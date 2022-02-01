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
import com.tencent.mm.cl.b;
import com.tencent.mm.cl.c;
import com.tencent.mm.cl.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame
  extends FrameLayout
{
  List<View> JoP;
  int bAm;
  int size;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28385);
    this.JoP = new ArrayList();
    this.size = 0;
    this.bAm = 0;
    AppMethodBeat.o(28385);
  }
  
  static float am(float paramFloat1, float paramFloat2)
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
  
  public final void aK(Activity paramActivity)
  {
    AppMethodBeat.i(28386);
    Object localObject1 = this.JoP.iterator();
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
      h.htZ();
      localObject2 = b.htF();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).UYf.get(107), true);
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
      ((a)paramActivity).kJL = ((View)localObject3);
      this.JoP.add(localObject3);
      i += 1;
    }
    AppMethodBeat.o(28386);
  }
  
  abstract class a
    extends Animation
  {
    protected int duration = 100;
    View kJL;
    
    a() {}
    
    public final void fHU()
    {
      if (this.kJL != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.kJL.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28380);
            if (ShakeEggAnimFrame.a.this.kJL != null)
            {
              ShakeEggAnimFrame.a.this.kJL.clearAnimation();
              ShakeEggAnimFrame localShakeEggAnimFrame = ShakeEggAnimFrame.this;
              View localView = ShakeEggAnimFrame.a.this.kJL;
              localShakeEggAnimFrame.JoP.remove(localView);
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
    private float JoS;
    private float JoT;
    private float JoU;
    private float JoV;
    private float JoW;
    private float JoX;
    private float JoY;
    private float JoZ;
    private float Jpa;
    private float Jpb;
    private int bxE;
    private int jMo;
    
    public b(int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(28381);
      this.JoW = 0.01F;
      this.JoX = 0.02F;
      this.jMo = paramInt1;
      this.bxE = paramInt2;
      this.JoS = ShakeEggAnimFrame.am(0.1F, 0.9F);
      this.JoT = this.JoS;
      this.JoV = ShakeEggAnimFrame.am(-0.3F, -0.1F);
      bgP();
      AppMethodBeat.o(28381);
    }
    
    private void bgP()
    {
      AppMethodBeat.i(28383);
      if (this.JoV > 0.0F) {
        this.JoX += this.JoW;
      }
      this.JoU = this.JoV;
      this.JoV += this.JoX;
      if (this.JoU > 1.1F) {
        fHU();
      }
      fs();
      AppMethodBeat.o(28383);
    }
    
    private void fs()
    {
      this.JoY = (this.JoS * this.jMo);
      this.JoZ = (this.JoT * this.jMo);
      this.Jpa = (this.JoU * this.bxE);
      this.Jpb = (this.JoV * this.bxE);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(28382);
      float f1 = this.JoY;
      float f2 = this.Jpa;
      if (this.JoY != this.JoZ) {
        f1 = this.JoY + (this.JoZ - this.JoY) * paramFloat;
      }
      if (this.Jpa != this.Jpb) {
        f2 = this.Jpa + (this.Jpb - this.Jpa) * paramFloat;
      }
      paramTransformation.getMatrix().setTranslate(f1, f2);
      if (paramFloat == 1.0F) {
        bgP();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame
 * JD-Core Version:    0.7.0.1
 */