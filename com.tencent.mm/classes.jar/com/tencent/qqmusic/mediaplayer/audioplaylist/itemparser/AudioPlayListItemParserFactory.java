package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

public class AudioPlayListItemParserFactory
{
  public static AudioPlayListItemParser createParser(String paramString)
  {
    if ((!paramString.startsWith("http")) && (paramString.endsWith(".cue"))) {
      return new CueItemParser(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParserFactory
 * JD-Core Version:    0.7.0.1
 */