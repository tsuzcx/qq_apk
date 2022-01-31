package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.i;
import com.tencent.mm.at.d.a;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  implements e, d.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ai.m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(26507);
    ab.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(26507);
  }
  
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(26506);
    parama = parama.eyJ;
    Object localObject1;
    Object localObject2;
    int i;
    if ((parama != null) && (parama.nqW == 51))
    {
      ab.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(parama.nqW), Integer.valueOf(51) });
      localObject1 = com.tencent.mm.platformtools.aa.a(parama.woQ);
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject2 = com.tencent.mm.platformtools.aa.a(parama.woR).trim();
        parama = br.F((String)localObject2, "msg");
        if (parama != null)
        {
          i = bo.getInt((String)parama.get(".msg.op.$id"), 0);
          ab.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(i) });
          if ((i != 1) && (i != 2) && (i != 5)) {
            break label354;
          }
          ab.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          com.tencent.mm.model.aw.aaz();
          c.YC().Tj((String)localObject1);
          com.tencent.mm.plugin.webwx.a.gmO.cancelNotification((String)localObject1);
          if (!t.nY((String)localObject1)) {
            break label221;
          }
          com.tencent.mm.model.aw.aaz();
          c.Ru().set(143618, Integer.valueOf(0));
          d.ali().dxx();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26506);
      return null;
      label221:
      ab.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
      com.tencent.mm.model.aw.aaz();
      c.YF().arJ((String)localObject1);
      if (t.lA((String)localObject1))
      {
        com.tencent.mm.model.aw.aaz();
        parama = c.YF().arH((String)localObject1);
        if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
        {
          ab.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject1, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
          com.tencent.mm.plugin.webwx.a.gmP.dH((String)localObject1);
          parama.hJ(0);
          com.tencent.mm.model.aw.aaz();
          c.YF().a(parama, (String)localObject1);
          continue;
          label354:
          long l;
          if (i == 3)
          {
            ab.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", new Object[] { Integer.valueOf(i) });
            l = System.currentTimeMillis();
            com.tencent.mm.model.aw.aaz();
            localObject2 = c.YF().dxi();
            localObject1 = new StringBuilder();
            i = 0;
            if (i < ((List)localObject2).size())
            {
              if (i > 0) {}
              for (parama = ",";; parama = "")
              {
                ((StringBuilder)localObject1).append(parama);
                ((StringBuilder)localObject1).append((String)((List)localObject2).get(i));
                i += 1;
                break;
              }
            }
            ab.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", new Object[] { Integer.valueOf(((List)localObject2).size()), Long.valueOf(System.currentTimeMillis() - l) });
            Object localObject3 = u.P(t.flc, 0);
            if (localObject3 == null)
            {
              i = -1;
              ab.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus unreadUsernames[%s] take[%d]ms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
              if (localObject3 != null) {
                break label667;
              }
            }
            label667:
            for (i = 0;; i = ((List)localObject3).size())
            {
              parama = null;
              if (i <= 0) {
                break label678;
              }
              parama = new LinkedList();
              localObject2 = ((j)com.tencent.mm.kernel.g.E(j.class)).YF();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                String str = (String)((Iterator)localObject3).next();
                cgm localcgm = new cgm();
                localcgm.jJA = str;
                localcgm.xRn = ((int)((be)localObject2).arH(str).field_conversationTime);
                parama.add(localcgm);
              }
              i = ((List)localObject3).size();
              break;
            }
            label678:
            parama = new com.tencent.mm.modelsimple.aa(((StringBuilder)localObject1).toString(), 4, i, parama);
            com.tencent.mm.model.aw.Rc().a(parama, 0);
          }
          else if (i == 6)
          {
            ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
          }
          else if (i == 7)
          {
            ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            com.tencent.mm.model.aw.aaz();
            ab.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.Yx()), Integer.valueOf(com.tencent.mm.modelsimple.n.ajB()) });
            localObject1 = bo.nullAsNil((String)parama.get(".msg.op.name")).trim();
            parama = bo.nullAsNil((String)parama.get(".msg.op.arg")).trim();
            if ("WeixinStatus".equals(localObject1))
            {
              com.tencent.mm.model.aw.aaz();
              if ((c.Yx() == com.tencent.mm.modelsimple.n.ajB()) && (com.tencent.mm.modelsimple.n.fPn != null) && (com.tencent.mm.modelsimple.n.fPn.trim().length() > 0))
              {
                parama = new Intent(ah.getContext(), WebWXLogoutUI.class);
                parama.setFlags(603979776);
                parama.addFlags(268435456);
                parama.putExtra("intent.key.online_version", com.tencent.mm.modelsimple.n.ajB());
                ah.getContext().startActivity(parama);
              }
            }
            else if ("MomentsUnreadMsgStatus".equals(localObject1))
            {
              localObject2 = new su();
              ((su)localObject2).cJs.ctW = 7;
              ((su)localObject2).cJs.cJt = ((String)localObject1);
              ((su)localObject2).cJs.cJu = bo.getInt(parama, 0);
              ab.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((su)localObject2).cJs.ctW), ((su)localObject2).cJs.cJt, Long.valueOf(((su)localObject2).cJs.cJu) });
              com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
            }
            else if ("EnterpriseChatStatus".equals(localObject1))
            {
              com.tencent.mm.aj.z.afv();
              i.h(i, (String)localObject1, parama);
            }
          }
          else if (i == 8)
          {
            ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            localObject1 = bo.nullAsNil((String)parama.get(".msg.op.name")).trim();
            parama = bo.nullAsNil((String)parama.get(".msg.op.arg")).trim();
            if ("EnterpriseChatStatus".equals(localObject1))
            {
              com.tencent.mm.aj.z.afv();
              i.h(i, (String)localObject1, parama);
            }
            else
            {
              parama = new su();
              parama.cJs.ctW = 8;
              com.tencent.mm.sdk.b.a.ymk.l(parama);
            }
          }
          else if (i == 9)
          {
            ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            localObject1 = bo.nullAsNil((String)parama.get(".msg.op.name")).trim();
            parama = bo.nullAsNil((String)parama.get(".msg.op.arg")).trim();
            if ("MomentsTimelineStatus".equals(localObject1))
            {
              parama = parama.split(",");
              if (parama.length == 2)
              {
                localObject2 = new su();
                ((su)localObject2).cJs.ctW = 9;
                ((su)localObject2).cJs.cJt = ((String)localObject1);
                ((su)localObject2).cJs.cJu = bo.getInt(parama[1], 0);
                ((su)localObject2).cJs.cJv = parama[0];
                com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
              }
            }
            else if ("EnterpriseChatStatus".equals(localObject1))
            {
              com.tencent.mm.aj.z.afv();
              i.h(i, (String)localObject1, parama);
            }
          }
          else if (i == 11)
          {
            localObject1 = bo.nullAsNil((String)parama.get(".msg.op.name")).trim();
            parama = bo.nullAsNil((String)parama.get(".msg.op.arg")).trim();
            if (!"DownloadFile".equals(localObject1)) {
              ab.i("MicroMsg.StatusNotifyMsgExtension", "[MultiTerminalSyncMgr]not DownloadFile, ignore");
            }
            localObject1 = br.F(parama, "downloadList");
            if (localObject1 != null)
            {
              i = 0;
              for (;;)
              {
                label1465:
                localObject2 = new StringBuilder(".downloadList.downloadItem");
                if (i == 0) {}
                for (parama = "";; parama = Integer.valueOf(i))
                {
                  localObject2 = parama;
                  i += 1;
                  parama = (String)localObject2 + ".username";
                  localObject2 = (String)localObject2 + ".msgsvrid";
                  parama = (String)((Map)localObject1).get(parama);
                  if (bo.isNullOrNil(parama)) {
                    break;
                  }
                  l = bo.getLong((String)((Map)localObject1).get(localObject2), -1L);
                  if (l == -1L) {
                    break;
                  }
                  com.tencent.mm.model.aw.aaz();
                  parama = c.YC().ag(parama, l);
                  if (parama.field_msgSvrId != 0L) {
                    break label1645;
                  }
                  ab.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[] { Long.valueOf(l) });
                  break label1465;
                }
                label1645:
                g.dhh().dhj().nr(parama.field_msgId);
              }
            }
          }
          else if (i == 12)
          {
            ab.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(localObject2)), new Object[] { Integer.valueOf(i) });
            try
            {
              if (parama.get(".msg.op.arg") == null) {
                break label1815;
              }
              parama = new JSONObject((String)parama.get(".msg.op.arg")).get("deviceName").toString();
              if (!com.tencent.mm.modelsimple.n.ajA()) {
                continue;
              }
              localObject1 = new Intent(ah.getContext(), WebWXPopupUnlockUI.class);
              ((Intent)localObject1).setFlags(872415232);
              ((Intent)localObject1).putExtra("deviceName", parama);
              ah.getContext().startActivity((Intent)localObject1);
            }
            catch (JSONException parama)
            {
              ab.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + parama.getMessage());
            }
            continue;
            label1815:
            ab.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
          }
          else
          {
            ab.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[] { Integer.valueOf(i) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.f
 * JD-Core Version:    0.7.0.1
 */