package com.tencent.mm.plugin.webwx.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.a.yf;
import com.tencent.mm.f.a.yf.a;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.emv;
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
  implements com.tencent.mm.an.h, e.a
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
    parama = parama.jQG;
    Object localObject1;
    Object localObject3;
    int j;
    if ((parama != null) && (parama.COi == 51))
    {
      Log.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(parama.COi), Integer.valueOf(51) });
      localObject1 = z.a(parama.RIE);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject3 = z.a(parama.RIF).trim();
        parama = XmlParser.parseXml((String)localObject3, "msg", null);
        if (parama != null)
        {
          j = Util.getInt((String)parama.get(".msg.op.$id"), 0);
          Log.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(j) });
          if ((j != 1) && (j != 2) && (j != 5)) {
            break label357;
          }
          Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          bh.beI();
          c.bbO().aOE((String)localObject1);
          com.tencent.mm.plugin.webwx.a.mIG.hg((String)localObject1);
          if (!com.tencent.mm.model.ab.Qq((String)localObject1)) {
            break label224;
          }
          bh.beI();
          c.aHp().i(143618, Integer.valueOf(0));
          com.tencent.mm.bl.d.bqc().hzd();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30181);
      return null;
      label224:
      Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
      bh.beI();
      c.bbR().bwz((String)localObject1);
      if (com.tencent.mm.model.ab.Lj((String)localObject1))
      {
        bh.beI();
        parama = c.bbR().bwx((String)localObject1);
        if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
        {
          Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject1, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
          com.tencent.mm.plugin.webwx.a.mIH.hb((String)localObject1);
          parama.pH(0);
          bh.beI();
          c.bbR().a(parama, (String)localObject1);
          continue;
          label357:
          if (j != 13) {
            break;
          }
          Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject1)));
          bh.beI();
          c.bbR().bwB((String)localObject1);
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
      bh.beI();
      localObject2 = c.bbR().hyJ();
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
      localObject2 = ac.uN(1);
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
          emv localemv = new emv();
          localemv.UserName = ((String)localObject4);
          localemv.UpD = ((int)localaz.field_conversationTime);
          parama.add(localemv);
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
            bh.aGY().a(parama, 0);
            break;
            if (j == 6)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject3 });
              break;
            }
            if (j == 7)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject3 });
              bh.beI();
              Log.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.bbI()), Integer.valueOf(o.bou()) });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("WeixinStatus".equals(localObject1))
              {
                bh.beI();
                if ((c.bbI() != o.bou()) || (o.lZF == null) || (o.lZF.trim().length() <= 0)) {
                  break;
                }
                localObject1 = new Intent(MMApplicationContext.getContext(), WebWXLogoutUI.class);
                ((Intent)localObject1).setFlags(603979776);
                ((Intent)localObject1).addFlags(268435456);
                ((Intent)localObject1).putExtra("intent.key.online_version", o.bou());
                parama = MMApplicationContext.getContext();
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                com.tencent.mm.hellhoundlib.a.a.b(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if ("MomentsUnreadMsgStatus".equals(localObject1))
              {
                localObject2 = new yf();
                ((yf)localObject2).fXy.fCN = 7;
                ((yf)localObject2).fXy.fXz = ((String)localObject1);
                ((yf)localObject2).fXy.fXA = Util.getInt(parama, 0);
                Log.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((yf)localObject2).fXy.fCN), ((yf)localObject2).fXy.fXz, Long.valueOf(((yf)localObject2).fXy.fXA) });
                EventCenter.instance.publish((IEvent)localObject2);
                break;
              }
              if (!"EnterpriseChatStatus".equals(localObject1)) {
                break;
              }
              af.bjJ();
              com.tencent.mm.ao.a.i.h(j, (String)localObject1, parama);
              break;
            }
            if (j == 8)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject3 });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("EnterpriseChatStatus".equals(localObject1))
              {
                af.bjJ();
                com.tencent.mm.ao.a.i.h(j, (String)localObject1, parama);
                break;
              }
              parama = new yf();
              parama.fXy.fCN = 8;
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
                localObject2 = new yf();
                ((yf)localObject2).fXy.fCN = 9;
                ((yf)localObject2).fXy.fXz = ((String)localObject1);
                ((yf)localObject2).fXy.fXA = Util.getInt(parama[1], 0);
                ((yf)localObject2).fXy.fXB = parama[0];
                EventCenter.instance.publish((IEvent)localObject2);
                break;
              }
              if (!"EnterpriseChatStatus".equals(localObject1)) {
                break;
              }
              af.bjJ();
              com.tencent.mm.ao.a.i.h(j, (String)localObject1, parama);
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
                    bh.beI();
                    parama = c.bbO().aL(parama, l);
                    if (parama.field_msgSvrId != 0L) {
                      break label1782;
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
                label1782:
                g.hcM().hcO().TH(parama.field_msgId);
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
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).processRequest(parama);
              break;
            case 6: 
              Log.i("MicroMsg.StatusNotifyMsgExtension", "receive handoff GET_ALL_LIST request, call alllist");
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBI();
              break;
            case 5: 
              try
              {
                localObject1 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$from")).trim();
                l = Util.getLong(((String)parama.get(".msg.op.arg.handofflist.handoff.id")).trim(), 0L);
                localObject3 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$id")).trim();
                bh.beI();
                parama = c.bbO().aL((String)localObject1, l);
                localObject1 = com.tencent.mm.pluginsdk.model.app.ao.ctZ().TR(parama.field_msgId);
                parama = (h.a)localObject1;
                if (localObject1 == null)
                {
                  localObject4 = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).aLm((String)localObject3);
                  parama = (h.a)localObject1;
                  if ((localObject4 instanceof HandOffFile)) {
                    parama = ak.a((HandOffFile)localObject4);
                  }
                }
                if (parama == null) {
                  break label2139;
                }
                if (!((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).a((String)localObject3, parama)) {
                  break;
                }
                bh.aGY().a(new ak((String)localObject3, parama), 0);
              }
              catch (Throwable parama)
              {
                Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
              }
            }
          }
          break;
          label2139:
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io((String)localObject3, (String)localObject2);
          break;
          try
          {
            parama = ((String)parama.get(".msg.op.arg.handofflist.handoff.md5")).trim();
            ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).aLo(parama);
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
          if (!o.bot()) {
            break;
          }
          parama = new Intent(MMApplicationContext.getContext(), WebWXPopupUnlockUI.class);
          parama.setFlags(872415232);
          parama.putExtra("deviceName", (String)localObject1);
          localObject1 = MMApplicationContext.getContext();
          parama = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, parama.aFh(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)parama.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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