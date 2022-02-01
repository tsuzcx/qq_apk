package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.v;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private Map<String, Preference> ncz;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(27127);
    this.ncz = new HashMap();
    this.context = paramContext;
    bh.beI();
    com.tencent.mm.model.c.bbR().bwz("facebookapp");
    AppMethodBeat.o(27127);
  }
  
  public static void F(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27132);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27125);
          int i = z.bdn();
          if (this.uoH) {
            i &= 0xFFFFDFFF;
          }
          for (;;)
          {
            bh.beI();
            com.tencent.mm.model.c.aHp().i(34, Integer.valueOf(i));
            bh.beI();
            com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.uoH) {
              f.clearData();
            }
            if (this.ESS != null) {
              this.ESS.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27125);
            return;
            i |= 0x2000;
          }
        }
      };
      com.tencent.e.h.ZvG.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27126);
          if (this.ucj != null)
          {
            this.ucj.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27126);
        }
      }, 1500L);
      AppMethodBeat.o(27132);
      return;
    }
  }
  
  private void cQY()
  {
    AppMethodBeat.i(27131);
    this.screen.removeAll();
    Object localObject;
    if (this.ncz.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.ncz.get("contact_info_header_helper");
      this.screen.b((Preference)localObject);
      ((HelperHeaderPreference)localObject).bf(this.contact.field_username, this.contact.ayr(), this.context.getString(R.l.contact_info_facebookapp_tip));
      if (!isOpen()) {
        break label185;
      }
    }
    label185:
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      if (this.ncz.containsKey("contact_info_facebookapp_cat")) {
        this.screen.b((Preference)this.ncz.get("contact_info_facebookapp_cat"));
      }
      if (isOpen()) {
        break;
      }
      if (this.ncz.containsKey("contact_info_facebookapp_install")) {
        this.screen.b((Preference)this.ncz.get("contact_info_facebookapp_install"));
      }
      AppMethodBeat.o(27131);
      return;
    }
    if (this.ncz.containsKey("contact_info_facebookapp_account"))
    {
      localObject = (Preference)this.ncz.get("contact_info_facebookapp_account");
      this.screen.b((Preference)localObject);
      if (!z.bdH()) {
        break label392;
      }
      ((Preference)localObject).auI(R.l.setting_bind);
    }
    for (;;)
    {
      if (z.bdH())
      {
        com.tencent.mm.az.b.bmZ();
        if (this.ncz.containsKey("contact_info_facebookapp_addr"))
        {
          localObject = (Preference)this.ncz.get("contact_info_facebookapp_addr");
          this.screen.b((Preference)localObject);
          bh.beI();
          ((Preference)localObject).aF((String)com.tencent.mm.model.c.aHp().b(65826, null));
        }
      }
      if (this.ncz.containsKey("contact_info_facebookapp_cat2")) {
        this.screen.b((Preference)this.ncz.get("contact_info_facebookapp_cat2"));
      }
      if (this.ncz.containsKey("contact_info_facebookapp_uninstall")) {
        this.screen.b((Preference)this.ncz.get("contact_info_facebookapp_uninstall"));
      }
      AppMethodBeat.o(27131);
      return;
      label392:
      ((Preference)localObject).auI(R.l.setting_unbind);
    }
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(291217);
    com.tencent.mm.plugin.account.b.getFacebookFrdStg().byd();
    bh.beI();
    com.tencent.mm.model.c.aHp().i(65828, "");
    bh.beI();
    com.tencent.mm.model.c.bbR().bwv("facebookapp");
    bh.beI();
    com.tencent.mm.model.c.bbO().aOO("facebookapp");
    AppMethodBeat.o(291217);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27130);
    if ((z.bdn() & 0x2000) == 0)
    {
      AppMethodBeat.o(27130);
      return true;
    }
    AppMethodBeat.o(27130);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27129);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Qu(paramas.field_username));
      bh.beI();
      com.tencent.mm.model.c.aHp().add(this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.auC(R.o.eXk);
      paramas = paramf.byG("contact_info_header_helper");
      if (paramas != null) {
        this.ncz.put("contact_info_header_helper", paramas);
      }
      paramas = paramf.byG("contact_info_facebookapp_listfriend");
      if (paramas != null) {
        this.ncz.put("contact_info_facebookapp_listfriend", paramas);
      }
      paramas = paramf.byG("contact_info_facebookapp_account");
      if (paramas != null) {
        this.ncz.put("contact_info_facebookapp_account", paramas);
      }
      paramas = (PreferenceCategory)paramf.byG("contact_info_facebookapp_cat");
      if (paramas != null) {
        this.ncz.put("contact_info_facebookapp_cat", paramas);
      }
      paramas = paramf.byG("contact_info_facebookapp_addr");
      if (paramas != null) {
        this.ncz.put("contact_info_facebookapp_addr", paramas);
      }
      paramas = (PreferenceCategory)paramf.byG("contact_info_facebookapp_cat2");
      if (paramas != null) {
        this.ncz.put("contact_info_facebookapp_cat2", paramas);
      }
      paramas = paramf.byG("contact_info_facebookapp_install");
      if (paramas != null) {
        this.ncz.put("contact_info_facebookapp_install", paramas);
      }
      paramf = paramf.byG("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.ncz.put("contact_info_facebookapp_uninstall", paramf);
      }
      cQY();
      AppMethodBeat.o(27129);
      return true;
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(27128);
    Log.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27128);
      return false;
    }
    if (paramString.equals("contact_info_facebookapp_install"))
    {
      F(this.context, true);
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27124);
          f.F(f.a(f.this), false);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_account"))
    {
      com.tencent.mm.by.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_addr"))
    {
      com.tencent.mm.by.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27128);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27128);
    return false;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27133);
    bh.beI();
    com.tencent.mm.model.c.aHp().remove(this);
    com.tencent.mm.plugin.profile.b.mIH.abC();
    AppMethodBeat.o(27133);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27134);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.beI();
    if ((paramMStorageEx != com.tencent.mm.model.c.aHp()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(27134);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 65825))
    {
      AppMethodBeat.o(27134);
      return;
    }
    cQY();
    AppMethodBeat.o(27134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */