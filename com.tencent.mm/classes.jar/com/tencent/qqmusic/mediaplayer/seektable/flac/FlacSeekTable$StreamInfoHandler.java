package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

class FlacSeekTable$StreamInfoHandler
  implements FlacSeekTable.BlockHandler
{
  FlacSeekTable$StreamInfoHandler(FlacSeekTable paramFlacSeekTable) {}
  
  public boolean handle(Parsable paramParsable, int paramInt)
  {
    if (paramInt != 0) {
      return false;
    }
    paramParsable.skip(13L);
    paramParsable.readBytes(new byte[3], 0, 3);
    paramParsable.skip(21L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable.StreamInfoHandler
 * JD-Core Version:    0.7.0.1
 */