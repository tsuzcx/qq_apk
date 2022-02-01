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
import com.tencent.mm.an.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bg;
import java.util.Iterator;
import java.util.List;

public final class h$a
{
  private static DisplayMetrics aegd = null;
  
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
      Point localPoint = bg.bf(paramContext);
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
        locala.uLf = 0;
        locala.uLg = (k - (i + 0));
      }
      for (;;)
      {
        AppMethodBeat.o(34346);
        return locala;
        if (aegd == null) {
          aegd = paramContext.getResources().getDisplayMetrics();
        }
        localDisplayMetrics = aegd;
        break;
        if (k - (i / 2 + paramInt) < 0)
        {
          locala.uLf = (k - (i + 0));
          locala.uLg = 0;
        }
        else
        {
          locala.uLf = (paramInt - i / 2);
          locala.uLg = (k - (i / 2 + paramInt));
        }
      }
    }
  }
  
  public static final class a
  {
    public int uLf;
    public int uLg;
    
    public final String toString()
    {
      AppMethodBeat.i(34344);
      String str = " marginLeft:" + this.uLf + " marginRight:" + this.uLg;
      AppMethodBeat.o(34344);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */