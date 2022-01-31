package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;

public final class e
{
  ap bAz;
  com.tencent.mm.sdk.b.c eaA;
  com.tencent.mm.sdk.b.c ipZ;
  h.a mdz;
  com.tencent.mm.sdk.b.c opW;
  com.tencent.mm.sdk.b.c rXQ;
  private PowerManager uGW;
  private KeyguardManager uGX;
  com.tencent.mm.sdk.b.c uGY;
  com.tencent.mm.sdk.b.c uGZ;
  com.tencent.mm.sdk.b.c uHa;
  com.tencent.mm.sdk.b.c uHb;
  com.tencent.mm.sdk.b.c uHc;
  
  public e()
  {
    AppMethodBeat.i(26318);
    this.rXQ = new e.1(this);
    this.uGY = new e.4(this);
    this.uGZ = new e.5(this);
    this.ipZ = new e.6(this);
    this.bAz = new ap(Looper.getMainLooper(), new e.7(this), true);
    this.uHa = new e.8(this);
    this.uHb = new e.9(this);
    this.uHc = new e.10(this);
    this.eaA = new e.11(this);
    this.mdz = new e.2(this);
    this.opW = new e.3(this);
    ab.i("MicroMsg.Wear.WearLogic", "Create!");
    this.rXQ.alive();
    this.uGY.alive();
    this.uGZ.alive();
    this.ipZ.alive();
    this.uHa.alive();
    this.uHb.alive();
    this.uHc.alive();
    this.eaA.alive();
    this.opW.alive();
    this.bAz.ag(1800000L, 1800000L);
    this.uGW = ((PowerManager)ah.getContext().getSystemService("power"));
    this.uGX = ((KeyguardManager)ah.getContext().getSystemService("keyguard"));
    aw.aaz();
    com.tencent.mm.model.c.YC().a(this.mdz, null);
    AppMethodBeat.o(26318);
  }
  
  public static void s(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26319);
    a.cYy().uGI.a(new com.tencent.mm.plugin.wear.model.f.j(paramString, paramInt, paramBoolean));
    AppMethodBeat.o(26319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e
 * JD-Core Version:    0.7.0.1
 */