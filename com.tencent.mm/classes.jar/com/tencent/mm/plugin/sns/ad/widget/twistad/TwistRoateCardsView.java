package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.xwalk.core.Log;

public class TwistRoateCardsView
  extends FrameLayout
{
  public int JNB;
  public int JNC;
  private View JNF;
  private int JOL;
  private int JOM;
  public int JON;
  private int JOO;
  private int JOP;
  private float JOQ;
  private float JOR;
  public int JOS;
  public String JOT;
  public int JOU;
  ViewOutlineProvider JOV;
  private int JOW;
  private a JOX;
  public boolean JzI;
  private final String TAG;
  public Context mContext;
  
  public TwistRoateCardsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(222296);
    this.TAG = "TwistRoateCardsView";
    this.JOL = 0;
    this.JOM = 0;
    this.JOQ = 0.0F;
    this.JOR = 1.0F;
    this.JzI = false;
    this.JOV = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(205606);
        paramAnonymousOutline.setRoundRect(0, 0, TwistRoateCardsView.a(TwistRoateCardsView.this), TwistRoateCardsView.b(TwistRoateCardsView.this), TwistRoateCardsView.c(TwistRoateCardsView.this));
        AppMethodBeat.o(205606);
      }
    };
    this.JOW = 0;
    this.mContext = paramContext;
    this.JOO = a.fromDPToPix(this.mContext, 14);
    this.JOP = a.fromDPToPix(this.mContext, 8);
    AppMethodBeat.o(222296);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(222317);
    paramCanvas.save();
    paramCanvas.rotate(this.JOQ, this.JOL, this.JOM);
    paramCanvas.scale(this.JOR, this.JOR, this.JOL, this.JOM);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(222317);
  }
  
  public final void fMK()
  {
    AppMethodBeat.i(222304);
    int i = 0;
    while (i < 12)
    {
      ImageView localImageView = new ImageView(this.mContext);
      Object localObject = new FrameLayout.LayoutParams(this.JNB, this.JNC);
      ((FrameLayout.LayoutParams)localObject).setMargins(this.JOO, this.JOO, this.JOO, this.JOO);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localImageView.setClipToOutline(true);
      localImageView.setOutlineProvider(this.JOV);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setBackgroundColor(this.JOU);
      c.l(this.JOT, localImageView);
      localObject = new FrameLayout(this.mContext);
      ((FrameLayout)localObject).addView(localImageView);
      ((FrameLayout)localObject).setBackgroundResource(i.e.sns_ad_twist_card_bg);
      ((FrameLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(this.JNB + this.JOO * 2, this.JNC + this.JOO * 2));
      addView((View)localObject);
      i += 1;
    }
    AppMethodBeat.o(222304);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(222312);
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      this.JOL = (getWidth() / 2);
      this.JOM = (getHeight() + a.fromDPToPix(this.mContext, 40));
      if (getChildCount() == 12)
      {
        paramInt1 = 0;
        if (paramInt1 < 12)
        {
          View localView = getChildAt(paramInt1);
          double d1;
          double d2;
          if (this.JzI)
          {
            d1 = 0.5235987755982988D * paramInt1;
            paramInt3 = (int)(this.JON * Math.cos(d1));
            d2 = this.JON;
            paramInt2 = (int)(Math.sin(d1) * d2);
            localView.setRotation(90 - paramInt1 * 360 / 12);
          }
          for (;;)
          {
            paramInt3 += this.JOL;
            paramInt2 = this.JOM - paramInt2;
            paramInt4 = this.JNB + this.JOO * 2;
            int i = this.JNC + this.JOO * 2;
            localView.layout(paramInt3 - paramInt4 / 2, paramInt2 - i / 2, paramInt3 + paramInt4 / 2, paramInt2 + i / 2);
            paramInt1 += 1;
            break;
            d1 = 0.5235987755982988D * -paramInt1;
            paramInt3 = (int)(this.JON * Math.cos(d1));
            d2 = this.JON;
            paramInt2 = (int)(Math.sin(d1) * d2);
            localView.setRotation(paramInt1 * 360 / 12 + 90);
          }
        }
      }
    }
    AppMethodBeat.o(222312);
  }
  
  public void setAnimCardView(View paramView)
  {
    this.JNF = paramView;
  }
  
  public void setOnCardAnimListener(a parama)
  {
    this.JOX = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fKF();
    
    public abstract void fKG();
    
    public abstract void fKH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView
 * JD-Core Version:    0.7.0.1
 */