package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.b.a;
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
  protected HelperHeaderPreference.a BfU;
  protected as contact;
  protected Context context;
  protected f screen;
  
  public m(Context paramContext, HelperHeaderPreference.a parama)
  {
    this.context = paramContext;
    this.BfU = parama;
  }
  
  private void cCt()
  {
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017177);
    boolean bool = eEv();
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    if (localHelperHeaderPreference != null) {
      localHelperHeaderPreference.a(this.contact, this.BfU);
    }
    if (!bool)
    {
      this.screen.bmi("contact_info_plugin_view");
      this.screen.bmi("contact_info_plugin_clear_data");
      this.screen.bmi("contact_info_plugin_uninstall");
      return;
    }
    this.screen.bmi("contact_info_plugin_install");
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
      bg.aVF();
      c.azQ().add(this);
      this.contact = paramas;
      this.screen = paramf;
      cCt();
      return true;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean alD(String paramString)
  {
    if ("contact_info_plugin_clear_data".equals(paramString))
    {
      h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
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
      sH(true);
      return true;
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27205);
          m.this.sH(false);
          AppMethodBeat.o(27205);
        }
      }, null);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(paramString)));
    return false;
  }
  
  public boolean cCs()
  {
    bg.aVF();
    c.azQ().remove(this);
    this.screen.bmg("contact_info_header_helper");
    return true;
  }
  
  protected abstract void clear();
  
  protected abstract boolean eEv();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bg.aVF();
    if ((paramMStorageEx != c.azQ()) || (i <= 0)) {
      Log.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    cCt();
  }
  
  protected abstract void sH(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m
 * JD-Core Version:    0.7.0.1
 */