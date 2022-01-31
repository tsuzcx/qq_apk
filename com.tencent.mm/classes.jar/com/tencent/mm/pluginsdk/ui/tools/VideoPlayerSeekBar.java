package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.y;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  public boolean bNU = false;
  private int qWg = -1;
  private int qWh = -1;
  private int qWi = -1;
  private PInt sne = new PInt();
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public void akP()
  {
    if (this.ofu == 0) {}
    while ((this.guU) || (this.ofq == null) || (getBarLen() == 0)) {
      return;
    }
    this.ofs.setText(lC(this.mPosition / 60) + ":" + lC(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ofq.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = fa(this.mPosition, i);
    this.ofq.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.ofo.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ofu * i));
    this.ofo.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public final int fa(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
    {
      this.ofp.getLayoutParams();
      return 0;
    }
    if (paramInt1 >= this.ofu) {
      return paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
    }
    return (int)(paramInt1 * 1.0D / this.ofu * paramInt2);
  }
  
  protected int getBarPointWidth()
  {
    if (this.qWg == -1) {
      this.qWg = this.ofq.getWidth();
    }
    return this.qWg;
  }
  
  public int getLayoutId()
  {
    return a.b.video_player_seek_bar;
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
    this.ofo = ((ImageView)this.contentView.findViewById(a.a.player_progress_bar_front));
    this.ofp = ((ImageView)this.contentView.findViewById(a.a.player_progress_bar_background));
    this.ofq = ((ImageView)this.contentView.findViewById(a.a.player_progress_point));
    this.ofr = ((ImageView)this.contentView.findViewById(a.a.play_btn));
    this.ofs = ((TextView)this.contentView.findViewById(a.a.play_current_time_tv));
    this.oft = ((TextView)this.contentView.findViewById(a.a.play_total_time_tv));
    this.ofq.setOnTouchListener(new VideoPlayerSeekBar.1(this));
  }
  
  public final void kZ(boolean paramBoolean)
  {
    setIsPlay(paramBoolean);
  }
  
  public void seek(int paramInt)
  {
    y.d("MicroMsg.VideoPlayerSeekBar", "seek position : " + paramInt);
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
  
  public final void yg(int paramInt)
  {
    seek(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */