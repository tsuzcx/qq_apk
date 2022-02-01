package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class f$43
  implements Runnable
{
  f$43(f paramf, int paramInt1, double paramDouble1, double paramDouble2, String paramString, int paramInt2) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(208296);
    int i = j;
    Object localObject;
    Context localContext;
    int k;
    double d1;
    double d2;
    String str;
    int m;
    f.43.1 local1;
    if (f.i(this.Ema) != null)
    {
      i = j;
      if ((f.i(this.Ema) instanceof Activity))
      {
        i = j;
        if (!((Activity)f.i(this.Ema)).isFinishing())
        {
          localObject = f.K(this.Ema);
          localContext = f.i(this.Ema);
          k = this.EmG;
          d1 = this.hXO;
          d2 = this.hXP;
          str = this.EmH;
          m = this.EmI;
          local1 = new f.43.1(this);
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
      localObject = f.b(this.Ema, this.EmI);
      if ((((f.c)localObject).DNO != null) && (((f.c)localObject).Ela != null)) {
        f.a(this.Ema, ((f.c)localObject).DNO, ((f.c)localObject).Ela, "openMapNavigateMenu:fail");
      }
    }
    AppMethodBeat.o(208296);
    return;
    label210:
    ((h)localObject).EnJ = m;
    ((h)localObject).EnK = true;
    ((h)localObject).EnL = k;
    ((h)localObject).EnN = new h.e(d1, d2, (byte)0);
    ((h)localObject).EnO = str;
    ((h)localObject).aWN = new WeakReference(localContext);
    ((h)localObject).EnP = local1;
    ((h)localObject).hQo = null;
    if (((h)localObject).hQo == null) {
      ((h)localObject).eUO();
    }
    for (;;)
    {
      i = 1;
      break;
      ((h)localObject).EnS = new h.2((h)localObject);
      if (((h)localObject).vfb != null)
      {
        ((h)localObject).EnR = new h.3((h)localObject);
        ((h)localObject).vfb.a(((h)localObject).EnN.latitude, ((h)localObject).EnN.longitude, ((h)localObject).EnR);
      }
      aq.f(new h.4((h)localObject));
      ((h)localObject).hQo.b(((h)localObject).EnS);
      aq.o(((h)localObject).EnT, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.43
 * JD-Core Version:    0.7.0.1
 */