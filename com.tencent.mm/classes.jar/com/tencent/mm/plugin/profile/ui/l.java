package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class l
  implements a, n.b
{
  protected ai contact;
  protected Context context;
  protected f screen;
  protected HelperHeaderPreference.a vLa;
  
  public l(Context paramContext, HelperHeaderPreference.a parama)
  {
    this.context = paramContext;
    this.vLa = parama;
  }
  
  private void bYK()
  {
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951640);
    boolean bool = dqi();
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    if (localHelperHeaderPreference != null) {
      localHelperHeaderPreference.a(this.contact, this.vLa);
    }
    if (!bool)
    {
      this.screen.aPO("contact_info_plugin_view");
      this.screen.aPO("contact_info_plugin_clear_data");
      this.screen.aPO("contact_info_plugin_uninstall");
      return;
    }
    this.screen.aPO("contact_info_plugin_install");
  }
  
  public boolean WZ(String paramString)
  {
    if ("contact_info_plugin_clear_data".equals(paramString))
    {
      h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
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
      oS(true);
      return true;
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27205);
          l.this.oS(false);
          AppMethodBeat.o(27205);
        }
      }, null);
      return true;
    }
    ac.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(paramString)));
    return false;
  }
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.ayM();
    if ((paramn != c.agA()) || (i <= 0)) {
      ac.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    bYK();
  }
  
  public boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramai != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (bs.nullAsNil(paramai.field_username).length() <= 0) {
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
      az.ayM();
      c.agA().a(this);
      this.contact = paramai;
      this.screen = paramf;
      bYK();
      return true;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean bYJ()
  {
    az.ayM();
    c.agA().b(this);
    this.screen.aPN("contact_info_header_helper");
    return true;
  }
  
  protected abstract void clear();
  
  protected abstract boolean dqi();
  
  protected abstract void oS(boolean paramBoolean);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l
 * JD-Core Version:    0.7.0.1
 */