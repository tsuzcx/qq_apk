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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements i, MStorageEx.IOnStorageChange
{
  protected long JWc;
  protected PreferenceTitleCategory KXX;
  protected PreferenceTitleCategory KXY;
  protected String KXZ;
  private boolean KYa;
  protected ContactListExpandPreference.a KYb;
  protected ContactListExpandPreference iYf;
  protected String md5;
  protected int scene;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected com.tencent.mm.ui.base.s tipDialog;
  protected List<String> unc;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(99180);
    this.tipDialog = null;
    this.unc = new ArrayList();
    this.KXZ = "";
    this.md5 = "";
    this.KYa = false;
    this.scene = 0;
    this.KYb = new ContactListExpandPreference.a()
    {
      public final void asG()
      {
        AppMethodBeat.i(99179);
        if (SnsTagDetailUI.this.iYf != null) {
          SnsTagDetailUI.this.iYf.hkC();
        }
        AppMethodBeat.o(99179);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(225660);
        paramAnonymousViewGroup = SnsTagDetailUI.this.iYf.aqq(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        if (SnsTagDetailUI.this.JWc == 4L) {
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
        }
        for (;;)
        {
          a.mIG.c(localIntent, SnsTagDetailUI.this);
          AppMethodBeat.o(225660);
          return;
          if (SnsTagDetailUI.this.JWc == 5L) {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
          }
        }
      }
      
      public final void qv(int paramAnonymousInt)
      {
        AppMethodBeat.i(99176);
        String str = SnsTagDetailUI.this.iYf.aqq(paramAnonymousInt);
        Log.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        com.tencent.mm.kernel.h.aHH();
        if (Util.nullAs((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null), "").equals(str))
        {
          com.tencent.mm.ui.base.h.p(SnsTagDetailUI.this.getContext(), i.j.room_delete_self_tip, i.j.app_tip);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.KE(str);
        if (((SnsTagDetailUI.this.KXZ + " " + Util.listToString(SnsTagDetailUI.this.unc, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.JWc != 0L))
        {
          SnsTagDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(99176);
      }
      
      public final void qw(int paramAnonymousInt)
      {
        AppMethodBeat.i(99177);
        Log.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        SnsTagDetailUI.a(SnsTagDetailUI.this);
        AppMethodBeat.o(99177);
      }
    };
    AppMethodBeat.o(99180);
  }
  
  private void fWZ()
  {
    AppMethodBeat.i(99188);
    Preference localPreference = this.screen.byG("settings_tag_name");
    if (localPreference != null)
    {
      if (this.KXZ.length() > 20) {
        this.KXZ = this.KXZ.substring(0, 20);
      }
      localPreference.aF(this.KXZ);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(99188);
  }
  
  protected void KE(String paramString)
  {
    AppMethodBeat.i(99194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(99194);
      return;
    }
    this.unc.remove(paramString);
    if (this.iYf != null)
    {
      this.iYf.fO(this.unc);
      this.iYf.notifyChanged();
    }
    if ((this.unc.size() == 0) && (this.iYf != null))
    {
      this.iYf.hkC();
      this.iYf.DZ(true).Ea(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      updateTitle();
      AppMethodBeat.o(99194);
      return;
      if (this.iYf != null) {
        this.iYf.DZ(true).Ea(true);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99191);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5)) && (this.JWc != 0L)) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(99191);
        return true;
        com.tencent.mm.ui.base.h.a(this, i.j.sns_tag_cancel, i.j.app_tip, new DialogInterface.OnClickListener()
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
  
  protected void eNa()
  {
    AppMethodBeat.i(99192);
    if (((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5)) && (this.JWc != 0L))
    {
      finish();
      AppMethodBeat.o(99192);
      return;
    }
    if (aj.fOO().S(this.JWc, this.KXZ))
    {
      com.tencent.mm.ui.base.h.c(this, getString(i.j.sns_tag_exist, new Object[] { this.KXZ }), getString(i.j.app_tip), true);
      AppMethodBeat.o(99192);
      return;
    }
    final x localx = new x(3, this.JWc, this.KXZ, this.unc.size(), this.unc, this.scene);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(localx, 0);
    getString(i.j.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(i.j.sns_tag_save), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99175);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(localx);
        AppMethodBeat.o(99175);
      }
    });
    AppMethodBeat.o(99192);
  }
  
  protected void fVU()
  {
    AppMethodBeat.i(99181);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(290, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(291, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(293, this);
    com.tencent.mm.kernel.h.aHH();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(this);
    if (aj.fOO().fTb().size() == 0)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new w(1), 0);
      this.KYa = true;
    }
    AppMethodBeat.o(99181);
  }
  
  protected void fVV()
  {
    AppMethodBeat.i(99183);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(290, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(291, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(293, this);
    com.tencent.mm.kernel.h.aHH();
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this);
    }
    AppMethodBeat.o(99183);
  }
  
  protected void fVW()
  {
    AppMethodBeat.i(99189);
    if (this.JWc != 0L)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new y(this.JWc, this.KXZ), 0);
    }
    getString(i.j.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(i.j.sns_tag_save), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(99189);
  }
  
  protected List<String> fVY()
  {
    AppMethodBeat.i(99193);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.plugin.sns.storage.s locals = aj.fOO().Rf(this.JWc);
    Object localObject = localLinkedList;
    if (locals.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!locals.field_memberList.equals("")) {
        localObject = Util.stringsToList(locals.field_memberList.split(","));
      }
    }
    AppMethodBeat.o(99193);
    return localObject;
  }
  
  public int getResourceId()
  {
    return i.m.tag_detail_pref;
  }
  
  protected void hL(List<String> paramList)
  {
    AppMethodBeat.i(99195);
    bv localbv = aj.fOw();
    String str1 = z.bcZ();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.unc.contains(str2)) && (d.rk(localbv.RG(str2).field_type)) && (!str1.equals(str2))) {
        this.unc.add(str2);
      }
    }
    if (this.iYf != null)
    {
      this.iYf.fO(this.unc);
      this.iYf.notifyChanged();
    }
    if (this.unc.size() > 0) {
      this.iYf.DZ(true).Ea(true);
    }
    for (;;)
    {
      updateTitle();
      AppMethodBeat.o(99195);
      return;
      this.iYf.DZ(true).Ea(false);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(99190);
    this.screen = getPreferenceScreen();
    this.iYf = ((ContactListExpandPreference)this.screen.byG("roominfo_contact_anchor"));
    if (this.iYf != null)
    {
      this.iYf.a(this.screen, this.iYf.mKey);
      this.iYf.DZ(true).Ea(true);
      this.iYf.s(null, this.unc);
      this.iYf.a(new s.b()
      {
        public final boolean qx(int paramAnonymousInt)
        {
          AppMethodBeat.i(99170);
          if (!SnsTagDetailUI.this.iYf.aqn(paramAnonymousInt)) {
            Log.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(99170);
          return true;
        }
      });
      this.iYf.a(this.KYb);
    }
    if (com.tencent.mm.plugin.textstatus.a.t.gkZ())
    {
      this.KXX = ((PreferenceTitleCategory)this.screen.byG("outside"));
      if (this.KXX != null) {
        this.KXX.setTitle(i.j.sns_tag_name_tip_with_status);
      }
      this.KXY = ((PreferenceTitleCategory)this.screen.byG("black"));
      if (this.KXY != null) {
        this.KXY.setTitle(i.j.sns_tag_name_black_tip_with_status);
      }
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99172);
        if (((SnsTagDetailUI.this.KXZ + " " + Util.listToString(SnsTagDetailUI.this.unc, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.JWc != 0L))
        {
          SnsTagDetailUI.this.finish();
          AppMethodBeat.o(99172);
          return true;
        }
        com.tencent.mm.ui.base.h.a(SnsTagDetailUI.this, i.j.sns_tag_cancel, i.j.app_tip, new DialogInterface.OnClickListener()
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
    addTextOptionMenu(0, getString(i.j.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99173);
        SnsTagDetailUI.this.eNa();
        AppMethodBeat.o(99173);
        return true;
      }
    }, null, w.b.Wao);
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
      if (Util.nullAsNil(z.bcZ()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        com.tencent.mm.ui.base.h.c(this, getString(i.j.add_room_mem_memberExits, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(i.j.app_tip), true);
        AppMethodBeat.o(99196);
        return;
        if (this.unc == null)
        {
          paramInt2 = 0;
        }
        else
        {
          Iterator localIterator = this.unc.iterator();
          paramInt1 = 0;
          paramInt2 = paramInt1;
          if (localIterator.hasNext())
          {
            if (!((String)localIterator.next()).equals(paramIntent)) {
              break label350;
            }
            paramInt1 = 1;
          }
        }
      }
    }
    label350:
    for (;;)
    {
      break;
      paramIntent = Util.stringsToList(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      hL(paramIntent);
      while (((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5)) && (this.JWc != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.KXZ = paramIntent;
        }
        updateTitle();
        Log.d("MicroMsg.SnsTagDetailUI", "updateName " + this.KXZ);
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
    fVU();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.JWc = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.JWc == 4L) {
      this.KXZ = getString(i.j.sns_tag_outsiders);
    }
    while (this.JWc == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.KXZ = Util.nullAs(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = aj.fOw();
      String str1 = z.bcZ();
      localObject = Util.stringsToList(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.unc.contains(str2)) && (d.rk(paramBundle.RG(str2).field_type)) && (!str1.equals(str2))) {
          this.unc.add(str2);
        }
      }
      if (this.JWc == 5L) {
        this.KXZ = getString(i.j.sns_tag_snsblack);
      } else {
        this.KXZ = aj.fOO().Rf(this.JWc).field_tagName;
      }
    }
    this.unc = fVY();
    label263:
    if ((this.KXZ == null) || (this.KXZ.equals("")))
    {
      this.KXZ = getString(i.j.sns_tag_name_unknow);
      this.KXZ = an.bag(getString(i.j.sns_tag_name_unknow));
    }
    initView();
    fWZ();
    updateTitle();
    if (this.JWc < 6L)
    {
      this.screen.byI("delete_tag_name");
      this.screen.byI("delete_tag_name_category");
      if (this.JWc > 0L)
      {
        this.screen.byI("settings_tag_name");
        this.screen.byI("settings_tag_name_category");
      }
    }
    if (this.JWc == 4L)
    {
      this.screen.byI("black");
      this.screen.byI("group");
      if (this.JWc != 0L) {
        break label555;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
      AppMethodBeat.o(99182);
      return;
      if (this.JWc == 5L)
      {
        this.screen.byI("outside");
        this.screen.byI("group");
        break;
      }
      this.screen.byI("black");
      this.screen.byI("outside");
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
    fVV();
    super.onDestroy();
    AppMethodBeat.o(99184);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(99186);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.JWc >= 6L) || (this.JWc == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", Util.nullAs(this.KXZ, " "));
      a.mIG.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      com.tencent.mm.ui.base.h.a(this, i.j.set_tag_del_cmd, i.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99169);
          SnsTagDetailUI.this.fVW();
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
    fWZ();
    AppMethodBeat.o(99185);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(99197);
    Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramq.getType())
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
      if ((this.iYf != null) && (this.KYa) && (!(this instanceof SnsBlackDetailUI)))
      {
        Log.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (w)paramq;
        paramq = new ArrayList();
        if (!Util.isNullOrNil(paramString.QI(this.JWc)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.QI(this.JWc).size())
          {
            String str = (String)paramString.QI(this.JWc).get(paramInt1);
            if (str != null) {
              paramq.add(str);
            }
            paramInt1 += 1;
          }
        }
        this.md5 = (this.KXZ + " " + Util.listToString(paramq, ","));
        new LinkedList();
        paramString = this.unc;
        this.unc = fVY();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramq = (String)paramString.next();
            if (!this.unc.contains(paramq)) {
              this.unc.add(paramq);
            }
          }
        }
        this.iYf.fO(this.unc);
        this.iYf.notifyChanged();
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
    setMMTitle(this.KXZ + "(" + this.unc.size() + ")");
    AppMethodBeat.o(99187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */