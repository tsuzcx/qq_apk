package com.tencent.mm.ui.widget.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
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
  Queue<a> AKB;
  private AnimationSet AKC;
  private final Runnable mHideRunnable;
  private AnimationSet zFQ;
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112996);
    this.AKB = new LinkedList();
    this.mHideRunnable = new SnackContainer.1(this);
    init();
    AppMethodBeat.o(112996);
  }
  
  SnackContainer(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    AppMethodBeat.i(112997);
    this.AKB = new LinkedList();
    this.mHideRunnable = new SnackContainer.1(this);
    paramViewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
    setVisibility(8);
    setId(2131827819);
    init();
    AppMethodBeat.o(112997);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(113004);
    if (parama.AKJ != null)
    {
      b.rJ(false);
      parama.AKJ.onHide();
    }
    AppMethodBeat.o(113004);
  }
  
  private static void c(a parama)
  {
    AppMethodBeat.i(113005);
    if (parama.AKJ != null)
    {
      b.rJ(true);
      parama.AKJ.onShow();
    }
    AppMethodBeat.o(113005);
  }
  
  private void init()
  {
    AppMethodBeat.i(112998);
    this.zFQ = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.zFQ.setInterpolator(new DecelerateInterpolator(1.5F));
    this.zFQ.addAnimation(localTranslateAnimation);
    this.zFQ.addAnimation(localAlphaAnimation);
    this.AKC = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.AKC.addAnimation(localTranslateAnimation);
    this.AKC.addAnimation(localAlphaAnimation);
    this.AKC.setDuration(300L);
    this.AKC.setAnimationListener(new SnackContainer.2(this));
    AppMethodBeat.o(112998);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(113003);
    setVisibility(0);
    c(parama);
    addView(parama.AKF);
    parama.AKG.setText(parama.AKI.nGF);
    if (parama.AKI.AKn != null)
    {
      parama.AKH.setVisibility(0);
      parama.AKH.setText(parama.AKI.AKn);
    }
    for (;;)
    {
      this.zFQ.setDuration(500L);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034181);
      localAnimation.setDuration(500L);
      startAnimation(this.zFQ);
      localAnimation.setStartOffset(200L);
      parama.AKH.startAnimation(localAnimation);
      parama.AKG.startAnimation(localAnimation);
      if (parama.AKI.AKq > 0) {
        postDelayed(this.mHideRunnable, parama.AKI.AKq);
      }
      parama.AKF.setOnTouchListener(new SnackContainer.3(this, parama));
      AppMethodBeat.o(113003);
      return;
      parama.AKH.setVisibility(8);
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(113002);
    removeCallbacks(this.mHideRunnable);
    this.mHideRunnable.run();
    AppMethodBeat.o(113002);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(113000);
    boolean bool = this.AKB.isEmpty();
    AppMethodBeat.o(113000);
    return bool;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(113001);
    if (!this.AKB.isEmpty())
    {
      AppMethodBeat.o(113001);
      return true;
    }
    AppMethodBeat.o(113001);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(112999);
    super.onDetachedFromWindow();
    this.zFQ.cancel();
    this.AKC.cancel();
    removeCallbacks(this.mHideRunnable);
    this.AKB.clear();
    AppMethodBeat.o(112999);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(113006);
    super.onVisibilityChanged(paramView, paramInt);
    if (8 == paramInt)
    {
      removeAllViews();
      if (!this.AKB.isEmpty()) {
        b((a)this.AKB.poll());
      }
      if (isEmpty()) {
        break label83;
      }
      a((a)this.AKB.peek());
    }
    for (;;)
    {
      b.rJ(false);
      AppMethodBeat.o(113006);
      return;
      label83:
      setVisibility(8);
    }
  }
  
  static final class a
  {
    final View AKF;
    final TextView AKG;
    final TextView AKH;
    final Snack AKI;
    final a.c AKJ;
    
    private a(Snack paramSnack, View paramView, a.c paramc)
    {
      AppMethodBeat.i(112995);
      this.AKF = paramView;
      this.AKH = ((TextView)paramView.findViewById(2131827822));
      this.AKG = ((TextView)paramView.findViewById(2131827821));
      this.AKI = paramSnack;
      this.AKJ = paramc;
      AppMethodBeat.o(112995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer
 * JD-Core Version:    0.7.0.1
 */