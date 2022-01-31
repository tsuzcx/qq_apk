package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends MMPreference
{
  private ContactListExpandPreference dnv;
  private List<String> ptP;
  private ContactListExpandPreference.a ptQ = new SportBlackListUI.2(this);
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 != 0) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!bk.bl(paramIntent))
      {
        paramIntent = bk.G(paramIntent.split(","));
        if (paramIntent != null)
        {
          this.ptP.addAll(paramIntent);
          this.dnv.s(null, this.ptP);
          this.dnv.refresh();
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            String str = (String)paramIntent.next();
            au.Hx();
            s.g(c.Fw().abl(str));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d.jdMethod_if(39);
    if (this.ptP == null) {
      this.ptP = new ArrayList();
    }
    au.Hx();
    paramBundle = c.Fw().d("@werun.black.android", "", null);
    while (paramBundle.moveToNext())
    {
      String str = paramBundle.getString(0);
      this.ptP.add(str);
    }
    paramBundle.close();
    this.dnv = ((ContactListExpandPreference)this.vdd.add("black_contact_list_pref"));
    this.dnv.a(this.vdd, this.dnv.mKey);
    this.dnv.lS(true).lT(true);
    this.dnv.s(null, this.ptP);
    this.dnv.a(this.ptQ);
    this.dnv.setSummary(R.l.exdevice_we_sport_black_list_intro);
    setMMTitle(getString(R.l.exdevice_profile_add_black_list));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SportBlackListUI.this.finish();
        return false;
      }
    });
  }
  
  public final int xj()
  {
    return R.o.sportblacklist_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportBlackListUI
 * JD-Core Version:    0.7.0.1
 */