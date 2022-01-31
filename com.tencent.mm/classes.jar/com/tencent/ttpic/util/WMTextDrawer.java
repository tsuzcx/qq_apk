package com.tencent.ttpic.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.ttpic.model.TextWMElement;
import com.tencent.ttpic.model.WMElement;
import com.tencent.util.g;

public class WMTextDrawer
{
  private static final String TAG = WMTextDrawer.class.getSimpleName();
  
  private void adjustTextSize(TextWMElement paramTextWMElement, Paint paramPaint, String paramString, boolean paramBoolean)
  {
    float f1 = 0.95F;
    if (!paramBoolean)
    {
      m = paramTextWMElement.width / paramString.length();
      paramPaint.setTextSize(m);
      float f5 = getTextWidth(paramPaint, paramString, false);
      float f4 = getTextHeight(paramPaint, paramString, false);
      i = paramTextWMElement.width - (paramString.length() - 1) * paramTextWMElement.kern;
      int n = paramTextWMElement.height;
      j = i;
      f2 = f4;
      f3 = f5;
      k = m;
      if (f5 < i)
      {
        j = i;
        f2 = f4;
        f3 = f5;
        k = m;
        if (f4 < n)
        {
          f2 = f5;
          while ((f2 < i) && (f4 < n))
          {
            j = m + 2;
            paramPaint.setTextSize(j);
            f3 = getTextWidth(paramPaint, paramString, false);
            f5 = getTextHeight(paramPaint, paramString, false);
            f4 = f5;
            f2 = f3;
            m = j;
            if ("HYHeiLiZhiTiJ".equals(paramTextWMElement.fontName))
            {
              paramTextWMElement.kern *= j / 141;
              i = paramTextWMElement.width - (paramString.length() - 1) * paramTextWMElement.kern;
              f4 = f5;
              f2 = f3;
              m = j;
            }
          }
          f2 = m - 2;
          if (paramTextWMElement.fontItalics) {}
          for (;;)
          {
            paramPaint.setTextSize(f1 * f2);
            return;
            f1 = 1.0F;
          }
        }
      }
      while ((f3 > j) || (f2 > n))
      {
        i = k - 2;
        paramPaint.setTextSize(i);
        f4 = getTextWidth(paramPaint, paramString, false);
        f5 = getTextHeight(paramPaint, paramString, false);
        f2 = f5;
        f3 = f4;
        k = i;
        if ("HYHeiLiZhiTiJ".equals(paramTextWMElement.fontName))
        {
          paramTextWMElement.kern *= i / 141;
          j = paramTextWMElement.width - (paramString.length() - 1) * paramTextWMElement.kern;
          f2 = f5;
          f3 = f4;
          k = i;
        }
      }
      f2 = k;
      if (paramTextWMElement.fontItalics) {}
      for (;;)
      {
        paramPaint.setTextSize(f1 * f2);
        return;
        f1 = 1.0F;
      }
    }
    Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
    float f2 = localFontMetrics.descent - localFontMetrics.ascent;
    int i = paramTextWMElement.height / paramString.length();
    paramPaint.setTextSize(i);
    int k = paramTextWMElement.width - (paramString.length() - 1) * paramTextWMElement.kern;
    int m = paramTextWMElement.height;
    int j = i;
    float f3 = f2;
    if (f2 < k)
    {
      j = i;
      f3 = f2;
      if (paramString.length() * f2 < m)
      {
        while ((f2 < k) && (f2 * paramString.length() < m))
        {
          i += 2;
          paramPaint.setTextSize(i);
          localFontMetrics = paramPaint.getFontMetrics();
          f2 = localFontMetrics.bottom - localFontMetrics.top;
        }
        f2 = i - 2;
        if (paramTextWMElement.fontItalics) {}
        for (;;)
        {
          paramPaint.setTextSize(f1 * f2);
          return;
          f1 = 1.0F;
        }
      }
    }
    while ((f3 > k) || (f3 * paramString.length() > m))
    {
      j -= 2;
      paramPaint.setTextSize(j);
      localFontMetrics = paramPaint.getFontMetrics();
      f3 = localFontMetrics.bottom - localFontMetrics.top;
    }
    f2 = j;
    if (paramTextWMElement.fontItalics) {}
    for (;;)
    {
      paramPaint.setTextSize(f1 * f2);
      return;
      f1 = 1.0F;
    }
  }
  
  private void drawHorizontalText(TextWMElement paramTextWMElement, Canvas paramCanvas, String paramString)
  {
    new WMTextDrawer.TextHorizontalLayout(this, paramString, getStyledPaint(paramTextWMElement, paramString, false), paramTextWMElement).draw(paramCanvas);
  }
  
  private void drawNormalVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, String paramString)
  {
    new WMTextDrawer.TextVerticalLayout(this, paramString, getStyledPaint(paramTextWMElement, paramString, true), paramTextWMElement).draw(paramCanvas);
  }
  
  private void drawRotatedVerticalText(TextWMElement paramTextWMElement, String paramString)
  {
    swapWidthHeight(paramTextWMElement);
    Bitmap localBitmap = Bitmap.createBitmap(paramTextWMElement.width, paramTextWMElement.height, Bitmap.Config.ARGB_8888);
    drawHorizontalText(paramTextWMElement, new Canvas(localBitmap), paramString);
    swapWidthHeight(paramTextWMElement);
    if ((paramTextWMElement.bitmap != null) && (!paramTextWMElement.bitmap.isRecycled())) {
      paramTextWMElement.bitmap.recycle();
    }
    paramTextWMElement.bitmap = rotateBitmap(localBitmap, paramTextWMElement.rotate);
  }
  
  private void drawVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, String paramString)
  {
    if ((paramTextWMElement.rotate == 90) || (paramTextWMElement.rotate == -90))
    {
      drawRotatedVerticalText(paramTextWMElement, paramString);
      return;
    }
    drawNormalVerticalText(paramTextWMElement, paramCanvas, paramString);
  }
  
  private TextPaint getStyledPaint(TextWMElement paramTextWMElement, String paramString, boolean paramBoolean)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    if (!TextUtils.isEmpty(paramTextWMElement.fontName)) {}
    try
    {
      if (paramTextWMElement.fontName.equals("sans_serif")) {
        localTextPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
      }
      for (;;)
      {
        if ((paramTextWMElement.fontSize <= 0.0F) || (paramTextWMElement.fontFit != 0)) {
          break label271;
        }
        localTextPaint.setTextSize(paramTextWMElement.fontSize);
        localTextPaint.setFakeBoldText(paramTextWMElement.fontBold);
        if (!paramTextWMElement.fontItalics) {
          break label283;
        }
        f = -0.2F;
        localTextPaint.setTextSkewX(f);
        if (paramTextWMElement.shadowSize > 0.0F) {
          localTextPaint.setShadowLayer(paramTextWMElement.shadowSize, paramTextWMElement.shadowDx, paramTextWMElement.shadowDy, Color.parseColor(paramTextWMElement.shadowColor));
        }
        localTextPaint.setColor(Color.parseColor(paramTextWMElement.color));
        return localTextPaint;
        if (!paramTextWMElement.fontName.equals("serif")) {
          break;
        }
        localTextPaint.setTypeface(Typeface.create(Typeface.SERIF, 0));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f;
        g.i(TAG, localException.getMessage());
        continue;
        if (paramTextWMElement.fontName.equals("monospace"))
        {
          localTextPaint.setTypeface(Typeface.create(Typeface.MONOSPACE, 0));
        }
        else
        {
          String str = "fonts/" + paramTextWMElement.fontName + ".ttf";
          localTextPaint.setTypeface(Typeface.createFromAsset(VideoGlobalContext.getContext().getAssets(), str));
          continue;
          label271:
          adjustTextSize(paramTextWMElement, localTextPaint, paramString, paramBoolean);
          continue;
          label283:
          f = 0.0F;
        }
      }
    }
  }
  
  private float getTextHeight(Paint paramPaint, String paramString, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    if (!paramBoolean) {
      return localRect.height() * 1.1F;
    }
    int i = paramString.length();
    return localRect.height() * i;
  }
  
  private float getTextWidth(Paint paramPaint, String paramString, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (!paramBoolean)
    {
      arrayOfFloat = new float[paramString.length()];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      for (;;)
      {
        f2 = f1;
        if (i >= paramString.length()) {
          break;
        }
        f1 += arrayOfFloat[i];
        i += 1;
      }
    }
    float[] arrayOfFloat = new float[paramString.length()];
    paramPaint.getTextWidths(paramString, arrayOfFloat);
    f1 = f2;
    i = j;
    for (;;)
    {
      f2 = f1;
      if (i >= paramString.length()) {
        break;
      }
      f2 = f1;
      if (arrayOfFloat[i] > f1) {
        f2 = arrayOfFloat[i];
      }
      i += 1;
      f1 = f2;
    }
    return f2;
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramFloat);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
      localObject = localBitmap;
    } while (localBitmap.equals(paramBitmap));
    paramBitmap.recycle();
    return localBitmap;
  }
  
  private void swapWidthHeight(WMElement paramWMElement)
  {
    int i = paramWMElement.width;
    paramWMElement.width = paramWMElement.height;
    paramWMElement.height = i;
  }
  
  public void drawTextToBitmap(TextWMElement paramTextWMElement, String paramString)
  {
    if ((paramTextWMElement.bitmap == null) || (paramTextWMElement.bitmap.isRecycled()) || (paramString == null)) {}
    do
    {
      return;
      paramTextWMElement.bitmap.eraseColor(0);
    } while (paramString.length() == 0);
    Canvas localCanvas = new Canvas(paramTextWMElement.bitmap);
    if (paramTextWMElement.vertical == 0)
    {
      drawHorizontalText(paramTextWMElement, localCanvas, paramString);
      return;
    }
    drawVerticalText(paramTextWMElement, localCanvas, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer
 * JD-Core Version:    0.7.0.1
 */