package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.cl.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.util.Map;

public class AddMoreFriendsUI
  extends MMPreference
{
  private f dnn;
  private final int pxE = 4;
  private final int pxF = 9;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if ("find_friends_by_qrcode".equals(paramPreference.mKey))
    {
      paramf = new Intent();
      paramf.putExtra("BaseScanUI_select_scan_mode", 1);
      paramf.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      paramf.setFlags(65536);
      h.nFQ.f(11265, new Object[] { Integer.valueOf(1) });
      if ((!a.bj(this)) && (!com.tencent.mm.bf.e.RS())) {
        com.tencent.mm.br.d.b(this, "scanner", ".ui.BaseScanUI", paramf);
      }
      return true;
    }
    if ("find_friends_by_other_way".equals(paramPreference.mKey))
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
    if ("find_friends_by_web".equals(paramPreference.mKey))
    {
      if (aa.Br(0))
      {
        ((m)com.tencent.mm.kernel.g.r(m.class)).a(ae.getContext(), new Runnable()
        {
          public final void run()
          {
            Intent localIntent = aa.bZt();
            localIntent.putExtra("KRightBtn", true);
            localIntent.putExtra("ftsneedkeyboard", true);
            localIntent.putExtra("key_load_js_without_delay", true);
            localIntent.putExtra("ftsType", 1);
            localIntent.putExtra("ftsbizscene", 9);
            Object localObject = aa.b(9, true, 0);
            String str = aa.Bm(bk.ZR((String)((Map)localObject).get("scene")));
            ((Map)localObject).put("sessionId", str);
            ((Map)localObject).put("subSessionId", str);
            localIntent.putExtra("sessionId", str);
            localIntent.putExtra("subSessionId", str);
            localIntent.putExtra("rawUrl", aa.v((Map)localObject));
            localObject = null;
            if (Build.VERSION.SDK_INT >= 21) {
              localObject = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
            }
            com.tencent.mm.br.d.a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent, (Bundle)localObject);
          }
        });
        paramPreference.setEnabled(false);
      }
      for (;;)
      {
        return true;
        y.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
      }
    }
    if ("find_friends_by_radar".equals(paramPreference.mKey))
    {
      com.tencent.mm.br.d.x(this, "radar", ".ui.RadarSearchUI");
      return true;
    }
    if ("find_friends_create_pwdgroup".equals(paramPreference.mKey))
    {
      h.nFQ.f(11140, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.br.d.x(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
      return true;
    }
    if ("find_friends_by_invite".equals(paramPreference.mKey))
    {
      int i = getIntent().getIntExtra("invite_friend_scene", 4);
      h.nFQ.f(14034, new Object[] { Integer.valueOf(i) });
      paramf = new Intent(this, InviteFriendsBy3rdUI.class);
      paramf.putExtra("Invite_friends", i);
      startActivity(paramf);
      return true;
    }
    if ("find_friends_by_ww".equals(paramPreference.mKey))
    {
      paramPreference = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
      paramf = null;
      if (Build.VERSION.SDK_INT >= 21) {
        paramf = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
      }
      com.tencent.mm.plugin.fts.a.d.b(this.mController.uMN, ".ui.FTSAddWw", paramPreference, paramf);
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
    AddFriendItemPreference localAddFriendItemPreference = new AddFriendItemPreference(this.mController.uMN);
    localAddFriendItemPreference.setKey("find_friends_by_invite");
    localAddFriendItemPreference.setTitle(R.l.find_friends_by_invite_friend);
    int i = R.k.addfriend_icon_invite;
    localAddFriendItemPreference.Ub = i;
    Drawable localDrawable = localAddFriendItemPreference.mContext.getResources().getDrawable(i);
    if (((localDrawable == null) && (localAddFriendItemPreference.kc != null)) || ((localDrawable != null) && (localAddFriendItemPreference.kc != localDrawable)))
    {
      localAddFriendItemPreference.kc = localDrawable;
      localAddFriendItemPreference.notifyChanged();
    }
    localAddFriendItemPreference.setSummary(R.l.find_friends_by_invite_friend_summary);
    if ((bk.getInt(com.tencent.mm.m.g.AA().getValue("InviteFriendsControlFlags"), 0) & 0x4) > 0) {
      this.dnn.a(localAddFriendItemPreference, 4);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AddMoreFriendsUI.this.finish();
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject;
    PreferenceInfoCategory localPreferenceInfoCategory;
    String str2;
    if (!com.tencent.mm.br.d.SP("brandservice"))
    {
      this.dnn.bJ("find_friends_by_web", true);
      this.dnn.notifyDataSetChanged();
      localObject = (AddFriendSearchPreference)this.dnn.add("find_friends_by_input");
      ((AddFriendSearchPreference)localObject).pxw = getString(R.l.contact_search_account_hint);
      ((AddFriendSearchPreference)localObject).pxy = new AddMoreFriendsUI.3(this);
      localPreferenceInfoCategory = (PreferenceInfoCategory)this.dnn.add("find_friends_info");
      localObject = q.Gj();
      String str1 = q.Gk();
      au.Hx();
      str2 = ar.Zt((String)c.Dz().get(6, null));
      if (bk.bl(str1)) {
        break label241;
      }
      localObject = getString(R.l.find_friends_my_account, new Object[] { str1 });
    }
    for (;;)
    {
      localPreferenceInfoCategory.setTitle((CharSequence)localObject);
      localPreferenceInfoCategory.uHe = R.g.info_qr_code;
      localObject = new AddMoreFriendsUI.4(this);
      localPreferenceInfoCategory.vdT = ((View.OnClickListener)localObject);
      localPreferenceInfoCategory.vdU = ((View.OnClickListener)localObject);
      ((AddFriendItemPreference)this.dnn.add("find_friends_create_pwdgroup")).nSi = 8;
      b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      if (this.vdd != null)
      {
        localObject = this.vdd.add("find_friends_by_web");
        if (localObject != null) {
          ((Preference)localObject).setEnabled(true);
        }
      }
      return;
      this.dnn.bJ("find_friends_by_web", false);
      break;
      label241:
      if (!ad.aaX((String)localObject)) {
        localObject = getString(R.l.find_friends_my_account, new Object[] { localObject });
      } else if (!bk.bl(str2)) {
        localObject = getString(R.l.find_friends_my_mobile, new Object[] { ar.Zs(str2) });
      } else {
        localObject = getString(R.l.find_friends_my_qrcode);
      }
    }
  }
  
  public final int xj()
  {
    return R.o.add_more_friends;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */