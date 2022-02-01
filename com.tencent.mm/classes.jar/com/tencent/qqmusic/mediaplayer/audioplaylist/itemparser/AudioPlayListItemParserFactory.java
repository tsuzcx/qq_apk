package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioPlayListItemParserFactory
{
  public static AudioPlayListItemParser createParser(String paramString)
  {
    AppMethodBeat.i(76606);
    if ((!paramString.startsWith("http")) && (paramString.endsWith(".cue")))
    {
      paramString = new CueItemParser(paramString);
      AppMethodBeat.o(76606);
      return paramString;
    }
    AppMethodBeat.o(76606);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParserFactory
 * JD-Core Version:    0.7.0.1
 */