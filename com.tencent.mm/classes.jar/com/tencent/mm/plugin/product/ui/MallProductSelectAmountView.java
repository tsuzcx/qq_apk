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
  private TextView iUX;
  private ImageView wNT;
  private ImageView wNU;
  private int wNV;
  private int wNW;
  private int wNX;
  private int wNY;
  private a wNZ;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67003);
    this.iUX = null;
    this.wNT = null;
    this.wNU = null;
    this.wNV = 2147483647;
    this.wNW = 1;
    this.wNX = 1;
    this.wNY = this.wNX;
    this.wNZ = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495125, this, true);
    this.iUX = ((TextView)paramContext.findViewById(2131302098));
    this.wNT = ((ImageView)paramContext.findViewById(2131302097));
    this.wNU = ((ImageView)paramContext.findViewById(2131302103));
    this.iUX.setText(this.wNY);
    this.wNT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67001);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) + 1 > MallProductSelectAmountView.b(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).hc(MallProductSelectAmountView.a(MallProductSelectAmountView.this), MallProductSelectAmountView.d(MallProductSelectAmountView.this));
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hD(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67001);
      }
    });
    this.wNU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67002);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).hc(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hD(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67002);
      }
    });
    AppMethodBeat.o(67003);
  }
  
  private boolean dzV()
  {
    AppMethodBeat.i(67005);
    if (this.wNY > this.wNV)
    {
      this.wNY = this.wNV;
      if (this.wNZ != null) {
        this.wNZ.hD(this.wNY);
      }
      if (this.wNZ != null) {
        this.wNZ.hc(this.wNY, this.wNW);
      }
      this.iUX.setText(this.wNY);
      AppMethodBeat.o(67005);
      return false;
    }
    if (this.wNY > this.wNX) {
      this.wNU.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(67005);
      return true;
      if (this.wNY != this.wNX) {
        break;
      }
      this.wNU.setEnabled(false);
    }
    this.wNU.setEnabled(false);
    this.wNY = this.wNX;
    if (this.wNZ != null) {
      this.wNZ.hD(this.wNY);
    }
    if (this.wNZ != null) {
      this.wNZ.hc(this.wNY, 2);
    }
    this.iUX.setText(this.wNY);
    AppMethodBeat.o(67005);
    return false;
  }
  
  public final void hb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67008);
    if (paramInt1 > paramInt2) {
      this.wNW = 3;
    }
    for (this.wNV = paramInt2;; this.wNV = paramInt1)
    {
      dzV();
      if (this.wNZ != null) {
        this.wNZ.hD(this.wNY);
      }
      AppMethodBeat.o(67008);
      return;
      this.wNW = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67006);
    this.wNT.setEnabled(paramBoolean);
    AppMethodBeat.o(67006);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(67004);
    this.wNY = paramInt;
    if (dzV())
    {
      this.iUX.setText(this.wNY);
      if (this.wNZ != null) {
        this.wNZ.hD(this.wNY);
      }
    }
    AppMethodBeat.o(67004);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(67009);
    this.wNX = paramInt;
    dzV();
    AppMethodBeat.o(67009);
  }
  
  public void setOnAmountChangeListener(a parama)
  {
    this.wNZ = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67007);
    this.wNU.setEnabled(paramBoolean);
    AppMethodBeat.o(67007);
  }
  
  public static abstract interface a
  {
    public abstract void hD(int paramInt);
    
    public abstract void hc(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */