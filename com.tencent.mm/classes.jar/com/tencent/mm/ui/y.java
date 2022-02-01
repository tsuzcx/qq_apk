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
import com.tencent.mm.g.a.lk;
import com.tencent.mm.model.bc;
import com.tencent.mm.n.e;
import com.tencent.mm.pluginsdk.i.j;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class y
{
  private static boolean Jxa = false;
  static ProgressDialog fOC = null;
  static SecurityImage jfm = null;
  
  public static com.tencent.mm.ui.widget.a.d a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(33449);
    lk locallk = new lk();
    locallk.dzN.status = 0;
    locallk.dzN.reason = 1;
    com.tencent.mm.sdk.b.a.IvT.l(locallk);
    paramActivity = h.a(paramActivity, paramString1, paramActivity.getString(2131755906), new y.5(paramString2, paramActivity, paramIntent), new y.6(paramString2, paramActivity, paramIntent));
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33448);
      return false;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      h.a(paramActivity, 2131761065, 2131755906, new y.2(paramIntent, paramActivity));
      AppMethodBeat.o(33448);
      return true;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      h.a(paramActivity, 2131755265, 2131755906, new y.3(paramIntent, paramActivity));
      AppMethodBeat.o(33448);
      return true;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), paramString });
      String str;
      if ((!bu.isNullOrNil(paramString)) && (paramString.startsWith("autoauth_errmsg_"))) {
        str = paramString.substring(16);
      }
      do
      {
        paramString = str;
        if (!bu.isNullOrNil(str))
        {
          paramString = str;
          if (str.startsWith("<"))
          {
            Map localMap = bx.M(str, "e");
            paramString = str;
            if (localMap != null)
            {
              paramString = str;
              if (!bu.isNullOrNil((String)localMap.get(".e.Content"))) {
                paramString = (String)localMap.get(".e.Content");
              }
            }
          }
        }
        str = paramString;
        if (bu.isNullOrNil(paramString)) {
          str = ak.getContext().getString(2131761065);
        }
        h.d(paramActivity, str, ak.getContext().getString(2131755906), new y.4(paramIntent, paramActivity));
        AppMethodBeat.o(33448);
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  public static boolean be(Activity paramActivity)
  {
    int j = 1;
    AppMethodBeat.i(33450);
    if (bu.aSB(com.tencent.mm.n.g.acL().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(33450);
      return false;
    }
    bc.aCg();
    int i;
    if ((((Integer)com.tencent.mm.model.c.ajA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!az.isWifi(paramActivity)) || (i == 0)) {
        break label116;
      }
      i = j;
      label71:
      if ((com.tencent.mm.sdk.platformtools.k.cSO & 0x1) == 0) {
        break label121;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      i = 0;
    }
    for (;;)
    {
      if ((i == 0) || (!j.fem())) {
        break label132;
      }
      boolean bool = bf(paramActivity);
      AppMethodBeat.o(33450);
      return bool;
      i = 0;
      break;
      label116:
      i = 0;
      break label71;
      label121:
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label132:
    AppMethodBeat.o(33450);
    return false;
  }
  
  private static boolean bf(Activity paramActivity)
  {
    AppMethodBeat.i(33453);
    b localb = b.fdA();
    if (localb != null)
    {
      localb.fdD();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      AppMethodBeat.o(33453);
      return true;
    }
    if (com.tencent.mm.plugin.q.d.drw() != null)
    {
      com.tencent.mm.plugin.q.d.drw().fW(paramActivity).update(2);
      AppMethodBeat.o(33453);
      return true;
    }
    AppMethodBeat.o(33453);
    return false;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33452);
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.FFH), Integer.valueOf(com.tencent.mm.sdk.platformtools.k.cSM), Integer.valueOf(com.tencent.mm.sdk.platformtools.k.cSO) });
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
      if (com.tencent.mm.plugin.q.d.drw() != null)
      {
        paramActivity = com.tencent.mm.plugin.q.d.drw().d(paramActivity, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(33445);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 37L, 1L, true);
            this.iQK.finish();
            MMAppMgr.m(this.iQK, true);
            AppMethodBeat.o(33445);
          }
        });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 36L, 1L, true);
        paramActivity.update(1);
        AppMethodBeat.o(33452);
        return true;
      }
      AppMethodBeat.o(33452);
      return false;
    }
    long l = ak.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1L);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[] { Long.valueOf(l), Long.valueOf(bu.rZ(l)) });
    if ((l != -1L) && (bu.rZ(l) < 86400L))
    {
      AppMethodBeat.o(33452);
      return true;
    }
    if ((com.tencent.mm.sdk.platformtools.k.cSO & 0x2) != 0)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      AppMethodBeat.o(33452);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    String str = com.tencent.mm.n.g.acL().getValue("SilentDownloadApkAtWiFi");
    bc.aCg();
    if ((((Integer)com.tencent.mm.model.c.ajA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!bu.isNullOrNil(str)) && (bu.aSB(str) != 0))) {
        break label456;
      }
      bool = true;
      label338:
      if ((com.tencent.mm.sdk.platformtools.k.cSO & 0x1) == 0) {
        break label462;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      bool = false;
    }
    for (;;)
    {
      if (bu.aSB(str) != 0) {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label481;
      }
      if (com.tencent.mm.plugin.q.d.drw() == null) {
        break label473;
      }
      paramActivity = com.tencent.mm.plugin.q.d.drw().d(paramActivity, new y.1(paramActivity));
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 38L, 1L, true);
      paramActivity.update(2);
      AppMethodBeat.o(33452);
      return true;
      paramInt1 = 0;
      break;
      label456:
      bool = false;
      break label338;
      label462:
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label473:
    AppMethodBeat.o(33452);
    return false;
    label481:
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 40L, 1L, true);
    boolean bool = bf(paramActivity);
    AppMethodBeat.o(33452);
    return bool;
  }
  
  public static boolean jU(final Context paramContext)
  {
    AppMethodBeat.i(33451);
    final String str = j.fej();
    int i = j.fek();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!bu.isNullOrNil(str)) && (!j.fel()))
    {
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33444);
          if ((this.Jxc == 4) && (b.fdA() == null))
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
            AppMethodBeat.o(33444);
            return;
          }
          if ((com.tencent.mm.plugin.q.d.drw() != null) && (com.tencent.mm.plugin.q.d.drw().arX(str) != null)) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33443);
                if (com.tencent.mm.plugin.q.d.drw() != null) {
                  com.tencent.mm.plugin.q.d.drw().fX(y.7.this.val$context);
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
        if (((paramInt3 & 0x2) != 0) && (bc.ajj().aFe()))
        {
          bc.ajj().getNetworkServerIp();
          new StringBuilder().append(paramInt2);
        }
        for (;;)
        {
          AppMethodBeat.o(33447);
          return true;
          if ((((paramInt3 & 0x1) == 0) || (!com.tencent.mm.network.ae.cR(paramContext)) || (!com.tencent.mm.pluginsdk.ui.tools.k.hI(paramContext))) && (((paramInt3 & 0x4) == 0) || (!az.isWap(paramContext)) || (!MMAppMgr.jS(paramContext)))) {
            Toast.makeText(paramContext, paramContext.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
          }
        }
        Toast.makeText(paramContext, paramContext.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
        AppMethodBeat.o(33447);
        return true;
        AppMethodBeat.o(33447);
        return true;
        com.tencent.mm.h.a locala = com.tencent.mm.h.a.uU(paramString);
        if (locala != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(locala.dmr), locala.url, locala.desc });
          if (!bu.isNullOrNil(locala.url)) {}
          for (paramString = new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(33446);
                  paramAnonymousDialogInterface = new Intent();
                  StringBuilder localStringBuilder = new StringBuilder(this.iQN.url);
                  localStringBuilder.append("&wechat_real_lang=" + ad.fom());
                  paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                  paramAnonymousDialogInterface.putExtra("showShare", false);
                  paramAnonymousDialogInterface.putExtra("show_bottom", false);
                  paramAnonymousDialogInterface.putExtra("needRedirect", false);
                  paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
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