package com.tencent.mm.plugin.subapp.ui.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.cc.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI
  extends MMPreference
  implements k.a
{
  private ao handler = null;
  private f screen;
  private g tmL;
  private AppHeaderPreference.a zSI;
  
  private static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(29156);
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder = new StringBuilder().append(paramg.field_appId).append(",");
    if (paramBoolean) {}
    for (paramg = "1";; paramg = "2")
    {
      localLinkedList.add(new i.a(10165, paramg));
      az.ayM();
      c.awA().c(new com.tencent.mm.ba.i(localLinkedList));
      AppMethodBeat.o(29156);
      return;
    }
  }
  
  private void eaU()
  {
    AppMethodBeat.i(29153);
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29147);
        AppProfileUI.this.finish();
        AppMethodBeat.o(29147);
      }
    };
    this.handler.sendEmptyMessageDelayed(0, 30L);
    AppMethodBeat.o(29153);
  }
  
  private void refresh()
  {
    boolean bool = true;
    AppMethodBeat.i(29152);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    AppHeaderPreference localAppHeaderPreference;
    AppHeaderPreference.a locala;
    if (this.tmL.field_status == 1)
    {
      this.screen.aPO("app_profile_add");
      localAppHeaderPreference = (AppHeaderPreference)this.screen.aPN("app_profile_header");
      locala = this.zSI;
      if (this.tmL.field_status != 1) {
        break label112;
      }
    }
    for (;;)
    {
      localAppHeaderPreference.a(locala, bool);
      AppMethodBeat.o(29152);
      return;
      this.screen.aPO("app_profile_remove");
      break;
      label112:
      bool = false;
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(29155);
    if (paramString.equals(this.tmL.field_appId)) {
      initView();
    }
    AppMethodBeat.o(29155);
  }
  
  public int getResourceId()
  {
    return 2131951624;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(29151);
    this.zSI = new AppHeaderPreference.a()
    {
      public final String eaS()
      {
        AppMethodBeat.i(29142);
        String str = h.a(AppProfileUI.this.getContext(), AppProfileUI.a(AppProfileUI.this), null);
        AppMethodBeat.o(29142);
        return str;
      }
      
      public final Bitmap eaT()
      {
        AppMethodBeat.i(29143);
        Bitmap localBitmap = h.c(AppProfileUI.a(AppProfileUI.this).field_appId, 1, a.getDensity(AppProfileUI.this));
        AppMethodBeat.o(29143);
        return localBitmap;
      }
      
      public final String getHint()
      {
        AppMethodBeat.i(29145);
        Object localObject2 = AppProfileUI.this.getContext();
        Object localObject1 = AppProfileUI.a(AppProfileUI.this);
        if ((localObject2 == null) || (localObject1 == null))
        {
          AppMethodBeat.o(29145);
          return null;
        }
        localObject2 = h.ho((Context)localObject2);
        if (((String)localObject2).equalsIgnoreCase("zh_CN"))
        {
          localObject1 = ((g)localObject1).field_appDiscription;
          AppMethodBeat.o(29145);
          return localObject1;
        }
        if ((((String)localObject2).equalsIgnoreCase("zh_TW")) || (((String)localObject2).equalsIgnoreCase("zh_HK")))
        {
          if (bs.isNullOrNil(((g)localObject1).field_appDiscription_tw))
          {
            localObject1 = ((g)localObject1).field_appDiscription;
            AppMethodBeat.o(29145);
            return localObject1;
          }
          localObject1 = ((g)localObject1).field_appDiscription_tw;
          AppMethodBeat.o(29145);
          return localObject1;
        }
        if (((String)localObject2).equalsIgnoreCase("en"))
        {
          if (bs.isNullOrNil(((g)localObject1).field_appDiscription_en))
          {
            localObject1 = ((g)localObject1).field_appDiscription;
            AppMethodBeat.o(29145);
            return localObject1;
          }
          localObject1 = ((g)localObject1).field_appDiscription_en;
          AppMethodBeat.o(29145);
          return localObject1;
        }
        if (bs.isNullOrNil(((g)localObject1).field_appDiscription_en))
        {
          localObject1 = ((g)localObject1).field_appDiscription;
          AppMethodBeat.o(29145);
          return localObject1;
        }
        localObject1 = ((g)localObject1).field_appDiscription_en;
        AppMethodBeat.o(29145);
        return localObject1;
      }
      
      public final String rY(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29144);
        if (paramAnonymousBoolean) {}
        for (int i = 2131763360;; i = 2131763368)
        {
          String str = AppProfileUI.this.getContext().getString(i);
          AppMethodBeat.o(29144);
          return str;
        }
      }
    };
    this.tmL = h.k(getIntent().getStringExtra("AppProfileUI_AppId"), true, false);
    if (this.tmL != null) {}
    for (;;)
    {
      Assert.assertTrue("initView : appInfo does not exist", bool);
      setMMTitle(2131755864);
      this.screen = getPreferenceScreen();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(29146);
          AppProfileUI.this.finish();
          AppMethodBeat.o(29146);
          return true;
        }
      });
      refresh();
      AppMethodBeat.o(29151);
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29148);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29148);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29150);
    ap.dny().remove(this);
    super.onPause();
    AppMethodBeat.o(29150);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29154);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.AppProfileUI", paramf + " item has been clicked!");
    if (paramf.equals("app_profile_add"))
    {
      this.tmL.field_status = 1;
      this.tmL.field_modifyTime = System.currentTimeMillis();
      ap.dny().a(this.tmL, new String[0]);
      refresh();
      a(this.tmL, true);
      eaU();
      AppMethodBeat.o(29154);
      return true;
    }
    if (paramf.equals("app_profile_remove"))
    {
      this.tmL.field_status = 0;
      this.tmL.field_modifyTime = System.currentTimeMillis();
      ap.dny().a(this.tmL, new String[0]);
      refresh();
      a(this.tmL, false);
      eaU();
      AppMethodBeat.o(29154);
      return true;
    }
    AppMethodBeat.o(29154);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29149);
    super.onResume();
    ap.dny().add(this);
    AppMethodBeat.o(29149);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI
 * JD-Core Version:    0.7.0.1
 */