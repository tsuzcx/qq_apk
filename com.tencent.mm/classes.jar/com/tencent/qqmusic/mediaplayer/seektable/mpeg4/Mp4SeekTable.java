package com.tencent.qqmusic.mediaplayer.seektable.mpeg4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Co64;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.GhostBox;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Mdhd;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stco;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsc;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsz;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stts;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Mp4SeekTable
  implements SeekTable
{
  private final Map<String, IMpeg4Box> essentialStblChunkMap;
  private final Mdhd mdhd;
  
  public Mp4SeekTable()
  {
    AppMethodBeat.i(114249);
    this.essentialStblChunkMap = new HashMap();
    this.essentialStblChunkMap.put("stco", new Stco());
    this.essentialStblChunkMap.put("co64", new Co64());
    this.essentialStblChunkMap.put("stts", new Stts());
    this.essentialStblChunkMap.put("stsc", new Stsc());
    this.essentialStblChunkMap.put("stsz", new Stsz());
    this.mdhd = new Mdhd();
    AppMethodBeat.o(114249);
  }
  
  private static void chunkOfSample(Stsc paramStsc, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114253);
    int i3 = paramStsc.getEntryCount();
    int m = 0;
    int j = 1;
    int i = 0;
    int i2;
    for (int i1 = 0;; i1 = i2)
    {
      int n = paramStsc.getFirstChunk()[i1];
      int i4 = (n - j) * m;
      int k;
      if (paramInt < i + i4)
      {
        n = 1;
        k = m;
        if (k == 0) {
          break label167;
        }
        if (n == 0) {
          break label161;
        }
        paramInt = (paramInt - i) / k + j;
      }
      for (;;)
      {
        paramArrayOfInt[0] = paramInt;
        paramArrayOfInt[1] = ((paramInt - j) * k + i);
        AppMethodBeat.o(114253);
        return;
        m = paramStsc.getSamplesPerChunk()[i1];
        k = i;
        i2 = i1;
        if (i1 < i3)
        {
          i2 = i1 + 1;
          k = i + i4;
        }
        if (i2 < i3) {
          break label172;
        }
        i1 = 0;
        j = n;
        i = k;
        n = i1;
        k = m;
        break;
        label161:
        paramInt = j;
        continue;
        label167:
        paramInt = 1;
      }
      label172:
      j = n;
      i = k;
    }
  }
  
  private static boolean needMoreChunks(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114260);
    if (paramHashSet.size() > 2)
    {
      AppMethodBeat.o(114260);
      return true;
    }
    if ((paramHashSet.contains("stco")) && (paramHashSet.contains("co64")))
    {
      AppMethodBeat.o(114260);
      return true;
    }
    AppMethodBeat.o(114260);
    return false;
  }
  
  private static long offset64OfChunk(Co64 paramCo64, int paramInt)
  {
    AppMethodBeat.i(114255);
    long l;
    if (paramInt > paramCo64.getEntryCount())
    {
      l = paramCo64.getChunkOffset()[(paramCo64.getEntryCount() - 1)];
      AppMethodBeat.o(114255);
      return l;
    }
    if (paramCo64.getEntryCount() > 0)
    {
      l = paramCo64.getChunkOffset()[(paramInt - 1)];
      AppMethodBeat.o(114255);
      return l;
    }
    AppMethodBeat.o(114255);
    return 8L;
  }
  
  private static int offsetOfChunk(Stco paramStco, int paramInt)
  {
    AppMethodBeat.i(114254);
    if (paramInt > paramStco.getEntryCount())
    {
      paramInt = paramStco.getChunkOffset()[(paramStco.getEntryCount() - 1)];
      AppMethodBeat.o(114254);
      return paramInt;
    }
    if (paramStco.getEntryCount() > 0)
    {
      paramInt = paramStco.getChunkOffset()[(paramInt - 1)];
      AppMethodBeat.o(114254);
      return paramInt;
    }
    AppMethodBeat.o(114254);
    return 8;
  }
  
  private static int offsetOfSampleInChunk(Stsz paramStsz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114256);
    if (paramStsz.getSampleSize() != 0)
    {
      i = paramStsz.getSampleSize();
      AppMethodBeat.o(114256);
      return (paramInt1 - paramInt2) * i;
    }
    int i = 0;
    int j = Math.min(paramInt1, paramStsz.getSampleCount());
    paramInt1 = i;
    while (paramInt2 < j)
    {
      paramInt1 += paramStsz.getEntrySize()[paramInt2];
      paramInt2 += 1;
    }
    AppMethodBeat.o(114256);
    return paramInt1;
  }
  
  private static void parseChunks(Parsable paramParsable, Map<String, IMpeg4Box> paramMap, Function1<HashSet<String>, Boolean> paramFunction1)
  {
    AppMethodBeat.i(114259);
    GhostBox localGhostBox = new GhostBox();
    HashSet localHashSet = new HashSet(paramMap.keySet());
    while (((paramFunction1 == null) || (((Boolean)paramFunction1.call(localHashSet)).booleanValue())) && (localHashSet.size() != 0) && (paramParsable.available() > 0L))
    {
      localGhostBox.parse(paramParsable, null);
      String str = localGhostBox.getType();
      IMpeg4Box localIMpeg4Box = (IMpeg4Box)paramMap.get(str);
      if (localIMpeg4Box == null)
      {
        paramParsable.skip(localGhostBox.getSize() - 8L);
      }
      else
      {
        localIMpeg4Box.parse(paramParsable, localGhostBox);
        localHashSet.remove(str);
      }
    }
    if ((paramFunction1 != null) && (((Boolean)paramFunction1.call(localHashSet)).booleanValue()))
    {
      paramParsable = new InvalidBoxException("invalid box: critical box not found!");
      AppMethodBeat.o(114259);
      throw paramParsable;
    }
    AppMethodBeat.o(114259);
  }
  
  private static int sampleOfTime(Stts paramStts, int paramInt)
  {
    int n = 0;
    AppMethodBeat.i(114257);
    int i1 = paramStts.getEntryCount();
    int j = 0;
    int i = 0;
    int m = 0;
    int k = paramInt;
    paramInt = m;
    for (;;)
    {
      m = n;
      int i2;
      if (j < i1)
      {
        paramInt = paramStts.getSampleDelta()[j];
        m = paramStts.getSampleCount()[j];
        i2 = m * paramInt;
        if (k < i2) {
          m = 1;
        }
      }
      else
      {
        if (m == 0) {
          break;
        }
        paramInt = k / paramInt;
        AppMethodBeat.o(114257);
        return i + paramInt;
      }
      k -= i2;
      i += m;
      j += 1;
    }
    AppMethodBeat.o(114257);
    return i;
  }
  
  private long seekInternal(int paramInt)
  {
    AppMethodBeat.i(114252);
    Object localObject = new int[2];
    paramInt = sampleOfTime((Stts)this.essentialStblChunkMap.get("stts"), paramInt);
    chunkOfSample((Stsc)this.essentialStblChunkMap.get("stsc"), paramInt, (int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    if (((IMpeg4Box)this.essentialStblChunkMap.get("stco")).getSize() != 0L) {}
    for (long l1 = offsetOfChunk((Stco)this.essentialStblChunkMap.get("stco"), i);; l1 = offset64OfChunk((Co64)this.essentialStblChunkMap.get("co64"), i))
    {
      long l2 = offsetOfSampleInChunk((Stsz)this.essentialStblChunkMap.get("stsz"), paramInt, j);
      AppMethodBeat.o(114252);
      return l2 + l1;
      if (((IMpeg4Box)this.essentialStblChunkMap.get("co64")).getSize() == 0L) {
        break;
      }
    }
    localObject = new RuntimeException("invalid stbl: both [stco] nor [co64] was found!");
    AppMethodBeat.o(114252);
    throw ((Throwable)localObject);
  }
  
  private static IMpeg4Box seekTo(Parsable paramParsable, String paramString)
  {
    AppMethodBeat.i(114258);
    GhostBox localGhostBox = new GhostBox();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ".");
    paramString = null;
    for (;;)
    {
      if (!localStringTokenizer.hasMoreTokens()) {
        break label110;
      }
      String str = localStringTokenizer.nextToken();
      int i = 0;
      while ((i == 0) && (paramParsable.available() > 0L))
      {
        localGhostBox.parse(paramParsable, null);
        if (str.equalsIgnoreCase(localGhostBox.getType())) {
          break label95;
        }
        paramParsable.skip(localGhostBox.getSize() - 8L);
      }
      continue;
      label95:
      i = 1;
      if (localStringTokenizer.hasMoreTokens()) {
        break;
      }
      paramString = localGhostBox;
    }
    label110:
    AppMethodBeat.o(114258);
    return paramString;
  }
  
  public void parse(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(114250);
    paramIDataSource = new ParsableInputStreamWrapper(paramIDataSource);
    if (seekTo(paramIDataSource, "moov.trak.mdia") == null)
    {
      paramIDataSource = new InvalidBoxException("invalid mp4: no [mdia] was found!");
      AppMethodBeat.o(114250);
      throw paramIDataSource;
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("mdhd", this.mdhd);
    localHashMap.put("minf", new GhostBox());
    parseChunks(paramIDataSource, localHashMap, null);
    if (seekTo(paramIDataSource, "stbl") == null)
    {
      paramIDataSource = new InvalidBoxException("invalid mp4: no [stbl] was found!");
      AppMethodBeat.o(114250);
      throw paramIDataSource;
    }
    parseChunks(paramIDataSource, this.essentialStblChunkMap, new Function1()
    {
      public Boolean call(HashSet<String> paramAnonymousHashSet)
      {
        AppMethodBeat.i(114269);
        boolean bool = Mp4SeekTable.access$000(paramAnonymousHashSet);
        AppMethodBeat.o(114269);
        return Boolean.valueOf(bool);
      }
    });
    AppMethodBeat.o(114250);
  }
  
  public long seek(long paramLong)
  {
    AppMethodBeat.i(114251);
    paramLong = seekInternal((int)Math.round(this.mdhd.getTimeScale() * paramLong / 1000.0D));
    AppMethodBeat.o(114251);
    return paramLong;
  }
  
  static abstract interface Function1<T, R>
  {
    public abstract R call(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable
 * JD-Core Version:    0.7.0.1
 */