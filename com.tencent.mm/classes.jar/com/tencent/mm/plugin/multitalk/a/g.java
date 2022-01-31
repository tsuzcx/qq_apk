package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.b.a;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private Map<String, Long> mue = new ConcurrentHashMap();
  
  final void a(String paramString, e.a parama)
  {
    String str = aa.a(parama.dBs.svH);
    paramString = Base64.decode(paramString.getBytes(), 0);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + str + " buffer len " + paramString.length);
    Object localObject1;
    Object localObject2;
    try
    {
      localObject1 = (a.bb)com.google.a.a.e.a(new a.bb(), paramString, paramString.length);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:" + str);
        return;
      }
      if ((this.mue.get(((a.bb)localObject1).groupId) == null) || (((Long)this.mue.get(((a.bb)localObject1).groupId)).longValue() < ((a.bb)localObject1).wJA))
      {
        this.mue.put(((a.bb)localObject1).groupId, Long.valueOf(((a.bb)localObject1).wJA));
        parama = parama.dBs;
        paramString = aa.a(parama.svF);
        parama = aa.a(parama.svG);
        localObject2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, null);
        if (localObject2 != null) {
          break label284;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
        return;
      }
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:" + str, new Object[] { paramString.getMessage() });
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + ((a.bb)localObject1).groupId + " is early than last msg, so we do not process,now return.");
    return;
    label284:
    int i;
    int j;
    label345:
    int k;
    if (((String)localObject2).equals(paramString))
    {
      paramString = parama;
      Object localObject3 = ((a.bb)localObject1).wJy;
      Object localObject4;
      a.av[] arrayOfav;
      int m;
      int n;
      if (((a.bb)localObject1).wJx == 1)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject4 = ((a.bb)localObject1).wJz;
        arrayOfav = ((a.bb)localObject1).wHz;
        i = 0;
        parama = "";
        m = arrayOfav.length;
        j = 0;
        if (j < m)
        {
          a.av localav = arrayOfav[j];
          parama = parama + localav.wHY + ",";
          k = i;
          if (localav.wHY != null)
          {
            k = i;
            if (localav.wHY.equals(localObject2))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
              k = 1;
            }
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + parama);
          m = 0;
          n = localObject4.length;
          j = 0;
          label459:
          k = m;
          if (j < n)
          {
            parama = localObject4[j];
            if ((parama == null) || (!parama.equals(localObject2))) {
              break label1497;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
            k = 1;
          }
          if (i == 0)
          {
            p.blH().II(paramString);
            p.blH().bls().remove(paramString);
            if (!((String)localObject2).equals(localObject3)) {
              break label614;
            }
            p.blF().b(paramString, (String)localObject3, false, false);
          }
          for (;;)
          {
            p.blH().a(paramString, (a.bb)localObject1);
            p.blE().mtp.bk(bk.g((Integer)com.tencent.mm.kernel.g.DP().dKo.get(1)), q.Gj());
            return;
            if ((p.blH().bls().contains(paramString)) || (k == 0)) {
              break;
            }
            p.blH().bls().add(paramString);
            break;
            label614:
            if ((i != 0) && (k == 0)) {
              p.blF().b(paramString, (String)localObject3, false, false);
            } else if ((i != 0) && (k != 0)) {
              p.blF().b(paramString, (String)localObject3, true, true);
            } else {
              p.blF().b(paramString, (String)localObject3, true, false);
            }
          }
        }
      }
      else
      {
        if (((a.bb)localObject1).wJx == 2)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + ((a.bb)localObject1).wHz.length);
          localObject3 = ((a.bb)localObject1).wJz;
          localObject4 = ((a.bb)localObject1).wHz;
          i = 0;
          parama = "";
          m = localObject4.length;
          j = 0;
          label737:
          if (j < m)
          {
            arrayOfav = localObject4[j];
            parama = parama + arrayOfav.wHY + ",";
            k = i;
            if (arrayOfav.wHY == null) {
              break label1506;
            }
            k = i;
            if (!arrayOfav.wHY.equals(localObject2)) {
              break label1506;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
            k = 1;
            break label1506;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + parama);
          m = 0;
          n = localObject3.length;
          j = 0;
          label851:
          k = m;
          if (j < n)
          {
            parama = localObject3[j];
            if ((parama == null) || (!parama.equals(localObject2))) {
              break label1518;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
            k = 1;
          }
          if (i == 0)
          {
            if ((!p.blH().IJ(paramString)) && (p.blH().bls().contains(paramString)) && (p.blH().dU(paramString, (String)localObject2)))
            {
              p.blF();
              f.IG(paramString);
            }
            p.blH().II(paramString);
            p.blH().bls().remove(paramString);
          }
          for (;;)
          {
            p.blE().mtp.bk(bk.g((Integer)com.tencent.mm.kernel.g.DP().dKo.get(1)), q.Gj());
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
            parama = p.blH();
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
            localObject2 = p.blB().Iu(paramString);
            if (localObject2 == null) {
              break label1141;
            }
            if (((com.tencent.mm.bf.f)localObject2).field_roomId == ((a.bb)localObject1).pRI) {
              break;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bf.f)localObject2).field_roomId + "bannerinfo.roomid:" + ((a.bb)localObject1).pRI);
            return;
            if ((!p.blH().bls().contains(paramString)) && (k != 0)) {
              p.blH().bls().add(paramString);
            }
          }
          if (!h.c(paramString, (a.bb)localObject1))
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
            return;
          }
          parama.IK(paramString);
          return;
          label1141:
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
          parama.a(paramString, (a.bb)localObject1);
          return;
        }
        if (((a.bb)localObject1).wJx == 0)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
          if ((!p.blH().IJ(paramString)) && (p.blH().bls().contains(paramString)) && (p.blH().dU(paramString, (String)localObject2)))
          {
            p.blF();
            f.IG(paramString);
          }
          parama = p.blF();
          localObject1 = new bi();
          ((bi)localObject1).setType(64);
          ((bi)localObject1).bg(System.currentTimeMillis());
          ((bi)localObject1).setStatus(6);
          ((bi)localObject1).setContent(ae.getContext().getString(a.g.multitalk_system_master_multi_finish_msg));
          if (m.gE(paramString))
          {
            ((bi)localObject1).ec(paramString);
            ((bi)localObject1).setContent(((cs)localObject1).field_content);
            ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T((bi)localObject1);
          }
          if ((parama.mtT != null) && (paramString.equals(parama.mtT.wJN)) && (!parama.mtV.crl()))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
            parama.mtT = null;
            parama.mtU = 0L;
            parama.mtV.stopTimer();
          }
          p.blH().IA(paramString);
          p.blH().II(paramString);
          p.blH().bls().remove(paramString);
          return;
        }
        if (((a.bb)localObject1).wJx == 3)
        {
          paramString = ((a.bb)localObject1).wHz;
          j = paramString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.wHY != null) && (parama.wHY.equals(localObject2)))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
          break label1527;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + ((a.bb)localObject1).wJx);
        }
      }
      else
      {
        return;
        j += 1;
        i = k;
        break label345;
        break;
        label1497:
        j += 1;
        break label459;
        label1506:
        j += 1;
        i = k;
        break label737;
        label1518:
        j += 1;
        break label851;
      }
      label1527:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.g
 * JD-Core Version:    0.7.0.1
 */