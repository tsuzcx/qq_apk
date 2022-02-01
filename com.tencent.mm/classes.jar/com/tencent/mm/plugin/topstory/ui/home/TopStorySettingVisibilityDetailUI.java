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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bq;
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
  implements com.tencent.mm.ak.f
{
  protected String AAA;
  protected ContactListExpandPreference.a AAD;
  protected Preference BKH;
  protected Preference BKI;
  protected List<String> BKJ;
  protected List<String> BKK;
  private Set<i> BKL;
  protected ContactListExpandPreference fOK;
  protected String md5;
  protected List<String> pwz;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected p tipDialog;
  protected long zyS;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(126003);
    this.pwz = new ArrayList();
    this.BKJ = new ArrayList();
    this.BKK = new ArrayList();
    this.AAA = "";
    this.md5 = "";
    this.tipDialog = null;
    this.AAD = new ContactListExpandPreference.a()
    {
      public final void YS()
      {
        AppMethodBeat.i(126001);
        if (TopStorySettingVisibilityDetailUI.this.fOK != null) {
          TopStorySettingVisibilityDetailUI.this.fOK.fgv();
        }
        AppMethodBeat.o(126001);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(220237);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.fOK.ZD(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.br.d.b(TopStorySettingVisibilityDetailUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(220237);
      }
      
      public final void le(int paramAnonymousInt)
      {
        AppMethodBeat.i(125998);
        String str = TopStorySettingVisibilityDetailUI.this.fOK.ZD(paramAnonymousInt);
        ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        g.ajS();
        if (bu.bI((String)g.ajR().ajA().get(2, null), "").equals(str))
        {
          com.tencent.mm.ui.base.h.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(2131762613), "", true);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.vv(str);
        if (((TopStorySettingVisibilityDetailUI.this.AAA + " " + bu.m(TopStorySettingVisibilityDetailUI.this.pwz, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5)) && (TopStorySettingVisibilityDetailUI.this.zyS != 0L))
        {
          TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(125998);
      }
      
      public final void lf(int paramAnonymousInt)
      {
        AppMethodBeat.i(125999);
        ae.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(125999);
      }
    };
    this.BKL = new HashSet();
    AppMethodBeat.o(126003);
  }
  
  private boolean esV()
  {
    AppMethodBeat.i(126008);
    if ((this.AAA + " " + bu.m(this.pwz, ",")).equals(this.md5))
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
  private void esW()
  {
    AppMethodBeat.i(126011);
    if (this.BKK.isEmpty())
    {
      this.screen.cT("revert_pref", true);
      AppMethodBeat.o(126011);
      return;
    }
    this.screen.cT("revert_pref", false);
    this.BKI.setTitle(getString(2131764496, new Object[] { Integer.valueOf(this.BKK.size()) }));
    AppMethodBeat.o(126011);
  }
  
  private void m(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126014);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      g.ajS();
      bq localbq = ((l)g.ab(l.class)).azF();
      String str1 = v.aAC();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.pwz.contains(str2)) && (!str1.equals(str2)) && ((c.lO(localbq.BH(str2).field_type)) || (!paramBoolean)))
        {
          this.pwz.add(str2);
          this.BKK.add(str2);
        }
      }
    }
    if (this.fOK != null)
    {
      this.fOK.es(this.pwz);
      this.fOK.notifyChanged();
    }
    if (this.pwz.size() > 0) {
      this.fOK.vW(true).vX(true);
    }
    for (;;)
    {
      esW();
      updateTitle();
      AppMethodBeat.o(126014);
      return;
      this.fOK.vW(true).vX(false);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126009);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      esV();
      AppMethodBeat.o(126009);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(126009);
    return bool;
  }
  
  protected final void djU()
  {
    AppMethodBeat.i(126015);
    int i;
    if (((com.tencent.mm.kernel.b.h)g.ajO().ajq()).akL())
    {
      i = g.ajj().aFd();
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
      if (az.isConnected(ak.getContext())) {}
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
    if (((this.AAA + " " + bu.m(this.pwz, ",")).equals(this.md5)) && (this.zyS != 0L))
    {
      finish();
      AppMethodBeat.o(126015);
      return;
    }
    Object localObject2;
    if (this.zyS == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.esx().BIu.clear();
      com.tencent.mm.plugin.topstory.a.b.a.esx().BIu.addAll(this.pwz);
      com.tencent.mm.plugin.topstory.a.b.a.esx().esz();
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = this.pwz.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label355;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.BKJ.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.zyS == 1L)
        {
          ((List)localObject2).add(Integer.valueOf(3));
          continue;
          com.tencent.mm.plugin.topstory.a.b.a.esx().AYQ.clear();
          com.tencent.mm.plugin.topstory.a.b.a.esx().AYQ.addAll(this.pwz);
          com.tencent.mm.plugin.topstory.a.b.a.esx().esy();
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
      }
    }
    label355:
    Object localObject3 = this.BKJ.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.pwz.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.zyS == 1L) {
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
          g.ajQ().gDv.a(locali);
        }
        AppMethodBeat.o(126002);
      }
    });
    this.BKL.clear();
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
      this.BKL.add(locali);
    }
    ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.BKL.size()) });
    Object localObject1 = this.BKL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      g.ajQ().gDv.a((n)localObject2, 0);
    }
    AppMethodBeat.o(126015);
  }
  
  public int getResourceId()
  {
    return 2131951751;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126007);
    this.screen = getPreferenceScreen();
    this.fOK = ((ContactListExpandPreference)this.screen.aXe("roominfo_contact_anchor"));
    if (this.fOK != null)
    {
      this.fOK.a(this.screen, this.fOK.mKey);
      this.fOK.vW(true).vX(true);
      this.fOK.B(null, this.pwz);
      this.fOK.a(new com.tencent.mm.pluginsdk.ui.applet.s.b()
      {
        public final boolean lg(int paramAnonymousInt)
        {
          AppMethodBeat.i(125997);
          if (!TopStorySettingVisibilityDetailUI.this.fOK.ZA(paramAnonymousInt)) {
            ae.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(125997);
          return true;
        }
      });
      this.fOK.a(this.AAD);
    }
    this.BKH = this.screen.aXe("desc");
    this.BKI = this.screen.aXe("revert_pref");
    this.screen.cT("revert_pref", true);
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
        TopStorySettingVisibilityDetailUI.this.djU();
        AppMethodBeat.o(125995);
        return true;
      }
    }, null, com.tencent.mm.ui.s.b.JwA);
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
    ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onActivityResult %s", new Object[] { localObject });
    if (bu.nullAsNil(v.aAC()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), "", true);
      AppMethodBeat.o(126013);
      return;
      if (this.pwz == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.pwz.iterator();
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
      localObject = bu.U(((String)localObject).split(","));
      if (localObject == null)
      {
        AppMethodBeat.o(126013);
        return;
      }
      paramIntent = paramIntent.getStringExtra("App_MsgId");
      if ((!bu.isNullOrNil(paramIntent)) && (paramIntent.equals("fromSns"))) {
        m((List)localObject, false);
      }
      while (((this.AAA + " " + bu.m(this.pwz, ",")).equals(this.md5)) && (this.zyS != 0L))
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
    if (!bu.isNullOrNil(paramBundle))
    {
      this.BKJ = Arrays.asList(paramBundle.split(","));
      paramBundle = this.BKJ.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if (!bu.isNullOrNil(str)) {
          this.pwz.add(str);
        }
      }
    }
    initView();
    this.zyS = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.zyS == 1L)
    {
      this.AAA = getString(2131764502);
      this.BKH.setTitle(2131764503);
    }
    for (;;)
    {
      g.ajj().a(2859, this);
      enableOptionMenu(false);
      updateTitle();
      this.md5 = (this.AAA + " " + bu.m(this.pwz, ","));
      AppMethodBeat.o(126005);
      return;
      this.AAA = getString(2131764491);
      this.BKH.setTitle(2131764492);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126006);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.ajj().b(2859, this);
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
          paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.this.BKK.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            TopStorySettingVisibilityDetailUI.this.pwz.remove(str);
          }
          if (TopStorySettingVisibilityDetailUI.this.fOK != null)
          {
            TopStorySettingVisibilityDetailUI.this.fOK.es(TopStorySettingVisibilityDetailUI.this.pwz);
            TopStorySettingVisibilityDetailUI.this.fOK.notifyChanged();
          }
          TopStorySettingVisibilityDetailUI.this.BKK.clear();
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
    ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
      paramInt1 = ((aad)paramString.rr.hQE.hQJ).BaseResponse.Ret;
      if (paramInt1 == 0) {
        break label300;
      }
      ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", new Object[] { Integer.valueOf(paramInt1) });
      bool = false;
    }
    label294:
    label300:
    for (;;)
    {
      ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramString.ilG += 1;
        if (paramString.ilG < 2)
        {
          paramString = new i(paramString);
          g.ajQ().gDv.a(paramString, 0);
          this.BKL.add(paramString);
        }
      }
      if (this.BKL.contains(paramn))
      {
        this.BKL.remove(paramn);
        ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.BKL.size()) });
        if (this.BKL.isEmpty())
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
    setMMTitle(this.AAA + "(" + this.pwz.size() + ")");
    AppMethodBeat.o(126010);
  }
  
  protected final void vv(String paramString)
  {
    AppMethodBeat.i(126012);
    ae.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(126012);
      return;
    }
    this.pwz.remove(paramString);
    if (this.fOK != null)
    {
      this.fOK.es(this.pwz);
      this.fOK.notifyChanged();
    }
    if ((this.pwz.size() == 0) && (this.fOK != null))
    {
      this.fOK.fgv();
      this.fOK.vW(true).vX(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.BKK.clear();
      esW();
      updateTitle();
      AppMethodBeat.o(126012);
      return;
      if (this.fOK != null) {
        this.fOK.vW(true).vX(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */