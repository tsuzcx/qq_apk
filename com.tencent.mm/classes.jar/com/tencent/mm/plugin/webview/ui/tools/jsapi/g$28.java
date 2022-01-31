package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class g$28
  implements Runnable
{
  g$28(g paramg, int paramInt1, double paramDouble1, double paramDouble2, String paramString, int paramInt2) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(154951);
    int i = j;
    Object localObject;
    Context localContext;
    int k;
    double d1;
    double d2;
    String str;
    int m;
    g.28.1 local1;
    if (g.j(this.vqm) != null)
    {
      i = j;
      if ((g.j(this.vqm) instanceof Activity))
      {
        i = j;
        if (!((Activity)g.j(this.vqm)).isFinishing())
        {
          localObject = g.K(this.vqm);
          localContext = g.j(this.vqm);
          k = this.vqJ;
          d1 = this.fCg;
          d2 = this.fCh;
          str = this.vqK;
          m = this.vqL;
          local1 = new g.28.1(this);
          i = j;
          if (localContext != null)
          {
            i = j;
            if ((localContext instanceof MMActivity))
            {
              if (!((MMActivity)localContext).isFinishing()) {
                break label210;
              }
              i = j;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      localObject = g.b(this.vqm, this.vqL);
      if ((((g.c)localObject).uWu != null) && (((g.c)localObject).vpn != null)) {
        g.a(this.vqm, ((g.c)localObject).uWu, ((g.c)localObject).vpn, "openMapNavigateMenu:fail");
      }
    }
    AppMethodBeat.o(154951);
    return;
    label210:
    ((j)localObject).vrR = m;
    ((j)localObject).vrS = true;
    ((j)localObject).vrT = k;
    ((j)localObject).vrV = new j.e(d1, d2, (byte)0);
    ((j)localObject).vrW = str;
    ((j)localObject).aqU = new WeakReference(localContext);
    ((j)localObject).vrX = local1;
    ((j)localObject).fwu = null;
    if (((j)localObject).fwu == null) {
      ((j)localObject).dgR();
    }
    for (;;)
    {
      i = 1;
      break;
      ((j)localObject).vsa = new j.2((j)localObject);
      if (((j)localObject).ofr != null)
      {
        ((j)localObject).vrZ = new j.3((j)localObject);
        ((j)localObject).ofr.a(((j)localObject).vrV.latitude, ((j)localObject).vrV.longitude, ((j)localObject).vrZ);
      }
      al.d(new j.4((j)localObject));
      ((j)localObject).fwu.b(((j)localObject).vsa);
      al.p(((j)localObject).vsb, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.28
 * JD-Core Version:    0.7.0.1
 */