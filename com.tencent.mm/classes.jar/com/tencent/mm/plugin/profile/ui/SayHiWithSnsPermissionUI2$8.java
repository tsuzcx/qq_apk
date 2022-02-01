package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.f.c;

final class SayHiWithSnsPermissionUI2$8
  implements f.c
{
  SayHiWithSnsPermissionUI2$8(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2, int paramInt) {}
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(179684);
    g.aAh().azQ().set(ar.a.OnG, Integer.valueOf(this.BiH + 1));
    AppMethodBeat.o(179684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.8
 * JD-Core Version:    0.7.0.1
 */