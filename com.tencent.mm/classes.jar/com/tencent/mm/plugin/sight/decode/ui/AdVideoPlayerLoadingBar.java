package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
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

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  protected View contentView;
  public boolean jVE;
  public ImageView kte;
  public ImageView ktf;
  public ImageView ktg;
  protected ImageView kth;
  public TextView kti;
  protected TextView ktj;
  public int ktk;
  private int ktl;
  private int ktm;
  public float ktn;
  private int kto;
  private int ktp;
  private int ktq;
  private int ktr;
  public int mPosition;
  public b wso;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133963);
    this.wso = null;
    this.contentView = null;
    this.ktf = null;
    this.ktg = null;
    this.kth = null;
    this.ktk = 0;
    this.mPosition = 0;
    this.ktl = 0;
    this.ktm = 0;
    this.jVE = false;
    this.ktn = 0.0F;
    this.kto = -1;
    this.ktp = -1;
    this.ktq = -1;
    this.ktr = -1;
    init();
    AppMethodBeat.o(133963);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133964);
    this.wso = null;
    this.contentView = null;
    this.ktf = null;
    this.ktg = null;
    this.kth = null;
    this.ktk = 0;
    this.mPosition = 0;
    this.ktl = 0;
    this.ktm = 0;
    this.jVE = false;
    this.ktn = 0.0F;
    this.kto = -1;
    this.ktp = -1;
    this.ktq = -1;
    this.ktr = -1;
    init();
    AppMethodBeat.o(133964);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133965);
    this.wso = null;
    this.contentView = null;
    this.ktf = null;
    this.ktg = null;
    this.kth = null;
    this.ktk = 0;
    this.mPosition = 0;
    this.ktl = 0;
    this.ktm = 0;
    this.jVE = false;
    this.ktn = 0.0F;
    this.kto = -1;
    this.ktp = -1;
    this.ktq = -1;
    this.ktr = -1;
    init();
    AppMethodBeat.o(133965);
  }
  
  public static String rX(int paramInt)
  {
    AppMethodBeat.i(133977);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(133977);
      return str;
    }
    AppMethodBeat.o(133977);
    return String.valueOf(paramInt);
  }
  
  public final void bdS()
  {
    AppMethodBeat.i(133973);
    this.ktj.setText(rX(this.ktk / 60) + ":" + rX(this.ktk % 60));
    bdT();
    AppMethodBeat.o(133973);
  }
  
  public void bdT()
  {
    AppMethodBeat.i(133976);
    if (this.ktk == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.jVE)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.ktg == null)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    int i = (getBarPointWidth() - this.ktg.getPaddingLeft() - this.ktg.getPaddingRight()) / 2;
    this.kti.setText(rX(this.mPosition / 60) + ":" + rX(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.ktf.getLayoutParams()).leftMargin;
    int k = this.ktg.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktg.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.ktk * getBarLen()) - i);
    this.ktg.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ktk * getBarLen()));
    this.kte.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133976);
  }
  
  public final void dqB()
  {
    this.ktl = 0;
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(133974);
    if (this.ktl <= 0) {
      this.ktl = this.ktf.getWidth();
    }
    int i = this.ktl;
    AppMethodBeat.o(133974);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(133975);
    if (this.ktm <= 0) {
      this.ktm = this.ktg.getWidth();
    }
    int i = this.ktm;
    AppMethodBeat.o(133975);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(133970);
    int i = ((FrameLayout.LayoutParams)this.ktf.getLayoutParams()).leftMargin;
    int j = this.ktg.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.ktg.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.ktg.getPaddingLeft() - this.ktg.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.ktk));
    AppMethodBeat.o(133970);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131495833;
  }
  
  public int getVideoTotalTime()
  {
    return this.ktk;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(133966);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
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
        AppMethodBeat.i(133960);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.jVE = false;
          AdVideoPlayerLoadingBar.this.ktn = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.wso != null) {
            AdVideoPlayerLoadingBar.this.wso.bcv();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(133960);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.ktg.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.ktn);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.ktg.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.ktk > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.kte.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.ktk * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.kte.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.kti.setText(AdVideoPlayerLoadingBar.rX(i / 60) + ":" + AdVideoPlayerLoadingBar.rX(i % 60));
            AdVideoPlayerLoadingBar.this.jVE = true;
          }
          else if (AdVideoPlayerLoadingBar.this.jVE)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.wso != null)
            {
              ad.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.wso.rZ(i);
            }
            AdVideoPlayerLoadingBar.this.jVE = false;
          }
        }
      }
    });
    this.ktg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133961);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.ktg.getPaddingLeft() - AdVideoPlayerLoadingBar.this.ktg.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.ktf.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.ktg.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.ktg.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.ktg.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(133961);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
    localLayoutParams.width = 0;
    this.kte.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133966);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133967);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.ktl = 0;
    if ((paramInt1 != this.kto) || (paramInt2 != this.ktp) || (paramInt3 != this.ktq) || (paramInt4 != this.ktr)) {
      bdT();
    }
    this.kto = paramInt1;
    this.ktp = paramInt2;
    this.ktq = paramInt3;
    this.ktr = paramInt4;
    AppMethodBeat.o(133967);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(133971);
    this.mPosition = paramInt;
    bdT();
    AppMethodBeat.o(133971);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.wso = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(133969);
    if (paramBoolean)
    {
      this.kth.setImageResource(2131690795);
      AppMethodBeat.o(133969);
      return;
    }
    this.kth.setImageResource(2131690796);
    AppMethodBeat.o(133969);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(133968);
    this.kth.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(133968);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(133972);
    this.ktk = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133962);
          AdVideoPlayerLoadingBar.this.bdS();
          AppMethodBeat.o(133962);
        }
      });
      AppMethodBeat.o(133972);
      return;
    }
    bdS();
    AppMethodBeat.o(133972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */