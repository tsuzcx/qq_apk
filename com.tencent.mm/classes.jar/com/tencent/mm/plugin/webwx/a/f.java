package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.i;
import com.tencent.mm.al.af;
import com.tencent.mm.av.d.a;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vb.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.dda;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  implements com.tencent.mm.ak.f, d.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ak.n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(30182);
    ac.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(30182);
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(30181);
    parama = parama.fXi;
    Object localObject1;
    Object localObject2;
    int i;
    if ((parama != null) && (parama.tit == 51))
    {
      ac.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(parama.tit), Integer.valueOf(51) });
      localObject1 = z.a(parama.DPU);
      if (!bs.isNullOrNil((String)localObject1))
      {
        localObject2 = z.a(parama.DPV).trim();
        parama = bv.L((String)localObject2, "msg");
        if (parama != null)
        {
          i = bs.getInt((String)parama.get(".msg.op.$id"), 0);
          ac.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(i) });
          if ((i != 1) && (i != 2) && (i != 5)) {
            break label354;
          }
          ac.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          com.tencent.mm.model.az.ayM();
          c.awD().alh((String)localObject1);
          com.tencent.mm.plugin.webwx.a.iyx.cancelNotification((String)localObject1);
          if (!w.wL((String)localObject1)) {
            break label221;
          }
          com.tencent.mm.model.az.ayM();
          c.agA().set(143618, Integer.valueOf(0));
          com.tencent.mm.bj.d.aJe().fbg();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30181);
      return null;
      label221:
      ac.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
      com.tencent.mm.model.az.ayM();
      c.awG().aNK((String)localObject1);
      label2440:
      if (w.sQ((String)localObject1))
      {
        com.tencent.mm.model.az.ayM();
        parama = c.awG().aNI((String)localObject1);
        label1552:
        label1732:
        if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
        {
          ac.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject1, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
          com.tencent.mm.plugin.webwx.a.iyy.eE((String)localObject1);
          parama.jR(0);
          com.tencent.mm.model.az.ayM();
          c.awG().a(parama, (String)localObject1);
          continue;
          label354:
          if (i == 13)
          {
            ac.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
            com.tencent.mm.model.az.ayM();
            c.awG().aNM((String)localObject1);
          }
          else
          {
            long l;
            Object localObject3;
            Object localObject4;
            if (i == 3)
            {
              ac.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", new Object[] { Integer.valueOf(i) });
              l = System.currentTimeMillis();
              com.tencent.mm.model.az.ayM();
              localObject2 = c.awG().faM();
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
              ac.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", new Object[] { Integer.valueOf(((List)localObject2).size()), Long.valueOf(System.currentTimeMillis() - l) });
              localObject2 = x.xD(w.hmN);
              ac.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus unreadUsernames[%s] take[%d]ms", new Object[] { ((Map)localObject2).keySet(), Long.valueOf(System.currentTimeMillis() - l) });
              i = ((Map)localObject2).size();
              parama = null;
              if (i > 0)
              {
                parama = new LinkedList();
                localObject3 = ((Map)localObject2).keySet().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject3).next();
                  com.tencent.mm.storage.ap localap = (com.tencent.mm.storage.ap)((Map)localObject2).get(localObject4);
                  if (localap != null)
                  {
                    dda localdda = new dda();
                    localdda.ncR = ((String)localObject4);
                    localdda.FMJ = ((int)localap.field_conversationTime);
                    parama.add(localdda);
                  }
                }
              }
              parama = new aa(((StringBuilder)localObject1).toString(), 4, i, parama);
              com.tencent.mm.model.az.agi().a(parama, 0);
            }
            else if (i == 6)
            {
              ac.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
            }
            else if (i == 7)
            {
              ac.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              com.tencent.mm.model.az.ayM();
              ac.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.awy()), Integer.valueOf(com.tencent.mm.modelsimple.n.aHv()) });
              localObject1 = bs.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bs.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("WeixinStatus".equals(localObject1))
              {
                com.tencent.mm.model.az.ayM();
                if ((c.awy() == com.tencent.mm.modelsimple.n.aHv()) && (com.tencent.mm.modelsimple.n.hSs != null) && (com.tencent.mm.modelsimple.n.hSs.trim().length() > 0))
                {
                  localObject1 = new Intent(ai.getContext(), WebWXLogoutUI.class);
                  ((Intent)localObject1).setFlags(603979776);
                  ((Intent)localObject1).addFlags(268435456);
                  ((Intent)localObject1).putExtra("intent.key.online_version", com.tencent.mm.modelsimple.n.aHv());
                  parama = ai.getContext();
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
              else if ("MomentsUnreadMsgStatus".equals(localObject1))
              {
                localObject2 = new vb();
                ((vb)localObject2).dxY.dgm = 7;
                ((vb)localObject2).dxY.dxZ = ((String)localObject1);
                ((vb)localObject2).dxY.dya = bs.getInt(parama, 0);
                ac.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((vb)localObject2).dxY.dgm), ((vb)localObject2).dxY.dxZ, Long.valueOf(((vb)localObject2).dxY.dya) });
                com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
              }
              else if ("EnterpriseChatStatus".equals(localObject1))
              {
                af.aDj();
                i.h(i, (String)localObject1, parama);
              }
            }
            else if (i == 8)
            {
              ac.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              localObject1 = bs.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bs.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("EnterpriseChatStatus".equals(localObject1))
              {
                af.aDj();
                i.h(i, (String)localObject1, parama);
              }
              else
              {
                parama = new vb();
                parama.dxY.dgm = 8;
                com.tencent.mm.sdk.b.a.GpY.l(parama);
              }
            }
            else if (i == 9)
            {
              ac.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(i), localObject2 });
              localObject1 = bs.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = bs.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("MomentsTimelineStatus".equals(localObject1))
              {
                parama = parama.split(",");
                if (parama.length == 2)
                {
                  localObject2 = new vb();
                  ((vb)localObject2).dxY.dgm = 9;
                  ((vb)localObject2).dxY.dxZ = ((String)localObject1);
                  ((vb)localObject2).dxY.dya = bs.getInt(parama[1], 0);
                  ((vb)localObject2).dxY.dyb = parama[0];
                  com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
                }
              }
              else if ("EnterpriseChatStatus".equals(localObject1))
              {
                af.aDj();
                i.h(i, (String)localObject1, parama);
              }
            }
            else if (i == 11)
            {
              localObject1 = bs.nullAsNil((String)parama.get(".msg.op.name")).trim();
              localObject2 = bs.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("DownloadFile".equals(localObject1))
              {
                localObject1 = bv.L((String)localObject2, "downloadList");
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
                      if (bs.isNullOrNil(parama)) {
                        break;
                      }
                      l = bs.getLong((String)((Map)localObject1).get(localObject2), -1L);
                      if (l == -1L) {
                        break;
                      }
                      com.tencent.mm.model.az.ayM();
                      parama = c.awD().aF(parama, l);
                      if (parama.field_msgSvrId != 0L) {
                        break label1732;
                      }
                      ac.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[] { Long.valueOf(l) });
                      break label1552;
                    }
                    g.eHq().eHs().zF(parama.field_msgId);
                  }
                }
              }
              else if ("HandOff".equals(localObject1))
              {
                i = bs.getInt((String)parama.get(".msg.op.arg.handofflist.$opcode"), 0);
                if (i == 6) {
                  ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).cSD();
                } else if (i == 5) {
                  try
                  {
                    localObject1 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$from")).trim();
                    l = bs.getLong(((String)parama.get(".msg.op.arg.handofflist.handoff.id")).trim(), 0L);
                    localObject3 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$id")).trim();
                    com.tencent.mm.model.az.ayM();
                    parama = c.awD().aF((String)localObject1, l);
                    localObject1 = com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(parama.field_msgId);
                    parama = (f.a)localObject1;
                    if (localObject1 == null)
                    {
                      localObject4 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).aip((String)localObject3);
                      parama = (f.a)localObject1;
                      if ((localObject4 instanceof HandOffFile)) {
                        parama = al.a((HandOffFile)localObject4);
                      }
                    }
                    if (parama != null)
                    {
                      if (!((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a((String)localObject3, parama)) {
                        continue;
                      }
                      com.tencent.mm.model.az.agi().a(new al((String)localObject3, parama), 0);
                    }
                  }
                  catch (NullPointerException parama)
                  {
                    ac.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                    continue;
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf((String)localObject3, (String)localObject2);
                  }
                  catch (AssertionError parama)
                  {
                    ac.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                  catch (Exception parama)
                  {
                    ac.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                } else if (i == 9) {
                  try
                  {
                    parama = ((String)parama.get(".msg.op.arg.handofflist.handoff.md5")).trim();
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).aiq(parama);
                  }
                  catch (NullPointerException parama)
                  {
                    ac.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                  catch (Exception parama)
                  {
                    ac.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
                  }
                }
              }
              else
              {
                ac.d("MicroMsg.StatusNotifyMsgExtension", "[SendCommand]unknown function: " + (String)localObject1 + " , ignore");
              }
            }
            else if (i == 12)
            {
              ac.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(localObject2)), new Object[] { Integer.valueOf(i) });
              try
              {
                if (parama.get(".msg.op.arg") == null) {
                  break label2440;
                }
                localObject1 = new JSONObject((String)parama.get(".msg.op.arg")).get("deviceName").toString();
                if (!com.tencent.mm.modelsimple.n.aHu()) {
                  continue;
                }
                parama = new Intent(ai.getContext(), WebWXPopupUnlockUI.class);
                parama.setFlags(872415232);
                parama.putExtra("deviceName", (String)localObject1);
                localObject1 = ai.getContext();
                parama = new com.tencent.mm.hellhoundlib.b.a().ba(parama);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, parama.aeD(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)parama.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              catch (JSONException parama)
              {
                ac.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + parama.getMessage());
              }
              continue;
              ac.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
            }
            else
            {
              ac.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[] { Integer.valueOf(i) });
            }
          }
        }
      }
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.f
 * JD-Core Version:    0.7.0.1
 */