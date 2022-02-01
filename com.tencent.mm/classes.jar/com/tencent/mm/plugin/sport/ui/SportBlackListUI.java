package com.tencent.mm.plugin.sport.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends MMPreference
{
  private ContactListExpandPreference fpW;
  private List<String> yct;
  private ContactListExpandPreference.a ycu;
  
  public SportBlackListUI()
  {
    AppMethodBeat.i(28816);
    this.ycu = new ContactListExpandPreference.a()
    {
      public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(204853);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).US(paramAnonymousInt);
        if (bt.isNullOrNil(paramAnonymousViewGroup))
        {
          AppMethodBeat.o(204853);
          return;
        }
        SportBlackListUI.b(SportBlackListUI.this).remove(paramAnonymousViewGroup);
        SportBlackListUI.a(SportBlackListUI.this).B(null, SportBlackListUI.b(SportBlackListUI.this));
        SportBlackListUI.a(SportBlackListUI.this).refresh();
        az.arV();
        w.l(com.tencent.mm.model.c.apM().aHY(paramAnonymousViewGroup));
        com.tencent.mm.plugin.sport.a.c.lI(40);
        AppMethodBeat.o(204853);
      }
      
      public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(204855);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).US(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousViewGroup);
        d.b(SportBlackListUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        AppMethodBeat.o(204855);
      }
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(204854);
        SportBlackListUI.c(SportBlackListUI.this);
        AppMethodBeat.o(204854);
      }
      
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
      {
        AppMethodBeat.i(204856);
        SportBlackListUI.a(SportBlackListUI.this).eyo();
        AppMethodBeat.o(204856);
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
      paramIntent = bt.S(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(28818);
        return;
      }
      this.yct.addAll(paramIntent);
      this.fpW.B(null, this.yct);
      this.fpW.refresh();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        az.arV();
        w.k(com.tencent.mm.model.c.apM().aHY(str));
      }
    }
    AppMethodBeat.o(28818);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28817);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.lI(39);
    if (this.yct == null) {
      this.yct = new ArrayList();
    }
    az.arV();
    paramBundle = com.tencent.mm.model.c.apM().e("@werun.black.android", "", null);
    while (paramBundle.moveToNext())
    {
      String str = paramBundle.getString(paramBundle.getColumnIndex("username"));
      this.yct.add(str);
    }
    paramBundle.close();
    this.fpW = ((ContactListExpandPreference)getPreferenceScreen().aKk("black_contact_list_pref"));
    this.fpW.a(getPreferenceScreen(), this.fpW.mKey);
    this.fpW.ub(true).uc(true);
    this.fpW.B(null, this.yct);
    this.fpW.a(this.ycu);
    this.fpW.setSummary(2131758620);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportBlackListUI
 * JD-Core Version:    0.7.0.1
 */