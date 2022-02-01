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
import com.tencent.mm.sdk.platformtools.Log;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  public b Dnp;
  protected View contentView;
  public ImageView mCM;
  public ImageView mCN;
  public ImageView mCO;
  protected ImageView mCP;
  public TextView mCQ;
  protected TextView mCR;
  public int mCS;
  private int mCT;
  private int mCU;
  public float mCV;
  private int mCW;
  private int mCX;
  private int mCY;
  private int mCZ;
  public int mPosition;
  public boolean mbo;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133963);
    this.Dnp = null;
    this.contentView = null;
    this.mCN = null;
    this.mCO = null;
    this.mCP = null;
    this.mCS = 0;
    this.mPosition = 0;
    this.mCT = 0;
    this.mCU = 0;
    this.mbo = false;
    this.mCV = 0.0F;
    this.mCW = -1;
    this.mCX = -1;
    this.mCY = -1;
    this.mCZ = -1;
    init();
    AppMethodBeat.o(133963);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133964);
    this.Dnp = null;
    this.contentView = null;
    this.mCN = null;
    this.mCO = null;
    this.mCP = null;
    this.mCS = 0;
    this.mPosition = 0;
    this.mCT = 0;
    this.mCU = 0;
    this.mbo = false;
    this.mCV = 0.0F;
    this.mCW = -1;
    this.mCX = -1;
    this.mCY = -1;
    this.mCZ = -1;
    init();
    AppMethodBeat.o(133964);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133965);
    this.Dnp = null;
    this.contentView = null;
    this.mCN = null;
    this.mCO = null;
    this.mCP = null;
    this.mCS = 0;
    this.mPosition = 0;
    this.mCT = 0;
    this.mCU = 0;
    this.mbo = false;
    this.mCV = 0.0F;
    this.mCW = -1;
    this.mCX = -1;
    this.mCY = -1;
    this.mCZ = -1;
    init();
    AppMethodBeat.o(133965);
  }
  
  public static String xt(int paramInt)
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
  
  public final void bKN()
  {
    AppMethodBeat.i(133973);
    this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
    bKO();
    AppMethodBeat.o(133973);
  }
  
  public void bKO()
  {
    AppMethodBeat.i(133976);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.mCO == null)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    int i = (getBarPointWidth() - this.mCO.getPaddingLeft() - this.mCO.getPaddingRight()) / 2;
    this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.mCN.getLayoutParams()).leftMargin;
    int k = this.mCO.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.mCS * getBarLen()) - i);
    this.mCO.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.mCS * getBarLen()));
    this.mCM.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133976);
  }
  
  public final void eVJ()
  {
    this.mCT = 0;
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(133974);
    if (this.mCT <= 0) {
      this.mCT = this.mCN.getWidth();
    }
    int i = this.mCT;
    AppMethodBeat.o(133974);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(133975);
    if (this.mCU <= 0) {
      this.mCU = this.mCO.getWidth();
    }
    int i = this.mCU;
    AppMethodBeat.o(133975);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(133970);
    int i = ((FrameLayout.LayoutParams)this.mCN.getLayoutParams()).leftMargin;
    int j = this.mCO.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.mCO.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.mCO.getPaddingLeft() - this.mCO.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.mCS));
    AppMethodBeat.o(133970);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131496801;
  }
  
  public int getVideoTotalTime()
  {
    return this.mCS;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(133966);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
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
        AppMethodBeat.i(133960);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.mbo = false;
          AdVideoPlayerLoadingBar.this.mCV = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.Dnp != null) {
            AdVideoPlayerLoadingBar.this.Dnp.aJq();
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
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.mCO.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.mCV);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.mCO.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.mCS > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.mCM.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.mCS * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.mCM.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.mCQ.setText(AdVideoPlayerLoadingBar.xt(i / 60) + ":" + AdVideoPlayerLoadingBar.xt(i % 60));
            AdVideoPlayerLoadingBar.this.mbo = true;
          }
          else if (AdVideoPlayerLoadingBar.this.mbo)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.Dnp != null)
            {
              Log.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.Dnp.rk(i);
            }
            AdVideoPlayerLoadingBar.this.mbo = false;
          }
        }
      }
    });
    this.mCO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133961);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.mCO.getPaddingLeft() - AdVideoPlayerLoadingBar.this.mCO.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.mCN.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.mCO.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.mCO.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.mCO.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(133961);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
    localLayoutParams.width = 0;
    this.mCM.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133966);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133967);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCT = 0;
    if ((paramInt1 != this.mCW) || (paramInt2 != this.mCX) || (paramInt3 != this.mCY) || (paramInt4 != this.mCZ)) {
      bKO();
    }
    this.mCW = paramInt1;
    this.mCX = paramInt2;
    this.mCY = paramInt3;
    this.mCZ = paramInt4;
    AppMethodBeat.o(133967);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(133971);
    this.mPosition = paramInt;
    bKO();
    AppMethodBeat.o(133971);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.Dnp = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(133969);
    if (paramBoolean)
    {
      this.mCP.setImageResource(2131691081);
      AppMethodBeat.o(133969);
      return;
    }
    this.mCP.setImageResource(2131691082);
    AppMethodBeat.o(133969);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(133968);
    this.mCP.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(133968);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(133972);
    this.mCS = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133962);
          AdVideoPlayerLoadingBar.this.bKN();
          AppMethodBeat.o(133962);
        }
      });
      AppMethodBeat.o(133972);
      return;
    }
    bKN();
    AppMethodBeat.o(133972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */