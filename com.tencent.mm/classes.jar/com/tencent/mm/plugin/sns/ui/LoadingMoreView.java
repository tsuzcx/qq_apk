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
  ImageView dnd;
  protected LinearLayout nwJ;
  protected LinearLayout nwK;
  protected LinearLayout xnU;
  protected TextView xnV;
  Animation xnW;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97931);
    this.xnW = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97931);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97930);
    this.xnW = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97930);
  }
  
  private void init()
  {
    AppMethodBeat.i(97932);
    Object localObject = LayoutInflater.from(this.context).inflate(2131495572, this, true);
    this.dnd = ((ImageView)findViewById(2131296594));
    this.nwJ = ((LinearLayout)((View)localObject).findViewById(2131301504));
    this.nwK = ((LinearLayout)((View)localObject).findViewById(2131301499));
    this.xnU = ((LinearLayout)((View)localObject).findViewById(2131303813));
    this.xnV = ((TextView)((View)localObject).findViewById(2131303814));
    this.nwJ.setVisibility(0);
    this.nwK.setVisibility(8);
    this.xnU.setVisibility(8);
    this.xnW.setDuration(1000L);
    this.xnW.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.xnW.setInterpolator((Interpolator)localObject);
    this.dnd.startAnimation(this.xnW);
    AppMethodBeat.o(97932);
  }
  
  public final void ET()
  {
    AppMethodBeat.i(97933);
    this.nwJ.setVisibility(0);
    this.nwK.setVisibility(8);
    this.xnU.setVisibility(8);
    AppMethodBeat.o(97933);
  }
  
  public final void aqs(String paramString)
  {
    AppMethodBeat.i(97934);
    this.nwJ.setVisibility(8);
    if (bt.isNullOrNil(paramString))
    {
      this.nwK.setVisibility(0);
      this.xnU.setVisibility(8);
      AppMethodBeat.o(97934);
      return;
    }
    this.xnU.setVisibility(0);
    this.nwK.setVisibility(8);
    this.xnV.setText(paramString);
    AppMethodBeat.o(97934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */