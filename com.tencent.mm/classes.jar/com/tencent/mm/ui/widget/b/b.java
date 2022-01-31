package com.tencent.mm.ui.widget.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.ci.a.j;
import com.tencent.mm.ui.ap;

public final class b
{
  private static DisplayMetrics viC = null;
  
  public static b.a a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    b.a locala = new b.a();
    if (viC == null) {
      viC = paramContext.getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = viC;
    int j = ap.fromDPToPix(paramContext, 95);
    int i = paramInt1;
    if (paramInt1 < j) {
      i = j;
    }
    if (paramInt2 < 0)
    {
      locala.hyd = 0;
      locala.hye = (localDisplayMetrics.widthPixels - (paramInt5 * 2 + i));
      paramInt1 = 0;
      paramInt2 = 1;
      if (paramInt3 >= 0)
      {
        i = paramInt3;
        if (paramInt3 <= localDisplayMetrics.heightPixels) {}
      }
      else
      {
        i = (int)(localDisplayMetrics.heightPixels / 2.0F);
      }
      if (!paramBoolean) {
        break label270;
      }
      if (i < paramInt4 + paramInt5) {
        break label309;
      }
      locala.pko = (i - paramInt5 - paramInt4);
      paramInt3 = 0;
      paramInt4 = 1;
      label143:
      if (paramInt4 == 0) {
        break label327;
      }
      locala.pko -= paramInt5 * 2;
    }
    for (;;)
    {
      if ((paramInt2 == 0) || (paramInt3 == 0))
      {
        if ((paramInt1 != 0) && (paramInt3 != 0))
        {
          locala.wok = a.j.PopRightTopAnimation;
          return locala;
          if (localDisplayMetrics.widthPixels - (paramInt2 + i + paramInt5 * 2) < 0)
          {
            locala.hyd = (paramInt2 - i - paramInt5);
            locala.hye = (localDisplayMetrics.widthPixels - paramInt2 - paramInt5);
            paramInt1 = 1;
            paramInt2 = 0;
            break;
          }
          locala.hyd = paramInt2;
          locala.hye = (localDisplayMetrics.widthPixels - (paramInt2 + i));
          paramInt1 = 0;
          paramInt2 = 1;
          break;
          label270:
          if (localDisplayMetrics.heightPixels - i < paramInt5 * 3 + paramInt4)
          {
            locala.pko = (i - paramInt5 - paramInt4);
            paramInt3 = 0;
            paramInt4 = 1;
            break label143;
          }
          label309:
          locala.pko = (i - paramInt5);
          paramInt3 = 1;
          paramInt4 = 0;
          break label143;
          label327:
          if (paramInt3 == 0) {
            continue;
          }
          locala.pko += paramInt5 * 2;
          continue;
        }
        if ((paramInt2 != 0) && (paramInt4 != 0))
        {
          locala.wok = a.j.PopLeftBottomAnimation;
          return locala;
        }
        if ((paramInt1 != 0) && (paramInt4 != 0))
        {
          locala.wok = a.j.PopRightBottomAnimation;
          return locala;
        }
      }
    }
    locala.wok = a.j.PopLeftTopAnimation;
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.b
 * JD-Core Version:    0.7.0.1
 */