package com.tencent.mm.ui.widget.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public final class b
{
  private static DisplayMetrics HLD = null;
  
  public static a a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(159490);
    a locala = new a();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    int i;
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int j = ao.fromDPToPix(paramContext, 95);
      i = paramInt1;
      if (paramInt1 < j) {
        i = j;
      }
      if (paramInt2 >= 0) {
        break label235;
      }
      locala.mIf = 0;
      locala.mIg = (localDisplayMetrics.widthPixels - (paramInt5 * 2 + i));
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
        break label315;
      }
      if (i < paramInt4 + paramInt5) {
        break label354;
      }
      locala.yYJ = (i - paramInt5 - paramInt4);
      paramInt3 = 0;
      paramInt4 = 1;
      label160:
      if (paramInt4 == 0) {
        break label372;
      }
      locala.yYJ -= paramInt5 * 2;
      label180:
      if ((paramInt2 != 0) && (paramInt3 != 0)) {
        break label432;
      }
      if ((paramInt1 == 0) || (paramInt3 == 0)) {
        break label394;
      }
      locala.JiZ = 2131821220;
    }
    for (;;)
    {
      AppMethodBeat.o(159490);
      return locala;
      if (HLD == null) {
        HLD = paramContext.getResources().getDisplayMetrics();
      }
      localDisplayMetrics = HLD;
      break;
      label235:
      if (localDisplayMetrics.widthPixels - (paramInt2 + i + paramInt5 * 2) < 0)
      {
        locala.mIf = (paramInt2 - i - paramInt5);
        locala.mIg = (localDisplayMetrics.widthPixels - paramInt2 - paramInt5);
        paramInt1 = 1;
        paramInt2 = 0;
        break label100;
      }
      locala.mIf = paramInt2;
      locala.mIg = (localDisplayMetrics.widthPixels - (paramInt2 + i));
      paramInt1 = 0;
      paramInt2 = 1;
      break label100;
      label315:
      if (localDisplayMetrics.heightPixels - i < paramInt5 * 3 + paramInt4)
      {
        locala.yYJ = (i - paramInt5 - paramInt4);
        paramInt3 = 0;
        paramInt4 = 1;
        break label160;
      }
      label354:
      locala.yYJ = (i - paramInt5);
      paramInt3 = 1;
      paramInt4 = 0;
      break label160;
      label372:
      if (paramInt3 == 0) {
        break label180;
      }
      locala.yYJ += paramInt5 * 2;
      break label180;
      label394:
      if ((paramInt2 != 0) && (paramInt4 != 0)) {
        locala.JiZ = 2131821217;
      } else if ((paramInt1 != 0) && (paramInt4 != 0)) {
        locala.JiZ = 2131821219;
      } else {
        label432:
        locala.JiZ = 2131821218;
      }
    }
  }
  
  public static final class a
  {
    public int JiZ;
    public int mIf;
    public int mIg;
    public int yYJ;
    
    public final String toString()
    {
      AppMethodBeat.i(159489);
      String str = " marginLeft:" + this.mIf + " marginRight:" + this.mIg;
      AppMethodBeat.o(159489);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.b
 * JD-Core Version:    0.7.0.1
 */