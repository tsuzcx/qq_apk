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
import com.tencent.mm.sdk.platformtools.ac;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private Context mContext;
  private float oTC;
  private a vRJ;
  private int vSA;
  private int vSB;
  private int vSC;
  private int vSD;
  private Button vSc;
  private Button vSd;
  private Button vSe;
  private Button vSf;
  private Button vSg;
  private Button vSh;
  private Button vSi;
  private Button vSj;
  private Button vSk;
  private Button vSl;
  private ImageButton vSm;
  private View vSn;
  private View vSo;
  private View vSp;
  private View vSq;
  private View vSr;
  private View vSs;
  private boolean vSt;
  private int vSu;
  private int vSv;
  private ColorStateList vSw;
  private int vSx;
  private int vSy;
  private int vSz;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27686);
    this.vSt = true;
    this.mContext = paramContext;
    this.vSu = getResources().getDimensionPixelSize(2131166466);
    this.vSv = getResources().getDimensionPixelSize(2131166467);
    this.oTC = getResources().getDimensionPixelSize(2131166468);
    this.vSw = getResources().getColorStateList(2131100527);
    this.vSx = getResources().getColor(2131100526);
    this.vSc = new Button(this.mContext);
    this.vSd = new Button(this.mContext);
    this.vSe = new Button(this.mContext);
    this.vSf = new Button(this.mContext);
    this.vSg = new Button(this.mContext);
    this.vSh = new Button(this.mContext);
    this.vSi = new Button(this.mContext);
    this.vSj = new Button(this.mContext);
    this.vSk = new Button(this.mContext);
    this.vSl = new Button(this.mContext);
    this.vSm = new ImageButton(this.mContext);
    this.vSn = new View(this.mContext);
    this.vSn = new View(this.mContext);
    this.vSo = new View(this.mContext);
    this.vSp = new View(this.mContext);
    this.vSq = new View(this.mContext);
    this.vSr = new View(this.mContext);
    this.vSs = new View(this.mContext);
    this.vSc.setBackgroundResource(2131232759);
    this.vSd.setBackgroundResource(2131232759);
    this.vSe.setBackgroundResource(2131232759);
    this.vSf.setBackgroundResource(2131232759);
    this.vSg.setBackgroundResource(2131232759);
    this.vSh.setBackgroundResource(2131232759);
    this.vSi.setBackgroundResource(2131232759);
    this.vSj.setBackgroundResource(2131232759);
    this.vSk.setBackgroundResource(2131232759);
    this.vSh.setBackgroundResource(2131232759);
    this.vSl.setBackgroundResource(2131232759);
    this.vSm.setBackgroundResource(2131232759);
    this.vSm.setImageResource(2131232760);
    this.vSc.setText("0");
    this.vSd.setText("1");
    this.vSe.setText("2");
    this.vSf.setText("3");
    this.vSg.setText("4");
    this.vSh.setText("5");
    this.vSi.setText("6");
    this.vSj.setText("7");
    this.vSk.setText("8");
    this.vSl.setText("9");
    this.vSc.setGravity(17);
    this.vSd.setGravity(17);
    this.vSe.setGravity(17);
    this.vSf.setGravity(17);
    this.vSg.setGravity(17);
    this.vSh.setGravity(17);
    this.vSi.setGravity(17);
    this.vSj.setGravity(17);
    this.vSk.setGravity(17);
    this.vSl.setGravity(17);
    this.vSc.setTextSize(0, this.oTC);
    this.vSd.setTextSize(0, this.oTC);
    this.vSe.setTextSize(0, this.oTC);
    this.vSf.setTextSize(0, this.oTC);
    this.vSg.setTextSize(0, this.oTC);
    this.vSh.setTextSize(0, this.oTC);
    this.vSi.setTextSize(0, this.oTC);
    this.vSj.setTextSize(0, this.oTC);
    this.vSk.setTextSize(0, this.oTC);
    this.vSl.setTextSize(0, this.oTC);
    this.vSc.setTextColor(this.vSw);
    this.vSd.setTextColor(this.vSw);
    this.vSe.setTextColor(this.vSw);
    this.vSf.setTextColor(this.vSw);
    this.vSg.setTextColor(this.vSw);
    this.vSh.setTextColor(this.vSw);
    this.vSi.setTextColor(this.vSw);
    this.vSj.setTextColor(this.vSw);
    this.vSk.setTextColor(this.vSw);
    this.vSl.setTextColor(this.vSw);
    this.vSc.setOnClickListener(this);
    this.vSd.setOnClickListener(this);
    this.vSe.setOnClickListener(this);
    this.vSf.setOnClickListener(this);
    this.vSg.setOnClickListener(this);
    this.vSh.setOnClickListener(this);
    this.vSi.setOnClickListener(this);
    this.vSj.setOnClickListener(this);
    this.vSk.setOnClickListener(this);
    this.vSl.setOnClickListener(this);
    this.vSm.setOnClickListener(this);
    this.vSm.setOnLongClickListener(this);
    this.vSn.setBackgroundColor(this.vSx);
    this.vSn.setBackgroundColor(this.vSx);
    this.vSo.setBackgroundColor(this.vSx);
    this.vSp.setBackgroundColor(this.vSx);
    this.vSq.setBackgroundColor(this.vSx);
    this.vSr.setBackgroundColor(this.vSx);
    this.vSs.setBackgroundColor(this.vSx);
    addView(this.vSc);
    addView(this.vSd);
    addView(this.vSe);
    addView(this.vSf);
    addView(this.vSg);
    addView(this.vSh);
    addView(this.vSi);
    addView(this.vSj);
    addView(this.vSk);
    addView(this.vSl);
    addView(this.vSm);
    addView(this.vSn);
    addView(this.vSo);
    addView(this.vSp);
    addView(this.vSq);
    addView(this.vSr);
    addView(this.vSs);
    post(new MMKeyBoardView.1(this));
    AppMethodBeat.o(27686);
  }
  
  private void input(String paramString)
  {
    AppMethodBeat.i(27692);
    if ((this.vRJ != null) && (this.vSt)) {
      this.vRJ.input(paramString);
    }
    AppMethodBeat.o(27692);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27689);
    if (!this.vSt)
    {
      ac.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSc)
    {
      input("0");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSd)
    {
      input("1");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSe)
    {
      input("2");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSf)
    {
      input("3");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSg)
    {
      input("4");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSh)
    {
      input("5");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSi)
    {
      input("6");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSj)
    {
      input("7");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSk)
    {
      input("8");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.vSl)
    {
      input("9");
      AppMethodBeat.o(27689);
      return;
    }
    if ((paramView == this.vSm) && (this.vRJ != null) && (this.vSt)) {
      this.vRJ.delete();
    }
    AppMethodBeat.o(27689);
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27687);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.vSy = getWidth();
    this.vSz = getHeight();
    paramInt1 = -this.vSv;
    paramInt2 = this.vSC - this.vSv + 1;
    paramInt3 = this.vSC * 2 - this.vSv + 2;
    paramInt4 = this.vSD + 2;
    int i = this.vSD * 2 + 3;
    int j = this.vSD * 3 + 4;
    this.vSd.layout(paramInt1, 1, this.vSA + paramInt1, this.vSB + 1);
    this.vSe.layout(paramInt2, 1, this.vSA + paramInt2, this.vSB + 1);
    this.vSf.layout(paramInt3, 1, this.vSA + paramInt3, this.vSB + 1);
    this.vSg.layout(paramInt1, paramInt4, this.vSA + paramInt1, this.vSB + paramInt4);
    this.vSh.layout(paramInt2, paramInt4, this.vSA + paramInt2, this.vSB + paramInt4);
    this.vSi.layout(paramInt3, paramInt4, this.vSA + paramInt3, this.vSB + paramInt4);
    this.vSj.layout(paramInt1, i, this.vSA + paramInt1, this.vSB + i);
    this.vSk.layout(paramInt2, i, this.vSA + paramInt2, this.vSB + i);
    this.vSl.layout(paramInt3, i, this.vSA + paramInt3, this.vSB + i);
    this.vSc.layout(paramInt2, j, this.vSA + paramInt2, this.vSB + j);
    this.vSm.layout(paramInt3, j, this.vSA + paramInt3, this.vSB + j);
    this.vSn.layout(0, this.vSu + 1, this.vSy, this.vSu + 1 + 1);
    this.vSo.layout(0, this.vSu + paramInt4, this.vSy, paramInt4 + this.vSu + 1);
    this.vSp.layout(0, this.vSu + i, this.vSy, i + this.vSu + 1);
    this.vSq.layout(0, this.vSu + j, this.vSy, this.vSu + j + 1);
    this.vSr.layout(this.vSC + 1, this.vSu, this.vSC + 2, this.vSz);
    this.vSs.layout(this.vSC * 2 + 2, this.vSu, this.vSC * 2 + 3, this.vSz);
    AppMethodBeat.o(27687);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27690);
    if ((paramView == this.vSm) && (this.vRJ != null) && (this.vSt)) {
      this.vRJ.aZf();
    }
    AppMethodBeat.o(27690);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27688);
    super.onMeasure(paramInt1, paramInt2);
    this.vSy = getWidth();
    this.vSz = getHeight();
    if ((this.vSy != 0) && (this.vSz != 0))
    {
      this.vSC = ((this.vSy - 2) / 3);
      this.vSD = ((this.vSz - this.vSu - 4) / 4);
      this.vSA = (this.vSC + this.vSv * 2);
      this.vSB = (this.vSD + this.vSu * 2);
    }
    this.vSd.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSe.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSf.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSg.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSh.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSi.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSj.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSk.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSl.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSc.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSm.measure(View.MeasureSpec.makeMeasureSpec(this.vSA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSB, 1073741824));
    this.vSn.measure(View.MeasureSpec.makeMeasureSpec(this.vSy, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.vSo.measure(View.MeasureSpec.makeMeasureSpec(this.vSy, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.vSp.measure(View.MeasureSpec.makeMeasureSpec(this.vSy, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.vSq.measure(View.MeasureSpec.makeMeasureSpec(this.vSy, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.vSr.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSz, 1073741824));
    this.vSs.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.vSz, 1073741824));
    AppMethodBeat.o(27688);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(27691);
    this.vSt = paramBoolean;
    this.vSc.setEnabled(paramBoolean);
    this.vSd.setEnabled(paramBoolean);
    this.vSe.setEnabled(paramBoolean);
    this.vSf.setEnabled(paramBoolean);
    this.vSg.setEnabled(paramBoolean);
    this.vSh.setEnabled(paramBoolean);
    this.vSi.setEnabled(paramBoolean);
    this.vSj.setEnabled(paramBoolean);
    this.vSk.setEnabled(paramBoolean);
    this.vSl.setEnabled(paramBoolean);
    this.vSm.setEnabled(paramBoolean);
    AppMethodBeat.o(27691);
  }
  
  public void setOnInputDeleteListener(a parama)
  {
    this.vRJ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aZf();
    
    public abstract void delete();
    
    public abstract void input(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */