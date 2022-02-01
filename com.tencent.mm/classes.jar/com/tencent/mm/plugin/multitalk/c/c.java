package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.TalkRoom;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "TAG", "", "getMemberId", "", "username", "getMultitalkMaxLimitedNumber", "plugin-multitalk_release"})
public final class c
{
  public static final c vcn;
  
  static
  {
    AppMethodBeat.i(178995);
    vcn = new c();
    AppMethodBeat.o(178995);
  }
  
  public static final int amJ(String paramString)
  {
    AppMethodBeat.i(178994);
    a.ay localay;
    if (!bs.isNullOrNil(paramString))
    {
      Object localObject = p.dgx();
      k.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((f)localObject).dfS() != null)
      {
        localObject = p.dgx();
        k.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((f)localObject).dfS().fCa();
        localObject = com.tencent.wecall.talkroom.model.c.fIe().aUb((String)localObject);
        if (localObject != null)
        {
          localObject = ((TalkRoom)localObject).fHY().iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localay = (a.ay)((Iterator)localObject).next();
          } while (!k.g(localay.dhV, paramString));
        }
      }
    }
    for (int i = localay.osF;; i = -1)
    {
      AppMethodBeat.o(178994);
      return i;
    }
  }
  
  public static final int dhi()
  {
    AppMethodBeat.i(178993);
    int i = ((b)g.ab(b.class)).a(b.a.qaT, d.b.Dfr);
    AppMethodBeat.o(178993);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.c
 * JD-Core Version:    0.7.0.1
 */