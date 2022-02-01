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
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
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
  implements com.tencent.mm.al.f, n.b
{
  protected String Ajp;
  private boolean Ajq;
  protected ContactListExpandPreference.a Ajr;
  protected ContactListExpandPreference fMC;
  protected String md5;
  protected List<String> ppT;
  protected int scene;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected p tipDialog;
  protected long zid;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(99180);
    this.tipDialog = null;
    this.ppT = new ArrayList();
    this.Ajp = "";
    this.md5 = "";
    this.Ajq = false;
    this.scene = 0;
    this.Ajr = new ContactListExpandPreference.a()
    {
      public final void YJ()
      {
        AppMethodBeat.i(99179);
        if (SnsTagDetailUI.this.fMC != null) {
          SnsTagDetailUI.this.fMC.fcH();
        }
        AppMethodBeat.o(99179);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(198398);
        paramAnonymousViewGroup = SnsTagDetailUI.this.fMC.YX(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        if (SnsTagDetailUI.this.zid == 4L) {
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.c.a.iRG.c(localIntent, SnsTagDetailUI.this);
          AppMethodBeat.o(198398);
          return;
          if (SnsTagDetailUI.this.zid == 5L) {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
          }
        }
      }
      
      public final void lc(int paramAnonymousInt)
      {
        AppMethodBeat.i(99176);
        String str = SnsTagDetailUI.this.fMC.YX(paramAnonymousInt);
        ad.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        g.ajD();
        if (bt.bI((String)g.ajC().ajl().get(2, null), "").equals(str))
        {
          h.l(SnsTagDetailUI.this.getContext(), 2131762613, 2131755906);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.uZ(str);
        if (((SnsTagDetailUI.this.Ajp + " " + bt.m(SnsTagDetailUI.this.ppT, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.zid != 0L))
        {
          SnsTagDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(99176);
      }
      
      public final void ld(int paramAnonymousInt)
      {
        AppMethodBeat.i(99177);
        ad.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        SnsTagDetailUI.a(SnsTagDetailUI.this);
        AppMethodBeat.o(99177);
      }
    };
    AppMethodBeat.o(99180);
  }
  
  private void ecE()
  {
    AppMethodBeat.i(99188);
    Preference localPreference = this.screen.aVD("settings_tag_name");
    if (localPreference != null)
    {
      if (this.Ajp.length() > 20) {
        this.Ajp = this.Ajp.substring(0, 20);
      }
      localPreference.setSummary(this.Ajp);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(99188);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
  
  protected void dgV()
  {
    AppMethodBeat.i(99192);
    if (((this.Ajp + " " + bt.m(this.ppT, ",")).equals(this.md5)) && (this.zid != 0L))
    {
      finish();
      AppMethodBeat.o(99192);
      return;
    }
    if (ag.dUk().D(this.zid, this.Ajp))
    {
      h.c(this, getString(2131763994, new Object[] { this.Ajp }), getString(2131755906), true);
      AppMethodBeat.o(99192);
      return;
    }
    final com.tencent.mm.plugin.sns.model.v localv = new com.tencent.mm.plugin.sns.model.v(3, this.zid, this.Ajp, this.ppT.size(), this.ppT, this.scene);
    g.ajD();
    g.ajB().gAO.a(localv, 0);
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99175);
        g.ajD();
        g.ajB().gAO.a(localv);
        AppMethodBeat.o(99175);
      }
    });
    AppMethodBeat.o(99192);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99191);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.Ajp + " " + bt.m(this.ppT, ",")).equals(this.md5)) && (this.zid != 0L)) {
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
  
  protected void ebC()
  {
    AppMethodBeat.i(99181);
    ad.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    g.ajD();
    g.ajB().gAO.a(290, this);
    g.ajD();
    g.ajB().gAO.a(291, this);
    g.ajD();
    g.ajB().gAO.a(292, this);
    g.ajD();
    g.ajB().gAO.a(293, this);
    g.ajD();
    ((l)g.ab(l.class)).azp().a(this);
    if (ag.dUk().dZo().size() == 0)
    {
      g.ajD();
      g.ajB().gAO.a(new com.tencent.mm.plugin.sns.model.u(1), 0);
      this.Ajq = true;
    }
    AppMethodBeat.o(99181);
  }
  
  protected void ebD()
  {
    AppMethodBeat.i(99183);
    ad.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    g.ajD();
    g.ajB().gAO.b(290, this);
    g.ajD();
    g.ajB().gAO.b(291, this);
    g.ajD();
    g.ajB().gAO.b(292, this);
    g.ajD();
    g.ajB().gAO.b(293, this);
    g.ajD();
    if (g.ajA().aiK())
    {
      g.ajD();
      ((l)g.ab(l.class)).azp().b(this);
    }
    AppMethodBeat.o(99183);
  }
  
  protected void ebE()
  {
    AppMethodBeat.i(99189);
    if (this.zid != 0L)
    {
      g.ajD();
      g.ajB().gAO.a(new com.tencent.mm.plugin.sns.model.w(this.zid, this.Ajp), 0);
    }
    getString(2131755906);
    this.tipDialog = h.b(this, getString(2131764013), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(99189);
  }
  
  protected List<String> ebG()
  {
    AppMethodBeat.i(99193);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.plugin.sns.storage.v localv = ag.dUk().Ak(this.zid);
    Object localObject = localLinkedList;
    if (localv.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!localv.field_memberList.equals("")) {
        localObject = bt.U(localv.field_memberList.split(","));
      }
    }
    AppMethodBeat.o(99193);
    return localObject;
  }
  
  protected void fW(List<String> paramList)
  {
    AppMethodBeat.i(99195);
    bp localbp = ag.dTS();
    String str1 = com.tencent.mm.model.u.aAm();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.ppT.contains(str2)) && (com.tencent.mm.o.b.lM(localbp.Bf(str2).field_type)) && (!str1.equals(str2))) {
        this.ppT.add(str2);
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
      updateTitle();
      AppMethodBeat.o(99195);
      return;
      this.fMC.vO(true).vP(false);
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
          AppMethodBeat.i(99170);
          if (!SnsTagDetailUI.this.fMC.YU(paramAnonymousInt)) {
            ad.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(99170);
          return true;
        }
      });
      this.fMC.a(this.Ajr);
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99172);
        if (((SnsTagDetailUI.this.Ajp + " " + bt.m(SnsTagDetailUI.this.ppT, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.zid != 0L))
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
        SnsTagDetailUI.this.dgV();
        AppMethodBeat.o(99173);
        return true;
      }
    }, null, com.tencent.mm.ui.s.b.JbS);
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
      if (bt.nullAsNil(com.tencent.mm.model.u.aAm()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        h.c(this, getString(2131755154, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(2131755906), true);
        AppMethodBeat.o(99196);
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
      paramIntent = bt.U(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      fW(paramIntent);
      while (((this.Ajp + " " + bt.m(this.ppT, ",")).equals(this.md5)) && (this.zid != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.Ajp = paramIntent;
        }
        updateTitle();
        ad.d("MicroMsg.SnsTagDetailUI", "updateName " + this.Ajp);
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
    ebC();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.zid = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.zid == 4L) {
      this.Ajp = getString(2131764005);
    }
    while (this.zid == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.Ajp = bt.bI(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = ag.dTS();
      String str1 = com.tencent.mm.model.u.aAm();
      localObject = bt.U(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.ppT.contains(str2)) && (com.tencent.mm.o.b.lM(paramBundle.Bf(str2).field_type)) && (!str1.equals(str2))) {
          this.ppT.add(str2);
        }
      }
      if (this.zid == 5L) {
        this.Ajp = getString(2131764017);
      } else {
        this.Ajp = ag.dUk().Ak(this.zid).field_tagName;
      }
    }
    this.ppT = ebG();
    label263:
    if ((this.Ajp == null) || (this.Ajp.equals("")))
    {
      this.Ajp = getString(2131764004);
      this.Ajp = ak.ayY(getString(2131764004));
    }
    initView();
    ecE();
    updateTitle();
    if (this.zid < 6L)
    {
      this.screen.aVE("delete_tag_name");
      this.screen.aVE("delete_tag_name_category");
      if (this.zid > 0L)
      {
        this.screen.aVE("settings_tag_name");
        this.screen.aVE("settings_tag_name_category");
      }
    }
    if (this.zid == 4L)
    {
      this.screen.aVE("black");
      this.screen.aVE("group");
      if (this.zid != 0L) {
        break label555;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.Ajp + " " + bt.m(this.ppT, ","));
      AppMethodBeat.o(99182);
      return;
      if (this.zid == 5L)
      {
        this.screen.aVE("outside");
        this.screen.aVE("group");
        break;
      }
      this.screen.aVE("black");
      this.screen.aVE("outside");
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
    ebD();
    super.onDestroy();
    AppMethodBeat.o(99184);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(99186);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.zid >= 6L) || (this.zid == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", bt.bI(this.Ajp, " "));
      com.tencent.mm.plugin.sns.c.a.iRG.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      h.a(this, 2131763091, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99169);
          SnsTagDetailUI.this.ebE();
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
    ecE();
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
      if ((this.fMC != null) && (this.Ajq) && (!(this instanceof SnsBlackDetailUI)))
      {
        ad.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (com.tencent.mm.plugin.sns.model.u)paramn;
        paramn = new ArrayList();
        if (!bt.hj(paramString.zL(this.zid)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.zL(this.zid).size())
          {
            String str = (String)paramString.zL(this.zid).get(paramInt1);
            if (str != null) {
              paramn.add(str);
            }
            paramInt1 += 1;
          }
        }
        this.md5 = (this.Ajp + " " + bt.m(paramn, ","));
        new LinkedList();
        paramString = this.ppT;
        this.ppT = ebG();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramn = (String)paramString.next();
            if (!this.ppT.contains(paramn)) {
              this.ppT.add(paramn);
            }
          }
        }
        this.fMC.eo(this.ppT);
        this.fMC.notifyChanged();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void uZ(String paramString)
  {
    AppMethodBeat.i(99194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(99194);
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
      updateTitle();
      AppMethodBeat.o(99194);
      return;
      if (this.fMC != null) {
        this.fMC.vO(true).vP(true);
      }
    }
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(99187);
    setMMTitle(this.Ajp + "(" + this.ppT.size() + ")");
    AppMethodBeat.o(99187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */