package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.a;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.autogen.a.xi;
import com.tencent.mm.autogen.a.yl;
import com.tencent.mm.autogen.a.ym;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.jw;
import com.tencent.mm.autogen.mmdata.rpt.ke;
import com.tencent.mm.g.g.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.cq;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.j.d;
import com.tencent.mm.modelimage.l;
import com.tencent.mm.modelimage.p.a;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.network.ah;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.z.a;
import com.tencent.mm.pluginsdk.h.c.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.q.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.m;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public class MsgRetransmitUI
  extends MMBaseActivity
  implements com.tencent.mm.am.h
{
  boolean Aet;
  private String aeGE;
  private int aeSs;
  public List<String> afMB;
  private ArrayList<Long> afMC;
  private String afMD;
  private boolean afME;
  private boolean afMF;
  private com.tencent.mm.ui.widget.a.e afMG;
  private int afMH;
  private int afMI;
  private com.tencent.mm.modelimage.o afMJ;
  private boolean afMK;
  private List<String> afML;
  private int afMM;
  private int afMN;
  private boolean afMO;
  private boolean afMP;
  private int afMQ;
  private boolean afMR;
  private boolean afMS;
  private boolean afMT;
  private int afMU;
  private int afMV;
  private String afMW;
  private int afMX;
  private int afMY;
  private boolean afMZ;
  private boolean afNa;
  private boolean afNb;
  private boolean afNc;
  private int afNd;
  boolean afNe;
  public String fileName;
  private int fromScene;
  public String hWn;
  private boolean isGroupChat;
  private float latitude;
  private int length;
  private float longtitude;
  private ProgressDialog lzP;
  private MMHandler mHandler;
  private String mSessionId;
  public long msgId;
  public int msgType;
  private int oGu;
  private com.tencent.mm.am.i oHS;
  private String oIv;
  private String pbn;
  private long startTime;
  private String thumbPath;
  long vEb;
  
  public MsgRetransmitUI()
  {
    AppMethodBeat.i(39288);
    this.afMD = null;
    this.afME = true;
    this.afMF = false;
    this.lzP = null;
    this.oGu = 0;
    this.afMH = 0;
    this.afMI = 0;
    this.afMJ = null;
    this.afMK = false;
    this.afML = null;
    this.oHS = null;
    this.afMM = 0;
    this.afMN = 0;
    this.afMO = false;
    this.afMP = false;
    this.isGroupChat = false;
    this.aeSs = -1;
    this.afMS = true;
    this.afMT = true;
    this.afMU = 0;
    this.startTime = 0L;
    this.afMZ = true;
    this.afNa = false;
    this.fromScene = 0;
    this.afNb = false;
    this.afNc = false;
    this.afNd = 0;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.afNe = false;
    AppMethodBeat.o(39288);
  }
  
  private void a(final k.b paramb, final com.tencent.mm.pluginsdk.model.app.c paramc, final cc paramcc, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39296);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_MsgRetransmitUI_1";
    localg.lwL = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(250800);
        paramc.field_fileFullPath = paramString2;
        if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
        {
          paramc.field_offset = paramAnonymousc.field_finishedLength;
          as.cWJ().a(paramc, new String[0]);
        }
        if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          paramc.field_status = 199L;
          paramc.field_offset = paramc.field_totalLen;
          as.cWJ().a(paramc, new String[0]);
          paramcc.setStatus(3);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
          com.tencent.mm.pluginsdk.model.app.n.a(paramb, paramb.appId, paramb.appName, paramString1, paramString2, paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this));
        }
        AppMethodBeat.o(250800);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    localg.field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), paramcc.field_talker, paramcc.field_msgId);
    localg.field_aesKey = paramb.aesKey;
    localg.field_fileType = 19;
    localg.field_authKey = paramb.nRn;
    localg.lwO = paramb.tpurl;
    localg.field_fullpath = paramString2;
    if (!com.tencent.mm.modelcdntran.k.bHW().b(localg, -1)) {
      Log.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
    }
    AppMethodBeat.o(39296);
  }
  
  private void a(com.tencent.mm.modelimage.h paramh, cc paramcc, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39303);
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = paramh.oGu;
    long l1 = com.tencent.mm.modelimage.r.bKa().a(paramcc.field_talker, this.fileName, i, paramInt, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.modelimage.h localh = com.tencent.mm.modelimage.r.bKa().b(Long.valueOf(l1));
    localh.wo(1);
    cc localcc = new cc();
    localcc.setType(com.tencent.mm.model.ab.IY(paramString2));
    localcc.BS(paramString2);
    localcc.pI(1);
    localcc.setStatus(1);
    localcc.BT(((PString)localObject).value);
    localcc.pW(localPInt1.value);
    localcc.pX(localPInt2.value);
    localcc.setCreateTime(br.JN(localcc.field_talker));
    if (com.tencent.mm.an.g.Dn(localcc.field_talker)) {
      paramcc.AU(com.tencent.mm.an.a.e.bCQ());
    }
    bh.bCz();
    long l2 = com.tencent.mm.model.c.bzD().ba(localcc);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      localh.iP((int)l2);
      com.tencent.mm.modelimage.r.bKa().a(Long.valueOf(l1), localh);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), paramh);
      com.tencent.mm.modelimage.r.bKb().a(paramh.localId, paramcc.field_msgId, i, localObject, R.g.chat_img_template, new f.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, p paramAnonymousp) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(250831);
          if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
          for (paramAnonymousInt1 = 1; (paramAnonymousObject instanceof HashMap); paramAnonymousInt1 = 0)
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            if (paramAnonymousObject == null) {
              break;
            }
            paramAnonymousObject = paramAnonymousObject.entrySet().iterator();
            while (paramAnonymousObject.hasNext())
            {
              paramAnonymousp = (Map.Entry)paramAnonymousObject.next();
              paramAnonymousString = (Long)paramAnonymousp.getKey();
              paramAnonymousp = (com.tencent.mm.modelimage.h)paramAnonymousp.getValue();
              MsgRetransmitUI.this.fileName = com.tencent.mm.modelimage.r.bKa().v(com.tencent.mm.modelimage.i.c(paramAnonymousp), "", "");
              if (paramAnonymousInt1 != 0)
              {
                bh.bCz();
                com.tencent.mm.model.c.bzD().sm(paramAnonymousString.longValue());
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramString2, paramInt, paramString3, paramString1, MsgRetransmitUI.f(MsgRetransmitUI.this), paramAnonymousLong1);
              }
            }
          }
          AppMethodBeat.o(250831);
        }
      });
      AppMethodBeat.o(39303);
      return;
    }
  }
  
  private void a(b paramb, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(39309);
    Log.printInfoStack("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
    Object localObject = new a();
    getString(R.l.app_tip);
    this.lzP = com.tencent.mm.ui.base.k.a(this, getString(R.l.app_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(250836);
        this.aelI.afNt = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(250836);
      }
    });
    ((a)localObject).context = this;
    ((a)localObject).fileName = this.fileName;
    ((a)localObject).tipDialog = this.lzP;
    ((a)localObject).afMH = this.afMH;
    ((a)localObject).omT = this.length;
    ((a)localObject).oYP = this.msgType;
    ((a)localObject).afNv = false;
    ((a)localObject).userName = paramString;
    ((a)localObject).afNw = true;
    ((a)localObject).afMF = this.afMF;
    ((a)localObject).afNz = paramb;
    paramb = com.tencent.mm.modelvideo.ab.Qo(this.fileName);
    if ((paramb != null) && (paramb.pbk != null))
    {
      Log.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((a)localObject).afNy = paramb.pbk;
      ((a)localObject).jUr = paramb.bOs();
      ((a)localObject).afNA = paramb.pbc;
    }
    if (paramb != null) {
      ((a)localObject).pbo = paramb.pbo;
    }
    ((a)localObject).execute(new Object[0]);
    ch.bDg().f(ch.onj, null);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(39309);
      return;
    }
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().sl(this.msgId);
    boolean bool = au.bwE(paramString);
    if (bool)
    {
      paramb = a.c.aedA;
      if (!this.afMR) {
        break label332;
      }
    }
    label332:
    for (localObject = a.d.aedE;; localObject = a.d.aedD)
    {
      if (bool) {
        i = com.tencent.mm.model.v.getMembersCountByChatRoomName(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localcc, i);
      AppMethodBeat.o(39309);
      return;
      paramb = a.c.aedz;
      break;
    }
  }
  
  private void a(final String paramString, final int paramInt, com.tencent.mm.am.i parami)
  {
    AppMethodBeat.i(39301);
    final String str1 = com.tencent.mm.model.z.bAM();
    bh.bCz();
    final cc localcc = com.tencent.mm.model.c.bzD().sl(this.msgId);
    if ((localcc != null) && (localcc.field_msgId == this.msgId))
    {
      Object localObject3 = localcc.field_content;
      Object localObject1 = null;
      if (localcc.field_msgId > 0L) {
        localObject1 = com.tencent.mm.modelimage.r.bKa().H(localcc.field_talker, localcc.field_msgId);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.modelimage.h)localObject1).localId > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localcc.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.modelimage.r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
        }
      }
      localObject1 = localObject3;
      if (Util.isNullOrNil((String)localObject3))
      {
        localObject1 = localObject3;
        if (localcc.field_msgSvrId > 0L) {
          localObject1 = ((com.tencent.mm.modelimage.h)localObject2).oGC;
        }
      }
      if ((localObject2 != null) && ((((com.tencent.mm.modelimage.h)localObject2).offset < ((com.tencent.mm.modelimage.h)localObject2).osy) || (((com.tencent.mm.modelimage.h)localObject2).osy == 0)) && (!this.afMO))
      {
        localObject2 = com.tencent.mm.modelimage.r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
        localObject3 = XmlParser.parseXml(((com.tencent.mm.modelimage.h)localObject2).oGC, "msg", null);
        final int i;
        if (localObject3 == null)
        {
          Log.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.modelimage.h)localObject2).oGC });
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            a((com.tencent.mm.modelimage.h)localObject2, localcc, (String)localObject1, paramInt, paramString, str1);
          }
          AppMethodBeat.o(39301);
          return;
          final int j = ((com.tencent.mm.modelimage.h)localObject2).oGu;
          if (j != 1) {
            parami = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
          }
          for (i = 2;; i = 1)
          {
            Log.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), parami });
            if (!Util.isNullOrNil(parami)) {
              break label386;
            }
            Log.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
            i = 0;
            break;
            parami = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
          }
          label386:
          String str2 = (String)((Map)localObject3).get(".msg.img.$aeskey");
          if (Util.isNullOrNil(str2))
          {
            Log.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
            i = 0;
          }
          else if (Util.isNullOrNil(com.tencent.mm.modelcdntran.h.a("downimg", ((com.tencent.mm.modelimage.h)localObject2).createTime, localcc.field_talker, localcc.field_msgId)))
          {
            Log.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(localcc.field_msgSvrId) });
            i = 0;
          }
          else
          {
            localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
            com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
            localg.taskName = "task_MsgRetransmitUI_2";
            localg.lwL = new g.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(250832);
                if (paramAnonymousd != null)
                {
                  if (!paramAnonymousd.field_exist_whencheck) {
                    break label78;
                  }
                  Log.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
                  MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymousd, localcc, paramInt, paramString, str1, this.aehd, this.oJE, j);
                }
                for (;;)
                {
                  AppMethodBeat.o(250832);
                  return 0;
                  label78:
                  Log.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
                  MsgRetransmitUI.a(MsgRetransmitUI.this, this.oIE, localcc, this.aehd, paramInt, paramString, str1);
                }
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            localg.field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), paramString, localcc.field_msgId);
            localg.field_fileId = parami;
            localg.field_aesKey = str2;
            localg.field_filemd5 = ((String)localObject3);
            localg.field_fileType = i;
            localg.field_talker = paramString;
            localg.field_priority = com.tencent.mm.g.a.lvZ;
            localg.field_svr_signature = "";
            localg.field_onlycheckexist = true;
            localg.field_trysafecdn = true;
            if (!com.tencent.mm.modelcdntran.k.bHW().g(localg))
            {
              Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
        }
      }
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.modelimage.h)localObject2).localId;; l = -1L)
      {
        a(paramString, paramInt, str1, (String)localObject1, parami, l);
        AppMethodBeat.o(39301);
        return;
      }
    }
    a(paramString, paramInt, str1, "", parami, -1L);
    AppMethodBeat.o(39301);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.am.i parami, long paramLong)
  {
    AppMethodBeat.i(39304);
    t.e locale;
    if (!Util.isNullOrNil(this.fileName))
    {
      this.afMM = 1;
      this.afMN = 1;
      if (!bCF(this.fileName))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.oGu == 1) && (!com.tencent.mm.model.z.h(this.fileName, paramString1, false))) {
        this.oGu = 0;
      }
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 96L, 1L, false);
      locale = com.tencent.mm.modelmulti.t.a(t.d.oNd).wg(paramInt);
      locale.hQQ = paramString2;
      locale.toUser = paramString1;
      locale.oIx = this.fileName;
      locale.oGu = this.oGu;
      locale.oNk = parami;
      locale.hOX = 0;
      locale.oGC = paramString3;
      locale.thumbPath = "";
      locale.oNn = true;
      locale.oNm = R.g.chat_img_template;
      locale.oNs = true;
      locale.oNt = this.afMQ;
      locale.longitude = this.longtitude;
      locale.latitude = this.latitude;
      locale.oIv = this.oIv;
      locale.oNp = paramLong;
      locale.oNo = this.msgId;
      locale.oNq = this.pbn;
      if (this.afMI == 1) {}
      for (bool = true;; bool = false)
      {
        locale.mxV = bool;
        locale.oNj = 19;
        paramString1 = locale.bKW();
        this.afMJ = ((com.tencent.mm.modelimage.o)paramString1.oNb);
        paramString1.aXz();
        this.afMK = true;
        Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.oGu) });
        ch.bDg().f(ch.oni, null);
        AppMethodBeat.o(39304);
        return;
      }
    }
    if (this.afMO)
    {
      this.afMM += 1;
      if (!bCF((String)this.afML.get(0)))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.oGu == 1) && (!com.tencent.mm.model.z.h((String)this.afML.get(0), paramString1, false))) {
        this.oGu = 0;
      }
      Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.oGu) });
      locale = com.tencent.mm.modelmulti.t.a(t.d.oNd).wg(paramInt);
      locale.hQQ = paramString2;
      locale.toUser = paramString1;
      locale.oIx = ((String)this.afML.get(0));
      locale.oGu = this.oGu;
      locale.oNk = parami;
      locale.hOX = 0;
      locale.oGC = paramString3;
      locale.thumbPath = "";
      locale.oNn = true;
      locale.oNm = R.g.chat_img_template;
      if (this.afMI != 1) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      locale.mxV = bool;
      locale.oNj = 11;
      paramString1 = locale.bKW();
      this.afMJ = ((com.tencent.mm.modelimage.o)paramString1.oNb);
      this.afMK = true;
      paramString1.aXz();
      ch.bDg().f(ch.oni, null);
      AppMethodBeat.o(39304);
      return;
    }
  }
  
  private void a(final String paramString, final k.b paramb, final byte[] paramArrayOfByte, cc paramcc)
  {
    AppMethodBeat.i(39295);
    Log.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, paramb.hzM });
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.n.bpU(paramb.hzM);
    if (!Util.isNullOrNil(paramb.tpurl)) {
      localObject1 = com.tencent.mm.pluginsdk.model.app.n.g(paramcc, paramb.hzM);
    }
    Object localObject3 = "";
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath != null)
      {
        localObject2 = localObject3;
        if (!((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath.equals(""))
        {
          bh.bCz();
          localObject2 = com.tencent.mm.pluginsdk.model.app.n.aK(com.tencent.mm.model.c.bzT(), paramb.title, paramb.nRe);
          y.O(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, (String)localObject2, false);
          Log.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramb.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).efT()) });
        }
      }
    }
    localObject3 = k.b.a(paramb);
    ((k.b)localObject3).nRg = 3;
    if ((paramcc != null) && (paramb.type == 6) && (!Util.isNullOrNil(paramb.tpurl)) && (localObject1 != null) && ((!y.ZC(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (y.bEl(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
    {
      a((k.b)localObject3, (com.tencent.mm.pluginsdk.model.app.c)localObject1, paramcc, paramString, (String)localObject2, paramArrayOfByte);
      AppMethodBeat.o(39295);
      return;
    }
    if ((Util.isNullOrNil((String)localObject2)) && ((paramb.nRh != 0) || (paramb.nRd > 26214400)))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(paramb.nRh), Integer.valueOf(paramb.nRd) });
      bh.aZW().a(new com.tencent.mm.pluginsdk.h.c(paramb, null, paramString, new c.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
        {
          AppMethodBeat.i(250815);
          Log.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new, errMsg:[%s], md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2, Util.secPrint(paramAnonymousString3), Util.secPrint(paramAnonymousString4), Util.secPrint(paramb.aesKey), Util.secPrint(paramAnonymousString5), Util.secPrint(paramAnonymousString6) });
          if (!Util.isNullOrNil(paramAnonymousString4))
          {
            com.tencent.mm.pluginsdk.model.app.n.a(this.afNq, paramb.appId, paramb.appName, paramString, "", paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this), paramAnonymousString4);
            AppMethodBeat.o(250815);
            return;
          }
          com.tencent.mm.ui.base.k.c(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.l.gDm), "", true);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(250815);
        }
      }), 0);
      AppMethodBeat.o(39295);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.n.a((k.b)localObject3, paramb.appId, paramb.appName, paramString, (String)localObject2, paramArrayOfByte, this.mSessionId);
    if (((k.b)localObject3).type == 36) {
      if (!paramString.endsWith("chatroom")) {
        break label588;
      }
    }
    label588:
    for (int i = 1;; i = 0)
    {
      paramArrayOfByte = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).url));
      paramcc = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).title));
      localObject1 = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).description));
      localObject2 = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).nTC));
      paramb = paramb.nTI;
      com.tencent.mm.plugin.report.service.h.OAn.b(14127, new Object[] { ((k.b)localObject3).appId, ((k.b)localObject3).nTD, localObject2, paramcc, localObject1, "", paramArrayOfByte, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString, Integer.valueOf(1), paramb, "" });
      AppMethodBeat.o(39295);
      return;
    }
  }
  
  private boolean b(final com.tencent.mm.modelvideo.z paramz, final String paramString)
  {
    AppMethodBeat.i(251108);
    if (paramz == null)
    {
      Log.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
      AppMethodBeat.o(251108);
      return false;
    }
    Object localObject = XmlParser.parseXml(paramz.bOu(), "msg", null);
    if (localObject == null)
    {
      Log.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
      AppMethodBeat.o(251108);
      return false;
    }
    final String str1 = (String)((Map)localObject).get(".msg.videomsg.$cdnvideourl");
    if (Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(251108);
      return false;
    }
    final String str2 = (String)((Map)localObject).get(".msg.videomsg.$aeskey");
    final String str3 = (String)((Map)localObject).get(".msg.videomsg.$md5");
    final String str4 = (String)((Map)localObject).get(".msg.videomsg.$newmd5");
    final String str5 = (String)((Map)localObject).get(".msg.videomsg.$cdnrawvideoaeskey");
    final String str6 = (String)((Map)localObject).get(".msg.videomsg.$cdnrawvideourl");
    final String str7 = (String)((Map)localObject).get(".msg.videomsg.$rawmd5");
    final int i = Util.getInt((String)((Map)localObject).get(".msg.videomsg.$rawlength"), 0);
    final int j = Util.getInt((String)((Map)localObject).get(".msg.videomsg.$length"), 0);
    final int k = Util.getInt((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
    final int m = Util.getInt((String)((Map)localObject).get(".msg.videomsg.$cdnthumblength"), 0);
    if (Util.isNullOrNil(str3))
    {
      com.tencent.mm.modelvideo.v.bOh();
      if (!y.ZC(com.tencent.mm.modelvideo.aa.PX(paramz.getFileName())))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1328L, 1L, 1L, true);
        AppMethodBeat.o(251108);
        return false;
      }
    }
    localObject = new com.tencent.mm.g.g();
    ((com.tencent.mm.g.g)localObject).taskName = "task_MsgRetransmitUI_3";
    ((com.tencent.mm.g.g)localObject).lwL = new g.a()
    {
      boolean afNi = false;
      String afNj;
      com.tencent.mm.g.d oZF = null;
      
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(250853);
        if (paramAnonymousd != null)
        {
          if (!paramAnonymousd.field_exist_whencheck) {
            break label928;
          }
          label48:
          long l;
          if (this.afNi)
          {
            paramAnonymousString = str6;
            paramAnonymousd.field_fileId = paramAnonymousString;
            if (!this.afNi) {
              break label701;
            }
            paramAnonymousString = str5;
            paramAnonymousd.field_aesKey = paramAnonymousString;
            paramAnonymousd.field_thumbimgLength = m;
            if (!this.afNi) {
              break label709;
            }
            l = i;
            label77:
            paramAnonymousd.field_fileLength = l;
            paramAnonymousd.field_toUser = paramString;
            if (!this.afNi) {
              break label719;
            }
            paramAnonymousString = str7;
            label105:
            paramAnonymousd.field_filemd5 = paramAnonymousString;
            paramAnonymousd.field_mp4identifymd5 = str4;
            Log.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
            if (this.afNi) {
              break label727;
            }
            paramAnonymousString = com.tencent.mm.modelvideo.aa.PW(paramString);
            this.afNj = paramAnonymousString;
            label156:
            com.tencent.mm.modelvideo.v.bOh();
            paramAnonymousc = com.tencent.mm.modelvideo.aa.PY(paramAnonymousString);
            com.tencent.mm.modelvideo.v.bOh();
            String str = com.tencent.mm.modelvideo.aa.PY(MsgRetransmitUI.this.fileName);
            if (!this.afNi) {
              y.O(str, paramAnonymousc, false);
            }
            paramAnonymousc = "<msg><videomsg aeskey=\"" + str2 + "\" cdnthumbaeskey=\"" + str2 + "\" cdnvideourl=\"" + str1 + "\" ";
            paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + str1 + "\" ";
            paramAnonymousc = paramAnonymousc + "length=\"" + j + "\" ";
            paramAnonymousc = paramAnonymousc + "cdnrawvideourl=\"" + str6 + "\" ";
            paramAnonymousc = paramAnonymousc + "cdnrawvideoaeskey=\"" + str5 + "\" ";
            paramAnonymousc = paramAnonymousc + "rawlength=\"" + i + "\" ";
            paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + m + "\"/></msg>";
            Log.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
            if (this.afNi) {
              break label754;
            }
            com.tencent.mm.modelvideo.ab.b(paramAnonymousString, k, paramString, paramAnonymousc, paramz.pbc);
          }
          for (;;)
          {
            if ((!com.tencent.mm.modelvideo.ab.bOG()) || (Util.isNullOrNil(str6)) || (this.afNi)) {
              break label833;
            }
            paramAnonymousString = new com.tencent.mm.g.g();
            paramAnonymousString.taskName = "task_MsgRetransmitUI_3";
            paramAnonymousString.lwL = this;
            paramAnonymousString.field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), paramString, MsgRetransmitUI.this.msgId);
            paramAnonymousString.field_fileId = str6;
            paramAnonymousString.field_aesKey = str5;
            paramAnonymousString.field_filemd5 = str7;
            paramAnonymousString.field_fileType = 4;
            paramAnonymousString.field_talker = paramString;
            paramAnonymousString.field_priority = com.tencent.mm.g.a.lvZ;
            paramAnonymousString.field_svr_signature = "";
            paramAnonymousString.field_onlycheckexist = true;
            paramAnonymousString.field_trysafecdn = true;
            Log.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { str1, str3, str2, paramz.bOu() });
            this.afNi = com.tencent.mm.modelcdntran.k.bHW().g(paramAnonymousString);
            this.oZF = paramAnonymousd;
            if (!this.afNi) {
              break label833;
            }
            AppMethodBeat.o(250853);
            return 0;
            paramAnonymousString = str1;
            break;
            label701:
            paramAnonymousString = str2;
            break label48;
            label709:
            l = j;
            break label77;
            label719:
            paramAnonymousString = str3;
            break label105;
            label727:
            paramAnonymousString = this.afNj + "origin";
            break label156;
            label754:
            paramAnonymousc = com.tencent.mm.modelvideo.ab.Qo(this.afNj);
            if (paramAnonymousc == null)
            {
              Log.w("MicroMsg.MsgRetransmitUI", "compress video info is null, pls check process");
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(250853);
              return 0;
            }
            paramAnonymousc.PP(paramAnonymousString);
            com.tencent.mm.modelvideo.ab.a(paramAnonymousString, null, k, paramString, null, 0, "", 43, null, "", 0, null, null, true);
            com.tencent.mm.modelvideo.v.bOh().c(paramAnonymousc);
          }
          label833:
          paramAnonymousc = com.tencent.mm.modelimage.t.bKi();
          paramAnonymousc.fileName = this.afNj;
          if (!this.afNi) {
            break label923;
          }
          paramAnonymousString = paramAnonymousd;
          paramAnonymousc.oJL = paramAnonymousString;
          paramAnonymousc.oJI = 0;
          if (this.afNi) {
            paramAnonymousd = this.oZF;
          }
          paramAnonymousc.oJJ = paramAnonymousd;
          paramAnonymousc.oJK = new com.tencent.mm.modelimage.g()
          {
            public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(250930);
              com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(MsgRetransmitUI.17.this.afNj);
              localz.status = 111;
              localz.eQp = 256;
              com.tencent.mm.modelvideo.v.bOh().c(localz);
              Log.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              AppMethodBeat.o(250930);
            }
          };
          paramAnonymousc.oNj = 4;
          paramAnonymousc.bKW().aXz();
          MsgRetransmitUI.this.finish();
        }
        for (;;)
        {
          AppMethodBeat.o(250853);
          return 0;
          label923:
          paramAnonymousString = null;
          break;
          label928:
          if (this.afNi) {
            break label953;
          }
          MsgRetransmitUI.j(MsgRetransmitUI.this);
          Log.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
        }
        label953:
        Log.i("MicroMsg.MsgRetransmitUI", "origin video not support second!! dealDownloadVideo, go ahead normal video");
        if ((this.oZF != null) && (!Util.isNullOrNil(this.afNj)))
        {
          paramAnonymousString = com.tencent.mm.modelimage.t.bKi();
          paramAnonymousString.fileName = this.afNj;
          paramAnonymousString.oJI = 0;
          paramAnonymousString.oJJ = this.oZF;
          paramAnonymousString.oJK = new com.tencent.mm.modelimage.g()
          {
            public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(250921);
              com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(MsgRetransmitUI.17.this.afNj);
              localz.status = 111;
              localz.eQp = 256;
              com.tencent.mm.modelvideo.v.bOh().c(localz);
              Log.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              AppMethodBeat.o(250921);
            }
          };
          paramAnonymousString.oNj = 4;
          paramAnonymousString.bKW().aXz();
        }
        for (;;)
        {
          MsgRetransmitUI.this.finish();
          break;
          Log.w("MicroMsg.MsgRetransmitUI", "temp result is null, some thing wrong in process");
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    ((com.tencent.mm.g.g)localObject).field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), paramString, this.msgId);
    ((com.tencent.mm.g.g)localObject).field_fileId = str1;
    ((com.tencent.mm.g.g)localObject).field_aesKey = str2;
    ((com.tencent.mm.g.g)localObject).field_filemd5 = str3;
    ((com.tencent.mm.g.g)localObject).field_fileType = 4;
    ((com.tencent.mm.g.g)localObject).field_talker = paramString;
    ((com.tencent.mm.g.g)localObject).field_priority = com.tencent.mm.g.a.lvZ;
    ((com.tencent.mm.g.g)localObject).field_svr_signature = "";
    ((com.tencent.mm.g.g)localObject).field_onlycheckexist = true;
    ((com.tencent.mm.g.g)localObject).field_trysafecdn = true;
    Log.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { str1, str3, str2, paramz.bOu() });
    if (!com.tencent.mm.modelcdntran.k.bHW().g((com.tencent.mm.g.g)localObject))
    {
      Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
      finish();
      AppMethodBeat.o(251108);
      return false;
    }
    this.afMF = false;
    finish();
    AppMethodBeat.o(251108);
    return true;
  }
  
  /* Error */
  private static boolean bCF(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc_w 1297
    //   7: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 316
    //   13: ldc_w 1299
    //   16: iconst_1
    //   17: anewarray 496	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: invokestatic 1303	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: new 1305	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 1306	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: iconst_1
    //   51: putfield 1309	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: aconst_null
    //   60: aload 5
    //   62: invokestatic 1315	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: getfield 1318	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: iflt +29 -> 103
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 1321	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: istore_1
    //   86: iload_1
    //   87: iflt +16 -> 103
    //   90: aload 4
    //   92: invokestatic 1325	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   95: ldc_w 1297
    //   98: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload_2
    //   102: ireturn
    //   103: iconst_0
    //   104: istore_2
    //   105: goto -15 -> 90
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_3
    //   111: ldc_w 316
    //   114: ldc_w 1327
    //   117: iconst_1
    //   118: anewarray 496	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: invokestatic 948	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: invokestatic 1325	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   132: ldc_w 1297
    //   135: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_3
    //   142: invokestatic 1325	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   145: ldc_w 1297
    //   148: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: goto -13 -> 141
    //   157: astore_3
    //   158: aload 4
    //   160: astore_3
    //   161: goto -50 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   85	2	1	i	int
    //   3	102	2	bool	boolean
    //   1	79	3	localObject1	Object
    //   108	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   110	32	3	localCloseable	java.io.Closeable
    //   157	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   160	1	3	localObject2	Object
    //   31	128	4	localInputStream	java.io.InputStream
    //   43	38	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   27	33	108	java/io/FileNotFoundException
    //   27	33	140	finally
    //   36	45	140	finally
    //   48	54	140	finally
    //   57	66	140	finally
    //   69	77	140	finally
    //   80	86	140	finally
    //   111	128	153	finally
    //   36	45	157	java/io/FileNotFoundException
    //   48	54	157	java/io/FileNotFoundException
    //   57	66	157	java/io/FileNotFoundException
    //   69	77	157	java/io/FileNotFoundException
    //   80	86	157	java/io/FileNotFoundException
  }
  
  private void bCK(String paramString)
  {
    AppMethodBeat.i(251014);
    tr localtr = new tr();
    localtr.hXt.type = 4;
    tr.a locala = localtr.hXt;
    bh.bCz();
    locala.hTm = com.tencent.mm.model.c.bzD().sl(this.msgId);
    localtr.hXt.toUser = paramString;
    localtr.publish();
    AppMethodBeat.o(251014);
  }
  
  private boolean bCL(String paramString)
  {
    AppMethodBeat.i(251017);
    k.b localb = k.b.Hf(Util.processXml(this.hWn));
    if (localb == null)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(251017);
      return false;
    }
    a(paramString, localb, null, null);
    AppMethodBeat.o(251017);
    return true;
  }
  
  private boolean bCM(final String paramString)
  {
    AppMethodBeat.i(39294);
    final k.b localb = k.b.Hf(Util.processXml(this.hWn));
    Log.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.hWn, localb });
    if (localb == null)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(39294);
      return false;
    }
    if ((localb.type == 53) || (localb.type == 57))
    {
      localObject1 = localb.title;
      com.tencent.mm.model.z.bAM();
      localObject2 = com.tencent.mm.modelmulti.t.OH(paramString);
      ((t.e)localObject2).toUser = paramString;
      ((t.e)localObject2).content = ((String)localObject1);
      paramString = ((t.e)localObject2).wF(com.tencent.mm.model.ab.IX(paramString));
      paramString.eQp = 0;
      paramString.oNj = 4;
      paramString.bKW().aXz();
      AppMethodBeat.o(39294);
      return true;
    }
    bh.bCz();
    final cc localcc = com.tencent.mm.model.c.bzD().sl(this.msgId);
    if (localcc == null)
    {
      AppMethodBeat.o(39294);
      return false;
    }
    if (localcc.iYe())
    {
      if (localb.type == 33) {
        com.tencent.mm.ui.chatting.o.b(paramString, localb, cq.d(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        AppMethodBeat.o(39294);
        return true;
        m.a(this, paramString, this.hWn, localcc.field_isSend, this.isGroupChat);
      }
    }
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool;
    if (this.afMD == null)
    {
      localObject1 = localObject4;
      if (this.aeSs < 0)
      {
        localObject1 = localObject4;
        if (localcc.field_imgPath != null)
        {
          localObject1 = localObject4;
          if (!localcc.field_imgPath.equals(""))
          {
            localObject4 = com.tencent.mm.modelimage.r.bKa().X(localcc.field_imgPath, true);
            localObject1 = localObject2;
            try
            {
              localObject2 = y.bi((String)localObject4, 0, -1);
              localObject1 = localObject2;
              bool = dn((byte[])localObject2);
              localObject1 = localObject2;
              if (!bool)
              {
                AppMethodBeat.o(39294);
                return false;
              }
            }
            catch (Exception localException1)
            {
              Log.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException1.getLocalizedMessage() });
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject4 = (com.tencent.mm.message.a)localb.aK(com.tencent.mm.message.a.class);
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new com.tencent.mm.message.a();
      }
      ((com.tencent.mm.message.a)localObject3).nPl = this.afNc;
      localb.a((com.tencent.mm.message.f)localObject3);
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250833);
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, localb, this.afNp, localcc);
          AppMethodBeat.o(250833);
        }
      }, "MicroMsg.MsgRetransmitUI");
      break;
      try
      {
        localObject3 = y.bi(this.afMD, 0, -1);
        localObject1 = localObject3;
        bool = dn((byte[])localObject3);
        localObject1 = localObject3;
        if (!bool)
        {
          AppMethodBeat.o(39294);
          return false;
        }
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.MsgRetransmitUI", localException2, "", new Object[0]);
        Log.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException2.getLocalizedMessage() });
      }
    }
  }
  
  private void bCN(final String paramString)
  {
    AppMethodBeat.i(251030);
    if (!ah.eb(this))
    {
      com.tencent.mm.ui.base.k.a(this, R.l.video_export_file_warning, R.l.app_tip, R.l.app_ok, R.l.app_cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39279);
          MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), paramString);
          AppMethodBeat.o(39279);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(250806);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(250806);
        }
      });
      AppMethodBeat.o(251030);
      return;
    }
    u(getIntent(), paramString);
    AppMethodBeat.o(251030);
  }
  
  private boolean bCO(String paramString)
  {
    AppMethodBeat.i(251034);
    paramString = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.s.s(paramString, this.fileName, this.length), 1);
    bh.aZW().a(paramString, 0);
    AppMethodBeat.o(251034);
    return true;
  }
  
  private void bCP(String paramString)
  {
    AppMethodBeat.i(251037);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(this.msgId);
    if (((cc)localObject).getType() == 42)
    {
      Log.d("MicroMsg.MsgRetransmitUI", "set forward flag");
      ((cc)localObject).jbW();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.msgId, (cc)localObject);
    }
    int i;
    if (!((cc)localObject).jbC()) {
      if (au.bwO(cc.a.bys(this.hWn).hgk)) {
        i = 66;
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.modelmulti.t.OH(paramString);
      ((t.e)localObject).toUser = paramString;
      ((t.e)localObject).content = this.hWn;
      paramString = ((t.e)localObject).wF(i);
      paramString.eQp = 1;
      paramString.oNj = 4;
      paramString.bKW().aXz();
      AppMethodBeat.o(251037);
      return;
      i = 42;
      continue;
      i = 67;
    }
  }
  
  private void bCQ(final String paramString)
  {
    AppMethodBeat.i(251054);
    if ((this.afML != null) && (this.afML.size() > 0)) {
      this.afMN = this.afML.size();
    }
    this.oHS = new com.tencent.mm.am.i()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, p paramAnonymousp)
      {
        AppMethodBeat.i(250784);
        if ((MsgRetransmitUI.b(MsgRetransmitUI.this) == null) || (paramAnonymousInt2 == 0))
        {
          AppMethodBeat.o(250784);
          return;
        }
        paramAnonymousInt1 = (int)(paramAnonymousInt1 * 100L / paramAnonymousInt2);
        MsgRetransmitUI.b(MsgRetransmitUI.this).setMessage(MsgRetransmitUI.this.getString(R.l.gOe, new Object[] { Integer.valueOf(MsgRetransmitUI.c(MsgRetransmitUI.this)), Integer.valueOf(MsgRetransmitUI.d(MsgRetransmitUI.this)), Integer.valueOf(paramAnonymousInt1) }));
        Log.i("MicroMsg.MsgRetransmitUI", "onSceneProgress: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        AppMethodBeat.o(250784);
      }
    };
    this.afMG = com.tencent.mm.ui.base.k.d(this, getString(R.l.gOe, new Object[] { Integer.valueOf(1), Integer.valueOf(this.afMN), Integer.valueOf(0) }), getString(R.l.app_tip), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(250780);
        if (MsgRetransmitUI.b(MsgRetransmitUI.this) != null) {
          MsgRetransmitUI.b(MsgRetransmitUI.this).cancel();
        }
        AppMethodBeat.o(250780);
      }
    });
    Log.i("MicroMsg.MsgRetransmitUI", "show uploadImgDialog : %s", new Object[] { this.afMG });
    if (this.afMG != null)
    {
      this.afMG.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(250781);
          com.tencent.mm.ui.base.k.a(MsgRetransmitUI.this, R.l.gOb, R.l.app_tip, R.l.app_yes, R.l.app_no, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(250848);
              com.tencent.mm.modelimage.j localj;
              com.tencent.mm.modelimage.h localh;
              if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null)
              {
                bh.aZW().a(MsgRetransmitUI.e(MsgRetransmitUI.this));
                paramAnonymous2Int = (int)MsgRetransmitUI.e(MsgRetransmitUI.this).oHT;
                paramAnonymous2DialogInterface = com.tencent.mm.modelimage.r.bKa().wq(paramAnonymous2Int);
                if (paramAnonymous2DialogInterface != null)
                {
                  localj = com.tencent.mm.modelimage.r.bKa();
                  localh = localj.wq(paramAnonymous2Int);
                  if ((localh != null) && (localh.localId == paramAnonymous2Int)) {
                    break label138;
                  }
                }
              }
              for (;;)
              {
                bh.bCz();
                com.tencent.mm.model.c.bzD().sm(paramAnonymous2DialogInterface.oGz);
                Toast.makeText(MsgRetransmitUI.this, R.l.gOc, 1).show();
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(250848);
                return;
                label138:
                y.deleteFile(localj.v(localh.oGr, "", ""));
                y.deleteFile(localj.v(localh.oGw, "", ""));
                y.deleteFile(localj.v(localh.oGt, "", ""));
                y.deleteFile(localj.v(localh.oGt, "", "") + "hd");
                localj.omV.delete(j.d.iR(paramAnonymous2Int), "id=?", new String[] { String.valueOf(paramAnonymous2Int) });
                if (localh.bJE())
                {
                  localh = localj.wq(localh.oGB);
                  if (localh != null)
                  {
                    y.deleteFile(localj.v(localh.oGr, "", ""));
                    y.deleteFile(localj.v(localh.oGw, "", ""));
                    y.deleteFile(localj.v(localh.oGt, "", ""));
                    y.deleteFile(localj.v(localh.oGt, "", "") + "hd");
                    localj.omV.delete(j.d.iR(paramAnonymous2Int), "id=?", new String[] { localh.localId });
                  }
                }
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(250847);
              if (MsgRetransmitUI.b(MsgRetransmitUI.this) != null) {
                MsgRetransmitUI.b(MsgRetransmitUI.this).show();
              }
              AppMethodBeat.o(250847);
            }
          });
          AppMethodBeat.o(250781);
        }
      });
      this.afMG.setCanceledOnTouchOutside(false);
      this.afMG.aEJ(-1).setText(R.l.app_cancel);
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250774);
        Log.i("MicroMsg.MsgRetransmitUI", "before send image from external");
        MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, MsgRetransmitUI.f(MsgRetransmitUI.this));
        AppMethodBeat.o(250774);
      }
    }, "MicroMsg.MsgRetransmitUI");
    AppMethodBeat.o(251054);
  }
  
  private boolean bCR(String paramString)
  {
    AppMethodBeat.i(251059);
    com.tencent.mm.model.z.bAM();
    t.e locale = com.tencent.mm.modelmulti.t.OH(paramString);
    locale.toUser = paramString;
    locale.content = this.hWn;
    paramString = locale.wF(com.tencent.mm.model.ab.IX(paramString));
    paramString.eQp = 0;
    paramString.oNj = 4;
    paramString.bKW().aXz();
    AppMethodBeat.o(251059);
    return true;
  }
  
  private boolean bCS(String paramString)
  {
    AppMethodBeat.i(251060);
    t.e locale = com.tencent.mm.modelmulti.t.OH(paramString);
    locale.toUser = paramString;
    locale.content = this.hWn;
    paramString = locale.wF(48);
    paramString.eQp = 0;
    paramString.oNj = 4;
    paramString.bKW().aXz();
    AppMethodBeat.o(251060);
    return true;
  }
  
  private void bCT(String paramString)
  {
    AppMethodBeat.i(251062);
    xi localxi = new xi();
    localxi.iaM.hCz = this.msgId;
    localxi.iaM.hOj = this.hWn;
    localxi.iaM.hOk = paramString;
    localxi.publish();
    AppMethodBeat.o(251062);
  }
  
  private boolean bCU(String paramString)
  {
    AppMethodBeat.i(251064);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { paramString });
      k.b localb = k.b.Hf(this.hWn);
      if (localb != null)
      {
        w.a.bwq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(251064);
        return true;
      }
    }
    AppMethodBeat.o(251064);
    return false;
  }
  
  private boolean bCV(String paramString)
  {
    AppMethodBeat.i(251067);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { paramString });
      k.b localb = k.b.Hf(this.hWn);
      if (localb != null)
      {
        w.a.bwq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(251067);
        return true;
      }
    }
    AppMethodBeat.o(251067);
    return false;
  }
  
  private boolean bCW(String paramString)
  {
    AppMethodBeat.i(251069);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { paramString });
      k.b localb = k.b.Hf(this.hWn);
      if (localb != null)
      {
        w.a.bwq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(251069);
        return true;
      }
    }
    AppMethodBeat.o(251069);
    return false;
  }
  
  private boolean bCX(String paramString)
  {
    AppMethodBeat.i(251071);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { paramString });
      Object localObject = k.b.Hf(this.hWn);
      if (localObject != null)
      {
        w.a.bwq().a((k.b)localObject, "", "", paramString, "", null);
        paramString = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject).aK(com.tencent.mm.plugin.findersdk.a.f.class);
        if (paramString != null)
        {
          localObject = new LinkedList();
          ((List)localObject).add(new Pair(paramString.oUc.objectId, paramString.oUc.objectNonceId));
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).shareStatsReport((List)localObject, false);
        }
        AppMethodBeat.o(251071);
        return true;
      }
    }
    AppMethodBeat.o(251071);
    return false;
  }
  
  private boolean bCY(String paramString)
  {
    AppMethodBeat.i(251073);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { paramString });
      Object localObject = k.b.Hf(this.hWn);
      if (localObject != null)
      {
        w.a.bwq().a((k.b)localObject, "", "", paramString, "", null);
        paramString = (com.tencent.mm.plugin.findersdk.a.j)((k.b)localObject).aK(com.tencent.mm.plugin.findersdk.a.j.class);
        if (paramString != null)
        {
          localObject = new LinkedList();
          ((List)localObject).add(new Pair(paramString.oUe.objectId, paramString.oUe.objectNonceId));
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).shareStatsReport((List)localObject, true);
        }
        AppMethodBeat.o(251073);
        return true;
      }
    }
    AppMethodBeat.o(251073);
    return false;
  }
  
  private boolean bCZ(String paramString)
  {
    AppMethodBeat.i(251074);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { paramString });
      k.b localb = k.b.Hf(this.hWn);
      if (localb != null)
      {
        w.a.bwq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(251074);
        return true;
      }
    }
    AppMethodBeat.o(251074);
    return false;
  }
  
  private boolean bDa(String paramString)
  {
    AppMethodBeat.i(251075);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { paramString });
      k.b localb = k.b.Hf(this.hWn);
      if (localb != null)
      {
        w.a.bwq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(251075);
        return true;
      }
    }
    AppMethodBeat.o(251075);
    return false;
  }
  
  private boolean bDb(String paramString)
  {
    AppMethodBeat.i(251077);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { paramString });
      k.b localb = k.b.Hf(this.hWn);
      if (localb != null)
      {
        w.a.bwq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(251077);
        return true;
      }
    }
    AppMethodBeat.o(251077);
    return false;
  }
  
  private boolean bDc(String paramString)
  {
    AppMethodBeat.i(251078);
    if (!Util.isNullOrNil(this.hWn))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "transfer finder poi to %s", new Object[] { paramString });
      k.b localb = k.b.Hf(this.hWn);
      if (localb != null)
      {
        w.a.bwq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(251078);
        return true;
      }
    }
    AppMethodBeat.o(251078);
    return false;
  }
  
  private void bDd(String paramString)
  {
    AppMethodBeat.i(251083);
    if (this.afMF) {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(R.l.has_send));
    }
    Object localObject1 = new Intent();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(this.afMB);
    ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
    ((Intent)localObject1).putExtra("sendResult", 0);
    setResult(-1, (Intent)localObject1);
    if (this.afMZ)
    {
      localObject1 = this.mHandler;
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250775);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(250775);
        }
      };
      if (!this.afMF) {
        break label262;
      }
    }
    label262:
    for (long l = 1800L;; l = 0L)
    {
      ((MMHandler)localObject1).postDelayed((Runnable)localObject2, l);
      if ((this.afME) && (!this.afMS))
      {
        localObject1 = new Intent(this, ChattingUI.class);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("Chat_User", paramString);
        ((Intent)localObject1).putExtra("scene_from", this.fromScene);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(251083);
      return;
    }
  }
  
  private void bDe(final String paramString)
  {
    AppMethodBeat.i(39300);
    Log.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new q(this, null, getIntent(), paramString, 1, new q.a()
    {
      public final void iHX()
      {
        AppMethodBeat.i(250772);
        if (MsgRetransmitUI.g(MsgRetransmitUI.this) != null)
        {
          MsgRetransmitUI.g(MsgRetransmitUI.this).dismiss();
          MsgRetransmitUI.h(MsgRetransmitUI.this);
        }
        if (MsgRetransmitUI.i(MsgRetransmitUI.this) == 1) {
          Toast.makeText(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.l.app_shared), 0).show();
        }
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(250772);
      }
    }, false);
    com.tencent.threadpool.h.ahAA.bm(paramString);
    getString(R.l.app_tip);
    this.lzP = com.tencent.mm.ui.base.k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(250771);
        paramString.iHR();
        MsgRetransmitUI.this.afNe = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(250771);
      }
    });
    AppMethodBeat.o(39300);
  }
  
  private static boolean dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39306);
    Log.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", new Object[] { Byte.valueOf(paramArrayOfByte[0]), Byte.valueOf(paramArrayOfByte[1]), Byte.valueOf(paramArrayOfByte[2]), Byte.valueOf(paramArrayOfByte[3]), Byte.valueOf(paramArrayOfByte[4]) });
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    if ((localOptions.outWidth >= 0) && (localOptions.outHeight >= 0))
    {
      AppMethodBeat.o(39306);
      return true;
    }
    AppMethodBeat.o(39306);
    return false;
  }
  
  private boolean es(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39297);
    if (this.fileName == null)
    {
      AppMethodBeat.o(39297);
      return false;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(this.fileName);
    long l;
    Object localObject1;
    label71:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = y.bEl(this.fileName);
      if (localEmojiInfo != null) {
        break label280;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapUtil.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.k.c.aRh()) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.k.c.aRh())) {
        break label608;
      }
    }
    label280:
    label601:
    label608:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.k.c.aRi()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.getMd5())
        {
          Log.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.afMZ = false;
          this.afMF = false;
          com.tencent.mm.ui.base.k.a(this, getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", getString(R.l.i_know_it), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(250782);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(250782);
            }
          });
          if (this.afMQ == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.b(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.getMd5(), Integer.valueOf(1) });
          }
          AppMethodBeat.o(39297);
          return true;
          l = y.bEl(localEmojiInfo.kMn());
          break;
          localObject1 = localEmojiInfo.kMn();
          break label71;
        }
      }
      if (this.afMQ == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        if (localEmojiInfo == null)
        {
          localObject1 = "";
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), localObject1, Integer.valueOf(1) });
        }
      }
      else
      {
        if (!paramBoolean) {
          break label519;
        }
        if (localEmojiInfo != null) {
          break label601;
        }
        localObject1 = new WXMediaMessage(new WXEmojiObject(this.fileName));
        localObject1 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject1, "");
      }
      for (localObject1 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe((String)localObject1);; localObject1 = localEmojiInfo)
      {
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(2) });
          m.d((EmojiInfo)localObject1, paramString);
        }
        finish();
        AppMethodBeat.o(39297);
        return true;
        localObject1 = localEmojiInfo.getMd5();
        break;
        if ((localEmojiInfo != null) && (l > com.tencent.mm.k.c.aRf()))
        {
          m.d(localEmojiInfo, paramString);
          AppMethodBeat.o(39297);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().y(this, paramString, this.fileName))
        {
          AppMethodBeat.o(39297);
          return true;
        }
        Log.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
        AppMethodBeat.o(39297);
        return false;
      }
    }
  }
  
  private void jDA()
  {
    AppMethodBeat.i(39292);
    switch (this.afMI)
    {
    default: 
      Log.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.afMI) });
      finish();
      AppMethodBeat.o(39292);
      return;
    case 0: 
      jDC();
      AppMethodBeat.o(39292);
      return;
    case 1: 
      jDD();
      AppMethodBeat.o(39292);
      return;
    }
    jDE();
    AppMethodBeat.o(39292);
  }
  
  private boolean jDB()
  {
    AppMethodBeat.i(250977);
    switch (this.msgType)
    {
    case 3: 
    default: 
      Log.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(250977);
            return true;
          } while (jDG());
          finish();
          AppMethodBeat.o(250977);
          return false;
        } while ((this.hWn != null) && (!this.hWn.equals("")));
        Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
        finish();
        AppMethodBeat.o(250977);
        return false;
        finish();
        AppMethodBeat.o(250977);
        return false;
        if (!jDG())
        {
          finish();
          AppMethodBeat.o(250977);
          return false;
        }
      } while (this.fileName != null);
      Log.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
      finish();
      AppMethodBeat.o(250977);
      return false;
    } while ((this.hWn != null) && (!this.hWn.equals("")));
    Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
    finish();
    AppMethodBeat.o(250977);
    return false;
  }
  
  private void jDC()
  {
    AppMethodBeat.i(250992);
    if (!jDB())
    {
      AppMethodBeat.o(250992);
      return;
    }
    boolean bool1 = true;
    if ((this.msgType == 11) || (this.msgType == 1))
    {
      ol(this.afMB);
      if (this.afMP) {
        com.tencent.mm.ui.chatting.n.LU(true);
      }
      AppMethodBeat.o(250992);
      return;
    }
    if (this.msgType == 0) {
      this.afMU = this.afMB.size();
    }
    int i = this.afMB.size();
    c.jg(this.mSessionId, i);
    Object localObject1 = this.afMB.iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      i -= 1;
      boolean bool2;
      if (i == 0)
      {
        bool2 = true;
        label146:
        switch (this.msgType)
        {
        }
      }
      for (;;)
      {
        if (this.afMP) {
          com.tencent.mm.ui.chatting.n.LU(bool2);
        }
        break;
        bool2 = false;
        break label146;
        bh.baH().setHighPriority();
        com.tencent.threadpool.h.ahAA.g(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39258);
            Log.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
            MsgRetransmitUI.a(MsgRetransmitUI.this, this.lzC);
            AppMethodBeat.o(39258);
          }
        }, "MicroMsg.MsgRetransmitUI");
        continue;
        bool1 = bCM((String)localObject2);
        continue;
        bool1 = bCR((String)localObject2);
        continue;
        bool1 = es((String)localObject2, false);
        continue;
        bool1 = bCL((String)localObject2);
        continue;
        bool1 = bCO((String)localObject2);
        continue;
        bCP((String)localObject2);
        continue;
        bool1 = bCS((String)localObject2);
        continue;
        bCK((String)localObject2);
        continue;
        com.tencent.mm.ui.chatting.n.n(this, (String)localObject2, bool2);
        continue;
        com.tencent.mm.ui.chatting.n.m(this, (String)localObject2, bool2);
        continue;
        bCT((String)localObject2);
        continue;
        bool1 = bCX((String)localObject2);
        continue;
        bool1 = bCU((String)localObject2);
        continue;
        bool1 = bCV((String)localObject2);
        continue;
        bool1 = bCZ((String)localObject2);
        continue;
        bool1 = bDa((String)localObject2);
        continue;
        bool1 = bDb((String)localObject2);
        continue;
        bool1 = bCY((String)localObject2);
        continue;
        bool1 = bCW((String)localObject2);
        continue;
        bool1 = bDc((String)localObject2);
      }
    }
    Object localObject3 = (String)this.afMB.get(0);
    switch (this.msgType)
    {
    case 3: 
    case 15: 
    case 17: 
    default: 
      finish();
    case 1: 
    case 11: 
      if (this.msgId != -1L)
      {
        bh.bCz();
        localObject2 = com.tencent.mm.model.c.bzD().sl(this.msgId);
        localObject3 = new jw();
        if (((fi)localObject2).field_isSend != 1) {
          break label1326;
        }
        com.tencent.mm.kernel.h.baC();
        localObject1 = com.tencent.mm.kernel.b.getUserName();
      }
      break;
    }
    for (;;)
    {
      localObject3 = ((jw)localObject3).aIO();
      ((jw)localObject3).iUJ = this.msgId;
      ((jw)localObject3).iUM = ((cc)localObject2).getType();
      ((jw)localObject3).sp((String)localObject1).so(((fi)localObject2).field_talker).bMH();
      AppMethodBeat.o(250992);
      return;
      k.b localb;
      if ((this.msgType == 2) || (this.msgType == 16))
      {
        localb = k.b.Hf(Util.processXml(this.hWn));
        if ((localb != null) && (localb.type == 5) && (!Util.isNullOrNil(localb.url))) {
          localObject1 = "";
        }
      }
      else
      {
        try
        {
          localObject2 = URLEncoder.encode(localb.url, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            i = 2;
          }
        }
        if (bool1)
        {
          i = 1;
          Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localb.url, Long.valueOf(this.startTime), Integer.valueOf(this.afMV), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.afMV), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        if (bool1)
        {
          bDd((String)localObject3);
          break;
          if ((!bool1) && (localb != null) && (localb.type == 33))
          {
            localObject1 = new com.tencent.mm.autogen.a.s();
            ((com.tencent.mm.autogen.a.s)localObject1).hzu.scene = this.afMX;
            ((com.tencent.mm.autogen.a.s)localObject1).hzu.appServiceType = this.afMY;
            if (2 == this.afMX)
            {
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzx = (this.afMW + ":" + this.aeGE);
              label1152:
              if (!((String)localObject3).endsWith("@chatroom")) {
                break label1307;
              }
            }
            label1307:
            for (((com.tencent.mm.autogen.a.s)localObject1).hzu.action = 2;; ((com.tencent.mm.autogen.a.s)localObject1).hzu.action = 1)
            {
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzw = (localb.nTW + 1);
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzy = localb.nTC;
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzv = localb.nTD;
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.appId = localb.nTE;
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.appVersion = localb.nTX;
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzz = "";
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzA = Util.nowSecond();
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzB = 2;
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzD = localb.nTI;
              ((com.tencent.mm.autogen.a.s)localObject1).publish();
              break;
              ((com.tencent.mm.autogen.a.s)localObject1).hzu.hzx = this.afMW;
              break label1152;
            }
          }
        }
      }
      finish();
      break;
      label1326:
      if (au.bwE(localUnsupportedEncodingException.field_talker)) {
        localObject1 = br.JJ(localUnsupportedEncodingException.field_content);
      } else {
        localObject1 = localUnsupportedEncodingException.field_talker;
      }
    }
  }
  
  private void jDD()
  {
    AppMethodBeat.i(251000);
    String str = (String)this.afMB.get(0);
    if (!jDG())
    {
      finish();
      AppMethodBeat.o(251000);
      return;
    }
    switch (this.msgType)
    {
    default: 
      Log.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
      AppMethodBeat.o(251000);
      return;
    case 0: 
      bCQ(str);
      AppMethodBeat.o(251000);
      return;
    case 1: 
    case 11: 
      bCN(str);
      AppMethodBeat.o(251000);
      return;
    }
    es(str, true);
    AppMethodBeat.o(251000);
  }
  
  private void jDE()
  {
    AppMethodBeat.i(251006);
    switch (this.msgType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251006);
      return;
      this.afMB.get(0);
      jDF();
    }
  }
  
  private boolean jDF()
  {
    AppMethodBeat.i(251026);
    String str = getIntent().getExtras().getString("_mmessage_appPackage");
    com.tencent.mm.pluginsdk.model.app.g localg = new com.tencent.mm.pluginsdk.model.app.g();
    localg.field_packageName = str;
    as.gxn().get(localg, new String[] { "packageName" });
    e.a(this, new SendMessageToWX.Req(getIntent().getExtras()).message, localg, new e.a()
    {
      public final void jDI()
      {
        AppMethodBeat.i(250835);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(250835);
      }
    });
    AppMethodBeat.o(251026);
    return true;
  }
  
  private boolean jDG()
  {
    AppMethodBeat.i(39298);
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.aa.j(this, null);
      AppMethodBeat.o(39298);
      return false;
    }
    AppMethodBeat.o(39298);
    return true;
  }
  
  private void jDH()
  {
    AppMethodBeat.i(39308);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250839);
        com.tencent.mm.modelvideo.v.bOm().a(MsgRetransmitUI.this.fileName, new aa.a()
        {
          public final void a(aa.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(250877);
            paramAnonymous2a = com.tencent.mm.modelvideo.ab.Qo(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199))
            {
              paramAnonymous2a = new MsgRetransmitUI.b((byte)0);
              paramAnonymous2a.afNE = new LinkedList();
              paramAnonymous2a.afNE.addAll(MsgRetransmitUI.this.afMB);
              Iterator localIterator = MsgRetransmitUI.this.afMB.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                Log.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", new Object[] { str });
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymous2a, str);
              }
            }
            AppMethodBeat.o(250877);
          }
        });
        AppMethodBeat.o(250839);
      }
    }, "MicroMsg.MsgRetransmitUI");
    this.afMF = false;
    AppMethodBeat.o(39308);
  }
  
  private void jDz()
  {
    AppMethodBeat.i(250965);
    Object localObject = getIntent().getStringExtra("Select_Conv_User");
    String str1 = getIntent().getStringExtra("custom_send_text");
    this.afMB = new ArrayList();
    this.afMB.add(localObject);
    jDA();
    if (!TextUtils.isEmpty(str1))
    {
      localObject = this.afMB.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        wp localwp = new wp();
        localwp.iak.hgl = str2;
        localwp.iak.content = str1;
        localwp.iak.type = com.tencent.mm.model.ab.IX(str2);
        localwp.iak.flags = 0;
        localwp.publish();
      }
    }
    AppMethodBeat.o(250965);
  }
  
  private void ol(List<String> paramList)
  {
    AppMethodBeat.i(251032);
    Log.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
    if ((11 == this.msgType) && (com.tencent.mm.modelvideo.ab.Qp(this.fileName)))
    {
      com.tencent.mm.ui.widget.snackbar.b.a(this, getResources().getString(R.l.sendrequest_send_fail), "", null);
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250813);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(250813);
        }
      }, 1800L);
      AppMethodBeat.o(251032);
      return;
    }
    om(paramList);
    AppMethodBeat.o(251032);
  }
  
  private void om(List<String> paramList)
  {
    AppMethodBeat.i(251099);
    b localb = new b((byte)0);
    localb.afNE = new LinkedList();
    localb.afNE.addAll(paramList);
    com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(this.fileName);
    Object localObject;
    if (localz == null)
    {
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzD().sl(this.msgId);
      if ((localObject != null) && (((cc)localObject).dSI()))
      {
        oo(paramList);
        AppMethodBeat.o(251099);
        return;
      }
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localz != null)
      {
        paramList = localz.getFileName();
        label132:
        if (localz == null) {
          break label200;
        }
      }
      label200:
      for (localObject = Integer.valueOf(localz.status);; localObject = "")
      {
        Log.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { paramList, localObject });
        if ((localz == null) || (localz.status != 199)) {
          break label207;
        }
        a(localb, str);
        break;
        paramList = "";
        break label132;
      }
      label207:
      if (!b(localz, str)) {
        jDH();
      }
    }
    AppMethodBeat.o(251099);
  }
  
  private void oo(List<String> paramList)
  {
    AppMethodBeat.i(39307);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      bCM((String)paramList.next());
    }
    if (this.afMF) {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(R.l.has_send));
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250829);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(250829);
      }
    }, 1800L);
    AppMethodBeat.o(39307);
  }
  
  private void u(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(39299);
    if (this.afMO)
    {
      this.afMN = this.afML.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.afNe) {
            break;
          }
          bDe(paramString);
        }
        AppMethodBeat.o(39299);
        return;
      }
      finish();
      AppMethodBeat.o(39299);
      return;
    }
    this.afMN = 1;
    bDe(paramString);
    AppMethodBeat.o(39299);
  }
  
  public void finish()
  {
    AppMethodBeat.i(39290);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(39290);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39293);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1 = "";
    Object localObject3;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("custom_send_text");
      localObject3 = paramIntent.getStringExtra("Select_Conv_User");
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject3))
      {
        this.afMB = Util.stringsToList(((String)localObject3).split(","));
        localObject1 = localObject2;
      }
    }
    long l;
    if (this.afNa)
    {
      localObject3 = com.tencent.mm.plugin.selectrecord.b.d.gUK();
      localObject2 = this.afMB;
      localObject3 = ((com.tencent.mm.plugin.selectrecord.b.d)localObject3).PmI;
      ((ke)localObject3).iWh = ((ke)localObject3).F("ToUsername", Util.listToString((List)localObject2, ";"), true);
      localObject2 = com.tencent.mm.plugin.selectrecord.b.d.gUK();
      if (Util.isNullOrNil((String)localObject1))
      {
        l = 2L;
        ((com.tencent.mm.plugin.selectrecord.b.d)localObject2).PmI.iWd = l;
      }
    }
    else
    {
      if (paramInt2 == -1) {
        break label594;
      }
      localObject1 = k.b.Hf(Util.processXml(this.hWn));
      if ((localObject1 == null) || (((k.b)localObject1).type != 5) || (((k.b)localObject1).url == null)) {
        break label372;
      }
      Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject1).url, Long.valueOf(this.startTime), Integer.valueOf(this.afMV), Integer.valueOf(1), Integer.valueOf(3) });
      paramIntent = "";
    }
    try
    {
      localObject1 = URLEncoder.encode(((k.b)localObject1).url, "UTF-8");
      paramIntent = (Intent)localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.afMV), Integer.valueOf(1), Integer.valueOf(3) });
    label372:
    while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
    {
      if (this.afNa) {
        com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
      }
      finish();
      AppMethodBeat.o(39293);
      return;
      l = 1L;
      break;
    }
    paramIntent = new com.tencent.mm.autogen.a.s();
    paramIntent.hzu.appServiceType = this.afMY;
    paramIntent.hzu.scene = this.afMX;
    if (2 == this.afMX) {}
    for (paramIntent.hzu.hzx = (this.afMW + ":" + this.aeGE);; paramIntent.hzu.hzx = this.afMW)
    {
      paramIntent.hzu.hzw = (localUnsupportedEncodingException.nTW + 1);
      paramIntent.hzu.hzy = localUnsupportedEncodingException.nTC;
      paramIntent.hzu.hzv = localUnsupportedEncodingException.nTD;
      paramIntent.hzu.appId = localUnsupportedEncodingException.nTE;
      paramIntent.hzu.appVersion = localUnsupportedEncodingException.nTX;
      paramIntent.hzu.action = 1;
      paramIntent.hzu.hzz = "";
      paramIntent.hzu.hzA = Util.nowSecond();
      paramIntent.hzu.hzB = 3;
      paramIntent.hzu.hzD = localUnsupportedEncodingException.nTI;
      paramIntent.publish();
      break;
    }
    label594:
    if (paramInt1 != 0)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(39293);
      return;
    }
    this.Aet = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.Aet) {
      this.vEb = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      Log.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    this.afNc = paramIntent.getBooleanExtra("KSendGroupToDo", false);
    this.afNd = paramIntent.getIntExtra("KShowTodoIntroduceView", 0);
    Log.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.afMI), Integer.valueOf(this.afMB.size()) });
    paramInt1 = this.msgType;
    paramIntent = this.hWn;
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.r.class)).aaA(paramInt1);
    if (localObject2 != null)
    {
      localObject3 = com.tencent.mm.ui.base.w.a(this, getString(R.l.app_waiting), true, 3, null);
      ((com.tencent.mm.plugin.messenger.foundation.a.z)localObject2).a(this, (String)this.afMB.get(0), paramIntent, new z.a() {});
    }
    if (localObject2 != null) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      AppMethodBeat.o(39293);
      return;
    }
    jDA();
    if (!TextUtils.isEmpty(localUnsupportedEncodingException))
    {
      paramIntent = this.afMB.iterator();
      while (paramIntent.hasNext())
      {
        localObject2 = (String)paramIntent.next();
        localObject3 = new wp();
        ((wp)localObject3).iak.hgl = ((String)localObject2);
        ((wp)localObject3).iak.content = localUnsupportedEncodingException;
        ((wp)localObject3).iak.type = com.tencent.mm.model.ab.IX((String)localObject2);
        ((wp)localObject3).iak.flags = 0;
        ((wp)localObject3).publish();
      }
    }
    if (this.afNa)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.d.gUK();
      paramIntent.aiO(1);
      paramIntent.bMH();
    }
    AppMethodBeat.o(39293);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39289);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    aw.g(getWindow());
    this.startTime = Util.nowSecond();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    boolean bool;
    if (getIntent().hasExtra("Retr_Msg_content_bytes"))
    {
      this.hWn = new String(getIntent().getByteArrayExtra("Retr_Msg_content_bytes"));
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      this.afMC = ((ArrayList)getIntent().getSerializableExtra("Retr_Msg_Id_List"));
      this.fileName = getIntent().getStringExtra("Retr_File_Name");
      this.afML = getIntent().getStringArrayListExtra("Retr_File_Path_List");
      if ((this.afML == null) || (this.afML.size() <= 0)) {
        break label953;
      }
      bool = true;
      label163:
      this.afMO = bool;
      this.oGu = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.afMI = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.afMH = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.afMD = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.afME = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.afMS = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.afMI != 0) {
        break label958;
      }
      bool = true;
      label286:
      this.afMT = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.afMT) {
        this.afMS = true;
      }
      this.afMF = getIntent().getBooleanExtra("Retr_show_success_tips", this.afMS);
      this.afMP = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.isGroupChat = getIntent().getBooleanExtra("is_group_chat", false);
      this.pbn = getIntent().getStringExtra("msg_uuid");
      this.aeSs = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.afMQ = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.longtitude = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.latitude = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.oIv = getIntent().getStringExtra("Retr_AttachedContent");
      this.afMR = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.mSessionId = getIntent().getStringExtra("reportSessionId");
      this.afMV = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.aeGE = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.afMW = getIntent().getStringExtra("Retr_MsgTalker");
      this.afMX = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.afMY = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      this.afNa = getIntent().getBooleanExtra("Retr_MsgFromMoreSelectRetransmit", false);
      this.fromScene = getIntent().getIntExtra("scene_from", 0);
      this.afNb = getIntent().getBooleanExtra("Retr_MsgQuickShare", false);
      bh.aZW().a(110, this);
      if (!com.tencent.mm.compatible.util.d.rb(19)) {
        setContentView(R.i.geM);
      }
      if (this.afNb) {
        break label1295;
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.afMT) {
        paramBundle.putExtra("mutil_select_is_ret", true);
      }
      switch (this.msgType)
      {
      case 3: 
      case 4: 
      case 5: 
      case 9: 
      case 10: 
      case 11: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      default: 
        paramBundle.putExtra("Select_Conv_Type", 3);
      }
    }
    for (;;)
    {
      paramBundle.putExtra("Retr_Msg_Type", this.msgType);
      paramBundle.putExtra("Retr_Msg_Id", this.msgId);
      if (!Util.isNullOrNil(this.afMC)) {
        paramBundle.putExtra("Retr_Msg_Id_List", this.afMC);
      }
      if (this.hWn != null) {
        paramBundle.putExtra("Retr_Msg_content_bytes", this.hWn.getBytes());
      }
      paramBundle.putExtra("Retr_Msg_thumb_path", this.afMD);
      paramBundle.putExtra("image_path", this.fileName);
      paramBundle.putExtra("scene_from", this.fromScene);
      startActivityForResult(paramBundle, 0);
      overridePendingTransition(R.a.sight_slide_bottom_in, R.a.anim_not_change);
      AppMethodBeat.o(39289);
      return;
      this.hWn = getIntent().getStringExtra("Retr_Msg_content");
      break;
      label953:
      bool = false;
      break label163;
      label958:
      bool = false;
      break label286;
      paramBundle.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
      if (this.afMV == 3)
      {
        this.fromScene = 3;
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.aeSs);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
      continue;
      bh.bCz();
      cc.a locala = com.tencent.mm.model.c.bzD().aLU(this.hWn);
      if ((locala.hgk == null) || (locala.hgk.length() <= 0)) {
        Log.e("MicroMsg.MsgRetransmitUI", "getView : parse possible friend msg failed");
      }
      if (!com.tencent.mm.model.ab.uY(locala.WAW))
      {
        paramBundle.putExtra("Select_Conv_Type", 7);
        paramBundle.putExtra("search_range", new int[] { 131072 });
        paramBundle.putExtra("mutil_select_is_ret", false);
        paramBundle.putExtra("forward_card", true);
      }
      else
      {
        paramBundle.putExtra("Select_Conv_Type", 3);
        continue;
        if (com.tencent.mm.ui.chatting.n.jpi())
        {
          Log.d("MicroMsg.MsgRetransmitUI", "has can forward card");
          paramBundle.putExtra("Select_Conv_Type", 7);
          paramBundle.putExtra("mutil_select_is_ret", false);
          paramBundle.putExtra("search_range", new int[] { 131072 });
          paramBundle.putExtra("forward_card", true);
        }
        else
        {
          paramBundle.putExtra("Select_Conv_Type", 3);
          continue;
          int i = getIntent().getIntExtra("Select_Conv_Type", 0);
          paramBundle.putExtra("search_range", getIntent().getIntArrayExtra("search_range"));
          paramBundle.putExtra("Select_Conv_Type", i | 0x3);
        }
      }
    }
    label1295:
    jDz();
    AppMethodBeat.o(39289);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39291);
    if (!this.afMK) {
      bh.aZW().b(110, this);
    }
    super.onDestroy();
    AppMethodBeat.o(39291);
  }
  
  @DoNotCheckLeakForActivities
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(39310);
    Log.i("MicroMsg.MsgRetransmitUI", "errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp.getType() != 110) || (!(paramp instanceof com.tencent.mm.modelimage.o)))
    {
      AppMethodBeat.o(39310);
      return;
    }
    paramString = (com.tencent.mm.modelimage.o)paramp;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramp = getIntent().getStringExtra("Retr_KSnsId");
      if (!au.bwE(paramString.hgl)) {
        break label218;
      }
      localObject = new yl();
      ((yl)localObject).ibM.hQX = paramp;
      ((yl)localObject).publish();
    }
    while ((this.afML != null) && (this.afML.size() > 1))
    {
      this.afML.remove(0);
      paramp = paramString.hgl;
      paramString = paramp;
      if (Util.isNullOrNil(paramp))
      {
        paramString = paramp;
        if (this.afMB != null) {
          paramString = (String)this.afMB.get(0);
        }
      }
      a(paramString, 3, this.oHS);
      AppMethodBeat.o(39310);
      return;
      label218:
      localObject = new ym();
      ((ym)localObject).ibN.hQX = paramp;
      ((ym)localObject).publish();
    }
    if (this.afMG != null)
    {
      this.afMG.dismiss();
      Log.i("MicroMsg.MsgRetransmitUI", "uploadImgDialog dismissed : %s", new Object[] { this.afMG.toString() });
      this.afMG = null;
    }
    this.afMU -= 1;
    if ((this.afMU <= 0) || (!this.afMT))
    {
      this.afMK = false;
      bh.aZW().b(110, this);
      if (this.afMI != 0)
      {
        finish();
        if ((this.afME) && (!this.afMS))
        {
          paramp = new Intent(this, ChattingUI.class);
          paramp.addFlags(67108864);
          paramp.putExtra("Chat_User", paramString.hgl);
          paramp.putExtra("scene_from", this.fromScene);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
    AppMethodBeat.o(39310);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends AsyncTask<Object, Object, String>
  {
    public boolean afMF;
    public int afMH;
    public int afNA;
    public d.a afNB;
    private String afNC;
    public boolean afNt;
    public String afNu;
    public boolean afNv;
    public boolean afNw;
    public boolean afNx;
    public fjp afNy;
    public MsgRetransmitUI.b afNz;
    public Context context;
    public String fileName;
    public String iah;
    public String jUr;
    private MMHandler mHandler;
    public int oYP;
    public int omT;
    public String pbn;
    public String pbo;
    public Dialog tipDialog;
    public String userName;
    
    public a()
    {
      AppMethodBeat.i(39285);
      this.afNv = true;
      this.afNw = false;
      this.afMF = false;
      this.afNx = true;
      this.afNy = null;
      this.afNz = null;
      this.mHandler = new MMHandler(Looper.getMainLooper());
      this.afNB = null;
      AppMethodBeat.o(39285);
    }
  }
  
  static final class b
  {
    public List<String> afNE = null;
    boolean hCQ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */