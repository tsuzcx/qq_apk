package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class b
  implements v
{
  private c.a qSa = null;
  private String thumburl = "";
  
  public b(c.a parama)
  {
    this.qSa = parama;
  }
  
  public b(String paramString)
  {
    this.thumburl = paramString;
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    AppMethodBeat.i(24951);
    if (v.a.gjx == parama) {}
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aon(), false);
      AppMethodBeat.o(24951);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TVImgGetStrategy", parama, "", new Object[0]);
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
    AppMethodBeat.i(24948);
    String str;
    if ((this.qSa != null) && (this.qSa.field_thumburl != null))
    {
      str = m.gb(this.qSa.field_thumburl, "@S");
      AppMethodBeat.o(24948);
      return str;
    }
    if (this.thumburl != null)
    {
      str = m.gb(this.thumburl, "@S");
      AppMethodBeat.o(24948);
      return str;
    }
    AppMethodBeat.o(24948);
    return "";
  }
  
  public final String aoo()
  {
    if ((this.qSa != null) && (this.qSa.field_thumburl != null)) {
      return this.qSa.field_thumburl;
    }
    return this.thumburl;
  }
  
  public final String aop()
  {
    AppMethodBeat.i(24949);
    String str = aoo() + "_tv";
    AppMethodBeat.o(24949);
    return str;
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
    AppMethodBeat.i(24952);
    if (ah.getContext() == null)
    {
      AppMethodBeat.o(24952);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
    AppMethodBeat.o(24952);
    return localBitmap;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(24950);
    String str = aoo() + "_tv";
    AppMethodBeat.o(24950);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.b
 * JD-Core Version:    0.7.0.1
 */