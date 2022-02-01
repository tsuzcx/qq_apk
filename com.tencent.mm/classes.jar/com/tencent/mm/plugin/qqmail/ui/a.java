package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.PluginQQMail;
import com.tencent.mm.plugin.qqmail.d.ac;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.plugin.qqmail.d.r;
import com.tencent.mm.plugin.qqmail.d.s;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.d.x;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.e.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public final class a
  implements i, com.tencent.mm.pluginsdk.c.a
{
  private boolean GXw;
  private p HpG;
  private as contact;
  private Context context;
  private boolean enable;
  private boolean fuZ;
  private ProgressDialog iXX;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(122992);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.context = paramContext;
      AppMethodBeat.o(122992);
      return;
    }
  }
  
  private static void F(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(251049);
    int i = z.bdn();
    int j;
    if (paramBoolean)
    {
      i &= 0xFFFFFFFE;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDk, paramString);
      j = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDj, 0);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDj, Integer.valueOf(j | 0x2));
      wn(true);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(34, Integer.valueOf(i));
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new com.tencent.mm.bd.l("", "", "", "", "", "", "", "", i, "", ""));
      com.tencent.mm.plugin.qqmail.a.a.mIH.abC();
      AppMethodBeat.o(251049);
      return;
      i |= 0x1;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDk, "");
      j = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDj, 0);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDj, Integer.valueOf(j & 0xFFFFFFFD));
      ac.fsw();
    }
  }
  
  private void ax(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(251046);
    View localView = View.inflate(this.context, e.f.secondpass, null);
    final EditText localEditText = (EditText)localView.findViewById(e.e.secondpass_et);
    com.tencent.mm.ui.base.h.a(this.context, this.context.getString(e.i.contact_info_qqmailhelper_secondpass), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(122991);
        if ((localEditText.getText() != null) && (!Util.isNullOrNil(localEditText.getText()))) {
          a.a(a.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(122991);
      }
    });
    AppMethodBeat.o(251046);
  }
  
  private void cQY()
  {
    AppMethodBeat.i(122995);
    boolean bool;
    label44:
    Object localObject;
    int i;
    if ((z.bdn() & 0x1) == 0)
    {
      bool = true;
      this.enable = bool;
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(17, null)) != 1) {
        break label507;
      }
      bool = true;
      this.fuZ = bool;
      localObject = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).bf(this.contact.field_username, this.contact.ays(), this.context.getString(e.i.contact_info_qqmailhelper_tip));
      if (!this.enable) {
        break label512;
      }
      i = 1;
      label106:
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.dz("contact_info_qqmailhelper_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label517;
      }
      bool = true;
      label144:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_qqmailhelper_view", bool);
      localObject = this.screen;
      if (this.enable) {
        break label522;
      }
      bool = true;
      label171:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_qqmailhelper_compose", bool);
      localObject = (CheckBoxPreference)this.screen.byG("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).setChecked(this.fuZ);
      }
      localObject = this.screen;
      if (this.enable) {
        break label527;
      }
      bool = true;
      label229:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_qqmailhelper_recv_remind", bool);
      localObject = this.screen;
      if ((this.enable & this.fuZ)) {
        break label532;
      }
      bool = true;
      label261:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_qqmailhelper_set_files_view", bool);
      this.screen.dz("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.screen;
      if (this.enable) {
        break label537;
      }
      bool = true;
      label302:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_qqmailhelper_clear_data", bool);
      localObject = this.screen;
      if (this.enable) {
        break label542;
      }
      bool = true;
      label329:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_qqmailhelper_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label547;
      }
      bool = true;
      label356:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_qqmailhelper_account", bool);
      localObject = this.screen.byG("contact_info_qqmailhelper_account");
      if (this.enable)
      {
        ((Preference)localObject).auO(8);
        ((Preference)localObject).setEnabled(false);
        String str = fsO();
        i = com.tencent.mm.kernel.h.aHG().aHp().getInt(9, 0);
        int j = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDj, 0);
        Log.i("MicroMsg.ContactWidgetQQMail", "bindXMail %s, bindQQ %d, extUserStatus %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
        if (Util.isNullOrNil(str)) {
          break label582;
        }
        if ((j & 0x2) == 0) {
          break label552;
        }
        ((Preference)localObject).aF(str);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(122995);
      return;
      bool = false;
      break;
      label507:
      bool = false;
      break label44;
      label512:
      i = 0;
      break label106;
      label517:
      bool = false;
      break label144;
      label522:
      bool = false;
      break label171;
      label527:
      bool = false;
      break label229;
      label532:
      bool = false;
      break label261;
      label537:
      bool = false;
      break label302;
      label542:
      bool = false;
      break label329;
      label547:
      bool = false;
      break label356;
      label552:
      ((Preference)localObject).aF(this.context.getString(e.i.contact_info_qqmailhelper_no_account));
      ((Preference)localObject).auO(0);
      ((Preference)localObject).setEnabled(true);
      continue;
      label582:
      if (i != 0)
      {
        ((Preference)localObject).aF(i + "@qq.com");
      }
      else
      {
        ((Preference)localObject).aF(this.context.getString(e.i.contact_info_qqmailhelper_no_account));
        ((Preference)localObject).auO(0);
        ((Preference)localObject).setEnabled(true);
      }
    }
  }
  
  private static String fsO()
  {
    AppMethodBeat.i(251040);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDk, null);
    Log.i("MicroMsg.ContactWidgetQQMail", "last bind xmail %s", new Object[] { str });
    AppMethodBeat.o(251040);
    return str;
  }
  
  private void fsP()
  {
    AppMethodBeat.i(251041);
    this.iXX = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(e.i.app_waiting), false, null);
    r localr = new r(fsO());
    com.tencent.mm.kernel.h.aGY().a(localr, 0);
    AppMethodBeat.o(251041);
  }
  
  private static boolean wn(boolean paramBoolean)
  {
    AppMethodBeat.i(251051);
    s locals = new s(paramBoolean, "");
    com.tencent.mm.kernel.h.aHF().kcd.a(locals, 0);
    AppMethodBeat.o(251051);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(122994);
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramas == null) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(ab.Qp(paramas.field_username));
      com.tencent.mm.kernel.h.aHF().kcd.a(3848, this);
      com.tencent.mm.kernel.h.aHF().kcd.a(3889, this);
      com.tencent.mm.kernel.h.aGY().a(586, this);
      com.tencent.mm.kernel.h.aHF().kcd.a(129, this);
      this.GXw = paramBoolean;
      this.contact = paramas;
      this.screen = paramf;
      paramf.auC(e.j.contact_info_pref_qqmail);
      cQY();
      if (((Activity)this.context).getIntent().getBooleanExtra("key_need_rebind_xmail", false)) {
        fsP();
      }
      AppMethodBeat.o(122994);
      return true;
      bool = false;
      break;
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(122993);
    Log.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(122993);
      return false;
    }
    if (paramString.equals("contact_info_qqmailhelper_view"))
    {
      paramString = new Intent();
      if (this.GXw)
      {
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(122993);
        return true;
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.qqmail.a.a.mIG.d(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      Object localObject = new Intent(this.context, ComposeUI.class);
      if (this.GXw)
      {
        ((Intent)localObject).putExtra("Chat_User", this.contact.field_username);
        ((Intent)localObject).addFlags(67108864);
        ((Activity)this.context).setResult(-1, (Intent)localObject);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(122993);
        return true;
        ((Intent)localObject).putExtra("Chat_User", this.contact.field_username);
        ((Intent)localObject).addFlags(67108864);
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(29, null))));
      paramString.putExtra("title", this.context.getString(e.i.contact_info_qqmailhelper_set_files_view));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.mIG.h(paramString, this.context);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      wn(((CheckBoxPreference)this.screen.byG(paramString)).isChecked());
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(e.i.contact_info_clear_data_wording), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122986);
          ac.fsw();
          AppMethodBeat.o(122986);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      fsP();
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(e.i.settings_plugins_uninstall_hint), "", this.context.getString(e.i.app_clear), this.context.getString(e.i.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122987);
          if (!Util.isNullOrNil(a.fsQ()))
          {
            a.a(a.this);
            AppMethodBeat.o(122987);
            return;
          }
          a.fsR();
          a.b(a.this);
          AppMethodBeat.o(122987);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_account"))
    {
      fsP();
      AppMethodBeat.o(122993);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(122993);
    return false;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(122998);
    com.tencent.mm.kernel.h.aHF().kcd.b(3848, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(3889, this);
    com.tencent.mm.kernel.h.aGY().b(586, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(129, this);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    AppMethodBeat.o(122998);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(251045);
    if (paramInt1 == 291)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        F(true, paramIntent.getStringExtra("Key_Bind_XMail"));
        cQY();
        AppMethodBeat.o(251045);
      }
    }
    else if (paramInt1 == 292)
    {
      Object localObject = null;
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if (localObject != null)
      {
        paramIntent = ((Bundle)localObject).getString("key_qq_mail");
        final String str = ((Bundle)localObject).getString("key_bind_ticket");
        boolean bool = ((Bundle)localObject).getBoolean("key_need_second_pwd", false);
        localObject = ((Bundle)localObject).getString("key_second_pwd_key");
        Log.i("MicroMsg.ContactWidgetQQMail", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", new Object[] { paramIntent, str, Boolean.valueOf(bool), localObject });
        if (!Util.isNullOrNil(new String[] { paramIntent, str }))
        {
          if (bool)
          {
            if (!Util.isNullOrNil((String)localObject))
            {
              com.tencent.mm.ui.base.h.d(this.context, this.context.getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(122988);
                  a.a(a.this, paramIntent, str, this.HpJ);
                  AppMethodBeat.o(122988);
                }
              });
              AppMethodBeat.o(251045);
              return;
            }
            Toast.makeText(this.context, this.context.getString(e.i.settings_mail_install_fail), 1).show();
            AppMethodBeat.o(251045);
            return;
          }
          com.tencent.mm.ui.base.h.d(this.context, this.context.getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(250987);
              a.a(a.this, paramIntent, str, "", "");
              AppMethodBeat.o(250987);
            }
          });
        }
      }
    }
    AppMethodBeat.o(251045);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(123001);
    Log.i("MicroMsg.ContactWidgetQQMail", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    Object localObject;
    if (paramq.getType() == 3848)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((x)d.c.b(((r)paramq).kwO.lBS)).HmA;
        localObject = ((x)d.c.b(((r)paramq).kwO.lBS)).HmB;
        paramq = ((x)d.c.b(((r)paramq).kwO.lBS)).Hmz;
        Log.i("MicroMsg.ContactWidgetQQMail", "wxMail %s, wxLoginUrl %s, qqLoginUrl %s", new Object[] { paramString, localObject, paramq });
        if (Util.isNullOrNil(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("rawUrl", (String)localObject);
          paramString.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
          paramString.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
          com.tencent.mm.by.c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString, 292);
          AppMethodBeat.o(123001);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(this.context, PrepareBindXMailUI.class);
        ((Intent)localObject).putExtra("Key_WeXin_Mail", paramString);
        ((Intent)localObject).putExtra("Key_QQMail_Login_Url", paramq);
        ((Intent)localObject).putExtra("Key_Last_Bind_Mail", fsO());
        ((Activity)this.context).startActivityForResult((Intent)localObject, 291);
        AppMethodBeat.o(123001);
        return;
      }
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = this.context.getString(e.i.settings_mail_install_fail);
      }
      Toast.makeText(this.context, paramq, 0).show();
      AppMethodBeat.o(123001);
      return;
    }
    if (paramq.getType() == 3889) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        F(false, null);
      }
    }
    for (;;)
    {
      cQY();
      do
      {
        AppMethodBeat.o(123001);
        return;
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = this.context.getString(e.i.settings_mail_uninstall_fail);
        }
        Toast.makeText(this.context, paramq, 0).show();
        AppMethodBeat.o(123001);
        return;
        if (paramq.getType() == 586)
        {
          if (paramq != this.HpG)
          {
            Log.i("MicroMsg.ContactWidgetQQMail", "not my scene, ignore");
            AppMethodBeat.o(123001);
            return;
          }
          int i = ((p)paramq).fsp();
          if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
          {
            Toast.makeText(this.context, this.context.getString(e.i.settings_mail_install_success), 0).show();
            F(true, ((p)paramq).Hmh);
            cQY();
            ((PluginQQMail)com.tencent.mm.kernel.h.ag(PluginQQMail.class)).getNormalMailAppService().reset();
            AppMethodBeat.o(123001);
            return;
          }
          if (i == -39006)
          {
            localObject = paramString;
            if (Util.isNullOrNil(paramString)) {
              localObject = this.context.getString(e.i.qqmail_verify_second_pwd_error);
            }
            Toast.makeText(this.context, (CharSequence)localObject, 0).show();
            ax(((p)paramq).Hmh, ((p)paramq).fAo, ((p)paramq).Hmi);
            AppMethodBeat.o(123001);
            return;
          }
          paramq = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramq = this.context.getString(e.i.settings_mail_install_fail);
          }
          Toast.makeText(this.context, paramq, 1).show();
          AppMethodBeat.o(123001);
          return;
        }
      } while (paramq.getType() != 129);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = this.context.getString(e.i.app_modify_failed);
        }
        Toast.makeText(this.context, paramq, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a
 * JD-Core Version:    0.7.0.1
 */