package com.tencent.mm.plugin.order.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;

public final class b
  implements v
{
  private static final String knX;
  private String url;
  
  static
  {
    AppMethodBeat.i(43932);
    knX = e.eQz + "wallet";
    AppMethodBeat.o(43932);
  }
  
  public b(String paramString)
  {
    this.url = paramString;
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    AppMethodBeat.i(43931);
    if (v.a.gjx == parama) {}
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aon(), false);
      ab.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(43931);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new File(knX);
          if (!paramString.exists()) {
            paramString.mkdir();
          }
          ab.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
          d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aon(), false);
        }
        catch (IOException paramString)
        {
          ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", paramString, "", new Object[0]);
          ab.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final v.b aom()
  {
    return null;
  }
  
  public final String aon()
  {
    AppMethodBeat.i(43930);
    String str = this.url;
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
      AppMethodBeat.o(43930);
      return null;
    }
    str = String.format("%s/%s", new Object[] { knX, g.w(str.getBytes()) });
    AppMethodBeat.o(43930);
    return str;
  }
  
  public final String aoo()
  {
    return this.url;
  }
  
  public final String aop()
  {
    return this.url;
  }
  
  public final boolean aoq()
  {
    return true;
  }
  
  public final boolean aor()
  {
    return false;
  }
  
  public final Bitmap aos()
  {
    return null;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.c.b
 * JD-Core Version:    0.7.0.1
 */