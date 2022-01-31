package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.a;

final class NewBizInfoSettingUI$6
  implements bf.a
{
  NewBizInfoSettingUI$6(NewBizInfoSettingUI paramNewBizInfoSettingUI, boolean paramBoolean, String paramString) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(23917);
    boolean bool = NewBizInfoSettingUI.e(this.pDY);
    AppMethodBeat.o(23917);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(23918);
    if (NewBizInfoSettingUI.f(this.pDY) != null)
    {
      NewBizInfoSettingUI.f(this.pDY).dismiss();
      NewBizInfoSettingUI.g(this.pDY);
    }
    if (this.pDZ)
    {
      g.E(o.class);
      com.tencent.mm.storage.p.aqS(this.pxM);
    }
    AppMethodBeat.o(23918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.6
 * JD-Core Version:    0.7.0.1
 */