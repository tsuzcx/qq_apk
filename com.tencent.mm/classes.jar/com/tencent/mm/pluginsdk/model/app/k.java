package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.a.aci;
import com.tencent.mm.autogen.a.acj;
import com.tencent.mm.autogen.a.adn;
import com.tencent.mm.autogen.a.bd;
import com.tencent.mm.autogen.a.bd.a;
import com.tencent.mm.autogen.a.cv;
import com.tencent.mm.autogen.a.dt;
import com.tencent.mm.autogen.a.te;
import com.tencent.mm.autogen.a.tg;
import com.tencent.mm.autogen.a.tg.a;
import com.tencent.mm.autogen.a.tj;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.k.b.a;
import com.tencent.mm.message.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.AppAttachNewDownloadUI;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class k
  implements com.tencent.mm.am.g
{
  private g.b a(com.tencent.mm.am.g.a parama, String paramString, k.b paramb)
  {
    AppMethodBeat.i(31011);
    dl localdl = parama.mpN;
    bh.bCz();
    Object localObject7 = com.tencent.mm.model.c.bzD();
    bh.bCz();
    Object localObject1 = com.tencent.mm.model.c.bzJ();
    Object localObject2 = com.tencent.mm.model.z.bAM();
    String str1 = w.a(localdl.YFE);
    String str2 = w.a(localdl.YFF);
    int j;
    br.b localb;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = br.JP(localdl.YFJ);
      if (localb == null) {
        break label3727;
      }
    }
    label3721:
    label3727:
    for (Object localObject4 = localb.olO;; localObject4 = null)
    {
      if (au.bwv((String)localObject4)) {
        localObject2 = "notifymessage";
      }
      long l1;
      boolean bool4;
      boolean bool3;
      boolean bool2;
      for (;;)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).aU((String)localObject2, localdl.Njv);
        Log.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(((fi)localObject1).field_msgId) });
        if ((((fi)localObject1).field_msgId != 0L) && (((cc)localObject1).getCreateTime() + 604800000L < br.D((String)localObject2, localdl.CreateTime)))
        {
          Log.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(((fi)localObject1).field_msgId) });
          br.iu(((fi)localObject1).field_msgId);
          ((cc)localObject1).setMsgId(0L);
        }
        l1 = localdl.Njv;
        bool4 = false;
        bool1 = false;
        if (((fi)localObject1).field_msgId != 0L) {
          break label1662;
        }
        bool3 = true;
        bool2 = true;
        if (paramb.type != 6) {
          break label1531;
        }
        localObject5 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getFileMsgInfoStorage().zg(localdl.Njv);
        if (localObject5 == null) {
          break label375;
        }
        Log.e("MicroMsg.AppMessageExtension", "doInsertMessage fail, %s has exist, overwriteNewMsgId:%s", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(((com.tencent.mm.storage.a.a)localObject5).field_overwriteNewMsgId) });
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
      Object localObject5 = (com.tencent.mm.message.a.b)paramb.aK(com.tencent.mm.message.a.b.class);
      Object localObject8;
      if ((localObject5 != null) && (((com.tencent.mm.message.a.b)localObject5).nVD != 0L))
      {
        if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sn(((com.tencent.mm.message.a.b)localObject5).nVD))
        {
          Log.i("MicroMsg.AppMessageExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
          AppMethodBeat.o(31011);
          return null;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).aU((String)localObject2, ((com.tencent.mm.message.a.b)localObject5).nVD);
        localObject8 = new com.tencent.mm.storage.a.a();
        if (((fi)localObject1).field_msgId != 0L)
        {
          if (!((cc)localObject1).fxR())
          {
            Log.w("MicroMsg.AppMessageExtension", "ignore, because msg(%s) type:%s", new Object[] { Long.valueOf(((fi)localObject1).field_msgId), Integer.valueOf(((cc)localObject1).getType()) });
            AppMethodBeat.o(31011);
            return null;
          }
          ((cc)localObject1).gX(localdl.Njv);
          l1 = ((com.tencent.mm.message.a.b)localObject5).nVD;
          bool2 = false;
          if (((fi)localObject1).fileStatus != 1) {
            break label3721;
          }
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        Object localObject9 = k.b.Hf(((fi)localObject1).field_content);
        if ((localObject9 != null) && (!Util.isNullOrNil(((k.b)localObject9).nTV)))
        {
          localObject9 = ((k.b)localObject9).nTV.split(";");
          if ((localObject9 != null) && (localObject9.length == 2))
          {
            ((com.tencent.mm.storage.a.a)localObject8).field_cgi = localObject9[0];
            ((com.tencent.mm.storage.a.a)localObject8).field_aeskey = localObject9[1];
          }
        }
        ((com.tencent.mm.storage.a.a)localObject8).field_msgSvrId = localdl.Njv;
        ((com.tencent.mm.storage.a.a)localObject8).field_overwriteNewMsgId = ((com.tencent.mm.message.a.b)localObject5).nVD;
        bool3 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getFileMsgInfoStorage().a((com.tencent.mm.storage.a.a)localObject8);
        Log.i("MicroMsg.AppMessageExtension", "fileuploadtoken:%s overwrite_newmsgid:%s msgId:%s needCreate:%s needAutoDownloadFile:%s insertFileMsgInfo:%s cgi:%s aeskey:%s", new Object[] { ((com.tencent.mm.message.a.b)localObject5).nVE, Long.valueOf(((com.tencent.mm.message.a.b)localObject5).nVD), Long.valueOf(((fi)localObject1).field_msgId), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Util.nullAs(((com.tencent.mm.storage.a.a)localObject8).field_cgi, ""), Util.nullAs(((com.tencent.mm.storage.a.a)localObject8).field_aeskey, "") });
        if (bool2)
        {
          localObject1 = new cc();
          ((cc)localObject1).gX(localdl.Njv);
          ((cc)localObject1).setCreateTime(br.D((String)localObject2, localdl.CreateTime));
        }
        if ((paramb.type == 74) || (paramb.type == 6)) {
          ((cc)localObject1).aJR();
        }
        for (int i = 1;; i = 0)
        {
          int k = i;
          for (;;)
          {
            if (paramb.nRa != null)
            {
              ((cc)localObject1).Cc(paramb.nRa.kLp);
              Log.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((fi)localObject1).kLp });
            }
            ((cc)localObject1).setType(n.h(paramb));
            if (((cc)localObject1).iYe())
            {
              localObject5 = paramb.content;
              label894:
              ((cc)localObject1).setContent((String)localObject5);
              if (((cc)localObject1).iYe()) {
                ((cc)localObject1).Ca(paramb.kLg);
              }
              if ((localdl.YFH != 2) || (((fi)localObject1).field_msgId != 0L)) {
                break label2016;
              }
              label1167:
              switch (((cc)localObject1).getType())
              {
              default: 
                i = 0;
                label971:
                if (i == 0) {
                  if (paramb.type == 2)
                  {
                    bool2 = true;
                    label987:
                    localObject5 = w.a(localdl.YFI);
                    if (com.tencent.mm.platformtools.z.pCs)
                    {
                      Log.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                      localObject5 = null;
                    }
                    if (Util.isNullOrNil((byte[])localObject5)) {
                      break label1748;
                    }
                    if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
                      break label1731;
                    }
                    localObject5 = r.bKa().a((byte[])localObject5, Bitmap.CompressFormat.PNG);
                    if (Util.isNullOrNil((String)localObject5)) {
                      Log.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { Util.secPrint(((fi)localObject1).field_content) });
                    }
                    if (!Util.isNullOrNil((String)localObject5))
                    {
                      ((cc)localObject1).BT((String)localObject5);
                      Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject5)));
                    }
                    label1142:
                    if (j == 0) {
                      break label2288;
                    }
                    ((cc)localObject1).pI(1);
                    ((cc)localObject1).BS((String)localObject2);
                    i = localdl.vhk;
                    ((cc)localObject1).setStatus(i);
                    if (paramb.type == 2001) {
                      if (paramb.hAN == 1)
                      {
                        if ((TextUtils.isEmpty(paramb.nSO)) || (TextUtils.isEmpty(paramb.nSP)) || (paramb.nSQ <= 0)) {
                          break label2326;
                        }
                        Log.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                        localObject2 = new bd();
                        ((bd)localObject2).hBd = new bd.a();
                        ((bd)localObject2).hBd.hBf = paramb.nSP;
                        ((bd)localObject2).hBd.hBe = paramb.nSO;
                        ((bd)localObject2).hBd.hBg = paramb.nSQ;
                        ((bd)localObject2).publish();
                      }
                    }
                  }
                }
                label1080:
                break;
              }
            }
            for (;;)
            {
              for (;;)
              {
                try
                {
                  if (Util.isNullOrNil(paramb.nTa)) {
                    continue;
                  }
                  localObject2 = paramb.nTa.iterator();
                  if (((Iterator)localObject2).hasNext())
                  {
                    localObject5 = ((String)((Iterator)localObject2).next()).split(",");
                    if ((localObject5 == null) || (localObject5.length <= 0)) {
                      continue;
                    }
                    localObject5 = localObject5[0];
                    if ((Util.isNullOrNil((String)localObject5)) || (!((String)localObject5).equals(com.tencent.mm.model.z.bAM()))) {
                      continue;
                    }
                    ((cc)localObject1).setFlag(((fi)localObject1).field_flag | 0x8);
                    Log.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                    aQ(true, ((fi)localObject1).field_talker);
                  }
                }
                catch (Exception localException1)
                {
                  label1531:
                  String str3;
                  com.tencent.mm.modelimage.loader.a.c.a locala;
                  Log.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException1.getMessage() });
                  continue;
                  ((czj)localObject6).aaEJ = localException1.nPW;
                  ((czj)localObject6).aaEL = localException1.nPX;
                  ((czj)localObject6).aaER = localException1.nQh;
                  ((czj)localObject6).aaES = localException1.nQi;
                  continue;
                  Log.i("MicroMsg.AppMessageExtension", "not predownload envelope resource");
                  continue;
                  br.a((cc)localObject1, parama);
                  if (((fi)localObject1).field_msgId != 0L) {
                    continue;
                  }
                  if (!ai.h((cc)localObject1, (String)localObject4)) {
                    continue;
                  }
                  ad.e((cc)localObject1, true);
                  Object localObject3 = new com.tencent.mm.autogen.a.z();
                  ((com.tencent.mm.autogen.a.z)localObject3).hzN.hzO = ((cc)localObject1);
                  ((com.tencent.mm.autogen.a.z)localObject3).hzN.hzP = paramb;
                  ((com.tencent.mm.autogen.a.z)localObject3).publish();
                  localObject3 = new g.b((cc)localObject1, true);
                  ((com.tencent.mm.plugin.messenger.foundation.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.b.class)).a(parama, (cc)localObject1, (Map)localObject6);
                  if ((((cc)localObject1).getType() != 301989937) || (!au.bwt(((fi)localObject1).field_talker))) {
                    continue;
                  }
                  ((cc)localObject1).setMsgId(0L);
                  if ((!((cc)localObject1).jbz()) || (!"notifymessage".equals(((fi)localObject1).field_talker)) || (localObject6 == null)) {
                    continue;
                  }
                  parama = Util.nullAsNil((String)((Map)localObject6).get(".msg.fromusername"));
                  if (!au.Hh(parama)) {
                    continue;
                  }
                  ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).c(parama, null);
                  Log.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { parama });
                  if (((cc)localObject1).getType() != 536870961) {
                    continue;
                  }
                  parama = (com.tencent.mm.message.b)paramb.aK(com.tencent.mm.message.b.class);
                  localObject4 = new tg();
                  ((tg)localObject4).hWP.hWM = ((fi)localObject1).field_msgId;
                  ((tg)localObject4).hWP.hWQ = parama.hWO;
                  ((tg)localObject4).hWP.hWn = paramString;
                  if (((fi)localObject1).field_isSend != 1) {
                    continue;
                  }
                  Log.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
                  ((tg)localObject4).hWP.username = ((fi)localObject1).field_talker;
                  ((tg)localObject4).publish();
                  if (((tg)localObject4).hWP.hWn == null) {
                    continue;
                  }
                  ((cc)localObject1).setContent(((tg)localObject4).hWP.hWn);
                  ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).a(((fi)localObject1).field_msgId, (cc)localObject1);
                  if ((Util.isNullOrNil(paramb.nST)) || (((cc)localObject1).getType() != 436207665)) {
                    continue;
                  }
                  parama = new te();
                  parama.hWL.hWM = ((fi)localObject1).field_msgId;
                  parama.hWL.hWn = paramString;
                  parama.publish();
                  if ((paramb.type != 2000) || (Util.isNullOrNil(paramb.nSk))) {
                    continue;
                  }
                  parama = new tj();
                  parama.hWU.hPj = paramb.nSk;
                  parama.hWU.msgId = ((fi)localObject1).field_msgId;
                  parama.hWU.hWV = paramb;
                  parama.publish();
                  aQ(false, ((fi)localObject1).field_talker);
                  parama = paramb.nUd;
                  paramString = Util.nullAs((String)parama.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                  if (((!paramString.equals("wx_f2f")) && (!paramString.equals("wx_md"))) || (!((g.b)localObject3).otS)) {
                    continue;
                  }
                  l1 = ((cc)localObject1).getCreateTime();
                  long l2 = cn.bDv();
                  Log.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
                  localObject4 = new cv();
                  i = Util.getInt((String)parama.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                  Object localObject6 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                  str1 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                  str2 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.voice_content"));
                  localObject7 = Util.nullAsNil((String)parama.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
                  j = Util.getInt((String)parama.get(".msg.appmsg.ext_pay_info.need_failover"), 1);
                  if ((i <= 0) || (Util.isNullOrNil((String)localObject6)) || (Util.isNullOrNil(str1))) {
                    continue;
                  }
                  ((cv)localObject4).hCG.fee = i;
                  ((cv)localObject4).hCG.hCH = ((String)localObject6);
                  ((cv)localObject4).hCG.hCI = str1;
                  ((cv)localObject4).hCG.hCJ = paramString;
                  ((cv)localObject4).hCG.delay = (l2 - l1);
                  ((cv)localObject4).hCG.source = 0;
                  ((cv)localObject4).hCG.hCK = str2;
                  ((cv)localObject4).hCG.hCL = ((String)localObject7);
                  if (j != 0) {
                    continue;
                  }
                  ((cv)localObject4).hCG.hCM = false;
                  ((cv)localObject4).publish();
                  if (k == 0) {
                    continue;
                  }
                  if (paramb.type != 74) {
                    continue;
                  }
                  b((cc)localObject1, paramb, 11);
                  AppMethodBeat.o(31011);
                  return localObject3;
                  ((cc)localObject1).setMsgId(br.B((cc)localObject1));
                  continue;
                  if (!ai.h((cc)localObject1, (String)localObject4)) {
                    continue;
                  }
                  ad.e((cc)localObject1, true);
                  if (!bool1) {
                    continue;
                  }
                  Log.i("MicroMsg.AppMessageExtension", "autoDownloadFile1 %s %s", new Object[] { Long.valueOf(((fi)localObject1).field_msgSvrId), Long.valueOf(((fi)localObject1).field_msgId) });
                  com.tencent.threadpool.h.ahAA.bm(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(244938);
                      Log.i("MicroMsg.AppMessageExtension", "autoDownloadFile2 %s %s", new Object[] { Long.valueOf(k.this.field_msgSvrId), Long.valueOf(k.this.field_msgId) });
                      Object localObject = k.b.Hf(k.this.field_content);
                      if (localObject != null)
                      {
                        localObject = n.aK(com.tencent.mm.loader.i.b.bmC(), ((k.b)localObject).title, ((k.b)localObject).nRe) + "_lan_tmp";
                        if ((!Util.isNullOrNil((String)localObject)) && (com.tencent.mm.vfs.y.ZC((String)localObject)))
                        {
                          c localc = com.tencent.mm.plugin.openapi.a.cWJ().yi(k.this.field_msgId);
                          if (localc != null) {
                            if (com.tencent.mm.vfs.y.bEl((String)localObject) == localc.field_totalLen)
                            {
                              boolean bool = com.tencent.mm.plugin.record.model.g.f(k.this, (String)localObject);
                              Log.i("MicroMsg.AppMessageExtension", "startToDownloadFile use lan, status:%s", new Object[] { Long.valueOf(localc.field_status) });
                              if (bool) {
                                AppMethodBeat.o(244938);
                              }
                            }
                            else
                            {
                              Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile tmpFile:%s, length:%s", new Object[] { Util.nullAs((String)localObject, ""), Long.valueOf(com.tencent.mm.vfs.y.bEl((String)localObject)) });
                            }
                          }
                        }
                      }
                      for (;;)
                      {
                        localObject = k.d(k.this, false);
                        Log.i("MicroMsg.AppMessageExtension", "autoDownloadFile3 %s %s, tryInitAttach:%s meidaId:%s", new Object[] { Long.valueOf(k.this.field_msgSvrId), Long.valueOf(k.this.field_msgId), ((Pair)localObject).first, ((Pair)localObject).second });
                        if (((Boolean)((Pair)localObject).first).booleanValue())
                        {
                          Log.i("MicroMsg.AppMessageExtension", "startToDownloadFile");
                          bh.aZW().a(new com.tencent.mm.plugin.record.model.g(k.this.field_msgId, (String)((Pair)localObject).second, null), 0);
                          ac.am(k.this);
                        }
                        com.tencent.mm.pluginsdk.model.file.b.XTS.by(k.this);
                        AppMethodBeat.o(244938);
                        return;
                        Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile info is null");
                        continue;
                        Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile tmpFile:%s, %s", new Object[] { Util.nullAs((String)localObject, ""), Boolean.valueOf(com.tencent.mm.vfs.y.ZC((String)localObject)) });
                        continue;
                        Log.e("MicroMsg.AppMessageExtension", "startToDownloadFile content is null");
                      }
                    }
                  });
                  localObject3 = new g.b((cc)localObject1, false);
                  continue;
                  if (!bool1) {
                    continue;
                  }
                  ((cc)localObject1).setFileStatus(0);
                  ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject7).b(l1, (cc)localObject1);
                  continue;
                  ((cv)localObject4).hCG.hCM = true;
                  continue;
                  if (paramb.type != 6) {
                    continue;
                  }
                  b((cc)localObject1, paramb, 16);
                  continue;
                  k = 0;
                  bool1 = false;
                }
                Log.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.nSN });
                ((cc)localObject1).AU(localdl.YFJ);
                if (localb != null)
                {
                  ((cc)localObject1).Cb(localb.olS);
                  ((cc)localObject1).qb(localb.olT);
                  ((cc)localObject1).BW(localb.olR);
                }
                if (((cc)localObject1).dSI()) {
                  ((cc)localObject1).BT(aa.PW(str2));
                }
                localObject5 = XmlParser.parseXml(((fi)localObject1).field_content, "msg", null);
                if (((com.tencent.mm.plugin.messenger.foundation.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.b.class)).b(parama, (cc)localObject1, (Map)localObject5)) {
                  continue;
                }
                AppMethodBeat.o(31011);
                return null;
                if (paramb.type == 74) {
                  try
                  {
                    localObject5 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getFileMsgInfoStorage().zh(localdl.Njv);
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
              label1662:
              if (paramb.type != 74) {
                continue;
              }
              Log.e("MicroMsg.AppMessageExtension", "doInsertMessage repeat receive msg(MM_APP_FILE_UPLOADING)(%s, %s)", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(((fi)localObject1).field_msgId) });
              AppMethodBeat.o(31011);
              return null;
              localObject6 = paramString;
              break label894;
              i = 1;
              break label971;
              bool2 = false;
              break label987;
              label1731:
              localObject6 = a((byte[])localObject6, bool2, ((cc)localObject1).jbH());
              break label1080;
              label1748:
              if ((!Util.isNullOrNil(paramb.nRr)) && (!Util.isNullOrNil(paramb.nRv)))
              {
                a(((fi)localObject1).field_msgSvrId, (cc)localObject1, (String)localObject2, paramb.nRv, paramb.nRr, paramb.nRs, bool2, paramb, "", false);
                break label1142;
              }
              if (!Util.isNullOrNil(paramb.thumburl))
              {
                Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
                localObject8 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
                localObject6 = r.bKa().getFullPath((String)localObject8);
                r.bKa();
                localObject8 = com.tencent.mm.modelimage.j.Ew((String)localObject8);
                localObject9 = r.bKe();
                str3 = paramb.thumburl;
                locala = new com.tencent.mm.modelimage.loader.a.c.a();
                locala.fullPath = ((String)localObject6);
                locala.oKp = true;
                ((com.tencent.mm.modelimage.loader.a)localObject9).a(str3, null, locala.bKx());
                ((cc)localObject1).BT((String)localObject8);
                Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject6)));
                break label1142;
              }
              if (Util.isNullOrNil(paramb.nRi)) {
                break label1142;
              }
              a(((fi)localObject1).field_msgSvrId, (cc)localObject1, (String)localObject2, paramb.nRo, paramb.nRi, paramb.nRj, bool2, paramb, paramb.nRn, true);
              Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.nRi);
              break label1142;
              label2016:
              if (!Util.isNullOrNil(paramb.thumburl))
              {
                Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
                localObject6 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
                if (paramb.type == 2001) {
                  localObject6 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
                }
                if (((cc)localObject1).iYe()) {
                  break label1142;
                }
                localObject8 = r.bKa().getFullPath((String)localObject6);
                r.bKa();
                localObject6 = com.tencent.mm.modelimage.j.Ew((String)localObject6);
                localObject9 = r.bKe();
                str3 = paramb.thumburl;
                locala = new com.tencent.mm.modelimage.loader.a.c.a();
                locala.fullPath = ((String)localObject8);
                locala.oKp = true;
                ((com.tencent.mm.modelimage.loader.a)localObject9).a(str3, null, locala.bKx());
                ((cc)localObject1).BT((String)localObject6);
                Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject8)));
                break label1142;
              }
              if (Util.isNullOrNil(paramb.nRi)) {
                break label1142;
              }
              if (paramb.type == 2)
              {
                bool2 = true;
                a(((fi)localObject1).field_msgSvrId, (cc)localObject1, (String)localObject2, paramb.nRo, paramb.nRi, paramb.nRj, bool2, paramb, paramb.nRn, true);
                Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.nRi);
                break label1142;
              }
              bool2 = false;
              continue;
              label2288:
              ((cc)localObject1).pI(0);
              ((cc)localObject1).BS((String)localObject2);
              if (localdl.vhk > 3)
              {
                i = localdl.vhk;
                break label1167;
              }
              i = 3;
              break label1167;
              label2326:
              Log.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
              continue;
              if (!"1001".equals(paramb.nSK))
              {
                localObject2 = new adn();
                ((adn)localObject2).ihH.hWn = paramString;
                ((adn)localObject2).ihH.ihI = ((fi)localObject1).field_talker;
                ((adn)localObject2).ihH.hTh = ((fi)localObject1).field_msgSvrId;
                ((adn)localObject2).publish();
                aQ(false, ((fi)localObject1).field_talker);
                if ("1002".equals(paramb.nSK))
                {
                  localObject2 = (com.tencent.mm.message.c)paramb.aK(com.tencent.mm.message.c.class);
                  localObject6 = new czj();
                  ((czj)localObject6).aaEK = ((com.tencent.mm.message.c)localObject2).nQa;
                  ((czj)localObject6).aaEN = ((com.tencent.mm.message.c)localObject2).nQb;
                  ((czj)localObject6).nBe = ((com.tencent.mm.message.c)localObject2).nPY;
                  ((czj)localObject6).aaEM = ((com.tencent.mm.message.c)localObject2).nPZ;
                  ((czj)localObject6).aaEP = ((com.tencent.mm.message.c)localObject2).nQd;
                  ((czj)localObject6).aaEQ = ((com.tencent.mm.message.c)localObject2).nQe;
                  if (j == 0) {
                    continue;
                  }
                  ((czj)localObject6).aaEJ = ((com.tencent.mm.message.c)localObject2).nPU;
                  ((czj)localObject6).aaEL = ((com.tencent.mm.message.c)localObject2).nPV;
                  ((czj)localObject6).aaER = ((com.tencent.mm.message.c)localObject2).nQf;
                  ((czj)localObject6).aaES = ((com.tencent.mm.message.c)localObject2).nQg;
                  localObject8 = (com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class);
                  localObject9 = new czi();
                  ((czi)localObject9).aaEq = ((czj)localObject6);
                  if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXo, true)) {
                    continue;
                  }
                  ((com.tencent.mm.plugin.luckymoney.a.a)localObject8).a((czi)localObject9);
                  ((com.tencent.mm.plugin.luckymoney.a.a)localObject8).a(((com.tencent.mm.message.c)localObject2).nQl);
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
    AppMethodBeat.i(244914);
    paramArrayOfByte = r.bKa().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(244914);
    return paramArrayOfByte;
  }
  
  private boolean a(final long paramLong, cc paramcc, final String paramString1, String paramString2, String paramString3, final int paramInt, final boolean paramBoolean1, final k.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(31014);
    Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(paramcc.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    Util.nowMilliSecond();
    final int i;
    com.tencent.mm.g.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = "wcf://temp/appmsgext-cdnthumb-" + new Random().nextLong();
      localg = new com.tencent.mm.g.g();
      localg.taskName = "task_AppMessageExtension_1";
      localg.field_mediaId = com.tencent.mm.modelcdntran.h.a("downappthumb", paramcc.getCreateTime(), paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label293;
      }
      localg.field_fileType = 19;
      localg.lwO = paramString3;
      label168:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.g.a.lwa;
      localg.field_authKey = paramString4;
      if (!au.bwE(paramString1)) {
        break label311;
      }
    }
    label293:
    label311:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.lwL = new com.tencent.mm.g.g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31005);
          if (paramAnonymousInt != 0)
          {
            Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt), paramb });
            AppMethodBeat.o(31005);
            return paramAnonymousInt;
          }
          if (paramAnonymousd == null)
          {
            AppMethodBeat.o(31005);
            return 0;
          }
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousd.field_retCode), paramb });
            com.tencent.mm.vfs.y.deleteFile(paramString1);
            r.bKa().doNotify();
            AppMethodBeat.o(31005);
            return 0;
          }
          bh.bCz();
          paramAnonymousc = com.tencent.mm.model.c.bzD().aU(i, paramLong);
          if ((paramAnonymousc == null) || (paramAnonymousc.field_msgSvrId != paramLong))
          {
            Log.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(paramLong) });
            AppMethodBeat.o(31005);
            return 0;
          }
          Log.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousc.getType()) });
          paramAnonymousString = com.tencent.mm.vfs.y.bi(paramString1, 0, -1);
          if ((paramBoolean1 == 33) || (paramBoolean1 == 36) || (paramBoolean1 == 46) || (paramBoolean1 == 44) || (paramBoolean1 == 48))
          {
            paramAnonymousString = r.bKa().a(paramAnonymousString, Bitmap.CompressFormat.JPEG);
            com.tencent.mm.vfs.y.deleteFile(paramString1);
            label306:
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              paramAnonymousc.BT(paramAnonymousString);
              bh.bCz();
              com.tencent.mm.model.c.bzD().b(paramAnonymousc.field_msgSvrId, paramAnonymousc);
            }
            Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(paramLong), i, paramb, paramAnonymousString });
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 16L, this.oHG, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 17L, 1L, false);
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
            if (!au.bwE(i)) {
              break label455;
            }
          }
          label455:
          for (long l = 19L;; l = 18L)
          {
            paramAnonymousString.idkeyStat(198L, l, 1L, false);
            break;
            paramAnonymousString = k.a(paramAnonymousString, paramInt, paramAnonymousc.jbH());
            break label306;
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return null;
        }
      };
      com.tencent.mm.modelcdntran.k.bHW().b(localg, -1);
      AppMethodBeat.o(31014);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.g.a.MediaType_THUMBIMAGE;
      break label168;
    }
  }
  
  private static void aQ(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(31012);
    bb localbb;
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      bh.bCz();
      localbb = com.tencent.mm.model.c.bzG().bxM(paramString);
      if (localbb != null)
      {
        if (!paramBoolean) {
          break label87;
        }
        localbb.rv(16777216);
      }
    }
    for (;;)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzG().c(localbb, paramString);
      AppMethodBeat.o(31012);
      return;
      label87:
      localbb.rw(16777216);
    }
  }
  
  private static void b(cc paramcc, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(244978);
    if ((paramcc == null) || (paramb == null))
    {
      AppMethodBeat.o(244978);
      return;
    }
    long l = paramcc.field_msgSvrId;
    Object localObject = (com.tencent.mm.message.a.b)paramb.aK(com.tencent.mm.message.a.b.class);
    if ((localObject != null) && (((com.tencent.mm.message.a.b)localObject).nVD != 0L)) {
      l = ((com.tencent.mm.message.a.b)localObject).nVD;
    }
    for (;;)
    {
      localObject = paramb.nRq;
      if (paramb.nRh == 1) {}
      for (int i = 7;; i = 5)
      {
        paramcc = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramb.nRd), Integer.valueOf(paramInt), Long.valueOf((cn.bDv() - paramcc.getCreateTime()) / 1000L), Util.nullAsNil(paramb.nRe).toLowerCase(), paramcc.field_talker, Integer.valueOf(1), "", Long.valueOf(l), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(cn.bDu()), Integer.valueOf(1) });
        Log.i("MicroMsg.AppMessageExtension", "reportKVStat 14665 %s", new Object[] { paramcc });
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(14665, paramcc);
        AppMethodBeat.o(244978);
        return;
      }
    }
  }
  
  public static Pair<Boolean, String> d(cc paramcc, boolean paramBoolean)
  {
    int i = -1;
    AppMethodBeat.i(244970);
    Object localObject2 = paramcc.field_content;
    Object localObject1 = localObject2;
    if (au.bwE(paramcc.field_talker))
    {
      localObject1 = localObject2;
      if (paramcc.field_isSend == 0) {
        localObject1 = br.JK(paramcc.field_content);
      }
    }
    k.b localb = k.b.Hf((String)localObject1);
    localObject2 = AppAttachNewDownloadUI.a(localb.type, paramcc.field_msgId, localb.hzM, (String)localObject1);
    long l1;
    long l2;
    long l3;
    long l4;
    boolean bool1;
    if (localObject2 == null)
    {
      n.ab(paramcc.field_msgId, (String)localObject1);
      localObject1 = AppAttachNewDownloadUI.a(localb.type, paramcc.field_msgId, localb.hzM, (String)localObject1);
      paramcc = (cc)localObject1;
      if (localObject1 == null) {
        break label664;
      }
      l1 = ((c)localObject1).systemRowid;
      l2 = ((c)localObject1).field_totalLen;
      paramcc = ((c)localObject1).field_fileFullPath;
      l3 = ((c)localObject1).field_type;
      localObject2 = ((c)localObject1).field_mediaId;
      l4 = ((c)localObject1).field_msgInfoId;
      bool1 = ((c)localObject1).field_isUpload;
      if (((c)localObject1).field_signature == null)
      {
        i = -1;
        Log.i("MicroMsg.AppMessageExtension", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramcc, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (localb.nRh == 0)
        {
          paramcc = (cc)localObject1;
          if (localb.nRd <= 26214400) {
            break label664;
          }
        }
        if (com.tencent.mm.platformtools.ab.isNullOrNil(((c)localObject1).field_signature)) {
          break label447;
        }
        bool1 = true;
        label282:
        paramcc = (cc)localObject1;
        if ((paramBoolean) || (localb == null) || ((localb.nRh == 0) && (localb.nRd <= 26214400))) {
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
        localObject2 = Util.nullAsNil(localb.nRe).toLowerCase();
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = com.tencent.mm.vfs.y.alV((String)localObject3);
        }
        bh.aZW().a(new com.tencent.mm.plugin.record.model.e(paramcc, Util.nullAsNil(localb.aesKey), Util.nullAsNil(localb.filemd5), (String)localObject3, (String)localObject1, Util.nullAsNil(localb.hQQ), true), 0);
      }
      paramcc = new Pair(Boolean.valueOf(bool1), localb.hzM);
      AppMethodBeat.o(244970);
      return paramcc;
      i = ((c)localObject1).field_signature.length();
      break;
      label447:
      bool1 = false;
      break label282;
      Object localObject3 = new u(((c)localObject2).field_fileFullPath);
      if ((((c)localObject2).field_status == 199L) && (!((u)localObject3).jKS()))
      {
        Log.i("MicroMsg.AppMessageExtension", "summerapp tryInitAttachInfo info exist but file not!");
        n.ab(paramcc.field_msgId, (String)localObject1);
      }
      l1 = ((c)localObject2).systemRowid;
      l2 = ((c)localObject2).field_totalLen;
      paramcc = ((c)localObject2).field_fileFullPath;
      l3 = ((c)localObject2).field_type;
      localObject1 = ((c)localObject2).field_mediaId;
      l4 = ((c)localObject2).field_msgInfoId;
      bool1 = ((c)localObject2).field_isUpload;
      boolean bool2 = ((u)localObject3).jKS();
      long l5 = ((c)localObject2).field_status;
      if (((c)localObject2).field_signature == null) {}
      for (;;)
      {
        Log.i("MicroMsg.AppMessageExtension", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramcc, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
        paramcc = (cc)localObject2;
        bool1 = true;
        break;
        i = ((c)localObject2).field_signature.length();
      }
    }
  }
  
  public static String ph(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31008);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(31008);
      return null;
    }
    String str = paramString2;
    if (au.bwE(paramString1))
    {
      int i = br.JG(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = Util.processXml(str);
    AppMethodBeat.o(31008);
    return paramString1;
  }
  
  public final g.b b(com.tencent.mm.am.g.a parama)
  {
    AppMethodBeat.i(31009);
    Log.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject5 = parama.mpN;
    Object localObject1 = w.a(((dl)localObject5).YFE);
    String str = w.a(((dl)localObject5).YFF);
    if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(str))) {
      Log.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    k.b localb;
    for (str = null;; str = ph((String)localObject1, w.a(((dl)localObject5).YFG)))
    {
      localb = k.b.Hf(str);
      if (localb != null) {
        break;
      }
      Log.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(31009);
      return null;
    }
    if (localb.nSR)
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(352273, str);
      bh.bCz();
      com.tencent.mm.model.c.ban().B(352274, Long.valueOf(System.currentTimeMillis()));
      new b(str).iIq();
      AppMethodBeat.o(31009);
      return null;
    }
    Object localObject2 = as.gxn().bpR(localb.appId);
    Object localObject3 = localb.appId;
    int i = localb.appVersion;
    if (localObject2 == null) {}
    g.b localb1;
    for (localObject1 = "null";; localObject1 = Integer.valueOf(((g)localObject2).field_appVersion))
    {
      Log.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { localObject3, Integer.valueOf(i), localObject1 });
      if ((localObject2 == null) || (((g)localObject2).field_appVersion < localb.appVersion)) {
        as.gxm().bpP(localb.appId);
      }
      localb1 = a(parama, w.a(((dl)localObject5).YFG), localb);
      if ((localb1 != null) && (localb1.hzO != null)) {
        break;
      }
      AppMethodBeat.o(31009);
      return null;
    }
    cc localcc = localb1.hzO;
    if (localcc.iYe())
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localcc.getType() == 301989937)
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localcc.getType() == -1879048190)
    {
      localObject1 = new acj();
      ((acj)localObject1).ifN.xml = str;
      ((acj)localObject1).ifN.description = localb.description;
      ((acj)localObject1).ifN.hzO = localcc;
      ((acj)localObject1).publish();
    }
    if (localcc.getType() == 318767153)
    {
      localObject1 = new dt();
      ((dt)localObject1).hDF.xml = str;
      ((dt)localObject1).hDF.msgType = localcc.getType();
      ((dt)localObject1).publish();
      localObject1 = com.tencent.mm.plugin.appbrand.msg.dyeingtemplate.a.tmI;
      int j = localcc.getType();
      kotlin.g.b.s.u(str, "msgXml");
      if (((CharSequence)com.tencent.mm.plugin.appbrand.msg.dyeingtemplate.a.adQ(str)).length() <= 0) {
        break label1163;
      }
      i = 1;
      if ((i != 0) || (com.tencent.mm.plugin.appbrand.msg.dyeingtemplate.a.cW(str, j) == null)) {
        break label1168;
      }
      i = 1;
      label524:
      if (i != 0) {
        localb1.otS = false;
      }
    }
    if ((localcc.getType() == 49) && (!Util.isNullOrNil(localb.canvasPageXml)))
    {
      localObject1 = new com.tencent.mm.autogen.a.h();
      ((com.tencent.mm.autogen.a.h)localObject1).hyO.hyP = localb.canvasPageXml;
      ((com.tencent.mm.autogen.a.h)localObject1).publish();
    }
    if (localcc.dSI())
    {
      localObject3 = (String)com.tencent.mm.kernel.h.baE().ban().d(2, "");
      localObject1 = w.a(((dl)localObject5).YFF);
      localObject2 = w.a(((dl)localObject5).YFE);
      if ((!((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzJ().has((String)localObject2)) && (!((String)localObject3).equals(localObject2))) {
        break label1173;
      }
      i = 1;
      label664:
      localObject3 = new com.tencent.mm.modelvideo.z();
      if (i == 0) {
        break label1178;
      }
      label677:
      ((com.tencent.mm.modelvideo.z)localObject3).hVQ = ((String)localObject1);
      ((com.tencent.mm.modelvideo.z)localObject3).paV = ((String)localObject2);
      ((com.tencent.mm.modelvideo.z)localObject3).createTime = ((dl)localObject5).CreateTime;
      ((com.tencent.mm.modelvideo.z)localObject3).hTh = ((dl)localObject5).Njv;
      ((com.tencent.mm.modelvideo.z)localObject3).pbh = ((dl)localObject5).YFG.abwM;
      ((com.tencent.mm.modelvideo.z)localObject3).pbc = ((int)localcc.field_msgId);
      if (!localcc.jbt()) {
        break label1185;
      }
    }
    Object localObject6;
    for (localObject1 = new com.tencent.mm.message.y().a(localcc.adks);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((com.tencent.mm.modelvideo.z)localObject3).fileName = localcc.field_imgPath;
        ((com.tencent.mm.modelvideo.z)localObject3).a(((com.tencent.mm.message.y)localObject1).videoUrl, ((com.tencent.mm.message.y)localObject1).videoDuration, ((com.tencent.mm.message.y)localObject1).title, ((com.tencent.mm.message.y)localObject1).YMm, "", "", "");
        ((com.tencent.mm.modelvideo.z)localObject3).status = 111;
      }
      com.tencent.mm.modelvideo.v.bOh().b((com.tencent.mm.modelvideo.z)localObject3);
      if (localb.type != 53) {
        break label1485;
      }
      Log.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
      localObject3 = ((dl)localObject5).YFK;
      localObject6 = localb.title;
      if (!Util.isNullOrNil((String)localObject3)) {
        break label1255;
      }
      localObject1 = "";
      label871:
      ((dl)localObject5).YFK = ((String)localObject1);
      localObject1 = br.JJ(localcc.field_content);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label1844;
      }
      label901:
      if (!parama.otM) {
        break label1428;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).b(w.a(((dl)localObject5).YFE), (String)localObject1, localb.title, (String)localb.nTT.second, localcc.field_msgId, localcc.getCreateTime() / 1000L);
      label962:
      if ((au.bwG(localcc.field_talker)) && (com.tencent.mm.chatroom.d.ab.aLX())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.h.az(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(localcc);
      }
      if (au.bwG(localcc.field_talker)) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.h.az(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localcc);
      }
      parama = new com.tencent.mm.message.k();
      localb.a(parama);
      parama.field_msgId = localcc.field_msgId;
      if ((as.iIJ().rI(localcc.field_msgId) != null) || (!as.iIJ().insert(parama))) {
        break label1836;
      }
      if (localb.type == 40)
      {
        parama = as.cWJ().yi(localcc.field_msgId);
        localObject1 = t.Hk(str);
        if (parama == null) {
          n.a(null, localcc.field_msgId, 0, null, null, ((t)localObject1).nUI, localb.type, 0);
        }
        parama = new com.tencent.mm.plugin.record.model.g(localcc.field_msgId, localcc.field_msgSvrId, null);
        bh.aZW().a(parama, 0);
      }
      AppMethodBeat.o(31009);
      return localb1;
      label1163:
      i = 0;
      break;
      label1168:
      i = 0;
      break label524;
      label1173:
      i = 0;
      break label664;
      label1178:
      localObject1 = localObject2;
      break label677;
      label1185:
      localObject1 = k.b.aP(localcc.field_content, localcc.field_reserved);
      if (localObject1 != null) {
        break label1219;
      }
      Log.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
    }
    label1219:
    localObject1 = (com.tencent.mm.message.e)((k.b)localObject1).aK(com.tencent.mm.message.e.class);
    if ((localObject1 != null) && (((com.tencent.mm.message.e)localObject1).nQs != null)) {}
    for (localObject1 = ((com.tencent.mm.message.e)localObject1).nQs;; localObject1 = null)
    {
      break;
      label1255:
      localObject2 = Util.processXml((String)localObject3);
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = "";
        break label871;
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
        label1428:
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).a(w.a(((dl)localObject5).YFE), (String)localObject1, localb.title, (String)localb.nTT.second, localcc.field_msgId, localcc.getCreateTime() / 1000L);
        break label962;
        label1485:
        if (localb.type == 57)
        {
          Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(localcc.field_msgId, localcc.field_msgSvrId, localcc.field_talker, localb.nTU.LgU);
          break label962;
        }
        if (localb.type != 60) {
          break label962;
        }
        parama = (String)com.tencent.mm.kernel.h.baE().ban().d(2, "");
        w.a(((dl)localObject5).YFF);
        localObject1 = w.a(((dl)localObject5).YFE);
        boolean bool;
        if ((((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzJ().has((String)localObject1)) || (parama.equals(localObject1)))
        {
          bool = true;
          label1624:
          if (!bool) {
            break label1827;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", new Object[] { Boolean.valueOf(bool), parama });
          if (bool) {
            break;
          }
          localObject3 = (com.tencent.mm.live.model.v)localb.aK(com.tencent.mm.live.model.v.class);
          long l1 = Long.parseLong(((com.tencent.mm.live.model.v)localObject3).liveId);
          localObject2 = ((com.tencent.mm.live.model.v)localObject3).mIA;
          localObject3 = ((com.tencent.mm.live.model.v)localObject3).thumbUrl;
          localObject4 = ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
          localObject6 = Boolean.FALSE;
          long l2 = ((dl)localObject5).CreateTime;
          Log.i("MicroMsg.LiveTipsBarStorage", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", new Object[] { localObject1, Long.valueOf(l1) });
          localObject5 = new com.tencent.mm.live.model.c.b();
          ((com.tencent.mm.live.model.c.b)localObject5).field_hostRoomId = ((String)localObject1);
          ((com.tencent.mm.live.model.c.b)localObject5).field_liveId = l1;
          ((com.tencent.mm.live.model.c.b)localObject5).field_liveName = ((String)localObject2);
          ((com.tencent.mm.live.model.c.b)localObject5).field_thumbUrl = ((String)localObject3);
          ((com.tencent.mm.live.model.c.b)localObject5).field_anchorUsername = parama;
          ((com.tencent.mm.live.model.c.b)localObject5).field_isSender = ((Boolean)localObject6).booleanValue();
          ((com.tencent.mm.live.model.c.b)localObject5).field_timeStamp = l2;
          ((com.tencent.mm.live.model.c.c)localObject4).a((com.tencent.mm.live.model.c.b)localObject5);
          break;
          bool = false;
          break label1624;
          label1827:
          parama = localb.hQQ;
        }
        label1836:
        AppMethodBeat.o(31009);
        return null;
        label1844:
        localObject1 = "";
        break label901;
      }
    }
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(31013);
    Object localObject = paramc.hTm;
    if (localObject == null)
    {
      Log.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(31013);
      return;
    }
    Log.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + ((fi)localObject).field_imgPath);
    paramc = new aci();
    paramc.ifM.path = ((fi)localObject).field_imgPath;
    paramc.publish();
    paramc = null;
    c localc = com.tencent.mm.plugin.openapi.a.cWJ().yi(((fi)localObject).field_msgId);
    if (localc != null)
    {
      paramc = localc.field_fileFullPath;
      com.tencent.mm.vfs.y.deleteFile(paramc);
      com.tencent.mm.plugin.openapi.a.cWJ().delete(localc, new String[] { "msgInfoId" });
    }
    localObject = r.bKa().d(((fi)localObject).field_imgPath, false, true);
    if (com.tencent.mm.vfs.y.ZC((String)localObject)) {
      com.tencent.mm.vfs.y.deleteFile((String)localObject);
    }
    Log.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, thumbPath:%s, attachFullPath:%s", new Object[] { localObject, paramc });
    AppMethodBeat.o(31013);
  }
  
  public static abstract interface a
  {
    public abstract void iIz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */