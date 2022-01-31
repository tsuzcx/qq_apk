package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class l
  implements a, n.b
{
  protected ad contact;
  protected Context context;
  protected HelperHeaderPreference.a pAy;
  protected f screen;
  
  public l(Context paramContext, HelperHeaderPreference.a parama)
  {
    this.context = paramContext;
    this.pAy = parama;
  }
  
  private void bkc()
  {
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165206);
    boolean bool = ccj();
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    if (localHelperHeaderPreference != null) {
      localHelperHeaderPreference.a(this.contact, this.pAy);
    }
    if (!bool)
    {
      this.screen.aty("contact_info_plugin_view");
      this.screen.aty("contact_info_plugin_clear_data");
      this.screen.aty("contact_info_plugin_uninstall");
      return;
    }
    this.screen.aty("contact_info_plugin_install");
  }
  
  public boolean Ke(String paramString)
  {
    if ("contact_info_plugin_clear_data".equals(paramString))
    {
      h.d(this.context, this.context.getString(2131298571), "", this.context.getString(2131296891), this.context.getString(2131296888), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(23589);
          l.this.clear();
          AppMethodBeat.o(23589);
        }
      }, null);
      return true;
    }
    if (paramString.equals("contact_info_plugin_install"))
    {
      kd(true);
      return true;
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new l.2(this), null);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(paramString)));
    return false;
  }
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    aw.aaz();
    if ((paramn != c.Ru()) || (i <= 0)) {
      ab.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    bkc();
  }
  
  public boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramad != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
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
      aw.aaz();
      c.Ru().a(this);
      this.contact = paramad;
      this.screen = paramf;
      bkc();
      return true;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean bkb()
  {
    aw.aaz();
    c.Ru().b(this);
    this.screen.atx("contact_info_header_helper");
    return true;
  }
  
  protected abstract boolean ccj();
  
  protected abstract void clear();
  
  protected abstract void kd(boolean paramBoolean);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l
 * JD-Core Version:    0.7.0.1
 */