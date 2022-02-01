package com.tencent.mm.plugin.profile.ui.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.io.IOException;

public final class c
  extends BitmapDrawable
  implements r.a
{
  private String url;
  
  public c(Resources paramResources, String paramString) {}
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(27609);
    Object localObject2 = r.a(new p()
    {
      public final Bitmap a(Bitmap paramAnonymousBitmap, p.a paramAnonymousa, String paramAnonymousString)
      {
        AppMethodBeat.i(27603);
        if (p.a.pAS == paramAnonymousa) {}
        try
        {
          BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
          Log.d("MicroMsg.UrlDrawable", "get bitmap, from %s", new Object[] { paramAnonymousa.toString() });
          AppMethodBeat.o(27603);
          return paramAnonymousBitmap;
        }
        catch (IOException paramAnonymousString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.UrlDrawable", paramAnonymousString, "", new Object[0]);
            Log.w("MicroMsg.UrlDrawable", "save bitmap fail");
          }
        }
      }
      
      public final void a(p.a paramAnonymousa) {}
      
      public final p.b bTB()
      {
        return null;
      }
      
      public final String bTC()
      {
        AppMethodBeat.i(27604);
        Object localObject = new StringBuilder();
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzU() + MD5Util.getMD5String(c.a(c.this));
        AppMethodBeat.o(27604);
        return localObject;
      }
      
      public final String bTD()
      {
        AppMethodBeat.i(27606);
        String str = c.a(c.this);
        AppMethodBeat.o(27606);
        return str;
      }
      
      public final String bTE()
      {
        AppMethodBeat.i(27605);
        String str = c.a(c.this);
        AppMethodBeat.o(27605);
        return str;
      }
      
      public final boolean bTF()
      {
        return false;
      }
      
      public final boolean bTG()
      {
        return false;
      }
      
      public final Bitmap bTH()
      {
        return null;
      }
      
      public final void bTI() {}
      
      public final void bTJ() {}
      
      public final String getCacheKey()
      {
        AppMethodBeat.i(27607);
        String str = c.a(c.this);
        AppMethodBeat.o(27607);
        return str;
      }
    });
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = getBounds();
    if (localObject1 != null) {
      paramCanvas.drawBitmap(localObject1, null, (Rect)localObject2, null);
    }
    AppMethodBeat.o(27609);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(27610);
    if (this.url.equals(paramString)) {
      invalidateSelf();
    }
    AppMethodBeat.o(27610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.c
 * JD-Core Version:    0.7.0.1
 */