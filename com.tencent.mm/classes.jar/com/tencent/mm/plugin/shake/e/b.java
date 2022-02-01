package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
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
  private c.a Jrt = null;
  private String thumburl = "";
  
  public b(c.a parama)
  {
    this.Jrt = parama;
  }
  
  public b(String paramString)
  {
    this.thumburl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(28620);
    if (s.a.mEp == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bvq(), false);
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
  
  public final void a(s.a parama) {}
  
  public final s.b bvp()
  {
    return null;
  }
  
  public final String bvq()
  {
    AppMethodBeat.i(28617);
    String str;
    if ((this.Jrt != null) && (this.Jrt.field_thumburl != null))
    {
      str = m.kh(this.Jrt.field_thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    if (this.thumburl != null)
    {
      str = m.kh(this.thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    AppMethodBeat.o(28617);
    return "";
  }
  
  public final String bvr()
  {
    if ((this.Jrt != null) && (this.Jrt.field_thumburl != null)) {
      return this.Jrt.field_thumburl;
    }
    return this.thumburl;
  }
  
  public final String bvs()
  {
    AppMethodBeat.i(28618);
    String str = bvr() + "_tv";
    AppMethodBeat.o(28618);
    return str;
  }
  
  public final boolean bvt()
  {
    return false;
  }
  
  public final Bitmap bvu()
  {
    AppMethodBeat.i(28621);
    if (MMApplicationContext.getContext() == null)
    {
      AppMethodBeat.o(28621);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.g.nosdcard_chatting_bg);
    AppMethodBeat.o(28621);
    return localBitmap;
  }
  
  public final void bvv() {}
  
  public final void bvw() {}
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(28619);
    String str = bvr() + "_tv";
    AppMethodBeat.o(28619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.b
 * JD-Core Version:    0.7.0.1
 */