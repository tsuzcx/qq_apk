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
import com.tencent.mm.ci.a.a;
import com.tencent.mm.ci.a.f;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer
  extends FrameLayout
{
  private final Runnable acP = new SnackContainer.1(this);
  private AnimationSet vqk;
  Queue<a> wpY = new LinkedList();
  private AnimationSet wpZ;
  
  public SnackContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  SnackContainer(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    paramViewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
    setVisibility(8);
    setId(a.f.snackContainer);
    init();
  }
  
  private static void b(a parama)
  {
    if (parama.wqg != null)
    {
      b.nZ(false);
      parama.wqg.onHide();
    }
  }
  
  private void init()
  {
    this.vqk = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.vqk.setInterpolator(new DecelerateInterpolator(1.5F));
    this.vqk.addAnimation(localTranslateAnimation);
    this.vqk.addAnimation(localAlphaAnimation);
    this.wpZ = new AnimationSet(false);
    localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 0.0F, 1, 1.0F);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.wpZ.addAnimation(localTranslateAnimation);
    this.wpZ.addAnimation(localAlphaAnimation);
    this.wpZ.setDuration(300L);
    this.wpZ.setAnimationListener(new SnackContainer.2(this));
  }
  
  final void a(a parama)
  {
    setVisibility(0);
    if (parama.wqg != null)
    {
      b.nZ(true);
      parama.wqg.onShow();
    }
    addView(parama.wqc);
    parama.wqd.setText(parama.wqf.ljq);
    if (parama.wqf.wpJ != null)
    {
      parama.wqe.setVisibility(0);
      parama.wqe.setText(parama.wqf.wpJ);
    }
    for (;;)
    {
      this.vqk.setDuration(500L);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
      localAnimation.setDuration(500L);
      startAnimation(this.vqk);
      localAnimation.setStartOffset(200L);
      parama.wqe.startAnimation(localAnimation);
      parama.wqd.startAnimation(localAnimation);
      if (parama.wqf.wpM > 0) {
        postDelayed(this.acP, parama.wqf.wpM);
      }
      parama.wqc.setOnTouchListener(new SnackContainer.3(this, parama));
      return;
      parama.wqe.setVisibility(8);
    }
  }
  
  public final void hide()
  {
    removeCallbacks(this.acP);
    this.acP.run();
  }
  
  public final boolean isEmpty()
  {
    return this.wpY.isEmpty();
  }
  
  public final boolean isShowing()
  {
    return !this.wpY.isEmpty();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.vqk.cancel();
    this.wpZ.cancel();
    removeCallbacks(this.acP);
    this.wpY.clear();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (8 == paramInt)
    {
      removeAllViews();
      if (!this.wpY.isEmpty()) {
        b((a)this.wpY.poll());
      }
      if (isEmpty()) {
        break label71;
      }
      a((a)this.wpY.peek());
    }
    for (;;)
    {
      b.nZ(false);
      return;
      label71:
      setVisibility(8);
    }
  }
  
  private static final class a
  {
    final View wqc;
    final TextView wqd;
    final TextView wqe;
    final Snack wqf;
    final a.c wqg;
    
    private a(Snack paramSnack, View paramView, a.c paramc)
    {
      this.wqc = paramView;
      this.wqe = ((TextView)paramView.findViewById(a.f.snackButton));
      this.wqd = ((TextView)paramView.findViewById(a.f.snackMessage));
      this.wqf = paramSnack;
      this.wqg = paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer
 * JD-Core Version:    0.7.0.1
 */