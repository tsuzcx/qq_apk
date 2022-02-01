package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.j;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int yVN;
  private Drawable hKK;
  private int yRt;
  private TextView yVK;
  private TextView yVL;
  private View yVM;
  private float yVO;
  private int yVP;
  
  static
  {
    AppMethodBeat.i(99450);
    yVN = Color.parseColor("#19000000");
    AppMethodBeat.o(99450);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99444);
    this.yRt = -1;
    this.yVO = -1.0F;
    this.yVP = -1;
    LayoutInflater.from(getContext()).inflate(2131495805, this);
    this.yVK = ((TextView)findViewById(2131305089));
    this.yVL = ((TextView)findViewById(2131305090));
    this.yVM = findViewById(2131306076);
    this.hKK = getResources().getDrawable(2131234151);
    this.hKK.setBounds(0, 0, (int)(this.yVL.getTextSize() * 0.8F), (int)(this.yVL.getTextSize() * 0.8F));
    this.hKK.setColorFilter(yVN, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(99444);
  }
  
  private void dQU()
  {
    AppMethodBeat.i(99448);
    if ((this.yVO == -1.0F) && (this.yVP == -1)) {
      if (this.yRt == 2) {
        this.yVL.setTextSize(1, 14.0F * a.eb(getContext()));
      }
    }
    while (this.yRt == 2)
    {
      this.yVL.setTextColor(getContext().getResources().getColor(2131100933));
      AppMethodBeat.o(99448);
      return;
      if (this.yRt == 1)
      {
        this.yVL.setTextSize(1, 15.0F * a.eb(getContext()));
        continue;
        this.yVL.setTextSize(this.yVP, this.yVO);
      }
    }
    if (this.yRt == 1) {
      this.yVL.setTextColor(getContext().getResources().getColor(2131100935));
    }
    AppMethodBeat.o(99448);
  }
  
  public final void PK(int paramInt)
  {
    AppMethodBeat.i(99445);
    this.yVL.setCompoundDrawables(this.hKK, null, null, null);
    this.yVL.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.yVL.setText(2131764045);
    j.a(this.yVL, null);
    this.yVK.setVisibility(4);
    this.yRt = paramInt;
    this.yVL.setTextSize(0, this.yVK.getTextSize());
    this.yVL.setTextColor(getContext().getResources().getColor(2131100934));
    AppMethodBeat.o(99445);
  }
  
  @TargetApi(11)
  public final void a(final aq.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(99449);
    this.yRt = paramInt;
    dQU();
    if (!bs.isNullOrNil(paramString1))
    {
      this.yVL.setText(paramString1);
      k.m(this.yVL, 2);
      this.yVL.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.kZ(11))) {
        j.a(this.yVL, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(99443);
            if (paramb != null) {
              aq.a(paramb);
            }
            AppMethodBeat.o(99443);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
      }
      if (bs.isNullOrNil(paramString2)) {
        break label121;
      }
      this.yVK.setText(paramString2);
    }
    for (;;)
    {
      this.yVK.setVisibility(0);
      AppMethodBeat.o(99449);
      return;
      this.yVL.setText(2131764043);
      break;
      label121:
      this.yVK.setText(2131757326);
    }
  }
  
  public TextView getResultTextView()
  {
    return this.yVL;
  }
  
  public View getSplitlineView()
  {
    return this.yVM;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(99447);
    this.yVL.setTextSize(0, paramFloat);
    this.yVO = paramFloat;
    this.yVP = 0;
    AppMethodBeat.o(99447);
  }
  
  public final void setResultTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(99446);
    this.yVL.setTextSize(1, paramFloat);
    this.yVO = paramFloat;
    this.yVP = 1;
    AppMethodBeat.o(99446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */