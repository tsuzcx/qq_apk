package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements ax
{
  g Bnj;
  private d Bnk;
  public c Bnl;
  private e Bnm;
  f Bnn;
  private n Bno;
  
  public b()
  {
    AppMethodBeat.i(29439);
    this.Bnk = new d();
    this.Bnl = new c();
    this.Bno = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29438);
        if (paramAnonymousInt != 4)
        {
          AppMethodBeat.o(29438);
          return;
        }
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29437);
            if (b.this.Bnj != null) {
              b.this.Bnj.sH(false);
            }
            AppMethodBeat.o(29437);
          }
        });
        AppMethodBeat.o(29438);
      }
    };
    AppMethodBeat.o(29439);
  }
  
  public static b enC()
  {
    AppMethodBeat.i(29440);
    ba.aBK();
    b localb2 = (b)ca.By("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      ba.aBK().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(29440);
    return localb1;
  }
  
  public static g enD()
  {
    AppMethodBeat.i(29441);
    if (enC().Bnj == null) {
      enC().Bnj = new g();
    }
    g localg = enC().Bnj;
    AppMethodBeat.o(29441);
    return localg;
  }
  
  public static e enE()
  {
    AppMethodBeat.i(29442);
    if (enC().Bnm == null) {
      enC().Bnm = new e();
    }
    e locale = enC().Bnm;
    AppMethodBeat.o(29442);
    return locale;
  }
  
  public static String enF()
  {
    AppMethodBeat.i(29443);
    Object localObject = new StringBuilder();
    ba.aBQ();
    localObject = com.tencent.mm.model.c.ajh() + "talkroom/";
    AppMethodBeat.o(29443);
    return localObject;
  }
  
  public static f enG()
  {
    AppMethodBeat.i(29444);
    if (enC().Bnn == null) {
      enC().Bnn = new f();
    }
    f localf = enC().Bnn;
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
    e.d.a(Integer.valueOf(56), this.Bnk);
    ba.a(this.Bno);
    com.tencent.mm.bi.g.irs = enE();
    com.tencent.mm.bi.g.irt = enD();
    com.tencent.mm.bi.g.irs.aLU();
    AppMethodBeat.o(29445);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29446);
    e.d.b(Integer.valueOf(56), this.Bnk);
    ba.b(this.Bno);
    com.tencent.mm.bi.g.irs = null;
    com.tencent.mm.bi.g.irt = null;
    if (this.Bnj != null)
    {
      this.Bnj.enR();
      this.Bnj = null;
    }
    AppMethodBeat.o(29446);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */