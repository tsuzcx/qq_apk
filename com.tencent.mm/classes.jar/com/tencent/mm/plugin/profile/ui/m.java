package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class m
  implements a, n.b
{
  private ad contact;
  Context context;
  private boolean enable;
  private f screen;
  
  public m(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bkc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(23600);
    this.enable = r.ZJ();
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298714));
    int i;
    if (this.enable)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).sb(i);
      localObject = this.screen;
      if (this.enable) {
        break label176;
      }
      bool1 = true;
      label89:
      ((f)localObject).cl("contact_info_go_to_sync", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label181;
      }
      bool1 = true;
      label114:
      ((f)localObject).cl("contact_info_remind_me_syncing_tip", bool1);
      this.screen.cl("contact_info_qqsync_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label186;
      }
    }
    label176:
    label181:
    label186:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cl("contact_info_qqsync_uninstall", bool1);
      AppMethodBeat.o(23600);
      return;
      i = 0;
      break;
      bool1 = false;
      break label89;
      bool1 = false;
      break label114;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23595);
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(23595);
      return false;
    }
    if ("contact_info_go_to_sync".equals(paramString))
    {
      if (p.u(this.context, "com.tencent.qqpim"))
      {
        paramString = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
        paramString.addFlags(268435456);
        this.context.startActivity(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(23595);
        return true;
        h.a(this.context, 2131298712, 2131297087, 2131296907, 2131296888, new m.2(this), null);
      }
    }
    if ("contact_info_remind_me_syncing".equals(paramString))
    {
      paramString = (CheckBoxPreference)this.screen.atx("contact_info_remind_me_syncing");
      aw.aaz();
      c.Ru().set(65792, Boolean.valueOf(paramString.isChecked()));
      if (paramString.isChecked()) {}
      for (paramString = "1";; paramString = "2")
      {
        bv.v(6, paramString);
        AppMethodBeat.o(23595);
        return true;
      }
    }
    if (paramString.equals("contact_info_qqsync_install"))
    {
      s(this.context, true);
      AppMethodBeat.o(23595);
      return true;
    }
    if (paramString.equals("contact_info_qqsync_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new m.1(this), null);
      AppMethodBeat.o(23595);
      return true;
    }
    AppMethodBeat.o(23595);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(23599);
    if (this.enable != r.ZJ()) {
      bkc();
    }
    AppMethodBeat.o(23599);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(23597);
    aw.aaz();
    c.Ru().a(this);
    this.screen = paramf;
    this.contact = paramad;
    paramf.addPreferencesFromResource(2131165219);
    bkc();
    AppMethodBeat.o(23597);
    return true;
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23598);
    aw.aaz();
    c.Ru().b(this);
    AppMethodBeat.o(23598);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(23596);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131303380);; str = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      paramContext = h.b(paramContext, str, true, null);
      aw.RO().ac(new m.3(this, paramBoolean, paramContext));
      AppMethodBeat.o(23596);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m
 * JD-Core Version:    0.7.0.1
 */