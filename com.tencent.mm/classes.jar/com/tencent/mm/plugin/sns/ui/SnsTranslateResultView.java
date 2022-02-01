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
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.at.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.k;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int Lcj;
  private int KXB;
  private TextView Lcg;
  private TextView Lch;
  private View Lci;
  private float Lck;
  private int Lcl;
  private Drawable lRR;
  
  static
  {
    AppMethodBeat.i(99450);
    Lcj = Color.parseColor("#19000000");
    AppMethodBeat.o(99450);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99444);
    this.KXB = -1;
    this.Lck = -1.0F;
    this.Lcl = -1;
    LayoutInflater.from(getContext()).inflate(i.g.translate_result_layout, this);
    this.Lcg = ((TextView)findViewById(i.f.sns_translate_brand_tv));
    this.Lch = ((TextView)findViewById(i.f.sns_translate_result_tv));
    this.Lci = findViewById(i.f.translate_split);
    this.lRR = getResources().getDrawable(i.e.sns_translate_loading_icon);
    this.lRR.setBounds(0, 0, (int)(this.Lch.getTextSize() * 0.8F), (int)(this.Lch.getTextSize() * 0.8F));
    this.lRR.setColorFilter(Lcj, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(99444);
  }
  
  private void fXI()
  {
    AppMethodBeat.i(99448);
    if ((this.Lck == -1.0F) && (this.Lcl == -1)) {
      if (this.KXB == 2) {
        this.Lch.setTextSize(1, 14.0F * a.ez(getContext()));
      }
    }
    while (this.KXB == 2)
    {
      this.Lch.setTextColor(getContext().getResources().getColor(i.c.sns_translate_comment_result_color));
      AppMethodBeat.o(99448);
      return;
      if (this.KXB == 1)
      {
        this.Lch.setTextSize(1, 15.0F * a.ez(getContext()));
        continue;
        this.Lch.setTextSize(this.Lcl, this.Lck);
      }
    }
    if (this.KXB == 1) {
      this.Lch.setTextColor(getContext().getResources().getColor(i.c.sns_translate_post_result_color));
    }
    AppMethodBeat.o(99448);
  }
  
  @TargetApi(11)
  public final void a(final at.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(99449);
    this.KXB = paramInt;
    fXI();
    if (!Util.isNullOrNil(paramString1))
    {
      this.Lch.setText(paramString1);
      l.q(this.Lch, 2);
      this.Lch.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.qV(11))) {
        k.a(this.Lch, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(99443);
            if (paramb != null) {
              at.a(paramb);
            }
            AppMethodBeat.o(99443);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
      }
      if (Util.isNullOrNil(paramString2)) {
        break label122;
      }
      this.Lcg.setText(paramString2);
    }
    for (;;)
    {
      this.Lcg.setVisibility(0);
      AppMethodBeat.o(99449);
      return;
      this.Lch.setText(i.j.sns_translate_failed);
      break;
      label122:
      this.Lcg.setText(i.j.chatting_translate_status_got);
    }
  }
  
  public final void aht(int paramInt)
  {
    AppMethodBeat.i(99445);
    this.Lch.setCompoundDrawables(this.lRR, null, null, null);
    this.Lch.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.Lch.setText(i.j.sns_translating);
    k.a(this.Lch, null);
    this.Lcg.setVisibility(4);
    this.KXB = paramInt;
    this.Lch.setTextSize(0, this.Lcg.getTextSize());
    this.Lch.setTextColor(getContext().getResources().getColor(i.c.sns_translate_loading_text_color));
    AppMethodBeat.o(99445);
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(99446);
    this.Lch.setTextSize(1, paramFloat);
    this.Lck = paramFloat;
    this.Lcl = 1;
    AppMethodBeat.o(99446);
  }
  
  public TextView getResultTextView()
  {
    return this.Lch;
  }
  
  public View getSplitlineView()
  {
    return this.Lci;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(99447);
    this.Lch.setTextSize(0, paramFloat);
    this.Lck = paramFloat;
    this.Lcl = 0;
    AppMethodBeat.o(99447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */