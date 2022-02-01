package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class c
  implements com.tencent.mm.platformtools.s
{
  private s.b qvE;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(71512);
    this.qvE = new s.b()
    {
      public final Bitmap So(String paramAnonymousString)
      {
        AppMethodBeat.i(71511);
        paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
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
    if (s.a.jNh == parama) {
      if ((paramBitmap != null) && (paramBitmap.getNinePatchChunk() != null))
      {
        Log.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
        com.tencent.mm.vfs.s.nw(paramString, b.aKj(this.url));
        AppMethodBeat.o(71514);
        return paramBitmap;
      }
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.aKj(this.url), false);
      Log.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(71514);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.s.boN(b.fSn());
          Log.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.aKj(this.url), false);
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          Log.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(71513);
    String str = b.aKj(this.url);
    AppMethodBeat.o(71513);
    return str;
  }
  
  public final String blB()
  {
    return this.url;
  }
  
  public final String blC()
  {
    return this.url;
  }
  
  public final boolean blD()
  {
    return true;
  }
  
  public final boolean blE()
  {
    return false;
  }
  
  public final Bitmap blF()
  {
    return null;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return this.qvE;
  }
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.c
 * JD-Core Version:    0.7.0.1
 */