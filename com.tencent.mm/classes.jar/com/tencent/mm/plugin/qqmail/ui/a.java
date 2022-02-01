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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.qqmail.PluginQQMail;
import com.tencent.mm.plugin.qqmail.d.ac;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.plugin.qqmail.d.r;
import com.tencent.mm.plugin.qqmail.d.s;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.d.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class a
  implements i, com.tencent.mm.pluginsdk.b.a
{
  private boolean Bdx;
  private p Bvl;
  private as contact;
  Context context;
  private boolean dCs;
  private boolean enable;
  ProgressDialog gtM;
  private f screen;
  
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
  
  static void A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(198702);
    int i = z.aUl();
    int j;
    if (paramBoolean)
    {
      i &= 0xFFFFFFFE;
      g.aAh().azQ().set(ar.a.OnU, paramString);
      j = g.aAh().azQ().getInt(ar.a.OnT, 0);
      g.aAh().azQ().set(ar.a.OnT, Integer.valueOf(j | 0x2));
      sT(true);
    }
    for (;;)
    {
      g.aAh().azQ().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      com.tencent.mm.plugin.qqmail.a.a.jRu.WZ();
      AppMethodBeat.o(198702);
      return;
      i |= 0x1;
      g.aAh().azQ().set(ar.a.OnU, "");
      j = g.aAh().azQ().getInt(ar.a.OnT, 0);
      g.aAh().azQ().set(ar.a.OnT, Integer.valueOf(j & 0xFFFFFFFD));
      ac.eGs();
    }
  }
  
  static String eGL()
  {
    AppMethodBeat.i(198698);
    String str = (String)g.aAh().azQ().get(ar.a.OnU, null);
    Log.i("MicroMsg.ContactWidgetQQMail", "last bind xmail %s", new Object[] { str });
    AppMethodBeat.o(198698);
    return str;
  }
  
  private void eGM()
  {
    AppMethodBeat.i(198699);
    this.gtM = h.a(this.context, this.context.getString(2131756029), false, null);
    r localr = new r(eGL());
    g.azz().a(localr, 0);
    AppMethodBeat.o(198699);
  }
  
  private static boolean sT(boolean paramBoolean)
  {
    AppMethodBeat.i(198703);
    s locals = new s(paramBoolean, "");
    g.aAg().hqi.a(locals, 0);
    AppMethodBeat.o(198703);
    return false;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(122994);
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramas == null) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(ab.IW(paramas.field_username));
      g.aAg().hqi.a(3848, this);
      g.aAg().hqi.a(3889, this);
      g.azz().a(586, this);
      g.aAg().hqi.a(129, this);
      this.Bdx = paramBoolean;
      this.contact = paramas;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2132017190);
      cCt();
      if (((Activity)this.context).getIntent().getBooleanExtra("key_need_rebind_xmail", false)) {
        eGM();
      }
      AppMethodBeat.o(122994);
      return true;
      bool = false;
      break;
    }
  }
  
  final void aC(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(198701);
    View localView = View.inflate(this.context, 2131496190, null);
    final EditText localEditText = (EditText)localView.findViewById(2131307448);
    h.a(this.context, this.context.getString(2131758010), localView, new DialogInterface.OnClickListener()
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
    AppMethodBeat.o(198701);
  }
  
  public final boolean alD(String paramString)
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
      if (this.Bdx)
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
        com.tencent.mm.plugin.qqmail.a.a.jRt.d(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      Object localObject = new Intent(this.context, ComposeUI.class);
      if (this.Bdx)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(Util.nullAsNil((String)g.aAh().azQ().get(29, null))));
      paramString.putExtra("title", this.context.getString(2131758011));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.jRt.i(paramString, this.context);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      sT(((CheckBoxPreference)this.screen.bmg(paramString)).isChecked());
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_clear_data"))
    {
      h.a(this.context, this.context.getString(2131757860), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122986);
          ac.eGs();
          AppMethodBeat.o(122986);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      eGM();
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122987);
          if (!Util.isNullOrNil(a.eGL()))
          {
            paramAnonymousDialogInterface = a.this;
            paramAnonymousDialogInterface.gtM = h.a(paramAnonymousDialogInterface.context, paramAnonymousDialogInterface.context.getString(2131756029), false, null);
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.qqmail.d.t();
            g.azz().a(paramAnonymousDialogInterface, 0);
            AppMethodBeat.o(122987);
            return;
          }
          a.A(false, null);
          a.this.cCt();
          AppMethodBeat.o(122987);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_account"))
    {
      eGM();
      AppMethodBeat.o(122993);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(122993);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(122998);
    g.aAg().hqi.b(3848, this);
    g.aAg().hqi.b(3889, this);
    g.azz().b(586, this);
    g.aAg().hqi.b(129, this);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    AppMethodBeat.o(122998);
    return true;
  }
  
  final void cCt()
  {
    AppMethodBeat.i(122995);
    boolean bool;
    label45:
    Object localObject;
    int i;
    if ((z.aUl() & 0x1) == 0)
    {
      bool = true;
      this.enable = bool;
      if (Util.nullAsNil((Integer)g.aAh().azQ().get(17, null)) != 1) {
        break label509;
      }
      bool = true;
      this.dCs = bool;
      localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758012));
      if (!this.enable) {
        break label514;
      }
      i = 1;
      label108:
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.jdMethod_do("contact_info_qqmailhelper_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label519;
      }
      bool = true;
      label146:
      ((f)localObject).jdMethod_do("contact_info_qqmailhelper_view", bool);
      localObject = this.screen;
      if (this.enable) {
        break label524;
      }
      bool = true;
      label173:
      ((f)localObject).jdMethod_do("contact_info_qqmailhelper_compose", bool);
      localObject = (CheckBoxPreference)this.screen.bmg("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).setChecked(this.dCs);
      }
      localObject = this.screen;
      if (this.enable) {
        break label529;
      }
      bool = true;
      label231:
      ((f)localObject).jdMethod_do("contact_info_qqmailhelper_recv_remind", bool);
      localObject = this.screen;
      if ((this.enable & this.dCs)) {
        break label534;
      }
      bool = true;
      label263:
      ((f)localObject).jdMethod_do("contact_info_qqmailhelper_set_files_view", bool);
      this.screen.jdMethod_do("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.screen;
      if (this.enable) {
        break label539;
      }
      bool = true;
      label304:
      ((f)localObject).jdMethod_do("contact_info_qqmailhelper_clear_data", bool);
      localObject = this.screen;
      if (this.enable) {
        break label544;
      }
      bool = true;
      label331:
      ((f)localObject).jdMethod_do("contact_info_qqmailhelper_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label549;
      }
      bool = true;
      label358:
      ((f)localObject).jdMethod_do("contact_info_qqmailhelper_account", bool);
      localObject = this.screen.bmg("contact_info_qqmailhelper_account");
      if (this.enable)
      {
        ((Preference)localObject).alO(8);
        ((Preference)localObject).setEnabled(false);
        String str = eGL();
        i = g.aAh().azQ().getInt(9, 0);
        int j = g.aAh().azQ().getInt(ar.a.OnT, 0);
        Log.i("MicroMsg.ContactWidgetQQMail", "bindXMail %s, bindQQ %d, extUserStatus %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
        if (Util.isNullOrNil(str)) {
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
      ((Preference)localObject).setSummary(this.context.getString(2131758007));
      ((Preference)localObject).alO(0);
      ((Preference)localObject).setEnabled(true);
      continue;
      label584:
      if (i != 0)
      {
        ((Preference)localObject).setSummary(i + "@qq.com");
      }
      else
      {
        ((Preference)localObject).setSummary(this.context.getString(2131758007));
        ((Preference)localObject).alO(0);
        ((Preference)localObject).setEnabled(true);
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(198700);
    if (paramInt1 == 291)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        A(true, paramIntent.getStringExtra("Key_Bind_XMail"));
        cCt();
        AppMethodBeat.o(198700);
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
              h.d(this.context, this.context.getString(2131758008), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(122988);
                  a.this.aC(paramIntent, str, this.Bvo);
                  AppMethodBeat.o(122988);
                }
              });
              AppMethodBeat.o(198700);
              return;
            }
            Toast.makeText(this.context, this.context.getString(2131765437), 1).show();
            AppMethodBeat.o(198700);
            return;
          }
          h.d(this.context, this.context.getString(2131758008), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(198697);
              a.a(a.this, paramIntent, str, "", "");
              AppMethodBeat.o(198697);
            }
          });
        }
      }
    }
    AppMethodBeat.o(198700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(123001);
    Log.i("MicroMsg.ContactWidgetQQMail", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    Object localObject;
    if (paramq.getType() == 3848)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((x)((r)paramq).hJu.iLL.iLR).Bsh;
        localObject = ((x)((r)paramq).hJu.iLL.iLR).Bsi;
        paramq = ((x)((r)paramq).hJu.iLL.iLR).Bsg;
        Log.i("MicroMsg.ContactWidgetQQMail", "wxMail %s, wxLoginUrl %s, qqLoginUrl %s", new Object[] { paramString, localObject, paramq });
        if (Util.isNullOrNil(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("rawUrl", (String)localObject);
          paramString.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          paramString.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
          c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString, 292);
          AppMethodBeat.o(123001);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(this.context, PrepareBindXMailUI.class);
        ((Intent)localObject).putExtra("Key_WeXin_Mail", paramString);
        ((Intent)localObject).putExtra("Key_QQMail_Login_Url", paramq);
        ((Intent)localObject).putExtra("Key_Last_Bind_Mail", eGL());
        ((Activity)this.context).startActivityForResult((Intent)localObject, 291);
        AppMethodBeat.o(123001);
        return;
      }
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = this.context.getString(2131765437);
      }
      Toast.makeText(this.context, paramq, 0).show();
      AppMethodBeat.o(123001);
      return;
    }
    if (paramq.getType() == 3889) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        A(false, null);
      }
    }
    for (;;)
    {
      cCt();
      do
      {
        AppMethodBeat.o(123001);
        return;
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = this.context.getString(2131765439);
        }
        Toast.makeText(this.context, paramq, 0).show();
        AppMethodBeat.o(123001);
        return;
        if (paramq.getType() == 586)
        {
          if (paramq != this.Bvl)
          {
            Log.i("MicroMsg.ContactWidgetQQMail", "not my scene, ignore");
            AppMethodBeat.o(123001);
            return;
          }
          int i = ((p)paramq).eGo();
          if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
          {
            Toast.makeText(this.context, this.context.getString(2131765438), 0).show();
            A(true, ((p)paramq).BrO);
            cCt();
            ((PluginQQMail)g.ah(PluginQQMail.class)).getNormalMailAppService().reset();
            AppMethodBeat.o(123001);
            return;
          }
          if (i == -39006)
          {
            localObject = paramString;
            if (Util.isNullOrNil(paramString)) {
              localObject = this.context.getString(2131764103);
            }
            Toast.makeText(this.context, (CharSequence)localObject, 0).show();
            aC(((p)paramq).BrO, ((p)paramq).dHx, ((p)paramq).BrP);
            AppMethodBeat.o(123001);
            return;
          }
          paramq = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramq = this.context.getString(2131765437);
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
          paramq = this.context.getString(2131755897);
        }
        Toast.makeText(this.context, paramq, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a
 * JD-Core Version:    0.7.0.1
 */