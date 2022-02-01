package com.tencent.mm.plugin.nearby.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.kl.a;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements aw
{
  private com.tencent.mm.sdk.b.c fop;
  private com.tencent.mm.sdk.b.c tZP;
  private com.tencent.mm.sdk.b.c tZQ;
  com.tencent.mm.pluginsdk.c.c<lw> tZR;
  com.tencent.mm.pluginsdk.c.c<lx> tZS;
  d tZT;
  private bg.a tZU;
  private com.tencent.mm.sdk.b.c<oh> tZV;
  private com.tencent.mm.sdk.b.c<lo> tZW;
  
  public f()
  {
    AppMethodBeat.i(89793);
    this.tZP = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(kl paramAnonymouskl)
      {
        int i = 3;
        AppMethodBeat.i(89776);
        Object localObject = paramAnonymouskl.doR.doS;
        paramAnonymouskl = paramAnonymouskl.doR.dbD;
        if ((((bi.b)localObject).gOc != null) && (((bi.b)localObject).scene == 1))
        {
          g.afB().afk().set(73729, Integer.valueOf(1));
          bi localbi = new bi();
          localbi.field_content = paramAnonymouskl.field_content;
          localbi.field_createtime = bt.aGK();
          localbi.field_imgpath = "";
          localbi.field_sayhicontent = aj.getContext().getString(2131761529);
          localbi.field_sayhiuser = paramAnonymouskl.field_talker;
          localbi.field_scene = 18;
          if (paramAnonymouskl.field_status > 3) {
            i = paramAnonymouskl.field_status;
          }
          localbi.field_status = i;
          localbi.field_svrid = paramAnonymouskl.field_msgSvrId;
          localbi.field_talker = paramAnonymouskl.field_talker;
          localbi.field_type = 34;
          localbi.field_isSend = 0;
          localbi.field_sayhiencryptuser = paramAnonymouskl.field_talker;
          localbi.field_ticket = ((bi.b)localObject).gOc;
          g.afz().aeD();
          ((bj)((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF()).a(localbi);
          localObject = new kk();
          ((kk)localObject).doP.doQ = paramAnonymouskl.field_talker;
          com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
        }
        AppMethodBeat.o(89776);
        return false;
      }
    };
    this.tZQ = new com.tencent.mm.sdk.b.c() {};
    this.tZR = new f.3(this);
    this.tZS = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int UO()
      {
        return 377;
      }
    };
    this.fop = new com.tencent.mm.sdk.b.c() {};
    this.tZT = new d()
    {
      public final b abU(String paramAnonymousString)
      {
        AppMethodBeat.i(89786);
        kg localkg = new kg();
        localkg.doD.dcx = paramAnonymousString;
        AppMethodBeat.o(89786);
        return localkg;
      }
      
      public final com.tencent.mm.sdk.e.k cBa()
      {
        AppMethodBeat.i(89787);
        g.afz().aeD();
        com.tencent.mm.sdk.e.k localk = (com.tencent.mm.sdk.e.k)((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF();
        AppMethodBeat.o(89787);
        return localk;
      }
    };
    this.tZU = new bg.a()
    {
      public final void a(bg paramAnonymousbg, af paramAnonymousaf)
      {
        AppMethodBeat.i(89788);
        if ((paramAnonymousbg != null) && (paramAnonymousaf != null) && (paramAnonymousaf.ZM()))
        {
          g.afz().aeD();
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF().agj(paramAnonymousaf.field_username);
        }
        AppMethodBeat.o(89788);
      }
    };
    this.tZV = new com.tencent.mm.sdk.b.c()
    {
      private static boolean azW()
      {
        AppMethodBeat.i(89789);
        f.cWc();
        AppMethodBeat.o(89789);
        return false;
      }
    };
    this.tZW = new com.tencent.mm.sdk.b.c()
    {
      private static boolean cWd()
      {
        AppMethodBeat.i(89791);
        f.cWc();
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
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().a(this.tZU);
    this.tZW.alive();
    this.tZV.alive();
    com.tencent.mm.sdk.b.a.ESL.c(this.fop);
    com.tencent.mm.sdk.b.a.ESL.c(this.tZQ);
    com.tencent.mm.sdk.b.a.ESL.c(this.tZR);
    com.tencent.mm.sdk.b.a.ESL.c(this.tZS);
    this.tZP.alive();
    AppMethodBeat.o(89795);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(89794);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this.tZU);
    this.tZW.alive();
    this.tZV.dead();
    com.tencent.mm.sdk.b.a.ESL.d(this.tZQ);
    com.tencent.mm.sdk.b.a.ESL.d(this.fop);
    com.tencent.mm.sdk.b.a.ESL.d(this.tZR);
    com.tencent.mm.sdk.b.a.ESL.d(this.tZS);
    this.tZP.dead();
    AppMethodBeat.o(89794);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */