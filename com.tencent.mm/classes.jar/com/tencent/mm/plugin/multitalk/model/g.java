package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private Map<String, Long> oTT;
  
  public g()
  {
    AppMethodBeat.i(54005);
    this.oTT = new ConcurrentHashMap();
    AppMethodBeat.o(54005);
  }
  
  final void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(54006);
    String str = aa.a(parama.eyJ.woR);
    paramString = Base64.decode(paramString.getBytes(), 0);
    ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + str + " buffer len " + paramString.length);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    a.av[] arrayOfav;
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
        localObject1 = (a.bb)com.google.a.a.e.a(new a.bb(), paramString, paramString.length);
        if (localObject1 == null)
        {
          ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(str)));
          AppMethodBeat.o(54006);
          return;
        }
        if ((this.oTT.get(((a.bb)localObject1).groupId) == null) || (((Long)this.oTT.get(((a.bb)localObject1).groupId)).longValue() < ((a.bb)localObject1).Bha))
        {
          this.oTT.put(((a.bb)localObject1).groupId, Long.valueOf(((a.bb)localObject1).Bha));
          parama = parama.eyJ;
          paramString = aa.a(parama.woP);
          parama = aa.a(parama.woQ);
          localObject2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, null);
          if (localObject2 == null)
          {
            ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
            AppMethodBeat.o(54006);
          }
        }
        else
        {
          ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + ((a.bb)localObject1).groupId + " is early than last msg, so we do not process,now return.");
          AppMethodBeat.o(54006);
          return;
        }
        if (!((String)localObject2).equals(paramString)) {
          break label1542;
        }
        paramString = parama;
        localObject3 = ((a.bb)localObject1).BgY;
        if (((a.bb)localObject1).BgX != 1) {
          break;
        }
        ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject4 = ((a.bb)localObject1).BgZ;
        arrayOfav = ((a.bb)localObject1).BeZ;
        i = 0;
        parama = "";
        m = arrayOfav.length;
        j = 0;
        if (j < m)
        {
          a.av localav = arrayOfav[j];
          parama = parama + localav.Bfy + ",";
          k = i;
          if (localav.Bfy == null) {
            break label1530;
          }
          k = i;
          if (!localav.Bfy.equals(localObject2)) {
            break label1530;
          }
          ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
          k = 1;
          break label1530;
        }
        ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject4.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject4[j];
          if ((parama != null) && (parama.equals(localObject2)))
          {
            ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
            k = 1;
          }
        }
        else
        {
          if (i != 0) {
            break label601;
          }
          p.bTH().Ux(paramString);
          p.bTH().bTs().remove(paramString);
          if (!((String)localObject2).equals(localObject3)) {
            break label633;
          }
          p.bTF().c(paramString, (String)localObject3, false, false);
          p.bTH().a(paramString, (a.bb)localObject1);
          p.bTE().oTa.bQ(bo.g((Integer)com.tencent.mm.kernel.g.RL().eHM.get(1)), r.Zn());
          AppMethodBeat.o(54006);
          return;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(str)), new Object[] { paramString.getMessage() });
        AppMethodBeat.o(54006);
        return;
      }
      j += 1;
      continue;
      label601:
      if ((!p.bTH().bTs().contains(paramString)) && (k != 0))
      {
        p.bTH().bTs().add(paramString);
        continue;
        label633:
        if ((i != 0) && (k == 0)) {
          p.bTF().c(paramString, (String)localObject3, false, false);
        } else if ((i != 0) && (k != 0)) {
          p.bTF().c(paramString, (String)localObject3, true, true);
        } else {
          p.bTF().c(paramString, (String)localObject3, true, false);
        }
      }
    }
    if (((a.bb)localObject1).BgX == 2)
    {
      ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + ((a.bb)localObject1).BeZ.length);
      localObject3 = ((a.bb)localObject1).BgZ;
      localObject4 = ((a.bb)localObject1).BeZ;
      i = 0;
      parama = "";
      m = localObject4.length;
      j = 0;
      label756:
      if (j < m)
      {
        arrayOfav = localObject4[j];
        parama = parama + arrayOfav.Bfy + ",";
        k = i;
        if (arrayOfav.Bfy != null)
        {
          k = i;
          if (arrayOfav.Bfy.equals(localObject2))
          {
            ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
            k = 1;
          }
        }
      }
      else
      {
        ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
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
          ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
          k = 1;
        }
        if (i == 0)
        {
          if ((!p.bTH().Uy(paramString)) && (p.bTH().bTs().contains(paramString)) && (p.bTH().fn(paramString, (String)localObject2)))
          {
            p.bTF();
            f.Uv(paramString);
          }
          p.bTH().Ux(paramString);
          p.bTH().bTs().remove(paramString);
        }
        for (;;)
        {
          p.bTE().oTa.bQ(bo.g((Integer)com.tencent.mm.kernel.g.RL().eHM.get(1)), r.Zn());
          ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = p.bTH();
          ab.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject2 = p.bTB().Uj(paramString);
          if (localObject2 == null) {
            break label1168;
          }
          if (((com.tencent.mm.bg.f)localObject2).field_roomId == ((a.bb)localObject1).twP) {
            break;
          }
          ab.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bg.f)localObject2).field_roomId + "bannerinfo.roomid:" + ((a.bb)localObject1).twP);
          AppMethodBeat.o(54006);
          return;
          if ((!p.bTH().bTs().contains(paramString)) && (k != 0)) {
            p.bTH().bTs().add(paramString);
          }
        }
        if (!h.d(paramString, (a.bb)localObject1))
        {
          ab.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(54006);
          return;
        }
        parama.Uz(paramString);
        AppMethodBeat.o(54006);
        return;
        ab.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        parama.a(paramString, (a.bb)localObject1);
        AppMethodBeat.o(54006);
      }
    }
    else
    {
      label863:
      if (((a.bb)localObject1).BgX == 0)
      {
        ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!p.bTH().Uy(paramString)) && (p.bTH().bTs().contains(paramString)) && (p.bTH().fn(paramString, (String)localObject2)))
        {
          p.bTF();
          f.Uv(paramString);
        }
        parama = p.bTF();
        localObject1 = new bi();
        ((bi)localObject1).setType(64);
        ((bi)localObject1).fQ(System.currentTimeMillis());
        ((bi)localObject1).setStatus(6);
        ((bi)localObject1).setContent(ah.getContext().getString(2131301704));
        if (n.nn(paramString))
        {
          ((bi)localObject1).kj(paramString);
          ((bi)localObject1).setContent(((dd)localObject1).field_content);
          ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z((bi)localObject1);
        }
        if ((parama.oTG != null) && (paramString.equals(parama.oTG.Bhn)) && (!parama.oTJ.dtj()))
        {
          ab.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
          parama.oTG = null;
          parama.oTH = 0L;
          parama.oTJ.stopTimer();
        }
        p.bTH().Up(paramString);
        p.bTH().Ux(paramString);
        p.bTH().bTs().remove(paramString);
        AppMethodBeat.o(54006);
        return;
      }
      label1168:
      if (((a.bb)localObject1).BgX == 3)
      {
        paramString = ((a.bb)localObject1).BeZ;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.Bfy != null) && (parama.Bfy.equals(localObject2))) {
          ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(54006);
        return;
        ab.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + ((a.bb)localObject1).BgX);
        AppMethodBeat.o(54006);
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