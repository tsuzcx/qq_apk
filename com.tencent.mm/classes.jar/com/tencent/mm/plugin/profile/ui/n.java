package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class n
  implements a, MStorageEx.IOnStorageChange
{
  protected HelperHeaderPreference.a MXI;
  protected au contact;
  protected Context context;
  protected f screen;
  
  public n(Context paramContext, HelperHeaderPreference.a parama)
  {
    this.context = paramContext;
    this.MXI = parama;
  }
  
  private void dvr()
  {
    this.screen.removeAll();
    this.screen.aBe(getResourceId());
    boolean bool = gBD();
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    if (localHelperHeaderPreference != null) {
      localHelperHeaderPreference.a(this.contact, this.MXI);
    }
    if (!bool)
    {
      this.screen.bAk("contact_info_plugin_view");
      this.screen.bAk("contact_info_plugin_clear_data");
      this.screen.bAk("contact_info_plugin_uninstall");
      return;
    }
    this.screen.bAk("contact_info_plugin_install");
  }
  
  protected abstract void Av(boolean paramBoolean);
  
  public boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramau != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (Util.nullAsNil(paramau.field_username).length() <= 0) {
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
      bh.bCz();
      c.ban().add(this);
      this.contact = paramau;
      this.screen = paramf;
      dvr();
      return true;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean anl(String paramString)
  {
    if ("contact_info_plugin_clear_data".equals(paramString))
    {
      k.b(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27204);
          n.this.clear();
          AppMethodBeat.o(27204);
        }
      }, null);
      return true;
    }
    if (paramString.equals("contact_info_plugin_install"))
    {
      Av(true);
      return true;
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27205);
          n.this.Av(false);
          AppMethodBeat.o(27205);
        }
      }, null);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(paramString)));
    return false;
  }
  
  protected abstract void clear();
  
  public boolean dvq()
  {
    bh.bCz();
    c.ban().remove(this);
    this.screen.bAi("contact_info_header_helper");
    return true;
  }
  
  protected abstract boolean gBD();
  
  protected abstract int getResourceId();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.bCz();
    if ((paramMStorageEx != c.ban()) || (i <= 0)) {
      Log.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    dvr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n
 * JD-Core Version:    0.7.0.1
 */