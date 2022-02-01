package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class aq
{
  public String KnK;
  public float KnL;
  public float bDI;
  public String bgColor;
  
  public static aq a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(265001);
    aq localaq = new aq();
    localaq.KnK = Util.nullAsNil((String)paramMap.get(paramString + ".borderColor"));
    localaq.KnL = i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
    localaq.bDI = i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
    localaq.bgColor = Util.nullAsNil((String)paramMap.get(paramString + ".bgColor"));
    AppMethodBeat.o(265001);
    return localaq;
  }
  
  public static void a(View paramView, aq paramaq)
  {
    int j = 0;
    AppMethodBeat.i(265002);
    try
    {
      String str2 = paramaq.KnK;
      String str1 = paramaq.bgColor;
      float f1 = paramaq.KnL;
      float f2 = paramaq.bDI;
      Object localObject = null;
      boolean bool = Util.isNullOrNil(str2);
      paramaq = (aq)localObject;
      if (!bool)
      {
        paramaq = (aq)localObject;
        if (f1 <= 0.0F) {}
      }
      try
      {
        i = Color.parseColor(str2);
        paramaq = new GradientDrawable();
        paramaq.setShape(0);
        paramaq.setStroke((int)f1, i);
        bool = Util.isNullOrNil(str1);
        localObject = paramaq;
        if (bool) {}
      }
      catch (Exception paramaq)
      {
        try
        {
          i = Color.parseColor(str1);
          localObject = paramaq;
          if (paramaq == null)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setShape(0);
          }
          ((GradientDrawable)localObject).setColor(i);
          if ((localObject != null) && (f2 > 0.0F)) {
            ((GradientDrawable)localObject).setCornerRadius(f2);
          }
          if (localObject != null)
          {
            paramView.setClipToOutline(true);
            paramView.setBackgroundDrawable((Drawable)localObject);
          }
          AppMethodBeat.o(265002);
          return;
          paramaq = paramaq;
          Log.e("BorderCornerBgInfo", Util.stackTraceToString(paramaq));
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("BorderCornerBgInfo", Util.stackTraceToString(localException));
            int i = j;
          }
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      Log.e("BorderCornerBgInfo", "");
      AppMethodBeat.o(265002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq
 * JD-Core Version:    0.7.0.1
 */