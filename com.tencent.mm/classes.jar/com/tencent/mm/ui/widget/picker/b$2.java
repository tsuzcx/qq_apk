package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = null;
    AppMethodBeat.i(112821);
    b localb = this.AIX;
    if (b.b(this.AIX) == null)
    {
      paramView = null;
      if (b.a(this.AIX) != null) {
        break label61;
      }
    }
    for (;;)
    {
      b.a(localb, true, paramView, localObject);
      AppMethodBeat.o(112821);
      return;
      paramView = b.b(this.AIX).aRR();
      break;
      label61:
      localObject = b.a(this.AIX).aRR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.2
 * JD-Core Version:    0.7.0.1
 */