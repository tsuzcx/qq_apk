package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;

public class AddMoreFriendsUI
  extends MMPreference
{
  private final int sZs = 4;
  private final int sZt = 9;
  private f screen;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getResourceId()
  {
    return 2131165185;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25513);
    setMMTitle(2131296420);
    this.screen = getPreferenceScreen();
    AddFriendItemPreference localAddFriendItemPreference = new AddFriendItemPreference(getContext());
    localAddFriendItemPreference.setKey("find_friends_by_invite");
    localAddFriendItemPreference.setTitle(2131299900);
    localAddFriendItemPreference.es();
    localAddFriendItemPreference.setSummary(2131299901);
    if ((bo.getInt(com.tencent.mm.m.g.Nq().getValue("InviteFriendsControlFlags"), 0) & 0x4) > 0) {
      this.screen.a(localAddFriendItemPreference, 4);
    }
    hideActionbarLine();
    setBackBtn(new AddMoreFriendsUI.2(this));
    AppMethodBeat.o(25513);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25508);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(25508);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25511);
    super.onDestroy();
    AppMethodBeat.o(25511);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25514);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25514);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25510);
    super.onPause();
    AppMethodBeat.o(25510);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(25512);
    if ("find_friends_by_qrcode".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      paramf.putExtra("BaseScanUI_select_scan_mode", 1);
      paramf.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      paramf.setFlags(65536);
      h.qsU.e(11265, new Object[] { Integer.valueOf(1) });
      if ((!a.bN(this)) && (!com.tencent.mm.bg.e.alb())) {
        com.tencent.mm.bq.d.b(this, "scanner", ".ui.BaseScanUI", paramf);
      }
      AppMethodBeat.o(25512);
      return true;
    }
    if ("find_friends_by_other_way".equals(paramPreference.mKey))
    {
      if (l.aqq() != l.a.gxB)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.J(this, paramf);
        AppMethodBeat.o(25512);
        return true;
      }
      startActivity(new Intent(this, MobileFriendUI.class));
      AppMethodBeat.o(25512);
      return true;
    }
    if ("find_friends_by_web".equals(paramPreference.mKey))
    {
      if (aa.Je(0))
      {
        ((m)com.tencent.mm.kernel.g.E(m.class)).a(ah.getContext(), new AddMoreFriendsUI.1(this));
        paramPreference.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(25512);
        return true;
        ab.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
      }
    }
    if ("find_friends_by_radar".equals(paramPreference.mKey))
    {
      com.tencent.mm.bq.d.H(this, "radar", ".ui.RadarSearchUI");
      AppMethodBeat.o(25512);
      return true;
    }
    if ("find_friends_create_pwdgroup".equals(paramPreference.mKey))
    {
      h.qsU.e(11140, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.bq.d.H(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      AppMethodBeat.o(25512);
      return true;
    }
    if ("find_friends_by_invite".equals(paramPreference.mKey))
    {
      int i = getIntent().getIntExtra("invite_friend_scene", 4);
      h.qsU.e(14034, new Object[] { Integer.valueOf(i) });
      paramf = new Intent(this, InviteFriendsBy3rdUI.class);
      paramf.putExtra("Invite_friends", i);
      startActivity(paramf);
      AppMethodBeat.o(25512);
      return true;
    }
    if ("find_friends_by_ww".equals(paramPreference.mKey))
    {
      paramPreference = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
      paramf = null;
      if (Build.VERSION.SDK_INT >= 21) {
        paramf = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
      }
      com.tencent.mm.plugin.fts.a.d.b(getContext(), ".ui.FTSAddWw", paramPreference, paramf);
      AppMethodBeat.o(25512);
      return true;
    }
    AppMethodBeat.o(25512);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25509);
    super.onResume();
    Object localObject;
    PreferenceInfoCategory localPreferenceInfoCategory;
    String str2;
    if (!com.tencent.mm.bq.d.ahR("brandservice"))
    {
      this.screen.cl("find_friends_by_web", true);
      this.screen.notifyDataSetChanged();
      localObject = (AddFriendSearchPreference)this.screen.atx("find_friends_by_input");
      ((AddFriendSearchPreference)localObject).sZk = getString(2131298839);
      ((AddFriendSearchPreference)localObject).sZm = new AddMoreFriendsUI.3(this);
      localPreferenceInfoCategory = (PreferenceInfoCategory)this.screen.atx("find_friends_info");
      localObject = r.Zn();
      String str1 = r.Zo();
      aw.aaz();
      str2 = av.apy((String)c.Ru().get(6, null));
      if (bo.isNullOrNil(str1)) {
        break label244;
      }
      localObject = getString(2131299916, new Object[] { str1 });
    }
    for (;;)
    {
      localPreferenceInfoCategory.setTitle((CharSequence)localObject);
      localObject = new AddMoreFriendsUI.4(this);
      localPreferenceInfoCategory.zst = ((View.OnClickListener)localObject);
      localPreferenceInfoCategory.zsu = ((View.OnClickListener)localObject);
      ((AddFriendItemPreference)this.screen.atx("find_friends_create_pwdgroup")).qGf = 8;
      com.tencent.mm.cn.d.aNX();
      if (getPreferenceScreen() != null)
      {
        localObject = getPreferenceScreen().atx("find_friends_by_web");
        if (localObject != null) {
          ((Preference)localObject).setEnabled(true);
        }
      }
      AppMethodBeat.o(25509);
      return;
      this.screen.cl("find_friends_by_web", false);
      break;
      label244:
      if (!ad.ari((String)localObject)) {
        localObject = getString(2131299916, new Object[] { localObject });
      } else if (!bo.isNullOrNil(str2)) {
        localObject = getString(2131299917, new Object[] { av.apx(str2) });
      } else {
        localObject = getString(2131299918);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */