package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.uq;
import com.tencent.mm.autogen.a.uq.a;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.g.n;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class SnsCore$36
  extends IListener<uq>
{
  SnsCore$36(al paramal, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309517);
    this.__eventId = uq.class.getName().hashCode();
    AppMethodBeat.o(309517);
  }
  
  private static boolean a(uq paramuq)
  {
    AppMethodBeat.i(309523);
    SnsAdClick localSnsAdClick = paramuq.hYr.hXZ;
    try
    {
      if (paramuq.hYr.hYs != 1) {
        break label259;
      }
      if (localSnsAdClick.oTR != 1) {
        break label365;
      }
      localAdSnsInfo = al.hgE().vd(localSnsAdClick.ibq);
      if ((localAdSnsInfo == null) || (!localAdSnsInfo.isRecExpAd())) {
        break label266;
      }
      localObject2 = al.hgv();
      j = 14647;
      localObject1 = new Object[7];
      localObject1[0] = Long.valueOf(localSnsAdClick.ibq);
      localObject1[1] = localAdSnsInfo.getAdInfo().uxInfo;
      localObject1[2] = Integer.valueOf(localSnsAdClick.oTO);
      localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
      localObject1[4] = Long.valueOf(System.currentTimeMillis());
      i = localAdSnsInfo.getRecSrc();
      paramuq = (uq)localObject1;
    }
    catch (Exception paramuq)
    {
      for (;;)
      {
        AdSnsInfo localAdSnsInfo;
        int j;
        n localn;
        Log.printErrStackTrace("MicroMsg.SnsCore", paramuq, "report ad click error", new Object[0]);
        continue;
        Object localObject1 = paramuq.hYr.uxInfo;
        paramuq = (uq)localObject1;
        if (localObject1 == null) {
          paramuq = "";
        }
        Log.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramuq)));
        boolean bool = false;
        continue;
        al.hgv().b(12013, new Object[] { localObject1 });
        continue;
        int i = -1;
        localObject1 = paramuq;
        Object localObject2 = paramuq;
        paramuq = (uq)localObject1;
        localObject1 = localObject2;
        localObject2 = localn;
      }
    }
    paramuq[5] = Integer.valueOf(i);
    localObject1[6] = "";
    ((n)localObject2).b(j, (Object[])localObject1);
    paramuq = l.wP(750);
    paramuq.Ph(localSnsAdClick.ibq).Ph(localAdSnsInfo.getAdInfo().uxInfo).wR(localSnsAdClick.oTO).Ph(localSnsAdClick.startTime).Ph(System.currentTimeMillis());
    paramuq.bMH();
    for (;;)
    {
      label259:
      AppMethodBeat.o(309523);
      return false;
      label266:
      localn = al.hgv();
      j = 13155;
      paramuq = new Object[7];
      paramuq[0] = Long.valueOf(localSnsAdClick.ibq);
      paramuq[1] = localAdSnsInfo.getAdInfo().uxInfo;
      paramuq[2] = Integer.valueOf(localSnsAdClick.oTO);
      paramuq[3] = Long.valueOf(localSnsAdClick.startTime);
      paramuq[4] = Long.valueOf(System.currentTimeMillis());
      if (localAdSnsInfo == null) {
        break label753;
      }
      i = localAdSnsInfo.getRecSrc();
      localObject1 = paramuq;
      localObject2 = paramuq;
      paramuq = (uq)localObject1;
      localObject1 = localObject2;
      localObject2 = localn;
      break;
      label365:
      localObject1 = al.hgE().vd(localSnsAdClick.ibq);
      if (localObject1 == null) {
        break label693;
      }
      paramuq = ((AdSnsInfo)localObject1).getAdInfo().uxInfo;
      bool = ((AdSnsInfo)localObject1).isRecExpAd();
      localObject1 = k.a(localSnsAdClick.ibq, new Object[] { localSnsAdClick, paramuq, Integer.valueOf(localSnsAdClick.oTO), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
      localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.oTS });
      localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.oTU });
      if (!bool) {
        break label732;
      }
      al.hgv().b(14643, new Object[] { localObject1 });
      localObject1 = l.wP(733);
      ((l)localObject1).Ph(localSnsAdClick.ibq).Ph(paramuq).wR(localSnsAdClick.oTO).Ph(localSnsAdClick.startTime).Ph(System.currentTimeMillis());
      ((l)localObject1).bMH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.SnsCore.36
 * JD-Core Version:    0.7.0.1
 */