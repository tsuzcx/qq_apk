package com.tencent.mm.ui.widget.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer
  extends FrameLayout
{
  private AnimationSet HUB;
  Queue<a> JlO;
  private AnimationSet JlP;
  private final Runnable mHideRunnable;
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159724);
    this.JlO = new LinkedList();
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159719);
        if (SnackContainer.this.getVisibility() == 0) {
          SnackContainer.this.startAnimation(SnackContainer.a(SnackContainer.this));
        }
        AppMethodBeat.o(159719);
      }
    };
    init();
    AppMethodBeat.o(159724);
  }
  
  SnackContainer(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    AppMethodBeat.i(159725);
    this.JlO = new LinkedList();
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159719);
        if (SnackContainer.this.getVisibility() == 0) {
          SnackContainer.this.startAnimation(SnackContainer.a(SnackContainer.this));
        }
        AppMethodBeat.o(159719);
      }
    };
    paramViewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
    setVisibility(8);
    setId(2131304882);
    init();
    AppMethodBeat.o(159725);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(159732);
    if (parama.JlV != null)
    {
      b.yk(false);
      parama.JlV.onHide();
    }
    AppMethodBeat.o(159732);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(159733);
    if (parama.JlV != null)
    {
      b.yk(true);
      parama.JlV.onShow();
    }
    AppMethodBeat.o(159733);
  }
  
  private void init()
  {
    AppMethodBeat.i(159726);
    this.HUB = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.HUB.setInterpolator(new DecelerateInterpolator(1.5F));
    this.HUB.addAnimation(localTranslateAnimation);
    this.HUB.addAnimation(localAlphaAnimation);
    this.JlP = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.JlP.addAnimation(localTranslateAnimation);
    this.JlP.addAnimation(localAlphaAnimation);
    this.JlP.setDuration(300L);
    this.JlP.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(159721);
        SnackContainer.this.removeAllViews();
        if (!SnackContainer.b(SnackContainer.this).isEmpty()) {
          SnackContainer.d((SnackContainer.a)SnackContainer.b(SnackContainer.this).poll());
        }
        if (!SnackContainer.this.isEmpty())
        {
          SnackContainer.a(SnackContainer.this, (SnackContainer.a)SnackContainer.b(SnackContainer.this).peek());
          AppMethodBeat.o(159721);
          return;
        }
        SnackContainer.this.setVisibility(8);
        AppMethodBeat.o(159721);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(159720);
        if ((!SnackContainer.this.isEmpty()) && (SnackContainer.b(SnackContainer.this).peek() != null) && (((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).JlV != null))
        {
          b.yk(false);
          ((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).JlV.beK();
        }
        AppMethodBeat.o(159720);
      }
    });
    AppMethodBeat.o(159726);
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(159731);
    setVisibility(0);
    c(parama);
    addView(parama.JlS);
    parama.rE.setText(parama.JlU.tAU);
    if (parama.JlU.JlA != null)
    {
      parama.JlT.setVisibility(0);
      parama.JlT.setText(parama.JlU.JlA);
    }
    for (;;)
    {
      this.HUB.setDuration(500L);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772047);
      localAnimation.setDuration(500L);
      startAnimation(this.HUB);
      localAnimation.setStartOffset(200L);
      parama.JlT.startAnimation(localAnimation);
      parama.rE.startAnimation(localAnimation);
      if (parama.JlU.JlD > 0) {
        postDelayed(this.mHideRunnable, parama.JlU.JlD);
      }
      parama.JlS.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159722);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(159722);
            return true;
            SnackContainer.this.removeCallbacks(SnackContainer.c(SnackContainer.this));
            SnackContainer.d(parama);
            SnackContainer.this.startAnimation(SnackContainer.a(SnackContainer.this));
            if (!SnackContainer.b(SnackContainer.this).isEmpty()) {
              SnackContainer.b(SnackContainer.this).clear();
            }
          }
        }
      });
      AppMethodBeat.o(159731);
      return;
      parama.JlT.setVisibility(8);
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159730);
    removeCallbacks(this.mHideRunnable);
    this.mHideRunnable.run();
    AppMethodBeat.o(159730);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(159728);
    boolean bool = this.JlO.isEmpty();
    AppMethodBeat.o(159728);
    return bool;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159729);
    if (!this.JlO.isEmpty())
    {
      AppMethodBeat.o(159729);
      return true;
    }
    AppMethodBeat.o(159729);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(159727);
    super.onDetachedFromWindow();
    this.HUB.cancel();
    this.JlP.cancel();
    removeCallbacks(this.mHideRunnable);
    this.JlO.clear();
    AppMethodBeat.o(159727);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(159734);
    super.onVisibilityChanged(paramView, paramInt);
    if (8 == paramInt)
    {
      removeAllViews();
      if (!this.JlO.isEmpty()) {
        b((a)this.JlO.poll());
      }
      if (isEmpty()) {
        break label83;
      }
      a((a)this.JlO.peek());
    }
    for (;;)
    {
      b.yk(false);
      AppMethodBeat.o(159734);
      return;
      label83:
      setVisibility(8);
    }
  }
  
  static final class a
  {
    final View JlS;
    final TextView JlT;
    final Snack JlU;
    final a.c JlV;
    final TextView rE;
    
    private a(Snack paramSnack, View paramView, a.c paramc)
    {
      AppMethodBeat.i(159723);
      this.JlS = paramView;
      this.JlT = ((TextView)paramView.findViewById(2131304881));
      this.rE = ((TextView)paramView.findViewById(2131304883));
      this.JlU = paramSnack;
      this.JlV = paramc;
      AppMethodBeat.o(159723);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer
 * JD-Core Version:    0.7.0.1
 */