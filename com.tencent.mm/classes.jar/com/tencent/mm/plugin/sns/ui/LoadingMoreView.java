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
import com.tencent.mm.sdk.platformtools.bu;

public class LoadingMoreView
  extends LinearLayout
{
  protected LinearLayout Ajh;
  protected TextView Aji;
  Animation Ajj;
  private Context context;
  ImageView dxD;
  protected LinearLayout oJF;
  protected LinearLayout oJG;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97931);
    this.Ajj = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97931);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97930);
    this.Ajj = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97930);
  }
  
  private void init()
  {
    AppMethodBeat.i(97932);
    Object localObject = LayoutInflater.from(this.context).inflate(2131495572, this, true);
    this.dxD = ((ImageView)findViewById(2131296594));
    this.oJF = ((LinearLayout)((View)localObject).findViewById(2131301504));
    this.oJG = ((LinearLayout)((View)localObject).findViewById(2131301499));
    this.Ajh = ((LinearLayout)((View)localObject).findViewById(2131303813));
    this.Aji = ((TextView)((View)localObject).findViewById(2131303814));
    this.oJF.setVisibility(0);
    this.oJG.setVisibility(8);
    this.Ajh.setVisibility(8);
    this.Ajj.setDuration(1000L);
    this.Ajj.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.Ajj.setInterpolator((Interpolator)localObject);
    this.dxD.startAnimation(this.Ajj);
    AppMethodBeat.o(97932);
  }
  
  public final void Gc()
  {
    AppMethodBeat.i(97933);
    this.oJF.setVisibility(0);
    this.oJG.setVisibility(8);
    this.Ajh.setVisibility(8);
    AppMethodBeat.o(97933);
  }
  
  public final void aBZ(String paramString)
  {
    AppMethodBeat.i(97934);
    this.oJF.setVisibility(8);
    if (bu.isNullOrNil(paramString))
    {
      this.oJG.setVisibility(0);
      this.Ajh.setVisibility(8);
      AppMethodBeat.o(97934);
      return;
    }
    this.Ajh.setVisibility(0);
    this.oJG.setVisibility(8);
    this.Aji.setText(paramString);
    AppMethodBeat.o(97934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */