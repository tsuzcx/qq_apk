package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Map;

public class AddMoreFriendsUI
  extends MMPreference
{
  private f screen;
  private final int yFQ = 4;
  private final int yFR = 9;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getResourceId()
  {
    return 2131951617;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29203);
    setMMTitle(2131755148);
    this.screen = getPreferenceScreen();
    AddFriendItemPreference localAddFriendItemPreference = new AddFriendItemPreference(getContext());
    localAddFriendItemPreference.setKey("find_friends_by_invite");
    localAddFriendItemPreference.setTitle(2131759087);
    localAddFriendItemPreference.fK();
    localAddFriendItemPreference.setSummary(2131759088);
    if ((bt.getInt(com.tencent.mm.m.g.Zd().getValue("InviteFriendsControlFlags"), 0) & 0x4) > 0) {
      this.screen.a(localAddFriendItemPreference, 4);
    }
    hideActionbarLine();
    setBackBtn(new AddMoreFriendsUI.2(this));
    AppMethodBeat.o(29203);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29198);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29198);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29201);
    super.onDestroy();
    AppMethodBeat.o(29201);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29204);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(29204);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29200);
    super.onPause();
    AppMethodBeat.o(29200);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29202);
    if ("find_friends_by_qrcode".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      paramf.putExtra("BaseScanUI_select_scan_mode", 1);
      paramf.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      paramf.setFlags(65536);
      h.vKh.f(11265, new Object[] { Integer.valueOf(1) });
      if ((!com.tencent.mm.r.a.cd(this)) && (!com.tencent.mm.bi.e.aCh())) {
        com.tencent.mm.bs.d.b(this, "scanner", ".ui.BaseScanUI", paramf);
      }
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_other_way".equals(paramPreference.mKey))
    {
      if (l.aIL() != l.a.iky)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.V(this, paramf);
        AppMethodBeat.o(29202);
        return true;
      }
      paramf = new Intent(this, MobileFriendUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_web".equals(paramPreference.mKey))
    {
      if (aa.Sa(0))
      {
        ((i)com.tencent.mm.kernel.g.ab(i.class)).a(aj.getContext(), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29194);
            Intent localIntent = aa.ehS();
            localIntent.putExtra("KRightBtn", true);
            localIntent.putExtra("ftsneedkeyboard", true);
            localIntent.putExtra("key_load_js_without_delay", true);
            localIntent.putExtra("ftsType", 1);
            localIntent.putExtra("ftsbizscene", 9);
            Object localObject = aa.f(9, true, 0);
            String str = aa.RY(bt.aGh((String)((Map)localObject).get("scene")));
            ((Map)localObject).put("sessionId", str);
            ((Map)localObject).put("subSessionId", str);
            localIntent.putExtra("sessionId", str);
            localIntent.putExtra("subSessionId", str);
            localIntent.putExtra("rawUrl", aa.aR((Map)localObject));
            str = null;
            localObject = str;
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject = str;
              if (!ai.Eq()) {
                localObject = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
              }
            }
            com.tencent.mm.bs.d.a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
            AppMethodBeat.o(29194);
          }
        });
        paramPreference.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(29202);
        return true;
        ad.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
      }
    }
    if ("find_friends_by_radar".equals(paramPreference.mKey))
    {
      com.tencent.mm.bs.d.O(this, "radar", ".ui.RadarSearchUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_create_pwdgroup".equals(paramPreference.mKey))
    {
      h.vKh.f(11140, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.bs.d.O(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_invite".equals(paramPreference.mKey))
    {
      int i = getIntent().getIntExtra("invite_friend_scene", 4);
      h.vKh.f(14034, new Object[] { Integer.valueOf(i) });
      paramf = new Intent(this, InviteFriendsBy3rdUI.class);
      paramf.putExtra("Invite_friends", i);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_ww".equals(paramPreference.mKey))
    {
      Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
      paramPreference = null;
      paramf = paramPreference;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramf = paramPreference;
        if (!ai.Eq()) {
          paramf = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
      }
      com.tencent.mm.plugin.fts.a.d.b(getContext(), ".ui.FTSAddWw", localIntent, paramf);
      AppMethodBeat.o(29202);
      return true;
    }
    AppMethodBeat.o(29202);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29199);
    super.onResume();
    Object localObject;
    PreferenceInfoCategory localPreferenceInfoCategory;
    String str2;
    if (!com.tencent.mm.bs.d.axB("brandservice"))
    {
      this.screen.cE("find_friends_by_web", true);
      this.screen.notifyDataSetChanged();
      localObject = (AddFriendSearchPreference)this.screen.aKk("find_friends_by_input");
      ((AddFriendSearchPreference)localObject).yFK = getString(2131757917);
      ((AddFriendSearchPreference)localObject).yFM = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29196);
          Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
          Object localObject = null;
          paramAnonymousView = localObject;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramAnonymousView = localObject;
            if (!ai.Eq()) {
              paramAnonymousView = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
            }
          }
          com.tencent.mm.plugin.fts.a.d.b(AddMoreFriendsUI.this.getContext(), ".ui.FTSAddFriendUI", localIntent, paramAnonymousView);
          AppMethodBeat.o(29196);
        }
      };
      localPreferenceInfoCategory = (PreferenceInfoCategory)this.screen.aKk("find_friends_info");
      localObject = u.aqG();
      String str1 = u.aqH();
      az.arV();
      str2 = ba.aFL((String)c.afk().get(6, null));
      if (bt.isNullOrNil(str1)) {
        break label249;
      }
      localObject = getString(2131759103, new Object[] { str1 });
    }
    for (;;)
    {
      localPreferenceInfoCategory.setTitle((CharSequence)localObject);
      localObject = new AddMoreFriendsUI.4(this);
      localPreferenceInfoCategory.Ggj = ((View.OnClickListener)localObject);
      localPreferenceInfoCategory.Ggk = ((View.OnClickListener)localObject);
      ((AddFriendItemPreference)this.screen.aKk("find_friends_create_pwdgroup")).wez = 8;
      com.tencent.mm.cr.d.fkP();
      if (getPreferenceScreen() != null)
      {
        localObject = getPreferenceScreen().aKk("find_friends_by_web");
        if (localObject != null) {
          ((Preference)localObject).setEnabled(true);
        }
      }
      AppMethodBeat.o(29199);
      return;
      this.screen.cE("find_friends_by_web", false);
      break;
      label249:
      if (!af.aHK((String)localObject)) {
        localObject = getString(2131759103, new Object[] { localObject });
      } else if (!bt.isNullOrNil(str2)) {
        localObject = getString(2131759104, new Object[] { ba.aFK(str2) });
      } else {
        localObject = getString(2131759105);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */