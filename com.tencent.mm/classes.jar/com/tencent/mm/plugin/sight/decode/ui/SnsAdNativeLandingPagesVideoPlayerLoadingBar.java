package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ai.a.e;
import com.tencent.mm.plugin.ai.a.f;
import com.tencent.mm.plugin.ai.a.g;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private boolean bNU = false;
  private View contentView = null;
  private boolean guU = false;
  private int mPosition = 0;
  private int ofA = -1;
  private int ofB = -1;
  private b ofn = null;
  private ImageView ofo;
  private ImageView ofp = null;
  private ImageView ofq = null;
  private ImageView ofr = null;
  private TextView ofs;
  private TextView oft;
  private int ofu = 0;
  private int ofv = 0;
  private float ofx = 0.0F;
  private int ofy = -1;
  private int ofz = -1;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void akP()
  {
    if (this.ofu == 0) {}
    while ((this.guU) || (this.ofq == null) || (getBarLen() == 0)) {
      return;
    }
    int i = (this.ofq.getWidth() - this.ofq.getPaddingLeft() - this.ofq.getPaddingRight()) / 2;
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
  
  private int getBarLen()
  {
    this.ofv = this.ofp.getWidth();
    return this.ofv;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    int i = ((FrameLayout.LayoutParams)this.ofp.getLayoutParams()).leftMargin;
    int j = this.ofq.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.ofq.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.ofu);
    i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  private void init()
  {
    this.contentView = View.inflate(getContext(), a.f.sns_ad_natvie_landingpages_video_player_loading_bar, this);
    this.ofo = ((ImageView)this.contentView.findViewById(a.e.player_progress_bar_front));
    this.ofp = ((ImageView)this.contentView.findViewById(a.e.player_progress_bar_background));
    this.ofq = ((ImageView)this.contentView.findViewById(a.e.player_progress_point));
    this.ofr = ((ImageView)this.contentView.findViewById(a.e.play_btn));
    this.ofs = ((TextView)this.contentView.findViewById(a.e.play_current_time_tv));
    this.oft = ((TextView)this.contentView.findViewById(a.e.play_total_time_tv));
    this.ofq.setOnTouchListener(new SnsAdNativeLandingPagesVideoPlayerLoadingBar.1(this));
  }
  
  public static String lC(int paramInt)
  {
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return String.valueOf(paramInt);
  }
  
  public final void bBm()
  {
    this.ofv = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.bNU;
  }
  
  public int getVideoTotalTime()
  {
    return this.ofu;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.ofy) || (paramInt2 != this.ofz) || (paramInt3 != this.ofA) || (paramInt4 != this.ofB)) {
      akP();
    }
    this.ofy = paramInt1;
    this.ofz = paramInt2;
    this.ofA = paramInt3;
    this.ofB = paramInt4;
  }
  
  public final void seek(int paramInt)
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
    this.bNU = paramBoolean;
    if (paramBoolean)
    {
      this.ofr.setImageResource(a.g.media_player_pause_btn);
      return;
    }
    this.ofr.setImageResource(a.g.media_player_play_btn);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ofr.setOnClickListener(paramOnClickListener);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    if ((this.ofq.isShown()) && (this.ofq.getWidth() == 0))
    {
      post(new SnsAdNativeLandingPagesVideoPlayerLoadingBar.2(this, paramInt));
      return;
    }
    this.ofu = paramInt;
    this.mPosition = 0;
    this.oft.setText(lC(this.ofu / 60) + ":" + lC(this.ofu % 60));
    akP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */