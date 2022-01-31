package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

public final class j
{
  public static void a(Context paramContext, Set<Long> paramSet, aj paramaj)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      y.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
      return;
    }
    paramContext.getString(R.l.app_tip);
    paramContext = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(R.l.deleting_message), false, null);
    com.tencent.mm.ui.chatting.b.j.vpo.c(new j.a(paramSet, paramContext, paramaj));
    com.tencent.mm.plugin.report.service.h.nFQ.f(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */