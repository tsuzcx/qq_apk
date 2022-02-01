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
import com.tencent.mm.cr.a.a;
import com.tencent.mm.cr.a.f;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer
  extends FrameLayout
{
  private AnimationSet WKh;
  Queue<a> Yum;
  private AnimationSet Yun;
  private final Runnable mHideRunnable;
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159724);
    this.Yum = new LinkedList();
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
    this.Yum = new LinkedList();
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
    if (parama.Yut != null)
    {
      b.HQ(false);
      parama.Yut.onHide();
    }
    AppMethodBeat.o(159732);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(159733);
    if (parama.Yut != null)
    {
      b.HQ(true);
      parama.Yut.onShow();
    }
    AppMethodBeat.o(159733);
  }
  
  private void init()
  {
    AppMethodBeat.i(159726);
    this.WKh = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.WKh.setInterpolator(new DecelerateInterpolator(1.5F));
    this.WKh.addAnimation(localTranslateAnimation);
    this.WKh.addAnimation(localAlphaAnimation);
    this.Yun = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.Yun.addAnimation(localTranslateAnimation);
    this.Yun.addAnimation(localAlphaAnimation);
    this.Yun.setDuration(300L);
    this.Yun.setAnimationListener(new Animation.AnimationListener()
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
        if ((!SnackContainer.this.isEmpty()) && (SnackContainer.b(SnackContainer.this).peek() != null) && (((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).Yut != null))
        {
          b.HQ(false);
          ((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).Yut.bPL();
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
    addView(parama.Yuq);
    parama.bEG.setText(parama.Yus.mMessage);
    if (parama.Yus.YtZ != null)
    {
      parama.Yur.setVisibility(0);
      parama.Yur.setText(parama.Yus.YtZ);
    }
    for (;;)
    {
      this.WKh.setDuration(500L);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
      localAnimation.setDuration(500L);
      startAnimation(this.WKh);
      localAnimation.setStartOffset(200L);
      parama.Yur.startAnimation(localAnimation);
      parama.bEG.startAnimation(localAnimation);
      if (parama.Yus.Yuc > 0) {
        postDelayed(this.mHideRunnable, parama.Yus.Yuc);
      }
      parama.Yuq.setOnTouchListener(new View.OnTouchListener()
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
      parama.Yur.setVisibility(8);
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
    boolean bool = this.Yum.isEmpty();
    AppMethodBeat.o(159728);
    return bool;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159729);
    if (!this.Yum.isEmpty())
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
    this.WKh.cancel();
    this.Yun.cancel();
    removeCallbacks(this.mHideRunnable);
    this.Yum.clear();
    AppMethodBeat.o(159727);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(159734);
    super.onVisibilityChanged(paramView, paramInt);
    if (8 == paramInt)
    {
      removeAllViews();
      if (!this.Yum.isEmpty()) {
        b((a)this.Yum.poll());
      }
      if (isEmpty()) {
        break label83;
      }
      a((a)this.Yum.peek());
    }
    for (;;)
    {
      b.HQ(false);
      AppMethodBeat.o(159734);
      return;
      label83:
      setVisibility(8);
    }
  }
  
  static final class a
  {
    final View Yuq;
    final TextView Yur;
    final Snack Yus;
    final a.c Yut;
    final TextView bEG;
    
    private a(Snack paramSnack, View paramView, a.c paramc)
    {
      AppMethodBeat.i(159723);
      this.Yuq = paramView;
      this.Yur = ((TextView)paramView.findViewById(a.f.snackButton));
      this.bEG = ((TextView)paramView.findViewById(a.f.snackMessage));
      this.Yus = paramSnack;
      this.Yut = paramc;
      AppMethodBeat.o(159723);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer
 * JD-Core Version:    0.7.0.1
 */