package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.protocal.protobuf.ccp;

final class e$11
  implements View.OnClickListener
{
  e$11(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1896);
    b localb = this.tkq.getFSVideoUIComponent();
    e.d(this.tkq).cJb();
    localb.a((ccp)paramView.getTag());
    AppMethodBeat.o(1896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.11
 * JD-Core Version:    0.7.0.1
 */