package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public class a$c
  implements a.h
{
  public a$c(a parama) {}
  
  public View dDv()
  {
    return null;
  }
  
  public void onCreateMMMenu(l paraml) {}
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 0;
    AppMethodBeat.i(29934);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      if (paramInt != 0) {
        this.zgk.iwc.cre();
      }
      AppMethodBeat.o(29934);
      return;
      al.p(new a.c.1(this), 100L);
      paramInt = 1;
      continue;
      al.p(new a.c.2(this), 100L);
      paramInt = 1;
      continue;
      this.zgk.iwc.cre();
      paramInt = 1;
      continue;
      if (!bo.isNullOrNil(this.zgk.username))
      {
        b.j(this.zgk.context, this.zgk.username, true);
        if (this.zgk.jvs)
        {
          a.a(this.zgk, 6);
          paramInt = 1;
          continue;
        }
        this.zgk.ht(this.zgk.scene, 4);
        paramInt = 1;
        continue;
        if (!bo.isNullOrNil(this.zgk.username))
        {
          b.j(this.zgk.context, this.zgk.username, false);
          if (this.zgk.jvs)
          {
            a.a(this.zgk, 1);
            paramInt = 1;
            continue;
          }
          this.zgk.ht(this.zgk.scene, 2);
          paramInt = 1;
          continue;
          paramMenuItem = this.zgk;
          Object localObject1 = this.zgk.context;
          Object localObject2 = this.zgk.iOe;
          if (localObject2 == null)
          {
            ab.e("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams is null");
            paramInt = 1;
            continue;
          }
          ab.i("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams : %s", new Object[] { ((WxaExposedParams)localObject2).toString() });
          if (!bo.isNullOrNil(((WxaExposedParams)localObject2).username))
          {
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("key_username", ((WxaExposedParams)localObject2).username);
            ((Intent)localObject3).putExtra("key_from_scene", 4);
            ((Intent)localObject3).putExtra("key_scene_exposed_params", (Parcelable)localObject2);
            com.tencent.mm.bq.d.b((Context)localObject1, "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject3);
            paramMenuItem.ht(paramMenuItem.scene, 1);
          }
          paramInt = 1;
          continue;
          localObject1 = this.zgk;
          localObject2 = new Intent();
          Object localObject3 = ((a)localObject1).iOe.appId;
          String str = ((a)localObject1).iOe.pageId;
          if (((a)localObject1).iOe.appId.equals(((a)localObject1).getAppId())) {}
          for (paramMenuItem = "";; paramMenuItem = ((a)localObject1).getAppId())
          {
            paramMenuItem = a.aH((String)localObject3, str, paramMenuItem);
            ab.v("MicroMsg.AppBrandServiceActionSheet", "KRawUrl ".concat(String.valueOf(paramMenuItem)));
            ((Intent)localObject2).putExtra("rawUrl", paramMenuItem);
            ((Intent)localObject2).putExtra("forceHideShare", true);
            com.tencent.mm.bq.d.b(((a)localObject1).context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
            paramInt = 1;
            break;
          }
        }
      }
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */