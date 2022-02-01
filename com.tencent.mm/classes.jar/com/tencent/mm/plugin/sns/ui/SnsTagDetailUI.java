package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements com.tencent.mm.al.g, n.b
{
  protected ContactListExpandPreference fpW;
  protected String md5;
  protected List<String> oiL;
  protected int scene;
  protected f screen;
  protected p tipDialog;
  protected long wFP;
  protected String xFb;
  private boolean xFc;
  protected ContactListExpandPreference.a xFd;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(99180);
    this.tipDialog = null;
    this.oiL = new ArrayList();
    this.xFb = "";
    this.md5 = "";
    this.xFc = false;
    this.scene = 0;
    this.xFd = new ContactListExpandPreference.a()
    {
      public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(201283);
        paramAnonymousViewGroup = SnsTagDetailUI.this.fpW.US(paramAnonymousInt);
        ad.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + paramAnonymousViewGroup);
        com.tencent.mm.kernel.g.afC();
        if (bt.by((String)com.tencent.mm.kernel.g.afB().afk().get(2, null), "").equals(paramAnonymousViewGroup))
        {
          h.j(SnsTagDetailUI.this.getContext(), 2131762613, 2131755906);
          AppMethodBeat.o(201283);
          return;
        }
        SnsTagDetailUI.this.oY(paramAnonymousViewGroup);
        if (((SnsTagDetailUI.this.xFb + " " + bt.n(SnsTagDetailUI.this.oiL, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.wFP != 0L))
        {
          SnsTagDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(201283);
          return;
        }
        SnsTagDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(201283);
      }
      
      public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(201285);
        paramAnonymousViewGroup = SnsTagDetailUI.this.fpW.US(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousViewGroup);
        if (SnsTagDetailUI.this.wFP == 4L) {
          paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 18);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.d.a.hYt.c(paramAnonymousView, SnsTagDetailUI.this);
          AppMethodBeat.o(201285);
          return;
          if (SnsTagDetailUI.this.wFP == 5L) {
            paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 19);
          }
        }
      }
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(201284);
        ad.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        SnsTagDetailUI.a(SnsTagDetailUI.this);
        AppMethodBeat.o(201284);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
      {
        AppMethodBeat.i(201286);
        if (SnsTagDetailUI.this.fpW != null) {
          SnsTagDetailUI.this.fpW.eyo();
        }
        AppMethodBeat.o(201286);
      }
    };
    AppMethodBeat.o(99180);
  }
  
  private void dBR()
  {
    AppMethodBeat.i(99188);
    Preference localPreference = this.screen.aKk("settings_tag_name");
    if (localPreference != null)
    {
      if (this.xFb.length() > 20) {
        this.xFb = this.xFb.substring(0, 20);
      }
      localPreference.setSummary(this.xFb);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(99188);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
  
  protected void cKe()
  {
    AppMethodBeat.i(99192);
    if (((this.xFb + " " + bt.n(this.oiL, ",")).equals(this.md5)) && (this.wFP != 0L))
    {
      finish();
      AppMethodBeat.o(99192);
      return;
    }
    if (af.dtA().B(this.wFP, this.xFb))
    {
      h.c(this, getString(2131763994, new Object[] { this.xFb }), getString(2131755906), true);
      AppMethodBeat.o(99192);
      return;
    }
    final com.tencent.mm.plugin.sns.model.v localv = new com.tencent.mm.plugin.sns.model.v(3, this.wFP, this.xFb, this.oiL.size(), this.oiL, this.scene);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(localv, 0);
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99175);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(localv);
        AppMethodBeat.o(99175);
      }
    });
    AppMethodBeat.o(99192);
  }
  
  protected void dAO()
  {
    AppMethodBeat.i(99181);
    ad.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(290, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(291, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(292, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(293, this);
    com.tencent.mm.kernel.g.afC();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().a(this);
    if (af.dtA().dyC().size() == 0)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.model.u(1), 0);
      this.xFc = true;
    }
    AppMethodBeat.o(99181);
  }
  
  protected void dAP()
  {
    AppMethodBeat.i(99183);
    ad.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(290, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(291, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(292, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(293, this);
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afC();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().b(this);
    }
    AppMethodBeat.o(99183);
  }
  
  protected void dAQ()
  {
    AppMethodBeat.i(99189);
    if (this.wFP != 0L)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.model.w(this.wFP, this.xFb), 0);
    }
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(99189);
  }
  
  protected List<String> dAS()
  {
    AppMethodBeat.i(99193);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.plugin.sns.storage.v localv = af.dtA().tj(this.wFP);
    Object localObject = localLinkedList;
    if (localv.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!localv.field_memberList.equals("")) {
        localObject = bt.S(localv.field_memberList.split(","));
      }
    }
    AppMethodBeat.o(99193);
    return localObject;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99191);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.xFb + " " + bt.n(this.oiL, ",")).equals(this.md5)) && (this.wFP != 0L)) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(99191);
        return true;
        h.a(this, 2131763989, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(99174);
            SnsTagDetailUI.this.finish();
            AppMethodBeat.o(99174);
          }
        }, null);
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99191);
    return bool;
  }
  
  protected void fD(List<String> paramList)
  {
    AppMethodBeat.i(99195);
    bg localbg = af.dti();
    String str1 = com.tencent.mm.model.u.aqG();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.oiL.contains(str2)) && (com.tencent.mm.n.b.ls(localbg.aHY(str2).field_type)) && (!str1.equals(str2))) {
        this.oiL.add(str2);
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
      updateTitle();
      AppMethodBeat.o(99195);
      return;
      this.fpW.ub(true).uc(false);
    }
  }
  
  public int getResourceId()
  {
    return 2131951749;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99190);
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
          AppMethodBeat.i(99170);
          if (!SnsTagDetailUI.this.fpW.UP(paramAnonymousInt)) {
            ad.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(99170);
          return true;
        }
      });
      this.fpW.a(this.xFd);
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99172);
        if (((SnsTagDetailUI.this.xFb + " " + bt.n(SnsTagDetailUI.this.oiL, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.wFP != 0L))
        {
          SnsTagDetailUI.this.finish();
          AppMethodBeat.o(99172);
          return true;
        }
        h.a(SnsTagDetailUI.this, 2131763989, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(99171);
            SnsTagDetailUI.this.finish();
            AppMethodBeat.o(99171);
          }
        }, null);
        AppMethodBeat.o(99172);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99173);
        SnsTagDetailUI.this.cKe();
        AppMethodBeat.o(99173);
        return true;
      }
    }, null, r.b.FOB);
    AppMethodBeat.o(99190);
  }
  
  protected void oY(String paramString)
  {
    AppMethodBeat.i(99194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(99194);
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
      updateTitle();
      AppMethodBeat.o(99194);
      return;
      if (this.fpW != null) {
        this.fpW.ub(true).uc(true);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99196);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(99196);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(99196);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bt.nullAsNil(com.tencent.mm.model.u.aqG()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        h.c(this, getString(2131755154, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(2131755906), true);
        AppMethodBeat.o(99196);
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
            if (!((String)localIterator.next()).equals(paramIntent)) {
              break label349;
            }
            paramInt1 = 1;
          }
        }
      }
    }
    label349:
    for (;;)
    {
      break;
      paramIntent = bt.S(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      fD(paramIntent);
      while (((this.xFb + " " + bt.n(this.oiL, ",")).equals(this.md5)) && (this.wFP != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.xFb = paramIntent;
        }
        updateTitle();
        ad.d("MicroMsg.SnsTagDetailUI", "updateName " + this.xFb);
      }
      enableOptionMenu(true);
      AppMethodBeat.o(99196);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99182);
    super.onCreate(paramBundle);
    dAO();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.wFP = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.wFP == 4L) {
      this.xFb = getString(2131764005);
    }
    while (this.wFP == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.xFb = bt.by(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = af.dti();
      String str1 = com.tencent.mm.model.u.aqG();
      localObject = bt.S(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.oiL.contains(str2)) && (com.tencent.mm.n.b.ls(paramBundle.aHY(str2).field_type)) && (!str1.equals(str2))) {
          this.oiL.add(str2);
        }
      }
      if (this.wFP == 5L) {
        this.xFb = getString(2131764017);
      } else {
        this.xFb = af.dtA().tj(this.wFP).field_tagName;
      }
    }
    this.oiL = dAS();
    label263:
    if ((this.xFb == null) || (this.xFb.equals("")))
    {
      this.xFb = getString(2131764004);
      this.xFb = aj.aoH(getString(2131764004));
    }
    initView();
    dBR();
    updateTitle();
    if (this.wFP < 6L)
    {
      this.screen.aKl("delete_tag_name");
      this.screen.aKl("delete_tag_name_category");
      if (this.wFP > 0L)
      {
        this.screen.aKl("settings_tag_name");
        this.screen.aKl("settings_tag_name_category");
      }
    }
    if (this.wFP == 4L)
    {
      this.screen.aKl("black");
      this.screen.aKl("group");
      if (this.wFP != 0L) {
        break label555;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.xFb + " " + bt.n(this.oiL, ","));
      AppMethodBeat.o(99182);
      return;
      if (this.wFP == 5L)
      {
        this.screen.aKl("outside");
        this.screen.aKl("group");
        break;
      }
      this.screen.aKl("black");
      this.screen.aKl("outside");
      break;
      label555:
      enableOptionMenu(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99184);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    dAP();
    super.onDestroy();
    AppMethodBeat.o(99184);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(99186);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.wFP >= 6L) || (this.wFP == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", bt.by(this.xFb, " "));
      com.tencent.mm.plugin.sns.d.a.hYt.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      h.a(this, 2131763091, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99169);
          SnsTagDetailUI.this.dAQ();
          AppMethodBeat.o(99169);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(99186);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99185);
    super.onResume();
    dBR();
    AppMethodBeat.o(99185);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(99197);
    ad.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99197);
      return;
      finish();
      AppMethodBeat.o(99197);
      return;
      finish();
      AppMethodBeat.o(99197);
      return;
      if ((this.fpW != null) && (this.xFc) && (!(this instanceof SnsBlackDetailUI)))
      {
        ad.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (com.tencent.mm.plugin.sns.model.u)paramn;
        paramn = new ArrayList();
        if (!bt.gL(paramString.sJ(this.wFP)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.sJ(this.wFP).size())
          {
            String str = (String)paramString.sJ(this.wFP).get(paramInt1);
            if (str != null) {
              paramn.add(str);
            }
            paramInt1 += 1;
          }
        }
        this.md5 = (this.xFb + " " + bt.n(paramn, ","));
        new LinkedList();
        paramString = this.oiL;
        this.oiL = dAS();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramn = (String)paramString.next();
            if (!this.oiL.contains(paramn)) {
              this.oiL.add(paramn);
            }
          }
        }
        this.fpW.dX(this.oiL);
        this.fpW.notifyChanged();
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
    AppMethodBeat.i(99187);
    setMMTitle(this.xFb + "(" + this.oiL.size() + ")");
    AppMethodBeat.o(99187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */