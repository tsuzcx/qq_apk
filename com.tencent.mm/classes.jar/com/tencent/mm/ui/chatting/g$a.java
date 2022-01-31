package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.an;
import java.util.Iterator;
import java.util.List;

public final class g$a
{
  private static DisplayMetrics zxw = null;
  
  public static g.a.a a(Context paramContext, TextPaint paramTextPaint, List<j> paramList, int paramInt)
  {
    AppMethodBeat.i(30496);
    g.a.a locala = new g.a.a();
    if (zxw == null) {
      zxw = paramContext.getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = zxw;
    Point localPoint = an.hQ(paramContext);
    int k = localPoint.x;
    if ((k != localDisplayMetrics.widthPixels) || (localPoint.y != localDisplayMetrics.heightPixels)) {
      ab.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.heightPixels) });
    }
    paramList = paramList.iterator();
    float f1 = 0.0F;
    if (paramList.hasNext())
    {
      float f2 = paramTextPaint.measureText(((j)paramList.next()).name);
      if (f1 >= f2) {
        break label313;
      }
      f1 = f2;
    }
    label313:
    for (;;)
    {
      break;
      int i = (int)f1;
      i = a.fromDPToPix(paramContext, 30) * 2 + i;
      int j = a.fromDPToPix(paramContext, 95);
      if (i < j) {
        i = j;
      }
      for (;;)
      {
        if (paramInt - i / 2 < 0)
        {
          locala.jqn = 0;
          locala.jqo = (k - (i + 0));
        }
        for (;;)
        {
          AppMethodBeat.o(30496);
          return locala;
          if (k - (i / 2 + paramInt) < 0)
          {
            locala.jqn = (k - (i + 0));
            locala.jqo = 0;
          }
          else
          {
            locala.jqn = (paramInt - i / 2);
            locala.jqo = (k - (i / 2 + paramInt));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */