package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;

public class a$c
  implements a.h
{
  public a$c(a parama) {}
  
  public void a(l paraml) {}
  
  public View cAl()
  {
    return null;
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 0;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      if (paramInt != 0) {
        this.uRJ.gSO.bFp();
      }
      return;
      ai.l(new a.c.1(this), 100L);
      paramInt = 1;
      continue;
      ai.l(new a.c.2(this), 100L);
      paramInt = 1;
      continue;
      this.uRJ.gSO.bFp();
      paramInt = 1;
      continue;
      if (!bk.bl(this.uRJ.username))
      {
        b.i(this.uRJ.context, this.uRJ.username, true);
        if (this.uRJ.hCQ)
        {
          a.a(this.uRJ, 6);
          paramInt = 1;
          continue;
        }
        this.uRJ.fn(this.uRJ.scene, 4);
        paramInt = 1;
        continue;
        if (!bk.bl(this.uRJ.username))
        {
          b.i(this.uRJ.context, this.uRJ.username, false);
          if (this.uRJ.hCQ)
          {
            a.a(this.uRJ, 1);
            paramInt = 1;
            continue;
          }
          this.uRJ.fn(this.uRJ.scene, 2);
          paramInt = 1;
          continue;
          paramMenuItem = this.uRJ;
          Object localObject1 = this.uRJ.context;
          Object localObject2 = this.uRJ.hdB;
          if (localObject2 == null)
          {
            y.e("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams is null");
            paramInt = 1;
            continue;
          }
          y.i("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams : %s", new Object[] { ((WxaExposedParams)localObject2).toString() });
          if (!bk.bl(((WxaExposedParams)localObject2).username))
          {
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("key_username", ((WxaExposedParams)localObject2).username);
            ((Intent)localObject3).putExtra("key_from_scene", 4);
            ((Intent)localObject3).putExtra("key_scene_exposed_params", (Parcelable)localObject2);
            com.tencent.mm.br.d.b((Context)localObject1, "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject3);
            paramMenuItem.fn(paramMenuItem.scene, 1);
          }
          paramInt = 1;
          continue;
          localObject1 = this.uRJ;
          localObject2 = new Intent();
          Object localObject3 = ((a)localObject1).hdB.appId;
          String str = ((a)localObject1).hdB.bUo;
          if (((a)localObject1).hdB.appId.equals(((a)localObject1).getAppId())) {}
          for (paramMenuItem = "";; paramMenuItem = ((a)localObject1).getAppId())
          {
            paramMenuItem = a.aq((String)localObject3, str, paramMenuItem);
            y.v("MicroMsg.AppBrandSerivceActionSheet", "KRawUrl " + paramMenuItem);
            ((Intent)localObject2).putExtra("rawUrl", paramMenuItem);
            ((Intent)localObject2).putExtra("forceHideShare", true);
            com.tencent.mm.br.d.b(((a)localObject1).context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
            paramInt = 1;
            break;
          }
        }
      }
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */