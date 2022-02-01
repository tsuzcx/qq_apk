package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class i
  implements com.tencent.mm.an.i, e
{
  private f EAz;
  private a YVZ;
  private b YWa;
  public HashMap<Integer, c> YWb;
  public Bundle mBundle;
  public Context mContext;
  public String mProcessName;
  public HashSet<q> nkO;
  public HashSet<q> nkP;
  private Set<Integer> nkQ;
  public Dialog tipDialog;
  
  public i(Context paramContext, f paramf)
  {
    AppMethodBeat.i(72863);
    this.EAz = null;
    this.nkO = new HashSet();
    this.nkP = new HashSet();
    this.tipDialog = null;
    this.nkQ = new HashSet();
    this.mContext = paramContext;
    this.EAz = paramf;
    this.YVZ = new a(this);
    this.YWa = new b(this);
    this.YWb = new HashMap();
    AppMethodBeat.o(72863);
  }
  
  private boolean k(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72871);
    Log.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", new Object[] { this, paramq.toString() });
    Log.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(ac.mGM) });
    if ((ac.mGM) && ((paramq instanceof n)) && (!((n)paramq).getHasRetried()) && (!((n)paramq).gGS()))
    {
      paramString = (n)paramq;
      Log.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
      this.YVZ.a(paramString);
      AppMethodBeat.o(72871);
      return true;
    }
    if ((paramq instanceof ITenpaySave))
    {
      paramString = (ITenpaySave)paramq;
      if ((paramString instanceof ITenpaySave))
      {
        paramString = paramString.getRetryPayInfo();
        if ((paramString != null) && (paramString.fiY())) {
          b.retryPayInfo = paramString;
        }
      }
    }
    boolean bool1;
    if ((paramq instanceof n))
    {
      if (((n)paramq).getHasRetried())
      {
        Log.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", new Object[] { paramq });
        AppMethodBeat.o(72871);
        return false;
      }
      if ((((n)paramq).gGS()) && ((paramq instanceof com.tencent.mm.wallet_core.tenpay.model.a)))
      {
        bool2 = ((n)paramq).canPayRetry();
        if (!((n)paramq).checkRecSrvResp()) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool2) && (!bool1)) {
            break label373;
          }
          paramString = (com.tencent.mm.wallet_core.tenpay.model.a)paramq;
          if ((paramString instanceof com.tencent.mm.wallet_core.tenpay.model.a))
          {
            paramString = paramString.getRetryPayInfo();
            if ((paramString != null) && (paramString.fiY())) {
              b.retryPayInfo = paramString;
            }
          }
          if (!this.YWa.c((n)paramq)) {
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
    int i = paramq.getType();
    if (this.YWb != null)
    {
      paramString = (c)this.YWb.get(Integer.valueOf(i));
      if ((paramq instanceof d))
      {
        if (((d)paramq).getHasRetried())
        {
          AppMethodBeat.o(72871);
          return false;
        }
        d locald = (d)paramq;
        Log.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", new Object[] { locald });
        paramString.YVW = locald;
        if (paramString.a(paramInt1, paramInt2, locald))
        {
          AppMethodBeat.o(72871);
          return true;
        }
      }
    }
    if (!(paramq instanceof n))
    {
      AppMethodBeat.o(72871);
      return false;
    }
    if (((n)paramq).gGS())
    {
      AppMethodBeat.o(72871);
      return false;
    }
    if (((n)paramq).getHasRetried())
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
      AppMethodBeat.o(72871);
      return false;
    }
    paramString = (n)paramq;
    paramq = this.YVZ;
    paramInt1 = u.gJo().mRetryCount;
    Log.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(paramString.ijo()), Integer.valueOf(paramq.YVU) });
    if ((paramString.ijo()) && (paramq.YVU < paramInt1))
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
      com.tencent.mm.plugin.report.service.h.IzE.p(965L, 13L, 1L);
      if (bool2) {
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 14L, 1L);
      }
      if ((!bool1) && (!bool2)) {
        break label738;
      }
      Log.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", new Object[] { this });
      this.YVZ.a(paramString);
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
    this.EAz = null;
    this.mContext = null;
    this.YVZ.destory();
    this.YWa.destory();
    Iterator localIterator = this.YWb.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).fWn();
    }
    this.YWb.clear();
    AppMethodBeat.o(72875);
  }
  
  private void s(q paramq)
  {
    AppMethodBeat.i(72876);
    if ((paramq != null) && ((paramq instanceof w)))
    {
      ((w)paramq).setProcessName(this.mProcessName);
      if (this.mBundle != null)
      {
        ((w)paramq).setProcessBundle(this.mBundle);
        AppMethodBeat.o(72876);
        return;
      }
      if ((this.mContext instanceof WalletBaseUI)) {
        ((w)paramq).setProcessBundle(((WalletBaseUI)this.mContext).getInput());
      }
    }
    AppMethodBeat.o(72876);
  }
  
  public final void a(q paramq, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(72865);
    a(paramq, paramBoolean, paramInt, 0);
    AppMethodBeat.o(72865);
  }
  
  public final void a(q paramq, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72866);
    int i = paramq.getType();
    boolean bool2 = paramq instanceof j;
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s", new Object[] { this, Boolean.valueOf(paramBoolean), paramq, Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      s(paramq);
      this.nkP.add(paramq);
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
      if ((paramq instanceof j))
      {
        this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(this.mContext, false, new DialogInterface.OnCancelListener()
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
                q localq = (q)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHF().kcd.a(localq);
              }
              i.d(i.this).clear();
            }
            AppMethodBeat.o(72856);
          }
        });
        label221:
        if ((ac.mGM) && ((paramq instanceof m)) && ((((m)paramq).getUri().contains("authen")) || (((m)paramq).getUri().contains("verify")))) {
          ((m)paramq).setFake();
        }
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramq, paramInt2);
        if (paramq.getReqResp() != null) {
          break label560;
        }
      }
    }
    label560:
    for (Object localObject = "";; localObject = paramq.getReqResp().getUri())
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "this %s scene url %s %s", new Object[] { this, paramq, localObject });
      AppMethodBeat.o(72866);
      return;
      localObject = this.mContext;
      this.mContext.getString(a.i.app_empty_string);
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
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
              q localq = (q)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(localq);
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
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
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
                q localq = (q)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHF().kcd.a(localq);
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
        this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(this.mContext, "验证中", new DialogInterface.OnCancelListener()
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
                q localq = (q)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHF().kcd.a(localq);
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
        this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(this.mContext, false, new DialogInterface.OnCancelListener()
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
                q localq = (q)paramAnonymousDialogInterface.next();
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHF().kcd.a(localq);
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
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, this.mContext.getString(a.i.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
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
              q localq = (q)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(localq);
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
    this.nkQ.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramInt, this);
    AppMethodBeat.o(72868);
  }
  
  public final void b(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(72864);
    s(paramq);
    this.nkO.add(paramq);
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
      this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(this.mContext, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72855);
          i.this.forceCancel();
          AppMethodBeat.o(72855);
        }
      });
    }
    if ((ac.mGM) && ((paramq instanceof m)) && ((((m)paramq).getUri().contains("authen")) || (((m)paramq).getUri().contains("verify")))) {
      ((m)paramq).setFake();
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramq, 0);
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
  
  public final void eOG()
  {
    AppMethodBeat.i(293281);
    closeTipDialog();
    AppMethodBeat.o(293281);
  }
  
  public final void forceCancel()
  {
    AppMethodBeat.i(72867);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    Iterator localIterator = this.nkO.iterator();
    q localq;
    while (localIterator.hasNext())
    {
      localq = (q)localIterator.next();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(localq);
    }
    localIterator = this.nkP.iterator();
    while (localIterator.hasNext())
    {
      localq = (q)localIterator.next();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(localq);
    }
    this.nkO.clear();
    this.nkP.clear();
    AppMethodBeat.o(72867);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(72874);
    if ((this.nkP.isEmpty()) && (this.nkO.isEmpty()))
    {
      AppMethodBeat.o(72874);
      return false;
    }
    AppMethodBeat.o(72874);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72872);
    int i;
    if (this.nkP.contains(paramq))
    {
      Log.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", new Object[] { this });
      if (!k(paramInt1, paramInt2, paramString, paramq))
      {
        Log.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[] { this });
        this.nkP.remove(paramq);
        i = 1;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", new Object[] { this, Integer.valueOf(this.nkP.size()), Integer.valueOf(this.nkO.size()) });
      if ((this.nkP.isEmpty()) && (this.nkO.isEmpty())) {
        closeTipDialog();
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.EAz != null)) {
          this.EAz.onSceneEnd(paramInt1, paramInt2, paramString, paramq, bool);
        }
        AppMethodBeat.o(72872);
        return;
        Log.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[] { this });
        AppMethodBeat.o(72872);
        return;
        if (!this.nkO.contains(paramq)) {
          break label303;
        }
        Log.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", new Object[] { this });
        if (!k(paramInt1, paramInt2, paramString, paramq))
        {
          this.nkO.remove(paramq);
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
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(paramInt, this);
    this.nkQ.remove(Integer.valueOf(paramInt));
    if (this.nkQ.isEmpty()) {
      onDestroy();
    }
    AppMethodBeat.o(72869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.i
 * JD-Core Version:    0.7.0.1
 */