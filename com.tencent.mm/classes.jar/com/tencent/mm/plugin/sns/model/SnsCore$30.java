package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ug;
import com.tencent.mm.autogen.a.ug.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.ad.g.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class SnsCore$30
  extends IListener<ug>
{
  SnsCore$30(al paramal, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309585);
    this.__eventId = ug.class.getName().hashCode();
    AppMethodBeat.o(309585);
  }
  
  private static boolean a(ug paramug)
  {
    AppMethodBeat.i(309593);
    label501:
    for (;;)
    {
      try
      {
        SnsAdClick localSnsAdClick = paramug.hXY.hXZ;
        paramug = al.hgE().vd(localSnsAdClick.ibq);
        if (paramug == null)
        {
          AppMethodBeat.o(309593);
          return false;
        }
        SnsInfo localSnsInfo = paramug.convertToSnsInfo();
        String str1;
        String str2;
        a locala;
        String str3;
        if (localSnsAdClick.source == 2)
        {
          paramug = localSnsInfo.getAtAdInfo();
          if (paramug == null) {
            continue;
          }
          str1 = paramug.waidPkg;
          str2 = b.bbr(str1);
          locala = new a();
          locala.PUN = m.t(localSnsInfo);
          locala.PUO = m.u(localSnsInfo);
          locala.PUP = ((int)localSnsAdClick.oTX);
          locala.oTY = localSnsAdClick.oTY;
          if ((paramug.isWeapp()) && (!localSnsInfo.isFullCardAd()) && (!localSnsInfo.isSlideFullCardAd()))
          {
            if (!i.aWm(paramug.actionExtWeApp.appUserName)) {
              break label501;
            }
            i = 1;
            locala.PUQ = i;
          }
          str3 = t.uA(localSnsInfo.field_snsId);
          if (localSnsAdClick.source == 2)
          {
            Log.i("MicroMsg.SnsCore", "report ad click, at detail, exposureTime=" + localSnsAdClick.oTW + ", clkPos=" + localSnsAdClick.oTP + ", source=" + localSnsAdClick.source + ", snsId=" + str3);
            paramug = new com.tencent.mm.plugin.sns.ad.g.f(localSnsAdClick.ibq, paramug.viewId, localSnsAdClick.oTP, localSnsAdClick.oTQ, localSnsAdClick.oTO, "", localSnsInfo.getAdType(), localSnsInfo.getTimeLine().statExtStr, localSnsAdClick.oTV, localSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSourceInfo(), localSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSelfInfo(), localSnsAdClick.oTW, str1, str2, locala);
            h.baF();
            h.baD().mCm.a(paramug, 0);
            AppMethodBeat.o(309593);
            return true;
          }
        }
        else
        {
          paramug = localSnsInfo.getAdInfo();
          continue;
        }
        Log.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.oTW + ", clkPos=" + localSnsAdClick.oTP + ", source=" + localSnsAdClick.source + ", snsId=" + str3);
        paramug = new com.tencent.mm.plugin.sns.ad.g.f(localSnsAdClick.ibq, paramug.viewId, localSnsAdClick.oTP, localSnsAdClick.oTQ, localSnsAdClick.oTO, "", localSnsInfo.getAdType(), localSnsInfo.getTimeLine().statExtStr, localSnsAdClick.oTV, localSnsInfo.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), localSnsInfo.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), localSnsAdClick.oTW, str1, str2, locala);
        h.baF();
        h.baD().mCm.a(paramug, 0);
        continue;
        int i = 0;
      }
      catch (Exception paramug)
      {
        Log.printErrStackTrace("MicroMsg.SnsCore", paramug, "report ad click error", new Object[0]);
        AppMethodBeat.o(309593);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.SnsCore.30
 * JD-Core Version:    0.7.0.1
 */