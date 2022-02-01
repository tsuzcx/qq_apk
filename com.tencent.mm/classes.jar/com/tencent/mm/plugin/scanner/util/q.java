package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class q
  implements s
{
  private String mPicUrl = null;
  
  public q(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(52069);
    if (s.a.jNh == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
      AppMethodBeat.o(52069);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(52068);
    String str = j.eOR().jP(this.mPicUrl, "@S");
    AppMethodBeat.o(52068);
    return str;
  }
  
  public final String blB()
  {
    return this.mPicUrl;
  }
  
  public final String blC()
  {
    return this.mPicUrl;
  }
  
  public final boolean blD()
  {
    return false;
  }
  
  public final boolean blE()
  {
    return false;
  }
  
  public final Bitmap blF()
  {
    AppMethodBeat.i(52070);
    if (MMApplicationContext.getContext() == null)
    {
      AppMethodBeat.o(52070);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
    AppMethodBeat.o(52070);
    return localBitmap;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return null;
  }
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.q
 * JD-Core Version:    0.7.0.1
 */