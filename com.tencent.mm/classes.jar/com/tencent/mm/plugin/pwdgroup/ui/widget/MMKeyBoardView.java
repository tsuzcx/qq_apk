package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private ColorStateList eR;
  private Context mContext;
  private float nEC;
  private MMKeyBoardView.a pGD;
  private Button pGW;
  private Button pGX;
  private Button pGY;
  private Button pGZ;
  private Button pHa;
  private Button pHb;
  private Button pHc;
  private Button pHd;
  private Button pHe;
  private Button pHf;
  private ImageButton pHg;
  private View pHh;
  private View pHi;
  private View pHj;
  private View pHk;
  private View pHl;
  private View pHm;
  private boolean pHn;
  private int pHo;
  private int pHp;
  private int pHq;
  private int pHr;
  private int pHs;
  private int pHt;
  private int pHu;
  private int pHv;
  private int pHw;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.pHn = true;
    this.mContext = paramContext;
    this.pHo = getResources().getDimensionPixelSize(2131427368);
    this.pHp = getResources().getDimensionPixelSize(2131427369);
    this.nEC = getResources().getDimensionPixelSize(2131427370);
    this.eR = getResources().getColorStateList(2131690758);
    this.pHq = getResources().getColor(2131690197);
    this.pGW = new Button(this.mContext);
    this.pGX = new Button(this.mContext);
    this.pGY = new Button(this.mContext);
    this.pGZ = new Button(this.mContext);
    this.pHa = new Button(this.mContext);
    this.pHb = new Button(this.mContext);
    this.pHc = new Button(this.mContext);
    this.pHd = new Button(this.mContext);
    this.pHe = new Button(this.mContext);
    this.pHf = new Button(this.mContext);
    this.pHg = new ImageButton(this.mContext);
    this.pHh = new View(this.mContext);
    this.pHh = new View(this.mContext);
    this.pHi = new View(this.mContext);
    this.pHj = new View(this.mContext);
    this.pHk = new View(this.mContext);
    this.pHl = new View(this.mContext);
    this.pHm = new View(this.mContext);
    this.pGW.setBackgroundResource(2130839194);
    this.pGX.setBackgroundResource(2130839194);
    this.pGY.setBackgroundResource(2130839194);
    this.pGZ.setBackgroundResource(2130839194);
    this.pHa.setBackgroundResource(2130839194);
    this.pHb.setBackgroundResource(2130839194);
    this.pHc.setBackgroundResource(2130839194);
    this.pHd.setBackgroundResource(2130839194);
    this.pHe.setBackgroundResource(2130839194);
    this.pHb.setBackgroundResource(2130839194);
    this.pHf.setBackgroundResource(2130839194);
    this.pHg.setBackgroundResource(2130839194);
    this.pHg.setImageResource(2130839195);
    this.pGW.setText("0");
    this.pGX.setText("1");
    this.pGY.setText("2");
    this.pGZ.setText("3");
    this.pHa.setText("4");
    this.pHb.setText("5");
    this.pHc.setText("6");
    this.pHd.setText("7");
    this.pHe.setText("8");
    this.pHf.setText("9");
    this.pGW.setGravity(17);
    this.pGX.setGravity(17);
    this.pGY.setGravity(17);
    this.pGZ.setGravity(17);
    this.pHa.setGravity(17);
    this.pHb.setGravity(17);
    this.pHc.setGravity(17);
    this.pHd.setGravity(17);
    this.pHe.setGravity(17);
    this.pHf.setGravity(17);
    this.pGW.setTextSize(0, this.nEC);
    this.pGX.setTextSize(0, this.nEC);
    this.pGY.setTextSize(0, this.nEC);
    this.pGZ.setTextSize(0, this.nEC);
    this.pHa.setTextSize(0, this.nEC);
    this.pHb.setTextSize(0, this.nEC);
    this.pHc.setTextSize(0, this.nEC);
    this.pHd.setTextSize(0, this.nEC);
    this.pHe.setTextSize(0, this.nEC);
    this.pHf.setTextSize(0, this.nEC);
    this.pGW.setTextColor(this.eR);
    this.pGX.setTextColor(this.eR);
    this.pGY.setTextColor(this.eR);
    this.pGZ.setTextColor(this.eR);
    this.pHa.setTextColor(this.eR);
    this.pHb.setTextColor(this.eR);
    this.pHc.setTextColor(this.eR);
    this.pHd.setTextColor(this.eR);
    this.pHe.setTextColor(this.eR);
    this.pHf.setTextColor(this.eR);
    this.pGW.setOnClickListener(this);
    this.pGX.setOnClickListener(this);
    this.pGY.setOnClickListener(this);
    this.pGZ.setOnClickListener(this);
    this.pHa.setOnClickListener(this);
    this.pHb.setOnClickListener(this);
    this.pHc.setOnClickListener(this);
    this.pHd.setOnClickListener(this);
    this.pHe.setOnClickListener(this);
    this.pHf.setOnClickListener(this);
    this.pHg.setOnClickListener(this);
    this.pHg.setOnLongClickListener(this);
    this.pHh.setBackgroundColor(this.pHq);
    this.pHh.setBackgroundColor(this.pHq);
    this.pHi.setBackgroundColor(this.pHq);
    this.pHj.setBackgroundColor(this.pHq);
    this.pHk.setBackgroundColor(this.pHq);
    this.pHl.setBackgroundColor(this.pHq);
    this.pHm.setBackgroundColor(this.pHq);
    addView(this.pGW);
    addView(this.pGX);
    addView(this.pGY);
    addView(this.pGZ);
    addView(this.pHa);
    addView(this.pHb);
    addView(this.pHc);
    addView(this.pHd);
    addView(this.pHe);
    addView(this.pHf);
    addView(this.pHg);
    addView(this.pHh);
    addView(this.pHi);
    addView(this.pHj);
    addView(this.pHk);
    addView(this.pHl);
    addView(this.pHm);
    post(new MMKeyBoardView.1(this));
    AppMethodBeat.o(24046);
  }
  
  private void input(String paramString)
  {
    AppMethodBeat.i(24052);
    if ((this.pGD != null) && (this.pHn)) {
      this.pGD.input(paramString);
    }
    AppMethodBeat.o(24052);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(24049);
    if (!this.pHn)
    {
      ab.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pGW)
    {
      input("0");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pGX)
    {
      input("1");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pGY)
    {
      input("2");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pGZ)
    {
      input("3");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pHa)
    {
      input("4");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pHb)
    {
      input("5");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pHc)
    {
      input("6");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pHd)
    {
      input("7");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pHe)
    {
      input("8");
      AppMethodBeat.o(24049);
      return;
    }
    if (paramView == this.pHf)
    {
      input("9");
      AppMethodBeat.o(24049);
      return;
    }
    if ((paramView == this.pHg) && (this.pGD != null) && (this.pHn)) {
      this.pGD.delete();
    }
    AppMethodBeat.o(24049);
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(24047);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pHr = getWidth();
    this.pHs = getHeight();
    paramInt1 = -this.pHp;
    paramInt2 = this.pHv - this.pHp + 1;
    paramInt3 = this.pHv * 2 - this.pHp + 2;
    paramInt4 = this.pHw + 2;
    int i = this.pHw * 2 + 3;
    int j = this.pHw * 3 + 4;
    this.pGX.layout(paramInt1, 1, this.pHt + paramInt1, this.pHu + 1);
    this.pGY.layout(paramInt2, 1, this.pHt + paramInt2, this.pHu + 1);
    this.pGZ.layout(paramInt3, 1, this.pHt + paramInt3, this.pHu + 1);
    this.pHa.layout(paramInt1, paramInt4, this.pHt + paramInt1, this.pHu + paramInt4);
    this.pHb.layout(paramInt2, paramInt4, this.pHt + paramInt2, this.pHu + paramInt4);
    this.pHc.layout(paramInt3, paramInt4, this.pHt + paramInt3, this.pHu + paramInt4);
    this.pHd.layout(paramInt1, i, this.pHt + paramInt1, this.pHu + i);
    this.pHe.layout(paramInt2, i, this.pHt + paramInt2, this.pHu + i);
    this.pHf.layout(paramInt3, i, this.pHt + paramInt3, this.pHu + i);
    this.pGW.layout(paramInt2, j, this.pHt + paramInt2, this.pHu + j);
    this.pHg.layout(paramInt3, j, this.pHt + paramInt3, this.pHu + j);
    this.pHh.layout(0, this.pHo + 1, this.pHr, this.pHo + 1 + 1);
    this.pHi.layout(0, this.pHo + paramInt4, this.pHr, paramInt4 + this.pHo + 1);
    this.pHj.layout(0, this.pHo + i, this.pHr, i + this.pHo + 1);
    this.pHk.layout(0, this.pHo + j, this.pHr, this.pHo + j + 1);
    this.pHl.layout(this.pHv + 1, this.pHo, this.pHv + 2, this.pHs);
    this.pHm.layout(this.pHv * 2 + 2, this.pHo, this.pHv * 2 + 3, this.pHs);
    AppMethodBeat.o(24047);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(24050);
    if ((paramView == this.pHg) && (this.pGD != null) && (this.pHn)) {
      this.pGD.axH();
    }
    AppMethodBeat.o(24050);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24048);
    super.onMeasure(paramInt1, paramInt2);
    this.pHr = getWidth();
    this.pHs = getHeight();
    if ((this.pHr != 0) && (this.pHs != 0))
    {
      this.pHv = ((this.pHr - 2) / 3);
      this.pHw = ((this.pHs - this.pHo - 4) / 4);
      this.pHt = (this.pHv + this.pHp * 2);
      this.pHu = (this.pHw + this.pHo * 2);
    }
    this.pGX.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pGY.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pGZ.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHa.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHb.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHc.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHd.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHe.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHf.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pGW.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHg.measure(View.MeasureSpec.makeMeasureSpec(this.pHt, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHu, 1073741824));
    this.pHh.measure(View.MeasureSpec.makeMeasureSpec(this.pHr, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.pHi.measure(View.MeasureSpec.makeMeasureSpec(this.pHr, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.pHj.measure(View.MeasureSpec.makeMeasureSpec(this.pHr, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.pHk.measure(View.MeasureSpec.makeMeasureSpec(this.pHr, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.pHl.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHs, 1073741824));
    this.pHm.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.pHs, 1073741824));
    AppMethodBeat.o(24048);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(24051);
    this.pHn = paramBoolean;
    this.pGW.setEnabled(paramBoolean);
    this.pGX.setEnabled(paramBoolean);
    this.pGY.setEnabled(paramBoolean);
    this.pGZ.setEnabled(paramBoolean);
    this.pHa.setEnabled(paramBoolean);
    this.pHb.setEnabled(paramBoolean);
    this.pHc.setEnabled(paramBoolean);
    this.pHd.setEnabled(paramBoolean);
    this.pHe.setEnabled(paramBoolean);
    this.pHf.setEnabled(paramBoolean);
    this.pHg.setEnabled(paramBoolean);
    AppMethodBeat.o(24051);
  }
  
  public void setOnInputDeleteListener(MMKeyBoardView.a parama)
  {
    this.pGD = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */