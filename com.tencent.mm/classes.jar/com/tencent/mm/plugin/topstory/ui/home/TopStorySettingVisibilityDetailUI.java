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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class TopStorySettingVisibilityDetailUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  protected ContactListExpandPreference fpW;
  protected String md5;
  protected List<String> oiL;
  protected f screen;
  protected p tipDialog;
  protected long wFP;
  protected String xFb;
  protected ContactListExpandPreference.a xFd;
  protected Preference yNH;
  protected Preference yNI;
  protected List<String> yNJ;
  protected List<String> yNK;
  private Set<i> yNL;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(126003);
    this.oiL = new ArrayList();
    this.yNJ = new ArrayList();
    this.yNK = new ArrayList();
    this.xFb = "";
    this.md5 = "";
    this.tipDialog = null;
    this.xFd = new ContactListExpandPreference.a()
    {
      public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(202278);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.fpW.US(paramAnonymousInt);
        ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + paramAnonymousViewGroup);
        com.tencent.mm.kernel.g.afC();
        if (bt.by((String)com.tencent.mm.kernel.g.afB().afk().get(2, null), "").equals(paramAnonymousViewGroup))
        {
          com.tencent.mm.ui.base.h.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(2131762613), "", true);
          AppMethodBeat.o(202278);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.oY(paramAnonymousViewGroup);
        if (((TopStorySettingVisibilityDetailUI.this.xFb + " " + bt.n(TopStorySettingVisibilityDetailUI.this.oiL, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5)) && (TopStorySettingVisibilityDetailUI.this.wFP != 0L))
        {
          TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(202278);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(202278);
      }
      
      public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(202280);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.fpW.US(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.bs.d.b(TopStorySettingVisibilityDetailUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        AppMethodBeat.o(202280);
      }
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(202279);
        ad.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(202279);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
      {
        AppMethodBeat.i(202281);
        if (TopStorySettingVisibilityDetailUI.this.fpW != null) {
          TopStorySettingVisibilityDetailUI.this.fpW.eyo();
        }
        AppMethodBeat.o(202281);
      }
    };
    this.yNL = new HashSet();
    AppMethodBeat.o(126003);
  }
  
  private boolean dOw()
  {
    AppMethodBeat.i(126008);
    if ((this.xFb + " " + bt.n(this.oiL, ",")).equals(this.md5))
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
  private void dOx()
  {
    AppMethodBeat.i(126011);
    if (this.yNK.isEmpty())
    {
      this.screen.cE("revert_pref", true);
      AppMethodBeat.o(126011);
      return;
    }
    this.screen.cE("revert_pref", false);
    this.yNI.setTitle(getString(2131764496, new Object[] { Integer.valueOf(this.yNK.size()) }));
    AppMethodBeat.o(126011);
  }
  
  private void k(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126014);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.afC();
      bg localbg = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM();
      String str1 = u.aqG();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.oiL.contains(str2)) && (!str1.equals(str2)) && ((com.tencent.mm.n.b.ls(localbg.aHY(str2).field_type)) || (!paramBoolean)))
        {
          this.oiL.add(str2);
          this.yNK.add(str2);
        }
      }
    }
    if (this.fpW != null)
    {
      this.fpW.dX(this.oiL);
      this.fpW.notifyChanged();
    }
    if (this.oiL.size() > 0) {
      this.fpW.ub(true).uc(true);
    }
    for (;;)
    {
      dOx();
      updateTitle();
      AppMethodBeat.o(126014);
      return;
      this.fpW.ub(true).uc(false);
    }
  }
  
  protected final void cKe()
  {
    AppMethodBeat.i(126015);
    int i;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu())
    {
      i = com.tencent.mm.kernel.g.aeS().auR();
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
      if (ay.isConnected(aj.getContext())) {}
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
    if (((this.xFb + " " + bt.n(this.oiL, ",")).equals(this.md5)) && (this.wFP != 0L))
    {
      finish();
      AppMethodBeat.o(126015);
      return;
    }
    Object localObject2;
    if (this.wFP == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLq.clear();
      com.tencent.mm.plugin.topstory.a.b.a.dNZ().yLq.addAll(this.oiL);
      com.tencent.mm.plugin.topstory.a.b.a.dNZ().dOb();
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = this.oiL.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label355;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.yNJ.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.wFP == 1L)
        {
          ((List)localObject2).add(Integer.valueOf(3));
          continue;
          com.tencent.mm.plugin.topstory.a.b.a.dNZ().yct.clear();
          com.tencent.mm.plugin.topstory.a.b.a.dNZ().yct.addAll(this.oiL);
          com.tencent.mm.plugin.topstory.a.b.a.dNZ().dOa();
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
      }
    }
    label355:
    Object localObject3 = this.yNJ.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.oiL.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.wFP == 1L) {
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
          com.tencent.mm.kernel.g.afA().gcy.a(locali);
        }
        AppMethodBeat.o(126002);
      }
    });
    this.yNL.clear();
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
      this.yNL.add(locali);
    }
    ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.yNL.size()) });
    Object localObject1 = this.yNL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      com.tencent.mm.kernel.g.afA().gcy.a((n)localObject2, 0);
    }
    AppMethodBeat.o(126015);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126009);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      dOw();
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
    this.fpW = ((ContactListExpandPreference)this.screen.aKk("roominfo_contact_anchor"));
    if (this.fpW != null)
    {
      this.fpW.a(this.screen, this.fpW.mKey);
      this.fpW.ub(true).uc(true);
      this.fpW.B(null, this.oiL);
      this.fpW.a(new s.b()
      {
        public final boolean kL(int paramAnonymousInt)
        {
          AppMethodBeat.i(125997);
          if (!TopStorySettingVisibilityDetailUI.this.fpW.UP(paramAnonymousInt)) {
            ad.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(125997);
          return true;
        }
      });
      this.fpW.a(this.xFd);
    }
    this.yNH = this.screen.aKk("desc");
    this.yNI = this.screen.aKk("revert_pref");
    this.screen.cE("revert_pref", true);
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
        TopStorySettingVisibilityDetailUI.this.cKe();
        AppMethodBeat.o(125995);
        return true;
      }
    }, null, r.b.FOB);
    AppMethodBeat.o(126007);
  }
  
  protected final void oY(String paramString)
  {
    AppMethodBeat.i(126012);
    ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(126012);
      return;
    }
    this.oiL.remove(paramString);
    if (this.fpW != null)
    {
      this.fpW.dX(this.oiL);
      this.fpW.notifyChanged();
    }
    if ((this.oiL.size() == 0) && (this.fpW != null))
    {
      this.fpW.eyo();
      this.fpW.ub(true).uc(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.yNK.clear();
      dOx();
      updateTitle();
      AppMethodBeat.o(126012);
      return;
      if (this.fpW != null) {
        this.fpW.ub(true).uc(true);
      }
    }
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
    ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onActivityResult %s", new Object[] { localObject });
    if (bt.nullAsNil(u.aqG()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), "", true);
      AppMethodBeat.o(126013);
      return;
      if (this.oiL == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.oiL.iterator();
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
      localObject = bt.S(((String)localObject).split(","));
      if (localObject == null)
      {
        AppMethodBeat.o(126013);
        return;
      }
      paramIntent = paramIntent.getStringExtra("App_MsgId");
      if ((!bt.isNullOrNil(paramIntent)) && (paramIntent.equals("fromSns"))) {
        k((List)localObject, false);
      }
      while (((this.xFb + " " + bt.n(this.oiL, ",")).equals(this.md5)) && (this.wFP != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(126013);
        return;
        k((List)localObject, true);
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
    if (!bt.isNullOrNil(paramBundle))
    {
      this.yNJ = Arrays.asList(paramBundle.split(","));
      paramBundle = this.yNJ.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if (!bt.isNullOrNil(str)) {
          this.oiL.add(str);
        }
      }
    }
    initView();
    this.wFP = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.wFP == 1L)
    {
      this.xFb = getString(2131764502);
      this.yNH.setTitle(2131764503);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aeS().a(2859, this);
      enableOptionMenu(false);
      updateTitle();
      this.md5 = (this.xFb + " " + bt.n(this.oiL, ","));
      AppMethodBeat.o(126005);
      return;
      this.xFb = getString(2131764491);
      this.yNH.setTitle(2131764492);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126006);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.kernel.g.aeS().b(2859, this);
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
          paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.this.yNK.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            TopStorySettingVisibilityDetailUI.this.oiL.remove(str);
          }
          if (TopStorySettingVisibilityDetailUI.this.fpW != null)
          {
            TopStorySettingVisibilityDetailUI.this.fpW.dX(TopStorySettingVisibilityDetailUI.this.oiL);
            TopStorySettingVisibilityDetailUI.this.fpW.notifyChanged();
          }
          TopStorySettingVisibilityDetailUI.this.yNK.clear();
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
    ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
      paramInt1 = ((xj)paramString.rr.gUT.gUX).BaseResponse.Ret;
      if (paramInt1 == 0) {
        break label300;
      }
      ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", new Object[] { Integer.valueOf(paramInt1) });
      bool = false;
    }
    label294:
    label300:
    for (;;)
    {
      ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramString.hoX += 1;
        if (paramString.hoX < 2)
        {
          paramString = new i(paramString);
          com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
          this.yNL.add(paramString);
        }
      }
      if (this.yNL.contains(paramn))
      {
        this.yNL.remove(paramn);
        ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.yNL.size()) });
        if (this.yNL.isEmpty())
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
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(126010);
    setMMTitle(this.xFb + "(" + this.oiL.size() + ")");
    AppMethodBeat.o(126010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */