package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements be
{
  private g SMW;
  private d SMX;
  private c SMY;
  private e SMZ;
  private f SNa;
  private p mPf;
  
  public b()
  {
    AppMethodBeat.i(29439);
    this.SMX = new d();
    this.SMY = new c();
    this.mPf = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29438);
        if (paramAnonymousInt != 4)
        {
          AppMethodBeat.o(29438);
          return;
        }
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29437);
            if (b.a(b.this) != null) {
              b.a(b.this).Ff(false);
            }
            AppMethodBeat.o(29437);
          }
        });
        AppMethodBeat.o(29438);
      }
    };
    AppMethodBeat.o(29439);
  }
  
  private static b hCn()
  {
    AppMethodBeat.i(29440);
    bh.bCt();
    b localb2 = (b)ci.Ka("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bh.bCt().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(29440);
    return localb1;
  }
  
  public static g hCo()
  {
    AppMethodBeat.i(29441);
    if (hCn().SMW == null) {
      hCn().SMW = new g();
    }
    g localg = hCn().SMW;
    AppMethodBeat.o(29441);
    return localg;
  }
  
  public static e hCp()
  {
    AppMethodBeat.i(29442);
    if (hCn().SMZ == null) {
      hCn().SMZ = new e();
    }
    e locale = hCn().SMZ;
    AppMethodBeat.o(29442);
    return locale;
  }
  
  public static String hCq()
  {
    AppMethodBeat.i(29443);
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = com.tencent.mm.model.c.baj() + "talkroom/";
    AppMethodBeat.o(29443);
    return localObject;
  }
  
  public static void hCr()
  {
    AppMethodBeat.i(262686);
    hCn().SNa = new f();
    AppMethodBeat.o(262686);
  }
  
  public static c hCs()
  {
    AppMethodBeat.i(262688);
    c localc = hCn().SMY;
    AppMethodBeat.o(262688);
    return localc;
  }
  
  public static f hCt()
  {
    AppMethodBeat.i(29444);
    if (hCn().SNa == null) {
      hCn().SNa = new f();
    }
    f localf = hCn().SNa;
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
    g.d.a(Integer.valueOf(56), this.SMX);
    bh.a(this.mPf);
    com.tencent.mm.bc.g.oXL = hCp();
    com.tencent.mm.bc.g.oXM = hCo();
    com.tencent.mm.bc.g.oXL.bNo();
    AppMethodBeat.o(29445);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29446);
    g.d.b(Integer.valueOf(56), this.SMX);
    bh.b(this.mPf);
    com.tencent.mm.bc.g.oXL = null;
    com.tencent.mm.bc.g.oXM = null;
    if (this.SMW != null)
    {
      this.SMW.hCE();
      this.SMW = null;
    }
    AppMethodBeat.o(29446);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */