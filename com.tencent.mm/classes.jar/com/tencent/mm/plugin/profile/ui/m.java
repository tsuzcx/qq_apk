package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class m
  implements a, m.b
{
  private boolean bIU;
  Context context;
  private f dnn;
  private ad dnp;
  
  public m(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void awY()
  {
    boolean bool2 = true;
    this.bIU = q.GE();
    Object localObject = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(R.l.contact_info_qqsync_switch_tip));
    int i;
    if (this.bIU)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).ov(i);
      localObject = this.dnn;
      if (this.bIU) {
        break label165;
      }
      bool1 = true;
      label84:
      ((f)localObject).bJ("contact_info_go_to_sync", bool1);
      localObject = this.dnn;
      if (this.bIU) {
        break label170;
      }
      bool1 = true;
      label109:
      ((f)localObject).bJ("contact_info_remind_me_syncing_tip", bool1);
      this.dnn.bJ("contact_info_qqsync_install", this.bIU);
      localObject = this.dnn;
      if (this.bIU) {
        break label175;
      }
    }
    label165:
    label170:
    label175:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).bJ("contact_info_qqsync_uninstall", bool1);
      return;
      i = 0;
      break;
      bool1 = false;
      break label84;
      bool1 = false;
      break label109;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if (this.bIU != q.GE()) {
      awY();
    }
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    au.Hx();
    c.Dz().a(this);
    this.dnn = paramf;
    this.dnp = paramad;
    paramf.addPreferencesFromResource(R.o.contact_info_pref_qqsync);
    awY();
    return true;
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void p(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = paramContext.getString(R.l.settings_plugins_installing);; str = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = h.b(paramContext, str, true, null);
      au.DS().O(new m.3(this, paramBoolean, paramContext));
      return;
    }
  }
  
  public final boolean xQ(String paramString)
  {
    if (bk.pm(paramString).length() <= 0) {}
    do
    {
      return false;
      if ("contact_info_go_to_sync".equals(paramString))
      {
        if (p.o(this.context, "com.tencent.qqpim"))
        {
          paramString = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
          paramString.addFlags(268435456);
          this.context.startActivity(paramString);
        }
        for (;;)
        {
          return true;
          h.a(this.context, R.l.contact_info_qqsync_download, R.l.app_tip, R.l.app_download, R.l.app_cancel, new m.2(this), null);
        }
      }
      if ("contact_info_remind_me_syncing".equals(paramString))
      {
        paramString = (CheckBoxPreference)this.dnn.add("contact_info_remind_me_syncing");
        au.Hx();
        c.Dz().o(65792, Boolean.valueOf(paramString.isChecked()));
        if (paramString.isChecked()) {}
        for (paramString = "1";; paramString = "2")
        {
          bt.o(6, paramString);
          return true;
        }
      }
      if (paramString.equals("contact_info_qqsync_install"))
      {
        p(this.context, true);
        return true;
      }
    } while (!paramString.equals("contact_info_qqsync_uninstall"));
    h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new m.1(this), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m
 * JD-Core Version:    0.7.0.1
 */