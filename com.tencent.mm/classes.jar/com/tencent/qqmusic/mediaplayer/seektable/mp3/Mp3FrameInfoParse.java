package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class Mp3FrameInfoParse
{
  private static final int[][][] BitrateTable;
  private static final int DECODE_ERROR_IO_READ = -3;
  private static final int DECODE_ERROR_MEMORY_ALLOC = -2;
  private static final int DECODE_ERROR_SUCCESS = 0;
  private static final int DECODE_FAIL = -1;
  private static final int[][] SAMPLE_PER_FRAME = { { 384, 1152, 1152 }, { 384, 1152, 576 }, { 384, 1152, 576 } };
  private static final int[][] SAMPLE_RATE_TABLE;
  private static final String TAG = "Mp3FrameInfoParse";
  public static final int VBR_TYPE_CBR = 0;
  public static final int VBR_TYPE_VBRI = 1;
  public static final int VBR_TYPE_XING = 2;
  
  static
  {
    int[] arrayOfInt1 = { 0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 };
    int[] arrayOfInt2 = { 0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 };
    int[] arrayOfInt3 = { 0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 };
    int[] arrayOfInt4 = { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 };
    int[] arrayOfInt5 = { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 };
    BitrateTable = new int[][][] { { { 0, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 }, arrayOfInt1, arrayOfInt2 }, { arrayOfInt3, arrayOfInt4, arrayOfInt5 } };
    SAMPLE_RATE_TABLE = new int[][] { { 11025, 12000, 8000 }, { 0, 0, 0 }, { 22050, 24000, 16000 }, { 44100, 48000, 32000 } };
  }
  
  private static boolean IsMp3Header(TrackPositionDataSource paramTrackPositionDataSource, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Mp3Info paramMp3Info)
  {
    AppMethodBeat.i(114233);
    if ((paramArrayOfByte == null) || (paramMp3Info == null))
    {
      AppMethodBeat.o(114233);
      return false;
    }
    int k = paramArrayOfByte[(paramInt2 + 1)] >> 3 & 0x3;
    if (1 == k)
    {
      AppMethodBeat.o(114233);
      return false;
    }
    int i = paramArrayOfByte[(paramInt2 + 1)] >> 1 & 0x3;
    if (i == 0)
    {
      AppMethodBeat.o(114233);
      return false;
    }
    int m = 4 - i;
    int n = paramArrayOfByte[(paramInt2 + 2)] >> 4 & 0xF;
    if (15 == n)
    {
      AppMethodBeat.o(114233);
      return false;
    }
    int i1 = paramArrayOfByte[(paramInt2 + 2)] >> 2 & 0x3;
    if (3 == i1)
    {
      AppMethodBeat.o(114233);
      return false;
    }
    int i2 = paramArrayOfByte[(paramInt2 + 3)];
    i = paramArrayOfByte[(paramInt2 + 2)] >> 1 & 0x1;
    int j;
    if (k == 3)
    {
      j = 0;
      if (1 != m) {
        break label234;
      }
      i = BitrateTable[j][0][n] * 12000 / SAMPLE_RATE_TABLE[k][i1] + i << 2;
    }
    for (;;)
    {
      if (i > 0)
      {
        long l = paramTrackPositionDataSource.getCurPosition();
        if (paramTrackPositionDataSource.seek(l - paramInt1 + paramInt2 + i) < 0L)
        {
          AppMethodBeat.o(114233);
          return false;
          j = 1;
          break;
          label234:
          if (2 == m)
          {
            i = BitrateTable[j][1][n] * 144000 / SAMPLE_RATE_TABLE[k][i1] + i;
            continue;
          }
          i = BitrateTable[j][2][n] * 144000 / (SAMPLE_RATE_TABLE[k][i1] << j) + i;
          continue;
        }
        byte[] arrayOfByte = new byte[4];
        if (paramTrackPositionDataSource.read(arrayOfByte, 4) == -1)
        {
          AppMethodBeat.o(114233);
          return false;
        }
        paramInt1 = Mp3DecodeBase.readInt(paramArrayOfByte, paramInt2, 4);
        paramInt2 = Mp3DecodeBase.readInt(arrayOfByte, 4);
        paramTrackPositionDataSource.seek(l);
        if ((paramInt1 == 0) || (paramInt2 == 0) || ((0xFFFE0C00 & paramInt1) != (paramInt2 & 0xFFFE0C00)))
        {
          AppMethodBeat.o(114233);
          return false;
        }
        Logger.i("Mp3FrameInfoParse", "FirstFrameSize = ".concat(String.valueOf(i)));
        paramMp3Info.firstFrameSize = i;
        paramInt1 = 0;
        if (k == 3)
        {
          paramInt1 = 0;
          paramMp3Info.mpeg_version = paramInt1;
          paramMp3Info.layer = m;
          paramMp3Info.sample_rate = SAMPLE_RATE_TABLE[k][i1];
          paramMp3Info.bit_rate = BitrateTable[j][(m - 1)][n];
          if ((i2 >> 6 & 0x3) != 3) {
            break label504;
          }
        }
        label504:
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          paramMp3Info.channels = paramInt1;
          AppMethodBeat.o(114233);
          return true;
          if (k == 2)
          {
            paramInt1 = 1;
            break;
          }
          if (k != 0) {
            break;
          }
          paramInt1 = 2;
          break;
        }
      }
    }
    paramMp3Info.firstFrameSize = -1L;
    AppMethodBeat.o(114233);
    return false;
  }
  
  public static int parseFrameInfo(TrackPositionDataSource paramTrackPositionDataSource, Mp3Info paramMp3Info)
  {
    AppMethodBeat.i(114231);
    if (paramTrackPositionDataSource == null)
    {
      AppMethodBeat.o(114231);
      return -1;
    }
    byte[] arrayOfByte = new byte[1024];
    if (paramTrackPositionDataSource.read(arrayOfByte, 1024) < 1024)
    {
      AppMethodBeat.o(114231);
      return -2;
    }
    if (Mp3DecodeBase.hasId3v2(arrayOfByte, 4))
    {
      Logger.i("Mp3FrameInfoParse", "hasId3v2");
      skipId3v2(paramTrackPositionDataSource, arrayOfByte, paramMp3Info);
    }
    int j;
    int i;
    for (;;)
    {
      j = 0;
      long l2 = paramTrackPositionDataSource.getSize();
      long l4 = paramMp3Info.idv2Size;
      long l1 = l2;
      i = j;
      if (l4 > 0L)
      {
        l1 = l2;
        i = j;
        if (l2 > l4)
        {
          l1 = l2 - l4;
          i = j;
        }
      }
      long l3 = paramTrackPositionDataSource.getCurPosition();
      l2 = l3;
      if (l4 > 0L) {
        l2 = l3 - l4;
      }
      if (l2 < l1 / 10L) {
        break;
      }
      AppMethodBeat.o(114231);
      return -3;
      paramTrackPositionDataSource.seek(0L);
    }
    if ((i < 3) || (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() - 3L) >= 0L))
    {
      int m = paramTrackPositionDataSource.read(arrayOfByte, 1024);
      if (m == -1)
      {
        paramMp3Info.firstFramePosition = -1L;
        AppMethodBeat.o(114231);
        return -3;
      }
      int k = i + m;
      j = 0;
      for (;;)
      {
        i = k;
        if (j + 4 > m) {
          break;
        }
        if ((255 == (arrayOfByte[j] & 0xFF)) && (224 == (arrayOfByte[(j + 1)] & 0xE0)) && (IsMp3Header(paramTrackPositionDataSource, arrayOfByte, 1024, j, paramMp3Info)))
        {
          paramMp3Info.firstFramePosition = (paramMp3Info.idv2Size + k - m + j);
          Logger.i("Mp3FrameInfoParse", "FirstFramePos = " + paramMp3Info.firstFramePosition);
          if (paramTrackPositionDataSource.seek(paramMp3Info.firstFramePosition) < 0L)
          {
            AppMethodBeat.o(114231);
            return -1;
          }
          boolean bool = parseVBRFrameInfo(paramTrackPositionDataSource, paramMp3Info);
          if ((paramTrackPositionDataSource.seek(0L) < 0L) || (!bool))
          {
            AppMethodBeat.o(114231);
            return -1;
          }
          AppMethodBeat.o(114231);
          return 0;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(114231);
    return -3;
  }
  
  private static boolean parseVBRFrameInfo(TrackPositionDataSource paramTrackPositionDataSource, Mp3Info paramMp3Info)
  {
    AppMethodBeat.i(114234);
    if ((paramTrackPositionDataSource == null) || (paramMp3Info == null))
    {
      AppMethodBeat.o(114234);
      return false;
    }
    long l2 = paramMp3Info.sample_rate;
    int i = paramMp3Info.channels;
    byte[] arrayOfByte = new byte[1024];
    long l1;
    if (paramMp3Info.mpeg_version == 0) {
      if (i != 1) {
        l1 = 36L;
      }
    }
    while (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() + l1) < 0L)
    {
      AppMethodBeat.o(114234);
      return false;
      l1 = 21L;
      continue;
      if (i != 1) {
        l1 = 21L;
      } else {
        l1 = 13L;
      }
    }
    if (paramTrackPositionDataSource.read(arrayOfByte, 1024) < 1024)
    {
      AppMethodBeat.o(114234);
      return false;
    }
    if (Mp3DecodeBase.isXingVBRheader(arrayOfByte, 4))
    {
      Logger.i("Mp3FrameInfoParse", "is Xing VBR");
      paramMp3Info.VBRType = 2;
      paramMp3Info.isVbr = 1;
      parseXingInfo(arrayOfByte, l2, paramMp3Info);
    }
    for (;;)
    {
      AppMethodBeat.o(114234);
      return true;
      if (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() - (l1 + 1024L)) < 0L)
      {
        AppMethodBeat.o(114234);
        return false;
      }
      if (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() + 36L) < 0L)
      {
        AppMethodBeat.o(114234);
        return false;
      }
      if (paramTrackPositionDataSource.read(arrayOfByte, 1024) < 1024)
      {
        AppMethodBeat.o(114234);
        return false;
      }
      if (Mp3DecodeBase.isVBRIVBRHeader(arrayOfByte, 4))
      {
        Logger.i("Mp3FrameInfoParse", "is VBRI VBR");
        paramMp3Info.VBRType = 1;
        paramMp3Info.isVbr = 1;
        parseVBRIInfo(paramMp3Info, arrayOfByte, l2);
      }
      else
      {
        Logger.i("Mp3FrameInfoParse", "is CBR");
        paramMp3Info.VBRType = 0;
        l1 = paramTrackPositionDataSource.getSize();
        if (paramMp3Info.fileLengthInBytes <= 0L) {
          paramMp3Info.fileLengthInBytes = l1;
        }
        paramMp3Info.duration = (((float)(paramMp3Info.fileLengthInBytes - paramMp3Info.idv2Size) * 8.0F / paramMp3Info.bit_rate));
      }
    }
  }
  
  private static void parseVBRIInfo(Mp3Info paramMp3Info, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(114236);
    if ((paramArrayOfByte == null) || (paramMp3Info == null))
    {
      AppMethodBeat.o(114236);
      return;
    }
    long l1 = Mp3DecodeBase.readLong(paramArrayOfByte, 10, 4);
    paramMp3Info.fileLengthInBytes = l1;
    long l2 = Mp3DecodeBase.readLong(paramArrayOfByte, 14, 4);
    int i;
    int j;
    if ((l2 > 0L) && (paramLong > 0L))
    {
      i = paramMp3Info.mpeg_version;
      j = paramMp3Info.layer;
      paramMp3Info.lengthInFrames = l2;
      paramMp3Info.duration = ((l2 * SAMPLE_PER_FRAME[i][(j - 1)] * 1.0D / paramLong * 1000.0D));
    }
    int i1 = Mp3DecodeBase.readShort(paramArrayOfByte, 18, 2);
    int i2 = Mp3DecodeBase.readShort(paramArrayOfByte, 20, 2);
    int i3 = Mp3DecodeBase.readShort(paramArrayOfByte, 22, 2);
    int n = 24;
    if ((i1 > 0) && (i2 > 0))
    {
      int i4 = i1 + 1;
      long[] arrayOfLong1 = new long[i4];
      j = 0;
      if (paramMp3Info.firstFramePosition > 0L) {
        j = (int)(0L + paramMp3Info.firstFramePosition);
      }
      i = j;
      if (paramMp3Info.firstFrameSize > 0L) {
        i = (int)(j + paramMp3Info.firstFrameSize);
      }
      int k = 1;
      int m = i;
      i = n;
      long[] arrayOfLong2 = arrayOfLong1;
      if (k < i4)
      {
        j = -1;
        if (i3 == 1)
        {
          j = Mp3DecodeBase.readByte(paramArrayOfByte, i, 1);
          i += 1;
        }
        for (;;)
        {
          arrayOfLong2 = arrayOfLong1;
          if (j < 0) {
            break label384;
          }
          m = j * i2 + m;
          j = m;
          if (m >= l1) {
            j = (int)l1;
          }
          arrayOfLong1[k] = j;
          k += 1;
          m = j;
          break;
          if (i3 == 2)
          {
            j = Mp3DecodeBase.readShort(paramArrayOfByte, i, 2);
            i += 2;
          }
          else if (i3 == 3)
          {
            j = Mp3DecodeBase.readUnsignedInt24(paramArrayOfByte, i, 3);
            i += 3;
          }
          else if (i3 == 4)
          {
            j = Mp3DecodeBase.readInt(paramArrayOfByte, i, 4);
            i += 4;
          }
          else
          {
            arrayOfLong1 = null;
          }
        }
      }
      label384:
      paramMp3Info.entry_count = i1;
      paramMp3Info.entry_size = i3;
      paramMp3Info.scale_factor = i2;
      paramMp3Info.toc_table = arrayOfLong2;
    }
    AppMethodBeat.o(114236);
  }
  
  private static void parseXingInfo(byte[] paramArrayOfByte, long paramLong, Mp3Info paramMp3Info)
  {
    AppMethodBeat.i(114235);
    if ((paramArrayOfByte == null) || (paramMp3Info == null))
    {
      AppMethodBeat.o(114235);
      return;
    }
    Object localObject = null;
    int k = Mp3DecodeBase.readInt(paramArrayOfByte, 4, 4);
    int i = 8;
    int j;
    if ((k & 0x1) == 1)
    {
      long l = Mp3DecodeBase.readLong(paramArrayOfByte, 8, 4) - 1L;
      if ((l > 0L) && (paramLong > 0L))
      {
        i = paramMp3Info.mpeg_version;
        j = paramMp3Info.layer;
        paramMp3Info.lengthInFrames = l;
        paramMp3Info.duration = ((l * SAMPLE_PER_FRAME[i][(j - 1)] * 1.0D / paramLong * 1000.0D));
      }
      i = 12;
    }
    if ((k & 0x2) == 2)
    {
      paramMp3Info.fileLengthInBytes = Mp3DecodeBase.readLong(paramArrayOfByte, i, 4);
      i += 4;
    }
    for (;;)
    {
      if ((k & 0x4) == 4)
      {
        long[] arrayOfLong = new long[100];
        j = 0;
        for (;;)
        {
          localObject = arrayOfLong;
          if (j >= 100) {
            break;
          }
          arrayOfLong[j] = (paramArrayOfByte[(j + i)] & 0xFF);
          j += 1;
        }
      }
      if ((k > 0) && (localObject != null))
      {
        paramMp3Info.toc_table = localObject;
        paramMp3Info.flag_value = k;
      }
      AppMethodBeat.o(114235);
      return;
    }
  }
  
  private static void skipId3v2(TrackPositionDataSource paramTrackPositionDataSource, byte[] paramArrayOfByte, Mp3Info paramMp3Info)
  {
    AppMethodBeat.i(114232);
    if ((paramTrackPositionDataSource == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(114232);
      return;
    }
    if ((paramArrayOfByte[0] == 73) && (paramArrayOfByte[1] == 68) && (paramArrayOfByte[2] == 51))
    {
      int i = ((paramArrayOfByte[6] & 0x7F) << 21) + ((paramArrayOfByte[7] & 0x7F) << 14) + ((paramArrayOfByte[8] & 0x7F) << 7) + (paramArrayOfByte[9] & 0x7F);
      if ((paramArrayOfByte[5] & 0x10) != 0) {
        i += 20;
      }
      for (int k = 1; paramTrackPositionDataSource.seek(i) < 0L; k = 0)
      {
        AppMethodBeat.o(114232);
        return;
        i += 10;
      }
      int j = i;
      if (k == 0)
      {
        paramArrayOfByte = new byte[1];
        for (k = paramTrackPositionDataSource.read(paramArrayOfByte, 1);; k = paramTrackPositionDataSource.read(paramArrayOfByte, 1))
        {
          j = i;
          if (paramArrayOfByte[0] != 0) {
            break;
          }
          j = i;
          if (k != 1) {
            break;
          }
          i += 1;
        }
      }
      paramMp3Info.idv2Size = j;
      Logger.i("Mp3FrameInfoParse", "id3V2 Size: " + paramMp3Info.idv2Size);
      paramTrackPositionDataSource.seek(j);
    }
    AppMethodBeat.o(114232);
  }
  
  static class Mp3Info
  {
    int VBRType = 0;
    int bit_rate = 0;
    int channels = 0;
    long duration = 0L;
    int entry_count = 0;
    int entry_size = 0;
    long fileLengthInBytes = 0L;
    long firstFramePosition = 0L;
    long firstFrameSize = 0L;
    int flag_value = 0;
    int idv2Size = 0;
    int isVbr = 0;
    int layer = 0;
    long lengthInFrames = 0L;
    int mpeg_version = 0;
    long sample_rate = 0L;
    int scale_factor = 0;
    long[] toc_table = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3FrameInfoParse
 * JD-Core Version:    0.7.0.1
 */