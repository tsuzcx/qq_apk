package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange
{
  protected long Qtd;
  protected PreferenceTitleCategory RxY;
  protected PreferenceTitleCategory RxZ;
  protected String Rya;
  private boolean Ryb;
  protected ContactListExpandPreference.a Ryc;
  protected ContactListExpandPreference lzX;
  protected String md5;
  protected int scene;
  protected com.tencent.mm.ui.base.preference.f screen;
  protected com.tencent.mm.ui.base.w tipDialog;
  protected List<String> xtu;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(99180);
    this.tipDialog = null;
    this.xtu = new ArrayList();
    this.Rya = "";
    this.md5 = "";
    this.Ryb = false;
    this.scene = 0;
    this.Ryc = new ContactListExpandPreference.a()
    {
      public final void aMI()
      {
        AppMethodBeat.i(99179);
        if (SnsTagDetailUI.this.lzX != null) {
          SnsTagDetailUI.this.lzX.iLt();
        }
        AppMethodBeat.o(99179);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(307695);
        paramAnonymousViewGroup = SnsTagDetailUI.this.lzX.awu(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        if (SnsTagDetailUI.this.Qtd == 4L) {
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
        }
        for (;;)
        {
          a.pFn.c(localIntent, SnsTagDetailUI.this);
          AppMethodBeat.o(307695);
          return;
          if (SnsTagDetailUI.this.Qtd == 5L) {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
          }
        }
      }
      
      public final void qw(int paramAnonymousInt)
      {
        AppMethodBeat.i(99176);
        String str = SnsTagDetailUI.this.lzX.awu(paramAnonymousInt);
        Log.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        com.tencent.mm.kernel.h.baF();
        if (Util.nullAs((String)com.tencent.mm.kernel.h.baE().ban().d(2, null), "").equals(str))
        {
          k.s(SnsTagDetailUI.this.getContext(), b.j.room_delete_self_tip, b.j.app_tip);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.Dk(str);
        if (((SnsTagDetailUI.this.Rya + " " + Util.listToString(SnsTagDetailUI.this.xtu, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.Qtd != 0L))
        {
          SnsTagDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(99176);
      }
      
      public final void qx(int paramAnonymousInt)
      {
        AppMethodBeat.i(99177);
        Log.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        SnsTagDetailUI.a(SnsTagDetailUI.this);
        AppMethodBeat.o(99177);
      }
    };
    AppMethodBeat.o(99180);
  }
  
  private void hps()
  {
    AppMethodBeat.i(99188);
    Preference localPreference = this.screen.bAi("settings_tag_name");
    if (localPreference != null)
    {
      if (this.Rya.length() > 20) {
        this.Rya = this.Rya.substring(0, 20);
      }
      localPreference.aS(this.Rya);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(99188);
  }
  
  protected void Dk(String paramString)
  {
    AppMethodBeat.i(99194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(99194);
      return;
    }
    this.xtu.remove(paramString);
    if (this.lzX != null)
    {
      this.lzX.iM(this.xtu);
      this.lzX.notifyChanged();
    }
    if ((this.xtu.size() == 0) && (this.lzX != null))
    {
      this.lzX.iLt();
      this.lzX.JJ(true).JK(false);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      aMl();
      AppMethodBeat.o(99194);
      return;
      if (this.lzX != null) {
        this.lzX.JJ(true).JK(true);
      }
    }
  }
  
  protected final void aMl()
  {
    AppMethodBeat.i(99187);
    setMMTitle(this.Rya + "(" + this.xtu.size() + ")");
    AppMethodBeat.o(99187);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99191);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5)) && (this.Qtd != 0L)) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(99191);
        return true;
        k.a(this, b.j.sns_tag_cancel, b.j.app_tip, new DialogInterface.OnClickListener()
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
  
  protected void fVt()
  {
    AppMethodBeat.i(99192);
    if (((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5)) && (this.Qtd != 0L))
    {
      finish();
      AppMethodBeat.o(99192);
      return;
    }
    if (al.hgI().ah(this.Qtd, this.Rya))
    {
      k.c(this, getString(b.j.sns_tag_exist, new Object[] { this.Rya }), getString(b.j.app_tip), true);
      AppMethodBeat.o(99192);
      return;
    }
    final x localx = new x(3, this.Qtd, this.Rya, this.xtu.size(), this.xtu, this.scene);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(localx, 0);
    getString(b.j.app_tip);
    this.tipDialog = k.a(this, getString(b.j.sns_tag_save), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99175);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(localx);
        AppMethodBeat.o(99175);
      }
    });
    AppMethodBeat.o(99192);
  }
  
  public int getResourceId()
  {
    return b.m.tag_detail_pref;
  }
  
  protected void hoi()
  {
    AppMethodBeat.i(99181);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(290, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(293, this);
    com.tencent.mm.kernel.h.baF();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add(this);
    if (al.hgI().hlo().size() == 0)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.sns.model.w(1), 0);
      this.Ryb = true;
    }
    AppMethodBeat.o(99181);
  }
  
  protected void hoj()
  {
    AppMethodBeat.i(99183);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(290, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(293, this);
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.kernel.h.baF();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove(this);
    }
    AppMethodBeat.o(99183);
  }
  
  protected void hok()
  {
    AppMethodBeat.i(99189);
    if (this.Qtd != 0L)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new y(this.Qtd, this.Rya), 0);
    }
    getString(b.j.app_tip);
    this.tipDialog = k.a(this, getString(b.j.sns_tag_save), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(99189);
  }
  
  protected List<String> hom()
  {
    AppMethodBeat.i(99193);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.plugin.sns.storage.ac localac = al.hgI().vl(this.Qtd);
    Object localObject = localac;
    if (localac == null) {
      localObject = new com.tencent.mm.plugin.sns.storage.ac();
    }
    if ((((com.tencent.mm.plugin.sns.storage.ac)localObject).field_memberList != null) && (!((com.tencent.mm.plugin.sns.storage.ac)localObject).field_memberList.equals(""))) {}
    for (localObject = Util.stringsToList(((com.tencent.mm.plugin.sns.storage.ac)localObject).field_memberList.split(","));; localObject = localLinkedList)
    {
      AppMethodBeat.o(99193);
      return localObject;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(99190);
    this.screen = getPreferenceScreen();
    this.lzX = ((ContactListExpandPreference)this.screen.bAi("roominfo_contact_anchor"));
    if (this.lzX != null)
    {
      this.lzX.a(this.screen, this.lzX.mKey);
      this.lzX.JJ(true).JK(true);
      this.lzX.y(null, this.xtu);
      this.lzX.a(new s.b()
      {
        public final boolean qy(int paramAnonymousInt)
        {
          AppMethodBeat.i(99170);
          if (!SnsTagDetailUI.this.lzX.awr(paramAnonymousInt)) {
            Log.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(99170);
          return true;
        }
      });
      this.lzX.a(this.Ryc);
    }
    if (com.tencent.mm.plugin.textstatus.a.ac.hFS())
    {
      this.RxY = ((PreferenceTitleCategory)this.screen.bAi("outside"));
      if (this.RxY != null) {
        this.RxY.setTitle(b.j.sns_tag_name_tip_with_status);
      }
      this.RxZ = ((PreferenceTitleCategory)this.screen.bAi("black"));
      if (this.RxZ != null) {
        this.RxZ.setTitle(b.j.sns_tag_name_black_tip_with_status);
      }
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99172);
        if (((SnsTagDetailUI.this.Rya + " " + Util.listToString(SnsTagDetailUI.this.xtu, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.Qtd != 0L))
        {
          SnsTagDetailUI.this.finish();
          AppMethodBeat.o(99172);
          return true;
        }
        k.a(SnsTagDetailUI.this, b.j.sns_tag_cancel, b.j.app_tip, new DialogInterface.OnClickListener()
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
    addTextOptionMenu(0, getString(b.j.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99173);
        SnsTagDetailUI.this.fVt();
        AppMethodBeat.o(99173);
        return true;
      }
    }, null, y.b.adEJ);
    AppMethodBeat.o(99190);
  }
  
  protected void kM(List<String> paramList)
  {
    AppMethodBeat.i(99195);
    bx localbx = al.hgp();
    String str1 = z.bAM();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.xtu.contains(str2)) && (localbx.JE(str2) != null) && (d.rs(localbx.JE(str2).field_type)) && (!str1.equals(str2))) {
        this.xtu.add(str2);
      }
    }
    if (this.lzX != null)
    {
      this.lzX.iM(this.xtu);
      this.lzX.notifyChanged();
    }
    if (this.xtu.size() > 0) {
      this.lzX.JJ(true).JK(true);
    }
    for (;;)
    {
      aMl();
      AppMethodBeat.o(99195);
      return;
      this.lzX.JJ(true).JK(false);
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
      if (Util.nullAsNil(z.bAM()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        k.c(this, getString(b.j.add_room_mem_memberExits, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(b.j.app_tip), true);
        AppMethodBeat.o(99196);
        return;
        if (this.xtu == null)
        {
          paramInt2 = 0;
        }
        else
        {
          Iterator localIterator = this.xtu.iterator();
          paramInt1 = 0;
          paramInt2 = paramInt1;
          if (localIterator.hasNext())
          {
            if (!((String)localIterator.next()).equals(paramIntent)) {
              break label351;
            }
            paramInt1 = 1;
          }
        }
      }
    }
    label351:
    for (;;)
    {
      break;
      paramIntent = Util.stringsToList(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      kM(paramIntent);
      while (((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5)) && (this.Qtd != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.Rya = paramIntent;
        }
        aMl();
        Log.d("MicroMsg.SnsTagDetailUI", "updateName " + this.Rya);
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
    hoi();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.Qtd = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.Qtd == 4L) {
      this.Rya = getString(b.j.sns_tag_outsiders);
    }
    while (this.Qtd == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.Rya = Util.nullAs(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = al.hgp();
      String str1 = z.bAM();
      localObject = Util.stringsToList(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.xtu.contains(str2)) && (d.rs(paramBundle.JE(str2).field_type)) && (!str1.equals(str2))) {
          this.xtu.add(str2);
        }
      }
      if (this.Qtd == 5L) {
        this.Rya = getString(b.j.sns_tag_snsblack);
      } else {
        this.Rya = al.hgI().vl(this.Qtd).field_tagName;
      }
    }
    this.xtu = hom();
    label263:
    if ((this.Rya == null) || (this.Rya.equals("")))
    {
      this.Rya = getString(b.j.sns_tag_name_unknow);
      this.Rya = ap.aYw(getString(b.j.sns_tag_name_unknow));
    }
    initView();
    hps();
    aMl();
    if (this.Qtd < 6L)
    {
      this.screen.bAk("delete_tag_name");
      this.screen.bAk("delete_tag_name_category");
      if (this.Qtd > 0L)
      {
        this.screen.bAk("settings_tag_name");
        this.screen.bAk("settings_tag_name_category");
      }
    }
    if (this.Qtd == 4L)
    {
      this.screen.bAk("black");
      this.screen.bAk("group");
      if (this.Qtd != 0L) {
        break label556;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
      AppMethodBeat.o(99182);
      return;
      if (this.Qtd == 5L)
      {
        this.screen.bAk("outside");
        this.screen.bAk("group");
        break;
      }
      this.screen.bAk("black");
      this.screen.bAk("outside");
      break;
      label556:
      enableOptionMenu(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99184);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    hoj();
    super.onDestroy();
    AppMethodBeat.o(99184);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(99186);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.Qtd >= 6L) || (this.Qtd == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", Util.nullAs(this.Rya, " "));
      a.pFn.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      k.a(this, b.j.set_tag_del_cmd, b.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99169);
          SnsTagDetailUI.this.hok();
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
    hps();
    AppMethodBeat.o(99185);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(99197);
    Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramp.getType())
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
      if ((this.lzX != null) && (this.Ryb) && (!(this instanceof SnsBlackDetailUI)))
      {
        Log.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (com.tencent.mm.plugin.sns.model.w)paramp;
        paramp = new ArrayList();
        if (!Util.isNullOrNil(paramString.uO(this.Qtd)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.uO(this.Qtd).size())
          {
            String str = (String)paramString.uO(this.Qtd).get(paramInt1);
            if (str != null) {
              paramp.add(str);
            }
            paramInt1 += 1;
          }
        }
        this.md5 = (this.Rya + " " + Util.listToString(paramp, ","));
        new LinkedList();
        paramString = this.xtu;
        this.xtu = hom();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramp = (String)paramString.next();
            if (!this.xtu.contains(paramp)) {
              this.xtu.add(paramp);
            }
          }
        }
        this.lzX.iM(this.xtu);
        this.lzX.notifyChanged();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */