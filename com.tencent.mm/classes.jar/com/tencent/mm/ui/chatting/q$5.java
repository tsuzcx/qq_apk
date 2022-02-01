package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.chatting.e.a;

final class q$5
  implements q.f
{
  q$5(q paramq) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(268981);
    paramo.d(1, q.e(this.WAw).WQv.getMMResources().getString(R.l.app_field_mmsight));
    paramo.d(5, "拍摄参数设置面板");
    AppMethodBeat.o(268981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.5
 * JD-Core Version:    0.7.0.1
 */