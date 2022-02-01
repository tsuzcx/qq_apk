package com.tencent.mm.ui.contact.privacy;

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
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends ContactMgrUIBase
{
  private String abky;
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(253382);
    paramo = new a(paramo);
    AppMethodBeat.o(253382);
    return paramo;
  }
  
  public final void aDz(int paramInt)
  {
    AppMethodBeat.i(253392);
    Object localObject = this.afkK.aDt(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(253392);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(253392);
  }
  
  protected final void aMl()
  {
    AppMethodBeat.i(253417);
    if ((this.afkK != null) && (this.afkK.getContactCount() > 0))
    {
      setMMTitle(this.abky + "(" + this.afkK.getContactCount() + ")");
      AppMethodBeat.o(253417);
      return;
    }
    setMMTitle(this.abky);
    AppMethodBeat.o(253417);
  }
  
  public final void ck(Intent paramIntent)
  {
    AppMethodBeat.i(253409);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.SportBlackListUI", "onAddContact before userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.xtu });
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(253409);
      return;
    }
    Object localObject = Util.stringsToList(paramIntent.split(","));
    if (localObject == null)
    {
      AppMethodBeat.o(253409);
      return;
    }
    String str1 = z.bAM();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str2 = (String)((Iterator)localObject).next();
      if ((!this.xtu.contains(str2)) && (!str1.equals(str2)))
      {
        this.xtu.add(str2);
        bh.bCz();
        ab.s(com.tencent.mm.model.c.bzA().JE(str2));
      }
    }
    this.afkM = true;
    Log.i("MicroMsg.SportBlackListUI", "onAddContact after userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.xtu });
    getResources().getString(R.l.app_tip);
    this.tipDialog = k.a(this, getResources().getString(R.l.gqh), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    jzA();
    AppMethodBeat.o(253409);
  }
  
  public final void cl(Intent paramIntent)
  {
    AppMethodBeat.i(253425);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.SportBlackListUI", "onRemoveContact before userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.xtu });
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(253425);
      return;
    }
    Object localObject = Util.stringsToList(paramIntent.split(","));
    if (localObject == null)
    {
      AppMethodBeat.o(253425);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!Util.isNullOrNil(str))
      {
        this.xtu.remove(str);
        bh.bCz();
        ab.t(com.tencent.mm.model.c.bzA().JE(str));
        d.rG(40);
      }
    }
    this.afkN = true;
    jzA();
    getResources().getString(R.l.app_tip);
    this.tipDialog = k.a(this, getResources().getString(R.l.gql), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    Log.i("MicroMsg.SportBlackListUI", "onRemoveContact after userNameStr: %s, tagList : %s.", new Object[] { paramIntent, this.xtu });
    AppMethodBeat.o(253425);
  }
  
  protected final void jzC()
  {
    AppMethodBeat.i(253434);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.afkN)
    {
      this.afkN = false;
      Toast.makeText(this, getResources().getString(R.l.gqt), 0).show();
    }
    if (this.afkM)
    {
      this.afkM = false;
      Toast.makeText(this, getResources().getString(R.l.gqq), 0).show();
    }
    AppMethodBeat.o(253434);
  }
  
  protected final void jzw()
  {
    AppMethodBeat.i(253365);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    localIntent.putExtra("filter_type", "@werun.black.android");
    localIntent.putExtra("titile", getResources().getString(R.l.gRF));
    cm(localIntent);
    startActivityForResult(localIntent, 2);
    AppMethodBeat.o(253365);
  }
  
  protected final void jzx()
  {
    AppMethodBeat.i(253371);
    String str = Util.listToString(this.xtu, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.gRC));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.w.affo);
    localIntent.putExtra("show_too_many_member", false);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    localIntent.putExtra("always_select_contact", str);
    com.tencent.mm.br.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
    AppMethodBeat.o(253371);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253349);
    super.onCreate(paramBundle);
    d.rG(39);
    if (this.xtu == null) {
      this.xtu = new ArrayList();
    }
    h.baF();
    paramBundle = Util.nullAs((String)h.baE().ban().d(2, null), "");
    bh.bCz();
    Cursor localCursor = com.tencent.mm.model.c.bzA().h("@werun.black.android", "", null);
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      if (paramBundle.equals(str))
      {
        bh.bCz();
        ab.t(com.tencent.mm.model.c.bzA().JE(str));
      }
      else
      {
        this.xtu.add(str);
      }
    }
    localCursor.close();
    this.abky = getString(R.l.gRS);
    setMMTitle(this.abky);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(253303);
        SportBlackListUI.this.finish();
        AppMethodBeat.o(253303);
        return false;
      }
    });
    this.afkL = getString(R.l.gRR);
    h.baF();
    h.baD().mCm.a(681, this);
    jzz();
    AppMethodBeat.o(253349);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(253441);
    super.onDestroy();
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    h.baF();
    h.baD().mCm.b(681, this);
    AppMethodBeat.o(253441);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(253399);
    Log.i("MicroMsg.SportBlackListUI", "onNotifyChange, event: %s, stg: %s, obj: %s.", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
    if (paramInt == 4) {
      jzA();
    }
    AppMethodBeat.o(253399);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends ContactMgrUIBase.a
  {
    public a(o paramo)
    {
      super(paramo);
    }
    
    public final String jzy()
    {
      return "@werun.black.android";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.SportBlackListUI
 * JD-Core Version:    0.7.0.1
 */