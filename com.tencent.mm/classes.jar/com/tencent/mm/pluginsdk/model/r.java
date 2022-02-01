package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.t;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class r
  implements s
{
  private boolean EMj;
  private boolean dsF;
  private long isy;
  private long isz;
  private String jMs;
  private String url;
  
  public static String aLC(String paramString)
  {
    AppMethodBeat.i(116445);
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      paramString = String.format("%s%s", new Object[] { "wcf://bizimg/", com.tencent.mm.b.g.getMessageDigest((a.aiq() + paramString).getBytes()) });
      AppMethodBeat.o(116445);
      return paramString;
    }
    AppMethodBeat.o(116445);
    return "";
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(116449);
    if (s.a.iNr == parama)
    {
      String str = this.jMs;
      a locala = new a();
      Object localObject = aj.getContext();
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
      int j;
      int i;
      if (parama != null) {
        if ("@T".equals(str))
        {
          j = (int)(parama.widthPixels - 60.0F * parama.density);
          i = (int)(parama.density * 167.0F);
        }
      }
      for (;;)
      {
        locala.w = j;
        locala.h = i;
        ad.d("MicroMsg.ReaaderAppGetPicStrategy", locala.toString());
        paramBitmap = com.tencent.mm.sdk.platformtools.g.b(paramBitmap, locala.w, locala.h, true);
        try
        {
          ad.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[] { aLC(this.url) });
          com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aLC(this.url), false);
          AppMethodBeat.o(116449);
          return paramBitmap;
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
        catch (Exception parama)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", parama, "", new Object[0]);
            ad.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[] { this.url });
          }
        }
      }
    }
    AppMethodBeat.o(116449);
    return paramBitmap;
  }
  
  public final void a(s.a parama, String paramString)
  {
    AppMethodBeat.i(116452);
    if ((parama == s.a.iNr) && (this.EMj) && (t.aIN()) && (!bt.isNullOrNil(paramString)) && (t.ev(t.FB(this.url))) && (paramString.equals("image/webp")))
    {
      ad.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 14L, 1L, false);
    }
    AppMethodBeat.o(116452);
  }
  
  public final boolean aQA()
  {
    return this.dsF;
  }
  
  public final Bitmap aQB()
  {
    AppMethodBeat.i(116453);
    Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
    AppMethodBeat.o(116453);
    return localBitmap;
  }
  
  public final void aQC()
  {
    AppMethodBeat.i(116450);
    this.isy = bt.flT();
    if (this.EMj)
    {
      ad.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 0L, 1L, false);
    }
    AppMethodBeat.o(116450);
  }
  
  public final s.b aQv()
  {
    return null;
  }
  
  public final String aQw()
  {
    AppMethodBeat.i(116446);
    String str = aLC(this.url);
    AppMethodBeat.o(116446);
    return str;
  }
  
  public final String aQx()
  {
    AppMethodBeat.i(116447);
    String str = t.FB(this.url);
    AppMethodBeat.o(116447);
    return str;
  }
  
  public final String aQy()
  {
    return this.url;
  }
  
  public final boolean aQz()
  {
    return false;
  }
  
  public final void aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116451);
    this.isz = bt.flT();
    int j = 0;
    int i = j;
    if (t.aIN())
    {
      i = j;
      if (!bt.isNullOrNil(paramString))
      {
        i = j;
        if (t.ev(t.FB(this.url)))
        {
          i = j;
          if (paramString.equals("image/webp")) {
            i = 1;
          }
        }
      }
    }
    if (this.EMj) {
      if (!paramBoolean)
      {
        ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 2L, 1L, false);
        if (i != 0)
        {
          ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 15L, 1L, false);
          AppMethodBeat.o(116451);
        }
      }
      else
      {
        long l = this.isz - this.isy;
        ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 4L, l, false);
        if (i != 0)
        {
          ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 17L, l, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 13L, 1L, false);
        }
      }
    }
    AppMethodBeat.o(116451);
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(116448);
    String str = this.url + this.jMs;
    AppMethodBeat.o(116448);
    return str;
  }
  
  public static final class a
  {
    public int h;
    public int w;
    public int x;
    public int y;
    
    public final String toString()
    {
      AppMethodBeat.i(116444);
      String str = String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w) });
      AppMethodBeat.o(116444);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r
 * JD-Core Version:    0.7.0.1
 */