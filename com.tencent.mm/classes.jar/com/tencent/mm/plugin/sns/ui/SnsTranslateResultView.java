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
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.j;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int Anx;
  private int AiT;
  private TextView Anu;
  private TextView Anv;
  private View Anw;
  private float Any;
  private int Anz;
  private Drawable idF;
  
  static
  {
    AppMethodBeat.i(99450);
    Anx = Color.parseColor("#19000000");
    AppMethodBeat.o(99450);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99444);
    this.AiT = -1;
    this.Any = -1.0F;
    this.Anz = -1;
    LayoutInflater.from(getContext()).inflate(2131495805, this);
    this.Anu = ((TextView)findViewById(2131305089));
    this.Anv = ((TextView)findViewById(2131305090));
    this.Anw = findViewById(2131306076);
    this.idF = getResources().getDrawable(2131234151);
    this.idF.setBounds(0, 0, (int)(this.Anv.getTextSize() * 0.8F), (int)(this.Anv.getTextSize() * 0.8F));
    this.idF.setColorFilter(Anx, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(99444);
  }
  
  private void edm()
  {
    AppMethodBeat.i(99448);
    if ((this.Any == -1.0F) && (this.Anz == -1)) {
      if (this.AiT == 2) {
        this.Anv.setTextSize(1, 14.0F * a.eb(getContext()));
      }
    }
    while (this.AiT == 2)
    {
      this.Anv.setTextColor(getContext().getResources().getColor(2131100933));
      AppMethodBeat.o(99448);
      return;
      if (this.AiT == 1)
      {
        this.Anv.setTextSize(1, 15.0F * a.eb(getContext()));
        continue;
        this.Anv.setTextSize(this.Anz, this.Any);
      }
    }
    if (this.AiT == 1) {
      this.Anv.setTextColor(getContext().getResources().getColor(2131100935));
    }
    AppMethodBeat.o(99448);
  }
  
  public final void Rt(int paramInt)
  {
    AppMethodBeat.i(99445);
    this.Anv.setCompoundDrawables(this.idF, null, null, null);
    this.Anv.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.Anv.setText(2131764045);
    j.a(this.Anv, null);
    this.Anu.setVisibility(4);
    this.AiT = paramInt;
    this.Anv.setTextSize(0, this.Anu.getTextSize());
    this.Anv.setTextColor(getContext().getResources().getColor(2131100934));
    AppMethodBeat.o(99445);
  }
  
  @TargetApi(11)
  public final void a(final ar.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(99449);
    this.AiT = paramInt;
    edm();
    if (!bt.isNullOrNil(paramString1))
    {
      this.Anv.setText(paramString1);
      k.n(this.Anv, 2);
      this.Anv.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.ly(11))) {
        j.a(this.Anv, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(99443);
            if (paramb != null) {
              ar.a(paramb);
            }
            AppMethodBeat.o(99443);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
      }
      if (bt.isNullOrNil(paramString2)) {
        break label121;
      }
      this.Anu.setText(paramString2);
    }
    for (;;)
    {
      this.Anu.setVisibility(0);
      AppMethodBeat.o(99449);
      return;
      this.Anv.setText(2131764043);
      break;
      label121:
      this.Anu.setText(2131757326);
    }
  }
  
  public TextView getResultTextView()
  {
    return this.Anv;
  }
  
  public View getSplitlineView()
  {
    return this.Anw;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(99447);
    this.Anv.setTextSize(0, paramFloat);
    this.Any = paramFloat;
    this.Anz = 0;
    AppMethodBeat.o(99447);
  }
  
  public final void setResultTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(99446);
    this.Anv.setTextSize(1, paramFloat);
    this.Any = paramFloat;
    this.Anz = 1;
    AppMethodBeat.o(99446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */