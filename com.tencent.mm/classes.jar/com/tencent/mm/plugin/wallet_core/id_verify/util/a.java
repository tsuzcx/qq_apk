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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements f
{
  private a CTE = null;
  WeakReference<MMActivity> CTF;
  WeakReference<com.tencent.mm.wallet_core.d.e> CTG;
  private boolean CTH = false;
  com.tencent.mm.ui.widget.a.d CTI;
  int mScene = -1;
  
  public static boolean a(Activity paramActivity, int paramInt1, n paramn, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70195);
    if (paramInt1 != 416)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70195);
      return false;
    }
    ad.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    boolean bool = a(paramActivity, paramn, paramBundle, false, paramInt2);
    AppMethodBeat.o(70195);
    return bool;
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, cra paramcra, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70197);
    if (paramInt1 != 416)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70197);
      return false;
    }
    ad.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    if (paramcra == null)
    {
      AppMethodBeat.o(70197);
      return false;
    }
    ad.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramcra.Fqw + ";upload_credit_url=" + paramcra.vqC);
    boolean bool;
    if (bt.lQ("1", paramcra.Fqw))
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
      bool = a(paramActivity, paramBundle, null, paramInt2);
      AppMethodBeat.o(70197);
      return bool;
    }
    if ((bt.lQ("2", paramcra.Fqw)) && (!bt.isNullOrNil(paramcra.vqC)))
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
      bool = a(paramActivity, paramcra.vqB, paramcra.vqC, paramcra.kzK, paramcra.kzL, true, null);
      AppMethodBeat.o(70197);
      return bool;
    }
    ad.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramcra.Fqw + ";upload_credit_url=null?" + bt.isNullOrNil(paramcra.vqC));
    AppMethodBeat.o(70197);
    return false;
  }
  
  public static boolean a(final Activity paramActivity, Bundle paramBundle, final int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70200);
    g.ajD();
    int i = ((Integer)g.ajC().ajl().get(al.a.IBc, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(i) });
    if (i >= 3)
    {
      AppMethodBeat.o(70200);
      return false;
    }
    g.ajD();
    g.ajC().ajl().set(al.a.IBc, Integer.valueOf(i + 1));
    if (bt.isNullOrNil(paramString2)) {
      paramString2 = paramActivity.getString(2131755691);
    }
    for (;;)
    {
      if (bt.isNullOrNil(paramString3)) {
        paramString3 = paramActivity.getString(2131755835);
      }
      for (;;)
      {
        if (paramOnClickListener == null) {
          paramOnClickListener = new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70178);
              ad.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
              paramAnonymousDialogInterface.dismiss();
              if (this.CTM) {
                this.iNQ.finish();
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
              ad.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
              ad.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
              Bundle localBundle = this.val$bundle;
              if (this.val$bundle == null) {
                localBundle = new Bundle();
              }
              localBundle.putInt("real_name_verify_mode", 0);
              localBundle.putInt("entry_scene", paramInt);
              localBundle.putBoolean("key_from_set_pwd", true);
              com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle);
              com.tencent.mm.wallet_core.ui.e.d(19, bt.aQJ(), paramInt);
              paramAnonymousDialogInterface.dismiss();
              if (this.CTM) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70179);
            }
          }, paramOnClickListener, 2131101171);
          if (paramBundle != null)
          {
            paramBundle.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70180);
                if (this.CTM) {
                  this.iNQ.finish();
                }
                AppMethodBeat.o(70180);
              }
            });
            paramBundle.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70181);
                if (this.CTM) {
                  this.iNQ.finish();
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
    ad.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[] { Integer.valueOf(0) });
    ad.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", paramInt);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, parama);
    com.tencent.mm.wallet_core.ui.e.d(19, bt.aQJ(), paramInt);
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
      ad.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramn + ";upload_credit_url=" + str2);
      if ("1".equals(paramn))
      {
        ad.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
        paramBoolean = a(paramActivity, paramBundle, null, paramInt);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      if (("2".equals(paramn)) && (!bt.isNullOrNil(str2)))
      {
        ad.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
        paramBoolean = a(paramActivity, str1, str2, str3, str4, paramBoolean, null);
        AppMethodBeat.o(70196);
        return paramBoolean;
      }
      ad.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramn + ";upload_credit_url=null?" + bt.isNullOrNil(str2));
      AppMethodBeat.o(70196);
      return false;
    }
  }
  
  public static boolean a(final Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, final boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70199);
    if (bt.isNullOrNil(paramString3)) {
      paramString3 = paramActivity.getString(2131755691);
    }
    for (;;)
    {
      if (bt.isNullOrNil(paramString4)) {
        paramString4 = paramActivity.getString(2131755835);
      }
      for (;;)
      {
        if (paramOnClickListener == null)
        {
          ad.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
          paramOnClickListener = new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70185);
              ad.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
              paramAnonymousDialogInterface.dismiss();
              if (this.CTM) {
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
              ad.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", this.val$url);
              localIntent.putExtra("showShare", false);
              com.tencent.mm.wallet_core.ui.e.an(paramActivity, localIntent);
              paramAnonymousDialogInterface.dismiss();
              if (paramBoolean) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70186);
            }
          }, paramOnClickListener, 2131101171);
          if (paramString1 != null)
          {
            paramString1.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70187);
                if (this.CTM) {
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
                if (this.CTM) {
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
  
  private void dip()
  {
    AppMethodBeat.i(70189);
    if ((this.CTG != null) && (this.CTG.get() != null)) {
      ((com.tencent.mm.wallet_core.d.e)this.CTG.get()).dip();
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
        paramn = (dmk)paramn.hNL.hNQ;
        if (paramn.GJp != null)
        {
          paramn = z.b(paramn.GJp);
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
              ad.printErrStackTrace("MicroMsg.RealnameVerifyUtil", paramn, "", new Object[0]);
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
    this.CTF = new WeakReference(paramMMActivity);
    this.CTG = new WeakReference(parame);
    this.CTH = paramBoolean;
    if ((this.CTF != null) && (this.CTF.get() != null))
    {
      this.CTE = parama;
      paramString1 = paramString1 + paramString2;
      parame = new l(paramMMActivity);
      parame.DfS = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70176);
          com.tencent.mm.wallet_core.ui.e.d(3, bt.aQJ(), paramInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramString3);
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.e.an(paramMMActivity, paramAnonymousView);
          AppMethodBeat.o(70176);
        }
      };
      paramString3 = k.c(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.cc.a.ax(paramMMActivity, 2131165466));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(2131100711));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      com.tencent.mm.wallet_core.ui.e.d(0, bt.aQJ(), paramInt);
      this.CTI = com.tencent.mm.ui.base.h.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70182);
          com.tencent.mm.wallet_core.ui.e.d(2, bt.aQJ(), paramInt);
          if ((a.this.CTG != null) && (a.this.CTG.get() != null))
          {
            g.ajD();
            g.ajB().gAO.a(385, a.this);
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_core.id_verify.model.d(a.this.mScene);
            ((com.tencent.mm.wallet_core.d.e)a.this.CTG.get()).b(paramAnonymousDialogInterface, true);
          }
          AppMethodBeat.o(70182);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70183);
          com.tencent.mm.wallet_core.ui.e.d(1, bt.aQJ(), paramInt);
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
    this.CTH = false;
    g.ajD();
    long l1 = ((Long)g.ajC().ajl().get(al.a.IuS, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      com.tencent.mm.wallet_core.ui.e.d(5, bt.aQJ(), paramInt);
      if (l2 < l1)
      {
        ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = ".concat(String.valueOf(l1)));
        AppMethodBeat.o(70188);
        return false;
      }
      ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = ".concat(String.valueOf(l1)));
    }
    if (paramMMActivity == null)
    {
      ad.e("MicroMsg.RealnameVerifyUtil", "context is null");
      AppMethodBeat.o(70188);
      return false;
    }
    if (parame == null)
    {
      ad.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
      AppMethodBeat.o(70188);
      return false;
    }
    AppMethodBeat.o(70188);
    return false;
  }
  
  final void c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70192);
    ad.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    if (this.CTE != null)
    {
      g.ajD();
      Object localObject = g.ajC().ajl();
      al.a locala = al.a.IuT;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((ai)localObject).set(locala, Integer.valueOf(i));
        if (this.CTE.run(paramInt1, paramInt2, paramString, paramBoolean)) {
          break;
        }
        ad.e("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback: errCode = " + paramInt2 + ";errMsg = " + paramString);
        if (paramInt1 != 3) {
          break;
        }
        localObject = paramString;
        if (bt.isNullOrNil(paramString))
        {
          localObject = paramString;
          if (this.CTF != null)
          {
            localObject = paramString;
            if (this.CTF.get() != null) {
              localObject = ((MMActivity)this.CTF.get()).getString(2131765901);
            }
          }
        }
        ad.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
        com.tencent.mm.ui.base.h.a((Context)this.CTF.get(), (String)localObject, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70184);
            paramAnonymousDialogInterface.dismiss();
            a.this.CTI.dismiss();
            if ((a.this.CTF != null) && (a.this.CTF.get() != null)) {
              ((MMActivity)a.this.CTF.get()).finish();
            }
            a.this.destory();
            AppMethodBeat.o(70184);
          }
        });
        AppMethodBeat.o(70192);
        return;
      }
      if (this.CTI != null) {
        this.CTI.dismiss();
      }
      destory();
    }
    AppMethodBeat.o(70192);
  }
  
  final void destory()
  {
    AppMethodBeat.i(70193);
    this.CTH = false;
    if (this.CTI != null)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
      this.CTI = null;
    }
    if (this.CTG != null)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
      this.CTG.clear();
      this.CTG = null;
    }
    if (this.CTF != null)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
      this.CTF.clear();
      this.CTF = null;
    }
    ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
    this.CTE = null;
    AppMethodBeat.o(70193);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70190);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
    {
      g.ajD();
      g.ajB().gAO.b(385, this);
      dip();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.wallet_core.id_verify.model.h)paramn;
        boolean bool = paramn.CSL.equals("1");
        if (bool)
        {
          ad.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
          c(0, paramInt2, paramString, bool);
          AppMethodBeat.o(70190);
          return;
        }
        paramString = paramn.title;
        String str1 = paramn.CSM;
        String str2 = paramn.CSN;
        String str3 = paramn.CSO;
        paramInt1 = paramn.CSP;
        a((MMActivity)this.CTF.get(), (com.tencent.mm.wallet_core.d.e)this.CTG.get(), paramString, str1, str2, str3, this.CTE, false, paramInt1);
        AppMethodBeat.o(70190);
        return;
      }
      c(2, paramInt2, paramString, false);
      AppMethodBeat.o(70190);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.d))
    {
      g.ajD();
      g.ajB().gAO.a(385, this);
      dip();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a
 * JD-Core Version:    0.7.0.1
 */