package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.bi.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.b.a;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
{
  private Map<String, Long> wcf;
  
  public p()
  {
    AppMethodBeat.i(114536);
    this.wcf = new ConcurrentHashMap();
    AppMethodBeat.o(114536);
  }
  
  final void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(114537);
    String str = com.tencent.mm.platformtools.z.a(parama.gqE.Fvk);
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
        if ((this.wcf.get(((a.be)localObject1).groupId) == null) || (((Long)this.wcf.get(((a.be)localObject1).groupId)).longValue() < ((a.be)localObject1).LJr))
        {
          this.wcf.put(((a.be)localObject1).groupId, Long.valueOf(((a.be)localObject1).LJr));
          parama = parama.gqE;
          paramString = com.tencent.mm.platformtools.z.a(parama.Fvi);
          parama = com.tencent.mm.platformtools.z.a(parama.Fvj);
          localObject2 = (String)g.ajC().ajl().get(2, null);
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
        localObject3 = ((a.be)localObject1).LJp;
        if (((a.be)localObject1).LJo != 1) {
          break;
        }
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject4 = ((a.be)localObject1).LJq;
        arrayOfay = ((a.be)localObject1).LHp;
        i = 0;
        parama = "";
        m = arrayOfay.length;
        j = 0;
        if (j < m)
        {
          a.ay localay = arrayOfay[j];
          parama = parama + localay.dtx + ",";
          k = i;
          if (localay.dtx == null) {
            break label1530;
          }
          k = i;
          if (!localay.dtx.equals(localObject2)) {
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
          z.dqy().arw(paramString);
          z.dqy().dqj().remove(paramString);
          if (!((String)localObject2).equals(localObject3)) {
            break label633;
          }
          z.dqx().d(paramString, (String)localObject3, false, false);
          z.dqy().a(paramString, (a.be)localObject1);
          z.dqw().wbf.cW(bt.n((Integer)g.ajC().gBh.get(1)), u.aAm());
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
      if ((!z.dqy().dqj().contains(paramString)) && (k != 0))
      {
        z.dqy().dqj().add(paramString);
        continue;
        label633:
        if ((i != 0) && (k == 0)) {
          z.dqx().d(paramString, (String)localObject3, false, false);
        } else if ((i != 0) && (k != 0)) {
          z.dqx().d(paramString, (String)localObject3, true, true);
        } else {
          z.dqx().d(paramString, (String)localObject3, true, false);
        }
      }
    }
    if (((a.be)localObject1).LJo == 2)
    {
      ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + ((a.be)localObject1).LHp.length);
      localObject3 = ((a.be)localObject1).LJq;
      localObject4 = ((a.be)localObject1).LHp;
      i = 0;
      parama = "";
      m = localObject4.length;
      j = 0;
      label756:
      if (j < m)
      {
        arrayOfay = localObject4[j];
        parama = parama + arrayOfay.dtx + ",";
        k = i;
        if (arrayOfay.dtx != null)
        {
          k = i;
          if (arrayOfay.dtx.equals(localObject2))
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
          if ((!z.dqy().arx(paramString)) && (z.dqy().dqj().contains(paramString)) && (z.dqy().hW(paramString, (String)localObject2)))
          {
            z.dqx();
            o.art(paramString);
          }
          z.dqy().arw(paramString);
          z.dqy().dqj().remove(paramString);
        }
        for (;;)
        {
          z.dqw().wbf.cW(bt.n((Integer)g.ajC().gBh.get(1)), u.aAm());
          ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = z.dqy();
          ad.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject2 = z.dqt().arh(paramString);
          if (localObject2 == null) {
            break label1168;
          }
          if (((f)localObject2).field_roomId == ((a.be)localObject1).CcE) {
            break;
          }
          ad.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((f)localObject2).field_roomId + "bannerinfo.roomid:" + ((a.be)localObject1).CcE);
          AppMethodBeat.o(114537);
          return;
          if ((!z.dqy().dqj().contains(paramString)) && (k != 0)) {
            z.dqy().dqj().add(paramString);
          }
        }
        if (!q.d(paramString, (a.be)localObject1))
        {
          ad.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(114537);
          return;
        }
        parama.ary(paramString);
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
      if (((a.be)localObject1).LJo == 0)
      {
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!z.dqy().arx(paramString)) && (z.dqy().dqj().contains(paramString)) && (z.dqy().hW(paramString, (String)localObject2)))
        {
          z.dqx();
          o.art(paramString);
        }
        parama = z.dqx();
        localObject1 = new bu();
        ((bu)localObject1).setType(64);
        ((bu)localObject1).qA(System.currentTimeMillis());
        ((bu)localObject1).setStatus(6);
        ((bu)localObject1).setContent(aj.getContext().getString(2131761445));
        if (com.tencent.mm.model.q.yK(paramString))
        {
          ((bu)localObject1).tN(paramString);
          ((bu)localObject1).setContent(((ei)localObject1).field_content);
          ((l)g.ab(l.class)).dlK().as((bu)localObject1);
        }
        if ((parama.wbK != null) && (paramString.equals(parama.wbK.LJE)) && (!parama.wbS.fkZ()))
        {
          ad.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
          parama.wbK = null;
          parama.wbL = 0L;
          parama.wbS.stopTimer();
        }
        z.dqy().arn(paramString);
        z.dqy().arw(paramString);
        z.dqy().dqj().remove(paramString);
        AppMethodBeat.o(114537);
        return;
      }
      label1168:
      if (((a.be)localObject1).LJo == 3)
      {
        paramString = ((a.be)localObject1).LHp;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.dtx != null) && (parama.dtx.equals(localObject2))) {
          ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(114537);
        return;
        ad.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + ((a.be)localObject1).LJo);
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
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p
 * JD-Core Version:    0.7.0.1
 */