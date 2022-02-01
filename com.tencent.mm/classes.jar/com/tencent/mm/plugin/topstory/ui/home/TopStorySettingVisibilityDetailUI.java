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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class TopStorySettingVisibilityDetailUI
  extends MMPreference
  implements com.tencent.mm.ak.i
{
  protected long DJc;
  protected String EJW;
  protected ContactListExpandPreference.a EJY;
  protected Preference Gln;
  protected Preference Glo;
  protected List<String> Glp;
  protected List<String> Glq;
  private Set<com.tencent.mm.plugin.topstory.a.c.i> Glr;
  protected ContactListExpandPreference gtU;
  protected String md5;
  protected List<String> qLQ;
  protected f screen;
  protected com.tencent.mm.ui.base.q tipDialog;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(126003);
    this.qLQ = new ArrayList();
    this.Glp = new ArrayList();
    this.Glq = new ArrayList();
    this.EJW = "";
    this.md5 = "";
    this.tipDialog = null;
    this.EJY = new ContactListExpandPreference.a()
    {
      public final void amF()
      {
        AppMethodBeat.i(126001);
        if (TopStorySettingVisibilityDetailUI.this.gtU != null) {
          TopStorySettingVisibilityDetailUI.this.gtU.gpE();
        }
        AppMethodBeat.o(126001);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(236388);
        paramAnonymousViewGroup = TopStorySettingVisibilityDetailUI.this.gtU.aio(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.br.c.b(TopStorySettingVisibilityDetailUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(236388);
      }
      
      public final void og(int paramAnonymousInt)
      {
        AppMethodBeat.i(125998);
        String str = TopStorySettingVisibilityDetailUI.this.gtU.aio(paramAnonymousInt);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        g.aAi();
        if (Util.nullAs((String)g.aAh().azQ().get(2, null), "").equals(str))
        {
          com.tencent.mm.ui.base.h.c(TopStorySettingVisibilityDetailUI.this.getContext(), TopStorySettingVisibilityDetailUI.this.getString(2131764695), "", true);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.DM(str);
        if (((TopStorySettingVisibilityDetailUI.this.EJW + " " + Util.listToString(TopStorySettingVisibilityDetailUI.this.qLQ, ",")).equals(TopStorySettingVisibilityDetailUI.this.md5)) && (TopStorySettingVisibilityDetailUI.this.DJc != 0L))
        {
          TopStorySettingVisibilityDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(125998);
          return;
        }
        TopStorySettingVisibilityDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(125998);
      }
      
      public final void oh(int paramAnonymousInt)
      {
        AppMethodBeat.i(125999);
        Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        TopStorySettingVisibilityDetailUI.c(TopStorySettingVisibilityDetailUI.this);
        AppMethodBeat.o(125999);
      }
    };
    this.Glr = new HashSet();
    AppMethodBeat.o(126003);
  }
  
  private boolean fys()
  {
    AppMethodBeat.i(126008);
    if ((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5))
    {
      finish();
      AppMethodBeat.o(126008);
      return true;
    }
    int i = 2131766837;
    if (this.tipDialog != null) {
      i = 2131766839;
    }
    com.tencent.mm.ui.base.h.c(this, getString(i), "", getString(2131766843), getString(2131755761), new DialogInterface.OnClickListener()
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
  private void fyt()
  {
    AppMethodBeat.i(126011);
    if (this.Glq.isEmpty())
    {
      this.screen.jdMethod_do("revert_pref", true);
      AppMethodBeat.o(126011);
      return;
    }
    this.screen.jdMethod_do("revert_pref", false);
    this.Glo.setTitle(getString(2131766840, new Object[] { Integer.valueOf(this.Glq.size()) }));
    AppMethodBeat.o(126011);
  }
  
  private void r(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126014);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealOnAddContact %s", new Object[] { Integer.valueOf(i) });
      g.aAi();
      bv localbv = ((l)g.af(l.class)).aSN();
      String str1 = z.aTY();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        if ((!this.qLQ.contains(str2)) && (!str1.equals(str2)) && ((com.tencent.mm.contact.c.oR(localbv.Kn(str2).field_type)) || (!paramBoolean)))
        {
          this.qLQ.add(str2);
          this.Glq.add(str2);
        }
      }
    }
    if (this.gtU != null)
    {
      this.gtU.fm(this.qLQ);
      this.gtU.notifyChanged();
    }
    if (this.qLQ.size() > 0) {
      this.gtU.zU(true).zV(true);
    }
    for (;;)
    {
      fyt();
      updateTitle();
      AppMethodBeat.o(126014);
      return;
      this.gtU.zU(true).zV(false);
    }
  }
  
  protected final void DM(String paramString)
  {
    AppMethodBeat.i(126012);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "dealDelChatRoomMember");
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(126012);
      return;
    }
    this.qLQ.remove(paramString);
    if (this.gtU != null)
    {
      this.gtU.fm(this.qLQ);
      this.gtU.notifyChanged();
    }
    if ((this.qLQ.size() == 0) && (this.gtU != null))
    {
      this.gtU.gpE();
      this.gtU.zU(true).zV(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      this.Glq.clear();
      fyt();
      updateTitle();
      AppMethodBeat.o(126012);
      return;
      if (this.gtU != null) {
        this.gtU.zU(true).zV(true);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126009);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      fys();
      AppMethodBeat.o(126009);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(126009);
    return bool;
  }
  
  protected final void edF()
  {
    AppMethodBeat.i(126015);
    int i;
    if (((com.tencent.mm.kernel.b.h)g.aAe().azG()).aBb())
    {
      i = g.azz().aYS();
      if ((i == 4) || (i == 6)) {
        i = 1;
      }
    }
    while (i == 0)
    {
      u.makeText(this, 2131766842, 0).show();
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
    if (((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5)) && (this.DJc != 0L))
    {
      finish();
      AppMethodBeat.o(126015);
      return;
    }
    Object localObject2;
    if (this.DJc == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjd.clear();
      com.tencent.mm.plugin.topstory.a.b.a.fxV().Gjd.addAll(this.qLQ);
      com.tencent.mm.plugin.topstory.a.b.a.fxV().fxX();
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = this.qLQ.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label355;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.Glp.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.DJc == 1L)
        {
          ((List)localObject2).add(Integer.valueOf(3));
          continue;
          com.tencent.mm.plugin.topstory.a.b.a.fxV().FjN.clear();
          com.tencent.mm.plugin.topstory.a.b.a.fxV().FjN.addAll(this.qLQ);
          com.tencent.mm.plugin.topstory.a.b.a.fxV().fxW();
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
      }
    }
    label355:
    Object localObject3 = this.Glp.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.qLQ.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.DJc == 1L) {
          ((List)localObject2).add(Integer.valueOf(4));
        } else {
          ((List)localObject2).add(Integer.valueOf(2));
        }
      }
    }
    getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(2131766845), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126002);
        paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.d(TopStorySettingVisibilityDetailUI.this).iterator();
        while (paramAnonymousDialogInterface.hasNext())
        {
          com.tencent.mm.plugin.topstory.a.c.i locali = (com.tencent.mm.plugin.topstory.a.c.i)paramAnonymousDialogInterface.next();
          g.aAg().hqi.a(locali);
        }
        AppMethodBeat.o(126002);
      }
    });
    this.Glr.clear();
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
      this.Glr.add(locali);
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.Glr.size()) });
    Object localObject1 = this.Glr.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.topstory.a.c.i)((Iterator)localObject1).next();
      g.aAg().hqi.a((com.tencent.mm.ak.q)localObject2, 0);
    }
    AppMethodBeat.o(126015);
  }
  
  public int getResourceId()
  {
    return 2132017296;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126007);
    this.screen = getPreferenceScreen();
    this.gtU = ((ContactListExpandPreference)this.screen.bmg("roominfo_contact_anchor"));
    if (this.gtU != null)
    {
      this.gtU.a(this.screen, this.gtU.mKey);
      this.gtU.zU(true).zV(true);
      this.gtU.H(null, this.qLQ);
      this.gtU.a(new s.b()
      {
        public final boolean oi(int paramAnonymousInt)
        {
          AppMethodBeat.i(125997);
          if (!TopStorySettingVisibilityDetailUI.this.gtU.ail(paramAnonymousInt)) {
            Log.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(125997);
          return true;
        }
      });
      this.gtU.a(this.EJY);
    }
    this.Gln = this.screen.bmg("desc");
    this.Glo = this.screen.bmg("revert_pref");
    this.screen.jdMethod_do("revert_pref", true);
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
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125995);
        TopStorySettingVisibilityDetailUI.this.edF();
        AppMethodBeat.o(125995);
        return true;
      }
    }, null, t.b.OGU);
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
    if (Util.nullAsNil(z.aTY()).equals(localObject)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755172), "", true);
      AppMethodBeat.o(126013);
      return;
      if (this.qLQ == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.qLQ.iterator();
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
      localObject = Util.stringsToList(((String)localObject).split(","));
      if (localObject == null)
      {
        AppMethodBeat.o(126013);
        return;
      }
      paramIntent = paramIntent.getStringExtra("App_MsgId");
      if ((!Util.isNullOrNil(paramIntent)) && (paramIntent.equals("fromSns"))) {
        r((List)localObject, false);
      }
      while (((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5)) && (this.DJc != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(126013);
        return;
        r((List)localObject, true);
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
    if (!Util.isNullOrNil(paramBundle))
    {
      this.Glp = Arrays.asList(paramBundle.split(","));
      paramBundle = this.Glp.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if (!Util.isNullOrNil(str)) {
          this.qLQ.add(str);
        }
      }
    }
    initView();
    this.DJc = getIntent().getIntExtra("k_topstory_type", 0);
    if (this.DJc == 1L)
    {
      this.EJW = getString(2131766846);
      this.Gln.setTitle(2131766847);
    }
    for (;;)
    {
      g.azz().a(2859, this);
      enableOptionMenu(false);
      updateTitle();
      this.md5 = (this.EJW + " " + Util.listToString(this.qLQ, ","));
      AppMethodBeat.o(126005);
      return;
      this.EJW = getString(2131766835);
      this.Gln.setTitle(2131766836);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126006);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.azz().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(126006);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(126004);
    if ("revert_pref".equals(paramPreference.mKey)) {
      com.tencent.mm.ui.base.h.c(this, getString(2131766837), "", getString(2131766843), getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125993);
          paramAnonymousDialogInterface = TopStorySettingVisibilityDetailUI.this.Glq.iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            TopStorySettingVisibilityDetailUI.this.qLQ.remove(str);
          }
          if (TopStorySettingVisibilityDetailUI.this.gtU != null)
          {
            TopStorySettingVisibilityDetailUI.this.gtU.fm(TopStorySettingVisibilityDetailUI.this.qLQ);
            TopStorySettingVisibilityDetailUI.this.gtU.notifyChanged();
          }
          TopStorySettingVisibilityDetailUI.this.Glq.clear();
          TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this);
          TopStorySettingVisibilityDetailUI.this.updateTitle();
          AppMethodBeat.o(125993);
        }
      }, null);
    }
    AppMethodBeat.o(126004);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(126016);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    boolean bool;
    if ((paramq instanceof com.tencent.mm.plugin.topstory.a.c.i))
    {
      paramString = (com.tencent.mm.plugin.topstory.a.c.i)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label294;
      }
      bool = true;
      if (!bool) {
        break label300;
      }
      paramInt1 = ((abu)paramString.rr.iLL.iLR).BaseResponse.Ret;
      if (paramInt1 == 0) {
        break label300;
      }
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", new Object[] { Integer.valueOf(paramInt1) });
      bool = false;
    }
    label294:
    label300:
    for (;;)
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramString.jgF += 1;
        if (paramString.jgF < 2)
        {
          paramString = new com.tencent.mm.plugin.topstory.a.c.i(paramString);
          g.aAg().hqi.a(paramString, 0);
          this.Glr.add(paramString);
        }
      }
      if (this.Glr.contains(paramq))
      {
        this.Glr.remove(paramq);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.Glr.size()) });
        if (this.Glr.isEmpty())
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
    setMMTitle(this.EJW + "(" + this.qLQ.size() + ")");
    AppMethodBeat.o(126010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */