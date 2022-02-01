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
import com.tencent.mm.cg.b;
import com.tencent.mm.cg.c;
import com.tencent.mm.cg.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame
  extends FrameLayout
{
  int og;
  int size;
  List<View> wok;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28385);
    this.wok = new ArrayList();
    this.size = 0;
    this.og = 0;
    AppMethodBeat.o(28385);
  }
  
  static float V(float paramFloat1, float paramFloat2)
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
  
  public final void ay(Activity paramActivity)
  {
    AppMethodBeat.i(28386);
    Object localObject1 = this.wok.iterator();
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
      g.eIa();
      localObject2 = b.eHL();
      localObject2 = ((b)localObject2).a((c)((b)localObject2).Far.get(107), true);
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
      this.wok.add(localObject3);
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
    
    public final void dpI()
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
              localShakeEggAnimFrame.wok.remove(localView);
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
    private int fQq;
    private int ln;
    private float won;
    private float woo;
    private float wop;
    private float woq;
    private float wor;
    private float wos;
    private float wot;
    private float wou;
    private float wov;
    private float wow;
    
    public b(int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(28381);
      this.wor = 0.01F;
      this.wos = 0.02F;
      this.fQq = paramInt1;
      this.ln = paramInt2;
      this.won = ShakeEggAnimFrame.V(0.1F, 0.9F);
      this.woo = this.won;
      this.woq = ShakeEggAnimFrame.V(-0.3F, -0.1F);
      restart();
      AppMethodBeat.o(28381);
    }
    
    private void resolve()
    {
      this.wot = (this.won * this.fQq);
      this.wou = (this.woo * this.fQq);
      this.wov = (this.wop * this.ln);
      this.wow = (this.woq * this.ln);
    }
    
    private void restart()
    {
      AppMethodBeat.i(28383);
      if (this.woq > 0.0F) {
        this.wos += this.wor;
      }
      this.wop = this.woq;
      this.woq += this.wos;
      if (this.wop > 1.1F) {
        dpI();
      }
      resolve();
      AppMethodBeat.o(28383);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(28382);
      float f1 = this.wot;
      float f2 = this.wov;
      if (this.wot != this.wou) {
        f1 = this.wot + (this.wou - this.wot) * paramFloat;
      }
      if (this.wov != this.wow) {
        f2 = this.wov + (this.wow - this.wov) * paramFloat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame
 * JD-Core Version:    0.7.0.1
 */