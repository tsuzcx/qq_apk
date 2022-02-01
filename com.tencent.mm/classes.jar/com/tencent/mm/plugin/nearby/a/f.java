package com.tencent.mm.plugin.nearby.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.ld.a;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class f
  implements az
{
  private com.tencent.mm.sdk.b.c fLW;
  private com.tencent.mm.sdk.b.c wDR;
  private com.tencent.mm.sdk.b.c wDS;
  com.tencent.mm.pluginsdk.c.c<mp> wDT;
  com.tencent.mm.pluginsdk.c.c<mq> wDU;
  d wDV;
  private bq.a wDW;
  private com.tencent.mm.sdk.b.c<pa> wDX;
  private com.tencent.mm.sdk.b.c<mh> wDY;
  
  public f()
  {
    AppMethodBeat.i(89793);
    this.wDR = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ld paramAnonymousld)
      {
        int i = 3;
        AppMethodBeat.i(89776);
        Object localObject = paramAnonymousld.dzs.dzt;
        paramAnonymousld = paramAnonymousld.dzs.dlw;
        if ((((bl.b)localObject).hJM != null) && (((bl.b)localObject).scene == 1))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(73729, Integer.valueOf(1));
          bs localbs = new bs();
          localbs.field_content = paramAnonymousld.field_content;
          localbs.field_createtime = bu.aRi();
          localbs.field_imgpath = "";
          localbs.field_sayhicontent = ak.getContext().getString(2131761529);
          localbs.field_sayhiuser = paramAnonymousld.field_talker;
          localbs.field_scene = 18;
          if (paramAnonymousld.field_status > 3) {
            i = paramAnonymousld.field_status;
          }
          localbs.field_status = i;
          localbs.field_svrid = paramAnonymousld.field_msgSvrId;
          localbs.field_talker = paramAnonymousld.field_talker;
          localbs.field_type = 34;
          localbs.field_isSend = 0;
          localbs.field_sayhiencryptuser = paramAnonymousld.field_talker;
          localbs.field_ticket = ((bl.b)localObject).hJM;
          com.tencent.mm.kernel.g.ajP().aiU();
          ((bt)((l)com.tencent.mm.kernel.g.ab(l.class)).doG()).a(localbs);
          localObject = new lc();
          ((lc)localObject).dzq.dzr = paramAnonymousld.field_talker;
          com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
        }
        AppMethodBeat.o(89776);
        return false;
      }
    };
    this.wDS = new com.tencent.mm.sdk.b.c() {};
    this.wDT = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yl()
      {
        return 148;
      }
    };
    this.wDU = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yl()
      {
        return 377;
      }
    };
    this.fLW = new com.tencent.mm.sdk.b.c() {};
    this.wDV = new d()
    {
      public final b amh(String paramAnonymousString)
      {
        AppMethodBeat.i(89786);
        ky localky = new ky();
        localky.dzf.dmp = paramAnonymousString;
        AppMethodBeat.o(89786);
        return localky;
      }
      
      public final k cZh()
      {
        AppMethodBeat.i(89787);
        com.tencent.mm.kernel.g.ajP().aiU();
        k localk = (k)((l)com.tencent.mm.kernel.g.ab(l.class)).doG();
        AppMethodBeat.o(89787);
        return localk;
      }
    };
    this.wDW = new bq.a()
    {
      public final an BH(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bq paramAnonymousbq, an paramAnonymousan)
      {
        AppMethodBeat.i(89788);
        if ((paramAnonymousbq != null) && (paramAnonymousan != null) && (paramAnonymousan.adv()))
        {
          com.tencent.mm.kernel.g.ajP().aiU();
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doG().aqV(paramAnonymousan.field_username);
        }
        AppMethodBeat.o(89788);
      }
      
      public final int b(an paramAnonymousan, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.wDX = new com.tencent.mm.sdk.b.c()
    {
      private static boolean aKq()
      {
        AppMethodBeat.i(89789);
        f.dxl();
        AppMethodBeat.o(89789);
        return false;
      }
    };
    this.wDY = new com.tencent.mm.sdk.b.c()
    {
      private static boolean dxm()
      {
        AppMethodBeat.i(89791);
        f.dxl();
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
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(this.wDW);
    this.wDY.alive();
    this.wDX.alive();
    com.tencent.mm.sdk.b.a.IvT.c(this.fLW);
    com.tencent.mm.sdk.b.a.IvT.c(this.wDS);
    com.tencent.mm.sdk.b.a.IvT.c(this.wDT);
    com.tencent.mm.sdk.b.a.IvT.c(this.wDU);
    this.wDR.alive();
    AppMethodBeat.o(89795);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(89794);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(this.wDW);
    this.wDY.alive();
    this.wDX.dead();
    com.tencent.mm.sdk.b.a.IvT.d(this.wDS);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLW);
    com.tencent.mm.sdk.b.a.IvT.d(this.wDT);
    com.tencent.mm.sdk.b.a.IvT.d(this.wDU);
    this.wDR.dead();
    AppMethodBeat.o(89794);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */