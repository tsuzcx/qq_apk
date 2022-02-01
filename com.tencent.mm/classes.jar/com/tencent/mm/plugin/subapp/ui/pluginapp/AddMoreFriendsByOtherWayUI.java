package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddMoreFriendsByOtherWayUI
  extends MMPreference
{
  private f screen;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getResourceId()
  {
    return 2131951618;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29192);
    setMMTitle(2131755148);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29188);
        AddMoreFriendsByOtherWayUI.this.finish();
        AppMethodBeat.o(29188);
        return true;
      }
    });
    AppMethodBeat.o(29192);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29189);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29189);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29193);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(29193);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29191);
    ad.d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", new Object[] { paramPreference.mKey });
    if ("find_friends_by_mobile".equals(paramPreference.mKey))
    {
      if (l.aSO() != l.a.jdO)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.al(this, paramf);
        AppMethodBeat.o(29191);
        return true;
      }
      paramf = new Intent(this, MobileFriendUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsByOtherWayUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsByOtherWayUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29191);
      return true;
    }
    if ("find_friends_by_google_account".equals(paramPreference.mKey))
    {
      if (TextUtils.isEmpty((String)g.ajC().ajl().get(208903, null))) {}
      for (int i = 0; i == 0; i = 1)
      {
        paramf = new Intent(this, BindGoogleContactUI.class);
        paramf.putExtra("enter_scene", 1);
        MMWizardActivity.al(this, paramf);
        AppMethodBeat.o(29191);
        return true;
      }
      paramf = new Intent(this, GoogleFriendUI.class);
      paramf.putExtra("enter_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsByOtherWayUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsByOtherWayUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29191);
      return true;
    }
    AppMethodBeat.o(29191);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29190);
    super.onResume();
    if ((IconPreference)this.screen.aVD("find_friends_by_google_account") != null) {
      if ((u.aAy() & 0x800000) != 0) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!bt.jk(this))) {
        this.screen.aVE("find_friends_by_google_account");
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(29190);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsByOtherWayUI
 * JD-Core Version:    0.7.0.1
 */