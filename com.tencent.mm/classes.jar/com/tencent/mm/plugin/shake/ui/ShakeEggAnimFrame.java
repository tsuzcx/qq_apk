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
import com.tencent.mm.ce.b;
import com.tencent.mm.ce.c;
import com.tencent.mm.ce.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame
  extends FrameLayout
{
  List<View> Djn;
  int rd;
  int size;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28385);
    this.Djn = new ArrayList();
    this.size = 0;
    this.rd = 0;
    AppMethodBeat.o(28385);
  }
  
  static float ak(float paramFloat1, float paramFloat2)
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
  
  public final void aE(Activity paramActivity)
  {
    AppMethodBeat.i(28386);
    Object localObject1 = this.Djn.iterator();
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
      g.gxZ();
      localObject2 = b.gxI();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).NKE.get(107), true);
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
      this.Djn.add(localObject3);
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
    
    public final void eUT()
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
              localShakeEggAnimFrame.Djn.remove(localView);
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
    private float Djq;
    private float Djr;
    private float Djs;
    private float Djt;
    private float Dju;
    private float Djv;
    private float Djw;
    private float Djx;
    private float Djy;
    private float Djz;
    private int hbc;
    private int oh;
    
    public b(int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(28381);
      this.Dju = 0.01F;
      this.Djv = 0.02F;
      this.hbc = paramInt1;
      this.oh = paramInt2;
      this.Djq = ShakeEggAnimFrame.ak(0.1F, 0.9F);
      this.Djr = this.Djq;
      this.Djt = ShakeEggAnimFrame.ak(-0.3F, -0.1F);
      restart();
      AppMethodBeat.o(28381);
    }
    
    private void resolve()
    {
      this.Djw = (this.Djq * this.hbc);
      this.Djx = (this.Djr * this.hbc);
      this.Djy = (this.Djs * this.oh);
      this.Djz = (this.Djt * this.oh);
    }
    
    private void restart()
    {
      AppMethodBeat.i(28383);
      if (this.Djt > 0.0F) {
        this.Djv += this.Dju;
      }
      this.Djs = this.Djt;
      this.Djt += this.Djv;
      if (this.Djs > 1.1F) {
        eUT();
      }
      resolve();
      AppMethodBeat.o(28383);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(28382);
      float f1 = this.Djw;
      float f2 = this.Djy;
      if (this.Djw != this.Djx) {
        f1 = this.Djw + (this.Djx - this.Djw) * paramFloat;
      }
      if (this.Djy != this.Djz) {
        f2 = this.Djy + (this.Djz - this.Djy) * paramFloat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame
 * JD-Core Version:    0.7.0.1
 */