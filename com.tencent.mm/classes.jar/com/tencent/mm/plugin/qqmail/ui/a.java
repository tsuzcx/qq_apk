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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.qqmail.PluginQQMail;
import com.tencent.mm.plugin.qqmail.d.ac;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.plugin.qqmail.d.r;
import com.tencent.mm.plugin.qqmail.d.s;
import com.tencent.mm.plugin.qqmail.d.t;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.f, com.tencent.mm.pluginsdk.b.a
{
  private an contact;
  Context context;
  private boolean dlg;
  private boolean enable;
  ProgressDialog fOC;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean xfQ;
  private p xvi;
  
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
  
  static String dFX()
  {
    AppMethodBeat.i(218042);
    String str = (String)g.ajR().ajA().get(am.a.Jen, null);
    ae.i("MicroMsg.ContactWidgetQQMail", "last bind xmail %s", new Object[] { str });
    AppMethodBeat.o(218042);
    return str;
  }
  
  private void dFY()
  {
    AppMethodBeat.i(218043);
    this.fOC = h.b(this.context, this.context.getString(2131755936), false, null);
    r localr = new r(dFX());
    g.ajj().a(localr, 0);
    AppMethodBeat.o(218043);
  }
  
  private static boolean pI(boolean paramBoolean)
  {
    AppMethodBeat.i(218047);
    s locals = new s(paramBoolean, "");
    g.ajQ().gDv.a(locals, 0);
    AppMethodBeat.o(218047);
    return false;
  }
  
  static void z(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(218046);
    int i = com.tencent.mm.model.v.aAO();
    int j;
    if (paramBoolean)
    {
      i &= 0xFFFFFFFE;
      g.ajR().ajA().set(am.a.Jen, paramString);
      j = g.ajR().ajA().getInt(am.a.Jem, 0);
      g.ajR().ajA().set(am.a.Jem, Integer.valueOf(j | 0x2));
      pI(true);
    }
    for (;;)
    {
      g.ajR().ajA().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      com.tencent.mm.plugin.qqmail.a.a.iUA.MM();
      AppMethodBeat.o(218046);
      return;
      i |= 0x1;
      g.ajR().ajA().set(am.a.Jen, "");
      j = g.ajR().ajA().getInt(am.a.Jem, 0);
      g.ajR().ajA().set(am.a.Jem, Integer.valueOf(j & 0xFFFFFFFD));
      ac.dFD();
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(122994);
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paraman == null) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(com.tencent.mm.model.x.Ar(paraman.field_username));
      g.ajQ().gDv.a(3848, this);
      g.ajQ().gDv.a(3889, this);
      g.ajj().a(586, this);
      g.ajQ().gDv.a(129, this);
      this.xfQ = paramBoolean;
      this.contact = paraman;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951652);
      ceD();
      if (((Activity)this.context).getIntent().getBooleanExtra("key_need_rebind_xmail", false)) {
        dFY();
      }
      AppMethodBeat.o(122994);
      return true;
      bool = false;
      break;
    }
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(122993);
    ae.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(122993);
      return false;
    }
    if (paramString.equals("contact_info_qqmailhelper_view"))
    {
      paramString = new Intent();
      if (this.xfQ)
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
        com.tencent.mm.plugin.qqmail.a.a.iUz.d(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      Object localObject = new Intent(this.context, ComposeUI.class);
      if (this.xfQ)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(bu.nullAsNil((String)g.ajR().ajA().get(29, null))));
      paramString.putExtra("title", this.context.getString(2131757771));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.iUz.i(paramString, this.context);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      pI(((CheckBoxPreference)this.screen.aXe(paramString)).isChecked());
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_clear_data"))
    {
      h.a(this.context, this.context.getString(2131757632), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122986);
          ac.dFD();
          AppMethodBeat.o(122986);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      dFY();
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_uninstall"))
    {
      h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122987);
          if (!bu.isNullOrNil(a.dFX()))
          {
            paramAnonymousDialogInterface = a.this;
            paramAnonymousDialogInterface.fOC = h.b(paramAnonymousDialogInterface.context, paramAnonymousDialogInterface.context.getString(2131755936), false, null);
            paramAnonymousDialogInterface = new t();
            g.ajj().a(paramAnonymousDialogInterface, 0);
            AppMethodBeat.o(122987);
            return;
          }
          a.z(false, null);
          a.this.ceD();
          AppMethodBeat.o(122987);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_account"))
    {
      dFY();
      AppMethodBeat.o(122993);
      return true;
    }
    ae.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(122993);
    return false;
  }
  
  final void ar(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(218045);
    View localView = View.inflate(this.context, 2131495329, null);
    final EditText localEditText = (EditText)localView.findViewById(2131304470);
    h.a(this.context, this.context.getString(2131757770), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(122991);
        if ((localEditText.getText() != null) && (!bu.ah(localEditText.getText()))) {
          a.a(a.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(122991);
      }
    });
    AppMethodBeat.o(218045);
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(122998);
    g.ajQ().gDv.b(3848, this);
    g.ajQ().gDv.b(3889, this);
    g.ajj().b(586, this);
    g.ajQ().gDv.b(129, this);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    AppMethodBeat.o(122998);
    return true;
  }
  
  final void ceD()
  {
    AppMethodBeat.i(122995);
    boolean bool;
    label45:
    Object localObject;
    int i;
    if ((com.tencent.mm.model.v.aAO() & 0x1) == 0)
    {
      bool = true;
      this.enable = bool;
      if (bu.o((Integer)g.ajR().ajA().get(17, null)) != 1) {
        break label509;
      }
      bool = true;
      this.dlg = bool;
      localObject = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757772));
      if (!this.enable) {
        break label514;
      }
      i = 1;
      label108:
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cT("contact_info_qqmailhelper_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label519;
      }
      bool = true;
      label146:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("contact_info_qqmailhelper_view", bool);
      localObject = this.screen;
      if (this.enable) {
        break label524;
      }
      bool = true;
      label173:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("contact_info_qqmailhelper_compose", bool);
      localObject = (CheckBoxPreference)this.screen.aXe("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).setChecked(this.dlg);
      }
      localObject = this.screen;
      if (this.enable) {
        break label529;
      }
      bool = true;
      label231:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("contact_info_qqmailhelper_recv_remind", bool);
      localObject = this.screen;
      if ((this.enable & this.dlg)) {
        break label534;
      }
      bool = true;
      label263:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("contact_info_qqmailhelper_set_files_view", bool);
      this.screen.cT("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.screen;
      if (this.enable) {
        break label539;
      }
      bool = true;
      label304:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("contact_info_qqmailhelper_clear_data", bool);
      localObject = this.screen;
      if (this.enable) {
        break label544;
      }
      bool = true;
      label331:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("contact_info_qqmailhelper_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label549;
      }
      bool = true;
      label358:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("contact_info_qqmailhelper_account", bool);
      localObject = this.screen.aXe("contact_info_qqmailhelper_account");
      if (this.enable)
      {
        ((Preference)localObject).ade(8);
        ((Preference)localObject).setEnabled(false);
        String str = dFX();
        i = g.ajR().ajA().getInt(9, 0);
        int j = g.ajR().ajA().getInt(am.a.Jem, 0);
        ae.i("MicroMsg.ContactWidgetQQMail", "bindXMail %s, bindQQ %d, extUserStatus %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
        if (bu.isNullOrNil(str)) {
          break label584;
        }
        if ((j & 0x2) == 0) {
          break label554;
        }
        ((Preference)localObject).setSummary(str);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(122995);
      return;
      bool = false;
      break;
      label509:
      bool = false;
      break label45;
      label514:
      i = 0;
      break label108;
      label519:
      bool = false;
      break label146;
      label524:
      bool = false;
      break label173;
      label529:
      bool = false;
      break label231;
      label534:
      bool = false;
      break label263;
      label539:
      bool = false;
      break label304;
      label544:
      bool = false;
      break label331;
      label549:
      bool = false;
      break label358;
      label554:
      ((Preference)localObject).setSummary(this.context.getString(2131766919));
      ((Preference)localObject).ade(0);
      ((Preference)localObject).setEnabled(true);
      continue;
      label584:
      if (i != 0)
      {
        ((Preference)localObject).setSummary(i + "@qq.com");
      }
      else
      {
        ((Preference)localObject).setSummary(this.context.getString(2131766919));
        ((Preference)localObject).ade(0);
        ((Preference)localObject).setEnabled(true);
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(218044);
    if (paramInt1 == 291)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        z(true, paramIntent.getStringExtra("Key_Bind_XMail"));
        ceD();
        AppMethodBeat.o(218044);
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
        ae.i("MicroMsg.ContactWidgetQQMail", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", new Object[] { paramIntent, str, Boolean.valueOf(bool), localObject });
        if (!bu.V(new String[] { paramIntent, str }))
        {
          if (bool)
          {
            if (!bu.isNullOrNil((String)localObject))
            {
              h.d(this.context, this.context.getString(2131766920), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(122988);
                  a.this.ar(paramIntent, str, this.xvl);
                  AppMethodBeat.o(122988);
                }
              });
              AppMethodBeat.o(218044);
              return;
            }
            Toast.makeText(this.context, this.context.getString(2131767175), 1).show();
            AppMethodBeat.o(218044);
            return;
          }
          h.d(this.context, this.context.getString(2131766920), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(218041);
              a.a(a.this, paramIntent, str, "", "");
              AppMethodBeat.o(218041);
            }
          });
        }
      }
    }
    AppMethodBeat.o(218044);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(123001);
    ae.i("MicroMsg.ContactWidgetQQMail", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    Object localObject;
    if (paramn.getType() == 3848)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.qqmail.d.x)((r)paramn).gRX.hQE.hQJ).xsd;
        localObject = ((com.tencent.mm.plugin.qqmail.d.x)((r)paramn).gRX.hQE.hQJ).xse;
        paramn = ((com.tencent.mm.plugin.qqmail.d.x)((r)paramn).gRX.hQE.hQJ).xsc;
        ae.i("MicroMsg.ContactWidgetQQMail", "wxMail %s, wxLoginUrl %s, qqLoginUrl %s", new Object[] { paramString, localObject, paramn });
        if (bu.isNullOrNil(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("rawUrl", (String)localObject);
          paramString.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
          paramString.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
          d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString, 292);
          AppMethodBeat.o(123001);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(this.context, PrepareBindXMailUI.class);
        ((Intent)localObject).putExtra("Key_WeXin_Mail", paramString);
        ((Intent)localObject).putExtra("Key_QQMail_Login_Url", paramn);
        ((Intent)localObject).putExtra("Key_Last_Bind_Mail", dFX());
        ((Activity)this.context).startActivityForResult((Intent)localObject, 291);
        AppMethodBeat.o(123001);
        return;
      }
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = this.context.getString(2131767175);
      }
      Toast.makeText(this.context, paramn, 0).show();
      AppMethodBeat.o(123001);
      return;
    }
    if (paramn.getType() == 3889) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        z(false, null);
      }
    }
    for (;;)
    {
      ceD();
      do
      {
        AppMethodBeat.o(123001);
        return;
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = this.context.getString(2131767177);
        }
        Toast.makeText(this.context, paramn, 0).show();
        AppMethodBeat.o(123001);
        return;
        if (paramn.getType() == 586)
        {
          if (paramn != this.xvi)
          {
            ae.i("MicroMsg.ContactWidgetQQMail", "not my scene, ignore");
            AppMethodBeat.o(123001);
            return;
          }
          int i = ((p)paramn).dFz();
          if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
          {
            Toast.makeText(this.context, this.context.getString(2131767176), 0).show();
            z(true, ((p)paramn).xrM);
            ceD();
            ((PluginQQMail)g.ad(PluginQQMail.class)).getNormalMailAppService().reset();
            AppMethodBeat.o(123001);
            return;
          }
          if (i == -39006)
          {
            localObject = paramString;
            if (bu.isNullOrNil(paramString)) {
              localObject = this.context.getString(2131767115);
            }
            Toast.makeText(this.context, (CharSequence)localObject, 0).show();
            ar(((p)paramn).xrM, ((p)paramn).dqk, ((p)paramn).xrN);
            AppMethodBeat.o(123001);
            return;
          }
          paramn = paramString;
          if (bu.isNullOrNil(paramString)) {
            paramn = this.context.getString(2131767175);
          }
          Toast.makeText(this.context, paramn, 1).show();
          AppMethodBeat.o(123001);
          return;
        }
      } while (paramn.getType() != 129);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = this.context.getString(2131757998);
        }
        Toast.makeText(this.context, paramn, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a
 * JD-Core Version:    0.7.0.1
 */