package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends FrameLayout
{
  View Qz;
  Vibrator jbU;
  ImageView lNK;
  
  public a$a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(8143);
    this.jbU = ((Vibrator)paramContext.getSystemService("vibrator"));
    LayoutInflater.from(paramContext).inflate(2130971299, this);
    this.lNK = ((ImageView)findViewById(2131829530));
    paramContext = (RelativeLayout.LayoutParams)this.lNK.getLayoutParams();
    paramContext.height = b.vhv;
    paramContext.width = b.vhv;
    this.lNK.setLayoutParams(paramContext);
    this.Qz = findViewById(2131820946);
    AppMethodBeat.o(8143);
  }
  
  final void ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(8144);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 1.0F, 1, 1.0F);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setDuration(50L);
    this.lNK.startAnimation(localScaleAnimation);
    AppMethodBeat.o(8144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a.a
 * JD-Core Version:    0.7.0.1
 */