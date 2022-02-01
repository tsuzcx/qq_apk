package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.a.vu.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  implements e, com.tencent.mm.aw.e.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.al.n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(30182);
    ad.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(30182);
  }
  
  public final e.b b(com.tencent.mm.al.e.a parama)
  {
    AppMethodBeat.i(30181);
    parama = parama.gqE;
    Object localObject1;
    Object localObject2;
    int i;
    if ((parama != null) && (parama.ugm == 51))
    {
      ad.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(parama.ugm), Integer.valueOf(51) });
      localObject1 = z.a(parama.Fvj);
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject2 = z.a(parama.Fvk).trim();
        parama = bw.M((String)localObject2, "msg");
        if (parama != null)
        {
          i = bt.getInt((String)parama.get(".msg.op.$id"), 0);
          ad.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(i) });
          if ((i != 1) && (i != 2) && (i != 5)) {
            break label354;
          }
          ad.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          com.tencent.mm.model.ba.aBQ();
          c.azs().apU((String)localObject1);
          com.tencent.mm.plugin.webwx.a.iRG.cancelNotification((String)localObject1);
          if (!w.zI((String)localObject1)) {
            break label221;
          }
          com.tencent.mm.model.ba.aBQ();
          c.ajl().set(143618, Integer.valueOf(0));
          com.tencent.mm.bk.d.aMo().frj();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30181);
      return null;
      label221:
      ad.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
      com.tencent.mm.model.ba.aBQ();
      c.azv().aTB((String)localObject1);
      label2440:
      if (w.vF((String)localObject1))
      {
        com.tencent.mm.model.ba.aBQ();
        parama = c.azv().aTz((String)localObject1);
        label1552:
        label1732:
        if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
        {
          ad.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject1, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
          com.tencent.mm.plugin.webwx.a.iRH.fz((String)localObject1);
          parama.kp(0);
          com.tencent.mm.model.ba.aBQ();
          c.azv().a(parama, (String)localObject1);
          continue;
          label354:
          if (i == 13)
          {
            ad.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
            com.tencent.mm.model.ba.aBQ();
            c.azv().aTD((String)localObject1);
          }
          else
          {
            long l;
            Object localObject3;
            Object localObject4;
            if (i == 3)
            {
              ad.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", new Object[] { Integer.valueOf(i) });
              l = System.currentTimeMillis();
              com.tencent.mm.model.ba.aBQ();
              localObject2 = c.azv().fqP();
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
              ad.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", new Object[] { Integer.valueOf(((List)localObject2).size()), Long.valueOf(System.currentTimeMillis() - l) });
              localObject2 = x.AB(w.hFd);
              ad.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus unreadUsernames[%s] take[%d]ms", new Object[] { ((Map)localObject2).keySet(), Long.valueOf(System.currentTimeMillis() - l) });
              i = ((Map)localObject2).size();
              parama = null;
              if (i > 0)
              {
                parama = new LinkedList();
                localObject3 = ((Map)localObject2).keySet().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject3).next();
                  at localat = (at)((Map)localObject2).get(localObject4);
                  if (localat != null)
                  {
                    din localdin = new din();
                    localdin.nDo = ((String)localObject4);
                    localdin.Hxu = ((int)localat.field_conversationTime);
                    parama.add(localdin);
                  }
                }
              }
              parama = new aa(((StringBuilder)localObject1).toString(), 4, i, parama);
              com.tencent.mm.model.ba.aiU().a(parama, 0);
            }
            else if (i == 6)
            {
              ad.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            }
            else if (i == 7)
            {
              ad.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              com.tencent.mm.model.ba.aBQ();
              ad.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.azm()), Integer.valueOf(com.tencent.mm.modelsimple.n.aKG()) });
              localObject1 = bt.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bt.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("WeixinStatus".equals(localObject1))
              {
                com.tencent.mm.model.ba.aBQ();
                if ((c.azm() == com.tencent.mm.modelsimple.n.aKG()) && (com.tencent.mm.modelsimple.n.ilJ != null) && (com.tencent.mm.modelsimple.n.ilJ.trim().length() > 0))
                {
                  localObject1 = new Intent(aj.getContext(), WebWXLogoutUI.class);
                  ((Intent)localObject1).setFlags(603979776);
                  ((Intent)localObject1).addFlags(268435456);
                  ((Intent)localObject1).putExtra("intent.key.online_version", com.tencent.mm.modelsimple.n.aKG());
                  parama = aj.getContext();
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
              else if ("MomentsUnreadMsgStatus".equals(localObject1))
              {
                localObject2 = new vu();
                ((vu)localObject2).dKl.drI = 7;
                ((vu)localObject2).dKl.dKm = ((String)localObject1);
                ((vu)localObject2).dKl.dKn = bt.getInt(parama, 0);
                ad.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((vu)localObject2).dKl.drI), ((vu)localObject2).dKl.dKm, Long.valueOf(((vu)localObject2).dKl.dKn) });
                com.tencent.mm.sdk.b.a.IbL.l((b)localObject2);
              }
              else if ("EnterpriseChatStatus".equals(localObject1))
              {
                ag.aGm();
                com.tencent.mm.am.a.i.h(i, (String)localObject1, parama);
              }
            }
            else if (i == 8)
            {
              ad.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              localObject1 = bt.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bt.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("EnterpriseChatStatus".equals(localObject1))
              {
                ag.aGm();
                com.tencent.mm.am.a.i.h(i, (String)localObject1, parama);
              }
              else
              {
                parama = new vu();
                parama.dKl.drI = 8;
                com.tencent.mm.sdk.b.a.IbL.l(parama);
              }
            }
            else if (i == 9)
            {
              ad.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              localObject1 = bt.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bt.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("MomentsTimelineStatus".equals(localObject1))
              {
                parama = parama.split(",");
                if (parama.length == 2)
                {
                  localObject2 = new vu();
                  ((vu)localObject2).dKl.drI = 9;
                  ((vu)localObject2).dKl.dKm = ((String)localObject1);
                  ((vu)localObject2).dKl.dKn = bt.getInt(parama[1], 0);
                  ((vu)localObject2).dKl.dKo = parama[0];
                  com.tencent.mm.sdk.b.a.IbL.l((b)localObject2);
                }
              }
              else if ("EnterpriseChatStatus".equals(localObject1))
              {
                ag.aGm();
                com.tencent.mm.am.a.i.h(i, (String)localObject1, parama);
              }
            }
            else if (i == 11)
            {
              localObject1 = bt.nullAsNil((String)parama.get(".msg.op.name")).trim();
              localObject2 = bt.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("DownloadFile".equals(localObject1))
              {
                localObject1 = bw.M((String)localObject2, "downloadList");
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
                      if (bt.isNullOrNil(parama)) {
                        break;
                      }
                      l = bt.getLong((String)((Map)localObject1).get(localObject2), -1L);
                      if (l == -1L) {
                        break;
                      }
                      com.tencent.mm.model.ba.aBQ();
                      parama = c.azs().aI(parama, l);
                      if (parama.field_msgSvrId != 0L) {
                        break label1732;
                      }
                      ad.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[] { Long.valueOf(l) });
                      break label1552;
                    }
                    g.eWj().eWl().Cu(parama.field_msgId);
                  }
                }
              }
              else if ("HandOff".equals(localObject1))
              {
                i = bt.getInt((String)parama.get(".msg.op.arg.handofflist.$opcode"), 0);
                if (i == 6) {
                  ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).dbK();
                } else if (i == 5) {
                  try
                  {
                    localObject1 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$from")).trim();
                    l = bt.getLong(((String)parama.get(".msg.op.arg.handofflist.handoff.id")).trim(), 0L);
                    localObject3 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$id")).trim();
                    com.tencent.mm.model.ba.aBQ();
                    parama = c.azs().aI((String)localObject1, l);
                    localObject1 = ao.bIX().CB(parama.field_msgId);
                    parama = (com.tencent.mm.al.e.a)localObject1;
                    if (localObject1 == null)
                    {
                      localObject4 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).anc((String)localObject3);
                      parama = (com.tencent.mm.al.e.a)localObject1;
                      if ((localObject4 instanceof HandOffFile)) {
                        parama = ak.a((HandOffFile)localObject4);
                      }
                    }
                    if (parama != null)
                    {
                      if (!((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a((String)localObject3, parama)) {
                        continue;
                      }
                      com.tencent.mm.model.ba.aiU().a(new ak((String)localObject3, parama), 0);
                    }
                  }
                  catch (NullPointerException parama)
                  {
                    ad.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                    continue;
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr((String)localObject3, (String)localObject2);
                  }
                  catch (AssertionError parama)
                  {
                    ad.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                  catch (Exception parama)
                  {
                    ad.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                } else if (i == 9) {
                  try
                  {
                    parama = ((String)parama.get(".msg.op.arg.handofflist.handoff.md5")).trim();
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).and(parama);
                  }
                  catch (NullPointerException parama)
                  {
                    ad.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                  catch (Exception parama)
                  {
                    ad.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                }
              }
              else
              {
                ad.d("MicroMsg.StatusNotifyMsgExtension", "[SendCommand]unknown function: " + (String)localObject1 + " , ignore");
              }
            }
            else if (i == 12)
            {
              ad.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(localObject2)), new Object[] { Integer.valueOf(i) });
              try
              {
                if (parama.get(".msg.op.arg") == null) {
                  break label2440;
                }
                localObject1 = new JSONObject((String)parama.get(".msg.op.arg")).get("deviceName").toString();
                if (!com.tencent.mm.modelsimple.n.aKF()) {
                  continue;
                }
                parama = new Intent(aj.getContext(), WebWXPopupUnlockUI.class);
                parama.setFlags(872415232);
                parama.putExtra("deviceName", (String)localObject1);
                localObject1 = aj.getContext();
                parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, parama.ahp(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)parama.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              catch (JSONException parama)
              {
                ad.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + parama.getMessage());
              }
              continue;
              ad.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
            }
            else
            {
              ad.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[] { Integer.valueOf(i) });
            }
          }
        }
      }
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.f
 * JD-Core Version:    0.7.0.1
 */