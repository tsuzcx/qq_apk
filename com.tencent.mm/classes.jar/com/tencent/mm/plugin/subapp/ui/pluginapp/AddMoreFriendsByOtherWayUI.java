package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddMoreFriendsByOtherWayUI
  extends MMPreference
{
  private f dnn;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    int i = 0;
    y.d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", new Object[] { paramPreference.mKey });
    if ("find_friends_by_mobile".equals(paramPreference.mKey))
    {
      if (l.WP() != l.a.ffT)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.C(this, paramf);
        return true;
      }
      startActivity(new Intent(this, MobileFriendUI.class));
      return true;
    }
    if ("find_friends_by_google_account".equals(paramPreference.mKey))
    {
      if (TextUtils.isEmpty((String)g.DP().Dz().get(208903, null))) {}
      while (i == 0)
      {
        paramf = new Intent(this, BindGoogleContactUI.class);
        paramf.putExtra("enter_scene", 1);
        MMWizardActivity.C(this, paramf);
        return true;
        i = 1;
      }
      paramf = new Intent(this, GoogleFriendUI.class);
      paramf.putExtra("enter_scene", 1);
      startActivity(paramf);
      return true;
    }
    return false;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.add_more_friends_title);
    this.dnn = this.vdd;
    setBackBtn(new AddMoreFriendsByOtherWayUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((IconPreference)this.dnn.add("find_friends_by_google_account") != null) {
      if ((q.Gu() & 0x800000) != 0) {
        break label65;
      }
    }
    label65:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!bk.fV(this))) {
        this.dnn.ade("find_friends_by_google_account");
      }
      this.dnn.notifyDataSetChanged();
      return;
    }
  }
  
  public final int xj()
  {
    return R.o.add_more_friends_by_other_way;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsByOtherWayUI
 * JD-Core Version:    0.7.0.1
 */