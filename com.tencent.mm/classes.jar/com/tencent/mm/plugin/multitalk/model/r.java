package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.bh.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bh;
import com.tencent.pb.talkroom.sdk.d;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
{
  private Map<String, Long> zNu;
  
  public r()
  {
    AppMethodBeat.i(114536);
    this.zNu = new ConcurrentHashMap();
    AppMethodBeat.o(114536);
  }
  
  final void a(String paramString, h.a parama)
  {
    AppMethodBeat.i(114537);
    String str = com.tencent.mm.platformtools.z.a(parama.heO.KHn);
    paramString = Base64.decode(paramString.getBytes(), 0);
    Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + str + " buffer len " + paramString.length);
    a.bh localbh;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    a.bb[] arrayOfbb;
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
        localbh = (a.bh)com.google.a.a.e.a(new a.bh(), paramString, paramString.length);
        if (localbh == null)
        {
          Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:".concat(String.valueOf(str)));
          AppMethodBeat.o(114537);
          return;
        }
        if ((this.zNu.get(localbh.groupId) == null) || (((Long)this.zNu.get(localbh.groupId)).longValue() < localbh.RGN))
        {
          this.zNu.put(localbh.groupId, Long.valueOf(localbh.RGN));
          parama = parama.heO;
          paramString = com.tencent.mm.platformtools.z.a(parama.KHl);
          parama = com.tencent.mm.platformtools.z.a(parama.KHm);
          localObject1 = (String)g.aAh().azQ().get(2, null);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
            AppMethodBeat.o(114537);
          }
        }
        else
        {
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + localbh.groupId + " is early than last msg, so we do not process,now return.");
          AppMethodBeat.o(114537);
          return;
        }
        if (!((String)localObject1).equals(paramString)) {
          break label1413;
        }
        paramString = parama;
        localObject2 = localbh.RGL;
        ac.eom().eM(paramString, 1);
        if (localbh.RGK != 1) {
          break;
        }
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject3 = localbh.RGM;
        arrayOfbb = localbh.REK;
        i = 0;
        parama = "";
        m = arrayOfbb.length;
        j = 0;
        if (j < m)
        {
          a.bb localbb = arrayOfbb[j];
          parama = parama + localbb.dLN + ",";
          k = i;
          if (localbb.dLN == null) {
            break label1401;
          }
          k = i;
          if (!localbb.dLN.equals(localObject1)) {
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
          ac.eop().aGf(paramString);
          ac.eop().enT().remove(paramString);
          if (!((String)localObject1).equals(localObject2)) {
            break label641;
          }
          ac.eom().d(paramString, (String)localObject2, false, false);
          ac.eop().a(paramString, localbh);
          ac.eol().zMd.dr(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
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
      if ((!ac.eop().enT().contains(paramString)) && (k != 0))
      {
        ac.eop().enT().add(paramString);
        continue;
        if ((i != 0) && (k == 0)) {
          ac.eom().d(paramString, (String)localObject2, false, false);
        } else if ((i != 0) && (k != 0)) {
          ac.eom().d(paramString, (String)localObject2, true, true);
        } else {
          ac.eom().d(paramString, (String)localObject2, true, false);
        }
      }
    }
    if (localbh.RGK == 2)
    {
      Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + localbh.REK.length);
      localObject2 = localbh.RGM;
      localObject3 = localbh.REK;
      i = 0;
      parama = "";
      m = localObject3.length;
      j = 0;
      label764:
      if (j < m)
      {
        arrayOfbb = localObject3[j];
        parama = parama + arrayOfbb.dLN + ",";
        k = i;
        if (arrayOfbb.dLN != null)
        {
          k = i;
          if (arrayOfbb.dLN.equals(localObject1))
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
          if ((!ac.eop().aGg(paramString)) && (ac.eop().enT().contains(paramString)) && (ac.eop().iL(paramString, (String)localObject1)))
          {
            ac.eom();
            q.aGd(paramString);
          }
          ac.eop().aGf(paramString);
          ac.eop().enT().remove(paramString);
        }
        for (;;)
        {
          ac.eol().zMd.dr(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = ac.eop();
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject1 = ac.eoi().aFI(paramString);
          if (localObject1 == null) {
            break label1176;
          }
          if (((f)localObject1).field_roomId == localbh.GXO) {
            break;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((f)localObject1).field_roomId + ", bannerinfo.roomid:" + localbh.GXO);
          AppMethodBeat.o(114537);
          return;
          if ((!ac.eop().enT().contains(paramString)) && (k != 0)) {
            ac.eop().enT().add(paramString);
          }
        }
        if (!s.d(paramString, localbh))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(114537);
          return;
        }
        parama.aGh(paramString);
        AppMethodBeat.o(114537);
        return;
        Log.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        parama.a(paramString, localbh);
        AppMethodBeat.o(114537);
      }
    }
    else
    {
      label871:
      if (localbh.RGK == 0)
      {
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!ac.eop().aGg(paramString)) && (ac.eop().enT().contains(paramString)) && (ac.eop().iL(paramString, (String)localObject1)))
        {
          ac.eom();
          q.aGd(paramString);
        }
        ac.eom().aGc(paramString);
        ac.eom().aFX(paramString);
        ac.eop().aFO(paramString);
        ac.eop().aGf(paramString);
        ac.eop().enT().remove(paramString);
        AppMethodBeat.o(114537);
        return;
      }
      label1176:
      if (localbh.RGK == 3)
      {
        paramString = localbh.REK;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.dLN != null) && (parama.dLN.equals(localObject1))) {
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(114537);
        return;
        Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + localbh.RGK);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.r
 * JD-Core Version:    0.7.0.1
 */