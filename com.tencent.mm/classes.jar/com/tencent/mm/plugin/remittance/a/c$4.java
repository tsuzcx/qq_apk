package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.b.b;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

final class c$4
  implements bz.a
{
  c$4(c paramc) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(44427);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
    parama = parama.eyJ;
    if (parama == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
      AppMethodBeat.o(44427);
      return;
    }
    parama = aa.a(parama.woR);
    if (bo.isNullOrNil(parama))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
      AppMethodBeat.o(44427);
      return;
    }
    parama = br.F(parama, "sysmsg");
    if (parama == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
      AppMethodBeat.o(44427);
      return;
    }
    Object localObject1 = (String)parama.get(".sysmsg.paymsg.PayMsgType");
    Object localObject2;
    if ("15".equals(localObject1))
    {
      localObject1 = URLDecoder.decode((String)parama.get(".sysmsg.paymsg.appmsgcontent"));
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
        AppMethodBeat.o(44427);
        return;
      }
      localObject2 = br.F((String)localObject1, "msg");
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
        AppMethodBeat.o(44427);
        return;
      }
      localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.transferid");
      if (bo.isNullOrNil((String)localObject2))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
        AppMethodBeat.o(44427);
        return;
      }
      if (this.qfI.cgK().Yg((String)localObject2))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
        AppMethodBeat.o(44427);
        return;
      }
      parama = (String)parama.get(".sysmsg.paymsg.tousername");
      if ((bo.isNullOrNil((String)localObject1)) || (bo.isNullOrNil(parama)))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
        AppMethodBeat.o(44427);
        return;
      }
      this.qfI.cgK().ac((String)localObject2, (String)localObject1, parama);
      AppMethodBeat.o(44427);
      return;
    }
    String str1;
    int i;
    if ("22".equals(localObject1))
    {
      localObject1 = (String)parama.get(".sysmsg.paymsg.tousername");
      String str2 = (String)parama.get(".sysmsg.paymsg.fromusername");
      try
      {
        str1 = URLDecoder.decode((String)parama.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
        if (bo.isNullOrNil(str1))
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
          AppMethodBeat.o(44427);
          return;
        }
      }
      catch (UnsupportedEncodingException parama)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.SubCoreRemittance", parama, "", new Object[0]);
        AppMethodBeat.o(44427);
        return;
      }
      parama = br.F(str1, "msg");
      if (parama == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
        AppMethodBeat.o(44427);
        return;
      }
      localObject2 = (String)parama.get(".msg.appmsg.wcpayinfo.transferid");
      i = bo.getInt((String)parama.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { str2, localObject1, localObject2, Integer.valueOf(i) });
      parama = null;
      try
      {
        c.cgH();
        localObject1 = c.cgI().Yd((String)localObject2);
        parama = (e.a)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
        }
        localbi = ((j)g.E(j.class)).bPQ().kB(parama.field_msgId);
        if (localbi.field_msgId > 0L) {
          break label596;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreRemittance", "has delete msg");
        c.cgH();
        c.cgI().delete(parama, new String[0]);
        AppMethodBeat.o(44427);
        return;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(localbi.field_msgId) });
        localbi.setContent(str1);
        ((j)g.E(j.class)).bPQ().a(localbi.field_msgId, localbi);
        parama = c.cgJ().Ye((String)localObject2);
        if (parama == null) {
          break label682;
        }
        parama.field_receiveStatus = i;
        c.cgJ().a(parama);
        AppMethodBeat.o(44427);
        return;
        if (localbi.field_talker.equals(r.Zn())) {
          break label737;
        }
        parama = new com.tencent.mm.plugin.remittance.b.c();
        parama.field_locaMsgId = localbi.field_msgId;
        parama.field_transferId = ((String)localObject2);
        parama.field_receiveStatus = i;
        parama.field_isSend = false;
        c.cgJ().a(parama);
        AppMethodBeat.o(44427);
        return;
      }
      if (parama == null)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreRemittance", "empty record");
        AppMethodBeat.o(44427);
        return;
      }
    }
    bi localbi;
    label596:
    label737:
    if ("33".equals(localbi))
    {
      i = bo.getInt((String)parama.get(".sysmsg.paymsg.opentransferbankcard"), 0);
      parama = g.RL().Ru();
      parama.set(ac.a.yIJ, Integer.valueOf(i));
      int j = ((Integer)parama.get(ac.a.yIK, Integer.valueOf(0))).intValue();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j == 0)
      {
        com.tencent.mm.x.c.PJ().b(ac.a.yIE, true);
        parama.set(ac.a.yIK, Integer.valueOf(1));
        g.RL().Ru().set(ac.a.yIF, Boolean.FALSE);
      }
    }
    label682:
    AppMethodBeat.o(44427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c.4
 * JD-Core Version:    0.7.0.1
 */