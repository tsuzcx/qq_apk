package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements az
{
  g BEI;
  private d BEJ;
  public c BEK;
  private e BEL;
  f BEM;
  private n BEN;
  
  public b()
  {
    AppMethodBeat.i(29439);
    this.BEJ = new d();
    this.BEK = new c();
    this.BEN = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29438);
        if (paramAnonymousInt != 4)
        {
          AppMethodBeat.o(29438);
          return;
        }
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29437);
            if (b.this.BEI != null) {
              b.this.BEI.sO(false);
            }
            AppMethodBeat.o(29437);
          }
        });
        AppMethodBeat.o(29438);
      }
    };
    AppMethodBeat.o(29439);
  }
  
  public static b erj()
  {
    AppMethodBeat.i(29440);
    bc.aCa();
    b localb2 = (b)cc.Ca("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bc.aCa().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(29440);
    return localb1;
  }
  
  public static g erk()
  {
    AppMethodBeat.i(29441);
    if (erj().BEI == null) {
      erj().BEI = new g();
    }
    g localg = erj().BEI;
    AppMethodBeat.o(29441);
    return localg;
  }
  
  public static e erl()
  {
    AppMethodBeat.i(29442);
    if (erj().BEL == null) {
      erj().BEL = new e();
    }
    e locale = erj().BEL;
    AppMethodBeat.o(29442);
    return locale;
  }
  
  public static String erm()
  {
    AppMethodBeat.i(29443);
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = com.tencent.mm.model.c.ajw() + "talkroom/";
    AppMethodBeat.o(29443);
    return localObject;
  }
  
  public static f ern()
  {
    AppMethodBeat.i(29444);
    if (erj().BEM == null) {
      erj().BEM = new f();
    }
    f localf = erj().BEM;
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
    e.d.a(Integer.valueOf(56), this.BEJ);
    bc.a(this.BEN);
    com.tencent.mm.bh.g.ium = erl();
    com.tencent.mm.bh.g.iun = erk();
    com.tencent.mm.bh.g.ium.aMr();
    AppMethodBeat.o(29445);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29446);
    e.d.b(Integer.valueOf(56), this.BEJ);
    bc.b(this.BEN);
    com.tencent.mm.bh.g.ium = null;
    com.tencent.mm.bh.g.iun = null;
    if (this.BEI != null)
    {
      this.BEI.ery();
      this.BEI = null;
    }
    AppMethodBeat.o(29446);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */