package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class b
  implements v
{
  private c.a odT = null;
  private String thumburl = "";
  
  public b(c.a parama)
  {
    this.odT = parama;
  }
  
  public b(String paramString)
  {
    this.thumburl = paramString;
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    if ((this.odT != null) && (this.odT.field_thumburl != null)) {
      return m.eA(this.odT.field_thumburl, "@S");
    }
    if (this.thumburl != null) {
      return m.eA(this.thumburl, "@S");
    }
    return "";
  }
  
  public final String UP()
  {
    if ((this.odT != null) && (this.odT.field_thumburl != null)) {
      return this.odT.field_thumburl;
    }
    return this.thumburl;
  }
  
  public final String UQ()
  {
    return UP() + "_tv";
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
      c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      y.printErrStackTrace("MicroMsg.TVImgGetStrategy", parama, "", new Object[0]);
    }
    return paramBitmap;
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return UP() + "_tv";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.b
 * JD-Core Version:    0.7.0.1
 */