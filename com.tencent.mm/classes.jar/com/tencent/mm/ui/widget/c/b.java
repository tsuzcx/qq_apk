package com.tencent.mm.ui.widget.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;

public final class b
{
  private static DisplayMetrics zxw = null;
  
  public static a a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(112780);
    a locala = new a();
    if (zxw == null) {
      zxw = paramContext.getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = zxw;
    int j = al.fromDPToPix(paramContext, 95);
    int i = paramInt1;
    if (paramInt1 < j) {
      i = j;
    }
    if (paramInt2 < 0)
    {
      locala.jqn = 0;
      locala.jqo = (localDisplayMetrics.widthPixels - (paramInt5 * 2 + i));
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
        break label279;
      }
      if (i < paramInt4 + paramInt5) {
        break label318;
      }
      locala.scS = (i - paramInt5 - paramInt4);
      paramInt3 = 0;
      paramInt4 = 1;
      label148:
      if (paramInt4 == 0) {
        break label336;
      }
      locala.scS -= paramInt5 * 2;
      label168:
      if ((paramInt2 != 0) && (paramInt3 != 0)) {
        break label396;
      }
      if ((paramInt1 == 0) || (paramInt3 == 0)) {
        break label358;
      }
      locala.AIM = 2131493514;
    }
    label396:
    for (;;)
    {
      AppMethodBeat.o(112780);
      return locala;
      if (localDisplayMetrics.widthPixels - (paramInt2 + i + paramInt5 * 2) < 0)
      {
        locala.jqn = (paramInt2 - i - paramInt5);
        locala.jqo = (localDisplayMetrics.widthPixels - paramInt2 - paramInt5);
        paramInt1 = 1;
        paramInt2 = 0;
        break;
      }
      locala.jqn = paramInt2;
      locala.jqo = (localDisplayMetrics.widthPixels - (paramInt2 + i));
      paramInt1 = 0;
      paramInt2 = 1;
      break;
      label279:
      if (localDisplayMetrics.heightPixels - i < paramInt5 * 3 + paramInt4)
      {
        locala.scS = (i - paramInt5 - paramInt4);
        paramInt3 = 0;
        paramInt4 = 1;
        break label148;
      }
      label318:
      locala.scS = (i - paramInt5);
      paramInt3 = 1;
      paramInt4 = 0;
      break label148;
      label336:
      if (paramInt3 == 0) {
        break label168;
      }
      locala.scS += paramInt5 * 2;
      break label168;
      label358:
      if ((paramInt2 != 0) && (paramInt4 != 0)) {
        locala.AIM = 2131493511;
      } else if ((paramInt1 != 0) && (paramInt4 != 0)) {
        locala.AIM = 2131493513;
      } else {
        locala.AIM = 2131493512;
      }
    }
  }
  
  public static final class a
  {
    public int AIM;
    public int jqn;
    public int jqo;
    public int scS;
    
    public final String toString()
    {
      AppMethodBeat.i(112779);
      String str = " marginLeft:" + this.jqn + " marginRight:" + this.jqo;
      AppMethodBeat.o(112779);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c.b
 * JD-Core Version:    0.7.0.1
 */