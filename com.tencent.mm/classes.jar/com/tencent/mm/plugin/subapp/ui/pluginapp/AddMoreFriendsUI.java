package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.bh.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import java.util.Map;

public class AddMoreFriendsUI
  extends MMPreference
{
  private final int FMU = 4;
  private final int FMV = 9;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getResourceId()
  {
    return 2132017153;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29203);
    setMMTitle(2131755166);
    this.screen = getPreferenceScreen();
    AddFriendItemPreference localAddFriendItemPreference = new AddFriendItemPreference(getContext());
    localAddFriendItemPreference.setKey("find_friends_by_invite");
    localAddFriendItemPreference.setTitle(2131759420);
    localAddFriendItemPreference.gr();
    localAddFriendItemPreference.setSummary(2131759421);
    if ((Util.getInt(com.tencent.mm.n.h.aqJ().getValue("InviteFriendsControlFlags"), 0) & 0x4) > 0) {
      this.screen.a(localAddFriendItemPreference, 4);
    }
    hideActionbarLine();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29195);
        AddMoreFriendsUI.this.finish();
        AppMethodBeat.o(29195);
        return true;
      }
    });
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
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29202);
    if ("find_friends_by_qrcode".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      paramf.putExtra("BaseScanUI_select_scan_mode", 1);
      paramf.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      paramf.setFlags(65536);
      com.tencent.mm.plugin.report.service.h.CyF.a(11265, new Object[] { Integer.valueOf(1) });
      if ((!com.tencent.mm.q.a.o(this, true)) && (!e.bgF()) && (!com.tencent.mm.q.a.r(getContext(), true))) {
        com.tencent.mm.br.c.b(this, "scanner", ".ui.BaseScanUI", paramf);
      }
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_other_way".equals(paramPreference.mKey))
    {
      if (l.bnZ() != l.a.keL)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.ay(this, paramf);
        AppMethodBeat.o(29202);
        return true;
      }
      paramf = new Intent(this, MobileFriendUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_web".equals(paramPreference.mKey))
    {
      if (!WeChatBrands.Business.Entries.ContactNewFriendOa.checkAvailable(getContext()))
      {
        AppMethodBeat.o(29202);
        return true;
      }
      if (ai.afs(0))
      {
        ((i)g.af(i.class)).a(MMApplicationContext.getContext(), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29194);
            Intent localIntent = ai.fXX();
            localIntent.putExtra("KRightBtn", true);
            localIntent.putExtra("ftsneedkeyboard", true);
            localIntent.putExtra("key_load_js_without_delay", true);
            localIntent.putExtra("ftsType", 1);
            localIntent.putExtra("ftsbizscene", 9);
            Object localObject = ai.h(9, true, 0);
            String str = ai.afq(Util.safeParseInt((String)((Map)localObject).get("scene")));
            ((Map)localObject).put("sessionId", str);
            ((Map)localObject).put("subSessionId", str);
            localIntent.putExtra("sessionId", str);
            localIntent.putExtra("subSessionId", str);
            localIntent.putExtra("rawUrl", ai.bd((Map)localObject));
            str = null;
            localObject = str;
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject = str;
              if (!com.tencent.mm.ui.ao.isDarkMode()) {
                localObject = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
              }
            }
            com.tencent.mm.br.c.a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
            AppMethodBeat.o(29194);
          }
        });
        paramPreference.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(29202);
        return true;
        Log.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
      }
    }
    if ("find_friends_by_radar".equals(paramPreference.mKey))
    {
      com.tencent.mm.br.c.V(this, "radar", ".ui.RadarSearchUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_create_pwdgroup".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11140, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.br.c.V(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_invite".equals(paramPreference.mKey))
    {
      int i = getIntent().getIntExtra("invite_friend_scene", 4);
      com.tencent.mm.plugin.report.service.h.CyF.a(14034, new Object[] { Integer.valueOf(i) });
      paramf = new Intent(this, InviteFriendsBy3rdUI.class);
      paramf.putExtra("Invite_friends", i);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_ww".equals(paramPreference.mKey))
    {
      if (!WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(getContext()))
      {
        AppMethodBeat.o(29202);
        return true;
      }
      Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
      paramPreference = null;
      paramf = paramPreference;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramf = paramPreference;
        if (!com.tencent.mm.ui.ao.isDarkMode()) {
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
    boolean bool = ((q)g.af(q.class)).Vu();
    Object localObject;
    PreferenceInfoCategory localPreferenceInfoCategory;
    String str2;
    if ((!com.tencent.mm.br.c.aZU("brandservice")) || (!bool))
    {
      this.screen.jdMethod_do("find_friends_by_web", true);
      this.screen.notifyDataSetChanged();
      localObject = (AddFriendSearchPreference)this.screen.bmg("find_friends_by_input");
      ((AddFriendSearchPreference)localObject).FMO = getString(2131758157);
      ((AddFriendSearchPreference)localObject).FMQ = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29196);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
          localb = null;
          paramAnonymousView = localb;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramAnonymousView = localb;
            if (!com.tencent.mm.ui.ao.isDarkMode()) {
              paramAnonymousView = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
            }
          }
          com.tencent.mm.plugin.fts.a.d.b(AddMoreFriendsUI.this.getContext(), ".ui.FTSAddFriendUI", localIntent, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29196);
        }
      };
      localPreferenceInfoCategory = (PreferenceInfoCategory)this.screen.bmg("find_friends_info");
      localObject = z.aTY();
      String str1 = z.aTZ();
      bg.aVF();
      str2 = PhoneFormater.pureNumber((String)com.tencent.mm.model.c.azQ().get(6, null));
      if (Util.isNullOrNil(str1)) {
        break label271;
      }
      localObject = getString(2131759436, new Object[] { str1 });
    }
    for (;;)
    {
      localPreferenceInfoCategory.setTitle((CharSequence)localObject);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29197);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          com.tencent.mm.plugin.report.service.h.CyF.a(11264, new Object[] { Integer.valueOf(1) });
          localObject = new Intent();
          ((Intent)localObject).setClassName(AddMoreFriendsUI.this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
          paramAnonymousView = AddMoreFriendsUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29197);
        }
      };
      localPreferenceInfoCategory.OZL = ((View.OnClickListener)localObject);
      localPreferenceInfoCategory.OZM = ((View.OnClickListener)localObject);
      ((AddFriendItemPreference)this.screen.bmg("find_friends_create_pwdgroup")).CZl = 8;
      com.tencent.mm.cr.d.hiy();
      if (getPreferenceScreen() != null)
      {
        localObject = getPreferenceScreen().bmg("find_friends_by_web");
        if (localObject != null) {
          ((Preference)localObject).setEnabled(true);
        }
      }
      AppMethodBeat.o(29199);
      return;
      this.screen.jdMethod_do("find_friends_by_web", false);
      break;
      label271:
      if (!as.bjx((String)localObject)) {
        localObject = getString(2131759436, new Object[] { localObject });
      } else if (!Util.isNullOrNil(str2)) {
        localObject = getString(2131759437, new Object[] { PhoneFormater.formatMobileString(str2) });
      } else {
        localObject = getString(2131759438);
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
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */