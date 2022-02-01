package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.o;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class s
  implements p
{
  private String mPicUrl = null;
  
  public s(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    AppMethodBeat.i(52069);
    if (p.a.pAS == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
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
  
  public final void a(p.a parama) {}
  
  public final p.b bTB()
  {
    return null;
  }
  
  public final String bTC()
  {
    AppMethodBeat.i(52068);
    String str = o.gPw().lG(this.mPicUrl, "@S");
    AppMethodBeat.o(52068);
    return str;
  }
  
  public final String bTD()
  {
    return this.mPicUrl;
  }
  
  public final String bTE()
  {
    return this.mPicUrl;
  }
  
  public final boolean bTF()
  {
    return false;
  }
  
  public final boolean bTG()
  {
    return false;
  }
  
  public final Bitmap bTH()
  {
    AppMethodBeat.i(52070);
    if (MMApplicationContext.getContext() == null)
    {
      AppMethodBeat.o(52070);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), l.e.nosdcard_chatting_bg);
    AppMethodBeat.o(52070);
    return localBitmap;
  }
  
  public final void bTI() {}
  
  public final void bTJ() {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.s
 * JD-Core Version:    0.7.0.1
 */