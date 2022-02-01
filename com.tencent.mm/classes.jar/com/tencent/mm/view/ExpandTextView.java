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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ExpandTextView
  extends FrameLayout
  implements View.OnClickListener
{
  private TextView LKP;
  private MMNeat7extView LKQ;
  private String LKR;
  private int LKS;
  private a LKT = null;
  private boolean vuQ = false;
  
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
    return this.LKP;
  }
  
  public MMNeat7extView getTextView()
  {
    return this.LKQ;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(164249);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/ExpandTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!this.vuQ)
    {
      this.vuQ = true;
      this.LKQ.setMaxLines(2147483647);
      this.LKP.animate().alpha(0.0F).setDuration(300L).setListener(new Animator.AnimatorListener()
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
    this.LKQ = new MMNeat7extView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.LKQ, localLayoutParams);
    this.LKP = new TextView(getContext());
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 85;
    addView(this.LKP, localLayoutParams);
    this.LKP.setOnClickListener(this);
    AppMethodBeat.o(164241);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164248);
    super.onMeasure(paramInt1, paramInt2);
    if (!this.vuQ)
    {
      com.tencent.neattextview.textview.layout.a locala = this.LKQ.kR(getMeasuredWidth(), getMeasuredHeight());
      if (locala != null)
      {
        if (locala.fXb() > this.LKS)
        {
          this.LKP.setVisibility(0);
          AppMethodBeat.o(164248);
          return;
        }
        this.LKP.setVisibility(8);
        AppMethodBeat.o(164248);
        return;
      }
      ae.e("MicroMsg.ExpandTextView", "layout is null!");
      this.LKP.setVisibility(8);
    }
    AppMethodBeat.o(164248);
  }
  
  public void setExpandIconText(String paramString)
  {
    this.LKR = paramString;
  }
  
  public void setExpandTextColor(int paramInt)
  {
    AppMethodBeat.i(164242);
    this.LKP.setTextColor(paramInt);
    AppMethodBeat.o(164242);
  }
  
  public void setExpandTextSize(float paramFloat)
  {
    AppMethodBeat.i(164244);
    this.LKP.setTextSize(0, paramFloat);
    AppMethodBeat.o(164244);
  }
  
  public void setLineSpacingExtra(int paramInt)
  {
    AppMethodBeat.i(164245);
    this.LKQ.setSpacingAdd(paramInt);
    AppMethodBeat.o(164245);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(164247);
    this.LKQ.setMaxLines(paramInt);
    AppMethodBeat.o(164247);
  }
  
  public void setOnExpandListener(a parama)
  {
    this.LKT = parama;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(164243);
    this.LKQ.setTextColor(paramInt);
    AppMethodBeat.o(164243);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(164246);
    this.LKQ.setTextSize(0, paramFloat);
    AppMethodBeat.o(164246);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.ExpandTextView
 * JD-Core Version:    0.7.0.1
 */