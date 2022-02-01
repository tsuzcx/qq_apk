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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private Context mContext;
  private float pxm;
  private a wYT;
  private View wZA;
  private View wZB;
  private View wZC;
  private boolean wZD;
  private int wZE;
  private int wZF;
  private ColorStateList wZG;
  private int wZH;
  private int wZI;
  private int wZJ;
  private int wZK;
  private int wZL;
  private int wZM;
  private int wZN;
  private Button wZm;
  private Button wZn;
  private Button wZo;
  private Button wZp;
  private Button wZq;
  private Button wZr;
  private Button wZs;
  private Button wZt;
  private Button wZu;
  private Button wZv;
  private ImageButton wZw;
  private View wZx;
  private View wZy;
  private View wZz;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27686);
    this.wZD = true;
    this.mContext = paramContext;
    this.wZE = getResources().getDimensionPixelSize(2131166466);
    this.wZF = getResources().getDimensionPixelSize(2131166467);
    this.pxm = getResources().getDimensionPixelSize(2131166468);
    this.wZG = getResources().getColorStateList(2131100527);
    this.wZH = getResources().getColor(2131100526);
    this.wZm = new Button(this.mContext);
    this.wZn = new Button(this.mContext);
    this.wZo = new Button(this.mContext);
    this.wZp = new Button(this.mContext);
    this.wZq = new Button(this.mContext);
    this.wZr = new Button(this.mContext);
    this.wZs = new Button(this.mContext);
    this.wZt = new Button(this.mContext);
    this.wZu = new Button(this.mContext);
    this.wZv = new Button(this.mContext);
    this.wZw = new ImageButton(this.mContext);
    this.wZx = new View(this.mContext);
    this.wZx = new View(this.mContext);
    this.wZy = new View(this.mContext);
    this.wZz = new View(this.mContext);
    this.wZA = new View(this.mContext);
    this.wZB = new View(this.mContext);
    this.wZC = new View(this.mContext);
    this.wZm.setBackgroundResource(2131232759);
    this.wZn.setBackgroundResource(2131232759);
    this.wZo.setBackgroundResource(2131232759);
    this.wZp.setBackgroundResource(2131232759);
    this.wZq.setBackgroundResource(2131232759);
    this.wZr.setBackgroundResource(2131232759);
    this.wZs.setBackgroundResource(2131232759);
    this.wZt.setBackgroundResource(2131232759);
    this.wZu.setBackgroundResource(2131232759);
    this.wZr.setBackgroundResource(2131232759);
    this.wZv.setBackgroundResource(2131232759);
    this.wZw.setBackgroundResource(2131232759);
    this.wZw.setImageResource(2131232760);
    this.wZm.setText("0");
    this.wZn.setText("1");
    this.wZo.setText("2");
    this.wZp.setText("3");
    this.wZq.setText("4");
    this.wZr.setText("5");
    this.wZs.setText("6");
    this.wZt.setText("7");
    this.wZu.setText("8");
    this.wZv.setText("9");
    this.wZm.setGravity(17);
    this.wZn.setGravity(17);
    this.wZo.setGravity(17);
    this.wZp.setGravity(17);
    this.wZq.setGravity(17);
    this.wZr.setGravity(17);
    this.wZs.setGravity(17);
    this.wZt.setGravity(17);
    this.wZu.setGravity(17);
    this.wZv.setGravity(17);
    this.wZm.setTextSize(0, this.pxm);
    this.wZn.setTextSize(0, this.pxm);
    this.wZo.setTextSize(0, this.pxm);
    this.wZp.setTextSize(0, this.pxm);
    this.wZq.setTextSize(0, this.pxm);
    this.wZr.setTextSize(0, this.pxm);
    this.wZs.setTextSize(0, this.pxm);
    this.wZt.setTextSize(0, this.pxm);
    this.wZu.setTextSize(0, this.pxm);
    this.wZv.setTextSize(0, this.pxm);
    this.wZm.setTextColor(this.wZG);
    this.wZn.setTextColor(this.wZG);
    this.wZo.setTextColor(this.wZG);
    this.wZp.setTextColor(this.wZG);
    this.wZq.setTextColor(this.wZG);
    this.wZr.setTextColor(this.wZG);
    this.wZs.setTextColor(this.wZG);
    this.wZt.setTextColor(this.wZG);
    this.wZu.setTextColor(this.wZG);
    this.wZv.setTextColor(this.wZG);
    this.wZm.setOnClickListener(this);
    this.wZn.setOnClickListener(this);
    this.wZo.setOnClickListener(this);
    this.wZp.setOnClickListener(this);
    this.wZq.setOnClickListener(this);
    this.wZr.setOnClickListener(this);
    this.wZs.setOnClickListener(this);
    this.wZt.setOnClickListener(this);
    this.wZu.setOnClickListener(this);
    this.wZv.setOnClickListener(this);
    this.wZw.setOnClickListener(this);
    this.wZw.setOnLongClickListener(this);
    this.wZx.setBackgroundColor(this.wZH);
    this.wZx.setBackgroundColor(this.wZH);
    this.wZy.setBackgroundColor(this.wZH);
    this.wZz.setBackgroundColor(this.wZH);
    this.wZA.setBackgroundColor(this.wZH);
    this.wZB.setBackgroundColor(this.wZH);
    this.wZC.setBackgroundColor(this.wZH);
    addView(this.wZm);
    addView(this.wZn);
    addView(this.wZo);
    addView(this.wZp);
    addView(this.wZq);
    addView(this.wZr);
    addView(this.wZs);
    addView(this.wZt);
    addView(this.wZu);
    addView(this.wZv);
    addView(this.wZw);
    addView(this.wZx);
    addView(this.wZy);
    addView(this.wZz);
    addView(this.wZA);
    addView(this.wZB);
    addView(this.wZC);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27685);
        MMKeyBoardView.this.requestLayout();
        AppMethodBeat.o(27685);
      }
    });
    AppMethodBeat.o(27686);
  }
  
  private void input(String paramString)
  {
    AppMethodBeat.i(27692);
    if ((this.wYT != null) && (this.wZD)) {
      this.wYT.input(paramString);
    }
    AppMethodBeat.o(27692);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27689);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!this.wZD)
    {
      ad.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.wZm) {
      input("0");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
      if (paramView == this.wZn) {
        input("1");
      } else if (paramView == this.wZo) {
        input("2");
      } else if (paramView == this.wZp) {
        input("3");
      } else if (paramView == this.wZq) {
        input("4");
      } else if (paramView == this.wZr) {
        input("5");
      } else if (paramView == this.wZs) {
        input("6");
      } else if (paramView == this.wZt) {
        input("7");
      } else if (paramView == this.wZu) {
        input("8");
      } else if (paramView == this.wZv) {
        input("9");
      } else if ((paramView == this.wZw) && (this.wYT != null) && (this.wZD)) {
        this.wYT.delete();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27687);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.wZI = getWidth();
    this.wZJ = getHeight();
    paramInt1 = -this.wZF;
    paramInt2 = this.wZM - this.wZF + 1;
    paramInt3 = this.wZM * 2 - this.wZF + 2;
    paramInt4 = this.wZN + 2;
    int i = this.wZN * 2 + 3;
    int j = this.wZN * 3 + 4;
    this.wZn.layout(paramInt1, 1, this.wZK + paramInt1, this.wZL + 1);
    this.wZo.layout(paramInt2, 1, this.wZK + paramInt2, this.wZL + 1);
    this.wZp.layout(paramInt3, 1, this.wZK + paramInt3, this.wZL + 1);
    this.wZq.layout(paramInt1, paramInt4, this.wZK + paramInt1, this.wZL + paramInt4);
    this.wZr.layout(paramInt2, paramInt4, this.wZK + paramInt2, this.wZL + paramInt4);
    this.wZs.layout(paramInt3, paramInt4, this.wZK + paramInt3, this.wZL + paramInt4);
    this.wZt.layout(paramInt1, i, this.wZK + paramInt1, this.wZL + i);
    this.wZu.layout(paramInt2, i, this.wZK + paramInt2, this.wZL + i);
    this.wZv.layout(paramInt3, i, this.wZK + paramInt3, this.wZL + i);
    this.wZm.layout(paramInt2, j, this.wZK + paramInt2, this.wZL + j);
    this.wZw.layout(paramInt3, j, this.wZK + paramInt3, this.wZL + j);
    this.wZx.layout(0, this.wZE + 1, this.wZI, this.wZE + 1 + 1);
    this.wZy.layout(0, this.wZE + paramInt4, this.wZI, paramInt4 + this.wZE + 1);
    this.wZz.layout(0, this.wZE + i, this.wZI, i + this.wZE + 1);
    this.wZA.layout(0, this.wZE + j, this.wZI, this.wZE + j + 1);
    this.wZB.layout(this.wZM + 1, this.wZE, this.wZM + 2, this.wZJ);
    this.wZC.layout(this.wZM * 2 + 2, this.wZE, this.wZM * 2 + 3, this.wZJ);
    AppMethodBeat.o(27687);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27690);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    if ((paramView == this.wZw) && (this.wYT != null) && (this.wZD)) {
      this.wYT.bcD();
    }
    a.a(false, this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27690);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27688);
    super.onMeasure(paramInt1, paramInt2);
    this.wZI = getWidth();
    this.wZJ = getHeight();
    if ((this.wZI != 0) && (this.wZJ != 0))
    {
      this.wZM = ((this.wZI - 2) / 3);
      this.wZN = ((this.wZJ - this.wZE - 4) / 4);
      this.wZK = (this.wZM + this.wZF * 2);
      this.wZL = (this.wZN + this.wZE * 2);
    }
    this.wZn.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZo.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZp.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZq.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZr.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZs.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZt.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZu.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZv.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZm.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZw.measure(View.MeasureSpec.makeMeasureSpec(this.wZK, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZL, 1073741824));
    this.wZx.measure(View.MeasureSpec.makeMeasureSpec(this.wZI, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.wZy.measure(View.MeasureSpec.makeMeasureSpec(this.wZI, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.wZz.measure(View.MeasureSpec.makeMeasureSpec(this.wZI, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.wZA.measure(View.MeasureSpec.makeMeasureSpec(this.wZI, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.wZB.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZJ, 1073741824));
    this.wZC.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.wZJ, 1073741824));
    AppMethodBeat.o(27688);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(27691);
    this.wZD = paramBoolean;
    this.wZm.setEnabled(paramBoolean);
    this.wZn.setEnabled(paramBoolean);
    this.wZo.setEnabled(paramBoolean);
    this.wZp.setEnabled(paramBoolean);
    this.wZq.setEnabled(paramBoolean);
    this.wZr.setEnabled(paramBoolean);
    this.wZs.setEnabled(paramBoolean);
    this.wZt.setEnabled(paramBoolean);
    this.wZu.setEnabled(paramBoolean);
    this.wZv.setEnabled(paramBoolean);
    this.wZw.setEnabled(paramBoolean);
    AppMethodBeat.o(27691);
  }
  
  public void setOnInputDeleteListener(a parama)
  {
    this.wYT = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bcD();
    
    public abstract void delete();
    
    public abstract void input(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */