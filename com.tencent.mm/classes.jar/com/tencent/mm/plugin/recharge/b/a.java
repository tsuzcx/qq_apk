package com.tencent.mm.plugin.recharge.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.c;
import java.io.IOException;

public final class a
  implements s
{
  private static final String pTN;
  private String url;
  
  static
  {
    AppMethodBeat.i(67331);
    pTN = c.hgG();
    AppMethodBeat.o(67331);
  }
  
  public a(String paramString)
  {
    this.url = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(67330);
    if (s.a.jNh == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
      Log.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(67330);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new o(pTN);
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          Log.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          Log.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(67329);
    String str = this.url;
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(67329);
      return null;
    }
    str = String.format("%s/%s", new Object[] { pTN, g.getMessageDigest(str.getBytes()) });
    AppMethodBeat.o(67329);
    return str;
  }
  
  public final String blB()
  {
    return this.url;
  }
  
  public final String blC()
  {
    return this.url;
  }
  
  public final boolean blD()
  {
    return true;
  }
  
  public final boolean blE()
  {
    return false;
  }
  
  public final Bitmap blF()
  {
    return null;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return null;
  }
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.b.a
 * JD-Core Version:    0.7.0.1
 */