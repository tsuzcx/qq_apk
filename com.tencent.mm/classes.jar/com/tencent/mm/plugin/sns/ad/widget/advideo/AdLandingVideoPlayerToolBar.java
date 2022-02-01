package com.tencent.mm.plugin.sns.ad.widget.advideo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.a.f.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class AdLandingVideoPlayerToolBar
  extends RelativeLayout
  implements h
{
  protected boolean AJP;
  protected AdLandingVideoPlayerSeekBar JAN;
  private f.a JBg;
  protected ImageView JLH;
  protected ImageView JLI;
  protected boolean JLJ;
  protected View contentView;
  
  public AdLandingVideoPlayerToolBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdLandingVideoPlayerToolBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdLandingVideoPlayerToolBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219162);
    this.contentView = null;
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.JAN = ((AdLandingVideoPlayerSeekBar)this.contentView.findViewById(i.f.ad_landing_video_player_seek_bar));
    this.JLH = ((ImageView)this.contentView.findViewById(i.f.sns_ad_native_landing_pages_sight_video_full_screen_btn));
    this.JLI = ((ImageView)this.contentView.findViewById(i.f.sns_ad_native_landing_pages_sight_voice_btn));
    AppMethodBeat.o(219162);
  }
  
  public final void AS(int paramInt)
  {
    AppMethodBeat.i(219182);
    if (this.JAN == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar updateTime, seekBar is null");
      AppMethodBeat.o(219182);
      return;
    }
    this.JAN.AS(paramInt);
    if (this.JBg != null) {
      this.JBg.AS(paramInt);
    }
    AppMethodBeat.o(219182);
  }
  
  public final boolean QT()
  {
    return this.AJP;
  }
  
  public final List<Animator> b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    AppMethodBeat.i(219195);
    LinkedList localLinkedList = new LinkedList();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "rotation", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "translationX", new float[] { paramFloat3, paramFloat4 });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "translationY", new float[] { paramFloat5, paramFloat6 });
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat7, paramFloat8 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(206524);
        paramAnonymousValueAnimator = (Float)paramAnonymousValueAnimator.getAnimatedValue();
        ViewGroup.LayoutParams localLayoutParams = AdLandingVideoPlayerToolBar.this.getLayoutParams();
        localLayoutParams.width = ((int)paramAnonymousValueAnimator.floatValue());
        AdLandingVideoPlayerToolBar.this.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(206524);
      }
    });
    localLinkedList.add(localObjectAnimator1);
    localLinkedList.add(localObjectAnimator2);
    localLinkedList.add(localObjectAnimator3);
    localLinkedList.add(localValueAnimator);
    AppMethodBeat.o(219195);
    return localLinkedList;
  }
  
  public final void fMa()
  {
    AppMethodBeat.i(219178);
    if (this.JLI != null) {
      this.JLI.setVisibility(0);
    }
    AppMethodBeat.o(219178);
  }
  
  protected int getLayoutId()
  {
    return i.g.ad_landing_video_player_tool_bar;
  }
  
  public AdLandingVideoPlayerSeekBar getSeekBar()
  {
    return this.JAN;
  }
  
  public int getVideoTotalTime()
  {
    AppMethodBeat.i(219187);
    if (this.JAN == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar getVideoTotalTime, seekBar is null");
      AppMethodBeat.o(219187);
      return 0;
    }
    int i = this.JAN.getVideoTotalTime();
    AppMethodBeat.o(219187);
    return i;
  }
  
  public int getVisibility()
  {
    AppMethodBeat.i(219180);
    int i = this.JAN.getVisibility();
    AppMethodBeat.o(219180);
    return i;
  }
  
  public final void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(219185);
    if (this.JAN == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar updateVideoStatus, seekBar is null");
      AppMethodBeat.o(219185);
      return;
    }
    this.JAN.iF(paramBoolean);
    AppMethodBeat.o(219185);
  }
  
  public void setOnFullScreenClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(219174);
    if (this.JLH != null) {
      this.JLH.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(219174);
  }
  
  public void setOnVoiceButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(219173);
    if (this.JLI != null) {
      this.JLI.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(219173);
  }
  
  public void setUpdateTimeListener(f.a parama)
  {
    this.JBg = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(219186);
    if (this.JAN == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar setVideoTotalTime, seekBar is null");
      AppMethodBeat.o(219186);
      return;
    }
    this.JAN.setVideoTotalTime(paramInt);
    AppMethodBeat.o(219186);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(219175);
    if ((this.JAN != null) && (this.JLH != null) && (this.JLI != null))
    {
      this.JAN.setVisibility(paramInt);
      this.JLH.setVisibility(paramInt);
      this.JLI.setVisibility(paramInt);
    }
    AppMethodBeat.o(219175);
  }
  
  public final void ys(boolean paramBoolean)
  {
    AppMethodBeat.i(219167);
    this.JLJ = paramBoolean;
    if (this.JLI == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar swichVoiceStatus, voiceIv is null");
      AppMethodBeat.o(219167);
      return;
    }
    if (paramBoolean)
    {
      this.JLI.setImageResource(i.i.icon_volume_on);
      AppMethodBeat.o(219167);
      return;
    }
    this.JLI.setImageResource(i.i.icon_volume_off);
    AppMethodBeat.o(219167);
  }
  
  public final void yt(boolean paramBoolean)
  {
    AppMethodBeat.i(219170);
    this.AJP = paramBoolean;
    if (this.JLH == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar swichScreenStatus, switchScreenIv is null");
      AppMethodBeat.o(219170);
      return;
    }
    if (paramBoolean)
    {
      this.JLH.setImageResource(i.i.icon_video_short_screen);
      AppMethodBeat.o(219170);
      return;
    }
    this.JLH.setImageResource(i.i.icon_video_full_screen);
    AppMethodBeat.o(219170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar
 * JD-Core Version:    0.7.0.1
 */