package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;

public class bj
{
  private final String a = "marker_default.png";
  private int b = -1;
  private int c = -1;
  private String d = "";
  private String e = "";
  private String f = "";
  private float g = -1.0F;
  private Bitmap h = null;
  private String i = null;
  
  public bj(int paramInt)
  {
    this.b = paramInt;
  }
  
  private String a(float paramFloat)
  {
    String str = null;
    if (paramFloat < 30.0F) {
      str = "RED.png";
    }
    do
    {
      return str;
      if ((paramFloat >= 30.0F) && (paramFloat < 60.0F)) {
        return "ORANGE.png";
      }
      if ((paramFloat >= 60.0F) && (paramFloat < 120.0F)) {
        return "YELLOW.png";
      }
      if ((paramFloat >= 120.0F) && (paramFloat < 180.0F)) {
        return "GREEN.png";
      }
      if ((paramFloat >= 180.0F) && (paramFloat < 210.0F)) {
        return "CYAN.png";
      }
      if ((paramFloat >= 210.0F) && (paramFloat < 240.0F)) {
        return "AZURE.png";
      }
      if ((paramFloat >= 240.0F) && (paramFloat < 270.0F)) {
        return "BLUE.png";
      }
      if ((paramFloat >= 270.0F) && (paramFloat < 300.0F)) {
        return "VIOLET.png";
      }
      if ((paramFloat >= 300.0F) && (paramFloat < 330.0F)) {
        return "MAGENTAV.png";
      }
    } while (paramFloat < 330.0F);
    return "ROSE.png";
  }
  
  private String b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(149873);
    String str2 = paramBitmap.toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str1 = str1.replace("android.graphics.Bitmap", "");
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    str1 = str1 + "@" + paramBitmap.hashCode() + "@" + j + "@" + k + "@" + paramBitmap.getRowBytes();
    paramBitmap = str1 + "@" + paramBitmap.getPixel(j / 2, k / 2);
    AppMethodBeat.o(149873);
    return paramBitmap;
  }
  
  public Bitmap a(Context paramContext)
  {
    AppMethodBeat.i(149874);
    if ((this.h != null) && (this.i != null))
    {
      paramContext = this.h;
      AppMethodBeat.o(149874);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(149874);
      return null;
    }
    switch (this.b)
    {
    }
    for (;;)
    {
      paramContext = this.h;
      AppMethodBeat.o(149874);
      return paramContext;
      this.i = ("res_" + this.c);
      if (ka.u != null) {
        this.h = ka.u.a(this.i);
      }
      if (this.h == null)
      {
        this.h = ka.a(paramContext, this.c);
        if ((ka.u != null) && (this.h != null))
        {
          ka.u.a(this.i, this.h);
          continue;
          this.i = ("asset_" + this.d);
          if (ka.u != null) {
            this.h = ka.u.a(this.i);
          }
          if (this.h == null)
          {
            this.h = ka.c(paramContext, this.d);
            if (this.h == null)
            {
              this.h = ka.b(paramContext, this.d);
              if ((this.h != null) && (this.d != "color_texture_flat_style.png")) {
                this.h = ka.b(this.h);
              }
            }
            if ((ka.u != null) && (this.h != null))
            {
              ka.u.a(this.i, this.h);
              continue;
              this.i = ("file_" + this.e);
              if (ka.u != null) {
                this.h = ka.u.a(this.i);
              }
              if (this.h == null)
              {
                this.h = ka.a(paramContext, this.e);
                continue;
                this.i = ("path_" + this.f);
                if (ka.u != null) {
                  this.h = ka.u.a(this.i);
                }
                if (this.h == null)
                {
                  this.h = ka.b(this.f);
                  if ((ka.u != null) && (this.h != null))
                  {
                    ka.u.a(this.i, this.h);
                    continue;
                    this.i = "asset_marker_default.png";
                    if (ka.u != null) {
                      this.h = ka.u.a(this.i);
                    }
                    if (this.h == null)
                    {
                      this.h = ka.b(paramContext, "marker_default.png");
                      if ((ka.u != null) && (this.h != null))
                      {
                        ka.u.a(this.i, this.h);
                        continue;
                        String str = a(this.g);
                        if (str != null)
                        {
                          this.i = "asset_".concat(String.valueOf(str));
                          if (ka.u != null) {
                            this.h = ka.u.a(this.i);
                          }
                          if (this.h == null)
                          {
                            this.h = ka.b(paramContext, str);
                            if ((ka.u != null) && (this.h != null))
                            {
                              ka.u.a(this.i, this.h);
                              continue;
                              if (this.h != null)
                              {
                                this.i = ("bitmap_" + b(this.h));
                                if ((ka.u != null) && (this.h != null)) {
                                  ka.u.a(this.i, this.h);
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String a()
  {
    return this.i;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.h = paramBitmap;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bj
 * JD-Core Version:    0.7.0.1
 */