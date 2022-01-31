package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShareMicroMsgChoiceUI
  extends MMPreference
{
  private f dnn;
  
  protected final boolean XI()
  {
    return false;
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("share_micromsg_qzone")) {
      if (bk.g((Integer)g.DP().Dz().get(9, null)) != 0)
      {
        paramf = new Intent(this, ShowQRCodeStep1UI.class);
        paramf.putExtra("show_to", 2);
        startActivity(paramf);
      }
    }
    for (;;)
    {
      return false;
      h.h(this, a.i.self_qrcode_show_no_qq_tip, a.i.app_tip);
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
  
  public final int getLayoutId()
  {
    return a.g.share_mm_choice;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.send_qrcode_to_microblog);
    this.dnn = this.vdd;
    setBackBtn(new ShareMicroMsgChoiceUI.1(this));
    ((IconPreference)this.dnn.add("share_micromsg_to_sina")).drawable = a.g(this, a.e.share_to_sinaweibo_icon);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com");
    int i;
    IconPreference localIconPreference;
    if (bk.g((Integer)g.DP().Dz().get(9, null)) != 0)
    {
      i = 1;
      localIconPreference = (IconPreference)this.dnn.add("share_micromsg_qzone");
      if (i != 0) {
        break label163;
      }
      this.dnn.c(localIconPreference);
    }
    for (;;)
    {
      localIconPreference = (IconPreference)this.dnn.add("share_micromsg_to_fuckbook");
      if (!q.GI()) {
        break label177;
      }
      localIconPreference.drawable = a.g(this, a.e.share_to_facebook_icon);
      return;
      i = 0;
      break;
      label163:
      localIconPreference.drawable = a.g(this, a.e.self_qrcode_show_to_qzone);
    }
    label177:
    this.dnn.c(localIconPreference);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public final int xj()
  {
    return a.k.share_micromsg_choice;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareMicroMsgChoiceUI
 * JD-Core Version:    0.7.0.1
 */