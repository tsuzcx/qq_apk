package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.a.vy.a;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.br;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  implements e, com.tencent.mm.av.e.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(30182);
    ae.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(30182);
  }
  
  public final e.b b(com.tencent.mm.ak.e.a parama)
  {
    AppMethodBeat.i(30181);
    parama = parama.gte;
    Object localObject1;
    Object localObject2;
    int i;
    if ((parama != null) && (parama.urJ == 51))
    {
      ae.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(parama.urJ), Integer.valueOf(51) });
      localObject1 = z.a(parama.FNH);
      if (!bu.isNullOrNil((String)localObject1))
      {
        localObject2 = z.a(parama.FNI).trim();
        parama = bx.M((String)localObject2, "msg");
        if (parama != null)
        {
          i = bu.getInt((String)parama.get(".msg.op.$id"), 0);
          ae.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(i) });
          if ((i != 1) && (i != 2) && (i != 5)) {
            break label354;
          }
          ae.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          bc.aCg();
          c.azI().aqZ((String)localObject1);
          com.tencent.mm.plugin.webwx.a.iUz.cancelNotification((String)localObject1);
          if (!x.As((String)localObject1)) {
            break label221;
          }
          bc.aCg();
          c.ajA().set(143618, Integer.valueOf(0));
          com.tencent.mm.bj.d.aMM().fvj();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30181);
      return null;
      label221:
      ae.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
      bc.aCg();
      c.azL().aVc((String)localObject1);
      label2440:
      if (x.wb((String)localObject1))
      {
        bc.aCg();
        parama = c.azL().aVa((String)localObject1);
        label1552:
        label1732:
        if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
        {
          ae.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject1, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
          com.tencent.mm.plugin.webwx.a.iUA.fF((String)localObject1);
          parama.kr(0);
          bc.aCg();
          c.azL().a(parama, (String)localObject1);
          continue;
          label354:
          if (i == 13)
          {
            ae.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
            bc.aCg();
            c.azL().aVe((String)localObject1);
          }
          else
          {
            long l;
            Object localObject3;
            Object localObject4;
            if (i == 3)
            {
              ae.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", new Object[] { Integer.valueOf(i) });
              l = System.currentTimeMillis();
              bc.aCg();
              localObject2 = c.azL().fuP();
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
              ae.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", new Object[] { Integer.valueOf(((List)localObject2).size()), Long.valueOf(System.currentTimeMillis() - l) });
              localObject2 = y.Bl(x.hHV);
              ae.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus unreadUsernames[%s] take[%d]ms", new Object[] { ((Map)localObject2).keySet(), Long.valueOf(System.currentTimeMillis() - l) });
              i = ((Map)localObject2).size();
              parama = null;
              if (i > 0)
              {
                parama = new LinkedList();
                localObject3 = ((Map)localObject2).keySet().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject3).next();
                  au localau = (au)((Map)localObject2).get(localObject4);
                  if (localau != null)
                  {
                    dji localdji = new dji();
                    localdji.nIJ = ((String)localObject4);
                    localdji.HRf = ((int)localau.field_conversationTime);
                    parama.add(localdji);
                  }
                }
              }
              parama = new ab(((StringBuilder)localObject1).toString(), 4, i, parama);
              bc.ajj().a(parama, 0);
            }
            else if (i == 6)
            {
              ae.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            }
            else if (i == 7)
            {
              ae.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              bc.aCg();
              ae.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.azC()), Integer.valueOf(o.aLd()) });
              localObject1 = bu.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bu.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("WeixinStatus".equals(localObject1))
              {
                bc.aCg();
                if ((c.azC() == o.aLd()) && (o.ioC != null) && (o.ioC.trim().length() > 0))
                {
                  localObject1 = new Intent(com.tencent.mm.sdk.platformtools.ak.getContext(), WebWXLogoutUI.class);
                  ((Intent)localObject1).setFlags(603979776);
                  ((Intent)localObject1).addFlags(268435456);
                  ((Intent)localObject1).putExtra("intent.key.online_version", o.aLd());
                  parama = com.tencent.mm.sdk.platformtools.ak.getContext();
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
              else if ("MomentsUnreadMsgStatus".equals(localObject1))
              {
                localObject2 = new vy();
                ((vy)localObject2).dLA.dsO = 7;
                ((vy)localObject2).dLA.dLB = ((String)localObject1);
                ((vy)localObject2).dLA.dLC = bu.getInt(parama, 0);
                ae.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((vy)localObject2).dLA.dsO), ((vy)localObject2).dLA.dLB, Long.valueOf(((vy)localObject2).dLA.dLC) });
                com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
              }
              else if ("EnterpriseChatStatus".equals(localObject1))
              {
                ag.aGC();
                com.tencent.mm.al.a.i.h(i, (String)localObject1, parama);
              }
            }
            else if (i == 8)
            {
              ae.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              localObject1 = bu.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bu.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("EnterpriseChatStatus".equals(localObject1))
              {
                ag.aGC();
                com.tencent.mm.al.a.i.h(i, (String)localObject1, parama);
              }
              else
              {
                parama = new vy();
                parama.dLA.dsO = 8;
                com.tencent.mm.sdk.b.a.IvT.l(parama);
              }
            }
            else if (i == 9)
            {
              ae.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              localObject1 = bu.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bu.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("MomentsTimelineStatus".equals(localObject1))
              {
                parama = parama.split(",");
                if (parama.length == 2)
                {
                  localObject2 = new vy();
                  ((vy)localObject2).dLA.dsO = 9;
                  ((vy)localObject2).dLA.dLB = ((String)localObject1);
                  ((vy)localObject2).dLA.dLC = bu.getInt(parama[1], 0);
                  ((vy)localObject2).dLA.dLD = parama[0];
                  com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
                }
              }
              else if ("EnterpriseChatStatus".equals(localObject1))
              {
                ag.aGC();
                com.tencent.mm.al.a.i.h(i, (String)localObject1, parama);
              }
            }
            else if (i == 11)
            {
              localObject1 = bu.nullAsNil((String)parama.get(".msg.op.name")).trim();
              localObject2 = bu.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("DownloadFile".equals(localObject1))
              {
                localObject1 = bx.M((String)localObject2, "downloadList");
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
                      if (bu.isNullOrNil(parama)) {
                        break;
                      }
                      l = bu.getLong((String)((Map)localObject1).get(localObject2), -1L);
                      if (l == -1L) {
                        break;
                      }
                      bc.aCg();
                      parama = c.azI().aJ(parama, l);
                      if (parama.field_msgSvrId != 0L) {
                        break label1732;
                      }
                      ae.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[] { Long.valueOf(l) });
                      break label1552;
                    }
                    g.eZV().eZX().CS(parama.field_msgId);
                  }
                }
              }
              else if ("HandOff".equals(localObject1))
              {
                i = bu.getInt((String)parama.get(".msg.op.arg.handofflist.$opcode"), 0);
                if (i == 6) {
                  ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).deB();
                } else if (i == 5) {
                  try
                  {
                    localObject1 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$from")).trim();
                    l = bu.getLong(((String)parama.get(".msg.op.arg.handofflist.handoff.id")).trim(), 0L);
                    localObject3 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$id")).trim();
                    bc.aCg();
                    parama = c.azI().aJ((String)localObject1, l);
                    localObject1 = ao.bJV().CZ(parama.field_msgId);
                    parama = (com.tencent.mm.ak.e.a)localObject1;
                    if (localObject1 == null)
                    {
                      localObject4 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).aod((String)localObject3);
                      parama = (com.tencent.mm.ak.e.a)localObject1;
                      if ((localObject4 instanceof HandOffFile)) {
                        parama = com.tencent.mm.pluginsdk.model.app.ak.a((HandOffFile)localObject4);
                      }
                    }
                    if (parama != null)
                    {
                      if (!((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a((String)localObject3, parama)) {
                        continue;
                      }
                      bc.ajj().a(new com.tencent.mm.pluginsdk.model.app.ak((String)localObject3, parama), 0);
                    }
                  }
                  catch (NullPointerException parama)
                  {
                    ae.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                    continue;
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy((String)localObject3, (String)localObject2);
                  }
                  catch (AssertionError parama)
                  {
                    ae.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                  catch (Exception parama)
                  {
                    ae.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                } else if (i == 9) {
                  try
                  {
                    parama = ((String)parama.get(".msg.op.arg.handofflist.handoff.md5")).trim();
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).aoe(parama);
                  }
                  catch (NullPointerException parama)
                  {
                    ae.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                  catch (Exception parama)
                  {
                    ae.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                }
              }
              else
              {
                ae.d("MicroMsg.StatusNotifyMsgExtension", "[SendCommand]unknown function: " + (String)localObject1 + " , ignore");
              }
            }
            else if (i == 12)
            {
              ae.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(localObject2)), new Object[] { Integer.valueOf(i) });
              try
              {
                if (parama.get(".msg.op.arg") == null) {
                  break label2440;
                }
                localObject1 = new JSONObject((String)parama.get(".msg.op.arg")).get("deviceName").toString();
                if (!o.aLc()) {
                  continue;
                }
                parama = new Intent(com.tencent.mm.sdk.platformtools.ak.getContext(), WebWXPopupUnlockUI.class);
                parama.setFlags(872415232);
                parama.putExtra("deviceName", (String)localObject1);
                localObject1 = com.tencent.mm.sdk.platformtools.ak.getContext();
                parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, parama.ahE(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)parama.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              catch (JSONException parama)
              {
                ae.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + parama.getMessage());
              }
              continue;
              ae.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
            }
            else
            {
              ae.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[] { Integer.valueOf(i) });
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