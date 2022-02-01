package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void a(View paramView, Context paramContext, a parama)
  {
    AppMethodBeat.i(29946);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772050);
    paramContext.setDuration(300L);
    paramContext.setFillAfter(true);
    paramContext.setRepeatCount(0);
    paramContext.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(29937);
        if (this.GSE != null) {
          this.GSE.fEM();
        }
        AppMethodBeat.o(29937);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.startAnimation(paramContext);
    AppMethodBeat.o(29946);
  }
  
  public static void a(final View paramView, a parama)
  {
    AppMethodBeat.i(29945);
    float f = paramView.getWidth();
    Log.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(f)));
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    final int i = (int)(f + localObject[0]);
    Log.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(i) });
    paramView.getParent();
    localObject = new TranslateAnimation(0, 0.0F, 0, -i, 1, 0.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setRepeatMode(-1);
    ((Animation)localObject).setRepeatCount(0);
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(29936);
        if (this.GSF != null) {
          this.GSF.fEL();
        }
        Log.d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
        paramAnonymousAnimation = new TranslateAnimation(0, i, 0, 0.0F, 1, 0.0F, 1, 0.0F);
        paramAnonymousAnimation.setDuration(200L);
        paramAnonymousAnimation.setStartOffset(0L);
        paramAnonymousAnimation.setRepeatMode(-1);
        paramAnonymousAnimation.setRepeatCount(0);
        paramAnonymousAnimation.setFillAfter(true);
        paramAnonymousAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymous2Animation)
          {
            AppMethodBeat.i(29935);
            Log.i("MicroMsg.VoiceViewAnimationHelper", "next end");
            if (a.2.this.GSF != null) {
              a.2.this.GSF.fEM();
            }
            AppMethodBeat.o(29935);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
          
          public final void onAnimationStart(Animation paramAnonymous2Animation) {}
        });
        paramView.startAnimation(paramAnonymousAnimation);
        AppMethodBeat.o(29936);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.startAnimation((Animation)localObject);
    AppMethodBeat.o(29945);
  }
  
  public static void b(View paramView, Context paramContext, a parama)
  {
    AppMethodBeat.i(29947);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772059);
    paramContext.setDuration(300L);
    paramContext.setFillAfter(true);
    paramContext.setRepeatCount(0);
    paramContext.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(29938);
        if (this.GSE != null) {
          this.GSE.fEM();
        }
        AppMethodBeat.o(29938);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.startAnimation(paramContext);
    AppMethodBeat.o(29947);
  }
  
  public static void b(View paramView, a parama)
  {
    AppMethodBeat.i(29948);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setRepeatCount(0);
    localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(29940);
        if (this.GSE != null) {
          this.GSE.fEM();
        }
        AppMethodBeat.o(29940);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(29939);
        if (this.GSE != null) {
          this.GSE.fEL();
        }
        AppMethodBeat.o(29939);
      }
    });
    paramView.startAnimation(localTranslateAnimation);
    AppMethodBeat.o(29948);
  }
  
  public static abstract interface a
  {
    public abstract void fEL();
    
    public abstract void fEM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.a
 * JD-Core Version:    0.7.0.1
 */