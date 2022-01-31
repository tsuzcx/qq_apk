package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;

final class g$b
  implements Runnable
{
  private int eIB;
  private int eIC;
  private String[] smw;
  private String smx;
  private String url;
  
  private g$b(g paramg) {}
  
  private Bitmap WY(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    String str;
    Bitmap localBitmap;
    do
    {
      return localObject;
      if ((this.eIC <= 0) || (this.eIB <= 0)) {
        return x.pg(paramString);
      }
      str = paramString + "_" + this.eIB + "_" + this.eIC;
      localBitmap = x.o(str, this.eIB, this.eIC);
      localObject = localBitmap;
    } while (localBitmap != null);
    int i = BackwardSupportUtil.ExifHelper.YS(paramString);
    if ((90 == i) || (270 == i)) {}
    for (paramString = c.e(paramString, this.eIB, this.eIC, true);; paramString = c.e(paramString, this.eIC, this.eIB, true))
    {
      localObject = paramString;
      if (paramString == null) {
        break;
      }
      paramString = c.b(paramString, i);
      try
      {
        c.a(paramString, 100, Bitmap.CompressFormat.PNG, str, false);
        return paramString;
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.ImageEngine", localIOException, "", new Object[0]);
        return paramString;
      }
    }
  }
  
  public final void run()
  {
    if (this.smn.smc)
    {
      y.w("MicroMsg.ImageEngine", "on load image jog, isQuit, return");
      return;
    }
    synchronized (this.smn.dMQ)
    {
      if (this.smn.smf.get(this.smx) == null)
      {
        y.w("MicroMsg.ImageEngine", "check before decode, no match wait to render view, renderKey is %s, return", new Object[] { this.smx });
        return;
      }
    }
    ??? = null;
    Object localObject3 = null;
    int i;
    if (this.smw != null)
    {
      i = 0;
      ??? = localObject3;
    }
    for (;;)
    {
      if (i < this.smw.length)
      {
        if (i == 0)
        {
          ??? = WY(this.smw[0]);
          localObject3 = ???;
          if (??? == null) {
            break label403;
          }
          this.smn.smh.put(this.smx, ???);
        }
      }
      else
      {
        label134:
        localObject3 = ???;
        if (??? == null)
        {
          localObject3 = ???;
          if (!bk.bl(this.url))
          {
            ??? = x.a(this.smn.h(this.smx, this.url, this.eIB, this.eIC));
            localObject3 = ???;
            if (??? != null)
            {
              this.smn.smh.put(this.smx, ???);
              localObject3 = ???;
            }
          }
        }
        if (localObject3 == null) {}
      }
      synchronized (this.smn.dMQ)
      {
        Object localObject5 = (ImageView)this.smn.smf.get(this.smx);
        if (localObject5 != null)
        {
          this.smn.smg.remove(localObject5);
          g.e locale = (g.e)this.smn.smj.cok();
          locale.bNu = ((ImageView)localObject5);
          locale.kJz = ((Bitmap)localObject3);
          this.smn.dPi.post(locale);
        }
        this.smn.smf.remove(this.smx);
        this.smn.smk.bO(this);
        return;
        localObject5 = g.q(this.smw[i], this.url, this.eIB, this.eIC);
        localObject3 = (Bitmap)this.smn.smh.get(localObject5);
        ??? = localObject3;
        if (localObject3 == null) {
          ??? = WY(this.smw[i]);
        }
        localObject3 = ???;
        if (??? != null)
        {
          this.smn.smh.put(localObject5, ???);
          break label134;
        }
        label403:
        i += 1;
        ??? = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.b
 * JD-Core Version:    0.7.0.1
 */