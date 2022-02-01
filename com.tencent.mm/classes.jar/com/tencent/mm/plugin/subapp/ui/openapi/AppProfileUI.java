package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI
  extends MMPreference
  implements MStorage.IOnStorageChange
{
  private g INh;
  private AppHeaderPreference.a SHX;
  private MMHandler handler = null;
  private f screen;
  
  private static void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(29156);
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder = new StringBuilder().append(paramg.field_appId).append(",");
    if (paramBoolean) {}
    for (paramg = "1";; paramg = "2")
    {
      localLinkedList.add(new i.a(10165, paramg));
      bh.bCz();
      c.bzz().d(new i(localLinkedList));
      AppMethodBeat.o(29156);
      return;
    }
  }
  
  private void bDL()
  {
    boolean bool = true;
    AppMethodBeat.i(29152);
    this.screen.removeAll();
    this.screen.aBe(getResourceId());
    AppHeaderPreference localAppHeaderPreference;
    AppHeaderPreference.a locala;
    if (this.INh.field_status == 1)
    {
      this.screen.bAk("app_profile_add");
      localAppHeaderPreference = (AppHeaderPreference)this.screen.bAi("app_profile_header");
      locala = this.SHX;
      if (this.INh.field_status != 1) {
        break label112;
      }
    }
    for (;;)
    {
      localAppHeaderPreference.a(locala, bool);
      AppMethodBeat.o(29152);
      return;
      this.screen.bAk("app_profile_remove");
      break;
      label112:
      bool = false;
    }
  }
  
  private void hBt()
  {
    AppMethodBeat.i(29153);
    this.handler = new MMHandler()
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
  
  public int getResourceId()
  {
    return R.o.haH;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(29151);
    this.SHX = new AppHeaderPreference.a()
    {
      public final String Fc(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29144);
        if (paramAnonymousBoolean) {}
        for (int i = R.l.settings_plugins_installed;; i = R.l.settings_plugins_uninstalled)
        {
          String str = AppProfileUI.this.getContext().getString(i);
          AppMethodBeat.o(29144);
          return str;
        }
      }
      
      public final Bitmap fwJ()
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
        localObject2 = h.lt((Context)localObject2);
        if (((String)localObject2).equalsIgnoreCase("zh_CN"))
        {
          localObject1 = ((g)localObject1).field_appDiscription;
          AppMethodBeat.o(29145);
          return localObject1;
        }
        if ((((String)localObject2).equalsIgnoreCase("zh_TW")) || (((String)localObject2).equalsIgnoreCase("zh_HK")))
        {
          if (Util.isNullOrNil(((g)localObject1).field_appDiscription_tw))
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
          if (Util.isNullOrNil(((g)localObject1).field_appDiscription_en))
          {
            localObject1 = ((g)localObject1).field_appDiscription;
            AppMethodBeat.o(29145);
            return localObject1;
          }
          localObject1 = ((g)localObject1).field_appDiscription_en;
          AppMethodBeat.o(29145);
          return localObject1;
        }
        if (Util.isNullOrNil(((g)localObject1).field_appDiscription_en))
        {
          localObject1 = ((g)localObject1).field_appDiscription;
          AppMethodBeat.o(29145);
          return localObject1;
        }
        localObject1 = ((g)localObject1).field_appDiscription_en;
        AppMethodBeat.o(29145);
        return localObject1;
      }
      
      public final String hBs()
      {
        AppMethodBeat.i(29142);
        String str = h.a(AppProfileUI.this.getContext(), AppProfileUI.a(AppProfileUI.this), null);
        AppMethodBeat.o(29142);
        return str;
      }
    };
    this.INh = h.s(getIntent().getStringExtra("AppProfileUI_AppId"), true, false);
    if (this.INh != null) {}
    for (;;)
    {
      Assert.assertTrue("initView : appInfo does not exist", bool);
      setMMTitle(R.l.grR);
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
      bDL();
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
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(29155);
    if (paramString.equals(this.INh.field_appId)) {
      initView();
    }
    AppMethodBeat.o(29155);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29150);
    as.gxn().remove(this);
    super.onPause();
    AppMethodBeat.o(29150);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29154);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.AppProfileUI", paramf + " item has been clicked!");
    if (paramf.equals("app_profile_add"))
    {
      this.INh.field_status = 1;
      this.INh.field_modifyTime = System.currentTimeMillis();
      as.gxn().a(this.INh, new String[0]);
      bDL();
      a(this.INh, true);
      hBt();
      AppMethodBeat.o(29154);
      return true;
    }
    if (paramf.equals("app_profile_remove"))
    {
      this.INh.field_status = 0;
      this.INh.field_modifyTime = System.currentTimeMillis();
      as.gxn().a(this.INh, new String[0]);
      bDL();
      a(this.INh, false);
      hBt();
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
    as.gxn().add(this);
    AppMethodBeat.o(29149);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI
 * JD-Core Version:    0.7.0.1
 */