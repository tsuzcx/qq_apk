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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ck.a.f;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer
  extends FrameLayout
{
  private AnimationSet aesl;
  Queue<a> agmF;
  private AnimationSet agmG;
  private final Runnable mHideRunnable;
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159724);
    this.agmF = new LinkedList();
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
    this.agmF = new LinkedList();
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
    setId(a.f.snackContainer);
    init();
    AppMethodBeat.o(159725);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(159732);
    if (parama.agmM != null)
    {
      b.NL(false);
      parama.agmM.onHide();
    }
    AppMethodBeat.o(159732);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(159733);
    if (parama.agmM != null)
    {
      b.NL(true);
      parama.agmM.onShow();
    }
    AppMethodBeat.o(159733);
  }
  
  private void init()
  {
    AppMethodBeat.i(159726);
    this.aesl = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.aesl.setInterpolator(new DecelerateInterpolator(1.5F));
    this.aesl.addAnimation(localTranslateAnimation);
    this.aesl.addAnimation(localAlphaAnimation);
    this.agmG = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.agmG.addAnimation(localTranslateAnimation);
    this.agmG.addAnimation(localAlphaAnimation);
    this.agmG.setDuration(300L);
    this.agmG.setAnimationListener(new Animation.AnimationListener()
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
        if ((!SnackContainer.this.isEmpty()) && (SnackContainer.b(SnackContainer.this).peek() != null) && (((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).agmM != null))
        {
          b.NL(false);
          ((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).agmM.cpT();
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
    addView(parama.agmJ);
    parama.dxG.setText(parama.agmL.mMessage);
    if (parama.agmL.agms != null)
    {
      parama.agmK.setVisibility(0);
      parama.agmK.setText(parama.agmL.agms);
    }
    for (;;)
    {
      this.aesl.setDuration(500L);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
      localAnimation.setDuration(500L);
      startAnimation(this.aesl);
      localAnimation.setStartOffset(200L);
      parama.agmK.startAnimation(localAnimation);
      parama.dxG.startAnimation(localAnimation);
      if (parama.agmL.agmv > 0) {
        postDelayed(this.mHideRunnable, parama.agmL.agmv);
      }
      parama.agmJ.setOnTouchListener(new View.OnTouchListener()
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
      parama.agmK.setVisibility(8);
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
    boolean bool = this.agmF.isEmpty();
    AppMethodBeat.o(159728);
    return bool;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159729);
    if (!this.agmF.isEmpty())
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
    this.aesl.cancel();
    this.agmG.cancel();
    removeCallbacks(this.mHideRunnable);
    this.agmF.clear();
    AppMethodBeat.o(159727);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(159734);
    super.onVisibilityChanged(paramView, paramInt);
    if (8 == paramInt)
    {
      removeAllViews();
      if (!this.agmF.isEmpty()) {
        b((a)this.agmF.poll());
      }
      if (isEmpty()) {
        break label83;
      }
      a((a)this.agmF.peek());
    }
    for (;;)
    {
      b.NL(false);
      AppMethodBeat.o(159734);
      return;
      label83:
      setVisibility(8);
    }
  }
  
  static final class a
  {
    final View agmJ;
    final TextView agmK;
    final Snack agmL;
    final a.c agmM;
    final TextView dxG;
    
    private a(Snack paramSnack, View paramView, a.c paramc)
    {
      AppMethodBeat.i(159723);
      this.agmJ = paramView;
      this.agmK = ((TextView)paramView.findViewById(a.f.snackButton));
      this.dxG = ((TextView)paramView.findViewById(a.f.snackMessage));
      this.agmL = paramSnack;
      this.agmM = paramc;
      AppMethodBeat.o(159723);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer
 * JD-Core Version:    0.7.0.1
 */