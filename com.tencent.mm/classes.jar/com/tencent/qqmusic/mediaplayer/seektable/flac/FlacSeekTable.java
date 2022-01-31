package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.Arrays;
import java.util.HashSet;

public class FlacSeekTable
  implements SeekTable
{
  private static final int SEEK_POINT_SIZE = 18;
  private static final byte TYPE_SEEKTABLE = 3;
  private static final byte TYPE_STREAMINFO = 0;
  private long firstFrameOffset;
  private long[] offsets;
  private long[] sampleNumbers;
  private int sampleRate = 0;
  
  public FlacSeekTable(int paramInt)
  {
    this.sampleRate = paramInt;
  }
  
  private static int binarySearchFloor(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(128527);
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i;
    if (j < 0) {
      i = -(j + 2);
    }
    while (paramBoolean2)
    {
      i = Math.max(0, i);
      AppMethodBeat.o(128527);
      return i;
      i = j;
      if (!paramBoolean1) {
        i = j - 1;
      }
    }
    AppMethodBeat.o(128527);
    return i;
  }
  
  private static boolean seekToFirstFrame(Parsable paramParsable)
  {
    boolean bool2 = false;
    AppMethodBeat.i(128526);
    byte[] arrayOfByte1 = new byte[1];
    byte[] arrayOfByte2 = new byte[3];
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramParsable.available() > 0L)
      {
        if (i == 0) {
          break label93;
        }
        arrayOfByte1 = new byte[2];
        paramParsable.readBytes(arrayOfByte1, 0, 2);
        bool1 = bool2;
        if ((arrayOfByte1[0] & 0xFF) == 255)
        {
          bool1 = bool2;
          if ((arrayOfByte1[1] & 0xFF) >> 2 == 62) {
            bool1 = true;
          }
        }
      }
      AppMethodBeat.o(128526);
      return bool1;
      label93:
      paramParsable.readBytes(arrayOfByte1, 0, 1);
      if ((arrayOfByte1[0] & 0xFF) >> 7 == 1) {
        i = 1;
      }
      paramParsable.readBytes(arrayOfByte2, 0, 3);
      paramParsable.skip(BytesUtil.from(arrayOfByte2));
    }
  }
  
  private static boolean seekToFlac(Parsable paramParsable)
  {
    AppMethodBeat.i(128524);
    byte[] arrayOfByte = new byte[4];
    paramParsable.readBytes(arrayOfByte, 0, 4);
    if ((arrayOfByte[0] == 73) && (arrayOfByte[1] == 68) && (arrayOfByte[2] == 51))
    {
      paramParsable.skip(2L);
      paramParsable.skip(Id3Util.unsynchsafe(paramParsable.readInt()));
      paramParsable.readBytes(arrayOfByte, 0, 4);
    }
    if ((arrayOfByte[0] == 102) && (arrayOfByte[1] == 76) && (arrayOfByte[2] == 97) && (arrayOfByte[3] == 67))
    {
      AppMethodBeat.o(128524);
      return true;
    }
    AppMethodBeat.o(128524);
    return false;
  }
  
  private static boolean walkThrough(Parsable paramParsable, FlacSeekTable.BlockHandler... paramVarArgs)
  {
    AppMethodBeat.i(128525);
    byte[] arrayOfByte1 = new byte[1];
    byte[] arrayOfByte2 = new byte[3];
    HashSet localHashSet = new HashSet();
    if ((localHashSet.size() < paramVarArgs.length) && (paramParsable.available() > 0L))
    {
      paramParsable.readBytes(arrayOfByte1, 0, 1);
      int j = arrayOfByte1[0];
      int k = paramVarArgs.length;
      int i = 0;
      boolean bool = false;
      for (;;)
      {
        if (i < k)
        {
          FlacSeekTable.BlockHandler localBlockHandler = paramVarArgs[i];
          bool = localBlockHandler.handle(paramParsable, j & 0x7F);
          if (bool) {
            localHashSet.add(Integer.valueOf(localBlockHandler.hashCode()));
          }
        }
        else
        {
          if (bool) {
            break;
          }
          if ((arrayOfByte1[0] & 0xFF) >> 7 == 1) {
            break label166;
          }
          paramParsable.readBytes(arrayOfByte2, 0, 3);
          paramParsable.skip(BytesUtil.from(arrayOfByte2));
          break;
        }
        i += 1;
      }
    }
    label166:
    if (localHashSet.size() == paramVarArgs.length)
    {
      AppMethodBeat.o(128525);
      return true;
    }
    AppMethodBeat.o(128525);
    return false;
  }
  
  public long[] getOffsetRangeOfSample(int paramInt)
  {
    AppMethodBeat.i(128521);
    paramInt = binarySearchFloor(this.sampleNumbers, paramInt, true, true);
    if (paramInt + 1 >= this.offsets.length)
    {
      l1 = this.firstFrameOffset;
      l2 = this.offsets[paramInt];
      AppMethodBeat.o(128521);
      return new long[] { l1 + l2, -1L };
    }
    long l1 = this.firstFrameOffset;
    long l2 = this.offsets[paramInt];
    long l3 = this.firstFrameOffset;
    long l4 = this.offsets[(paramInt + 1)];
    AppMethodBeat.o(128521);
    return new long[] { l1 + l2, l3 + l4 };
  }
  
  public void parse(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(128522);
    ParsableInputStreamWrapper localParsableInputStreamWrapper = new ParsableInputStreamWrapper(paramIDataSource);
    if (!seekToFlac(localParsableInputStreamWrapper))
    {
      AppMethodBeat.o(128522);
      return;
    }
    if (this.sampleRate == 0)
    {
      paramIDataSource = new FlacSeekTable.BlockHandler[2];
      paramIDataSource[0] = new FlacSeekTable.SeektableHandler(this);
      paramIDataSource[1] = new FlacSeekTable.StreamInfoHandler(this);
    }
    while (!walkThrough(localParsableInputStreamWrapper, paramIDataSource))
    {
      paramIDataSource = new InvalidBoxException("lack one or more critical BLOCK(s) to create seek table!");
      AppMethodBeat.o(128522);
      throw paramIDataSource;
      paramIDataSource = new FlacSeekTable.BlockHandler[1];
      paramIDataSource[0] = new FlacSeekTable.SeektableHandler(this);
    }
    AppMethodBeat.o(128522);
  }
  
  public long seek(long paramLong)
  {
    AppMethodBeat.i(128523);
    int i = (int)(Math.round(paramLong / 1000.0D) * this.sampleRate);
    i = binarySearchFloor(this.sampleNumbers, i, true, true);
    paramLong = this.firstFrameOffset;
    long l = this.offsets[i];
    AppMethodBeat.o(128523);
    return l + paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable
 * JD-Core Version:    0.7.0.1
 */