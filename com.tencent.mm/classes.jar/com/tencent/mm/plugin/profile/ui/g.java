package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.model.e;
import com.tencent.mm.plugin.account.ui.MMFBFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.x;
import com.tencent.threadpool.h;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class g
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private au contact;
  private Context context;
  private Map<String, Preference> qbN;
  private f screen;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(27127);
    this.qbN = new HashMap();
    this.context = paramContext;
    bh.bCz();
    com.tencent.mm.model.c.bzG().bxO("facebookapp");
    AppMethodBeat.o(27127);
  }
  
  public static void M(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27132);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = k.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27125);
          int i = z.bBf();
          if (this.xve) {
            i &= 0xFFFFDFFF;
          }
          for (;;)
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().B(34, Integer.valueOf(i));
            bh.bCz();
            com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.xve) {
              g.clearData();
            }
            if (this.KNw != null) {
              this.KNw.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27125);
            return;
            i |= 0x2000;
          }
        }
      };
      h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27126);
          if (g.this != null)
          {
            g.this.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27126);
        }
      }, 1500L);
      AppMethodBeat.o(27132);
      return;
    }
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(305648);
    com.tencent.mm.plugin.account.b.getFacebookFrdStg().bwy();
    bh.bCz();
    com.tencent.mm.model.c.ban().B(65828, "");
    bh.bCz();
    com.tencent.mm.model.c.bzG().bxK("facebookapp");
    bh.bCz();
    com.tencent.mm.model.c.bzD().aLO("facebookapp");
    AppMethodBeat.o(305648);
  }
  
  private void dvr()
  {
    AppMethodBeat.i(27131);
    this.screen.removeAll();
    Object localObject;
    if (this.qbN.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.qbN.get("contact_info_header_helper");
      this.screen.c((Preference)localObject);
      ((HelperHeaderPreference)localObject).bz(this.contact.field_username, this.contact.aSU(), this.context.getString(R.l.contact_info_facebookapp_tip));
      if (!isOpen()) {
        break label182;
      }
    }
    label182:
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      if (this.qbN.containsKey("contact_info_facebookapp_cat")) {
        this.screen.c((Preference)this.qbN.get("contact_info_facebookapp_cat"));
      }
      if (isOpen()) {
        break;
      }
      if (this.qbN.containsKey("contact_info_facebookapp_install")) {
        this.screen.c((Preference)this.qbN.get("contact_info_facebookapp_install"));
      }
      AppMethodBeat.o(27131);
      return;
    }
    if (this.qbN.containsKey("contact_info_facebookapp_account"))
    {
      localObject = (Preference)this.qbN.get("contact_info_facebookapp_account");
      this.screen.c((Preference)localObject);
      if (!z.bBz()) {
        break label428;
      }
      ((Preference)localObject).aBk(R.l.setting_bind);
    }
    for (;;)
    {
      if (z.bBz())
      {
        if ((com.tencent.mm.au.b.bKL()) && (this.qbN.containsKey("contact_info_facebookapp_listfriend"))) {
          this.screen.c((Preference)this.qbN.get("contact_info_facebookapp_listfriend"));
        }
        if (this.qbN.containsKey("contact_info_facebookapp_addr"))
        {
          localObject = (Preference)this.qbN.get("contact_info_facebookapp_addr");
          this.screen.c((Preference)localObject);
          bh.bCz();
          ((Preference)localObject).aS((String)com.tencent.mm.model.c.ban().d(65826, null));
        }
      }
      if (this.qbN.containsKey("contact_info_facebookapp_cat2")) {
        this.screen.c((Preference)this.qbN.get("contact_info_facebookapp_cat2"));
      }
      if (this.qbN.containsKey("contact_info_facebookapp_uninstall")) {
        this.screen.c((Preference)this.qbN.get("contact_info_facebookapp_uninstall"));
      }
      AppMethodBeat.o(27131);
      return;
      label428:
      ((Preference)localObject).aBk(R.l.setting_unbind);
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27130);
    if ((z.bBf() & 0x2000) == 0)
    {
      AppMethodBeat.o(27130);
      return true;
    }
    AppMethodBeat.o(27130);
    return false;
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27129);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramau != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(au.bvY(paramau.field_username));
      bh.bCz();
      com.tencent.mm.model.c.ban().add(this);
      this.contact = paramau;
      this.screen = paramf;
      paramf.aBe(R.o.haM);
      paramau = paramf.bAi("contact_info_header_helper");
      if (paramau != null) {
        this.qbN.put("contact_info_header_helper", paramau);
      }
      paramau = paramf.bAi("contact_info_facebookapp_listfriend");
      if (paramau != null) {
        this.qbN.put("contact_info_facebookapp_listfriend", paramau);
      }
      paramau = paramf.bAi("contact_info_facebookapp_account");
      if (paramau != null) {
        this.qbN.put("contact_info_facebookapp_account", paramau);
      }
      paramau = (PreferenceCategory)paramf.bAi("contact_info_facebookapp_cat");
      if (paramau != null) {
        this.qbN.put("contact_info_facebookapp_cat", paramau);
      }
      paramau = paramf.bAi("contact_info_facebookapp_addr");
      if (paramau != null) {
        this.qbN.put("contact_info_facebookapp_addr", paramau);
      }
      paramau = (PreferenceCategory)paramf.bAi("contact_info_facebookapp_cat2");
      if (paramau != null) {
        this.qbN.put("contact_info_facebookapp_cat2", paramau);
      }
      paramau = paramf.bAi("contact_info_facebookapp_install");
      if (paramau != null) {
        this.qbN.put("contact_info_facebookapp_install", paramau);
      }
      paramf = paramf.bAi("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.qbN.put("contact_info_facebookapp_uninstall", paramf);
      }
      dvr();
      AppMethodBeat.o(27129);
      return true;
    }
  }
  
  public final boolean anl(String paramString)
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
      M(this.context, true);
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_uninstall"))
    {
      k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27124);
          g.M(g.a(g.this), false);
          AppMethodBeat.o(27124);
        }
      }, null);
      AppMethodBeat.o(27128);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_listfriend"))
    {
      Object localObject = new Intent(this.context, MMFBFriendUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27133);
    bh.bCz();
    com.tencent.mm.model.c.ban().remove(this);
    com.tencent.mm.plugin.profile.b.pFo.aDx();
    AppMethodBeat.o(27133);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27134);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.bCz();
    if ((paramMStorageEx != com.tencent.mm.model.c.ban()) || (i <= 0))
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
    dvr();
    AppMethodBeat.o(27134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g
 * JD-Core Version:    0.7.0.1
 */