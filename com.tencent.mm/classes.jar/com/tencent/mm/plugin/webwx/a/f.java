package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.a.i;
import com.tencent.mm.as.d.a;
import com.tencent.mm.bh.d;
import com.tencent.mm.h.a.ri;
import com.tencent.mm.h.a.ri.a;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.be;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  implements e, d.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ah.m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    parama = parama.dBs;
    Object localObject1;
    Object localObject2;
    int i;
    if ((parama != null) && (parama.kSW == 51))
    {
      y.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(parama.kSW), Integer.valueOf(51) });
      localObject1 = aa.a(parama.svG);
      if (!bk.bl((String)localObject1))
      {
        localObject2 = aa.a(parama.svH).trim();
        parama = bn.s((String)localObject2, "msg");
        if (parama != null)
        {
          i = bk.getInt((String)parama.get(".msg.op.$id"), 0);
          y.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(i) });
          if ((i != 1) && (i != 2) && (i != 5)) {
            break label339;
          }
          y.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = " + (String)localObject1);
          au.Hx();
          c.Fy().Hx((String)localObject1);
          com.tencent.mm.plugin.webwx.a.eUR.cancelNotification((String)localObject1);
          if (!s.hp((String)localObject1)) {
            break label216;
          }
          au.Hx();
          c.Dz().o(143618, Integer.valueOf(0));
          d.RY().cuT();
        }
      }
    }
    for (;;)
    {
      return null;
      label216:
      y.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
      au.Hx();
      c.FB().abx((String)localObject1);
      label1560:
      if (s.fn((String)localObject1))
      {
        au.Hx();
        parama = c.FB().abv((String)localObject1);
        label1204:
        if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
        {
          y.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject1, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
          parama.fy(0);
          au.Hx();
          c.FB().a(parama, (String)localObject1);
          continue;
          label339:
          if (i == 3)
          {
            au.Hx();
            localObject1 = c.FB().cuI();
            localObject2 = new StringBuilder();
            i = 0;
            if (i < ((List)localObject1).size())
            {
              if (i > 0) {}
              for (parama = ",";; parama = "")
              {
                ((StringBuilder)localObject2).append(parama);
                ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
                i += 1;
                break;
              }
            }
            parama = new com.tencent.mm.modelsimple.z(((StringBuilder)localObject2).toString(), 4);
            au.Dk().a(parama, 0);
          }
          else if (i == 6)
          {
            y.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
          }
          else if (i == 7)
          {
            y.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            au.Hx();
            y.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.Ft()), Integer.valueOf(l.Qu()) });
            localObject1 = bk.pm((String)parama.get(".msg.op.name")).trim();
            parama = bk.pm((String)parama.get(".msg.op.arg")).trim();
            if ("WeixinStatus".equals(localObject1))
            {
              au.Hx();
              if ((c.Ft() == l.Qu()) && (l.ezy != null) && (l.ezy.trim().length() > 0))
              {
                parama = new Intent(ae.getContext(), WebWXLogoutUI.class);
                parama.setFlags(603979776);
                parama.addFlags(268435456);
                parama.putExtra("intent.key.online_version", l.Qu());
                ae.getContext().startActivity(parama);
              }
            }
            else if ("MomentsUnreadMsgStatus".equals(localObject1))
            {
              localObject2 = new ri();
              ((ri)localObject2).caT.bMC = 7;
              ((ri)localObject2).caT.caU = ((String)localObject1);
              ((ri)localObject2).caT.caV = bk.getInt(parama, 0);
              y.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((ri)localObject2).caT.bMC), ((ri)localObject2).caT.caU, Long.valueOf(((ri)localObject2).caT.caV) });
              com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
            }
            else if ("EnterpriseChatStatus".equals(localObject1))
            {
              com.tencent.mm.ai.z.ML();
              i.e(i, (String)localObject1, parama);
            }
          }
          else if (i == 8)
          {
            y.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            localObject1 = bk.pm((String)parama.get(".msg.op.name")).trim();
            parama = bk.pm((String)parama.get(".msg.op.arg")).trim();
            if ("EnterpriseChatStatus".equals(localObject1))
            {
              com.tencent.mm.ai.z.ML();
              i.e(i, (String)localObject1, parama);
            }
            else
            {
              parama = new ri();
              parama.caT.bMC = 8;
              com.tencent.mm.sdk.b.a.udP.m(parama);
            }
          }
          else if (i == 9)
          {
            y.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            localObject1 = bk.pm((String)parama.get(".msg.op.name")).trim();
            parama = bk.pm((String)parama.get(".msg.op.arg")).trim();
            if ("MomentsTimelineStatus".equals(localObject1))
            {
              parama = parama.split(",");
              if (parama.length == 2)
              {
                localObject2 = new ri();
                ((ri)localObject2).caT.bMC = 9;
                ((ri)localObject2).caT.caU = ((String)localObject1);
                ((ri)localObject2).caT.caV = bk.getInt(parama[1], 0);
                ((ri)localObject2).caT.caW = parama[0];
                com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
              }
            }
            else if ("EnterpriseChatStatus".equals(localObject1))
            {
              com.tencent.mm.ai.z.ML();
              i.e(i, (String)localObject1, parama);
            }
          }
          else if (i == 11)
          {
            localObject1 = bk.pm((String)parama.get(".msg.op.name")).trim();
            parama = bk.pm((String)parama.get(".msg.op.arg")).trim();
            if (!"DownloadFile".equals(localObject1)) {
              y.i("MicroMsg.StatusNotifyMsgExtension", "[MultiTerminalSyncMgr]not DownloadFile, ignore");
            }
            localObject1 = bn.s(parama, "downloadList");
            if (localObject1 != null)
            {
              i = 0;
              for (;;)
              {
                localObject2 = new StringBuilder(".downloadList.downloadItem");
                if (i == 0) {}
                for (parama = "";; parama = Integer.valueOf(i))
                {
                  localObject2 = parama;
                  i += 1;
                  parama = (String)localObject2 + ".username";
                  localObject2 = (String)localObject2 + ".msgsvrid";
                  parama = (String)((Map)localObject1).get(parama);
                  if (bk.bl(parama)) {
                    break;
                  }
                  long l = bk.getLong((String)((Map)localObject1).get(localObject2), -1L);
                  if (l == -1L) {
                    break;
                  }
                  au.Hx();
                  parama = c.Fy().O(parama, l);
                  if (parama.field_msgSvrId != 0L) {
                    break label1383;
                  }
                  y.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[] { Long.valueOf(l) });
                  break label1204;
                }
                label1383:
                g.cgZ().chb().gU(parama.field_msgId);
              }
            }
          }
          else if (i == 12)
          {
            y.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock " + (String)localObject2, new Object[] { Integer.valueOf(i) });
            try
            {
              if (parama.get(".msg.op.arg") == null) {
                break label1560;
              }
              parama = new JSONObject((String)parama.get(".msg.op.arg")).get("deviceName").toString();
              if (!l.Qt()) {
                continue;
              }
              localObject1 = new Intent(ae.getContext(), WebWXPopupUnlockUI.class);
              ((Intent)localObject1).setFlags(872415232);
              ((Intent)localObject1).putExtra("deviceName", parama);
              ae.getContext().startActivity((Intent)localObject1);
            }
            catch (JSONException parama)
            {
              y.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + parama.getMessage());
            }
            continue;
            y.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
          }
          else
          {
            y.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[] { Integer.valueOf(i) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.f
 * JD-Core Version:    0.7.0.1
 */