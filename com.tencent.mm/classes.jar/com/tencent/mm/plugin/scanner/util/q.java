package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class q
  implements v
{
  private String mPicUrl = null;
  
  public q(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    return com.tencent.mm.plugin.scanner.c.bxd().eA(this.mPicUrl, "@S");
  }
  
  public final String UP()
  {
    return this.mPicUrl;
  }
  
  public final String UQ()
  {
    return this.mPicUrl;
  }
  
  public final boolean UR()
  {
    return false;
  }
  
  public final boolean US()
  {
    return false;
  }
  
  public final Bitmap UT()
  {
    if (ae.getContext() == null) {
      return null;
    }
    return BitmapFactory.decodeResource(ae.getContext().getResources(), R.g.nosdcard_chatting_bg);
  }
  
  public final void UU() {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    if (v.a.eRD == parama) {}
    try
    {
      com.tencent.mm.sdk.platformtools.c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      y.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", parama, "", new Object[0]);
    }
    return paramBitmap;
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.q
 * JD-Core Version:    0.7.0.1
 */