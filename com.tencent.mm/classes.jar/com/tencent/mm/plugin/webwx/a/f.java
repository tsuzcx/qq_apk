package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.a.wy.a;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  implements h, e.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, q paramq) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, q paramq)
  {
    AppMethodBeat.i(30182);
    Log.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(30182);
  }
  
  public final h.b b(h.a parama)
  {
    int i = 0;
    AppMethodBeat.i(30181);
    parama = parama.heO;
    Object localObject1;
    Object localObject3;
    int j;
    if ((parama != null) && (parama.xKb == 51))
    {
      Log.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(parama.xKb), Integer.valueOf(51) });
      localObject1 = z.a(parama.KHm);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject3 = z.a(parama.KHn).trim();
        parama = XmlParser.parseXml((String)localObject3, "msg", null);
        if (parama != null)
        {
          j = Util.getInt((String)parama.get(".msg.op.$id"), 0);
          Log.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(j) });
          if ((j != 1) && (j != 2) && (j != 5)) {
            break label357;
          }
          Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          bg.aVF();
          c.aSQ().aEu((String)localObject1);
          com.tencent.mm.plugin.webwx.a.jRt.cancelNotification((String)localObject1);
          if (!com.tencent.mm.model.ab.IX((String)localObject1)) {
            break label224;
          }
          bg.aVF();
          c.azQ().set(143618, Integer.valueOf(0));
          com.tencent.mm.bj.d.bgN().gCQ();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30181);
      return null;
      label224:
      Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
      bg.aVF();
      c.aST().bka((String)localObject1);
      if (com.tencent.mm.model.ab.Eq((String)localObject1))
      {
        bg.aVF();
        parama = c.aST().bjY((String)localObject1);
        if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
        {
          Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject1, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
          com.tencent.mm.plugin.webwx.a.jRu.gr((String)localObject1);
          parama.nt(0);
          bg.aVF();
          c.aST().a(parama, (String)localObject1);
          continue;
          label357:
          if (j != 13) {
            break;
          }
          Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          bg.aVF();
          c.aST().bkc((String)localObject1);
        }
      }
    }
    long l;
    Object localObject2;
    Object localObject4;
    if (j == 3)
    {
      Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", new Object[] { Integer.valueOf(j) });
      l = System.currentTimeMillis();
      bg.aVF();
      localObject2 = c.aST().gCw();
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
      Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", new Object[] { Integer.valueOf(((List)localObject2).size()), Long.valueOf(System.currentTimeMillis() - l) });
      localObject2 = ac.JQ(com.tencent.mm.model.ab.iCF);
      Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus unreadUsernames[%s] take[%d]ms", new Object[] { ((Map)localObject2).keySet(), Long.valueOf(System.currentTimeMillis() - l) });
      i = ((Map)localObject2).size();
      if (i <= 0) {
        break label2513;
      }
      parama = new LinkedList();
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        az localaz = (az)((Map)localObject2).get(localObject4);
        if (localaz != null)
        {
          ecu localecu = new ecu();
          localecu.UserName = ((String)localObject4);
          localecu.Ndg = ((int)localaz.field_conversationTime);
          parama.add(localecu);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            parama = new com.tencent.mm.modelsimple.ab(((StringBuilder)localObject1).toString(), 4, i, parama);
            bg.azz().a(parama, 0);
            break;
            if (j == 6)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject3 });
              break;
            }
            if (j == 7)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject3 });
              bg.aVF();
              Log.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.aSK()), Integer.valueOf(o.bff()) });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("WeixinStatus".equals(localObject1))
              {
                bg.aVF();
                if ((c.aSK() != o.bff()) || (o.jjJ == null) || (o.jjJ.trim().length() <= 0)) {
                  break;
                }
                localObject1 = new Intent(MMApplicationContext.getContext(), WebWXLogoutUI.class);
                ((Intent)localObject1).setFlags(603979776);
                ((Intent)localObject1).addFlags(268435456);
                ((Intent)localObject1).putExtra("intent.key.online_version", o.bff());
                parama = MMApplicationContext.getContext();
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if ("MomentsUnreadMsgStatus".equals(localObject1))
              {
                localObject2 = new wy();
                ((wy)localObject2).edp.dJY = 7;
                ((wy)localObject2).edp.edq = ((String)localObject1);
                ((wy)localObject2).edp.edr = Util.getInt(parama, 0);
                Log.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((wy)localObject2).edp.dJY), ((wy)localObject2).edp.edq, Long.valueOf(((wy)localObject2).edp.edr) });
                EventCenter.instance.publish((IEvent)localObject2);
                break;
              }
              if (!"EnterpriseChatStatus".equals(localObject1)) {
                break;
              }
              ag.bav();
              com.tencent.mm.al.a.i.h(j, (String)localObject1, parama);
              break;
            }
            if (j == 8)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject3 });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("EnterpriseChatStatus".equals(localObject1))
              {
                ag.bav();
                com.tencent.mm.al.a.i.h(j, (String)localObject1, parama);
                break;
              }
              parama = new wy();
              parama.edp.dJY = 8;
              EventCenter.instance.publish(parama);
              break;
            }
            if (j == 9)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject3 });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("MomentsTimelineStatus".equals(localObject1))
              {
                parama = parama.split(",");
                if (parama.length != 2) {
                  break;
                }
                localObject2 = new wy();
                ((wy)localObject2).edp.dJY = 9;
                ((wy)localObject2).edp.edq = ((String)localObject1);
                ((wy)localObject2).edp.edr = Util.getInt(parama[1], 0);
                ((wy)localObject2).edp.eds = parama[0];
                EventCenter.instance.publish((IEvent)localObject2);
                break;
              }
              if (!"EnterpriseChatStatus".equals(localObject1)) {
                break;
              }
              ag.bav();
              com.tencent.mm.al.a.i.h(j, (String)localObject1, parama);
              break;
            }
            if (j != 11) {
              break label2255;
            }
            localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
            localObject2 = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
            Log.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, op:SENDCOMMAND, funcName:".concat(String.valueOf(localObject1)));
            if ("DownloadFile".equals(localObject1))
            {
              localObject1 = XmlParser.parseXml((String)localObject2, "downloadList", null);
              if (localObject1 == null) {
                break;
              }
              for (;;)
              {
                try
                {
                  localObject2 = new StringBuilder(".downloadList.downloadItem");
                  if (i == 0)
                  {
                    parama = "";
                    localObject2 = parama;
                    i += 1;
                    parama = (String)localObject2 + ".username";
                    localObject2 = (String)localObject2 + ".msgsvrid";
                    parama = (String)((Map)localObject1).get(parama);
                    if (Util.isNullOrNil(parama)) {
                      break;
                    }
                    l = Util.getLong((String)((Map)localObject1).get(localObject2), -1L);
                    if (l == -1L) {
                      break;
                    }
                    bg.aVF();
                    parama = c.aSQ().aJ(parama, l);
                    if (parama.field_msgSvrId != 0L) {
                      break label1784;
                    }
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[] { Long.valueOf(l) });
                    continue;
                  }
                }
                catch (Throwable parama)
                {
                  Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] DownloadFile fail: " + parama.getLocalizedMessage());
                }
                parama = Integer.valueOf(i);
                continue;
                label1784:
                g.gjb().gjd().Mh(parama.field_msgId);
              }
            }
            if (!"HandOff".equals(localObject1)) {
              break label2223;
            }
            switch (Util.getInt((String)parama.get(".msg.op.arg.handofflist.$opcode"), 0))
            {
            case 7: 
            case 8: 
            default: 
              parama = Pattern.compile("<arg>([\\s\\S]+)</arg>").matcher((CharSequence)localObject3);
              if ((!parama.find()) || (parama.groupCount() <= 0)) {
                break;
              }
              parama = parama.group(1);
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).processRequest(parama);
              break;
            case 6: 
              Log.i("MicroMsg.StatusNotifyMsgExtension", "receive handoff GET_ALL_LIST request, call alllist");
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYk();
              break;
            case 5: 
              try
              {
                localObject1 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$from")).trim();
                l = Util.getLong(((String)parama.get(".msg.op.arg.handofflist.handoff.id")).trim(), 0L);
                localObject3 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$id")).trim();
                bg.aVF();
                parama = c.aSQ().aJ((String)localObject1, l);
                localObject1 = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(parama.field_msgId);
                parama = (h.a)localObject1;
                if (localObject1 == null)
                {
                  localObject4 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBy((String)localObject3);
                  parama = (h.a)localObject1;
                  if ((localObject4 instanceof HandOffFile)) {
                    parama = ak.a((HandOffFile)localObject4);
                  }
                }
                if (parama == null) {
                  break label2139;
                }
                if (!((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a((String)localObject3, parama)) {
                  break;
                }
                bg.azz().a(new ak((String)localObject3, parama), 0);
              }
              catch (Throwable parama)
              {
                Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
              }
            }
          }
          break;
          label2139:
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).jdMethod_if((String)localObject3, (String)localObject2);
          break;
          try
          {
            parama = ((String)parama.get(".msg.op.arg.handofflist.handoff.md5")).trim();
            ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBA(parama);
          }
          catch (Exception parama)
          {
            Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
          }
        }
        break;
        label2223:
        Log.d("MicroMsg.StatusNotifyMsgExtension", "[SendCommand]unknown function: " + (String)localObject1 + " , ignore");
        break;
        label2255:
        if (j != 12) {
          break label2491;
        }
        Log.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(localObject3)), new Object[] { Integer.valueOf(j) });
        try
        {
          if (parama.get(".msg.op.arg") == null) {
            break label2480;
          }
          localObject1 = new JSONObject((String)parama.get(".msg.op.arg")).get("deviceName").toString();
          if (!o.bfe()) {
            break;
          }
          parama = new Intent(MMApplicationContext.getContext(), WebWXPopupUnlockUI.class);
          parama.setFlags(872415232);
          parama.putExtra("deviceName", (String)localObject1);
          localObject1 = MMApplicationContext.getContext();
          parama = new com.tencent.mm.hellhoundlib.b.a().bl(parama);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, parama.axQ(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)parama.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        catch (JSONException parama)
        {
          Log.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + parama.getMessage());
        }
      }
      break;
      label2480:
      Log.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
      break;
      label2491:
      Log.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[] { Integer.valueOf(j) });
      break;
      label2513:
      parama = null;
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.f
 * JD-Core Version:    0.7.0.1
 */