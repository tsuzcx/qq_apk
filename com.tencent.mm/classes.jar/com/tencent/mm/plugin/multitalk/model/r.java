package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bg;
import com.tencent.pb.talkroom.sdk.d;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
{
  private Map<String, Long> FsR;
  
  public r()
  {
    AppMethodBeat.i(114536);
    this.FsR = new ConcurrentHashMap();
    AppMethodBeat.o(114536);
  }
  
  final void a(String paramString, h.a parama)
  {
    AppMethodBeat.i(114537);
    String str = com.tencent.mm.platformtools.z.a(parama.jQG.RIF);
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
        if ((this.FsR.get(localbg.groupId) == null) || (((Long)this.FsR.get(localbg.groupId)).longValue() < localbg.Zit))
        {
          this.FsR.put(localbg.groupId, Long.valueOf(localbg.Zit));
          parama = parama.jQG;
          paramString = com.tencent.mm.platformtools.z.a(parama.RID);
          parama = com.tencent.mm.platformtools.z.a(parama.RIE);
          localObject1 = (String)h.aHG().aHp().b(2, null);
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
        localObject2 = localbg.Zir;
        ad.eYc().fn(paramString, 1);
        if (localbg.Ziq != 1) {
          break;
        }
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
        localObject3 = localbg.Zis;
        arrayOfba = localbg.Zgp;
        i = 0;
        parama = "";
        m = arrayOfba.length;
        j = 0;
        if (j < m)
        {
          a.ba localba = arrayOfba[j];
          parama = parama + localba.fEC + ",";
          k = i;
          if (localba.fEC == null) {
            break label1401;
          }
          k = i;
          if (!localba.fEC.equals(localObject1)) {
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
          ad.eYf().aQt(paramString);
          ad.eYf().eXJ().remove(paramString);
          if (!((String)localObject1).equals(localObject2)) {
            break label641;
          }
          ad.eYc().c(paramString, (String)localObject2, false, false);
          ad.eYf().a(paramString, localbg);
          ad.eYb().Frw.ds(Util.nullAsNil((Integer)h.aHG().kcw.get(1)), com.tencent.mm.model.z.bcZ());
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
      if ((!ad.eYf().eXJ().contains(paramString)) && (k != 0))
      {
        ad.eYf().eXJ().add(paramString);
        continue;
        if ((i != 0) && (k == 0)) {
          ad.eYc().c(paramString, (String)localObject2, false, false);
        } else if ((i != 0) && (k != 0)) {
          ad.eYc().c(paramString, (String)localObject2, true, true);
        } else {
          ad.eYc().c(paramString, (String)localObject2, true, false);
        }
      }
    }
    if (localbg.Ziq == 2)
    {
      Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + localbg.Zgp.length);
      localObject2 = localbg.Zis;
      localObject3 = localbg.Zgp;
      i = 0;
      parama = "";
      m = localObject3.length;
      j = 0;
      label764:
      if (j < m)
      {
        arrayOfba = localObject3[j];
        parama = parama + arrayOfba.fEC + ",";
        k = i;
        if (arrayOfba.fEC != null)
        {
          k = i;
          if (arrayOfba.fEC.equals(localObject1))
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
          if ((!ad.eYf().aQu(paramString)) && (ad.eYf().eXJ().contains(paramString)) && (ad.eYf().iW(paramString, (String)localObject1)))
          {
            ad.eYc();
            q.aQq(paramString);
          }
          ad.eYf().aQt(paramString);
          ad.eYf().eXJ().remove(paramString);
        }
        for (;;)
        {
          ad.eYb().Frw.ds(Util.nullAsNil((Integer)h.aHG().kcw.get(1)), com.tencent.mm.model.z.bcZ());
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          parama = ad.eYf();
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { paramString });
          localObject1 = ad.eXY().aPU(paramString);
          if (localObject1 == null) {
            break label1176;
          }
          if (((com.tencent.mm.bj.f)localObject1).field_roomId == localbg.NOc) {
            break;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bj.f)localObject1).field_roomId + ", bannerinfo.roomid:" + localbg.NOc);
          AppMethodBeat.o(114537);
          return;
          if ((!ad.eYf().eXJ().contains(paramString)) && (k != 0)) {
            ad.eYf().eXJ().add(paramString);
          }
        }
        if (!s.d(paramString, localbg))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(114537);
          return;
        }
        parama.aQv(paramString);
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
      if (localbg.Ziq == 0)
      {
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
        if ((!ad.eYf().aQu(paramString)) && (ad.eYf().eXJ().contains(paramString)) && (ad.eYf().iW(paramString, (String)localObject1)))
        {
          ad.eYc();
          q.aQq(paramString);
        }
        ad.eYc().aQp(paramString);
        ad.eYc().aQk(paramString);
        ad.eYf().aQa(paramString);
        ad.eYf().aQt(paramString);
        ad.eYf().eXJ().remove(paramString);
        AppMethodBeat.o(114537);
        return;
      }
      label1176:
      if (localbg.Ziq == 3)
      {
        paramString = localbg.Zgp;
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        parama = paramString[i];
        if ((parama.fEC != null) && (parama.fEC.equals(localObject1))) {
          Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
        }
      }
      else
      {
        AppMethodBeat.o(114537);
        return;
        Log.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + localbg.Ziq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.r
 * JD-Core Version:    0.7.0.1
 */