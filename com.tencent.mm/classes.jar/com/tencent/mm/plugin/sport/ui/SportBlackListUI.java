package com.tencent.mm.plugin.sport.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends MMPreference
{
  private List<String> Lyy;
  private ContactListExpandPreference.a Lyz;
  private ContactListExpandPreference iYf;
  
  public SportBlackListUI()
  {
    AppMethodBeat.i(28816);
    this.Lyz = new ContactListExpandPreference.a()
    {
      public final void asG()
      {
        AppMethodBeat.i(28815);
        SportBlackListUI.a(SportBlackListUI.this).hkC();
        AppMethodBeat.o(28815);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(281164);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).aqq(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.by.c.b(SportBlackListUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(281164);
      }
      
      public final void qv(int paramAnonymousInt)
      {
        AppMethodBeat.i(28812);
        String str = SportBlackListUI.a(SportBlackListUI.this).aqq(paramAnonymousInt);
        if (Util.isNullOrNil(str))
        {
          AppMethodBeat.o(28812);
          return;
        }
        SportBlackListUI.b(SportBlackListUI.this).remove(str);
        SportBlackListUI.a(SportBlackListUI.this).s(null, SportBlackListUI.b(SportBlackListUI.this));
        SportBlackListUI.a(SportBlackListUI.this).bfU();
        bh.beI();
        ab.s(com.tencent.mm.model.c.bbL().RG(str));
        d.rE(40);
        AppMethodBeat.o(28812);
      }
      
      public final void qw(int paramAnonymousInt)
      {
        AppMethodBeat.i(28813);
        SportBlackListUI.c(SportBlackListUI.this);
        AppMethodBeat.o(28813);
      }
    };
    AppMethodBeat.o(28816);
  }
  
  public int getResourceId()
  {
    return R.o.eXR;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(28818);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(28818);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (Util.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(28818);
        return;
      }
      paramIntent = Util.stringsToList(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(28818);
        return;
      }
      this.Lyy.addAll(paramIntent);
      this.iYf.s(null, this.Lyy);
      this.iYf.bfU();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        bh.beI();
        ab.r(com.tencent.mm.model.c.bbL().RG(str));
      }
    }
    AppMethodBeat.o(28818);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28817);
    super.onCreate(paramBundle);
    d.rE(39);
    paramBundle = a.hhV();
    if (this.Lyy == null) {
      this.Lyy = new ArrayList();
    }
    bh.beI();
    Cursor localCursor = com.tencent.mm.model.c.bbL().f("@werun.black.android", "", null);
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      if (!paramBundle.contains(str)) {
        this.Lyy.add(str);
      }
    }
    localCursor.close();
    this.iYf = ((ContactListExpandPreference)getPreferenceScreen().byG("black_contact_list_pref"));
    this.iYf.a(getPreferenceScreen(), this.iYf.mKey);
    this.iYf.DZ(true).Ea(true);
    this.iYf.s(null, this.Lyy);
    this.iYf.a(this.Lyz);
    this.iYf.auI(R.l.eEl);
    setMMTitle(getString(R.l.eDN));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28811);
        SportBlackListUI.this.finish();
        AppMethodBeat.o(28811);
        return false;
      }
    });
    AppMethodBeat.o(28817);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportBlackListUI
 * JD-Core Version:    0.7.0.1
 */