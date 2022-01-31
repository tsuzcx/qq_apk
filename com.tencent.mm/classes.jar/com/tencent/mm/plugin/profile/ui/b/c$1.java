package com.tencent.mm.plugin.profile.ui.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

final class c$1
  implements v
{
  c$1(c paramc) {}
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    AppMethodBeat.i(23964);
    if (v.a.gjx == parama) {}
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aon(), false);
      ab.d("MicroMsg.UrlDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(23964);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.UrlDrawable", paramString, "", new Object[0]);
        ab.w("MicroMsg.UrlDrawable", "save bitmap fail");
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
    AppMethodBeat.i(23965);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = com.tencent.mm.model.c.YT() + ag.cE(c.a(this.pFK));
    AppMethodBeat.o(23965);
    return localObject;
  }
  
  public final String aoo()
  {
    AppMethodBeat.i(23967);
    String str = c.a(this.pFK);
    AppMethodBeat.o(23967);
    return str;
  }
  
  public final String aop()
  {
    AppMethodBeat.i(23966);
    String str = c.a(this.pFK);
    AppMethodBeat.o(23966);
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
    return null;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(23968);
    String str = c.a(this.pFK);
    AppMethodBeat.o(23968);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.c.1
 * JD-Core Version:    0.7.0.1
 */