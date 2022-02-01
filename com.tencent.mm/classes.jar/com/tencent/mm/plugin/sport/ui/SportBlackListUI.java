package com.tencent.mm.plugin.sport.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends MMPreference
{
  private List<String> AHn;
  private ContactListExpandPreference.a AHo;
  private ContactListExpandPreference fMC;
  
  public SportBlackListUI()
  {
    AppMethodBeat.i(28816);
    this.AHo = new ContactListExpandPreference.a()
    {
      public final void YJ()
      {
        AppMethodBeat.i(28815);
        SportBlackListUI.a(SportBlackListUI.this).fcH();
        AppMethodBeat.o(28815);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(193355);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).YX(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        d.b(SportBlackListUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(193355);
      }
      
      public final void lc(int paramAnonymousInt)
      {
        AppMethodBeat.i(28812);
        String str = SportBlackListUI.a(SportBlackListUI.this).YX(paramAnonymousInt);
        if (bt.isNullOrNil(str))
        {
          AppMethodBeat.o(28812);
          return;
        }
        SportBlackListUI.b(SportBlackListUI.this).remove(str);
        SportBlackListUI.a(SportBlackListUI.this).A(null, SportBlackListUI.b(SportBlackListUI.this));
        SportBlackListUI.a(SportBlackListUI.this).refresh();
        ba.aBQ();
        w.l(com.tencent.mm.model.c.azp().Bf(str));
        com.tencent.mm.plugin.sport.a.c.ma(40);
        AppMethodBeat.o(28812);
      }
      
      public final void ld(int paramAnonymousInt)
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
      if (bt.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(28818);
        return;
      }
      paramIntent = bt.U(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(28818);
        return;
      }
      this.AHn.addAll(paramIntent);
      this.fMC.A(null, this.AHn);
      this.fMC.refresh();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        ba.aBQ();
        w.k(com.tencent.mm.model.c.azp().Bf(str));
      }
    }
    AppMethodBeat.o(28818);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28817);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.ma(39);
    if (this.AHn == null) {
      this.AHn = new ArrayList();
    }
    ba.aBQ();
    paramBundle = com.tencent.mm.model.c.azp().e("@werun.black.android", "", null);
    while (paramBundle.moveToNext())
    {
      String str = paramBundle.getString(paramBundle.getColumnIndex("username"));
      this.AHn.add(str);
    }
    paramBundle.close();
    this.fMC = ((ContactListExpandPreference)getPreferenceScreen().aVD("black_contact_list_pref"));
    this.fMC.a(getPreferenceScreen(), this.fMC.mKey);
    this.fMC.vO(true).vP(true);
    this.fMC.A(null, this.AHn);
    this.fMC.a(this.AHo);
    this.fMC.setSummary(2131758620);
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