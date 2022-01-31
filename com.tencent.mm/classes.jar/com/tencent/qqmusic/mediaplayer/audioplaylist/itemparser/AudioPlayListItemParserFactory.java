package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioPlayListItemParserFactory
{
  public static AudioPlayListItemParser createParser(String paramString)
  {
    AppMethodBeat.i(104771);
    if ((!paramString.startsWith("http")) && (paramString.endsWith(".cue")))
    {
      paramString = new CueItemParser(paramString);
      AppMethodBeat.o(104771);
      return paramString;
    }
    AppMethodBeat.o(104771);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParserFactory
 * JD-Core Version:    0.7.0.1
 */