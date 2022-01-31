package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.k;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ah.f, com.tencent.mm.pluginsdk.b.a, m.b
{
  private static boolean nhn = false;
  private boolean bIU;
  private Context context;
  private ProgressDialog dnm;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  private ProgressDialog ecf;
  private boolean mVI;
  private boolean nhm;
  
  public a(Context paramContext)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.context = paramContext;
      return;
    }
  }
  
  private void awY()
  {
    boolean bool2 = true;
    label41:
    Object localObject;
    int i;
    if ((q.Gu() & 0x1) == 0)
    {
      bool1 = true;
      this.bIU = bool1;
      if (bk.g((Integer)g.DP().Dz().get(17, null)) != 1) {
        break label327;
      }
      bool1 = true;
      this.nhm = bool1;
      localObject = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(b.j.contact_info_qqmailhelper_tip));
      if (!this.bIU) {
        break label332;
      }
      i = 1;
      label103:
      ((HelperHeaderPreference)localObject).ov(i);
      this.dnn.bJ("contact_info_qqmailhelper_install", this.bIU);
      localObject = this.dnn;
      if (this.bIU) {
        break label337;
      }
      bool1 = true;
      label139:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_qqmailhelper_view", bool1);
      localObject = this.dnn;
      if (this.bIU) {
        break label342;
      }
      bool1 = true;
      label164:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_qqmailhelper_compose", bool1);
      localObject = (CheckBoxPreference)this.dnn.add("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).rHo = this.nhm;
      }
      localObject = this.dnn;
      if (this.bIU) {
        break label347;
      }
      bool1 = true;
      label219:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_qqmailhelper_recv_remind", bool1);
      localObject = this.dnn;
      if ((this.bIU & this.nhm)) {
        break label352;
      }
      bool1 = true;
      label249:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_qqmailhelper_set_files_view", bool1);
      this.dnn.bJ("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.dnn;
      if (this.bIU) {
        break label357;
      }
      bool1 = true;
      label286:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_qqmailhelper_clear_data", bool1);
      localObject = this.dnn;
      if (this.bIU) {
        break label362;
      }
    }
    label327:
    label332:
    label337:
    label342:
    label347:
    label352:
    label357:
    label362:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_qqmailhelper_uninstall", bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label41;
      i = 0;
      break label103;
      bool1 = false;
      break label139;
      bool1 = false;
      break label164;
      bool1 = false;
      break label219;
      bool1 = false;
      break label249;
      bool1 = false;
      break label286;
    }
  }
  
  private void ik(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = this.context.getString(b.j.settings_plugins_installing);; str = this.context.getString(b.j.settings_plugins_uninstalling))
    {
      Context localContext = this.context;
      this.context.getString(b.j.app_tip);
      this.ecf = com.tencent.mm.ui.base.h.b(localContext, str, true, null);
      nhn = true;
      il(paramBoolean);
      return;
    }
  }
  
  private boolean il(boolean paramBoolean)
  {
    t localt = new t(paramBoolean, "");
    if (!nhn) {
      this.dnm = com.tencent.mm.ui.base.h.b(this.context, this.context.getString(b.j.app_waiting), true, new a.4(this, localt));
    }
    g.DO().dJT.a(localt, 0);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != g.DP().Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while ((i != 17) && (i != 34) && (i != 7)) {
      return;
    }
    awY();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    if (paramf != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      bool1 = bool2;
      if (paramad != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      Assert.assertTrue(s.ho(paramad.field_username));
      g.DP().Dz().a(this);
      g.DO().dJT.a(24, this);
      this.mVI = paramBoolean;
      this.dnp = paramad;
      this.dnn = paramf;
      paramf.addPreferencesFromResource(b.k.contact_info_pref_qqmail);
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    g.DP().Dz().b(this);
    g.DO().dJT.b(24, this);
    if (this.ecf != null)
    {
      this.ecf.dismiss();
      this.ecf = null;
    }
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (paramm.getType() != 24)
    {
      y.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + paramm.getType());
      return;
    }
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (this.ecf != null)
    {
      this.ecf.dismiss();
      this.ecf = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      bool = ((t)paramm).cce;
      paramString = g.DP().Dz();
      if (bool)
      {
        paramInt1 = 1;
        paramString.o(17, Integer.valueOf(paramInt1));
        if ((nhn) && (bk.bU(this.context)))
        {
          if (bool) {
            g.DP().Dz().o(17, Integer.valueOf(1));
          }
          paramInt1 = q.Gu();
          if (!bool) {
            break label255;
          }
          paramInt1 &= 0xFFFFFFFE;
        }
      }
      for (;;)
      {
        g.DP().Dz().o(34, Integer.valueOf(paramInt1));
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new com.tencent.mm.ay.j("", "", "", "", "", "", "", "", paramInt1, "", ""));
        com.tencent.mm.plugin.qqmail.a.a.eUS.tk();
        if (!bool) {
          ac.btH();
        }
        nhn = false;
        return;
        paramInt1 = 2;
        break;
        label255:
        paramInt1 |= 0x1;
      }
    }
    boolean bool = ((t)paramm).cce;
    y.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramInt1 == 4)
    {
      switch (paramInt2)
      {
      default: 
        return;
      case -31: 
        y.i("MicroMsg.ContactWidgetQQMail", "need second pass");
        paramString = View.inflate(this.context, b.g.secondpass, null);
        paramm = (EditText)paramString.findViewById(b.f.secondpass_et);
        com.tencent.mm.ui.base.h.a(this.context, this.context.getString(b.j.contact_info_qqmailhelper_secondpass), paramString, new a.5(this, bool, paramm));
        return;
      }
      y.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
    }
    if (nhn)
    {
      paramString = this.context;
      if (bool) {
        paramInt1 = b.j.settings_plugins_install_fail;
      }
    }
    for (paramString = paramString.getString(paramInt1);; paramString = this.context.getString(b.j.app_err_server_busy_tip))
    {
      Toast.makeText(this.context, paramString, 1).show();
      nhn = false;
      return;
      paramInt1 = b.j.settings_plugins_uninstall_fail;
      break;
    }
  }
  
  public final boolean xQ(String paramString)
  {
    boolean bool1 = false;
    y.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_qqmailhelper_view"))
    {
      paramString = new Intent();
      if (this.mVI)
      {
        paramString.putExtra("Chat_User", this.dnp.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        return true;
        paramString.putExtra("Chat_User", this.dnp.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.qqmail.a.a.eUR.e(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      paramString = new Intent(this.context, ComposeUI.class);
      if (this.mVI)
      {
        paramString.putExtra("Chat_User", this.dnp.field_username);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        return true;
        paramString.putExtra("Chat_User", this.dnp.field_username);
        paramString.addFlags(67108864);
        this.context.startActivity(paramString);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(bk.pm((String)g.DP().Dz().get(29, null))));
      paramString.putExtra("title", this.context.getString(b.j.contact_info_qqmailhelper_set_files_view));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.eUR.j(paramString, this.context);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.dnn.add(paramString);
      boolean bool2 = paramString.isChecked();
      il(bool2);
      if (!bool2) {
        bool1 = true;
      }
      paramString.rHo = bool1;
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(b.j.contact_info_clear_data_wording), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, null);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      if (bk.g((Integer)g.DP().Dz().get(9, null)) == 0)
      {
        com.tencent.mm.ui.base.h.b(this.context, b.j.settings_weibo_notice, b.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            com.tencent.mm.plugin.qqmail.a.a.eUR.h(null, a.a(a.this));
          }
        }, null);
        return true;
      }
      ik(true);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_uninstall"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(b.j.settings_plugins_uninstall_hint), "", this.context.getString(b.j.app_clear), this.context.getString(b.j.app_cancel), new a.3(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a
 * JD-Core Version:    0.7.0.1
 */