package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;

final class g$a
  implements s
{
  private String mPicUrl = null;
  
  public g$a(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(51830);
    if (s.a.iQl == parama) {}
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
      AppMethodBeat.o(51830);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ProductGridPreference", parama, "", new Object[0]);
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
    AppMethodBeat.i(51829);
    String str = j.dNQ().je(this.mPicUrl, "@S");
    AppMethodBeat.o(51829);
    return str;
  }
  
  public final String aQW()
  {
    return this.mPicUrl;
  }
  
  public final String aQX()
  {
    return this.mPicUrl;
  }
  
  public final boolean aQY()
  {
    return false;
  }
  
  public final boolean aQZ()
  {
    return false;
  }
  
  public final Bitmap aRa()
  {
    AppMethodBeat.i(51831);
    if (ak.getContext() == null)
    {
      AppMethodBeat.o(51831);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
    AppMethodBeat.o(51831);
    return localBitmap;
  }
  
  public final void aRb() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.g.a
 * JD-Core Version:    0.7.0.1
 */