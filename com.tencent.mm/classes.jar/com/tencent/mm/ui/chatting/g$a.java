package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.k;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ay;
import java.util.Iterator;
import java.util.List;

public final class g$a
{
  private static DisplayMetrics WyH = null;
  
  private static int a(Context paramContext, TextPaint paramTextPaint, List<k> paramList)
  {
    AppMethodBeat.i(34345);
    paramList = paramList.iterator();
    float f1 = 0.0F;
    if (paramList.hasNext())
    {
      float f2 = paramTextPaint.measureText(((k)paramList.next()).name);
      if (f1 >= f2) {
        break label79;
      }
      f1 = f2;
    }
    label79:
    for (;;)
    {
      break;
      int i = (int)f1;
      int j = a.fromDPToPix(paramContext, 30);
      AppMethodBeat.o(34345);
      return i + j * 2;
    }
  }
  
  public static a a(Context paramContext, TextPaint paramTextPaint, List<k> paramList, int paramInt)
  {
    AppMethodBeat.i(34346);
    a locala = new a();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    int k;
    int i;
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      Point localPoint = ay.au(paramContext);
      k = localDisplayMetrics.widthPixels;
      if ((k != localDisplayMetrics.widthPixels) || (localPoint.y != localDisplayMetrics.heightPixels)) {
        Log.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.heightPixels) });
      }
      i = a(paramContext, paramTextPaint, paramList);
      int j = a.fromDPToPix(paramContext, 95);
      if (i >= j) {
        break label282;
      }
      i = j;
    }
    label282:
    for (;;)
    {
      if (paramInt - i / 2 < 0)
      {
        locala.rzO = 0;
        locala.rzP = (k - (i + 0));
      }
      for (;;)
      {
        AppMethodBeat.o(34346);
        return locala;
        if (WyH == null) {
          WyH = paramContext.getResources().getDisplayMetrics();
        }
        localDisplayMetrics = WyH;
        break;
        if (k - (i / 2 + paramInt) < 0)
        {
          locala.rzO = (k - (i + 0));
          locala.rzP = 0;
        }
        else
        {
          locala.rzO = (paramInt - i / 2);
          locala.rzP = (k - (i / 2 + paramInt));
        }
      }
    }
  }
  
  public static final class a
  {
    public int rzO;
    public int rzP;
    
    public final String toString()
    {
      AppMethodBeat.i(34344);
      String str = " marginLeft:" + this.rzO + " marginRight:" + this.rzP;
      AppMethodBeat.o(34344);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */