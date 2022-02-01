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
import com.tencent.mm.plugin.af.a.b;
import com.tencent.mm.plugin.af.a.c;
import com.tencent.mm.plugin.af.a.d;
import com.tencent.mm.sdk.platformtools.Log;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  public b JsU;
  protected View contentView;
  public int mPosition;
  public boolean oZf;
  public ImageView pBZ;
  public ImageView pCa;
  public ImageView pCb;
  protected ImageView pCc;
  public TextView pCd;
  protected TextView pCe;
  public int pCf;
  private int pCg;
  private int pCh;
  public float pCi;
  private int pCj;
  private int pCk;
  private int pCl;
  private int pCm;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133963);
    this.JsU = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.pCh = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(133963);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133964);
    this.JsU = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.pCh = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(133964);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133965);
    this.JsU = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.pCh = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(133965);
  }
  
  public static String AQ(int paramInt)
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
  
  public final void bWN()
  {
    AppMethodBeat.i(133973);
    this.pCe.setText(AQ(this.pCf / 60) + ":" + AQ(this.pCf % 60));
    bWO();
    AppMethodBeat.o(133973);
  }
  
  public void bWO()
  {
    AppMethodBeat.i(133976);
    if (this.pCf == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.oZf)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.pCb == null)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    int i = (getBarPointWidth() - this.pCb.getPaddingLeft() - this.pCb.getPaddingRight()) / 2;
    this.pCd.setText(AQ(this.mPosition / 60) + ":" + AQ(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.pCa.getLayoutParams()).leftMargin;
    int k = this.pCb.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCb.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.pCf * getBarLen()) - i);
    this.pCb.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.pCf * getBarLen()));
    this.pBZ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133976);
  }
  
  public final void fIM()
  {
    this.pCg = 0;
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(133974);
    if (this.pCg <= 0) {
      this.pCg = this.pCa.getWidth();
    }
    int i = this.pCg;
    AppMethodBeat.o(133974);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(133975);
    if (this.pCh <= 0) {
      this.pCh = this.pCb.getWidth();
    }
    int i = this.pCh;
    AppMethodBeat.o(133975);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(133970);
    int i = ((FrameLayout.LayoutParams)this.pCa.getLayoutParams()).leftMargin;
    int j = this.pCb.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.pCb.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.pCb.getPaddingLeft() - this.pCb.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.pCf));
    AppMethodBeat.o(133970);
    return i;
  }
  
  protected int getLayoutId()
  {
    return a.c.video_player_loading_bar;
  }
  
  public int getVideoTotalTime()
  {
    return this.pCf;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(133966);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.pBZ = ((ImageView)this.contentView.findViewById(a.b.player_progress_bar_front));
    this.pCa = ((ImageView)this.contentView.findViewById(a.b.player_progress_bar_background));
    this.pCb = ((ImageView)this.contentView.findViewById(a.b.player_progress_point));
    this.pCc = ((ImageView)this.contentView.findViewById(a.b.play_btn));
    this.pCd = ((TextView)this.contentView.findViewById(a.b.play_current_time_tv));
    this.pCe = ((TextView)this.contentView.findViewById(a.b.play_total_time_tv));
    this.pCb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(133960);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.oZf = false;
          AdVideoPlayerLoadingBar.this.pCi = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.JsU != null) {
            AdVideoPlayerLoadingBar.this.JsU.aRo();
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
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pCb.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.pCi);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.pCb.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.pCf > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pBZ.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.pCf * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.pBZ.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.pCd.setText(AdVideoPlayerLoadingBar.AQ(i / 60) + ":" + AdVideoPlayerLoadingBar.AQ(i % 60));
            AdVideoPlayerLoadingBar.this.oZf = true;
          }
          else if (AdVideoPlayerLoadingBar.this.oZf)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.JsU != null)
            {
              Log.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.JsU.tY(i);
            }
            AdVideoPlayerLoadingBar.this.oZf = false;
          }
        }
      }
    });
    this.pCb.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133961);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.pCb.getPaddingLeft() - AdVideoPlayerLoadingBar.this.pCb.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pCa.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.pCb.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pCb.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.pCb.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(133961);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = 0;
    this.pBZ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133966);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133967);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pCg = 0;
    if ((paramInt1 != this.pCj) || (paramInt2 != this.pCk) || (paramInt3 != this.pCl) || (paramInt4 != this.pCm)) {
      bWO();
    }
    this.pCj = paramInt1;
    this.pCk = paramInt2;
    this.pCl = paramInt3;
    this.pCm = paramInt4;
    AppMethodBeat.o(133967);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(133971);
    this.mPosition = paramInt;
    bWO();
    AppMethodBeat.o(133971);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.JsU = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(133969);
    if (paramBoolean)
    {
      this.pCc.setImageResource(a.d.media_player_pause_btn);
      AppMethodBeat.o(133969);
      return;
    }
    this.pCc.setImageResource(a.d.media_player_play_btn);
    AppMethodBeat.o(133969);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(133968);
    this.pCc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(133968);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(133972);
    this.pCf = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133962);
          AdVideoPlayerLoadingBar.this.bWN();
          AppMethodBeat.o(133962);
        }
      });
      AppMethodBeat.o(133972);
      return;
    }
    bWN();
    AppMethodBeat.o(133972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */