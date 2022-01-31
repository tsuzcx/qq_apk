package com.tencent.mm.plugin.translate;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public final class a
  implements at
{
  ak handler;
  com.tencent.mm.plugin.translate.a.c toF;
  az toG;
  private c.a toH;
  private com.tencent.mm.sdk.b.c toI;
  private com.tencent.mm.sdk.b.c toJ;
  
  public a()
  {
    AppMethodBeat.i(26055);
    this.toF = c.b.toT;
    this.toG = new az(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.toH = new a.1(this);
    this.handler = new ak(Looper.getMainLooper());
    this.toI = new com.tencent.mm.sdk.b.c() {};
    this.toJ = new a.3(this);
    AppMethodBeat.o(26055);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    com.tencent.mm.plugin.translate.a.c localc = this.toF;
    c.a locala = this.toH;
    if ((locala == null) || (localc.eDb.contains(locala))) {}
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.c(this.toI);
      com.tencent.mm.sdk.b.a.ymk.c(this.toJ);
      AppMethodBeat.o(26056);
      return;
      localc.eDb.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26057);
    com.tencent.mm.sdk.b.a.ymk.d(this.toI);
    com.tencent.mm.sdk.b.a.ymk.d(this.toJ);
    com.tencent.mm.plugin.translate.a.c localc = this.toF;
    Object localObject = this.toH;
    if ((localObject == null) || (!localc.eDb.contains(localObject))) {}
    for (;;)
    {
      localc = this.toF;
      if (localc.toQ == null) {
        break;
      }
      localObject = localc.toQ;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        f localf = localObject[i];
        if (localf != null)
        {
          aw.Rc().b(631, localf);
          if (localf.toZ != null)
          {
            localf.tpb.stopTimer();
            aw.Rc().a(localf.toZ);
          }
          localf.cKU();
          localf.toX = null;
        }
        i += 1;
      }
      localc.eDb.remove(localObject);
    }
    localc.toS.clear();
    localc.toR.clear();
    localc.eDb.clear();
    localc.evn = 0;
    AppMethodBeat.o(26057);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */