package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public abstract interface IMpeg4Box
{
  public abstract long getSize();
  
  public abstract String getType();
  
  public abstract void parse(Parsable paramParsable, Box paramBox);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box
 * JD-Core Version:    0.7.0.1
 */