package com.tencent.mm.plugin.remittance.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.d;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.ui.widget.a.f.c;

public final class b
  implements com.tencent.mm.plugin.wxpaysdk.api.b
{
  public final void a(Context paramContext, ResendMsgInfo paramResendMsgInfo, f.c paramc)
  {
    AppMethodBeat.i(67337);
    new d(paramContext).a(paramResendMsgInfo, paramc);
    AppMethodBeat.o(67337);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, f.c paramc)
  {
    AppMethodBeat.i(67336);
    paramContext = new d(paramContext);
    ResendMsgInfo localResendMsgInfo = new ResendMsgInfo();
    localResendMsgInfo.title = paramString1;
    localResendMsgInfo.Fae = paramString2;
    localResendMsgInfo.description = paramString3;
    localResendMsgInfo.kCZ = paramString4;
    localResendMsgInfo.kDa = paramString5;
    paramContext.a(localResendMsgInfo, paramc);
    AppMethodBeat.o(67336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.b
 * JD-Core Version:    0.7.0.1
 */