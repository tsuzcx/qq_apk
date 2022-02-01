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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.al.g
{
  private a AaV = null;
  WeakReference<MMActivity> AaW;
  WeakReference<com.tencent.mm.wallet_core.d.e> AaX;
  private boolean AaY = false;
  com.tencent.mm.ui.widget.a.d AaZ;
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
  
  public static boolean a(Activity paramActivity, int paramInt1, cgx paramcgx, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70197);
    if (paramInt1 != 416)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70197);
      return false;
    }
    ad.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    if (paramcgx == null)
    {
      AppMethodBeat.o(70197);
      return false;
    }
    ad.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramcgx.Cta + ";upload_credit_url=" + paramcgx.tfJ);
    boolean bool;
    if (bt.kU("1", paramcgx.Cta))
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
      bool = a(paramActivity, paramBundle, null, paramInt2);
      AppMethodBeat.o(70197);
      return bool;
    }
    if ((bt.kU("2", paramcgx.Cta)) && (!bt.isNullOrNil(paramcgx.tfJ)))
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
      bool = a(paramActivity, paramcgx.tfG, paramcgx.tfJ, paramcgx.tfH, paramcgx.tfI, true, null);
      AppMethodBeat.o(70197);
      return bool;
    }
    ad.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramcgx.Cta + ";upload_credit_url=null?" + bt.isNullOrNil(paramcgx.tfJ));
    AppMethodBeat.o(70197);
    return false;
  }
  
  public static boolean a(final Activity paramActivity, Bundle paramBundle, final int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70200);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqR, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(i) });
    if (i >= 3)
    {
      AppMethodBeat.o(70200);
      return false;
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqR, Integer.valueOf(i + 1));
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
              if (this.Abd) {
                this.hUJ.finish();
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
              com.tencent.mm.wallet_core.ui.e.c(19, bt.aGK(), paramInt);
              paramAnonymousDialogInterface.dismiss();
              if (this.Abd) {
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
                if (this.Abd) {
                  this.hUJ.finish();
                }
                AppMethodBeat.o(70180);
              }
            });
            paramBundle.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(70181);
                if (this.Abd) {
                  this.hUJ.finish();
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
    com.tencent.mm.wallet_core.ui.e.c(19, bt.aGK(), paramInt);
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
    Object localObject = q(paramn);
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
              if (this.Abd) {
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
              com.tencent.mm.wallet_core.ui.e.X(paramActivity, localIntent);
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
                if (this.Abd) {
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
                if (this.Abd) {
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
  
  private void cLx()
  {
    AppMethodBeat.i(70189);
    if ((this.AaX != null) && (this.AaX.get() != null)) {
      ((com.tencent.mm.wallet_core.d.e)this.AaX.get()).cLx();
    }
    AppMethodBeat.o(70189);
  }
  
  private static JSONObject q(n paramn)
  {
    AppMethodBeat.i(70194);
    if ((paramn != null) && ((paramn instanceof m)))
    {
      paramn = ((m)paramn).getCommReqResp();
      if (paramn != null)
      {
        paramn = (dbl)paramn.gUT.gUX;
        if (paramn.DEv != null)
        {
          paramn = z.b(paramn.DEv);
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
    this.AaW = new WeakReference(paramMMActivity);
    this.AaX = new WeakReference(parame);
    this.AaY = paramBoolean;
    if ((this.AaW != null) && (this.AaW.get() != null))
    {
      this.AaV = parama;
      paramString1 = paramString1 + paramString2;
      parame = new l(paramMMActivity);
      parame.Anf = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70176);
          com.tencent.mm.wallet_core.ui.e.c(3, bt.aGK(), paramInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramString3);
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.e.X(paramMMActivity, paramAnonymousView);
          AppMethodBeat.o(70176);
        }
      };
      paramString3 = k.c(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.cd.a.ao(paramMMActivity, 2131165466));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(2131100711));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      com.tencent.mm.wallet_core.ui.e.c(0, bt.aGK(), paramInt);
      this.AaZ = com.tencent.mm.ui.base.h.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70182);
          com.tencent.mm.wallet_core.ui.e.c(2, bt.aGK(), paramInt);
          if ((a.this.AaX != null) && (a.this.AaX.get() != null))
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(385, a.this);
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_core.id_verify.model.d(a.this.mScene);
            ((com.tencent.mm.wallet_core.d.e)a.this.AaX.get()).b(paramAnonymousDialogInterface, true);
          }
          AppMethodBeat.o(70182);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70183);
          com.tencent.mm.wallet_core.ui.e.c(1, bt.aGK(), paramInt);
          a.this.d(1, -1, "cancel", false);
          AppMethodBeat.o(70183);
        }
      });
    }
    AppMethodBeat.o(70191);
  }
  
  public final boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(70188);
    this.AaY = false;
    com.tencent.mm.kernel.g.afC();
    long l1 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkL, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      com.tencent.mm.wallet_core.ui.e.c(5, bt.aGK(), paramInt);
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
  
  final void d(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70192);
    ad.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    if (this.AaV != null)
    {
      com.tencent.mm.kernel.g.afC();
      Object localObject = com.tencent.mm.kernel.g.afB().afk();
      ae.a locala = ae.a.FkM;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((ab)localObject).set(locala, Integer.valueOf(i));
        if (this.AaV.run(paramInt1, paramInt2, paramString, paramBoolean)) {
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
          if (this.AaW != null)
          {
            localObject = paramString;
            if (this.AaW.get() != null) {
              localObject = ((MMActivity)this.AaW.get()).getString(2131765901);
            }
          }
        }
        ad.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
        com.tencent.mm.ui.base.h.a((Context)this.AaW.get(), (String)localObject, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70184);
            paramAnonymousDialogInterface.dismiss();
            a.this.AaZ.dismiss();
            if ((a.this.AaW != null) && (a.this.AaW.get() != null)) {
              ((MMActivity)a.this.AaW.get()).finish();
            }
            a.this.destory();
            AppMethodBeat.o(70184);
          }
        });
        AppMethodBeat.o(70192);
        return;
      }
      if (this.AaZ != null) {
        this.AaZ.dismiss();
      }
      destory();
    }
    AppMethodBeat.o(70192);
  }
  
  final void destory()
  {
    AppMethodBeat.i(70193);
    this.AaY = false;
    if (this.AaZ != null)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
      this.AaZ = null;
    }
    if (this.AaX != null)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
      this.AaX.clear();
      this.AaX = null;
    }
    if (this.AaW != null)
    {
      ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
      this.AaW.clear();
      this.AaW = null;
    }
    ad.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
    this.AaV = null;
    AppMethodBeat.o(70193);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70190);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      cLx();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.wallet_core.id_verify.model.h)paramn;
        boolean bool = paramn.Aac.equals("1");
        if (bool)
        {
          ad.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
          d(0, paramInt2, paramString, bool);
          AppMethodBeat.o(70190);
          return;
        }
        paramString = paramn.title;
        String str1 = paramn.Aad;
        String str2 = paramn.Aae;
        String str3 = paramn.Aaf;
        paramInt1 = paramn.Aag;
        a((MMActivity)this.AaW.get(), (com.tencent.mm.wallet_core.d.e)this.AaX.get(), paramString, str1, str2, str3, this.AaV, false, paramInt1);
        AppMethodBeat.o(70190);
        return;
      }
      d(2, paramInt2, paramString, false);
      AppMethodBeat.o(70190);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.d))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(385, this);
      cLx();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        d(0, paramInt2, paramString, true);
        AppMethodBeat.o(70190);
        return;
      }
      d(3, paramInt2, paramString, false);
    }
    AppMethodBeat.o(70190);
  }
  
  public static abstract interface a
  {
    public abstract boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a
 * JD-Core Version:    0.7.0.1
 */