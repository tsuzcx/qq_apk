package com.tencent.mm.plugin.remittance.ui;

import android.widget.EditText;
import com.tencent.mm.h.b.a.ab;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.ui.widget.a.e.d;

final class b$2
  implements e.d
{
  b$2(b paramb, v paramv, EditText paramEditText) {}
  
  public final void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = new ab();
      paramString.ckv = this.nzN.amount;
      paramString.cku = this.nzN.username;
      paramString.ckp = 3L;
      paramString.QX();
      this.nzM.nzK.LQ(this.nzL.getText().toString());
      return;
    }
    paramString = new ab();
    paramString.ckv = this.nzN.amount;
    paramString.cku = this.nzN.username;
    paramString.ckp = 2L;
    paramString.QX();
    this.nzM.nzK.onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b.2
 * JD-Core Version:    0.7.0.1
 */