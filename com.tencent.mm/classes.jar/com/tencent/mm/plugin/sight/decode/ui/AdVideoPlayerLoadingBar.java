package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.ac.a.c;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  public View contentView = null;
  public boolean guU = false;
  public int mPosition = 0;
  private int ofA = -1;
  private int ofB = -1;
  public b ofn = null;
  public ImageView ofo;
  public ImageView ofp = null;
  public ImageView ofq = null;
  public ImageView ofr = null;
  public TextView ofs;
  public TextView oft;
  public int ofu = 0;
  private int ofv = 0;
  private int ofw = 0;
  public float ofx = 0.0F;
  private int ofy = -1;
  private int ofz = -1;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static String lC(int paramInt)
  {
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return String.valueOf(paramInt);
  }
  
  public void akP()
  {
    if (this.ofu == 0) {}
    while ((this.guU) || (this.ofq == null) || (getBarLen() == 0)) {
      return;
    }
    int i = (getBarPointWidth() - this.ofq.getPaddingLeft() - this.ofq.getPaddingRight()) / 2;
    this.ofs.setText(lC(this.mPosition / 60) + ":" + lC(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.ofp.getLayoutParams()).leftMargin;
    int k = this.ofq.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ofq.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.ofu * getBarLen()) - i);
    this.ofq.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.ofo.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ofu * getBarLen()));
    this.ofo.setLayoutParams(localLayoutParams);
  }
  
  public final void bBl()
  {
    this.oft.setText(lC(this.ofu / 60) + ":" + lC(this.ofu % 60));
    akP();
  }
  
  public final void bBm()
  {
    this.ofv = 0;
  }
  
  public int getBarLen()
  {
    if (this.ofv <= 0) {
      this.ofv = this.ofp.getWidth();
    }
    return this.ofv;
  }
  
  public int getBarPointWidth()
  {
    if (this.ofw <= 0) {
      this.ofw = this.ofq.getWidth();
    }
    return this.ofw;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    int i = ((FrameLayout.LayoutParams)this.ofp.getLayoutParams()).leftMargin;
    int j = this.ofq.getPaddingLeft();
    return Math.max(0, (int)((((FrameLayout.LayoutParams)this.ofq.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.ofq.getPaddingLeft() - this.ofq.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.ofu));
  }
  
  public int getLayoutId()
  {
    return a.b.video_player_loading_bar;
  }
  
  public int getVideoTotalTime()
  {
    return this.ofu;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  public void init()
  {
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.ofo = ((ImageView)this.contentView.findViewById(a.a.player_progress_bar_front));
    this.ofp = ((ImageView)this.contentView.findViewById(a.a.player_progress_bar_background));
    this.ofq = ((ImageView)this.contentView.findViewById(a.a.player_progress_point));
    this.ofr = ((ImageView)this.contentView.findViewById(a.a.play_btn));
    this.ofs = ((TextView)this.contentView.findViewById(a.a.play_current_time_tv));
    this.oft = ((TextView)this.contentView.findViewById(a.a.play_total_time_tv));
    this.ofq.setOnTouchListener(new AdVideoPlayerLoadingBar.1(this));
    this.ofq.post(new AdVideoPlayerLoadingBar.2(this));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ofo.getLayoutParams();
    localLayoutParams.width = 0;
    this.ofo.setLayoutParams(localLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.ofv = 0;
    if ((paramInt1 != this.ofy) || (paramInt2 != this.ofz) || (paramInt3 != this.ofA) || (paramInt4 != this.ofB)) {
      akP();
    }
    this.ofy = paramInt1;
    this.ofz = paramInt2;
    this.ofA = paramInt3;
    this.ofB = paramInt4;
  }
  
  public void seek(int paramInt)
  {
    this.mPosition = paramInt;
    akP();
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.ofn = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ofr.setImageResource(a.c.media_player_pause_btn);
      return;
    }
    this.ofr.setImageResource(a.c.media_player_play_btn);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ofr.setOnClickListener(paramOnClickListener);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    this.ofu = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new AdVideoPlayerLoadingBar.3(this));
      return;
    }
    bBl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */