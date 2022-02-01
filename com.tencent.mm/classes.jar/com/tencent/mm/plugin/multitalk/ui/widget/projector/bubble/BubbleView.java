package com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;

public class BubbleView
  extends RelativeLayout
  implements Runnable
{
  protected int backgroundColor;
  private TextView gtJ;
  protected Context mContext;
  protected a zYk;
  protected float zYl;
  protected RelativeLayout zYm;
  protected ImageView zYn;
  protected int zYo;
  protected int zYp;
  float zYq;
  float zYr;
  float zYs;
  int zYt;
  
  public BubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239496);
    this.zYq = 0.0F;
    this.zYr = 0.0F;
    this.zYs = 0.0F;
    this.zYt = -1;
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(239496);
  }
  
  public BubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(239497);
    this.zYq = 0.0F;
    this.zYr = 0.0F;
    this.zYs = 0.0F;
    this.zYt = -1;
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(239497);
  }
  
  private void a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, String paramString)
  {
    AppMethodBeat.i(239499);
    this.zYm = new RelativeLayout(this.mContext);
    this.zYm.setId(View.generateViewId());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, (int)this.zYs);
    Object localObject = new a(paramInt1, paramFloat1);
    this.zYm.setBackground((Drawable)localObject);
    a(paramInt2, paramFloat2, paramString);
    this.zYn = new ImageView(this.mContext);
    this.zYn.setId(View.generateViewId());
    paramString = new RelativeLayout.LayoutParams((int)this.zYq, (int)this.zYr);
    switch (1.zYu[this.zYk.ordinal()])
    {
    default: 
      paramInt1 = 270;
      paramString.addRule(17, this.zYm.getId());
    }
    for (;;)
    {
      localObject = new BitmapDrawable(BitmapUtil.rotate(b(ar.m(this.mContext, this.zYt, this.mContext.getResources().getColor(2131099844)), this.zYq, this.zYr), paramInt1));
      this.zYn.setImageDrawable((Drawable)localObject);
      addView(this.zYn, paramString);
      addView(this.zYm, localLayoutParams);
      this.zYm.post(this);
      setClickable(true);
      AppMethodBeat.o(239499);
      return;
      paramInt1 = 90;
      localLayoutParams.addRule(17, this.zYn.getId());
      continue;
      paramInt1 = 180;
      localLayoutParams.addRule(3, this.zYn.getId());
      continue;
      paramInt1 = 0;
      paramString.addRule(3, this.zYm.getId());
    }
  }
  
  private void a(int paramInt, float paramFloat, String paramString)
  {
    AppMethodBeat.i(239501);
    b(paramInt, paramFloat, paramString);
    this.zYm.addView(this.gtJ);
    AppMethodBeat.o(239501);
  }
  
  private static Bitmap b(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(239500);
    Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, (int)paramFloat1, (int)paramFloat2);
    paramDrawable.draw(localCanvas);
    AppMethodBeat.o(239500);
    return localBitmap;
  }
  
  private void b(int paramInt, float paramFloat, String paramString)
  {
    AppMethodBeat.i(239502);
    this.gtJ = new TextView(this.mContext);
    this.gtJ.setId(View.generateViewId());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(17);
    localLayoutParams.setMarginStart(f.zSe);
    localLayoutParams.setMarginEnd(f.zSe);
    localLayoutParams.topMargin = f.zSe;
    localLayoutParams.bottomMargin = f.zSe;
    this.gtJ.setLayoutParams(localLayoutParams);
    this.gtJ.setTextColor(paramInt);
    this.gtJ.setTextSize(at.E(this.mContext, (int)paramFloat));
    this.gtJ.setText(paramString);
    AppMethodBeat.o(239502);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(239498);
    this.mContext = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BubbleTextView);
    float f1 = paramContext.getDimension(5, 0.0F);
    this.backgroundColor = paramContext.getColor(4, 0);
    this.zYq = paramContext.getDimension(2, 0.0F);
    this.zYr = paramContext.getDimension(0, 0.0F);
    int i = paramContext.getColor(7, 0);
    float f2 = paramContext.getDimension(8, 0.0F);
    paramAttributeSet = paramContext.getString(6);
    this.zYt = paramContext.getResourceId(1, -1);
    setCurDirection(paramContext.getInt(3, 3));
    setRelativePosition(paramContext.getFraction(12, 1, 1, 0.3F));
    setCurThemeStyle(i);
    this.zYs = paramContext.getDimension(10, 0.0F);
    paramContext.recycle();
    a(f1, this.backgroundColor, i, f2, paramAttributeSet);
    AppMethodBeat.o(239498);
  }
  
  private void setCurDirection(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.zYk = a.zYv;
      return;
    case 2: 
      this.zYk = a.zYw;
      return;
    case 3: 
      this.zYk = a.zYx;
      return;
    }
    this.zYk = a.zYy;
  }
  
  private void setRelativePosition(float paramFloat)
  {
    if (paramFloat < 0.2F)
    {
      this.zYl = 0.2F;
      return;
    }
    if (paramFloat > 0.8F)
    {
      this.zYl = 0.8F;
      return;
    }
    this.zYl = paramFloat;
  }
  
  public float getRelative()
  {
    return this.zYl;
  }
  
  public void run()
  {
    AppMethodBeat.i(239503);
    int i = this.zYm.getWidth();
    int j = this.zYm.getHeight();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.zYn.getLayoutParams();
    switch (1.zYu[this.zYk.ordinal()])
    {
    default: 
      this.zYo = ((int)(j * this.zYl - this.zYn.getHeight() / 2));
      localLayoutParams.setMargins(0, this.zYo, 0, 0);
    }
    for (;;)
    {
      this.zYn.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(239503);
      return;
      this.zYo = ((int)(i * this.zYl - this.zYn.getWidth() / 2));
      localLayoutParams.setMargins(this.zYo, 0, 0, 0);
    }
  }
  
  public void setCurThemeStyle(int paramInt)
  {
    this.zYp = 3;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(239495);
      zYv = new a("LEFT", 0);
      zYw = new a("TOP", 1);
      zYx = new a("RIGHT", 2);
      zYy = new a("BOTTOM", 3);
      zYz = new a[] { zYv, zYw, zYx, zYy };
      AppMethodBeat.o(239495);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble.BubbleView
 * JD-Core Version:    0.7.0.1
 */