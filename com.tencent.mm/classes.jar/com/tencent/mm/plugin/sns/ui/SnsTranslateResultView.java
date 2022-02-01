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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.as.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.j;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int AEK;
  private int AAe;
  private TextView AEH;
  private TextView AEI;
  private View AEJ;
  private float AEL;
  private int AEM;
  private Drawable igx;
  
  static
  {
    AppMethodBeat.i(99450);
    AEK = Color.parseColor("#19000000");
    AppMethodBeat.o(99450);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99444);
    this.AAe = -1;
    this.AEL = -1.0F;
    this.AEM = -1;
    LayoutInflater.from(getContext()).inflate(2131495805, this);
    this.AEH = ((TextView)findViewById(2131305089));
    this.AEI = ((TextView)findViewById(2131305090));
    this.AEJ = findViewById(2131306076);
    this.igx = getResources().getDrawable(2131234151);
    this.igx.setBounds(0, 0, (int)(this.AEI.getTextSize() * 0.8F), (int)(this.AEI.getTextSize() * 0.8F));
    this.igx.setColorFilter(AEK, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(99444);
  }
  
  private void egT()
  {
    AppMethodBeat.i(99448);
    if ((this.AEL == -1.0F) && (this.AEM == -1)) {
      if (this.AAe == 2) {
        this.AEI.setTextSize(1, 14.0F * a.ef(getContext()));
      }
    }
    while (this.AAe == 2)
    {
      this.AEI.setTextColor(getContext().getResources().getColor(2131100933));
      AppMethodBeat.o(99448);
      return;
      if (this.AAe == 1)
      {
        this.AEI.setTextSize(1, 15.0F * a.ef(getContext()));
        continue;
        this.AEI.setTextSize(this.AEM, this.AEL);
      }
    }
    if (this.AAe == 1) {
      this.AEI.setTextColor(getContext().getResources().getColor(2131100935));
    }
    AppMethodBeat.o(99448);
  }
  
  public final void Sa(int paramInt)
  {
    AppMethodBeat.i(99445);
    this.AEI.setCompoundDrawables(this.igx, null, null, null);
    this.AEI.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.AEI.setText(2131764045);
    j.a(this.AEI, null);
    this.AEH.setVisibility(4);
    this.AAe = paramInt;
    this.AEI.setTextSize(0, this.AEH.getTextSize());
    this.AEI.setTextColor(getContext().getResources().getColor(2131100934));
    AppMethodBeat.o(99445);
  }
  
  @TargetApi(11)
  public final void a(final as.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(99449);
    this.AAe = paramInt;
    egT();
    if (!bu.isNullOrNil(paramString1))
    {
      this.AEI.setText(paramString1);
      k.o(this.AEI, 2);
      this.AEI.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.lA(11))) {
        j.a(this.AEI, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(99443);
            if (paramb != null) {
              as.a(paramb);
            }
            AppMethodBeat.o(99443);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
      }
      if (bu.isNullOrNil(paramString2)) {
        break label121;
      }
      this.AEH.setText(paramString2);
    }
    for (;;)
    {
      this.AEH.setVisibility(0);
      AppMethodBeat.o(99449);
      return;
      this.AEI.setText(2131764043);
      break;
      label121:
      this.AEH.setText(2131757326);
    }
  }
  
  public TextView getResultTextView()
  {
    return this.AEI;
  }
  
  public View getSplitlineView()
  {
    return this.AEJ;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(99447);
    this.AEI.setTextSize(0, paramFloat);
    this.AEL = paramFloat;
    this.AEM = 0;
    AppMethodBeat.o(99447);
  }
  
  public final void setResultTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(99446);
    this.AEI.setTextSize(1, paramFloat);
    this.AEL = paramFloat;
    this.AEM = 1;
    AppMethodBeat.o(99446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */