package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class f$43
  implements Runnable
{
  f$43(f paramf, int paramInt1, double paramDouble1, double paramDouble2, String paramString, int paramInt2) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(198478);
    int i = j;
    Object localObject;
    Context localContext;
    int k;
    double d1;
    double d2;
    String str;
    int m;
    f.43.1 local1;
    if (f.i(this.EEe) != null)
    {
      i = j;
      if ((f.i(this.EEe) instanceof Activity))
      {
        i = j;
        if (!((Activity)f.i(this.EEe)).isFinishing())
        {
          localObject = f.K(this.EEe);
          localContext = f.i(this.EEe);
          k = this.EEK;
          d1 = this.iaG;
          d2 = this.iaH;
          str = this.EEL;
          m = this.EEM;
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
      localObject = f.b(this.EEe, this.EEM);
      if ((((f.c)localObject).EfN != null) && (((f.c)localObject).EDe != null)) {
        f.a(this.EEe, ((f.c)localObject).EfN, ((f.c)localObject).EDe, "openMapNavigateMenu:fail");
      }
    }
    AppMethodBeat.o(198478);
    return;
    label210:
    ((h)localObject).EFN = m;
    ((h)localObject).EFO = true;
    ((h)localObject).EFP = k;
    ((h)localObject).EFR = new h.e(d1, d2, (byte)0);
    ((h)localObject).EFS = str;
    ((h)localObject).aWN = new WeakReference(localContext);
    ((h)localObject).EFT = local1;
    ((h)localObject).hTg = null;
    if (((h)localObject).hTg == null) {
      ((h)localObject).eYB();
    }
    for (;;)
    {
      i = 1;
      break;
      ((h)localObject).EFW = new h.2((h)localObject);
      if (((h)localObject).vri != null)
      {
        ((h)localObject).EFV = new h.3((h)localObject);
        ((h)localObject).vri.a(((h)localObject).EFR.latitude, ((h)localObject).EFR.longitude, ((h)localObject).EFV);
      }
      ar.f(new h.4((h)localObject));
      ((h)localObject).hTg.b(((h)localObject).EFW);
      ar.o(((h)localObject).EFX, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.43
 * JD-Core Version:    0.7.0.1
 */