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
import com.tencent.mm.sdk.platformtools.ae;

public class MMKeyBoardView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private Context mContext;
  private float pDQ;
  private a xoK;
  private int xpA;
  private int xpB;
  private int xpC;
  private int xpD;
  private int xpE;
  private Button xpd;
  private Button xpe;
  private Button xpf;
  private Button xpg;
  private Button xph;
  private Button xpi;
  private Button xpj;
  private Button xpk;
  private Button xpl;
  private Button xpm;
  private ImageButton xpn;
  private View xpo;
  private View xpp;
  private View xpq;
  private View xpr;
  private View xps;
  private View xpt;
  private boolean xpu;
  private int xpv;
  private int xpw;
  private ColorStateList xpx;
  private int xpy;
  private int xpz;
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMKeyBoardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27686);
    this.xpu = true;
    this.mContext = paramContext;
    this.xpv = getResources().getDimensionPixelSize(2131166466);
    this.xpw = getResources().getDimensionPixelSize(2131166467);
    this.pDQ = getResources().getDimensionPixelSize(2131166468);
    this.xpx = getResources().getColorStateList(2131100527);
    this.xpy = getResources().getColor(2131100526);
    this.xpd = new Button(this.mContext);
    this.xpe = new Button(this.mContext);
    this.xpf = new Button(this.mContext);
    this.xpg = new Button(this.mContext);
    this.xph = new Button(this.mContext);
    this.xpi = new Button(this.mContext);
    this.xpj = new Button(this.mContext);
    this.xpk = new Button(this.mContext);
    this.xpl = new Button(this.mContext);
    this.xpm = new Button(this.mContext);
    this.xpn = new ImageButton(this.mContext);
    this.xpo = new View(this.mContext);
    this.xpo = new View(this.mContext);
    this.xpp = new View(this.mContext);
    this.xpq = new View(this.mContext);
    this.xpr = new View(this.mContext);
    this.xps = new View(this.mContext);
    this.xpt = new View(this.mContext);
    this.xpd.setBackgroundResource(2131232759);
    this.xpe.setBackgroundResource(2131232759);
    this.xpf.setBackgroundResource(2131232759);
    this.xpg.setBackgroundResource(2131232759);
    this.xph.setBackgroundResource(2131232759);
    this.xpi.setBackgroundResource(2131232759);
    this.xpj.setBackgroundResource(2131232759);
    this.xpk.setBackgroundResource(2131232759);
    this.xpl.setBackgroundResource(2131232759);
    this.xpi.setBackgroundResource(2131232759);
    this.xpm.setBackgroundResource(2131232759);
    this.xpn.setBackgroundResource(2131232759);
    this.xpn.setImageResource(2131232760);
    this.xpd.setText("0");
    this.xpe.setText("1");
    this.xpf.setText("2");
    this.xpg.setText("3");
    this.xph.setText("4");
    this.xpi.setText("5");
    this.xpj.setText("6");
    this.xpk.setText("7");
    this.xpl.setText("8");
    this.xpm.setText("9");
    this.xpd.setGravity(17);
    this.xpe.setGravity(17);
    this.xpf.setGravity(17);
    this.xpg.setGravity(17);
    this.xph.setGravity(17);
    this.xpi.setGravity(17);
    this.xpj.setGravity(17);
    this.xpk.setGravity(17);
    this.xpl.setGravity(17);
    this.xpm.setGravity(17);
    this.xpd.setTextSize(0, this.pDQ);
    this.xpe.setTextSize(0, this.pDQ);
    this.xpf.setTextSize(0, this.pDQ);
    this.xpg.setTextSize(0, this.pDQ);
    this.xph.setTextSize(0, this.pDQ);
    this.xpi.setTextSize(0, this.pDQ);
    this.xpj.setTextSize(0, this.pDQ);
    this.xpk.setTextSize(0, this.pDQ);
    this.xpl.setTextSize(0, this.pDQ);
    this.xpm.setTextSize(0, this.pDQ);
    this.xpd.setTextColor(this.xpx);
    this.xpe.setTextColor(this.xpx);
    this.xpf.setTextColor(this.xpx);
    this.xpg.setTextColor(this.xpx);
    this.xph.setTextColor(this.xpx);
    this.xpi.setTextColor(this.xpx);
    this.xpj.setTextColor(this.xpx);
    this.xpk.setTextColor(this.xpx);
    this.xpl.setTextColor(this.xpx);
    this.xpm.setTextColor(this.xpx);
    this.xpd.setOnClickListener(this);
    this.xpe.setOnClickListener(this);
    this.xpf.setOnClickListener(this);
    this.xpg.setOnClickListener(this);
    this.xph.setOnClickListener(this);
    this.xpi.setOnClickListener(this);
    this.xpj.setOnClickListener(this);
    this.xpk.setOnClickListener(this);
    this.xpl.setOnClickListener(this);
    this.xpm.setOnClickListener(this);
    this.xpn.setOnClickListener(this);
    this.xpn.setOnLongClickListener(this);
    this.xpo.setBackgroundColor(this.xpy);
    this.xpo.setBackgroundColor(this.xpy);
    this.xpp.setBackgroundColor(this.xpy);
    this.xpq.setBackgroundColor(this.xpy);
    this.xpr.setBackgroundColor(this.xpy);
    this.xps.setBackgroundColor(this.xpy);
    this.xpt.setBackgroundColor(this.xpy);
    addView(this.xpd);
    addView(this.xpe);
    addView(this.xpf);
    addView(this.xpg);
    addView(this.xph);
    addView(this.xpi);
    addView(this.xpj);
    addView(this.xpk);
    addView(this.xpl);
    addView(this.xpm);
    addView(this.xpn);
    addView(this.xpo);
    addView(this.xpp);
    addView(this.xpq);
    addView(this.xpr);
    addView(this.xps);
    addView(this.xpt);
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
    if ((this.xoK != null) && (this.xpu)) {
      this.xoK.input(paramString);
    }
    AppMethodBeat.o(27692);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27689);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!this.xpu)
    {
      ae.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
    }
    if (paramView == this.xpd) {
      input("0");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27689);
      return;
      if (paramView == this.xpe) {
        input("1");
      } else if (paramView == this.xpf) {
        input("2");
      } else if (paramView == this.xpg) {
        input("3");
      } else if (paramView == this.xph) {
        input("4");
      } else if (paramView == this.xpi) {
        input("5");
      } else if (paramView == this.xpj) {
        input("6");
      } else if (paramView == this.xpk) {
        input("7");
      } else if (paramView == this.xpl) {
        input("8");
      } else if (paramView == this.xpm) {
        input("9");
      } else if ((paramView == this.xpn) && (this.xoK != null) && (this.xpu)) {
        this.xoK.delete();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27687);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.xpz = getWidth();
    this.xpA = getHeight();
    paramInt1 = -this.xpw;
    paramInt2 = this.xpD - this.xpw + 1;
    paramInt3 = this.xpD * 2 - this.xpw + 2;
    paramInt4 = this.xpE + 2;
    int i = this.xpE * 2 + 3;
    int j = this.xpE * 3 + 4;
    this.xpe.layout(paramInt1, 1, this.xpB + paramInt1, this.xpC + 1);
    this.xpf.layout(paramInt2, 1, this.xpB + paramInt2, this.xpC + 1);
    this.xpg.layout(paramInt3, 1, this.xpB + paramInt3, this.xpC + 1);
    this.xph.layout(paramInt1, paramInt4, this.xpB + paramInt1, this.xpC + paramInt4);
    this.xpi.layout(paramInt2, paramInt4, this.xpB + paramInt2, this.xpC + paramInt4);
    this.xpj.layout(paramInt3, paramInt4, this.xpB + paramInt3, this.xpC + paramInt4);
    this.xpk.layout(paramInt1, i, this.xpB + paramInt1, this.xpC + i);
    this.xpl.layout(paramInt2, i, this.xpB + paramInt2, this.xpC + i);
    this.xpm.layout(paramInt3, i, this.xpB + paramInt3, this.xpC + i);
    this.xpd.layout(paramInt2, j, this.xpB + paramInt2, this.xpC + j);
    this.xpn.layout(paramInt3, j, this.xpB + paramInt3, this.xpC + j);
    this.xpo.layout(0, this.xpv + 1, this.xpz, this.xpv + 1 + 1);
    this.xpp.layout(0, this.xpv + paramInt4, this.xpz, paramInt4 + this.xpv + 1);
    this.xpq.layout(0, this.xpv + i, this.xpz, i + this.xpv + 1);
    this.xpr.layout(0, this.xpv + j, this.xpz, this.xpv + j + 1);
    this.xps.layout(this.xpD + 1, this.xpv, this.xpD + 2, this.xpA);
    this.xpt.layout(this.xpD * 2 + 2, this.xpv, this.xpD * 2 + 3, this.xpA);
    AppMethodBeat.o(27687);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27690);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    if ((paramView == this.xpn) && (this.xoK != null) && (this.xpu)) {
      this.xoK.bdi();
    }
    a.a(false, this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27690);
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27688);
    super.onMeasure(paramInt1, paramInt2);
    this.xpz = getWidth();
    this.xpA = getHeight();
    if ((this.xpz != 0) && (this.xpA != 0))
    {
      this.xpD = ((this.xpz - 2) / 3);
      this.xpE = ((this.xpA - this.xpv - 4) / 4);
      this.xpB = (this.xpD + this.xpw * 2);
      this.xpC = (this.xpE + this.xpv * 2);
    }
    this.xpe.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpf.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpg.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xph.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpi.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpj.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpk.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpl.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpm.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpd.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpn.measure(View.MeasureSpec.makeMeasureSpec(this.xpB, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpC, 1073741824));
    this.xpo.measure(View.MeasureSpec.makeMeasureSpec(this.xpz, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.xpp.measure(View.MeasureSpec.makeMeasureSpec(this.xpz, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.xpq.measure(View.MeasureSpec.makeMeasureSpec(this.xpz, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.xpr.measure(View.MeasureSpec.makeMeasureSpec(this.xpz, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    this.xps.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpA, 1073741824));
    this.xpt.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.xpA, 1073741824));
    AppMethodBeat.o(27688);
  }
  
  public void setKeyBoardEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(27691);
    this.xpu = paramBoolean;
    this.xpd.setEnabled(paramBoolean);
    this.xpe.setEnabled(paramBoolean);
    this.xpf.setEnabled(paramBoolean);
    this.xpg.setEnabled(paramBoolean);
    this.xph.setEnabled(paramBoolean);
    this.xpi.setEnabled(paramBoolean);
    this.xpj.setEnabled(paramBoolean);
    this.xpk.setEnabled(paramBoolean);
    this.xpl.setEnabled(paramBoolean);
    this.xpm.setEnabled(paramBoolean);
    this.xpn.setEnabled(paramBoolean);
    AppMethodBeat.o(27691);
  }
  
  public void setOnInputDeleteListener(a parama)
  {
    this.xoK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bdi();
    
    public abstract void delete();
    
    public abstract void input(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView
 * JD-Core Version:    0.7.0.1
 */