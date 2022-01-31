package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.util.HashMap;

final class f$b
  implements Runnable
{
  private int eRu;
  private int eRv;
  private String url;
  private String[] weY;
  private String weZ;
  
  private f$b(f paramf) {}
  
  private Bitmap amI(String paramString)
  {
    AppMethodBeat.i(79933);
    if (paramString == null)
    {
      AppMethodBeat.o(79933);
      return null;
    }
    Object localObject;
    if ((this.eRv <= 0) || (this.eRu <= 0)) {
      localObject = x.wx(paramString);
    }
    String str;
    Bitmap localBitmap;
    do
    {
      AppMethodBeat.o(79933);
      return localObject;
      str = paramString + "_" + this.eRu + "_" + this.eRv;
      localBitmap = x.y(str, this.eRu, this.eRv);
      localObject = localBitmap;
    } while (localBitmap != null);
    int i = BackwardSupportUtil.ExifHelper.bY(paramString);
    if ((90 == i) || (270 == i)) {}
    for (paramString = d.d(paramString, this.eRu, this.eRv, true);; paramString = d.d(paramString, this.eRv, this.eRu, true))
    {
      for (;;)
      {
        localObject = paramString;
        if (paramString == null) {
          break;
        }
        localObject = d.b(paramString, i);
        try
        {
          d.a((Bitmap)localObject, 100, Bitmap.CompressFormat.PNG, str, false);
        }
        catch (IOException paramString)
        {
          ab.printErrStackTrace("MicroMsg.ImageEngine", paramString, "", new Object[0]);
        }
      }
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(79934);
    if (this.weP.weE)
    {
      ab.w("MicroMsg.ImageEngine", "on load image jog, isQuit, return");
      AppMethodBeat.o(79934);
      return;
    }
    for (;;)
    {
      Object localObject2;
      int i;
      synchronized (this.weP.eKs)
      {
        if (this.weP.weH.get(this.weZ) == null)
        {
          ab.w("MicroMsg.ImageEngine", "check before decode, no match wait to render view, renderKey is %s, return", new Object[] { this.weZ });
          AppMethodBeat.o(79934);
          return;
        }
        ??? = null;
        localObject2 = null;
        if (this.weY != null)
        {
          i = 0;
          ??? = localObject2;
          if (i < this.weY.length)
          {
            if (i != 0) {
              break label349;
            }
            ??? = amI(this.weY[0]);
            localObject2 = ???;
            if (??? == null) {
              break label428;
            }
            this.weP.weJ.put(this.weZ, ???);
          }
        }
        localObject2 = ???;
        if (??? == null)
        {
          localObject2 = ???;
          if (!bo.isNullOrNil(this.url))
          {
            ??? = x.a(this.weP.i(this.weZ, this.url, this.eRu, this.eRv));
            localObject2 = ???;
            if (??? != null)
            {
              this.weP.weJ.put(this.weZ, ???);
              localObject2 = ???;
            }
          }
        }
        if (localObject2 == null) {}
      }
      synchronized (this.weP.eKs)
      {
        Object localObject6 = (ImageView)this.weP.weH.get(this.weZ);
        if (localObject6 != null)
        {
          this.weP.weI.remove(localObject6);
          f.d locald = (f.d)this.weP.weL.dpz();
          locald.cuM = ((ImageView)localObject6);
          locald.nfX = localObject2;
          this.weP.faV.post(locald);
        }
        this.weP.weH.remove(this.weZ);
        this.weP.weM.cr(this);
        AppMethodBeat.o(79934);
        return;
        localObject3 = finally;
        AppMethodBeat.o(79934);
        throw localObject3;
        label349:
        localObject6 = f.p(this.weY[i], this.url, this.eRu, this.eRv);
        Object localObject4 = (Bitmap)this.weP.weJ.get((String)localObject6);
        ??? = localObject4;
        if (localObject4 == null) {
          ??? = amI(this.weY[i]);
        }
        localObject4 = ???;
        if (??? != null)
        {
          this.weP.weJ.put((String)localObject6, ???);
          continue;
        }
        label428:
        i += 1;
        ??? = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f.b
 * JD-Core Version:    0.7.0.1
 */