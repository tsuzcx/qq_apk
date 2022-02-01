package com.tencent.mm.plugin.shake.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.plugin.shake.model.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class c
  implements p
{
  private d.a PES = null;
  private String thumburl = "";
  
  public c(d.a parama)
  {
    this.PES = parama;
  }
  
  public c(String paramString)
  {
    this.thumburl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    AppMethodBeat.i(28620);
    if (p.a.pAS == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
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
  
  public final void a(p.a parama) {}
  
  public final p.b bTB()
  {
    return null;
  }
  
  public final String bTC()
  {
    AppMethodBeat.i(28617);
    String str;
    if ((this.PES != null) && (this.PES.field_thumburl != null))
    {
      str = m.lG(this.PES.field_thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    if (this.thumburl != null)
    {
      str = m.lG(this.thumburl, "@S");
      AppMethodBeat.o(28617);
      return str;
    }
    AppMethodBeat.o(28617);
    return "";
  }
  
  public final String bTD()
  {
    if ((this.PES != null) && (this.PES.field_thumburl != null)) {
      return this.PES.field_thumburl;
    }
    return this.thumburl;
  }
  
  public final String bTE()
  {
    AppMethodBeat.i(28618);
    String str = bTD() + "_tv";
    AppMethodBeat.o(28618);
    return str;
  }
  
  public final boolean bTF()
  {
    return false;
  }
  
  public final boolean bTG()
  {
    return false;
  }
  
  public final Bitmap bTH()
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
  
  public final void bTI() {}
  
  public final void bTJ() {}
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(28619);
    String str = bTD() + "_tv";
    AppMethodBeat.o(28619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.c
 * JD-Core Version:    0.7.0.1
 */