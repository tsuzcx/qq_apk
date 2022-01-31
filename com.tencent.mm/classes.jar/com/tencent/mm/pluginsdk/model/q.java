package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.mm.bm.a.a.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  implements v
{
  private boolean bNw;
  private long eGa = 0L;
  private long eGb = 0L;
  private boolean rTJ;
  private String size;
  private int type;
  private String url;
  
  public q(String paramString1, int paramInt, String paramString2)
  {
    this.url = paramString1;
    this.type = paramInt;
    this.size = paramString2;
    this.bNw = false;
  }
  
  public static String y(String paramString1, int paramInt, String paramString2)
  {
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      String str = com.tencent.mm.plugin.n.c.bbu();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.DN();
      return String.format("%s%d%s_%s", new Object[] { str, Integer.valueOf(paramInt), paramString2, com.tencent.mm.a.g.o((a.CL() + paramString1).getBytes()) });
    }
    return "";
  }
  
  public final void S(String paramString, boolean paramBoolean)
  {
    this.eGb = bk.UY();
    int j = 0;
    int i = j;
    if (com.tencent.mm.as.q.OQ())
    {
      i = j;
      if (!bk.bl(paramString))
      {
        i = j;
        if (com.tencent.mm.as.q.mp(UP()))
        {
          i = j;
          if (paramString.equals("image/webp")) {
            i = 1;
          }
        }
      }
    }
    if (this.rTJ)
    {
      if (paramBoolean) {
        break label114;
      }
      y.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
      h.nFQ.a(86L, 2L, 1L, false);
      if (i != 0)
      {
        y.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
        h.nFQ.a(86L, 15L, 1L, false);
      }
    }
    label114:
    long l;
    do
    {
      return;
      l = this.eGb - this.eGa;
      y.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[] { Long.valueOf(l) });
      h.nFQ.a(86L, 4L, l, false);
    } while (i == 0);
    y.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
    h.nFQ.a(86L, 17L, l, false);
    h.nFQ.a(86L, 13L, 1L, false);
  }
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    return y(this.url, this.type, this.size);
  }
  
  public final String UP()
  {
    if (com.tencent.mm.as.q.OQ()) {
      return com.tencent.mm.as.q.mo(this.url);
    }
    return this.url;
  }
  
  public final String UQ()
  {
    return this.url;
  }
  
  public final boolean UR()
  {
    return false;
  }
  
  public final boolean US()
  {
    return this.bNw;
  }
  
  public final Bitmap UT()
  {
    return BitmapFactory.decodeResource(ae.getContext().getResources(), a.a.nosdcard_chatting_bg);
  }
  
  public final void UU()
  {
    this.eGa = bk.UY();
    if (this.rTJ)
    {
      y.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
      h.nFQ.a(86L, 0L, 1L, false);
    }
  }
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    paramString = paramBitmap;
    String str;
    a locala;
    int j;
    int i;
    if (v.a.eRD == parama)
    {
      str = this.size;
      locala = new a();
      Object localObject = ae.getContext();
      paramString = null;
      parama = paramString;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        parama = paramString;
        if (localObject != null) {
          parama = ((Resources)localObject).getDisplayMetrics();
        }
      }
      if (parama == null) {
        break label191;
      }
      if (!"@T".equals(str)) {
        break label173;
      }
      j = (int)(parama.widthPixels - 60.0F * parama.density);
      i = (int)(parama.density * 167.0F);
    }
    for (;;)
    {
      locala.w = j;
      locala.h = i;
      y.d("MicroMsg.ReaaderAppGetPicStrategy", locala.toString());
      paramString = com.tencent.mm.sdk.platformtools.c.a(paramBitmap, locala.w, locala.h, true);
      try
      {
        y.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[] { UO() });
        com.tencent.mm.sdk.platformtools.c.a(paramString, 100, Bitmap.CompressFormat.PNG, UO(), false);
        return paramString;
      }
      catch (Exception paramBitmap)
      {
        label173:
        label191:
        y.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", paramBitmap, "", new Object[0]);
        y.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[] { this.url });
      }
      j = (int)(parama.density * 50.0F);
      i = j;
      continue;
      if ("@T".equals(str))
      {
        i = 334;
        j = 2147483647;
      }
      else
      {
        i = 100;
        j = 100;
      }
    }
    return paramString;
  }
  
  public final void a(v.a parama, String paramString)
  {
    if ((parama == v.a.eRD) && (this.rTJ) && (com.tencent.mm.as.q.OQ()) && (!bk.bl(paramString)) && (com.tencent.mm.as.q.mp(UP())) && (paramString.equals("image/webp")))
    {
      y.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
      h.nFQ.a(86L, 14L, 1L, false);
    }
  }
  
  public final String getCacheKey()
  {
    return this.url + this.size;
  }
  
  public static final class a
  {
    public int h;
    public int w;
    public int x;
    public int y;
    
    public final String toString()
    {
      return String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.q
 * JD-Core Version:    0.7.0.1
 */