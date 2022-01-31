package com.tencent.mm.plugin.remittance.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.ui.widget.b.e.c;

final class c$2
  implements e.c
{
  c$2(c paramc, v paramv, EditText paramEditText) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(44815);
    if (paramBoolean)
    {
      paramString = new bv();
      paramString.cYX = this.qlb.okH;
      paramString = paramString.gR(this.qlb.username);
      paramString.cYR = 3L;
      paramString.ake();
      this.qla.qkY.Yk(this.qkZ.getText().toString());
      AppMethodBeat.o(44815);
      return;
    }
    paramString = new bv();
    paramString.cYX = this.qlb.okH;
    paramString = paramString.gR(this.qlb.username);
    paramString.cYR = 2L;
    paramString.ake();
    this.qla.qkY.onCancel();
    AppMethodBeat.o(44815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c.2
 * JD-Core Version:    0.7.0.1
 */