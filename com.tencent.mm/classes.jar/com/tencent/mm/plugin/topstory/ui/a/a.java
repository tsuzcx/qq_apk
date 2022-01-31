package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.topstory.ui.b.h;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, m.b
{
  private Context context;
  private f dnn;
  private ad dnp;
  private CheckBoxPreference iUh;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void awY()
  {
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
    localHelperHeaderPreference.al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(b.g.contact_info_top_story_switch_tip));
    if ((q.Gu() & 0x4000000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label140;
      }
      localHelperHeaderPreference.ov(1);
      this.dnn.bJ("contact_info_top_story_install", true);
      this.dnn.bJ("contact_info_top_story_uninstall", false);
      this.dnn.bJ("contact_info_go_to_top_story", false);
      this.dnn.bJ("contact_info_top_story_not_disturb", false);
      label111:
      if ((q.Gp() & 0x1000000) != 0) {
        break label196;
      }
    }
    label140:
    label196:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label201;
      }
      this.iUh.rHo = true;
      return;
      i = 0;
      break;
      localHelperHeaderPreference.ov(0);
      this.dnn.bJ("contact_info_top_story_install", false);
      this.dnn.bJ("contact_info_top_story_uninstall", true);
      this.dnn.bJ("contact_info_go_to_top_story", true);
      this.dnn.bJ("contact_info_top_story_not_disturb", true);
      break label111;
    }
    label201:
    this.iUh.rHo = false;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    paramInt = bk.e(paramObject, 0);
    if ((paramm != g.DP().Dz()) || (paramInt <= 0)) {}
    while ((paramInt != 40) && (paramInt != 34) && (paramInt != 7)) {
      return;
    }
    awY();
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    this.dnn = paramf;
    this.dnp = paramad;
    paramf.addPreferencesFromResource(b.h.contact_info_pref_top_story);
    g.DP().Dz().a(this);
    this.iUh = ((CheckBoxPreference)paramf.add("contact_info_top_story_not_disturb"));
    awY();
    return true;
  }
  
  public final boolean awZ()
  {
    g.DP().Dz().b(this);
    return true;
  }
  
  final void ik(boolean paramBoolean)
  {
    int i = q.Gu();
    Object localObject;
    if (paramBoolean)
    {
      i &= 0xFBFFFFFF;
      g.DP().Dz().o(34, Integer.valueOf(i));
      localObject = new bev();
      ((bev)localObject).stP = 67108864;
      if (!paramBoolean) {
        break label186;
      }
    }
    label186:
    for (i = 0;; i = 1)
    {
      ((bev)localObject).tzI = i;
      ((j)g.r(j.class)).Fv().b(new i.a(39, (com.tencent.mm.bv.a)localObject));
      awY();
      if (!paramBoolean) {
        break label191;
      }
      if (((j)g.r(j.class)).FB().abv("topstoryapp") == null)
      {
        localObject = new ak();
        ((ak)localObject).setUsername("topstoryapp");
        ((ak)localObject).setContent(this.context.getString(b.g.contact_info_top_story_switch_tip));
        ((ak)localObject).ba(bk.UY());
        ((ak)localObject).fA(0);
        ((ak)localObject).fy(0);
        ((j)g.r(j.class)).FB().d((ak)localObject);
      }
      return;
      i |= 0x4000000;
      break;
    }
    label191:
    ((j)g.r(j.class)).FB().abu("topstoryapp");
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    if ("contact_info_go_to_top_story".equals(paramString)) {
      d.L(this.context, 0);
    }
    do
    {
      return false;
      if ("contact_info_top_story_install".equals(paramString))
      {
        ik(true);
        return false;
      }
      if ("contact_info_top_story_uninstall".equals(paramString))
      {
        com.tencent.mm.ui.base.h.a(this.context, this.context.getString(b.g.settings_plugins_uninstall_hint), "", this.context.getString(b.g.app_clear), this.context.getString(b.g.app_cancel), new a.1(this), null);
        return false;
      }
    } while (!"contact_info_top_story_not_disturb".equals(paramString));
    int i = q.Gp();
    if (this.iUh.isChecked())
    {
      i &= 0xFEFFFFFF;
      g.DP().Dz().o(40, Integer.valueOf(i));
      paramString = new zr();
      paramString.sYS = 55;
      if (!this.iUh.isChecked()) {
        break label208;
      }
    }
    label208:
    for (i = 2;; i = 1)
    {
      paramString.nfn = i;
      ((j)g.r(j.class)).Fv().b(new i.a(55, paramString));
      return false;
      i |= 0x1000000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */