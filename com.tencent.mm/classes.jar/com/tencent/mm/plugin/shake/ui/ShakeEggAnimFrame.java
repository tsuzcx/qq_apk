package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.b;
import com.tencent.mm.cf.c;
import com.tencent.mm.cf.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame
  extends FrameLayout
{
  int ph;
  int size;
  List<View> xzB;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28385);
    this.xzB = new ArrayList();
    this.size = 0;
    this.ph = 0;
    AppMethodBeat.o(28385);
  }
  
  static float Z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(28387);
    float f = (float)Math.random();
    AppMethodBeat.o(28387);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private int getSize()
  {
    AppMethodBeat.i(28388);
    if (this.size == 0)
    {
      i = (int)(new TextView(getContext()).getTextSize() * 1.2D);
      AppMethodBeat.o(28388);
      return i;
    }
    int i = this.size;
    AppMethodBeat.o(28388);
    return i;
  }
  
  public final void aC(Activity paramActivity)
  {
    AppMethodBeat.i(28386);
    Object localObject1 = this.xzB.iterator();
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
      paramActivity = new b(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
      g.eXw();
      localObject2 = b.eXh();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).GxI.get(107), true);
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
      ((a)paramActivity).targetView = ((View)localObject3);
      this.xzB.add(localObject3);
      i += 1;
    }
    AppMethodBeat.o(28386);
  }
  
  abstract class a
    extends Animation
  {
    protected int duration = 100;
    View targetView;
    
    a() {}
    
    public final void dDS()
    {
      if (this.targetView != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.targetView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28380);
            if (ShakeEggAnimFrame.a.this.targetView != null)
            {
              ShakeEggAnimFrame.a.this.targetView.clearAnimation();
              ShakeEggAnimFrame localShakeEggAnimFrame = ShakeEggAnimFrame.this;
              View localView = ShakeEggAnimFrame.a.this.targetView;
              localShakeEggAnimFrame.xzB.remove(localView);
              localShakeEggAnimFrame.removeView(localView);
            }
            AppMethodBeat.o(28380);
          }
        });
        return;
      }
    }
  }
  
  final class b
    extends ShakeEggAnimFrame.a
  {
    private int fUl;
    private int mm;
    private float xzE;
    private float xzF;
    private float xzG;
    private float xzH;
    private float xzI;
    private float xzJ;
    private float xzK;
    private float xzL;
    private float xzM;
    private float xzN;
    
    public b(int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(28381);
      this.xzI = 0.01F;
      this.xzJ = 0.02F;
      this.fUl = paramInt1;
      this.mm = paramInt2;
      this.xzE = ShakeEggAnimFrame.Z(0.1F, 0.9F);
      this.xzF = this.xzE;
      this.xzH = ShakeEggAnimFrame.Z(-0.3F, -0.1F);
      restart();
      AppMethodBeat.o(28381);
    }
    
    private void resolve()
    {
      this.xzK = (this.xzE * this.fUl);
      this.xzL = (this.xzF * this.fUl);
      this.xzM = (this.xzG * this.mm);
      this.xzN = (this.xzH * this.mm);
    }
    
    private void restart()
    {
      AppMethodBeat.i(28383);
      if (this.xzH > 0.0F) {
        this.xzJ += this.xzI;
      }
      this.xzG = this.xzH;
      this.xzH += this.xzJ;
      if (this.xzG > 1.1F) {
        dDS();
      }
      resolve();
      AppMethodBeat.o(28383);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(28382);
      float f1 = this.xzK;
      float f2 = this.xzM;
      if (this.xzK != this.xzL) {
        f1 = this.xzK + (this.xzL - this.xzK) * paramFloat;
      }
      if (this.xzM != this.xzN) {
        f2 = this.xzM + (this.xzN - this.xzM) * paramFloat;
      }
      paramTransformation.getMatrix().setTranslate(f1, f2);
      if (paramFloat == 1.0F) {
        restart();
      }
      AppMethodBeat.o(28382);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(28384);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      setRepeatCount(-1);
      setDuration(this.duration);
      AppMethodBeat.o(28384);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame
 * JD-Core Version:    0.7.0.1
 */