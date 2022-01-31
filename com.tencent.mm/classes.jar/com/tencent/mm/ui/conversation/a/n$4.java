package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.am;

final class n$4
  implements View.OnClickListener
{
  n$4(n paramn) {}
  
  public final void onClick(View paramView)
  {
    n.a(this.vVt, this.vVt.pIS);
    this.vVt.pIS = 1;
    if (this.vVt.vVr == null)
    {
      paramView = this.vVt;
      paramView.vVr = new n.1(paramView);
      a.udP.b(paramView.vVr);
    }
    if (this.vVt.vVq == null)
    {
      paramView = this.vVt;
      paramView.vVq = new am(new n.2(paramView), true);
      paramView.vVq.S(1000L, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n.4
 * JD-Core Version:    0.7.0.1
 */