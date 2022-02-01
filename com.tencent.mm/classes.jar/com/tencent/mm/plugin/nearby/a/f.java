package com.tencent.mm.plugin.nearby.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.lc.a;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bp.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements ax
{
  private com.tencent.mm.sdk.b.c fJT;
  private com.tencent.mm.sdk.b.c woi;
  private com.tencent.mm.sdk.b.c woj;
  com.tencent.mm.pluginsdk.c.c<mo> wok;
  com.tencent.mm.pluginsdk.c.c<mp> wol;
  d wom;
  private bp.a won;
  private com.tencent.mm.sdk.b.c<oz> woo;
  private com.tencent.mm.sdk.b.c<mg> wop;
  
  public f()
  {
    AppMethodBeat.i(89793);
    this.woi = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(lc paramAnonymouslc)
      {
        int i = 3;
        AppMethodBeat.i(89776);
        Object localObject = paramAnonymouslc.dyn.dyo;
        paramAnonymouslc = paramAnonymouslc.dyn.dku;
        if ((((bj.b)localObject).hGU != null) && (((bj.b)localObject).scene == 1))
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(73729, Integer.valueOf(1));
          br localbr = new br();
          localbr.field_content = paramAnonymouslc.field_content;
          localbr.field_createtime = bt.aQJ();
          localbr.field_imgpath = "";
          localbr.field_sayhicontent = aj.getContext().getString(2131761529);
          localbr.field_sayhiuser = paramAnonymouslc.field_talker;
          localbr.field_scene = 18;
          if (paramAnonymouslc.field_status > 3) {
            i = paramAnonymouslc.field_status;
          }
          localbr.field_status = i;
          localbr.field_svrid = paramAnonymouslc.field_msgSvrId;
          localbr.field_talker = paramAnonymouslc.field_talker;
          localbr.field_type = 34;
          localbr.field_isSend = 0;
          localbr.field_sayhiencryptuser = paramAnonymouslc.field_talker;
          localbr.field_ticket = ((bj.b)localObject).hGU;
          com.tencent.mm.kernel.g.ajA().aiF();
          ((bs)((l)com.tencent.mm.kernel.g.ab(l.class)).dlH()).a(localbr);
          localObject = new lb();
          ((lb)localObject).dyl.dym = paramAnonymouslc.field_talker;
          com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
        }
        AppMethodBeat.o(89776);
        return false;
      }
    };
    this.woj = new com.tencent.mm.sdk.b.c() {};
    this.wok = new f.3(this);
    this.wol = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yb()
      {
        return 377;
      }
    };
    this.fJT = new com.tencent.mm.sdk.b.c() {};
    this.wom = new d()
    {
      public final b alj(String paramAnonymousString)
      {
        AppMethodBeat.i(89786);
        kx localkx = new kx();
        localkx.dya.dln = paramAnonymousString;
        AppMethodBeat.o(89786);
        return localkx;
      }
      
      public final k cWC()
      {
        AppMethodBeat.i(89787);
        com.tencent.mm.kernel.g.ajA().aiF();
        k localk = (k)((l)com.tencent.mm.kernel.g.ab(l.class)).dlH();
        AppMethodBeat.o(89787);
        return localk;
      }
    };
    this.won = new bp.a()
    {
      public final am Bf(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bp paramAnonymousbp, am paramAnonymousam)
      {
        AppMethodBeat.i(89788);
        if ((paramAnonymousbp != null) && (paramAnonymousam != null) && (paramAnonymousam.adk()))
        {
          com.tencent.mm.kernel.g.ajA().aiF();
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlH().apQ(paramAnonymousam.field_username);
        }
        AppMethodBeat.o(89788);
      }
      
      public final int b(am paramAnonymousam, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.woo = new com.tencent.mm.sdk.b.c()
    {
      private static boolean aJX()
      {
        AppMethodBeat.i(89789);
        f.dtW();
        AppMethodBeat.o(89789);
        return false;
      }
    };
    this.wop = new com.tencent.mm.sdk.b.c()
    {
      private static boolean dtX()
      {
        AppMethodBeat.i(89791);
        f.dtW();
        AppMethodBeat.o(89791);
        return false;
      }
    };
    AppMethodBeat.o(89793);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(89795);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this.won);
    this.wop.alive();
    this.woo.alive();
    com.tencent.mm.sdk.b.a.IbL.c(this.fJT);
    com.tencent.mm.sdk.b.a.IbL.c(this.woj);
    com.tencent.mm.sdk.b.a.IbL.c(this.wok);
    com.tencent.mm.sdk.b.a.IbL.c(this.wol);
    this.woi.alive();
    AppMethodBeat.o(89795);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(89794);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this.won);
    this.wop.alive();
    this.woo.dead();
    com.tencent.mm.sdk.b.a.IbL.d(this.woj);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJT);
    com.tencent.mm.sdk.b.a.IbL.d(this.wok);
    com.tencent.mm.sdk.b.a.IbL.d(this.wol);
    this.woi.dead();
    AppMethodBeat.o(89794);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */