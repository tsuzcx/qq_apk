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
  private Button HjI;
  private Button HjJ;
  private Button HjK;
  private Button HjL;
  private Button HjM;
  private Button HjN;
  private Button HjO;
  private Button HjP;
  private Button HjQ;
  private Button HjR;
  private ImageButton HjS;
  private View HjT;
  private View HjU;
  private View HjV;
  private View HjW;
  private View HjX;
  private View HjY;
  private boolean HjZ;
  private a Hjp;
  private int Hka;
  private int Hkb;
  private ColorStateList Hkc;
  private int Hkd;
  private int Hke;
  private int Hkf;
  private int Hkg;
  private int Hkh;
  private int Hki;
  private int Hkj;
  private float jAg;
  private Context mContext;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27686);
    this.HjZ = true;
    this.mContext = paramContext;
    this.Hka = getResources().getDimensionPixelSize(R.f.dlu);
    this.Hkb = getResources().getDimensionPixelSize(R.f.dlv);
    this.jAg = getResources().getDimensionPixelSize(R.f.dlw);
    this.Hkc = getResources().getColorStateList(R.e.dkz);
    this.Hkd = getResources().getColor(R.e.dky);
    this.HjI = new Button(this.mContext);
    this.HjJ = new Button(this.mContext);
    this.HjK = new Button(this.mContext);
    this.HjL = new Button(this.mContext);
    this.HjM = new Button(this.mContext);
    this.HjN = new Button(this.mContext);
    this.HjO = new Button(this.mContext);
    this.HjP = new Button(this.mContext);
    this.HjQ = new Button(this.mContext);
    this.HjR = new Button(this.mContext);
    this.HjS = new ImageButton(this.mContext);
    this.HjT = new View(this.mContext);
    this.HjT = new View(this.mContext);
    this.HjU = new View(this.mContext);
    this.HjV = new View(this.mContext);
    this.HjW = new View(this.mContext);
    this.HjX = new View(this.mContext);
    this.HjY = new View(this.mContext);
    this.HjI.setBackgroundResource(R.g.dnJ);
    this.HjJ.setBackgroundResource(R.g.dnJ);
    this.HjK.setBackgroundResource(R.g.dnJ);
    this.HjL.setBackgroundResource(R.g.dnJ);
    this.HjM.setBackgroundResource(R.g.dnJ);
    this.HjN.setBackgroundResource(R.g.dnJ);
    this.HjO.setBackgroundResource(R.g.dnJ);
    this.HjP.setBackgroundResource(R.g.dnJ);
    this.HjQ.setBackgroundResource(R.g.dnJ);
    this.HjN.setBackgroundResource(R.g.dnJ);
    this.HjR.setBackgroundResource(R.g.dnJ);
    this.HjS.setBackgroundResource(R.g.dnJ);
    this.HjS.setImageResource(R.g.dnK);
    this.HjI.setText("0");
    this.HjJ.setText("1");
    this.HjK.setText("2");
    this.HjL.setText("3");
    this.HjM.setText("4");
    this.HjN.setText("5");
    this.HjO.setText("6");
    this.HjP.setText("7");
    this.HjQ.setText("8");
    this.HjR.setText("9");
    this.HjI.setGravity(17);
    this.HjJ.setGravity(17);
    this.HjK.setGravity(17);
    this.HjL.setGravity(17);
    this.HjM.setGravity(17);
    this.HjN.setGravity(17);
    this.HjO.setGravity(17);
    this.HjP.setGravity(17);
    this.HjQ.setGravity(17);
    this.HjR.setGravity(17);
    this.HjI.setTextSize(0, this.jAg);
    this.HjJ.setTextSize(0, this.jAg);
    this.HjK.setTextSize(0, this.jAg);
    this.HjL.setTextSize(0, this.jAg);
    this.HjM.setTextSize(0, this.jAg);
    this.HjN.setTextSize(0, this.jAg);
    this.HjO.setTextSize(0, this.jAg);
    this.HjP.setTextSize(0, this.jAg);
    this.HjQ.setTextSize(0, this.jAg);
    this.HjR.setTextSize(0, this.jAg);
    this.HjI.setTextColor(this.Hkc);
    this.HjJ.setTextColor(this.Hkc);
    this.HjK.setTextColor(this.Hkc);
    this.HjL.setTextColor(this.Hkc);
    this.HjM.setTextColor(this.Hkc);
    this.HjN.setTextColor(this.Hkc);
    this.HjO.setTextColor(this.Hkc);
    this.HjP.setTextColor(this.Hkc);
    this.HjQ.setTextColor(this.Hkc);
    this.HjR.setTextColor(this.Hkc);
    this.HjI.setOnClickListener(this);
    this.HjJ.setOnClickListener(this);
    this.HjK.setOnClickListener(this);
    this.HjL.setOnClickListener(this);
    this.HjM.setOnClickListener(this);
    this.HjN.setOnClickListener(this);
    this.HjO.setOnClickListener(this);
    this.HjP.setOnClickListener(this);
    this.HjQ.setOnClickListener(this);
    this.HjR.setOnClickListener(this);
    this.HjS.setOnClickListener(this);
    this.HjS.setOnLongClickListener(this);
    this.HjT.setBackgroundColor(this.Hkd);
    this.HjT.setBackgroundColor(this.Hkd);
    this.HjU.setBackgroundColor(this.Hkd);
    this.HjV.setBackgroundColor(this.Hkd);
    this.HjW.setBackgroundColor(this.Hkd);
    this.HjX.setBackgroundColor(this.Hkd);
    this.HjY.setBackgroundColor(this.Hkd);
    addView(this.HjI);
    addView(this.HjJ);
    addView(this.HjK);
    addView(this.HjL);
    addView(this.HjM);
    addView(this.HjN);
    addView(this.HjO);
    addView(this.HjP);
    addView(this.HjQ);
    addView(this.HjR);
    addView(this.HjS);
    addView(this.HjT);
    addView(this.HjU);
    addView(this.HjV);
    addView(this.HjW);
    addView(this.HjX);
    addView(this.HjY);
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
  
  private void aVa(String paramString)
  {
    AppMethodBeat.i(27692);
    if ((this.Hjp != null) && (this.HjZ)) {
      this.Hjp.aVa(paramString);
    }
    AppMethodBeat.o(27692);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27689);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!this.HjZ)
    {
      Log.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.HjI) {
      aVa("0");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
      if (paramView == this.HjJ) {
        aVa("1");
      } else if (paramView == this.HjK) {
        aVa("2");
      } else if (paramView == this.HjL) {
        aVa("3");
      } else if (paramView == this.HjM) {
        aVa("4");
      } else if (paramView == this.HjN) {
        aVa("5");
      } else if (paramView == this.HjO) {
        aVa("6");
      } else if (paramView == this.HjP) {
        aVa("7");
      } else if (paramView == this.HjQ) {
        aVa("8");
      } else if (paramView == this.HjR) {
        aVa("9");
      } else if ((paramView == this.HjS) && (this.Hjp != null) && (this.HjZ)) {
        this.Hjp.frW();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27687);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.Hke = getWidth();
    this.Hkf = getHeight();
    paramInt1 = -this.Hkb;
    paramInt2 = this.Hki - this.Hkb + 1;
    paramInt3 = this.Hki * 2 - this.Hkb + 2;
    paramInt4 = this.Hkj + 2;
    int i = this.Hkj * 2 + 3;
    int j = this.Hkj * 3 + 4;
    this.HjJ.layout(paramInt1, 1, this.Hkg + paramInt1, this.Hkh + 1);
    this.HjK.layout(paramInt2, 1, this.Hkg + paramInt2, this.Hkh + 1);
    this.HjL.layout(paramInt3, 1, this.Hkg + paramInt3, this.Hkh + 1);
    this.HjM.layout(paramInt1, paramInt4, this.Hkg + paramInt1, this.Hkh + paramInt4);
    this.HjN.layout(paramInt2, paramInt4, this.Hkg + paramInt2, this.Hkh + paramInt4);
    this.HjO.layout(paramInt3, paramInt4, this.Hkg + paramInt3, this.Hkh + paramInt4);
    this.HjP.layout(paramInt1, i, this.Hkg + paramInt1, this.Hkh + i);
    this.HjQ.layout(paramInt2, i, this.Hkg + paramInt2, this.Hkh + i);
    this.HjR.layout(paramInt3, i, this.Hkg + paramInt3, this.Hkh + i);
    this.HjI.layout(paramInt2, j, this.Hkg + paramInt2, this.Hkh + j);
    this.HjS.layout(paramInt3, j, this.Hkg + paramInt3, this.Hkh + j);
    this.HjT.layout(0, this.Hka + 1, this.Hke, this.Hka + 1 + 1);
    this.HjU.layout(0, this.Hka + paramInt4, this.Hke, paramInt4 + this.Hka + 1);
    this.HjV.layout(0, this.Hka + i, this.Hke, i + this.Hka + 1);
    this.HjW.layout(0, this.Hka + j, this.Hke, this.Hka + j + 1);
    this.HjX.layout(this.Hki + 1, this.Hka, this.Hki + 2, this.Hkf);
    this.HjY.layout(this.Hki * 2 + 2, this.Hka, this.Hki * 2 + 3, this.Hkf);
    AppMethodBeat.o(27687);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27690);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    if ((paramView == this.HjS) && (this.Hjp != null) && (this.HjZ)) {
      this.Hjp.bJQ();
    }
    a.a(false, this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27690);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27688);
    super.onMeasure(paramInt1, paramInt2);
    this.Hke = getWidth();
    this.Hkf = getHeight();
    if ((this.Hke != 0) && (this.Hkf != 0))
    {
      this.Hki = ((this.Hke - 2) / 3);
      this.Hkj = ((this.Hkf - this.Hka - 4) / 4);
      this.Hkg = (this.Hki + this.Hkb * 2);
      this.Hkh = (this.Hkj + this.Hka * 2);
    }
    this.HjJ.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjK.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjL.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjM.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjN.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjO.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjP.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjQ.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjR.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjI.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjS.measure(View.MeasureSpec.makeMeasureSpec(this.Hkg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkh, 1073741824));
    this.HjT.measure(View.MeasureSpec.makeMeasureSpec(this.Hke, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.HjU.measure(View.MeasureSpec.makeMeasureSpec(this.Hke, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.HjV.measure(View.MeasureSpec.makeMeasureSpec(this.Hke, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.HjW.measure(View.MeasureSpec.makeMeasureSpec(this.Hke, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.HjX.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkf, 1073741824));
    this.HjY.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Hkf, 1073741824));
    AppMethodBeat.o(27688);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(27691);
    this.HjZ = paramBoolean;
    this.HjI.setEnabled(paramBoolean);
    this.HjJ.setEnabled(paramBoolean);
    this.HjK.setEnabled(paramBoolean);
    this.HjL.setEnabled(paramBoolean);
    this.HjM.setEnabled(paramBoolean);
    this.HjN.setEnabled(paramBoolean);
    this.HjO.setEnabled(paramBoolean);
    this.HjP.setEnabled(paramBoolean);
    this.HjQ.setEnabled(paramBoolean);
    this.HjR.setEnabled(paramBoolean);
    this.HjS.setEnabled(paramBoolean);
    AppMethodBeat.o(27691);
  }
  
  public void setOnInputDeleteListener(a parama)
  {
    this.Hjp = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aVa(String paramString);
    
    public abstract void bJQ();
    
    public abstract void frW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */