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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private Button NhA;
  private Button NhB;
  private Button NhC;
  private Button NhD;
  private Button NhE;
  private ImageButton NhF;
  private View NhG;
  private View NhH;
  private View NhI;
  private View NhJ;
  private View NhK;
  private View NhL;
  private boolean NhM;
  private int NhN;
  private int NhO;
  private ColorStateList NhP;
  private int NhQ;
  private int NhR;
  private int NhS;
  private int NhT;
  private int NhU;
  private int NhV;
  private int NhW;
  private a Nhc;
  private Button Nhv;
  private Button Nhw;
  private Button Nhx;
  private Button Nhy;
  private Button Nhz;
  private Context mContext;
  private float xBL;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27686);
    this.NhM = true;
    this.mContext = paramContext;
    this.NhN = getResources().getDimensionPixelSize(R.f.flK);
    this.NhO = getResources().getDimensionPixelSize(R.f.flL);
    this.xBL = getResources().getDimensionPixelSize(R.f.flM);
    this.NhP = getResources().getColorStateList(R.e.fkH);
    this.NhQ = getResources().getColor(R.e.fkG);
    this.Nhv = new Button(this.mContext);
    this.Nhw = new Button(this.mContext);
    this.Nhx = new Button(this.mContext);
    this.Nhy = new Button(this.mContext);
    this.Nhz = new Button(this.mContext);
    this.NhA = new Button(this.mContext);
    this.NhB = new Button(this.mContext);
    this.NhC = new Button(this.mContext);
    this.NhD = new Button(this.mContext);
    this.NhE = new Button(this.mContext);
    this.NhF = new ImageButton(this.mContext);
    this.NhG = new View(this.mContext);
    this.NhG = new View(this.mContext);
    this.NhH = new View(this.mContext);
    this.NhI = new View(this.mContext);
    this.NhJ = new View(this.mContext);
    this.NhK = new View(this.mContext);
    this.NhL = new View(this.mContext);
    this.Nhv.setBackgroundResource(R.g.fnY);
    this.Nhw.setBackgroundResource(R.g.fnY);
    this.Nhx.setBackgroundResource(R.g.fnY);
    this.Nhy.setBackgroundResource(R.g.fnY);
    this.Nhz.setBackgroundResource(R.g.fnY);
    this.NhA.setBackgroundResource(R.g.fnY);
    this.NhB.setBackgroundResource(R.g.fnY);
    this.NhC.setBackgroundResource(R.g.fnY);
    this.NhD.setBackgroundResource(R.g.fnY);
    this.NhA.setBackgroundResource(R.g.fnY);
    this.NhE.setBackgroundResource(R.g.fnY);
    this.NhF.setBackgroundResource(R.g.fnY);
    this.NhF.setImageResource(R.g.fnZ);
    this.NhF.setContentDescription("删除");
    this.Nhv.setText("0");
    this.Nhw.setText("1");
    this.Nhx.setText("2");
    this.Nhy.setText("3");
    this.Nhz.setText("4");
    this.NhA.setText("5");
    this.NhB.setText("6");
    this.NhC.setText("7");
    this.NhD.setText("8");
    this.NhE.setText("9");
    this.Nhv.setGravity(17);
    this.Nhw.setGravity(17);
    this.Nhx.setGravity(17);
    this.Nhy.setGravity(17);
    this.Nhz.setGravity(17);
    this.NhA.setGravity(17);
    this.NhB.setGravity(17);
    this.NhC.setGravity(17);
    this.NhD.setGravity(17);
    this.NhE.setGravity(17);
    this.Nhv.setTextSize(0, this.xBL);
    this.Nhw.setTextSize(0, this.xBL);
    this.Nhx.setTextSize(0, this.xBL);
    this.Nhy.setTextSize(0, this.xBL);
    this.Nhz.setTextSize(0, this.xBL);
    this.NhA.setTextSize(0, this.xBL);
    this.NhB.setTextSize(0, this.xBL);
    this.NhC.setTextSize(0, this.xBL);
    this.NhD.setTextSize(0, this.xBL);
    this.NhE.setTextSize(0, this.xBL);
    this.Nhv.setTextColor(this.NhP);
    this.Nhw.setTextColor(this.NhP);
    this.Nhx.setTextColor(this.NhP);
    this.Nhy.setTextColor(this.NhP);
    this.Nhz.setTextColor(this.NhP);
    this.NhA.setTextColor(this.NhP);
    this.NhB.setTextColor(this.NhP);
    this.NhC.setTextColor(this.NhP);
    this.NhD.setTextColor(this.NhP);
    this.NhE.setTextColor(this.NhP);
    this.Nhv.setOnClickListener(this);
    this.Nhw.setOnClickListener(this);
    this.Nhx.setOnClickListener(this);
    this.Nhy.setOnClickListener(this);
    this.Nhz.setOnClickListener(this);
    this.NhA.setOnClickListener(this);
    this.NhB.setOnClickListener(this);
    this.NhC.setOnClickListener(this);
    this.NhD.setOnClickListener(this);
    this.NhE.setOnClickListener(this);
    this.NhF.setOnClickListener(this);
    this.NhF.setOnLongClickListener(this);
    this.NhG.setBackgroundColor(this.NhQ);
    this.NhG.setBackgroundColor(this.NhQ);
    this.NhH.setBackgroundColor(this.NhQ);
    this.NhI.setBackgroundColor(this.NhQ);
    this.NhJ.setBackgroundColor(this.NhQ);
    this.NhK.setBackgroundColor(this.NhQ);
    this.NhL.setBackgroundColor(this.NhQ);
    addView(this.Nhv);
    addView(this.Nhw);
    addView(this.Nhx);
    addView(this.Nhy);
    addView(this.Nhz);
    addView(this.NhA);
    addView(this.NhB);
    addView(this.NhC);
    addView(this.NhD);
    addView(this.NhE);
    addView(this.NhF);
    addView(this.NhG);
    addView(this.NhH);
    addView(this.NhI);
    addView(this.NhJ);
    addView(this.NhK);
    addView(this.NhL);
    post(new MMKeyBoardView.1(this));
    AppMethodBeat.o(27686);
  }
  
  private void aSi(String paramString)
  {
    AppMethodBeat.i(27692);
    if ((this.Nhc != null) && (this.NhM)) {
      this.Nhc.aSi(paramString);
    }
    AppMethodBeat.o(27692);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27689);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!this.NhM)
    {
      Log.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.Nhv) {
      aSi("0");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
      if (paramView == this.Nhw) {
        aSi("1");
      } else if (paramView == this.Nhx) {
        aSi("2");
      } else if (paramView == this.Nhy) {
        aSi("3");
      } else if (paramView == this.Nhz) {
        aSi("4");
      } else if (paramView == this.NhA) {
        aSi("5");
      } else if (paramView == this.NhB) {
        aSi("6");
      } else if (paramView == this.NhC) {
        aSi("7");
      } else if (paramView == this.NhD) {
        aSi("8");
      } else if (paramView == this.NhE) {
        aSi("9");
      } else if ((paramView == this.NhF) && (this.Nhc != null) && (this.NhM)) {
        this.Nhc.gDE();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27687);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.NhR = getWidth();
    this.NhS = getHeight();
    paramInt1 = -this.NhO;
    paramInt2 = this.NhV - this.NhO + 1;
    paramInt3 = this.NhV * 2 - this.NhO + 2;
    paramInt4 = this.NhW + 2;
    int i = this.NhW * 2 + 3;
    int j = this.NhW * 3 + 4;
    this.Nhw.layout(paramInt1, 1, this.NhT + paramInt1, this.NhU + 1);
    this.Nhx.layout(paramInt2, 1, this.NhT + paramInt2, this.NhU + 1);
    this.Nhy.layout(paramInt3, 1, this.NhT + paramInt3, this.NhU + 1);
    this.Nhz.layout(paramInt1, paramInt4, this.NhT + paramInt1, this.NhU + paramInt4);
    this.NhA.layout(paramInt2, paramInt4, this.NhT + paramInt2, this.NhU + paramInt4);
    this.NhB.layout(paramInt3, paramInt4, this.NhT + paramInt3, this.NhU + paramInt4);
    this.NhC.layout(paramInt1, i, this.NhT + paramInt1, this.NhU + i);
    this.NhD.layout(paramInt2, i, this.NhT + paramInt2, this.NhU + i);
    this.NhE.layout(paramInt3, i, this.NhT + paramInt3, this.NhU + i);
    this.Nhv.layout(paramInt2, j, this.NhT + paramInt2, this.NhU + j);
    this.NhF.layout(paramInt3, j, this.NhT + paramInt3, this.NhU + j);
    this.NhG.layout(0, this.NhN + 1, this.NhR, this.NhN + 1 + 1);
    this.NhH.layout(0, this.NhN + paramInt4, this.NhR, paramInt4 + this.NhN + 1);
    this.NhI.layout(0, this.NhN + i, this.NhR, i + this.NhN + 1);
    this.NhJ.layout(0, this.NhN + j, this.NhR, this.NhN + j + 1);
    this.NhK.layout(this.NhV + 1, this.NhN, this.NhV + 2, this.NhS);
    this.NhL.layout(this.NhV * 2 + 2, this.NhN, this.NhV * 2 + 3, this.NhS);
    AppMethodBeat.o(27687);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27690);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if ((paramView == this.NhF) && (this.Nhc != null) && (this.NhM)) {
      this.Nhc.cju();
    }
    a.a(false, this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27690);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27688);
    super.onMeasure(paramInt1, paramInt2);
    this.NhR = getWidth();
    this.NhS = getHeight();
    if ((this.NhR != 0) && (this.NhS != 0))
    {
      this.NhV = ((this.NhR - 2) / 3);
      this.NhW = ((this.NhS - this.NhN - 4) / 4);
      this.NhT = (this.NhV + this.NhO * 2);
      this.NhU = (this.NhW + this.NhN * 2);
    }
    this.Nhw.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.Nhx.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.Nhy.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.Nhz.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.NhA.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.NhB.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.NhC.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.NhD.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.NhE.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.Nhv.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.NhF.measure(View.MeasureSpec.makeMeasureSpec(this.NhT, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhU, 1073741824));
    this.NhG.measure(View.MeasureSpec.makeMeasureSpec(this.NhR, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.NhH.measure(View.MeasureSpec.makeMeasureSpec(this.NhR, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.NhI.measure(View.MeasureSpec.makeMeasureSpec(this.NhR, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.NhJ.measure(View.MeasureSpec.makeMeasureSpec(this.NhR, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.NhK.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhS, 1073741824));
    this.NhL.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.NhS, 1073741824));
    AppMethodBeat.o(27688);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(27691);
    this.NhM = paramBoolean;
    this.Nhv.setEnabled(paramBoolean);
    this.Nhw.setEnabled(paramBoolean);
    this.Nhx.setEnabled(paramBoolean);
    this.Nhy.setEnabled(paramBoolean);
    this.Nhz.setEnabled(paramBoolean);
    this.NhA.setEnabled(paramBoolean);
    this.NhB.setEnabled(paramBoolean);
    this.NhC.setEnabled(paramBoolean);
    this.NhD.setEnabled(paramBoolean);
    this.NhE.setEnabled(paramBoolean);
    this.NhF.setEnabled(paramBoolean);
    AppMethodBeat.o(27691);
  }
  
  public void setOnInputDeleteListener(a parama)
  {
    this.Nhc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aSi(String paramString);
    
    public abstract void cju();
    
    public abstract void gDE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */