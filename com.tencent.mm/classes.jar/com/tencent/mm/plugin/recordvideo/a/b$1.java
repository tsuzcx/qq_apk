package com.tencent.mm.plugin.recordvideo.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class b$1
  implements o.f
{
  b$1(b paramb, Context paramContext) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(75018);
    paramm.d(0, this.val$context.getResources().getString(2131764635));
    paramm.d(1, this.val$context.getResources().getString(2131763947));
    paramm.d(2, this.val$context.getResources().getString(2131764866));
    AppMethodBeat.o(75018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b.1
 * JD-Core Version:    0.7.0.1
 */