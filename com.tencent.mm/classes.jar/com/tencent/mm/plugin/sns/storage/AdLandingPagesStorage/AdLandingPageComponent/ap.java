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

public final class ap
{
  public String DWN;
  public String Eap;
  public float Eaq;
  public float tt;
  
  public static ap a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202832);
    ap localap = new ap();
    localap.Eap = Util.nullAsNil((String)paramMap.get(paramString + ".borderColor"));
    localap.Eaq = i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
    localap.tt = i.a(Util.safeParseDouble((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
    localap.DWN = Util.nullAsNil((String)paramMap.get(paramString + ".bgColor"));
    AppMethodBeat.o(202832);
    return localap;
  }
  
  public static void a(View paramView, ap paramap)
  {
    int j = 0;
    AppMethodBeat.i(202833);
    try
    {
      String str2 = paramap.Eap;
      String str1 = paramap.DWN;
      float f1 = paramap.Eaq;
      float f2 = paramap.tt;
      Object localObject = null;
      boolean bool = Util.isNullOrNil(str2);
      paramap = (ap)localObject;
      if (!bool)
      {
        paramap = (ap)localObject;
        if (f1 <= 0.0F) {}
      }
      try
      {
        i = Color.parseColor(str2);
        paramap = new GradientDrawable();
        paramap.setShape(0);
        paramap.setStroke((int)f1, i);
        bool = Util.isNullOrNil(str1);
        localObject = paramap;
        if (bool) {}
      }
      catch (Exception paramap)
      {
        try
        {
          i = Color.parseColor(str1);
          localObject = paramap;
          if (paramap == null)
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
          AppMethodBeat.o(202833);
          return;
          paramap = paramap;
          Log.e("BorderCornerBgInfo", Util.stackTraceToString(paramap));
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
      AppMethodBeat.o(202833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap
 * JD-Core Version:    0.7.0.1
 */