package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class b$6
  implements r
{
  b$6(b paramb) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(55147);
    ab.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { parame.name() });
    if (parame == e.bWb) {
      b.i(this.oOV);
    }
    AppMethodBeat.o(55147);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(55148);
    ab.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[] { parame.name(), Integer.valueOf(paramInt) });
    AppMethodBeat.o(55148);
  }
  
  public final void bk(boolean paramBoolean)
  {
    AppMethodBeat.i(55149);
    if (paramBoolean)
    {
      b.e(this.oOV).showVKB();
      AppMethodBeat.o(55149);
      return;
    }
    b.e(this.oOV).hideVKB(b.j(this.oOV));
    AppMethodBeat.o(55149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.6
 * JD-Core Version:    0.7.0.1
 */