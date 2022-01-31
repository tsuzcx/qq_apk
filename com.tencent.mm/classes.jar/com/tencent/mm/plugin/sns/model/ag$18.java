package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.on.a;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class ag$18
  extends c<on>
{
  ag$18(ag paramag)
  {
    AppMethodBeat.i(36445);
    this.__eventId = on.class.getName().hashCode();
    AppMethodBeat.o(36445);
  }
  
  private static boolean a(on paramon)
  {
    AppMethodBeat.i(36446);
    SnsAdClick localSnsAdClick;
    Object localObject1;
    try
    {
      localSnsAdClick = paramon.cFc.cFb;
      localObject1 = ag.cpi().lQ(localSnsAdClick.cIo);
      if (localObject1 != null)
      {
        localObject2 = ((e)localObject1).csn();
        if (localSnsAdClick.cpt == 2)
        {
          localObject1 = ((n)localObject2).cse();
          if (localObject1 == null) {
            break label227;
          }
          if (localSnsAdClick.cpt != 2) {
            break label204;
          }
          ab.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
        }
        for (;;)
        {
          h.qsU.e(16972, new Object[] { Long.valueOf(localSnsAdClick.cIo), Integer.valueOf(localSnsAdClick.fQs), ((a)localObject1).cFe, Integer.valueOf(((n)localObject2).csR()), ((n)localObject2).csh().rHA, paramon.cFc.url, Integer.valueOf(paramon.cFc.cFd), Integer.valueOf(paramon.cFc.errorCode), Long.valueOf(paramon.cFc.timestamp) });
          AppMethodBeat.o(36446);
          return true;
          localObject1 = ((n)localObject2).csd();
          break;
          label204:
          ab.i("MicroMsg.SnsCore", "report ad h5 load");
        }
      }
      label227:
      localObject1 = ag.cpf().lZ(localSnsAdClick.cIo);
    }
    catch (Exception paramon)
    {
      ab.printErrStackTrace("MicroMsg.SnsCore", paramon, "report load ad h5 error", new Object[0]);
      AppMethodBeat.o(36446);
      return false;
    }
    Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramon.cFc.cFe).append(", snsInfo==null?");
    boolean bool;
    String str;
    int i;
    if (localObject1 == null)
    {
      bool = true;
      ab.i("MicroMsg.SnsCore", bool);
      if (localObject1 == null) {
        break label450;
      }
      str = paramon.cFc.cFe;
      i = ((n)localObject1).csR();
      localObject1 = ((n)localObject1).csh();
      if (localObject1 != null) {
        break label442;
      }
      localObject1 = "";
      break label569;
    }
    for (;;)
    {
      h.qsU.e(16972, new Object[] { Long.valueOf(localSnsAdClick.cIo), Integer.valueOf(localSnsAdClick.fQs), str, Integer.valueOf(i), localObject2, paramon.cFc.url, Integer.valueOf(paramon.cFc.cFd), Integer.valueOf(paramon.cFc.errorCode), Long.valueOf(paramon.cFc.timestamp) });
      AppMethodBeat.o(36446);
      return true;
      bool = false;
      break;
      label442:
      localObject1 = ((TimeLineObject)localObject1).rHA;
      break label569;
      label450:
      localObject1 = paramon.cFc.cFe;
      h.qsU.e(16972, new Object[] { Long.valueOf(localSnsAdClick.cIo), Integer.valueOf(localSnsAdClick.fQs), localObject1, Integer.valueOf(0), "", paramon.cFc.url, Integer.valueOf(paramon.cFc.cFd), Integer.valueOf(paramon.cFc.errorCode), Long.valueOf(paramon.cFc.timestamp) });
      AppMethodBeat.o(36446);
      return true;
      label569:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag.18
 * JD-Core Version:    0.7.0.1
 */