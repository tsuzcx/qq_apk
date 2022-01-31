package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class p
{
  public static p pTi;
  v2protocal pTa = new v2protocal(new ah(Looper.getMainLooper()));
  boolean pTb = false;
  public p.a pTc;
  int pTd = -1;
  boolean pTe = false;
  int pTf = 0;
  public int pTg;
  public int pTh;
  am pTj = new am(Looper.getMainLooper(), new p.1(this), true);
  
  public static p bQU()
  {
    if (pTi == null) {
      pTi = new p();
    }
    return pTi;
  }
  
  public final void bQV()
  {
    y.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.pTd = -1;
    this.pTe = true;
    this.pTh = 0;
    this.pTg = 0;
    ai.l(new p.2(this), 3000L);
  }
  
  public final void bQW()
  {
    y.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.pTd = -1;
    this.pTb = false;
    this.pTe = false;
    this.pTh = 0;
    this.pTg = 0;
    ai.d(new p.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p
 * JD-Core Version:    0.7.0.1
 */