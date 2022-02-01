package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.uh;
import com.tencent.mm.autogen.a.uh.a;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class SnsCore$31
  extends IListener<uh>
{
  SnsCore$31(al paramal, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309583);
    this.__eventId = uh.class.getName().hashCode();
    AppMethodBeat.o(309583);
  }
  
  private static boolean a(uh paramuh)
  {
    AppMethodBeat.i(309595);
    SnsAdClick localSnsAdClick;
    Object localObject1;
    try
    {
      localSnsAdClick = paramuh.hYa.hXZ;
      localObject1 = al.hgE().vd(localSnsAdClick.ibq);
      Log.i("MicroMsg.SnsCore", "ad h5 report, snsId=" + t.uA(localSnsAdClick.ibq) + ", reportType=" + paramuh.hYa.hYb + ", errCode=" + paramuh.hYa.errorCode);
      if (localObject1 != null)
      {
        localObject2 = ((AdSnsInfo)localObject1).convertToSnsInfo();
        if (localSnsAdClick.source == 2)
        {
          localObject1 = ((SnsInfo)localObject2).getAtAdInfo();
          if (localObject1 == null) {
            break label285;
          }
          if (localSnsAdClick.source != 2) {
            break label262;
          }
          Log.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
        }
        for (;;)
        {
          h.OAn.b(16972, new Object[] { Long.valueOf(localSnsAdClick.ibq), Integer.valueOf(localSnsAdClick.oTO), ((ADInfo)localObject1).uxInfo, Integer.valueOf(((SnsInfo)localObject2).getAdRecSrc()), ((SnsInfo)localObject2).getTimeLine().statExtStr, paramuh.hYa.url, Integer.valueOf(paramuh.hYa.hYb), Integer.valueOf(paramuh.hYa.errorCode), Long.valueOf(paramuh.hYa.timestamp) });
          AppMethodBeat.o(309595);
          return true;
          localObject1 = ((SnsInfo)localObject2).getAdInfo();
          break;
          label262:
          Log.i("MicroMsg.SnsCore", "report ad h5 load");
        }
      }
      label285:
      localObject1 = al.hgB().vj(localSnsAdClick.ibq);
    }
    catch (Exception paramuh)
    {
      Log.printErrStackTrace("MicroMsg.SnsCore", paramuh, "report load ad h5 error", new Object[0]);
      AppMethodBeat.o(309595);
      return false;
    }
    Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramuh.hYa.uxInfo).append(", snsInfo==null?");
    boolean bool;
    String str;
    int i;
    if (localObject1 == null)
    {
      bool = true;
      Log.i("MicroMsg.SnsCore", bool);
      if (localObject1 == null) {
        break label508;
      }
      str = paramuh.hYa.uxInfo;
      i = ((SnsInfo)localObject1).getAdRecSrc();
      localObject1 = ((SnsInfo)localObject1).getTimeLine();
      if (localObject1 != null) {
        break label500;
      }
      localObject1 = "";
      break label627;
    }
    for (;;)
    {
      h.OAn.b(16972, new Object[] { Long.valueOf(localSnsAdClick.ibq), Integer.valueOf(localSnsAdClick.oTO), str, Integer.valueOf(i), localObject2, paramuh.hYa.url, Integer.valueOf(paramuh.hYa.hYb), Integer.valueOf(paramuh.hYa.errorCode), Long.valueOf(paramuh.hYa.timestamp) });
      AppMethodBeat.o(309595);
      return true;
      bool = false;
      break;
      label500:
      localObject1 = ((TimeLineObject)localObject1).statExtStr;
      break label627;
      label508:
      localObject1 = paramuh.hYa.uxInfo;
      h.OAn.b(16972, new Object[] { Long.valueOf(localSnsAdClick.ibq), Integer.valueOf(localSnsAdClick.oTO), localObject1, Integer.valueOf(0), "", paramuh.hYa.url, Integer.valueOf(paramuh.hYa.hYb), Integer.valueOf(paramuh.hYa.errorCode), Long.valueOf(paramuh.hYa.timestamp) });
      AppMethodBeat.o(309595);
      return true;
      label627:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.SnsCore.31
 * JD-Core Version:    0.7.0.1
 */