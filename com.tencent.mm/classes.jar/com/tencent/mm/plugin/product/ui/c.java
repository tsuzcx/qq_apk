package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.wallet_core.d;
import java.io.IOException;

public final class c
  implements p
{
  private static final String wun;
  private String url;
  
  static
  {
    AppMethodBeat.i(66955);
    wun = d.jOc();
    AppMethodBeat.o(66955);
  }
  
  public c(String paramString)
  {
    this.url = paramString;
  }
  
  public static String aRP(String paramString)
  {
    AppMethodBeat.i(66954);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(66954);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { wun, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(66954);
    return paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    AppMethodBeat.i(66953);
    if (p.a.pAS == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, aRP(this.url), false);
      Log.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(66953);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new u(wun);
          if (!paramString.jKS()) {
            paramString.jKY();
          }
          Log.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, aRP(this.url), false);
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          Log.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(p.a parama) {}
  
  public final p.b bTB()
  {
    return null;
  }
  
  public final String bTC()
  {
    AppMethodBeat.i(66952);
    String str = aRP(this.url);
    AppMethodBeat.o(66952);
    return str;
  }
  
  public final String bTD()
  {
    return this.url;
  }
  
  public final String bTE()
  {
    return this.url;
  }
  
  public final boolean bTF()
  {
    return true;
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
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.c
 * JD-Core Version:    0.7.0.1
 */