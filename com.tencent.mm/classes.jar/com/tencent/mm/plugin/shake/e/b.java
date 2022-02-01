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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;

public final class b
  implements s
{
  private String thumburl = "";
  private c.a zha = null;
  
  public b(c.a parama)
  {
    this.zha = parama;
  }
  
  public b(String paramString)
  {
    this.thumburl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(28620);
    if (s.a.iQl == parama) {}
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
      AppMethodBeat.o(28620);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TVImgGetStrategy", parama, "", new Object[0]);
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
    AppMethodBeat.i(28617);
    String str;
    if ((this.zha != null) && (this.zha.field_thumburl != null))
    {
      str = m.je(this.zha.field_thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    if (this.thumburl != null)
    {
      str = m.je(this.thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    AppMethodBeat.o(28617);
    return "";
  }
  
  public final String aQW()
  {
    if ((this.zha != null) && (this.zha.field_thumburl != null)) {
      return this.zha.field_thumburl;
    }
    return this.thumburl;
  }
  
  public final String aQX()
  {
    AppMethodBeat.i(28618);
    String str = aQW() + "_tv";
    AppMethodBeat.o(28618);
    return str;
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
    AppMethodBeat.i(28621);
    if (ak.getContext() == null)
    {
      AppMethodBeat.o(28621);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
    AppMethodBeat.o(28621);
    return localBitmap;
  }
  
  public final void aRb() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(28619);
    String str = aQW() + "_tv";
    AppMethodBeat.o(28619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.b
 * JD-Core Version:    0.7.0.1
 */