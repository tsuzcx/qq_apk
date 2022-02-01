package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class MiniQBReaderUI$6$1
  implements u.g
{
  MiniQBReaderUI$6$1(MiniQBReaderUI.6 param6) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(31967);
    params.c(0, this.YtC.YtA.getString(R.l.retransmit));
    params.c(3, this.YtC.YtA.getString(R.l.files_enter_float_ball));
    params.c(1, this.YtC.YtA.getString(R.l.choose_app));
    params.c(4, this.YtC.YtA.getString(R.l.export_to_mobile));
    if ((((a)h.ax(a.class)).fJL()) && (MiniQBReaderUI.m(this.YtC.YtA) != null) && (HandOffFile.isSupportOpenFile(MiniQBReaderUI.i(this.YtC.YtA)))) {
      params.c(5, this.YtC.YtA.getString(R.l.files_open_in_computer));
    }
    if (((aw.ato()) || (aw.jla()) || (aw.jkZ()) || (aw.jlb())) && ((aw.jkS()) || (aj.aAy(this.YtC.YtA.getTaskId()))))
    {
      if (aw.aAj(this.YtC.YtA.getTaskId()))
      {
        params.c(6, this.YtC.YtA.getString(R.l.close_split_screen));
        AppMethodBeat.o(31967);
        return;
      }
      params.c(6, this.YtC.YtA.getString(R.l.split_screen));
    }
    AppMethodBeat.o(31967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI.6.1
 * JD-Core Version:    0.7.0.1
 */