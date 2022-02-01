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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Map;

public class AddMoreFriendsUI
  extends MMPreference
{
  private final int BCi = 4;
  private final int BCj = 9;
  private f screen;
  
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
    localAddFriendItemPreference.gk();
    localAddFriendItemPreference.setSummary(2131759088);
    if ((bu.getInt(com.tencent.mm.n.g.acL().getValue("InviteFriendsControlFlags"), 0) & 0x4) > 0) {
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
      com.tencent.mm.plugin.report.service.g.yxI.f(11265, new Object[] { Integer.valueOf(1) });
      if ((!com.tencent.mm.r.a.n(this, true)) && (!com.tencent.mm.bh.e.aME()) && (!com.tencent.mm.r.a.p(getContext(), true))) {
        com.tencent.mm.br.d.b(this, "scanner", ".ui.BaseScanUI", paramf);
      }
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_other_way".equals(paramPreference.mKey))
    {
      if (l.aTn() != l.a.jgH)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.al(this, paramf);
        AppMethodBeat.o(29202);
        return true;
      }
      paramf = new Intent(this, MobileFriendUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_web".equals(paramPreference.mKey))
    {
      if (ad.WK(0))
      {
        ((i)com.tencent.mm.kernel.g.ab(i.class)).a(ak.getContext(), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29194);
            Intent localIntent = ad.ePM();
            localIntent.putExtra("KRightBtn", true);
            localIntent.putExtra("ftsneedkeyboard", true);
            localIntent.putExtra("key_load_js_without_delay", true);
            localIntent.putExtra("ftsType", 1);
            localIntent.putExtra("ftsbizscene", 9);
            Object localObject = ad.f(9, true, 0);
            String str = ad.WI(bu.aSB((String)((Map)localObject).get("scene")));
            ((Map)localObject).put("sessionId", str);
            ((Map)localObject).put("subSessionId", str);
            localIntent.putExtra("sessionId", str);
            localIntent.putExtra("subSessionId", str);
            localIntent.putExtra("rawUrl", ad.be((Map)localObject));
            str = null;
            localObject = str;
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject = str;
              if (!al.isDarkMode()) {
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
        ae.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
      }
    }
    if ("find_friends_by_radar".equals(paramPreference.mKey))
    {
      com.tencent.mm.br.d.Q(this, "radar", ".ui.RadarSearchUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_create_pwdgroup".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11140, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.br.d.Q(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_invite".equals(paramPreference.mKey))
    {
      int i = getIntent().getIntExtra("invite_friend_scene", 4);
      com.tencent.mm.plugin.report.service.g.yxI.f(14034, new Object[] { Integer.valueOf(i) });
      paramf = new Intent(this, InviteFriendsBy3rdUI.class);
      paramf.putExtra("Invite_friends", i);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
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
        if (!al.isDarkMode()) {
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
    if (!com.tencent.mm.br.d.aJN("brandservice"))
    {
      this.screen.cT("find_friends_by_web", true);
      this.screen.notifyDataSetChanged();
      localObject = (AddFriendSearchPreference)this.screen.aXe("find_friends_by_input");
      ((AddFriendSearchPreference)localObject).BCc = getString(2131757917);
      ((AddFriendSearchPreference)localObject).BCe = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29196);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
          localb = null;
          paramAnonymousView = localb;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramAnonymousView = localb;
            if (!al.isDarkMode()) {
              paramAnonymousView = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
            }
          }
          com.tencent.mm.plugin.fts.a.d.b(AddMoreFriendsUI.this.getContext(), ".ui.FTSAddFriendUI", localIntent, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29196);
        }
      };
      localPreferenceInfoCategory = (PreferenceInfoCategory)this.screen.aXe("find_friends_info");
      localObject = v.aAC();
      String str1 = v.aAD();
      bc.aCg();
      str2 = bb.aSf((String)c.ajA().get(6, null));
      if (bu.isNullOrNil(str1)) {
        break label249;
      }
      localObject = getString(2131759103, new Object[] { str1 });
    }
    for (;;)
    {
      localPreferenceInfoCategory.setTitle((CharSequence)localObject);
      localObject = new AddMoreFriendsUI.4(this);
      localPreferenceInfoCategory.JOF = ((View.OnClickListener)localObject);
      localPreferenceInfoCategory.JOG = ((View.OnClickListener)localObject);
      ((AddFriendItemPreference)this.screen.aXe("find_friends_create_pwdgroup")).yUv = 8;
      com.tencent.mm.cp.d.fWU();
      if (getPreferenceScreen() != null)
      {
        localObject = getPreferenceScreen().aXe("find_friends_by_web");
        if (localObject != null) {
          ((Preference)localObject).setEnabled(true);
        }
      }
      AppMethodBeat.o(29199);
      return;
      this.screen.cT("find_friends_by_web", false);
      break;
      label249:
      if (!an.aUy((String)localObject)) {
        localObject = getString(2131759103, new Object[] { localObject });
      } else if (!bu.isNullOrNil(str2)) {
        localObject = getString(2131759104, new Object[] { bb.aSe(str2) });
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