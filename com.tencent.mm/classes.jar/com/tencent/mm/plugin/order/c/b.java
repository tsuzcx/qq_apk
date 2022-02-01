package com.tencent.mm.plugin.order.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.wallet_core.c;
import java.io.IOException;

public final class b
  implements s
{
  private static final String tpO;
  private String url;
  
  static
  {
    AppMethodBeat.i(66839);
    tpO = c.iii();
    AppMethodBeat.o(66839);
  }
  
  public b(String paramString)
  {
    this.url = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(66838);
    if (s.a.mEp == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bvq(), false);
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
          paramString = new q(tpO);
          if (!paramString.ifE()) {
            paramString.ifK();
          }
          Log.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bvq(), false);
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          Log.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama) {}
  
  public final s.b bvp()
  {
    return null;
  }
  
  public final String bvq()
  {
    AppMethodBeat.i(66837);
    String str = this.url;
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(66837);
      return null;
    }
    str = String.format("%s/%s", new Object[] { tpO, g.getMessageDigest(str.getBytes()) });
    AppMethodBeat.o(66837);
    return str;
  }
  
  public final String bvr()
  {
    return this.url;
  }
  
  public final String bvs()
  {
    return this.url;
  }
  
  public final boolean bvt()
  {
    return true;
  }
  
  public final Bitmap bvu()
  {
    return null;
  }
  
  public final void bvv() {}
  
  public final void bvw() {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.c.b
 * JD-Core Version:    0.7.0.1
 */