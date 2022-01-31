package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements a, n.b
{
  private ad contact;
  Context context;
  private Map<String, Preference> gCY;
  private HelperHeaderPreference.a pAb;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(23512);
    this.gCY = new HashMap();
    this.context = paramContext;
    this.pAb = new q(paramContext);
    aw.aaz();
    c.YF().arJ("facebookapp");
    AppMethodBeat.o(23512);
  }
  
  private void bkc()
  {
    AppMethodBeat.i(23516);
    this.screen.removeAll();
    Object localObject;
    if (this.gCY.containsKey("contact_info_header_helper"))
    {
      localObject = (HelperHeaderPreference)this.gCY.get("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).a(this.contact, this.pAb);
      this.screen.b((Preference)localObject);
    }
    if (this.gCY.containsKey("contact_info_facebookapp_cat")) {
      this.screen.b((Preference)this.gCY.get("contact_info_facebookapp_cat"));
    }
    if (!isOpen())
    {
      if (this.gCY.containsKey("contact_info_facebookapp_install")) {
        this.screen.b((Preference)this.gCY.get("contact_info_facebookapp_install"));
      }
      AppMethodBeat.o(23516);
      return;
    }
    if (!r.ZP()) {
      if (this.gCY.containsKey("contact_info_facebookapp_connect")) {
        this.screen.b((Preference)this.gCY.get("contact_info_facebookapp_connect"));
      }
    }
    for (;;)
    {
      if (this.gCY.containsKey("contact_info_facebookapp_cat2")) {
        this.screen.b((Preference)this.gCY.get("contact_info_facebookapp_cat2"));
      }
      if (this.gCY.containsKey("contact_info_facebookapp_uninstall")) {
        this.screen.b((Preference)this.gCY.get("contact_info_facebookapp_uninstall"));
      }
      AppMethodBeat.o(23516);
      return;
      com.tencent.mm.au.b.aif();
      if (this.gCY.containsKey("contact_info_facebookapp_addr"))
      {
        this.screen.b((Preference)this.gCY.get("contact_info_facebookapp_addr"));
        localObject = (Preference)this.gCY.get("contact_info_facebookapp_addr");
        aw.aaz();
        ((Preference)localObject).setSummary((String)c.Ru().get(65826, null));
      }
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(23515);
    if ((r.Zy() & 0x2000) == 0)
    {
      AppMethodBeat.o(23515);
      return true;
    }
    AppMethodBeat.o(23515);
    return false;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(23517);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new f.2(paramBoolean);
      new Timer().schedule(new f.3(paramContext, (ak)localObject), 1500L);
      AppMethodBeat.o(23517);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23513);
    ab.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(23513);
      return false;
    }
    if (paramString.equals("contact_info_facebookapp_install"))
    {
      u(this.context, true);
      AppMethodBeat.o(23513);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new f.1(this), null);
      AppMethodBeat.o(23513);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_listfriend"))
    {
      paramString = new Intent(this.context, FacebookFriendUI.class);
      this.context.startActivity(paramString);
      AppMethodBeat.o(23513);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_connect"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(23513);
      return true;
    }
    if (paramString.equals("contact_info_facebookapp_addr"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(23513);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(23513);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(23519);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    aw.aaz();
    if ((paramn != c.Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(23519);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 65825))
    {
      AppMethodBeat.o(23519);
      return;
    }
    bkc();
    AppMethodBeat.o(23519);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(23514);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.oc(paramad.field_username));
      aw.aaz();
      c.Ru().a(this);
      this.contact = paramad;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131165205);
      paramad = paramf.atx("contact_info_header_helper");
      if (paramad != null) {
        this.gCY.put("contact_info_header_helper", paramad);
      }
      paramad = paramf.atx("contact_info_facebookapp_listfriend");
      if (paramad != null) {
        this.gCY.put("contact_info_facebookapp_listfriend", paramad);
      }
      paramad = paramf.atx("contact_info_facebookapp_connect");
      if (paramad != null) {
        this.gCY.put("contact_info_facebookapp_connect", paramad);
      }
      paramad = (PreferenceCategory)paramf.atx("contact_info_facebookapp_cat");
      if (paramad != null) {
        this.gCY.put("contact_info_facebookapp_cat", paramad);
      }
      paramad = paramf.atx("contact_info_facebookapp_addr");
      if (paramad != null) {
        this.gCY.put("contact_info_facebookapp_addr", paramad);
      }
      paramad = (PreferenceCategory)paramf.atx("contact_info_facebookapp_cat2");
      if (paramad != null) {
        this.gCY.put("contact_info_facebookapp_cat2", paramad);
      }
      paramad = paramf.atx("contact_info_facebookapp_install");
      if (paramad != null) {
        this.gCY.put("contact_info_facebookapp_install", paramad);
      }
      paramf = paramf.atx("contact_info_facebookapp_uninstall");
      if (paramf != null) {
        this.gCY.put("contact_info_facebookapp_uninstall", paramf);
      }
      bkc();
      AppMethodBeat.o(23514);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23518);
    aw.aaz();
    c.Ru().b(this);
    this.gCY.get("contact_info_header_helper");
    com.tencent.mm.plugin.profile.b.gmP.BO();
    AppMethodBeat.o(23518);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */