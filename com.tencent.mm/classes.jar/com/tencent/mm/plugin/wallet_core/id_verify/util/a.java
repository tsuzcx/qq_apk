package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bxh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.o;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements f
{
  int fzn = -1;
  private boolean qsA = false;
  c qsB;
  private a.a qsx = null;
  WeakReference<MMActivity> qsy;
  WeakReference<com.tencent.mm.wallet_core.d.e> qsz;
  
  public static boolean a(Activity paramActivity, int paramInt1, m paramm, Bundle paramBundle, int paramInt2)
  {
    if (paramInt1 != 416)
    {
      y.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
      return false;
    }
    y.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
    return a(paramActivity, paramm, paramBundle, false, paramInt2);
  }
  
  public static boolean a(Activity paramActivity, Bundle paramBundle, c.a parama, int paramInt)
  {
    y.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[] { Integer.valueOf(0) });
    y.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", paramInt);
    com.tencent.mm.wallet_core.a.a(paramActivity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, parama);
    com.tencent.mm.wallet_core.ui.e.a(19, bk.UX(), paramInt);
    return true;
  }
  
  public static boolean a(Activity paramActivity, m paramm, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    String str1 = "";
    String str3 = "";
    String str4 = "";
    String str2 = "";
    Object localObject = p(paramm);
    if (localObject != null)
    {
      paramm = (m)localObject;
      if (((JSONObject)localObject).has("real_name_info")) {
        paramm = ((JSONObject)localObject).optJSONObject("real_name_info");
      }
      localObject = paramm.optString("guide_flag", "0");
      str1 = paramm.optString("guide_wording");
      str3 = paramm.optString("left_button_wording", paramActivity.getString(a.i.app_cancel));
      str4 = paramm.optString("right_button_wording", paramActivity.getString(a.i.app_ok));
      str2 = paramm.optString("upload_credit_url", "");
    }
    for (paramm = (m)localObject;; paramm = "")
    {
      y.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + paramm + ";upload_credit_url=" + str2);
      if ("1".equals(paramm))
      {
        y.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
        return a(paramActivity, paramBundle, null, paramInt);
      }
      if (("2".equals(paramm)) && (!bk.bl(str2)))
      {
        y.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
        return a(paramActivity, str1, str2, str3, str4, paramBoolean, null);
      }
      y.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + paramm + ";upload_credit_url=null?" + bk.bl(str2));
      return false;
    }
  }
  
  public static boolean a(final Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (bk.bl(paramString3)) {
      paramString3 = paramActivity.getString(a.i.app_cancel);
    }
    for (;;)
    {
      if (bk.bl(paramString4)) {
        paramString4 = paramActivity.getString(a.i.app_ok);
      }
      for (;;)
      {
        if (paramOnClickListener == null)
        {
          y.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
          paramOnClickListener = new a.8(paramBoolean, paramActivity);
        }
        for (;;)
        {
          paramString1 = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, "", paramString4, paramString3, new a.9(paramString2, paramActivity, paramBoolean), paramOnClickListener, a.c.wechat_green);
          if (paramString1 != null)
          {
            paramString1.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                if (this.qsF) {
                  paramActivity.finish();
                }
              }
            });
            paramString1.setOnDismissListener(new a.2(paramBoolean, paramActivity));
          }
          return true;
        }
      }
    }
  }
  
  private void bfJ()
  {
    if ((this.qsz != null) && (this.qsz.get() != null)) {
      ((com.tencent.mm.wallet_core.d.e)this.qsz.get()).bfJ();
    }
  }
  
  private static JSONObject p(m paramm)
  {
    if ((paramm != null) && ((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.j)))
    {
      paramm = ((com.tencent.mm.wallet_core.tenpay.model.j)paramm).dmK;
      if (paramm != null)
      {
        paramm = (bxh)paramm.ecF.ecN;
        if (paramm.tls != null)
        {
          paramm = aa.b(paramm.tls);
          try
          {
            paramm = new JSONObject(paramm);
            return paramm;
          }
          catch (JSONException paramm)
          {
            y.printErrStackTrace("MicroMsg.RealnameVerifyUtil", paramm, "", new Object[0]);
            return null;
          }
        }
      }
    }
    return null;
  }
  
  public final void a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, String paramString1, String paramString2, String paramString3, String paramString4, a.a parama, boolean paramBoolean, int paramInt)
  {
    this.qsy = new WeakReference(paramMMActivity);
    this.qsz = new WeakReference(parame);
    this.qsA = paramBoolean;
    if ((this.qsy != null) && (this.qsy.get() != null))
    {
      this.qsx = parama;
      paramString1 = paramString1 + paramString2;
      parame = new com.tencent.mm.plugin.wallet_core.ui.h(paramMMActivity);
      parame.qDo = new a.1(this, paramInt, paramString3, paramMMActivity);
      paramString3 = com.tencent.mm.pluginsdk.ui.d.j.b(paramMMActivity, paramString1);
      paramString1 = new SpannableString(paramString3);
      paramString1.setSpan(parame, paramString3.length() - paramString2.length(), paramString3.length(), 33);
      parame = new TextView(paramMMActivity);
      parame.setText(paramString1);
      parame.setTextSize(0, com.tencent.mm.cb.a.aa(paramMMActivity, a.d.HintTextSize));
      parame.setTextColor(paramMMActivity.getResources().getColorStateList(a.c.normal_text_color));
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      com.tencent.mm.wallet_core.ui.e.a(0, bk.UX(), paramInt);
      this.qsB = com.tencent.mm.ui.base.h.a(paramMMActivity, "", parame, paramString4, paramMMActivity.getString(a.i.app_cancel), new a.6(this, paramInt), new a.7(this, paramInt));
    }
  }
  
  public final boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    this.qsA = false;
    g.DQ();
    long l1 = ((Long)g.DP().Dz().get(ac.a.usp, Long.valueOf(0L))).longValue();
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      com.tencent.mm.wallet_core.ui.e.a(5, bk.UX(), paramInt);
      if (l2 < l1) {
        y.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = " + l1);
      }
    }
    do
    {
      return false;
      y.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = " + l1);
      if (paramMMActivity == null)
      {
        y.e("MicroMsg.RealnameVerifyUtil", "context is null");
        return false;
      }
    } while (parame != null);
    y.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
    return false;
  }
  
  final void e(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
    z localz;
    ac.a locala;
    if (this.qsx != null)
    {
      g.DQ();
      localz = g.DP().Dz();
      locala = ac.a.usq;
      if (!paramBoolean) {
        break label174;
      }
    }
    label174:
    for (int i = 0;; i = 1)
    {
      localz.c(locala, Integer.valueOf(i));
      this.qsx.c(paramInt1, paramInt2, paramString, paramBoolean);
      if (this.qsB != null) {
        this.qsB.dismiss();
      }
      this.qsA = false;
      if (this.qsB != null)
      {
        y.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
        this.qsB = null;
      }
      if (this.qsz != null)
      {
        y.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
        this.qsz.clear();
        this.qsz = null;
      }
      if (this.qsy != null)
      {
        y.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
        this.qsy.clear();
        this.qsy = null;
      }
      y.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
      this.qsx = null;
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e))
    {
      g.DQ();
      g.DO().dJT.b(385, this);
      bfJ();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (com.tencent.mm.plugin.wallet_core.id_verify.model.e)paramm;
        bool = paramm.qsh.equals("1");
        if (bool)
        {
          y.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
          e(0, paramInt2, paramString, bool);
        }
      }
    }
    while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.a))
    {
      boolean bool;
      return;
      paramString = paramm.title;
      String str1 = paramm.qsi;
      String str2 = paramm.qsj;
      String str3 = paramm.qsk;
      paramInt1 = paramm.qsl;
      a((MMActivity)this.qsy.get(), (com.tencent.mm.wallet_core.d.e)this.qsz.get(), paramString, str1, str2, str3, this.qsx, false, paramInt1);
      return;
      e(2, paramInt2, paramString, false);
      return;
    }
    g.DQ();
    g.DO().dJT.a(385, this);
    bfJ();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e(0, paramInt2, paramString, true);
      return;
    }
    e(3, paramInt2, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a
 * JD-Core Version:    0.7.0.1
 */