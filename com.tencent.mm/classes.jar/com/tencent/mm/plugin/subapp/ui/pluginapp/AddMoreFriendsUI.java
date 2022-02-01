package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.bc.e;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import java.util.Set;

public class AddMoreFriendsUI
  extends MMPreference
{
  private final int SIt = 4;
  private final int SIu = 9;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getResourceId()
  {
    return R.o.haE;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(292062);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.profile.ui.a.a.class);
    AppMethodBeat.o(292062);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29203);
    setMMTitle(R.l.gpM);
    this.screen = getPreferenceScreen();
    AddFriendItemPreference localAddFriendItemPreference = new AddFriendItemPreference(getContext());
    localAddFriendItemPreference.setKey("find_friends_by_invite");
    localAddFriendItemPreference.setTitle(R.l.gHT);
    localAddFriendItemPreference.setIcon(R.k.addfriend_icon_invite);
    localAddFriendItemPreference.aBk(R.l.gHU);
    if ((Util.getInt(com.tencent.mm.k.i.aRC().getValue("InviteFriendsControlFlags"), 0) & 0x4) > 0) {
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
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29202);
    if ("find_friends_by_qrcode".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      paramf.putExtra("BaseScanUI_select_scan_mode", 1);
      paramf.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      paramf.setFlags(65536);
      paramf.putExtra("key_enable_multi_code", true);
      paramf.putExtra("key_scan_goods_enable_dynamic_wording", true);
      paramf.putExtra("key_enable_scan_code_product_merge", true);
      com.tencent.mm.plugin.report.service.h.OAn.b(11265, new Object[] { Integer.valueOf(1) });
      if ((!com.tencent.mm.n.a.p(this, true)) && (!e.bNA()) && (!com.tencent.mm.n.a.u(getContext(), true))) {
        com.tencent.mm.br.c.b(this, "scanner", ".ui.BaseScanUI", paramf);
      }
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_other_way".equals(paramPreference.mKey))
    {
      if (com.tencent.mm.plugin.account.friend.model.i.bWW() != i.a.pSQ)
      {
        paramf = new Intent(this, BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.aQ(this, paramf);
        AppMethodBeat.o(29202);
        return true;
      }
      paramf = new Intent(this, MobileFriendUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      if (aj.asX(0))
      {
        ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.i.class)).a(MMApplicationContext.getContext(), new AddMoreFriendsUI.1(this));
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
      com.tencent.mm.br.c.ai(this, "radar", ".ui.RadarSearchUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_create_pwdgroup".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11140, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.br.c.ai(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      AppMethodBeat.o(29202);
      return true;
    }
    if ("find_friends_by_invite".equals(paramPreference.mKey))
    {
      int i = getIntent().getIntExtra("invite_friend_scene", 4);
      com.tencent.mm.plugin.report.service.h.OAn.b(14034, new Object[] { Integer.valueOf(i) });
      paramf = new Intent(this, InviteFriendsBy3rdUI.class);
      paramf.putExtra("Invite_friends", i);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        if (!aw.isDarkMode()) {
          paramf = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
      }
      d.b(getContext(), ".ui.FTSAddWw", localIntent, paramf);
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
    boolean bool = aj.aBu();
    Object localObject;
    PreferenceInfoCategory localPreferenceInfoCategory;
    String str2;
    if ((!com.tencent.mm.br.c.blq("brandservice")) || (bool))
    {
      this.screen.eh("find_friends_by_web", true);
      this.screen.notifyDataSetChanged();
      localObject = (AddFriendSearchPreference)this.screen.bAi("find_friends_by_input");
      ((AddFriendSearchPreference)localObject).SIn = getString(R.l.contact_search_account_hint);
      ((AddFriendSearchPreference)localObject).SIp = new AddMoreFriendsUI.3(this);
      localPreferenceInfoCategory = (PreferenceInfoCategory)this.screen.bAi("find_friends_info");
      localObject = z.bAM();
      String str1 = z.bAN();
      bh.bCz();
      str2 = PhoneFormater.pureNumber((String)com.tencent.mm.model.c.ban().d(6, null));
      if (Util.isNullOrNil(str1)) {
        break label272;
      }
      localObject = getString(R.l.gHW, new Object[] { str1 });
    }
    for (;;)
    {
      localPreferenceInfoCategory.setTitle((CharSequence)localObject);
      localPreferenceInfoCategory.aeao = new AddMoreFriendsUI.4(this);
      localObject = new AddMoreFriendsUI.5(this);
      localPreferenceInfoCategory.aeam = ((View.OnClickListener)localObject);
      localPreferenceInfoCategory.aean = ((View.OnClickListener)localObject);
      ((AddFriendItemPreference)this.screen.bAi("find_friends_create_pwdgroup")).MPm = 8;
      com.tencent.mm.xwebutil.c.jQE();
      if (getPreferenceScreen() != null)
      {
        localObject = getPreferenceScreen().bAi("find_friends_by_web");
        if (localObject != null) {
          ((Preference)localObject).setEnabled(true);
        }
      }
      AppMethodBeat.o(29199);
      return;
      this.screen.eh("find_friends_by_web", false);
      break;
      label272:
      if (!au.bxb((String)localObject)) {
        localObject = getString(R.l.gHW, new Object[] { localObject });
      } else if (!Util.isNullOrNil(str2)) {
        localObject = getString(R.l.gHX, new Object[] { PhoneFormater.formatMobileString(str2) });
      } else {
        localObject = getString(R.l.gHY);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */