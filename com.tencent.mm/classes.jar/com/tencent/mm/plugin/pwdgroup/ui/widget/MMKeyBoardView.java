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
import com.tencent.mm.sdk.platformtools.ad;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private Context mContext;
  private float oqc;
  private a uIS;
  private View uJA;
  private View uJB;
  private boolean uJC;
  private int uJD;
  private int uJE;
  private ColorStateList uJF;
  private int uJG;
  private int uJH;
  private int uJI;
  private int uJJ;
  private int uJK;
  private int uJL;
  private int uJM;
  private Button uJl;
  private Button uJm;
  private Button uJn;
  private Button uJo;
  private Button uJp;
  private Button uJq;
  private Button uJr;
  private Button uJs;
  private Button uJt;
  private Button uJu;
  private ImageButton uJv;
  private View uJw;
  private View uJx;
  private View uJy;
  private View uJz;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27686);
    this.uJC = true;
    this.mContext = paramContext;
    this.uJD = getResources().getDimensionPixelSize(2131166466);
    this.uJE = getResources().getDimensionPixelSize(2131166467);
    this.oqc = getResources().getDimensionPixelSize(2131166468);
    this.uJF = getResources().getColorStateList(2131100527);
    this.uJG = getResources().getColor(2131100526);
    this.uJl = new Button(this.mContext);
    this.uJm = new Button(this.mContext);
    this.uJn = new Button(this.mContext);
    this.uJo = new Button(this.mContext);
    this.uJp = new Button(this.mContext);
    this.uJq = new Button(this.mContext);
    this.uJr = new Button(this.mContext);
    this.uJs = new Button(this.mContext);
    this.uJt = new Button(this.mContext);
    this.uJu = new Button(this.mContext);
    this.uJv = new ImageButton(this.mContext);
    this.uJw = new View(this.mContext);
    this.uJw = new View(this.mContext);
    this.uJx = new View(this.mContext);
    this.uJy = new View(this.mContext);
    this.uJz = new View(this.mContext);
    this.uJA = new View(this.mContext);
    this.uJB = new View(this.mContext);
    this.uJl.setBackgroundResource(2131232759);
    this.uJm.setBackgroundResource(2131232759);
    this.uJn.setBackgroundResource(2131232759);
    this.uJo.setBackgroundResource(2131232759);
    this.uJp.setBackgroundResource(2131232759);
    this.uJq.setBackgroundResource(2131232759);
    this.uJr.setBackgroundResource(2131232759);
    this.uJs.setBackgroundResource(2131232759);
    this.uJt.setBackgroundResource(2131232759);
    this.uJq.setBackgroundResource(2131232759);
    this.uJu.setBackgroundResource(2131232759);
    this.uJv.setBackgroundResource(2131232759);
    this.uJv.setImageResource(2131232760);
    this.uJl.setText("0");
    this.uJm.setText("1");
    this.uJn.setText("2");
    this.uJo.setText("3");
    this.uJp.setText("4");
    this.uJq.setText("5");
    this.uJr.setText("6");
    this.uJs.setText("7");
    this.uJt.setText("8");
    this.uJu.setText("9");
    this.uJl.setGravity(17);
    this.uJm.setGravity(17);
    this.uJn.setGravity(17);
    this.uJo.setGravity(17);
    this.uJp.setGravity(17);
    this.uJq.setGravity(17);
    this.uJr.setGravity(17);
    this.uJs.setGravity(17);
    this.uJt.setGravity(17);
    this.uJu.setGravity(17);
    this.uJl.setTextSize(0, this.oqc);
    this.uJm.setTextSize(0, this.oqc);
    this.uJn.setTextSize(0, this.oqc);
    this.uJo.setTextSize(0, this.oqc);
    this.uJp.setTextSize(0, this.oqc);
    this.uJq.setTextSize(0, this.oqc);
    this.uJr.setTextSize(0, this.oqc);
    this.uJs.setTextSize(0, this.oqc);
    this.uJt.setTextSize(0, this.oqc);
    this.uJu.setTextSize(0, this.oqc);
    this.uJl.setTextColor(this.uJF);
    this.uJm.setTextColor(this.uJF);
    this.uJn.setTextColor(this.uJF);
    this.uJo.setTextColor(this.uJF);
    this.uJp.setTextColor(this.uJF);
    this.uJq.setTextColor(this.uJF);
    this.uJr.setTextColor(this.uJF);
    this.uJs.setTextColor(this.uJF);
    this.uJt.setTextColor(this.uJF);
    this.uJu.setTextColor(this.uJF);
    this.uJl.setOnClickListener(this);
    this.uJm.setOnClickListener(this);
    this.uJn.setOnClickListener(this);
    this.uJo.setOnClickListener(this);
    this.uJp.setOnClickListener(this);
    this.uJq.setOnClickListener(this);
    this.uJr.setOnClickListener(this);
    this.uJs.setOnClickListener(this);
    this.uJt.setOnClickListener(this);
    this.uJu.setOnClickListener(this);
    this.uJv.setOnClickListener(this);
    this.uJv.setOnLongClickListener(this);
    this.uJw.setBackgroundColor(this.uJG);
    this.uJw.setBackgroundColor(this.uJG);
    this.uJx.setBackgroundColor(this.uJG);
    this.uJy.setBackgroundColor(this.uJG);
    this.uJz.setBackgroundColor(this.uJG);
    this.uJA.setBackgroundColor(this.uJG);
    this.uJB.setBackgroundColor(this.uJG);
    addView(this.uJl);
    addView(this.uJm);
    addView(this.uJn);
    addView(this.uJo);
    addView(this.uJp);
    addView(this.uJq);
    addView(this.uJr);
    addView(this.uJs);
    addView(this.uJt);
    addView(this.uJu);
    addView(this.uJv);
    addView(this.uJw);
    addView(this.uJx);
    addView(this.uJy);
    addView(this.uJz);
    addView(this.uJA);
    addView(this.uJB);
    post(new MMKeyBoardView.1(this));
    AppMethodBeat.o(27686);
  }
  
  private void input(String paramString)
  {
    AppMethodBeat.i(27692);
    if ((this.uIS != null) && (this.uJC)) {
      this.uIS.input(paramString);
    }
    AppMethodBeat.o(27692);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27689);
    if (!this.uJC)
    {
      ad.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJl)
    {
      input("0");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJm)
    {
      input("1");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJn)
    {
      input("2");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJo)
    {
      input("3");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJp)
    {
      input("4");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJq)
    {
      input("5");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJr)
    {
      input("6");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJs)
    {
      input("7");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJt)
    {
      input("8");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.uJu)
    {
      input("9");
      AppMethodBeat.o(27689);
      return;
    }
    if ((paramView == this.uJv) && (this.uIS != null) && (this.uJC)) {
      this.uIS.delete();
    }
    AppMethodBeat.o(27689);
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27687);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.uJH = getWidth();
    this.uJI = getHeight();
    paramInt1 = -this.uJE;
    paramInt2 = this.uJL - this.uJE + 1;
    paramInt3 = this.uJL * 2 - this.uJE + 2;
    paramInt4 = this.uJM + 2;
    int i = this.uJM * 2 + 3;
    int j = this.uJM * 3 + 4;
    this.uJm.layout(paramInt1, 1, this.uJJ + paramInt1, this.uJK + 1);
    this.uJn.layout(paramInt2, 1, this.uJJ + paramInt2, this.uJK + 1);
    this.uJo.layout(paramInt3, 1, this.uJJ + paramInt3, this.uJK + 1);
    this.uJp.layout(paramInt1, paramInt4, this.uJJ + paramInt1, this.uJK + paramInt4);
    this.uJq.layout(paramInt2, paramInt4, this.uJJ + paramInt2, this.uJK + paramInt4);
    this.uJr.layout(paramInt3, paramInt4, this.uJJ + paramInt3, this.uJK + paramInt4);
    this.uJs.layout(paramInt1, i, this.uJJ + paramInt1, this.uJK + i);
    this.uJt.layout(paramInt2, i, this.uJJ + paramInt2, this.uJK + i);
    this.uJu.layout(paramInt3, i, this.uJJ + paramInt3, this.uJK + i);
    this.uJl.layout(paramInt2, j, this.uJJ + paramInt2, this.uJK + j);
    this.uJv.layout(paramInt3, j, this.uJJ + paramInt3, this.uJK + j);
    this.uJw.layout(0, this.uJD + 1, this.uJH, this.uJD + 1 + 1);
    this.uJx.layout(0, this.uJD + paramInt4, this.uJH, paramInt4 + this.uJD + 1);
    this.uJy.layout(0, this.uJD + i, this.uJH, i + this.uJD + 1);
    this.uJz.layout(0, this.uJD + j, this.uJH, this.uJD + j + 1);
    this.uJA.layout(this.uJL + 1, this.uJD, this.uJL + 2, this.uJI);
    this.uJB.layout(this.uJL * 2 + 2, this.uJD, this.uJL * 2 + 3, this.uJI);
    AppMethodBeat.o(27687);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27690);
    if ((paramView == this.uJv) && (this.uIS != null) && (this.uJC)) {
      this.uIS.aSi();
    }
    AppMethodBeat.o(27690);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27688);
    super.onMeasure(paramInt1, paramInt2);
    this.uJH = getWidth();
    this.uJI = getHeight();
    if ((this.uJH != 0) && (this.uJI != 0))
    {
      this.uJL = ((this.uJH - 2) / 3);
      this.uJM = ((this.uJI - this.uJD - 4) / 4);
      this.uJJ = (this.uJL + this.uJE * 2);
      this.uJK = (this.uJM + this.uJD * 2);
    }
    this.uJm.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJn.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJo.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJp.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJq.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJr.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJs.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJt.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJu.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJl.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJv.measure(View.MeasureSpec.makeMeasureSpec(this.uJJ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJK, 1073741824));
    this.uJw.measure(View.MeasureSpec.makeMeasureSpec(this.uJH, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.uJx.measure(View.MeasureSpec.makeMeasureSpec(this.uJH, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.uJy.measure(View.MeasureSpec.makeMeasureSpec(this.uJH, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.uJz.measure(View.MeasureSpec.makeMeasureSpec(this.uJH, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.uJA.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJI, 1073741824));
    this.uJB.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.uJI, 1073741824));
    AppMethodBeat.o(27688);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(27691);
    this.uJC = paramBoolean;
    this.uJl.setEnabled(paramBoolean);
    this.uJm.setEnabled(paramBoolean);
    this.uJn.setEnabled(paramBoolean);
    this.uJo.setEnabled(paramBoolean);
    this.uJp.setEnabled(paramBoolean);
    this.uJq.setEnabled(paramBoolean);
    this.uJr.setEnabled(paramBoolean);
    this.uJs.setEnabled(paramBoolean);
    this.uJt.setEnabled(paramBoolean);
    this.uJu.setEnabled(paramBoolean);
    this.uJv.setEnabled(paramBoolean);
    AppMethodBeat.o(27691);
  }
  
  public void setOnInputDeleteListener(a parama)
  {
    this.uIS = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aSi();
    
    public abstract void delete();
    
    public abstract void input(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */