package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class ShareMicroMsgChoiceUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  
  public boolean autoRefresh()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return b.g.share_mm_choice;
  }
  
  public int getResourceId()
  {
    return b.k.share_micromsg_choice;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73843);
    setMMTitle(b.i.send_qrcode_to_microblog);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73841);
        ShareMicroMsgChoiceUI.this.hideVKB();
        ShareMicroMsgChoiceUI.this.finish();
        AppMethodBeat.o(73841);
        return true;
      }
    });
    ((IconPreference)this.screen.byG("share_micromsg_to_sina")).drawable = com.tencent.mm.ci.a.m(this, b.e.share_to_sinaweibo_icon);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().aPi("@t.qq.com");
    int i;
    IconPreference localIconPreference;
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, null)) != 0)
    {
      i = 1;
      localIconPreference = (IconPreference)this.screen.byG("share_micromsg_qzone");
      if (i != 0) {
        break label173;
      }
      this.screen.d(localIconPreference);
    }
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.byG("share_micromsg_to_fuckbook");
      if (!z.bdE()) {
        break label187;
      }
      localIconPreference.drawable = com.tencent.mm.ci.a.m(this, b.e.share_to_facebook_icon);
      AppMethodBeat.o(73843);
      return;
      i = 0;
      break;
      label173:
      localIconPreference.drawable = com.tencent.mm.ci.a.m(this, b.e.self_qrcode_show_to_qzone);
    }
    label187:
    this.screen.d(localIconPreference);
    AppMethodBeat.o(73843);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73842);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(73842);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73844);
    paramf = paramPreference.mKey;
    if (paramf.equals("share_micromsg_qzone")) {
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, null)) != 0)
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 2);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(73844);
      return false;
      com.tencent.mm.ui.base.h.p(this, b.i.self_qrcode_show_no_qq_tip, b.i.app_tip);
      continue;
      if (paramf.equals("share_micromsg_to_sina"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 3);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("share_micromsg_to_fuckbook"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 4);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareMicroMsgChoiceUI
 * JD-Core Version:    0.7.0.1
 */