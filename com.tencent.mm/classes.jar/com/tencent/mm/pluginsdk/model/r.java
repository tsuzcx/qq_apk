package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;

public final class r
  implements s
{
  private boolean Dhy;
  private boolean dhh;
  private long hZc;
  private long hZd;
  private String jsy;
  private String url;
  
  public static String aGc(String paramString)
  {
    AppMethodBeat.i(116445);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      paramString = String.format("%s%s", new Object[] { "wcf://bizimg/", com.tencent.mm.b.g.getMessageDigest((a.afE() + paramString).getBytes()) });
      AppMethodBeat.o(116445);
      return paramString;
    }
    AppMethodBeat.o(116445);
    return "";
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(116449);
    if (s.a.iuo == parama)
    {
      String str = this.jsy;
      r.a locala = new r.a();
      Object localObject = ai.getContext();
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
        ac.d("MicroMsg.ReaaderAppGetPicStrategy", locala.toString());
        paramBitmap = f.b(paramBitmap, locala.w, locala.h, true);
        try
        {
          ac.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[] { aGc(this.url) });
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGc(this.url), false);
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
            ac.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", parama, "", new Object[0]);
            ac.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[] { this.url });
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
    if ((parama == s.a.iuo) && (this.Dhy) && (q.aFE()) && (!bs.isNullOrNil(paramString)) && (q.dz(q.Cx(this.url))) && (paramString.equals("image/webp")))
    {
      ac.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
      h.wUl.idkeyStat(86L, 14L, 1L, false);
    }
    AppMethodBeat.o(116452);
  }
  
  public final s.b aNk()
  {
    return null;
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(116446);
    String str = aGc(this.url);
    AppMethodBeat.o(116446);
    return str;
  }
  
  public final String aNm()
  {
    AppMethodBeat.i(116447);
    String str = q.Cx(this.url);
    AppMethodBeat.o(116447);
    return str;
  }
  
  public final String aNn()
  {
    return this.url;
  }
  
  public final boolean aNo()
  {
    return false;
  }
  
  public final boolean aNp()
  {
    return this.dhh;
  }
  
  public final Bitmap aNq()
  {
    AppMethodBeat.i(116453);
    Bitmap localBitmap = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
    AppMethodBeat.o(116453);
    return localBitmap;
  }
  
  public final void aNr()
  {
    AppMethodBeat.i(116450);
    this.hZc = bs.eWj();
    if (this.Dhy)
    {
      ac.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
      h.wUl.idkeyStat(86L, 0L, 1L, false);
    }
    AppMethodBeat.o(116450);
  }
  
  public final void aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116451);
    this.hZd = bs.eWj();
    int j = 0;
    int i = j;
    if (q.aFE())
    {
      i = j;
      if (!bs.isNullOrNil(paramString))
      {
        i = j;
        if (q.dz(q.Cx(this.url)))
        {
          i = j;
          if (paramString.equals("image/webp")) {
            i = 1;
          }
        }
      }
    }
    if (this.Dhy) {
      if (!paramBoolean)
      {
        ac.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        h.wUl.idkeyStat(86L, 2L, 1L, false);
        if (i != 0)
        {
          ac.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
          h.wUl.idkeyStat(86L, 15L, 1L, false);
          AppMethodBeat.o(116451);
        }
      }
      else
      {
        long l = this.hZd - this.hZc;
        ac.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[] { Long.valueOf(l) });
        h.wUl.idkeyStat(86L, 4L, l, false);
        if (i != 0)
        {
          ac.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
          h.wUl.idkeyStat(86L, 17L, l, false);
          h.wUl.idkeyStat(86L, 13L, 1L, false);
        }
      }
    }
    AppMethodBeat.o(116451);
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(116448);
    String str = this.url + this.jsy;
    AppMethodBeat.o(116448);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r
 * JD-Core Version:    0.7.0.1
 */