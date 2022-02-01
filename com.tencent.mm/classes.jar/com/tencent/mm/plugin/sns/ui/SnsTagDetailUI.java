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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements com.tencent.mm.ak.g, n.b
{
  protected ContactListExpandPreference ftA;
  protected String md5;
  protected List<String> oMl;
  protected ContactListExpandPreference.a rpz;
  protected int scene;
  protected f screen;
  protected p tipDialog;
  protected long xSj;
  protected String yRP;
  private boolean yRQ;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(99180);
    this.tipDialog = null;
    this.oMl = new ArrayList();
    this.yRP = "";
    this.md5 = "";
    this.yRQ = false;
    this.scene = 0;
    this.rpz = new ContactListExpandPreference.a()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(200536);
        paramAnonymousViewGroup = SnsTagDetailUI.this.ftA.Xb(paramAnonymousInt);
        ac.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + paramAnonymousViewGroup);
        com.tencent.mm.kernel.g.agS();
        if (bs.bG((String)com.tencent.mm.kernel.g.agR().agA().get(2, null), "").equals(paramAnonymousViewGroup))
        {
          h.l(SnsTagDetailUI.this.getContext(), 2131762613, 2131755906);
          AppMethodBeat.o(200536);
          return;
        }
        SnsTagDetailUI.this.sk(paramAnonymousViewGroup);
        if (((SnsTagDetailUI.this.yRP + " " + bs.n(SnsTagDetailUI.this.oMl, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.xSj != 0L))
        {
          SnsTagDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(200536);
          return;
        }
        SnsTagDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(200536);
      }
      
      public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(200538);
        paramAnonymousViewGroup = SnsTagDetailUI.this.ftA.Xb(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousViewGroup);
        if (SnsTagDetailUI.this.xSj == 4L) {
          paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 18);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.c.a.iyx.c(paramAnonymousView, SnsTagDetailUI.this);
          AppMethodBeat.o(200538);
          return;
          if (SnsTagDetailUI.this.xSj == 5L) {
            paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 19);
          }
        }
      }
      
      public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(200537);
        ac.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        SnsTagDetailUI.a(SnsTagDetailUI.this);
        AppMethodBeat.o(200537);
      }
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
      
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
      {
        AppMethodBeat.i(200539);
        if (SnsTagDetailUI.this.ftA != null) {
          SnsTagDetailUI.this.ftA.eNI();
        }
        AppMethodBeat.o(200539);
      }
    };
    AppMethodBeat.o(99180);
  }
  
  private void dQo()
  {
    AppMethodBeat.i(99188);
    Preference localPreference = this.screen.aPN("settings_tag_name");
    if (localPreference != null)
    {
      if (this.yRP.length() > 20) {
        this.yRP = this.yRP.substring(0, 20);
      }
      localPreference.setSummary(this.yRP);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(99188);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
  
  protected void cXJ()
  {
    AppMethodBeat.i(99192);
    if (((this.yRP + " " + bs.n(this.oMl, ",")).equals(this.md5)) && (this.xSj != 0L))
    {
      finish();
      AppMethodBeat.o(99192);
      return;
    }
    if (af.dHX().z(this.xSj, this.yRP))
    {
      h.c(this, getString(2131763994, new Object[] { this.yRP }), getString(2131755906), true);
      AppMethodBeat.o(99192);
      return;
    }
    final com.tencent.mm.plugin.sns.model.v localv = new com.tencent.mm.plugin.sns.model.v(3, this.xSj, this.yRP, this.oMl.size(), this.oMl, this.scene);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(localv, 0);
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99175);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(localv);
        AppMethodBeat.o(99175);
      }
    });
    AppMethodBeat.o(99192);
  }
  
  protected void dPl()
  {
    AppMethodBeat.i(99181);
    ac.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(290, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(291, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(293, this);
    com.tencent.mm.kernel.g.agS();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().a(this);
    if (af.dHX().dMZ().size() == 0)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.model.u(1), 0);
      this.yRQ = true;
    }
    AppMethodBeat.o(99181);
  }
  
  protected void dPm()
  {
    AppMethodBeat.i(99183);
    ac.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(290, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(291, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(293, this);
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agS();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().b(this);
    }
    AppMethodBeat.o(99183);
  }
  
  protected void dPn()
  {
    AppMethodBeat.i(99189);
    if (this.xSj != 0L)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.model.w(this.xSj, this.yRP), 0);
    }
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(99189);
  }
  
  protected List<String> dPp()
  {
    AppMethodBeat.i(99193);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.plugin.sns.storage.v localv = af.dHX().xM(this.xSj);
    Object localObject = localLinkedList;
    if (localv.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!localv.field_memberList.equals("")) {
        localObject = bs.S(localv.field_memberList.split(","));
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
      if (((this.yRP + " " + bs.n(this.oMl, ",")).equals(this.md5)) && (this.xSj != 0L)) {
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
  
  protected void fL(List<String> paramList)
  {
    AppMethodBeat.i(99195);
    bj localbj = af.dHF();
    String str1 = com.tencent.mm.model.u.axw();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.oMl.contains(str2)) && (com.tencent.mm.n.b.ln(localbj.aNt(str2).field_type)) && (!str1.equals(str2))) {
        this.oMl.add(str2);
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
      updateTitle();
      AppMethodBeat.o(99195);
      return;
      this.ftA.vc(true).vd(false);
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
          AppMethodBeat.i(99170);
          if (!SnsTagDetailUI.this.ftA.WY(paramAnonymousInt)) {
            ac.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(99170);
          return true;
        }
      });
      this.ftA.a(this.rpz);
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99172);
        if (((SnsTagDetailUI.this.yRP + " " + bs.n(SnsTagDetailUI.this.oMl, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.xSj != 0L))
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
        SnsTagDetailUI.this.cXJ();
        AppMethodBeat.o(99173);
        return true;
      }
    }, null, com.tencent.mm.ui.s.b.Hom);
    AppMethodBeat.o(99190);
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
      if (bs.nullAsNil(com.tencent.mm.model.u.axw()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        h.c(this, getString(2131755154, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(2131755906), true);
        AppMethodBeat.o(99196);
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
      paramIntent = bs.S(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      fL(paramIntent);
      while (((this.yRP + " " + bs.n(this.oMl, ",")).equals(this.md5)) && (this.xSj != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.yRP = paramIntent;
        }
        updateTitle();
        ac.d("MicroMsg.SnsTagDetailUI", "updateName " + this.yRP);
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
    dPl();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.xSj = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.xSj == 4L) {
      this.yRP = getString(2131764005);
    }
    while (this.xSj == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.yRP = bs.bG(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = af.dHF();
      String str1 = com.tencent.mm.model.u.axw();
      localObject = bs.S(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.oMl.contains(str2)) && (com.tencent.mm.n.b.ln(paramBundle.aNt(str2).field_type)) && (!str1.equals(str2))) {
          this.oMl.add(str2);
        }
      }
      if (this.xSj == 5L) {
        this.yRP = getString(2131764017);
      } else {
        this.yRP = af.dHX().xM(this.xSj).field_tagName;
      }
    }
    this.oMl = dPp();
    label263:
    if ((this.yRP == null) || (this.yRP.equals("")))
    {
      this.yRP = getString(2131764004);
      this.yRP = aj.atT(getString(2131764004));
    }
    initView();
    dQo();
    updateTitle();
    if (this.xSj < 6L)
    {
      this.screen.aPO("delete_tag_name");
      this.screen.aPO("delete_tag_name_category");
      if (this.xSj > 0L)
      {
        this.screen.aPO("settings_tag_name");
        this.screen.aPO("settings_tag_name_category");
      }
    }
    if (this.xSj == 4L)
    {
      this.screen.aPO("black");
      this.screen.aPO("group");
      if (this.xSj != 0L) {
        break label555;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.yRP + " " + bs.n(this.oMl, ","));
      AppMethodBeat.o(99182);
      return;
      if (this.xSj == 5L)
      {
        this.screen.aPO("outside");
        this.screen.aPO("group");
        break;
      }
      this.screen.aPO("black");
      this.screen.aPO("outside");
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
    dPm();
    super.onDestroy();
    AppMethodBeat.o(99184);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(99186);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.xSj >= 6L) || (this.xSj == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", bs.bG(this.yRP, " "));
      com.tencent.mm.plugin.sns.c.a.iyx.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      h.a(this, 2131763091, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99169);
          SnsTagDetailUI.this.dPn();
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
    dQo();
    AppMethodBeat.o(99185);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(99197);
    ac.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
      if ((this.ftA != null) && (this.yRQ) && (!(this instanceof SnsBlackDetailUI)))
      {
        ac.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (com.tencent.mm.plugin.sns.model.u)paramn;
        paramn = new ArrayList();
        if (!bs.gY(paramString.xm(this.xSj)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.xm(this.xSj).size())
          {
            String str = (String)paramString.xm(this.xSj).get(paramInt1);
            if (str != null) {
              paramn.add(str);
            }
            paramInt1 += 1;
          }
        }
        this.md5 = (this.yRP + " " + bs.n(paramn, ","));
        new LinkedList();
        paramString = this.oMl;
        this.oMl = dPp();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramn = (String)paramString.next();
            if (!this.oMl.contains(paramn)) {
              this.oMl.add(paramn);
            }
          }
        }
        this.ftA.eb(this.oMl);
        this.ftA.notifyChanged();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void sk(String paramString)
  {
    AppMethodBeat.i(99194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(99194);
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
      updateTitle();
      AppMethodBeat.o(99194);
      return;
      if (this.ftA != null) {
        this.ftA.vc(true).vd(true);
      }
    }
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(99187);
    setMMTitle(this.yRP + "(" + this.oMl.size() + ")");
    AppMethodBeat.o(99187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */