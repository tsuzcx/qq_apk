package com.tencent.qqmusic.mediaplayer.seektable.mpeg4;

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
  private final Map<String, IMpeg4Box> essentialStblChunkMap = new HashMap();
  private final Mdhd mdhd;
  
  public Mp4SeekTable()
  {
    this.essentialStblChunkMap.put("stco", new Stco());
    this.essentialStblChunkMap.put("co64", new Co64());
    this.essentialStblChunkMap.put("stts", new Stts());
    this.essentialStblChunkMap.put("stsc", new Stsc());
    this.essentialStblChunkMap.put("stsz", new Stsz());
    this.mdhd = new Mdhd();
  }
  
  private static void chunkOfSample(Stsc paramStsc, int paramInt, int[] paramArrayOfInt)
  {
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
          break label157;
        }
        if (n == 0) {
          break label151;
        }
        paramInt = (paramInt - i) / k + j;
      }
      for (;;)
      {
        paramArrayOfInt[0] = paramInt;
        paramArrayOfInt[1] = ((paramInt - j) * k + i);
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
          break label162;
        }
        i1 = 0;
        j = n;
        i = k;
        n = i1;
        k = m;
        break;
        label151:
        paramInt = j;
        continue;
        label157:
        paramInt = 1;
      }
      label162:
      j = n;
      i = k;
    }
  }
  
  private static boolean needMoreChunks(HashSet<String> paramHashSet)
  {
    if (paramHashSet.size() > 2) {}
    while ((paramHashSet.contains("stco")) && (paramHashSet.contains("co64"))) {
      return true;
    }
    return false;
  }
  
  private static long offset64OfChunk(Co64 paramCo64, int paramInt)
  {
    if (paramInt > paramCo64.getEntryCount()) {
      return paramCo64.getChunkOffset()[(paramCo64.getEntryCount() - 1)];
    }
    if (paramCo64.getEntryCount() > 0) {
      return paramCo64.getChunkOffset()[(paramInt - 1)];
    }
    return 8L;
  }
  
  private static int offsetOfChunk(Stco paramStco, int paramInt)
  {
    if (paramInt > paramStco.getEntryCount()) {
      return paramStco.getChunkOffset()[(paramStco.getEntryCount() - 1)];
    }
    if (paramStco.getEntryCount() > 0) {
      return paramStco.getChunkOffset()[(paramInt - 1)];
    }
    return 8;
  }
  
  private static int offsetOfSampleInChunk(Stsz paramStsz, int paramInt1, int paramInt2)
  {
    if (paramStsz.getSampleSize() != 0)
    {
      i = (paramInt1 - paramInt2) * paramStsz.getSampleSize();
      return i;
    }
    int i = 0;
    int j = Math.min(paramInt1, paramStsz.getSampleCount());
    paramInt1 = i;
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 >= j) {
        break;
      }
      paramInt1 += paramStsz.getEntrySize()[paramInt2];
      paramInt2 += 1;
    }
  }
  
  private static void parseChunks(Parsable paramParsable, Map<String, IMpeg4Box> paramMap, Mp4SeekTable.Function1<HashSet<String>, Boolean> paramFunction1)
  {
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
    if ((paramFunction1 != null) && (((Boolean)paramFunction1.call(localHashSet)).booleanValue())) {
      throw new InvalidBoxException("invalid box: critical box not found!");
    }
  }
  
  private static int sampleOfTime(Stts paramStts, int paramInt)
  {
    int n = 0;
    int i1 = paramStts.getEntryCount();
    int k = 0;
    int m = 0;
    int i = 0;
    int j = paramInt;
    paramInt = m;
    for (;;)
    {
      m = n;
      int i2;
      if (k < i1)
      {
        i = paramStts.getSampleDelta()[k];
        m = paramStts.getSampleCount()[k];
        i2 = m * i;
        if (j < i2) {
          m = 1;
        }
      }
      else
      {
        k = paramInt;
        if (m != 0) {
          k = paramInt + j / i;
        }
        return k;
      }
      j -= i2;
      paramInt += m;
      k += 1;
    }
  }
  
  private long seekInternal(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    paramInt = sampleOfTime((Stts)this.essentialStblChunkMap.get("stts"), paramInt);
    chunkOfSample((Stsc)this.essentialStblChunkMap.get("stsc"), paramInt, arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if (((IMpeg4Box)this.essentialStblChunkMap.get("stco")).getSize() != 0L) {}
    for (long l = offsetOfChunk((Stco)this.essentialStblChunkMap.get("stco"), i);; l = offset64OfChunk((Co64)this.essentialStblChunkMap.get("co64"), i))
    {
      return offsetOfSampleInChunk((Stsz)this.essentialStblChunkMap.get("stsz"), paramInt, j) + l;
      if (((IMpeg4Box)this.essentialStblChunkMap.get("co64")).getSize() == 0L) {
        break;
      }
    }
    throw new RuntimeException("invalid stbl: both [stco] nor [co64] was found!");
  }
  
  private static IMpeg4Box seekTo(Parsable paramParsable, String paramString)
  {
    GhostBox localGhostBox = new GhostBox();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ".");
    paramString = null;
    for (;;)
    {
      if (!localStringTokenizer.hasMoreTokens()) {
        return paramString;
      }
      String str = localStringTokenizer.nextToken();
      int i = 0;
      while ((i == 0) && (paramParsable.available() > 0L))
      {
        localGhostBox.parse(paramParsable, null);
        if (str.equalsIgnoreCase(localGhostBox.getType())) {
          break label90;
        }
        paramParsable.skip(localGhostBox.getSize() - 8L);
      }
      continue;
      label90:
      i = 1;
      if (localStringTokenizer.hasMoreTokens()) {
        break;
      }
      paramString = localGhostBox;
    }
    return paramString;
  }
  
  public void parse(IDataSource paramIDataSource)
  {
    paramIDataSource = new ParsableInputStreamWrapper(paramIDataSource);
    if (seekTo(paramIDataSource, "moov.trak.mdia") == null) {
      throw new InvalidBoxException("invalid mp4: no [mdia] was found!");
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("mdhd", this.mdhd);
    localHashMap.put("minf", new GhostBox());
    parseChunks(paramIDataSource, localHashMap, null);
    if (seekTo(paramIDataSource, "stbl") == null) {
      throw new InvalidBoxException("invalid mp4: no [stbl] was found!");
    }
    parseChunks(paramIDataSource, this.essentialStblChunkMap, new Mp4SeekTable.Function1()
    {
      public Boolean call(HashSet<String> paramAnonymousHashSet)
      {
        return Boolean.valueOf(Mp4SeekTable.needMoreChunks(paramAnonymousHashSet));
      }
    });
  }
  
  public long seek(long paramLong)
  {
    return seekInternal((int)Math.round(this.mdhd.getTimeScale() * paramLong / 1000.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable
 * JD-Core Version:    0.7.0.1
 */