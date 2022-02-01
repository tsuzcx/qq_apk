package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
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
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private Map<String, Preference> kkJ;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(27127);
    this.kkJ = new HashMap();
    this.context = paramContext;
    bg.aVF();
    com.tencent.mm.model.c.aST().bka("facebookapp");
    AppMethodBeat.o(27127);
  }
  
  public static void C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27132);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      paramContext = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27125);
          int i = z.aUl();
          if (this.qNu) {
            i &= 0xFFFFDFFF;
          }
          for (;;)
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(34, Integer.valueOf(i));
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.qNu) {
              f.clearData();
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
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
          if (this.qDi != null)
          {
            this.qDi.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27126);
        }
      }, 1500L);
      AppMethodBeat.o(27132);
      return;
    }
  }
  
  private void cCt()
  {
    AppMethodBeat.i(27131);
    this.screen.removeAll();
    Object localObject;
    if (this.kkJ.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.kkJ.get("contact_info_header_helper");
      this.screen.c((Preference)localObject);
      ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arI(), this.context.getString(2131757889));
      if (!isOpen()) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      if (this.kkJ.containsKey("contact_info_facebookapp_cat")) {
        this.screen.c((Preference)this.kkJ.get("contact_info_facebookapp_cat"));
      }
      if (isOpen()) {
        break;
      }
      if (this.kkJ.containsKey("contact_info_facebookapp_install")) {
        this.screen.c((Preference)this.kkJ.get("contact_info_facebookapp_install"));
      }
      AppMethodBeat.o(27131);
      return;
    }
    if (this.kkJ.containsKey("contact_info_facebookapp_account"))
    {
      localObject = (Preference)this.kkJ.get("contact_info_facebookapp_account");
      this.screen.c((Preference)localObject);
      if (!z.aUF()) {
        break label390;
      }
      ((Preference)localObject).setSummary(2131765261);
    }
    for (;;)
    {
      if (z.aUF())
      {
        com.tencent.mm.aw.b.bdF();
        if (this.kkJ.containsKey("contact_info_facebookapp_addr"))
        {
          localObject = (Preference)this.kkJ.get("contact_info_facebookapp_addr");
          this.screen.c((Preference)localObject);
          bg.aVF();
          ((Preference)localObject).setSummary((String)com.tencent.mm.model.c.azQ().get(65826, null));
        }
      }
      if (this.kkJ.containsKey("contact_info_facebookapp_cat2")) {
        this.screen.c((Preference)this.kkJ.get("contact_info_facebookapp_cat2"));
      }
      if (this.kkJ.containsKey("contact_info_facebookapp_uninstall")) {
        this.screen.c((Preference)this.kkJ.get("contact_info_facebookapp_uninstall"));
      }
      AppMethodBeat.o(27131);
      return;
      label390:
      ((Preference)localObject).setSummary(2131765294);
    }
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(231864);
    com.tencent.mm.plugin.account.a.getFacebookFrdStg().bnU();
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(65828, "");
    bg.aVF();
    com.tencent.mm.model.c.aST().bjW("facebookapp");
    bg.aVF();
    com.tencent.mm.model.c.aSQ().aEE("facebookapp");
    AppMethodBeat.o(231864);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27130);
    if ((z.aUl() & 0x2000) == 0)
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
      Assert.assertTrue(ab.Jb(paramas.field_username));
      bg.aVF();
      com.tencent.mm.model.c.azQ().add(this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2132017176);
      paramas = paramf.bmg("contact_info_header_helper");
      if (paramas != null) {
        this.kkJ.put("contact_info_header_helper", paramas);
      }
      paramas = paramf.bmg("contact_info_facebookapp_listfriend");
      if (paramas != null) {
        this.kkJ.put("contact_info_facebookapp_listfriend", paramas);
      }
      paramas = paramf.bmg("contact_info_facebookapp_account");
      if (paramas != null) {
        this.kkJ.put("contact_info_facebookapp_account", paramas);
      }
      paramas = (PreferenceCategory)paramf.bmg("contact_info_facebookapp_cat");
      if (paramas != null) {
        this.kkJ.put("contact_info_facebookapp_cat", paramas);
      }
      paramas = paramf.bmg("contact_info_facebookapp_addr");
      if (paramas != null) {
        this.kkJ.put("contact_info_facebookapp_addr", paramas);
      }
      paramas = (PreferenceCategory)paramf.bmg("contact_info_facebookapp_cat2");
      if (paramas != null) {
        this.kkJ.put("contact_info_facebookapp_cat2", paramas);
      }
      paramas = paramf.bmg("contact_info_facebookapp_install");
      if (paramas != null) {
        this.kkJ.put("contact_info_facebookapp_install", paramas);
      }
      paramf = paramf.bmg("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.kkJ.put("contact_info_facebookapp_uninstall", paramf);
      }
      cCt();
      AppMethodBeat.o(27129);
      return true;
    }
  }
  
  public final boolean alD(String paramString)
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
      C(this.context, true);
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27124);
          f.C(f.a(f.this), false);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_account"))
    {
      com.tencent.mm.br.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_addr"))
    {
      com.tencent.mm.br.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27128);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27128);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27133);
    bg.aVF();
    com.tencent.mm.model.c.azQ().remove(this);
    com.tencent.mm.plugin.profile.b.jRu.WZ();
    AppMethodBeat.o(27133);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27134);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bg.aVF();
    if ((paramMStorageEx != com.tencent.mm.model.c.azQ()) || (i <= 0))
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
    cCt();
    AppMethodBeat.o(27134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */