package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
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
    return 2131496300;
  }
  
  public int getResourceId()
  {
    return 2132017287;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73843);
    setMMTitle(2131765226);
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
    ((IconPreference)this.screen.bmg("share_micromsg_to_sina")).drawable = com.tencent.mm.cb.a.l(this, 2131234860);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com");
    int i;
    IconPreference localIconPreference;
    if (Util.nullAsNil((Integer)g.aAh().azQ().get(9, null)) != 0)
    {
      i = 1;
      localIconPreference = (IconPreference)this.screen.bmg("share_micromsg_qzone");
      if (i != 0) {
        break label170;
      }
      this.screen.e(localIconPreference);
    }
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.bmg("share_micromsg_to_fuckbook");
      if (!z.aUC()) {
        break label183;
      }
      localIconPreference.drawable = com.tencent.mm.cb.a.l(this, 2131234859);
      AppMethodBeat.o(73843);
      return;
      i = 0;
      break;
      label170:
      localIconPreference.drawable = com.tencent.mm.cb.a.l(this, 2131234776);
    }
    label183:
    this.screen.e(localIconPreference);
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
      if (Util.nullAsNil((Integer)g.aAh().azQ().get(9, null)) != 0)
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 2);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(73844);
      return false;
      h.n(this, 2131765192, 2131755998);
      continue;
      if (paramf.equals("share_micromsg_to_sina"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 3);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("share_micromsg_to_fuckbook"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 4);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShareMicroMsgChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareMicroMsgChoiceUI
 * JD-Core Version:    0.7.0.1
 */