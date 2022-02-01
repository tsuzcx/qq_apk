package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.t;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class s
  implements com.tencent.mm.platformtools.s
{
  private boolean JVy;
  private boolean dKW;
  private long jqE;
  private long jqF;
  private String kSm;
  private String url;
  
  public static String bdu(String paramString)
  {
    AppMethodBeat.i(116445);
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      paramString = String.format("%s%s", new Object[] { "wcf://bizimg/", com.tencent.mm.b.g.getMessageDigest((a.ayV() + paramString).getBytes()) });
      AppMethodBeat.o(116445);
      return paramString;
    }
    AppMethodBeat.o(116445);
    return "";
  }
  
  public final Bitmap a(Bitmap paramBitmap, com.tencent.mm.platformtools.s.a parama, String paramString)
  {
    AppMethodBeat.i(116449);
    if (com.tencent.mm.platformtools.s.a.jNh == parama)
    {
      String str = this.kSm;
      a locala = new a();
      Object localObject = MMApplicationContext.getContext();
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
        Log.d("MicroMsg.ReaaderAppGetPicStrategy", locala.toString());
        paramBitmap = BitmapUtil.getCenterCropBitmap(paramBitmap, locala.w, locala.h, true);
        try
        {
          Log.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[] { bdu(this.url) });
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bdu(this.url), false);
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
            Log.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", parama, "", new Object[0]);
            Log.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[] { this.url });
          }
        }
      }
    }
    AppMethodBeat.o(116449);
    return paramBitmap;
  }
  
  public final void a(com.tencent.mm.platformtools.s.a parama, String paramString)
  {
    AppMethodBeat.i(116452);
    if ((parama == com.tencent.mm.platformtools.s.a.jNh) && (this.JVy) && (t.bcZ()) && (!Util.isNullOrNil(paramString)) && (t.fm(t.OO(this.url))) && (paramString.equals("image/webp")))
    {
      Log.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
      h.CyF.idkeyStat(86L, 14L, 1L, false);
    }
    AppMethodBeat.o(116452);
  }
  
  public final void ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116451);
    this.jqF = Util.nowMilliSecond();
    int j = 0;
    int i = j;
    if (t.bcZ())
    {
      i = j;
      if (!Util.isNullOrNil(paramString))
      {
        i = j;
        if (t.fm(t.OO(this.url)))
        {
          i = j;
          if (paramString.equals("image/webp")) {
            i = 1;
          }
        }
      }
    }
    if (this.JVy) {
      if (!paramBoolean)
      {
        Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        h.CyF.idkeyStat(86L, 2L, 1L, false);
        if (i != 0)
        {
          Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
          h.CyF.idkeyStat(86L, 15L, 1L, false);
          AppMethodBeat.o(116451);
        }
      }
      else
      {
        long l = this.jqF - this.jqE;
        Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[] { Long.valueOf(l) });
        h.CyF.idkeyStat(86L, 4L, l, false);
        if (i != 0)
        {
          Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
          h.CyF.idkeyStat(86L, 17L, l, false);
          h.CyF.idkeyStat(86L, 13L, 1L, false);
        }
      }
    }
    AppMethodBeat.o(116451);
  }
  
  public final String blA()
  {
    AppMethodBeat.i(116446);
    String str = bdu(this.url);
    AppMethodBeat.o(116446);
    return str;
  }
  
  public final String blB()
  {
    AppMethodBeat.i(116447);
    String str = t.OO(this.url);
    AppMethodBeat.o(116447);
    return str;
  }
  
  public final String blC()
  {
    return this.url;
  }
  
  public final boolean blD()
  {
    return false;
  }
  
  public final boolean blE()
  {
    return this.dKW;
  }
  
  public final Bitmap blF()
  {
    AppMethodBeat.i(116453);
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
    AppMethodBeat.o(116453);
    return localBitmap;
  }
  
  public final void blG()
  {
    AppMethodBeat.i(116450);
    this.jqE = Util.nowMilliSecond();
    if (this.JVy)
    {
      Log.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
      h.CyF.idkeyStat(86L, 0L, 1L, false);
    }
    AppMethodBeat.o(116450);
  }
  
  public final s.b blz()
  {
    return null;
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(116448);
    String str = this.url + this.kSm;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.s
 * JD-Core Version:    0.7.0.1
 */