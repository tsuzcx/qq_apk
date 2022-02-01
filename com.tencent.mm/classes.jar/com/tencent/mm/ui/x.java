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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.network.ae;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import java.util.Map;

public final class x
{
  private static boolean FOZ = false;
  static ProgressDialog fpP = null;
  static SecurityImage ijd = null;
  
  public static com.tencent.mm.ui.widget.a.d a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(33449);
    kr localkr = new kr();
    localkr.dpk.status = 0;
    localkr.dpk.bvJ = 1;
    com.tencent.mm.sdk.b.a.ESL.l(localkr);
    paramActivity = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, paramActivity.getString(2131755906), new x.5(paramString2, paramActivity, paramIntent), new x.6(paramString2, paramActivity, paramIntent));
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
    ad.d("MicroMsg.MMErrorProcessor", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33448);
      return false;
      ad.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      com.tencent.mm.ui.base.h.a(paramActivity, 2131761065, 2131755906, new x.2(paramIntent, paramActivity));
      AppMethodBeat.o(33448);
      return true;
      ad.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      com.tencent.mm.ui.base.h.a(paramActivity, 2131755265, 2131755906, new x.3(paramIntent, paramActivity));
      AppMethodBeat.o(33448);
      return true;
      ad.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), paramString });
      String str;
      if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("autoauth_errmsg_"))) {
        str = paramString.substring(16);
      }
      do
      {
        paramString = str;
        if (!bt.isNullOrNil(str))
        {
          paramString = str;
          if (str.startsWith("<"))
          {
            Map localMap = bw.K(str, "e");
            paramString = str;
            if (localMap != null)
            {
              paramString = str;
              if (!bt.isNullOrNil((String)localMap.get(".e.Content"))) {
                paramString = (String)localMap.get(".e.Content");
              }
            }
          }
        }
        str = paramString;
        if (bt.isNullOrNil(paramString)) {
          str = aj.getContext().getString(2131761065);
        }
        com.tencent.mm.ui.base.h.d(paramActivity, str, aj.getContext().getString(2131755906), new x.4(paramIntent, paramActivity));
        AppMethodBeat.o(33448);
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      ad.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  public static boolean aZ(Activity paramActivity)
  {
    int j = 1;
    AppMethodBeat.i(33450);
    if (bt.aGh(g.Zd().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(33450);
      return false;
    }
    az.arV();
    int i;
    if ((((Integer)com.tencent.mm.model.c.afk().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!ay.isWifi(paramActivity)) || (i == 0)) {
        break label116;
      }
      i = j;
      label71:
      if ((com.tencent.mm.sdk.platformtools.i.cJT & 0x1) == 0) {
        break label121;
      }
      ad.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      i = 0;
    }
    for (;;)
    {
      if ((i == 0) || (!com.tencent.mm.pluginsdk.g.i.ewh())) {
        break label132;
      }
      boolean bool = ba(paramActivity);
      AppMethodBeat.o(33450);
      return bool;
      i = 0;
      break;
      label116:
      i = 0;
      break label71;
      label121:
      ad.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label132:
    AppMethodBeat.o(33450);
    return false;
  }
  
  private static boolean ba(Activity paramActivity)
  {
    AppMethodBeat.i(33453);
    b localb = b.evy();
    if (localb != null)
    {
      localb.evB();
      ad.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      AppMethodBeat.o(33453);
      return true;
    }
    if (com.tencent.mm.plugin.q.d.cRq() != null)
    {
      com.tencent.mm.plugin.q.d.cRq().fz(paramActivity).update(2);
      AppMethodBeat.o(33453);
      return true;
    }
    AppMethodBeat.o(33453);
    return false;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33452);
    ad.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.CpK), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cJR), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cJT) });
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
      if (com.tencent.mm.plugin.q.d.cRq() != null)
      {
        paramActivity = com.tencent.mm.plugin.q.d.cRq().d(paramActivity, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(33445);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 37L, 1L, true);
            this.hUJ.finish();
            MMAppMgr.m(this.hUJ, true);
            AppMethodBeat.o(33445);
          }
        });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 36L, 1L, true);
        paramActivity.update(1);
        AppMethodBeat.o(33452);
        return true;
      }
      AppMethodBeat.o(33452);
      return false;
    }
    long l = aj.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1L);
    ad.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[] { Long.valueOf(l), Long.valueOf(bt.lZ(l)) });
    if ((l != -1L) && (bt.lZ(l) < 86400L))
    {
      AppMethodBeat.o(33452);
      return true;
    }
    if ((com.tencent.mm.sdk.platformtools.i.cJT & 0x2) != 0)
    {
      ad.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      AppMethodBeat.o(33452);
      return true;
    }
    ad.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    String str = g.Zd().getValue("SilentDownloadApkAtWiFi");
    az.arV();
    if ((((Integer)com.tencent.mm.model.c.afk().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!bt.isNullOrNil(str)) && (bt.aGh(str) != 0))) {
        break label456;
      }
      bool = true;
      label338:
      if ((com.tencent.mm.sdk.platformtools.i.cJT & 0x1) == 0) {
        break label462;
      }
      ad.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      bool = false;
    }
    for (;;)
    {
      if (bt.aGh(str) != 0) {
        ad.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
      }
      ad.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label481;
      }
      if (com.tencent.mm.plugin.q.d.cRq() == null) {
        break label473;
      }
      paramActivity = com.tencent.mm.plugin.q.d.cRq().d(paramActivity, new x.1(paramActivity));
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 38L, 1L, true);
      paramActivity.update(2);
      AppMethodBeat.o(33452);
      return true;
      paramInt1 = 0;
      break;
      label456:
      bool = false;
      break label338;
      label462:
      ad.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label473:
    AppMethodBeat.o(33452);
    return false;
    label481:
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 40L, 1L, true);
    boolean bool = ba(paramActivity);
    AppMethodBeat.o(33452);
    return bool;
  }
  
  public static boolean jr(final Context paramContext)
  {
    AppMethodBeat.i(33451);
    final String str = com.tencent.mm.pluginsdk.g.i.ewe();
    int i = com.tencent.mm.pluginsdk.g.i.ewf();
    ad.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!bt.isNullOrNil(str)) && (!com.tencent.mm.pluginsdk.g.i.ewg()))
    {
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33444);
          if ((this.FPb == 4) && (b.evy() == null))
          {
            ad.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
            AppMethodBeat.o(33444);
            return;
          }
          if ((com.tencent.mm.plugin.q.d.cRq() != null) && (com.tencent.mm.plugin.q.d.cRq().ahi(str) != null)) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33443);
                if (com.tencent.mm.plugin.q.d.cRq() != null) {
                  com.tencent.mm.plugin.q.d.cRq().fA(x.7.this.val$context);
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
        if (((paramInt3 & 0x2) != 0) && (az.aeS().auS()))
        {
          az.aeS().getNetworkServerIp();
          new StringBuilder().append(paramInt2);
        }
        for (;;)
        {
          AppMethodBeat.o(33447);
          return true;
          if ((((paramInt3 & 0x1) == 0) || (!ae.cJ(paramContext)) || (!k.hm(paramContext))) && (((paramInt3 & 0x4) == 0) || (!ay.isWap(paramContext)) || (!MMAppMgr.jp(paramContext)))) {
            Toast.makeText(paramContext, paramContext.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
          }
        }
        Toast.makeText(paramContext, paramContext.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
        AppMethodBeat.o(33447);
        return true;
        AppMethodBeat.o(33447);
        return true;
        com.tencent.mm.h.a locala = com.tencent.mm.h.a.oG(paramString);
        if (locala != null)
        {
          ad.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(locala.dcz), locala.url, locala.desc });
          if (!bt.isNullOrNil(locala.url)) {}
          for (paramString = new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(33446);
                  paramAnonymousDialogInterface = new Intent();
                  StringBuilder localStringBuilder = new StringBuilder(this.hUM.url);
                  localStringBuilder.append("&wechat_real_lang=" + ac.eFu());
                  paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                  paramAnonymousDialogInterface.putExtra("showShare", false);
                  paramAnonymousDialogInterface.putExtra("show_bottom", false);
                  paramAnonymousDialogInterface.putExtra("needRedirect", false);
                  paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
                  com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */