package com.tencent.mm.plugin.sport.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends MMPreference
{
  private List<String> AYQ;
  private ContactListExpandPreference.a AYR;
  private ContactListExpandPreference fOK;
  
  public SportBlackListUI()
  {
    AppMethodBeat.i(28816);
    this.AYR = new ContactListExpandPreference.a()
    {
      public final void YS()
      {
        AppMethodBeat.i(28815);
        SportBlackListUI.a(SportBlackListUI.this).fgv();
        AppMethodBeat.o(28815);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(186630);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).ZD(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        d.b(SportBlackListUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(186630);
      }
      
      public final void le(int paramAnonymousInt)
      {
        AppMethodBeat.i(28812);
        String str = SportBlackListUI.a(SportBlackListUI.this).ZD(paramAnonymousInt);
        if (bu.isNullOrNil(str))
        {
          AppMethodBeat.o(28812);
          return;
        }
        SportBlackListUI.b(SportBlackListUI.this).remove(str);
        SportBlackListUI.a(SportBlackListUI.this).B(null, SportBlackListUI.b(SportBlackListUI.this));
        SportBlackListUI.a(SportBlackListUI.this).refresh();
        bc.aCg();
        x.s(com.tencent.mm.model.c.azF().BH(str));
        com.tencent.mm.plugin.sport.a.c.md(40);
        AppMethodBeat.o(28812);
      }
      
      public final void lf(int paramAnonymousInt)
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
    return 2131951746;
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
      if (bu.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(28818);
        return;
      }
      paramIntent = bu.U(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(28818);
        return;
      }
      this.AYQ.addAll(paramIntent);
      this.fOK.B(null, this.AYQ);
      this.fOK.refresh();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        bc.aCg();
        x.r(com.tencent.mm.model.c.azF().BH(str));
      }
    }
    AppMethodBeat.o(28818);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28817);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.md(39);
    if (this.AYQ == null) {
      this.AYQ = new ArrayList();
    }
    bc.aCg();
    paramBundle = com.tencent.mm.model.c.azF().e("@werun.black.android", "", null);
    while (paramBundle.moveToNext())
    {
      String str = paramBundle.getString(paramBundle.getColumnIndex("username"));
      this.AYQ.add(str);
    }
    paramBundle.close();
    this.fOK = ((ContactListExpandPreference)getPreferenceScreen().aXe("black_contact_list_pref"));
    this.fOK.a(getPreferenceScreen(), this.fOK.mKey);
    this.fOK.vW(true).vX(true);
    this.fOK.B(null, this.AYQ);
    this.fOK.a(this.AYR);
    this.fOK.setSummary(2131758620);
    setMMTitle(getString(2131758570));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportBlackListUI
 * JD-Core Version:    0.7.0.1
 */