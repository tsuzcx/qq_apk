package com.tencent.mm.plugin.recharge.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

public final class a
  implements v
{
  private static final String inc = e.bkH + "wallet";
  private String url;
  
  public a(String paramString)
  {
    this.url = paramString;
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    String str = this.url;
    if (bk.bl(str))
    {
      y.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      return null;
    }
    return String.format("%s/%s", new Object[] { inc, g.o(str.getBytes()) });
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
    if (v.a.eRD == parama) {}
    try
    {
      c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
      y.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new File(inc);
          if (!paramString.exists()) {
            paramString.mkdir();
          }
          y.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.b.a
 * JD-Core Version:    0.7.0.1
 */