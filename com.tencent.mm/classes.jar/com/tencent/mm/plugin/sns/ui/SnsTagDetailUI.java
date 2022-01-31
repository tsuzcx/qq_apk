package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements com.tencent.mm.ah.f, m.b
{
  protected String bIW = "";
  protected com.tencent.mm.ui.base.preference.f dnn;
  protected ContactListExpandPreference dnv;
  protected List<String> iSZ = new ArrayList();
  protected long oqH;
  protected String pdN = "";
  private boolean pdO = false;
  protected ContactListExpandPreference.a pdP = new SnsTagDetailUI.9(this);
  protected int scene = 0;
  protected com.tencent.mm.ui.base.p tipDialog = null;
  
  private void bJo()
  {
    Preference localPreference = this.dnn.add("settings_tag_name");
    if (localPreference != null)
    {
      if (this.pdN.length() > 20) {
        this.pdN = this.pdN.substring(0, 20);
      }
      localPreference.setSummary(this.pdN);
      this.dnn.notifyDataSetChanged();
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject) {}
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.oqH >= 6L) || (this.oqH == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", bk.aM(this.pdN, " "));
      com.tencent.mm.plugin.sns.c.a.eUR.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      h.a(this, i.j.set_tag_del_cmd, i.j.app_tip, new SnsTagDetailUI.1(this), new SnsTagDetailUI.2(this));
    }
    return false;
  }
  
  protected void bIt()
  {
    y.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    g.DQ();
    g.DO().dJT.a(290, this);
    g.DQ();
    g.DO().dJT.a(291, this);
    g.DQ();
    g.DO().dJT.a(292, this);
    g.DQ();
    g.DO().dJT.a(293, this);
    g.DQ();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(this);
    if (af.bDL().bHe().size() == 0)
    {
      g.DQ();
      g.DO().dJT.a(new v(1), 0);
      this.pdO = true;
    }
  }
  
  protected void bIu()
  {
    y.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    g.DQ();
    g.DO().dJT.b(290, this);
    g.DQ();
    g.DO().dJT.b(291, this);
    g.DQ();
    g.DO().dJT.b(292, this);
    g.DQ();
    g.DO().dJT.b(293, this);
    g.DQ();
    if (g.DN().Dc())
    {
      g.DQ();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(this);
    }
  }
  
  protected void bIv()
  {
    if (this.oqH != 0L)
    {
      g.DQ();
      g.DO().dJT.a(new x(this.oqH, this.pdN), 0);
    }
    getString(i.j.app_tip);
    this.tipDialog = h.b(this, getString(i.j.sns_tag_save), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  protected List<String> bIw()
  {
    LinkedList localLinkedList = new LinkedList();
    t localt = af.bDL().gv(this.oqH);
    Object localObject = localLinkedList;
    if (localt.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!localt.field_memberList.equals("")) {
        localObject = bk.G(localt.field_memberList.split(","));
      }
    }
    return localObject;
  }
  
  protected void beJ()
  {
    if (((this.pdN + " " + bk.c(this.iSZ, ",")).equals(this.bIW)) && (this.oqH != 0L))
    {
      finish();
      return;
    }
    if (af.bDL().u(this.oqH, this.pdN))
    {
      h.b(this, getString(i.j.sns_tag_exist, new Object[] { this.pdN }), getString(i.j.app_tip), true);
      return;
    }
    w localw = new w(3, this.oqH, this.pdN, this.iSZ.size(), this.iSZ, this.scene);
    g.DQ();
    g.DO().dJT.a(localw, 0);
    getString(i.j.app_tip);
    this.tipDialog = h.b(this, getString(i.j.sns_tag_save), true, new SnsTagDetailUI.8(this, localw));
  }
  
  protected void cG(List<String> paramList)
  {
    bd localbd = af.bDt();
    String str1 = q.Gj();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.iSZ.contains(str2)) && (com.tencent.mm.n.a.gR(localbd.abl(str2).field_type)) && (!str1.equals(str2))) {
        this.iSZ.add(str2);
      }
    }
    if (this.dnv != null)
    {
      this.dnv.bJ(this.iSZ);
      this.dnv.notifyChanged();
    }
    if (this.iSZ.size() > 0) {
      this.dnv.lS(true).lT(true);
    }
    for (;;)
    {
      updateTitle();
      return;
      this.dnv.lS(true).lT(false);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.pdN + " " + bk.c(this.iSZ, ",")).equals(this.bIW)) && (this.oqH != 0L)) {
        finish();
      }
      for (;;)
      {
        return true;
        h.a(this, i.j.sns_tag_cancel, i.j.app_tip, new SnsTagDetailUI.7(this), null);
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void eR(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    this.iSZ.remove(paramString);
    if (this.dnv != null)
    {
      this.dnv.bJ(this.iSZ);
      this.dnv.notifyChanged();
    }
    if ((this.iSZ.size() == 0) && (this.dnv != null))
    {
      this.dnv.cmP();
      this.dnv.lS(true).lT(false);
      this.dnn.notifyDataSetChanged();
    }
    for (;;)
    {
      updateTitle();
      return;
      if (this.dnv != null) {
        this.dnv.lS(true).lT(true);
      }
    }
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    this.dnv = ((ContactListExpandPreference)this.dnn.add("roominfo_contact_anchor"));
    if (this.dnv != null)
    {
      this.dnv.a(this.dnn, this.dnv.mKey);
      this.dnv.lS(true).lT(true);
      this.dnv.s(null, this.iSZ);
      this.dnv.a(new k.b()
      {
        public final boolean gk(int paramAnonymousInt)
        {
          ContactListExpandPreference localContactListExpandPreference = SnsTagDetailUI.this.dnv;
          if (localContactListExpandPreference.sdh != null) {}
          for (boolean bool = localContactListExpandPreference.sdh.scu.Eb(paramAnonymousInt);; bool = true)
          {
            if (!bool) {
              y.d("MicroMsg.SnsTagDetailUI", "onItemLongClick " + paramAnonymousInt);
            }
            return true;
          }
        }
      });
      this.dnv.a(this.pdP);
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new SnsTagDetailUI.5(this));
    a(0, getString(i.j.app_finish), new SnsTagDetailUI.6(this), s.b.uNx);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (bk.pm(q.Gj()).equals(paramIntent)) {
      paramInt2 = 1;
    }
    while (paramInt2 != 0)
    {
      h.b(this, getString(i.j.add_room_mem_memberExits, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(i.j.app_tip), true);
      return;
      if (this.iSZ == null)
      {
        paramInt2 = 0;
      }
      else
      {
        Iterator localIterator = this.iSZ.iterator();
        paramInt1 = 0;
        label132:
        paramInt2 = paramInt1;
        if (localIterator.hasNext())
        {
          if (!((String)localIterator.next()).equals(paramIntent)) {
            break label299;
          }
          paramInt1 = 1;
        }
      }
    }
    label299:
    for (;;)
    {
      break label132;
      paramIntent = bk.G(paramIntent.split(","));
      if (paramIntent == null) {
        break;
      }
      cG(paramIntent);
      while (((this.pdN + " " + bk.c(this.iSZ, ",")).equals(this.bIW)) && (this.oqH != 0L))
      {
        enableOptionMenu(false);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.pdN = paramIntent;
        }
        updateTitle();
        y.d("MicroMsg.SnsTagDetailUI", "updateName " + this.pdN);
      }
      enableOptionMenu(true);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bIt();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.oqH = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.oqH == 4L) {
      this.pdN = getString(i.j.sns_tag_outsiders);
    }
    while (this.oqH == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.pdN = bk.aM(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = af.bDt();
      String str1 = q.Gj();
      localObject = bk.G(((String)localObject).split(","));
      if (localObject == null) {
        break label257;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.iSZ.contains(str2)) && (com.tencent.mm.n.a.gR(paramBundle.abl(str2).field_type)) && (!str1.equals(str2))) {
          this.iSZ.add(str2);
        }
      }
      if (this.oqH == 5L) {
        this.pdN = getString(i.j.sns_tag_snsblack);
      } else {
        this.pdN = af.bDL().gv(this.oqH).field_tagName;
      }
    }
    this.iSZ = bIw();
    label257:
    if ((this.pdN == null) || (this.pdN.equals("")))
    {
      this.pdN = getString(i.j.sns_tag_name_unknow);
      this.pdN = aj.NF(getString(i.j.sns_tag_name_unknow));
    }
    initView();
    bJo();
    updateTitle();
    if (this.oqH < 6L)
    {
      this.dnn.ade("delete_tag_name");
      this.dnn.ade("delete_tag_name_category");
      if (this.oqH > 0L)
      {
        this.dnn.ade("settings_tag_name");
        this.dnn.ade("settings_tag_name_category");
      }
    }
    if (this.oqH == 4L)
    {
      this.dnn.ade("black");
      this.dnn.ade("group");
      if (this.oqH != 0L) {
        break label542;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.bIW = (this.pdN + " " + bk.c(this.iSZ, ","));
      return;
      if (this.oqH == 5L)
      {
        this.dnn.ade("outside");
        this.dnn.ade("group");
        break;
      }
      this.dnn.ade("black");
      this.dnn.ade("outside");
      break;
      label542:
      enableOptionMenu(false);
    }
  }
  
  public void onDestroy()
  {
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    bIu();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    bJo();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramm.getType())
    {
    }
    do
    {
      return;
      finish();
      return;
      finish();
      return;
    } while ((this.dnv == null) || (!this.pdO) || ((this instanceof SnsBlackDetailUI)));
    y.d("MicroMsg.SnsTagDetailUI", "update form net");
    paramString = (v)paramm;
    this.bIW = (this.pdN + " " + bk.c(paramString.gb(this.oqH), ","));
    new LinkedList();
    paramString = this.iSZ;
    this.iSZ = bIw();
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramm = (String)paramString.next();
        if (!this.iSZ.contains(paramm)) {
          this.iSZ.add(paramm);
        }
      }
    }
    this.dnv.bJ(this.iSZ);
    this.dnv.notifyChanged();
  }
  
  protected final void updateTitle()
  {
    setMMTitle(this.pdN + "(" + this.iSZ.size() + ")");
  }
  
  public final int xj()
  {
    return i.m.tag_detail_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */