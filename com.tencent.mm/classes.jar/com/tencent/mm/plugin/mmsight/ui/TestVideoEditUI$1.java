package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.ab;

final class TestVideoEditUI$1
  implements r
{
  TestVideoEditUI$1(TestVideoEditUI paramTestVideoEditUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(55292);
    ab.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", new Object[] { parame.name() });
    AppMethodBeat.o(55292);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(55293);
    ab.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { parame.name(), Integer.valueOf(paramInt) });
    AppMethodBeat.o(55293);
  }
  
  public final void bk(boolean paramBoolean)
  {
    AppMethodBeat.i(55294);
    if (paramBoolean)
    {
      this.oQK.showVKB();
      AppMethodBeat.o(55294);
      return;
    }
    this.oQK.hideVKB(TestVideoEditUI.a(this.oQK));
    AppMethodBeat.o(55294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI.1
 * JD-Core Version:    0.7.0.1
 */