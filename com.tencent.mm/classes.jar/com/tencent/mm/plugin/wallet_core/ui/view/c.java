package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public final class c
  implements s
{
  private s.b owu;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(71512);
    this.owu = new s.b()
    {
      public final Bitmap FC(String paramAnonymousString)
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
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(71514);
    if (s.a.iuo == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        ac.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
        i.lZ(paramString, b.apw(this.url));
        AppMethodBeat.o(71514);
        return paramBitmap;
      }
    }
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.apw(this.url), false);
      ac.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(71514);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          i.aSh(b.esU());
          ac.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.apw(this.url), false);
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
    return this.owu;
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(71513);
    String str = b.apw(this.url);
    AppMethodBeat.o(71513);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.c
 * JD-Core Version:    0.7.0.1
 */