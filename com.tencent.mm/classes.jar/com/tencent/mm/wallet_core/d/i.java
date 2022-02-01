package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i
  implements com.tencent.mm.ak.f, e
{
  private a LVL;
  private b LVM;
  public HashMap<Integer, c> LVN;
  public HashSet<com.tencent.mm.ak.n> juA;
  private Set<Integer> juP;
  public HashSet<com.tencent.mm.ak.n> juz;
  public Bundle mBundle;
  public Context mContext;
  public String mProcessName;
  public Dialog tipDialog;
  private f vBy;
  
  public i(Context paramContext, f paramf)
  {
    AppMethodBeat.i(72863);
    this.vBy = null;
    this.juz = new HashSet();
    this.juA = new HashSet();
    this.tipDialog = null;
    this.juP = new HashSet();
    this.mContext = paramContext;
    this.vBy = paramf;
    this.LVL = new a(this);
    this.LVM = new b(this);
    this.LVN = new HashMap();
    AppMethodBeat.o(72863);
  }
  
  private boolean k(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72871);
    ae.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", new Object[] { this, paramn.toString() });
    ae.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(ac.iSH) });
    if ((ac.iSH) && ((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n)) && (!((com.tencent.mm.wallet_core.tenpay.model.n)paramn).getHasRetried()) && (!((com.tencent.mm.wallet_core.tenpay.model.n)paramn).eHd()))
    {
      paramString = (com.tencent.mm.wallet_core.tenpay.model.n)paramn;
      ae.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
      this.LVL.a(paramString);
      AppMethodBeat.o(72871);
      return true;
    }
    if ((paramn instanceof ITenpaySave))
    {
      paramString = (ITenpaySave)paramn;
      if ((paramString instanceof ITenpaySave))
      {
        paramString = paramString.getRetryPayInfo();
        if ((paramString != null) && (paramString.dxN())) {
          b.retryPayInfo = paramString;
        }
      }
    }
    boolean bool1;
    if ((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n))
    {
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).getHasRetried())
      {
        ae.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", new Object[] { paramn });
        AppMethodBeat.o(72871);
        return false;
      }
      if ((((com.tencent.mm.wallet_core.tenpay.model.n)paramn).eHd()) && ((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.a)))
      {
        bool2 = ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).canPayRetry();
        if (!((com.tencent.mm.wallet_core.tenpay.model.n)paramn).checkRecSrvResp()) {}
        for (bool1 = true;; bool1 = false)
        {
          ae.i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool2) && (!bool1)) {
            break label373;
          }
          paramString = (com.tencent.mm.wallet_core.tenpay.model.a)paramn;
          if ((paramString instanceof com.tencent.mm.wallet_core.tenpay.model.a))
          {
            paramString = paramString.getRetryPayInfo();
            if ((paramString != null) && (paramString.dxN())) {
              b.retryPayInfo = paramString;
            }
          }
          if (!this.LVM.c((com.tencent.mm.wallet_core.tenpay.model.n)paramn)) {
            break;
          }
          AppMethodBeat.o(72871);
          return true;
        }
        AppMethodBeat.o(72871);
        return false;
        label373:
        AppMethodBeat.o(72871);
        return false;
      }
    }
    int i = paramn.getType();
    if (this.LVN != null)
    {
      paramString = (c)this.LVN.get(Integer.valueOf(i));
      if ((paramn instanceof d))
      {
        if (((d)paramn).getHasRetried())
        {
          AppMethodBeat.o(72871);
          return false;
        }
        d locald = (d)paramn;
        ae.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", new Object[] { locald });
        paramString.LVI = locald;
        if (paramString.a(paramInt1, paramInt2, locald))
        {
          AppMethodBeat.o(72871);
          return true;
        }
      }
    }
    if (!(paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n))
    {
      AppMethodBeat.o(72871);
      return false;
    }
    if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).eHd())
    {
      AppMethodBeat.o(72871);
      return false;
    }
    if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).getHasRetried())
    {
      ae.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
      AppMethodBeat.o(72871);
      return false;
    }
    paramString = (com.tencent.mm.wallet_core.tenpay.model.n)paramn;
    paramn = this.LVL;
    paramInt1 = t.eJf().mRetryCount;
    ae.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(paramString.fWp()), Integer.valueOf(paramn.LVG) });
    if ((paramString.fWp()) && (paramn.LVG < paramInt1))
    {
      bool1 = true;
      if (paramString.checkRecSrvResp()) {
        break label731;
      }
    }
    label731:
    for (boolean bool2 = true;; bool2 = false)
    {
      ae.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      com.tencent.mm.plugin.report.service.g.yxI.n(965L, 13L, 1L);
      if (bool2) {
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 14L, 1L);
      }
      if ((!bool1) && (!bool2)) {
        break label737;
      }
      ae.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", new Object[] { this });
      this.LVL.a(paramString);
      AppMethodBeat.o(72871);
      return true;
      bool1 = false;
      break;
    }
    label737:
    AppMethodBeat.o(72871);
    return false;
  }
  
  private void onDestroy()
  {
    AppMethodBeat.i(72875);
    forceCancel();
    this.vBy = null;
    this.mContext = null;
    this.LVL.destory();
    this.LVM.destory();
    Iterator localIterator = this.LVN.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).efC();
    }
    this.LVN.clear();
    AppMethodBeat.o(72875);
  }
  
  private void q(com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72876);
    if ((paramn != null) && ((paramn instanceof w)))
    {
      ((w)paramn).setProcessName(this.mProcessName);
      if (this.mBundle != null)
      {
        ((w)paramn).setProcessBundle(this.mBundle);
        AppMethodBeat.o(72876);
        return;
      }
      if ((this.mContext instanceof WalletBaseUI)) {
        ((w)paramn).setProcessBundle(((WalletBaseUI)this.mContext).getInput());
      }
    }
    AppMethodBeat.o(72876);
  }
  
  public final void a(com.tencent.mm.ak.n paramn, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(72865);
    a(paramn, paramBoolean, paramInt, 0);
    AppMethodBeat.o(72865);
  }
  
  public final void a(com.tencent.mm.ak.n paramn, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72866);
    int i = paramn.getType();
    boolean bool2 = paramn instanceof j;
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.WalletNetSceneMgr", "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s", new Object[] { this, Boolean.valueOf(paramBoolean), paramn, Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      q(paramn);
      this.juA.add(paramn);
      if ((!paramBoolean) || ((this.tipDialog != null) && ((this.tipDialog == null) || (this.tipDialog.isShowing())))) {
        break label221;
      }
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      if (this.mContext != null) {
        break;
      }
      ae.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
      AppMethodBeat.o(72866);
      return;
    }
    if (paramInt1 == 1) {
      if ((paramn instanceof j))
      {
        this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(this.mContext, false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72856);
            if ((i.this.tipDialog != null) && (i.this.juz.isEmpty()))
            {
              i.this.tipDialog.dismiss();
              paramAnonymousDialogInterface = i.this.juA.iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                com.tencent.mm.ak.n localn = (com.tencent.mm.ak.n)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
              }
              i.this.juA.clear();
            }
            AppMethodBeat.o(72856);
          }
        });
        label221:
        if ((ac.iSH) && ((paramn instanceof m)) && ((((m)paramn).getUri().contains("authen")) || (((m)paramn).getUri().contains("verify")))) {
          ((m)paramn).setFake();
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramn, paramInt2);
        if (paramn.getReqResp() != null) {
          break label560;
        }
      }
    }
    label560:
    for (Object localObject = "";; localObject = paramn.getReqResp().getUri())
    {
      ae.i("MicroMsg.WalletNetSceneMgr", "this %s scene url %s %s", new Object[] { this, paramn, localObject });
      AppMethodBeat.o(72866);
      return;
      localObject = this.mContext;
      this.mContext.getString(2131755726);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131765693), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72857);
          if ((i.this.tipDialog != null) && (i.this.juz.isEmpty()))
          {
            i.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = i.this.juA.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              com.tencent.mm.ak.n localn = (com.tencent.mm.ak.n)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
            }
            i.this.juA.clear();
          }
          AppMethodBeat.o(72857);
        }
      });
      break;
      if (paramInt1 == 2)
      {
        localObject = this.mContext;
        this.mContext.getString(2131755726);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131765693), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72858);
            if ((i.this.tipDialog != null) && (i.this.juz.isEmpty()))
            {
              i.this.tipDialog.dismiss();
              paramAnonymousDialogInterface = i.this.juA.iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                com.tencent.mm.ak.n localn = (com.tencent.mm.ak.n)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
              }
              i.this.juA.clear();
            }
            AppMethodBeat.o(72858);
          }
        });
        break;
      }
      if (paramInt1 == 3)
      {
        this.tipDialog = com.tencent.mm.wallet_core.ui.h.c(this.mContext, "验证中", new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72859);
            if ((i.this.tipDialog != null) && (i.this.juz.isEmpty()))
            {
              i.this.tipDialog.dismiss();
              paramAnonymousDialogInterface = i.this.juA.iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                com.tencent.mm.ak.n localn = (com.tencent.mm.ak.n)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
              }
              i.this.juA.clear();
            }
            AppMethodBeat.o(72859);
          }
        });
        break;
      }
      if (paramInt1 == 4)
      {
        this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(this.mContext, false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72860);
            if ((i.this.tipDialog != null) && (i.this.juz.isEmpty()))
            {
              i.this.tipDialog.dismiss();
              paramAnonymousDialogInterface = i.this.juA.iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                com.tencent.mm.ak.n localn = (com.tencent.mm.ak.n)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
              }
              i.this.juA.clear();
            }
            AppMethodBeat.o(72860);
          }
        });
        break;
      }
      ae.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", new Object[] { Integer.valueOf(paramInt1) });
      localObject = this.mContext;
      this.mContext.getString(2131755726);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.mContext.getString(2131765693), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72861);
          if ((i.this.tipDialog != null) && (i.this.juz.isEmpty()))
          {
            i.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = i.this.juA.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              com.tencent.mm.ak.n localn = (com.tencent.mm.ak.n)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
            }
            i.this.juA.clear();
          }
          AppMethodBeat.o(72861);
        }
      });
      break;
    }
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(72868);
    this.juP.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramInt, this);
    AppMethodBeat.o(72868);
  }
  
  public final void b(com.tencent.mm.ak.n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(72864);
    q(paramn);
    this.juz.add(paramn);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      if (this.mContext == null)
      {
        ae.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", new Object[] { this });
        AppMethodBeat.o(72864);
        return;
      }
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(this.mContext, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72855);
          i.this.forceCancel();
          AppMethodBeat.o(72855);
        }
      });
    }
    if ((ac.iSH) && ((paramn instanceof m)) && ((((m)paramn).getUri().contains("authen")) || (((m)paramn).getUri().contains("verify")))) {
      ((m)paramn).setFake();
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramn, 0);
    AppMethodBeat.o(72864);
  }
  
  public final void closeTipDialog()
  {
    AppMethodBeat.i(72873);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(72873);
  }
  
  public final void dlo()
  {
    AppMethodBeat.i(224239);
    closeTipDialog();
    AppMethodBeat.o(224239);
  }
  
  public final void forceCancel()
  {
    AppMethodBeat.i(72867);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    Iterator localIterator = this.juz.iterator();
    com.tencent.mm.ak.n localn;
    while (localIterator.hasNext())
    {
      localn = (com.tencent.mm.ak.n)localIterator.next();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
    }
    localIterator = this.juA.iterator();
    while (localIterator.hasNext())
    {
      localn = (com.tencent.mm.ak.n)localIterator.next();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(localn);
    }
    this.juz.clear();
    this.juA.clear();
    AppMethodBeat.o(72867);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(72874);
    if ((this.juA.isEmpty()) && (this.juz.isEmpty()))
    {
      AppMethodBeat.o(72874);
      return false;
    }
    AppMethodBeat.o(72874);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72872);
    int i;
    if (this.juA.contains(paramn))
    {
      ae.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", new Object[] { this });
      if (!k(paramInt1, paramInt2, paramString, paramn))
      {
        ae.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
        this.juA.remove(paramn);
        i = 1;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", new Object[] { this, Integer.valueOf(this.juA.size()), Integer.valueOf(this.juz.size()) });
      if ((this.juA.isEmpty()) && (this.juz.isEmpty())) {
        closeTipDialog();
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.vBy != null)) {
          this.vBy.onSceneEnd(paramInt1, paramInt2, paramString, paramn, bool);
        }
        AppMethodBeat.o(72872);
        return;
        ae.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        AppMethodBeat.o(72872);
        return;
        if (!this.juz.contains(paramn)) {
          break label303;
        }
        ae.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", new Object[] { this });
        if (!k(paramInt1, paramInt2, paramString, paramn))
        {
          this.juz.remove(paramn);
          ae.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
          i = 1;
          break;
        }
        ae.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        AppMethodBeat.o(72872);
        return;
      }
      label303:
      i = 0;
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(72869);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(paramInt, this);
    this.juP.remove(Integer.valueOf(paramInt));
    if (this.juP.isEmpty()) {
      onDestroy();
    }
    AppMethodBeat.o(72869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.i
 * JD-Core Version:    0.7.0.1
 */