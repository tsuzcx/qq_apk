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
  private AnimationSet PpM;
  Queue<a> QVC;
  private AnimationSet QVD;
  private final Runnable mHideRunnable;
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159724);
    this.QVC = new LinkedList();
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
    this.QVC = new LinkedList();
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
    setId(2131307968);
    init();
    AppMethodBeat.o(159725);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(159732);
    if (parama.QVJ != null)
    {
      b.Dt(false);
      parama.QVJ.onHide();
    }
    AppMethodBeat.o(159732);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(159733);
    if (parama.QVJ != null)
    {
      b.Dt(true);
      parama.QVJ.onShow();
    }
    AppMethodBeat.o(159733);
  }
  
  private void init()
  {
    AppMethodBeat.i(159726);
    this.PpM = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.PpM.setInterpolator(new DecelerateInterpolator(1.5F));
    this.PpM.addAnimation(localTranslateAnimation);
    this.PpM.addAnimation(localAlphaAnimation);
    this.QVD = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.QVD.addAnimation(localTranslateAnimation);
    this.QVD.addAnimation(localAlphaAnimation);
    this.QVD.setDuration(300L);
    this.QVD.setAnimationListener(new Animation.AnimationListener()
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
        if ((!SnackContainer.this.isEmpty()) && (SnackContainer.b(SnackContainer.this).peek() != null) && (((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).QVJ != null))
        {
          b.Dt(false);
          ((SnackContainer.a)SnackContainer.b(SnackContainer.this).peek()).QVJ.bDY();
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
    addView(parama.QVG);
    parama.tF.setText(parama.QVI.mMessage);
    if (parama.QVI.QVo != null)
    {
      parama.QVH.setVisibility(0);
      parama.QVH.setText(parama.QVI.QVo);
    }
    for (;;)
    {
      this.PpM.setDuration(500L);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772059);
      localAnimation.setDuration(500L);
      startAnimation(this.PpM);
      localAnimation.setStartOffset(200L);
      parama.QVH.startAnimation(localAnimation);
      parama.tF.startAnimation(localAnimation);
      if (parama.QVI.QVr > 0) {
        postDelayed(this.mHideRunnable, parama.QVI.QVr);
      }
      parama.QVG.setOnTouchListener(new View.OnTouchListener()
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
      parama.QVH.setVisibility(8);
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
    boolean bool = this.QVC.isEmpty();
    AppMethodBeat.o(159728);
    return bool;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159729);
    if (!this.QVC.isEmpty())
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
    this.PpM.cancel();
    this.QVD.cancel();
    removeCallbacks(this.mHideRunnable);
    this.QVC.clear();
    AppMethodBeat.o(159727);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(159734);
    super.onVisibilityChanged(paramView, paramInt);
    if (8 == paramInt)
    {
      removeAllViews();
      if (!this.QVC.isEmpty()) {
        b((a)this.QVC.poll());
      }
      if (isEmpty()) {
        break label83;
      }
      a((a)this.QVC.peek());
    }
    for (;;)
    {
      b.Dt(false);
      AppMethodBeat.o(159734);
      return;
      label83:
      setVisibility(8);
    }
  }
  
  static final class a
  {
    final View QVG;
    final TextView QVH;
    final Snack QVI;
    final a.c QVJ;
    final TextView tF;
    
    private a(Snack paramSnack, View paramView, a.c paramc)
    {
      AppMethodBeat.i(159723);
      this.QVG = paramView;
      this.QVH = ((TextView)paramView.findViewById(2131307967));
      this.tF = ((TextView)paramView.findViewById(2131307969));
      this.QVI = paramSnack;
      this.QVJ = paramc;
      AppMethodBeat.o(159723);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer
 * JD-Core Version:    0.7.0.1
 */