package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShareMicroMsgChoiceUI
  extends MMPreference
{
  private f screen;
  
  public boolean autoRefresh()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131495430;
  }
  
  public int getResourceId()
  {
    return 2131951742;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73843);
    setMMTitle(2131763067);
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
    ((IconPreference)this.screen.aXe("share_micromsg_to_sina")).drawable = com.tencent.mm.cb.a.l(this, 2131234022);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com");
    int i;
    IconPreference localIconPreference;
    if (bu.o((Integer)g.ajR().ajA().get(9, null)) != 0)
    {
      i = 1;
      localIconPreference = (IconPreference)this.screen.aXe("share_micromsg_qzone");
      if (i != 0) {
        break label170;
      }
      this.screen.d(localIconPreference);
    }
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.aXe("share_micromsg_to_fuckbook");
      if (!v.aBf()) {
        break label183;
      }
      localIconPreference.drawable = com.tencent.mm.cb.a.l(this, 2131234021);
      AppMethodBeat.o(73843);
      return;
      i = 0;
      break;
      label170:
      localIconPreference.drawable = com.tencent.mm.cb.a.l(this, 2131233940);
    }
    label183:
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
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73844);
    paramf = paramPreference.mKey;
    if (paramf.equals("share_micromsg_qzone")) {
      if (bu.o((Integer)g.ajR().ajA().get(9, null)) != 0)
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 2);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(73844);
      return false;
      h.l(this, 2131763041, 2131755906);
      continue;
      if (paramf.equals("share_micromsg_to_sina"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 3);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("share_micromsg_to_fuckbook"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 4);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareMicroMsgChoiceUI
 * JD-Core Version:    0.7.0.1
 */