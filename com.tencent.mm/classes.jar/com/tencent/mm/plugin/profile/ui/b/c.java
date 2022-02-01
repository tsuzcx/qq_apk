package com.tencent.mm.plugin.profile.ui.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class c
  extends BitmapDrawable
  implements u.a
{
  private String url;
  
  public c(Resources paramResources, String paramString) {}
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(27609);
    Object localObject2 = u.a(new s()
    {
      public final Bitmap a(Bitmap paramAnonymousBitmap, s.a paramAnonymousa, String paramAnonymousString)
      {
        AppMethodBeat.i(27603);
        if (s.a.iuo == paramAnonymousa) {}
        try
        {
          f.a(paramAnonymousBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
          ac.d("MicroMsg.UrlDrawable", "get bitmap, from %s", new Object[] { paramAnonymousa.toString() });
          AppMethodBeat.o(27603);
          return paramAnonymousBitmap;
        }
        catch (IOException paramAnonymousString)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.UrlDrawable", paramAnonymousString, "", new Object[0]);
            ac.w("MicroMsg.UrlDrawable", "save bitmap fail");
          }
        }
      }
      
      public final void a(s.a paramAnonymousa, String paramAnonymousString) {}
      
      public final s.b aNk()
      {
        return null;
      }
      
      public final String aNl()
      {
        AppMethodBeat.i(27604);
        Object localObject = new StringBuilder();
        az.ayM();
        localObject = com.tencent.mm.model.c.awU() + ah.dg(c.a(c.this));
        AppMethodBeat.o(27604);
        return localObject;
      }
      
      public final String aNm()
      {
        AppMethodBeat.i(27606);
        String str = c.a(c.this);
        AppMethodBeat.o(27606);
        return str;
      }
      
      public final String aNn()
      {
        AppMethodBeat.i(27605);
        String str = c.a(c.this);
        AppMethodBeat.o(27605);
        return str;
      }
      
      public final boolean aNo()
      {
        return false;
      }
      
      public final boolean aNp()
      {
        return false;
      }
      
      public final Bitmap aNq()
      {
        return null;
      }
      
      public final void aNr() {}
      
      public final void aa(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.c
 * JD-Core Version:    0.7.0.1
 */