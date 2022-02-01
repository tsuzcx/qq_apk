package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecognizer
{
  public String getLanguage()
  {
    return null;
  }
  
  abstract String getName();
  
  abstract CharsetMatch match(CharsetDetector paramCharsetDetector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
 * JD-Core Version:    0.7.0.1
 */