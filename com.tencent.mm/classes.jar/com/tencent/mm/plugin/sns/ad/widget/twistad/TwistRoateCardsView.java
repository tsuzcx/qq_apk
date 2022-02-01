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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.xwalk.core.Log;

public class TwistRoateCardsView
  extends FrameLayout
{
  private float DCA;
  private View DCB;
  public int DCC;
  public String DCD;
  public int DCE;
  ViewOutlineProvider DCF;
  private int DCG;
  private a DCH;
  private int DCs;
  private int DCt;
  public int DCu;
  public int DCv;
  public int DCw;
  private int DCx;
  private int DCy;
  private float DCz;
  public boolean DsW;
  private final String TAG;
  public Context mContext;
  
  public TwistRoateCardsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202543);
    this.TAG = "TwistRoateCardsView";
    this.DCs = 0;
    this.DCt = 0;
    this.DCz = 0.0F;
    this.DCA = 1.0F;
    this.DsW = false;
    this.DCF = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(202536);
        paramAnonymousOutline.setRoundRect(0, 0, TwistRoateCardsView.a(TwistRoateCardsView.this), TwistRoateCardsView.b(TwistRoateCardsView.this), TwistRoateCardsView.c(TwistRoateCardsView.this));
        AppMethodBeat.o(202536);
      }
    };
    this.DCG = 0;
    this.mContext = paramContext;
    this.DCx = a.fromDPToPix(this.mContext, 14);
    this.DCy = a.fromDPToPix(this.mContext, 8);
    AppMethodBeat.o(202543);
  }
  
  private View getCardView$7529eef0()
  {
    AppMethodBeat.i(258595);
    ImageView localImageView = new ImageView(this.mContext);
    Object localObject = new FrameLayout.LayoutParams(this.DCv, this.DCw);
    ((FrameLayout.LayoutParams)localObject).setMargins(this.DCx, this.DCx, this.DCx, this.DCx);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView.setClipToOutline(true);
    localImageView.setOutlineProvider(this.DCF);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setBackgroundColor(this.DCE);
    b.j(this.DCD, localImageView);
    localObject = new FrameLayout(this.mContext);
    ((FrameLayout)localObject).addView(localImageView);
    ((FrameLayout)localObject).setBackgroundResource(2131234954);
    ((FrameLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(this.DCv + this.DCx * 2, this.DCw + this.DCx * 2));
    AppMethodBeat.o(258595);
    return localObject;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(202547);
    paramCanvas.save();
    paramCanvas.rotate(this.DCz, this.DCs, this.DCt);
    paramCanvas.scale(this.DCA, this.DCA, this.DCs, this.DCt);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(202547);
  }
  
  public final void eYS()
  {
    AppMethodBeat.i(202544);
    int i = 0;
    while (i < 12)
    {
      ImageView localImageView = new ImageView(this.mContext);
      Object localObject = new FrameLayout.LayoutParams(this.DCv, this.DCw);
      ((FrameLayout.LayoutParams)localObject).setMargins(this.DCx, this.DCx, this.DCx, this.DCx);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localImageView.setClipToOutline(true);
      localImageView.setOutlineProvider(this.DCF);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setBackgroundColor(this.DCE);
      b.j(this.DCD, localImageView);
      localObject = new FrameLayout(this.mContext);
      ((FrameLayout)localObject).addView(localImageView);
      ((FrameLayout)localObject).setBackgroundResource(2131234954);
      ((FrameLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(this.DCv + this.DCx * 2, this.DCw + this.DCx * 2));
      addView((View)localObject);
      i += 1;
    }
    AppMethodBeat.o(202544);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(202546);
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      this.DCs = (getWidth() / 2);
      this.DCt = (getHeight() + a.fromDPToPix(this.mContext, 40));
      if (getChildCount() == 12)
      {
        paramInt1 = 0;
        if (paramInt1 < 12)
        {
          View localView = getChildAt(paramInt1);
          double d1;
          double d2;
          if (this.DsW)
          {
            d1 = 0.5235987755982988D * paramInt1;
            paramInt3 = (int)(this.DCu * Math.cos(d1));
            d2 = this.DCu;
            paramInt2 = (int)(Math.sin(d1) * d2);
            localView.setRotation(90 - paramInt1 * 360 / 12);
          }
          for (;;)
          {
            paramInt3 += this.DCs;
            paramInt2 = this.DCt - paramInt2;
            paramInt4 = this.DCv + this.DCx * 2;
            int i = this.DCw + this.DCx * 2;
            localView.layout(paramInt3 - paramInt4 / 2, paramInt2 - i / 2, paramInt3 + paramInt4 / 2, paramInt2 + i / 2);
            paramInt1 += 1;
            break;
            d1 = 0.5235987755982988D * -paramInt1;
            paramInt3 = (int)(this.DCu * Math.cos(d1));
            d2 = this.DCu;
            paramInt2 = (int)(Math.sin(d1) * d2);
            localView.setRotation(paramInt1 * 360 / 12 + 90);
          }
        }
      }
    }
    AppMethodBeat.o(202546);
  }
  
  public void setAnimCardView(View paramView)
  {
    this.DCB = paramView;
  }
  
  public void setOnCardAnimListener(a parama)
  {
    this.DCH = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eYT();
    
    public abstract void eYU();
    
    public abstract void eYV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView
 * JD-Core Version:    0.7.0.1
 */