package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.ak.g
{
  private a Btp = null;
  WeakReference<MMActivity> Btq;
  WeakReference<com.tencent.mm.wallet_core.d.e> Btr;
  private boolean Bts = false;
  com.tencent.mm.ui.widget.a.d Btt;
  int mScene = -1;
  
  public static boolean a(Activity paramActivity, int paramInt1, n paramn, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70195);
    if (paramInt1 != 416)
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70195);
      return false;
    }
    ac.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    boolean bool = a(paramActivity, paramn, paramBundle, false, paramInt2);
    AppMethodBeat.o(70195);
    return bool;
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, cma paramcma, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70197);
    if (paramInt1 != 416)
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70197);
      return false;
    }
    ac.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    if (paramcma == null)
    {
      AppMethodBeat.o(70197);
      return false;
    }
    ac.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramcma.DLr + ";upload_credit_url=" + paramcma.unY);
    boolean bool;
    if (bs.lr("1", paramcma.DLr))
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
      bool = a(paramActivity, paramBundle, null, paramInt2);
      AppMethodBeat.o(70197);
      return bool;
    }
    if ((bs.lr("2", paramcma.DLr)) && (!bs.isNullOrNil(paramcma.unY)))
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
      bool = a(paramActivity, paramcma.unV, paramcma.unY, paramcma.unW, paramcma.unX, true, null);
      AppMethodBeat.o(70197);
      return bool;
    }
    ac.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramcma.DLr + ";upload_credit_url=null?" + bs.isNullOrNil(paramcma.unY));
    AppMethodBeat.o(70197);
    return false;
  }
  
  public static boolean a(final Activity paramActivity, Bundle paramBundle, final int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70200);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOH, Integer.valueOf(0))).intValue();
    ac.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(i) });
    if (i >= 3)
    {
      AppMethodBeat.o(70200);
      return false;
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOH, Integer.valueOf(i + 1));
    if (bs.isNullOrNil(paramString2)) {
      paramString2 = paramActivity.getString(2131755691);
    }
    for (;;)
    {
      if (bs.isNullOrNil(paramString3)) {
        paramString3 = paramActivity.getString(2131755835);
      }
      for (;;)
      {
        if (paramOnClickListener == null) {
          paramOnClickListener = new a.3(paramActivity);
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, "", paramString3, paramString2, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70179);
              ac.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
              ac.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
              Bundle localBundle = this.val$bundle;
              if (this.val$bundle == null) {
                localBundle = new Bundle();
              }
              localBundle.putInt("real_name_verify_mode", 0);
              localBundle.putInt("entry_scene", paramInt);
              localBundle.putBoolean("key_from_set_pwd", true);
              com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle);
              com.tencent.mm.wallet_core.ui.e.d(19, bs.aNx(), paramInt);
              paramAnonymousDialogInterface.dismiss();
              if (this.Btx) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70179);
            }
          }, paramOnClickListener, 2131101171);
          if (paramBundle != null)
          {
            paramBundle.setOnCancelListener(new a.5(paramActivity));
            paramBundle.setOnDismissListener(new a.6(paramActivity));
          }
          AppMethodBeat.o(70200);
          return true;
        }
      }
    }
  }
  
  public static boolean a(Activity paramActivity, Bundle paramBundle, d.a parama, int paramInt)
  {
    AppMethodBeat.i(70198);
    ac.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[] { Integer.valueOf(0) });
    ac.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", paramInt);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, parama);
    com.tencent.mm.wallet_core.ui.e.d(19, bs.aNx(), paramInt);
    AppMethodBeat.o(70198);
    return true;
  }
  
  public static boolean a(Activity paramActivity, n paramn, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70196);
    String str1 = "";
    String str3 = "";
    String str4 = "";
    String str2 = "";
    Object localObject = p(paramn);
    if (localObject != null)
    {
      paramn = (n)localObject;
      if (((JSONObject)localObject).has("real_name_info")) {
        paramn = ((JSONObject)localObject).optJSONObject("real_name_info");
      }
      localObject = paramn.optString("guide_flag", "0");
      str1 = paramn.optString("guide_wording");
      str3 = paramn.optString("left_button_wording", paramActivity.getString(2131755691));
      str4 = paramn.optString("right_button_wording", paramActivity.getString(2131755835));
      str2 = paramn.optString("upload_credit_url", "");
    }
    for (paramn = (n)localObject;; paramn = "")
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramn + ";upload_credit_url=" + str2);
      if ("1".equals(paramn))
      {
        ac.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
        paramBoolean = a(paramActivity, paramBundle, null, paramInt);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      if (("2".equals(paramn)) && (!bs.isNullOrNil(str2)))
      {
        ac.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
        paramBoolean = a(paramActivity, str1, str2, str3, str4, paramBoolean, null);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      ac.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramn + ";upload_credit_url=null?" + bs.isNullOrNil(str2));
      AppMethodBeat.o(70196);
      return false;
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70199);
    if (bs.isNullOrNil(paramString3)) {
      paramString3 = paramActivity.getString(2131755691);
    }
    for (;;)
    {
      if (bs.isNullOrNil(paramString4)) {
        paramString4 = paramActivity.getString(2131755835);
      }
      for (;;)
      {
        if (paramOnClickListener == null)
        {
          ac.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
          paramOnClickListener = new a.10(paramBoolean, paramActivity);
        }
        for (;;)
        {
          paramString1 = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, "", paramString4, paramString3, new a.11(paramString2, paramActivity, paramBoolean), paramOnClickListener, 2131101171);
          if (paramString1 != null)
          {
            paramString1.setOnCancelListener(new a.12(paramBoolean, paramActivity));
            paramString1.setOnDismissListener(new a.2(paramBoolean, paramActivity));
          }
          AppMethodBeat.o(70199);
          return true;
        }
      }
    }
  }
  
  private void cZd()
  {
    AppMethodBeat.i(70189);
    if ((this.Btr != null) && (this.Btr.get() != null)) {
      ((com.tencent.mm.wallet_core.d.e)this.Btr.get()).cZd();
    }
    AppMethodBeat.o(70189);
  }
  
  private static JSONObject p(n paramn)
  {
    AppMethodBeat.i(70194);
    if ((paramn != null) && ((paramn instanceof m)))
    {
      paramn = ((m)paramn).getCommReqResp();
      if (paramn != null)
      {
        paramn = (dgx)paramn.hvs.hvw;
        if (paramn.EZQ != null)
        {
          paramn = z.b(paramn.EZQ);
          try
          {
            paramn = new JSONObject(paramn);
            AppMethodBeat.o(70194);
            return paramn;
          }
          catch (JSONException paramn)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.RealnameVerifyUtil", paramn, "", new Object[0]);
              paramn = null;
            }
          }
        }
      }
    }
    AppMethodBeat.o(70194);
    return null;
  }
  
  public final void a(final MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, String paramString1, String paramString2, final String paramString3, String paramString4, a parama, boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(70191);
    this.Btq = new WeakReference(paramMMActivity);
    this.Btr = new WeakReference(parame);
    this.Bts = paramBoolean;
    if ((this.Btq != null) && (this.Btq.get() != null))
    {
      this.Btp = parama;
      paramString1 = paramString1 + paramString2;
      parame = new l(paramMMActivity);
      parame.BFA = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70176);
          com.tencent.mm.wallet_core.ui.e.d(3, bs.aNx(), paramInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramString3);
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.e.al(paramMMActivity, paramAnonymousView);
          AppMethodBeat.o(70176);
        }
      };
      paramString3 = k.c(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.cc.a.au(paramMMActivity, 2131165466));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(2131100711));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      com.tencent.mm.wallet_core.ui.e.d(0, bs.aNx(), paramInt);
      this.Btt = com.tencent.mm.ui.base.h.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70182);
          com.tencent.mm.wallet_core.ui.e.d(2, bs.aNx(), paramInt);
          if ((a.this.Btr != null) && (a.this.Btr.get() != null))
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(385, a.this);
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_core.id_verify.model.d(a.this.mScene);
            ((com.tencent.mm.wallet_core.d.e)a.this.Btr.get()).b(paramAnonymousDialogInterface, true);
          }
          AppMethodBeat.o(70182);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70183);
          com.tencent.mm.wallet_core.ui.e.d(1, bs.aNx(), paramInt);
          a.this.c(1, -1, "cancel", false);
          AppMethodBeat.o(70183);
        }
      });
    }
    AppMethodBeat.o(70191);
  }
  
  public final boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(70188);
    this.Bts = false;
    com.tencent.mm.kernel.g.agS();
    long l1 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIA, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      com.tencent.mm.wallet_core.ui.e.d(5, bs.aNx(), paramInt);
      if (l2 < l1)
      {
        ac.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = ".concat(String.valueOf(l1)));
        AppMethodBeat.o(70188);
        return false;
      }
      ac.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = ".concat(String.valueOf(l1)));
    }
    if (paramMMActivity == null)
    {
      ac.e("MicroMsg.RealnameVerifyUtil", "context is null");
      AppMethodBeat.o(70188);
      return false;
    }
    if (parame == null)
    {
      ac.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
      AppMethodBeat.o(70188);
      return false;
    }
    AppMethodBeat.o(70188);
    return false;
  }
  
  final void c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70192);
    ac.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    if (this.Btp != null)
    {
      com.tencent.mm.kernel.g.agS();
      Object localObject = com.tencent.mm.kernel.g.agR().agA();
      ah.a locala = ah.a.GIB;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((ae)localObject).set(locala, Integer.valueOf(i));
        if (this.Btp.run(paramInt1, paramInt2, paramString, paramBoolean)) {
          break;
        }
        ac.e("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback: errCode = " + paramInt2 + ";errMsg = " + paramString);
        if (paramInt1 != 3) {
          break;
        }
        localObject = paramString;
        if (bs.isNullOrNil(paramString))
        {
          localObject = paramString;
          if (this.Btq != null)
          {
            localObject = paramString;
            if (this.Btq.get() != null) {
              localObject = ((MMActivity)this.Btq.get()).getString(2131765901);
            }
          }
        }
        ac.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
        com.tencent.mm.ui.base.h.a((Context)this.Btq.get(), (String)localObject, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70184);
            paramAnonymousDialogInterface.dismiss();
            a.this.Btt.dismiss();
            if ((a.this.Btq != null) && (a.this.Btq.get() != null)) {
              ((MMActivity)a.this.Btq.get()).finish();
            }
            a.this.destory();
            AppMethodBeat.o(70184);
          }
        });
        AppMethodBeat.o(70192);
        return;
      }
      if (this.Btt != null) {
        this.Btt.dismiss();
      }
      destory();
    }
    AppMethodBeat.o(70192);
  }
  
  final void destory()
  {
    AppMethodBeat.i(70193);
    this.Bts = false;
    if (this.Btt != null)
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
      this.Btt = null;
    }
    if (this.Btr != null)
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
      this.Btr.clear();
      this.Btr = null;
    }
    if (this.Btq != null)
    {
      ac.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
      this.Btq.clear();
      this.Btq = null;
    }
    ac.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
    this.Btp = null;
    AppMethodBeat.o(70193);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70190);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      cZd();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.wallet_core.id_verify.model.h)paramn;
        boolean bool = paramn.Bsw.equals("1");
        if (bool)
        {
          ac.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
          c(0, paramInt2, paramString, bool);
          AppMethodBeat.o(70190);
          return;
        }
        paramString = paramn.title;
        String str1 = paramn.Bsx;
        String str2 = paramn.Bsy;
        String str3 = paramn.Bsz;
        paramInt1 = paramn.BsA;
        a((MMActivity)this.Btq.get(), (com.tencent.mm.wallet_core.d.e)this.Btr.get(), paramString, str1, str2, str3, this.Btp, false, paramInt1);
        AppMethodBeat.o(70190);
        return;
      }
      c(2, paramInt2, paramString, false);
      AppMethodBeat.o(70190);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.d))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
      cZd();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        c(0, paramInt2, paramString, true);
        AppMethodBeat.o(70190);
        return;
      }
      c(3, paramInt2, paramString, false);
    }
    AppMethodBeat.o(70190);
  }
  
  public static abstract interface a
  {
    public abstract boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a
 * JD-Core Version:    0.7.0.1
 */