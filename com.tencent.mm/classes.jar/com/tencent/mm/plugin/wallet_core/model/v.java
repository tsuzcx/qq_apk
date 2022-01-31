package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.h.a.tk.a;
import com.tencent.mm.h.a.tk.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

public final class v
  extends c<tk>
  implements f
{
  private boolean cdb = false;
  private boolean cdc = false;
  private boolean kkX = false;
  private tk qyE;
  
  public v()
  {
    this.udX = tk.class.getName().hashCode();
  }
  
  private static boolean AO(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void a(int paramInt, String paramString, m paramm, boolean paramBoolean)
  {
    boolean bool2 = false;
    ag localag;
    boolean bool1;
    if (this.qyE != null)
    {
      this.qyE.cda.errCode = paramInt;
      this.qyE.cda.aox = paramString;
      this.qyE.cda.cdF = paramm;
      this.qyE.cda.cdd = o.bVs().bVN();
      paramString = this.qyE.cda;
      localag = o.bVs();
      if (((localag.qzf == null) || (!localag.qzf.bVF())) && ((localag.qjY == null) || (localag.qjY.size() <= 0))) {
        break label884;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label889;
      }
      bool1 = false;
      label119:
      paramString.cde = bool1;
      paramString = this.qyE.cda;
      localag = o.bVs();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localag.k(localArrayList1, localArrayList2);
      if (!ag.cS(localArrayList2)) {
        break label920;
      }
      bool1 = true;
      label176:
      paramString.cdf = bool1;
      this.qyE.cda.cdg = o.bVs().bVR().bVF();
      this.qyE.cda.cdh = o.bVs().bVQ();
      this.qyE.cda.cdi = o.bVs().aEZ();
      this.qyE.cda.cdj = o.bVs().bVO();
      this.qyE.cda.cdk = o.bVs().bVR().bVI();
      this.qyE.cda.cdl = "";
      paramString = this.qyE.cda;
      localag = o.bVs();
      if (localag.qzd == null) {
        break label932;
      }
      if (localag.qzd.field_paymenu_use_new != 1) {
        break label926;
      }
      bool1 = true;
      label316:
      paramString.cdz = bool1;
      if ((paramm != null) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)))
      {
        this.qyE.cda.cdl = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdl;
        this.qyE.cda.cdm = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdm;
        this.qyE.cda.cdn = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdn;
        this.qyE.cda.cdo = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdo;
        this.qyE.cda.cdp = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdp;
        this.qyE.cda.scene = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).scene;
        this.qyE.cda.cdq = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdq;
        this.qyE.cda.cdr = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdr;
        this.qyE.cda.cds = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cds;
        this.qyE.cda.cdt = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdt;
        this.qyE.cda.cdu = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdu;
        this.qyE.cda.cdv = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdv;
        this.qyE.cda.cdw = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdw;
        this.qyE.cda.title = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).title;
        this.qyE.cda.cdx = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdx;
        this.qyE.cda.cdy = ((com.tencent.mm.plugin.wallet_core.c.y)paramm).cdy;
      }
      paramString = this.qyE.cda;
      if (!o.bVs().bVY()) {
        break label938;
      }
      paramInt = 1;
      label624:
      paramString.cdA = paramInt;
      paramString = this.qyE.cda;
      paramm = o.bVs();
      if (paramm.qzd == null) {
        break label943;
      }
      paramInt = paramm.qzd.field_is_show_lqb;
      label656:
      paramString.cdB = paramInt;
      paramString = this.qyE.cda;
      paramm = o.bVs();
      bool1 = bool2;
      if (paramm.qzd != null)
      {
        bool1 = bool2;
        if (paramm.qzd.field_is_open_lqb == 1) {
          bool1 = true;
        }
      }
      paramString.cdC = bool1;
      paramm = this.qyE.cda;
      paramString = o.bVs();
      if (paramString.qzd == null) {
        break label948;
      }
    }
    label920:
    label926:
    label932:
    label938:
    label943:
    label948:
    for (paramString = paramString.qzd.field_lqb_open_url;; paramString = null)
    {
      paramm.cdD = paramString;
      this.qyE.cda.cdE = paramBoolean;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.qyE.cda.cde + " hasNewTips : " + this.qyE.cda.cdf + " swipeOn : " + this.qyE.cda.cdg);
      if (this.qyE.bFJ != null) {
        this.qyE.bFJ.run();
      }
      if (this.qyE.cda.ccT != null) {
        this.qyE.cda.ccT.run();
      }
      if (this.kkX) {
        this.qyE = null;
      }
      return;
      label884:
      paramInt = 0;
      break;
      label889:
      if ((localag.qjX != null) && (localag.qjX.size() > 0))
      {
        bool1 = false;
        break label119;
      }
      bool1 = true;
      break label119;
      bool1 = false;
      break label176;
      bool1 = false;
      break label316;
      bool1 = false;
      break label316;
      paramInt = 0;
      break label624;
      paramInt = 0;
      break label656;
    }
  }
  
  private boolean a(tk paramtk)
  {
    if (!(paramtk instanceof tk))
    {
      com.tencent.mm.sdk.platformtools.y.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      return false;
    }
    this.kkX = false;
    this.qyE = paramtk;
    this.cdb = paramtk.ccZ.cdb;
    this.cdc = paramtk.ccZ.cdc;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.cdc) });
    g.DQ();
    g.DO().dJT.a(385, this);
    g.DQ();
    g.DO().dJT.a(1518, this);
    if (o.bVs().bVM())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      if (q.Gw())
      {
        g.DQ();
        g.DO().dJT.a(new a(), 0);
      }
    }
    for (;;)
    {
      return true;
      g.DQ();
      Object localObject = g.DO().dJT;
      if (AO(paramtk.ccZ.scene)) {}
      for (int i = paramtk.ccZ.scene;; i = 0)
      {
        ((p)localObject).a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
        break;
      }
      long l;
      if (paramtk.ccZ.cdb)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localObject = o.bVs();
        l = bk.UX();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(((ag)localObject).qzl) });
        if ((((ag)localObject).qzl <= 0L) || (l > ((ag)localObject).qzl)) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0)
          {
            if (!this.cdc) {
              this.kkX = true;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
            a(0, "", null, false);
            if (q.Gw())
            {
              g.DQ();
              g.DO().dJT.a(new a(), 0);
              break;
              i = 0;
              continue;
            }
            g.DQ();
            localObject = g.DO().dJT;
            if (AO(paramtk.ccZ.scene)) {}
            for (i = paramtk.ccZ.scene;; i = 0)
            {
              ((p)localObject).a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
              break;
            }
          }
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        if (q.Gw())
        {
          g.DQ();
          g.DO().dJT.a(new a(), 0);
        }
        else
        {
          g.DQ();
          localObject = g.DO().dJT;
          if (AO(paramtk.ccZ.scene)) {}
          for (i = paramtk.ccZ.scene;; i = 0)
          {
            ((p)localObject).a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
            break;
          }
        }
      }
      else
      {
        localObject = o.bVs();
        l = bk.cn(((ag)localObject).qzk);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time " + l, new Object[] { Long.valueOf(((ag)localObject).qzk), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
            if (q.Gw())
            {
              g.DQ();
              g.DO().dJT.a(new a(), 0);
              break;
              i = 0;
              continue;
            }
            g.DQ();
            localObject = g.DO().dJT;
            if (AO(paramtk.ccZ.scene)) {}
            for (i = paramtk.ccZ.scene;; i = 0)
            {
              ((p)localObject).a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
              break;
            }
          }
        }
        this.kkX = true;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    if (((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)) || ((paramm instanceof a)))
    {
      g.DQ();
      g.DO().dJT.b(385, this);
      g.DQ();
      g.DO().dJT.b(1518, this);
      if ((!this.cdc) && (this.cdb) && (this.kkX)) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      }
    }
    else
    {
      return;
    }
    this.kkX = true;
    a(paramInt2, paramString, paramm, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.v
 * JD-Core Version:    0.7.0.1
 */