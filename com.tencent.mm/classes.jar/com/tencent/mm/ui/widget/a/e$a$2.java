package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

final class e$a$2
  implements View.OnClickListener
{
  e$a$2(e.a parama, CheckBox paramCheckBox, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof CheckBox)))
    {
      if (!((CheckBox)paramView).isChecked()) {
        break label83;
      }
      this.wnD.wnC[((java.lang.Integer)this.wnE.getTag()).intValue()] = 1;
    }
    for (;;)
    {
      if (this.wnD.wnB != null)
      {
        e.e locale = this.wnD.wnB;
        ((CheckBox)paramView).isChecked();
        locale.q(this.wnD.wnC);
      }
      return;
      label83:
      this.wnD.wnC[((java.lang.Integer)this.wnE.getTag()).intValue()] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.a.2
 * JD-Core Version:    0.7.0.1
 */