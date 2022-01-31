package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Timer;
import junit.framework.Assert;

public final class j
  implements com.tencent.mm.pluginsdk.b.a, m.b
{
  private static boolean isDeleteCancel = false;
  private Context context;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  
  public j(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void awY()
  {
    boolean bool4 = true;
    boolean bool1;
    int i;
    boolean bool2;
    label54:
    Object localObject;
    label105:
    boolean bool3;
    if ((q.Gu() & 0x10) == 0)
    {
      bool1 = true;
      i = q.Gn();
      if (q.GR()) {
        break label279;
      }
      if ((i & 0x4000) != 0)
      {
        au.Hx();
        c.Dz().o(7, Integer.valueOf(i & 0xFFFFBFFF));
      }
      bool2 = false;
      localObject = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(R.l.contact_info_medianote_tip));
      if (!bool1) {
        break label297;
      }
      i = 1;
      ((HelperHeaderPreference)localObject).ov(i);
      this.dnn.bJ("contact_info_medianote_install", bool1);
      localObject = this.dnn;
      if (bool1) {
        break label302;
      }
      bool3 = true;
      label136:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_medianote_view", bool3);
      if ((!bool1) || (q.GR())) {
        break label331;
      }
      if (bk.getInt(g.AA().getValue("BindQQSwitch"), 1) != 1) {
        break label308;
      }
      bool3 = true;
      label176:
      y.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
    }
    for (;;)
    {
      localObject = this.dnn;
      if (!bool3)
      {
        bool3 = true;
        label197:
        ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_medianote_sync_to_qqmail", bool3);
        localObject = this.dnn;
        if (bool1) {
          break label320;
        }
        bool3 = true;
        label221:
        ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_medianote_clear_data", bool3);
        localObject = this.dnn;
        if (bool1) {
          break label326;
        }
      }
      label279:
      label297:
      label302:
      label308:
      label320:
      label326:
      for (bool1 = bool4;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_medianote_uninstall", bool1);
        ((CheckBoxPreference)this.dnn.add("contact_info_medianote_sync_to_qqmail")).rHo = bool2;
        return;
        bool1 = false;
        break;
        if ((i & 0x4000) != 0)
        {
          bool2 = true;
          break label54;
        }
        bool2 = false;
        break label54;
        i = 0;
        break label105;
        bool3 = false;
        break label136;
        bool3 = false;
        break label176;
        bool3 = false;
        break label197;
        bool3 = false;
        break label221;
      }
      label331:
      bool3 = bool1;
    }
  }
  
  static void jdMethod_if(boolean paramBoolean)
  {
    int i = q.Gn();
    if (paramBoolean)
    {
      i |= 0x4000;
      au.Hx();
      c.Dz().o(7, Integer.valueOf(i));
      if (!paramBoolean) {
        break label68;
      }
    }
    label68:
    for (i = 1;; i = 2)
    {
      au.Hx();
      c.Fv().b(new com.tencent.mm.ay.f(13, i));
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      paramContext = new j.4(paramBoolean, paramContext);
      new Timer().schedule(new j.5((p)localObject, paramContext), 1500L);
      return;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
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
      Assert.assertTrue(s.hA(paramad.field_username));
      au.Hx();
      c.Dz().a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      paramf.addPreferencesFromResource(R.o.contact_info_pref_medianote);
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    com.tencent.mm.plugin.profile.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_medianote_view"))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", "medianote");
      com.tencent.mm.plugin.profile.a.eUR.e(paramString, this.context);
      com.tencent.mm.plugin.profile.a.eUS.tk();
      return true;
    }
    if (paramString.equals("contact_info_medianote_sync_to_qqmail"))
    {
      if (!q.GR())
      {
        com.tencent.mm.ui.base.h.a(this.context, R.l.contact_info_medianote_sync_to_qqmail_alert_tip, R.l.contact_info_medianote_sync_to_qqmail, new j.1(this), null);
        awY();
      }
      for (;;)
      {
        return true;
        jdMethod_if(((CheckBoxPreference)this.dnn.add(paramString)).isChecked());
      }
    }
    if (paramString.equals("contact_info_medianote_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new j.2(this), null);
      return true;
    }
    if (paramString.equals("contact_info_medianote_install"))
    {
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_medianote_uninstall"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new j.3(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j
 * JD-Core Version:    0.7.0.1
 */