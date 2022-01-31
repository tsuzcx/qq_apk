package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class ProductUI$a
  implements v
{
  private q.a qxP;
  
  public ProductUI$a(q.a parama)
  {
    this.qxP = parama;
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    AppMethodBeat.i(81101);
    if (v.a.gjx == parama) {}
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aon(), false);
      AppMethodBeat.o(81101);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.scanner.ProductUI", parama, "", new Object[0]);
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
    AppMethodBeat.i(81100);
    String str = e.chX().gb(this.qxP.field_thumburl, "@S");
    AppMethodBeat.o(81100);
    return str;
  }
  
  public final String aoo()
  {
    if (this.qxP == null) {
      return "";
    }
    return this.qxP.field_thumburl;
  }
  
  public final String aop()
  {
    if (this.qxP == null) {
      return "";
    }
    return this.qxP.field_thumburl;
  }
  
  public final boolean aoq()
  {
    return false;
  }
  
  public final boolean aor()
  {
    return false;
  }
  
  public final Bitmap aos()
  {
    AppMethodBeat.i(81102);
    if (ah.getContext() == null)
    {
      AppMethodBeat.o(81102);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
    AppMethodBeat.o(81102);
    return localBitmap;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    if (this.qxP == null) {
      return "";
    }
    return this.qxP.field_thumburl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.a
 * JD-Core Version:    0.7.0.1
 */