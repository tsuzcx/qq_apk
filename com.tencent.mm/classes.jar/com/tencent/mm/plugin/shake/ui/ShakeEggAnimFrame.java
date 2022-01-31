package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.cd.b;
import com.tencent.mm.cd.c;
import com.tencent.mm.cd.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShakeEggAnimFrame
  extends FrameLayout
{
  List<View> obn = new ArrayList();
  int obo = 0;
  int size = 0;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  static float L(float paramFloat1, float paramFloat2)
  {
    return (float)Math.random() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  public final void L(Activity paramActivity)
  {
    Object localObject1 = this.obn.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (View)((Iterator)localObject1).next();
      ((View)localObject2).clearAnimation();
      removeView((View)localObject2);
    }
    localObject1 = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    setVisibility(0);
    int i = 0;
    while (i < 30)
    {
      paramActivity = new ShakeEggAnimFrame.b(this, ((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
      g.csM();
      localObject2 = b.csC();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).ukM.get(107), true);
      ((Drawable)localObject2).setBounds(0, 0, getSize(), getSize());
      Object localObject3 = new ImageSpan((Drawable)localObject2, 1);
      localObject2 = new SpannableString("  ");
      ((SpannableString)localObject2).setSpan(localObject3, 0, 1, 33);
      localObject3 = new TextView(getContext());
      ((TextView)localObject3).setSingleLine();
      ((TextView)localObject3).setText((CharSequence)localObject2);
      ((TextView)localObject3).setAnimation(paramActivity);
      ((TextView)localObject3).setTag(paramActivity);
      addView((View)localObject3);
      ((ShakeEggAnimFrame.a)paramActivity).targetView = ((View)localObject3);
      this.obn.add(localObject3);
      i += 1;
    }
  }
  
  int getSize()
  {
    if (this.size == 0) {
      return (int)(new TextView(getContext()).getTextSize() * 1.2D);
    }
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame
 * JD-Core Version:    0.7.0.1
 */