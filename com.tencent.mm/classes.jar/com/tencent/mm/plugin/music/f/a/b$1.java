package com.tencent.mm.plugin.music.f.a;

import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    y.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(this.mAT) });
    this.mAU.mAR.c(this.mAU.myu, this.mAT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b.1
 * JD-Core Version:    0.7.0.1
 */