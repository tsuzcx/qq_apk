package com.tencent.mm.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.mmdata.rpt.iq;
import com.tencent.mm.model.ac;
import com.tencent.mm.storage.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/report/OpenImKefuConversationReporter;", "", "()V", "TAG", "", "reportDelKefuConversation", "", "talker", "unReadCount", "", "reportOpKefuConversation", "opType", "conv", "Lcom/tencent/mm/storage/Conversation;", "OpType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b afBS;
  
  static
  {
    AppMethodBeat.i(249527);
    afBS = new b();
    AppMethodBeat.o(249527);
  }
  
  public static final void a(int paramInt, String paramString, bb parambb)
  {
    AppMethodBeat.i(249522);
    s.u(paramString, "talker");
    iq localiq = new iq();
    long l;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(249522);
      return;
    case 1: 
      l = 12L;
      localiq.ioV = l;
      localiq.rT(paramString);
      localiq.iPK = ac.Jj(paramString);
      if (parambb == null)
      {
        l = 0L;
        label91:
        localiq.ipl = l;
        localiq.bMH();
        if (paramInt == 1) {
          if (parambb != null) {
            break label189;
          }
        }
      }
      break;
    }
    label189:
    for (paramInt = 0;; paramInt = parambb.field_unReadCount)
    {
      parambb = new iq();
      parambb.ioV = 1L;
      parambb.rT(paramString);
      parambb.iPK = ac.Jj(paramString);
      parambb.ipl = paramInt;
      parambb.bMH();
      AppMethodBeat.o(249522);
      return;
      l = 15L;
      break;
      l = 16L;
      break;
      l = 17L;
      break;
      l = parambb.field_unReadCount;
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.report.b
 * JD-Core Version:    0.7.0.1
 */