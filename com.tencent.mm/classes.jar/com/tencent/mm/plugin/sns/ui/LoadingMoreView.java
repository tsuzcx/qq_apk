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
import com.tencent.mm.sdk.platformtools.bt;

public class LoadingMoreView
  extends LinearLayout
{
  private Context context;
  ImageView dwy;
  protected LinearLayout oDd;
  protected LinearLayout oDe;
  protected LinearLayout zSa;
  protected TextView zSb;
  Animation zSc;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97931);
    this.zSc = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97931);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97930);
    this.zSc = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97930);
  }
  
  private void init()
  {
    AppMethodBeat.i(97932);
    Object localObject = LayoutInflater.from(this.context).inflate(2131495572, this, true);
    this.dwy = ((ImageView)findViewById(2131296594));
    this.oDd = ((LinearLayout)((View)localObject).findViewById(2131301504));
    this.oDe = ((LinearLayout)((View)localObject).findViewById(2131301499));
    this.zSa = ((LinearLayout)((View)localObject).findViewById(2131303813));
    this.zSb = ((TextView)((View)localObject).findViewById(2131303814));
    this.oDd.setVisibility(0);
    this.oDe.setVisibility(8);
    this.zSa.setVisibility(8);
    this.zSc.setDuration(1000L);
    this.zSc.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.zSc.setInterpolator((Interpolator)localObject);
    this.dwy.startAnimation(this.zSc);
    AppMethodBeat.o(97932);
  }
  
  public final void FW()
  {
    AppMethodBeat.i(97933);
    this.oDd.setVisibility(0);
    this.oDe.setVisibility(8);
    this.zSa.setVisibility(8);
    AppMethodBeat.o(97933);
  }
  
  public final void aAI(String paramString)
  {
    AppMethodBeat.i(97934);
    this.oDd.setVisibility(8);
    if (bt.isNullOrNil(paramString))
    {
      this.oDe.setVisibility(0);
      this.zSa.setVisibility(8);
      AppMethodBeat.o(97934);
      return;
    }
    this.zSa.setVisibility(0);
    this.oDe.setVisibility(8);
    this.zSb.setText(paramString);
    AppMethodBeat.o(97934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */