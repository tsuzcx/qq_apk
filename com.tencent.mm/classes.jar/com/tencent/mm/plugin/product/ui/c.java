package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class c
  implements s
{
  private static final String ozF;
  private String url;
  
  static
  {
    AppMethodBeat.i(66955);
    ozF = com.tencent.mm.wallet_core.c.fQN();
    AppMethodBeat.o(66955);
  }
  
  public c(String paramString)
  {
    this.url = paramString;
  }
  
  public static String auC(String paramString)
  {
    AppMethodBeat.i(66954);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(66954);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { ozF, com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(66954);
    return paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(66953);
    if (s.a.iNr == parama) {}
    try
    {
      com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, auC(this.url), false);
      ad.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(66953);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new e(ozF);
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ad.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, auC(this.url), false);
        }
        catch (IOException paramString)
        {
          ad.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          ad.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final boolean aQA()
  {
    return false;
  }
  
  public final Bitmap aQB()
  {
    return null;
  }
  
  public final void aQC() {}
  
  public final s.b aQv()
  {
    return null;
  }
  
  public final String aQw()
  {
    AppMethodBeat.i(66952);
    String str = auC(this.url);
    AppMethodBeat.o(66952);
    return str;
  }
  
  public final String aQx()
  {
    return this.url;
  }
  
  public final String aQy()
  {
    return this.url;
  }
  
  public final boolean aQz()
  {
    return true;
  }
  
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