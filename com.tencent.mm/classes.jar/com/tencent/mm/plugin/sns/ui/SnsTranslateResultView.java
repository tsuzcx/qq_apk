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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.tools.h;

public class SnsTranslateResultView
  extends LinearLayout
{
  private static final int phS = Color.parseColor("#19000000");
  private Drawable erx;
  private TextView nMf;
  private TextView phQ;
  private View phR;
  private int phT = -1;
  private float phU = -1.0F;
  private int phV = -1;
  
  public SnsTranslateResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(i.g.translate_result_layout, this);
    this.phQ = ((TextView)findViewById(i.f.sns_translate_brand_tv));
    this.nMf = ((TextView)findViewById(i.f.sns_translate_result_tv));
    this.phR = findViewById(i.f.translate_split);
    this.erx = getResources().getDrawable(i.e.sns_translate_loading_icon);
    this.erx.setBounds(0, 0, (int)(this.nMf.getTextSize() * 0.8F), (int)(this.nMf.getTextSize() * 0.8F));
    this.erx.setColorFilter(phS, PorterDuff.Mode.SRC_IN);
  }
  
  @TargetApi(11)
  public final void a(ap.b paramb, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.phT = paramInt;
    if ((this.phU == -1.0F) && (this.phV == -1)) {
      if (this.phT == 2)
      {
        this.nMf.setTextSize(1, 14.0F * a.cJ(getContext()));
        if (this.phT != 2) {
          break label214;
        }
        this.nMf.setTextColor(getContext().getResources().getColor(i.c.sns_translate_comment_result_color));
        label77:
        if (bk.bl(paramString1)) {
          break label245;
        }
        this.nMf.setText(paramString1);
        j.h(this.nMf, 2);
        label101:
        this.nMf.setCompoundDrawables(null, null, null, null);
        if ((paramBoolean) && (d.gF(11))) {
          h.a(this.nMf, new SnsTranslateResultView.1(this, paramb));
        }
        if (bk.bl(paramString2)) {
          break label258;
        }
        this.phQ.setText(paramString2);
      }
    }
    for (;;)
    {
      this.phQ.setVisibility(0);
      return;
      if (this.phT != 1) {
        break;
      }
      this.nMf.setTextSize(1, 15.0F * a.cJ(getContext()));
      break;
      this.nMf.setTextSize(this.phV, this.phU);
      break;
      label214:
      if (this.phT != 1) {
        break label77;
      }
      this.nMf.setTextColor(getContext().getResources().getColor(i.c.sns_translate_post_result_color));
      break label77;
      label245:
      this.nMf.setText(i.j.sns_translate_failed);
      break label101;
      label258:
      this.phQ.setText(i.j.chatting_translate_status_got);
    }
  }
  
  public TextView getResultTextView()
  {
    return this.nMf;
  }
  
  public View getSplitlineView()
  {
    return this.phR;
  }
  
  public void setResultTextSize(float paramFloat)
  {
    this.nMf.setTextSize(0, paramFloat);
    this.phU = paramFloat;
    this.phV = 0;
  }
  
  public final void setResultTextSize$255e752(float paramFloat)
  {
    this.nMf.setTextSize(1, paramFloat);
    this.phU = paramFloat;
    this.phV = 1;
  }
  
  public final void yV(int paramInt)
  {
    this.nMf.setCompoundDrawables(this.erx, null, null, null);
    this.nMf.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
    this.nMf.setText(i.j.sns_translating);
    h.a(this.nMf, null);
    this.phQ.setVisibility(4);
    this.phT = paramInt;
    this.nMf.setTextSize(0, this.phQ.getTextSize());
    this.nMf.setTextColor(getContext().getResources().getColor(i.c.sns_translate_loading_text_color));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView
 * JD-Core Version:    0.7.0.1
 */