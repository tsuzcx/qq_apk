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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

final class h$a
  implements v
{
  private String mPicUrl = null;
  
  public h$a(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    AppMethodBeat.i(81059);
    if (v.a.gjx == parama) {}
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aon(), false);
      AppMethodBeat.o(81059);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ProductGridPreference", parama, "", new Object[0]);
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
    AppMethodBeat.i(81058);
    String str = e.chX().gb(this.mPicUrl, "@S");
    AppMethodBeat.o(81058);
    return str;
  }
  
  public final String aoo()
  {
    return this.mPicUrl;
  }
  
  public final String aop()
  {
    return this.mPicUrl;
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
    AppMethodBeat.i(81060);
    if (ah.getContext() == null)
    {
      AppMethodBeat.o(81060);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
    AppMethodBeat.o(81060);
    return localBitmap;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h.a
 * JD-Core Version:    0.7.0.1
 */