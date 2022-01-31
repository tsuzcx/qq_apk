package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$1
  implements g
{
  b$1(b paramb) {}
  
  public final void onExit()
  {
    AppMethodBeat.i(55135);
    ab.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
    this.oOV.release();
    if (b.a(this.oOV) != null) {
      al.d(new b.1.2(this));
    }
    AppMethodBeat.o(55135);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(55134);
    ab.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
    b.h(this.oOV).a(new b.1.1(this));
    AppMethodBeat.o(55134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.1
 * JD-Core Version:    0.7.0.1
 */