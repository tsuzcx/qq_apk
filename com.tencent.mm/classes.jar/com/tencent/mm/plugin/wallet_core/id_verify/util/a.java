package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.wallet_core.c.a;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements f
{
  int mScene = -1;
  private a ueJ = null;
  WeakReference<MMActivity> ueK;
  WeakReference<com.tencent.mm.wallet_core.d.e> ueL;
  private boolean ueM = false;
  c ueN;
  
  public static boolean a(Activity paramActivity, int paramInt1, com.tencent.mm.ai.m paramm, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(46684);
    if (paramInt1 != 416)
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(46684);
      return false;
    }
    ab.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    boolean bool = a(paramActivity, paramm, paramBundle, false, paramInt2);
    AppMethodBeat.o(46684);
    return bool;
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, bry parambry, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(46686);
    if (paramInt1 != 416)
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(46686);
      return false;
    }
    ab.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    if (parambry == null)
    {
      AppMethodBeat.o(46686);
      return false;
    }
    ab.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + parambry.wkQ + ";upload_credit_url=" + parambry.opE);
    boolean bool;
    if (bo.isEqual("1", parambry.wkQ))
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
      bool = a(paramActivity, paramBundle, null, paramInt2);
      AppMethodBeat.o(46686);
      return bool;
    }
    if ((bo.isEqual("2", parambry.wkQ)) && (!bo.isNullOrNil(parambry.opE)))
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
      bool = a(paramActivity, parambry.opB, parambry.opE, parambry.opC, parambry.opD, true, null);
      AppMethodBeat.o(46686);
      return bool;
    }
    ab.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + parambry.wkQ + ";upload_credit_url=null?" + bo.isNullOrNil(parambry.opE));
    AppMethodBeat.o(46686);
    return false;
  }
  
  public static boolean a(Activity paramActivity, Bundle paramBundle, int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(46689);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yHV, Integer.valueOf(0))).intValue();
    ab.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(i) });
    if (i >= 3)
    {
      AppMethodBeat.o(46689);
      return false;
    }
    g.RM();
    g.RL().Ru().set(ac.a.yHV, Integer.valueOf(i + 1));
    if (bo.isNullOrNil(paramString2)) {
      paramString2 = paramActivity.getString(2131296888);
    }
    for (;;)
    {
      if (bo.isNullOrNil(paramString3)) {
        paramString3 = paramActivity.getString(2131297018);
      }
      for (;;)
      {
        if (paramOnClickListener == null) {
          paramOnClickListener = new a.3(paramActivity);
        }
        for (;;)
        {
          paramBundle = h.a(paramActivity, paramString1, "", paramString3, paramString2, new a.4(paramBundle, paramInt, paramActivity), paramOnClickListener, 2131690701);
          if (paramBundle != null)
          {
            paramBundle.setOnCancelListener(new a.5(paramActivity));
            paramBundle.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(46671);
                if (this.ueR) {
                  this.gjR.finish();
                }
                AppMethodBeat.o(46671);
              }
            });
          }
          AppMethodBeat.o(46689);
          return true;
        }
      }
    }
  }
  
  public static boolean a(Activity paramActivity, Bundle paramBundle, c.a parama, int paramInt)
  {
    AppMethodBeat.i(46687);
    ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[] { Integer.valueOf(0) });
    ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", paramInt);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, parama);
    com.tencent.mm.wallet_core.ui.e.a(19, bo.aox(), paramInt);
    AppMethodBeat.o(46687);
    return true;
  }
  
  public static boolean a(Activity paramActivity, com.tencent.mm.ai.m paramm, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(46685);
    String str1 = "";
    String str3 = "";
    String str4 = "";
    String str2 = "";
    Object localObject = p(paramm);
    if (localObject != null)
    {
      paramm = (com.tencent.mm.ai.m)localObject;
      if (((JSONObject)localObject).has("real_name_info")) {
        paramm = ((JSONObject)localObject).optJSONObject("real_name_info");
      }
      localObject = paramm.optString("guide_flag", "0");
      str1 = paramm.optString("guide_wording");
      str3 = paramm.optString("left_button_wording", paramActivity.getString(2131296888));
      str4 = paramm.optString("right_button_wording", paramActivity.getString(2131297018));
      str2 = paramm.optString("upload_credit_url", "");
    }
    for (paramm = (com.tencent.mm.ai.m)localObject;; paramm = "")
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramm + ";upload_credit_url=" + str2);
      if ("1".equals(paramm))
      {
        ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
        paramBoolean = a(paramActivity, paramBundle, null, paramInt);
        AppMethodBeat.o(46685);
        return paramBoolean;
      }
      if (("2".equals(paramm)) && (!bo.isNullOrNil(str2)))
      {
        ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
        paramBoolean = a(paramActivity, str1, str2, str3, str4, paramBoolean, null);
        AppMethodBeat.o(46685);
        return paramBoolean;
      }
      ab.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramm + ";upload_credit_url=null?" + bo.isNullOrNil(str2));
      AppMethodBeat.o(46685);
      return false;
    }
  }
  
  public static boolean a(final Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, final boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(46688);
    if (bo.isNullOrNil(paramString3)) {
      paramString3 = paramActivity.getString(2131296888);
    }
    for (;;)
    {
      if (bo.isNullOrNil(paramString4)) {
        paramString4 = paramActivity.getString(2131297018);
      }
      for (;;)
      {
        if (paramOnClickListener == null)
        {
          ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
          paramOnClickListener = new a.10(paramBoolean, paramActivity);
        }
        for (;;)
        {
          paramString1 = h.a(paramActivity, paramString1, "", paramString4, paramString3, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(46675);
              ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", this.val$url);
              localIntent.putExtra("showShare", false);
              d.b(paramActivity, "webview", ".ui.tools.WebViewUI", localIntent);
              paramAnonymousDialogInterface.dismiss();
              if (paramBoolean) {
                paramActivity.finish();
              }
              AppMethodBeat.o(46675);
            }
          }, paramOnClickListener, 2131690701);
          if (paramString1 != null)
          {
            paramString1.setOnCancelListener(new a.12(paramBoolean, paramActivity));
            paramString1.setOnDismissListener(new a.2(paramBoolean, paramActivity));
          }
          AppMethodBeat.o(46688);
          return true;
        }
      }
    }
  }
  
  private void bNp()
  {
    AppMethodBeat.i(46678);
    if ((this.ueL != null) && (this.ueL.get() != null)) {
      ((com.tencent.mm.wallet_core.d.e)this.ueL.get()).bNp();
    }
    AppMethodBeat.o(46678);
  }
  
  private static JSONObject p(com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(46683);
    if ((paramm != null) && ((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.m)))
    {
      paramm = ((com.tencent.mm.wallet_core.tenpay.model.m)paramm).getCommReqResp();
      if (paramm != null)
      {
        paramm = (cjt)paramm.fsW.fta;
        if (paramm.xkL != null)
        {
          paramm = aa.b(paramm.xkL);
          try
          {
            paramm = new JSONObject(paramm);
            AppMethodBeat.o(46683);
            return paramm;
          }
          catch (JSONException paramm)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.RealnameVerifyUtil", paramm, "", new Object[0]);
              paramm = null;
            }
          }
        }
      }
    }
    AppMethodBeat.o(46683);
    return null;
  }
  
  public final void a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, String paramString1, String paramString2, String paramString3, String paramString4, a parama, boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(46680);
    this.ueK = new WeakReference(paramMMActivity);
    this.ueL = new WeakReference(parame);
    this.ueM = paramBoolean;
    if ((this.ueK != null) && (this.ueK.get() != null))
    {
      this.ueJ = parama;
      paramString1 = paramString1 + paramString2;
      parame = new com.tencent.mm.plugin.wallet_core.ui.j(paramMMActivity);
      parame.uqj = new a.1(this, paramInt, paramString3, paramMMActivity);
      paramString3 = com.tencent.mm.pluginsdk.ui.d.j.b(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.cb.a.ao(paramMMActivity, 2131427758));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(2131690322));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      com.tencent.mm.wallet_core.ui.e.a(0, bo.aox(), paramInt);
      this.ueN = h.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(2131296888), new a.7(this, paramInt), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(46673);
          com.tencent.mm.wallet_core.ui.e.a(1, bo.aox(), paramInt);
          a.this.c(1, -1, "cancel", false);
          AppMethodBeat.o(46673);
        }
      });
    }
    AppMethodBeat.o(46680);
  }
  
  public final boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(46677);
    this.ueM = false;
    g.RM();
    long l1 = ((Long)g.RL().Ru().get(ac.a.yCp, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      com.tencent.mm.wallet_core.ui.e.a(5, bo.aox(), paramInt);
      if (l2 < l1)
      {
        ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = ".concat(String.valueOf(l1)));
        AppMethodBeat.o(46677);
        return false;
      }
      ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = ".concat(String.valueOf(l1)));
    }
    if (paramMMActivity == null)
    {
      ab.e("MicroMsg.RealnameVerifyUtil", "context is null");
      AppMethodBeat.o(46677);
      return false;
    }
    if (parame == null)
    {
      ab.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
      AppMethodBeat.o(46677);
      return false;
    }
    AppMethodBeat.o(46677);
    return false;
  }
  
  final void c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46681);
    ab.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    if (this.ueJ != null)
    {
      g.RM();
      Object localObject = g.RL().Ru();
      ac.a locala = ac.a.yCq;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((z)localObject).set(locala, Integer.valueOf(i));
        if (this.ueJ.run(paramInt1, paramInt2, paramString, paramBoolean)) {
          break;
        }
        ab.e("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback: errCode = " + paramInt2 + ";errMsg = " + paramString);
        if (paramInt1 != 3) {
          break;
        }
        localObject = paramString;
        if (bo.isNullOrNil(paramString))
        {
          localObject = paramString;
          if (this.ueK != null)
          {
            localObject = paramString;
            if (this.ueK.get() != null) {
              localObject = ((MMActivity)this.ueK.get()).getString(2131305682);
            }
          }
        }
        ab.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
        h.a((Context)this.ueK.get(), (String)localObject, null, false, new a.9(this));
        AppMethodBeat.o(46681);
        return;
      }
      if (this.ueN != null) {
        this.ueN.dismiss();
      }
      destory();
    }
    AppMethodBeat.o(46681);
  }
  
  final void destory()
  {
    AppMethodBeat.i(46682);
    this.ueM = false;
    if (this.ueN != null)
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
      this.ueN = null;
    }
    if (this.ueL != null)
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
      this.ueL.clear();
      this.ueL = null;
    }
    if (this.ueK != null)
    {
      ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
      this.ueK.clear();
      this.ueK = null;
    }
    ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
    this.ueJ = null;
    AppMethodBeat.o(46682);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(46679);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e))
    {
      g.RM();
      g.RK().eHt.b(385, this);
      bNp();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (com.tencent.mm.plugin.wallet_core.id_verify.model.e)paramm;
        boolean bool = paramm.uef.equals("1");
        if (bool)
        {
          ab.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
          c(0, paramInt2, paramString, bool);
          AppMethodBeat.o(46679);
          return;
        }
        paramString = paramm.title;
        String str1 = paramm.ueg;
        String str2 = paramm.ueh;
        String str3 = paramm.uei;
        paramInt1 = paramm.uej;
        a((MMActivity)this.ueK.get(), (com.tencent.mm.wallet_core.d.e)this.ueL.get(), paramString, str1, str2, str3, this.ueJ, false, paramInt1);
        AppMethodBeat.o(46679);
        return;
      }
      c(2, paramInt2, paramString, false);
      AppMethodBeat.o(46679);
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.a))
    {
      g.RM();
      g.RK().eHt.a(385, this);
      bNp();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        c(0, paramInt2, paramString, true);
        AppMethodBeat.o(46679);
        return;
      }
      c(3, paramInt2, paramString, false);
    }
    AppMethodBeat.o(46679);
  }
  
  public static abstract interface a
  {
    public abstract boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a
 * JD-Core Version:    0.7.0.1
 */