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
  int ra;
  int size;
  List<View> zev;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28385);
    this.zev = new ArrayList();
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
  
  public final void aD(Activity paramActivity)
  {
    AppMethodBeat.i(28386);
    Object localObject1 = this.zev.iterator();
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
      g.fqZ();
      localObject2 = b.fqL();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).IDN.get(107), true);
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
      this.zev.add(localObject3);
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
    
    public final void dSS()
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
              localShakeEggAnimFrame.zev.remove(localView);
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
    private int gqj;
    private int of;
    private float zeA;
    private float zeB;
    private float zeC;
    private float zeD;
    private float zeE;
    private float zeF;
    private float zeG;
    private float zeH;
    private float zey;
    private float zez;
    
    public b(int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(28381);
      this.zeC = 0.01F;
      this.zeD = 0.02F;
      this.gqj = paramInt1;
      this.of = paramInt2;
      this.zey = ShakeEggAnimFrame.ad(0.1F, 0.9F);
      this.zez = this.zey;
      this.zeB = ShakeEggAnimFrame.ad(-0.3F, -0.1F);
      restart();
      AppMethodBeat.o(28381);
    }
    
    private void resolve()
    {
      this.zeE = (this.zey * this.gqj);
      this.zeF = (this.zez * this.gqj);
      this.zeG = (this.zeA * this.of);
      this.zeH = (this.zeB * this.of);
    }
    
    private void restart()
    {
      AppMethodBeat.i(28383);
      if (this.zeB > 0.0F) {
        this.zeD += this.zeC;
      }
      this.zeA = this.zeB;
      this.zeB += this.zeD;
      if (this.zeA > 1.1F) {
        dSS();
      }
      resolve();
      AppMethodBeat.o(28383);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(28382);
      float f1 = this.zeE;
      float f2 = this.zeG;
      if (this.zeE != this.zeF) {
        f1 = this.zeE + (this.zeF - this.zeE) * paramFloat;
      }
      if (this.zeG != this.zeH) {
        f2 = this.zeG + (this.zeH - this.zeG) * paramFloat;
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