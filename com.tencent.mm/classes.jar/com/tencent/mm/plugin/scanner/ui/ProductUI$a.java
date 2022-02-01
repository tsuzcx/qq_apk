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
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;

public final class ProductUI$a
  implements s
{
  private k.a yHw;
  
  public ProductUI$a(k.a parama)
  {
    this.yHw = parama;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(51872);
    if (s.a.iQl == parama) {}
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
      AppMethodBeat.o(51872);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.scanner.ProductUI", parama, "", new Object[0]);
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
    AppMethodBeat.i(51871);
    String str = j.dNQ().je(this.yHw.field_thumburl, "@S");
    AppMethodBeat.o(51871);
    return str;
  }
  
  public final String aQW()
  {
    if (this.yHw == null) {
      return "";
    }
    return this.yHw.field_thumburl;
  }
  
  public final String aQX()
  {
    if (this.yHw == null) {
      return "";
    }
    return this.yHw.field_thumburl;
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
    AppMethodBeat.i(51873);
    if (ak.getContext() == null)
    {
      AppMethodBeat.o(51873);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
    AppMethodBeat.o(51873);
    return localBitmap;
  }
  
  public final void aRb() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    if (this.yHw == null) {
      return "";
    }
    return this.yHw.field_thumburl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.a
 * JD-Core Version:    0.7.0.1
 */