package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ExpandTextView
  extends FrameLayout
  implements View.OnClickListener
{
  private TextView Gww;
  private MMNeat7extView agGi;
  private String agGj;
  private int agGk;
  private a agGl = null;
  private boolean pvv = false;
  
  public ExpandTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExpandTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public TextView getExpandTextView()
  {
    return this.Gww;
  }
  
  public MMNeat7extView getTextView()
  {
    return this.agGi;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(164249);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/ExpandTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!this.pvv)
    {
      this.pvv = true;
      this.agGi.setMaxLines(2147483647);
      this.Gww.animate().alpha(0.0F).setDuration(300L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(164240);
          ExpandTextView.a(ExpandTextView.this).setAlpha(1.0F);
          ExpandTextView.a(ExpandTextView.this).setVisibility(8);
          AppMethodBeat.o(164240);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/ExpandTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(164249);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(164241);
    super.onFinishInflate();
    this.agGi = new MMNeat7extView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.agGi, localLayoutParams);
    this.Gww = new TextView(getContext());
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 85;
    addView(this.Gww, localLayoutParams);
    this.Gww.setOnClickListener(this);
    AppMethodBeat.o(164241);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164248);
    super.onMeasure(paramInt1, paramInt2);
    if (!this.pvv)
    {
      com.tencent.neattextview.textview.layout.a locala = this.agGi.pE(getMeasuredWidth(), getMeasuredHeight());
      if (locala != null)
      {
        if (locala.jQH() > this.agGk)
        {
          this.Gww.setVisibility(0);
          AppMethodBeat.o(164248);
          return;
        }
        this.Gww.setVisibility(8);
        AppMethodBeat.o(164248);
        return;
      }
      Log.e("MicroMsg.ExpandTextView", "layout is null!");
      this.Gww.setVisibility(8);
    }
    AppMethodBeat.o(164248);
  }
  
  public void setExpandIconText(String paramString)
  {
    this.agGj = paramString;
  }
  
  public void setExpandTextColor(int paramInt)
  {
    AppMethodBeat.i(164242);
    this.Gww.setTextColor(paramInt);
    AppMethodBeat.o(164242);
  }
  
  public void setExpandTextSize(float paramFloat)
  {
    AppMethodBeat.i(164244);
    this.Gww.setTextSize(0, paramFloat);
    AppMethodBeat.o(164244);
  }
  
  public void setLineSpacingExtra(int paramInt)
  {
    AppMethodBeat.i(164245);
    this.agGi.setSpacingAdd(paramInt);
    AppMethodBeat.o(164245);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(164247);
    this.agGi.setMaxLines(paramInt);
    AppMethodBeat.o(164247);
  }
  
  public void setOnExpandListener(a parama)
  {
    this.agGl = parama;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(164243);
    this.agGi.setTextColor(paramInt);
    AppMethodBeat.o(164243);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(164246);
    this.agGi.setTextSize(0, paramFloat);
    AppMethodBeat.o(164246);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.ExpandTextView
 * JD-Core Version:    0.7.0.1
 */