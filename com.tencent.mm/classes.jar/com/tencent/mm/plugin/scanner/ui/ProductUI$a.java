package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.scanner.h;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class ProductUI$a
  implements s
{
  private k.a vSJ;
  
  public ProductUI$a(k.a parama)
  {
    this.vSJ = parama;
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(51872);
    if (s.a.hUk == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
      AppMethodBeat.o(51872);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.scanner.ProductUI", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final String aGA()
  {
    if (this.vSJ == null) {
      return "";
    }
    return this.vSJ.field_thumburl;
  }
  
  public final boolean aGB()
  {
    return false;
  }
  
  public final boolean aGC()
  {
    return false;
  }
  
  public final Bitmap aGD()
  {
    AppMethodBeat.i(51873);
    if (aj.getContext() == null)
    {
      AppMethodBeat.o(51873);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
    AppMethodBeat.o(51873);
    return localBitmap;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(51871);
    String str = h.dkY().ir(this.vSJ.field_thumburl, "@S");
    AppMethodBeat.o(51871);
    return str;
  }
  
  public final String aGz()
  {
    if (this.vSJ == null) {
      return "";
    }
    return this.vSJ.field_thumburl;
  }
  
  public final String getCacheKey()
  {
    if (this.vSJ == null) {
      return "";
    }
    return this.vSJ.field_thumburl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.a
 * JD-Core Version:    0.7.0.1
 */