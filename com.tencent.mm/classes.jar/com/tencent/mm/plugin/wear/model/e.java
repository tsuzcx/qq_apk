package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  com.tencent.mm.sdk.b.c dji = new e.11(this);
  am fjC = new am(Looper.getMainLooper(), new e.7(this), true);
  com.tencent.mm.sdk.b.c gOo = new e.6(this);
  g.a jJv = new e.2(this);
  com.tencent.mm.sdk.b.c lRT = new e.3(this);
  com.tencent.mm.sdk.b.c peY = new e.1(this);
  private PowerManager qRO;
  private KeyguardManager qRP;
  com.tencent.mm.sdk.b.c qRQ = new e.4(this);
  com.tencent.mm.sdk.b.c qRR = new e.5(this);
  com.tencent.mm.sdk.b.c qRS = new e.8(this);
  com.tencent.mm.sdk.b.c qRT = new e.9(this);
  com.tencent.mm.sdk.b.c qRU = new e.10(this);
  
  public e()
  {
    y.i("MicroMsg.Wear.WearLogic", "Create!");
    this.peY.cqo();
    this.qRQ.cqo();
    this.qRR.cqo();
    this.gOo.cqo();
    this.qRS.cqo();
    this.qRT.cqo();
    this.qRU.cqo();
    this.dji.cqo();
    this.lRT.cqo();
    this.fjC.S(1800000L, 1800000L);
    this.qRO = ((PowerManager)ae.getContext().getSystemService("power"));
    this.qRP = ((KeyguardManager)ae.getContext().getSystemService("keyguard"));
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this.jJv, null);
  }
  
  public static void p(String paramString, int paramInt, boolean paramBoolean)
  {
    a.bYL().qRA.a(new com.tencent.mm.plugin.wear.model.f.j(paramString, paramInt, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e
 * JD-Core Version:    0.7.0.1
 */