package com.tencent.mm.plugin.teenmode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.g.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class TeenModePrivatePwdUI$d$a
  implements g.c
{
  TeenModePrivatePwdUI$d$a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(279142);
    if (!paramBoolean) {
      TeenModePrivatePwdUI.a(this.Tbm, "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=parental/resetpassword");
    }
    AppMethodBeat.o(279142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModePrivatePwdUI.d.a
 * JD-Core Version:    0.7.0.1
 */