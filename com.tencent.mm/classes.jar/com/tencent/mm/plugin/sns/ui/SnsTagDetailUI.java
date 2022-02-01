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
import com.tencent.mm.ak.i;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.textstatus.a.p;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends MMPreference
  implements i, MStorageEx.IOnStorageChange
{
  protected long DJc;
  protected String EJW;
  private boolean EJX;
  protected ContactListExpandPreference.a EJY;
  protected PreferenceTitleCategory UrA;
  protected PreferenceTitleCategory UrB;
  protected ContactListExpandPreference gtU;
  protected String md5;
  protected List<String> qLQ;
  protected int scene;
  protected f screen;
  protected com.tencent.mm.ui.base.q tipDialog;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(99180);
    this.tipDialog = null;
    this.qLQ = new ArrayList();
    this.EJW = "";
    this.md5 = "";
    this.EJX = false;
    this.scene = 0;
    this.EJY = new ContactListExpandPreference.a()
    {
      public final void amF()
      {
        AppMethodBeat.i(99179);
        if (SnsTagDetailUI.this.gtU != null) {
          SnsTagDetailUI.this.gtU.gpE();
        }
        AppMethodBeat.o(99179);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(203657);
        paramAnonymousViewGroup = SnsTagDetailUI.this.gtU.aio(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        if (SnsTagDetailUI.this.DJc == 4L) {
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.c.a.jRt.c(localIntent, SnsTagDetailUI.this);
          AppMethodBeat.o(203657);
          return;
          if (SnsTagDetailUI.this.DJc == 5L) {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
          }
        }
      }
      
      public final void og(int paramAnonymousInt)
      {
        AppMethodBeat.i(99176);
        String str = SnsTagDetailUI.this.gtU.aio(paramAnonymousInt);
        Log.d("MicroMsg.SnsTagDetailUI", "roomPref del " + paramAnonymousInt + " userName : " + str);
        g.aAi();
        if (Util.nullAs((String)g.aAh().azQ().get(2, null), "").equals(str))
        {
          h.n(SnsTagDetailUI.this.getContext(), 2131764695, 2131755998);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.DM(str);
        if (((SnsTagDetailUI.this.EJW + " " + Util.listToString(SnsTagDetailUI.this.qLQ, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.DJc != 0L))
        {
          SnsTagDetailUI.this.enableOptionMenu(false);
          AppMethodBeat.o(99176);
          return;
        }
        SnsTagDetailUI.this.enableOptionMenu(true);
        AppMethodBeat.o(99176);
      }
      
      public final void oh(int paramAnonymousInt)
      {
        AppMethodBeat.i(99177);
        Log.d("MicroMsg.SnsTagDetailUI", "roomPref add ".concat(String.valueOf(paramAnonymousInt)));
        SnsTagDetailUI.a(SnsTagDetailUI.this);
        AppMethodBeat.o(99177);
      }
    };
    AppMethodBeat.o(99180);
  }
  
  private void fiL()
  {
    AppMethodBeat.i(99188);
    Preference localPreference = this.screen.bmg("settings_tag_name");
    if (localPreference != null)
    {
      if (this.EJW.length() > 20) {
        this.EJW = this.EJW.substring(0, 20);
      }
      localPreference.setSummary(this.EJW);
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(99188);
  }
  
  protected void DM(String paramString)
  {
    AppMethodBeat.i(99194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(99194);
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
      updateTitle();
      AppMethodBeat.o(99194);
      return;
      if (this.gtU != null) {
        this.gtU.zU(true).zV(true);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99191);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5)) && (this.DJc != 0L)) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(99191);
        return true;
        h.a(this, 2131766227, 2131755998, new DialogInterface.OnClickListener()
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
  
  protected void edF()
  {
    AppMethodBeat.i(99192);
    if (((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5)) && (this.DJc != 0L))
    {
      finish();
      AppMethodBeat.o(99192);
      return;
    }
    if (aj.faU().K(this.DJc, this.EJW))
    {
      h.c(this, getString(2131766232, new Object[] { this.EJW }), getString(2131755998), true);
      AppMethodBeat.o(99192);
      return;
    }
    final x localx = new x(3, this.DJc, this.EJW, this.qLQ.size(), this.qLQ, this.scene);
    g.aAi();
    g.aAg().hqi.a(localx, 0);
    getString(2131755998);
    this.tipDialog = h.a(this, getString(2131766251), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99175);
        g.aAi();
        g.aAg().hqi.a(localx);
        AppMethodBeat.o(99175);
      }
    });
    AppMethodBeat.o(99192);
  }
  
  protected void fhH()
  {
    AppMethodBeat.i(99181);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    g.aAi();
    g.aAg().hqi.a(290, this);
    g.aAi();
    g.aAg().hqi.a(291, this);
    g.aAi();
    g.aAg().hqi.a(292, this);
    g.aAi();
    g.aAg().hqi.a(293, this);
    g.aAi();
    ((l)g.af(l.class)).aSN().add(this);
    if (aj.faU().ffg().size() == 0)
    {
      g.aAi();
      g.aAg().hqi.a(new w(1), 0);
      this.EJX = true;
    }
    AppMethodBeat.o(99181);
  }
  
  protected void fhI()
  {
    AppMethodBeat.i(99183);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
    g.aAi();
    g.aAg().hqi.b(290, this);
    g.aAi();
    g.aAg().hqi.b(291, this);
    g.aAi();
    g.aAg().hqi.b(292, this);
    g.aAi();
    g.aAg().hqi.b(293, this);
    g.aAi();
    if (g.aAf().azp())
    {
      g.aAi();
      ((l)g.af(l.class)).aSN().remove(this);
    }
    AppMethodBeat.o(99183);
  }
  
  protected void fhJ()
  {
    AppMethodBeat.i(99189);
    if (this.DJc != 0L)
    {
      g.aAi();
      g.aAg().hqi.a(new y(this.DJc, this.EJW), 0);
    }
    getString(2131755998);
    this.tipDialog = h.a(this, getString(2131766251), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(99189);
  }
  
  protected List<String> fhL()
  {
    AppMethodBeat.i(99193);
    LinkedList localLinkedList = new LinkedList();
    s locals = aj.faU().JL(this.DJc);
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
    return 2132017294;
  }
  
  protected void hc(List<String> paramList)
  {
    AppMethodBeat.i(99195);
    bv localbv = aj.faC();
    String str1 = z.aTY();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.qLQ.contains(str2)) && (c.oR(localbv.Kn(str2).field_type)) && (!str1.equals(str2))) {
        this.qLQ.add(str2);
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
      updateTitle();
      AppMethodBeat.o(99195);
      return;
      this.gtU.zU(true).zV(false);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(99190);
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
          AppMethodBeat.i(99170);
          if (!SnsTagDetailUI.this.gtU.ail(paramAnonymousInt)) {
            Log.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramAnonymousInt)));
          }
          AppMethodBeat.o(99170);
          return true;
        }
      });
      this.gtU.a(this.EJY);
    }
    if (p.fvC())
    {
      this.UrA = ((PreferenceTitleCategory)this.screen.bmg("outside"));
      if (this.UrA != null) {
        this.UrA.setTitle(2131767298);
      }
      this.UrB = ((PreferenceTitleCategory)this.screen.bmg("black"));
      if (this.UrB != null) {
        this.UrB.setTitle(2131767243);
      }
    }
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99172);
        if (((SnsTagDetailUI.this.EJW + " " + Util.listToString(SnsTagDetailUI.this.qLQ, ",")).equals(SnsTagDetailUI.this.md5)) && (SnsTagDetailUI.this.DJc != 0L))
        {
          SnsTagDetailUI.this.finish();
          AppMethodBeat.o(99172);
          return true;
        }
        h.a(SnsTagDetailUI.this, 2131766227, 2131755998, new DialogInterface.OnClickListener()
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
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99173);
        SnsTagDetailUI.this.edF();
        AppMethodBeat.o(99173);
        return true;
      }
    }, null, t.b.OGU);
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
      if (Util.nullAsNil(z.aTY()).equals(paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        h.c(this, getString(2131755172, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }), getString(2131755998), true);
        AppMethodBeat.o(99196);
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
      paramIntent = Util.stringsToList(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99196);
        return;
      }
      hc(paramIntent);
      while (((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5)) && (this.DJc != 0L))
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99196);
        return;
        paramIntent = paramIntent.getStringExtra("k_sns_tag_name");
        if (paramIntent != null) {
          this.EJW = paramIntent;
        }
        updateTitle();
        Log.d("MicroMsg.SnsTagDetailUI", "updateName " + this.EJW);
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
    fhH();
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    this.DJc = getIntent().getLongExtra("k_sns_tag_id", 0L);
    if (this.DJc == 4L) {
      this.EJW = getString(2131766243);
    }
    while (this.DJc == 0L)
    {
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.EJW = Util.nullAs(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = aj.faC();
      String str1 = z.aTY();
      localObject = Util.stringsToList(((String)localObject).split(","));
      if (localObject == null) {
        break label263;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.qLQ.contains(str2)) && (c.oR(paramBundle.Kn(str2).field_type)) && (!str1.equals(str2))) {
          this.qLQ.add(str2);
        }
      }
      if (this.DJc == 5L) {
        this.EJW = getString(2131766255);
      } else {
        this.EJW = aj.faU().JL(this.DJc).field_tagName;
      }
    }
    this.qLQ = fhL();
    label263:
    if ((this.EJW == null) || (this.EJW.equals("")))
    {
      this.EJW = getString(2131766242);
      this.EJW = an.aPl(getString(2131766242));
    }
    initView();
    fiL();
    updateTitle();
    if (this.DJc < 6L)
    {
      this.screen.bmi("delete_tag_name");
      this.screen.bmi("delete_tag_name_category");
      if (this.DJc > 0L)
      {
        this.screen.bmi("settings_tag_name");
        this.screen.bmi("settings_tag_name_category");
      }
    }
    if (this.DJc == 4L)
    {
      this.screen.bmi("black");
      this.screen.bmi("group");
      if (this.DJc != 0L) {
        break label555;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.EJW + " " + Util.listToString(this.qLQ, ","));
      AppMethodBeat.o(99182);
      return;
      if (this.DJc == 5L)
      {
        this.screen.bmi("outside");
        this.screen.bmi("group");
        break;
      }
      this.screen.bmi("black");
      this.screen.bmi("outside");
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
    fhI();
    super.onDestroy();
    AppMethodBeat.o(99184);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(99186);
    paramf = paramPreference.mKey;
    if ((paramf.equals("settings_tag_name")) && ((this.DJc >= 6L) || (this.DJc == 0L)))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("Contact_mode_name_type", 3);
      paramPreference.putExtra("Contact_Nick", Util.nullAs(this.EJW, " "));
      com.tencent.mm.plugin.sns.c.a.jRt.a(paramPreference, this);
    }
    if (paramf.equals("delete_tag_name")) {
      h.a(this, 2131765253, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(99169);
          SnsTagDetailUI.this.fhJ();
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
    fiL();
    AppMethodBeat.o(99185);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      if ((this.gtU != null) && (this.EJX) && (!(this instanceof SnsBlackDetailUI)))
      {
        Log.d("MicroMsg.SnsTagDetailUI", "update form net");
        paramString = (w)paramq;
        paramq = new ArrayList();
        if (!Util.isNullOrNil(paramString.Jp(this.DJc)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.Jp(this.DJc).size())
          {
            String str = (String)paramString.Jp(this.DJc).get(paramInt1);
            if (str != null) {
              paramq.add(str);
            }
            paramInt1 += 1;
          }
        }
        this.md5 = (this.EJW + " " + Util.listToString(paramq, ","));
        new LinkedList();
        paramString = this.qLQ;
        this.qLQ = fhL();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramq = (String)paramString.next();
            if (!this.qLQ.contains(paramq)) {
              this.qLQ.add(paramq);
            }
          }
        }
        this.gtU.fm(this.qLQ);
        this.gtU.notifyChanged();
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
    setMMTitle(this.EJW + "(" + this.qLQ.size() + ")");
    AppMethodBeat.o(99187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */