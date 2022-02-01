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
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements com.tencent.mm.ak.f, n.b
{
  protected String AAA;
  private boolean AAB;
  protected ContactListExpandPreference.a AAD;
  protected ContactListExpandPreference fOK;
  protected String md5;
  protected List<String> pwz;
  protected int scene;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected p tipDialog;
  protected long zyS;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(99180);
    this.tipDialog = null;
    this.pwz = new ArrayList();
    this.AAA = "";
    this.md5 = "";
    this.AAB = false;
    this.scene = 0;
    this.AAD = new ContactListExpandPreference.a()
    {
      public final void YS()
      {
        AppMethodBeat.i(99179);
        if (SnsTagDetailUI.this.fOK != null) {
          SnsTagDetailUI.this.fOK.fgv();
        }
        AppMethodBeat.o(99179);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(219940);
        paramAnonymousViewGroup = SnsTagDetailUI.this.fOK.ZD(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        if (SnsTagDetailUI.this.zyS == 4L) {
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.c.a.iUz.c(localIntent, SnsTagDetailUI.this);
          AppMethodBeat.o(219940);
          return;
          if (SnsTagDetailUI.this.zyS == 5L) {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
          }
        }
      }
      
      public final void le(int paramAnonymousInt)
      {
        AppMethodBeat.i(99176);
        String str = SnsTagDetailUI.this.fOK.ZD(paramAnonymousInt);
        ae.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        g.ajS();
        if (bu.bI((String)g.ajR().ajA().get(2, null), "").equals(str))
        {
          h.l(SnsTagDetailUI.this.getContext(), 2131762613, 2131755906);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.vv(str);
        if (((SnsTagDetailUI.this.AAA + " " + bu.m(SnsTagDetailUI.this.pwz, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.zyS != 0L))
        {
          SnsTagDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(99176);
      }
      
      public final void lf(int paramAnonymousInt)
      {
        AppMethodBeat.i(99177);
        ae.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        SnsTagDetailUI.a(SnsTagDetailUI.this);
        AppMethodBeat.o(99177);
      }
    };
    AppMethodBeat.o(99180);
  }
  
  private void egl()
  {
    AppMethodBeat.i(99188);
    Preference localPreference = this.screen.aXe("settings_tag_name");
    if (localPreference != null)
    {
      if (this.AAA.length() > 20) {
        this.AAA = this.AAA.substring(0, 20);
      }
      localPreference.setSummary(this.AAA);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(99188);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99191);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.AAA + " " + bu.m(this.pwz, ",")).equals(this.md5)) && (this.zyS != 0L)) {
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
  
  protected void djU()
  {
    AppMethodBeat.i(99192);
    if (((this.AAA + " " + bu.m(this.pwz, ",")).equals(this.md5)) && (this.zyS != 0L))
    {
      finish();
      AppMethodBeat.o(99192);
      return;
    }
    if (ah.dXK().E(this.zyS, this.AAA))
    {
      h.c(this, getString(2131763994, new Object[] { this.AAA }), getString(2131755906), true);
      AppMethodBeat.o(99192);
      return;
    }
    final com.tencent.mm.plugin.sns.model.w localw = new com.tencent.mm.plugin.sns.model.w(3, this.zyS, this.AAA, this.pwz.size(), this.pwz, this.scene);
    g.ajS();
    g.ajQ().gDv.a(localw, 0);
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99175);
        g.ajS();
        g.ajQ().gDv.a(localw);
        AppMethodBeat.o(99175);
      }
    });
    AppMethodBeat.o(99192);
  }
  
  protected void efj()
  {
    AppMethodBeat.i(99181);
    ae.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    g.ajS();
    g.ajQ().gDv.a(290, this);
    g.ajS();
    g.ajQ().gDv.a(291, this);
    g.ajS();
    g.ajQ().gDv.a(292, this);
    g.ajS();
    g.ajQ().gDv.a(293, this);
    g.ajS();
    ((l)g.ab(l.class)).azF().a(this);
    if (ah.dXK().ecT().size() == 0)
    {
      g.ajS();
      g.ajQ().gDv.a(new com.tencent.mm.plugin.sns.model.v(1), 0);
      this.AAB = true;
    }
    AppMethodBeat.o(99181);
  }
  
  protected void efk()
  {
    AppMethodBeat.i(99183);
    ae.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    g.ajS();
    g.ajQ().gDv.b(290, this);
    g.ajS();
    g.ajQ().gDv.b(291, this);
    g.ajS();
    g.ajQ().gDv.b(292, this);
    g.ajS();
    g.ajQ().gDv.b(293, this);
    g.ajS();
    if (g.ajP().aiZ())
    {
      g.ajS();
      ((l)g.ab(l.class)).azF().b(this);
    }
    AppMethodBeat.o(99183);
  }
  
  protected void efl()
  {
    AppMethodBeat.i(99189);
    if (this.zyS != 0L)
    {
      g.ajS();
      g.ajQ().gDv.a(new x(this.zyS, this.AAA), 0);
    }
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(99189);
  }
  
  protected List<String> efn()
  {
    AppMethodBeat.i(99193);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.plugin.sns.storage.v localv = ah.dXK().AI(this.zyS);
    Object localObject = localLinkedList;
    if (localv.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!localv.field_memberList.equals("")) {
        localObject = bu.U(localv.field_memberList.split(","));
      }
    }
    AppMethodBeat.o(99193);
    return localObject;
  }
  
  public int getResourceId()
  {
    return 2131951749;
  }
  
  protected void gf(List<String> paramList)
  {
    AppMethodBeat.i(99195);
    bq localbq = ah.dXs();
    String str1 = com.tencent.mm.model.v.aAC();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.pwz.contains(str2)) && (c.lO(localbq.BH(str2).field_type)) && (!str1.equals(str2))) {
        this.pwz.add(str2);
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
      updateTitle();
      AppMethodBeat.o(99195);
      return;
      this.fOK.vW(true).vX(false);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(99190);
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
          AppMethodBeat.i(99170);
          if (!SnsTagDetailUI.this.fOK.ZA(paramAnonymousInt)) {
            ae.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(99170);
          return true;
        }
      });
      this.fOK.a(this.AAD);
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99172);
        if (((SnsTagDetailUI.this.AAA + " " + bu.m(SnsTagDetailUI.this.pwz, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.zyS != 0L))
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
        SnsTagDetailUI.this.djU();
        AppMethodBeat.o(99173);
        return true;
      }
    }, null, com.tencent.mm.ui.s.b.JwA);
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
      if (bu.nullAsNil(com.tencent.mm.model.v.aAC()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        h.c(this, getString(2131755154, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(2131755906), true);
        AppMethodBeat.o(99196);
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
      paramIntent = bu.U(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      gf(paramIntent);
      while (((this.AAA + " " + bu.m(this.pwz, ",")).equals(this.md5)) && (this.zyS != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.AAA = paramIntent;
        }
        updateTitle();
        ae.d("MicroMsg.SnsTagDetailUI", "updateName " + this.AAA);
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
    efj();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.zyS = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.zyS == 4L) {
      this.AAA = getString(2131764005);
    }
    while (this.zyS == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.AAA = bu.bI(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = ah.dXs();
      String str1 = com.tencent.mm.model.v.aAC();
      localObject = bu.U(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.pwz.contains(str2)) && (c.lO(paramBundle.BH(str2).field_type)) && (!str1.equals(str2))) {
          this.pwz.add(str2);
        }
      }
      if (this.zyS == 5L) {
        this.AAA = getString(2131764017);
      } else {
        this.AAA = ah.dXK().AI(this.zyS).field_tagName;
      }
    }
    this.pwz = efn();
    label263:
    if ((this.AAA == null) || (this.AAA.equals("")))
    {
      this.AAA = getString(2131764004);
      this.AAA = al.aAp(getString(2131764004));
    }
    initView();
    egl();
    updateTitle();
    if (this.zyS < 6L)
    {
      this.screen.aXf("delete_tag_name");
      this.screen.aXf("delete_tag_name_category");
      if (this.zyS > 0L)
      {
        this.screen.aXf("settings_tag_name");
        this.screen.aXf("settings_tag_name_category");
      }
    }
    if (this.zyS == 4L)
    {
      this.screen.aXf("black");
      this.screen.aXf("group");
      if (this.zyS != 0L) {
        break label555;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.AAA + " " + bu.m(this.pwz, ","));
      AppMethodBeat.o(99182);
      return;
      if (this.zyS == 5L)
      {
        this.screen.aXf("outside");
        this.screen.aXf("group");
        break;
      }
      this.screen.aXf("black");
      this.screen.aXf("outside");
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
    efk();
    super.onDestroy();
    AppMethodBeat.o(99184);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(99186);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.zyS >= 6L) || (this.zyS == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", bu.bI(this.AAA, " "));
      com.tencent.mm.plugin.sns.c.a.iUz.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      h.a(this, 2131763091, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99169);
          SnsTagDetailUI.this.efl();
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
    egl();
    AppMethodBeat.o(99185);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(99197);
    ae.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
      if ((this.fOK != null) && (this.AAB) && (!(this instanceof SnsBlackDetailUI)))
      {
        ae.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (com.tencent.mm.plugin.sns.model.v)paramn;
        paramn = new ArrayList();
        if (!bu.ht(paramString.Aj(this.zyS)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.Aj(this.zyS).size())
          {
            String str = (String)paramString.Aj(this.zyS).get(paramInt1);
            if (str != null) {
              paramn.add(str);
            }
            paramInt1 += 1;
          }
        }
        this.md5 = (this.AAA + " " + bu.m(paramn, ","));
        new LinkedList();
        paramString = this.pwz;
        this.pwz = efn();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramn = (String)paramString.next();
            if (!this.pwz.contains(paramn)) {
              this.pwz.add(paramn);
            }
          }
        }
        this.fOK.es(this.pwz);
        this.fOK.notifyChanged();
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
    setMMTitle(this.AAA + "(" + this.pwz.size() + ")");
    AppMethodBeat.o(99187);
  }
  
  protected void vv(String paramString)
  {
    AppMethodBeat.i(99194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(99194);
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
      updateTitle();
      AppMethodBeat.o(99194);
      return;
      if (this.fOK != null) {
        this.fOK.vW(true).vX(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */