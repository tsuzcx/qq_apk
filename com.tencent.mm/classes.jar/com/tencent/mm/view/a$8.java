package com.tencent.mm.view;

import android.widget.Switch;
import com.tencent.mm.view.footer.SelectColorBar.a;

final class a$8
  implements SelectColorBar.a
{
  a$8(a parama) {}
  
  public final void IL(int paramInt)
  {
    if (a.c(this.wvE).isChecked())
    {
      a.c(this.wvE).setTag(Integer.valueOf(paramInt));
      a.b(this.wvE).setTextBackground(paramInt);
      return;
    }
    a.b(this.wvE).setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.8
 * JD-Core Version:    0.7.0.1
 */