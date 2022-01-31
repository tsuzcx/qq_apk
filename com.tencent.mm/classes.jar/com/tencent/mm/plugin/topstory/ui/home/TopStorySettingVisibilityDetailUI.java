package com.tencent.mm.plugin.topstory.ui.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class TopStorySettingVisibilityDetailUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  protected String cqq;
  protected ContactListExpandPreference eeU;
  protected List<String> lbK;
  protected String rWA;
  protected ContactListExpandPreference.a rWC;
  protected long rfr;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected Preference thc;
  protected Preference thd;
  protected List<String> the;
  protected List<String> thf;
  private Set<com.tencent.mm.plugin.topstory.a.c.h> thg;
  protected com.tencent.mm.ui.base.p tipDialog;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(1645);
    this.lbK = new ArrayList();
    this.the = new ArrayList();
    this.thf = new ArrayList();
    this.rWA = "";
    this.cqq = "";
    this.tipDialog = null;
    this.rWC = new TopStorySettingVisibilityDetailUI.6(this);
    this.thg = new HashSet();
    AppMethodBeat.o(1645);
  }
  
  private boolean cIS()
  {
    AppMethodBeat.i(1650);
    if ((this.rWA + " " + bo.d(this.lbK, ",")).equals(this.cqq))
    {
      finish();
      AppMethodBeat.o(1650);
      return true;
    }
    int i = 2131304353;
    if (this.tipDialog != null) {
      i = 2131304355;
    }
    com.tencent.mm.ui.base.h.d(this, getString(i), "", getString(2131304359), getString(2131296888), new TopStorySettingVisibilityDetailUI.4(this), null);
    AppMethodBeat.o(1650);
    return false;
  }
  
  @SuppressLint({"StringFormatMatches"})
  private void cIT()
  {
    AppMethodBeat.i(1654);
    if (this.thf.isEmpty())
    {
      this.screen.cl("revert_pref", true);
      AppMethodBeat.o(1654);
      return;
    }
    this.screen.cl("revert_pref", false);
    this.thd.setTitle(getString(2131304356, new Object[] { Integer.valueOf(this.thf.size()) }));
    AppMethodBeat.o(1654);
  }
  
  private void j(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(1657);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      g.RM();
      bd localbd = ((j)g.E(j.class)).YA();
      String str1 = r.Zn();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.lbK.contains(str2)) && (!str1.equals(str2)) && ((com.tencent.mm.n.a.je(localbd.arw(str2).field_type)) || (!paramBoolean)))
        {
          this.lbK.add(str2);
          this.thf.add(str2);
        }
      }
    }
    if (this.eeU != null)
    {
      this.eeU.cg(this.lbK);
      this.eeU.notifyChanged();
    }
    if (this.lbK.size() > 0) {
      this.eeU.pf(true).pg(true);
    }
    for (;;)
    {
      cIT();
      updateTitle();
      AppMethodBeat.o(1657);
      return;
      this.eeU.pf(true).pg(false);
    }
  }
  
  protected final void bMd()
  {
    AppMethodBeat.i(1658);
    int i;
    if (((com.tencent.mm.kernel.b.h)g.RI().Rj()).SD())
    {
      i = g.Rc().adt();
      if ((i == 4) || (i == 6)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      t.makeText(this, 2131304358, 0).show();
      AppMethodBeat.o(1658);
      return;
      i = 0;
      continue;
      if (at.isConnected(ah.getContext())) {}
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
    if (((this.rWA + " " + bo.d(this.lbK, ",")).equals(this.cqq)) && (this.rfr != 0L))
    {
      finish();
      AppMethodBeat.o(1658);
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.lbK.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.the.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.rfr == 1L) {
          ((List)localObject2).add(Integer.valueOf(3));
        } else {
          ((List)localObject2).add(Integer.valueOf(1));
        }
      }
    }
    localObject3 = this.the.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.lbK.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.rfr == 1L) {
          ((List)localObject2).add(Integer.valueOf(4));
        } else {
          ((List)localObject2).add(Integer.valueOf(2));
        }
      }
    }
    getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131304361), true, new TopStorySettingVisibilityDetailUI.7(this));
    this.thg.clear();
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
      com.tencent.mm.plugin.topstory.a.c.h localh = new com.tencent.mm.plugin.topstory.a.c.h((List)localObject3, (List)localObject4);
      this.thg.add(localh);
    }
    ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.thg.size()) });
    localObject1 = this.thg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.topstory.a.c.h)((Iterator)localObject1).next();
      g.RK().eHt.a((m)localObject2, 0);
    }
    AppMethodBeat.o(1658);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(1651);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      cIS();
      AppMethodBeat.o(1651);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(1651);
    return bool;
  }
  
  public int getResourceId()
  {
    return 2131165307;
  }
  
  public void initView()
  {
    AppMethodBeat.i(1652);
    this.screen = getPreferenceScreen();
    this.eeU = ((ContactListExpandPreference)this.screen.atx("roominfo_contact_anchor"));
    if (this.eeU != null)
    {
      this.eeU.a(this.screen, this.eeU.mKey);
      this.eeU.pf(true).pg(true);
      this.eeU.v(null, this.lbK);
      this.eeU.a(new TopStorySettingVisibilityDetailUI.5(this));
      this.eeU.a(this.rWC);
    }
    this.thc = this.screen.atx("desc");
    this.thd = this.screen.atx("revert_pref");
    this.screen.cl("revert_pref", true);
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new TopStorySettingVisibilityDetailUI.2(this));
    addTextOptionMenu(0, getString(2131296964), new TopStorySettingVisibilityDetailUI.3(this), null, q.b.zby);
    AppMethodBeat.o(1652);
  }
  
  protected final void lc(String paramString)
  {
    AppMethodBeat.i(1655);
    ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(1655);
      return;
    }
    this.lbK.remove(paramString);
    if (this.eeU != null)
    {
      this.eeU.cg(this.lbK);
      this.eeU.notifyChanged();
    }
    if ((this.lbK.size() == 0) && (this.eeU != null))
    {
      this.eeU.dnF();
      this.eeU.pf(true).pg(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.thf.clear();
      cIT();
      updateTitle();
      AppMethodBeat.o(1655);
      return;
      if (this.eeU != null) {
        this.eeU.pf(true).pg(true);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(1656);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(1656);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(1656);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(1656);
      return;
    }
    Object localObject = paramIntent.getStringExtra("Select_Contact");
    if (bo.nullAsNil(r.Zn()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      com.tencent.mm.ui.base.h.b(this, getString(2131296426), "", true);
      AppMethodBeat.o(1656);
      return;
      if (this.lbK == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.lbK.iterator();
        paramInt1 = 0;
        paramInt2 = paramInt1;
        if (localIterator.hasNext())
        {
          if (!((String)localIterator.next()).equals(localObject)) {
            break label316;
          }
          paramInt1 = 1;
        }
      }
    }
    label316:
    for (;;)
    {
      break;
      localObject = bo.P(((String)localObject).split(","));
      if (localObject == null)
      {
        AppMethodBeat.o(1656);
        return;
      }
      paramIntent = paramIntent.getStringExtra("App_MsgId");
      if ((!bo.isNullOrNil(paramIntent)) && (paramIntent.equals("fromSns"))) {
        j((List)localObject, false);
      }
      while (((this.rWA + " " + bo.d(this.lbK, ",")).equals(this.cqq)) && (this.rfr != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(1656);
        return;
        j((List)localObject, true);
      }
      enableOptionMenu(true);
      AppMethodBeat.o(1656);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1647);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("k_topstory_user_list");
    if (!bo.isNullOrNil(paramBundle))
    {
      this.the = Arrays.asList(paramBundle.split(","));
      paramBundle = this.the.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if (!bo.isNullOrNil(str)) {
          this.lbK.add(str);
        }
      }
    }
    initView();
    this.rfr = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.rfr == 1L)
    {
      this.rWA = getString(2131304362);
      this.thc.setTitle(2131304363);
    }
    for (;;)
    {
      g.Rc().a(2859, this);
      enableOptionMenu(false);
      updateTitle();
      this.cqq = (this.rWA + " " + bo.d(this.lbK, ","));
      AppMethodBeat.o(1647);
      return;
      this.rWA = getString(2131304351);
      this.thc.setTitle(2131304352);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(1648);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.Rc().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(1648);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(1646);
    if ("revert_pref".equals(paramPreference.mKey)) {
      com.tencent.mm.ui.base.h.d(this, getString(2131304353), "", getString(2131304359), getString(2131296888), new TopStorySettingVisibilityDetailUI.1(this), null);
    }
    AppMethodBeat.o(1646);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(1659);
    ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    boolean bool;
    if ((paramm instanceof com.tencent.mm.plugin.topstory.a.c.h))
    {
      paramString = (com.tencent.mm.plugin.topstory.a.c.h)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label294;
      }
      bool = true;
      if (!bool) {
        break label300;
      }
      paramInt1 = ((uj)paramString.rr.fsW.fta).BaseResponse.Ret;
      if (paramInt1 == 0) {
        break label300;
      }
      ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", new Object[] { Integer.valueOf(paramInt1) });
      bool = false;
    }
    label294:
    label300:
    for (;;)
    {
      ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramString.fMl += 1;
        if (paramString.fMl < 2)
        {
          paramString = new com.tencent.mm.plugin.topstory.a.c.h(paramString);
          g.RK().eHt.a(paramString, 0);
          this.thg.add(paramString);
        }
      }
      if (this.thg.contains(paramm))
      {
        this.thg.remove(paramm);
        ab.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.thg.size()) });
        if (this.thg.isEmpty())
        {
          if (this.tipDialog != null)
          {
            this.tipDialog.dismiss();
            this.tipDialog = null;
          }
          finish();
        }
      }
      AppMethodBeat.o(1659);
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
    AppMethodBeat.i(1653);
    setMMTitle(this.rWA + "(" + this.lbK.size() + ")");
    AppMethodBeat.o(1653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */