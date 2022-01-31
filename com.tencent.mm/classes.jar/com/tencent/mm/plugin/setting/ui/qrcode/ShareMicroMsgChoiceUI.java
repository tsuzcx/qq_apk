package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
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
    return 2130970726;
  }
  
  public int getResourceId()
  {
    return 2131165298;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126914);
    setMMTitle(2131303118);
    this.screen = getPreferenceScreen();
    setBackBtn(new ShareMicroMsgChoiceUI.1(this));
    ((IconPreference)this.screen.atx("share_micromsg_to_sina")).drawable = a.k(this, 2130840309);
    ((j)g.E(j.class)).YI().TL("@t.qq.com");
    int i;
    IconPreference localIconPreference;
    if (bo.g((Integer)g.RL().Ru().get(9, null)) != 0)
    {
      i = 1;
      localIconPreference = (IconPreference)this.screen.atx("share_micromsg_qzone");
      if (i != 0) {
        break label170;
      }
      this.screen.d(localIconPreference);
    }
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.atx("share_micromsg_to_fuckbook");
      if (!r.ZM()) {
        break label183;
      }
      localIconPreference.drawable = a.k(this, 2130840308);
      AppMethodBeat.o(126914);
      return;
      i = 0;
      break;
      label170:
      localIconPreference.drawable = a.k(this, 2130840233);
    }
    label183:
    this.screen.d(localIconPreference);
    AppMethodBeat.o(126914);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126913);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(126913);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(126915);
    paramf = paramPreference.mKey;
    if (paramf.equals("share_micromsg_qzone")) {
      if (bo.g((Integer)g.RL().Ru().get(9, null)) != 0)
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 2);
        startActivity(paramf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126915);
      return false;
      h.h(this, 2131303093, 2131297087);
      continue;
      if (paramf.equals("share_micromsg_to_sina"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 3);
        startActivity(paramf);
      }
      else if (paramf.equals("share_micromsg_to_fuckbook"))
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 4);
        startActivity(paramf);
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