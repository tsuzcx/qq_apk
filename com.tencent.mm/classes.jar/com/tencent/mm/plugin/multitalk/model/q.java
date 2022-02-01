package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.multitalk.d.a;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bg;
import com.tencent.pb.talkroom.sdk.d;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class q
{
  private Map<String, Long> Lpl;
  
  public q()
  {
    AppMethodBeat.i(114536);
    this.Lpl = new ConcurrentHashMap();
    AppMethodBeat.o(114536);
  }
  
  final void a(String paramString, g.a parama)
  {
    AppMethodBeat.i(114537);
    String str = w.a(parama.mpN.YFG);
    paramString = Base64.decode(paramString.getBytes(), 0);
    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + str + " buffer len " + paramString.length);
    a.bg localbg;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    a.ba[] arrayOfba;
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
        localbg = (a.bg)e.a(new a.bg(), paramString, paramString.length);
        if (localbg == null)
        {
          Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(str)));
          AppMethodBeat.o(114537);
          return;
        }
        if ((this.Lpl.get(localbg.groupId) == null) || (((Long)this.Lpl.get(localbg.groupId)).longValue() < localbg.ahgU))
        {
          this.Lpl.put(localbg.groupId, Long.valueOf(localbg.ahgU));
          parama = parama.mpN;
          paramString = w.a(parama.YFE);
          parama = w.a(parama.YFF);
          localObject1 = (String)h.baE().ban().d(2, null);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
            AppMethodBeat.o(114537);
          }
        }
        else
        {
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + localbg.groupId + " is early than last msg, so we do not process,now return.");
          AppMethodBeat.o(114537);
          return;
        }
        if (!((String)localObject1).equals(paramString)) {
          break label1413;
        }
        paramString = parama;
        localObject2 = localbg.ahgS;
        ac.ggS().gg(paramString, 1);
        if (localbg.ahgR != 1) {
          break;
        }
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject3 = localbg.ahgT;
        arrayOfba = localbg.aheQ;
        i = 0;
        parama = "";
        m = arrayOfba.length;
        j = 0;
        if (j < m)
        {
          a.ba localba = arrayOfba[j];
          parama = parama + localba.hJs + ",";
          k = i;
          if (localba.hJs == null) {
            break label1401;
          }
          k = i;
          if (!localba.hJs.equals(localObject1)) {
            break label1401;
          }
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
          k = 1;
          break label1401;
        }
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject3.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject3[j];
          if ((parama != null) && (parama.equals(localObject1)))
          {
            Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
            k = 1;
          }
        }
        else
        {
          if (i != 0) {
            break label609;
          }
          ac.ggV().aNm(paramString);
          ac.ggV().ggx().remove(paramString);
          if (!((String)localObject1).equals(localObject2)) {
            break label641;
          }
          ac.ggS().c(paramString, (String)localObject2, false, false);
          ac.ggV().a(paramString, localbg);
          ac.ggR().LnJ.em(Util.nullAsNil((Integer)h.baE().mCE.get(1)), z.bAM());
          AppMethodBeat.o(114537);
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:".concat(String.valueOf(str)), new Object[] { paramString.getMessage() });
        AppMethodBeat.o(114537);
        return;
      }
      j += 1;
      continue;
      label609:
      if ((!ac.ggV().ggx().contains(paramString)) && (k != 0))
      {
        ac.ggV().ggx().add(paramString);
        continue;
        if ((i != 0) && (k == 0)) {
          ac.ggS().c(paramString, (String)localObject2, false, false);
        } else if ((i != 0) && (k != 0)) {
          ac.ggS().c(paramString, (String)localObject2, true, true);
        } else {
          ac.ggS().c(paramString, (String)localObject2, true, false);
        }
      }
    }
    if (localbg.ahgR == 2)
    {
      Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + localbg.aheQ.length);
      localObject2 = localbg.ahgT;
      localObject3 = localbg.aheQ;
      i = 0;
      parama = "";
      m = localObject3.length;
      j = 0;
      label764:
      if (j < m)
      {
        arrayOfba = localObject3[j];
        parama = parama + arrayOfba.hJs + ",";
        k = i;
        if (arrayOfba.hJs != null)
        {
          k = i;
          if (arrayOfba.hJs.equals(localObject1))
          {
            Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
            k = 1;
          }
        }
      }
      else
      {
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :".concat(String.valueOf(parama)));
        m = 0;
        n = localObject2.length;
        j = 0;
        k = m;
        if (j < n)
        {
          parama = localObject2[j];
          if ((parama == null) || (!parama.equals(localObject1))) {
            break label1428;
          }
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
          k = 1;
        }
        if (i == 0)
        {
          if ((!ac.ggV().aNn(paramString)) && (ac.ggV().ggx().contains(paramString)) && (ac.ggV().kl(paramString, (String)localObject1)))
          {
            ac.ggS();
            p.aNk(paramString);
          }
          ac.ggV().aNm(paramString);
          ac.ggV().ggx().remove(paramString);
        }
        for (;;)
        {
          ac.ggR().LnJ.em(Util.nullAsNil((Integer)h.baE().mCE.get(1)), z.bAM());
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = ac.ggV();
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject1 = ac.ggO().aMP(paramString);
          if (localObject1 == null) {
            break label1176;
          }
          if (((com.tencent.mm.bc.f)localObject1).field_roomId == localbg.UAZ) {
            break;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bc.f)localObject1).field_roomId + ", bannerinfo.roomid:" + localbg.UAZ);
          AppMethodBeat.o(114537);
          return;
          if ((!ac.ggV().ggx().contains(paramString)) && (k != 0)) {
            ac.ggV().ggx().add(paramString);
          }
        }
        if (!r.d(paramString, localbg))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(114537);
          return;
        }
        parama.aNo(paramString);
        AppMethodBeat.o(114537);
        return;
        Log.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        parama.a(paramString, localbg);
        AppMethodBeat.o(114537);
      }
    }
    else
    {
      label871:
      if (localbg.ahgR == 0)
      {
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!ac.ggV().aNn(paramString)) && (ac.ggV().ggx().contains(paramString)) && (ac.ggV().kl(paramString, (String)localObject1)))
        {
          ac.ggS();
          p.aNk(paramString);
        }
        ac.ggS().aNj(paramString);
        ac.ggS().aNf(paramString);
        ac.ggV().aMV(paramString);
        ac.ggV().aNm(paramString);
        ac.ggV().ggx().remove(paramString);
        AppMethodBeat.o(114537);
        return;
      }
      label1176:
      if (localbg.ahgR == 3)
      {
        paramString = localbg.aheQ;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.hJs != null) && (parama.hJs.equals(localObject1))) {
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(114537);
        return;
        Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + localbg.ahgR);
        AppMethodBeat.o(114537);
        return;
        label1401:
        j += 1;
        i = k;
        break label331;
        label1413:
        break;
        j += 1;
        i = k;
        break label764;
        label1428:
        j += 1;
        break label871;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.q
 * JD-Core Version:    0.7.0.1
 */