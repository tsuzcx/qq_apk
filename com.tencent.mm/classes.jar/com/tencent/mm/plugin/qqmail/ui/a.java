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
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.PluginQQMail;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.e.j;
import com.tencent.mm.plugin.qqmail.model.ab;
import com.tencent.mm.plugin.qqmail.model.o;
import com.tencent.mm.plugin.qqmail.model.q;
import com.tencent.mm.plugin.qqmail.model.r;
import com.tencent.mm.plugin.qqmail.model.u;
import com.tencent.mm.plugin.qqmail.model.w;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.c.a
{
  private boolean MVt;
  private o Nnu;
  private au contact;
  private Context context;
  private boolean enable;
  private boolean hzt;
  private ProgressDialog lzP;
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
  
  private static boolean AN(boolean paramBoolean)
  {
    AppMethodBeat.i(266943);
    r localr = new r(paramBoolean, "");
    com.tencent.mm.kernel.h.baD().mCm.a(localr, 0);
    AppMethodBeat.o(266943);
    return false;
  }
  
  private void aL(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(266939);
    View localView = View.inflate(this.context, e.f.secondpass, null);
    final EditText localEditText = (EditText)localView.findViewById(e.e.secondpass_et);
    k.a(this.context, this.context.getString(e.i.contact_info_qqmailhelper_secondpass), localView, new DialogInterface.OnClickListener()
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
    AppMethodBeat.o(266939);
  }
  
  private static void as(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(266940);
    int i = z.bBf();
    int j;
    if (paramBoolean)
    {
      i &= 0xFFFFFFFE;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgf, paramString);
      j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adge, 0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adge, Integer.valueOf(j | 0x2));
      AN(true);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baE().ban().B(34, Integer.valueOf(i));
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new com.tencent.mm.ay.l("", "", "", "", "", "", "", "", i, "", ""));
      com.tencent.mm.plugin.qqmail.a.a.pFo.aDx();
      AppMethodBeat.o(266940);
      return;
      i |= 0x1;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgf, "");
      j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adge, 0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adge, Integer.valueOf(j & 0xFFFFFFFD));
      ab.gEe();
    }
  }
  
  private void dvr()
  {
    AppMethodBeat.i(122995);
    boolean bool;
    label44:
    Object localObject;
    int i;
    if ((z.bBf() & 0x1) == 0)
    {
      bool = true;
      this.enable = bool;
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(17, null)) != 1) {
        break label505;
      }
      bool = true;
      this.hzt = bool;
      localObject = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).bz(this.contact.field_username, this.contact.aSV(), this.context.getString(e.i.contact_info_qqmailhelper_tip));
      if (!this.enable) {
        break label510;
      }
      i = 1;
      label104:
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.eh("contact_info_qqmailhelper_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label515;
      }
      bool = true;
      label142:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_qqmailhelper_view", bool);
      localObject = this.screen;
      if (this.enable) {
        break label520;
      }
      bool = true;
      label169:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_qqmailhelper_compose", bool);
      localObject = (CheckBoxPreference)this.screen.bAi("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).setChecked(this.hzt);
      }
      localObject = this.screen;
      if (this.enable) {
        break label525;
      }
      bool = true;
      label227:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_qqmailhelper_recv_remind", bool);
      localObject = this.screen;
      if ((this.enable & this.hzt)) {
        break label530;
      }
      bool = true;
      label259:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_qqmailhelper_set_files_view", bool);
      this.screen.eh("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.screen;
      if (this.enable) {
        break label535;
      }
      bool = true;
      label300:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_qqmailhelper_clear_data", bool);
      localObject = this.screen;
      if (this.enable) {
        break label540;
      }
      bool = true;
      label327:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_qqmailhelper_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label545;
      }
      bool = true;
      label354:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_qqmailhelper_account", bool);
      localObject = this.screen.bAi("contact_info_qqmailhelper_account");
      if (this.enable)
      {
        ((Preference)localObject).aBq(8);
        ((Preference)localObject).setEnabled(false);
        String str = gEx();
        i = com.tencent.mm.kernel.h.baE().ban().getInt(9, 0);
        int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adge, 0);
        Log.i("MicroMsg.ContactWidgetQQMail", "bindXMail %s, bindQQ %d, extUserStatus %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
        if (Util.isNullOrNil(str)) {
          break label580;
        }
        if ((j & 0x2) == 0) {
          break label550;
        }
        ((Preference)localObject).aS(str);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(122995);
      return;
      bool = false;
      break;
      label505:
      bool = false;
      break label44;
      label510:
      i = 0;
      break label104;
      label515:
      bool = false;
      break label142;
      label520:
      bool = false;
      break label169;
      label525:
      bool = false;
      break label227;
      label530:
      bool = false;
      break label259;
      label535:
      bool = false;
      break label300;
      label540:
      bool = false;
      break label327;
      label545:
      bool = false;
      break label354;
      label550:
      ((Preference)localObject).aS(this.context.getString(e.i.contact_info_qqmailhelper_no_account));
      ((Preference)localObject).aBq(0);
      ((Preference)localObject).setEnabled(true);
      continue;
      label580:
      if (i != 0)
      {
        ((Preference)localObject).aS(i + "@qq.com");
      }
      else
      {
        ((Preference)localObject).aS(this.context.getString(e.i.contact_info_qqmailhelper_no_account));
        ((Preference)localObject).aBq(0);
        ((Preference)localObject).setEnabled(true);
      }
    }
  }
  
  private static String gEx()
  {
    AppMethodBeat.i(266933);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgf, null);
    Log.i("MicroMsg.ContactWidgetQQMail", "last bind xmail %s", new Object[] { str });
    AppMethodBeat.o(266933);
    return str;
  }
  
  private void gEy()
  {
    AppMethodBeat.i(266936);
    this.lzP = k.a(this.context, this.context.getString(e.i.app_waiting), false, null);
    q localq = new q(gEx());
    com.tencent.mm.kernel.h.aZW().a(localq, 0);
    AppMethodBeat.o(266936);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(122994);
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramau == null) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(au.bvS(paramau.field_username));
      com.tencent.mm.kernel.h.baD().mCm.a(3848, this);
      com.tencent.mm.kernel.h.baD().mCm.a(3889, this);
      com.tencent.mm.kernel.h.aZW().a(586, this);
      com.tencent.mm.kernel.h.baD().mCm.a(129, this);
      this.MVt = paramBoolean;
      this.contact = paramau;
      this.screen = paramf;
      paramf.aBe(e.j.contact_info_pref_qqmail);
      dvr();
      if (((Activity)this.context).getIntent().getBooleanExtra("key_need_rebind_xmail", false)) {
        gEy();
      }
      AppMethodBeat.o(122994);
      return true;
      bool = false;
      break;
    }
  }
  
  public final boolean anl(String paramString)
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
      if (this.MVt)
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
        com.tencent.mm.plugin.qqmail.a.a.pFn.d(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      Object localObject = new Intent(this.context, ComposeUI.class);
      if (this.MVt)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(29, null))));
      paramString.putExtra("title", this.context.getString(e.i.contact_info_qqmailhelper_set_files_view));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.pFn.h(paramString, this.context);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      AN(((CheckBoxPreference)this.screen.bAi(paramString)).isChecked());
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_clear_data"))
    {
      k.a(this.context, this.context.getString(e.i.contact_info_clear_data_wording), "", new a.1(this), null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      gEy();
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_uninstall"))
    {
      k.b(this.context, this.context.getString(e.i.settings_plugins_uninstall_hint), "", this.context.getString(e.i.app_clear), this.context.getString(e.i.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122987);
          if (!Util.isNullOrNil(a.gEz()))
          {
            a.a(a.this);
            AppMethodBeat.o(122987);
            return;
          }
          a.gEA();
          a.b(a.this);
          AppMethodBeat.o(122987);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_account"))
    {
      gEy();
      AppMethodBeat.o(122993);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(122993);
    return false;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(122998);
    com.tencent.mm.kernel.h.baD().mCm.b(3848, this);
    com.tencent.mm.kernel.h.baD().mCm.b(3889, this);
    com.tencent.mm.kernel.h.aZW().b(586, this);
    com.tencent.mm.kernel.h.baD().mCm.b(129, this);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    AppMethodBeat.o(122998);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(266956);
    if (paramInt1 == 291)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        as(true, paramIntent.getStringExtra("Key_Bind_XMail"));
        dvr();
        AppMethodBeat.o(266956);
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
              k.d(this.context, this.context.getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(122988);
                  a.a(a.this, paramIntent, str, this.Nnx);
                  AppMethodBeat.o(122988);
                }
              });
              AppMethodBeat.o(266956);
              return;
            }
            Toast.makeText(this.context, this.context.getString(e.i.settings_mail_install_fail), 1).show();
            AppMethodBeat.o(266956);
            return;
          }
          k.d(this.context, this.context.getString(e.i.contact_info_qqmailhelper_rebind_tip), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(266996);
              a.a(a.this, paramIntent, str, "", "");
              AppMethodBeat.o(266996);
            }
          });
        }
      }
    }
    AppMethodBeat.o(266956);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(123001);
    Log.i("MicroMsg.ContactWidgetQQMail", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    Object localObject;
    if (paramp.getType() == 3848)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((w)c.c.b(((q)paramp).nao.otC)).Nko;
        localObject = ((w)c.c.b(((q)paramp).nao.otC)).Nkp;
        paramp = ((w)c.c.b(((q)paramp).nao.otC)).Nkn;
        Log.i("MicroMsg.ContactWidgetQQMail", "wxMail %s, wxLoginUrl %s, qqLoginUrl %s", new Object[] { paramString, localObject, paramp });
        if (Util.isNullOrNil(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("rawUrl", (String)localObject);
          paramString.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
          paramString.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
          com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString, 292);
          AppMethodBeat.o(123001);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(this.context, PrepareBindXMailUI.class);
        ((Intent)localObject).putExtra("Key_WeXin_Mail", paramString);
        ((Intent)localObject).putExtra("Key_QQMail_Login_Url", paramp);
        ((Intent)localObject).putExtra("Key_Last_Bind_Mail", gEx());
        com.tencent.mm.hellhoundlib.a.a.a((Activity)this.context, com.tencent.mm.hellhoundlib.b.c.a(291, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        AppMethodBeat.o(123001);
        return;
      }
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = this.context.getString(e.i.settings_mail_install_fail);
      }
      Toast.makeText(this.context, paramp, 0).show();
      AppMethodBeat.o(123001);
      return;
    }
    if (paramp.getType() == 3889) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        as(false, null);
      }
    }
    for (;;)
    {
      dvr();
      do
      {
        AppMethodBeat.o(123001);
        return;
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = this.context.getString(e.i.settings_mail_uninstall_fail);
        }
        Toast.makeText(this.context, paramp, 0).show();
        AppMethodBeat.o(123001);
        return;
        if (paramp.getType() == 586)
        {
          if (paramp != this.Nnu)
          {
            Log.i("MicroMsg.ContactWidgetQQMail", "not my scene, ignore");
            AppMethodBeat.o(123001);
            return;
          }
          int i = ((o)paramp).gDX();
          if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
          {
            Toast.makeText(this.context, this.context.getString(e.i.settings_mail_install_success), 0).show();
            as(true, ((o)paramp).NjV);
            dvr();
            ((PluginQQMail)com.tencent.mm.kernel.h.az(PluginQQMail.class)).getNormalMailAppService().reset();
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
            aL(((o)paramp).NjV, ((o)paramp).hFb, ((o)paramp).NjW);
            AppMethodBeat.o(123001);
            return;
          }
          paramp = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramp = this.context.getString(e.i.settings_mail_install_fail);
          }
          Toast.makeText(this.context, paramp, 1).show();
          AppMethodBeat.o(123001);
          return;
        }
      } while (paramp.getType() != 129);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = this.context.getString(e.i.app_modify_failed);
        }
        Toast.makeText(this.context, paramp, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a
 * JD-Core Version:    0.7.0.1
 */