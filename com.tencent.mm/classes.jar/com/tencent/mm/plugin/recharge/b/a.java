package com.tencent.mm.plugin.recharge.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.wallet_core.c;
import java.io.IOException;

public final class a
  implements s
{
  private static final String oGh;
  private String url;
  
  static
  {
    AppMethodBeat.i(67331);
    oGh = c.fVj();
    AppMethodBeat.o(67331);
  }
  
  public a(String paramString)
  {
    this.url = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(67330);
    if (s.a.iQl == parama) {}
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
      ae.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(67330);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new k(oGh);
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ae.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
        }
        catch (IOException paramString)
        {
          ae.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          ae.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aQU()
  {
    return null;
  }
  
  public final String aQV()
  {
    AppMethodBeat.i(67329);
    String str = this.url;
    if (bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(67329);
      return null;
    }
    str = String.format("%s/%s", new Object[] { oGh, g.getMessageDigest(str.getBytes()) });
    AppMethodBeat.o(67329);
    return str;
  }
  
  public final String aQW()
  {
    return this.url;
  }
  
  public final String aQX()
  {
    return this.url;
  }
  
  public final boolean aQY()
  {
    return true;
  }
  
  public final boolean aQZ()
  {
    return false;
  }
  
  public final Bitmap aRa()
  {
    return null;
  }
  
  public final void aRb() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.b.a
 * JD-Core Version:    0.7.0.1
 */