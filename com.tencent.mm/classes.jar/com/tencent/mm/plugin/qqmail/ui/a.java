package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.qqmail.b.ad;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.pluginsdk.b.a, n.b
{
  private static boolean vXC = false;
  private boolean cYM;
  private ai contact;
  private Context context;
  private boolean enable;
  private ProgressDialog fts;
  private ProgressDialog huQ;
  private f screen;
  private boolean vIS;
  
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
  
  private void bYK()
  {
    boolean bool2 = true;
    AppMethodBeat.i(122995);
    label46:
    Object localObject;
    int i;
    if ((com.tencent.mm.model.u.axI() & 0x1) == 0)
    {
      bool1 = true;
      this.enable = bool1;
      if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(17, null)) != 1) {
        break label344;
      }
      bool1 = true;
      this.cYM = bool1;
      localObject = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757772));
      if (!this.enable) {
        break label349;
      }
      i = 1;
      label107:
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cK("contact_info_qqmailhelper_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label354;
      }
      bool1 = true;
      label144:
      ((f)localObject).cK("contact_info_qqmailhelper_view", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label359;
      }
      bool1 = true;
      label170:
      ((f)localObject).cK("contact_info_qqmailhelper_compose", bool1);
      localObject = (CheckBoxPreference)this.screen.aPN("contact_info_qqmailhelper_recv_remind");
      if (localObject != null) {
        ((CheckBoxPreference)localObject).mF = this.cYM;
      }
      localObject = this.screen;
      if (this.enable) {
        break label364;
      }
      bool1 = true;
      label226:
      ((f)localObject).cK("contact_info_qqmailhelper_recv_remind", bool1);
      localObject = this.screen;
      if ((this.enable & this.cYM)) {
        break label369;
      }
      bool1 = true;
      label257:
      ((f)localObject).cK("contact_info_qqmailhelper_set_files_view", bool1);
      this.screen.cK("contact_info_qqmailhelper_download_mgr_view", true);
      localObject = this.screen;
      if (this.enable) {
        break label374;
      }
      bool1 = true;
      label296:
      ((f)localObject).cK("contact_info_qqmailhelper_clear_data", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label379;
      }
    }
    label344:
    label349:
    label354:
    label359:
    label364:
    label369:
    label374:
    label379:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cK("contact_info_qqmailhelper_uninstall", bool1);
      AppMethodBeat.o(122995);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label46;
      i = 0;
      break label107;
      bool1 = false;
      break label144;
      bool1 = false;
      break label170;
      bool1 = false;
      break label226;
      bool1 = false;
      break label257;
      bool1 = false;
      break label296;
    }
  }
  
  private void pb(boolean paramBoolean)
  {
    AppMethodBeat.i(122996);
    if (paramBoolean) {}
    for (String str = this.context.getString(2131763362);; str = this.context.getString(2131763370))
    {
      Context localContext = this.context;
      this.context.getString(2131755906);
      this.huQ = h.b(localContext, str, true, null);
      vXC = true;
      pd(paramBoolean);
      AppMethodBeat.o(122996);
      return;
    }
  }
  
  private void pc(boolean paramBoolean)
  {
    AppMethodBeat.i(122997);
    if (!bs.iX(this.context))
    {
      AppMethodBeat.o(122997);
      return;
    }
    if (paramBoolean) {
      com.tencent.mm.kernel.g.agR().agA().set(17, Integer.valueOf(1));
    }
    int i = com.tencent.mm.model.u.axI();
    if (paramBoolean) {
      i &= 0xFFFFFFFE;
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agR().agA().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      com.tencent.mm.plugin.qqmail.a.a.iyy.Lj();
      if (!paramBoolean) {
        ad.drO();
      }
      AppMethodBeat.o(122997);
      return;
      i |= 0x1;
    }
  }
  
  private boolean pd(boolean paramBoolean)
  {
    AppMethodBeat.i(123000);
    final com.tencent.mm.plugin.qqmail.b.u localu = new com.tencent.mm.plugin.qqmail.b.u(paramBoolean, "");
    if (!vXC) {
      this.fts = h.b(this.context, this.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(122989);
          com.tencent.mm.kernel.g.agQ().ghe.a(localu);
          AppMethodBeat.o(122989);
        }
      });
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(localu, 0);
    AppMethodBeat.o(123000);
    return false;
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(122993);
    ac.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(122993);
      return false;
    }
    if (paramString.equals("contact_info_qqmailhelper_view"))
    {
      paramString = new Intent();
      if (this.vIS)
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
        com.tencent.mm.plugin.qqmail.a.a.iyx.d(paramString, this.context);
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_compose"))
    {
      Object localObject = new Intent(this.context, ComposeUI.class);
      if (this.vIS)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_set_files_view"))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(29, null))));
      paramString.putExtra("title", this.context.getString(2131757771));
      paramString.putExtra("zoom", false);
      paramString.putExtra("show_bottom", false);
      paramString.putExtra("showShare", false);
      paramString.putExtra("vertical_scroll", false);
      com.tencent.mm.plugin.qqmail.a.a.iyx.i(paramString, this.context);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.screen.aPN(paramString);
      boolean bool = paramString.isChecked();
      pd(bool);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        paramString.mF = bool;
        AppMethodBeat.o(122993);
        return true;
      }
    }
    if (paramString.equals("contact_info_qqmailhelper_clear_data"))
    {
      h.a(this.context, this.context.getString(2131757632), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122986);
          ad.drO();
          AppMethodBeat.o(122986);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_install"))
    {
      if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(9, null)) == 0)
      {
        h.b(this.context, 2131763508, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(122987);
            com.tencent.mm.plugin.qqmail.a.a.iyx.g(null, a.a(a.this));
            AppMethodBeat.o(122987);
          }
        }, null);
        AppMethodBeat.o(122993);
        return true;
      }
      pb(true);
      AppMethodBeat.o(122993);
      return true;
    }
    if (paramString.equals("contact_info_qqmailhelper_uninstall"))
    {
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122988);
          a.b(a.this);
          AppMethodBeat.o(122988);
        }
      }, null);
      AppMethodBeat.o(122993);
      return true;
    }
    ac.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(122993);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(122999);
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.agR().agA()) || (i <= 0))
    {
      ac.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(122999);
      return;
    }
    if ((i != 17) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(122999);
      return;
    }
    bYK();
    AppMethodBeat.o(122999);
  }
  
  public final boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(122994);
    if (paramf != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      bool1 = bool2;
      if (paramai != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      Assert.assertTrue(w.wK(paramai.field_username));
      com.tencent.mm.kernel.g.agR().agA().a(this);
      com.tencent.mm.kernel.g.agQ().ghe.a(24, this);
      this.vIS = paramBoolean;
      this.contact = paramai;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951652);
      bYK();
      AppMethodBeat.o(122994);
      return true;
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(122998);
    com.tencent.mm.kernel.g.agR().agA().b(this);
    com.tencent.mm.kernel.g.agQ().ghe.b(24, this);
    if (this.huQ != null)
    {
      this.huQ.dismiss();
      this.huQ = null;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    AppMethodBeat.o(122998);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    int i = 1;
    AppMethodBeat.i(123001);
    if (paramn.getType() != 24)
    {
      ac.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + paramn.getType());
      AppMethodBeat.o(123001);
      return;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (this.huQ != null)
    {
      this.huQ.dismiss();
      this.huQ = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      bool = ((com.tencent.mm.plugin.qqmail.b.u)paramn).dzv;
      paramString = com.tencent.mm.kernel.g.agR().agA();
      if (bool) {}
      for (paramInt1 = i;; paramInt1 = 2)
      {
        paramString.set(17, Integer.valueOf(paramInt1));
        if (vXC) {
          pc(bool);
        }
        vXC = false;
        AppMethodBeat.o(123001);
        return;
      }
    }
    final boolean bool = ((com.tencent.mm.plugin.qqmail.b.u)paramn).dzv;
    ac.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramInt1 == 4)
    {
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(123001);
        return;
      case -31: 
        ac.i("MicroMsg.ContactWidgetQQMail", "need second pass");
        paramString = View.inflate(this.context, 2131495329, null);
        paramn = (EditText)paramString.findViewById(2131304470);
        h.a(this.context, this.context.getString(2131757770), paramString, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(122991);
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.qqmail.b.u(bool, com.tencent.mm.b.g.getMessageDigest(paramn.getText().toString().trim().getBytes()));
            com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousDialogInterface, 0);
            a locala = a.this;
            Context localContext = a.a(a.this);
            a.a(a.this).getString(2131757768);
            a.a(locala, h.b(localContext, a.a(a.this).getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(122990);
                com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousDialogInterface);
                AppMethodBeat.o(122990);
              }
            }));
            AppMethodBeat.o(122991);
          }
        });
        AppMethodBeat.o(123001);
        return;
      }
      ac.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
    }
    if (vXC)
    {
      paramString = this.context;
      if (bool) {
        paramInt1 = 2131763359;
      }
    }
    for (paramString = paramString.getString(paramInt1);; paramString = this.context.getString(2131755732))
    {
      Toast.makeText(this.context, paramString, 1).show();
      vXC = false;
      AppMethodBeat.o(123001);
      return;
      paramInt1 = 2131763365;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a
 * JD-Core Version:    0.7.0.1
 */