package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;

final class ProductUI$11
  implements e.a
{
  ProductUI$11(ProductUI paramProductUI) {}
  
  public final Boolean LY(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return (Boolean)ProductUI.i(this.nKF).get(paramString);
    }
    return null;
  }
  
  public final void a(String paramString, Boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      ProductUI.i(this.nKF).put(paramString, paramBoolean);
    }
  }
  
  public final void bxI()
  {
    if (this.nKF.dnn != null) {
      this.nKF.dnn.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.11
 * JD-Core Version:    0.7.0.1
 */