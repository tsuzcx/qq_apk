package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements aw
{
  g yIs;
  private d yIt;
  public c yIu;
  private e yIv;
  f yIw;
  private n yIx;
  
  public b()
  {
    AppMethodBeat.i(29439);
    this.yIt = new d();
    this.yIu = new c();
    this.yIx = new n.a()
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
            if (b.this.yIs != null) {
              b.this.yIs.rd(false);
            }
            AppMethodBeat.o(29437);
          }
        });
        AppMethodBeat.o(29438);
      }
    };
    AppMethodBeat.o(29439);
  }
  
  public static b dML()
  {
    AppMethodBeat.i(29440);
    az.arP();
    b localb2 = (b)bz.ut("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      az.arP().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(29440);
    return localb1;
  }
  
  public static g dMM()
  {
    AppMethodBeat.i(29441);
    if (dML().yIs == null) {
      dML().yIs = new g();
    }
    g localg = dML().yIs;
    AppMethodBeat.o(29441);
    return localg;
  }
  
  public static e dMN()
  {
    AppMethodBeat.i(29442);
    if (dML().yIv == null) {
      dML().yIv = new e();
    }
    e locale = dML().yIv;
    AppMethodBeat.o(29442);
    return locale;
  }
  
  public static String dMO()
  {
    AppMethodBeat.i(29443);
    Object localObject = new StringBuilder();
    az.arV();
    localObject = com.tencent.mm.model.c.aff() + "talkroom/";
    AppMethodBeat.o(29443);
    return localObject;
  }
  
  public static f dMP()
  {
    AppMethodBeat.i(29444);
    if (dML().yIw == null) {
      dML().yIw = new f();
    }
    f localf = dML().yIw;
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
    f.d.a(Integer.valueOf(56), this.yIt);
    az.a(this.yIx);
    com.tencent.mm.bi.g.hxv = dMN();
    com.tencent.mm.bi.g.hxw = dMM();
    com.tencent.mm.bi.g.hxv.aBU();
    AppMethodBeat.o(29445);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29446);
    f.d.b(Integer.valueOf(56), this.yIt);
    az.b(this.yIx);
    com.tencent.mm.bi.g.hxv = null;
    com.tencent.mm.bi.g.hxw = null;
    if (this.yIs != null)
    {
      this.yIs.dNa();
      this.yIs = null;
    }
    AppMethodBeat.o(29446);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */