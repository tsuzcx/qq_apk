package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.pluginsdk.b.a, m.b
{
  Context context;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  private Map<String, Preference> flG = new HashMap();
  private HelperHeaderPreference.a mXf;
  
  public f(Context paramContext)
  {
    this.context = paramContext;
    this.mXf = new p(paramContext);
    au.Hx();
    c.FB().abx("facebookapp");
  }
  
  private void awY()
  {
    this.dnn.removeAll();
    Object localObject;
    if (this.flG.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.flG.get("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).a(this.dnp, this.mXf);
      this.dnn.a((Preference)localObject);
    }
    if (this.flG.containsKey("contact_info_facebookapp_cat")) {
      this.dnn.a((Preference)this.flG.get("contact_info_facebookapp_cat"));
    }
    if ((q.Gu() & 0x2000) == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (this.flG.containsKey("contact_info_facebookapp_install")) {
        this.dnn.a((Preference)this.flG.get("contact_info_facebookapp_install"));
      }
      return;
    }
    if (!q.GL()) {
      if (this.flG.containsKey("contact_info_facebookapp_connect")) {
        this.dnn.a((Preference)this.flG.get("contact_info_facebookapp_connect"));
      }
    }
    for (;;)
    {
      if (this.flG.containsKey("contact_info_facebookapp_cat2")) {
        this.dnn.a((Preference)this.flG.get("contact_info_facebookapp_cat2"));
      }
      if (!this.flG.containsKey("contact_info_facebookapp_uninstall")) {
        break;
      }
      this.dnn.a((Preference)this.flG.get("contact_info_facebookapp_uninstall"));
      return;
      if (this.flG.containsKey("contact_info_facebookapp_addr"))
      {
        this.dnn.a((Preference)this.flG.get("contact_info_facebookapp_addr"));
        localObject = (Preference)this.flG.get("contact_info_facebookapp_addr");
        au.Hx();
        ((Preference)localObject).setSummary((String)c.Dz().get(65826, null));
      }
    }
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new f.2(paramBoolean);
      new Timer().schedule(new f.3(paramContext, (ah)localObject), 1500L);
      return;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while ((i != 40) && (i != 34) && (i != 65825)) {
      return;
    }
    awY();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(s.ht(paramad.field_username));
      au.Hx();
      c.Dz().a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      paramf.addPreferencesFromResource(R.o.contact_info_pref_facebookapp);
      paramad = paramf.add("contact_info_header_helper");
      if (paramad != null) {
        this.flG.put("contact_info_header_helper", paramad);
      }
      paramad = paramf.add("contact_info_facebookapp_listfriend");
      if (paramad != null) {
        this.flG.put("contact_info_facebookapp_listfriend", paramad);
      }
      paramad = paramf.add("contact_info_facebookapp_connect");
      if (paramad != null) {
        this.flG.put("contact_info_facebookapp_connect", paramad);
      }
      paramad = (PreferenceCategory)paramf.add("contact_info_facebookapp_cat");
      if (paramad != null) {
        this.flG.put("contact_info_facebookapp_cat", paramad);
      }
      paramad = paramf.add("contact_info_facebookapp_addr");
      if (paramad != null) {
        this.flG.put("contact_info_facebookapp_addr", paramad);
      }
      paramad = (PreferenceCategory)paramf.add("contact_info_facebookapp_cat2");
      if (paramad != null) {
        this.flG.put("contact_info_facebookapp_cat2", paramad);
      }
      paramad = paramf.add("contact_info_facebookapp_install");
      if (paramad != null) {
        this.flG.put("contact_info_facebookapp_install", paramad);
      }
      paramf = paramf.add("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.flG.put("contact_info_facebookapp_uninstall", paramf);
      }
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    this.flG.get("contact_info_header_helper");
    com.tencent.mm.plugin.profile.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_facebookapp_install"))
    {
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_uninstall"))
    {
      h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new f.1(this), null);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_listfriend"))
    {
      paramString = new Intent(this.context, FacebookFriendUI.class);
      this.context.startActivity(paramString);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_connect"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_addr"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      return true;
    }
    y.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */