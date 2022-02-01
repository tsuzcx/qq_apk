package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.la;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.applet.SecurityImage;
import java.util.Map;

public final class y
{
  private static boolean HoK = false;
  static ProgressDialog fts = null;
  static SecurityImage iJk = null;
  
  public static com.tencent.mm.ui.widget.a.d a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(33449);
    la localla = new la();
    localla.dmU.status = 0;
    localla.dmU.reason = 1;
    com.tencent.mm.sdk.b.a.GpY.l(localla);
    paramActivity = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, paramActivity.getString(2131755906), new y.5(paramString2, paramActivity, paramIntent), new y.6(paramString2, paramActivity, paramIntent));
    AppMethodBeat.o(33449);
    return paramActivity;
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(33448);
    if (paramInt1 != 4)
    {
      AppMethodBeat.o(33448);
      return false;
    }
    ac.d("MicroMsg.MMErrorProcessor", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33448);
      return false;
      ac.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      com.tencent.mm.ui.base.h.a(paramActivity, 2131761065, 2131755906, new y.2(paramIntent, paramActivity));
      AppMethodBeat.o(33448);
      return true;
      ac.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      com.tencent.mm.ui.base.h.a(paramActivity, 2131755265, 2131755906, new y.3(paramIntent, paramActivity));
      AppMethodBeat.o(33448);
      return true;
      ac.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), paramString });
      String str;
      if ((!bs.isNullOrNil(paramString)) && (paramString.startsWith("autoauth_errmsg_"))) {
        str = paramString.substring(16);
      }
      do
      {
        paramString = str;
        if (!bs.isNullOrNil(str))
        {
          paramString = str;
          if (str.startsWith("<"))
          {
            Map localMap = bv.L(str, "e");
            paramString = str;
            if (localMap != null)
            {
              paramString = str;
              if (!bs.isNullOrNil((String)localMap.get(".e.Content"))) {
                paramString = (String)localMap.get(".e.Content");
              }
            }
          }
        }
        str = paramString;
        if (bs.isNullOrNil(paramString)) {
          str = ai.getContext().getString(2131761065);
        }
        com.tencent.mm.ui.base.h.d(paramActivity, str, ai.getContext().getString(2131755906), new y.4(paramIntent, paramActivity));
        AppMethodBeat.o(33448);
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      ac.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  public static boolean bd(Activity paramActivity)
  {
    int j = 1;
    AppMethodBeat.i(33450);
    if (bs.aLy(g.ZY().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(33450);
      return false;
    }
    az.ayM();
    int i;
    if ((((Integer)com.tencent.mm.model.c.agA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!ax.isWifi(paramActivity)) || (i == 0)) {
        break label116;
      }
      i = j;
      label71:
      if ((com.tencent.mm.sdk.platformtools.i.cHa & 0x1) == 0) {
        break label121;
      }
      ac.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      i = 0;
    }
    for (;;)
    {
      if ((i == 0) || (!com.tencent.mm.pluginsdk.g.i.eLB())) {
        break label132;
      }
      boolean bool = be(paramActivity);
      AppMethodBeat.o(33450);
      return bool;
      i = 0;
      break;
      label116:
      i = 0;
      break label71;
      label121:
      ac.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label132:
    AppMethodBeat.o(33450);
    return false;
  }
  
  private static boolean be(Activity paramActivity)
  {
    AppMethodBeat.i(33453);
    b localb = b.eKS();
    if (localb != null)
    {
      localb.eKV();
      ac.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      AppMethodBeat.o(33453);
      return true;
    }
    if (com.tencent.mm.plugin.q.d.dfa() != null)
    {
      com.tencent.mm.plugin.q.d.dfa().fL(paramActivity).update(2);
      AppMethodBeat.o(33453);
      return true;
    }
    AppMethodBeat.o(33453);
    return false;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33452);
    ac.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.DIc), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cGY), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cHa) });
    if (paramInt1 != 4)
    {
      AppMethodBeat.o(33452);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(33452);
      return false;
    case -16: 
      if (com.tencent.mm.plugin.q.d.dfa() != null)
      {
        paramActivity = com.tencent.mm.plugin.q.d.dfa().d(paramActivity, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(33445);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 37L, 1L, true);
            this.iuN.finish();
            MMAppMgr.m(this.iuN, true);
            AppMethodBeat.o(33445);
          }
        });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 36L, 1L, true);
        paramActivity.update(1);
        AppMethodBeat.o(33452);
        return true;
      }
      AppMethodBeat.o(33452);
      return false;
    }
    long l = ai.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1L);
    ac.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[] { Long.valueOf(l), Long.valueOf(bs.pN(l)) });
    if ((l != -1L) && (bs.pN(l) < 86400L))
    {
      AppMethodBeat.o(33452);
      return true;
    }
    if ((com.tencent.mm.sdk.platformtools.i.cHa & 0x2) != 0)
    {
      ac.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      AppMethodBeat.o(33452);
      return true;
    }
    ac.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    String str = g.ZY().getValue("SilentDownloadApkAtWiFi");
    az.ayM();
    if ((((Integer)com.tencent.mm.model.c.agA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!bs.isNullOrNil(str)) && (bs.aLy(str) != 0))) {
        break label456;
      }
      bool = true;
      label338:
      if ((com.tencent.mm.sdk.platformtools.i.cHa & 0x1) == 0) {
        break label462;
      }
      ac.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      bool = false;
    }
    for (;;)
    {
      if (bs.aLy(str) != 0) {
        ac.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
      }
      ac.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label481;
      }
      if (com.tencent.mm.plugin.q.d.dfa() == null) {
        break label473;
      }
      paramActivity = com.tencent.mm.plugin.q.d.dfa().d(paramActivity, new y.1(paramActivity));
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 38L, 1L, true);
      paramActivity.update(2);
      AppMethodBeat.o(33452);
      return true;
      paramInt1 = 0;
      break;
      label456:
      bool = false;
      break label338;
      label462:
      ac.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label473:
    AppMethodBeat.o(33452);
    return false;
    label481:
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 40L, 1L, true);
    boolean bool = be(paramActivity);
    AppMethodBeat.o(33452);
    return bool;
  }
  
  public static boolean jC(final Context paramContext)
  {
    AppMethodBeat.i(33451);
    final String str = com.tencent.mm.pluginsdk.g.i.eLy();
    int i = com.tencent.mm.pluginsdk.g.i.eLz();
    ac.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!bs.isNullOrNil(str)) && (!com.tencent.mm.pluginsdk.g.i.eLA()))
    {
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33444);
          if ((this.HoM == 4) && (b.eKS() == null))
          {
            ac.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
            AppMethodBeat.o(33444);
            return;
          }
          if ((com.tencent.mm.plugin.q.d.dfa() != null) && (com.tencent.mm.plugin.q.d.dfa().amd(str) != null)) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33443);
                if (com.tencent.mm.plugin.q.d.dfa() != null) {
                  com.tencent.mm.plugin.q.d.dfa().fM(y.7.this.val$context);
                }
                AppMethodBeat.o(33443);
              }
            });
          }
          AppMethodBeat.o(33444);
        }
      });
      AppMethodBeat.o(33451);
      return true;
    }
    AppMethodBeat.o(33451);
    return false;
  }
  
  public static final class a
  {
    public static boolean a(final Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(33447);
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(33447);
        return false;
        if (((paramInt3 & 0x2) != 0) && (az.agi().aBL()))
        {
          az.agi().getNetworkServerIp();
          new StringBuilder().append(paramInt2);
        }
        for (;;)
        {
          AppMethodBeat.o(33447);
          return true;
          if ((((paramInt3 & 0x1) == 0) || (!com.tencent.mm.network.ae.cS(paramContext)) || (!k.hx(paramContext))) && (((paramInt3 & 0x4) == 0) || (!ax.isWap(paramContext)) || (!MMAppMgr.jA(paramContext)))) {
            Toast.makeText(paramContext, paramContext.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
          }
        }
        Toast.makeText(paramContext, paramContext.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
        AppMethodBeat.o(33447);
        return true;
        AppMethodBeat.o(33447);
        return true;
        com.tencent.mm.h.a locala = com.tencent.mm.h.a.rM(paramString);
        if (locala != null)
        {
          ac.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(locala.cZX), locala.url, locala.desc });
          if (!bs.isNullOrNil(locala.url)) {}
          for (paramString = new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(33446);
                  paramAnonymousDialogInterface = new Intent();
                  StringBuilder localStringBuilder = new StringBuilder(this.iuQ.url);
                  localStringBuilder.append("&wechat_real_lang=" + ab.eUO());
                  paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                  paramAnonymousDialogInterface.putExtra("showShare", false);
                  paramAnonymousDialogInterface.putExtra("show_bottom", false);
                  paramAnonymousDialogInterface.putExtra("needRedirect", false);
                  paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
                  com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                  AppMethodBeat.o(33446);
                }
              }; locala.a(paramContext, paramString, null); paramString = null)
          {
            AppMethodBeat.o(33447);
            return true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.y
 * JD-Core Version:    0.7.0.1
 */