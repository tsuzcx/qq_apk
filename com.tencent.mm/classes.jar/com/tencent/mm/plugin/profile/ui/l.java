package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class l
  implements a, m.b
{
  protected Context context;
  protected f dnn;
  protected ad dnp;
  protected HelperHeaderPreference.a mXL;
  
  public l(Context paramContext, HelperHeaderPreference.a parama)
  {
    this.context = paramContext;
    this.mXL = parama;
  }
  
  private void awY()
  {
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(xj());
    boolean bool = bsD();
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
    if (localHelperHeaderPreference != null) {
      localHelperHeaderPreference.a(this.dnp, this.mXL);
    }
    if (!bool)
    {
      this.dnn.ade("contact_info_plugin_view");
      this.dnn.ade("contact_info_plugin_clear_data");
      this.dnn.ade("contact_info_plugin_uninstall");
      return;
    }
    this.dnn.ade("contact_info_plugin_install");
  }
  
  public void a(int paramInt, m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    awY();
  }
  
  public boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramad != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      au.Hx();
      c.Dz().a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      awY();
      return true;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    this.dnn.add("contact_info_header_helper");
    return true;
  }
  
  protected abstract boolean bsD();
  
  protected abstract void clear();
  
  protected abstract void ie(boolean paramBoolean);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean xQ(String paramString)
  {
    if ("contact_info_plugin_clear_data".equals(paramString))
    {
      h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new l.1(this), null);
      return true;
    }
    if (paramString.equals("contact_info_plugin_install"))
    {
      ie(true);
      return true;
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new l.2(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = " + paramString);
    return false;
  }
  
  protected abstract int xj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l
 * JD-Core Version:    0.7.0.1
 */