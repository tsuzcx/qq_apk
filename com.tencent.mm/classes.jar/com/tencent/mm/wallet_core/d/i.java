package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i
  implements com.tencent.mm.ai.f, e
{
  private a AXD;
  private b AXE;
  public HashMap<Integer, c> AXF;
  public HashSet<com.tencent.mm.ai.m> gKK;
  public HashSet<com.tencent.mm.ai.m> gKL;
  public Dialog gKM;
  private Set<Integer> gLa;
  public Bundle mBundle;
  public Context mContext;
  public String mProcessName;
  private f oou;
  
  public i(Context paramContext, f paramf)
  {
    AppMethodBeat.i(49147);
    this.oou = null;
    this.gKK = new HashSet();
    this.gKL = new HashSet();
    this.gKM = null;
    this.gLa = new HashSet();
    this.mContext = paramContext;
    this.oou = paramf;
    this.AXD = new a(this);
    this.AXE = new b(this);
    this.AXF = new HashMap();
    AppMethodBeat.o(49147);
  }
  
  private boolean i(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(49155);
    ab.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", new Object[] { this, paramm.toString() });
    ab.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(ae.glF) });
    if ((ae.glF) && ((paramm instanceof n)) && (!((n)paramm).getHasRetried()) && (!((n)paramm).cRN()))
    {
      paramString = (n)paramm;
      ab.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
      this.AXD.a(paramString);
      AppMethodBeat.o(49155);
      return true;
    }
    if ((paramm instanceof ITenpaySave))
    {
      paramString = (ITenpaySave)paramm;
      if ((paramString instanceof ITenpaySave))
      {
        paramString = paramString.getRetryPayInfo();
        if ((paramString != null) && (paramString.bWX())) {
          b.retryPayInfo = paramString;
        }
      }
    }
    boolean bool1;
    if ((paramm instanceof n))
    {
      if (((n)paramm).getHasRetried())
      {
        ab.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", new Object[] { paramm });
        AppMethodBeat.o(49155);
        return false;
      }
      if ((((n)paramm).cRN()) && ((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.a)))
      {
        bool2 = ((n)paramm).canPayRetry();
        if (!((n)paramm).checkRecSrvResp()) {}
        for (bool1 = true;; bool1 = false)
        {
          ab.i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool2) && (!bool1)) {
            break label338;
          }
          if (!this.AXE.c((n)paramm)) {
            break;
          }
          AppMethodBeat.o(49155);
          return true;
        }
        AppMethodBeat.o(49155);
        return false;
        label338:
        AppMethodBeat.o(49155);
        return false;
      }
    }
    int i = paramm.getType();
    if (this.AXF != null)
    {
      paramString = (c)this.AXF.get(Integer.valueOf(i));
      if ((paramm instanceof d))
      {
        if (((d)paramm).getHasRetried())
        {
          AppMethodBeat.o(49155);
          return false;
        }
        d locald = (d)paramm;
        ab.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", new Object[] { locald });
        paramString.AXA = locald;
        if (paramString.a(paramInt1, paramInt2, locald))
        {
          AppMethodBeat.o(49155);
          return true;
        }
      }
    }
    if (!(paramm instanceof n))
    {
      AppMethodBeat.o(49155);
      return false;
    }
    if (((n)paramm).cRN())
    {
      AppMethodBeat.o(49155);
      return false;
    }
    if (((n)paramm).getHasRetried())
    {
      ab.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
      AppMethodBeat.o(49155);
      return false;
    }
    paramString = (n)paramm;
    paramm = this.AXD;
    paramInt1 = t.cTN().mRetryCount;
    ab.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(paramString.dSM()), Integer.valueOf(paramm.AXy) });
    if ((paramString.dSM()) && (paramm.AXy < paramInt1))
    {
      bool1 = true;
      if (paramString.checkRecSrvResp()) {
        break label696;
      }
    }
    label696:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      com.tencent.mm.plugin.report.service.h.qsU.j(965L, 13L, 1L);
      if (bool2) {
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 14L, 1L);
      }
      if ((!bool1) && (!bool2)) {
        break label702;
      }
      ab.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", new Object[] { this });
      this.AXD.a(paramString);
      AppMethodBeat.o(49155);
      return true;
      bool1 = false;
      break;
    }
    label702:
    AppMethodBeat.o(49155);
    return false;
  }
  
  private void onDestroy()
  {
    AppMethodBeat.i(49159);
    forceCancel();
    this.oou = null;
    this.mContext = null;
    this.AXD.destory();
    this.AXE.destory();
    Iterator localIterator = this.AXF.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).bOo();
    }
    this.AXF.clear();
    AppMethodBeat.o(49159);
  }
  
  private void q(com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(142660);
    if ((paramm != null) && ((paramm instanceof u)))
    {
      ((u)paramm).setProcessName(this.mProcessName);
      if (this.mBundle != null)
      {
        ((u)paramm).setProcessBundle(this.mBundle);
        AppMethodBeat.o(142660);
        return;
      }
      if ((this.mContext instanceof WalletBaseUI)) {
        ((u)paramm).setProcessBundle(((WalletBaseUI)this.mContext).getInput());
      }
    }
    AppMethodBeat.o(142660);
  }
  
  public final void a(com.tencent.mm.ai.m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(49148);
    q(paramm);
    this.gKK.add(paramm);
    if ((paramBoolean) && ((this.gKM == null) || ((this.gKM != null) && (!this.gKM.isShowing()))))
    {
      if (this.gKM != null) {
        this.gKM.dismiss();
      }
      if (this.mContext == null)
      {
        ab.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", new Object[] { this });
        AppMethodBeat.o(49148);
        return;
      }
      this.gKM = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new i.1(this));
    }
    if ((ae.glF) && ((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.m)) && ((((com.tencent.mm.wallet_core.tenpay.model.m)paramm).getUri().contains("authen")) || (((com.tencent.mm.wallet_core.tenpay.model.m)paramm).getUri().contains("verify")))) {
      ((com.tencent.mm.wallet_core.tenpay.model.m)paramm).setFake();
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramm, 0);
    AppMethodBeat.o(49148);
  }
  
  public final void a(com.tencent.mm.ai.m paramm, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(49149);
    a(paramm, paramBoolean, paramInt, 0);
    AppMethodBeat.o(49149);
  }
  
  public final void a(com.tencent.mm.ai.m paramm, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49150);
    int i = paramm.getType();
    boolean bool2 = paramm instanceof com.tencent.mm.wallet_core.c.i;
    if ((this.gKM == null) || ((this.gKM != null) && (!this.gKM.isShowing()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.WalletNetSceneMgr", "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s", new Object[] { this, Boolean.valueOf(paramBoolean), paramm, Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      q(paramm);
      this.gKL.add(paramm);
      if ((!paramBoolean) || ((this.gKM != null) && ((this.gKM == null) || (this.gKM.isShowing())))) {
        break label221;
      }
      if (this.gKM != null) {
        this.gKM.dismiss();
      }
      if (this.mContext != null) {
        break;
      }
      ab.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
      AppMethodBeat.o(49150);
      return;
    }
    if (paramInt1 == 1) {
      if ((paramm instanceof com.tencent.mm.wallet_core.c.i))
      {
        this.gKM = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new i.2(this));
        label221:
        if ((ae.glF) && ((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.m)) && ((((com.tencent.mm.wallet_core.tenpay.model.m)paramm).getUri().contains("authen")) || (((com.tencent.mm.wallet_core.tenpay.model.m)paramm).getUri().contains("verify")))) {
          ((com.tencent.mm.wallet_core.tenpay.model.m)paramm).setFake();
        }
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(paramm, paramInt2);
        if (paramm.getReqResp() != null) {
          break label560;
        }
      }
    }
    label560:
    for (Object localObject = "";; localObject = paramm.getReqResp().getUri())
    {
      ab.i("MicroMsg.WalletNetSceneMgr", "this %s scene url %s %s", new Object[] { this, paramm, localObject });
      AppMethodBeat.o(49150);
      return;
      localObject = this.mContext;
      this.mContext.getString(2131296919);
      this.gKM = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131305479), false, new i.3(this));
      break;
      if (paramInt1 == 2)
      {
        localObject = this.mContext;
        this.mContext.getString(2131296919);
        this.gKM = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131305479), false, new i.4(this));
        break;
      }
      if (paramInt1 == 3)
      {
        this.gKM = com.tencent.mm.wallet_core.ui.g.d(this.mContext, "验证中", new i.5(this));
        break;
      }
      if (paramInt1 == 4)
      {
        this.gKM = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new i.6(this));
        break;
      }
      ab.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", new Object[] { Integer.valueOf(paramInt1) });
      localObject = this.mContext;
      this.mContext.getString(2131296919);
      this.gKM = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131305479), false, new i.7(this));
      break;
    }
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(49152);
    this.gLa.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramInt, this);
    AppMethodBeat.o(49152);
  }
  
  public final void bNp()
  {
    AppMethodBeat.i(156743);
    cRP();
    AppMethodBeat.o(156743);
  }
  
  public final void cRP()
  {
    AppMethodBeat.i(49157);
    if (this.gKM != null)
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    AppMethodBeat.o(49157);
  }
  
  public final void forceCancel()
  {
    AppMethodBeat.i(49151);
    if (this.gKM != null)
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    Iterator localIterator = this.gKK.iterator();
    com.tencent.mm.ai.m localm;
    while (localIterator.hasNext())
    {
      localm = (com.tencent.mm.ai.m)localIterator.next();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(localm);
    }
    localIterator = this.gKL.iterator();
    while (localIterator.hasNext())
    {
      localm = (com.tencent.mm.ai.m)localIterator.next();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(localm);
    }
    this.gKK.clear();
    this.gKL.clear();
    AppMethodBeat.o(49151);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(49158);
    if ((this.gKL.isEmpty()) && (this.gKK.isEmpty()))
    {
      AppMethodBeat.o(49158);
      return false;
    }
    AppMethodBeat.o(49158);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(49156);
    int i;
    if (this.gKL.contains(paramm))
    {
      ab.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", new Object[] { this });
      if (!i(paramInt1, paramInt2, paramString, paramm))
      {
        ab.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
        this.gKL.remove(paramm);
        i = 1;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", new Object[] { this, Integer.valueOf(this.gKL.size()), Integer.valueOf(this.gKK.size()) });
      if ((this.gKL.isEmpty()) && (this.gKK.isEmpty())) {
        cRP();
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.oou != null)) {
          this.oou.onSceneEnd(paramInt1, paramInt2, paramString, paramm, bool);
        }
        AppMethodBeat.o(49156);
        return;
        ab.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        AppMethodBeat.o(49156);
        return;
        if (!this.gKK.contains(paramm)) {
          break label303;
        }
        ab.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", new Object[] { this });
        if (!i(paramInt1, paramInt2, paramString, paramm))
        {
          this.gKK.remove(paramm);
          ab.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
          i = 1;
          break;
        }
        ab.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        AppMethodBeat.o(49156);
        return;
      }
      label303:
      i = 0;
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(49153);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(paramInt, this);
    this.gLa.remove(Integer.valueOf(paramInt));
    if (this.gLa.isEmpty()) {
      onDestroy();
    }
    AppMethodBeat.o(49153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.i
 * JD-Core Version:    0.7.0.1
 */