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
import com.tencent.mm.plugin.ag.a.b;
import com.tencent.mm.plugin.ag.a.c;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements h
{
  protected boolean hJg;
  private PInt sHY;
  private int sHZ;
  private int sIa;
  private int sIb;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134014);
    this.sHY = new PInt();
    this.hJg = false;
    this.sHZ = -1;
    this.sIa = -1;
    this.sIb = -1;
    AppMethodBeat.o(134014);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134015);
    this.sHY = new PInt();
    this.hJg = false;
    this.sHZ = -1;
    this.sIa = -1;
    this.sIb = -1;
    AppMethodBeat.o(134015);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134016);
    this.sHY = new PInt();
    this.hJg = false;
    this.sHZ = -1;
    this.sIa = -1;
    this.sIb = -1;
    AppMethodBeat.o(134016);
  }
  
  private int fF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134021);
    if (paramInt1 <= 0)
    {
      this.sHn.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(134021);
      return paramInt1;
      if (paramInt1 >= this.cqW) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.cqW * paramInt2);
      }
    }
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(134019);
    if (this.sIa == -1) {
      this.sIa = this.sHo.getPaddingLeft();
    }
    int i = this.sIa;
    AppMethodBeat.o(134019);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(134020);
    if (this.sIb == -1) {
      this.sIb = this.sHo.getPaddingRight();
    }
    int i = this.sIb;
    AppMethodBeat.o(134020);
    return i;
  }
  
  public final void Bh(int paramInt)
  {
    AppMethodBeat.i(134027);
    seek(paramInt);
    AppMethodBeat.o(134027);
  }
  
  public final void cxb()
  {
    AppMethodBeat.i(134024);
    if (this.cqW == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.seH)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.sHo == null)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    setPlayTimeText(this.mPosition);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHo.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = fF(this.mPosition, i);
    this.sHo.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.sHm.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.cqW * i));
    this.sHm.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(134024);
  }
  
  public final boolean dxE()
  {
    return this.hJg;
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(134018);
    if (this.sHZ == -1) {
      this.sHZ = this.sHo.getWidth();
    }
    int i = this.sHZ;
    AppMethodBeat.o(134018);
    return i;
  }
  
  public int getLayoutId()
  {
    return a.c.video_player_seek_bar;
  }
  
  public ImageView getPlayBtn()
  {
    return this.sHp;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.sHq;
  }
  
  public void init()
  {
    AppMethodBeat.i(134017);
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
        AppMethodBeat.i(134013);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this);
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          if (VideoPlayerSeekBar.b(VideoPlayerSeekBar.this) != null) {
            VideoPlayerSeekBar.c(VideoPlayerSeekBar.this).blc();
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
            VideoPlayerSeekBar.this.setPlayTimeText(j);
            if (VideoPlayerSeekBar.k(VideoPlayerSeekBar.this) != null) {
              VideoPlayerSeekBar.l(VideoPlayerSeekBar.this).tT(j);
            }
            VideoPlayerSeekBar.m(VideoPlayerSeekBar.this);
          }
          else
          {
            i = VideoPlayerSeekBar.n(VideoPlayerSeekBar.this);
            if (VideoPlayerSeekBar.o(VideoPlayerSeekBar.this)) {
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, VideoPlayerSeekBar.f(VideoPlayerSeekBar.this).value);
            }
            if (VideoPlayerSeekBar.p(VideoPlayerSeekBar.this) != null)
            {
              Log.i("MicroMsg.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.q(VideoPlayerSeekBar.this).tS(i);
            }
            VideoPlayerSeekBar.r(VideoPlayerSeekBar.this);
          }
        }
      }
    });
    AppMethodBeat.o(134017);
  }
  
  public void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(134028);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134028);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(134022);
    Log.d("MicroMsg.VideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.cqW) {
      paramInt = this.cqW;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      cxb();
    }
    AppMethodBeat.o(134022);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134026);
    this.hJg = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(134026);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134025);
    if (this.sHp != null) {
      this.sHp.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134025);
  }
  
  public void setPlayTimeText(int paramInt)
  {
    AppMethodBeat.i(245818);
    this.sHq.setText(Bf(paramInt / 60) + ":" + Bf(paramInt % 60));
    AppMethodBeat.o(245818);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(134023);
    this.cqW = paramInt;
    this.mPosition = 0;
    this.sHr.setText(Bf(this.cqW / 60) + ":" + Bf(this.cqW % 60));
    cxb();
    AppMethodBeat.o(134023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */