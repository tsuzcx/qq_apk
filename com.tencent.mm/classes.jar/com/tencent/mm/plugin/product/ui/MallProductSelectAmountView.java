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

public class MallProductSelectAmountView
  extends LinearLayout
{
  private TextView ibG;
  private ImageView uxT;
  private ImageView uxU;
  private int uxV;
  private int uxW;
  private int uxX;
  private int uxY;
  private a uxZ;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67003);
    this.ibG = null;
    this.uxT = null;
    this.uxU = null;
    this.uxV = 2147483647;
    this.uxW = 1;
    this.uxX = 1;
    this.uxY = this.uxX;
    this.uxZ = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495125, this, true);
    this.ibG = ((TextView)paramContext.findViewById(2131302098));
    this.uxT = ((ImageView)paramContext.findViewById(2131302097));
    this.uxU = ((ImageView)paramContext.findViewById(2131302103));
    this.ibG.setText(this.uxY);
    this.uxT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67001);
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) + 1 > MallProductSelectAmountView.b(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).gD(MallProductSelectAmountView.a(MallProductSelectAmountView.this), MallProductSelectAmountView.d(MallProductSelectAmountView.this));
          }
          AppMethodBeat.o(67001);
          return;
        }
        MallProductSelectAmountView.e(MallProductSelectAmountView.this);
        if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
          MallProductSelectAmountView.g(MallProductSelectAmountView.this).setText(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hM(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        AppMethodBeat.o(67001);
      }
    });
    this.uxU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67002);
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).gD(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
          }
          AppMethodBeat.o(67002);
          return;
        }
        MallProductSelectAmountView.i(MallProductSelectAmountView.this);
        if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
          MallProductSelectAmountView.g(MallProductSelectAmountView.this).setText(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        MallProductSelectAmountView.f(MallProductSelectAmountView.this);
        if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hM(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        AppMethodBeat.o(67002);
      }
    });
    AppMethodBeat.o(67003);
  }
  
  private boolean dbL()
  {
    AppMethodBeat.i(67005);
    if (this.uxY > this.uxV)
    {
      this.uxY = this.uxV;
      if (this.uxZ != null) {
        this.uxZ.hM(this.uxY);
      }
      if (this.uxZ != null) {
        this.uxZ.gD(this.uxY, this.uxW);
      }
      this.ibG.setText(this.uxY);
      AppMethodBeat.o(67005);
      return false;
    }
    if (this.uxY > this.uxX) {
      this.uxU.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(67005);
      return true;
      if (this.uxY != this.uxX) {
        break;
      }
      this.uxU.setEnabled(false);
    }
    this.uxU.setEnabled(false);
    this.uxY = this.uxX;
    if (this.uxZ != null) {
      this.uxZ.hM(this.uxY);
    }
    if (this.uxZ != null) {
      this.uxZ.gD(this.uxY, 2);
    }
    this.ibG.setText(this.uxY);
    AppMethodBeat.o(67005);
    return false;
  }
  
  public final void gC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67008);
    if (paramInt1 > paramInt2) {
      this.uxW = 3;
    }
    for (this.uxV = paramInt2;; this.uxV = paramInt1)
    {
      dbL();
      if (this.uxZ != null) {
        this.uxZ.hM(this.uxY);
      }
      AppMethodBeat.o(67008);
      return;
      this.uxW = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67006);
    this.uxT.setEnabled(paramBoolean);
    AppMethodBeat.o(67006);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(67004);
    this.uxY = paramInt;
    if (dbL())
    {
      this.ibG.setText(this.uxY);
      if (this.uxZ != null) {
        this.uxZ.hM(this.uxY);
      }
    }
    AppMethodBeat.o(67004);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(67009);
    this.uxX = paramInt;
    dbL();
    AppMethodBeat.o(67009);
  }
  
  public void setOnAmountChangeListener(a parama)
  {
    this.uxZ = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67007);
    this.uxU.setEnabled(paramBoolean);
    AppMethodBeat.o(67007);
  }
  
  public static abstract interface a
  {
    public abstract void gD(int paramInt1, int paramInt2);
    
    public abstract void hM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */