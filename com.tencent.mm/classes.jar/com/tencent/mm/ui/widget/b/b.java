package com.tencent.mm.ui.widget.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aq;

public final class b
{
  private static DisplayMetrics JUk = null;
  
  public static b.a a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(159490);
    b.a locala = new b.a();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    int i;
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int j = aq.fromDPToPix(paramContext, 95);
      i = paramInt1;
      if (paramInt1 < j) {
        i = j;
      }
      if (paramInt2 >= 0) {
        break label235;
      }
      locala.nnK = 0;
      locala.nnL = (localDisplayMetrics.widthPixels - (paramInt5 * 2 + i));
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
      locala.AHL = (i - paramInt5 - paramInt4);
      paramInt3 = 0;
      paramInt4 = 1;
      label160:
      if (paramInt4 == 0) {
        break label372;
      }
      locala.AHL -= paramInt5 * 2;
      label180:
      if ((paramInt2 != 0) && (paramInt3 != 0)) {
        break label432;
      }
      if ((paramInt1 == 0) || (paramInt3 == 0)) {
        break label394;
      }
      locala.LwU = 2131821220;
    }
    for (;;)
    {
      AppMethodBeat.o(159490);
      return locala;
      if (JUk == null) {
        JUk = paramContext.getResources().getDisplayMetrics();
      }
      localDisplayMetrics = JUk;
      break;
      label235:
      if (localDisplayMetrics.widthPixels - (paramInt2 + i + paramInt5 * 2) < 0)
      {
        locala.nnK = (paramInt2 - i - paramInt5);
        locala.nnL = (localDisplayMetrics.widthPixels - paramInt2 - paramInt5);
        paramInt1 = 1;
        paramInt2 = 0;
        break label100;
      }
      locala.nnK = paramInt2;
      locala.nnL = (localDisplayMetrics.widthPixels - (paramInt2 + i));
      paramInt1 = 0;
      paramInt2 = 1;
      break label100;
      label315:
      if (localDisplayMetrics.heightPixels - i < paramInt5 * 3 + paramInt4)
      {
        locala.AHL = (i - paramInt5 - paramInt4);
        paramInt3 = 0;
        paramInt4 = 1;
        break label160;
      }
      label354:
      locala.AHL = (i - paramInt5);
      paramInt3 = 1;
      paramInt4 = 0;
      break label160;
      label372:
      if (paramInt3 == 0) {
        break label180;
      }
      locala.AHL += paramInt5 * 2;
      break label180;
      label394:
      if ((paramInt2 != 0) && (paramInt4 != 0)) {
        locala.LwU = 2131821217;
      } else if ((paramInt1 != 0) && (paramInt4 != 0)) {
        locala.LwU = 2131821219;
      } else {
        label432:
        locala.LwU = 2131821218;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.b
 * JD-Core Version:    0.7.0.1
 */