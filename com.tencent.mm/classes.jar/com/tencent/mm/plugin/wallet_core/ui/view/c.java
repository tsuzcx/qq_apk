package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class c
  implements v
{
  private v.b iGL = new c.1(this);
  private String url;
  
  public c(String paramString)
  {
    this.url = paramString;
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return this.iGL;
  }
  
  public final String UO()
  {
    return b.KR(this.url);
  }
  
  public final String UP()
  {
    return this.url;
  }
  
  public final String UQ()
  {
    return this.url;
  }
  
  public final boolean UR()
  {
    return true;
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
    if (v.a.eRD == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        y.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
        e.r(paramString, b.KR(this.url));
        return paramBitmap;
      }
    }
    try
    {
      com.tencent.mm.sdk.platformtools.c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.KR(this.url), false);
      y.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          e.nb(b.bWn());
          y.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          com.tencent.mm.sdk.platformtools.c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.KR(this.url), false);
        }
        catch (IOException paramString)
        {
          y.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          y.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.c
 * JD-Core Version:    0.7.0.1
 */