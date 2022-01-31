package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i
  implements com.tencent.mm.pluginsdk.b.a, m.b
{
  Context context;
  private f dnn;
  private ad dnp;
  private HelperHeaderPreference.a mXl;
  
  public i(Context paramContext)
  {
    this.context = paramContext;
    this.mXl = new r(paramContext);
  }
  
  private void awY()
  {
    if ((q.Gu() & 0x1000000) == 0) {}
    for (int i = 1;; i = 0)
    {
      this.dnn.removeAll();
      this.dnn.addPreferencesFromResource(R.o.contact_info_pref_linkedin);
      ((HelperHeaderPreference)this.dnn.add("contact_info_header_helper")).a(this.dnp, this.mXl);
      if (i == 0) {
        break;
      }
      this.dnn.bJ("contact_info_linkedin_account", false);
      this.dnn.ade("contact_info_linkedin_install");
      return;
    }
    this.dnn.bJ("contact_info_linkedin_account", true);
    this.dnn.ade("contact_info_linkedin_uninstall");
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = paramContext.getString(R.l.settings_plugins_installing);; str = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      new am(new i.2(h.b(paramContext, str, true, null), paramBoolean), false).S(1500L, 1500L);
      return;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if ((paramInt == 40) || (paramInt == 34)) {
        awY();
      }
    }
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
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
      Assert.assertTrue(s.hG(paramad.field_username));
      au.Hx();
      c.Dz().a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    this.dnn.add("contact_info_header_helper");
    com.tencent.mm.plugin.profile.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      awY();
    }
  }
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_linkedin_install"))
    {
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_uninstall"))
    {
      h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          i.o(i.this.context, false);
        }
      }, null);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_account"))
    {
      Intent localIntent = new Intent(this.context, BindLinkedInUI.class);
      ((Activity)this.context).startActivityForResult(localIntent, 1);
    }
    y.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */