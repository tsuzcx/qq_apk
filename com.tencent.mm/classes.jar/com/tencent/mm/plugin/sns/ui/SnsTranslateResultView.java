package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.sdk.platformtools.bo;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int saz;
  private Drawable fHy;
  private TextView qzM;
  private int rWe;
  private float saA;
  private int saB;
  private TextView sax;
  private View say;
  
  static
  {
    AppMethodBeat.i(39629);
    saz = Color.parseColor("#19000000");
    AppMethodBeat.o(39629);
  }
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39623);
    this.rWe = -1;
    this.saA = -1.0F;
    this.saB = -1;
    LayoutInflater.from(getContext()).inflate(2130971040, this);
    this.sax = ((TextView)findViewById(2131828643));
    this.qzM = ((TextView)findViewById(2131828644));
    this.say = findViewById(2131828642);
    this.fHy = getResources().getDrawable(2130840429);
    this.fHy.setBounds(0, 0, (int)(this.qzM.getTextSize() * 0.8F), (int)(this.qzM.getTextSize() * 0.8F));
    this.fHy.setColorFilter(saz, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(39623);
  }
  
  private void cwu()
  {
    AppMethodBeat.i(39627);
    if ((this.saA == -1.0F) && (this.saB == -1)) {
      if (this.rWe == 2) {
        this.qzM.setTextSize(1, 14.0F * a.dr(getContext()));
      }
    }
    while (this.rWe == 2)
    {
      this.qzM.setTextColor(getContext().getResources().getColor(2131690508));
      AppMethodBeat.o(39627);
      return;
      if (this.rWe == 1)
      {
        this.qzM.setTextSize(1, 15.0F * a.dr(getContext()));
        continue;
        this.qzM.setTextSize(this.saB, this.saA);
      }
    }
    if (this.rWe == 1) {
      this.qzM.setTextColor(getContext().getResources().getColor(2131690510));
    }
    AppMethodBeat.o(39627);
  }
  
  public final void Fc(int paramInt)
  {
    AppMethodBeat.i(39624);
    this.qzM.setCompoundDrawables(this.fHy, null, null, null);
    this.qzM.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.qzM.setText(2131304028);
    com.tencent.mm.ui.tools.j.a(this.qzM, null);
    this.sax.setVisibility(4);
    this.rWe = paramInt;
    this.qzM.setTextSize(0, this.sax.getTextSize());
    this.qzM.setTextColor(getContext().getResources().getColor(2131690509));
    AppMethodBeat.o(39624);
  }
  
  @TargetApi(11)
  public final void a(aq.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(39628);
    this.rWe = paramInt;
    cwu();
    if (!bo.isNullOrNil(paramString1))
    {
      this.qzM.setText(paramString1);
      com.tencent.mm.pluginsdk.ui.d.j.k(this.qzM, 2);
      this.qzM.setCompoundDrawables(null, null, null, null);
      if ((paramBoolean) && (d.fv(11))) {
        com.tencent.mm.ui.tools.j.a(this.qzM, new SnsTranslateResultView.1(this, paramb));
      }
      if (bo.isNullOrNil(paramString2)) {
        break label121;
      }
      this.sax.setText(paramString2);
    }
    for (;;)
    {
      this.sax.setVisibility(0);
      AppMethodBeat.o(39628);
      return;
      this.qzM.setText(2131304026);
      break;
      label121:
      this.sax.setText(2131298335);
    }
  }
  
  public TextView getResultTextView()
  {
    return this.qzM;
  }
  
  public View getSplitlineView()
  {
    return this.say;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    AppMethodBeat.i(39626);
    this.qzM.setTextSize(0, paramFloat);
    this.saA = paramFloat;
    this.saB = 0;
    AppMethodBeat.o(39626);
  }
  
  public final void setResultTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(39625);
    this.qzM.setTextSize(1, paramFloat);
    this.saA = paramFloat;
    this.saB = 1;
    AppMethodBeat.o(39625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */