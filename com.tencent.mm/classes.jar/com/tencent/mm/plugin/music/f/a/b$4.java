package com.tencent.mm.plugin.music.f.a;

import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements Runnable
{
  b$4(b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    y.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(this.mAV) });
    this.mAU.mAR.b(this.mAU.myu, this.mAV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b.4
 * JD-Core Version:    0.7.0.1
 */