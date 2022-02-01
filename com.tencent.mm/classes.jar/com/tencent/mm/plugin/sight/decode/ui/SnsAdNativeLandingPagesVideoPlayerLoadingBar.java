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
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private b Dnp;
  private View contentView;
  private boolean dLB;
  private ImageView mCM;
  private ImageView mCN;
  private ImageView mCO;
  private ImageView mCP;
  private TextView mCQ;
  private TextView mCR;
  private int mCS;
  private int mCT;
  private float mCV;
  private int mCW;
  private int mCX;
  private int mCY;
  private int mCZ;
  private int mPosition;
  private boolean mbo;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116139);
    this.Dnp = null;
    this.contentView = null;
    this.mCN = null;
    this.mCO = null;
    this.mCP = null;
    this.mCS = 0;
    this.mPosition = 0;
    this.mCT = 0;
    this.mbo = false;
    this.mCV = 0.0F;
    this.dLB = false;
    this.mCW = -1;
    this.mCX = -1;
    this.mCY = -1;
    this.mCZ = -1;
    init();
    AppMethodBeat.o(116139);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116140);
    this.Dnp = null;
    this.contentView = null;
    this.mCN = null;
    this.mCO = null;
    this.mCP = null;
    this.mCS = 0;
    this.mPosition = 0;
    this.mCT = 0;
    this.mbo = false;
    this.mCV = 0.0F;
    this.dLB = false;
    this.mCW = -1;
    this.mCX = -1;
    this.mCY = -1;
    this.mCZ = -1;
    init();
    AppMethodBeat.o(116140);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116141);
    this.Dnp = null;
    this.contentView = null;
    this.mCN = null;
    this.mCO = null;
    this.mCP = null;
    this.mCS = 0;
    this.mPosition = 0;
    this.mCT = 0;
    this.mbo = false;
    this.mCV = 0.0F;
    this.dLB = false;
    this.mCW = -1;
    this.mCX = -1;
    this.mCY = -1;
    this.mCZ = -1;
    init();
    AppMethodBeat.o(116141);
  }
  
  private void bKO()
  {
    AppMethodBeat.i(116150);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.mCO == null)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    int i = (this.mCO.getWidth() - this.mCO.getPaddingLeft() - this.mCO.getPaddingRight()) / 2;
    this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.mCN.getLayoutParams()).leftMargin;
    int k = this.mCO.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.mCS * getBarLen()) - i);
    this.mCO.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.mCS * getBarLen()));
    this.mCM.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(116150);
  }
  
  private int getBarLen()
  {
    AppMethodBeat.i(116149);
    this.mCT = this.mCN.getWidth();
    int i = this.mCT;
    AppMethodBeat.o(116149);
    return i;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(116146);
    int i = ((FrameLayout.LayoutParams)this.mCN.getLayoutParams()).leftMargin;
    int j = this.mCO.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.mCO.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.mCS);
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
    this.contentView = View.inflate(getContext(), 2131496403, this);
    this.mCM = ((ImageView)this.contentView.findViewById(2131305975));
    this.mCN = ((ImageView)this.contentView.findViewById(2131305974));
    this.mCO = ((ImageView)this.contentView.findViewById(2131305978));
    this.mCP = ((ImageView)this.contentView.findViewById(2131305954));
    this.mCQ = ((TextView)this.contentView.findViewById(2131305956));
    this.mCR = ((TextView)this.contentView.findViewById(2131305962));
    this.mCO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(116137);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, paramAnonymousMotionEvent.getX());
          if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null) {
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).aJq();
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
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.xt(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.xt(i % 60));
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, true);
          }
          else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this))
          {
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null)
            {
              Log.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).rk(i);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          }
        }
      }
    });
    AppMethodBeat.o(116142);
  }
  
  public static String xt(int paramInt)
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
  
  public final void eVJ()
  {
    this.mCT = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.dLB;
  }
  
  public int getVideoTotalTime()
  {
    return this.mCS;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116143);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.mCW) || (paramInt2 != this.mCX) || (paramInt3 != this.mCY) || (paramInt4 != this.mCZ)) {
      bKO();
    }
    this.mCW = paramInt1;
    this.mCX = paramInt2;
    this.mCY = paramInt3;
    this.mCZ = paramInt4;
    AppMethodBeat.o(116143);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(116147);
    this.mPosition = paramInt;
    bKO();
    AppMethodBeat.o(116147);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.Dnp = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(116145);
    this.dLB = paramBoolean;
    if (paramBoolean)
    {
      this.mCP.setImageResource(2131691081);
      AppMethodBeat.o(116145);
      return;
    }
    this.mCP.setImageResource(2131691082);
    AppMethodBeat.o(116145);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116144);
    this.mCP.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116144);
  }
  
  public void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(116148);
    if ((this.mCO.isShown()) && (this.mCO.getWidth() == 0))
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
    this.mCS = paramInt;
    this.mPosition = 0;
    this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
    bKO();
    AppMethodBeat.o(116148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */