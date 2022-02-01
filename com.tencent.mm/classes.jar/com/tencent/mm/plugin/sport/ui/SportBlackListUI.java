package com.tencent.mm.plugin.sport.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
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
  private List<String> FjN;
  private ContactListExpandPreference.a FjO;
  private ContactListExpandPreference gtU;
  
  public SportBlackListUI()
  {
    AppMethodBeat.i(28816);
    this.FjO = new ContactListExpandPreference.a()
    {
      public final void amF()
      {
        AppMethodBeat.i(28815);
        SportBlackListUI.a(SportBlackListUI.this).gpE();
        AppMethodBeat.o(28815);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(232062);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).aio(paramAnonymousInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
        com.tencent.mm.br.c.b(SportBlackListUI.this, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(232062);
      }
      
      public final void og(int paramAnonymousInt)
      {
        AppMethodBeat.i(28812);
        String str = SportBlackListUI.a(SportBlackListUI.this).aio(paramAnonymousInt);
        if (Util.isNullOrNil(str))
        {
          AppMethodBeat.o(28812);
          return;
        }
        SportBlackListUI.b(SportBlackListUI.this).remove(str);
        SportBlackListUI.a(SportBlackListUI.this).H(null, SportBlackListUI.b(SportBlackListUI.this));
        SportBlackListUI.a(SportBlackListUI.this).refresh();
        bg.aVF();
        ab.s(com.tencent.mm.model.c.aSN().Kn(str));
        com.tencent.mm.plugin.sport.a.c.pl(40);
        AppMethodBeat.o(28812);
      }
      
      public final void oh(int paramAnonymousInt)
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
    return 2132017291;
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
      this.FjN.addAll(paramIntent);
      this.gtU.H(null, this.FjN);
      this.gtU.refresh();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        bg.aVF();
        ab.r(com.tencent.mm.model.c.aSN().Kn(str));
      }
    }
    AppMethodBeat.o(28818);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28817);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.pl(39);
    if (this.FjN == null) {
      this.FjN = new ArrayList();
    }
    bg.aVF();
    paramBundle = com.tencent.mm.model.c.aSN().e("@werun.black.android", "", null);
    while (paramBundle.moveToNext())
    {
      String str = paramBundle.getString(paramBundle.getColumnIndex("username"));
      this.FjN.add(str);
    }
    paramBundle.close();
    this.gtU = ((ContactListExpandPreference)getPreferenceScreen().bmg("black_contact_list_pref"));
    this.gtU.a(getPreferenceScreen(), this.gtU.mKey);
    this.gtU.zU(true).zV(true);
    this.gtU.H(null, this.FjN);
    this.gtU.a(this.FjO);
    this.gtU.setSummary(2131758926);
    setMMTitle(getString(2131758871));
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