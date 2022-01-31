package com.tencent.mm.plugin.music.f.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;

public class a
{
  private static c mAP = new a.a((byte)0);
  
  public static void a(c paramc)
  {
    mAP = paramc;
  }
  
  public static void bnK()
  {
    y.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new a.2());
    AudioPlayerConfigure.enableNativeLog(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a
 * JD-Core Version:    0.7.0.1
 */