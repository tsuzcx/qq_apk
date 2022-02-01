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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements h
{
  protected boolean dtk;
  private PInt lse;
  private int lsg;
  private int lsh;
  private int lsi;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134014);
    this.lse = new PInt();
    this.dtk = false;
    this.lsg = -1;
    this.lsh = -1;
    this.lsi = -1;
    AppMethodBeat.o(134014);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134015);
    this.lse = new PInt();
    this.dtk = false;
    this.lsg = -1;
    this.lsh = -1;
    this.lsi = -1;
    AppMethodBeat.o(134015);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134016);
    this.lse = new PInt();
    this.dtk = false;
    this.lsg = -1;
    this.lsh = -1;
    this.lsi = -1;
    AppMethodBeat.o(134016);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(134019);
    if (this.lsh == -1) {
      this.lsh = this.lrt.getPaddingLeft();
    }
    int i = this.lsh;
    AppMethodBeat.o(134019);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(134020);
    if (this.lsi == -1) {
      this.lsi = this.lrt.getPaddingRight();
    }
    int i = this.lsi;
    AppMethodBeat.o(134020);
    return i;
  }
  
  public void boy()
  {
    AppMethodBeat.i(134024);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrt.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = ea(this.mPosition, i);
    this.lrt.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lrx * i));
    this.lrr.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(134024);
  }
  
  public final boolean cfC()
  {
    return this.dtk;
  }
  
  protected final int ea(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134021);
    if (paramInt1 <= 0)
    {
      this.lrs.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(134021);
      return paramInt1;
      if (paramInt1 >= this.lrx) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.lrx * paramInt2);
      }
    }
  }
  
  public void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(134028);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134028);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(134018);
    if (this.lsg == -1) {
      this.lsg = this.lrt.getWidth();
    }
    int i = this.lsg;
    AppMethodBeat.o(134018);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495834;
  }
  
  public ImageView getPlayBtn()
  {
    return this.lru;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.lrv;
  }
  
  public void init()
  {
    AppMethodBeat.i(134017);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.lrr = ((ImageView)this.contentView.findViewById(2131303302));
    this.lrs = ((ImageView)this.contentView.findViewById(2131303301));
    this.lrt = ((ImageView)this.contentView.findViewById(2131303305));
    this.lru = ((ImageView)this.contentView.findViewById(2131303281));
    this.lrv = ((TextView)this.contentView.findViewById(2131303283));
    this.lrw = ((TextView)this.contentView.findViewById(2131303289));
    this.lrt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(134013);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this);
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          if (VideoPlayerSeekBar.b(VideoPlayerSeekBar.this) != null) {
            VideoPlayerSeekBar.c(VideoPlayerSeekBar.this).aqD();
          }
        }
        for (;;)
        {
          a.a(true, this, "com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
            VideoPlayerSeekBar.k(VideoPlayerSeekBar.this).setText(VideoPlayerSeekBar.tr(j / 60) + ":" + VideoPlayerSeekBar.tr(j % 60));
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
              VideoPlayerSeekBar.p(VideoPlayerSeekBar.this).nM(i);
            }
            VideoPlayerSeekBar.q(VideoPlayerSeekBar.this);
          }
        }
      }
    });
    AppMethodBeat.o(134017);
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
    if (i >= this.lrx) {
      paramInt = this.lrx;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      boy();
    }
    AppMethodBeat.o(134022);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134026);
    this.dtk = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(134026);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134025);
    if (this.lru != null) {
      this.lru.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134025);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(134023);
    this.lrx = paramInt;
    this.mPosition = 0;
    this.lrw.setText(tr(this.lrx / 60) + ":" + tr(this.lrx % 60));
    boy();
    AppMethodBeat.o(134023);
  }
  
  public final void tt(int paramInt)
  {
    AppMethodBeat.i(134027);
    seek(paramInt);
    AppMethodBeat.o(134027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */