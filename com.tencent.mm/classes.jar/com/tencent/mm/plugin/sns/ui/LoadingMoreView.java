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
import com.tencent.mm.sdk.platformtools.bs;

public class LoadingMoreView
  extends LinearLayout
{
  private Context context;
  ImageView dkL;
  protected LinearLayout nZJ;
  protected LinearLayout nZK;
  protected LinearLayout yAL;
  protected TextView yAM;
  Animation yAN;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97931);
    this.yAN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97931);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97930);
    this.yAN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97930);
  }
  
  private void init()
  {
    AppMethodBeat.i(97932);
    Object localObject = LayoutInflater.from(this.context).inflate(2131495572, this, true);
    this.dkL = ((ImageView)findViewById(2131296594));
    this.nZJ = ((LinearLayout)((View)localObject).findViewById(2131301504));
    this.nZK = ((LinearLayout)((View)localObject).findViewById(2131301499));
    this.yAL = ((LinearLayout)((View)localObject).findViewById(2131303813));
    this.yAM = ((TextView)((View)localObject).findViewById(2131303814));
    this.nZJ.setVisibility(0);
    this.nZK.setVisibility(8);
    this.yAL.setVisibility(8);
    this.yAN.setDuration(1000L);
    this.yAN.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.yAN.setInterpolator((Interpolator)localObject);
    this.dkL.startAnimation(this.yAN);
    AppMethodBeat.o(97932);
  }
  
  public final void Ex()
  {
    AppMethodBeat.i(97933);
    this.nZJ.setVisibility(0);
    this.nZK.setVisibility(8);
    this.yAL.setVisibility(8);
    AppMethodBeat.o(97933);
  }
  
  public final void avB(String paramString)
  {
    AppMethodBeat.i(97934);
    this.nZJ.setVisibility(8);
    if (bs.isNullOrNil(paramString))
    {
      this.nZK.setVisibility(0);
      this.yAL.setVisibility(8);
      AppMethodBeat.o(97934);
      return;
    }
    this.yAL.setVisibility(0);
    this.nZK.setVisibility(8);
    this.yAM.setText(paramString);
    AppMethodBeat.o(97934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */