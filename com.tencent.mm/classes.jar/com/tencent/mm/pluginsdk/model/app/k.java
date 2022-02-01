package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.k.b.a;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.f.a.aal;
import com.tencent.mm.f.a.aam;
import com.tencent.mm.f.a.abq;
import com.tencent.mm.f.a.ax;
import com.tencent.mm.f.a.ax.a;
import com.tencent.mm.f.a.dj;
import com.tencent.mm.f.a.rp;
import com.tencent.mm.f.a.rr;
import com.tencent.mm.f.a.rr.a;
import com.tencent.mm.f.a.ru;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.live.b.v;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.AppAttachNewDownloadUI;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class k
  implements com.tencent.mm.an.h
{
  private static void T(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(31012);
    az localaz;
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      bh.beI();
      localaz = com.tencent.mm.model.c.bbR().bwx(paramString);
      if (localaz != null)
      {
        if (!paramBoolean) {
          break label85;
        }
        localaz.rn(16777216);
      }
    }
    for (;;)
    {
      bh.beI();
      com.tencent.mm.model.c.bbR().a(localaz, paramString);
      AppMethodBeat.o(31012);
      return;
      label85:
      localaz.ro(16777216);
    }
  }
  
  private h.b a(h.a parama, String paramString, k.b paramb)
  {
    AppMethodBeat.i(31011);
    db localdb = parama.jQG;
    bh.beI();
    Object localObject7 = com.tencent.mm.model.c.bbO();
    bh.beI();
    Object localObject1 = com.tencent.mm.model.c.bbU();
    Object localObject2 = com.tencent.mm.model.z.bcZ();
    String str1 = com.tencent.mm.platformtools.z.a(localdb.RID);
    String str2 = com.tencent.mm.platformtools.z.a(localdb.RIE);
    int j;
    bq.b localb;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = bq.RR(localdb.RII);
      if (localb == null) {
        break label3656;
      }
    }
    label896:
    label961:
    label1987:
    label3656:
    for (Object localObject4 = localb.lup;; localObject4 = null)
    {
      if (com.tencent.mm.model.ab.QR((String)localObject4)) {
        localObject2 = "notifymessage";
      }
      long l1;
      boolean bool4;
      boolean bool3;
      boolean bool2;
      for (;;)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).aL((String)localObject2, localdb.HlH);
        Log.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(((et)localObject1).field_msgId) });
        if ((((et)localObject1).field_msgId != 0L) && (((et)localObject1).field_createTime + 604800000L < bq.z((String)localObject2, localdb.CreateTime)))
        {
          Log.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(((et)localObject1).field_msgId) });
          bq.Gk(((et)localObject1).field_msgId);
          ((ca)localObject1).setMsgId(0L);
        }
        l1 = localdb.HlH;
        bool4 = false;
        bool1 = false;
        if (((et)localObject1).field_msgId != 0L) {
          break label1639;
        }
        bool3 = true;
        bool2 = true;
        if (paramb.type != 6) {
          break label1508;
        }
        localObject5 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.ag(PluginMessengerFoundation.class)).getFileMsgInfoStorage().UZ(localdb.HlH);
        if (localObject5 == null) {
          break label375;
        }
        Log.e("MicroMsg.AppMessageExtension", "doInsertMessage fail, %s has exist, overwriteNewMsgId:%s", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(((com.tencent.mm.storage.a.a)localObject5).field_overwriteNewMsgId) });
        AppMethodBeat.o(31011);
        return null;
        j = 0;
        break;
        if (j != 0) {
          localObject2 = str2;
        } else {
          localObject2 = str1;
        }
      }
      label375:
      Object localObject5 = (com.tencent.mm.aj.a.b)paramb.ar(com.tencent.mm.aj.a.b.class);
      Object localObject8;
      if ((localObject5 != null) && (((com.tencent.mm.aj.a.b)localObject5).lqB != 0L))
      {
        if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Os(((com.tencent.mm.aj.a.b)localObject5).lqB))
        {
          Log.i("MicroMsg.AppMessageExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
          AppMethodBeat.o(31011);
          return null;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).aL((String)localObject2, ((com.tencent.mm.aj.a.b)localObject5).lqB);
        localObject8 = new com.tencent.mm.storage.a.a();
        if (((et)localObject1).field_msgId != 0L)
        {
          if (!((ca)localObject1).erk())
          {
            Log.w("MicroMsg.AppMessageExtension", "ignore, because msg(%s) type:%s", new Object[] { Long.valueOf(((et)localObject1).field_msgId), Integer.valueOf(((ca)localObject1).getType()) });
            AppMethodBeat.o(31011);
            return null;
          }
          ((ca)localObject1).EG(localdb.HlH);
          l1 = ((com.tencent.mm.aj.a.b)localObject5).lqB;
          bool2 = false;
          if (((et)localObject1).fileStatus != 1) {
            break label3650;
          }
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        Object localObject9 = k.b.OQ(((et)localObject1).field_content);
        if ((localObject9 != null) && (!Util.isNullOrNil(((k.b)localObject9).loS)))
        {
          localObject9 = ((k.b)localObject9).loS.split(";");
          if ((localObject9 != null) && (localObject9.length == 2))
          {
            ((com.tencent.mm.storage.a.a)localObject8).field_cgi = localObject9[0];
            ((com.tencent.mm.storage.a.a)localObject8).field_aeskey = localObject9[1];
          }
        }
        ((com.tencent.mm.storage.a.a)localObject8).field_msgSvrId = localdb.HlH;
        ((com.tencent.mm.storage.a.a)localObject8).field_overwriteNewMsgId = ((com.tencent.mm.aj.a.b)localObject5).lqB;
        bool3 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.ag(PluginMessengerFoundation.class)).getFileMsgInfoStorage().a((com.tencent.mm.storage.a.a)localObject8);
        Log.i("MicroMsg.AppMessageExtension", "fileuploadtoken:%s overwrite_newmsgid:%s msgId:%s needCreate:%s needAutoDownloadFile:%s insertFileMsgInfo:%s cgi:%s aeskey:%s", new Object[] { ((com.tencent.mm.aj.a.b)localObject5).lqC, Long.valueOf(((com.tencent.mm.aj.a.b)localObject5).lqB), Long.valueOf(((et)localObject1).field_msgId), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Util.nullAs(((com.tencent.mm.storage.a.a)localObject8).field_cgi, ""), Util.nullAs(((com.tencent.mm.storage.a.a)localObject8).field_aeskey, "") });
        if (bool2)
        {
          localObject1 = new ca();
          ((ca)localObject1).EG(localdb.HlH);
          ((ca)localObject1).setCreateTime(bq.z((String)localObject2, localdb.CreateTime));
        }
        if ((paramb.type == 74) || (paramb.type == 6)) {
          ((ca)localObject1).apT();
        }
        for (int i = 1;; i = 0)
        {
          int k = i;
          for (;;)
          {
            if (paramb.llU != null)
            {
              ((ca)localObject1).Jw(paramb.llU.ilq);
              Log.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((et)localObject1).ilq });
            }
            ((ca)localObject1).setType(m.g(paramb));
            if (((ca)localObject1).hwA())
            {
              localObject5 = paramb.content;
              ((ca)localObject1).setContent((String)localObject5);
              if (((ca)localObject1).hwA()) {
                ((ca)localObject1).Ju(paramb.ilh);
              }
              if ((localdb.RIG != 2) || (((et)localObject1).field_msgId != 0L) || (m.apM(((ca)localObject1).getType()))) {
                break label1987;
              }
              if (paramb.type != 2) {
                break label1696;
              }
              bool2 = true;
              localObject5 = com.tencent.mm.platformtools.z.a(localdb.RIH);
              if (com.tencent.mm.platformtools.ac.mFS)
              {
                Log.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                localObject5 = null;
              }
              if (Util.isNullOrNil((byte[])localObject5)) {
                break label1719;
              }
              if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
                break label1702;
              }
              localObject5 = com.tencent.mm.ay.q.bmh().a((byte[])localObject5, Bitmap.CompressFormat.PNG);
              if (Util.isNullOrNil((String)localObject5)) {
                Log.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { Util.secPrint(((et)localObject1).field_content) });
              }
              if (!Util.isNullOrNil((String)localObject5))
              {
                ((ca)localObject1).Jn((String)localObject5);
                Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject5)));
              }
              label1116:
              if (j == 0) {
                break label2259;
              }
              ((ca)localObject1).pJ(1);
              ((ca)localObject1).Jm((String)localObject2);
              i = localdb.rVU;
              label1141:
              ((ca)localObject1).setStatus(i);
              if (paramb.type == 2001) {
                if (paramb.fwp == 1)
                {
                  if ((TextUtils.isEmpty(paramb.lnK)) || (TextUtils.isEmpty(paramb.lnL)) || (paramb.lnM <= 0)) {
                    break label2297;
                  }
                  Log.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                  localObject2 = new ax();
                  ((ax)localObject2).fwD = new ax.a();
                  ((ax)localObject2).fwD.fwF = paramb.lnL;
                  ((ax)localObject2).fwD.fwE = paramb.lnK;
                  ((ax)localObject2).fwD.fwG = paramb.lnM;
                  EventCenter.instance.publish((IEvent)localObject2);
                }
              }
            }
            for (;;)
            {
              for (;;)
              {
                try
                {
                  if (Util.isNullOrNil(paramb.lnW)) {
                    continue;
                  }
                  localObject2 = paramb.lnW.iterator();
                  if (((Iterator)localObject2).hasNext())
                  {
                    localObject5 = ((String)((Iterator)localObject2).next()).split(",");
                    if ((localObject5 == null) || (localObject5.length <= 0)) {
                      continue;
                    }
                    localObject5 = localObject5[0];
                    if ((Util.isNullOrNil((String)localObject5)) || (!((String)localObject5).equals(com.tencent.mm.model.z.bcZ()))) {
                      continue;
                    }
                    ((ca)localObject1).setFlag(((et)localObject1).field_flag | 0x8);
                    Log.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                    T(true, ((et)localObject1).field_talker);
                  }
                }
                catch (Exception localException1)
                {
                  label1508:
                  String str3;
                  c.a locala;
                  Log.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException1.getMessage() });
                  continue;
                  ((cjg)localObject6).TqH = localException1.llh;
                  ((cjg)localObject6).TqJ = localException1.lli;
                  continue;
                  Log.i("MicroMsg.AppMessageExtension", "not predownload envelope resource");
                  continue;
                  bq.a((ca)localObject1, parama);
                  if (((et)localObject1).field_msgId != 0L) {
                    continue;
                  }
                  if (!ag.f((ca)localObject1, (String)localObject4)) {
                    continue;
                  }
                  com.tencent.mm.storage.ab.e((ca)localObject1, true);
                  Object localObject3 = new com.tencent.mm.f.a.w();
                  ((com.tencent.mm.f.a.w)localObject3).fvs.fvt = ((ca)localObject1);
                  ((com.tencent.mm.f.a.w)localObject3).fvs.fvu = paramb;
                  EventCenter.instance.publish((IEvent)localObject3);
                  localObject3 = new h.b((ca)localObject1, true);
                  ((com.tencent.mm.plugin.messenger.foundation.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.b.class)).a(parama, (ca)localObject1, (Map)localObject6);
                  if ((((ca)localObject1).getType() != 301989937) || (!com.tencent.mm.model.ab.QP(((et)localObject1).field_talker))) {
                    continue;
                  }
                  ((ca)localObject1).setMsgId(0L);
                  if ((!((ca)localObject1).hzw()) || (!"notifymessage".equals(((et)localObject1).field_talker)) || (localObject6 == null)) {
                    continue;
                  }
                  parama = Util.nullAsNil((String)((Map)localObject6).get(".msg.fromusername"));
                  if (!as.OS(parama)) {
                    continue;
                  }
                  ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).c(parama, null);
                  Log.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { parama });
                  if (((ca)localObject1).getType() != 536870961) {
                    continue;
                  }
                  parama = (com.tencent.mm.aj.b)paramb.ar(com.tencent.mm.aj.b.class);
                  localObject4 = new rr();
                  ((rr)localObject4).fQS.fQP = ((et)localObject1).field_msgId;
                  ((rr)localObject4).fQS.fQT = parama.fQR;
                  ((rr)localObject4).fQS.fQs = paramString;
                  if (((et)localObject1).field_isSend != 1) {
                    continue;
                  }
                  Log.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
                  ((rr)localObject4).fQS.username = ((et)localObject1).field_talker;
                  EventCenter.instance.publish((IEvent)localObject4);
                  if (((rr)localObject4).fQS.fQs == null) {
                    continue;
                  }
                  ((ca)localObject1).setContent(((rr)localObject4).fQS.fQs);
                  ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).a(((et)localObject1).field_msgId, (ca)localObject1);
                  if ((Util.isNullOrNil(paramb.lnP)) || (((ca)localObject1).getType() != 436207665)) {
                    continue;
                  }
                  parama = new rp();
                  parama.fQO.fQP = ((et)localObject1).field_msgId;
                  parama.fQO.fQs = paramString;
                  EventCenter.instance.publish(parama);
                  if ((paramb.type != 2000) || (Util.isNullOrNil(paramb.lnf))) {
                    continue;
                  }
                  parama = new ru();
                  parama.fQX.fJG = paramb.lnf;
                  parama.fQX.msgId = ((et)localObject1).field_msgId;
                  parama.fQX.fQY = paramb;
                  EventCenter.instance.publish(parama);
                  T(false, ((et)localObject1).field_talker);
                  parama = paramb.lpa;
                  paramString = Util.nullAs((String)parama.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                  if (((!paramString.equals("wx_f2f")) && (!paramString.equals("wx_md"))) || (!((h.b)localObject3).lCi)) {
                    continue;
                  }
                  l1 = ((et)localObject1).field_createTime;
                  long l2 = com.tencent.mm.model.cm.bfD();
                  Log.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
                  localObject4 = new com.tencent.mm.f.a.cm();
                  i = Util.getInt((String)parama.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                  Object localObject6 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                  str1 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                  str2 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.voice_content"));
                  localObject7 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
                  j = Util.getInt((String)parama.get(".msg.appmsg.ext_pay_info.need_failover"), 1);
                  if ((i <= 0) || (Util.isNullOrNil((String)localObject6)) || (Util.isNullOrNil(str1))) {
                    continue;
                  }
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fee = i;
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fyc = ((String)localObject6);
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fyd = str1;
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fye = paramString;
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.delay = (l2 - l1);
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.source = 0;
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fyf = str2;
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fyg = ((String)localObject7);
                  if (j != 0) {
                    continue;
                  }
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fyh = false;
                  EventCenter.instance.publish((IEvent)localObject4);
                  if (k == 0) {
                    continue;
                  }
                  if (paramb.type != 74) {
                    continue;
                  }
                  b((ca)localObject1, paramb, 11);
                  AppMethodBeat.o(31011);
                  return localObject3;
                  ((ca)localObject1).setMsgId(bq.z((ca)localObject1));
                  continue;
                  if (!ag.f((ca)localObject1, (String)localObject4)) {
                    continue;
                  }
                  com.tencent.mm.storage.ab.e((ca)localObject1, true);
                  if (!bool1) {
                    continue;
                  }
                  Log.i("MicroMsg.AppMessageExtension", "autoDownloadFile1 %s %s", new Object[] { Long.valueOf(((et)localObject1).field_msgSvrId), Long.valueOf(((et)localObject1).field_msgId) });
                  com.tencent.e.h.ZvG.be(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(289235);
                      Log.i("MicroMsg.AppMessageExtension", "autoDownloadFile2 %s %s", new Object[] { Long.valueOf(this.lrk.field_msgSvrId), Long.valueOf(this.lrk.field_msgId) });
                      Object localObject = k.b.OQ(this.lrk.field_content);
                      if (localObject != null)
                      {
                        localObject = m.aw(com.tencent.mm.loader.j.b.aSO(), ((k.b)localObject).title, ((k.b)localObject).llY) + "_lan_tmp";
                        if ((!Util.isNullOrNil((String)localObject)) && (u.agG((String)localObject)))
                        {
                          c localc = com.tencent.mm.plugin.ab.a.ctZ().TR(this.lrk.field_msgId);
                          if (localc != null) {
                            if (u.bBQ((String)localObject) == localc.field_totalLen)
                            {
                              boolean bool = com.tencent.mm.plugin.record.b.f.d(this.lrk, (String)localObject);
                              Log.i("MicroMsg.AppMessageExtension", "startToDownloadFile use lan, status:%s", new Object[] { Long.valueOf(localc.field_status) });
                              if (bool) {
                                AppMethodBeat.o(289235);
                              }
                            }
                            else
                            {
                              Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile tmpFile:%s, length:%s", new Object[] { Util.nullAs((String)localObject, ""), Long.valueOf(u.bBQ((String)localObject)) });
                            }
                          }
                        }
                      }
                      for (;;)
                      {
                        localObject = k.d(this.lrk, false);
                        Log.i("MicroMsg.AppMessageExtension", "autoDownloadFile3 %s %s, tryInitAttach:%s meidaId:%s", new Object[] { Long.valueOf(this.lrk.field_msgSvrId), Long.valueOf(this.lrk.field_msgId), ((Pair)localObject).first, ((Pair)localObject).second });
                        if (((Boolean)((Pair)localObject).first).booleanValue())
                        {
                          Log.i("MicroMsg.AppMessageExtension", "startToDownloadFile");
                          bh.aGY().a(new com.tencent.mm.plugin.record.b.f(this.lrk.field_msgId, (String)((Pair)localObject).second, null), 0);
                          com.tencent.mm.modelsimple.ab.ah(this.lrk);
                        }
                        com.tencent.mm.pluginsdk.model.a.b.QXV.bi(this.lrk);
                        AppMethodBeat.o(289235);
                        return;
                        Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile info is null");
                        continue;
                        Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile tmpFile:%s, %s", new Object[] { Util.nullAs((String)localObject, ""), Boolean.valueOf(u.agG((String)localObject)) });
                        continue;
                        Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile content is null");
                      }
                    }
                  });
                  localObject3 = new h.b((ca)localObject1, false);
                  continue;
                  if (!bool1) {
                    continue;
                  }
                  ((ca)localObject1).setFileStatus(0);
                  ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).b(l1, (ca)localObject1);
                  continue;
                  ((com.tencent.mm.f.a.cm)localObject4).fyb.fyh = true;
                  continue;
                  if (paramb.type != 6) {
                    continue;
                  }
                  b((ca)localObject1, paramb, 16);
                  continue;
                  k = 0;
                  bool1 = false;
                }
                Log.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.lnJ });
                ((ca)localObject1).Ip(localdb.RII);
                if (localb != null)
                {
                  ((ca)localObject1).Jv(localb.lut);
                  ((ca)localObject1).qb(localb.luu);
                  ((ca)localObject1).Jq(localb.lus);
                }
                if (((ca)localObject1).dlS()) {
                  ((ca)localObject1).Jn(x.XS(str2));
                }
                localObject5 = XmlParser.parseXml(((et)localObject1).field_content, "msg", null);
                if (((com.tencent.mm.plugin.messenger.foundation.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.b.class)).b(parama, (ca)localObject1, (Map)localObject5)) {
                  continue;
                }
                AppMethodBeat.o(31011);
                return null;
                if (paramb.type == 74) {
                  try
                  {
                    localObject5 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.ag(PluginMessengerFoundation.class)).getFileMsgInfoStorage().Va(localdb.HlH);
                    if (localObject5 != null)
                    {
                      Log.e("MicroMsg.AppMessageExtension", "doInsertMessage fail, %s has exist, overwriteNewMsgId:%s", new Object[] { Long.valueOf(((com.tencent.mm.storage.a.a)localObject5).field_msgSvrId), Long.valueOf(((com.tencent.mm.storage.a.a)localObject5).field_overwriteNewMsgId) });
                      AppMethodBeat.o(31011);
                      return null;
                    }
                    bool1 = bool4;
                    bool2 = bool3;
                  }
                  catch (Exception localException2)
                  {
                    Log.e("MicroMsg.AppMessageExtension", "doInsertMessage exception:%s %s", new Object[] { localException2.getClass().getSimpleName(), localException2.getMessage() });
                  }
                }
              }
              bool1 = bool4;
              bool2 = bool3;
              break;
              label1639:
              if (paramb.type != 74) {
                continue;
              }
              Log.e("MicroMsg.AppMessageExtension", "doInsertMessage repeat receive msg(MM_APP_FILE_UPLOADING)(%s, %s)", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(((et)localObject1).field_msgId) });
              AppMethodBeat.o(31011);
              return null;
              localObject6 = paramString;
              break label896;
              bool2 = false;
              break label961;
              localObject6 = a((byte[])localObject6, bool2, ((ca)localObject1).hzC());
              break label1054;
              if ((!Util.isNullOrNil(paramb.lmm)) && (!Util.isNullOrNil(paramb.lmq)))
              {
                a(((et)localObject1).field_msgSvrId, (ca)localObject1, (String)localObject2, paramb.lmq, paramb.lmm, paramb.lmn, bool2, paramb, "", false);
                break label1116;
              }
              if (!Util.isNullOrNil(paramb.thumburl))
              {
                Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
                localObject8 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
                localObject6 = com.tencent.mm.ay.q.bmh().getFullPath((String)localObject8);
                com.tencent.mm.ay.q.bmh();
                localObject8 = com.tencent.mm.ay.i.LQ((String)localObject8);
                localObject9 = com.tencent.mm.ay.q.bml();
                str3 = paramb.thumburl;
                locala = new c.a();
                locala.fullPath = ((String)localObject6);
                locala.lRD = true;
                ((com.tencent.mm.ay.a.a)localObject9).a(str3, null, locala.bmL());
                ((ca)localObject1).Jn((String)localObject8);
                Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject6)));
                break label1116;
              }
              if (Util.isNullOrNil(paramb.lmd)) {
                break label1116;
              }
              a(((et)localObject1).field_msgSvrId, (ca)localObject1, (String)localObject2, paramb.lmj, paramb.lmd, paramb.lme, bool2, paramb, paramb.lmi, true);
              Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.lmd);
              break label1116;
              if (!Util.isNullOrNil(paramb.thumburl))
              {
                Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
                localObject6 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
                if (paramb.type == 2001) {
                  localObject6 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
                }
                if (((ca)localObject1).hwA()) {
                  break label1116;
                }
                localObject8 = com.tencent.mm.ay.q.bmh().getFullPath((String)localObject6);
                com.tencent.mm.ay.q.bmh();
                localObject6 = com.tencent.mm.ay.i.LQ((String)localObject6);
                localObject9 = com.tencent.mm.ay.q.bml();
                str3 = paramb.thumburl;
                locala = new c.a();
                locala.fullPath = ((String)localObject8);
                locala.lRD = true;
                ((com.tencent.mm.ay.a.a)localObject9).a(str3, null, locala.bmL());
                ((ca)localObject1).Jn((String)localObject6);
                Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject8)));
                break label1116;
              }
              if (Util.isNullOrNil(paramb.lmd)) {
                break label1116;
              }
              if (paramb.type == 2)
              {
                bool2 = true;
                a(((et)localObject1).field_msgSvrId, (ca)localObject1, (String)localObject2, paramb.lmj, paramb.lmd, paramb.lme, bool2, paramb, paramb.lmi, true);
                Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.lmd);
                break label1116;
              }
              bool2 = false;
              continue;
              label2259:
              ((ca)localObject1).pJ(0);
              ((ca)localObject1).Jm((String)localObject2);
              if (localdb.rVU > 3)
              {
                i = localdb.rVU;
                break label1141;
              }
              i = 3;
              break label1141;
              label2297:
              Log.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
              continue;
              if (!"1001".equals(paramb.lnG))
              {
                localObject2 = new abq();
                ((abq)localObject2).gbx.fQs = paramString;
                ((abq)localObject2).gbx.gby = ((et)localObject1).field_talker;
                ((abq)localObject2).gbx.fNu = ((et)localObject1).field_msgSvrId;
                EventCenter.instance.publish((IEvent)localObject2);
                T(false, ((et)localObject1).field_talker);
                if ("1002".equals(paramb.lnG))
                {
                  localObject2 = (com.tencent.mm.aj.c)paramb.ar(com.tencent.mm.aj.c.class);
                  localObject6 = new cjg();
                  ((cjg)localObject6).TqI = ((com.tencent.mm.aj.c)localObject2).lll;
                  ((cjg)localObject6).TqL = ((com.tencent.mm.aj.c)localObject2).llm;
                  ((cjg)localObject6).kVK = ((com.tencent.mm.aj.c)localObject2).llj;
                  ((cjg)localObject6).TqK = ((com.tencent.mm.aj.c)localObject2).llk;
                  if (j == 0) {
                    continue;
                  }
                  ((cjg)localObject6).TqH = ((com.tencent.mm.aj.c)localObject2).llf;
                  ((cjg)localObject6).TqJ = ((com.tencent.mm.aj.c)localObject2).llg;
                  localObject8 = (com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class);
                  localObject9 = new cjf();
                  ((cjf)localObject9).Tqo = ((cjg)localObject6);
                  if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHn, true)) {
                    continue;
                  }
                  ((com.tencent.mm.plugin.luckymoney.a.a)localObject8).a((cjf)localObject9);
                  ((com.tencent.mm.plugin.luckymoney.a.a)localObject8).a(((com.tencent.mm.aj.c)localObject2).llo);
                }
              }
            }
          }
        }
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(281239);
    paramArrayOfByte = com.tencent.mm.ay.q.bmh().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(281239);
    return paramArrayOfByte;
  }
  
  private boolean a(final long paramLong, ca paramca, final String paramString1, String paramString2, String paramString3, final int paramInt, final boolean paramBoolean1, k.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(31014);
    Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(paramca.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    final long l = Util.nowMilliSecond();
    final int i;
    com.tencent.mm.i.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = "wcf://temp/appmsgext-cdnthumb-" + new Random().nextLong();
      localg = new com.tencent.mm.i.g();
      localg.taskName = "task_AppMessageExtension_1";
      localg.field_mediaId = com.tencent.mm.aq.c.a("downappthumb", paramca.field_createTime, paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label296;
      }
      localg.field_fileType = 19;
      localg.iUJ = paramString3;
      label169:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.i.a.iTV;
      localg.field_authKey = paramString4;
      if (!com.tencent.mm.model.ab.Lj(paramString1)) {
        break label314;
      }
    }
    label296:
    label314:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.iUG = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31005);
          if (paramAnonymousInt != 0)
          {
            Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt), l });
            new com.tencent.mm.f.b.a.ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(paramInt), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramString1), "" })).bpa();
            AppMethodBeat.o(31005);
            return paramAnonymousInt;
          }
          if (paramAnonymousd == null)
          {
            AppMethodBeat.o(31005);
            return 0;
          }
          label218:
          long l1;
          long l2;
          int i;
          int j;
          int k;
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousd.field_retCode), l });
            u.deleteFile(i);
            if (paramAnonymousd != null) {
              break label920;
            }
            paramAnonymousInt = -1;
            l1 = paramInt;
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
            j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
            k = paramString1;
            if (paramAnonymousd != null) {
              break label929;
            }
            paramAnonymousString = "";
            label256:
            if (paramAnonymousd != null) {
              break label938;
            }
            paramAnonymousc = "";
            label264:
            new com.tencent.mm.f.b.a.ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bpa();
            if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
            {
              if (paramAnonymousd != null) {
                break label947;
              }
              paramAnonymousInt = -1;
              label410:
              l1 = paramInt;
              l2 = Util.nowMilliSecond();
              i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
              j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
              k = paramString1;
              if (paramAnonymousd != null) {
                break label956;
              }
              paramAnonymousString = "";
              label448:
              if (paramAnonymousd != null) {
                break label965;
              }
            }
          }
          label912:
          label920:
          label929:
          label938:
          label947:
          label956:
          label965:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.iUs)
          {
            new com.tencent.mm.f.b.a.ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bpa();
            com.tencent.mm.ay.q.bmh().doNotify();
            AppMethodBeat.o(31005);
            return 0;
            bh.beI();
            paramAnonymousc = com.tencent.mm.model.c.bbO().aL(paramBoolean1, paramLong);
            if (paramAnonymousc.field_msgSvrId != paramLong)
            {
              Log.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(paramLong) });
              AppMethodBeat.o(31005);
              return 0;
            }
            Log.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousc.getType()) });
            paramAnonymousString = u.aY(i, 0, -1);
            if ((this.QWv == 33) || (this.QWv == 36) || (this.QWv == 46) || (this.QWv == 44) || (this.QWv == 48))
            {
              paramAnonymousString = com.tencent.mm.ay.q.bmh().a(paramAnonymousString, Bitmap.CompressFormat.JPEG);
              u.deleteFile(i);
              label763:
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                paramAnonymousc.Jn(paramAnonymousString);
                bh.beI();
                com.tencent.mm.model.c.bbO().b(paramAnonymousc.field_msgSvrId, paramAnonymousc);
              }
              Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(paramLong), paramBoolean1, l, paramAnonymousString });
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 16L, paramString1, false);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 17L, 1L, false);
              paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
              if (!com.tencent.mm.model.ab.Lj(paramBoolean1)) {
                break label912;
              }
            }
            for (l1 = 19L;; l1 = 18L)
            {
              paramAnonymousString.idkeyStat(198L, l1, 1L, false);
              break;
              paramAnonymousString = k.a(paramAnonymousString, this.QWw, paramAnonymousc.hzC());
              break label763;
            }
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label218;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label256;
            paramAnonymousc = paramAnonymousd.iUs;
            break label264;
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label410;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label448;
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return null;
        }
      };
      com.tencent.mm.aq.f.bkg().b(localg, -1);
      AppMethodBeat.o(31014);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      break label169;
    }
  }
  
  private static void b(ca paramca, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(281258);
    if ((paramca == null) || (paramb == null))
    {
      AppMethodBeat.o(281258);
      return;
    }
    long l = paramca.field_msgSvrId;
    Object localObject = (com.tencent.mm.aj.a.b)paramb.ar(com.tencent.mm.aj.a.b.class);
    if ((localObject != null) && (((com.tencent.mm.aj.a.b)localObject).lqB != 0L)) {
      l = ((com.tencent.mm.aj.a.b)localObject).lqB;
    }
    for (;;)
    {
      localObject = paramb.lml;
      if (paramb.lmb == 1) {}
      for (int i = 7;; i = 5)
      {
        paramca = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramb.llX), Integer.valueOf(paramInt), Long.valueOf((com.tencent.mm.model.cm.bfD() - paramca.field_createTime) / 1000L), Util.nullAsNil(paramb.llY).toLowerCase(), paramca.field_talker, Integer.valueOf(1), "", Long.valueOf(l), Long.valueOf(paramca.field_createTime), Long.valueOf(com.tencent.mm.model.cm.bfC()), Integer.valueOf(1) });
        Log.i("MicroMsg.AppMessageExtension", "reportKVStat 14665 %s", new Object[] { paramca });
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(14665, paramca);
        AppMethodBeat.o(281258);
        return;
      }
    }
  }
  
  public static Pair<Boolean, String> d(ca paramca, boolean paramBoolean)
  {
    int i = -1;
    AppMethodBeat.i(281257);
    Object localObject2 = paramca.field_content;
    Object localObject1 = localObject2;
    if (com.tencent.mm.model.ab.Lj(paramca.field_talker))
    {
      localObject1 = localObject2;
      if (paramca.field_isSend == 0) {
        localObject1 = bq.RM(paramca.field_content);
      }
    }
    k.b localb = k.b.OQ((String)localObject1);
    localObject2 = AppAttachNewDownloadUI.a(localb.type, paramca.field_msgId, localb.fvr, (String)localObject1);
    long l1;
    long l2;
    long l3;
    long l4;
    boolean bool1;
    if (localObject2 == null)
    {
      m.M(paramca.field_msgId, (String)localObject1);
      localObject1 = AppAttachNewDownloadUI.a(localb.type, paramca.field_msgId, localb.fvr, (String)localObject1);
      paramca = (ca)localObject1;
      if (localObject1 == null) {
        break label664;
      }
      l1 = ((c)localObject1).systemRowid;
      l2 = ((c)localObject1).field_totalLen;
      paramca = ((c)localObject1).field_fileFullPath;
      l3 = ((c)localObject1).field_type;
      localObject2 = ((c)localObject1).field_mediaId;
      l4 = ((c)localObject1).field_msgInfoId;
      bool1 = ((c)localObject1).field_isUpload;
      if (((c)localObject1).field_signature == null)
      {
        i = -1;
        Log.i("MicroMsg.AppMessageExtension", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramca, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (localb.lmb == 0)
        {
          paramca = (ca)localObject1;
          if (localb.llX <= 26214400) {
            break label664;
          }
        }
        if (com.tencent.mm.platformtools.ae.isNullOrNil(((c)localObject1).field_signature)) {
          break label447;
        }
        bool1 = true;
        label282:
        paramca = (ca)localObject1;
        if ((paramBoolean) || (localb == null) || ((localb.lmb == 0) && (localb.llX <= 26214400))) {
          break label681;
        }
        bool1 = false;
      }
    }
    label664:
    label681:
    for (;;)
    {
      if ((!paramBoolean) && (!bool1))
      {
        localObject3 = Util.nullAsNil(localb.title);
        localObject2 = Util.nullAsNil(localb.llY).toLowerCase();
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = u.asq((String)localObject3);
        }
        bh.aGY().a(new com.tencent.mm.plugin.record.b.d(paramca, Util.nullAsNil(localb.aesKey), Util.nullAsNil(localb.filemd5), (String)localObject3, (String)localObject1, Util.nullAsNil(localb.fLi), true), 0);
      }
      paramca = new Pair(Boolean.valueOf(bool1), localb.fvr);
      AppMethodBeat.o(281257);
      return paramca;
      i = ((c)localObject1).field_signature.length();
      break;
      label447:
      bool1 = false;
      break label282;
      Object localObject3 = new com.tencent.mm.vfs.q(((c)localObject2).field_fileFullPath);
      if ((((c)localObject2).field_status == 199L) && (!((com.tencent.mm.vfs.q)localObject3).ifE()))
      {
        Log.i("MicroMsg.AppMessageExtension", "summerapp tryInitAttachInfo info exist but file not!");
        m.M(paramca.field_msgId, (String)localObject1);
      }
      l1 = ((c)localObject2).systemRowid;
      l2 = ((c)localObject2).field_totalLen;
      paramca = ((c)localObject2).field_fileFullPath;
      l3 = ((c)localObject2).field_type;
      localObject1 = ((c)localObject2).field_mediaId;
      l4 = ((c)localObject2).field_msgInfoId;
      bool1 = ((c)localObject2).field_isUpload;
      boolean bool2 = ((com.tencent.mm.vfs.q)localObject3).ifE();
      long l5 = ((c)localObject2).field_status;
      if (((c)localObject2).field_signature == null) {}
      for (;;)
      {
        Log.i("MicroMsg.AppMessageExtension", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramca, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
        paramca = (ca)localObject2;
        bool1 = true;
        break;
        i = ((c)localObject2).field_signature.length();
      }
    }
  }
  
  public static String nm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31008);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(31008);
      return null;
    }
    String str = paramString2;
    if (com.tencent.mm.model.ab.Lj(paramString1))
    {
      int i = bq.RI(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = Util.processXml(str);
    AppMethodBeat.o(31008);
    return paramString1;
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(31009);
    Log.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject5 = parama.jQG;
    Object localObject1 = com.tencent.mm.platformtools.z.a(((db)localObject5).RID);
    String str = com.tencent.mm.platformtools.z.a(((db)localObject5).RIE);
    if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(str))) {
      Log.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    k.b localb;
    for (str = null;; str = nm((String)localObject1, com.tencent.mm.platformtools.z.a(((db)localObject5).RIF)))
    {
      localb = k.b.OQ(str);
      if (localb != null) {
        break;
      }
      Log.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(31009);
      return null;
    }
    if (localb.lnN)
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(352273, str);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(352274, Long.valueOf(System.currentTimeMillis()));
      new b(str).hhq();
      AppMethodBeat.o(31009);
      return null;
    }
    Object localObject2 = ao.fmz().bqc(localb.appId);
    Object localObject3 = localb.appId;
    int i = localb.appVersion;
    if (localObject2 == null) {}
    h.b localb1;
    for (localObject1 = "null";; localObject1 = Integer.valueOf(((g)localObject2).field_appVersion))
    {
      Log.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { localObject3, Integer.valueOf(i), localObject1 });
      if ((localObject2 == null) || (((g)localObject2).field_appVersion < localb.appVersion)) {
        ao.fmy().bqa(localb.appId);
      }
      localb1 = a(parama, com.tencent.mm.platformtools.z.a(((db)localObject5).RIF), localb);
      if ((localb1 != null) && (localb1.fvt != null)) {
        break;
      }
      AppMethodBeat.o(31009);
      return null;
    }
    ca localca = localb1.fvt;
    if (localca.hwA())
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localca.getType() == 301989937)
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localca.getType() == -1879048190)
    {
      localObject1 = new aam();
      ((aam)localObject1).fZF.xml = str;
      ((aam)localObject1).fZF.description = localb.description;
      ((aam)localObject1).fZF.fvt = localca;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    if (localca.getType() == 318767153)
    {
      localObject1 = new dj();
      ((dj)localObject1).fyW.xml = str;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    if ((localca.getType() == 49) && (!Util.isNullOrNil(localb.canvasPageXml)))
    {
      localObject1 = new com.tencent.mm.f.a.g();
      ((com.tencent.mm.f.a.g)localObject1).fuw.fux = localb.canvasPageXml;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    if (localca.dlS())
    {
      localObject3 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
      localObject1 = com.tencent.mm.platformtools.z.a(((db)localObject5).RIE);
      localObject2 = com.tencent.mm.platformtools.z.a(((db)localObject5).RID);
      if ((!((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().has((String)localObject2)) && (!((String)localObject3).equals(localObject2))) {
        break label1103;
      }
      i = 1;
      localObject3 = new com.tencent.mm.modelvideo.w();
      if (i == 0) {
        break label1108;
      }
      label611:
      ((com.tencent.mm.modelvideo.w)localObject3).fPV = ((String)localObject1);
      ((com.tencent.mm.modelvideo.w)localObject3).mhK = ((String)localObject2);
      ((com.tencent.mm.modelvideo.w)localObject3).createTime = ((db)localObject5).CreateTime;
      ((com.tencent.mm.modelvideo.w)localObject3).fNu = ((db)localObject5).HlH;
      ((com.tencent.mm.modelvideo.w)localObject3).mhW = ((db)localObject5).RIF.Ufy;
      ((com.tencent.mm.modelvideo.w)localObject3).mhR = ((int)localca.field_msgId);
      if (!localca.hzq()) {
        break label1115;
      }
    }
    Object localObject6;
    for (localObject1 = new com.tencent.mm.aj.y().a(localca.VGz);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((com.tencent.mm.modelvideo.w)localObject3).fileName = localca.field_imgPath;
        ((com.tencent.mm.modelvideo.w)localObject3).a(((com.tencent.mm.aj.y)localObject1).videoUrl, ((com.tencent.mm.aj.y)localObject1).videoDuration, ((com.tencent.mm.aj.y)localObject1).title, ((com.tencent.mm.aj.y)localObject1).ROZ, "", "", "");
        ((com.tencent.mm.modelvideo.w)localObject3).status = 111;
      }
      s.bqB().b((com.tencent.mm.modelvideo.w)localObject3);
      if (localb.type != 53) {
        break label1415;
      }
      Log.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
      localObject3 = ((db)localObject5).RIJ;
      localObject6 = localb.title;
      if (!Util.isNullOrNil((String)localObject3)) {
        break label1185;
      }
      localObject1 = "";
      label805:
      ((db)localObject5).RIJ = ((String)localObject1);
      localObject1 = bq.RL(localca.field_content);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label1769;
      }
      label835:
      if (!parama.lCc) {
        break label1358;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).b(com.tencent.mm.platformtools.z.a(((db)localObject5).RID), (String)localObject1, localb.title, (String)localb.loQ.second, localca.field_msgId, localca.field_createTime / 1000L);
      label896:
      if ((com.tencent.mm.model.ab.PP(localca.field_talker)) && (com.tencent.mm.chatroom.d.y.asb())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(localca);
      }
      if ((com.tencent.mm.model.ab.PP(localca.field_talker)) && (aa.asf())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localca);
      }
      parama = new com.tencent.mm.aj.k();
      localb.a(parama);
      parama.field_msgId = localca.field_msgId;
      if ((ao.hhH().NR(localca.field_msgId) != null) || (!ao.hhH().insert(parama))) {
        break label1761;
      }
      if (localb.type == 40)
      {
        parama = ao.ctZ().TR(localca.field_msgId);
        localObject1 = com.tencent.mm.aj.t.OV(str);
        if (parama == null) {
          m.a(null, localca.field_msgId, 0, null, null, ((com.tencent.mm.aj.t)localObject1).lpG, localb.type, 0);
        }
        parama = new com.tencent.mm.plugin.record.b.f(localca.field_msgId, localca.field_msgSvrId, null);
        bh.aGY().a(parama, 0);
      }
      AppMethodBeat.o(31009);
      return localb1;
      label1103:
      i = 0;
      break;
      label1108:
      localObject1 = localObject2;
      break label611;
      label1115:
      localObject1 = k.b.aG(localca.field_content, localca.field_reserved);
      if (localObject1 != null) {
        break label1149;
      }
      Log.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
    }
    label1149:
    localObject1 = (e)((k.b)localObject1).ar(e.class);
    if ((localObject1 != null) && (((e)localObject1).llv != null)) {}
    for (localObject1 = ((e)localObject1).llv;; localObject1 = null)
    {
      break;
      label1185:
      localObject2 = Util.processXml((String)localObject3);
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = "";
        break label805;
      }
      i = ((String)localObject2).indexOf("<pushcontent");
      Object localObject4 = new StringBuilder();
      if (i > 0)
      {
        localObject1 = ((String)localObject2).substring(i);
        localObject4 = ((StringBuilder)localObject4).append(((String)localObject2).substring(0, i));
        localObject2 = localObject1;
      }
      for (localObject1 = localObject4;; localObject1 = localObject4)
      {
        localObject2 = XmlParser.parseXml((String)localObject2, "pushcontent", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.AppMessageExtension", "inval xml");
          localObject1 = localObject3;
          break;
        }
        localObject2 = (String)((Map)localObject2).get(".pushcontent.$nickname");
        ((StringBuilder)localObject1).append("<pushcontent content=\"").append((String)localObject2).append(" : ").append((String)localObject6).append("\"nickname=\"").append((String)localObject2).append("\" />\n");
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        label1358:
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).a(com.tencent.mm.platformtools.z.a(((db)localObject5).RID), (String)localObject1, localb.title, (String)localb.loQ.second, localca.field_msgId, localca.field_createTime / 1000L);
        break label896;
        label1415:
        if (localb.type == 57)
        {
          Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(localca.field_msgId, localca.field_msgSvrId, localca.field_talker, localb.loR.FkS);
          break label896;
        }
        if (localb.type != 60) {
          break label896;
        }
        parama = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
        com.tencent.mm.platformtools.z.a(((db)localObject5).RIE);
        localObject1 = com.tencent.mm.platformtools.z.a(((db)localObject5).RID);
        boolean bool;
        if ((((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().has((String)localObject1)) || (parama.equals(localObject1)))
        {
          bool = true;
          label1553:
          if (!bool) {
            break label1752;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", new Object[] { Boolean.valueOf(bool), parama });
          if (bool) {
            break;
          }
          localObject3 = (v)localb.ar(v.class);
          long l1 = Long.parseLong(((v)localObject3).kwM);
          localObject2 = ((v)localObject3).kie;
          localObject3 = ((v)localObject3).thumbUrl;
          localObject4 = ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
          localObject6 = Boolean.FALSE;
          long l2 = ((db)localObject5).CreateTime;
          Log.i("MicroMsg.LiveTipsBarStorage", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", new Object[] { localObject1, Long.valueOf(l1) });
          localObject5 = new com.tencent.mm.live.b.c.b();
          ((com.tencent.mm.live.b.c.b)localObject5).field_hostRoomId = ((String)localObject1);
          ((com.tencent.mm.live.b.c.b)localObject5).field_liveId = l1;
          ((com.tencent.mm.live.b.c.b)localObject5).field_liveName = ((String)localObject2);
          ((com.tencent.mm.live.b.c.b)localObject5).field_thumbUrl = ((String)localObject3);
          ((com.tencent.mm.live.b.c.b)localObject5).field_anchorUsername = parama;
          ((com.tencent.mm.live.b.c.b)localObject5).field_isSender = ((Boolean)localObject6).booleanValue();
          ((com.tencent.mm.live.b.c.b)localObject5).field_timeStamp = l2;
          ((com.tencent.mm.live.b.c.c)localObject4).a((com.tencent.mm.live.b.c.b)localObject5);
          break;
          bool = false;
          break label1553;
          label1752:
          parama = localb.fLi;
        }
        label1761:
        AppMethodBeat.o(31009);
        return null;
        label1769:
        localObject1 = "";
        break label835;
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    String str = null;
    AppMethodBeat.i(31013);
    Object localObject = paramc.fNz;
    if (localObject == null)
    {
      Log.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(31013);
      return;
    }
    Log.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + ((et)localObject).field_imgPath);
    paramc = new aal();
    paramc.fZE.path = ((et)localObject).field_imgPath;
    EventCenter.instance.publish(paramc);
    paramc = ((et)localObject).field_content;
    if (paramc != null)
    {
      k.b localb = k.b.OQ(paramc);
      if ((localb != null) && (localb.type == 6))
      {
        paramc = com.tencent.mm.loader.j.b.aSO() + localb.title;
        u.deleteFile(paramc);
        u.deleteFile(com.tencent.mm.loader.j.b.aSO() + localb.title + "_tmp");
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.ab.a.ctZ().TR(((et)localObject).field_msgId);
      if (localObject != null)
      {
        str = ((c)localObject).field_fileFullPath;
        u.deleteFile(str);
        com.tencent.mm.plugin.ab.a.ctZ().delete((IAutoDBItem)localObject, new String[] { "msgInfoId" });
      }
      Log.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, %s, %s", new Object[] { paramc, str });
      AppMethodBeat.o(31013);
      return;
      paramc = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void hhz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */