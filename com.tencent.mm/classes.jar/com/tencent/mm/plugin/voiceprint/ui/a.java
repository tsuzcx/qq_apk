package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.R.a;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static void a(View paramView, Context paramContext, a.a parama)
  {
    paramContext = AnimationUtils.loadAnimation(paramContext, R.a.faded_out);
    paramContext.setDuration(300L);
    paramContext.setFillAfter(true);
    paramContext.setRepeatCount(0);
    paramContext.setAnimationListener(new a.3(parama));
    paramView.startAnimation(paramContext);
  }
  
  public static void a(View paramView, a.a parama)
  {
    float f = paramView.getWidth();
    y.d("MicroMsg.VoiceViewAnimationHelper", "target " + f);
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int i = (int)(f + localObject[0]);
    y.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(i) });
    paramView.getParent();
    localObject = new TranslateAnimation(0, 0.0F, 0, -i, 1, 0.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setRepeatMode(-1);
    ((Animation)localObject).setRepeatCount(0);
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setAnimationListener(new a.2(parama, i, paramView));
    paramView.startAnimation((Animation)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a
 * JD-Core Version:    0.7.0.1
 */