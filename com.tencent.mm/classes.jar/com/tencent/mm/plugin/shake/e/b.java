package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b
  implements s
{
  private c.a DlR = null;
  private String thumburl = "";
  
  public b(c.a parama)
  {
    this.DlR = parama;
  }
  
  public b(String paramString)
  {
    this.thumburl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(28620);
    if (s.a.jNh == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
      AppMethodBeat.o(28620);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TVImgGetStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(28617);
    String str;
    if ((this.DlR != null) && (this.DlR.field_thumburl != null))
    {
      str = m.jP(this.DlR.field_thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    if (this.thumburl != null)
    {
      str = m.jP(this.thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    AppMethodBeat.o(28617);
    return "";
  }
  
  public final String blB()
  {
    if ((this.DlR != null) && (this.DlR.field_thumburl != null)) {
      return this.DlR.field_thumburl;
    }
    return this.thumburl;
  }
  
  public final String blC()
  {
    AppMethodBeat.i(28618);
    String str = blB() + "_tv";
    AppMethodBeat.o(28618);
    return str;
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
    AppMethodBeat.i(28621);
    if (MMApplicationContext.getContext() == null)
    {
      AppMethodBeat.o(28621);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
    AppMethodBeat.o(28621);
    return localBitmap;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return null;
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(28619);
    String str = blB() + "_tv";
    AppMethodBeat.o(28619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.b
 * JD-Core Version:    0.7.0.1
 */