package com.tencent.biz.lebsearch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.lebsearch.util.ImageUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Statics
{
  public static Paint paint = new Paint();
  
  public static void dealTitleAndSecondText(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence, TextView paramTextView3)
  {
    if (paramTextView1 == null) {
      return;
    }
    int i = paramTextView1.getContext().getResources().getDisplayMetrics().widthPixels;
    float f1 = 0.0F;
    if (paramTextView3 != null)
    {
      paint.setTextSize(paramTextView3.getTextSize());
      f1 = paint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + dip2px(paramTextView1.getContext(), 4.0F);
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding((int)dip2px(paramTextView1.getContext(), 2.0F), 0, (int)dip2px(paramTextView1.getContext(), 2.0F), 0);
    }
    float f3 = i - dip2px(paramTextView1.getContext(), 89.0F);
    float f2 = f3;
    if (f1 != 0.0F) {
      f2 = f3 - (dip2px(paramTextView1.getContext(), 6.0F) + f1);
    }
    paint.setTextSize(paramTextView1.getTextSize());
    if (paint.measureText(paramCharSequence, 0, paramCharSequence.length()) > f2)
    {
      paramTextView1.setMaxLines(2);
      paramTextView2.setMaxLines(1);
      return;
    }
    paramTextView1.setMaxLines(1);
    paramTextView2.setMaxLines(2);
  }
  
  public static void dealWithCover(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 1)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2114060288);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2114060307);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    paramImageView1.setColorFilter(0);
    paramImageView2.setVisibility(8);
  }
  
  public static float dip2px(Context paramContext, float paramFloat)
  {
    return paramFloat * paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static void setImage(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    setImage(paramImageView, paramString, paramInt1, paramInt2, 0);
  }
  
  public static void setImage(ImageView paramImageView, final String paramString, int paramInt1, int paramInt2, final float paramFloat, final int paramInt3)
  {
    if (paramImageView == null) {
      return;
    }
    for (;;)
    {
      try
      {
        String str = "Dalvik/1.6.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + ")";
        new URL(paramString);
        if ((paramInt1 > 0) && (paramInt2 > 0))
        {
          paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2);
          paramString.addHeader("User-Agent", str);
          paramString.setURLDrawableListener(new URLDrawable.URLDrawableListener()
          {
            public void onLoadCanceled(URLDrawable paramAnonymousURLDrawable)
            {
              this.val$imageView.setImageDrawable(null);
              this.val$imageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
            }
            
            public void onLoadFialed(URLDrawable paramAnonymousURLDrawable, Throwable paramAnonymousThrowable)
            {
              if (paramInt3 != 0)
              {
                this.val$imageView.setBackgroundResource(paramInt3);
                return;
              }
              this.val$imageView.setImageDrawable(null);
              this.val$imageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
            }
            
            public void onLoadProgressed(URLDrawable paramAnonymousURLDrawable, int paramAnonymousInt) {}
            
            public void onLoadSuccessed(URLDrawable paramAnonymousURLDrawable)
            {
              this.val$imageView.setImageDrawable(null);
              this.val$imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
              this.val$imageView.setImageDrawable(ImageUtil.round(paramString, paramFloat));
            }
          });
          if (!paramString.isDownloadStarted()) {
            break label142;
          }
          paramImageView.setImageDrawable(ImageUtil.round(paramString, paramFloat));
          paramImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          return;
        }
      }
      catch (MalformedURLException paramString)
      {
        paramImageView.setImageDrawable(null);
        paramImageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
        return;
      }
      paramString = URLDrawable.getDrawable(paramString);
      continue;
      label142:
      paramImageView.setImageDrawable(paramString);
    }
  }
  
  public static void setImage(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    setImage(paramImageView, paramString, paramInt1, paramInt2, 0.0F, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.Statics
 * JD-Core Version:    0.7.0.1
 */