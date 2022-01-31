package com.tencent.mm.plugin.sns.ui;

import android.widget.Gallery;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.a.c;
import com.tencent.mm.ui.base.MultiTouchImageView.a;

final class SnsInfoFlip$6
  implements MultiTouchImageView.a
{
  SnsInfoFlip$6(SnsInfoFlip paramSnsInfoFlip) {}
  
  public final void cvp()
  {
    AppMethodBeat.i(38972);
    if ((SnsInfoFlip.g(this.rRB).getSelectedItem() == null) || (SnsInfoFlip.d(this.rRB) == null))
    {
      AppMethodBeat.o(38972);
      return;
    }
    int i = SnsInfoFlip.g(this.rRB).getSelectedItemPosition();
    Object localObject = ((b)SnsInfoFlip.g(this.rRB).getSelectedItem()).rlJ;
    localObject = ag.cpf().abv((String)localObject);
    if (localObject != null) {
      c.d((n)localObject, i);
    }
    AppMethodBeat.o(38972);
  }
  
  public final void cvq()
  {
    AppMethodBeat.i(38973);
    if ((SnsInfoFlip.g(this.rRB).getSelectedItem() == null) || (SnsInfoFlip.d(this.rRB) == null))
    {
      AppMethodBeat.o(38973);
      return;
    }
    int i = SnsInfoFlip.g(this.rRB).getSelectedItemPosition();
    Object localObject = ((b)SnsInfoFlip.g(this.rRB).getSelectedItem()).rlJ;
    localObject = ag.cpf().abv((String)localObject);
    if (localObject != null) {
      c.e((n)localObject, i);
    }
    AppMethodBeat.o(38973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.6
 * JD-Core Version:    0.7.0.1
 */