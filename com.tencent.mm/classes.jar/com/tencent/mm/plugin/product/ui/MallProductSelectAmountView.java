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
  private ImageView Bbj;
  private ImageView Bbk;
  private int Bbl;
  private int Bbm;
  private int Bbn;
  private int Bbo;
  private a Bbp;
  private TextView jUP;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67003);
    this.jUP = null;
    this.Bbj = null;
    this.Bbk = null;
    this.Bbl = 2147483647;
    this.Bbm = 1;
    this.Bbn = 1;
    this.Bbo = this.Bbn;
    this.Bbp = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495968, this, true);
    this.jUP = ((TextView)paramContext.findViewById(2131304437));
    this.Bbj = ((ImageView)paramContext.findViewById(2131304436));
    this.Bbk = ((ImageView)paramContext.findViewById(2131304442));
    this.jUP.setText(this.Bbo);
    this.Bbj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67001);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) + 1 > MallProductSelectAmountView.b(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).hO(MallProductSelectAmountView.a(MallProductSelectAmountView.this), MallProductSelectAmountView.d(MallProductSelectAmountView.this));
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).iZ(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67001);
      }
    });
    this.Bbk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67002);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).hO(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).iZ(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67002);
      }
    });
    AppMethodBeat.o(67003);
  }
  
  private boolean eDE()
  {
    AppMethodBeat.i(67005);
    if (this.Bbo > this.Bbl)
    {
      this.Bbo = this.Bbl;
      if (this.Bbp != null) {
        this.Bbp.iZ(this.Bbo);
      }
      if (this.Bbp != null) {
        this.Bbp.hO(this.Bbo, this.Bbm);
      }
      this.jUP.setText(this.Bbo);
      AppMethodBeat.o(67005);
      return false;
    }
    if (this.Bbo > this.Bbn) {
      this.Bbk.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(67005);
      return true;
      if (this.Bbo != this.Bbn) {
        break;
      }
      this.Bbk.setEnabled(false);
    }
    this.Bbk.setEnabled(false);
    this.Bbo = this.Bbn;
    if (this.Bbp != null) {
      this.Bbp.iZ(this.Bbo);
    }
    if (this.Bbp != null) {
      this.Bbp.hO(this.Bbo, 2);
    }
    this.jUP.setText(this.Bbo);
    AppMethodBeat.o(67005);
    return false;
  }
  
  public final void hN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67008);
    if (paramInt1 > paramInt2) {
      this.Bbm = 3;
    }
    for (this.Bbl = paramInt2;; this.Bbl = paramInt1)
    {
      eDE();
      if (this.Bbp != null) {
        this.Bbp.iZ(this.Bbo);
      }
      AppMethodBeat.o(67008);
      return;
      this.Bbm = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67006);
    this.Bbj.setEnabled(paramBoolean);
    AppMethodBeat.o(67006);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(67004);
    this.Bbo = paramInt;
    if (eDE())
    {
      this.jUP.setText(this.Bbo);
      if (this.Bbp != null) {
        this.Bbp.iZ(this.Bbo);
      }
    }
    AppMethodBeat.o(67004);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(67009);
    this.Bbn = paramInt;
    eDE();
    AppMethodBeat.o(67009);
  }
  
  public void setOnAmountChangeListener(a parama)
  {
    this.Bbp = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67007);
    this.Bbk.setEnabled(paramBoolean);
    AppMethodBeat.o(67007);
  }
  
  public static abstract interface a
  {
    public abstract void hO(int paramInt1, int paramInt2);
    
    public abstract void iZ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */