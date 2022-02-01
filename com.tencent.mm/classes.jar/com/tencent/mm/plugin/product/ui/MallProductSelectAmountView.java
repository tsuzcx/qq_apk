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
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class MallProductSelectAmountView
  extends LinearLayout
{
  private ImageView MSJ;
  private ImageView MSK;
  private int MSL;
  private int MSM;
  private int MSN;
  private int MSO;
  private a MSP;
  private TextView pIK;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67003);
    this.pIK = null;
    this.MSJ = null;
    this.MSK = null;
    this.MSL = 2147483647;
    this.MSM = 1;
    this.MSN = 1;
    this.MSO = this.MSN;
    this.MSP = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a.g.product_select_amount, this, true);
    this.pIK = ((TextView)paramContext.findViewById(a.f.mall_product_select_sku_count));
    this.MSJ = ((ImageView)paramContext.findViewById(a.f.mall_product_select_sku_add));
    this.MSK = ((ImageView)paramContext.findViewById(a.f.mall_product_select_sku_remove));
    this.pIK.setText(this.MSO);
    this.MSJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67001);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) + 1 > MallProductSelectAmountView.b(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).kz(MallProductSelectAmountView.a(MallProductSelectAmountView.this), MallProductSelectAmountView.d(MallProductSelectAmountView.this));
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).onChange(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67001);
      }
    });
    this.MSK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67002);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).kz(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).onChange(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67002);
      }
    });
    AppMethodBeat.o(67003);
  }
  
  private boolean gAB()
  {
    AppMethodBeat.i(67005);
    if (this.MSO > this.MSL)
    {
      this.MSO = this.MSL;
      if (this.MSP != null) {
        this.MSP.onChange(this.MSO);
      }
      if (this.MSP != null) {
        this.MSP.kz(this.MSO, this.MSM);
      }
      this.pIK.setText(this.MSO);
      AppMethodBeat.o(67005);
      return false;
    }
    if (this.MSO > this.MSN) {
      this.MSK.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(67005);
      return true;
      if (this.MSO != this.MSN) {
        break;
      }
      this.MSK.setEnabled(false);
    }
    this.MSK.setEnabled(false);
    this.MSO = this.MSN;
    if (this.MSP != null) {
      this.MSP.onChange(this.MSO);
    }
    if (this.MSP != null) {
      this.MSP.kz(this.MSO, 2);
    }
    this.pIK.setText(this.MSO);
    AppMethodBeat.o(67005);
    return false;
  }
  
  public final void ky(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67008);
    if (paramInt1 > paramInt2) {
      this.MSM = 3;
    }
    for (this.MSL = paramInt2;; this.MSL = paramInt1)
    {
      gAB();
      if (this.MSP != null) {
        this.MSP.onChange(this.MSO);
      }
      AppMethodBeat.o(67008);
      return;
      this.MSM = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67006);
    this.MSJ.setEnabled(paramBoolean);
    AppMethodBeat.o(67006);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(67004);
    this.MSO = paramInt;
    if (gAB())
    {
      this.pIK.setText(this.MSO);
      if (this.MSP != null) {
        this.MSP.onChange(this.MSO);
      }
    }
    AppMethodBeat.o(67004);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(67009);
    this.MSN = paramInt;
    gAB();
    AppMethodBeat.o(67009);
  }
  
  public void setOnAmountChangeListener(a parama)
  {
    this.MSP = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67007);
    this.MSK.setEnabled(paramBoolean);
    AppMethodBeat.o(67007);
  }
  
  public static abstract interface a
  {
    public abstract void kz(int paramInt1, int paramInt2);
    
    public abstract void onChange(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */