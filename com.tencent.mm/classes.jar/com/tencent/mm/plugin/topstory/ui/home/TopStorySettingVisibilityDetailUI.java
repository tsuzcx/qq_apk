package com.tencent.mm.plugin.topstory.ui.home;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class TopStorySettingVisibilityDetailUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  protected long Qtd;
  protected String Rya;
  protected ContactListExpandPreference.a Ryc;
  protected Preference TKI;
  protected Preference TKJ;
  protected List<String> TKK;
  protected List<String> TKL;
  private Set<i> TKM;
  protected ContactListExpandPreference lzX;
  protected String md5;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected w tipDialog;
  protected List<String> xtu;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(126003);
    this.xtu = new ArrayList();
    this.TKK = new ArrayList();
    this.TKL = new ArrayList();
    this.Rya = "";
    this.md5 = "";
    this.tipDialog = null;
    this.Ryc = new ContactListExpandPreference.a()
    {
      public final void aMI()
      {
        AppMethodBeat.i(126001);
        if (TopStorySettingVisibilityDetailUI.this.lzX != null) {
          TopStorySettingVisibilityDetailUI.this.lzX.iLt();
        }
        AppMethodBeat.o(126001);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(271760);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.lzX.awu(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.br.c.b(TopStorySettingVisibilityDetailUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(271760);
      }
      
      public final void qw(int paramAnonymousInt)
      {
        AppMethodBeat.i(125998);
        String str = TopStorySettingVisibilityDetailUI.this.lzX.awu(paramAnonymousInt);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        com.tencent.mm.kernel.h.baF();
        if (Util.nullAs((String)com.tencent.mm.kernel.h.baE().ban().d(2, null), "").equals(str))
        {
          k.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(c.g.room_delete_self_tip), "", true);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.Dk(str);
        if (((TopStorySettingVisibilityDetailUI.this.Rya + " " + Util.listToString(TopStorySettingVisibilityDetailUI.this.xtu, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5)) && (TopStorySettingVisibilityDetailUI.this.Qtd != 0L))
        {
          TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(125998);
      }
      
      public final void qx(int paramAnonymousInt)
      {
        AppMethodBeat.i(125999);
        Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(125999);
      }
    };
    this.TKM = new HashSet();
    AppMethodBeat.o(126003);
  }
  
  private void G(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126014);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.h.baF();
      bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
      String str1 = z.bAM();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.xtu.contains(str2)) && (str1 != null) && (!str1.equals(str2)))
        {
          au localau = localbx.JE(str2);
          if ((localau != null) && ((d.rs(localau.field_type)) || (!paramBoolean)))
          {
            this.xtu.add(str2);
            this.TKL.add(str2);
          }
        }
      }
    }
    if (this.lzX != null)
    {
      this.lzX.iM(this.xtu);
      this.lzX.notifyChanged();
    }
    if (this.xtu.size() > 0) {
      this.lzX.JJ(true).JK(true);
    }
    for (;;)
    {
      hNn();
      aMl();
      AppMethodBeat.o(126014);
      return;
      this.lzX.JJ(true).JK(false);
    }
  }
  
  private boolean hNm()
  {
    AppMethodBeat.i(126008);
    if ((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5))
    {
      finish();
      AppMethodBeat.o(126008);
      return true;
    }
    int i = c.g.top_story_setting_cancel;
    if (this.tipDialog != null) {
      i = c.g.top_story_setting_interval;
    }
    k.b(this, getString(i), "", getString(c.g.top_story_setting_not_save), getString(c.g.app_cancel), new DialogInterface.OnClickListener()
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
  
  private void hNn()
  {
    AppMethodBeat.i(126011);
    if (this.TKL.isEmpty())
    {
      this.screen.eh("revert_pref", true);
      AppMethodBeat.o(126011);
      return;
    }
    this.screen.eh("revert_pref", false);
    this.TKJ.setTitle(getString(c.g.top_story_setting_last_add, new Object[] { Integer.valueOf(this.TKL.size()) }));
    AppMethodBeat.o(126011);
  }
  
  protected final void Dk(String paramString)
  {
    AppMethodBeat.i(126012);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(126012);
      return;
    }
    this.xtu.remove(paramString);
    if (this.lzX != null)
    {
      this.lzX.iM(this.xtu);
      this.lzX.notifyChanged();
    }
    if ((this.xtu.size() == 0) && (this.lzX != null))
    {
      this.lzX.iLt();
      this.lzX.JJ(true).JK(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.TKL.clear();
      hNn();
      aMl();
      AppMethodBeat.o(126012);
      return;
      if (this.lzX != null) {
        this.lzX.JJ(true).JK(true);
      }
    }
  }
  
  protected final void aMl()
  {
    AppMethodBeat.i(126010);
    setMMTitle(this.Rya + "(" + this.xtu.size() + ")");
    AppMethodBeat.o(126010);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126009);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      hNm();
      AppMethodBeat.o(126009);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(126009);
    return bool;
  }
  
  protected final void fVt()
  {
    AppMethodBeat.i(126015);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      i = com.tencent.mm.kernel.h.aZW().bFQ();
      if ((i == 4) || (i == 6)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      aa.makeText(this, c.g.top_story_setting_loading_fail, 0).show();
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
    if (((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5)) && (this.Qtd != 0L))
    {
      finish();
      AppMethodBeat.o(126015);
      return;
    }
    Object localObject2;
    if (this.Qtd == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.hMM().TIs.clear();
      com.tencent.mm.plugin.topstory.a.b.a.hMM().TIs.addAll(this.xtu);
      com.tencent.mm.plugin.topstory.a.b.a.hMM().hMO();
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = this.xtu.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label356;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.TKK.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.Qtd == 1L)
        {
          ((List)localObject2).add(Integer.valueOf(3));
          continue;
          com.tencent.mm.plugin.topstory.a.b.a.hMM().Dig.clear();
          com.tencent.mm.plugin.topstory.a.b.a.hMM().Dig.addAll(this.xtu);
          com.tencent.mm.plugin.topstory.a.b.a.hMM().hMN();
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
      }
    }
    label356:
    Object localObject3 = this.TKK.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.xtu.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.Qtd == 1L) {
          ((List)localObject2).add(Integer.valueOf(4));
        } else {
          ((List)localObject2).add(Integer.valueOf(2));
        }
      }
    }
    getString(c.g.app_tip);
    this.tipDialog = k.a(this, getString(c.g.top_story_setting_save), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126002);
        paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.d(TopStorySettingVisibilityDetailUI.this).iterator();
        while (paramAnonymousDialogInterface.hasNext())
        {
          i locali = (i)paramAnonymousDialogInterface.next();
          com.tencent.mm.kernel.h.baD().mCm.a(locali);
        }
        AppMethodBeat.o(126002);
      }
    });
    this.TKM.clear();
    localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      ((List)localObject3).clear();
      ((List)localObject4).clear();
      int j = 0;
      while ((i < ((List)localObject1).size()) && (j < 50))
      {
        ((List)localObject3).add((String)((List)localObject1).get(i));
        ((List)localObject4).add((Integer)((List)localObject2).get(i));
        i += 1;
        j += 1;
      }
      i locali = new i((List)localObject3, (List)localObject4);
      this.TKM.add(locali);
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.TKM.size()) });
    Object localObject1 = this.TKM.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject2, 0);
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
    this.lzX = ((ContactListExpandPreference)this.screen.bAi("roominfo_contact_anchor"));
    if (this.lzX != null)
    {
      this.lzX.a(this.screen, this.lzX.mKey);
      this.lzX.JJ(true).JK(true);
      this.lzX.y(null, this.xtu);
      this.lzX.a(new s.b()
      {
        public final boolean qy(int paramAnonymousInt)
        {
          AppMethodBeat.i(125997);
          if (!TopStorySettingVisibilityDetailUI.this.lzX.awr(paramAnonymousInt)) {
            Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(125997);
          return true;
        }
      });
      this.lzX.a(this.Ryc);
    }
    this.TKI = this.screen.bAi("desc");
    this.TKJ = this.screen.bAi("revert_pref");
    this.screen.eh("revert_pref", true);
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
        TopStorySettingVisibilityDetailUI.this.fVt();
        AppMethodBeat.o(125995);
        return true;
      }
    }, null, y.b.adEJ);
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
    if (Util.nullAsNil(z.bAM()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      k.c(this, getString(c.g.add_room_mem_memberExits), "", true);
      AppMethodBeat.o(126013);
      return;
      if (this.xtu == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.xtu.iterator();
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
        G((List)localObject, false);
      }
      while (((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5)) && (this.Qtd != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(126013);
        return;
        G((List)localObject, true);
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
    paramBundle = com.tencent.mm.pluginsdk.platformtools.a.iIW();
    Object localObject = getIntent().getStringExtra("k_topstory_user_list");
    if (!Util.isNullOrNil((String)localObject))
    {
      this.TKK = Arrays.asList(((String)localObject).split(","));
      localObject = this.TKK.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((!Util.isNullOrNil(str)) && (!paramBundle.contains(str))) {
          this.xtu.add(str);
        }
      }
    }
    initView();
    this.Qtd = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.Qtd == 1L)
    {
      this.Rya = getString(c.g.top_story_setting_unlike);
      this.TKI.setTitle(c.g.top_story_setting_unlike_desc);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aZW().a(2859, this);
      enableOptionMenu(false);
      aMl();
      this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
      AppMethodBeat.o(126005);
      return;
      this.Rya = getString(c.g.top_story_setting_black);
      this.TKI.setTitle(c.g.top_story_setting_black_desc);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126006);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.kernel.h.aZW().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(126006);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(126004);
    if ("revert_pref".equals(paramPreference.mKey)) {
      k.b(this, getString(c.g.top_story_setting_cancel), "", getString(c.g.top_story_setting_not_save), getString(c.g.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125993);
          paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.this.TKL.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            TopStorySettingVisibilityDetailUI.this.xtu.remove(str);
          }
          if (TopStorySettingVisibilityDetailUI.this.lzX != null)
          {
            TopStorySettingVisibilityDetailUI.this.lzX.iM(TopStorySettingVisibilityDetailUI.this.xtu);
            TopStorySettingVisibilityDetailUI.this.lzX.notifyChanged();
          }
          TopStorySettingVisibilityDetailUI.this.TKL.clear();
          TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this);
          TopStorySettingVisibilityDetailUI.this.aMl();
          AppMethodBeat.o(125993);
        }
      }, null);
    }
    AppMethodBeat.o(126004);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(126016);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramp instanceof i))
    {
      paramString = (i)paramp;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label293;
      }
    }
    label293:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        paramInt1 = paramString.hMV().BaseResponse.Idd;
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
        paramString.oQk += 1;
        if (paramString.oQk < 2)
        {
          paramString = new i(paramString);
          com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
          this.TKM.add(paramString);
        }
      }
      if (this.TKM.contains(paramp))
      {
        this.TKM.remove(paramp);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.TKM.size()) });
        if (this.TKM.isEmpty())
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */