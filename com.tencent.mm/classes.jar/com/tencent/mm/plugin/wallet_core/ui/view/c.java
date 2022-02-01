package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public final class c
  implements s
{
  private s.b nSZ;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(71512);
    this.nSZ = new s.b()
    {
      public final Bitmap By(String paramAnonymousString)
      {
        AppMethodBeat.i(71511);
        paramAnonymousString = f.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(71511);
        return paramAnonymousString;
      }
    };
    this.url = paramString;
    AppMethodBeat.o(71512);
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(71514);
    if (s.a.hUk == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        ad.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
        i.lC(paramString, b.akx(this.url));
        AppMethodBeat.o(71514);
        return paramBitmap;
      }
    }
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.akx(this.url), false);
      ad.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(71514);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          i.aMF(b.edz());
          ad.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.akx(this.url), false);
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
    return this.nSZ;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(71513);
    String str = b.akx(this.url);
    AppMethodBeat.o(71513);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.c
 * JD-Core Version:    0.7.0.1
 */