package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class c
  implements s
{
  private static final String nWl;
  private String url;
  
  static
  {
    AppMethodBeat.i(66955);
    nWl = com.tencent.mm.wallet_core.c.fzD();
    AppMethodBeat.o(66955);
  }
  
  public c(String paramString)
  {
    this.url = paramString;
  }
  
  public static String apw(String paramString)
  {
    AppMethodBeat.i(66954);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(66954);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { nWl, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(66954);
    return paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(66953);
    if (s.a.iuo == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, apw(this.url), false);
      ac.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(66953);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new e(nWl);
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ac.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, apw(this.url), false);
        }
        catch (IOException paramString)
        {
          ac.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          ac.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aNk()
  {
    return null;
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(66952);
    String str = apw(this.url);
    AppMethodBeat.o(66952);
    return str;
  }
  
  public final String aNm()
  {
    return this.url;
  }
  
  public final String aNn()
  {
    return this.url;
  }
  
  public final boolean aNo()
  {
    return true;
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
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.c
 * JD-Core Version:    0.7.0.1
 */