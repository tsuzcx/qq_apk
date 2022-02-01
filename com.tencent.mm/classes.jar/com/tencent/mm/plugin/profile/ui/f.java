package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private af contact;
  Context context;
  private Map<String, Preference> iqs;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(27127);
    this.iqs = new HashMap();
    this.context = paramContext;
    az.arV();
    c.apR().aIp("facebookapp");
    AppMethodBeat.o(27127);
  }
  
  private void bRv()
  {
    AppMethodBeat.i(27131);
    this.screen.removeAll();
    Object localObject;
    if (this.iqs.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.iqs.get("contact_info_header_helper");
      this.screen.b((Preference)localObject);
      ((HelperHeaderPreference)localObject).aO(this.contact.field_username, this.contact.ZW(), this.context.getString(2131757661));
      if (!isOpen()) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      if (this.iqs.containsKey("contact_info_facebookapp_cat")) {
        this.screen.b((Preference)this.iqs.get("contact_info_facebookapp_cat"));
      }
      if (isOpen()) {
        break;
      }
      if (this.iqs.containsKey("contact_info_facebookapp_install")) {
        this.screen.b((Preference)this.iqs.get("contact_info_facebookapp_install"));
      }
      AppMethodBeat.o(27131);
      return;
    }
    if (this.iqs.containsKey("contact_info_facebookapp_account"))
    {
      localObject = (Preference)this.iqs.get("contact_info_facebookapp_account");
      this.screen.b((Preference)localObject);
      if (!u.arj()) {
        break label390;
      }
      ((Preference)localObject).setSummary(2131763099);
    }
    for (;;)
    {
      if (u.arj())
      {
        com.tencent.mm.ax.b.azm();
        if (this.iqs.containsKey("contact_info_facebookapp_addr"))
        {
          localObject = (Preference)this.iqs.get("contact_info_facebookapp_addr");
          this.screen.b((Preference)localObject);
          az.arV();
          ((Preference)localObject).setSummary((String)c.afk().get(65826, null));
        }
      }
      if (this.iqs.containsKey("contact_info_facebookapp_cat2")) {
        this.screen.b((Preference)this.iqs.get("contact_info_facebookapp_cat2"));
      }
      if (this.iqs.containsKey("contact_info_facebookapp_uninstall")) {
        this.screen.b((Preference)this.iqs.get("contact_info_facebookapp_uninstall"));
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
    if ((u.aqS() & 0x2000) == 0)
    {
      AppMethodBeat.o(27130);
      return true;
    }
    AppMethodBeat.o(27130);
    return false;
  }
  
  public static void w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27132);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27125);
          int i = u.aqS();
          if (this.okp) {
            i &= 0xFFFFDFFF;
          }
          for (;;)
          {
            az.arV();
            c.afk().set(34, Integer.valueOf(i));
            az.arV();
            c.apL().c(new com.tencent.mm.bb.k("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.okp)
            {
              com.tencent.mm.plugin.account.a.getFacebookFrdStg().aIG();
              az.arV();
              c.afk().set(65828, "");
              az.arV();
              c.apR().aIl("facebookapp");
              az.arV();
              c.apO().agw("facebookapp");
            }
            if (this.tvY != null) {
              this.tvY.a(null, null);
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
          if (this.tvZ != null)
          {
            this.tvZ.dismiss();
            this.ssV.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27126);
        }
      }, 1500L);
      AppMethodBeat.o(27132);
      return;
    }
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(27128);
    ad.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27128);
      return false;
    }
    if (paramString.equals("contact_info_facebookapp_install"))
    {
      w(this.context, true);
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_uninstall"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27124);
          f.w(f.this.context, false);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
    ad.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27128);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27134);
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.arV();
    if ((paramn != c.afk()) || (i <= 0))
    {
      ad.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(27134);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 65825))
    {
      AppMethodBeat.o(27134);
      return;
    }
    bRv();
    AppMethodBeat.o(27134);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27129);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramaf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.sM(paramaf.field_username));
      az.arV();
      c.afk().a(this);
      this.contact = paramaf;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951639);
      paramaf = paramf.aKk("contact_info_header_helper");
      if (paramaf != null) {
        this.iqs.put("contact_info_header_helper", paramaf);
      }
      paramaf = paramf.aKk("contact_info_facebookapp_listfriend");
      if (paramaf != null) {
        this.iqs.put("contact_info_facebookapp_listfriend", paramaf);
      }
      paramaf = paramf.aKk("contact_info_facebookapp_account");
      if (paramaf != null) {
        this.iqs.put("contact_info_facebookapp_account", paramaf);
      }
      paramaf = (PreferenceCategory)paramf.aKk("contact_info_facebookapp_cat");
      if (paramaf != null) {
        this.iqs.put("contact_info_facebookapp_cat", paramaf);
      }
      paramaf = paramf.aKk("contact_info_facebookapp_addr");
      if (paramaf != null) {
        this.iqs.put("contact_info_facebookapp_addr", paramaf);
      }
      paramaf = (PreferenceCategory)paramf.aKk("contact_info_facebookapp_cat2");
      if (paramaf != null) {
        this.iqs.put("contact_info_facebookapp_cat2", paramaf);
      }
      paramaf = paramf.aKk("contact_info_facebookapp_install");
      if (paramaf != null) {
        this.iqs.put("contact_info_facebookapp_install", paramaf);
      }
      paramf = paramf.aKk("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.iqs.put("contact_info_facebookapp_uninstall", paramf);
      }
      bRv();
      AppMethodBeat.o(27129);
      return true;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27133);
    az.arV();
    c.afk().b(this);
    com.tencent.mm.plugin.profile.b.hYu.Ll();
    AppMethodBeat.o(27133);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */