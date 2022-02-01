package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private View contentView;
  private boolean dkr;
  private boolean jVE;
  private ImageView kte;
  private ImageView ktf;
  private ImageView ktg;
  private ImageView kth;
  private TextView kti;
  private TextView ktj;
  private int ktk;
  private int ktl;
  private float ktn;
  private int kto;
  private int ktp;
  private int ktq;
  private int ktr;
  private int mPosition;
  private b wso;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116139);
    this.wso = null;
    this.contentView = null;
    this.ktf = null;
    this.ktg = null;
    this.kth = null;
    this.ktk = 0;
    this.mPosition = 0;
    this.ktl = 0;
    this.jVE = false;
    this.ktn = 0.0F;
    this.dkr = false;
    this.kto = -1;
    this.ktp = -1;
    this.ktq = -1;
    this.ktr = -1;
    init();
    AppMethodBeat.o(116139);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116140);
    this.wso = null;
    this.contentView = null;
    this.ktf = null;
    this.ktg = null;
    this.kth = null;
    this.ktk = 0;
    this.mPosition = 0;
    this.ktl = 0;
    this.jVE = false;
    this.ktn = 0.0F;
    this.dkr = false;
    this.kto = -1;
    this.ktp = -1;
    this.ktq = -1;
    this.ktr = -1;
    init();
    AppMethodBeat.o(116140);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116141);
    this.wso = null;
    this.contentView = null;
    this.ktf = null;
    this.ktg = null;
    this.kth = null;
    this.ktk = 0;
    this.mPosition = 0;
    this.ktl = 0;
    this.jVE = false;
    this.ktn = 0.0F;
    this.dkr = false;
    this.kto = -1;
    this.ktp = -1;
    this.ktq = -1;
    this.ktr = -1;
    init();
    AppMethodBeat.o(116141);
  }
  
  private void bdT()
  {
    AppMethodBeat.i(116150);
    if (this.ktk == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.jVE)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.ktg == null)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    int i = (this.ktg.getWidth() - this.ktg.getPaddingLeft() - this.ktg.getPaddingRight()) / 2;
    this.kti.setText(rX(this.mPosition / 60) + ":" + rX(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.ktf.getLayoutParams()).leftMargin;
    int k = this.ktg.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktg.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.ktk * getBarLen()) - i);
    this.ktg.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ktk * getBarLen()));
    this.kte.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(116150);
  }
  
  private int getBarLen()
  {
    AppMethodBeat.i(116149);
    this.ktl = this.ktf.getWidth();
    int i = this.ktl;
    AppMethodBeat.o(116149);
    return i;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(116146);
    int i = ((FrameLayout.LayoutParams)this.ktf.getLayoutParams()).leftMargin;
    int j = this.ktg.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.ktg.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.ktk);
    i = j;
    if (j < 0) {
      i = 0;
    }
    AppMethodBeat.o(116146);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(116142);
    this.contentView = View.inflate(getContext(), 2131495517, this);
    this.kte = ((ImageView)this.contentView.findViewById(2131303302));
    this.ktf = ((ImageView)this.contentView.findViewById(2131303301));
    this.ktg = ((ImageView)this.contentView.findViewById(2131303305));
    this.kth = ((ImageView)this.contentView.findViewById(2131303281));
    this.kti = ((TextView)this.contentView.findViewById(2131303283));
    this.ktj = ((TextView)this.contentView.findViewById(2131303289));
    this.ktg.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(116137);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, paramAnonymousMotionEvent.getX());
          if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null) {
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).bcv();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(116137);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - SnsAdNativeLandingPagesVideoPlayerLoadingBar.c(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this));
            paramAnonymousView.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, j + i);
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setLayoutParams(paramAnonymousView);
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) * SnsAdNativeLandingPagesVideoPlayerLoadingBar.g(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setLayoutParams(paramAnonymousView);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.rX(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.rX(i % 60));
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, true);
          }
          else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this))
          {
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null)
            {
              ad.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).rZ(i);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          }
        }
      }
    });
    AppMethodBeat.o(116142);
  }
  
  public static String rX(int paramInt)
  {
    AppMethodBeat.i(116151);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(116151);
      return str;
    }
    AppMethodBeat.o(116151);
    return String.valueOf(paramInt);
  }
  
  public final void dqB()
  {
    this.ktl = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.dkr;
  }
  
  public int getVideoTotalTime()
  {
    return this.ktk;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116143);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.kto) || (paramInt2 != this.ktp) || (paramInt3 != this.ktq) || (paramInt4 != this.ktr)) {
      bdT();
    }
    this.kto = paramInt1;
    this.ktp = paramInt2;
    this.ktq = paramInt3;
    this.ktr = paramInt4;
    AppMethodBeat.o(116143);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(116147);
    this.mPosition = paramInt;
    bdT();
    AppMethodBeat.o(116147);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.wso = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(116145);
    this.dkr = paramBoolean;
    if (paramBoolean)
    {
      this.kth.setImageResource(2131690795);
      AppMethodBeat.o(116145);
      return;
    }
    this.kth.setImageResource(2131690796);
    AppMethodBeat.o(116145);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116144);
    this.kth.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116144);
  }
  
  public void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(116148);
    if ((this.ktg.isShown()) && (this.ktg.getWidth() == 0))
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116138);
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.setVideoTotalTime(paramInt);
          AppMethodBeat.o(116138);
        }
      });
      AppMethodBeat.o(116148);
      return;
    }
    this.ktk = paramInt;
    this.mPosition = 0;
    this.ktj.setText(rX(this.ktk / 60) + ":" + rX(this.ktk % 60));
    bdT();
    AppMethodBeat.o(116148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */