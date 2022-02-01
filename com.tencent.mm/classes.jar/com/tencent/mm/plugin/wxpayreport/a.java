package com.tencent.mm.plugin.wxpayreport;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import androidx.j.a.b.a;
import androidx.j.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.b.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"maxBitmapSize", "", "getMaxBitmapSize", "()I", "argb2rgb", "fgColor", "bgColor", "blendBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "colorDifference", "", "first", "Lcom/tencent/mm/plugin/wxpayreport/LABColor;", "second", "getDominantColor", "getDominantColors", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "hab", "a", "b", "hexString", "", "color", "saturation", "toLABColor", "plugin-wxpay-report_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final int XIL;
  
  static
  {
    AppMethodBeat.i(261155);
    XIL = (int)(float)Math.pow(com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.a.Edge_25A), 2.0D);
    AppMethodBeat.o(261155);
  }
  
  public static final int aX(Bitmap paramBitmap)
  {
    AppMethodBeat.i(261081);
    s.u(paramBitmap, "bitmap");
    paramBitmap = androidx.j.a.b.l(paramBitmap);
    paramBitmap.bTf = 16;
    paramBitmap = paramBitmap.fu(XIL).IC().IB().ID();
    s.s(paramBitmap, "from(bitmap)\n        .ma…ers()\n        .generate()");
    paramBitmap = paramBitmap.bTd;
    if (paramBitmap == null)
    {
      AppMethodBeat.o(261081);
      return 0;
    }
    int i = paramBitmap.bTp;
    AppMethodBeat.o(261081);
    return i;
  }
  
  public static final ArrayList<Integer> aY(Bitmap paramBitmap)
  {
    AppMethodBeat.i(261090);
    s.u(paramBitmap, "bitmap");
    paramBitmap = androidx.j.a.b.l(paramBitmap);
    paramBitmap.bTf = 16;
    Object localObject = paramBitmap.fu(XIL).IC().IB().ID();
    s.s(localObject, "from(bitmap)\n        .ma…ers()\n        .generate()");
    paramBitmap = new ArrayList();
    localObject = Collections.unmodifiableList(((androidx.j.a.b)localObject).bSZ);
    s.s(localObject, "palette.swatches");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBitmap.add(Integer.valueOf(((b.d)((Iterator)localObject).next()).bTp));
    }
    AppMethodBeat.o(261090);
    return paramBitmap;
  }
  
  public static final String avj(int paramInt)
  {
    AppMethodBeat.i(261075);
    String str = Integer.toHexString(paramInt);
    s.s(str, "toHexString(color)");
    AppMethodBeat.o(261075);
    return str;
  }
  
  private static b avk(int paramInt)
  {
    AppMethodBeat.i(261125);
    Object localObject = new double[3];
    androidx.core.graphics.b.b(paramInt, (double[])localObject);
    localObject = new b(localObject[0], localObject[1], localObject[2]);
    AppMethodBeat.o(261125);
    return localObject;
  }
  
  public static final void l(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(261116);
    s.u(paramBitmap, "bitmap");
    if (paramBitmap.getConfig() != Bitmap.Config.ARGB_8888)
    {
      AppMethodBeat.o(261116);
      return;
    }
    HashMap localHashMap = new HashMap();
    int n = paramBitmap.getWidth();
    int i;
    int k;
    int i1;
    if (n > 0)
    {
      i = 0;
      k = i + 1;
      i1 = paramBitmap.getHeight();
      if (i1 <= 0) {}
    }
    int m;
    for (int j = 0;; j = m)
    {
      m = j + 1;
      int i2 = paramBitmap.getPixel(i, j);
      Integer localInteger2 = (Integer)localHashMap.get(Integer.valueOf(i2));
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(ny(i2, paramInt));
      }
      int i3 = ((Number)localInteger1).intValue();
      if (i2 != i3) {
        paramBitmap.setPixel(i, j, i3);
      }
      ((Map)localHashMap).put(Integer.valueOf(i2), Integer.valueOf(i3));
      if (m >= i1)
      {
        if (k >= n)
        {
          AppMethodBeat.o(261116);
          return;
        }
        i = k;
        break;
      }
    }
  }
  
  public static final int ny(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261102);
    if ((WeChatEnvironment.hasDebugger()) && (Color.alpha(paramInt2) != 255))
    {
      RuntimeException localRuntimeException = new RuntimeException("bgColor can't have alpha channel");
      AppMethodBeat.o(261102);
      throw localRuntimeException;
    }
    int i = Color.alpha(paramInt1);
    switch (i)
    {
    default: 
      double d1 = i / 255.0D;
      double d2 = Color.red(paramInt1);
      double d3 = Color.red(paramInt2);
      double d4 = Color.green(paramInt1);
      double d5 = Color.green(paramInt2);
      double d6 = Color.blue(paramInt1);
      double d7 = Color.blue(paramInt2);
      paramInt1 = Color.rgb((int)(d2 * d1 + (1.0D - d1) * d3), (int)(d4 * d1 + (1.0D - d1) * d5), (int)((1.0D - d1) * d7 + d6 * d1));
      AppMethodBeat.o(261102);
      return paramInt1;
    case 255: 
      AppMethodBeat.o(261102);
      return paramInt1;
    }
    AppMethodBeat.o(261102);
    return paramInt2;
  }
  
  public static final double nz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261136);
    b localb1 = avk(paramInt1);
    b localb2 = avk(paramInt2);
    s.u(localb1, "first");
    s.u(localb2, "second");
    double d1 = localb1.XIM;
    double d2 = localb2.XIM;
    double d6 = localb1.b;
    double d5 = localb2.b;
    double d3 = Math.pow((s(localb1.a, localb1.b) + s(localb2.a, localb2.b)) / 2.0D, 7.0D);
    d3 = (1.0D - Math.pow(d3 / (6103515625.0D + d3), 0.5D)) * 0.5D;
    double d7 = localb1.a * (1.0D + d3);
    double d9 = localb2.a * (d3 + 1.0D);
    d3 = s(d7, d6);
    double d4 = s(d9, d5);
    double d8 = t(d7, d6);
    double d10 = t(d9, d5);
    d5 = Math.sin((d8 - d10) * 3.141592653589793D / 360.0D);
    d6 = Math.pow(d3 * d4, 0.5D);
    d9 = (d1 + d2) / 2.0D;
    d7 = (d3 + d4) / 2.0D;
    double d13 = (d10 + d8) / 2.0D;
    d8 = d9 - 50.0D;
    double d14 = 0.015D * Math.pow(d8, 2.0D) / Math.pow(Math.pow(d8, 2.0D) + 20.0D, 0.5D);
    d8 = Math.cos((d13 - 30.0D) * 3.141592653589793D / 180.0D);
    d9 = Math.cos(2.0D * d13 * 3.141592653589793D / 180.0D);
    d10 = Math.cos((3.0D * d13 + 6.0D) * 3.141592653589793D / 180.0D);
    double d11 = Math.cos((4.0D * d13 - 63.0D) * 3.141592653589793D / 180.0D);
    double d12 = Math.pow(d7, 7.0D);
    d12 = Math.pow(d12 / (6103515625.0D + d12), 0.5D);
    d13 = -Math.sin(Math.exp(-Math.pow((d13 - 275.0D) / 25.0D, 2.0D)) * 30.0D * 2.0D * 3.141592653589793D / 180.0D);
    d1 = (d1 - d2) / ((d14 + 1.0D) * 1.0D);
    d2 = (d3 - d4) / (1.0D * (1.0D + 0.045D * d7));
    d3 = d5 * 2.0D * d6 / (1.0D * ((1.0D - 0.17D * d8 + 0.24D * d9 + 0.32D * d10 - 0.2D * d11) * (0.015D * d7) + 1.0D));
    d1 = Math.pow(d13 * (d12 * 2.0D) * d2 * d3 + (d1 * d1 + d2 * d2 + d3 * d3), 0.5D);
    AppMethodBeat.o(261136);
    return d1;
  }
  
  private static final double s(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(261143);
    paramDouble1 = Math.pow(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2, 0.5D);
    AppMethodBeat.o(261143);
    return paramDouble1;
  }
  
  private static final double t(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(261150);
    if (paramDouble1 == 0.0D) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(261150);
      return 90.0D;
    }
    double d = 57.295779513082323D * Math.atan(paramDouble2 / paramDouble1);
    if ((paramDouble1 > 0.0D) && (paramDouble2 > 0.0D))
    {
      AppMethodBeat.o(261150);
      return d;
    }
    if (((paramDouble1 < 0.0D) && (paramDouble2 > 0.0D)) || ((paramDouble1 < 0.0D) && (paramDouble2 < 0.0D)))
    {
      AppMethodBeat.o(261150);
      return d + 180.0D;
    }
    AppMethodBeat.o(261150);
    return d + 360.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.a
 * JD-Core Version:    0.7.0.1
 */