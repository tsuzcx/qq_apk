package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class NativeLog
{
  private static final String TAG = "NativeLog";
  
  static
  {
    if (NativeLibs.audioCommon.load()) {
      Logger.i("NativeLog", "[static initializer] NativeLog load succeed.");
    }
  }
  
  static native int init(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NativeLog
 * JD-Core Version:    0.7.0.1
 */