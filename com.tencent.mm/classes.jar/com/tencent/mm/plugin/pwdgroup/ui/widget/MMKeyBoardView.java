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
import com.tencent.mm.sdk.platformtools.Log;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private a BoW;
  private View BpA;
  private View BpB;
  private View BpC;
  private View BpD;
  private View BpE;
  private View BpF;
  private boolean BpG;
  private int BpH;
  private int BpI;
  private ColorStateList BpJ;
  private int BpK;
  private int BpL;
  private int BpM;
  private int BpN;
  private int BpO;
  private int BpP;
  private int BpQ;
  private Button Bpp;
  private Button Bpq;
  private Button Bpr;
  private Button Bps;
  private Button Bpt;
  private Button Bpu;
  private Button Bpv;
  private Button Bpw;
  private Button Bpx;
  private Button Bpy;
  private ImageButton Bpz;
  private float gPN;
  private Context mContext;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27686);
    this.BpG = true;
    this.mContext = paramContext;
    this.BpH = getResources().getDimensionPixelSize(2131166559);
    this.BpI = getResources().getDimensionPixelSize(2131166560);
    this.gPN = getResources().getDimensionPixelSize(2131166561);
    this.BpJ = getResources().getColorStateList(2131100665);
    this.BpK = getResources().getColor(2131100664);
    this.Bpp = new Button(this.mContext);
    this.Bpq = new Button(this.mContext);
    this.Bpr = new Button(this.mContext);
    this.Bps = new Button(this.mContext);
    this.Bpt = new Button(this.mContext);
    this.Bpu = new Button(this.mContext);
    this.Bpv = new Button(this.mContext);
    this.Bpw = new Button(this.mContext);
    this.Bpx = new Button(this.mContext);
    this.Bpy = new Button(this.mContext);
    this.Bpz = new ImageButton(this.mContext);
    this.BpA = new View(this.mContext);
    this.BpA = new View(this.mContext);
    this.BpB = new View(this.mContext);
    this.BpC = new View(this.mContext);
    this.BpD = new View(this.mContext);
    this.BpE = new View(this.mContext);
    this.BpF = new View(this.mContext);
    this.Bpp.setBackgroundResource(2131233200);
    this.Bpq.setBackgroundResource(2131233200);
    this.Bpr.setBackgroundResource(2131233200);
    this.Bps.setBackgroundResource(2131233200);
    this.Bpt.setBackgroundResource(2131233200);
    this.Bpu.setBackgroundResource(2131233200);
    this.Bpv.setBackgroundResource(2131233200);
    this.Bpw.setBackgroundResource(2131233200);
    this.Bpx.setBackgroundResource(2131233200);
    this.Bpu.setBackgroundResource(2131233200);
    this.Bpy.setBackgroundResource(2131233200);
    this.Bpz.setBackgroundResource(2131233200);
    this.Bpz.setImageResource(2131233201);
    this.Bpp.setText("0");
    this.Bpq.setText("1");
    this.Bpr.setText("2");
    this.Bps.setText("3");
    this.Bpt.setText("4");
    this.Bpu.setText("5");
    this.Bpv.setText("6");
    this.Bpw.setText("7");
    this.Bpx.setText("8");
    this.Bpy.setText("9");
    this.Bpp.setGravity(17);
    this.Bpq.setGravity(17);
    this.Bpr.setGravity(17);
    this.Bps.setGravity(17);
    this.Bpt.setGravity(17);
    this.Bpu.setGravity(17);
    this.Bpv.setGravity(17);
    this.Bpw.setGravity(17);
    this.Bpx.setGravity(17);
    this.Bpy.setGravity(17);
    this.Bpp.setTextSize(0, this.gPN);
    this.Bpq.setTextSize(0, this.gPN);
    this.Bpr.setTextSize(0, this.gPN);
    this.Bps.setTextSize(0, this.gPN);
    this.Bpt.setTextSize(0, this.gPN);
    this.Bpu.setTextSize(0, this.gPN);
    this.Bpv.setTextSize(0, this.gPN);
    this.Bpw.setTextSize(0, this.gPN);
    this.Bpx.setTextSize(0, this.gPN);
    this.Bpy.setTextSize(0, this.gPN);
    this.Bpp.setTextColor(this.BpJ);
    this.Bpq.setTextColor(this.BpJ);
    this.Bpr.setTextColor(this.BpJ);
    this.Bps.setTextColor(this.BpJ);
    this.Bpt.setTextColor(this.BpJ);
    this.Bpu.setTextColor(this.BpJ);
    this.Bpv.setTextColor(this.BpJ);
    this.Bpw.setTextColor(this.BpJ);
    this.Bpx.setTextColor(this.BpJ);
    this.Bpy.setTextColor(this.BpJ);
    this.Bpp.setOnClickListener(this);
    this.Bpq.setOnClickListener(this);
    this.Bpr.setOnClickListener(this);
    this.Bps.setOnClickListener(this);
    this.Bpt.setOnClickListener(this);
    this.Bpu.setOnClickListener(this);
    this.Bpv.setOnClickListener(this);
    this.Bpw.setOnClickListener(this);
    this.Bpx.setOnClickListener(this);
    this.Bpy.setOnClickListener(this);
    this.Bpz.setOnClickListener(this);
    this.Bpz.setOnLongClickListener(this);
    this.BpA.setBackgroundColor(this.BpK);
    this.BpA.setBackgroundColor(this.BpK);
    this.BpB.setBackgroundColor(this.BpK);
    this.BpC.setBackgroundColor(this.BpK);
    this.BpD.setBackgroundColor(this.BpK);
    this.BpE.setBackgroundColor(this.BpK);
    this.BpF.setBackgroundColor(this.BpK);
    addView(this.Bpp);
    addView(this.Bpq);
    addView(this.Bpr);
    addView(this.Bps);
    addView(this.Bpt);
    addView(this.Bpu);
    addView(this.Bpv);
    addView(this.Bpw);
    addView(this.Bpx);
    addView(this.Bpy);
    addView(this.Bpz);
    addView(this.BpA);
    addView(this.BpB);
    addView(this.BpC);
    addView(this.BpD);
    addView(this.BpE);
    addView(this.BpF);
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
    if ((this.BoW != null) && (this.BpG)) {
      this.BoW.input(paramString);
    }
    AppMethodBeat.o(27692);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27689);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!this.BpG)
    {
      Log.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.Bpp) {
      input("0");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
      if (paramView == this.Bpq) {
        input("1");
      } else if (paramView == this.Bpr) {
        input("2");
      } else if (paramView == this.Bps) {
        input("3");
      } else if (paramView == this.Bpt) {
        input("4");
      } else if (paramView == this.Bpu) {
        input("5");
      } else if (paramView == this.Bpv) {
        input("6");
      } else if (paramView == this.Bpw) {
        input("7");
      } else if (paramView == this.Bpx) {
        input("8");
      } else if (paramView == this.Bpy) {
        input("9");
      } else if ((paramView == this.Bpz) && (this.BoW != null) && (this.BpG)) {
        this.BoW.delete();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27687);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.BpL = getWidth();
    this.BpM = getHeight();
    paramInt1 = -this.BpI;
    paramInt2 = this.BpP - this.BpI + 1;
    paramInt3 = this.BpP * 2 - this.BpI + 2;
    paramInt4 = this.BpQ + 2;
    int i = this.BpQ * 2 + 3;
    int j = this.BpQ * 3 + 4;
    this.Bpq.layout(paramInt1, 1, this.BpN + paramInt1, this.BpO + 1);
    this.Bpr.layout(paramInt2, 1, this.BpN + paramInt2, this.BpO + 1);
    this.Bps.layout(paramInt3, 1, this.BpN + paramInt3, this.BpO + 1);
    this.Bpt.layout(paramInt1, paramInt4, this.BpN + paramInt1, this.BpO + paramInt4);
    this.Bpu.layout(paramInt2, paramInt4, this.BpN + paramInt2, this.BpO + paramInt4);
    this.Bpv.layout(paramInt3, paramInt4, this.BpN + paramInt3, this.BpO + paramInt4);
    this.Bpw.layout(paramInt1, i, this.BpN + paramInt1, this.BpO + i);
    this.Bpx.layout(paramInt2, i, this.BpN + paramInt2, this.BpO + i);
    this.Bpy.layout(paramInt3, i, this.BpN + paramInt3, this.BpO + i);
    this.Bpp.layout(paramInt2, j, this.BpN + paramInt2, this.BpO + j);
    this.Bpz.layout(paramInt3, j, this.BpN + paramInt3, this.BpO + j);
    this.BpA.layout(0, this.BpH + 1, this.BpL, this.BpH + 1 + 1);
    this.BpB.layout(0, this.BpH + paramInt4, this.BpL, paramInt4 + this.BpH + 1);
    this.BpC.layout(0, this.BpH + i, this.BpL, i + this.BpH + 1);
    this.BpD.layout(0, this.BpH + j, this.BpL, this.BpH + j + 1);
    this.BpE.layout(this.BpP + 1, this.BpH, this.BpP + 2, this.BpM);
    this.BpF.layout(this.BpP * 2 + 2, this.BpH, this.BpP * 2 + 3, this.BpM);
    AppMethodBeat.o(27687);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27690);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    if ((paramView == this.Bpz) && (this.BoW != null) && (this.BpG)) {
      this.BoW.byC();
    }
    a.a(false, this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27690);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27688);
    super.onMeasure(paramInt1, paramInt2);
    this.BpL = getWidth();
    this.BpM = getHeight();
    if ((this.BpL != 0) && (this.BpM != 0))
    {
      this.BpP = ((this.BpL - 2) / 3);
      this.BpQ = ((this.BpM - this.BpH - 4) / 4);
      this.BpN = (this.BpP + this.BpI * 2);
      this.BpO = (this.BpQ + this.BpH * 2);
    }
    this.Bpq.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpr.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bps.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpt.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpu.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpv.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpw.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpx.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpy.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpp.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.Bpz.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
    this.BpA.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.BpB.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.BpC.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.BpD.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.BpE.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpM, 1073741824));
    this.BpF.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpM, 1073741824));
    AppMethodBeat.o(27688);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(27691);
    this.BpG = paramBoolean;
    this.Bpp.setEnabled(paramBoolean);
    this.Bpq.setEnabled(paramBoolean);
    this.Bpr.setEnabled(paramBoolean);
    this.Bps.setEnabled(paramBoolean);
    this.Bpt.setEnabled(paramBoolean);
    this.Bpu.setEnabled(paramBoolean);
    this.Bpv.setEnabled(paramBoolean);
    this.Bpw.setEnabled(paramBoolean);
    this.Bpx.setEnabled(paramBoolean);
    this.Bpy.setEnabled(paramBoolean);
    this.Bpz.setEnabled(paramBoolean);
    AppMethodBeat.o(27691);
  }
  
  public void setOnInputDeleteListener(a parama)
  {
    this.BoW = parama;
  }
  
  public static abstract interface a
  {
    public abstract void byC();
    
    public abstract void delete();
    
    public abstract void input(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */