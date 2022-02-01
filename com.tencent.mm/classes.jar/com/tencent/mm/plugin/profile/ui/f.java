package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.r;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private an contact;
  Context context;
  private Map<String, Preference> jmA;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(27127);
    this.jmA = new HashMap();
    this.context = paramContext;
    bc.aCg();
    c.azL().aVc("facebookapp");
    AppMethodBeat.o(27127);
  }
  
  private void ceD()
  {
    AppMethodBeat.i(27131);
    this.screen.removeAll();
    Object localObject;
    if (this.jmA.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.jmA.get("contact_info_header_helper");
      this.screen.b((Preference)localObject);
      ((HelperHeaderPreference)localObject).ba(this.contact.field_username, this.contact.adF(), this.context.getString(2131757661));
      if (!isOpen()) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      if (this.jmA.containsKey("contact_info_facebookapp_cat")) {
        this.screen.b((Preference)this.jmA.get("contact_info_facebookapp_cat"));
      }
      if (isOpen()) {
        break;
      }
      if (this.jmA.containsKey("contact_info_facebookapp_install")) {
        this.screen.b((Preference)this.jmA.get("contact_info_facebookapp_install"));
      }
      AppMethodBeat.o(27131);
      return;
    }
    if (this.jmA.containsKey("contact_info_facebookapp_account"))
    {
      localObject = (Preference)this.jmA.get("contact_info_facebookapp_account");
      this.screen.b((Preference)localObject);
      if (!v.aBi()) {
        break label390;
      }
      ((Preference)localObject).setSummary(2131763099);
    }
    for (;;)
    {
      if (v.aBi())
      {
        com.tencent.mm.aw.b.aJE();
        if (this.jmA.containsKey("contact_info_facebookapp_addr"))
        {
          localObject = (Preference)this.jmA.get("contact_info_facebookapp_addr");
          this.screen.b((Preference)localObject);
          bc.aCg();
          ((Preference)localObject).setSummary((String)c.ajA().get(65826, null));
        }
      }
      if (this.jmA.containsKey("contact_info_facebookapp_cat2")) {
        this.screen.b((Preference)this.jmA.get("contact_info_facebookapp_cat2"));
      }
      if (this.jmA.containsKey("contact_info_facebookapp_uninstall")) {
        this.screen.b((Preference)this.jmA.get("contact_info_facebookapp_uninstall"));
      }
      AppMethodBeat.o(27131);
      return;
      label390:
      ((Preference)localObject).setSummary(2131763128);
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27130);
    if ((v.aAO() & 0x2000) == 0)
    {
      AppMethodBeat.o(27130);
      return true;
    }
    AppMethodBeat.o(27130);
    return false;
  }
  
  public static void z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27132);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27125);
          int i = v.aAO();
          if (this.pyd) {
            i &= 0xFFFFDFFF;
          }
          for (;;)
          {
            bc.aCg();
            c.ajA().set(34, Integer.valueOf(i));
            bc.aCg();
            c.azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.pyd)
            {
              com.tencent.mm.plugin.account.a.getFacebookFrdStg().aTi();
              bc.aCg();
              c.ajA().set(65828, "");
              bc.aCg();
              c.azL().aUY("facebookapp");
              bc.aCg();
              c.azI().arj("facebookapp");
            }
            if (this.vTv != null) {
              this.vTv.a(null, null);
            }
            AppMethodBeat.o(27125);
            return;
            i |= 0x2000;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(27126);
          if (this.pnC != null)
          {
            this.pnC.dismiss();
            this.uOZ.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27126);
        }
      }, 1500L);
      AppMethodBeat.o(27132);
      return;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27134);
    int i = bu.m(paramObject, 0);
    ae.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    bc.aCg();
    if ((paramn != c.ajA()) || (i <= 0))
    {
      ae.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(27134);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 65825))
    {
      AppMethodBeat.o(27134);
      return;
    }
    ceD();
    AppMethodBeat.o(27134);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27129);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paraman != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(x.Aw(paraman.field_username));
      bc.aCg();
      c.ajA().a(this);
      this.contact = paraman;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951639);
      paraman = paramf.aXe("contact_info_header_helper");
      if (paraman != null) {
        this.jmA.put("contact_info_header_helper", paraman);
      }
      paraman = paramf.aXe("contact_info_facebookapp_listfriend");
      if (paraman != null) {
        this.jmA.put("contact_info_facebookapp_listfriend", paraman);
      }
      paraman = paramf.aXe("contact_info_facebookapp_account");
      if (paraman != null) {
        this.jmA.put("contact_info_facebookapp_account", paraman);
      }
      paraman = (PreferenceCategory)paramf.aXe("contact_info_facebookapp_cat");
      if (paraman != null) {
        this.jmA.put("contact_info_facebookapp_cat", paraman);
      }
      paraman = paramf.aXe("contact_info_facebookapp_addr");
      if (paraman != null) {
        this.jmA.put("contact_info_facebookapp_addr", paraman);
      }
      paraman = (PreferenceCategory)paramf.aXe("contact_info_facebookapp_cat2");
      if (paraman != null) {
        this.jmA.put("contact_info_facebookapp_cat2", paraman);
      }
      paraman = paramf.aXe("contact_info_facebookapp_install");
      if (paraman != null) {
        this.jmA.put("contact_info_facebookapp_install", paraman);
      }
      paramf = paramf.aXe("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.jmA.put("contact_info_facebookapp_uninstall", paramf);
      }
      ceD();
      AppMethodBeat.o(27129);
      return true;
    }
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(27128);
    ae.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27128);
      return false;
    }
    if (paramString.equals("contact_info_facebookapp_install"))
    {
      z(this.context, true);
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_uninstall"))
    {
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27124);
          f.z(f.this.context, false);
          AppMethodBeat.o(27124);
        }
      }, null);
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_listfriend"))
    {
      Object localObject = new Intent(this.context, FacebookFriendUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_account"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_addr"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27128);
      return true;
    }
    ae.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27128);
    return false;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27133);
    bc.aCg();
    c.ajA().b(this);
    com.tencent.mm.plugin.profile.b.iUA.MM();
    AppMethodBeat.o(27133);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */