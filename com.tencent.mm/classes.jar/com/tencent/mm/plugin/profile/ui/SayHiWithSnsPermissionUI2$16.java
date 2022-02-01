package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.g.c;

final class SayHiWithSnsPermissionUI2$16
  implements g.c
{
  SayHiWithSnsPermissionUI2$16(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2, int paramInt) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(305627);
    h.baE().ban().set(at.a.adfO, Integer.valueOf(this.Nbn + 1));
    AppMethodBeat.o(305627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.16
 * JD-Core Version:    0.7.0.1
 */