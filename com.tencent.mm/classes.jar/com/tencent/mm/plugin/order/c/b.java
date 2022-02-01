package com.tencent.mm.plugin.order.c;

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

public final class b
  implements p
{
  private static final String wun;
  private String url;
  
  static
  {
    AppMethodBeat.i(66839);
    wun = d.jOc();
    AppMethodBeat.o(66839);
  }
  
  public b(String paramString)
  {
    this.url = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    AppMethodBeat.i(66838);
    if (p.a.pAS == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
      Log.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(66838);
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
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
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
    AppMethodBeat.i(66837);
    String str = this.url;
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(66837);
      return null;
    }
    str = String.format("%s/%s", new Object[] { wun, g.getMessageDigest(str.getBytes()) });
    AppMethodBeat.o(66837);
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
 * Qualified Name:     com.tencent.mm.plugin.order.c.b
 * JD-Core Version:    0.7.0.1
 */