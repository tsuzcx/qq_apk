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
  private ImageView GVh;
  private ImageView GVi;
  private int GVj;
  private int GVk;
  private int GVl;
  private int GVm;
  private a GVn;
  private TextView mMc;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67003);
    this.mMc = null;
    this.GVh = null;
    this.GVi = null;
    this.GVj = 2147483647;
    this.GVk = 1;
    this.GVl = 1;
    this.GVm = this.GVl;
    this.GVn = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a.g.product_select_amount, this, true);
    this.mMc = ((TextView)paramContext.findViewById(a.f.mall_product_select_sku_count));
    this.GVh = ((ImageView)paramContext.findViewById(a.f.mall_product_select_sku_add));
    this.GVi = ((ImageView)paramContext.findViewById(a.f.mall_product_select_sku_remove));
    this.mMc.setText(this.GVm);
    this.GVh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67001);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) + 1 > MallProductSelectAmountView.b(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).iT(MallProductSelectAmountView.a(MallProductSelectAmountView.this), MallProductSelectAmountView.d(MallProductSelectAmountView.this));
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).kp(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67001);
      }
    });
    this.GVi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67002);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).iT(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).kp(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67002);
      }
    });
    AppMethodBeat.o(67003);
  }
  
  private boolean fpw()
  {
    AppMethodBeat.i(67005);
    if (this.GVm > this.GVj)
    {
      this.GVm = this.GVj;
      if (this.GVn != null) {
        this.GVn.kp(this.GVm);
      }
      if (this.GVn != null) {
        this.GVn.iT(this.GVm, this.GVk);
      }
      this.mMc.setText(this.GVm);
      AppMethodBeat.o(67005);
      return false;
    }
    if (this.GVm > this.GVl) {
      this.GVi.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(67005);
      return true;
      if (this.GVm != this.GVl) {
        break;
      }
      this.GVi.setEnabled(false);
    }
    this.GVi.setEnabled(false);
    this.GVm = this.GVl;
    if (this.GVn != null) {
      this.GVn.kp(this.GVm);
    }
    if (this.GVn != null) {
      this.GVn.iT(this.GVm, 2);
    }
    this.mMc.setText(this.GVm);
    AppMethodBeat.o(67005);
    return false;
  }
  
  public final void iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67008);
    if (paramInt1 > paramInt2) {
      this.GVk = 3;
    }
    for (this.GVj = paramInt2;; this.GVj = paramInt1)
    {
      fpw();
      if (this.GVn != null) {
        this.GVn.kp(this.GVm);
      }
      AppMethodBeat.o(67008);
      return;
      this.GVk = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67006);
    this.GVh.setEnabled(paramBoolean);
    AppMethodBeat.o(67006);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(67004);
    this.GVm = paramInt;
    if (fpw())
    {
      this.mMc.setText(this.GVm);
      if (this.GVn != null) {
        this.GVn.kp(this.GVm);
      }
    }
    AppMethodBeat.o(67004);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(67009);
    this.GVl = paramInt;
    fpw();
    AppMethodBeat.o(67009);
  }
  
  public void setOnAmountChangeListener(a parama)
  {
    this.GVn = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67007);
    this.GVi.setEnabled(paramBoolean);
    AppMethodBeat.o(67007);
  }
  
  public static abstract interface a
  {
    public abstract void iT(int paramInt1, int paramInt2);
    
    public abstract void kp(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */