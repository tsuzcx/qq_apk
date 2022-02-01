package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class l
  implements a, n.b
{
  protected an contact;
  protected Context context;
  protected f screen;
  protected HelperHeaderPreference.a xia;
  
  public l(Context paramContext, HelperHeaderPreference.a parama)
  {
    this.context = paramContext;
    this.xia = parama;
  }
  
  private void ceD()
  {
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951640);
    boolean bool = dEc();
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    if (localHelperHeaderPreference != null) {
      localHelperHeaderPreference.a(this.contact, this.xia);
    }
    if (!bool)
    {
      this.screen.aXf("contact_info_plugin_view");
      this.screen.aXf("contact_info_plugin_clear_data");
      this.screen.aXf("contact_info_plugin_uninstall");
      return;
    }
    this.screen.aXf("contact_info_plugin_install");
  }
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    int i = bu.m(paramObject, 0);
    ae.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    bc.aCg();
    if ((paramn != c.ajA()) || (i <= 0)) {
      ae.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    ceD();
  }
  
  public boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paraman != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (bu.nullAsNil(paraman.field_username).length() <= 0) {
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
      bc.aCg();
      c.ajA().a(this);
      this.contact = paraman;
      this.screen = paramf;
      ceD();
      return true;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean abx(String paramString)
  {
    if ("contact_info_plugin_clear_data".equals(paramString))
    {
      h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27204);
          l.this.clear();
          AppMethodBeat.o(27204);
        }
      }, null);
      return true;
    }
    if (paramString.equals("contact_info_plugin_install"))
    {
      pz(true);
      return true;
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27205);
          l.this.pz(false);
          AppMethodBeat.o(27205);
        }
      }, null);
      return true;
    }
    ae.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(paramString)));
    return false;
  }
  
  public boolean ceC()
  {
    bc.aCg();
    c.ajA().b(this);
    this.screen.aXe("contact_info_header_helper");
    return true;
  }
  
  protected abstract void clear();
  
  protected abstract boolean dEc();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected abstract void pz(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l
 * JD-Core Version:    0.7.0.1
 */