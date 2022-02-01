package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  protected boolean dkr;
  private PInt ktR;
  private int ktS;
  private int ktT;
  private int ktU;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134014);
    this.ktR = new PInt();
    this.dkr = false;
    this.ktS = -1;
    this.ktT = -1;
    this.ktU = -1;
    AppMethodBeat.o(134014);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134015);
    this.ktR = new PInt();
    this.dkr = false;
    this.ktS = -1;
    this.ktT = -1;
    this.ktU = -1;
    AppMethodBeat.o(134015);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134016);
    this.ktR = new PInt();
    this.dkr = false;
    this.ktS = -1;
    this.ktT = -1;
    this.ktU = -1;
    AppMethodBeat.o(134016);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(134019);
    if (this.ktT == -1) {
      this.ktT = this.ktg.getPaddingLeft();
    }
    int i = this.ktT;
    AppMethodBeat.o(134019);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(134020);
    if (this.ktU == -1) {
      this.ktU = this.ktg.getPaddingRight();
    }
    int i = this.ktU;
    AppMethodBeat.o(134020);
    return i;
  }
  
  public final boolean bTK()
  {
    return this.dkr;
  }
  
  public void bdT()
  {
    AppMethodBeat.i(134024);
    if (this.ktk == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.jVE)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.ktg == null)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    this.kti.setText(rX(this.mPosition / 60) + ":" + rX(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktg.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = dX(this.mPosition, i);
    this.ktg.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ktk * i));
    this.kte.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(134024);
  }
  
  protected final int dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134021);
    if (paramInt1 <= 0)
    {
      this.ktf.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(134021);
      return paramInt1;
      if (paramInt1 >= this.ktk) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.ktk * paramInt2);
      }
    }
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(134018);
    if (this.ktS == -1) {
      this.ktS = this.ktg.getWidth();
    }
    int i = this.ktS;
    AppMethodBeat.o(134018);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495834;
  }
  
  public ImageView getPlayBtn()
  {
    return this.kth;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.kti;
  }
  
  public void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(134028);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134028);
  }
  
  public void init()
  {
    AppMethodBeat.i(134017);
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
        AppMethodBeat.i(134013);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this);
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          if (VideoPlayerSeekBar.b(VideoPlayerSeekBar.this) != null) {
            VideoPlayerSeekBar.c(VideoPlayerSeekBar.this).bcv();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134013);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.d(VideoPlayerSeekBar.this).getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.e(VideoPlayerSeekBar.this)) + i, VideoPlayerSeekBar.f(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.g(VideoPlayerSeekBar.this).setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.f(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.h(VideoPlayerSeekBar.this) > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.i(VideoPlayerSeekBar.this).getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.j(VideoPlayerSeekBar.this).setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.k(VideoPlayerSeekBar.this).setText(VideoPlayerSeekBar.rX(j / 60) + ":" + VideoPlayerSeekBar.rX(j % 60));
            VideoPlayerSeekBar.l(VideoPlayerSeekBar.this);
          }
          else
          {
            i = VideoPlayerSeekBar.m(VideoPlayerSeekBar.this);
            if (VideoPlayerSeekBar.n(VideoPlayerSeekBar.this)) {
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, VideoPlayerSeekBar.f(VideoPlayerSeekBar.this).value);
            }
            if (VideoPlayerSeekBar.o(VideoPlayerSeekBar.this) != null)
            {
              ad.i("MicroMsg.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.p(VideoPlayerSeekBar.this).rZ(i);
            }
            VideoPlayerSeekBar.q(VideoPlayerSeekBar.this);
          }
        }
      }
    });
    AppMethodBeat.o(134017);
  }
  
  public final void sa(int paramInt)
  {
    AppMethodBeat.i(134027);
    seek(paramInt);
    AppMethodBeat.o(134027);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(134022);
    ad.d("MicroMsg.VideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.ktk) {
      paramInt = this.ktk;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bdT();
    }
    AppMethodBeat.o(134022);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134026);
    this.dkr = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(134026);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134025);
    if (this.kth != null) {
      this.kth.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134025);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(134023);
    this.ktk = paramInt;
    this.mPosition = 0;
    this.ktj.setText(rX(this.ktk / 60) + ":" + rX(this.ktk % 60));
    bdT();
    AppMethodBeat.o(134023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */