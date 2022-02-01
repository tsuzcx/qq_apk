package com.tencent.mm.plugin.remittance.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.e;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.ui.widget.a.g.c;

public final class b
  implements com.tencent.mm.plugin.wxpaysdk.api.b
{
  public final void a(Context paramContext, ResendMsgInfo paramResendMsgInfo, g.c paramc)
  {
    AppMethodBeat.i(67337);
    new e(paramContext).a(paramResendMsgInfo, paramc);
    AppMethodBeat.o(67337);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, g.c paramc)
  {
    AppMethodBeat.i(67336);
    paramContext = new e(paramContext);
    ResendMsgInfo localResendMsgInfo = new ResendMsgInfo();
    localResendMsgInfo.title = paramString1;
    localResendMsgInfo.XJO = paramString2;
    localResendMsgInfo.description = paramString3;
    localResendMsgInfo.rGU = paramString4;
    localResendMsgInfo.right_button_wording = paramString5;
    paramContext.a(localResendMsgInfo, paramc);
    AppMethodBeat.o(67336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.app.b
 * JD-Core Version:    0.7.0.1
 */