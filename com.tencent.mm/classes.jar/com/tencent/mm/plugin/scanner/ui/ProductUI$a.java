package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class ProductUI$a
  implements s
{
  private k.a xdu;
  
  public ProductUI$a(k.a parama)
  {
    this.xdu = parama;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(51872);
    if (s.a.iuo == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
      AppMethodBeat.o(51872);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.scanner.ProductUI", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aNk()
  {
    return null;
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(51871);
    String str = i.dza().iL(this.xdu.field_thumburl, "@S");
    AppMethodBeat.o(51871);
    return str;
  }
  
  public final String aNm()
  {
    if (this.xdu == null) {
      return "";
    }
    return this.xdu.field_thumburl;
  }
  
  public final String aNn()
  {
    if (this.xdu == null) {
      return "";
    }
    return this.xdu.field_thumburl;
  }
  
  public final boolean aNo()
  {
    return false;
  }
  
  public final boolean aNp()
  {
    return false;
  }
  
  public final Bitmap aNq()
  {
    AppMethodBeat.i(51873);
    if (ai.getContext() == null)
    {
      AppMethodBeat.o(51873);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
    AppMethodBeat.o(51873);
    return localBitmap;
  }
  
  public final void aNr() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    if (this.xdu == null) {
      return "";
    }
    return this.xdu.field_thumburl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.a
 * JD-Core Version:    0.7.0.1
 */