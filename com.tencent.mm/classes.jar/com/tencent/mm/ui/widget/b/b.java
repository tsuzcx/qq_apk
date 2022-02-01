package com.tencent.mm.ui.widget.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.bd;

public final class b
{
  private static DisplayMetrics aegd = null;
  
  public static a a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(159490);
    a locala = new a();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    int i;
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int j = bd.fromDPToPix(paramContext, 95);
      i = paramInt1;
      if (paramInt1 < j) {
        i = j;
      }
      if (paramInt2 >= 0) {
        break label236;
      }
      locala.uLf = 0;
      locala.uLg = (localDisplayMetrics.widthPixels - (paramInt5 * 2 + i));
      paramInt1 = 0;
      paramInt2 = 1;
      label100:
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
        break label316;
      }
      if (i < paramInt4 + paramInt5) {
        break label355;
      }
      locala.CMA = (i - paramInt5 - paramInt4);
      paramInt3 = 0;
      paramInt4 = 1;
      label160:
      if (paramInt4 == 0) {
        break label373;
      }
      locala.CMA -= paramInt5 * 2;
      label180:
      if ((paramInt2 != 0) && (paramInt3 != 0)) {
        break label435;
      }
      if ((paramInt1 == 0) || (paramInt3 == 0)) {
        break label395;
      }
      locala.agjL = a.j.PopRightTopAnimation;
    }
    for (;;)
    {
      AppMethodBeat.o(159490);
      return locala;
      if (aegd == null) {
        aegd = paramContext.getResources().getDisplayMetrics();
      }
      localDisplayMetrics = aegd;
      break;
      label236:
      if (localDisplayMetrics.widthPixels - (paramInt2 + i + paramInt5 * 2) < 0)
      {
        locala.uLf = (paramInt2 - i - paramInt5);
        locala.uLg = (localDisplayMetrics.widthPixels - paramInt2 - paramInt5);
        paramInt1 = 1;
        paramInt2 = 0;
        break label100;
      }
      locala.uLf = paramInt2;
      locala.uLg = (localDisplayMetrics.widthPixels - (paramInt2 + i));
      paramInt1 = 0;
      paramInt2 = 1;
      break label100;
      label316:
      if (localDisplayMetrics.heightPixels - i < paramInt5 * 3 + paramInt4)
      {
        locala.CMA = (i - paramInt5 - paramInt4);
        paramInt3 = 0;
        paramInt4 = 1;
        break label160;
      }
      label355:
      locala.CMA = (i - paramInt5);
      paramInt3 = 1;
      paramInt4 = 0;
      break label160;
      label373:
      if (paramInt3 == 0) {
        break label180;
      }
      locala.CMA += paramInt5 * 2;
      break label180;
      label395:
      if ((paramInt2 != 0) && (paramInt4 != 0)) {
        locala.agjL = a.j.PopLeftBottomAnimation;
      } else if ((paramInt1 != 0) && (paramInt4 != 0)) {
        locala.agjL = a.j.PopRightBottomAnimation;
      } else {
        label435:
        locala.agjL = a.j.PopLeftTopAnimation;
      }
    }
  }
  
  public static final class a
  {
    public int CMA;
    public int agjL;
    public int uLf;
    public int uLg;
    
    public final String toString()
    {
      AppMethodBeat.i(159489);
      String str = " marginLeft:" + this.uLf + " marginRight:" + this.uLg;
      AppMethodBeat.o(159489);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.b
 * JD-Core Version:    0.7.0.1
 */