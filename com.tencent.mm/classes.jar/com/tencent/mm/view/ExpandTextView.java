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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;

public class ExpandTextView
  extends FrameLayout
  implements View.OnClickListener
{
  private TextView HUu;
  private MMNeat7extView HUv;
  private String HUw;
  private int HUx;
  private a HUy = null;
  private boolean sXO = false;
  
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
    return this.HUu;
  }
  
  public MMNeat7extView getTextView()
  {
    return this.HUv;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(164249);
    if (!this.sXO)
    {
      this.sXO = true;
      this.HUv.setMaxLines(2147483647);
      this.HUu.animate().alpha(0.0F).setDuration(300L).setListener(new Animator.AnimatorListener()
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
    AppMethodBeat.o(164249);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(164241);
    super.onFinishInflate();
    this.HUv = new MMNeat7extView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.HUv, localLayoutParams);
    this.HUu = new TextView(getContext());
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 85;
    addView(this.HUu, localLayoutParams);
    this.HUu.setOnClickListener(this);
    AppMethodBeat.o(164241);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164248);
    super.onMeasure(paramInt1, paramInt2);
    if (!this.sXO)
    {
      a locala = this.HUv.ki(getMeasuredWidth(), getMeasuredHeight());
      if (locala != null)
      {
        if (locala.fkV() > this.HUx)
        {
          this.HUu.setVisibility(0);
          AppMethodBeat.o(164248);
          return;
        }
        this.HUu.setVisibility(8);
        AppMethodBeat.o(164248);
        return;
      }
      ad.e("MicroMsg.ExpandTextView", "layout is null!");
      this.HUu.setVisibility(8);
    }
    AppMethodBeat.o(164248);
  }
  
  public void setExpandIconText(String paramString)
  {
    this.HUw = paramString;
  }
  
  public void setExpandTextColor(int paramInt)
  {
    AppMethodBeat.i(164242);
    this.HUu.setTextColor(paramInt);
    AppMethodBeat.o(164242);
  }
  
  public void setExpandTextSize(float paramFloat)
  {
    AppMethodBeat.i(164244);
    this.HUu.setTextSize(0, paramFloat);
    AppMethodBeat.o(164244);
  }
  
  public void setLineSpacingExtra(int paramInt)
  {
    AppMethodBeat.i(164245);
    this.HUv.setSpacingAdd(paramInt);
    AppMethodBeat.o(164245);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(164247);
    this.HUv.setMaxLines(paramInt);
    AppMethodBeat.o(164247);
  }
  
  public void setOnExpandListener(a parama)
  {
    this.HUy = parama;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(164243);
    this.HUv.setTextColor(paramInt);
    AppMethodBeat.o(164243);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(164246);
    this.HUv.setTextSize(0, paramFloat);
    AppMethodBeat.o(164246);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.ExpandTextView
 * JD-Core Version:    0.7.0.1
 */