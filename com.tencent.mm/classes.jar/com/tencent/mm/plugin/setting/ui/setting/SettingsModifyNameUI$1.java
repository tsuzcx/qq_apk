package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mh.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMEditText;

final class SettingsModifyNameUI$1
  extends c<mh>
{
  SettingsModifyNameUI$1(SettingsModifyNameUI paramSettingsModifyNameUI)
  {
    super(0);
    AppMethodBeat.i(127304);
    this.__eventId = mh.class.getName().hashCode();
    AppMethodBeat.o(127304);
  }
  
  private boolean a(mh parammh)
  {
    AppMethodBeat.i(127305);
    String str1 = parammh.cCr.cCs;
    String str2 = parammh.cCr.cCt;
    int i = parammh.cCr.ret;
    if ((i != 0) && (str2 != null))
    {
      h.b(this.qJf, str2, str1, true);
      if (SettingsModifyNameUI.a(this.qJf) != null) {
        ((j)g.E(j.class)).Yz().d(SettingsModifyNameUI.a(this.qJf));
      }
    }
    for (;;)
    {
      if (SettingsModifyNameUI.d(this.qJf) != null) {
        SettingsModifyNameUI.d(this.qJf).dismiss();
      }
      AppMethodBeat.o(127305);
      return true;
      if ((i == 0) && (SettingsModifyNameUI.b(this.qJf)))
      {
        g.RL().Ru().set(4, SettingsModifyNameUI.c(this.qJf).getText().toString());
        this.qJf.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI.1
 * JD-Core Version:    0.7.0.1
 */