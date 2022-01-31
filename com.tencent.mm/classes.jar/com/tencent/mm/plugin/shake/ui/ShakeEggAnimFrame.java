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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.cd.c;
import com.tencent.mm.cd.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShakeEggAnimFrame
  extends FrameLayout
{
  List<View> qPv;
  int qPw;
  int size;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24715);
    this.qPv = new ArrayList();
    this.size = 0;
    this.qPw = 0;
    AppMethodBeat.o(24715);
  }
  
  static float ab(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(24717);
    float f = (float)Math.random();
    AppMethodBeat.o(24717);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private int getSize()
  {
    AppMethodBeat.i(24718);
    if (this.size == 0)
    {
      i = (int)(new TextView(getContext()).getTextSize() * 1.2D);
      AppMethodBeat.o(24718);
      return i;
    }
    int i = this.size;
    AppMethodBeat.o(24718);
    return i;
  }
  
  public final void ag(Activity paramActivity)
  {
    AppMethodBeat.i(24716);
    Object localObject1 = this.qPv.iterator();
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
      g.dvk();
      localObject2 = b.duW();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).yuq.get(107), true);
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
      this.qPv.add(localObject3);
      i += 1;
    }
    AppMethodBeat.o(24716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame
 * JD-Core Version:    0.7.0.1
 */