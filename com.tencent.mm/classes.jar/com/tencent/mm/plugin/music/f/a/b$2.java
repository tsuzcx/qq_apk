package com.tencent.mm.plugin.music.f.a;

import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    y.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(this.mAU.isPlaying()) });
    this.mAU.mAR.k(this.mAU.myu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b.2
 * JD-Core Version:    0.7.0.1
 */