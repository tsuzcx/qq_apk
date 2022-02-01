package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;

public final class r
  implements s
{
  private boolean BPk;
  private boolean djM;
  private long hyB;
  private long hyC;
  private String iSn;
  private String url;
  
  public static String aAK(String paramString)
  {
    AppMethodBeat.i(116445);
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      paramString = String.format("%s%s", new Object[] { "wcf://bizimg/", com.tencent.mm.b.g.getMessageDigest((a.aeo() + paramString).getBytes()) });
      AppMethodBeat.o(116445);
      return paramString;
    }
    AppMethodBeat.o(116445);
    return "";
  }
  
  public final void Z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116451);
    this.hyC = bt.eGO();
    int j = 0;
    int i = j;
    if (q.ayM())
    {
      i = j;
      if (!bt.isNullOrNil(paramString))
      {
        i = j;
        if (q.dK(q.ys(this.url)))
        {
          i = j;
          if (paramString.equals("image/webp")) {
            i = 1;
          }
        }
      }
    }
    if (this.BPk) {
      if (!paramBoolean)
      {
        ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        h.vKh.idkeyStat(86L, 2L, 1L, false);
        if (i != 0)
        {
          ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
          h.vKh.idkeyStat(86L, 15L, 1L, false);
          AppMethodBeat.o(116451);
        }
      }
      else
      {
        long l = this.hyC - this.hyB;
        ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[] { Long.valueOf(l) });
        h.vKh.idkeyStat(86L, 4L, l, false);
        if (i != 0)
        {
          ad.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
          h.vKh.idkeyStat(86L, 17L, l, false);
          h.vKh.idkeyStat(86L, 13L, 1L, false);
        }
      }
    }
    AppMethodBeat.o(116451);
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(116449);
    if (s.a.hUk == parama)
    {
      String str = this.iSn;
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
        paramBitmap = f.b(paramBitmap, locala.w, locala.h, true);
        try
        {
          ad.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[] { aAK(this.url) });
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aAK(this.url), false);
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
    if ((parama == s.a.hUk) && (this.BPk) && (q.ayM()) && (!bt.isNullOrNil(paramString)) && (q.dK(q.ys(this.url))) && (paramString.equals("image/webp")))
    {
      ad.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
      h.vKh.idkeyStat(86L, 14L, 1L, false);
    }
    AppMethodBeat.o(116452);
  }
  
  public final String aGA()
  {
    return this.url;
  }
  
  public final boolean aGB()
  {
    return false;
  }
  
  public final boolean aGC()
  {
    return this.djM;
  }
  
  public final Bitmap aGD()
  {
    AppMethodBeat.i(116453);
    Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
    AppMethodBeat.o(116453);
    return localBitmap;
  }
  
  public final void aGE()
  {
    AppMethodBeat.i(116450);
    this.hyB = bt.eGO();
    if (this.BPk)
    {
      ad.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
      h.vKh.idkeyStat(86L, 0L, 1L, false);
    }
    AppMethodBeat.o(116450);
  }
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(116446);
    String str = aAK(this.url);
    AppMethodBeat.o(116446);
    return str;
  }
  
  public final String aGz()
  {
    AppMethodBeat.i(116447);
    String str = q.ys(this.url);
    AppMethodBeat.o(116447);
    return str;
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(116448);
    String str = this.url + this.iSn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r
 * JD-Core Version:    0.7.0.1
 */