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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.qqmail.PluginQQMail;
import com.tencent.mm.plugin.qqmail.d.ac;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.plugin.qqmail.d.r;
import com.tencent.mm.plugin.qqmail.d.s;
import com.tencent.mm.plugin.qqmail.d.t;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.d.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.al.f, com.tencent.mm.pluginsdk.b.a
{
  private am contact;
  Context context;
  private boolean dke;
  private boolean enable;
  ProgressDialog fMu;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean wPZ;
  private p xfq;
  
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
  
  static String dCG()
  {
    AppMethodBeat.i(215296);
    String str = (String)g.ajC().ajl().get(al.a.IJH, null);
    ad.i("MicroMsg.ContactWidgetQQMail", "last bind xmail %s", new Object[] { str });
    AppMethodBeat.o(215296);
    return str;
  }
  
  private void dCH()
  {
    AppMethodBeat.i(215297);
    this.fMu = h.b(this.context, this.context.getString(2131755936), false, null);
    r localr = new r(dCG());
    g.aiU().a(localr, 0);
    AppMethodBeat.o(215297);
  }
  
  private static boolean pA(boolean paramBoolean)
  {
    AppMethodBeat.i(215301);
    s locals = new s(paramBoolean, "");
    g.ajB().gAO.a(locals, 0);
    AppMethodBeat.o(215301);
    return false;
  }
  
  static void y(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(215300);
    int i = u.aAy();
    int j;
    if (paramBoolean)
    {
      i &= 0xFFFFFFFE;
      g.ajC().ajl().set(al.a.IJH, paramString);
      j = g.ajC().ajl().getInt(al.a.IJG, 0);
      g.ajC().ajl().set(al.a.IJG, Integer.valueOf(j | 0x2));
      pA(true);
    }
    for (;;)
    {
      g.ajC().ajl().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new com.tencent.mm.bb.l("", "", "", "", "", "", "", "", i, "", ""));
      com.tencent.mm.plugin.qqmail.a.a.iRH.MR();
      AppMethodBeat.o(215300);
      return;
      i |= 0x1;
      g.ajC().ajl().set(al.a.IJH, "");
      j = g.ajC().ajl().getInt(al.a.IJG, 0);
      g.ajC().ajl().set(al.a.IJG, Integer.valueOf(j & 0xFFFFFFFD));
      ac.dCm();
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(122994);
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramam == null) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(w.zH(paramam.field_username));
      g.ajB().gAO.a(3848, this);
      g.ajB().gAO.a(3889, this);
      g.aiU().a(586, this);
      g.ajB().gAO.a(129, this);
      this.wPZ = paramBoolean;
      this.contact = paramam;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951652);
      cdo();
      if (((Activity)this.context).getIntent().getBooleanExtra("key_need_rebind_xmail", false)) {
        dCH();
      }
      AppMethodBeat.o(122994);
      return true;
      bool = false;
      break;
    }
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(122993);
    ad.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(122993);
      return false;
    }
    if (paramString.equals("contact_info_qqmailhelper_view"))
    {
      paramString = new Intent();
      if (this.wPZ)
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
        com.tencent.mm.plugin.qqmail.a.a.iRG.d(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      Object localObject = new Intent(this.context, ComposeUI.class);
      if (this.wPZ)
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
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(bt.nullAsNil((String)g.ajC().ajl().get(29, null))));
      paramString.putExtra("title", this.context.getString(2131757771));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.iRG.i(paramString, this.context);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      pA(((CheckBoxPreference)this.screen.aVD(paramString)).isChecked());
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
          ac.dCm();
          AppMethodBeat.o(122986);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      dCH();
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
          if (!bt.isNullOrNil(a.dCG()))
          {
            paramAnonymousDialogInterface = a.this;
            paramAnonymousDialogInterface.fMu = h.b(paramAnonymousDialogInterface.context, paramAnonymousDialogInterface.context.getString(2131755936), false, null);
            paramAnonymousDialogInterface = new t();
            g.aiU().a(paramAnonymousDialogInterface, 0);
            AppMethodBeat.o(122987);
            return;
          }
          a.y(false, null);
          a.this.cdo();
          AppMethodBeat.o(122987);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_account"))
    {
      dCH();
      AppMethodBeat.o(122993);
      return true;
    }
    ad.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(122993);
    return false;
  }
  
  final void ar(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(215299);
    View localView = View.inflate(this.context, 2131495329, null);
    final EditText localEditText = (EditText)localView.findViewById(2131304470);
    h.a(this.context, this.context.getString(2131757770), localView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(122991);
        if ((localEditText.getText() != null) && (!bt.ai(localEditText.getText()))) {
          a.a(a.this, paramString1, paramString2, paramString3, localEditText.getText().toString());
        }
        AppMethodBeat.o(122991);
      }
    });
    AppMethodBeat.o(215299);
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(122998);
    g.ajB().gAO.b(3848, this);
    g.ajB().gAO.b(3889, this);
    g.aiU().b(586, this);
    g.ajB().gAO.b(129, this);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    AppMethodBeat.o(122998);
    return true;
  }
  
  final void cdo()
  {
    AppMethodBeat.i(122995);
    boolean bool;
    label45:
    Object localObject;
    int i;
    if ((u.aAy() & 0x1) == 0)
    {
      bool = true;
      this.enable = bool;
      if (bt.n((Integer)g.ajC().ajl().get(17, null)) != 1) {
        break label509;
      }
      bool = true;
      this.dke = bool;
      localObject = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131757772));
      if (!this.enable) {
        break label514;
      }
      i = 1;
      label108:
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cP("contact_info_qqmailhelper_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label519;
      }
      bool = true;
      label146:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("contact_info_qqmailhelper_view", bool);
      localObject = this.screen;
      if (this.enable) {
        break label524;
      }
      bool = true;
      label173:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("contact_info_qqmailhelper_compose", bool);
      localObject = (CheckBoxPreference)this.screen.aVD("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).oB = this.dke;
      }
      localObject = this.screen;
      if (this.enable) {
        break label529;
      }
      bool = true;
      label231:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("contact_info_qqmailhelper_recv_remind", bool);
      localObject = this.screen;
      if ((this.enable & this.dke)) {
        break label534;
      }
      bool = true;
      label263:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("contact_info_qqmailhelper_set_files_view", bool);
      this.screen.cP("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.screen;
      if (this.enable) {
        break label539;
      }
      bool = true;
      label304:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("contact_info_qqmailhelper_clear_data", bool);
      localObject = this.screen;
      if (this.enable) {
        break label544;
      }
      bool = true;
      label331:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("contact_info_qqmailhelper_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label549;
      }
      bool = true;
      label358:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("contact_info_qqmailhelper_account", bool);
      localObject = this.screen.aVD("contact_info_qqmailhelper_account");
      if (this.enable)
      {
        ((Preference)localObject).acw(8);
        ((Preference)localObject).setEnabled(false);
        String str = dCG();
        i = g.ajC().ajl().getInt(9, 0);
        int j = g.ajC().ajl().getInt(al.a.IJG, 0);
        ad.i("MicroMsg.ContactWidgetQQMail", "bindXMail %s, bindQQ %d, extUserStatus %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
        if (bt.isNullOrNil(str)) {
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
      ((Preference)localObject).acw(0);
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
        ((Preference)localObject).acw(0);
        ((Preference)localObject).setEnabled(true);
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(215298);
    if (paramInt1 == 291)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        y(true, paramIntent.getStringExtra("Key_Bind_XMail"));
        cdo();
        AppMethodBeat.o(215298);
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
        ad.i("MicroMsg.ContactWidgetQQMail", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", new Object[] { paramIntent, str, Boolean.valueOf(bool), localObject });
        if (!bt.V(new String[] { paramIntent, str }))
        {
          if (bool)
          {
            if (!bt.isNullOrNil((String)localObject))
            {
              h.d(this.context, this.context.getString(2131766920), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(122988);
                  a.this.ar(paramIntent, str, this.xft);
                  AppMethodBeat.o(122988);
                }
              });
              AppMethodBeat.o(215298);
              return;
            }
            Toast.makeText(this.context, this.context.getString(2131767175), 1).show();
            AppMethodBeat.o(215298);
            return;
          }
          h.d(this.context, this.context.getString(2131766920), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(215295);
              a.a(a.this, paramIntent, str, "", "");
              AppMethodBeat.o(215295);
            }
          });
        }
      }
    }
    AppMethodBeat.o(215298);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(123001);
    ad.i("MicroMsg.ContactWidgetQQMail", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    Object localObject;
    if (paramn.getType() == 3848)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((x)((r)paramn).gPp.hNL.hNQ).xcm;
        localObject = ((x)((r)paramn).gPp.hNL.hNQ).xcn;
        paramn = ((x)((r)paramn).gPp.hNL.hNQ).xcl;
        ad.i("MicroMsg.ContactWidgetQQMail", "wxMail %s, wxLoginUrl %s, qqLoginUrl %s", new Object[] { paramString, localObject, paramn });
        if (bt.isNullOrNil(paramString))
        {
          paramString = new Intent();
          paramString.putExtra("rawUrl", (String)localObject);
          paramString.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
          paramString.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
          d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString, 292);
          AppMethodBeat.o(123001);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(this.context, PrepareBindXMailUI.class);
        ((Intent)localObject).putExtra("Key_WeXin_Mail", paramString);
        ((Intent)localObject).putExtra("Key_QQMail_Login_Url", paramn);
        ((Intent)localObject).putExtra("Key_Last_Bind_Mail", dCG());
        ((Activity)this.context).startActivityForResult((Intent)localObject, 291);
        AppMethodBeat.o(123001);
        return;
      }
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = this.context.getString(2131767175);
      }
      Toast.makeText(this.context, paramn, 0).show();
      AppMethodBeat.o(123001);
      return;
    }
    if (paramn.getType() == 3889) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        y(false, null);
      }
    }
    for (;;)
    {
      cdo();
      do
      {
        AppMethodBeat.o(123001);
        return;
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = this.context.getString(2131767177);
        }
        Toast.makeText(this.context, paramn, 0).show();
        AppMethodBeat.o(123001);
        return;
        if (paramn.getType() == 586)
        {
          if (paramn != this.xfq)
          {
            ad.i("MicroMsg.ContactWidgetQQMail", "not my scene, ignore");
            AppMethodBeat.o(123001);
            return;
          }
          int i = ((p)paramn).dCi();
          if ((paramInt1 == 0) && (paramInt2 == 0) && (i == 0))
          {
            Toast.makeText(this.context, this.context.getString(2131767176), 0).show();
            y(true, ((p)paramn).xbV);
            cdo();
            ((PluginQQMail)g.ad(PluginQQMail.class)).getNormalMailAppService().reset();
            AppMethodBeat.o(123001);
            return;
          }
          if (i == -39006)
          {
            localObject = paramString;
            if (bt.isNullOrNil(paramString)) {
              localObject = this.context.getString(2131767115);
            }
            Toast.makeText(this.context, (CharSequence)localObject, 0).show();
            ar(((p)paramn).xbV, ((p)paramn).dpf, ((p)paramn).xbW);
            AppMethodBeat.o(123001);
            return;
          }
          paramn = paramString;
          if (bt.isNullOrNil(paramString)) {
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
        if (bt.isNullOrNil(paramString)) {
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