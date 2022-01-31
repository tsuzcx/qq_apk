package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i
  implements com.tencent.mm.ah.f, e
{
  public Bundle BX;
  public String dIA;
  public HashSet<com.tencent.mm.ah.m> fti = new HashSet();
  public HashSet<com.tencent.mm.ah.m> ftj = new HashSet();
  public Dialog ftk = null;
  private Set<Integer> fty = new HashSet();
  private f lQE = null;
  public Context mContext;
  private a wBf;
  private b wBg;
  public HashMap<Integer, c> wBh;
  
  public i(Context paramContext, f paramf)
  {
    this.mContext = paramContext;
    this.lQE = paramf;
    this.wBf = new a(this);
    this.wBg = new b(this);
    this.wBh = new HashMap();
  }
  
  private boolean l(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    boolean bool3 = false;
    y.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", new Object[] { this, paramm.toString() });
    y.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(ae.eTK) });
    if ((ae.eTK) && ((paramm instanceof k)) && (!((k)paramm).nyn) && (!((k)paramm).bTR()))
    {
      paramString = (k)paramm;
      y.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
      this.wBf.b(paramString);
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if ((paramm instanceof ITenpaySave))
          {
            paramString = (ITenpaySave)paramm;
            if ((paramString instanceof ITenpaySave))
            {
              paramString = paramString.bTh();
              if ((paramString != null) && (paramString.cMW())) {
                b.qfp = paramString;
              }
            }
          }
          if ((paramm instanceof k))
          {
            if (((k)paramm).nyn)
            {
              y.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", new Object[] { paramm });
              return false;
            }
            if ((((k)paramm).bTR()) && ((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.a)))
            {
              bool1 = ((k)paramm).wBG;
              if (!((k)paramm).wAF) {}
              for (bool2 = true;; bool2 = false)
              {
                y.i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
                if (!bool1)
                {
                  bool1 = bool3;
                  if (!bool2) {
                    break;
                  }
                }
                bool1 = bool3;
                if (!this.wBg.d((k)paramm)) {
                  break;
                }
                return true;
              }
            }
          }
          int i = paramm.getType();
          if (this.wBh == null) {
            break;
          }
          paramString = (c)this.wBh.get(Integer.valueOf(i));
          if (!(paramm instanceof d)) {
            break;
          }
          bool1 = bool3;
        } while (((d)paramm).bwg());
        d locald = (d)paramm;
        y.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", new Object[] { locald });
        paramString.wBc = locald;
        if (paramString.a(paramInt1, paramInt2, locald)) {
          return true;
        }
        bool1 = bool3;
      } while (!(paramm instanceof k));
      bool1 = bool3;
    } while (((k)paramm).bTR());
    if (((k)paramm).nyn)
    {
      y.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
      return false;
    }
    paramString = (k)paramm;
    boolean bool1 = this.wBf.a(paramString);
    if (!paramString.wAF) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      y.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (!bool1)
      {
        bool1 = bool3;
        if (!bool2) {
          break;
        }
      }
      y.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", new Object[] { this });
      this.wBf.b(paramString);
      return true;
    }
  }
  
  private void q(com.tencent.mm.ah.m paramm)
  {
    if ((paramm != null) && ((paramm instanceof s)))
    {
      ((s)paramm).dIA = this.dIA;
      if (this.BX == null) {
        break label41;
      }
      ((s)paramm).BX = this.BX;
    }
    label41:
    while (!(this.mContext instanceof WalletBaseUI)) {
      return;
    }
    ((s)paramm).BX = ((WalletBaseUI)this.mContext).BX;
  }
  
  public final void a(com.tencent.mm.ah.m paramm, boolean paramBoolean)
  {
    q(paramm);
    this.fti.add(paramm);
    if ((paramBoolean) && ((this.ftk == null) || ((this.ftk != null) && (!this.ftk.isShowing()))))
    {
      if (this.ftk != null) {
        this.ftk.dismiss();
      }
      if (this.mContext == null)
      {
        y.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", new Object[] { this });
        return;
      }
      this.ftk = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new i.1(this));
    }
    if ((ae.eTK) && ((paramm instanceof j)) && ((((j)paramm).getUri().contains("authen")) || (((j)paramm).getUri().contains("verify")))) {
      ((j)paramm).cMY();
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramm, 0);
  }
  
  public final void a(com.tencent.mm.ah.m paramm, boolean paramBoolean, int paramInt)
  {
    a(paramm, paramBoolean, paramInt, 0);
  }
  
  public final void a(com.tencent.mm.ah.m paramm, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = paramm.getType();
    boolean bool2 = paramm instanceof com.tencent.mm.wallet_core.c.g;
    if ((this.ftk == null) || ((this.ftk != null) && (!this.ftk.isShowing()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.WalletNetSceneMgr", "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s", new Object[] { this, Boolean.valueOf(paramBoolean), paramm, Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      q(paramm);
      this.ftj.add(paramm);
      if ((!paramBoolean) || ((this.ftk != null) && ((this.ftk == null) || (this.ftk.isShowing())))) {
        break label209;
      }
      if (this.ftk != null) {
        this.ftk.dismiss();
      }
      if (this.mContext != null) {
        break;
      }
      y.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
      return;
    }
    if (paramInt1 == 1) {
      if ((paramm instanceof com.tencent.mm.wallet_core.c.g))
      {
        this.ftk = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new i.2(this));
        label209:
        if ((ae.eTK) && ((paramm instanceof j)) && ((((j)paramm).getUri().contains("authen")) || (((j)paramm).getUri().contains("verify")))) {
          ((j)paramm).cMY();
        }
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(paramm, paramInt2);
        if (paramm.edi != null) {
          break label541;
        }
      }
    }
    label541:
    for (Object localObject = "";; localObject = paramm.edi.getUri())
    {
      y.i("MicroMsg.WalletNetSceneMgr", "this %s scene url %s %s", new Object[] { this, paramm, localObject });
      return;
      localObject = this.mContext;
      this.mContext.getString(a.i.app_empty_string);
      this.ftk = h.b((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new i.3(this));
      break;
      if (paramInt1 == 2)
      {
        localObject = this.mContext;
        this.mContext.getString(a.i.app_empty_string);
        this.ftk = h.b((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new i.4(this));
        break;
      }
      if (paramInt1 == 3)
      {
        this.ftk = com.tencent.mm.wallet_core.ui.g.e(this.mContext, "验证中", new i.5(this));
        break;
      }
      if (paramInt1 == 4)
      {
        this.ftk = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new i.6(this));
        break;
      }
      y.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", new Object[] { Integer.valueOf(paramInt1) });
      localObject = this.mContext;
      this.mContext.getString(a.i.app_empty_string);
      this.ftk = h.b((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new i.7(this));
      break;
    }
  }
  
  public final void bTT()
  {
    if (this.ftk != null)
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
  }
  
  public final void bfH()
  {
    if (this.ftk != null)
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
    Iterator localIterator = this.fti.iterator();
    com.tencent.mm.ah.m localm;
    while (localIterator.hasNext())
    {
      localm = (com.tencent.mm.ah.m)localIterator.next();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.c(localm);
    }
    localIterator = this.ftj.iterator();
    while (localIterator.hasNext())
    {
      localm = (com.tencent.mm.ah.m)localIterator.next();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.c(localm);
    }
    this.fti.clear();
    this.ftj.clear();
  }
  
  public final boolean bfI()
  {
    return (!this.ftj.isEmpty()) || (!this.fti.isEmpty());
  }
  
  public final void bfJ()
  {
    bTT();
  }
  
  public final void kh(int paramInt)
  {
    this.fty.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramInt, this);
  }
  
  public final void ki(int paramInt)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(paramInt, this);
    this.fty.remove(Integer.valueOf(paramInt));
    if (this.fty.isEmpty())
    {
      bfH();
      this.lQE = null;
      this.mContext = null;
      Object localObject = this.wBf;
      ((a)localObject).wBb = null;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(385, (com.tencent.mm.ah.f)localObject);
      localObject = this.wBg;
      ((b)localObject).wBb = null;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(385, (com.tencent.mm.ah.f)localObject);
      localObject = this.wBh.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        y.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(localc.rtType) });
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.b(localc.rtType, localc);
      }
      this.wBh.clear();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    int i;
    if (this.ftj.contains(paramm))
    {
      y.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", new Object[] { this });
      if (!l(paramInt1, paramInt2, paramString, paramm))
      {
        y.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
        this.ftj.remove(paramm);
        i = 1;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", new Object[] { this, Integer.valueOf(this.ftj.size()), Integer.valueOf(this.fti.size()) });
      if ((this.ftj.isEmpty()) && (this.fti.isEmpty())) {
        bTT();
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.lQE != null)) {
          this.lQE.b(paramInt1, paramInt2, paramString, paramm, bool);
        }
        return;
        y.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        return;
        if (!this.fti.contains(paramm)) {
          break label279;
        }
        y.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", new Object[] { this });
        if (!l(paramInt1, paramInt2, paramString, paramm))
        {
          this.fti.remove(paramm);
          y.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
          i = 1;
          break;
        }
        y.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        return;
      }
      label279:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.i
 * JD-Core Version:    0.7.0.1
 */