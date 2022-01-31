package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.y;

final class a$10
  implements c.b
{
  a$10(a parama) {}
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    if (this.mpw.mlw == null) {
      return;
    }
    int i = this.mpw.mpf;
    this.mpw.mpg = Math.round(i * paramFloat1);
    this.mpw.mph = Math.round(i * paramFloat2);
    y.i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", new Object[] { Integer.valueOf(this.mpw.mpg), Integer.valueOf(this.mpw.mph), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.mpw.mlw.d(this.mpw.mpg, true);
  }
  
  public final void U(float paramFloat1, float paramFloat2)
  {
    if (this.mpw.mlw == null) {
      return;
    }
    int i = this.mpw.mpf;
    this.mpw.mpg = Math.round(i * paramFloat1);
    this.mpw.mph = Math.round(i * paramFloat2);
    this.mpw.mlw.d(this.mpw.mpg, true);
    y.i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", new Object[] { Integer.valueOf(this.mpw.mpg), Integer.valueOf(this.mpw.mph), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
  }
  
  public final void V(float paramFloat1, float paramFloat2) {}
  
  public final void bjM()
  {
    if (this.mpw.mlw == null) {
      return;
    }
    this.mpw.mlw.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.10
 * JD-Core Version:    0.7.0.1
 */