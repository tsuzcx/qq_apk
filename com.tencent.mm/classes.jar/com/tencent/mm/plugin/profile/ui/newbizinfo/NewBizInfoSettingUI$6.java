package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.ai.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.a;

final class NewBizInfoSettingUI$6
  implements bd.a
{
  NewBizInfoSettingUI$6(NewBizInfoSettingUI paramNewBizInfoSettingUI, boolean paramBoolean, String paramString) {}
  
  public final void xA()
  {
    if (NewBizInfoSettingUI.e(this.nad) != null)
    {
      NewBizInfoSettingUI.e(this.nad).dismiss();
      NewBizInfoSettingUI.f(this.nad);
    }
    if (this.nae)
    {
      g.r(o.class);
      com.tencent.mm.storage.p.aaH(this.mYI);
    }
  }
  
  public final boolean xz()
  {
    return NewBizInfoSettingUI.d(this.nad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.6
 * JD-Core Version:    0.7.0.1
 */