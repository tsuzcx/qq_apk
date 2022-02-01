package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class c
  implements s
{
  private s.b pgt;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(71512);
    this.pgt = new s.b()
    {
      public final Bitmap Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(71511);
        paramAnonymousString = h.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(71511);
        return paramAnonymousString;
      }
    };
    this.url = paramString;
    AppMethodBeat.o(71512);
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(71514);
    if (s.a.iQl == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        ae.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
        o.mF(paramString, b.avR(this.url));
        AppMethodBeat.o(71514);
        return paramBitmap;
      }
    }
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.avR(this.url), false);
      ae.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(71514);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          o.aZI(b.eKI());
          ae.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.avR(this.url), false);
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
    return this.pgt;
  }
  
  public final String aQV()
  {
    AppMethodBeat.i(71513);
    String str = b.avR(this.url);
    AppMethodBeat.o(71513);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.c
 * JD-Core Version:    0.7.0.1
 */