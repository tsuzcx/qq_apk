package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends ContactMgrUIBase
{
  private String TTU;
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(270008);
    paramo = new a(paramo);
    AppMethodBeat.o(270008);
    return paramo;
  }
  
  public final void awS(int paramInt)
  {
    AppMethodBeat.i(270010);
    Object localObject = this.Xyt.awM(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(270010);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    com.tencent.mm.by.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(270010);
  }
  
  public final void bH(Intent paramIntent)
  {
    AppMethodBeat.i(270015);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.SportBlackListUI", "onAddContact before userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.unc });
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(270015);
      return;
    }
    Object localObject = Util.stringsToList(paramIntent.split(","));
    if (localObject == null)
    {
      AppMethodBeat.o(270015);
      return;
    }
    String str1 = z.bcZ();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str2 = (String)((Iterator)localObject).next();
      if ((!this.unc.contains(str2)) && (!str1.equals(str2)))
      {
        this.unc.add(str2);
        bh.beI();
        ab.r(com.tencent.mm.model.c.bbL().RG(str2));
      }
    }
    this.Xyw = true;
    Log.i("MicroMsg.SportBlackListUI", "onAddContact after userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.unc });
    getResources().getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getResources().getString(R.l.eng), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    hVE();
    AppMethodBeat.o(270015);
  }
  
  public final void bI(Intent paramIntent)
  {
    AppMethodBeat.i(270017);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.SportBlackListUI", "onRemoveContact before userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.unc });
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(270017);
      return;
    }
    Object localObject = Util.stringsToList(paramIntent.split(","));
    if (localObject == null)
    {
      AppMethodBeat.o(270017);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!Util.isNullOrNil(str))
      {
        this.unc.remove(str);
        bh.beI();
        ab.s(com.tencent.mm.model.c.bbL().RG(str));
        d.rE(40);
      }
    }
    this.Xyx = true;
    hVE();
    getResources().getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getResources().getString(R.l.enk), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    Log.i("MicroMsg.SportBlackListUI", "onRemoveContact after userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.unc });
    AppMethodBeat.o(270017);
  }
  
  protected final void hVA()
  {
    AppMethodBeat.i(270006);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    localIntent.putExtra("filter_type", "@werun.black.android");
    localIntent.putExtra("titile", getResources().getString(R.l.ePd));
    bJ(localIntent);
    startActivityForResult(localIntent, 2);
    AppMethodBeat.o(270006);
  }
  
  protected final void hVB()
  {
    AppMethodBeat.i(270007);
    String str = Util.listToString(this.unc, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.ePa));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("list_attr", w.XtK);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    localIntent.putExtra("always_select_contact", str);
    com.tencent.mm.by.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
    AppMethodBeat.o(270007);
  }
  
  protected final void hVG()
  {
    AppMethodBeat.i(270018);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.Xyx)
    {
      this.Xyx = false;
      Toast.makeText(this, getResources().getString(R.l.ens), 0).show();
    }
    if (this.Xyw)
    {
      this.Xyw = false;
      Toast.makeText(this, getResources().getString(R.l.enp), 0).show();
    }
    AppMethodBeat.o(270018);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270005);
    super.onCreate(paramBundle);
    d.rE(39);
    if (this.unc == null) {
      this.unc = new ArrayList();
    }
    com.tencent.mm.kernel.h.aHH();
    paramBundle = Util.nullAs((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null), "");
    bh.beI();
    Cursor localCursor = com.tencent.mm.model.c.bbL().f("@werun.black.android", "", null);
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      if (paramBundle.equals(str))
      {
        bh.beI();
        ab.s(com.tencent.mm.model.c.bbL().RG(str));
      }
      else
      {
        this.unc.add(str);
      }
    }
    localCursor.close();
    this.TTU = getString(R.l.ePq);
    setMMTitle(this.TTU);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(261490);
        SportBlackListUI.this.finish();
        AppMethodBeat.o(261490);
        return false;
      }
    });
    this.Xyv = getString(R.l.ePp);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(681, this);
    hVD();
    AppMethodBeat.o(270005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(270019);
    super.onDestroy();
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(681, this);
    AppMethodBeat.o(270019);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(270011);
    Log.i("MicroMsg.SportBlackListUI", "onNotifyChange, event: %s, stg: %s, obj: %s.", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
    if (paramInt == 4) {
      hVE();
    }
    AppMethodBeat.o(270011);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(270016);
    if ((this.Xyt != null) && (this.Xyt.getContactCount() > 0))
    {
      setMMTitle(this.TTU + "(" + this.Xyt.getContactCount() + ")");
      AppMethodBeat.o(270016);
      return;
    }
    setMMTitle(this.TTU);
    AppMethodBeat.o(270016);
  }
  
  final class a
    extends ContactMgrUIBase.a
  {
    public a(o paramo)
    {
      super(paramo);
    }
    
    public final String hVC()
    {
      return "@werun.black.android";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.SportBlackListUI
 * JD-Core Version:    0.7.0.1
 */