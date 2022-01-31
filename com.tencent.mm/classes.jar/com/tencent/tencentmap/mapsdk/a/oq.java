package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;

public class oq
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
  
  public oq(int paramInt)
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
    String str2 = paramBitmap.toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str1 = str1.replace("android.graphics.Bitmap", "");
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    str1 = str1 + "@" + paramBitmap.hashCode() + "@" + j + "@" + k + "@" + paramBitmap.getRowBytes();
    return str1 + "@" + paramBitmap.getPixel(j / 2, k / 2);
  }
  
  public Bitmap a(Context paramContext)
  {
    if ((this.h != null) && (this.i != null)) {
      return this.h;
    }
    if (paramContext == null) {
      return null;
    }
    switch (this.b)
    {
    }
    for (;;)
    {
      return this.h;
      this.i = ("res_" + this.c);
      if (lq.t != null) {
        this.h = lq.t.a(this.i);
      }
      if (this.h == null)
      {
        this.h = lq.a(paramContext, this.c);
        if ((lq.t != null) && (this.h != null))
        {
          lq.t.a(this.i, this.h);
          continue;
          this.i = ("asset_" + this.d);
          if (lq.t != null) {
            this.h = lq.t.a(this.i);
          }
          if (this.h == null)
          {
            this.h = lq.c(paramContext, this.d);
            if (this.h == null)
            {
              this.h = lq.b(paramContext, this.d);
              if (this.h != null) {
                this.h = lq.b(this.h);
              }
            }
            if ((lq.t != null) && (this.h != null))
            {
              lq.t.a(this.i, this.h);
              continue;
              this.i = ("file_" + this.e);
              if (lq.t != null) {
                this.h = lq.t.a(this.i);
              }
              if (this.h == null)
              {
                this.h = lq.a(paramContext, this.e);
                continue;
                this.i = ("path_" + this.f);
                if (lq.t != null) {
                  this.h = lq.t.a(this.i);
                }
                if (this.h == null)
                {
                  this.h = lq.b(this.f);
                  if ((lq.t != null) && (this.h != null))
                  {
                    lq.t.a(this.i, this.h);
                    continue;
                    this.i = "asset_marker_default.png";
                    if (lq.t != null) {
                      this.h = lq.t.a(this.i);
                    }
                    if (this.h == null)
                    {
                      this.h = lq.b(paramContext, "marker_default.png");
                      if ((lq.t != null) && (this.h != null))
                      {
                        lq.t.a(this.i, this.h);
                        continue;
                        String str = a(this.g);
                        if (str != null)
                        {
                          this.i = ("asset_" + str);
                          if (lq.t != null) {
                            this.h = lq.t.a(this.i);
                          }
                          if (this.h == null)
                          {
                            this.h = lq.b(paramContext, str);
                            if ((lq.t != null) && (this.h != null))
                            {
                              lq.t.a(this.i, this.h);
                              continue;
                              if (this.h != null)
                              {
                                this.i = ("bitmap_" + b(this.h));
                                if ((lq.t != null) && (this.h != null)) {
                                  lq.t.a(this.i, this.h);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oq
 * JD-Core Version:    0.7.0.1
 */