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
import com.tencent.mm.sdk.platformtools.ac;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  protected boolean dhM;
  private PInt kVg;
  private int kVh;
  private int kVi;
  private int kVj;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134014);
    this.kVg = new PInt();
    this.dhM = false;
    this.kVh = -1;
    this.kVi = -1;
    this.kVj = -1;
    AppMethodBeat.o(134014);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134015);
    this.kVg = new PInt();
    this.dhM = false;
    this.kVh = -1;
    this.kVi = -1;
    this.kVj = -1;
    AppMethodBeat.o(134015);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134016);
    this.kVg = new PInt();
    this.dhM = false;
    this.kVh = -1;
    this.kVi = -1;
    this.kVj = -1;
    AppMethodBeat.o(134016);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(134019);
    if (this.kVi == -1) {
      this.kVi = this.kUv.getPaddingLeft();
    }
    int i = this.kVi;
    AppMethodBeat.o(134019);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(134020);
    if (this.kVj == -1) {
      this.kVj = this.kUv.getPaddingRight();
    }
    int i = this.kVj;
    AppMethodBeat.o(134020);
    return i;
  }
  
  public void bkN()
  {
    AppMethodBeat.i(134024);
    if (this.kUz == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.kwq)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (this.kUv == null)
    {
      AppMethodBeat.o(134024);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(134024);
      return;
    }
    this.kUx.setText(sO(this.mPosition / 60) + ":" + sO(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUv.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = dY(this.mPosition, i);
    this.kUv.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kUt.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.kUz * i));
    this.kUt.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(134024);
  }
  
  public final boolean caY()
  {
    return this.dhM;
  }
  
  protected final int dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134021);
    if (paramInt1 <= 0)
    {
      this.kUu.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(134021);
      return paramInt1;
      if (paramInt1 >= this.kUz) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.kUz * paramInt2);
      }
    }
  }
  
  public void gL(boolean paramBoolean)
  {
    AppMethodBeat.i(134028);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134028);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(134018);
    if (this.kVh == -1) {
      this.kVh = this.kUv.getWidth();
    }
    int i = this.kVh;
    AppMethodBeat.o(134018);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495834;
  }
  
  public ImageView getPlayBtn()
  {
    return this.kUw;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.kUx;
  }
  
  public void init()
  {
    AppMethodBeat.i(134017);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.kUt = ((ImageView)this.contentView.findViewById(2131303302));
    this.kUu = ((ImageView)this.contentView.findViewById(2131303301));
    this.kUv = ((ImageView)this.contentView.findViewById(2131303305));
    this.kUw = ((ImageView)this.contentView.findViewById(2131303281));
    this.kUx = ((TextView)this.contentView.findViewById(2131303283));
    this.kUy = ((TextView)this.contentView.findViewById(2131303289));
    this.kUv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(134013);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ac.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this);
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          if (VideoPlayerSeekBar.b(VideoPlayerSeekBar.this) != null) {
            VideoPlayerSeekBar.c(VideoPlayerSeekBar.this).anR();
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
            VideoPlayerSeekBar.k(VideoPlayerSeekBar.this).setText(VideoPlayerSeekBar.sO(j / 60) + ":" + VideoPlayerSeekBar.sO(j % 60));
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
              ac.i("MicroMsg.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.p(VideoPlayerSeekBar.this).nn(i);
            }
            VideoPlayerSeekBar.q(VideoPlayerSeekBar.this);
          }
        }
      }
    });
    AppMethodBeat.o(134017);
  }
  
  public final void sQ(int paramInt)
  {
    AppMethodBeat.i(134027);
    seek(paramInt);
    AppMethodBeat.o(134027);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(134022);
    ac.d("MicroMsg.VideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.kUz) {
      paramInt = this.kUz;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bkN();
    }
    AppMethodBeat.o(134022);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134026);
    this.dhM = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(134026);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(134025);
    if (this.kUw != null) {
      this.kUw.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(134025);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(134023);
    this.kUz = paramInt;
    this.mPosition = 0;
    this.kUy.setText(sO(this.kUz / 60) + ":" + sO(this.kUz % 60));
    bkN();
    AppMethodBeat.o(134023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */