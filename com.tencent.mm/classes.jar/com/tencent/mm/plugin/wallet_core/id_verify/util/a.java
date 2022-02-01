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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements i
{
  private a HUD = null;
  WeakReference<MMActivity> HUE;
  WeakReference<com.tencent.mm.wallet_core.d.e> HUF;
  private boolean HUG = false;
  com.tencent.mm.ui.widget.a.d HUH;
  int mScene = -1;
  
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
  
  public static boolean a(Activity paramActivity, int paramInt1, dju paramdju, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(70197);
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      AppMethodBeat.o(70197);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    if (paramdju == null)
    {
      AppMethodBeat.o(70197);
      return false;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramdju.KCl + ";upload_credit_url=" + paramdju.yXK);
    boolean bool;
    if (Util.isEqual("1", paramdju.KCl))
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
      bool = a(paramActivity, paramBundle, null, paramInt2);
      AppMethodBeat.o(70197);
      return bool;
    }
    if ((Util.isEqual("2", paramdju.KCl)) && (!Util.isNullOrNil(paramdju.yXK)))
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
      bool = a(paramActivity, paramdju.yXJ, paramdju.yXK, paramdju.lHA, paramdju.lHB, true, null);
      AppMethodBeat.o(70197);
      return bool;
    }
    Log.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramdju.KCl + ";upload_credit_url=null?" + Util.isNullOrNil(paramdju.yXK));
    AppMethodBeat.o(70197);
    return false;
  }
  
  public static boolean a(final Activity paramActivity, Bundle paramBundle, final int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70200);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.OdT, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(i) });
    if (i >= 3)
    {
      AppMethodBeat.o(70200);
      return false;
    }
    g.aAi();
    g.aAh().azQ().set(ar.a.OdT, Integer.valueOf(i + 1));
    if (Util.isNullOrNil(paramString2)) {
      paramString2 = paramActivity.getString(2131755761);
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString3)) {
        paramString3 = paramActivity.getString(2131755921);
      }
      for (;;)
      {
        if (paramOnClickListener == null) {
          paramOnClickListener = new a.3(false, paramActivity);
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
              f.d(19, Util.nowSecond(), paramInt);
              paramAnonymousDialogInterface.dismiss();
              if (this.HUL) {
                paramActivity.finish();
              }
              AppMethodBeat.o(70179);
            }
          }, paramOnClickListener, 2131101414);
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
    f.d(19, Util.nowSecond(), paramInt);
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
      str3 = paramq.optString("left_button_wording", paramActivity.getString(2131755761));
      str4 = paramq.optString("right_button_wording", paramActivity.getString(2131755921));
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
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70199);
    if (Util.isNullOrNil(paramString3)) {
      paramString3 = paramActivity.getString(2131755761);
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString4)) {
        paramString4 = paramActivity.getString(2131755921);
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
          paramString1 = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, "", paramString4, paramString3, new a.11(paramString2, paramActivity, paramBoolean), paramOnClickListener, 2131101414);
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
  
  private void efi()
  {
    AppMethodBeat.i(70189);
    if ((this.HUF != null) && (this.HUF.get() != null)) {
      ((com.tencent.mm.wallet_core.d.e)this.HUF.get()).efi();
    }
    AppMethodBeat.o(70189);
  }
  
  private static JSONObject r(q paramq)
  {
    AppMethodBeat.i(70194);
    if ((paramq != null) && ((paramq instanceof m)))
    {
      paramq = ((m)paramq).getCommReqResp();
      if (paramq != null)
      {
        paramq = (ehb)paramq.iLL.iLR;
        if (paramq.MhT != null)
        {
          paramq = z.b(paramq.MhT);
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
  
  public final void a(final MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, String paramString1, String paramString2, final String paramString3, String paramString4, a parama, boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(70191);
    this.HUE = new WeakReference(paramMMActivity);
    this.HUF = new WeakReference(parame);
    this.HUG = paramBoolean;
    if ((this.HUE != null) && (this.HUE.get() != null))
    {
      this.HUD = parama;
      paramString1 = paramString1 + paramString2;
      parame = new com.tencent.mm.plugin.wallet_core.ui.l(paramMMActivity);
      parame.IgH = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70176);
          f.d(3, Util.nowSecond(), paramInt);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramString3);
          paramAnonymousView.putExtra("showShare", false);
          f.aA(paramMMActivity, paramAnonymousView);
          AppMethodBeat.o(70176);
        }
      };
      paramString3 = com.tencent.mm.pluginsdk.ui.span.l.c(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.cb.a.aG(paramMMActivity, 2131165482));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(2131100904));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      f.d(0, Util.nowSecond(), paramInt);
      this.HUH = com.tencent.mm.ui.base.h.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70182);
          f.d(2, Util.nowSecond(), paramInt);
          if ((a.this.HUF != null) && (a.this.HUF.get() != null))
          {
            g.aAi();
            g.aAg().hqi.a(385, a.this);
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.wallet_core.id_verify.model.d(a.this.mScene);
            ((com.tencent.mm.wallet_core.d.e)a.this.HUF.get()).b(paramAnonymousDialogInterface, true);
          }
          AppMethodBeat.o(70182);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70183);
          f.d(1, Util.nowSecond(), paramInt);
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
    this.HUG = false;
    g.aAi();
    long l1 = ((Long)g.aAh().azQ().get(ar.a.NXr, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      f.d(5, Util.nowSecond(), paramInt);
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
  
  final void c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70192);
    Log.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    if (this.HUD != null)
    {
      g.aAi();
      Object localObject = g.aAh().azQ();
      ar.a locala = ar.a.NXs;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((ao)localObject).set(locala, Integer.valueOf(i));
        if (this.HUD.run(paramInt1, paramInt2, paramString, paramBoolean)) {
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
          if (this.HUE != null)
          {
            localObject = paramString;
            if (this.HUE.get() != null) {
              localObject = ((MMActivity)this.HUE.get()).getString(2131768354);
            }
          }
        }
        Log.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
        com.tencent.mm.ui.base.h.a((Context)this.HUE.get(), (String)localObject, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70184);
            paramAnonymousDialogInterface.dismiss();
            a.this.HUH.dismiss();
            if ((a.this.HUE != null) && (a.this.HUE.get() != null)) {
              ((MMActivity)a.this.HUE.get()).finish();
            }
            a.this.destory();
            AppMethodBeat.o(70184);
          }
        });
        AppMethodBeat.o(70192);
        return;
      }
      if (this.HUH != null) {
        this.HUH.dismiss();
      }
      destory();
    }
    AppMethodBeat.o(70192);
  }
  
  final void destory()
  {
    AppMethodBeat.i(70193);
    this.HUG = false;
    if (this.HUH != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
      this.HUH = null;
    }
    if (this.HUF != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
      this.HUF.clear();
      this.HUF = null;
    }
    if (this.HUE != null)
    {
      Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
      this.HUE.clear();
      this.HUE = null;
    }
    Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
    this.HUD = null;
    AppMethodBeat.o(70193);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70190);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h))
    {
      g.aAi();
      g.aAg().hqi.b(385, this);
      efi();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (com.tencent.mm.plugin.wallet_core.id_verify.model.h)paramq;
        boolean bool = paramq.HTK.equals("1");
        if (bool)
        {
          Log.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
          c(0, paramInt2, paramString, bool);
          AppMethodBeat.o(70190);
          return;
        }
        paramString = paramq.title;
        String str1 = paramq.HTL;
        String str2 = paramq.HTM;
        String str3 = paramq.HTN;
        paramInt1 = paramq.HTO;
        a((MMActivity)this.HUE.get(), (com.tencent.mm.wallet_core.d.e)this.HUF.get(), paramString, str1, str2, str3, this.HUD, false, paramInt1);
        AppMethodBeat.o(70190);
        return;
      }
      c(2, paramInt2, paramString, false);
      AppMethodBeat.o(70190);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.d))
    {
      g.aAi();
      g.aAg().hqi.a(385, this);
      efi();
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