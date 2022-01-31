package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static void a(View paramView, Context paramContext, a.a parama)
  {
    AppMethodBeat.i(26261);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2131034174);
    paramContext.setDuration(300L);
    paramContext.setFillAfter(true);
    paramContext.setRepeatCount(0);
    paramContext.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(26252);
        if (this.tsV != null) {
          this.tsV.cLp();
        }
        AppMethodBeat.o(26252);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.startAnimation(paramContext);
    AppMethodBeat.o(26261);
  }
  
  public static void a(View paramView, a.a parama)
  {
    AppMethodBeat.i(26260);
    float f = paramView.getWidth();
    ab.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(f)));
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int i = (int)(f + localObject[0]);
    ab.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(i) });
    paramView.getParent();
    localObject = new TranslateAnimation(0, 0.0F, 0, -i, 1, 0.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setRepeatMode(-1);
    ((Animation)localObject).setRepeatCount(0);
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setAnimationListener(new a.2(parama, i, paramView));
    paramView.startAnimation((Animation)localObject);
    AppMethodBeat.o(26260);
  }
  
  public static void b(View paramView, Context paramContext, a.a parama)
  {
    AppMethodBeat.i(26262);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2131034181);
    paramContext.setDuration(300L);
    paramContext.setFillAfter(true);
    paramContext.setRepeatCount(0);
    paramContext.setAnimationListener(new a.4(parama));
    paramView.startAnimation(paramContext);
    AppMethodBeat.o(26262);
  }
  
  public static void b(View paramView, a.a parama)
  {
    AppMethodBeat.i(26263);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setRepeatCount(0);
    localTranslateAnimation.setAnimationListener(new a.5(parama));
    paramView.startAnimation(localTranslateAnimation);
    AppMethodBeat.o(26263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a
 * JD-Core Version:    0.7.0.1
 */