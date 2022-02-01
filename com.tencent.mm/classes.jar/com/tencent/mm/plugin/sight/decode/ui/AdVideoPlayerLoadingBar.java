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
import com.tencent.mm.plugin.ag.a.b;
import com.tencent.mm.plugin.ag.a.c;
import com.tencent.mm.plugin.ag.a.d;
import com.tencent.mm.sdk.platformtools.Log;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  public b PGw;
  protected View contentView;
  public int cqW;
  public int mPosition;
  public ImageView sHm;
  public ImageView sHn;
  public ImageView sHo;
  protected ImageView sHp;
  public TextView sHq;
  protected TextView sHr;
  private int sHs;
  private int sHt;
  public float sHu;
  private int sHv;
  private int sHw;
  private int sHx;
  private int sHy;
  public boolean seH;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133963);
    this.PGw = null;
    this.contentView = null;
    this.sHn = null;
    this.sHo = null;
    this.sHp = null;
    this.cqW = 0;
    this.mPosition = 0;
    this.sHs = 0;
    this.sHt = 0;
    this.seH = false;
    this.sHu = 0.0F;
    this.sHv = -1;
    this.sHw = -1;
    this.sHx = -1;
    this.sHy = -1;
    init();
    AppMethodBeat.o(133963);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133964);
    this.PGw = null;
    this.contentView = null;
    this.sHn = null;
    this.sHo = null;
    this.sHp = null;
    this.cqW = 0;
    this.mPosition = 0;
    this.sHs = 0;
    this.sHt = 0;
    this.seH = false;
    this.sHu = 0.0F;
    this.sHv = -1;
    this.sHw = -1;
    this.sHx = -1;
    this.sHy = -1;
    init();
    AppMethodBeat.o(133964);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133965);
    this.PGw = null;
    this.contentView = null;
    this.sHn = null;
    this.sHo = null;
    this.sHp = null;
    this.cqW = 0;
    this.mPosition = 0;
    this.sHs = 0;
    this.sHt = 0;
    this.seH = false;
    this.sHu = 0.0F;
    this.sHv = -1;
    this.sHw = -1;
    this.sHx = -1;
    this.sHy = -1;
    init();
    AppMethodBeat.o(133965);
  }
  
  public static String Bf(int paramInt)
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
  
  public final void cxa()
  {
    AppMethodBeat.i(133973);
    this.sHr.setText(Bf(this.cqW / 60) + ":" + Bf(this.cqW % 60));
    cxb();
    AppMethodBeat.o(133973);
  }
  
  public void cxb()
  {
    AppMethodBeat.i(133976);
    if (this.cqW == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.seH)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.sHo == null)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    int i = (getBarPointWidth() - this.sHo.getPaddingLeft() - this.sHo.getPaddingRight()) / 2;
    this.sHq.setText(Bf(this.mPosition / 60) + ":" + Bf(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.sHn.getLayoutParams()).leftMargin;
    int k = this.sHo.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHo.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.cqW * getBarLen()) - i);
    this.sHo.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.sHm.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.cqW * getBarLen()));
    this.sHm.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133976);
  }
  
  public final void gYF()
  {
    this.sHs = 0;
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(133974);
    if (this.sHs <= 0) {
      this.sHs = this.sHn.getWidth();
    }
    int i = this.sHs;
    AppMethodBeat.o(133974);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(133975);
    if (this.sHt <= 0) {
      this.sHt = this.sHo.getWidth();
    }
    int i = this.sHt;
    AppMethodBeat.o(133975);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(133970);
    int i = ((FrameLayout.LayoutParams)this.sHn.getLayoutParams()).leftMargin;
    int j = this.sHo.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.sHo.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.sHo.getPaddingLeft() - this.sHo.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.cqW));
    AppMethodBeat.o(133970);
    return i;
  }
  
  protected int getLayoutId()
  {
    return a.c.video_player_loading_bar;
  }
  
  public int getVideoTotalTime()
  {
    return this.cqW;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(133966);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.sHm = ((ImageView)this.contentView.findViewById(a.b.player_progress_bar_front));
    this.sHn = ((ImageView)this.contentView.findViewById(a.b.player_progress_bar_background));
    this.sHo = ((ImageView)this.contentView.findViewById(a.b.player_progress_point));
    this.sHp = ((ImageView)this.contentView.findViewById(a.b.play_btn));
    this.sHq = ((TextView)this.contentView.findViewById(a.b.play_current_time_tv));
    this.sHr = ((TextView)this.contentView.findViewById(a.b.play_total_time_tv));
    this.sHo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(133960);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.seH = false;
          AdVideoPlayerLoadingBar.this.sHu = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.PGw != null) {
            AdVideoPlayerLoadingBar.this.PGw.blc();
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
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.sHo.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.sHu);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.sHo.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.cqW > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.sHm.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.cqW * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.sHm.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.sHq.setText(AdVideoPlayerLoadingBar.Bf(i / 60) + ":" + AdVideoPlayerLoadingBar.Bf(i % 60));
            AdVideoPlayerLoadingBar.this.seH = true;
          }
          else if (AdVideoPlayerLoadingBar.this.seH)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.PGw != null)
            {
              Log.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.PGw.tS(i);
            }
            AdVideoPlayerLoadingBar.this.seH = false;
          }
        }
      }
    });
    this.sHo.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133961);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.sHo.getPaddingLeft() - AdVideoPlayerLoadingBar.this.sHo.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.sHn.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.sHo.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.sHo.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.sHo.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(133961);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHm.getLayoutParams();
    localLayoutParams.width = 0;
    this.sHm.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133966);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133967);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.sHs = 0;
    if ((paramInt1 != this.sHv) || (paramInt2 != this.sHw) || (paramInt3 != this.sHx) || (paramInt4 != this.sHy)) {
      cxb();
    }
    this.sHv = paramInt1;
    this.sHw = paramInt2;
    this.sHx = paramInt3;
    this.sHy = paramInt4;
    AppMethodBeat.o(133967);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(133971);
    this.mPosition = paramInt;
    cxb();
    AppMethodBeat.o(133971);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.PGw = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(133969);
    if (paramBoolean)
    {
      this.sHp.setImageResource(a.d.media_player_pause_btn);
      AppMethodBeat.o(133969);
      return;
    }
    this.sHp.setImageResource(a.d.media_player_play_btn);
    AppMethodBeat.o(133969);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(133968);
    this.sHp.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(133968);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(133972);
    this.cqW = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133962);
          AdVideoPlayerLoadingBar.this.cxa();
          AppMethodBeat.o(133962);
        }
      });
      AppMethodBeat.o(133972);
      return;
    }
    cxa();
    AppMethodBeat.o(133972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */