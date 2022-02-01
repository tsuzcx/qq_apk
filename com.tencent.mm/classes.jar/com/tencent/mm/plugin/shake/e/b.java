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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class b
  implements s
{
  private String thumburl = "";
  private c.a wqP = null;
  
  public b(c.a parama)
  {
    this.wqP = parama;
  }
  
  public b(String paramString)
  {
    this.thumburl = paramString;
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(28620);
    if (s.a.hUk == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
      AppMethodBeat.o(28620);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TVImgGetStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final String aGA()
  {
    AppMethodBeat.i(28618);
    String str = aGz() + "_tv";
    AppMethodBeat.o(28618);
    return str;
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
    AppMethodBeat.i(28621);
    if (aj.getContext() == null)
    {
      AppMethodBeat.o(28621);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
    AppMethodBeat.o(28621);
    return localBitmap;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(28617);
    String str;
    if ((this.wqP != null) && (this.wqP.field_thumburl != null))
    {
      str = m.ir(this.wqP.field_thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    if (this.thumburl != null)
    {
      str = m.ir(this.thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    AppMethodBeat.o(28617);
    return "";
  }
  
  public final String aGz()
  {
    if ((this.wqP != null) && (this.wqP.field_thumburl != null)) {
      return this.wqP.field_thumburl;
    }
    return this.thumburl;
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(28619);
    String str = aGz() + "_tv";
    AppMethodBeat.o(28619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.b
 * JD-Core Version:    0.7.0.1
 */