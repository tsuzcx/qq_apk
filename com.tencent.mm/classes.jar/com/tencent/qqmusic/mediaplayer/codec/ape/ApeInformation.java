package com.tencent.qqmusic.mediaplayer.codec.ape;

import com.tencent.qqmusic.mediaplayer.AudioInformation;

public class ApeInformation
  extends AudioInformation
{
  private String album;
  private int apeFileVersion;
  private String artist;
  private long blocks;
  private int compressionLevel;
  private int frames;
  private String title;
  private String writer;
  
  public String getAlbum()
  {
    return this.album;
  }
  
  public String getArtist()
  {
    return this.artist;
  }
  
  public long getBlocks()
  {
    return this.blocks;
  }
  
  public int getCompressionLevel()
  {
    return this.compressionLevel;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getWriter()
  {
    return this.writer;
  }
  
  public void setAlbum(String paramString)
  {
    this.album = paramString;
  }
  
  public void setArtist(String paramString)
  {
    this.artist = paramString;
  }
  
  public void setBlocks(long paramLong)
  {
    this.blocks = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setWriter(String paramString)
  {
    this.writer = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ape.ApeInformation
 * JD-Core Version:    0.7.0.1
 */