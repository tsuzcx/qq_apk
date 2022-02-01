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
  int ra;
  int size;
  List<View> yOl;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28385);
    this.yOl = new ArrayList();
    this.size = 0;
    this.ra = 0;
    AppMethodBeat.o(28385);
  }
  
  static float ad(float paramFloat1, float paramFloat2)
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
    Object localObject1 = this.yOl.iterator();
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
      g.fng();
      localObject2 = b.fmR();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).IjC.get(107), true);
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
      this.yOl.add(localObject3);
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
    
    public final void dPv()
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
              localShakeEggAnimFrame.yOl.remove(localView);
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
    private int gnN;
    private int of;
    private float yOo;
    private float yOp;
    private float yOq;
    private float yOr;
    private float yOs;
    private float yOt;
    private float yOu;
    private float yOv;
    private float yOw;
    private float yOx;
    
    public b(int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(28381);
      this.yOs = 0.01F;
      this.yOt = 0.02F;
      this.gnN = paramInt1;
      this.of = paramInt2;
      this.yOo = ShakeEggAnimFrame.ad(0.1F, 0.9F);
      this.yOp = this.yOo;
      this.yOr = ShakeEggAnimFrame.ad(-0.3F, -0.1F);
      restart();
      AppMethodBeat.o(28381);
    }
    
    private void resolve()
    {
      this.yOu = (this.yOo * this.gnN);
      this.yOv = (this.yOp * this.gnN);
      this.yOw = (this.yOq * this.of);
      this.yOx = (this.yOr * this.of);
    }
    
    private void restart()
    {
      AppMethodBeat.i(28383);
      if (this.yOr > 0.0F) {
        this.yOt += this.yOs;
      }
      this.yOq = this.yOr;
      this.yOr += this.yOt;
      if (this.yOq > 1.1F) {
        dPv();
      }
      resolve();
      AppMethodBeat.o(28383);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(28382);
      float f1 = this.yOu;
      float f2 = this.yOw;
      if (this.yOu != this.yOv) {
        f1 = this.yOu + (this.yOv - this.yOu) * paramFloat;
      }
      if (this.yOw != this.yOx) {
        f2 = this.yOw + (this.yOx - this.yOw) * paramFloat;
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