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
  View mContentView;
  Vibrator mZD;
  ImageView qrQ;
  
  public a$a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(80409);
    this.mZD = ((Vibrator)paramContext.getSystemService("vibrator"));
    LayoutInflater.from(paramContext).inflate(2131496081, this);
    this.qrQ = ((ImageView)findViewById(2131297203));
    paramContext = (RelativeLayout.LayoutParams)this.qrQ.getLayoutParams();
    paramContext.height = b.Exj;
    paramContext.width = b.Exj;
    this.qrQ.setLayoutParams(paramContext);
    this.mContentView = findViewById(2131298739);
    AppMethodBeat.o(80409);
  }
  
  final void aj(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(80410);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 1.0F, 1, 1.0F);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setDuration(50L);
    this.qrQ.startAnimation(localScaleAnimation);
    AppMethodBeat.o(80410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a.a
 * JD-Core Version:    0.7.0.1
 */