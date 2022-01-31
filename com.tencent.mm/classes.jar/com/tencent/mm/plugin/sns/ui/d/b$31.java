package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ui.aj;
import java.lang.ref.WeakReference;

final class b$31
  implements b.e
{
  b$31(b paramb) {}
  
  public final void d(com.tencent.mm.plugin.sight.decode.a.b paramb, int paramInt)
  {
    if ((paramb != null) && (paramInt == 0)) {
      if (paramb.oez == null) {
        break label78;
      }
    }
    label78:
    for (paramb = (View)paramb.oez.get();; paramb = null)
    {
      if ((paramb != null) && ((paramb instanceof a)))
      {
        paramb = (a)paramb;
        paramb.getVideoPath();
        if ((paramb.getTagObject() != null) && ((paramb.getTagObject() instanceof aj))) {
          paramb.getTagObject();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.31
 * JD-Core Version:    0.7.0.1
 */