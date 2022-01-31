package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bo;

final class AppProfileUI$1
  implements AppHeaderPreference.a
{
  AppProfileUI$1(AppProfileUI paramAppProfileUI) {}
  
  public final String cGY()
  {
    AppMethodBeat.i(25448);
    String str = g.b(this.sYV.getContext(), AppProfileUI.a(this.sYV), null);
    AppMethodBeat.o(25448);
    return str;
  }
  
  public final Bitmap cGZ()
  {
    AppMethodBeat.i(25449);
    Bitmap localBitmap = g.b(AppProfileUI.a(this.sYV).field_appId, 1, a.getDensity(this.sYV));
    AppMethodBeat.o(25449);
    return localBitmap;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(25451);
    Object localObject2 = this.sYV.getContext();
    Object localObject1 = AppProfileUI.a(this.sYV);
    if ((localObject2 == null) || (localObject1 == null))
    {
      AppMethodBeat.o(25451);
      return null;
    }
    localObject2 = g.fR((Context)localObject2);
    if (((String)localObject2).equalsIgnoreCase("zh_CN"))
    {
      localObject1 = ((f)localObject1).field_appDiscription;
      AppMethodBeat.o(25451);
      return localObject1;
    }
    if ((((String)localObject2).equalsIgnoreCase("zh_TW")) || (((String)localObject2).equalsIgnoreCase("zh_HK")))
    {
      if (bo.isNullOrNil(((f)localObject1).field_appDiscription_tw))
      {
        localObject1 = ((f)localObject1).field_appDiscription;
        AppMethodBeat.o(25451);
        return localObject1;
      }
      localObject1 = ((f)localObject1).field_appDiscription_tw;
      AppMethodBeat.o(25451);
      return localObject1;
    }
    if (((String)localObject2).equalsIgnoreCase("en"))
    {
      if (bo.isNullOrNil(((f)localObject1).field_appDiscription_en))
      {
        localObject1 = ((f)localObject1).field_appDiscription;
        AppMethodBeat.o(25451);
        return localObject1;
      }
      localObject1 = ((f)localObject1).field_appDiscription_en;
      AppMethodBeat.o(25451);
      return localObject1;
    }
    if (bo.isNullOrNil(((f)localObject1).field_appDiscription_en))
    {
      localObject1 = ((f)localObject1).field_appDiscription;
      AppMethodBeat.o(25451);
      return localObject1;
    }
    localObject1 = ((f)localObject1).field_appDiscription_en;
    AppMethodBeat.o(25451);
    return localObject1;
  }
  
  public final String mw(boolean paramBoolean)
  {
    AppMethodBeat.i(25450);
    if (paramBoolean) {}
    for (int i = 2131303378;; i = 2131303386)
    {
      String str = this.sYV.getContext().getString(i);
      AppMethodBeat.o(25450);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI.1
 * JD-Core Version:    0.7.0.1
 */