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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
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
  implements com.tencent.mm.al.f
{
  protected String Ajp;
  protected ContactListExpandPreference.a Ajr;
  protected Preference Btj;
  protected Preference Btk;
  protected List<String> Btl;
  protected List<String> Btm;
  private Set<i> Btn;
  protected ContactListExpandPreference fMC;
  protected String md5;
  protected List<String> ppT;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected p tipDialog;
  protected long zid;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(126003);
    this.ppT = new ArrayList();
    this.Btl = new ArrayList();
    this.Btm = new ArrayList();
    this.Ajp = "";
    this.md5 = "";
    this.tipDialog = null;
    this.Ajr = new ContactListExpandPreference.a()
    {
      public final void YJ()
      {
        AppMethodBeat.i(126001);
        if (TopStorySettingVisibilityDetailUI.this.fMC != null) {
          TopStorySettingVisibilityDetailUI.this.fMC.fcH();
        }
        AppMethodBeat.o(126001);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(199593);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.fMC.YX(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.bs.d.b(TopStorySettingVisibilityDetailUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(199593);
      }
      
      public final void lc(int paramAnonymousInt)
      {
        AppMethodBeat.i(125998);
        String str = TopStorySettingVisibilityDetailUI.this.fMC.YX(paramAnonymousInt);
        ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        g.ajD();
        if (bt.bI((String)g.ajC().ajl().get(2, null), "").equals(str))
        {
          com.tencent.mm.ui.base.h.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(2131762613), "", true);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.uZ(str);
        if (((TopStorySettingVisibilityDetailUI.this.Ajp + " " + bt.m(TopStorySettingVisibilityDetailUI.this.ppT, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5)) && (TopStorySettingVisibilityDetailUI.this.zid != 0L))
        {
          TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(125998);
      }
      
      public final void ld(int paramAnonymousInt)
      {
        AppMethodBeat.i(125999);
        ad.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(125999);
      }
    };
    this.Btn = new HashSet();
    AppMethodBeat.o(126003);
  }
  
  private boolean epo()
  {
    AppMethodBeat.i(126008);
    if ((this.Ajp + " " + bt.m(this.ppT, ",")).equals(this.md5))
    {
      finish();
      AppMethodBeat.o(126008);
      return true;
    }
    int i = 2131764493;
    if (this.tipDialog != null) {
      i = 2131764495;
    }
    com.tencent.mm.ui.base.h.e(this, getString(i), "", getString(2131764499), getString(2131755691), new DialogInterface.OnClickListener()
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
  private void epp()
  {
    AppMethodBeat.i(126011);
    if (this.Btm.isEmpty())
    {
      this.screen.cP("revert_pref", true);
      AppMethodBeat.o(126011);
      return;
    }
    this.screen.cP("revert_pref", false);
    this.Btk.setTitle(getString(2131764496, new Object[] { Integer.valueOf(this.Btm.size()) }));
    AppMethodBeat.o(126011);
  }
  
  private void m(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126014);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      g.ajD();
      bp localbp = ((l)g.ab(l.class)).azp();
      String str1 = u.aAm();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.ppT.contains(str2)) && (!str1.equals(str2)) && ((com.tencent.mm.o.b.lM(localbp.Bf(str2).field_type)) || (!paramBoolean)))
        {
          this.ppT.add(str2);
          this.Btm.add(str2);
        }
      }
    }
    if (this.fMC != null)
    {
      this.fMC.eo(this.ppT);
      this.fMC.notifyChanged();
    }
    if (this.ppT.size() > 0) {
      this.fMC.vO(true).vP(true);
    }
    for (;;)
    {
      epp();
      updateTitle();
      AppMethodBeat.o(126014);
      return;
      this.fMC.vO(true).vP(false);
    }
  }
  
  protected final void dgV()
  {
    AppMethodBeat.i(126015);
    int i;
    if (((com.tencent.mm.kernel.b.h)g.ajz().ajb()).akw())
    {
      i = g.aiU().aEN();
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
    if (((this.Ajp + " " + bt.m(this.ppT, ",")).equals(this.md5)) && (this.zid != 0L))
    {
      finish();
      AppMethodBeat.o(126015);
      return;
    }
    Object localObject2;
    if (this.zid == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.eoQ().BqV.clear();
      com.tencent.mm.plugin.topstory.a.b.a.eoQ().BqV.addAll(this.ppT);
      com.tencent.mm.plugin.topstory.a.b.a.eoQ().eoS();
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = this.ppT.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label355;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.Btl.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.zid == 1L)
        {
          ((List)localObject2).add(Integer.valueOf(3));
          continue;
          com.tencent.mm.plugin.topstory.a.b.a.eoQ().AHn.clear();
          com.tencent.mm.plugin.topstory.a.b.a.eoQ().AHn.addAll(this.ppT);
          com.tencent.mm.plugin.topstory.a.b.a.eoQ().eoR();
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
      }
    }
    label355:
    Object localObject3 = this.Btl.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.ppT.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.zid == 1L) {
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
          g.ajB().gAO.a(locali);
        }
        AppMethodBeat.o(126002);
      }
    });
    this.Btn.clear();
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
      this.Btn.add(locali);
    }
    ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.Btn.size()) });
    Object localObject1 = this.Btn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      g.ajB().gAO.a((n)localObject2, 0);
    }
    AppMethodBeat.o(126015);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126009);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      epo();
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
    this.fMC = ((ContactListExpandPreference)this.screen.aVD("roominfo_contact_anchor"));
    if (this.fMC != null)
    {
      this.fMC.a(this.screen, this.fMC.mKey);
      this.fMC.vO(true).vP(true);
      this.fMC.A(null, this.ppT);
      this.fMC.a(new com.tencent.mm.pluginsdk.ui.applet.s.b()
      {
        public final boolean le(int paramAnonymousInt)
        {
          AppMethodBeat.i(125997);
          if (!TopStorySettingVisibilityDetailUI.this.fMC.YU(paramAnonymousInt)) {
            ad.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(125997);
          return true;
        }
      });
      this.fMC.a(this.Ajr);
    }
    this.Btj = this.screen.aVD("desc");
    this.Btk = this.screen.aVD("revert_pref");
    this.screen.cP("revert_pref", true);
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
        TopStorySettingVisibilityDetailUI.this.dgV();
        AppMethodBeat.o(125995);
        return true;
      }
    }, null, com.tencent.mm.ui.s.b.JbS);
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
    ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onActivityResult %s", new Object[] { localObject });
    if (bt.nullAsNil(u.aAm()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), "", true);
      AppMethodBeat.o(126013);
      return;
      if (this.ppT == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.ppT.iterator();
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
      localObject = bt.U(((String)localObject).split(","));
      if (localObject == null)
      {
        AppMethodBeat.o(126013);
        return;
      }
      paramIntent = paramIntent.getStringExtra("App_MsgId");
      if ((!bt.isNullOrNil(paramIntent)) && (paramIntent.equals("fromSns"))) {
        m((List)localObject, false);
      }
      while (((this.Ajp + " " + bt.m(this.ppT, ",")).equals(this.md5)) && (this.zid != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(126013);
        return;
        m((List)localObject, true);
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
      this.Btl = Arrays.asList(paramBundle.split(","));
      paramBundle = this.Btl.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if (!bt.isNullOrNil(str)) {
          this.ppT.add(str);
        }
      }
    }
    initView();
    this.zid = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.zid == 1L)
    {
      this.Ajp = getString(2131764502);
      this.Btj.setTitle(2131764503);
    }
    for (;;)
    {
      g.aiU().a(2859, this);
      enableOptionMenu(false);
      updateTitle();
      this.md5 = (this.Ajp + " " + bt.m(this.ppT, ","));
      AppMethodBeat.o(126005);
      return;
      this.Ajp = getString(2131764491);
      this.Btj.setTitle(2131764492);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126006);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.aiU().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(126006);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(126004);
    if ("revert_pref".equals(paramPreference.mKey)) {
      com.tencent.mm.ui.base.h.e(this, getString(2131764493), "", getString(2131764499), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125993);
          paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.this.Btm.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            TopStorySettingVisibilityDetailUI.this.ppT.remove(str);
          }
          if (TopStorySettingVisibilityDetailUI.this.fMC != null)
          {
            TopStorySettingVisibilityDetailUI.this.fMC.eo(TopStorySettingVisibilityDetailUI.this.ppT);
            TopStorySettingVisibilityDetailUI.this.fMC.notifyChanged();
          }
          TopStorySettingVisibilityDetailUI.this.Btm.clear();
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
      paramInt1 = ((aaa)paramString.rr.hNL.hNQ).BaseResponse.Ret;
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
        paramString.iiN += 1;
        if (paramString.iiN < 2)
        {
          paramString = new i(paramString);
          g.ajB().gAO.a(paramString, 0);
          this.Btn.add(paramString);
        }
      }
      if (this.Btn.contains(paramn))
      {
        this.Btn.remove(paramn);
        ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.Btn.size()) });
        if (this.Btn.isEmpty())
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
  
  protected final void uZ(String paramString)
  {
    AppMethodBeat.i(126012);
    ad.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(126012);
      return;
    }
    this.ppT.remove(paramString);
    if (this.fMC != null)
    {
      this.fMC.eo(this.ppT);
      this.fMC.notifyChanged();
    }
    if ((this.ppT.size() == 0) && (this.fMC != null))
    {
      this.fMC.fcH();
      this.fMC.vO(true).vP(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.Btm.clear();
      epp();
      updateTitle();
      AppMethodBeat.o(126012);
      return;
      if (this.fMC != null) {
        this.fMC.vO(true).vP(true);
      }
    }
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(126010);
    setMMTitle(this.Ajp + "(" + this.ppT.size() + ")");
    AppMethodBeat.o(126010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */