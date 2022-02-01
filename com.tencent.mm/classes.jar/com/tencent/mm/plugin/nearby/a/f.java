package com.tencent.mm.plugin.nearby.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.kt.a;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bj.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements aw
{
  private com.tencent.mm.sdk.b.c frK;
  private com.tencent.mm.sdk.b.c viP;
  private com.tencent.mm.sdk.b.c viQ;
  com.tencent.mm.pluginsdk.c.c<mf> viR;
  com.tencent.mm.pluginsdk.c.c<mg> viS;
  d viT;
  private bj.a viU;
  private com.tencent.mm.sdk.b.c<oq> viV;
  private com.tencent.mm.sdk.b.c<lx> viW;
  
  public f()
  {
    AppMethodBeat.i(89793);
    this.viP = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(kt paramAnonymouskt)
      {
        int i = 3;
        AppMethodBeat.i(89776);
        Object localObject = paramAnonymouskt.dmz.dmA;
        paramAnonymouskt = paramAnonymouskt.dmz.cZc;
        if ((((bi.b)localObject).hoC != null) && (((bi.b)localObject).scene == 1))
        {
          g.agR().agA().set(73729, Integer.valueOf(1));
          bl localbl = new bl();
          localbl.field_content = paramAnonymouskt.field_content;
          localbl.field_createtime = bs.aNx();
          localbl.field_imgpath = "";
          localbl.field_sayhicontent = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761529);
          localbl.field_sayhiuser = paramAnonymouskt.field_talker;
          localbl.field_scene = 18;
          if (paramAnonymouskt.field_status > 3) {
            i = paramAnonymouskt.field_status;
          }
          localbl.field_status = i;
          localbl.field_svrid = paramAnonymouskt.field_msgSvrId;
          localbl.field_talker = paramAnonymouskt.field_talker;
          localbl.field_type = 34;
          localbl.field_isSend = 0;
          localbl.field_sayhiencryptuser = paramAnonymouskt.field_talker;
          localbl.field_ticket = ((bi.b)localObject).hoC;
          g.agP().afT();
          ((bm)((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco()).a(localbl);
          localObject = new ks();
          ((ks)localObject).dmx.dmy = paramAnonymouskt.field_talker;
          com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
        }
        AppMethodBeat.o(89776);
        return false;
      }
    };
    this.viQ = new com.tencent.mm.sdk.b.c() {};
    this.viR = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int VK()
      {
        return 148;
      }
    };
    this.viS = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int VK()
      {
        return 377;
      }
    };
    this.frK = new com.tencent.mm.sdk.b.c() {};
    this.viT = new d()
    {
      public final b agM(String paramAnonymousString)
      {
        AppMethodBeat.i(89786);
        ko localko = new ko();
        localko.dmm.cZV = paramAnonymousString;
        AppMethodBeat.o(89786);
        return localko;
      }
      
      public final com.tencent.mm.sdk.e.k cOj()
      {
        AppMethodBeat.i(89787);
        g.agP().afT();
        com.tencent.mm.sdk.e.k localk = (com.tencent.mm.sdk.e.k)((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco();
        AppMethodBeat.o(89787);
        return localk;
      }
    };
    this.viU = new bj.a()
    {
      public final void a(bj paramAnonymousbj, com.tencent.mm.storage.ai paramAnonymousai)
      {
        AppMethodBeat.i(89788);
        if ((paramAnonymousbj != null) && (paramAnonymousai != null) && (paramAnonymousai.aaH()))
        {
          g.agP().afT();
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco().ald(paramAnonymousai.field_username);
        }
        AppMethodBeat.o(89788);
      }
    };
    this.viV = new com.tencent.mm.sdk.b.c()
    {
      private static boolean aGM()
      {
        AppMethodBeat.i(89789);
        f.djK();
        AppMethodBeat.o(89789);
        return false;
      }
    };
    this.viW = new com.tencent.mm.sdk.b.c()
    {
      private static boolean djL()
      {
        AppMethodBeat.i(89791);
        f.djK();
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
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().a(this.viU);
    this.viW.alive();
    this.viV.alive();
    com.tencent.mm.sdk.b.a.GpY.c(this.frK);
    com.tencent.mm.sdk.b.a.GpY.c(this.viQ);
    com.tencent.mm.sdk.b.a.GpY.c(this.viR);
    com.tencent.mm.sdk.b.a.GpY.c(this.viS);
    this.viP.alive();
    AppMethodBeat.o(89795);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(89794);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this.viU);
    this.viW.alive();
    this.viV.dead();
    com.tencent.mm.sdk.b.a.GpY.d(this.viQ);
    com.tencent.mm.sdk.b.a.GpY.d(this.frK);
    com.tencent.mm.sdk.b.a.GpY.d(this.viR);
    com.tencent.mm.sdk.b.a.GpY.d(this.viS);
    this.viP.dead();
    AppMethodBeat.o(89794);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */