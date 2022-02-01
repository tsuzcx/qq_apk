package com.tencent.mm.plugin.order.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import com.tencent.mm.wallet_core.c;
import java.io.IOException;

public final class b
  implements s
{
  private static final String ntl;
  private String url;
  
  static
  {
    AppMethodBeat.i(66839);
    ntl = c.fjo();
    AppMethodBeat.o(66839);
  }
  
  public b(String paramString)
  {
    this.url = paramString;
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(66838);
    if (s.a.hUk == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
      ad.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(66838);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new e(ntl);
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ad.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
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
  
  public final String aGA()
  {
    return this.url;
  }
  
  public final boolean aGB()
  {
    return true;
  }
  
  public final boolean aGC()
  {
    return false;
  }
  
  public final Bitmap aGD()
  {
    return null;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(66837);
    String str = this.url;
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(66837);
      return null;
    }
    str = String.format("%s/%s", new Object[] { ntl, g.getMessageDigest(str.getBytes()) });
    AppMethodBeat.o(66837);
    return str;
  }
  
  public final String aGz()
  {
    return this.url;
  }
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.c.b
 * JD-Core Version:    0.7.0.1
 */