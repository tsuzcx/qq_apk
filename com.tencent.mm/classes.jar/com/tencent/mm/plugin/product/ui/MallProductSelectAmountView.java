package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class MallProductSelectAmountView
  extends LinearLayout
{
  private TextView iXQ;
  private ImageView xdH;
  private ImageView xdI;
  private int xdJ;
  private int xdK;
  private int xdL;
  private int xdM;
  private a xdN;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67003);
    this.iXQ = null;
    this.xdH = null;
    this.xdI = null;
    this.xdJ = 2147483647;
    this.xdK = 1;
    this.xdL = 1;
    this.xdM = this.xdL;
    this.xdN = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495125, this, true);
    this.iXQ = ((TextView)paramContext.findViewById(2131302098));
    this.xdH = ((ImageView)paramContext.findViewById(2131302097));
    this.xdI = ((ImageView)paramContext.findViewById(2131302103));
    this.iXQ.setText(this.xdM);
    this.xdH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67001);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) + 1 > MallProductSelectAmountView.b(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).he(MallProductSelectAmountView.a(MallProductSelectAmountView.this), MallProductSelectAmountView.d(MallProductSelectAmountView.this));
          }
          a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67001);
          return;
        }
        MallProductSelectAmountView.e(MallProductSelectAmountView.this);
        if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
          MallProductSelectAmountView.g(MallProductSelectAmountView.this).setText(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hF(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67001);
      }
    });
    this.xdI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67002);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).he(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
          }
          a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67002);
          return;
        }
        MallProductSelectAmountView.i(MallProductSelectAmountView.this);
        if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
          MallProductSelectAmountView.g(MallProductSelectAmountView.this).setText(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        MallProductSelectAmountView.f(MallProductSelectAmountView.this);
        if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hF(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67002);
      }
    });
    AppMethodBeat.o(67003);
  }
  
  private boolean dDm()
  {
    AppMethodBeat.i(67005);
    if (this.xdM > this.xdJ)
    {
      this.xdM = this.xdJ;
      if (this.xdN != null) {
        this.xdN.hF(this.xdM);
      }
      if (this.xdN != null) {
        this.xdN.he(this.xdM, this.xdK);
      }
      this.iXQ.setText(this.xdM);
      AppMethodBeat.o(67005);
      return false;
    }
    if (this.xdM > this.xdL) {
      this.xdI.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(67005);
      return true;
      if (this.xdM != this.xdL) {
        break;
      }
      this.xdI.setEnabled(false);
    }
    this.xdI.setEnabled(false);
    this.xdM = this.xdL;
    if (this.xdN != null) {
      this.xdN.hF(this.xdM);
    }
    if (this.xdN != null) {
      this.xdN.he(this.xdM, 2);
    }
    this.iXQ.setText(this.xdM);
    AppMethodBeat.o(67005);
    return false;
  }
  
  public final void hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67008);
    if (paramInt1 > paramInt2) {
      this.xdK = 3;
    }
    for (this.xdJ = paramInt2;; this.xdJ = paramInt1)
    {
      dDm();
      if (this.xdN != null) {
        this.xdN.hF(this.xdM);
      }
      AppMethodBeat.o(67008);
      return;
      this.xdK = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67006);
    this.xdH.setEnabled(paramBoolean);
    AppMethodBeat.o(67006);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(67004);
    this.xdM = paramInt;
    if (dDm())
    {
      this.iXQ.setText(this.xdM);
      if (this.xdN != null) {
        this.xdN.hF(this.xdM);
      }
    }
    AppMethodBeat.o(67004);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(67009);
    this.xdL = paramInt;
    dDm();
    AppMethodBeat.o(67009);
  }
  
  public void setOnAmountChangeListener(a parama)
  {
    this.xdN = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67007);
    this.xdI.setEnabled(paramBoolean);
    AppMethodBeat.o(67007);
  }
  
  public static abstract interface a
  {
    public abstract void hF(int paramInt);
    
    public abstract void he(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */