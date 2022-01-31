package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.chatting.c.j;
import java.util.Set;

public final class i
{
  public static void a(Context paramContext, Set<Long> paramSet, t paramt)
  {
    AppMethodBeat.i(153825);
    if (paramContext == null)
    {
      ab.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
      AppMethodBeat.o(153825);
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      ab.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
      AppMethodBeat.o(153825);
      return;
    }
    paramContext.getString(2131297087);
    paramContext = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131298953), false, null);
    j.zEQ.e(new i.a(paramSet, paramContext, paramt));
    com.tencent.mm.plugin.report.service.h.qsU.e(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(153825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i
 * JD-Core Version:    0.7.0.1
 */