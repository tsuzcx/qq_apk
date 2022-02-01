package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.priority.model.a.a.a;
import com.tencent.mm.plugin.priority.model.a.a.a.a;
import com.tencent.mm.plugin.priority.model.d;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;

final class PluginPriority$1
  implements i.a
{
  PluginPriority$1(PluginPriority paramPluginPriority) {}
  
  public final void a(i parami, i.c paramc)
  {
    AppMethodBeat.i(87765);
    if (paramc.vWi.equals("insert"))
    {
      int i = 0;
      if (i < paramc.gQn.size())
      {
        parami = (bv)paramc.gQn.get(i);
        label70:
        a locala;
        if ((parami.field_isSend == 0) && (parami.ftg()))
        {
          ((b)g.ab(b.class)).ai(parami);
          if (this.xaD.getC2CChatUsageLogic() != null)
          {
            if (parami.field_isSend != 1) {
              break label165;
            }
            locala = this.xaD.getC2CChatUsageLogic();
            parami = parami.field_talker;
            ((PluginPriority)g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, parami, 1));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((parami.field_isSend != 0) || (!parami.cVH())) {
            break label70;
          }
          ((b)g.ab(b.class)).aj(parami);
          break label70;
          label165:
          locala = this.xaD.getC2CChatUsageLogic();
          parami = parami.field_talker;
          ((PluginPriority)g.ad(PluginPriority.class)).getPriorityTaskRunner().a(new a.a(locala, parami, 3));
        }
      }
    }
    AppMethodBeat.o(87765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority.1
 * JD-Core Version:    0.7.0.1
 */