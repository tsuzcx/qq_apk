package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.qqmusic.mediaplayer.AudioInformation;

public class MP3Information
  extends AudioInformation
{
  private int bitratemode;
  private int encoding;
  private String error;
  private long fileLengthInBytes;
  private long firstFramePos;
  private long firstFrameSize;
  private long id3v2Size;
  private int layer;
  private long[] mTocTable;
  private int mpeg_version;
  private boolean success = false;
  
  public int getBitratemode()
  {
    return this.bitratemode;
  }
  
  public int getEncoding()
  {
    return this.encoding;
  }
  
  public String getError()
  {
    return this.error;
  }
  
  public long getFileLengthInBytes()
  {
    return this.fileLengthInBytes;
  }
  
  public long getFirstFramePos()
  {
    return this.firstFramePos;
  }
  
  public long getFirstFrameSize()
  {
    return this.firstFrameSize;
  }
  
  public long getId3v2Size()
  {
    return this.id3v2Size;
  }
  
  public int getLayer()
  {
    return this.layer;
  }
  
  public int getMpeg_version()
  {
    return this.mpeg_version;
  }
  
  public long[] getTocTable()
  {
    return this.mTocTable;
  }
  
  public boolean isSuccess()
  {
    return this.success;
  }
  
  public void setBitratemode(int paramInt)
  {
    this.bitratemode = paramInt;
  }
  
  public void setEncoding(int paramInt)
  {
    this.encoding = paramInt;
  }
  
  public void setError(String paramString)
  {
    this.error = paramString;
  }
  
  public void setSuccess(boolean paramBoolean)
  {
    this.success = paramBoolean;
  }
  
  public void setTocTable(long[] paramArrayOfLong)
  {
    this.mTocTable = paramArrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Information
 * JD-Core Version:    0.7.0.1
 */