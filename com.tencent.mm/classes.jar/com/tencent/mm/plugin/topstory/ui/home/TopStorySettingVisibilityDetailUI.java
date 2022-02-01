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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class TopStorySettingVisibilityDetailUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  protected List<String> AbA;
  protected List<String> AbB;
  private Set<i> AbC;
  protected Preference Aby;
  protected Preference Abz;
  protected ContactListExpandPreference ftA;
  protected String md5;
  protected List<String> oMl;
  protected ContactListExpandPreference.a rpz;
  protected f screen;
  protected p tipDialog;
  protected long xSj;
  protected String yRP;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(126003);
    this.oMl = new ArrayList();
    this.AbA = new ArrayList();
    this.AbB = new ArrayList();
    this.yRP = "";
    this.md5 = "";
    this.tipDialog = null;
    this.rpz = new ContactListExpandPreference.a()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(206775);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.ftA.Xb(paramAnonymousInt);
        ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + paramAnonymousViewGroup);
        com.tencent.mm.kernel.g.agS();
        if (bs.bG((String)com.tencent.mm.kernel.g.agR().agA().get(2, null), "").equals(paramAnonymousViewGroup))
        {
          com.tencent.mm.ui.base.h.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(2131762613), "", true);
          AppMethodBeat.o(206775);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.sk(paramAnonymousViewGroup);
        if (((TopStorySettingVisibilityDetailUI.this.yRP + " " + bs.n(TopStorySettingVisibilityDetailUI.this.oMl, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5)) && (TopStorySettingVisibilityDetailUI.this.xSj != 0L))
        {
          TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(206775);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(206775);
      }
      
      public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(206777);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.ftA.Xb(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.br.d.b(TopStorySettingVisibilityDetailUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        AppMethodBeat.o(206777);
      }
      
      public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(206776);
        ac.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(206776);
      }
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
      
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
      {
        AppMethodBeat.i(206778);
        if (TopStorySettingVisibilityDetailUI.this.ftA != null) {
          TopStorySettingVisibilityDetailUI.this.ftA.eNI();
        }
        AppMethodBeat.o(206778);
      }
    };
    this.AbC = new HashSet();
    AppMethodBeat.o(126003);
  }
  
  private boolean cvU()
  {
    AppMethodBeat.i(126008);
    if ((this.yRP + " " + bs.n(this.oMl, ",")).equals(this.md5))
    {
      finish();
      AppMethodBeat.o(126008);
      return true;
    }
    int i = 2131764493;
    if (this.tipDialog != null) {
      i = 2131764495;
    }
    com.tencent.mm.ui.base.h.d(this, getString(i), "", getString(2131764499), getString(2131755691), new DialogInterface.OnClickListener()
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
  private void ecX()
  {
    AppMethodBeat.i(126011);
    if (this.AbB.isEmpty())
    {
      this.screen.cK("revert_pref", true);
      AppMethodBeat.o(126011);
      return;
    }
    this.screen.cK("revert_pref", false);
    this.Abz.setTitle(getString(2131764496, new Object[] { Integer.valueOf(this.AbB.size()) }));
    AppMethodBeat.o(126011);
  }
  
  private void l(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126014);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.agS();
      bj localbj = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB();
      String str1 = u.axw();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.oMl.contains(str2)) && (!str1.equals(str2)) && ((com.tencent.mm.n.b.ln(localbj.aNt(str2).field_type)) || (!paramBoolean)))
        {
          this.oMl.add(str2);
          this.AbB.add(str2);
        }
      }
    }
    if (this.ftA != null)
    {
      this.ftA.eb(this.oMl);
      this.ftA.notifyChanged();
    }
    if (this.oMl.size() > 0) {
      this.ftA.vc(true).vd(true);
    }
    for (;;)
    {
      ecX();
      updateTitle();
      AppMethodBeat.o(126014);
      return;
      this.ftA.vc(true).vd(false);
    }
  }
  
  protected final void cXJ()
  {
    AppMethodBeat.i(126015);
    int i;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      i = com.tencent.mm.kernel.g.agi().aBK();
      if ((i == 4) || (i == 6)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      t.makeText(this, 2131764498, 0).show();
      AppMethodBeat.o(126015);
      return;
      i = 0;
      continue;
      if (ax.isConnected(ai.getContext())) {}
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
    if (((this.yRP + " " + bs.n(this.oMl, ",")).equals(this.md5)) && (this.xSj != 0L))
    {
      finish();
      AppMethodBeat.o(126015);
      return;
    }
    Object localObject2;
    if (this.xSj == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.ecz().zZj.clear();
      com.tencent.mm.plugin.topstory.a.b.a.ecz().zZj.addAll(this.oMl);
      com.tencent.mm.plugin.topstory.a.b.a.ecz().ecB();
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = this.oMl.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label355;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.AbA.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.xSj == 1L)
        {
          ((List)localObject2).add(Integer.valueOf(3));
          continue;
          com.tencent.mm.plugin.topstory.a.b.a.ecz().zpt.clear();
          com.tencent.mm.plugin.topstory.a.b.a.ecz().zpt.addAll(this.oMl);
          com.tencent.mm.plugin.topstory.a.b.a.ecz().ecA();
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
      }
    }
    label355:
    Object localObject3 = this.AbA.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.oMl.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.xSj == 1L) {
          ((List)localObject2).add(Integer.valueOf(4));
        } else {
          ((List)localObject2).add(Integer.valueOf(2));
        }
      }
    }
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131764501), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126002);
        paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.d(TopStorySettingVisibilityDetailUI.this).iterator();
        while (paramAnonymousDialogInterface.hasNext())
        {
          i locali = (i)paramAnonymousDialogInterface.next();
          com.tencent.mm.kernel.g.agQ().ghe.a(locali);
        }
        AppMethodBeat.o(126002);
      }
    });
    this.AbC.clear();
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
      i locali = new i((List)localObject3, (List)localObject4);
      this.AbC.add(locali);
    }
    ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.AbC.size()) });
    Object localObject1 = this.AbC.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject2, 0);
    }
    AppMethodBeat.o(126015);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126009);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      cvU();
      AppMethodBeat.o(126009);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(126009);
    return bool;
  }
  
  public int getResourceId()
  {
    return 2131951751;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126007);
    this.screen = getPreferenceScreen();
    this.ftA = ((ContactListExpandPreference)this.screen.aPN("roominfo_contact_anchor"));
    if (this.ftA != null)
    {
      this.ftA.a(this.screen, this.ftA.mKey);
      this.ftA.vc(true).vd(true);
      this.ftA.y(null, this.oMl);
      this.ftA.a(new com.tencent.mm.pluginsdk.ui.applet.s.b()
      {
        public final boolean kF(int paramAnonymousInt)
        {
          AppMethodBeat.i(125997);
          if (!TopStorySettingVisibilityDetailUI.this.ftA.WY(paramAnonymousInt)) {
            ac.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(125997);
          return true;
        }
      });
      this.ftA.a(this.rpz);
    }
    this.Aby = this.screen.aPN("desc");
    this.Abz = this.screen.aPN("revert_pref");
    this.screen.cK("revert_pref", true);
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
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125995);
        TopStorySettingVisibilityDetailUI.this.cXJ();
        AppMethodBeat.o(125995);
        return true;
      }
    }, null, com.tencent.mm.ui.s.b.Hom);
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
    ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onActivityResult %s", new Object[] { localObject });
    if (bs.nullAsNil(u.axw()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), "", true);
      AppMethodBeat.o(126013);
      return;
      if (this.oMl == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.oMl.iterator();
        paramInt1 = 0;
        paramInt2 = paramInt1;
        if (localIterator.hasNext())
        {
          if (!((String)localIterator.next()).equals(localObject)) {
            break label333;
          }
          paramInt1 = 1;
        }
      }
    }
    label333:
    for (;;)
    {
      break;
      localObject = bs.S(((String)localObject).split(","));
      if (localObject == null)
      {
        AppMethodBeat.o(126013);
        return;
      }
      paramIntent = paramIntent.getStringExtra("App_MsgId");
      if ((!bs.isNullOrNil(paramIntent)) && (paramIntent.equals("fromSns"))) {
        l((List)localObject, false);
      }
      while (((this.yRP + " " + bs.n(this.oMl, ",")).equals(this.md5)) && (this.xSj != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(126013);
        return;
        l((List)localObject, true);
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
    paramBundle = getIntent().getStringExtra("k_topstory_user_list");
    if (!bs.isNullOrNil(paramBundle))
    {
      this.AbA = Arrays.asList(paramBundle.split(","));
      paramBundle = this.AbA.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if (!bs.isNullOrNil(str)) {
          this.oMl.add(str);
        }
      }
    }
    initView();
    this.xSj = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.xSj == 1L)
    {
      this.yRP = getString(2131764502);
      this.Aby.setTitle(2131764503);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agi().a(2859, this);
      enableOptionMenu(false);
      updateTitle();
      this.md5 = (this.yRP + " " + bs.n(this.oMl, ","));
      AppMethodBeat.o(126005);
      return;
      this.yRP = getString(2131764491);
      this.Aby.setTitle(2131764492);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126006);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.kernel.g.agi().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(126006);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(126004);
    if ("revert_pref".equals(paramPreference.mKey)) {
      com.tencent.mm.ui.base.h.d(this, getString(2131764493), "", getString(2131764499), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125993);
          paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.this.AbB.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            TopStorySettingVisibilityDetailUI.this.oMl.remove(str);
          }
          if (TopStorySettingVisibilityDetailUI.this.ftA != null)
          {
            TopStorySettingVisibilityDetailUI.this.ftA.eb(TopStorySettingVisibilityDetailUI.this.oMl);
            TopStorySettingVisibilityDetailUI.this.ftA.notifyChanged();
          }
          TopStorySettingVisibilityDetailUI.this.AbB.clear();
          TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this);
          TopStorySettingVisibilityDetailUI.this.updateTitle();
          AppMethodBeat.o(125993);
        }
      }, null);
    }
    AppMethodBeat.o(126004);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(126016);
    ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    boolean bool;
    if ((paramn instanceof i))
    {
      paramString = (i)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label294;
      }
      bool = true;
      if (!bool) {
        break label300;
      }
      paramInt1 = ((yb)paramString.rr.hvs.hvw).BaseResponse.Ret;
      if (paramInt1 == 0) {
        break label300;
      }
      ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", new Object[] { Integer.valueOf(paramInt1) });
      bool = false;
    }
    label294:
    label300:
    for (;;)
    {
      ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramString.hPz += 1;
        if (paramString.hPz < 2)
        {
          paramString = new i(paramString);
          com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
          this.AbC.add(paramString);
        }
      }
      if (this.AbC.contains(paramn))
      {
        this.AbC.remove(paramn);
        ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.AbC.size()) });
        if (this.AbC.isEmpty())
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
      bool = false;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void sk(String paramString)
  {
    AppMethodBeat.i(126012);
    ac.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(126012);
      return;
    }
    this.oMl.remove(paramString);
    if (this.ftA != null)
    {
      this.ftA.eb(this.oMl);
      this.ftA.notifyChanged();
    }
    if ((this.oMl.size() == 0) && (this.ftA != null))
    {
      this.ftA.eNI();
      this.ftA.vc(true).vd(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.AbB.clear();
      ecX();
      updateTitle();
      AppMethodBeat.o(126012);
      return;
      if (this.ftA != null) {
        this.ftA.vc(true).vd(true);
      }
    }
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(126010);
    setMMTitle(this.yRP + "(" + this.oMl.size() + ")");
    AppMethodBeat.o(126010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */