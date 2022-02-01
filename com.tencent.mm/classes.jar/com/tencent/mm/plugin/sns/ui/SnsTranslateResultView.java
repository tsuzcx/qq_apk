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
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.au.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.j;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int EOn;
  private int EJA;
  private TextView EOk;
  private TextView EOl;
  private View EOm;
  private float EOo;
  private int EOp;
  private Drawable jbs;
  
  static
  {
    AppMethodBeat.i(99450);
    EOn = Color.parseColor("#19000000");
    AppMethodBeat.o(99450);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99444);
    this.EJA = -1;
    this.EOo = -1.0F;
    this.EOp = -1;
    LayoutInflater.from(getContext()).inflate(2131496763, this);
    this.EOk = ((TextView)findViewById(2131308246));
    this.EOl = ((TextView)findViewById(2131308247));
    this.EOm = findViewById(2131309407);
    this.jbs = getResources().getDrawable(2131235020);
    this.jbs.setBounds(0, 0, (int)(this.EOl.getTextSize() * 0.8F), (int)(this.EOl.getTextSize() * 0.8F));
    this.jbs.setColorFilter(EOn, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(99444);
  }
  
  private void fjv()
  {
    AppMethodBeat.i(99448);
    if ((this.EOo == -1.0F) && (this.EOp == -1)) {
      if (this.EJA == 2) {
        this.EOl.setTextSize(1, 14.0F * a.ez(getContext()));
      }
    }
    while (this.EJA == 2)
    {
      this.EOl.setTextColor(getContext().getResources().getColor(2131101151));
      AppMethodBeat.o(99448);
      return;
      if (this.EJA == 1)
      {
        this.EOl.setTextSize(1, 15.0F * a.ez(getContext()));
        continue;
        this.EOl.setTextSize(this.EOp, this.EOo);
      }
    }
    if (this.EJA == 1) {
      this.EOl.setTextColor(getContext().getResources().getColor(2131101153));
    }
    AppMethodBeat.o(99448);
  }
  
  public final void ZW(int paramInt)
  {
    AppMethodBeat.i(99445);
    this.EOl.setCompoundDrawables(this.jbs, null, null, null);
    this.EOl.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.EOl.setText(2131766284);
    j.a(this.EOl, null);
    this.EOk.setVisibility(4);
    this.EJA = paramInt;
    this.EOl.setTextSize(0, this.EOk.getTextSize());
    this.EOl.setTextColor(getContext().getResources().getColor(2131101152));
    AppMethodBeat.o(99445);
  }
  
  @TargetApi(11)
  public final void a(final au.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(99449);
    this.EJA = paramInt;
    fjv();
    if (!Util.isNullOrNil(paramString1))
    {
      this.EOl.setText(paramString1);
      l.p(this.EOl, 2);
      this.EOl.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.oD(11))) {
        j.a(this.EOl, new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(99443);
            if (paramb != null) {
              au.a(paramb);
            }
            AppMethodBeat.o(99443);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
      }
      if (Util.isNullOrNil(paramString2)) {
        break label121;
      }
      this.EOk.setText(paramString2);
    }
    for (;;)
    {
      this.EOk.setVisibility(0);
      AppMethodBeat.o(99449);
      return;
      this.EOl.setText(2131766282);
      break;
      label121:
      this.EOk.setText(2131757540);
    }
  }
  
  public TextView getResultTextView()
  {
    return this.EOl;
  }
  
  public View getSplitlineView()
  {
    return this.EOm;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(99447);
    this.EOl.setTextSize(0, paramFloat);
    this.EOo = paramFloat;
    this.EOp = 0;
    AppMethodBeat.o(99447);
  }
  
  public final void setResultTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(99446);
    this.EOl.setTextSize(1, paramFloat);
    this.EOo = paramFloat;
    this.EOp = 1;
    AppMethodBeat.o(99446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */