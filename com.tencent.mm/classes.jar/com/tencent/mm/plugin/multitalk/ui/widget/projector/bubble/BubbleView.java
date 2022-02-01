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
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;

public class BubbleView
  extends RelativeLayout
  implements Runnable
{
  protected int FfJ;
  protected a LzG;
  protected float LzH;
  protected RelativeLayout LzI;
  protected ImageView LzJ;
  protected int LzK;
  float LzL;
  float LzM;
  float LzN;
  int arrowRes;
  protected int backgroundColor;
  private TextView lzO;
  protected Context mContext;
  
  public BubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(285873);
    this.LzL = 0.0F;
    this.LzM = 0.0F;
    this.LzN = 0.0F;
    this.arrowRes = -1;
    d(paramContext, paramAttributeSet);
    AppMethodBeat.o(285873);
  }
  
  public BubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(285879);
    this.LzL = 0.0F;
    this.LzM = 0.0F;
    this.LzN = 0.0F;
    this.arrowRes = -1;
    d(paramContext, paramAttributeSet);
    AppMethodBeat.o(285879);
  }
  
  private void a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, String paramString)
  {
    AppMethodBeat.i(285915);
    this.LzI = new RelativeLayout(this.mContext);
    this.LzI.setId(View.generateViewId());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, (int)this.LzN);
    Object localObject = new a(paramInt1, paramFloat1);
    this.LzI.setBackground((Drawable)localObject);
    a(paramInt2, paramFloat2, paramString);
    this.LzJ = new ImageView(this.mContext);
    this.LzJ.setId(View.generateViewId());
    paramString = new RelativeLayout.LayoutParams((int)this.LzL, (int)this.LzM);
    switch (1.LzO[this.LzG.ordinal()])
    {
    default: 
      paramInt1 = 270;
      paramString.addRule(17, this.LzI.getId());
    }
    for (;;)
    {
      localObject = new BitmapDrawable(BitmapUtil.rotate(b(bb.m(this.mContext, this.arrowRes, this.mContext.getResources().getColor(a.b.White)), this.LzL, this.LzM), paramInt1));
      this.LzJ.setImageDrawable((Drawable)localObject);
      addView(this.LzJ, paramString);
      addView(this.LzI, localLayoutParams);
      this.LzI.post(this);
      setClickable(true);
      AppMethodBeat.o(285915);
      return;
      paramInt1 = 90;
      localLayoutParams.addRule(17, this.LzJ.getId());
      continue;
      paramInt1 = 180;
      localLayoutParams.addRule(3, this.LzJ.getId());
      continue;
      paramInt1 = 0;
      paramString.addRule(3, this.LzI.getId());
    }
  }
  
  private void a(int paramInt, float paramFloat, String paramString)
  {
    AppMethodBeat.i(285934);
    b(paramInt, paramFloat, paramString);
    this.LzI.addView(this.lzO);
    AppMethodBeat.o(285934);
  }
  
  private static Bitmap b(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(285926);
    Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, (int)paramFloat1, (int)paramFloat2);
    paramDrawable.draw(localCanvas);
    AppMethodBeat.o(285926);
    return localBitmap;
  }
  
  private void b(int paramInt, float paramFloat, String paramString)
  {
    AppMethodBeat.i(285940);
    this.lzO = new TextView(this.mContext);
    this.lzO.setId(View.generateViewId());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(17);
    localLayoutParams.setMarginStart(f.LtS);
    localLayoutParams.setMarginEnd(f.LtS);
    localLayoutParams.topMargin = f.LtS;
    localLayoutParams.bottomMargin = f.LtS;
    this.lzO.setLayoutParams(localLayoutParams);
    this.lzO.setTextColor(paramInt);
    this.lzO.setTextSize(bd.K(this.mContext, (int)paramFloat));
    this.lzO.setText(paramString);
    AppMethodBeat.o(285940);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(285889);
    this.mContext = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.BubbleTextView);
    float f1 = paramContext.getDimension(a.i.BubbleTextView_bubbleCornerRadius, 0.0F);
    this.backgroundColor = paramContext.getColor(a.i.BubbleTextView_bubbleBackgroundColor, 0);
    this.LzL = paramContext.getDimension(a.i.BubbleTextView_arrowWidth, 0.0F);
    this.LzM = paramContext.getDimension(a.i.BubbleTextView_arrowHeight, 0.0F);
    int i = paramContext.getColor(a.i.BubbleTextView_bubbleTextColor, 0);
    float f2 = paramContext.getDimension(a.i.BubbleTextView_bubbleTextSize, 0.0F);
    paramAttributeSet = paramContext.getString(a.i.BubbleTextView_bubbleText);
    this.arrowRes = paramContext.getResourceId(a.i.BubbleTextView_arrowRes, -1);
    setCurDirection(paramContext.getInt(a.i.BubbleTextView_bubbleArrowDirection, 3));
    setRelativePosition(paramContext.getFraction(a.i.BubbleTextView_relativePosition, 1, 1, 0.3F));
    setCurThemeStyle(i);
    this.LzN = paramContext.getDimension(a.i.BubbleTextView_contentHeight, 0.0F);
    paramContext.recycle();
    a(f1, this.backgroundColor, i, f2, paramAttributeSet);
    AppMethodBeat.o(285889);
  }
  
  private void setCurDirection(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.LzG = a.LzP;
      return;
    case 2: 
      this.LzG = a.LzQ;
      return;
    case 3: 
      this.LzG = a.LzR;
      return;
    }
    this.LzG = a.LzS;
  }
  
  private void setRelativePosition(float paramFloat)
  {
    if (paramFloat < 0.2F)
    {
      this.LzH = 0.2F;
      return;
    }
    if (paramFloat > 0.8F)
    {
      this.LzH = 0.8F;
      return;
    }
    this.LzH = paramFloat;
  }
  
  public float getRelative()
  {
    return this.LzH;
  }
  
  public void run()
  {
    AppMethodBeat.i(285948);
    int i = this.LzI.getWidth();
    int j = this.LzI.getHeight();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.LzJ.getLayoutParams();
    switch (1.LzO[this.LzG.ordinal()])
    {
    default: 
      this.LzK = ((int)(j * this.LzH - this.LzJ.getHeight() / 2));
      localLayoutParams.setMargins(0, this.LzK, 0, 0);
    }
    for (;;)
    {
      this.LzJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(285948);
      return;
      this.LzK = ((int)(i * this.LzH - this.LzJ.getWidth() / 2));
      localLayoutParams.setMargins(this.LzK, 0, 0, 0);
    }
  }
  
  public void setCurThemeStyle(int paramInt)
  {
    this.FfJ = 3;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(285882);
      LzP = new a("LEFT", 0);
      LzQ = new a("TOP", 1);
      LzR = new a("RIGHT", 2);
      LzS = new a("BOTTOM", 3);
      LzT = new a[] { LzP, LzQ, LzR, LzS };
      AppMethodBeat.o(285882);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble.BubbleView
 * JD-Core Version:    0.7.0.1
 */