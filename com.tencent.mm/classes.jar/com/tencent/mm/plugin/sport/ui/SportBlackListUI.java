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
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportBlackListUI
  extends MMPreference
{
  private ContactListExpandPreference ftA;
  private List<String> zpt;
  private ContactListExpandPreference.a zpu;
  
  public SportBlackListUI()
  {
    AppMethodBeat.i(28816);
    this.zpu = new ContactListExpandPreference.a()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(196080);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).Xb(paramAnonymousInt);
        if (bs.isNullOrNil(paramAnonymousViewGroup))
        {
          AppMethodBeat.o(196080);
          return;
        }
        SportBlackListUI.b(SportBlackListUI.this).remove(paramAnonymousViewGroup);
        SportBlackListUI.a(SportBlackListUI.this).y(null, SportBlackListUI.b(SportBlackListUI.this));
        SportBlackListUI.a(SportBlackListUI.this).refresh();
        az.ayM();
        w.l(com.tencent.mm.model.c.awB().aNt(paramAnonymousViewGroup));
        com.tencent.mm.plugin.sport.a.c.lA(40);
        AppMethodBeat.o(196080);
      }
      
      public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(196082);
        paramAnonymousViewGroup = SportBlackListUI.a(SportBlackListUI.this).Xb(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousViewGroup);
        d.b(SportBlackListUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        AppMethodBeat.o(196082);
      }
      
      public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(196081);
        SportBlackListUI.c(SportBlackListUI.this);
        AppMethodBeat.o(196081);
      }
      
      public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
      
      public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
      {
        AppMethodBeat.i(196083);
        SportBlackListUI.a(SportBlackListUI.this).eNI();
        AppMethodBeat.o(196083);
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
      if (bs.isNullOrNil(paramIntent))
      {
        AppMethodBeat.o(28818);
        return;
      }
      paramIntent = bs.S(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(28818);
        return;
      }
      this.zpt.addAll(paramIntent);
      this.ftA.y(null, this.zpt);
      this.ftA.refresh();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        az.ayM();
        w.k(com.tencent.mm.model.c.awB().aNt(str));
      }
    }
    AppMethodBeat.o(28818);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28817);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.sport.a.c.lA(39);
    if (this.zpt == null) {
      this.zpt = new ArrayList();
    }
    az.ayM();
    paramBundle = com.tencent.mm.model.c.awB().e("@werun.black.android", "", null);
    while (paramBundle.moveToNext())
    {
      String str = paramBundle.getString(paramBundle.getColumnIndex("username"));
      this.zpt.add(str);
    }
    paramBundle.close();
    this.ftA = ((ContactListExpandPreference)getPreferenceScreen().aPN("black_contact_list_pref"));
    this.ftA.a(getPreferenceScreen(), this.ftA.mKey);
    this.ftA.vc(true).vd(true);
    this.ftA.y(null, this.zpt);
    this.ftA.a(this.zpu);
    this.ftA.setSummary(2131758620);
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