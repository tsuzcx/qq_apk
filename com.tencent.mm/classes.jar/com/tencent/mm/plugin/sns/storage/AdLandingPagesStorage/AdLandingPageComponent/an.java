package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class an
{
  public float tm;
  public String zOW;
  public String zSf;
  public float zSg;
  
  public static an a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219382);
    an localan = new an();
    localan.zSf = bu.nullAsNil((String)paramMap.get(paramString + ".borderColor"));
    localan.zSg = i.a(bu.aSD((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
    localan.tm = i.a(bu.aSD((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
    localan.zOW = bu.nullAsNil((String)paramMap.get(paramString + ".bgColor"));
    AppMethodBeat.o(219382);
    return localan;
  }
  
  public static void a(View paramView, an paraman)
  {
    int j = 0;
    AppMethodBeat.i(219383);
    try
    {
      String str2 = paraman.zSf;
      String str1 = paraman.zOW;
      float f1 = paraman.zSg;
      float f2 = paraman.tm;
      Object localObject = null;
      boolean bool = bu.isNullOrNil(str2);
      paraman = (an)localObject;
      if (!bool)
      {
        paraman = (an)localObject;
        if (f1 <= 0.0F) {}
      }
      try
      {
        i = Color.parseColor(str2);
        paraman = new GradientDrawable();
        paraman.setShape(0);
        paraman.setStroke((int)f1, i);
        bool = bu.isNullOrNil(str1);
        localObject = paraman;
        if (bool) {}
      }
      catch (Exception paraman)
      {
        try
        {
          i = Color.parseColor(str1);
          localObject = paraman;
          if (paraman == null)
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
          AppMethodBeat.o(219383);
          return;
          paraman = paraman;
          ae.e("BorderCornerBgInfo", bu.o(paraman));
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("BorderCornerBgInfo", bu.o(localException));
            int i = j;
          }
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      ae.e("BorderCornerBgInfo", "");
      AppMethodBeat.o(219383);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an
 * JD-Core Version:    0.7.0.1
 */