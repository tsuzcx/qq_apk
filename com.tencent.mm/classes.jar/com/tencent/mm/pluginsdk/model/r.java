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
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;

public final class r
  implements s
{
  private boolean FeH;
  private boolean dtL;
  private long ivs;
  private long ivt;
  private String jPE;
  private String url;
  
  public static String aMY(String paramString)
  {
    AppMethodBeat.i(116445);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      paramString = String.format("%s%s", new Object[] { "wcf://bizimg/", com.tencent.mm.b.g.getMessageDigest((a.aiF() + paramString).getBytes()) });
      AppMethodBeat.o(116445);
      return paramString;
    }
    AppMethodBeat.o(116445);
    return "";
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(116449);
    if (s.a.iQl == parama)
    {
      String str = this.jPE;
      r.a locala = new r.a();
      Object localObject = ak.getContext();
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
        ae.d("MicroMsg.ReaaderAppGetPicStrategy", locala.toString());
        paramBitmap = h.b(paramBitmap, locala.w, locala.h, true);
        try
        {
          ae.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[] { aMY(this.url) });
          h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aMY(this.url), false);
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
            ae.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", parama, "", new Object[0]);
            ae.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[] { this.url });
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
    if ((parama == s.a.iQl) && (this.FeH) && (t.aJf()) && (!bu.isNullOrNil(paramString)) && (t.eA(t.Gd(this.url))) && (paramString.equals("image/webp")))
    {
      ae.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 14L, 1L, false);
    }
    AppMethodBeat.o(116452);
  }
  
  public final s.b aQU()
  {
    return null;
  }
  
  public final String aQV()
  {
    AppMethodBeat.i(116446);
    String str = aMY(this.url);
    AppMethodBeat.o(116446);
    return str;
  }
  
  public final String aQW()
  {
    AppMethodBeat.i(116447);
    String str = t.Gd(this.url);
    AppMethodBeat.o(116447);
    return str;
  }
  
  public final String aQX()
  {
    return this.url;
  }
  
  public final boolean aQY()
  {
    return false;
  }
  
  public final boolean aQZ()
  {
    return this.dtL;
  }
  
  public final Bitmap aRa()
  {
    AppMethodBeat.i(116453);
    Bitmap localBitmap = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
    AppMethodBeat.o(116453);
    return localBitmap;
  }
  
  public final void aRb()
  {
    AppMethodBeat.i(116450);
    this.ivs = bu.fpO();
    if (this.FeH)
    {
      ae.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 0L, 1L, false);
    }
    AppMethodBeat.o(116450);
  }
  
  public final void aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116451);
    this.ivt = bu.fpO();
    int j = 0;
    int i = j;
    if (t.aJf())
    {
      i = j;
      if (!bu.isNullOrNil(paramString))
      {
        i = j;
        if (t.eA(t.Gd(this.url)))
        {
          i = j;
          if (paramString.equals("image/webp")) {
            i = 1;
          }
        }
      }
    }
    if (this.FeH) {
      if (!paramBoolean)
      {
        ae.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 2L, 1L, false);
        if (i != 0)
        {
          ae.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 15L, 1L, false);
          AppMethodBeat.o(116451);
        }
      }
      else
      {
        long l = this.ivt - this.ivs;
        ae.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 4L, l, false);
        if (i != 0)
        {
          ae.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 17L, l, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 13L, 1L, false);
        }
      }
    }
    AppMethodBeat.o(116451);
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(116448);
    String str = this.url + this.jPE;
    AppMethodBeat.o(116448);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r
 * JD-Core Version:    0.7.0.1
 */