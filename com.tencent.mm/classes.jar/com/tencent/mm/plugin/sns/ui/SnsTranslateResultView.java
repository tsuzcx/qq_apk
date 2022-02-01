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
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.j;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int xIX;
  private Drawable hkh;
  private int xEF;
  private TextView xIU;
  private TextView xIV;
  private View xIW;
  private float xIY;
  private int xIZ;
  
  static
  {
    AppMethodBeat.i(99450);
    xIX = Color.parseColor("#19000000");
    AppMethodBeat.o(99450);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99444);
    this.xEF = -1;
    this.xIY = -1.0F;
    this.xIZ = -1;
    LayoutInflater.from(getContext()).inflate(2131495805, this);
    this.xIU = ((TextView)findViewById(2131305089));
    this.xIV = ((TextView)findViewById(2131305090));
    this.xIW = findViewById(2131306076);
    this.hkh = getResources().getDrawable(2131234151);
    this.hkh.setBounds(0, 0, (int)(this.xIV.getTextSize() * 0.8F), (int)(this.xIV.getTextSize() * 0.8F));
    this.hkh.setColorFilter(xIX, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(99444);
  }
  
  private void dCx()
  {
    AppMethodBeat.i(99448);
    if ((this.xIY == -1.0F) && (this.xIZ == -1)) {
      if (this.xEF == 2) {
        this.xIV.setTextSize(1, 14.0F * a.dT(getContext()));
      }
    }
    while (this.xEF == 2)
    {
      this.xIV.setTextColor(getContext().getResources().getColor(2131100933));
      AppMethodBeat.o(99448);
      return;
      if (this.xEF == 1)
      {
        this.xIV.setTextSize(1, 15.0F * a.dT(getContext()));
        continue;
        this.xIV.setTextSize(this.xIZ, this.xIY);
      }
    }
    if (this.xEF == 1) {
      this.xIV.setTextColor(getContext().getResources().getColor(2131100935));
    }
    AppMethodBeat.o(99448);
  }
  
  public final void NG(int paramInt)
  {
    AppMethodBeat.i(99445);
    this.xIV.setCompoundDrawables(this.hkh, null, null, null);
    this.xIV.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.xIV.setText(2131764045);
    j.a(this.xIV, null);
    this.xIU.setVisibility(4);
    this.xEF = paramInt;
    this.xIV.setTextSize(0, this.xIU.getTextSize());
    this.xIV.setTextColor(getContext().getResources().getColor(2131100934));
    AppMethodBeat.o(99445);
  }
  
  @TargetApi(11)
  public final void a(final ap.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(99449);
    this.xEF = paramInt;
    dCx();
    if (!bt.isNullOrNil(paramString1))
    {
      this.xIV.setText(paramString1);
      k.m(this.xIV, 2);
      this.xIV.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.lf(11))) {
        j.a(this.xIV, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(99443);
            if (paramb != null) {
              ap.a(paramb);
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
      this.xIU.setText(paramString2);
    }
    for (;;)
    {
      this.xIU.setVisibility(0);
      AppMethodBeat.o(99449);
      return;
      this.xIV.setText(2131764043);
      break;
      label121:
      this.xIU.setText(2131757326);
    }
  }
  
  public TextView getResultTextView()
  {
    return this.xIV;
  }
  
  public View getSplitlineView()
  {
    return this.xIW;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(99447);
    this.xIV.setTextSize(0, paramFloat);
    this.xIY = paramFloat;
    this.xIZ = 0;
    AppMethodBeat.o(99447);
  }
  
  public final void setResultTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(99446);
    this.xIV.setTextSize(1, paramFloat);
    this.xIY = paramFloat;
    this.xIZ = 1;
    AppMethodBeat.o(99446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */