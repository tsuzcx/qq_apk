package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ay.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI
  extends MMPreference
  implements j.a
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private ah handler = null;
  private com.tencent.mm.pluginsdk.model.app.f kXm;
  private AppHeaderPreference.a pxg;
  
  private static void a(com.tencent.mm.pluginsdk.model.app.f paramf, boolean paramBoolean)
  {
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder = new StringBuilder().append(paramf.field_appId).append(",");
    if (paramBoolean) {}
    for (paramf = "1";; paramf = "2")
    {
      localLinkedList.add(new g.a(10165, paramf));
      au.Hx();
      c.Fv().b(new com.tencent.mm.ay.g(localLinkedList));
      return;
    }
  }
  
  private void bMc()
  {
    this.handler = new AppProfileUI.3(this);
    this.handler.sendEmptyMessageDelayed(0, 30L);
  }
  
  private void refresh()
  {
    boolean bool2 = true;
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(R.o.app_profile);
    AppHeaderPreference localAppHeaderPreference;
    AppHeaderPreference.a locala;
    boolean bool1;
    if (this.kXm.field_status == 1)
    {
      this.dnn.ade("app_profile_add");
      localAppHeaderPreference = (AppHeaderPreference)this.dnn.add("app_profile_header");
      locala = this.pxg;
      if (this.kXm.field_status != 1) {
        break label116;
      }
      bool1 = true;
      label80:
      if (locala == null) {
        break label121;
      }
    }
    for (;;)
    {
      Assert.assertTrue(bool2);
      localAppHeaderPreference.pwX = locala;
      localAppHeaderPreference.cce = bool1;
      return;
      this.dnn.ade("app_profile_remove");
      break;
      label116:
      bool1 = false;
      break label80;
      label121:
      bool2 = false;
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    if (paramString.equals(this.kXm.field_appId)) {
      initView();
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    y.i("MicroMsg.AppProfileUI", paramf + " item has been clicked!");
    if (paramf.equals("app_profile_add"))
    {
      this.kXm.field_status = 1;
      this.kXm.field_modifyTime = System.currentTimeMillis();
      ap.brn().a(this.kXm, new String[0]);
      refresh();
      a(this.kXm, true);
      bMc();
      return true;
    }
    if (paramf.equals("app_profile_remove"))
    {
      this.kXm.field_status = 0;
      this.kXm.field_modifyTime = System.currentTimeMillis();
      ap.brn().a(this.kXm, new String[0]);
      refresh();
      a(this.kXm, false);
      bMc();
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    boolean bool = true;
    this.pxg = new AppProfileUI.1(this);
    this.kXm = com.tencent.mm.pluginsdk.model.app.g.by(getIntent().getStringExtra("AppProfileUI_AppId"), true);
    if (this.kXm != null) {}
    for (;;)
    {
      Assert.assertTrue("initView : appInfo does not exist", bool);
      setMMTitle(R.l.app_profile_title);
      this.dnn = this.vdd;
      setBackBtn(new AppProfileUI.2(this));
      refresh();
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onPause()
  {
    ap.brn().d(this);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    ap.brn().c(this);
  }
  
  public final int xj()
  {
    return R.o.app_profile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI
 * JD-Core Version:    0.7.0.1
 */