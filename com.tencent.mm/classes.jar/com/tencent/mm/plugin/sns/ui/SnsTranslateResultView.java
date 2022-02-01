package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.k;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int RCn;
  private TextView RCk;
  private TextView RCl;
  private View RCm;
  private float RCo;
  private int RCp;
  private int RxC;
  private Drawable oKD;
  
  static
  {
    AppMethodBeat.i(99450);
    RCn = Color.parseColor("#19000000");
    AppMethodBeat.o(99450);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99444);
    this.RxC = -1;
    this.RCo = -1.0F;
    this.RCp = -1;
    LayoutInflater.from(getContext()).inflate(b.g.translate_result_layout, this);
    this.RCk = ((TextView)findViewById(b.f.sns_translate_brand_tv));
    this.RCl = ((TextView)findViewById(b.f.sns_translate_result_tv));
    this.RCm = findViewById(b.f.translate_split);
    this.oKD = getResources().getDrawable(b.e.sns_translate_loading_icon);
    this.oKD.setBounds(0, 0, (int)(this.RCl.getTextSize() * 0.8F), (int)(this.RCl.getTextSize() * 0.8F));
    this.oKD.setColorFilter(RCn, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(99444);
  }
  
  private void hqc()
  {
    AppMethodBeat.i(99448);
    if ((this.RCo == -1.0F) && (this.RCp == -1)) {
      if (this.RxC == 2) {
        this.RCl.setTextSize(1, 14.0F * a.getScaleSize(getContext()));
      }
    }
    while (this.RxC == 2)
    {
      this.RCl.setTextColor(getContext().getResources().getColor(b.c.sns_translate_comment_result_color));
      AppMethodBeat.o(99448);
      return;
      if (this.RxC == 1)
      {
        this.RCl.setTextSize(1, 15.0F * a.getScaleSize(getContext()));
        continue;
        this.RCl.setTextSize(this.RCp, this.RCo);
      }
    }
    if (this.RxC == 1) {
      this.RCl.setTextColor(getContext().getResources().getColor(b.c.sns_translate_post_result_color));
    }
    AppMethodBeat.o(99448);
  }
  
  public final void a(final av.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(99449);
    this.RxC = paramInt;
    hqc();
    if (!Util.isNullOrNil(paramString1))
    {
      this.RCl.setText(paramString1);
      p.t(this.RCl, 2);
      this.RCl.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.rb(11))) {
        k.a(this.RCl, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(99443);
            if (paramb != null) {
              av.a(paramb);
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
      this.RCk.setText(paramString2);
    }
    for (;;)
    {
      this.RCk.setVisibility(0);
      AppMethodBeat.o(99449);
      return;
      this.RCl.setText(b.j.sns_translate_failed);
      break;
      label122:
      this.RCk.setText(b.j.chatting_translate_status_got);
    }
  }
  
  public final void amo(int paramInt)
  {
    AppMethodBeat.i(99445);
    this.RCl.setCompoundDrawables(this.oKD, null, null, null);
    this.RCl.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.RCl.setText(b.j.sns_translating);
    k.a(this.RCl, null);
    this.RCk.setVisibility(4);
    this.RxC = paramInt;
    this.RCl.setTextSize(0, this.RCk.getTextSize());
    this.RCl.setTextColor(getContext().getResources().getColor(b.c.sns_translate_loading_text_color));
    AppMethodBeat.o(99445);
  }
  
  public final void dr(float paramFloat)
  {
    AppMethodBeat.i(99446);
    this.RCl.setTextSize(1, paramFloat);
    this.RCo = paramFloat;
    this.RCp = 1;
    AppMethodBeat.o(99446);
  }
  
  public TextView getResultTextView()
  {
    return this.RCl;
  }
  
  public View getSplitlineView()
  {
    return this.RCm;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(99447);
    this.RCl.setTextSize(0, paramFloat);
    this.RCo = paramFloat;
    this.RCp = 0;
    AppMethodBeat.o(99447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */