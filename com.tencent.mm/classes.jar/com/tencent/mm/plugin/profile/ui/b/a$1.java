package com.tencent.mm.plugin.profile.ui.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class a$1
  implements v
{
  a$1(a parama) {}
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return com.tencent.mm.model.c.FP() + ad.bB(a.a(this.nau));
  }
  
  public final String UP()
  {
    return a.a(this.nau);
  }
  
  public final String UQ()
  {
    return a.a(this.nau);
  }
  
  public final boolean UR()
  {
    return false;
  }
  
  public final boolean US()
  {
    return false;
  }
  
  public final Bitmap UT()
  {
    return null;
  }
  
  public final void UU() {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    if (v.a.eRD == parama) {}
    try
    {
      com.tencent.mm.sdk.platformtools.c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
      y.d("MicroMsg.UrlDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.UrlDrawable", paramString, "", new Object[0]);
        y.w("MicroMsg.UrlDrawable", "save bitmap fail");
      }
    }
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return a.a(this.nau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a.1
 * JD-Core Version:    0.7.0.1
 */