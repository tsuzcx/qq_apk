package com.tencent.mm.plugin.recharge.b;

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
import com.tencent.mm.wallet_core.c;
import java.io.IOException;

public final class a
  implements s
{
  private static final String nWl;
  private String url;
  
  static
  {
    AppMethodBeat.i(67331);
    nWl = c.fzD();
    AppMethodBeat.o(67331);
  }
  
  public a(String paramString)
  {
    this.url = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(67330);
    if (s.a.iuo == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
      ac.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(67330);
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
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
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
    AppMethodBeat.i(67329);
    String str = this.url;
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(67329);
      return null;
    }
    str = String.format("%s/%s", new Object[] { nWl, g.getMessageDigest(str.getBytes()) });
    AppMethodBeat.o(67329);
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
 * Qualified Name:     com.tencent.mm.plugin.recharge.b.a
 * JD-Core Version:    0.7.0.1
 */