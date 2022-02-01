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
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements h
{
  protected boolean dLB;
  private PInt mDA;
  private int mDC;
  private int mDD;
  private int mDE;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134014);
    this.mDA = new PInt();
    this.dLB = false;
    this.mDC = -1;
    this.mDD = -1;
    this.mDE = -1;
    AppMethodBeat.o(134014);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134015);
    this.mDA = new PInt();
    this.dLB = false;
    this.mDC = -1;
    this.mDD = -1;
    this.mDE = -1;
    AppMethodBeat.o(134015);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134016);
    this.mDA = new PInt();
    this.dLB = false;
    this.mDC = -1;
    this.mDD = -1;
    this.mDE = -1;
    AppMethodBeat.o(134016);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(134019);
    if (this.mDD == -1) {
      this.mDD = this.mCO.getPaddingLeft();
    }
    int i = this.mDD;
    AppMethodBeat.o(134019);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(134020);
    if (this.mDE == -1) {
      this.mDE = this.mCO.getPaddingRight();
    }
    int i = this.mDE;
    AppMethodBeat.o(134020);
    return i;
  }
  
  public void bKO()
  {
    AppMethodBeat.i(134024);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.mCO == null)
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
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = en(this.mPosition, i);
    this.mCO.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.mCS * i));
    this.mCM.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(134024);
  }
  
  public final boolean cEF()
  {
    return this.dLB;
  }
  
  protected final int en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134021);
    if (paramInt1 <= 0)
    {
      this.mCN.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(134021);
      return paramInt1;
      if (paramInt1 >= this.mCS) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.mCS * paramInt2);
      }
    }
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(134018);
    if (this.mDC == -1) {
      this.mDC = this.mCO.getWidth();
    }
    int i = this.mDC;
    AppMethodBeat.o(134018);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496802;
  }
  
  public ImageView getPlayBtn()
  {
    return this.mCP;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.mCQ;
  }
  
  public void hP(boolean paramBoolean)
  {
    AppMethodBeat.i(134028);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134028);
  }
  
  public void init()
  {
    AppMethodBeat.i(134017);
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
        AppMethodBeat.i(134013);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this);
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          if (VideoPlayerSeekBar.b(VideoPlayerSeekBar.this) != null) {
            VideoPlayerSeekBar.c(VideoPlayerSeekBar.this).aJq();
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
            VideoPlayerSeekBar.k(VideoPlayerSeekBar.this);
          }
          else
          {
            i = VideoPlayerSeekBar.l(VideoPlayerSeekBar.this);
            if (VideoPlayerSeekBar.m(VideoPlayerSeekBar.this)) {
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, VideoPlayerSeekBar.f(VideoPlayerSeekBar.this).value);
            }
            if (VideoPlayerSeekBar.n(VideoPlayerSeekBar.this) != null)
            {
              Log.i("MicroMsg.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.o(VideoPlayerSeekBar.this).rk(i);
            }
            VideoPlayerSeekBar.p(VideoPlayerSeekBar.this);
          }
        }
      }
    });
    AppMethodBeat.o(134017);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(134022);
    Log.d("MicroMsg.VideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.mCS) {
      paramInt = this.mCS;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bKO();
    }
    AppMethodBeat.o(134022);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134026);
    this.dLB = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(134026);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134025);
    if (this.mCP != null) {
      this.mCP.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134025);
  }
  
  public void setPlayTimeText(int paramInt)
  {
    AppMethodBeat.i(208752);
    this.mCQ.setText(xt(paramInt / 60) + ":" + xt(paramInt % 60));
    AppMethodBeat.o(208752);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(134023);
    this.mCS = paramInt;
    this.mPosition = 0;
    this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
    bKO();
    AppMethodBeat.o(134023);
  }
  
  public final void xv(int paramInt)
  {
    AppMethodBeat.i(134027);
    seek(paramInt);
    AppMethodBeat.o(134027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */