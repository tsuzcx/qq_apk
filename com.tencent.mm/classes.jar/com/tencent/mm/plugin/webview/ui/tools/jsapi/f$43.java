package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class f$43
  implements Runnable
{
  f$43(f paramf, int paramInt1, double paramDouble1, double paramDouble2, String paramString, int paramInt2) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(211389);
    int i = j;
    Object localObject;
    Context localContext;
    int k;
    double d1;
    double d2;
    String str;
    int m;
    f.43.1 local1;
    if (f.i(this.JtL) != null)
    {
      i = j;
      if ((f.i(this.JtL) instanceof Activity))
      {
        i = j;
        if (!((Activity)f.i(this.JtL)).isFinishing())
        {
          localObject = f.K(this.JtL);
          localContext = f.i(this.JtL);
          k = this.Jur;
          d1 = this.iVE;
          d2 = this.iVF;
          str = this.Jus;
          m = this.Jut;
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
      localObject = f.b(this.JtL, this.Jut);
      if ((((f.c)localObject).ISw != null) && (((f.c)localObject).JsF != null)) {
        f.a(this.JtL, ((f.c)localObject).ISw, ((f.c)localObject).JsF, "openMapNavigateMenu:fail");
      }
    }
    AppMethodBeat.o(211389);
    return;
    label210:
    ((h)localObject).Jvq = m;
    ((h)localObject).Jvr = true;
    ((h)localObject).Jvs = k;
    ((h)localObject).Jvu = new h.e(d1, d2, (byte)0);
    ((h)localObject).Jvv = str;
    ((h)localObject).aWF = new WeakReference(localContext);
    ((h)localObject).Jvw = local1;
    ((h)localObject).iOv = null;
    if (((h)localObject).iOv == null) {
      ((h)localObject).ghG();
    }
    for (;;)
    {
      i = 1;
      break;
      ((h)localObject).Jvz = new h.2((h)localObject);
      if (((h)localObject).yKY != null)
      {
        ((h)localObject).Jvy = new h.3((h)localObject);
        ((h)localObject).yKY.a(((h)localObject).Jvu.latitude, ((h)localObject).Jvu.longitude, ((h)localObject).Jvy);
      }
      MMHandlerThread.postToMainThread(new h.4((h)localObject));
      ((h)localObject).iOv.b(((h)localObject).Jvz);
      MMHandlerThread.postToMainThreadDelayed(((h)localObject).JvA, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.43
 * JD-Core Version:    0.7.0.1
 */