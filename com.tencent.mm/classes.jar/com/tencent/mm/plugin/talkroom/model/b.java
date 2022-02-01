package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements aw
{
  g zVF;
  private d zVG;
  public c zVH;
  private e zVI;
  f zVJ;
  private n zVK;
  
  public b()
  {
    AppMethodBeat.i(29439);
    this.zVG = new d();
    this.zVH = new c();
    this.zVK = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29438);
        if (paramAnonymousInt != 4)
        {
          AppMethodBeat.o(29438);
          return;
        }
        new ao(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29437);
            if (b.this.zVF != null) {
              b.this.zVF.sb(false);
            }
            AppMethodBeat.o(29437);
          }
        });
        AppMethodBeat.o(29438);
      }
    };
    AppMethodBeat.o(29439);
  }
  
  public static b ebl()
  {
    AppMethodBeat.i(29440);
    az.ayG();
    b localb2 = (b)bz.yz("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      az.ayG().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(29440);
    return localb1;
  }
  
  public static g ebm()
  {
    AppMethodBeat.i(29441);
    if (ebl().zVF == null) {
      ebl().zVF = new g();
    }
    g localg = ebl().zVF;
    AppMethodBeat.o(29441);
    return localg;
  }
  
  public static e ebn()
  {
    AppMethodBeat.i(29442);
    if (ebl().zVI == null) {
      ebl().zVI = new e();
    }
    e locale = ebl().zVI;
    AppMethodBeat.o(29442);
    return locale;
  }
  
  public static String ebo()
  {
    AppMethodBeat.i(29443);
    Object localObject = new StringBuilder();
    az.ayM();
    localObject = com.tencent.mm.model.c.agv() + "talkroom/";
    AppMethodBeat.o(29443);
    return localObject;
  }
  
  public static f ebp()
  {
    AppMethodBeat.i(29444);
    if (ebl().zVJ == null) {
      ebl().zVJ = new f();
    }
    f localf = ebl().zVJ;
    AppMethodBeat.o(29444);
    return localf;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(29445);
    f.d.a(Integer.valueOf(56), this.zVG);
    az.a(this.zVK);
    com.tencent.mm.bh.g.hXW = ebn();
    com.tencent.mm.bh.g.hXX = ebm();
    com.tencent.mm.bh.g.hXW.aIK();
    AppMethodBeat.o(29445);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29446);
    f.d.b(Integer.valueOf(56), this.zVG);
    az.b(this.zVK);
    com.tencent.mm.bh.g.hXW = null;
    com.tencent.mm.bh.g.hXX = null;
    if (this.zVF != null)
    {
      this.zVF.ebA();
      this.zVF = null;
    }
    AppMethodBeat.o(29446);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */