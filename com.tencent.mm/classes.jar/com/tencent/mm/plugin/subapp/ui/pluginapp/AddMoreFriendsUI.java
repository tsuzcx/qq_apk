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
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Map;

public class AddMoreFriendsUI
  extends MMPreference
{
  private f screen;
  private final int zTe = 4;
  private final int zTf = 9;
  
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
    localAddFriendItemPreference.fS();
    localAddFriendItemPreference.setSummary(2131759088);
    if ((bs.getInt(com.tencent.mm.m.g.ZY().getValue("InviteFriendsControlFlags"), 0) & 0x4) > 0) {
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
      com.tencent.mm.plugin.report.service.h.wUl.f(11265, new Object[] { Integer.valueOf(1) });
      if ((!com.tencent.mm.r.a.cg(this)) && (!com.tencent.mm.bh.e.aIX()) && (!com.tencent.mm.r.a.cj(getContext()))) {
        com.tencent.mm.br.d.b(this, "scanner", ".ui.BaseScanUI", paramf);
      }
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_other_way".equals(paramPreference.mKey))
    {
      if (l.aPC() != l.a.iKF)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.aj(this, paramf);
        AppMethodBeat.o(29202);
        return true;
      }
      paramf = new Intent(this, MobileFriendUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_web".equals(paramPreference.mKey))
    {
      if (z.Uk(0))
      {
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(com.tencent.mm.sdk.platformtools.ai.getContext(), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29194);
            Intent localIntent = z.exm();
            localIntent.putExtra("KRightBtn", true);
            localIntent.putExtra("ftsneedkeyboard", true);
            localIntent.putExtra("key_load_js_without_delay", true);
            localIntent.putExtra("ftsType", 1);
            localIntent.putExtra("ftsbizscene", 9);
            Object localObject = z.f(9, true, 0);
            String str = z.Ui(bs.aLy((String)((Map)localObject).get("scene")));
            ((Map)localObject).put("sessionId", str);
            ((Map)localObject).put("subSessionId", str);
            localIntent.putExtra("sessionId", str);
            localIntent.putExtra("subSessionId", str);
            localIntent.putExtra("rawUrl", z.aV((Map)localObject));
            str = null;
            localObject = str;
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject = str;
              if (!aj.DT()) {
                localObject = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
              }
            }
            com.tencent.mm.br.d.a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
            AppMethodBeat.o(29194);
          }
        });
        paramPreference.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(29202);
        return true;
        ac.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
      }
    }
    if ("find_friends_by_radar".equals(paramPreference.mKey))
    {
      com.tencent.mm.br.d.N(this, "radar", ".ui.RadarSearchUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_create_pwdgroup".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11140, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.br.d.N(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_invite".equals(paramPreference.mKey))
    {
      int i = getIntent().getIntExtra("invite_friend_scene", 4);
      com.tencent.mm.plugin.report.service.h.wUl.f(14034, new Object[] { Integer.valueOf(i) });
      paramf = new Intent(this, InviteFriendsBy3rdUI.class);
      paramf.putExtra("Invite_friends", i);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
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
        if (!aj.DT()) {
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
    if (!com.tencent.mm.br.d.aCT("brandservice"))
    {
      this.screen.cK("find_friends_by_web", true);
      this.screen.notifyDataSetChanged();
      localObject = (AddFriendSearchPreference)this.screen.aPN("find_friends_by_input");
      ((AddFriendSearchPreference)localObject).zSY = getString(2131757917);
      ((AddFriendSearchPreference)localObject).zTa = new AddMoreFriendsUI.3(this);
      localPreferenceInfoCategory = (PreferenceInfoCategory)this.screen.aPN("find_friends_info");
      localObject = u.axw();
      String str1 = u.axx();
      com.tencent.mm.model.az.ayM();
      str2 = com.tencent.mm.sdk.platformtools.az.aLc((String)c.agA().get(6, null));
      if (bs.isNullOrNil(str1)) {
        break label249;
      }
      localObject = getString(2131759103, new Object[] { str1 });
    }
    for (;;)
    {
      localPreferenceInfoCategory.setTitle((CharSequence)localObject);
      localObject = new AddMoreFriendsUI.4(this);
      localPreferenceInfoCategory.HFZ = ((View.OnClickListener)localObject);
      localPreferenceInfoCategory.HGa = ((View.OnClickListener)localObject);
      ((AddFriendItemPreference)this.screen.aPN("find_friends_create_pwdgroup")).xpN = 8;
      com.tencent.mm.cq.d.fBf();
      if (getPreferenceScreen() != null)
      {
        localObject = getPreferenceScreen().aPN("find_friends_by_web");
        if (localObject != null) {
          ((Preference)localObject).setEnabled(true);
        }
      }
      AppMethodBeat.o(29199);
      return;
      this.screen.cK("find_friends_by_web", false);
      break;
      label249:
      if (!com.tencent.mm.storage.ai.aNf((String)localObject)) {
        localObject = getString(2131759103, new Object[] { localObject });
      } else if (!bs.isNullOrNil(str2)) {
        localObject = getString(2131759104, new Object[] { com.tencent.mm.sdk.platformtools.az.aLb(str2) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */