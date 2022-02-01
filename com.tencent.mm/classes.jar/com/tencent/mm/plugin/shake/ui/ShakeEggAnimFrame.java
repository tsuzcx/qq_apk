package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.smiley.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame
  extends FrameLayout
{
  List<View> PBM;
  int dtn;
  int size;
  
  public ShakeEggAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28385);
    this.PBM = new ArrayList();
    this.size = 0;
    this.dtn = 0;
    AppMethodBeat.o(28385);
  }
  
  static float aQ(float paramFloat1, float paramFloat2)
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
  
  public final void bm(Activity paramActivity)
  {
    AppMethodBeat.i(28386);
    Object localObject1 = this.PBM.iterator();
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
      u.iVt();
      EmojiHelper.iUM();
      localObject2 = EmojiHelper.iUO();
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
      ((a)paramActivity).nmf = ((View)localObject3);
      this.PBM.add(localObject3);
      i += 1;
    }
    AppMethodBeat.o(28386);
  }
  
  abstract class a
    extends Animation
  {
    protected int duration = 100;
    View nmf;
    
    a() {}
    
    public final void gXJ()
    {
      if (this.nmf != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.nmf.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28380);
            if (ShakeEggAnimFrame.a.this.nmf != null)
            {
              ShakeEggAnimFrame.a.this.nmf.clearAnimation();
              ShakeEggAnimFrame localShakeEggAnimFrame = ShakeEggAnimFrame.this;
              View localView = ShakeEggAnimFrame.a.this.nmf;
              localShakeEggAnimFrame.PBM.remove(localView);
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
    private float PBP;
    private float PBQ;
    private float PBR;
    private float PBS;
    private float PBT;
    private float PBU;
    private float PBV;
    private float PBW;
    private float PBX;
    private float PBY;
    private int aMZ;
    private int dqH;
    
    public b(int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(28381);
      this.PBT = 0.01F;
      this.PBU = 0.02F;
      this.aMZ = paramInt1;
      this.dqH = paramInt2;
      this.PBP = ShakeEggAnimFrame.aQ(0.1F, 0.9F);
      this.PBQ = this.PBP;
      this.PBS = ShakeEggAnimFrame.aQ(-0.3F, -0.1F);
      bEH();
      AppMethodBeat.o(28381);
    }
    
    private void CB()
    {
      this.PBV = (this.PBP * this.aMZ);
      this.PBW = (this.PBQ * this.aMZ);
      this.PBX = (this.PBR * this.dqH);
      this.PBY = (this.PBS * this.dqH);
    }
    
    private void bEH()
    {
      AppMethodBeat.i(28383);
      if (this.PBS > 0.0F) {
        this.PBU += this.PBT;
      }
      this.PBR = this.PBS;
      this.PBS += this.PBU;
      if (this.PBR > 1.1F) {
        gXJ();
      }
      CB();
      AppMethodBeat.o(28383);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(28382);
      float f1 = this.PBV;
      float f2 = this.PBX;
      if (this.PBV != this.PBW) {
        f1 = this.PBV + (this.PBW - this.PBV) * paramFloat;
      }
      if (this.PBX != this.PBY) {
        f2 = this.PBX + (this.PBY - this.PBX) * paramFloat;
      }
      paramTransformation.getMatrix().setTranslate(f1, f2);
      if (paramFloat == 1.0F) {
        bEH();
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