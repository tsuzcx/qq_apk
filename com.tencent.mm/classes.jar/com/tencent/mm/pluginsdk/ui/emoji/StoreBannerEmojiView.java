package com.tencent.mm.pluginsdk.ui.emoji;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class StoreBannerEmojiView
  extends MMAnimateView
{
  private static String TAG = "MicroMsg.emoji.StoreBannerEmojiView";
  
  public StoreBannerEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoreBannerEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = getContext();
    int[] arrayOfInt = new int[2];
    if ((localObject instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)localObject).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
    }
    int i;
    int j;
    for (;;)
    {
      i = arrayOfInt[0];
      j = i * 3 / 8 + 1;
      if ((i > 0) && (j > 0)) {
        break;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
      localObject = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay();
      arrayOfInt[0] = ((Display)localObject).getWidth();
      arrayOfInt[1] = ((Display)localObject).getHeight();
    }
    setMeasuredDimension(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView
 * JD-Core Version:    0.7.0.1
 */