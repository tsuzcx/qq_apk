package com.tencent.mm.plugin.webwx.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.a.b;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.zy;
import com.tencent.mm.autogen.a.zy.a;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.b.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fht;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.by;
import java.util.ArrayList;
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
  implements com.tencent.mm.am.g, f.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, p paramp)
  {
    AppMethodBeat.i(30182);
    Log.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(30182);
  }
  
  public final g.b b(g.a parama)
  {
    int i = 0;
    AppMethodBeat.i(30181);
    Object localObject3 = parama.mpN;
    Object localObject2;
    Object localObject1;
    int j;
    if ((localObject3 != null) && (((dl)localObject3).IIs == 51))
    {
      Log.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[] { Integer.valueOf(((dl)localObject3).IIs), Integer.valueOf(51) });
      localObject2 = w.a(((dl)localObject3).YFF);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = w.a(((dl)localObject3).YFG).trim();
        parama = XmlParser.parseXml((String)localObject1, "msg", null);
        if (parama != null)
        {
          j = Util.getInt((String)parama.get(".msg.op.$id"), 0);
          Log.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[] { Integer.valueOf(j) });
          if ((j != 1) && (j != 2) && (j != 5)) {
            break label396;
          }
          Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject2)));
          bh.bCz();
          c.bzD().aLD((String)localObject2);
          com.tencent.mm.plugin.webwx.a.pFn.iH((String)localObject2);
          if (!au.bvT((String)localObject2)) {
            break label230;
          }
          bh.bCz();
          c.ban().B(143618, Integer.valueOf(0));
          com.tencent.mm.modelverify.d.bNI().jbd();
        }
      }
    }
    label396:
    for (;;)
    {
      AppMethodBeat.o(30181);
      return null;
      label230:
      if (au.bvU((String)localObject2))
      {
        Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark convbox readed.");
        bh.bCz();
        c.bzG().bxO("conversationboxservice");
      }
      else
      {
        Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
        bh.bCz();
        c.bzG().bxO((String)localObject2);
        if (au.bwE((String)localObject2))
        {
          bh.bCz();
          parama = c.bzG().bxM((String)localObject2);
          if ((parama != null) && (parama.field_unReadCount > 0) && (parama.field_UnDeliverCount > 0))
          {
            Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[] { localObject2, Integer.valueOf(parama.field_UnDeliverCount), Integer.valueOf(parama.field_unReadCount) });
            com.tencent.mm.plugin.webwx.a.pFo.iC((String)localObject2);
            parama.pG(0);
            bh.bCz();
            c.bzG().c(parama, (String)localObject2);
            continue;
            if (j != 13) {
              break;
            }
            Log.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(localObject2)));
            bh.bCz();
            c.bzG().bxQ((String)localObject2);
          }
        }
      }
    }
    long l;
    Object localObject4;
    if (j == 3)
    {
      Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", new Object[] { Integer.valueOf(j) });
      l = System.currentTimeMillis();
      parama = new ArrayList();
      parama.add("message_fold");
      parama.add("conversationboxservice");
      bh.bCz();
      localObject2 = c.bzG().nd(parama);
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
      if (localObject2 == null) {}
      for (i = -1;; i = ((List)localObject2).size())
      {
        Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        localObject2 = com.tencent.mm.model.ac.bBZ();
        Log.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus unreadUsernames[%s] take[%d]ms", new Object[] { ((Map)localObject2).keySet(), Long.valueOf(System.currentTimeMillis() - l) });
        i = ((Map)localObject2).size();
        if (i <= 0) {
          break label2810;
        }
        parama = new LinkedList();
        localObject3 = ((Map)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          bb localbb = (bb)((Map)localObject2).get(localObject4);
          if (localbb != null)
          {
            fht localfht = new fht();
            localfht.UserName = ((String)localObject4);
            localfht.abIC = ((int)localbb.field_conversationTime);
            parama.add(localfht);
          }
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
            parama = new com.tencent.mm.modelsimple.ac(((StringBuilder)localObject1).toString(), 4, i, parama);
            bh.aZW().a(parama, 0);
            break;
            if (j == 6)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject1 });
              break;
            }
            if (j == 7)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject1 });
              bh.bCz();
              Log.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", new Object[] { Integer.valueOf(c.bzx()), Integer.valueOf(com.tencent.mm.plugin.messenger.b.a.gaP()) });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("WeixinStatus".equals(localObject1))
              {
                bh.bCz();
                if ((c.bzx() != com.tencent.mm.plugin.messenger.b.a.gaP()) || (com.tencent.mm.plugin.messenger.b.a.gaK() == null)) {
                  break;
                }
                parama = com.tencent.mm.plugin.messenger.b.a.gaK().KPZ;
                if ((parama == null) || (parama.trim().length() <= 0)) {
                  break;
                }
                localObject1 = new Intent(MMApplicationContext.getContext(), WebWXLogoutUI.class);
                ((Intent)localObject1).setFlags(603979776);
                ((Intent)localObject1).addFlags(268435456);
                ((Intent)localObject1).putExtra("intent.key.online_version", com.tencent.mm.plugin.messenger.b.a.gaP());
                parama = MMApplicationContext.getContext();
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                com.tencent.mm.hellhoundlib.a.a.b(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if ("MomentsUnreadMsgStatus".equals(localObject1))
              {
                localObject2 = new zy();
                ((zy)localObject2).idz.hHC = 7;
                ((zy)localObject2).idz.idA = ((String)localObject1);
                ((zy)localObject2).idz.idB = Util.getInt(parama, 0);
                Log.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[] { Integer.valueOf(((zy)localObject2).idz.hHC), ((zy)localObject2).idz.idA, Long.valueOf(((zy)localObject2).idz.idB) });
                ((zy)localObject2).publish();
                break;
              }
              if (!"EnterpriseChatStatus".equals(localObject1)) {
                break;
              }
              af.bHu();
              com.tencent.mm.an.a.i.k(j, (String)localObject1, parama);
              break;
            }
            if (j == 8)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject1 });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("EnterpriseChatStatus".equals(localObject1))
              {
                af.bHu();
                com.tencent.mm.an.a.i.k(j, (String)localObject1, parama);
                break;
              }
              parama = new zy();
              parama.idz.hHC = 8;
              parama.publish();
              break;
            }
            if (j == 9)
            {
              Log.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[] { Integer.valueOf(j), localObject1 });
              localObject1 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
              parama = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
              if ("MomentsTimelineStatus".equals(localObject1))
              {
                parama = parama.split(",");
                if (parama.length != 2) {
                  break;
                }
                localObject2 = new zy();
                ((zy)localObject2).idz.hHC = 9;
                ((zy)localObject2).idz.idA = ((String)localObject1);
                ((zy)localObject2).idz.idB = Util.getInt(parama[1], 0);
                ((zy)localObject2).idz.idC = parama[0];
                ((zy)localObject2).publish();
                break;
              }
              if ("EnterpriseChatStatus".equals(localObject1))
              {
                af.bHu();
                com.tencent.mm.an.a.i.k(j, (String)localObject1, parama);
                break;
              }
              if ("clearAllMsg".equals(localObject1))
              {
                Log.i("MicroMsg.StatusNotifyMsgExtension", "delete all msg");
                break;
              }
              if (!"deleteMessages".equals(localObject1)) {
                break;
              }
              Log.i("MicroMsg.StatusNotifyMsgExtension", "delete msgs");
              break;
            }
            if (j != 11) {
              break label2375;
            }
            localObject3 = Util.nullAsNil((String)parama.get(".msg.op.name")).trim();
            localObject2 = Util.nullAsNil((String)parama.get(".msg.op.arg")).trim();
            Log.i("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, op:SENDCOMMAND, funcName:".concat(String.valueOf(localObject3)));
            if ("DownloadFile".equals(localObject3))
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
                    bh.bCz();
                    parama = c.bzD().aU(parama, l);
                    if (parama.field_msgSvrId != 0L) {
                      break label1903;
                    }
                    Log.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[] { Long.valueOf(l) });
                    continue;
                    break;
                  }
                }
                finally
                {
                  Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] DownloadFile fail: " + parama.getLocalizedMessage());
                }
                parama = Integer.valueOf(i);
                continue;
                label1903:
                g.iDu().iDw().xR(parama.field_msgId);
              }
            }
            if (!"HandOff".equals(localObject3)) {
              break label2343;
            }
            switch (Util.getInt((String)parama.get(".msg.op.arg.handofflist.$opcode"), 0))
            {
            case 7: 
            case 8: 
            default: 
              parama = Pattern.compile("<arg>([\\s\\S]+)</arg>").matcher((CharSequence)localObject1);
              if ((!parama.find()) || (parama.groupCount() <= 0)) {
                break;
              }
              parama = parama.group(1);
              ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).processRequest(parama);
              break;
            case 6: 
              Log.i("MicroMsg.StatusNotifyMsgExtension", "receive handoff GET_ALL_LIST request, call alllist");
              ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJK();
              break;
            case 5: 
              try
              {
                localObject1 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$from")).trim();
                l = Util.getLong(((String)parama.get(".msg.op.arg.handofflist.handoff.id")).trim(), 0L);
                localObject3 = ((String)parama.get(".msg.op.arg.handofflist.handoff.$id")).trim();
                bh.bCz();
                parama = c.bzD().aU((String)localObject1, l);
                localObject1 = as.cWJ().yi(parama.field_msgId);
                parama = (g.a)localObject1;
                if (localObject1 == null)
                {
                  localObject4 = ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).aId((String)localObject3);
                  parama = (g.a)localObject1;
                  if ((localObject4 instanceof HandOffFile)) {
                    parama = ao.a((HandOffFile)localObject4);
                  }
                }
                if (parama == null) {
                  break label2259;
                }
                if (!((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).a((String)localObject3, parama)) {
                  break;
                }
                bh.aZW().a(new ao((String)localObject3, parama), 0);
                break;
              }
              finally
              {
                Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
              }
            }
          }
          break;
          label2259:
          ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv((String)localObject3, (String)localObject2);
          break;
          try
          {
            parama = ((String)parama.get(".msg.op.arg.handofflist.handoff.md5")).trim();
            ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).aIf(parama);
          }
          catch (Exception parama)
          {
            Log.e("MicroMsg.StatusNotifyMsgExtension", "[timyiluo] handoff received EXPIRED command, arg is invalid: " + parama.getLocalizedMessage());
          }
        }
        break;
        label2343:
        Log.d("MicroMsg.StatusNotifyMsgExtension", "[SendCommand]unknown function: " + (String)localObject3 + " , ignore");
        break;
        label2375:
        if (j != 12) {
          break label2611;
        }
        Log.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(localObject1)), new Object[] { Integer.valueOf(j) });
        try
        {
          if (parama.get(".msg.op.arg") == null) {
            break label2600;
          }
          localObject1 = new JSONObject((String)parama.get(".msg.op.arg")).get("deviceName").toString();
          if (!com.tencent.mm.plugin.messenger.b.a.gaO()) {
            break;
          }
          parama = new Intent(MMApplicationContext.getContext(), WebWXPopupUnlockUI.class);
          parama.setFlags(872415232);
          parama.putExtra("deviceName", (String)localObject1);
          localObject1 = MMApplicationContext.getContext();
          parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, parama.aYi(), "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)parama.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/webwx/model/StatusNotifyMsgExtension", "handleStatusNotifyMsg", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        catch (JSONException parama)
        {
          Log.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + parama.getMessage());
        }
      }
      break;
      label2600:
      Log.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
      break;
      label2611:
      if (j == 14)
      {
        if (z.bBa() == 1)
        {
          Log.i("MicroMsg.StatusNotifyMsgExtension", "login as main device %s", new Object[] { Integer.valueOf(j) });
          break;
        }
        parama = ((dl)localObject3).YFF.toString();
        if ((au.bwg(parama)) || (au.bvW(parama)))
        {
          bh.bCz();
          c.bzG().bxL(parama);
        }
        for (;;)
        {
          Log.i("MicroMsg.StatusNotifyMsgExtension", "hide session %s", new Object[] { parama });
          break;
          if ((com.tencent.mm.an.g.MB(parama)) || (com.tencent.mm.an.g.Dn(parama)))
          {
            af.bHi().MV(parama);
            ((n)h.ax(n.class)).bzG().bxK(parama);
          }
          else
          {
            com.tencent.mm.model.ac.Jk(parama);
          }
        }
      }
      if (j == 15)
      {
        Log.i("MicroMsg.StatusNotifyMsgExtension", "delete session");
        break;
      }
      if (j == 16)
      {
        Log.i("MicroMsg.StatusNotifyMsgExtension", "clear session");
        break;
      }
      Log.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[] { Integer.valueOf(j) });
      break;
      label2810:
      parama = null;
    }
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.model.f
 * JD-Core Version:    0.7.0.1
 */