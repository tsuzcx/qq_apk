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
import com.tencent.mm.plugin.sns.ad.landingpage.component.comp.g.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class AdLandingVideoPlayerToolBar
  extends RelativeLayout
  implements h
{
  protected boolean Flq;
  private g.a PQO;
  protected AdLandingVideoPlayerSeekBar PQw;
  protected ImageView QeC;
  protected ImageView QeD;
  protected boolean QeE;
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
    AppMethodBeat.i(310131);
    this.contentView = null;
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.PQw = ((AdLandingVideoPlayerSeekBar)this.contentView.findViewById(b.f.ad_landing_video_player_seek_bar));
    this.QeC = ((ImageView)this.contentView.findViewById(b.f.sns_ad_native_landing_pages_sight_video_full_screen_btn));
    this.QeD = ((ImageView)this.contentView.findViewById(b.f.sns_ad_native_landing_pages_sight_voice_btn));
    AppMethodBeat.o(310131);
  }
  
  public final void Bh(int paramInt)
  {
    AppMethodBeat.i(310196);
    if (this.PQw == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar updateTime, seekBar is null");
      AppMethodBeat.o(310196);
      return;
    }
    this.PQw.Bh(paramInt);
    if (this.PQO != null) {
      this.PQO.Bh(paramInt);
    }
    AppMethodBeat.o(310196);
  }
  
  public final void Dx(boolean paramBoolean)
  {
    AppMethodBeat.i(310142);
    this.QeE = paramBoolean;
    if (this.QeD == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar swichVoiceStatus, voiceIv is null");
      AppMethodBeat.o(310142);
      return;
    }
    if (paramBoolean)
    {
      this.QeD.setImageResource(b.i.icon_volume_on);
      AppMethodBeat.o(310142);
      return;
    }
    this.QeD.setImageResource(b.i.icon_volume_off);
    AppMethodBeat.o(310142);
  }
  
  public final void Dy(boolean paramBoolean)
  {
    AppMethodBeat.i(310150);
    this.Flq = paramBoolean;
    if (this.QeC == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar swichScreenStatus, switchScreenIv is null");
      AppMethodBeat.o(310150);
      return;
    }
    if (paramBoolean)
    {
      this.QeC.setImageResource(b.i.icon_video_short_screen);
      AppMethodBeat.o(310150);
      return;
    }
    this.QeC.setImageResource(b.i.icon_video_full_screen);
    AppMethodBeat.o(310150);
  }
  
  public final List<Animator> b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    AppMethodBeat.i(310217);
    LinkedList localLinkedList = new LinkedList();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "rotation", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "translationX", new float[] { paramFloat3, paramFloat4 });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "translationY", new float[] { paramFloat5, paramFloat6 });
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat7, paramFloat8 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(310124);
        paramAnonymousValueAnimator = (Float)paramAnonymousValueAnimator.getAnimatedValue();
        ViewGroup.LayoutParams localLayoutParams = AdLandingVideoPlayerToolBar.this.getLayoutParams();
        localLayoutParams.width = ((int)paramAnonymousValueAnimator.floatValue());
        AdLandingVideoPlayerToolBar.this.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(310124);
      }
    });
    localLinkedList.add(localObjectAnimator1);
    localLinkedList.add(localObjectAnimator2);
    localLinkedList.add(localObjectAnimator3);
    localLinkedList.add(localValueAnimator);
    AppMethodBeat.o(310217);
    return localLinkedList;
  }
  
  protected int getLayoutId()
  {
    return b.g.ad_landing_video_player_tool_bar;
  }
  
  public AdLandingVideoPlayerSeekBar getSeekBar()
  {
    return this.PQw;
  }
  
  public int getVideoTotalTime()
  {
    AppMethodBeat.i(310209);
    if (this.PQw == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar getVideoTotalTime, seekBar is null");
      AppMethodBeat.o(310209);
      return 0;
    }
    int i = this.PQw.getVideoTotalTime();
    AppMethodBeat.o(310209);
    return i;
  }
  
  public int getVisibility()
  {
    AppMethodBeat.i(310190);
    int i = this.PQw.getVisibility();
    AppMethodBeat.o(310190);
    return i;
  }
  
  public final void hcD()
  {
    AppMethodBeat.i(310183);
    if (this.QeD != null) {
      this.QeD.setVisibility(0);
    }
    AppMethodBeat.o(310183);
  }
  
  public final boolean isFullScreen()
  {
    return this.Flq;
  }
  
  public final void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(310200);
    if (this.PQw == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar updateVideoStatus, seekBar is null");
      AppMethodBeat.o(310200);
      return;
    }
    this.PQw.jJ(paramBoolean);
    AppMethodBeat.o(310200);
  }
  
  public void setOnFullScreenClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(310174);
    if (this.QeC != null) {
      this.QeC.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(310174);
  }
  
  public void setOnVoiceButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(310167);
    if (this.QeD != null) {
      this.QeD.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(310167);
  }
  
  public void setUpdateTimeListener(g.a parama)
  {
    this.PQO = parama;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(310205);
    if (this.PQw == null)
    {
      Log.e("AdLandingVideoPlayerToolBar", "in adLandingVideoPlayerToolBar setVideoTotalTime, seekBar is null");
      AppMethodBeat.o(310205);
      return;
    }
    this.PQw.setVideoTotalTime(paramInt);
    AppMethodBeat.o(310205);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(310178);
    if ((this.PQw != null) && (this.QeC != null) && (this.QeD != null))
    {
      this.PQw.setVisibility(paramInt);
      this.QeC.setVisibility(paramInt);
      this.QeD.setVisibility(paramInt);
    }
    AppMethodBeat.o(310178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar
 * JD-Core Version:    0.7.0.1
 */