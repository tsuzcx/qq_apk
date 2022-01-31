package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.platformtools.y;

public class WebSearchVideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  protected boolean bNU = false;
  private float fSy;
  private int qWg = -1;
  private int qWh = -1;
  private int qWi = -1;
  
  public WebSearchVideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebSearchVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebSearchVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getBarPointPaddingLeft()
  {
    if (this.qWh == -1) {
      this.qWh = this.ofq.getPaddingLeft();
    }
    return this.qWh;
  }
  
  private int getBarPointPaddingRight()
  {
    if (this.qWi == -1) {
      this.qWi = this.ofq.getPaddingRight();
    }
    return this.qWi;
  }
  
  private int getCurProgressBarLen()
  {
    return this.ofo.getWidth();
  }
  
  private int getCurTimeByProgressBar()
  {
    return (int)(getCurProgressBarLen() * 1.0D / getBarLen() * this.ofu);
  }
  
  public final int BH(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    if (paramInt >= this.ofu) {
      return getBarLen();
    }
    return (int)(paramInt * 1.0D / this.ofu * getBarLen());
  }
  
  public final void BI(int paramInt)
  {
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt > getBarLen())
    {
      i = getBarLen();
      localLayoutParams = (FrameLayout.LayoutParams)this.ofq.getLayoutParams();
      if (i <= getBarLen()) {
        break label121;
      }
    }
    label121:
    for (paramInt = getBarLen();; paramInt = i)
    {
      localLayoutParams.leftMargin = (((FrameLayout.LayoutParams)this.ofp.getLayoutParams()).leftMargin + paramInt - (getBarPointWidth() >>> 1));
      this.ofq.setLayoutParams(localLayoutParams);
      localLayoutParams = (FrameLayout.LayoutParams)this.ofo.getLayoutParams();
      localLayoutParams.width = i;
      this.ofo.setLayoutParams(localLayoutParams);
      this.ofq.requestLayout();
      this.ofo.requestLayout();
      return;
      i = paramInt;
      if (paramInt >= 0) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  public void akP()
  {
    if (this.ofu == 0) {}
    while ((this.guU) || (this.ofq == null) || (getBarLen() == 0)) {
      return;
    }
    if (this.mPosition == this.ofu) {
      y.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
    }
    this.ofs.setText(lC(this.mPosition / 60) + ":" + lC(this.mPosition % 60));
    BI(BH(this.mPosition));
  }
  
  protected int getBarLen()
  {
    return this.ofp.getWidth();
  }
  
  public int getBarPointWidth()
  {
    if (this.qWg == -1) {
      this.qWg = this.ofq.getWidth();
    }
    return this.qWg;
  }
  
  public int getLayoutId()
  {
    return a.d.video_player_seek_bar;
  }
  
  public ImageView getPlayBtn()
  {
    return this.ofr;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.ofs;
  }
  
  public void init()
  {
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.ofo = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_front));
    this.ofp = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_background));
    this.ofq = ((ImageView)this.contentView.findViewById(a.c.player_progress_point));
    this.ofr = ((ImageView)this.contentView.findViewById(a.c.play_btn));
    this.ofs = ((TextView)this.contentView.findViewById(a.c.play_current_time_tv));
    this.oft = ((TextView)this.contentView.findViewById(a.c.play_total_time_tv));
    this.ofq.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          y.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this);
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this, ((FrameLayout.LayoutParams)WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this).getLayoutParams()).leftMargin);
          if (WebSearchVideoPlayerSeekBar.c(WebSearchVideoPlayerSeekBar.this) != null) {
            WebSearchVideoPlayerSeekBar.d(WebSearchVideoPlayerSeekBar.this).akz();
          }
          return true;
        }
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          float f1 = paramAnonymousMotionEvent.getX();
          y.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", new Object[] { Float.valueOf(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this)) });
          float f2 = WebSearchVideoPlayerSeekBar.f(WebSearchVideoPlayerSeekBar.this);
          i = (int)(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this) + f2);
          WebSearchVideoPlayerSeekBar.this.BI(i);
          i = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
          WebSearchVideoPlayerSeekBar.h(WebSearchVideoPlayerSeekBar.this).setText(WebSearchVideoPlayerSeekBar.lC(i / 60) + ":" + WebSearchVideoPlayerSeekBar.lC(i % 60));
          WebSearchVideoPlayerSeekBar.i(WebSearchVideoPlayerSeekBar.this);
          return true;
        }
        y.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
        int i = WebSearchVideoPlayerSeekBar.j(WebSearchVideoPlayerSeekBar.this);
        if (WebSearchVideoPlayerSeekBar.k(WebSearchVideoPlayerSeekBar.this)) {
          i = WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this));
        }
        if (WebSearchVideoPlayerSeekBar.l(WebSearchVideoPlayerSeekBar.this) != null)
        {
          y.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : " + i);
          WebSearchVideoPlayerSeekBar.m(WebSearchVideoPlayerSeekBar.this).lE(i);
        }
        WebSearchVideoPlayerSeekBar.n(WebSearchVideoPlayerSeekBar.this);
        return true;
      }
    });
    this.ofq.addOnLayoutChangeListener(new WebSearchVideoPlayerSeekBar.2(this));
    this.ofp.addOnLayoutChangeListener(new WebSearchVideoPlayerSeekBar.3(this));
  }
  
  public final void kZ(boolean paramBoolean)
  {
    setIsPlay(paramBoolean);
  }
  
  public final void seek(int paramInt)
  {
    y.d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : " + paramInt);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.ofu) {
      paramInt = this.ofu;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      akP();
    }
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    this.bNU = paramBoolean;
    super.setIsPlay(paramBoolean);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.ofr != null) {
      this.ofr.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    this.ofu = paramInt;
    this.mPosition = 0;
    this.oft.setText(lC(this.ofu / 60) + ":" + lC(this.ofu % 60));
    akP();
  }
  
  public void yg(int paramInt)
  {
    seek(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */