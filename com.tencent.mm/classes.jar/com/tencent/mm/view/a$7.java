package com.tencent.mm.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.tencent.mm.view.footer.SelectColorBar;

final class a$7
  implements CompoundButton.OnCheckedChangeListener
{
  a$7(a parama, SelectColorBar paramSelectColorBar) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.wvF.setSelectColor(((Integer)a.c(this.wvE).getTag()).intValue());
      a.b(this.wvE).setTextBackground(((Integer)a.c(this.wvE).getTag()).intValue());
      return;
    }
    a.c(this.wvE).setTag(Integer.valueOf(this.wvF.getCurColor()));
    a.b(this.wvE).setTextBackground(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.a.7
 * JD-Core Version:    0.7.0.1
 */