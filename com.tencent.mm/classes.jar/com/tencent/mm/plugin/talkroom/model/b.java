package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements be
{
  private g MjA;
  private d MjB;
  private c MjC;
  private e MjD;
  private f MjE;
  private p MjF;
  
  public b()
  {
    AppMethodBeat.i(29439);
    this.MjB = new d();
    this.MjC = new c();
    this.MjF = new p.a()
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
              b.a(b.this).zO(false);
            }
            AppMethodBeat.o(29437);
          }
        });
        AppMethodBeat.o(29438);
      }
    };
    AppMethodBeat.o(29439);
  }
  
  private static b gim()
  {
    AppMethodBeat.i(29440);
    bh.beC();
    b localb2 = (b)ch.RZ("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      bh.beC().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(29440);
    return localb1;
  }
  
  public static g gin()
  {
    AppMethodBeat.i(29441);
    if (gim().MjA == null) {
      gim().MjA = new g();
    }
    g localg = gim().MjA;
    AppMethodBeat.o(29441);
    return localg;
  }
  
  public static e gio()
  {
    AppMethodBeat.i(29442);
    if (gim().MjD == null) {
      gim().MjD = new e();
    }
    e locale = gim().MjD;
    AppMethodBeat.o(29442);
    return locale;
  }
  
  public static String gip()
  {
    AppMethodBeat.i(29443);
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = com.tencent.mm.model.c.aHl() + "talkroom/";
    AppMethodBeat.o(29443);
    return localObject;
  }
  
  public static void giq()
  {
    AppMethodBeat.i(267103);
    gim().MjE = new f();
    AppMethodBeat.o(267103);
  }
  
  public static c gir()
  {
    AppMethodBeat.i(267104);
    c localc = gim().MjC;
    AppMethodBeat.o(267104);
    return localc;
  }
  
  public static f gis()
  {
    AppMethodBeat.i(29444);
    if (gim().MjE == null) {
      gim().MjE = new f();
    }
    f localf = gim().MjE;
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
    h.d.a(Integer.valueOf(56), this.MjB);
    bh.a(this.MjF);
    com.tencent.mm.bj.g.meT = gio();
    com.tencent.mm.bj.g.meU = gin();
    com.tencent.mm.bj.g.meT.bpI();
    AppMethodBeat.o(29445);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29446);
    h.d.b(Integer.valueOf(56), this.MjB);
    bh.b(this.MjF);
    com.tencent.mm.bj.g.meT = null;
    com.tencent.mm.bj.g.meU = null;
    if (this.MjA != null)
    {
      this.MjA.giD();
      this.MjA = null;
    }
    AppMethodBeat.o(29446);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */