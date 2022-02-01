package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.TalkRoom;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "TAG", "", "getMemberId", "", "username", "getMultitalkMaxLimitedNumber", "plugin-multitalk_release"})
public final class c
{
  public static final c tTF;
  
  static
  {
    AppMethodBeat.i(178995);
    tTF = new c();
    AppMethodBeat.o(178995);
  }
  
  public static final int ahO(String paramString)
  {
    AppMethodBeat.i(178994);
    a.ay localay;
    if (!bt.isNullOrNil(paramString))
    {
      Object localObject = p.cSO();
      k.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((f)localObject).cSi() != null)
      {
        localObject = p.cSO();
        k.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((f)localObject).cSi().flJ();
        localObject = com.tencent.wecall.talkroom.model.c.fpJ().aOp((String)localObject);
        if (localObject != null)
        {
          localObject = ((TalkRoom)localObject).fpD().iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localay = (a.ay)((Iterator)localObject).next();
          } while (!k.g(localay.Imu, paramString));
        }
      }
    }
    for (int i = localay.nPB;; i = -1)
    {
      AppMethodBeat.o(178994);
      return i;
    }
  }
  
  public static final int cTy()
  {
    AppMethodBeat.i(178993);
    int i = ((b)g.ab(b.class)).a(b.a.pwE, d.b.BNh);
    AppMethodBeat.o(178993);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.c
 * JD-Core Version:    0.7.0.1
 */