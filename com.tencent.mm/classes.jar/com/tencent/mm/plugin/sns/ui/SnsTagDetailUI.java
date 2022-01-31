package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements com.tencent.mm.ai.f, n.b
{
  protected String cqq;
  protected ContactListExpandPreference eeU;
  protected List<String> lbK;
  protected String rWA;
  private boolean rWB;
  protected ContactListExpandPreference.a rWC;
  protected long rfr;
  protected int scene;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected com.tencent.mm.ui.base.p tipDialog;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(39356);
    this.tipDialog = null;
    this.lbK = new ArrayList();
    this.rWA = "";
    this.cqq = "";
    this.rWB = false;
    this.scene = 0;
    this.rWC = new SnsTagDetailUI.9(this);
    AppMethodBeat.o(39356);
  }
  
  private void cvR()
  {
    AppMethodBeat.i(39364);
    Preference localPreference = this.screen.atx("settings_tag_name");
    if (localPreference != null)
    {
      if (this.rWA.length() > 20) {
        this.rWA = this.rWA.substring(0, 20);
      }
      localPreference.setSummary(this.rWA);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(39364);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
  
  protected void bMd()
  {
    AppMethodBeat.i(39369);
    if (((this.rWA + " " + bo.d(this.lbK, ",")).equals(this.cqq)) && (this.rfr != 0L))
    {
      finish();
      AppMethodBeat.o(39369);
      return;
    }
    if (ag.cpl().v(this.rfr, this.rWA))
    {
      h.b(this, getString(2131303977, new Object[] { this.rWA }), getString(2131297087), true);
      AppMethodBeat.o(39369);
      return;
    }
    w localw = new w(3, this.rfr, this.rWA, this.lbK.size(), this.lbK, this.scene);
    g.RM();
    g.RK().eHt.a(localw, 0);
    getString(2131297087);
    this.tipDialog = h.b(this, getString(2131303996), true, new SnsTagDetailUI.8(this, localw));
    AppMethodBeat.o(39369);
  }
  
  protected void cuN()
  {
    AppMethodBeat.i(39357);
    ab.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    g.RM();
    g.RK().eHt.a(290, this);
    g.RM();
    g.RK().eHt.a(291, this);
    g.RM();
    g.RK().eHt.a(292, this);
    g.RM();
    g.RK().eHt.a(293, this);
    g.RM();
    ((j)g.E(j.class)).YA().a(this);
    if (ag.cpl().cti().size() == 0)
    {
      g.RM();
      g.RK().eHt.a(new v(1), 0);
      this.rWB = true;
    }
    AppMethodBeat.o(39357);
  }
  
  protected void cuO()
  {
    AppMethodBeat.i(39359);
    ab.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    g.RM();
    g.RK().eHt.b(290, this);
    g.RM();
    g.RK().eHt.b(291, this);
    g.RM();
    g.RK().eHt.b(292, this);
    g.RM();
    g.RK().eHt.b(293, this);
    g.RM();
    if (g.RJ().QU())
    {
      g.RM();
      ((j)g.E(j.class)).YA().b(this);
    }
    AppMethodBeat.o(39359);
  }
  
  protected void cuP()
  {
    AppMethodBeat.i(39365);
    if (this.rfr != 0L)
    {
      g.RM();
      g.RK().eHt.a(new x(this.rfr, this.rWA), 0);
    }
    getString(2131297087);
    this.tipDialog = h.b(this, getString(2131303996), true, new SnsTagDetailUI.3(this));
    AppMethodBeat.o(39365);
  }
  
  protected List<String> cuR()
  {
    AppMethodBeat.i(39370);
    LinkedList localLinkedList = new LinkedList();
    t localt = ag.cpl().mb(this.rfr);
    Object localObject = localLinkedList;
    if (localt.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!localt.field_memberList.equals("")) {
        localObject = bo.P(localt.field_memberList.split(","));
      }
    }
    AppMethodBeat.o(39370);
    return localObject;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39368);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.rWA + " " + bo.d(this.lbK, ",")).equals(this.cqq)) && (this.rfr != 0L)) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(39368);
        return true;
        h.a(this, 2131303972, 2131297087, new SnsTagDetailUI.7(this), null);
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(39368);
    return bool;
  }
  
  protected void dm(List<String> paramList)
  {
    AppMethodBeat.i(39372);
    bd localbd = ag.coT();
    String str1 = r.Zn();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.lbK.contains(str2)) && (com.tencent.mm.n.a.je(localbd.arw(str2).field_type)) && (!str1.equals(str2))) {
        this.lbK.add(str2);
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
      updateTitle();
      AppMethodBeat.o(39372);
      return;
      this.eeU.pf(true).pg(false);
    }
  }
  
  public int getResourceId()
  {
    return 2131165305;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39366);
    this.screen = getPreferenceScreen();
    this.eeU = ((ContactListExpandPreference)this.screen.atx("roominfo_contact_anchor"));
    if (this.eeU != null)
    {
      this.eeU.a(this.screen, this.eeU.mKey);
      this.eeU.pf(true).pg(true);
      this.eeU.v(null, this.lbK);
      this.eeU.a(new SnsTagDetailUI.4(this));
      this.eeU.a(this.rWC);
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new SnsTagDetailUI.5(this));
    addTextOptionMenu(0, getString(2131296964), new SnsTagDetailUI.6(this), null, q.b.zby);
    AppMethodBeat.o(39366);
  }
  
  protected void lc(String paramString)
  {
    AppMethodBeat.i(39371);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(39371);
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
      updateTitle();
      AppMethodBeat.o(39371);
      return;
      if (this.eeU != null) {
        this.eeU.pf(true).pg(true);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39373);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(39373);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(39373);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(39373);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bo.nullAsNil(r.Zn()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        h.b(this, getString(2131296426, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(2131297087), true);
        AppMethodBeat.o(39373);
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
            if (!((String)localIterator.next()).equals(paramIntent)) {
              break label348;
            }
            paramInt1 = 1;
          }
        }
      }
    }
    label348:
    for (;;)
    {
      break;
      paramIntent = bo.P(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(39373);
        return;
      }
      dm(paramIntent);
      while (((this.rWA + " " + bo.d(this.lbK, ",")).equals(this.cqq)) && (this.rfr != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(39373);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.rWA = paramIntent;
        }
        updateTitle();
        ab.d("MicroMsg.SnsTagDetailUI", "updateName " + this.rWA);
      }
      enableOptionMenu(true);
      AppMethodBeat.o(39373);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39358);
    super.onCreate(paramBundle);
    cuN();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.rfr = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.rfr == 4L) {
      this.rWA = getString(2131303988);
    }
    while (this.rfr == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.rWA = bo.bf(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = ag.coT();
      String str1 = r.Zn();
      localObject = bo.P(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.lbK.contains(str2)) && (com.tencent.mm.n.a.je(paramBundle.arw(str2).field_type)) && (!str1.equals(str2))) {
          this.lbK.add(str2);
        }
      }
      if (this.rfr == 5L) {
        this.rWA = getString(2131304000);
      } else {
        this.rWA = ag.cpl().mb(this.rfr).field_tagName;
      }
    }
    this.lbK = cuR();
    label263:
    if ((this.rWA == null) || (this.rWA.equals("")))
    {
      this.rWA = getString(2131303987);
      this.rWA = ak.aaz(getString(2131303987));
    }
    initView();
    cvR();
    updateTitle();
    if (this.rfr < 6L)
    {
      this.screen.aty("delete_tag_name");
      this.screen.aty("delete_tag_name_category");
      if (this.rfr > 0L)
      {
        this.screen.aty("settings_tag_name");
        this.screen.aty("settings_tag_name_category");
      }
    }
    if (this.rfr == 4L)
    {
      this.screen.aty("black");
      this.screen.aty("group");
      if (this.rfr != 0L) {
        break label555;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.cqq = (this.rWA + " " + bo.d(this.lbK, ","));
      AppMethodBeat.o(39358);
      return;
      if (this.rfr == 5L)
      {
        this.screen.aty("outside");
        this.screen.aty("group");
        break;
      }
      this.screen.aty("black");
      this.screen.aty("outside");
      break;
      label555:
      enableOptionMenu(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39360);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    cuO();
    super.onDestroy();
    AppMethodBeat.o(39360);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(39362);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.rfr >= 6L) || (this.rfr == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", bo.bf(this.rWA, " "));
      com.tencent.mm.plugin.sns.c.a.gmO.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      h.a(this, 2131303135, 2131297087, new SnsTagDetailUI.1(this), new SnsTagDetailUI.2(this));
    }
    AppMethodBeat.o(39362);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39361);
    super.onResume();
    cvR();
    AppMethodBeat.o(39361);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(39374);
    ab.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39374);
      return;
      finish();
      AppMethodBeat.o(39374);
      return;
      finish();
      AppMethodBeat.o(39374);
      return;
      if ((this.eeU != null) && (this.rWB) && (!(this instanceof SnsBlackDetailUI)))
      {
        ab.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (v)paramm;
        this.cqq = (this.rWA + " " + bo.d(paramString.lG(this.rfr), ","));
        new LinkedList();
        paramString = this.lbK;
        this.lbK = cuR();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramm = (String)paramString.next();
            if (!this.lbK.contains(paramm)) {
              this.lbK.add(paramm);
            }
          }
        }
        this.eeU.cg(this.lbK);
        this.eeU.notifyChanged();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(39363);
    setMMTitle(this.rWA + "(" + this.lbK.size() + ")");
    AppMethodBeat.o(39363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */