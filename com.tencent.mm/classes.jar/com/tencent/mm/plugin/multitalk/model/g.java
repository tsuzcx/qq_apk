package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.multitalk.b.a;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private Map<String, Long> uXQ;
  
  public g()
  {
    AppMethodBeat.i(114536);
    this.uXQ = new ConcurrentHashMap();
    AppMethodBeat.o(114536);
  }
  
  final void a(String paramString, f.a parama)
  {
    AppMethodBeat.i(114537);
    String str = z.a(parama.fXi.DPV);
    paramString = Base64.decode(paramString.getBytes(), 0);
    ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + str + " buffer len " + paramString.length);
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
          ac.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(str)));
          AppMethodBeat.o(114537);
          return;
        }
        if ((this.uXQ.get(((a.be)localObject1).groupId) == null) || (((Long)this.uXQ.get(((a.be)localObject1).groupId)).longValue() < ((a.be)localObject1).JPF))
        {
          this.uXQ.put(((a.be)localObject1).groupId, Long.valueOf(((a.be)localObject1).JPF));
          parama = parama.fXi;
          paramString = z.a(parama.DPT);
          parama = z.a(parama.DPU);
          localObject2 = (String)com.tencent.mm.kernel.g.agR().agA().get(2, null);
          if (localObject2 == null)
          {
            ac.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
            AppMethodBeat.o(114537);
          }
        }
        else
        {
          ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + ((a.be)localObject1).groupId + " is early than last msg, so we do not process,now return.");
          AppMethodBeat.o(114537);
          return;
        }
        if (!((String)localObject2).equals(paramString)) {
          break label1542;
        }
        paramString = parama;
        localObject3 = ((a.be)localObject1).JPD;
        if (((a.be)localObject1).JPC != 1) {
          break;
        }
        ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject4 = ((a.be)localObject1).JPE;
        arrayOfay = ((a.be)localObject1).JNG;
        i = 0;
        parama = "";
        m = arrayOfay.length;
        j = 0;
        if (j < m)
        {
          a.ay localay = arrayOfay[j];
          parama = parama + localay.dhV + ",";
          k = i;
          if (localay.dhV == null) {
            break label1530;
          }
          k = i;
          if (!localay.dhV.equals(localObject2)) {
            break label1530;
          }
          ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
          k = 1;
          break label1530;
        }
        ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject4.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject4[j];
          if ((parama != null) && (parama.equals(localObject2)))
          {
            ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
            k = 1;
          }
        }
        else
        {
          if (i != 0) {
            break label601;
          }
          p.dgz().amz(paramString);
          p.dgz().dgk().remove(paramString);
          if (!((String)localObject2).equals(localObject3)) {
            break label633;
          }
          p.dgx().d(paramString, (String)localObject3, false, false);
          p.dgz().a(paramString, (a.be)localObject1);
          p.dgw().uWU.cO(bs.m((Integer)com.tencent.mm.kernel.g.agR().ghx.get(1)), u.axw());
          AppMethodBeat.o(114537);
          return;
        }
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(str)), new Object[] { paramString.getMessage() });
        AppMethodBeat.o(114537);
        return;
      }
      j += 1;
      continue;
      label601:
      if ((!p.dgz().dgk().contains(paramString)) && (k != 0))
      {
        p.dgz().dgk().add(paramString);
        continue;
        label633:
        if ((i != 0) && (k == 0)) {
          p.dgx().d(paramString, (String)localObject3, false, false);
        } else if ((i != 0) && (k != 0)) {
          p.dgx().d(paramString, (String)localObject3, true, true);
        } else {
          p.dgx().d(paramString, (String)localObject3, true, false);
        }
      }
    }
    if (((a.be)localObject1).JPC == 2)
    {
      ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + ((a.be)localObject1).JNG.length);
      localObject3 = ((a.be)localObject1).JPE;
      localObject4 = ((a.be)localObject1).JNG;
      i = 0;
      parama = "";
      m = localObject4.length;
      j = 0;
      label756:
      if (j < m)
      {
        arrayOfay = localObject4[j];
        parama = parama + arrayOfay.dhV + ",";
        k = i;
        if (arrayOfay.dhV != null)
        {
          k = i;
          if (arrayOfay.dhV.equals(localObject2))
          {
            ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
            k = 1;
          }
        }
      }
      else
      {
        ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
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
          ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
          k = 1;
        }
        if (i == 0)
        {
          if ((!p.dgz().amA(paramString)) && (p.dgz().dgk().contains(paramString)) && (p.dgz().hL(paramString, (String)localObject2)))
          {
            p.dgx();
            f.amx(paramString);
          }
          p.dgz().amz(paramString);
          p.dgz().dgk().remove(paramString);
        }
        for (;;)
        {
          p.dgw().uWU.cO(bs.m((Integer)com.tencent.mm.kernel.g.agR().ghx.get(1)), u.axw());
          ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = p.dgz();
          ac.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject2 = p.dgt().aml(paramString);
          if (localObject2 == null) {
            break label1168;
          }
          if (((com.tencent.mm.bh.f)localObject2).field_roomId == ((a.be)localObject1).ADE) {
            break;
          }
          ac.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bh.f)localObject2).field_roomId + "bannerinfo.roomid:" + ((a.be)localObject1).ADE);
          AppMethodBeat.o(114537);
          return;
          if ((!p.dgz().dgk().contains(paramString)) && (k != 0)) {
            p.dgz().dgk().add(paramString);
          }
        }
        if (!h.d(paramString, (a.be)localObject1))
        {
          ac.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(114537);
          return;
        }
        parama.amB(paramString);
        AppMethodBeat.o(114537);
        return;
        ac.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        parama.a(paramString, (a.be)localObject1);
        AppMethodBeat.o(114537);
      }
    }
    else
    {
      label863:
      if (((a.be)localObject1).JPC == 0)
      {
        ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!p.dgz().amA(paramString)) && (p.dgz().dgk().contains(paramString)) && (p.dgz().hL(paramString, (String)localObject2)))
        {
          p.dgx();
          f.amx(paramString);
        }
        parama = p.dgx();
        localObject1 = new bo();
        ((bo)localObject1).setType(64);
        ((bo)localObject1).oA(System.currentTimeMillis());
        ((bo)localObject1).setStatus(6);
        ((bo)localObject1).setContent(ai.getContext().getString(2131761445));
        if (q.vT(paramString))
        {
          ((bo)localObject1).re(paramString);
          ((bo)localObject1).setContent(((dy)localObject1).field_content);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().ap((bo)localObject1);
        }
        if ((parama.uXA != null) && (paramString.equals(parama.uXA.JPT)) && (!parama.uXE.eVs()))
        {
          ac.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
          parama.uXA = null;
          parama.uXB = 0L;
          parama.uXE.stopTimer();
        }
        p.dgz().amr(paramString);
        p.dgz().amz(paramString);
        p.dgz().dgk().remove(paramString);
        AppMethodBeat.o(114537);
        return;
      }
      label1168:
      if (((a.be)localObject1).JPC == 3)
      {
        paramString = ((a.be)localObject1).JNG;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.dhV != null) && (parama.dhV.equals(localObject2))) {
          ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(114537);
        return;
        ac.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + ((a.be)localObject1).JPC);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.g
 * JD-Core Version:    0.7.0.1
 */