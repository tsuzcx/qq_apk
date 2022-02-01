package com.tencent.mm.plugin.shake.d.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

final class a$a
  implements s
{
  private String Djf;
  
  public a$a(String paramString)
  {
    this.Djf = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(28353);
    if (s.a.jNh == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, a.aKj(this.Djf), false);
      Log.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(28353);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramString, "", new Object[0]);
        Log.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(28351);
    String str = a.aKj(this.Djf);
    AppMethodBeat.o(28351);
    return str;
  }
  
  public final String blB()
  {
    return this.Djf;
  }
  
  public final String blC()
  {
    return this.Djf;
  }
  
  public final boolean blD()
  {
    return true;
  }
  
  public final boolean blE()
  {
    return false;
  }
  
  public final Bitmap blF()
  {
    AppMethodBeat.i(28352);
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
    AppMethodBeat.o(28352);
    return localBitmap;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return null;
  }
  
  public final String getCacheKey()
  {
    return this.Djf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */