package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class Mp3SeekTable
  implements SeekTable
{
  private final Mp3FrameInfoParse.Mp3Info mInfo = new Mp3FrameInfoParse.Mp3Info();
  
  private static long timeToBytePositionInCbr(Mp3FrameInfoParse.Mp3Info paramMp3Info, long paramLong)
  {
    if ((paramMp3Info == null) || (paramMp3Info.bit_rate <= 0) || (paramLong < 0L)) {
      paramLong = -1L;
    }
    long l;
    do
    {
      return paramLong;
      l = paramMp3Info.bit_rate / 8 * paramLong;
      paramLong = l;
    } while (paramMp3Info.idv2Size <= 0);
    return l + paramMp3Info.idv2Size;
  }
  
  private static long timeToBytePositionInVBRIVbr(Mp3FrameInfoParse.Mp3Info paramMp3Info, long paramLong)
  {
    if ((paramMp3Info == null) || (paramMp3Info.toc_table == null) || (paramMp3Info.fileLengthInBytes <= 0L) || (paramMp3Info.firstFramePosition < 0L) || (paramMp3Info.duration <= 0L) || (paramLong < 0L)) {
      return -1L;
    }
    long l2 = paramMp3Info.fileLengthInBytes;
    long l1 = paramMp3Info.firstFramePosition;
    int i = paramMp3Info.entry_count;
    long[] arrayOfLong = paramMp3Info.toc_table;
    long l3 = paramMp3Info.duration;
    int j = (int)(paramLong * 1.0D / l3 * (i + 1));
    label104:
    long l4;
    if (j < 0)
    {
      if (j < i) {
        break label157;
      }
      l4 = j * l3 / (i + 1);
      l3 = l3 * (j + 1) / (i + 1);
      if (l2 != l1) {
        break label169;
      }
    }
    label157:
    label169:
    for (paramLong = 0L;; paramLong = ((l2 - l1) * 1.0D * (paramLong - l4) / (l3 - l4)))
    {
      return paramLong + l1;
      l1 = arrayOfLong[j];
      break;
      l2 = arrayOfLong[(j + 1)];
      break label104;
    }
  }
  
  private static long timeToBytePositionInXingVbr(Mp3FrameInfoParse.Mp3Info paramMp3Info, long paramLong)
  {
    if ((paramMp3Info == null) || (paramMp3Info.toc_table == null) || (paramMp3Info.fileLengthInBytes <= 0L) || (paramMp3Info.firstFramePosition < 0L) || (paramMp3Info.duration < 0L) || (paramLong < 0L))
    {
      l1 = -1L;
      return l1;
    }
    long l1 = paramMp3Info.fileLengthInBytes;
    long l3 = paramMp3Info.firstFramePosition;
    long[] arrayOfLong = paramMp3Info.toc_table;
    long l2 = paramMp3Info.duration;
    double d1 = paramLong * 100.0D / l2;
    if (d1 <= 0.0D) {}
    for (d1 = 0.0D;; d1 = 256.0D)
    {
      l2 = Math.round(d1 * 0.00390625D * l1) + l3;
      l1 = l1 + l3 - 1L;
      paramLong = l1;
      if (paramMp3Info.idv2Size > 0) {
        paramLong = l1 - paramMp3Info.idv2Size;
      }
      l1 = l2;
      if (l2 < paramLong) {
        break;
      }
      return paramLong;
      if (d1 < 100.0D) {
        break label168;
      }
    }
    label168:
    int i = (int)d1;
    float f1;
    if (i == 0)
    {
      f1 = 0.0F;
      label180:
      if (i >= 99) {
        break label232;
      }
    }
    label232:
    for (float f2 = (float)arrayOfLong[(i + 1)];; f2 = 256.0F)
    {
      double d2 = f1;
      d1 = (f2 - f1) * (d1 - i) + d2;
      break;
      f1 = (float)arrayOfLong[i];
      break label180;
    }
  }
  
  public void parse(IDataSource paramIDataSource)
  {
    Mp3FrameInfoParse.parseFrameInfo(new TrackPositionDataSource(paramIDataSource), this.mInfo);
  }
  
  public long seek(long paramLong)
  {
    if (paramLong < 0L) {
      return -1L;
    }
    switch (this.mInfo.VBRType)
    {
    default: 
      return -1L;
    case 0: 
      return timeToBytePositionInCbr(this.mInfo, paramLong);
    case 2: 
      return timeToBytePositionInXingVbr(this.mInfo, paramLong);
    }
    return timeToBytePositionInVBRIVbr(this.mInfo, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3SeekTable
 * JD-Core Version:    0.7.0.1
 */