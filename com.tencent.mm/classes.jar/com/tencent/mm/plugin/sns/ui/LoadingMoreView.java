package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.sdk.platformtools.Util;

public class LoadingMoreView
  extends LinearLayout
{
  protected LinearLayout ReL;
  protected TextView ReM;
  Animation ReN;
  private Context context;
  ImageView hNV;
  protected LinearLayout wxN;
  protected LinearLayout wxO;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97931);
    this.ReN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97931);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97930);
    this.ReN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97930);
  }
  
  private void init()
  {
    AppMethodBeat.i(97932);
    Object localObject = LayoutInflater.from(this.context).inflate(b.g.sns_next_loading, this, true);
    this.hNV = ((ImageView)findViewById(b.f.album_next_progress));
    this.wxN = ((LinearLayout)((View)localObject).findViewById(b.f.loading_more_state));
    this.wxO = ((LinearLayout)((View)localObject).findViewById(b.f.loading_end));
    this.ReL = ((LinearLayout)((View)localObject).findViewById(b.f.recent_limit));
    this.ReM = ((TextView)((View)localObject).findViewById(b.f.recent_limit_text));
    this.wxN.setVisibility(0);
    this.wxO.setVisibility(8);
    this.ReL.setVisibility(8);
    this.ReN.setDuration(1000L);
    this.ReN.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.ReN.setInterpolator((Interpolator)localObject);
    this.hNV.startAnimation(this.ReN);
    AppMethodBeat.o(97932);
  }
  
  public final void atP()
  {
    AppMethodBeat.i(97933);
    this.wxN.setVisibility(0);
    this.wxO.setVisibility(8);
    this.ReL.setVisibility(8);
    AppMethodBeat.o(97933);
  }
  
  public final void baw(String paramString)
  {
    AppMethodBeat.i(97934);
    this.wxN.setVisibility(8);
    if (Util.isNullOrNil(paramString))
    {
      this.wxO.setVisibility(0);
      this.ReL.setVisibility(8);
      AppMethodBeat.o(97934);
      return;
    }
    this.ReL.setVisibility(0);
    this.wxO.setVisibility(8);
    this.ReM.setText(paramString);
    AppMethodBeat.o(97934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */