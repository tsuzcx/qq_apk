package com.tencent.mm.plugin.music.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.b.d;
import com.tencent.mm.sdk.platformtools.y;

final class a$e
  implements e
{
  private a$e(a parama) {}
  
  public final void b(String paramString, long paramLong1, long paramLong2)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + this.myP.bmP() + ", " + paramString + "]");
  }
  
  public final void c(int paramInt, long paramLong1, long paramLong2)
  {
    a.a(this.myP, "audioTrackUnderrun [" + paramInt + ", " + paramLong1 + ", " + paramLong2 + "]", null);
  }
  
  public final void c(d paramd)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + this.myP.bmP() + "]");
  }
  
  public final void cC(int paramInt)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
  }
  
  public final void d(Format paramFormat)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + this.myP.bmP() + ", " + Format.a(paramFormat) + "]");
  }
  
  public final void d(d paramd)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + this.myP.bmP() + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.e
 * JD-Core Version:    0.7.0.1
 */