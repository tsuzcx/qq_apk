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
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.protocal.protobuf.fmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.i;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.am.h
{
  private a VCp = null;
  private WeakReference<MMActivity> VCq;
  private WeakReference<com.tencent.mm.wallet_core.c.e> VCr;
  private boolean VCs = false;
  private com.tencent.mm.ui.widget.a.e VCt;
  private int mScene = -1;
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70192);
    Log.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    if (this.VCp != null)
    {
      com.tencent.mm.kernel.h.baF();
      Object localObject = com.tencent.mm.kernel.h.baE().ban();
      at.a locala = at.a.acMM;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((aq)localObject).set(locala, Integer.valueOf(i));
        if (this.VCp.run(paramInt1, paramInt2, paramString, paramBoolean)) {
          break;
        }
        Log.e("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback: errCode = " + paramInt2 + ";errMsg = " + paramString);
        if (paramInt1 != 3) {
          break;
        }
        localObject = paramString;
        if (Util.isNullOrNil(paramString))
        {
          localObject = paramString;
          if (this.VCq != null)
          {
            localObject = paramString;
            if (this.VCq.get() != null) {
              localObject = ((MMActivity)this.VCq.get()).getString(a.i.wallet_unknown_err);
            }
          }
        }
        Log.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
        k.a((Context)this.VCq.get(), (String)localObject, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70184);
            paramAnonymousDialogInterface.dismiss();
            a.c(a.this).dismiss();
            if ((a.d(a.this) != null) && (a.d(a.this).get() != null)) {
              ((MMActivity)a.d(a.this).get()).finish();
            }
            a.e(a.this);
            AppMethodBeat.o(70184);
          }
        });
        AppMethodBeat.o(70192);
        return;
      }
      if (this.VCt != null) {
        this.VCt.dismiss();
      }
      destory();
    }
    AppMethodBeat.o(70192);
  }
  
  public static void a(final MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.e parame, String paramString1, String paramString2, final String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(301409);
    a locala = new a();
    locala.VCq = new WeakReference(paramMMActivity);
    locala.VCr = new WeakReference(parame);
    locala.VCs = true;
    if ((locala.VCq != null) && (locala.VCq.get() != null))
    {
      locala.VCp = parama;
      paramString1 = paramString1 + paramString2;
      parame = new n(paramMMActivity);
      parame.VPb = new n.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70176);
          i.f(3, Util.nowSecond(), this.VCu);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramString3);
          paramAnonymousView.putExtra("showShare", false);
          i.aS(paramMMActivity, paramAnonymousView);
          AppMethodBeat.o(70176);
        }
      };
      paramString3 = com.tencent.mm.pluginsdk.ui.span.p.b(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.cd.a.br(paramMMActivity, a.d.HintTextSize));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(a.c.normal_text_color));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      i.f(0, Util.nowSecond(), 1005);
      locala.VCt = k.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70182);
          i.f(2, Util.nowSecond(), this.VCu);
          if ((a.a(a.this) != null) && (a.a(a.this).get() != null))
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(385, a.this);
            paramAnonymousDialogInterface = new d(a.b(a.this));
            ((com.tencent.mm.wallet_core.c.e)a.a(a.this).get()).b(paramAnonymousDialogInterface, true);
          }
          AppMethodBeat.o(70182);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70183);
          i.f(1, Util.nowSecond(), this.VCu);
          a.a(a.this, "cancel");
          AppMethodBeat.o(70183);
        }
      });
    }
    AppMethodBeat.o(301409);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, com.tencent.mm.am.p paramp, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70195);
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70195);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    boolean bool = a(paramActivity, paramp, paramBundle, false, paramInt2);
    AppMethodBeat.o(70195);
    return bool;
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, eme parameme, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70197);
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70197);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    if (parameme == null)
    {
      AppMethodBeat.o(70197);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + parameme.YAF + ";upload_credit_url=" + parameme.KuP);
    boolean bool;
    if (Util.isEqual("1", parameme.YAF))
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
      bool = a(paramActivity, paramBundle, null, paramInt2);
      AppMethodBeat.o(70197);
      return bool;
    }
    if ((Util.isEqual("2", parameme.YAF)) && (!Util.isNullOrNil(parameme.KuP)))
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
      bool = a(paramActivity, parameme.KuO, parameme.KuP, parameme.rGU, parameme.right_button_wording, true, null);
      AppMethodBeat.o(70197);
      return bool;
    }
    Log.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + parameme.YAF + ";upload_credit_url=null?" + Util.isNullOrNil(parameme.KuP));
    AppMethodBeat.o(70197);
    return false;
  }
  
  public static boolean a(final Activity paramActivity, Bundle paramBundle, final int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70200);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTI, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(i) });
    if (i >= 3)
    {
      AppMethodBeat.o(70200);
      return false;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTI, Integer.valueOf(i + 1));
    if (Util.isNullOrNil(paramString2)) {
      paramString2 = paramActivity.getString(a.i.app_cancel);
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString3)) {
        paramString3 = paramActivity.getString(a.i.app_ok);
      }
      for (;;)
      {
        if (paramOnClickListener == null) {
          paramOnClickListener = new a.3(false, paramActivity);
        }
        for (;;)
        {
          paramBundle = k.a(paramActivity, paramString1, "", paramString3, paramString2, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70179);
              Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
              Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
              Bundle localBundle = a.this;
              if (a.this == null) {
                localBundle = new Bundle();
              }
              localBundle.putInt("real_name_verify_mode", 0);
              localBundle.putInt("entry_scene", paramInt);
              localBundle.putBoolean("key_from_set_pwd", true);
              com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle);
              i.f(19, Util.nowSecond(), paramInt);
              paramAnonymousDialogInterface.dismiss();
              if (this.VCx) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70179);
            }
          }, paramOnClickListener, a.c.wechat_green);
          if (paramBundle != null)
          {
            paramBundle.setOnCancelListener(new a.5(false, paramActivity));
            paramBundle.setOnDismissListener(new a.6(false, paramActivity));
          }
          AppMethodBeat.o(70200);
          return true;
        }
      }
    }
  }
  
  public static boolean a(Activity paramActivity, Bundle paramBundle, e.a parama, int paramInt)
  {
    AppMethodBeat.i(70198);
    Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[] { Integer.valueOf(0) });
    Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", paramInt);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, parama);
    i.f(19, Util.nowSecond(), paramInt);
    AppMethodBeat.o(70198);
    return true;
  }
  
  public static boolean a(Activity paramActivity, com.tencent.mm.am.p paramp, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70196);
    String str1 = "";
    String str3 = "";
    String str4 = "";
    String str2 = "";
    Object localObject = r(paramp);
    if (localObject != null)
    {
      paramp = (com.tencent.mm.am.p)localObject;
      if (((JSONObject)localObject).has("real_name_info")) {
        paramp = ((JSONObject)localObject).optJSONObject("real_name_info");
      }
      localObject = paramp.optString("guide_flag", "0");
      str1 = paramp.optString("guide_wording");
      str3 = paramp.optString("left_button_wording", paramActivity.getString(a.i.app_cancel));
      str4 = paramp.optString("right_button_wording", paramActivity.getString(a.i.app_ok));
      str2 = paramp.optString("upload_credit_url", "");
    }
    for (paramp = (com.tencent.mm.am.p)localObject;; paramp = "")
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramp + ";upload_credit_url=" + str2);
      if ("1".equals(paramp))
      {
        Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
        paramBoolean = a(paramActivity, paramBundle, null, paramInt);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      if (("2".equals(paramp)) && (!Util.isNullOrNil(str2)))
      {
        Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
        paramBoolean = a(paramActivity, str1, str2, str3, str4, paramBoolean, null);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      Log.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramp + ";upload_credit_url=null?" + Util.isNullOrNil(str2));
      AppMethodBeat.o(70196);
      return false;
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70199);
    if (Util.isNullOrNil(paramString3)) {
      paramString3 = paramActivity.getString(a.i.app_cancel);
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString4)) {
        paramString4 = paramActivity.getString(a.i.app_ok);
      }
      for (;;)
      {
        if (paramOnClickListener == null)
        {
          Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
          paramOnClickListener = new a.10(paramBoolean, paramActivity);
        }
        for (;;)
        {
          paramString1 = k.a(paramActivity, paramString1, "", paramString4, paramString3, new a.11(paramString2, paramActivity, paramBoolean), paramOnClickListener, a.c.wechat_green);
          if (paramString1 != null)
          {
            paramString1.setOnCancelListener(new a.12(paramBoolean, paramActivity));
            paramString1.setOnDismissListener(new a.2(paramBoolean, paramActivity));
            paramString1.setCanceledOnTouchOutside(false);
          }
          AppMethodBeat.o(70199);
          return true;
        }
      }
    }
  }
  
  private void destory()
  {
    AppMethodBeat.i(70193);
    this.VCs = false;
    if (this.VCt != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
      this.VCt = null;
    }
    if (this.VCr != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
      this.VCr.clear();
      this.VCr = null;
    }
    if (this.VCq != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
      this.VCq.clear();
      this.VCq = null;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
    this.VCp = null;
    AppMethodBeat.o(70193);
  }
  
  private void fXe()
  {
    AppMethodBeat.i(70189);
    if ((this.VCr != null) && (this.VCr.get() != null)) {
      ((com.tencent.mm.wallet_core.c.e)this.VCr.get()).fXe();
    }
    AppMethodBeat.o(70189);
  }
  
  private static JSONObject r(com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(70194);
    if ((paramp != null) && ((paramp instanceof m)))
    {
      paramp = ((m)paramp).getCommReqResp();
      if (paramp != null)
      {
        paramp = (fmk)c.c.b(paramp.otC);
        if (paramp.aaFS != null)
        {
          paramp = w.b(paramp.aaFS);
          try
          {
            paramp = new JSONObject(paramp);
            AppMethodBeat.o(70194);
            return paramp;
          }
          catch (JSONException paramp)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.RealnameVerifyUtil", paramp, "", new Object[0]);
              paramp = null;
            }
          }
        }
      }
    }
    AppMethodBeat.o(70194);
    return null;
  }
  
  public final boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.e parame, int paramInt)
  {
    AppMethodBeat.i(70188);
    this.VCs = false;
    com.tencent.mm.kernel.h.baF();
    long l1 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acML, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      i.f(5, Util.nowSecond(), paramInt);
      if (l2 < l1)
      {
        Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = ".concat(String.valueOf(l1)));
        AppMethodBeat.o(70188);
        return false;
      }
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = ".concat(String.valueOf(l1)));
    }
    if (paramMMActivity == null)
    {
      Log.e("MicroMsg.RealnameVerifyUtil", "context is null");
      AppMethodBeat.o(70188);
      return false;
    }
    if (parame == null)
    {
      Log.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
      AppMethodBeat.o(70188);
      return false;
    }
    AppMethodBeat.o(70188);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(70190);
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      fXe();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        AppMethodBeat.o(70190);
        throw null;
      }
      a(2, paramInt2, paramString, false);
      AppMethodBeat.o(70190);
      return;
    }
    if ((paramp instanceof d))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(385, this);
      fXe();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(0, paramInt2, paramString, true);
        AppMethodBeat.o(70190);
        return;
      }
      a(3, paramInt2, paramString, false);
    }
    AppMethodBeat.o(70190);
  }
  
  public static abstract interface a
  {
    public abstract boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a
 * JD-Core Version:    0.7.0.1
 */