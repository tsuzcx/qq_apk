package com.tencent.mm.plugin.sport.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bo;
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
  private ContactListExpandPreference eeU;
  private List<String> sqe;
  private ContactListExpandPreference.a sqf;
  
  public SportBlackListUI()
  {
    AppMethodBeat.i(25141);
    this.sqf = new SportBlackListUI.2(this);
    AppMethodBeat.o(25141);
  }
  
  public int getResourceId()
  {
    return 2131165302;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25143);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(25143);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bo.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(25143);
        return;
      }
      paramIntent = bo.P(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(25143);
        return;
      }
      this.sqe.addAll(paramIntent);
      this.eeU.v(null, this.sqe);
      this.eeU.refresh();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        aw.aaz();
        t.g(c.YA().arw(str));
      }
    }
    AppMethodBeat.o(25143);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25142);
    super.onCreate(paramBundle);
    d.kS(39);
    if (this.sqe == null) {
      this.sqe = new ArrayList();
    }
    aw.aaz();
    paramBundle = c.YA().e("@werun.black.android", "", null);
    while (paramBundle.moveToNext())
    {
      String str = paramBundle.getString(0);
      this.sqe.add(str);
    }
    paramBundle.close();
    this.eeU = ((ContactListExpandPreference)getPreferenceScreen().atx("black_contact_list_pref"));
    this.eeU.a(getPreferenceScreen(), this.eeU.mKey);
    this.eeU.pf(true).pg(true);
    this.eeU.v(null, this.sqe);
    this.eeU.a(this.sqf);
    this.eeU.setSummary(2131299489);
    setMMTitle(getString(2131299440));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25136);
        SportBlackListUI.this.finish();
        AppMethodBeat.o(25136);
        return false;
      }
    });
    AppMethodBeat.o(25142);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportBlackListUI
 * JD-Core Version:    0.7.0.1
 */