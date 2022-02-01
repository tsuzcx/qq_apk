package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.ui.g;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements i
{
  private a OME = null;
  private WeakReference<MMActivity> OMF;
  private WeakReference<e> OMG;
  private boolean OMH = false;
  private com.tencent.mm.ui.widget.a.d OMI;
  private int mScene = -1;
  
  public static void a(final MMActivity paramMMActivity, e parame, String paramString1, String paramString2, final String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(197200);
    a locala = new a();
    locala.OMF = new WeakReference(paramMMActivity);
    locala.OMG = new WeakReference(parame);
    locala.OMH = true;
    if ((locala.OMF != null) && (locala.OMF.get() != null))
    {
      locala.OME = parama;
      paramString1 = paramString1 + paramString2;
      parame = new com.tencent.mm.plugin.wallet_core.ui.m(paramMMActivity);
      parame.OYN = new m.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70176);
          g.d(3, Util.nowSecond(), this.OMJ);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramString3);
          paramAnonymousView.putExtra("showShare", false);
          g.aJ(paramMMActivity, paramAnonymousView);
          AppMethodBeat.o(70176);
        }
      };
      paramString3 = l.c(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.ci.a.aY(paramMMActivity, a.d.HintTextSize));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(a.c.normal_text_color));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      g.d(0, Util.nowSecond(), 1005);
      locala.OMI = com.tencent.mm.ui.base.h.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70182);
          g.d(2, Util.nowSecond(), this.OMJ);
          if ((a.a(a.this) != null) && (a.a(a.this).get() != null))
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(385, a.this);
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_core.id_verify.model.d(a.b(a.this));
            ((e)a.a(a.this).get()).b(paramAnonymousDialogInterface, true);
          }
          AppMethodBeat.o(70182);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70183);
          g.d(1, Util.nowSecond(), this.OMJ);
          a.a(a.this, "cancel");
          AppMethodBeat.o(70183);
        }
      });
    }
    AppMethodBeat.o(197200);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, q paramq, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70195);
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70195);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    boolean bool = a(paramActivity, paramq, paramBundle, false, paramInt2);
    AppMethodBeat.o(70195);
    return bool;
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, dtj paramdtj, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70197);
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70197);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    if (paramdtj == null)
    {
      AppMethodBeat.o(70197);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramdtj.REc + ";upload_credit_url=" + paramdtj.EBO);
    boolean bool;
    if (Util.isEqual("1", paramdtj.REc))
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
      bool = a(paramActivity, paramBundle, null, paramInt2);
      AppMethodBeat.o(70197);
      return bool;
    }
    if ((Util.isEqual("2", paramdtj.REc)) && (!Util.isNullOrNil(paramdtj.EBO)))
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
      bool = a(paramActivity, paramdtj.EBN, paramdtj.EBO, paramdtj.oDJ, paramdtj.oDK, true, null);
      AppMethodBeat.o(70197);
      return bool;
    }
    Log.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramdtj.REc + ";upload_credit_url=null?" + Util.isNullOrNil(paramdtj.EBO));
    AppMethodBeat.o(70197);
    return false;
  }
  
  public static boolean a(final Activity paramActivity, Bundle paramBundle, final int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70200);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vse, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(i) });
    if (i >= 3)
    {
      AppMethodBeat.o(70200);
      return false;
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vse, Integer.valueOf(i + 1));
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
          paramOnClickListener = new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70178);
              Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
              paramAnonymousDialogInterface.dismiss();
              if (this.OMM) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70178);
            }
          };
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, "", paramString3, paramString2, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70179);
              Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
              Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
              Bundle localBundle = this.val$bundle;
              if (this.val$bundle == null) {
                localBundle = new Bundle();
              }
              localBundle.putInt("real_name_verify_mode", 0);
              localBundle.putInt("entry_scene", paramInt);
              localBundle.putBoolean("key_from_set_pwd", true);
              com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle);
              g.d(19, Util.nowSecond(), paramInt);
              paramAnonymousDialogInterface.dismiss();
              if (this.OMM) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70179);
            }
          }, paramOnClickListener, a.c.wechat_green);
          if (paramBundle != null)
          {
            paramBundle.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70180);
                if (this.OMM) {
                  paramActivity.finish();
                }
                AppMethodBeat.o(70180);
              }
            });
            paramBundle.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70181);
                if (this.OMM) {
                  paramActivity.finish();
                }
                AppMethodBeat.o(70181);
              }
            });
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
    Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[] { Integer.valueOf(0) });
    Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", paramInt);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, parama);
    g.d(19, Util.nowSecond(), paramInt);
    AppMethodBeat.o(70198);
    return true;
  }
  
  public static boolean a(Activity paramActivity, q paramq, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70196);
    String str1 = "";
    String str3 = "";
    String str4 = "";
    String str2 = "";
    Object localObject = r(paramq);
    if (localObject != null)
    {
      paramq = (q)localObject;
      if (((JSONObject)localObject).has("real_name_info")) {
        paramq = ((JSONObject)localObject).optJSONObject("real_name_info");
      }
      localObject = paramq.optString("guide_flag", "0");
      str1 = paramq.optString("guide_wording");
      str3 = paramq.optString("left_button_wording", paramActivity.getString(a.i.app_cancel));
      str4 = paramq.optString("right_button_wording", paramActivity.getString(a.i.app_ok));
      str2 = paramq.optString("upload_credit_url", "");
    }
    for (paramq = (q)localObject;; paramq = "")
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramq + ";upload_credit_url=" + str2);
      if ("1".equals(paramq))
      {
        Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
        paramBoolean = a(paramActivity, paramBundle, null, paramInt);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      if (("2".equals(paramq)) && (!Util.isNullOrNil(str2)))
      {
        Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
        paramBoolean = a(paramActivity, str1, str2, str3, str4, paramBoolean, null);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      Log.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramq + ";upload_credit_url=null?" + Util.isNullOrNil(str2));
      AppMethodBeat.o(70196);
      return false;
    }
  }
  
  public static boolean a(final Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, final boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
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
          paramOnClickListener = new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70185);
              Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
              paramAnonymousDialogInterface.dismiss();
              if (this.OMM) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70185);
            }
          };
        }
        for (;;)
        {
          paramString1 = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, "", paramString4, paramString3, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70186);
              Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", this.val$url);
              localIntent.putExtra("showShare", false);
              g.aJ(paramActivity, localIntent);
              paramAnonymousDialogInterface.dismiss();
              if (paramBoolean) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70186);
            }
          }, paramOnClickListener, a.c.wechat_green);
          if (paramString1 != null)
          {
            paramString1.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70187);
                if (this.OMM) {
                  paramActivity.finish();
                }
                AppMethodBeat.o(70187);
              }
            });
            paramString1.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70177);
                if (this.OMM) {
                  paramActivity.finish();
                }
                AppMethodBeat.o(70177);
              }
            });
          }
          AppMethodBeat.o(70199);
          return true;
        }
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70192);
    Log.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    if (this.OME != null)
    {
      com.tencent.mm.kernel.h.aHH();
      Object localObject = com.tencent.mm.kernel.h.aHG().aHp();
      ar.a locala = ar.a.Vls;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((ao)localObject).set(locala, Integer.valueOf(i));
        if (this.OME.run(paramInt1, paramInt2, paramString, paramBoolean)) {
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
          if (this.OMF != null)
          {
            localObject = paramString;
            if (this.OMF.get() != null) {
              localObject = ((MMActivity)this.OMF.get()).getString(a.i.wallet_unknown_err);
            }
          }
        }
        Log.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
        com.tencent.mm.ui.base.h.a((Context)this.OMF.get(), (String)localObject, null, false, new DialogInterface.OnClickListener()
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
      if (this.OMI != null) {
        this.OMI.dismiss();
      }
      destory();
    }
    AppMethodBeat.o(70192);
  }
  
  private void destory()
  {
    AppMethodBeat.i(70193);
    this.OMH = false;
    if (this.OMI != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
      this.OMI = null;
    }
    if (this.OMG != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
      this.OMG.clear();
      this.OMG = null;
    }
    if (this.OMF != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
      this.OMF.clear();
      this.OMF = null;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
    this.OME = null;
    AppMethodBeat.o(70193);
  }
  
  private void eOG()
  {
    AppMethodBeat.i(70189);
    if ((this.OMG != null) && (this.OMG.get() != null)) {
      ((e)this.OMG.get()).eOG();
    }
    AppMethodBeat.o(70189);
  }
  
  private static JSONObject r(q paramq)
  {
    AppMethodBeat.i(70194);
    if ((paramq != null) && ((paramq instanceof com.tencent.mm.wallet_core.tenpay.model.m)))
    {
      paramq = ((com.tencent.mm.wallet_core.tenpay.model.m)paramq).getCommReqResp();
      if (paramq != null)
      {
        paramq = (erd)d.c.b(paramq.lBS);
        if (paramq.TrG != null)
        {
          paramq = z.b(paramq.TrG);
          try
          {
            paramq = new JSONObject(paramq);
            AppMethodBeat.o(70194);
            return paramq;
          }
          catch (JSONException paramq)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.RealnameVerifyUtil", paramq, "", new Object[0]);
              paramq = null;
            }
          }
        }
      }
    }
    AppMethodBeat.o(70194);
    return null;
  }
  
  public final boolean a(MMActivity paramMMActivity, e parame, int paramInt)
  {
    AppMethodBeat.i(70188);
    this.OMH = false;
    com.tencent.mm.kernel.h.aHH();
    long l1 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlr, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      g.d(5, Util.nowSecond(), paramInt);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70190);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
      eOG();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        AppMethodBeat.o(70190);
        throw null;
      }
      c(2, paramInt2, paramString, false);
      AppMethodBeat.o(70190);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.d))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
      eOG();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a
 * JD-Core Version:    0.7.0.1
 */