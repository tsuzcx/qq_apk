package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CacheBytesManager$SingletonHolder
{
  private static final CacheBytesManager INSTANCE;
  
  static
  {
    AppMethodBeat.i(128393);
    INSTANCE = new CacheBytesManager(262144, null);
    AppMethodBeat.o(128393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CacheBytesManager.SingletonHolder
 * JD-Core Version:    0.7.0.1
 */