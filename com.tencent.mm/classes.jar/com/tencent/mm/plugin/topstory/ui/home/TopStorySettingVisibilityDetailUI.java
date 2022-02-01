package com.tencent.mm.plugin.topstory.ui.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class TopStorySettingVisibilityDetailUI
  extends MMPreference
  implements com.tencent.mm.an.i
{
  protected long JWc;
  protected String KXZ;
  protected ContactListExpandPreference.a KYb;
  protected Preference MYa;
  protected Preference MYb;
  protected List<String> MYc;
  protected List<String> MYd;
  private Set<com.tencent.mm.plugin.topstory.a.c.i> MYe;
  protected ContactListExpandPreference iYf;
  protected String md5;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected s tipDialog;
  protected List<String> unc;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(126003);
    this.unc = new ArrayList();
    this.MYc = new ArrayList();
    this.MYd = new ArrayList();
    this.KXZ = "";
    this.md5 = "";
    this.tipDialog = null;
    this.KYb = new ContactListExpandPreference.a()
    {
      public final void asG()
      {
        AppMethodBeat.i(126001);
        if (TopStorySettingVisibilityDetailUI.this.iYf != null) {
          TopStorySettingVisibilityDetailUI.this.iYf.hkC();
        }
        AppMethodBeat.o(126001);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(204833);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.iYf.aqq(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.by.c.b(TopStorySettingVisibilityDetailUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(204833);
      }
      
      public final void qv(int paramAnonymousInt)
      {
        AppMethodBeat.i(125998);
        String str = TopStorySettingVisibilityDetailUI.this.iYf.aqq(paramAnonymousInt);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        com.tencent.mm.kernel.h.aHH();
        if (Util.nullAs((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null), "").equals(str))
        {
          com.tencent.mm.ui.base.h.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(c.g.room_delete_self_tip), "", true);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.KE(str);
        if (((TopStorySettingVisibilityDetailUI.this.KXZ + " " + Util.listToString(TopStorySettingVisibilityDetailUI.this.unc, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5)) && (TopStorySettingVisibilityDetailUI.this.JWc != 0L))
        {
          TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(125998);
      }
      
      public final void qw(int paramAnonymousInt)
      {
        AppMethodBeat.i(125999);
        Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(125999);
      }
    };
    this.MYe = new HashSet();
    AppMethodBeat.o(126003);
  }
  
  private boolean gqp()
  {
    AppMethodBeat.i(126008);
    if ((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5))
    {
      finish();
      AppMethodBeat.o(126008);
      return true;
    }
    int i = c.g.top_story_setting_cancel;
    if (this.tipDialog != null) {
      i = c.g.top_story_setting_interval;
    }
    com.tencent.mm.ui.base.h.c(this, getString(i), "", getString(c.g.top_story_setting_not_save), getString(c.g.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(125996);
        TopStorySettingVisibilityDetailUI.this.finish();
        AppMethodBeat.o(125996);
      }
    }, null);
    AppMethodBeat.o(126008);
    return false;
  }
  
  @SuppressLint({"StringFormatMatches"})
  private void gqq()
  {
    AppMethodBeat.i(126011);
    if (this.MYd.isEmpty())
    {
      this.screen.dz("revert_pref", true);
      AppMethodBeat.o(126011);
      return;
    }
    this.screen.dz("revert_pref", false);
    this.MYb.setTitle(getString(c.g.top_story_setting_last_add, new Object[] { Integer.valueOf(this.MYd.size()) }));
    AppMethodBeat.o(126011);
  }
  
  private void s(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126014);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.h.aHH();
      bv localbv = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
      String str1 = z.bcZ();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.unc.contains(str2)) && (!str1.equals(str2)) && ((d.rk(localbv.RG(str2).field_type)) || (!paramBoolean)))
        {
          this.unc.add(str2);
          this.MYd.add(str2);
        }
      }
    }
    if (this.iYf != null)
    {
      this.iYf.fO(this.unc);
      this.iYf.notifyChanged();
    }
    if (this.unc.size() > 0) {
      this.iYf.DZ(true).Ea(true);
    }
    for (;;)
    {
      gqq();
      updateTitle();
      AppMethodBeat.o(126014);
      return;
      this.iYf.DZ(true).Ea(false);
    }
  }
  
  protected final void KE(String paramString)
  {
    AppMethodBeat.i(126012);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(126012);
      return;
    }
    this.unc.remove(paramString);
    if (this.iYf != null)
    {
      this.iYf.fO(this.unc);
      this.iYf.notifyChanged();
    }
    if ((this.unc.size() == 0) && (this.iYf != null))
    {
      this.iYf.hkC();
      this.iYf.DZ(true).Ea(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.MYd.clear();
      gqq();
      updateTitle();
      AppMethodBeat.o(126012);
      return;
      if (this.iYf != null) {
        this.iYf.DZ(true).Ea(true);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126009);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      gqp();
      AppMethodBeat.o(126009);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(126009);
    return bool;
  }
  
  protected final void eNa()
  {
    AppMethodBeat.i(126015);
    int i;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      i = com.tencent.mm.kernel.h.aGY().bih();
      if ((i == 4) || (i == 6)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      w.makeText(this, c.g.top_story_setting_loading_fail, 0).show();
      AppMethodBeat.o(126015);
      return;
      i = 0;
      continue;
      if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
      for (i = 6;; i = 0)
      {
        if (i != 6) {
          break label96;
        }
        i = 1;
        break;
      }
      label96:
      i = 0;
    }
    if (((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5)) && (this.JWc != 0L))
    {
      finish();
      AppMethodBeat.o(126015);
      return;
    }
    Object localObject2;
    if (this.JWc == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVO.clear();
      com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVO.addAll(this.unc);
      com.tencent.mm.plugin.topstory.a.b.a.gpQ().gpS();
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = this.unc.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label355;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.MYc.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.JWc == 1L)
        {
          ((List)localObject2).add(Integer.valueOf(3));
          continue;
          com.tencent.mm.plugin.topstory.a.b.a.gpQ().Lyy.clear();
          com.tencent.mm.plugin.topstory.a.b.a.gpQ().Lyy.addAll(this.unc);
          com.tencent.mm.plugin.topstory.a.b.a.gpQ().gpR();
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
      }
    }
    label355:
    Object localObject3 = this.MYc.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.unc.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.JWc == 1L) {
          ((List)localObject2).add(Integer.valueOf(4));
        } else {
          ((List)localObject2).add(Integer.valueOf(2));
        }
      }
    }
    getString(c.g.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(c.g.top_story_setting_save), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126002);
        paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.d(TopStorySettingVisibilityDetailUI.this).iterator();
        while (paramAnonymousDialogInterface.hasNext())
        {
          com.tencent.mm.plugin.topstory.a.c.i locali = (com.tencent.mm.plugin.topstory.a.c.i)paramAnonymousDialogInterface.next();
          com.tencent.mm.kernel.h.aHF().kcd.a(locali);
        }
        AppMethodBeat.o(126002);
      }
    });
    this.MYe.clear();
    localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    int j = 0;
    while (j < ((List)localObject1).size())
    {
      ((List)localObject3).clear();
      ((List)localObject4).clear();
      i = 0;
      while ((j < ((List)localObject1).size()) && (i < 50))
      {
        ((List)localObject3).add(((List)localObject1).get(j));
        ((List)localObject4).add(((List)localObject2).get(j));
        j += 1;
        i += 1;
      }
      com.tencent.mm.plugin.topstory.a.c.i locali = new com.tencent.mm.plugin.topstory.a.c.i((List)localObject3, (List)localObject4);
      this.MYe.add(locali);
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.MYe.size()) });
    Object localObject1 = this.MYe.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.topstory.a.c.i)((Iterator)localObject1).next();
      com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject2, 0);
    }
    AppMethodBeat.o(126015);
  }
  
  public int getResourceId()
  {
    return c.i.topstory_setting_visibility;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126007);
    this.screen = getPreferenceScreen();
    this.iYf = ((ContactListExpandPreference)this.screen.byG("roominfo_contact_anchor"));
    if (this.iYf != null)
    {
      this.iYf.a(this.screen, this.iYf.mKey);
      this.iYf.DZ(true).Ea(true);
      this.iYf.s(null, this.unc);
      this.iYf.a(new s.b()
      {
        public final boolean qx(int paramAnonymousInt)
        {
          AppMethodBeat.i(125997);
          if (!TopStorySettingVisibilityDetailUI.this.iYf.aqn(paramAnonymousInt)) {
            Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(125997);
          return true;
        }
      });
      this.iYf.a(this.KYb);
    }
    this.MYa = this.screen.byG("desc");
    this.MYb = this.screen.byG("revert_pref");
    this.screen.dz("revert_pref", true);
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125994);
        TopStorySettingVisibilityDetailUI.b(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(125994);
        return true;
      }
    });
    addTextOptionMenu(0, getString(c.g.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125995);
        TopStorySettingVisibilityDetailUI.this.eNa();
        AppMethodBeat.o(125995);
        return true;
      }
    }, null, w.b.Wao);
    AppMethodBeat.o(126007);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126013);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(126013);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(126013);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(126013);
      return;
    }
    Object localObject = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onActivityResult %s", new Object[] { localObject });
    if (Util.nullAsNil(z.bcZ()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      com.tencent.mm.ui.base.h.c(this, getString(c.g.add_room_mem_memberExits), "", true);
      AppMethodBeat.o(126013);
      return;
      if (this.unc == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.unc.iterator();
        paramInt1 = 0;
        paramInt2 = paramInt1;
        if (localIterator.hasNext())
        {
          if (!((String)localIterator.next()).equals(localObject)) {
            break label334;
          }
          paramInt1 = 1;
        }
      }
    }
    label334:
    for (;;)
    {
      break;
      localObject = Util.stringsToList(((String)localObject).split(","));
      if (localObject == null)
      {
        AppMethodBeat.o(126013);
        return;
      }
      paramIntent = paramIntent.getStringExtra("App_MsgId");
      if ((!Util.isNullOrNil(paramIntent)) && (paramIntent.equals("fromSns"))) {
        s((List)localObject, false);
      }
      while (((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5)) && (this.JWc != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(126013);
        return;
        s((List)localObject, true);
      }
      enableOptionMenu(true);
      AppMethodBeat.o(126013);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126005);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.pluginsdk.j.a.hhV();
    Object localObject = getIntent().getStringExtra("k_topstory_user_list");
    if (!Util.isNullOrNil((String)localObject))
    {
      this.MYc = Arrays.asList(((String)localObject).split(","));
      localObject = this.MYc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((!Util.isNullOrNil(str)) && (!paramBundle.contains(str))) {
          this.unc.add(str);
        }
      }
    }
    initView();
    this.JWc = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.JWc == 1L)
    {
      this.KXZ = getString(c.g.top_story_setting_unlike);
      this.MYa.setTitle(c.g.top_story_setting_unlike_desc);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aGY().a(2859, this);
      enableOptionMenu(false);
      updateTitle();
      this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
      AppMethodBeat.o(126005);
      return;
      this.KXZ = getString(c.g.top_story_setting_black);
      this.MYa.setTitle(c.g.top_story_setting_black_desc);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126006);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.kernel.h.aGY().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(126006);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(126004);
    if ("revert_pref".equals(paramPreference.mKey)) {
      com.tencent.mm.ui.base.h.c(this, getString(c.g.top_story_setting_cancel), "", getString(c.g.top_story_setting_not_save), getString(c.g.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125993);
          paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.this.MYd.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            TopStorySettingVisibilityDetailUI.this.unc.remove(str);
          }
          if (TopStorySettingVisibilityDetailUI.this.iYf != null)
          {
            TopStorySettingVisibilityDetailUI.this.iYf.fO(TopStorySettingVisibilityDetailUI.this.unc);
            TopStorySettingVisibilityDetailUI.this.iYf.notifyChanged();
          }
          TopStorySettingVisibilityDetailUI.this.MYd.clear();
          TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this);
          TopStorySettingVisibilityDetailUI.this.updateTitle();
          AppMethodBeat.o(125993);
        }
      }, null);
    }
    AppMethodBeat.o(126004);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(126016);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramq instanceof com.tencent.mm.plugin.topstory.a.c.i))
    {
      paramString = (com.tencent.mm.plugin.topstory.a.c.i)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label297;
      }
    }
    label297:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        paramInt1 = paramString.gpZ().BaseResponse.CqV;
        bool2 = bool1;
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", new Object[] { Integer.valueOf(paramInt1) });
          bool2 = false;
        }
      }
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", new Object[] { Boolean.valueOf(bool2) });
      if (!bool2)
      {
        paramString.lXi += 1;
        if (paramString.lXi < 2)
        {
          paramString = new com.tencent.mm.plugin.topstory.a.c.i(paramString);
          com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
          this.MYe.add(paramString);
        }
      }
      if (this.MYe.contains(paramq))
      {
        this.MYe.remove(paramq);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.MYe.size()) });
        if (this.MYe.isEmpty())
        {
          if (this.tipDialog != null)
          {
            this.tipDialog.dismiss();
            this.tipDialog = null;
          }
          finish();
        }
      }
      AppMethodBeat.o(126016);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(126010);
    setMMTitle(this.KXZ + "(" + this.unc.size() + ")");
    AppMethodBeat.o(126010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */