package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.R.h;

final class ProductUI$b
{
  int Xc;
  ProductScrollView nKK = (ProductScrollView)this.nKF.findViewById(R.h.pruduct_root_sv);
  boolean nKL;
  private ProductScrollView.a nKM = new ProductUI.b.1(this);
  
  public ProductUI$b(ProductUI paramProductUI)
  {
    this.nKK.setOnScrollListener(this.nKM);
    this.Xc = ProductUI.u(this.nKF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.b
 * JD-Core Version:    0.7.0.1
 */