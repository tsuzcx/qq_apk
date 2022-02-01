package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class NativeLog
{
  private static final String TAG = "NativeLog";
  
  static
  {
    AppMethodBeat.i(114398);
    if (NativeLibs.audioCommon.load()) {
      Logger.i("NativeLog", "[static initializer] NativeLog load succeed.");
    }
    AppMethodBeat.o(114398);
  }
  
  static native int init(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NativeLog
 * JD-Core Version:    0.7.0.1
 */