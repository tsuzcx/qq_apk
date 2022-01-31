package com.tencent.mm.plugin.subapp.ui.openapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h;
import com.tencent.mm.az.h.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI
  extends MMPreference
  implements k.a
{
  private ak handler = null;
  private com.tencent.mm.pluginsdk.model.app.f nvo;
  private AppHeaderPreference.a sYU;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private static void a(com.tencent.mm.pluginsdk.model.app.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(25462);
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder = new StringBuilder().append(paramf.field_appId).append(",");
    if (paramBoolean) {}
    for (paramf = "1";; paramf = "2")
    {
      localLinkedList.add(new h.a(10165, paramf));
      aw.aaz();
      c.Yz().c(new h(localLinkedList));
      AppMethodBeat.o(25462);
      return;
    }
  }
  
  private void cHa()
  {
    AppMethodBeat.i(25459);
    this.handler = new AppProfileUI.3(this);
    this.handler.sendEmptyMessageDelayed(0, 30L);
    AppMethodBeat.o(25459);
  }
  
  private void refresh()
  {
    boolean bool = true;
    AppMethodBeat.i(25458);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    AppHeaderPreference localAppHeaderPreference;
    AppHeaderPreference.a locala;
    if (this.nvo.field_status == 1)
    {
      this.screen.aty("app_profile_add");
      localAppHeaderPreference = (AppHeaderPreference)this.screen.atx("app_profile_header");
      locala = this.sYU;
      if (this.nvo.field_status != 1) {
        break label112;
      }
    }
    for (;;)
    {
      localAppHeaderPreference.a(locala, bool);
      AppMethodBeat.o(25458);
      return;
      this.screen.aty("app_profile_remove");
      break;
      label112:
      bool = false;
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(25461);
    if (paramString.equals(this.nvo.field_appId)) {
      initView();
    }
    AppMethodBeat.o(25461);
  }
  
  public int getResourceId()
  {
    return 2131165191;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(25457);
    this.sYU = new AppProfileUI.1(this);
    this.nvo = g.ca(getIntent().getStringExtra("AppProfileUI_AppId"), true);
    if (this.nvo != null) {}
    for (;;)
    {
      Assert.assertTrue("initView : appInfo does not exist", bool);
      setMMTitle(2131297047);
      this.screen = getPreferenceScreen();
      setBackBtn(new AppProfileUI.2(this));
      refresh();
      AppMethodBeat.o(25457);
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25454);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(25454);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25456);
    al.cac().remove(this);
    super.onPause();
    AppMethodBeat.o(25456);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(25460);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.AppProfileUI", paramf + " item has been clicked!");
    if (paramf.equals("app_profile_add"))
    {
      this.nvo.field_status = 1;
      this.nvo.field_modifyTime = System.currentTimeMillis();
      al.cac().a(this.nvo, new String[0]);
      refresh();
      a(this.nvo, true);
      cHa();
      AppMethodBeat.o(25460);
      return true;
    }
    if (paramf.equals("app_profile_remove"))
    {
      this.nvo.field_status = 0;
      this.nvo.field_modifyTime = System.currentTimeMillis();
      al.cac().a(this.nvo, new String[0]);
      refresh();
      a(this.nvo, false);
      cHa();
      AppMethodBeat.o(25460);
      return true;
    }
    AppMethodBeat.o(25460);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25455);
    super.onResume();
    al.cac().add(this);
    AppMethodBeat.o(25455);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI
 * JD-Core Version:    0.7.0.1
 */