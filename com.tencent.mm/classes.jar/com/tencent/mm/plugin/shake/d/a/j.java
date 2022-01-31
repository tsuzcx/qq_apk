package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class j
  extends l.b
{
  public static boolean isInited = false;
  public static j oaX;
  private boolean bFk = false;
  private long hkx;
  public a oaW = new a();
  
  private j(l.a parama)
  {
    super(parama);
  }
  
  public static j a(l.a parama)
  {
    if ((oaX == null) || (oaX.nYU == null)) {
      oaX = new j(parama);
    }
    return oaX;
  }
  
  private void b(List<d> paramList, long paramLong)
  {
    if (this.nYU != null) {
      this.nYU.a(paramList, paramLong);
    }
  }
  
  public final void bzH()
  {
    this.oaW.uh();
    super.bzH();
  }
  
  public final void init()
  {
    if (!isInited)
    {
      if (!this.oaW.bAu()) {
        y.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
      }
    }
    else {
      return;
    }
    isInited = true;
  }
  
  public final void pause() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void start()
  {
    if (this.nYU == null)
    {
      y.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
      return;
    }
    this.hkx = System.currentTimeMillis();
    this.oaW.a(367, new j.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.j
 * JD-Core Version:    0.7.0.1
 */