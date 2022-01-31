package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ui.aj;
import java.lang.ref.WeakReference;

final class b$31
  implements b.e
{
  b$31(b paramb) {}
  
  public final void c(com.tencent.mm.plugin.sight.decode.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(40288);
    if ((paramb != null) && (paramInt == 0)) {
      if (paramb.qSO == null) {
        break label88;
      }
    }
    label88:
    for (paramb = (View)paramb.qSO.get();; paramb = null)
    {
      if ((paramb != null) && ((paramb instanceof a)))
      {
        paramb = (a)paramb;
        paramb.getVideoPath();
        if ((paramb.getTagObject() != null) && ((paramb.getTagObject() instanceof aj))) {
          paramb.getTagObject();
        }
      }
      AppMethodBeat.o(40288);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.31
 * JD-Core Version:    0.7.0.1
 */