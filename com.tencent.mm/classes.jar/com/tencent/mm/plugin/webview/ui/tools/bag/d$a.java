package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
  extends FrameLayout
{
  ImageView iCl;
  Vibrator jbU;
  private ImageView lNK;
  d.a.a vhN;
  
  public d$a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(8158);
    this.jbU = ((Vibrator)paramContext.getSystemService("vibrator"));
    LayoutInflater.from(paramContext).inflate(2130971300, this);
    this.lNK = ((ImageView)findViewById(2131829530));
    this.iCl = ((ImageView)findViewById(2131820929));
    AppMethodBeat.o(8158);
  }
  
  final void ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(8160);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setDuration(50L);
    this.lNK.startAnimation(localScaleAnimation);
    AppMethodBeat.o(8160);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(8159);
    super.onConfigurationChanged(paramConfiguration);
    d.a.a locala;
    if ((this.vhN != null) && (paramConfiguration != null))
    {
      locala = this.vhN;
      if (paramConfiguration.orientation != 2) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      locala.onChange(bool);
      AppMethodBeat.o(8159);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d.a
 * JD-Core Version:    0.7.0.1
 */