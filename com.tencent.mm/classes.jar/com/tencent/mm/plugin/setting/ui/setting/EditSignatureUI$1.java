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

final class EditSignatureUI$1
  extends c<mh>
{
  EditSignatureUI$1(EditSignatureUI paramEditSignatureUI)
  {
    AppMethodBeat.i(126942);
    this.__eventId = mh.class.getName().hashCode();
    AppMethodBeat.o(126942);
  }
  
  private boolean a(mh parammh)
  {
    AppMethodBeat.i(126943);
    String str1 = parammh.cCr.cCs;
    String str2 = parammh.cCr.cCt;
    int i = parammh.cCr.ret;
    if ((i != 0) && (EditSignatureUI.a(this.qFL) != null))
    {
      h.b(this.qFL, str2, str1, true);
      if (EditSignatureUI.b(this.qFL) != null) {
        ((j)g.E(j.class)).Yz().d(EditSignatureUI.b(this.qFL));
      }
    }
    for (;;)
    {
      if (EditSignatureUI.d(this.qFL) != null) {
        EditSignatureUI.d(this.qFL).dismiss();
      }
      AppMethodBeat.o(126943);
      return true;
      if ((i == 0) && (EditSignatureUI.c(this.qFL)))
      {
        parammh = EditSignatureUI.a(this.qFL).getText().toString().trim();
        g.RL().Ru().set(12291, parammh);
        this.qFL.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.1
 * JD-Core Version:    0.7.0.1
 */