package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.bh.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.talkroom.sdk.d;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
{
  private Map<String, Long> wrH;
  
  public p()
  {
    AppMethodBeat.i(114536);
    this.wrH = new ConcurrentHashMap();
    AppMethodBeat.o(114536);
  }
  
  final void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(114537);
    String str = com.tencent.mm.platformtools.z.a(parama.gte.FNI);
    paramString = Base64.decode(paramString.getBytes(), 0);
    ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + str + " buffer len " + paramString.length);
    a.be localbe;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    a.ay[] arrayOfay;
    int i;
    int m;
    int j;
    label331:
    int k;
    int n;
    label641:
    for (;;)
    {
      try
      {
        localbe = (a.be)com.google.b.a.e.a(new a.be(), paramString, paramString.length);
        if (localbe == null)
        {
          ae.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(str)));
          AppMethodBeat.o(114537);
          return;
        }
        if ((this.wrH.get(localbe.groupId) == null) || (((Long)this.wrH.get(localbe.groupId)).longValue() < localbe.Mgv))
        {
          this.wrH.put(localbe.groupId, Long.valueOf(localbe.Mgv));
          parama = parama.gte;
          paramString = com.tencent.mm.platformtools.z.a(parama.FNG);
          parama = com.tencent.mm.platformtools.z.a(parama.FNH);
          localObject1 = (String)g.ajR().ajA().get(2, null);
          if (localObject1 == null)
          {
            ae.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
            AppMethodBeat.o(114537);
          }
        }
        else
        {
          ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + localbe.groupId + " is early than last msg, so we do not process,now return.");
          AppMethodBeat.o(114537);
          return;
        }
        if (!((String)localObject1).equals(paramString)) {
          break label1406;
        }
        paramString = parama;
        localObject2 = localbe.Mgt;
        z.dtK().ey(paramString, 1);
        if (localbe.Mgs != 1) {
          break;
        }
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject3 = localbe.Mgu;
        arrayOfay = localbe.Met;
        i = 0;
        parama = "";
        m = arrayOfay.length;
        j = 0;
        if (j < m)
        {
          a.ay localay = arrayOfay[j];
          parama = parama + localay.duC + ",";
          k = i;
          if (localay.duC == null) {
            break label1394;
          }
          k = i;
          if (!localay.duC.equals(localObject1)) {
            break label1394;
          }
          ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
          k = 1;
          break label1394;
        }
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject3.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject3[j];
          if ((parama != null) && (parama.equals(localObject1)))
          {
            ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
            k = 1;
          }
        }
        else
        {
          if (i != 0) {
            break label609;
          }
          z.dtL().asH(paramString);
          z.dtL().dtw().remove(paramString);
          if (!((String)localObject1).equals(localObject2)) {
            break label641;
          }
          z.dtK().d(paramString, (String)localObject2, false, false);
          z.dtL().a(paramString, localbe);
          z.dtJ().wqE.cW(bu.o((Integer)g.ajR().gDO.get(1)), v.aAC());
          AppMethodBeat.o(114537);
          return;
        }
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(str)), new Object[] { paramString.getMessage() });
        AppMethodBeat.o(114537);
        return;
      }
      j += 1;
      continue;
      label609:
      if ((!z.dtL().dtw().contains(paramString)) && (k != 0))
      {
        z.dtL().dtw().add(paramString);
        continue;
        if ((i != 0) && (k == 0)) {
          z.dtK().d(paramString, (String)localObject2, false, false);
        } else if ((i != 0) && (k != 0)) {
          z.dtK().d(paramString, (String)localObject2, true, true);
        } else {
          z.dtK().d(paramString, (String)localObject2, true, false);
        }
      }
    }
    if (localbe.Mgs == 2)
    {
      ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + localbe.Met.length);
      localObject2 = localbe.Mgu;
      localObject3 = localbe.Met;
      i = 0;
      parama = "";
      m = localObject3.length;
      j = 0;
      label764:
      if (j < m)
      {
        arrayOfay = localObject3[j];
        parama = parama + arrayOfay.duC + ",";
        k = i;
        if (arrayOfay.duC != null)
        {
          k = i;
          if (arrayOfay.duC.equals(localObject1))
          {
            ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
            k = 1;
          }
        }
      }
      else
      {
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject2.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject2[j];
          if ((parama == null) || (!parama.equals(localObject1))) {
            break label1421;
          }
          ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
          k = 1;
        }
        if (i == 0)
        {
          if ((!z.dtL().asI(paramString)) && (z.dtL().dtw().contains(paramString)) && (z.dtL().ic(paramString, (String)localObject1)))
          {
            z.dtK();
            o.asE(paramString);
          }
          z.dtL().asH(paramString);
          z.dtL().dtw().remove(paramString);
        }
        for (;;)
        {
          z.dtJ().wqE.cW(bu.o((Integer)g.ajR().gDO.get(1)), v.aAC());
          ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = z.dtL();
          ae.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject1 = z.dtG().asp(paramString);
          if (localObject1 == null) {
            break label1176;
          }
          if (((f)localObject1).field_roomId == localbe.Cuf) {
            break;
          }
          ae.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((f)localObject1).field_roomId + ", bannerinfo.roomid:" + localbe.Cuf);
          AppMethodBeat.o(114537);
          return;
          if ((!z.dtL().dtw().contains(paramString)) && (k != 0)) {
            z.dtL().dtw().add(paramString);
          }
        }
        if (!q.d(paramString, localbe))
        {
          ae.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(114537);
          return;
        }
        parama.asJ(paramString);
        AppMethodBeat.o(114537);
        return;
        ae.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        parama.a(paramString, localbe);
        AppMethodBeat.o(114537);
      }
    }
    else
    {
      label871:
      if (localbe.Mgs == 0)
      {
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!z.dtL().asI(paramString)) && (z.dtL().dtw().contains(paramString)) && (z.dtL().ic(paramString, (String)localObject1)))
        {
          z.dtK();
          o.asE(paramString);
        }
        z.dtK().asD(paramString);
        z.dtL().asv(paramString);
        z.dtL().asH(paramString);
        z.dtL().dtw().remove(paramString);
        AppMethodBeat.o(114537);
        return;
      }
      label1176:
      if (localbe.Mgs == 3)
      {
        paramString = localbe.Met;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.duC != null) && (parama.duC.equals(localObject1))) {
          ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(114537);
        return;
        ae.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + localbe.Mgs);
        AppMethodBeat.o(114537);
        return;
        label1394:
        j += 1;
        i = k;
        break label331;
        label1406:
        break;
        j += 1;
        i = k;
        break label764;
        label1421:
        j += 1;
        break label871;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p
 * JD-Core Version:    0.7.0.1
 */