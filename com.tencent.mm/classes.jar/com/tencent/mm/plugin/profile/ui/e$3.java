package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.bd.a;
import com.tencent.mm.ui.base.p;

final class e$3
  implements bd.a
{
  e$3(e parame) {}
  
  public final void xA()
  {
    if (this.mXe.tipDialog != null)
    {
      this.mXe.tipDialog.dismiss();
      this.mXe.tipDialog = null;
    }
  }
  
  public final boolean xz()
  {
    return this.mXe.isDeleteCancel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e.3
 * JD-Core Version:    0.7.0.1
 */