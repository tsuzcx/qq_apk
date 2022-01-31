package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class p
  implements v
{
  private boolean cuO;
  private long fVR = 0L;
  private long fVS = 0L;
  private String size;
  private int type;
  private String url;
  private boolean vKG;
  
  public p(String paramString1, int paramInt, String paramString2)
  {
    this.url = paramString1;
    this.type = paramInt;
    this.size = paramString2;
    this.cuO = false;
  }
  
  public static String aln(String paramString)
  {
    AppMethodBeat.i(141573);
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      String str = c.bIC();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      paramString = String.format("%s%s", new Object[] { str, com.tencent.mm.a.g.w((a.QC() + paramString).getBytes()) });
      AppMethodBeat.o(141573);
      return paramString;
    }
    AppMethodBeat.o(141573);
    return "";
  }
  
  public final void W(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105505);
    this.fVS = bo.aoy();
    int j = 0;
    int i = j;
    if (q.ahJ())
    {
      i = j;
      if (!bo.isNullOrNil(paramString))
      {
        i = j;
        if (q.tv(aoo()))
        {
          i = j;
          if (paramString.equals("image/webp")) {
            i = 1;
          }
        }
      }
    }
    if (this.vKG) {
      if (!paramBoolean)
      {
        ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        h.qsU.idkeyStat(86L, 2L, 1L, false);
        if (i != 0)
        {
          ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
          h.qsU.idkeyStat(86L, 15L, 1L, false);
          AppMethodBeat.o(105505);
        }
      }
      else
      {
        long l = this.fVS - this.fVR;
        ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[] { Long.valueOf(l) });
        h.qsU.idkeyStat(86L, 4L, l, false);
        if (i != 0)
        {
          ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
          h.qsU.idkeyStat(86L, 17L, l, false);
          h.qsU.idkeyStat(86L, 13L, 1L, false);
        }
      }
    }
    AppMethodBeat.o(105505);
  }
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    AppMethodBeat.i(105503);
    if (v.a.gjx == parama)
    {
      String str = this.size;
      a locala = new a();
      Object localObject = ah.getContext();
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
        ab.d("MicroMsg.ReaaderAppGetPicStrategy", locala.toString());
        paramBitmap = d.b(paramBitmap, locala.w, locala.h, true);
        try
        {
          ab.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[] { aln(this.url) });
          d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aln(this.url), false);
          AppMethodBeat.o(105503);
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
            ab.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", parama, "", new Object[0]);
            ab.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[] { this.url });
          }
        }
      }
    }
    AppMethodBeat.o(105503);
    return paramBitmap;
  }
  
  public final void a(v.a parama, String paramString)
  {
    AppMethodBeat.i(105506);
    if ((parama == v.a.gjx) && (this.vKG) && (q.ahJ()) && (!bo.isNullOrNil(paramString)) && (q.tv(aoo())) && (paramString.equals("image/webp")))
    {
      ab.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
      h.qsU.idkeyStat(86L, 14L, 1L, false);
    }
    AppMethodBeat.o(105506);
  }
  
  public final v.b aom()
  {
    return null;
  }
  
  public final String aon()
  {
    AppMethodBeat.i(105500);
    String str = aln(this.url);
    AppMethodBeat.o(105500);
    return str;
  }
  
  public final String aoo()
  {
    AppMethodBeat.i(105501);
    if (q.ahJ()) {}
    for (String str = q.tu(this.url);; str = this.url)
    {
      AppMethodBeat.o(105501);
      return str;
    }
  }
  
  public final String aop()
  {
    return this.url;
  }
  
  public final boolean aoq()
  {
    return false;
  }
  
  public final boolean aor()
  {
    return this.cuO;
  }
  
  public final Bitmap aos()
  {
    AppMethodBeat.i(105507);
    Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
    AppMethodBeat.o(105507);
    return localBitmap;
  }
  
  public final void aot()
  {
    AppMethodBeat.i(105504);
    this.fVR = bo.aoy();
    if (this.vKG)
    {
      ab.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
      h.qsU.idkeyStat(86L, 0L, 1L, false);
    }
    AppMethodBeat.o(105504);
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(105502);
    String str = this.url + this.size;
    AppMethodBeat.o(105502);
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
      AppMethodBeat.i(105498);
      String str = String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w) });
      AppMethodBeat.o(105498);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */