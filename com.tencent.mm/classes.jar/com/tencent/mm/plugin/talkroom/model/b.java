package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements bd
{
  private d FPA;
  public c FPB;
  private e FPC;
  f FPD;
  private p FPE;
  g FPz;
  
  public b()
  {
    AppMethodBeat.i(29439);
    this.FPA = new d();
    this.FPB = new c();
    this.FPE = new p.a()
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
            if (b.this.FPz != null) {
              b.this.FPz.wi(false);
            }
            AppMethodBeat.o(29437);
          }
        });
        AppMethodBeat.o(29438);
      }
    };
    AppMethodBeat.o(29439);
  }
  
  public static b ftM()
  {
    AppMethodBeat.i(29440);
    bg.aVz();
    b localb2 = (b)cg.KG("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bg.aVz().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(29440);
    return localb1;
  }
  
  public static g ftN()
  {
    AppMethodBeat.i(29441);
    if (ftM().FPz == null) {
      ftM().FPz = new g();
    }
    g localg = ftM().FPz;
    AppMethodBeat.o(29441);
    return localg;
  }
  
  public static e ftO()
  {
    AppMethodBeat.i(29442);
    if (ftM().FPC == null) {
      ftM().FPC = new e();
    }
    e locale = ftM().FPC;
    AppMethodBeat.o(29442);
    return locale;
  }
  
  public static String ftP()
  {
    AppMethodBeat.i(29443);
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = com.tencent.mm.model.c.azM() + "talkroom/";
    AppMethodBeat.o(29443);
    return localObject;
  }
  
  public static f ftQ()
  {
    AppMethodBeat.i(29444);
    if (ftM().FPD == null) {
      ftM().FPD = new f();
    }
    f localf = ftM().FPD;
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
    h.d.a(Integer.valueOf(56), this.FPA);
    bg.a(this.FPE);
    com.tencent.mm.bh.g.jpy = ftO();
    com.tencent.mm.bh.g.jpz = ftN();
    com.tencent.mm.bh.g.jpy.bgs();
    AppMethodBeat.o(29445);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29446);
    h.d.b(Integer.valueOf(56), this.FPA);
    bg.b(this.FPE);
    com.tencent.mm.bh.g.jpy = null;
    com.tencent.mm.bh.g.jpz = null;
    if (this.FPz != null)
    {
      this.FPz.fub();
      this.FPz = null;
    }
    AppMethodBeat.o(29446);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */