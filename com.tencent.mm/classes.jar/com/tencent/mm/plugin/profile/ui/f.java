package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
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
  private ai contact;
  Context context;
  private Map<String, Preference> iQz;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(27127);
    this.iQz = new HashMap();
    this.context = paramContext;
    az.ayM();
    c.awG().aNK("facebookapp");
    AppMethodBeat.o(27127);
  }
  
  private void bYK()
  {
    AppMethodBeat.i(27131);
    this.screen.removeAll();
    Object localObject;
    if (this.iQz.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.iQz.get("contact_info_header_helper");
      this.screen.b((Preference)localObject);
      ((HelperHeaderPreference)localObject).aR(this.contact.field_username, this.contact.aaR(), this.context.getString(2131757661));
      if (!isOpen()) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      if (this.iQz.containsKey("contact_info_facebookapp_cat")) {
        this.screen.b((Preference)this.iQz.get("contact_info_facebookapp_cat"));
      }
      if (isOpen()) {
        break;
      }
      if (this.iQz.containsKey("contact_info_facebookapp_install")) {
        this.screen.b((Preference)this.iQz.get("contact_info_facebookapp_install"));
      }
      AppMethodBeat.o(27131);
      return;
    }
    if (this.iQz.containsKey("contact_info_facebookapp_account"))
    {
      localObject = (Preference)this.iQz.get("contact_info_facebookapp_account");
      this.screen.b((Preference)localObject);
      if (!u.axZ()) {
        break label390;
      }
      ((Preference)localObject).setSummary(2131763099);
    }
    for (;;)
    {
      if (u.axZ())
      {
        com.tencent.mm.aw.b.aGd();
        if (this.iQz.containsKey("contact_info_facebookapp_addr"))
        {
          localObject = (Preference)this.iQz.get("contact_info_facebookapp_addr");
          this.screen.b((Preference)localObject);
          az.ayM();
          ((Preference)localObject).setSummary((String)c.agA().get(65826, null));
        }
      }
      if (this.iQz.containsKey("contact_info_facebookapp_cat2")) {
        this.screen.b((Preference)this.iQz.get("contact_info_facebookapp_cat2"));
      }
      if (this.iQz.containsKey("contact_info_facebookapp_uninstall")) {
        this.screen.b((Preference)this.iQz.get("contact_info_facebookapp_uninstall"));
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
    if ((u.axI() & 0x2000) == 0)
    {
      AppMethodBeat.o(27130);
      return true;
    }
    AppMethodBeat.o(27130);
    return false;
  }
  
  public static void x(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27132);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new ao()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27125);
          int i = u.axI();
          if (this.oNP) {
            i &= 0xFFFFDFFF;
          }
          for (;;)
          {
            az.ayM();
            c.agA().set(34, Integer.valueOf(i));
            az.ayM();
            c.awA().c(new l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.oNP)
            {
              com.tencent.mm.plugin.account.a.getFacebookFrdStg().aPx();
              az.ayM();
              c.agA().set(65828, "");
              az.ayM();
              c.awG().aNG("facebookapp");
              az.ayM();
              c.awD().alq("facebookapp");
            }
            if (this.uEr != null) {
              this.uEr.a(null, null);
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
          if (this.oDw != null)
          {
            this.oDw.dismiss();
            this.tAL.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27126);
        }
      }, 1500L);
      AppMethodBeat.o(27132);
      return;
    }
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27128);
    ac.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27128);
      return false;
    }
    if (paramString.equals("contact_info_facebookapp_install"))
    {
      x(this.context, true);
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
          f.x(f.this.context, false);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    ac.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27128);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27134);
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.ayM();
    if ((paramn != c.agA()) || (i <= 0))
    {
      ac.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(27134);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 65825))
    {
      AppMethodBeat.o(27134);
      return;
    }
    bYK();
    AppMethodBeat.o(27134);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27129);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramai != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.wP(paramai.field_username));
      az.ayM();
      c.agA().a(this);
      this.contact = paramai;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951639);
      paramai = paramf.aPN("contact_info_header_helper");
      if (paramai != null) {
        this.iQz.put("contact_info_header_helper", paramai);
      }
      paramai = paramf.aPN("contact_info_facebookapp_listfriend");
      if (paramai != null) {
        this.iQz.put("contact_info_facebookapp_listfriend", paramai);
      }
      paramai = paramf.aPN("contact_info_facebookapp_account");
      if (paramai != null) {
        this.iQz.put("contact_info_facebookapp_account", paramai);
      }
      paramai = (PreferenceCategory)paramf.aPN("contact_info_facebookapp_cat");
      if (paramai != null) {
        this.iQz.put("contact_info_facebookapp_cat", paramai);
      }
      paramai = paramf.aPN("contact_info_facebookapp_addr");
      if (paramai != null) {
        this.iQz.put("contact_info_facebookapp_addr", paramai);
      }
      paramai = (PreferenceCategory)paramf.aPN("contact_info_facebookapp_cat2");
      if (paramai != null) {
        this.iQz.put("contact_info_facebookapp_cat2", paramai);
      }
      paramai = paramf.aPN("contact_info_facebookapp_install");
      if (paramai != null) {
        this.iQz.put("contact_info_facebookapp_install", paramai);
      }
      paramf = paramf.aPN("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.iQz.put("contact_info_facebookapp_uninstall", paramf);
      }
      bYK();
      AppMethodBeat.o(27129);
      return true;
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27133);
    az.ayM();
    c.agA().b(this);
    com.tencent.mm.plugin.profile.b.iyy.Lj();
    AppMethodBeat.o(27133);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */