package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class SnsOnlineVideoActivity$13
  implements View.OnLongClickListener
{
  SnsOnlineVideoActivity$13(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(39160);
    SnsOnlineVideoActivity.a(this.rUf, new d(this.rUf.getContext(), 1, false));
    SnsOnlineVideoActivity.o(this.rUf).sao = this.rUf.rUe;
    SnsOnlineVideoActivity.o(this.rUf).sap = this.rUf.jWw;
    SnsOnlineVideoActivity.o(this.rUf).AGQ = new SnsOnlineVideoActivity.13.1(this);
    SnsOnlineVideoActivity.o(this.rUf).crd();
    AppMethodBeat.o(39160);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.13
 * JD-Core Version:    0.7.0.1
 */