package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.widget.b.d.a;

final class s$6
  implements d.a
{
  s$6(s params) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(38254);
    Object localObject = new ao();
    ((ao)localObject).cnS.filePath = this.rHr.rGw;
    a.ymk.l((b)localObject);
    this.rHr.rHk = null;
    this.rHr.rGw = null;
    this.rHr.qXp = null;
    this.rHr.Cu = null;
    this.rHr.rGz = null;
    this.rHr.rGA = null;
    this.rHr.rGB = null;
    localObject = this.rHr;
    this.rHr.cpF = 0;
    ((s)localObject).cpE = 0;
    AppMethodBeat.o(38254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.6
 * JD-Core Version:    0.7.0.1
 */