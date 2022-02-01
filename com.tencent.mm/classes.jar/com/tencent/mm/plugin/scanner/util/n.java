package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class n
  implements s
{
  private String mPicUrl = null;
  
  public n(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(52069);
    if (s.a.iuo == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
      AppMethodBeat.o(52069);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aNk()
  {
    return null;
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(52068);
    String str = i.dza().iL(this.mPicUrl, "@S");
    AppMethodBeat.o(52068);
    return str;
  }
  
  public final String aNm()
  {
    return this.mPicUrl;
  }
  
  public final String aNn()
  {
    return this.mPicUrl;
  }
  
  public final boolean aNo()
  {
    return false;
  }
  
  public final boolean aNp()
  {
    return false;
  }
  
  public final Bitmap aNq()
  {
    AppMethodBeat.i(52070);
    if (ai.getContext() == null)
    {
      AppMethodBeat.o(52070);
      return null;
    }
    Bitmap localBitmap = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
    AppMethodBeat.o(52070);
    return localBitmap;
  }
  
  public final void aNr() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.n
 * JD-Core Version:    0.7.0.1
 */