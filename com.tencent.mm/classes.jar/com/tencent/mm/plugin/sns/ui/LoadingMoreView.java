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
import com.tencent.mm.sdk.platformtools.Util;

public class LoadingMoreView
  extends LinearLayout
{
  protected LinearLayout ErQ;
  protected TextView ErR;
  Animation ErS;
  private Context context;
  ImageView dPk;
  protected LinearLayout pXt;
  protected LinearLayout pXu;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97931);
    this.ErS = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97931);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97930);
    this.ErS = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.context = paramContext;
    init();
    AppMethodBeat.o(97930);
  }
  
  private void init()
  {
    AppMethodBeat.i(97932);
    Object localObject = LayoutInflater.from(this.context).inflate(2131496467, this, true);
    this.dPk = ((ImageView)findViewById(2131296671));
    this.pXt = ((LinearLayout)((View)localObject).findViewById(2131303707));
    this.pXu = ((LinearLayout)((View)localObject).findViewById(2131303700));
    this.ErQ = ((LinearLayout)((View)localObject).findViewById(2131306616));
    this.ErR = ((TextView)((View)localObject).findViewById(2131306617));
    this.pXt.setVisibility(0);
    this.pXu.setVisibility(8);
    this.ErQ.setVisibility(8);
    this.ErS.setDuration(1000L);
    this.ErS.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.ErS.setInterpolator((Interpolator)localObject);
    this.dPk.startAnimation(this.ErS);
    AppMethodBeat.o(97932);
  }
  
  public final void PL()
  {
    AppMethodBeat.i(97933);
    this.pXt.setVisibility(0);
    this.pXu.setVisibility(8);
    this.ErQ.setVisibility(8);
    AppMethodBeat.o(97933);
  }
  
  public final void aQU(String paramString)
  {
    AppMethodBeat.i(97934);
    this.pXt.setVisibility(8);
    if (Util.isNullOrNil(paramString))
    {
      this.pXu.setVisibility(0);
      this.ErQ.setVisibility(8);
      AppMethodBeat.o(97934);
      return;
    }
    this.ErQ.setVisibility(0);
    this.pXu.setVisibility(8);
    this.ErR.setText(paramString);
    AppMethodBeat.o(97934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */