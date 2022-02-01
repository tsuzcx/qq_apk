package com.tencent.mm.wallet_core.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.w;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class i
  implements com.tencent.mm.am.h, e
{
  private f Ktp;
  private a agTT;
  private b agTU;
  public HashMap<Integer, c> agTV;
  public Bundle mBundle;
  private Context mContext;
  public String mProcessName;
  public HashSet<p> qhX;
  public HashSet<p> qhY;
  private Set<Integer> qhZ;
  public Dialog tipDialog;
  
  public i(Context paramContext, f paramf)
  {
    AppMethodBeat.i(72863);
    this.Ktp = null;
    this.qhX = new HashSet();
    this.qhY = new HashSet();
    this.tipDialog = null;
    this.qhZ = new HashSet();
    this.mContext = paramContext;
    this.Ktp = paramf;
    this.agTT = new a(this);
    this.agTU = new b(this);
    this.agTV = new HashMap();
    AppMethodBeat.o(72863);
  }
  
  private void closeTipDialog()
  {
    AppMethodBeat.i(72873);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(72873);
  }
  
  private boolean j(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72871);
    Log.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", new Object[] { this, paramp.toString() });
    Log.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(z.pDm) });
    if ((z.pDm) && ((paramp instanceof n)) && (!((n)paramp).getHasRetried()) && (!((n)paramp).ifV()))
    {
      paramString = (n)paramp;
      Log.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
      this.agTT.a(paramString);
      AppMethodBeat.o(72871);
      return true;
    }
    if ((paramp instanceof ITenpaySave))
    {
      paramString = (ITenpaySave)paramp;
      if ((paramString instanceof ITenpaySave))
      {
        paramString = paramString.getRetryPayInfo();
        if ((paramString != null) && (paramString.gtp())) {
          b.retryPayInfo = paramString;
        }
      }
    }
    boolean bool1;
    if ((paramp instanceof n))
    {
      if (((n)paramp).getHasRetried())
      {
        Log.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", new Object[] { paramp });
        AppMethodBeat.o(72871);
        return false;
      }
      if ((((n)paramp).ifV()) && ((paramp instanceof com.tencent.mm.wallet_core.tenpay.model.a)))
      {
        bool2 = ((n)paramp).canPayRetry();
        if (!((n)paramp).checkRecSrvResp()) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool2) && (!bool1)) {
            break label373;
          }
          paramString = (com.tencent.mm.wallet_core.tenpay.model.a)paramp;
          if ((paramString instanceof com.tencent.mm.wallet_core.tenpay.model.a))
          {
            paramString = paramString.getRetryPayInfo();
            if ((paramString != null) && (paramString.gtp())) {
              b.retryPayInfo = paramString;
            }
          }
          if (!this.agTU.c((n)paramp)) {
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
    int i = paramp.getType();
    if (this.agTV != null)
    {
      paramString = (c)this.agTV.get(Integer.valueOf(i));
      if ((paramp instanceof d))
      {
        if (((d)paramp).getHasRetried())
        {
          AppMethodBeat.o(72871);
          return false;
        }
        d locald = (d)paramp;
        Log.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", new Object[] { locald });
        paramString.agTQ = locald;
        if (paramString.a(paramInt1, paramInt2, locald))
        {
          AppMethodBeat.o(72871);
          return true;
        }
      }
    }
    if (!(paramp instanceof n))
    {
      AppMethodBeat.o(72871);
      return false;
    }
    if (((n)paramp).ifV())
    {
      AppMethodBeat.o(72871);
      return false;
    }
    if (((n)paramp).getHasRetried())
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
      AppMethodBeat.o(72871);
      return false;
    }
    paramString = (n)paramp;
    paramp = this.agTT;
    paramInt1 = u.iiC().mRetryCount;
    Log.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(paramString.jPj()), Integer.valueOf(paramp.agTO) });
    if ((paramString.jPj()) && (paramp.agTO < paramInt1))
    {
      bool1 = true;
      if (paramString.checkRecSrvResp()) {
        break label732;
      }
    }
    label732:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      com.tencent.mm.plugin.report.service.h.OAn.p(965L, 13L, 1L);
      if (bool2) {
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 14L, 1L);
      }
      if ((!bool1) && (!bool2)) {
        break label738;
      }
      Log.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", new Object[] { this });
      this.agTT.a(paramString);
      AppMethodBeat.o(72871);
      return true;
      bool1 = false;
      break;
    }
    label738:
    AppMethodBeat.o(72871);
    return false;
  }
  
  private void onDestroy()
  {
    AppMethodBeat.i(72875);
    forceCancel();
    this.Ktp = null;
    this.mContext = null;
    this.agTT.destory();
    this.agTU.destory();
    Iterator localIterator = this.agTV.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).hoB();
    }
    this.agTV.clear();
    AppMethodBeat.o(72875);
  }
  
  private void s(p paramp)
  {
    AppMethodBeat.i(72876);
    if ((paramp != null) && ((paramp instanceof w)))
    {
      ((w)paramp).setProcessName(this.mProcessName);
      if (this.mBundle != null)
      {
        ((w)paramp).setProcessBundle(this.mBundle);
        AppMethodBeat.o(72876);
        return;
      }
      if ((this.mContext instanceof WalletBaseUI)) {
        ((w)paramp).setProcessBundle(((WalletBaseUI)this.mContext).getInput());
      }
    }
    AppMethodBeat.o(72876);
  }
  
  public final void a(p paramp, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(72865);
    a(paramp, paramBoolean, paramInt, 0);
    AppMethodBeat.o(72865);
  }
  
  public final void a(p paramp, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72866);
    int i = paramp.getType();
    boolean bool2 = paramp instanceof j;
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s", new Object[] { this, Boolean.valueOf(paramBoolean), paramp, Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      s(paramp);
      this.qhY.add(paramp);
      if ((!paramBoolean) || ((this.tipDialog != null) && ((this.tipDialog == null) || (this.tipDialog.isShowing())))) {
        break label221;
      }
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      if (this.mContext != null) {
        break;
      }
      Log.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
      AppMethodBeat.o(72866);
      return;
    }
    if (paramInt1 == 1) {
      if ((paramp instanceof j))
      {
        this.tipDialog = l.a(this.mContext, false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72856);
            if ((i.b(i.this) != null) && (i.c(i.this).isEmpty()))
            {
              i.b(i.this).dismiss();
              paramAnonymousDialogInterface = i.d(i.this).iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                p localp = (p)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baD().mCm.a(localp);
              }
              i.d(i.this).clear();
            }
            AppMethodBeat.o(72856);
          }
        });
        label221:
        if ((z.pDm) && ((paramp instanceof m)) && ((((m)paramp).getUri().contains("authen")) || (((m)paramp).getUri().contains("verify")))) {
          ((m)paramp).setFake();
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(paramp, paramInt2);
        if (paramp.getReqResp() != null) {
          break label560;
        }
      }
    }
    label560:
    for (Object localObject = "";; localObject = paramp.getReqResp().getUri())
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "this %s scene url %s %s", new Object[] { this, paramp, localObject });
      AppMethodBeat.o(72866);
      return;
      localObject = this.mContext;
      this.mContext.getString(a.i.app_empty_string);
      this.tipDialog = k.a((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72857);
          if ((i.b(i.this) != null) && (i.c(i.this).isEmpty()))
          {
            i.b(i.this).dismiss();
            paramAnonymousDialogInterface = i.d(i.this).iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              p localp = (p)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(localp);
            }
            i.d(i.this).clear();
          }
          AppMethodBeat.o(72857);
        }
      });
      break;
      if (paramInt1 == 2)
      {
        localObject = this.mContext;
        this.mContext.getString(a.i.app_empty_string);
        this.tipDialog = k.a((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72858);
            if ((i.b(i.this) != null) && (i.c(i.this).isEmpty()))
            {
              i.b(i.this).dismiss();
              paramAnonymousDialogInterface = i.d(i.this).iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                p localp = (p)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baD().mCm.a(localp);
              }
              i.d(i.this).clear();
            }
            AppMethodBeat.o(72858);
          }
        });
        break;
      }
      if (paramInt1 == 3)
      {
        this.tipDialog = l.a(this.mContext, "验证中", new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72859);
            if ((i.b(i.this) != null) && (i.c(i.this).isEmpty()))
            {
              i.b(i.this).dismiss();
              paramAnonymousDialogInterface = i.d(i.this).iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                p localp = (p)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baD().mCm.a(localp);
              }
              i.d(i.this).clear();
            }
            AppMethodBeat.o(72859);
          }
        });
        break;
      }
      if (paramInt1 == 4)
      {
        this.tipDialog = l.a(this.mContext, false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(72860);
            if ((i.b(i.this) != null) && (i.c(i.this).isEmpty()))
            {
              i.b(i.this).dismiss();
              paramAnonymousDialogInterface = i.d(i.this).iterator();
              while (paramAnonymousDialogInterface.hasNext())
              {
                p localp = (p)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baD().mCm.a(localp);
              }
              i.d(i.this).clear();
            }
            AppMethodBeat.o(72860);
          }
        });
        break;
      }
      Log.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", new Object[] { Integer.valueOf(paramInt1) });
      localObject = this.mContext;
      this.mContext.getString(a.i.app_empty_string);
      this.tipDialog = k.a((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72861);
          if ((i.b(i.this) != null) && (i.c(i.this).isEmpty()))
          {
            i.b(i.this).dismiss();
            paramAnonymousDialogInterface = i.d(i.this).iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              p localp = (p)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(localp);
            }
            i.d(i.this).clear();
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
    this.qhZ.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramInt, this);
    AppMethodBeat.o(72868);
  }
  
  public final void b(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(72864);
    s(paramp);
    this.qhX.add(paramp);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      if (this.mContext == null)
      {
        Log.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", new Object[] { this });
        AppMethodBeat.o(72864);
        return;
      }
      this.tipDialog = l.a(this.mContext, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72855);
          i.this.forceCancel();
          AppMethodBeat.o(72855);
        }
      });
    }
    if ((z.pDm) && ((paramp instanceof m)) && ((((m)paramp).getUri().contains("authen")) || (((m)paramp).getUri().contains("verify")))) {
      ((m)paramp).setFake();
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramp, 0);
    AppMethodBeat.o(72864);
  }
  
  public final void fXe()
  {
    AppMethodBeat.i(185689);
    closeTipDialog();
    AppMethodBeat.o(185689);
  }
  
  public final void forceCancel()
  {
    AppMethodBeat.i(72867);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    Iterator localIterator = this.qhX.iterator();
    p localp;
    while (localIterator.hasNext())
    {
      localp = (p)localIterator.next();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(localp);
    }
    localIterator = this.qhY.iterator();
    while (localIterator.hasNext())
    {
      localp = (p)localIterator.next();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(localp);
    }
    this.qhX.clear();
    this.qhY.clear();
    AppMethodBeat.o(72867);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(72874);
    if ((this.qhY.isEmpty()) && (this.qhX.isEmpty()))
    {
      AppMethodBeat.o(72874);
      return false;
    }
    AppMethodBeat.o(72874);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72872);
    int i;
    if (this.qhY.contains(paramp))
    {
      Log.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", new Object[] { this });
      if (!j(paramInt1, paramInt2, paramString, paramp))
      {
        Log.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
        this.qhY.remove(paramp);
        i = 1;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", new Object[] { this, Integer.valueOf(this.qhY.size()), Integer.valueOf(this.qhX.size()) });
      if ((this.qhY.isEmpty()) && (this.qhX.isEmpty())) {
        closeTipDialog();
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.Ktp != null)) {
          this.Ktp.onSceneEnd(paramInt1, paramInt2, paramString, paramp, bool);
        }
        AppMethodBeat.o(72872);
        return;
        Log.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        AppMethodBeat.o(72872);
        return;
        if (!this.qhX.contains(paramp)) {
          break label303;
        }
        Log.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", new Object[] { this });
        if (!j(paramInt1, paramInt2, paramString, paramp))
        {
          this.qhX.remove(paramp);
          Log.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
          i = 1;
          break;
        }
        Log.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(paramInt, this);
    this.qhZ.remove(Integer.valueOf(paramInt));
    if (this.qhZ.isEmpty()) {
      onDestroy();
    }
    AppMethodBeat.o(72869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */