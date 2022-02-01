package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class m
  implements a, MStorageEx.IOnStorageChange
{
  protected HelperHeaderPreference.a GZD;
  protected as contact;
  protected Context context;
  protected f screen;
  
  public m(Context paramContext, HelperHeaderPreference.a parama)
  {
    this.context = paramContext;
    this.GZD = parama;
  }
  
  private void cQY()
  {
    this.screen.removeAll();
    this.screen.auC(getResourceId());
    boolean bool = fqn();
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    if (localHelperHeaderPreference != null) {
      localHelperHeaderPreference.a(this.contact, this.GZD);
    }
    if (!bool)
    {
      this.screen.byI("contact_info_plugin_view");
      this.screen.byI("contact_info_plugin_clear_data");
      this.screen.byI("contact_info_plugin_uninstall");
      return;
    }
    this.screen.byI("contact_info_plugin_install");
  }
  
  public boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramas != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
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
      bh.beI();
      c.aHp().add(this);
      this.contact = paramas;
      this.screen = paramf;
      cQY();
      return true;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean atw(String paramString)
  {
    if ("contact_info_plugin_clear_data".equals(paramString))
    {
      h.c(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27204);
          m.this.clear();
          AppMethodBeat.o(27204);
        }
      }, null);
      return true;
    }
    if (paramString.equals("contact_info_plugin_install"))
    {
      vY(true);
      return true;
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.c(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27205);
          m.this.vY(false);
          AppMethodBeat.o(27205);
        }
      }, null);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(paramString)));
    return false;
  }
  
  public boolean cQX()
  {
    bh.beI();
    c.aHp().remove(this);
    this.screen.byG("contact_info_header_helper");
    return true;
  }
  
  protected abstract void clear();
  
  protected abstract boolean fqn();
  
  protected abstract int getResourceId();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.beI();
    if ((paramMStorageEx != c.aHp()) || (i <= 0)) {
      Log.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    cQY();
  }
  
  protected abstract void vY(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m
 * JD-Core Version:    0.7.0.1
 */