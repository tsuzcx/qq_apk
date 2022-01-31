package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class MallProductSelectAmountView
  extends LinearLayout
{
  private TextView eXt = null;
  private ImageView mUf = null;
  private ImageView mUg = null;
  int mUh = 2147483647;
  int mUi = 1;
  private int mUj = 1;
  int mUk = this.mUj;
  MallProductSelectAmountView.a mUl = null;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a.g.product_select_amount, this, true);
    this.eXt = ((TextView)paramContext.findViewById(a.f.mall_product_select_sku_count));
    this.mUf = ((ImageView)paramContext.findViewById(a.f.mall_product_select_sku_add));
    this.mUg = ((ImageView)paramContext.findViewById(a.f.mall_product_select_sku_remove));
    this.eXt.setText(this.mUk);
    this.mUf.setOnClickListener(new MallProductSelectAmountView.1(this));
    this.mUg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (MallProductSelectAmountView.a(MallProductSelectAmountView.this) - 1 < MallProductSelectAmountView.h(MallProductSelectAmountView.this)) {
          if (MallProductSelectAmountView.c(MallProductSelectAmountView.this) != null) {
            MallProductSelectAmountView.c(MallProductSelectAmountView.this).dC(MallProductSelectAmountView.a(MallProductSelectAmountView.this), 2);
          }
        }
        do
        {
          return;
          MallProductSelectAmountView.i(MallProductSelectAmountView.this);
          if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
            MallProductSelectAmountView.g(MallProductSelectAmountView.this).setText(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
          }
          MallProductSelectAmountView.f(MallProductSelectAmountView.this);
        } while (MallProductSelectAmountView.c(MallProductSelectAmountView.this) == null);
        MallProductSelectAmountView.c(MallProductSelectAmountView.this).ex(MallProductSelectAmountView.a(MallProductSelectAmountView.this));
      }
    });
  }
  
  final boolean bsp()
  {
    if (this.mUk > this.mUh)
    {
      this.mUk = this.mUh;
      if (this.mUl != null) {
        this.mUl.ex(this.mUk);
      }
      if (this.mUl != null) {
        this.mUl.dC(this.mUk, this.mUi);
      }
      this.eXt.setText(this.mUk);
      return false;
    }
    if (this.mUk > this.mUj) {
      this.mUg.setEnabled(true);
    }
    for (;;)
    {
      return true;
      if (this.mUk != this.mUj) {
        break;
      }
      this.mUg.setEnabled(false);
    }
    this.mUg.setEnabled(false);
    this.mUk = this.mUj;
    if (this.mUl != null) {
      this.mUl.ex(this.mUk);
    }
    if (this.mUl != null) {
      this.mUl.dC(this.mUk, 2);
    }
    this.eXt.setText(this.mUk);
    return false;
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    this.mUf.setEnabled(paramBoolean);
  }
  
  public void setAmount(int paramInt)
  {
    this.mUk = paramInt;
    if (bsp())
    {
      this.eXt.setText(this.mUk);
      if (this.mUl != null) {
        this.mUl.ex(this.mUk);
      }
    }
  }
  
  public void setMinAmount(int paramInt)
  {
    this.mUj = paramInt;
    bsp();
  }
  
  public void setOnAmountChangeListener(MallProductSelectAmountView.a parama)
  {
    this.mUl = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    this.mUg.setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */