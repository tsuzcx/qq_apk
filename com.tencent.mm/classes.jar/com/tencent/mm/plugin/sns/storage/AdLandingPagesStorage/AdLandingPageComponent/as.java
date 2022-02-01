package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class as
{
  public String QLR;
  public float QLS;
  public String bgColor;
  public float dwJ;
  
  public static as a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(306840);
    as localas = new as();
    localas.QLR = Util.nullAsNil((String)paramMap.get(paramString + ".borderColor"));
    localas.QLS = l.a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
    localas.dwJ = l.a(Util.safeParseDouble((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
    localas.bgColor = Util.nullAsNil((String)paramMap.get(paramString + ".bgColor"));
    AppMethodBeat.o(306840);
    return localas;
  }
  
  public static void a(View paramView, as paramas)
  {
    int j = 0;
    AppMethodBeat.i(306841);
    try
    {
      String str2 = paramas.QLR;
      String str1 = paramas.bgColor;
      float f1 = paramas.QLS;
      float f2 = paramas.dwJ;
      Object localObject = null;
      boolean bool = Util.isNullOrNil(str2);
      paramas = (as)localObject;
      if (!bool)
      {
        paramas = (as)localObject;
        if (f1 <= 0.0F) {}
      }
      try
      {
        i = Color.parseColor(str2);
        paramas = new GradientDrawable();
        paramas.setShape(0);
        paramas.setStroke((int)f1, i);
        bool = Util.isNullOrNil(str1);
        localObject = paramas;
        if (bool) {}
      }
      catch (Exception paramas)
      {
        try
        {
          i = Color.parseColor(str1);
          localObject = paramas;
          if (paramas == null)
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
          AppMethodBeat.o(306841);
          return;
          paramas = paramas;
          Log.e("BorderCornerBgInfo", Util.stackTraceToString(paramas));
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
    finally
    {
      Log.e("BorderCornerBgInfo", "");
      AppMethodBeat.o(306841);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.as
 * JD-Core Version:    0.7.0.1
 */