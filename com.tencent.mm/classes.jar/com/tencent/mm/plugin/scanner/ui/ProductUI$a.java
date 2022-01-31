package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class ProductUI$a
  implements v
{
  private o.a nKn;
  
  public ProductUI$a(o.a parama)
  {
    this.nKn = parama;
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    return com.tencent.mm.plugin.scanner.c.bxd().eA(this.nKn.field_thumburl, "@S");
  }
  
  public final String UP()
  {
    if (this.nKn == null) {
      return "";
    }
    return this.nKn.field_thumburl;
  }
  
  public final String UQ()
  {
    if (this.nKn == null) {
      return "";
    }
    return this.nKn.field_thumburl;
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
      y.printErrStackTrace("MicroMsg.scanner.ProductUI", parama, "", new Object[0]);
    }
    return paramBitmap;
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    if (this.nKn == null) {
      return "";
    }
    return this.nKn.field_thumburl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.a
 * JD-Core Version:    0.7.0.1
 */