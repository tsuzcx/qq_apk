package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class AppProfileUI$1
  implements AppHeaderPreference.a
{
  AppProfileUI$1(AppProfileUI paramAppProfileUI) {}
  
  public final String bMa()
  {
    return g.b(this.pxh.mController.uMN, AppProfileUI.a(this.pxh), null);
  }
  
  public final Bitmap bMb()
  {
    return g.b(AppProfileUI.a(this.pxh).field_appId, 1, a.getDensity(this.pxh));
  }
  
  public final String getHint()
  {
    Object localObject = this.pxh.mController.uMN;
    f localf = AppProfileUI.a(this.pxh);
    if ((localObject == null) || (localf == null)) {
      return null;
    }
    localObject = g.eR((Context)localObject);
    if (((String)localObject).equalsIgnoreCase("zh_CN")) {
      return localf.field_appDiscription;
    }
    if ((((String)localObject).equalsIgnoreCase("zh_TW")) || (((String)localObject).equalsIgnoreCase("zh_HK")))
    {
      if (bk.bl(localf.field_appDiscription_tw)) {
        return localf.field_appDiscription;
      }
      return localf.field_appDiscription_tw;
    }
    if (((String)localObject).equalsIgnoreCase("en"))
    {
      if (bk.bl(localf.field_appDiscription_en)) {
        return localf.field_appDiscription;
      }
      return localf.field_appDiscription_en;
    }
    if (bk.bl(localf.field_appDiscription_en)) {
      return localf.field_appDiscription;
    }
    return localf.field_appDiscription_en;
  }
  
  public final String jE(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = R.l.settings_plugins_installed;; i = R.l.settings_plugins_uninstalled) {
      return this.pxh.mController.uMN.getString(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI.1
 * JD-Core Version:    0.7.0.1
 */