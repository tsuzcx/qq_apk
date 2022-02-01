package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.multitalk.b.a;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private Map<String, Long> tPp;
  
  public g()
  {
    AppMethodBeat.i(114536);
    this.tPp = new ConcurrentHashMap();
    AppMethodBeat.o(114536);
  }
  
  final void a(String paramString, f.a parama)
  {
    AppMethodBeat.i(114537);
    String str = z.a(parama.fTo.Cxz);
    paramString = Base64.decode(paramString.getBytes(), 0);
    ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + str + " buffer len " + paramString.length);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    a.ay[] arrayOfay;
    int i;
    int m;
    int j;
    label323:
    int k;
    int n;
    for (;;)
    {
      try
      {
        localObject1 = (a.be)com.google.b.a.e.a(new a.be(), paramString, paramString.length);
        if (localObject1 == null)
        {
          ad.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(str)));
          AppMethodBeat.o(114537);
          return;
        }
        if ((this.tPp.get(((a.be)localObject1).groupId) == null) || (((Long)this.tPp.get(((a.be)localObject1).groupId)).longValue() < ((a.be)localObject1).InV))
        {
          this.tPp.put(((a.be)localObject1).groupId, Long.valueOf(((a.be)localObject1).InV));
          parama = parama.fTo;
          paramString = z.a(parama.Cxx);
          parama = z.a(parama.Cxy);
          localObject2 = (String)com.tencent.mm.kernel.g.afB().afk().get(2, null);
          if (localObject2 == null)
          {
            ad.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
            AppMethodBeat.o(114537);
          }
        }
        else
        {
          ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + ((a.be)localObject1).groupId + " is early than last msg, so we do not process,now return.");
          AppMethodBeat.o(114537);
          return;
        }
        if (!((String)localObject2).equals(paramString)) {
          break label1542;
        }
        paramString = parama;
        localObject3 = ((a.be)localObject1).InT;
        if (((a.be)localObject1).InS != 1) {
          break;
        }
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject4 = ((a.be)localObject1).InU;
        arrayOfay = ((a.be)localObject1).IlV;
        i = 0;
        parama = "";
        m = arrayOfay.length;
        j = 0;
        if (j < m)
        {
          a.ay localay = arrayOfay[j];
          parama = parama + localay.Imu + ",";
          k = i;
          if (localay.Imu == null) {
            break label1530;
          }
          k = i;
          if (!localay.Imu.equals(localObject2)) {
            break label1530;
          }
          ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
          k = 1;
          break label1530;
        }
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject4.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject4[j];
          if ((parama != null) && (parama.equals(localObject2)))
          {
            ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
            k = 1;
          }
        }
        else
        {
          if (i != 0) {
            break label601;
          }
          p.cSQ().ahE(paramString);
          p.cSQ().cSB().remove(paramString);
          if (!((String)localObject2).equals(localObject3)) {
            break label633;
          }
          p.cSO().d(paramString, (String)localObject3, false, false);
          p.cSQ().a(paramString, (a.be)localObject1);
          p.cSN().tOr.cL(bt.l((Integer)com.tencent.mm.kernel.g.afB().gcR.get(1)), u.aqG());
          AppMethodBeat.o(114537);
          return;
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(str)), new Object[] { paramString.getMessage() });
        AppMethodBeat.o(114537);
        return;
      }
      j += 1;
      continue;
      label601:
      if ((!p.cSQ().cSB().contains(paramString)) && (k != 0))
      {
        p.cSQ().cSB().add(paramString);
        continue;
        label633:
        if ((i != 0) && (k == 0)) {
          p.cSO().d(paramString, (String)localObject3, false, false);
        } else if ((i != 0) && (k != 0)) {
          p.cSO().d(paramString, (String)localObject3, true, true);
        } else {
          p.cSO().d(paramString, (String)localObject3, true, false);
        }
      }
    }
    if (((a.be)localObject1).InS == 2)
    {
      ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + ((a.be)localObject1).IlV.length);
      localObject3 = ((a.be)localObject1).InU;
      localObject4 = ((a.be)localObject1).IlV;
      i = 0;
      parama = "";
      m = localObject4.length;
      j = 0;
      label756:
      if (j < m)
      {
        arrayOfay = localObject4[j];
        parama = parama + arrayOfay.Imu + ",";
        k = i;
        if (arrayOfay.Imu != null)
        {
          k = i;
          if (arrayOfay.Imu.equals(localObject2))
          {
            ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
            k = 1;
          }
        }
      }
      else
      {
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject3.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject3[j];
          if ((parama == null) || (!parama.equals(localObject2))) {
            break label1557;
          }
          ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
          k = 1;
        }
        if (i == 0)
        {
          if ((!p.cSQ().ahF(paramString)) && (p.cSQ().cSB().contains(paramString)) && (p.cSQ().hs(paramString, (String)localObject2)))
          {
            p.cSO();
            f.ahC(paramString);
          }
          p.cSQ().ahE(paramString);
          p.cSQ().cSB().remove(paramString);
        }
        for (;;)
        {
          p.cSN().tOr.cL(bt.l((Integer)com.tencent.mm.kernel.g.afB().gcR.get(1)), u.aqG());
          ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = p.cSQ();
          ad.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject2 = p.cSK().ahq(paramString);
          if (localObject2 == null) {
            break label1168;
          }
          if (((com.tencent.mm.bi.f)localObject2).field_roomId == ((a.be)localObject1).zkT) {
            break;
          }
          ad.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bi.f)localObject2).field_roomId + "bannerinfo.roomid:" + ((a.be)localObject1).zkT);
          AppMethodBeat.o(114537);
          return;
          if ((!p.cSQ().cSB().contains(paramString)) && (k != 0)) {
            p.cSQ().cSB().add(paramString);
          }
        }
        if (!h.d(paramString, (a.be)localObject1))
        {
          ad.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(114537);
          return;
        }
        parama.ahG(paramString);
        AppMethodBeat.o(114537);
        return;
        ad.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        parama.a(paramString, (a.be)localObject1);
        AppMethodBeat.o(114537);
      }
    }
    else
    {
      label863:
      if (((a.be)localObject1).InS == 0)
      {
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!p.cSQ().ahF(paramString)) && (p.cSQ().cSB().contains(paramString)) && (p.cSQ().hs(paramString, (String)localObject2)))
        {
          p.cSO();
          f.ahC(paramString);
        }
        parama = p.cSO();
        localObject1 = new bl();
        ((bl)localObject1).setType(64);
        ((bl)localObject1).kY(System.currentTimeMillis());
        ((bl)localObject1).setStatus(6);
        ((bl)localObject1).setContent(aj.getContext().getString(2131761445));
        if (q.rQ(paramString))
        {
          ((bl)localObject1).nY(paramString);
          ((bl)localObject1).setContent(((du)localObject1).field_content);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().an((bl)localObject1);
        }
        if ((parama.tOY != null) && (paramString.equals(parama.tOY.Ioi)) && (!parama.tPc.eFX()))
        {
          ad.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
          parama.tOY = null;
          parama.tOZ = 0L;
          parama.tPc.stopTimer();
        }
        p.cSQ().ahw(paramString);
        p.cSQ().ahE(paramString);
        p.cSQ().cSB().remove(paramString);
        AppMethodBeat.o(114537);
        return;
      }
      label1168:
      if (((a.be)localObject1).InS == 3)
      {
        paramString = ((a.be)localObject1).IlV;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.Imu != null) && (parama.Imu.equals(localObject2))) {
          ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(114537);
        return;
        ad.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + ((a.be)localObject1).InS);
        AppMethodBeat.o(114537);
        return;
        label1530:
        j += 1;
        i = k;
        break label323;
        label1542:
        break;
        j += 1;
        i = k;
        break label756;
        label1557:
        j += 1;
        break label863;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.g
 * JD-Core Version:    0.7.0.1
 */