package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.ah.f
{
  static int fzn = 0;
  Activity fyk;
  boolean mTJ = false;
  private boolean mTK = false;
  com.tencent.mm.plugin.product.b.c mTL;
  private f.a mTM;
  private com.tencent.mm.sdk.b.c mTN = new f.3(this);
  
  public f(Activity paramActivity, f.a parama)
  {
    this.fyk = paramActivity;
    com.tencent.mm.plugin.product.a.a.brN();
    this.mTL = com.tencent.mm.plugin.product.a.a.brO();
    this.mTM = parama;
  }
  
  private void bso()
  {
    Object localObject = com.tencent.mm.plugin.product.a.a.brN().brP();
    bjm localbjm = this.mTL.brV();
    if ((localbjm != null) && (!bk.bl(localbjm.kSY)) && (!localbjm.kSY.contains(";")))
    {
      ((d)localObject).mSh.remove(localbjm.kSY);
      ((d)localObject).mSh.add(localbjm.kSY);
      ((d)localObject).bsi();
    }
    localObject = new Intent(this.fyk, MallProductUI.class);
    ((Intent)localObject).putExtra("key_go_finish", true);
    ((Intent)localObject).addFlags(67108864);
    this.fyk.startActivity((Intent)localObject);
  }
  
  public final void bsn()
  {
    com.tencent.mm.plugin.product.b.m localm = this.mTL.mRP;
    cj localcj = new cj();
    yj localyj = new yj();
    yp localyp = new yp();
    yi localyi = new yi();
    localyp.Yq(q.Gj());
    localyp.Yr(q.Gj());
    localyp.EQ(11);
    localyp.hl(bk.UY());
    localyi.Yj(localm.mSu.name);
    localyi.Yk(this.mTL.bsh());
    localyi.EN(localm.mSr);
    localyi.Ym(this.mTL.a(localm));
    localyi.Yl(localm.bsj());
    localcj.bIw.title = localm.mSu.name;
    localcj.bIw.desc = this.mTL.bsh();
    localcj.bIw.bIy = localyj;
    localcj.bIw.type = 11;
    localyj.a(localyp);
    localyj.b(localyi);
    localcj.bIw.activity = this.fyk;
    localcj.bIw.bID = 5;
    com.tencent.mm.sdk.b.a.udP.m(localcj);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        this.mTL.R(paramIntent);
        if (this.mTM != null) {
          this.mTM.q(0, 0, "");
        }
        com.tencent.mm.kernel.g.DQ();
        Object localObject = com.tencent.mm.kernel.g.DO().dJT;
        paramIntent = this.mTL;
        if (paramIntent.mRP != null) {}
        for (paramIntent = paramIntent.mRP.mSq;; paramIntent = "")
        {
          ((p)localObject).a(new com.tencent.mm.plugin.product.b.g(paramIntent, this.mTL.mRR, this.mTL.mRV), 0);
          return;
        }
        localObject = new tp();
        ((tp)localObject).cdQ.result = paramInt1;
        ((tp)localObject).cdQ.intent = paramIntent;
        this.mTN.a((com.tencent.mm.sdk.b.b)localObject);
        return;
      } while (this.mTM == null);
      this.mTM.q(0, 0, "");
      return;
      this.fyk.showDialog(-10002);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new i(this.mTL.mRR, this.mTL.mRY), 0);
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    this.mTL.R(paramIntent);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(new j(this.mTL.bsd(), fzn), 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.MallProductUI", "errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.product.b.h))
      {
        paramm = (com.tencent.mm.plugin.product.b.h)paramm;
        this.mTL.a(paramm.mSl, paramm.mSm);
        if (this.mTM != null) {
          this.mTM.q(paramInt1, paramInt2, paramString);
        }
        if (!bk.bl(paramm.mSl.mSq)) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11007, new Object[] { this.mTL.brW(), paramm.mSl.mSq, Integer.valueOf(fzn), Integer.valueOf(1) });
        }
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            com.tencent.mm.plugin.report.service.h.nFQ.f(11007, new Object[] { this.mTL.brW(), paramm.mSk, Integer.valueOf(fzn), Integer.valueOf(1) });
            return;
            Object localObject2;
            Object localObject1;
            if ((paramm instanceof j))
            {
              localObject2 = (j)paramm;
              paramString = this.mTL;
              paramm = ((j)localObject2).mRR;
              localObject1 = ((j)localObject2).mSc;
              localObject2 = ((j)localObject2).mSd;
              paramString.mRR = paramm;
              paramString.mSd = ((LinkedList)localObject2);
              paramString.mSc = ((LinkedList)localObject1);
              paramString.vM(0);
              this.fyk.startActivity(new Intent(this.fyk, MallProductSubmitUI.class));
              com.tencent.mm.plugin.report.service.h.nFQ.f(11009, new Object[] { this.mTL.brW(), this.mTL.mRP.mSq, Integer.valueOf(fzn), Integer.valueOf(1) });
              return;
            }
            if (!(paramm instanceof com.tencent.mm.plugin.product.b.f))
            {
              if ((paramm instanceof l))
              {
                paramString = ((l)paramm).mSp;
                paramInt1 = 6;
                if (fzn == 7) {
                  paramInt1 = 1001;
                }
                y.d("MicroMsg.MallProductUI", "payScene:" + paramInt1);
                com.tencent.mm.pluginsdk.wallet.h.a(this.fyk, paramString, this.mTL.getAppId(), paramInt1, 3);
                com.tencent.mm.sdk.b.a.udP.c(this.mTN);
                return;
              }
              if ((paramm instanceof k))
              {
                com.tencent.mm.ui.base.h.bC(this.fyk, this.fyk.getString(a.i.mall_product_submit_buy_free));
                bso();
                return;
              }
              if ((paramm instanceof com.tencent.mm.plugin.product.b.g)) {
                try
                {
                  this.fyk.dismissDialog(-10002);
                  paramString = this.mTL;
                  paramString.mSc = ((com.tencent.mm.plugin.product.b.g)paramm).mSc;
                  paramString.vM(0);
                  return;
                }
                catch (Exception paramString)
                {
                  for (;;)
                  {
                    y.e("MicroMsg.MallProductUI", paramString.toString());
                  }
                }
              }
              if ((paramm instanceof i)) {
                try
                {
                  this.fyk.dismissDialog(-10002);
                  localObject2 = (i)paramm;
                  paramm = this.mTL;
                  localObject1 = ((i)localObject2).mUrl;
                  localObject2 = ((i)localObject2).mSn;
                  if ((!bk.bl((String)localObject1)) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
                  {
                    if (paramm.mSg == null) {
                      paramm.mSg = new HashMap();
                    }
                    paramm.mSg.put(localObject1, localObject2);
                  }
                  if (this.mTM != null)
                  {
                    this.mTM.q(paramInt1, paramInt2, paramString);
                    return;
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    y.e("MicroMsg.MallProductUI", localException.toString());
                  }
                }
              }
            }
          }
          switch (paramInt2)
          {
          default: 
            y.i("MicroMsg.MallProductUI", "unkown errCode " + paramInt2);
            paramm = paramString;
            if (bk.bl(paramString)) {
              paramm = paramInt2 + " : " + this.fyk.getString(a.i.mall_product_data_err);
            }
            break;
          }
        } while (this.mTM == null);
        this.mTM.q(paramInt1, paramInt2, paramm);
        return;
        y.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
      } while (!(paramm instanceof com.tencent.mm.plugin.product.b.h));
      paramm = (com.tencent.mm.plugin.product.b.h)paramm;
      this.mTL.a(paramm.mSl, paramm.mSm);
    } while (this.mTM == null);
    this.mTM.q(paramInt1, paramInt2, paramString);
  }
  
  public final void onStart()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(553, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(554, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(555, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(556, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(557, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(578, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(579, this);
  }
  
  public final void onStop()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(553, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(554, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(555, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(556, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(557, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(578, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(579, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f
 * JD-Core Version:    0.7.0.1
 */