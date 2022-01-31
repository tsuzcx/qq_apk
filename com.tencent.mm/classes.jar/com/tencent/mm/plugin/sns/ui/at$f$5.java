package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class at$f$5
  implements View.OnClickListener
{
  at$f$5(at.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39215);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(39215);
      return;
    }
    ab.d("MicroMsg.SnsphotoAdapter", "sign click");
    this.rVo.rVn = ((at.f.a)paramView.getTag());
    int i = this.rVo.rVn.cIp;
    this.rVo.EU(i);
    AppMethodBeat.o(39215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.f.5
 * JD-Core Version:    0.7.0.1
 */