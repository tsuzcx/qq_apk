package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class g$26
  implements Runnable
{
  g$26(g paramg, int paramInt1, double paramDouble1, double paramDouble2, String paramString, int paramInt2) {}
  
  public final void run()
  {
    int j = 0;
    int i = j;
    Object localObject;
    Context localContext;
    int k;
    double d1;
    double d2;
    String str;
    int m;
    j.d local1;
    if (g.i(this.rzi) != null)
    {
      i = j;
      if ((g.i(this.rzi) instanceof Activity))
      {
        i = j;
        if (!((Activity)g.i(this.rzi)).isFinishing())
        {
          localObject = g.F(this.rzi);
          localContext = g.i(this.rzi);
          k = this.rzG;
          d1 = this.elO;
          d2 = this.elP;
          str = this.rzH;
          m = this.rzI;
          local1 = new j.d()
          {
            private void ba(int paramAnonymousInt, String paramAnonymousString)
            {
              g.c localc = g.b(g.26.this.rzi, paramAnonymousInt);
              if ((localc != null) && (localc.rym != null) && (localc.rgh != null)) {
                g.a(g.26.this.rzi, g.D(g.26.this.rzi), g.j(g.26.this.rzi), "openMapNavigateMenu:" + bk.aM(paramAnonymousString, "fail"));
              }
            }
            
            public final void CZ(int paramAnonymousInt)
            {
              ba(paramAnonymousInt, "cancel");
            }
            
            public final void Da(int paramAnonymousInt)
            {
              g.c(g.26.this.rzi, paramAnonymousInt);
            }
            
            public final void onFail(int paramAnonymousInt)
            {
              ba(paramAnonymousInt, "fail");
            }
            
            public final void onSuccess(int paramAnonymousInt)
            {
              ba(paramAnonymousInt, "ok");
            }
          };
          i = j;
          if (localContext != null)
          {
            i = j;
            if ((localContext instanceof MMActivity))
            {
              if (!((MMActivity)localContext).isFinishing()) {
                break label200;
              }
              i = j;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      localObject = g.b(this.rzi, this.rzI);
      if ((((g.c)localObject).rgh != null) && (((g.c)localObject).rym != null)) {
        g.a(this.rzi, ((g.c)localObject).rgh, ((g.c)localObject).rym, "openMapNavigateMenu:fail");
      }
    }
    return;
    label200:
    ((j)localObject).rhh = m;
    ((j)localObject).rAP = true;
    ((j)localObject).rAQ = k;
    ((j)localObject).rAS = new j.e(d1, d2, (byte)0);
    ((j)localObject).rAT = str;
    ((j)localObject).aoB = new WeakReference(localContext);
    ((j)localObject).rAU = local1;
    ((j)localObject).egs = null;
    if (((j)localObject).egs == null) {
      ((j)localObject).cgC();
    }
    for (;;)
    {
      i = 1;
      break;
      ((j)localObject).rAX = new j.2((j)localObject);
      if (((j)localObject).lIe != null)
      {
        ((j)localObject).rAW = new j.3((j)localObject);
        ((j)localObject).lIe.a(((j)localObject).rAS.latitude, ((j)localObject).rAS.longitude, ((j)localObject).rAW);
      }
      ai.d(new j.4((j)localObject));
      ((j)localObject).egs.b(((j)localObject).rAX);
      ai.l(((j)localObject).rAY, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.26
 * JD-Core Version:    0.7.0.1
 */