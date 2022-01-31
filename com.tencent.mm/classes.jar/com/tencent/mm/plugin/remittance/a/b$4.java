package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

final class b$4
  implements bx.a
{
  b$4(b paramb) {}
  
  public final void a(e.a parama)
  {
    y.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
    parama = parama.dBs;
    if (parama == null) {
      y.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
    }
    int j;
    do
    {
      bi localbi;
      do
      {
        Object localObject2;
        String str1;
        do
        {
          return;
          parama = aa.a(parama.svH);
          if (bk.bl(parama))
          {
            y.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
            return;
          }
          parama = bn.s(parama, "sysmsg");
          if (parama == null)
          {
            y.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
            return;
          }
          Object localObject1 = (String)parama.get(".sysmsg.paymsg.PayMsgType");
          if ("15".equals(localObject1))
          {
            localObject1 = URLDecoder.decode((String)parama.get(".sysmsg.paymsg.appmsgcontent"));
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              y.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
              return;
            }
            localObject2 = bn.s((String)localObject1, "msg");
            if (localObject2 == null)
            {
              y.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
              return;
            }
            localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.transferid");
            if (bk.bl((String)localObject2))
            {
              y.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
              return;
            }
            if (this.nuP.bvV().LN((String)localObject2))
            {
              y.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
              return;
            }
            parama = (String)parama.get(".sysmsg.paymsg.tousername");
            if ((bk.bl((String)localObject1)) || (bk.bl(parama)))
            {
              y.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
              return;
            }
            this.nuP.bvV().T((String)localObject2, (String)localObject1, parama);
            return;
          }
          if (!"22".equals(localObject1)) {
            break;
          }
          localObject1 = (String)parama.get(".sysmsg.paymsg.tousername");
          String str2 = (String)parama.get(".sysmsg.paymsg.fromusername");
          try
          {
            str1 = URLDecoder.decode((String)parama.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
            if (bk.bl(str1))
            {
              y.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
              return;
            }
          }
          catch (UnsupportedEncodingException parama)
          {
            y.printErrStackTrace("MicroMsg.SubCoreRemittance", parama, "", new Object[0]);
            return;
          }
          parama = bn.s(str1, "msg");
          if (parama == null)
          {
            y.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            return;
          }
          localObject2 = (String)parama.get(".msg.appmsg.wcpayinfo.transferid");
          i = bk.getInt((String)parama.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
          y.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { str2, localObject1, localObject2, Integer.valueOf(i) });
          parama = null;
          try
          {
            b.bvS();
            localObject1 = b.bvT().LL((String)localObject2);
            parama = (e.a)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
            }
            localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(parama.field_msgId);
            if (localbi.field_msgId > 0L) {
              continue;
            }
            y.i("MicroMsg.SubCoreRemittance", "has delete msg");
            b.bvS();
            b.bvT().a(parama, new String[0]);
            return;
            y.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(localbi.field_msgId) });
            localbi.setContent(str1);
            ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(localbi.field_msgId, localbi);
            parama = b.bvU().LM((String)localObject2);
            if (parama == null) {
              continue;
            }
            parama.field_receiveStatus = i;
            b.bvU().a(parama);
            return;
          }
          if (parama == null)
          {
            y.i("MicroMsg.SubCoreRemittance", "empty record");
            return;
          }
        } while (localbi.field_talker.equals(q.Gj()));
        parama = new com.tencent.mm.plugin.remittance.b.c();
        parama.field_locaMsgId = localbi.field_msgId;
        parama.field_transferId = ((String)localObject2);
        parama.field_receiveStatus = i;
        parama.field_isSend = false;
        b.bvU().a(parama);
        return;
      } while (!"33".equals(localbi));
      int i = bk.getInt((String)parama.get(".sysmsg.paymsg.opentransferbankcard"), 0);
      parama = com.tencent.mm.kernel.g.DP().Dz();
      parama.c(ac.a.uyz, Integer.valueOf(i));
      j = ((Integer)parama.get(ac.a.uyA, Integer.valueOf(0))).intValue();
      y.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    } while (j != 0);
    com.tencent.mm.y.c.BS().b(ac.a.uyu, true);
    parama.c(ac.a.uyA, Integer.valueOf(1));
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyv, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.b.4
 * JD-Core Version:    0.7.0.1
 */