package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProductUI$b
{
  int XO;
  ProductScrollView qyn;
  boolean qyo;
  private ProductScrollView.a qyp;
  
  public ProductUI$b(ProductUI paramProductUI)
  {
    AppMethodBeat.i(81104);
    this.qyp = new ProductUI.b.1(this);
    this.qyn = ((ProductScrollView)this.qyh.findViewById(2131826771));
    this.qyn.setOnScrollListener(this.qyp);
    this.XO = ProductUI.w(this.qyh);
    AppMethodBeat.o(81104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.b
 * JD-Core Version:    0.7.0.1
 */