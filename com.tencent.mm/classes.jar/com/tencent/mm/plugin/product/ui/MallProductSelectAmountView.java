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
  private TextView iBN;
  private ImageView vGM;
  private ImageView vGN;
  private int vGO;
  private int vGP;
  private int vGQ;
  private int vGR;
  private a vGS;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67003);
    this.iBN = null;
    this.vGM = null;
    this.vGN = null;
    this.vGO = 2147483647;
    this.vGP = 1;
    this.vGQ = 1;
    this.vGR = this.vGQ;
    this.vGS = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495125, this, true);
    this.iBN = ((TextView)paramContext.findViewById(2131302098));
    this.vGM = ((ImageView)paramContext.findViewById(2131302097));
    this.vGN = ((ImageView)paramContext.findViewById(2131302103));
    this.iBN.setText(this.vGR);
    this.vGM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67001);
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) + 1 > MallProductSelectAmountView.b(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).gK(MallProductSelectAmountView.a(MallProductSelectAmountView.this), MallProductSelectAmountView.d(MallProductSelectAmountView.this));
          }
          AppMethodBeat.o(67001);
          return;
        }
        MallProductSelectAmountView.e(MallProductSelectAmountView.this);
        if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
          MallProductSelectAmountView.g(MallProductSelectAmountView.this).setText(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hw(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        AppMethodBeat.o(67001);
      }
    });
    this.vGN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67002);
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this))
        {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).gK(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
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
          MallProductSelectAmountView.c(MallProductSelectAmountView.this).hw(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
        }
        AppMethodBeat.o(67002);
      }
    });
    AppMethodBeat.o(67003);
  }
  
  private boolean dpt()
  {
    AppMethodBeat.i(67005);
    if (this.vGR > this.vGO)
    {
      this.vGR = this.vGO;
      if (this.vGS != null) {
        this.vGS.hw(this.vGR);
      }
      if (this.vGS != null) {
        this.vGS.gK(this.vGR, this.vGP);
      }
      this.iBN.setText(this.vGR);
      AppMethodBeat.o(67005);
      return false;
    }
    if (this.vGR > this.vGQ) {
      this.vGN.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(67005);
      return true;
      if (this.vGR != this.vGQ) {
        break;
      }
      this.vGN.setEnabled(false);
    }
    this.vGN.setEnabled(false);
    this.vGR = this.vGQ;
    if (this.vGS != null) {
      this.vGS.hw(this.vGR);
    }
    if (this.vGS != null) {
      this.vGS.gK(this.vGR, 2);
    }
    this.iBN.setText(this.vGR);
    AppMethodBeat.o(67005);
    return false;
  }
  
  public final void gJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67008);
    if (paramInt1 > paramInt2) {
      this.vGP = 3;
    }
    for (this.vGO = paramInt2;; this.vGO = paramInt1)
    {
      dpt();
      if (this.vGS != null) {
        this.vGS.hw(this.vGR);
      }
      AppMethodBeat.o(67008);
      return;
      this.vGP = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67006);
    this.vGM.setEnabled(paramBoolean);
    AppMethodBeat.o(67006);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(67004);
    this.vGR = paramInt;
    if (dpt())
    {
      this.iBN.setText(this.vGR);
      if (this.vGS != null) {
        this.vGS.hw(this.vGR);
      }
    }
    AppMethodBeat.o(67004);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(67009);
    this.vGQ = paramInt;
    dpt();
    AppMethodBeat.o(67009);
  }
  
  public void setOnAmountChangeListener(a parama)
  {
    this.vGS = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(67007);
    this.vGN.setEnabled(paramBoolean);
    AppMethodBeat.o(67007);
  }
  
  public static abstract interface a
  {
    public abstract void gK(int paramInt1, int paramInt2);
    
    public abstract void hw(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */