package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.jf;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.network.ab;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.Map;

public final class w
{
  static ProgressDialog dnm = null;
  static SecurityImage fex;
  private static boolean uNY = false;
  
  static
  {
    fex = null;
  }
  
  public static boolean Z(Activity paramActivity)
  {
    int j = 1;
    if (bk.ZR(g.AA().getValue("SilentDownloadApkAtWiFi")) != 0) {}
    label61:
    label98:
    label103:
    label111:
    for (;;)
    {
      return false;
      au.Hx();
      int i;
      if ((((Integer)com.tencent.mm.model.c.Dz().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        i = 1;
        if ((!aq.isWifi(paramActivity)) || (i == 0)) {
          break label98;
        }
        i = j;
        if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x1) == 0) {
          break label103;
        }
        y.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
        i = 0;
      }
      for (;;)
      {
        if ((i == 0) || (!i.cll())) {
          break label111;
        }
        return aa(paramActivity);
        i = 0;
        break;
        i = 0;
        break label61;
        y.d("MicroMsg.MMErrorProcessor", "not channel pack.");
      }
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(final Activity paramActivity, String paramString1, String paramString2, final Intent paramIntent)
  {
    jf localjf = new jf();
    localjf.bRC.status = 0;
    localjf.bRC.aQw = 1;
    com.tencent.mm.sdk.b.a.udP.m(localjf);
    com.tencent.mm.ui.base.h.a(paramActivity, paramString1, paramActivity.getString(R.l.app_tip), new w.1(paramString2, paramActivity, paramIntent), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 24L, 1L, true);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4024), String.format("%b|%s", new Object[] { Boolean.valueOf(bk.bl(this.val$url)), this.val$url }) });
        paramActivity.startActivity(paramIntent);
        b.D(paramActivity, paramIntent);
        com.tencent.mm.platformtools.w.bM(paramActivity);
      }
    });
  }
  
  public static boolean a(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    if (paramInt1 != 4) {
      return false;
    }
    y.d("MicroMsg.MMErrorProcessor", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      return false;
      y.e("MicroMsg.MMErrorProcessor", "account expired=" + paramInt2);
      com.tencent.mm.ui.base.h.a(paramActivity, R.l.main_err_relogin, R.l.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (this.uNZ != null)
          {
            paramActivity.finish();
            paramActivity.startActivity(this.uNZ);
            b.D(paramActivity, this.uNZ);
            com.tencent.mm.platformtools.w.bM(paramActivity);
          }
        }
      });
      return true;
      String str = au.CM();
      y.e("MicroMsg.MMErrorProcessor", "account expired=" + paramInt2 + " lastKickReason=" + str);
      paramString = new com.tencent.mm.h.a.w();
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      com.tencent.mm.kernel.a.hold();
      paramString = new jf();
      paramString.bRC.status = 0;
      paramString.bRC.aQw = 1;
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      ae.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
      if (uNY)
      {
        if (bk.bl(str)) {}
        for (paramActivity = "";; paramActivity = str)
        {
          y.i("MicroMsg.MMErrorProcessor", "already show kickout dialog before, ignore. lastKickReason[%s]", new Object[] { paramActivity });
          return true;
        }
      }
      if (!bk.bl(str))
      {
        paramString = com.tencent.mm.i.a.eI(str);
        if (paramString != null)
        {
          y.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", new Object[] { Integer.valueOf(paramString.showType) });
          if (((paramString.showType == 3) || (paramString.showType == 4)) && (paramString.a(paramActivity, new w.7(paramIntent, paramActivity, paramString), new w.8(paramIntent, paramActivity))))
          {
            uNY = true;
            y.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
            return true;
          }
        }
      }
      paramString = str;
      Map localMap;
      if (!bk.bl(str))
      {
        paramString = str;
        if (str.startsWith("<"))
        {
          localMap = bn.s(str, "e");
          paramString = str;
          if (localMap != null)
          {
            paramString = str;
            if (!bk.bl((String)localMap.get(".e.Content")))
            {
              paramString = (String)localMap.get(".e.Content");
              y.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + paramString + " |v=" + localMap);
            }
          }
        }
      }
      y.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", new Object[] { paramString });
      str = paramString;
      if (bk.bl(paramString)) {
        str = com.tencent.mm.cb.a.ac(paramActivity, R.l.main_err_another_place);
      }
      com.tencent.mm.ui.base.h.a(paramActivity, str, paramActivity.getString(R.l.app_tip), new w.9(paramIntent, paramActivity), new w.10(paramIntent, paramActivity));
      uNY = true;
      y.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
      return true;
      y.e("MicroMsg.MMErrorProcessor", "account expired=" + paramInt2);
      com.tencent.mm.ui.base.h.a(paramActivity, R.l.alpha_version_tip_login, R.l.app_tip, new w.11(paramIntent, paramActivity));
      return true;
      y.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((!bk.bl(paramString)) && (paramString.startsWith("autoauth_errmsg_"))) {
        str = paramString.substring(16);
      }
      do
      {
        paramString = str;
        if (!bk.bl(str))
        {
          paramString = str;
          if (str.startsWith("<"))
          {
            localMap = bn.s(str, "e");
            paramString = str;
            if (localMap != null)
            {
              paramString = str;
              if (!bk.bl((String)localMap.get(".e.Content"))) {
                paramString = (String)localMap.get(".e.Content");
              }
            }
          }
        }
        str = paramString;
        if (bk.bl(paramString)) {
          str = ae.getContext().getString(R.l.main_err_relogin);
        }
        com.tencent.mm.ui.base.h.a(paramActivity, str, ae.getContext().getString(R.l.app_tip), new w.12(paramIntent, paramActivity));
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      y.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  private static boolean aa(Activity paramActivity)
  {
    com.tencent.mm.pluginsdk.model.app.a locala = com.tencent.mm.pluginsdk.model.app.a.ckJ();
    if (locala != null)
    {
      locala.ckM();
      y.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      return true;
    }
    if (com.tencent.mm.plugin.w.d.bkt() != null)
    {
      com.tencent.mm.plugin.w.d.bkt().dP(paramActivity).update(2);
      return true;
    }
    return false;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    y.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.spa), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvj), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvl) });
    if (paramInt1 != 4) {
      return false;
    }
    switch (paramInt2)
    {
    default: 
      return false;
    case -16: 
      if (com.tencent.mm.plugin.w.d.bkt() != null)
      {
        paramActivity = com.tencent.mm.plugin.w.d.bkt().b(paramActivity, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 37L, 1L, true);
            this.eRW.finish();
            MMAppMgr.i(this.eRW, true);
          }
        });
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 36L, 1L, true);
        paramActivity.update(1);
        return true;
      }
      return false;
    }
    long l = ae.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1L);
    y.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[] { Long.valueOf(l), Long.valueOf(bk.cn(l)) });
    if ((l != -1L) && (bk.cn(l) < 86400L)) {
      return true;
    }
    if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x2) != 0)
    {
      y.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      return true;
    }
    y.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    String str = g.AA().getValue("SilentDownloadApkAtWiFi");
    au.Hx();
    boolean bool;
    if ((((Integer)com.tencent.mm.model.c.Dz().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!bk.bl(str)) && (bk.ZR(str) != 0))) {
        break label405;
      }
      bool = true;
      label294:
      if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x1) == 0) {
        break label411;
      }
      y.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      bool = false;
    }
    for (;;)
    {
      if (bk.ZR(str) != 0) {
        y.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
      }
      y.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label423;
      }
      if (com.tencent.mm.plugin.w.d.bkt() == null) {
        break label421;
      }
      paramActivity = com.tencent.mm.plugin.w.d.bkt().b(paramActivity, new w.5(paramActivity));
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 38L, 1L, true);
      paramActivity.update(2);
      return true;
      paramInt1 = 0;
      break;
      label405:
      bool = false;
      break label294;
      label411:
      y.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label421:
    return false;
    label423:
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 40L, 1L, true);
    return aa(paramActivity);
  }
  
  public static boolean gs(final Context paramContext)
  {
    final String str = i.cli();
    int i = i.clj();
    y.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!bk.bl(str)) && (!i.clk()))
    {
      au.DS().O(new Runnable()
      {
        public final void run()
        {
          if ((this.uOa == 4) && (com.tencent.mm.pluginsdk.model.app.a.ckJ() == null)) {
            y.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
          }
          while ((com.tencent.mm.plugin.w.d.bkt() == null) || (com.tencent.mm.plugin.w.d.bkt().Iq(str) == null)) {
            return;
          }
          ai.d(new w.3.1(this));
        }
      });
      return true;
    }
    return false;
  }
  
  public static final class a
  {
    public static boolean a(final Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        return false;
        if (((paramInt3 & 0x2) != 0) && (au.Dk().KH()))
        {
          au.Dk().getNetworkServerIp();
          new StringBuilder().append(paramInt2);
        }
        label154:
        label347:
        for (;;)
        {
          return true;
          if (((paramInt3 & 0x1) == 0) || (!ab.bG(paramContext)) || (!j.eY(paramContext)))
          {
            if (((paramInt3 & 0x4) != 0) && (aq.isWap(paramContext)))
            {
              if (au.DK()) {
                break label154;
              }
              paramInt1 = 0;
            }
            for (;;)
            {
              if (paramInt1 != 0) {
                break label347;
              }
              Toast.makeText(paramContext, paramContext.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
              break;
              au.Hx();
              if (bk.d((Boolean)com.tencent.mm.model.c.Dz().get(61, null)))
              {
                paramInt1 = 0;
              }
              else if (!ag.Zm("show_wap_adviser"))
              {
                paramInt1 = 0;
              }
              else
              {
                paramString = View.inflate(paramContext, R.i.network_tips, null);
                ((TextView)paramString.findViewById(R.h.network_tips_content)).setText(R.l.network_wap_limited);
                localObject = (CheckBox)paramString.findViewById(R.h.network_tips_cb);
                ((CheckBox)localObject).setText(paramContext.getString(R.l.process_limited_cancel));
                ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.13());
                ((CheckBox)localObject).setVisibility(0);
                localObject = new c.a(paramContext);
                ((c.a)localObject).Ip(R.l.app_tip);
                ((c.a)localObject).ei(paramString);
                ((c.a)localObject).Is(R.l.process_limited_ok).a(new MMAppMgr.14(paramContext));
                ((c.a)localObject).nW(false);
                ((c.a)localObject).It(R.l.process_limited_next);
                ((c.a)localObject).a(new MMAppMgr.15());
                ((c.a)localObject).aoP().show();
                paramInt1 = 1;
              }
            }
          }
        }
        Toast.makeText(paramContext, paramContext.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
        return true;
        return true;
        Object localObject = com.tencent.mm.i.a.eI(paramString);
        if (localObject != null)
        {
          y.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.mm.i.a)localObject).showType), ((com.tencent.mm.i.a)localObject).url, ((com.tencent.mm.i.a)localObject).desc });
          if (!bk.bl(((com.tencent.mm.i.a)localObject).url)) {}
          for (paramString = new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  paramAnonymousDialogInterface = new Intent();
                  StringBuilder localStringBuilder = new StringBuilder(this.eRZ.url);
                  localStringBuilder.append("&wechat_real_lang=" + x.cqJ());
                  paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                  paramAnonymousDialogInterface.putExtra("showShare", false);
                  paramAnonymousDialogInterface.putExtra("show_bottom", false);
                  paramAnonymousDialogInterface.putExtra("needRedirect", false);
                  paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
                  com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                }
              }; ((com.tencent.mm.i.a)localObject).a(paramContext, paramString, null); paramString = null) {
            return true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.w
 * JD-Core Version:    0.7.0.1
 */