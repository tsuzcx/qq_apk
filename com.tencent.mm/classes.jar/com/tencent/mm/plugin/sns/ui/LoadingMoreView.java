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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.Util;

public class LoadingMoreView
  extends LinearLayout
{
  protected LinearLayout KFl;
  protected TextView KFm;
  Animation KFn;
  private Context context;
  ImageView fIv;
  protected LinearLayout ttq;
  protected LinearLayout ttr;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97931);
    this.KFn = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97931);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97930);
    this.KFn = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97930);
  }
  
  private void init()
  {
    AppMethodBeat.i(97932);
    Object localObject = LayoutInflater.from(this.context).inflate(i.g.sns_next_loading, this, true);
    this.fIv = ((ImageView)findViewById(i.f.album_next_progress));
    this.ttq = ((LinearLayout)((View)localObject).findViewById(i.f.loading_more_state));
    this.ttr = ((LinearLayout)((View)localObject).findViewById(i.f.loading_end));
    this.KFl = ((LinearLayout)((View)localObject).findViewById(i.f.recent_limit));
    this.KFm = ((TextView)((View)localObject).findViewById(i.f.recent_limit_text));
    this.ttq.setVisibility(0);
    this.ttr.setVisibility(8);
    this.KFl.setVisibility(8);
    this.KFn.setDuration(1000L);
    this.KFn.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.KFn.setInterpolator((Interpolator)localObject);
    this.fIv.startAnimation(this.KFn);
    AppMethodBeat.o(97932);
  }
  
  public final void Tk()
  {
    AppMethodBeat.i(97933);
    this.ttq.setVisibility(0);
    this.ttr.setVisibility(8);
    this.KFl.setVisibility(8);
    AppMethodBeat.o(97933);
  }
  
  public final void bbU(String paramString)
  {
    AppMethodBeat.i(97934);
    this.ttq.setVisibility(8);
    if (Util.isNullOrNil(paramString))
    {
      this.ttr.setVisibility(0);
      this.KFl.setVisibility(8);
      AppMethodBeat.o(97934);
      return;
    }
    this.KFl.setVisibility(0);
    this.ttr.setVisibility(8);
    this.KFm.setText(paramString);
    AppMethodBeat.o(97934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */