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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.i.d;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.a;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.f.a.vs;
import com.tencent.mm.f.a.ws;
import com.tencent.mm.f.a.wt;
import com.tencent.mm.f.b.a.ia;
import com.tencent.mm.f.c.et;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cp;
import com.tencent.mm.model.v;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.ac.a;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.network.ag;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.z.a;
import com.tencent.mm.pluginsdk.h.c.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
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
  implements com.tencent.mm.an.i
{
  private String WXa;
  private boolean XWA;
  private boolean XWB;
  private boolean XWC;
  private int XWD;
  private int XWE;
  private String XWF;
  private int XWG;
  private int XWH;
  private boolean XWI;
  private boolean XWJ;
  private boolean XWK;
  private int XWL;
  boolean XWM;
  public List<String> XWk;
  private ArrayList<Long> XWl;
  private String XWm;
  private boolean XWn;
  private boolean XWo;
  private com.tencent.mm.ui.widget.a.d XWp;
  private int XWq;
  private int XWr;
  private com.tencent.mm.ay.n XWs;
  private boolean XWt;
  private List<String> XWu;
  private int XWv;
  private int XWw;
  private boolean XWx;
  private boolean XWy;
  private int XWz;
  private int Xim;
  public String fQs;
  public String fileName;
  private int fromScene;
  private ProgressDialog iXX;
  private boolean isGroupChat;
  private int lNK;
  private String lPM;
  private com.tencent.mm.an.j lPi;
  private float latitude;
  private int length;
  private float longtitude;
  private MMHandler mHandler;
  private String mSessionId;
  private String mic;
  public long msgId;
  public int msgType;
  private long startTime;
  long syu;
  private String thumbPath;
  boolean wIf;
  
  public MsgRetransmitUI()
  {
    AppMethodBeat.i(39288);
    this.XWm = null;
    this.XWn = true;
    this.XWo = false;
    this.iXX = null;
    this.lNK = 0;
    this.XWq = 0;
    this.XWr = 0;
    this.XWs = null;
    this.XWt = false;
    this.XWu = null;
    this.lPi = null;
    this.XWv = 0;
    this.XWw = 0;
    this.XWx = false;
    this.XWy = false;
    this.isGroupChat = false;
    this.Xim = -1;
    this.XWB = true;
    this.XWC = true;
    this.XWD = 0;
    this.startTime = 0L;
    this.XWI = true;
    this.XWJ = false;
    this.fromScene = 0;
    this.XWK = false;
    this.XWL = 0;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.XWM = false;
    AppMethodBeat.o(39288);
  }
  
  private void a(final k.b paramb, final com.tencent.mm.pluginsdk.model.app.c paramc, final ca paramca, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39296);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_MsgRetransmitUI_1";
    localg.iUG = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(280974);
        paramc.field_fileFullPath = paramString2;
        if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
        {
          paramc.field_offset = paramAnonymousc.field_finishedLength;
          ao.ctZ().a(paramc, new String[0]);
        }
        if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          paramc.field_status = 199L;
          paramc.field_offset = paramc.field_totalLen;
          ao.ctZ().a(paramc, new String[0]);
          paramca.setStatus(3);
          bh.beI();
          com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
          com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.appId, paramb.appName, paramString1, paramString2, paramArrayOfByte, MsgRetransmitUI.d(MsgRetransmitUI.this));
        }
        AppMethodBeat.o(280974);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    localg.field_mediaId = com.tencent.mm.aq.c.a("checkExist", Util.nowMilliSecond(), paramca.field_talker, paramca.field_msgId);
    localg.field_aesKey = paramb.aesKey;
    localg.field_fileType = 19;
    localg.field_authKey = paramb.lmi;
    localg.iUJ = paramb.lmc;
    localg.field_fullpath = paramString2;
    if (!com.tencent.mm.aq.f.bkg().b(localg, -1)) {
      Log.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
    }
    AppMethodBeat.o(39296);
  }
  
  private void a(b paramb, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(39309);
    Log.printInfoStack("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
    Object localObject = new a();
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(279958);
        this.WEi.XWZ = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(279958);
      }
    });
    ((a)localObject).context = this;
    ((a)localObject).fileName = this.fileName;
    ((a)localObject).tipDialog = this.iXX;
    ((a)localObject).XWq = this.XWq;
    ((a)localObject).lvw = this.length;
    ((a)localObject).mfT = this.msgType;
    ((a)localObject).XXb = false;
    ((a)localObject).userName = paramString;
    ((a)localObject).XXc = true;
    ((a)localObject).XWo = this.XWo;
    ((a)localObject).XXf = paramb;
    paramb = y.Yk(this.fileName);
    if ((paramb != null) && (paramb.mhZ != null))
    {
      Log.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((a)localObject).XXe = paramb.mhZ;
      ((a)localObject).hxy = paramb.bqM();
      ((a)localObject).XXg = paramb.mhR;
    }
    ((a)localObject).execute(new Object[0]);
    cg.bfp().e(cg.lvL, null);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(39309);
      return;
    }
    bh.beI();
    ca localca = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    boolean bool = ab.Lj(paramString);
    if (bool)
    {
      paramb = a.c.Wwj;
      if (!this.XWA) {
        break label319;
      }
    }
    label319:
    for (localObject = a.d.Wwn;; localObject = a.d.Wwm)
    {
      if (bool) {
        i = v.Pu(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localca, i);
      AppMethodBeat.o(39309);
      return;
      paramb = a.c.Wwi;
      break;
    }
  }
  
  private void a(String paramString, int paramInt, com.tencent.mm.an.j paramj)
  {
    AppMethodBeat.i(39301);
    String str2 = com.tencent.mm.model.z.bcZ();
    bh.beI();
    ca localca = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    if (localca.field_msgId == this.msgId)
    {
      String str1 = localca.field_content;
      Object localObject1 = null;
      if (localca.field_msgId > 0L) {
        localObject1 = com.tencent.mm.ay.q.bmh().D(localca.field_talker, localca.field_msgId);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.ay.g)localObject1).localId > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localca.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.ay.q.bmh().C(localca.field_talker, localca.field_msgSvrId);
        }
      }
      localObject1 = str1;
      if (Util.isNullOrNil(str1))
      {
        localObject1 = str1;
        if (localca.field_msgSvrId > 0L) {
          localObject1 = ((com.tencent.mm.ay.g)localObject2).lNS;
        }
      }
      if ((localObject2 != null) && ((((com.tencent.mm.ay.g)localObject2).offset < ((com.tencent.mm.ay.g)localObject2).lAW) || (((com.tencent.mm.ay.g)localObject2).lAW == 0)) && (!this.XWx))
      {
        paramj = com.tencent.mm.ay.q.bmh().C(localca.field_talker, localca.field_msgSvrId);
        if (!a(paramj, localca, (String)localObject1, paramInt, paramString, str2)) {
          b(paramj, localca, (String)localObject1, paramInt, paramString, str2);
        }
        AppMethodBeat.o(39301);
        return;
      }
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.ay.g)localObject2).localId;; l = -1L)
      {
        a(paramString, paramInt, str2, (String)localObject1, paramj, l);
        AppMethodBeat.o(39301);
        return;
      }
    }
    a(paramString, paramInt, str2, "", paramj, -1L);
    AppMethodBeat.o(39301);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.an.j paramj, long paramLong)
  {
    AppMethodBeat.i(39304);
    o.e locale;
    if (!Util.isNullOrNil(this.fileName))
    {
      this.XWv = 1;
      this.XWw = 1;
      if (!bAH(this.fileName))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.lNK == 1) && (!com.tencent.mm.model.z.f(this.fileName, paramString1, false))) {
        this.lNK = 0;
      }
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 96L, 1L, false);
      locale = com.tencent.mm.modelmulti.o.a(o.d.lUk).wb(paramInt);
      locale.fLi = paramString2;
      locale.toUser = paramString1;
      locale.lPO = this.fileName;
      locale.lNK = this.lNK;
      locale.lUr = paramj;
      locale.fJu = 0;
      locale.lNS = paramString3;
      locale.thumbPath = "";
      locale.lUu = true;
      locale.lUt = R.g.chat_img_template;
      locale.lUz = true;
      locale.lUA = this.XWz;
      locale.longitude = this.longtitude;
      locale.latitude = this.latitude;
      locale.lPM = this.lPM;
      locale.lUw = paramLong;
      locale.lUv = this.msgId;
      locale.lUx = this.mic;
      if (this.XWr == 1) {}
      for (bool = true;; bool = false)
      {
        locale.jYb = bool;
        locale.lUq = 19;
        paramString1 = locale.bnl();
        this.XWs = ((com.tencent.mm.ay.n)paramString1.lUi);
        paramString1.aEv();
        this.XWt = true;
        Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.lNK) });
        cg.bfp().e(cg.lvK, null);
        AppMethodBeat.o(39304);
        return;
      }
    }
    if (this.XWx)
    {
      this.XWv += 1;
      if (!bAH((String)this.XWu.get(0)))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.lNK == 1) && (!com.tencent.mm.model.z.f((String)this.XWu.get(0), paramString1, false))) {
        this.lNK = 0;
      }
      Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.lNK) });
      locale = com.tencent.mm.modelmulti.o.a(o.d.lUk).wb(paramInt);
      locale.fLi = paramString2;
      locale.toUser = paramString1;
      locale.lPO = ((String)this.XWu.get(0));
      locale.lNK = this.lNK;
      locale.lUr = paramj;
      locale.fJu = 0;
      locale.lNS = paramString3;
      locale.thumbPath = "";
      locale.lUu = true;
      locale.lUt = R.g.chat_img_template;
      if (this.XWr != 1) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      locale.jYb = bool;
      locale.lUq = 11;
      paramString1 = locale.bnl();
      this.XWs = ((com.tencent.mm.ay.n)paramString1.lUi);
      this.XWt = true;
      paramString1.aEv();
      cg.bfp().e(cg.lvK, null);
      AppMethodBeat.o(39304);
      return;
    }
  }
  
  private void a(final String paramString, final k.b paramb, final byte[] paramArrayOfByte, ca paramca)
  {
    AppMethodBeat.i(39295);
    Log.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, paramb.fvr });
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.m.bqf(paramb.fvr);
    if (!Util.isNullOrNil(paramb.lmc)) {
      localObject1 = com.tencent.mm.pluginsdk.model.app.m.e(paramca, paramb.fvr);
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
          bh.beI();
          localObject2 = com.tencent.mm.pluginsdk.model.app.m.aw(com.tencent.mm.model.c.bce(), paramb.title, paramb.llY);
          u.on(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, (String)localObject2);
          Log.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramb.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).evg()) });
        }
      }
    }
    localObject3 = k.b.a(paramb);
    ((k.b)localObject3).lma = 3;
    if ((paramca != null) && (paramb.type == 6) && (!Util.isNullOrNil(paramb.lmc)) && (localObject1 != null) && ((!u.agG(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (u.bBQ(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
    {
      a((k.b)localObject3, (com.tencent.mm.pluginsdk.model.app.c)localObject1, paramca, paramString, (String)localObject2, paramArrayOfByte);
      AppMethodBeat.o(39295);
      return;
    }
    if ((Util.isNullOrNil((String)localObject2)) && ((paramb.lmb != 0) || (paramb.llX > 26214400)))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(paramb.lmb), Integer.valueOf(paramb.llX) });
      bh.aGY().a(new com.tencent.mm.pluginsdk.h.c(paramb, null, paramString, new c.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
        {
          AppMethodBeat.i(279253);
          Log.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new, errMsg:[%s], md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2, Util.secPrint(paramAnonymousString3), Util.secPrint(paramAnonymousString4), Util.secPrint(paramb.aesKey), Util.secPrint(paramAnonymousString5), Util.secPrint(paramAnonymousString6) });
          if (!Util.isNullOrNil(paramAnonymousString4))
          {
            com.tencent.mm.pluginsdk.model.app.m.a(this.XWW, paramb.appId, paramb.appName, paramString, "", paramArrayOfByte, MsgRetransmitUI.d(MsgRetransmitUI.this), paramAnonymousString4);
            AppMethodBeat.o(279253);
            return;
          }
          com.tencent.mm.ui.base.h.c(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.l.eAt), "", true);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(279253);
        }
      }), 0);
      AppMethodBeat.o(39295);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.m.a((k.b)localObject3, paramb.appId, paramb.appName, paramString, (String)localObject2, paramArrayOfByte, this.mSessionId);
    if (((k.b)localObject3).type == 36) {
      if (!paramString.endsWith("chatroom")) {
        break label587;
      }
    }
    label587:
    for (int i = 1;; i = 0)
    {
      paramArrayOfByte = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).url));
      paramca = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).title));
      localObject1 = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).description));
      localObject2 = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).loz));
      paramb = paramb.loF;
      com.tencent.mm.plugin.report.service.h.IzE.a(14127, new Object[] { ((k.b)localObject3).appId, ((k.b)localObject3).loA, localObject2, paramca, localObject1, "", paramArrayOfByte, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString, Integer.valueOf(1), paramb, "" });
      AppMethodBeat.o(39295);
      return;
    }
  }
  
  private boolean a(final com.tencent.mm.ay.g paramg, final ca paramca, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39302);
    Object localObject = XmlParser.parseXml(paramg.lNS, "msg", null);
    if (localObject == null)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.lNS });
      AppMethodBeat.o(39302);
      return false;
    }
    final int j = paramg.lNK;
    String str1;
    if (j != 1) {
      str1 = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
    }
    for (final int i = 2;; i = 1)
    {
      Log.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), str1 });
      if (!Util.isNullOrNil(str1)) {
        break;
      }
      Log.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(39302);
      return false;
      str1 = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    }
    String str2 = (String)((Map)localObject).get(".msg.img.$aeskey");
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
      AppMethodBeat.o(39302);
      return false;
    }
    if (Util.isNullOrNil(com.tencent.mm.aq.c.a("downimg", paramg.createTime, paramca.field_talker, paramca.field_msgId)))
    {
      Log.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(paramca.field_msgSvrId) });
      AppMethodBeat.o(39302);
      return false;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$md5");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_MsgRetransmitUI_2";
    localg.iUG = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(222723);
        if (paramAnonymousd != null)
        {
          if (!paramAnonymousd.field_exist_whencheck) {
            break label78;
          }
          Log.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymousd, paramca, paramInt, paramString2, paramString3, paramString1, this.lQU, j);
        }
        for (;;)
        {
          AppMethodBeat.o(222723);
          return 0;
          label78:
          Log.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramg, paramca, paramString1, paramInt, paramString2, paramString3);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    localg.field_mediaId = com.tencent.mm.aq.c.a("checkExist", Util.nowMilliSecond(), paramString2, paramca.field_msgId);
    localg.field_fileId = str1;
    localg.field_aesKey = str2;
    localg.field_filemd5 = ((String)localObject);
    localg.field_fileType = i;
    localg.field_talker = paramString2;
    localg.field_priority = com.tencent.mm.i.a.iTU;
    localg.field_svr_signature = "";
    localg.field_onlycheckexist = true;
    localg.field_trysafecdn = true;
    if (!com.tencent.mm.aq.f.bkg().f(localg))
    {
      Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
      AppMethodBeat.o(39302);
      return false;
    }
    AppMethodBeat.o(39302);
    return true;
  }
  
  private void b(com.tencent.mm.ay.g paramg, ca paramca, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39303);
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = paramg.lNK;
    long l1 = com.tencent.mm.ay.q.bmh().a(paramca.field_talker, this.fileName, i, paramInt, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.ay.g localg = com.tencent.mm.ay.q.bmh().b(Long.valueOf(l1));
    localg.wj(1);
    ca localca = new ca();
    localca.setType(ab.Ra(paramString2));
    localca.Jm(paramString2);
    localca.pJ(1);
    localca.setStatus(1);
    localca.Jn(((PString)localObject).value);
    localca.pW(localPInt1.value);
    localca.pX(localPInt2.value);
    localca.setCreateTime(bq.RP(localca.field_talker));
    if (com.tencent.mm.ao.g.KI(localca.field_talker)) {
      paramca.Ip(com.tencent.mm.ao.a.e.apc());
    }
    bh.beI();
    long l2 = com.tencent.mm.model.c.bbO().aM(localca);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      localg.GE((int)l2);
      com.tencent.mm.ay.q.bmh().a(Long.valueOf(l1), localg);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), paramg);
      com.tencent.mm.ay.q.bmi().a(paramg.localId, paramca.field_msgId, i, localObject, R.g.chat_img_template, new com.tencent.mm.ay.e.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.an.q paramAnonymousq) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(229142);
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
              paramAnonymousq = (Map.Entry)paramAnonymousObject.next();
              paramAnonymousString = (Long)paramAnonymousq.getKey();
              paramAnonymousq = (com.tencent.mm.ay.g)paramAnonymousq.getValue();
              MsgRetransmitUI.this.fileName = com.tencent.mm.ay.q.bmh().r(com.tencent.mm.ay.h.c(paramAnonymousq), "", "");
              if (paramAnonymousInt1 != 0)
              {
                bh.beI();
                com.tencent.mm.model.c.bbO().Or(paramAnonymousString.longValue());
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramString2, paramInt, paramString3, paramString1, MsgRetransmitUI.l(MsgRetransmitUI.this), paramAnonymousLong1);
              }
            }
          }
          AppMethodBeat.o(229142);
        }
      });
      AppMethodBeat.o(39303);
      return;
    }
  }
  
  /* Error */
  private static boolean bAH(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc_w 1228
    //   7: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 310
    //   13: ldc_w 1230
    //   16: iconst_1
    //   17: anewarray 324	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 663	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: invokestatic 1234	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: new 1236	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 1237	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: iconst_1
    //   51: putfield 1240	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: aconst_null
    //   60: aload 5
    //   62: invokestatic 1246	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: getfield 1249	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: iflt +29 -> 103
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 1252	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: istore_1
    //   86: iload_1
    //   87: iflt +16 -> 103
    //   90: aload 4
    //   92: invokestatic 1256	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   95: ldc_w 1228
    //   98: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload_2
    //   102: ireturn
    //   103: iconst_0
    //   104: istore_2
    //   105: goto -15 -> 90
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_3
    //   111: ldc_w 310
    //   114: ldc_w 1258
    //   117: iconst_1
    //   118: anewarray 324	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: invokestatic 1145	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: invokestatic 1256	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   132: ldc_w 1228
    //   135: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_3
    //   142: invokestatic 1256	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   145: ldc_w 1228
    //   148: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private boolean bAL(final String paramString)
  {
    AppMethodBeat.i(39294);
    final k.b localb = k.b.OQ(Util.processXml(this.fQs));
    Log.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.fQs, localb });
    if (localb == null)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(39294);
      return false;
    }
    if ((localb.type == 53) || (localb.type == 57))
    {
      localObject1 = localb.title;
      com.tencent.mm.model.z.bcZ();
      localObject2 = com.tencent.mm.modelmulti.o.WI(paramString);
      ((o.e)localObject2).toUser = paramString;
      ((o.e)localObject2).content = ((String)localObject1);
      paramString = ((o.e)localObject2).wD(ab.QZ(paramString));
      paramString.cUP = 0;
      paramString.lUq = 4;
      paramString.bnl().aEv();
      AppMethodBeat.o(39294);
      return true;
    }
    bh.beI();
    final ca localca = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    if (localca.hwA())
    {
      if (localb.type == 33) {
        com.tencent.mm.ui.chatting.m.b(paramString, localb, cp.d(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        AppMethodBeat.o(39294);
        return true;
        com.tencent.mm.ui.chatting.k.a(this, paramString, this.fQs, localca.field_isSend, this.isGroupChat);
      }
    }
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool;
    if (this.XWm == null)
    {
      localObject1 = localObject4;
      if (this.Xim < 0)
      {
        localObject1 = localObject4;
        if (localca.field_imgPath != null)
        {
          localObject1 = localObject4;
          if (!localca.field_imgPath.equals(""))
          {
            localObject4 = com.tencent.mm.ay.q.bmh().T(localca.field_imgPath, true);
            localObject1 = localObject2;
            try
            {
              localObject2 = u.aY((String)localObject4, 0, -1);
              localObject1 = localObject2;
              bool = dl((byte[])localObject2);
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
      localObject4 = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new com.tencent.mm.aj.a();
      }
      ((com.tencent.mm.aj.a)localObject3).lkz = this.XWK;
      localb.a((com.tencent.mm.aj.f)localObject3);
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219608);
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, localb, this.XWV, localca);
          AppMethodBeat.o(219608);
        }
      }, "MicroMsg.MsgRetransmitUI");
      break;
      try
      {
        localObject3 = u.aY(this.XWm, 0, -1);
        localObject1 = localObject3;
        bool = dl((byte[])localObject3);
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
  
  private void bAM(String paramString)
  {
    AppMethodBeat.i(290720);
    if (this.XWo) {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.l.has_send));
    }
    Object localObject1 = new Intent();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(this.XWk);
    ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
    ((Intent)localObject1).putExtra("sendResult", 0);
    setResult(-1, (Intent)localObject1);
    if (this.XWI)
    {
      localObject1 = this.mHandler;
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(282268);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(282268);
        }
      };
      if (!this.XWo) {
        break label262;
      }
    }
    label262:
    for (long l = 1800L;; l = 0L)
    {
      ((MMHandler)localObject1).postDelayed((Runnable)localObject2, l);
      if ((this.XWn) && (!this.XWB))
      {
        localObject1 = new Intent(this, ChattingUI.class);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("Chat_User", paramString);
        ((Intent)localObject1).putExtra("scene_from", this.fromScene);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(290720);
      return;
    }
  }
  
  private void bAN(final String paramString)
  {
    AppMethodBeat.i(39300);
    Log.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new com.tencent.mm.pluginsdk.model.o(this, null, getIntent(), paramString, 1, new com.tencent.mm.pluginsdk.model.o.a()
    {
      public final void hgY()
      {
        AppMethodBeat.i(273327);
        if (MsgRetransmitUI.i(MsgRetransmitUI.this) != null)
        {
          MsgRetransmitUI.i(MsgRetransmitUI.this).dismiss();
          MsgRetransmitUI.j(MsgRetransmitUI.this);
        }
        if (MsgRetransmitUI.k(MsgRetransmitUI.this) == 1) {
          Toast.makeText(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.l.app_shared), 0).show();
        }
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(273327);
      }
    });
    com.tencent.e.h.ZvG.be(paramString);
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(271898);
        paramString.hgS();
        MsgRetransmitUI.this.XWM = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(271898);
      }
    });
    AppMethodBeat.o(39300);
  }
  
  private boolean dG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39297);
    if (this.fileName == null)
    {
      AppMethodBeat.o(39297);
      return false;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(this.fileName);
    long l;
    Object localObject1;
    label71:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = u.bBQ(this.fileName);
      if (localEmojiInfo != null) {
        break label280;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapUtil.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.n.c.awH()) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.n.c.awH())) {
        break label608;
      }
    }
    label280:
    label601:
    label608:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.n.c.awI()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.getMd5())
        {
          Log.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.XWI = false;
          this.XWo = false;
          com.tencent.mm.ui.base.h.a(this, getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", getString(R.l.i_know_it), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(288800);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(288800);
            }
          });
          if (this.XWz == 1) {
            com.tencent.mm.plugin.report.service.h.IzE.a(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.getMd5(), Integer.valueOf(1) });
          }
          AppMethodBeat.o(39297);
          return true;
          l = u.bBQ(localEmojiInfo.ifh());
          break;
          localObject1 = localEmojiInfo.ifh();
          break label71;
        }
      }
      if (this.XWz == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        if (localEmojiInfo == null)
        {
          localObject1 = "";
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), localObject1, Integer.valueOf(1) });
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
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject1, "");
      }
      for (localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud((String)localObject1);; localObject1 = localEmojiInfo)
      {
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(2) });
          com.tencent.mm.ui.chatting.k.d((EmojiInfo)localObject1, paramString);
        }
        finish();
        AppMethodBeat.o(39297);
        return true;
        localObject1 = localEmojiInfo.getMd5();
        break;
        if ((localEmojiInfo != null) && (l > com.tencent.mm.n.c.awF()))
        {
          com.tencent.mm.ui.chatting.k.d(localEmojiInfo, paramString);
          AppMethodBeat.o(39297);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().x(this, paramString, this.fileName))
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
  
  private static boolean dl(byte[] paramArrayOfByte)
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
  
  private void hYP()
  {
    AppMethodBeat.i(39292);
    label181:
    Object localObject6;
    switch (this.XWr)
    {
    default: 
      Log.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.XWr) });
      finish();
      AppMethodBeat.o(39292);
      return;
    case 0: 
      boolean bool3;
      switch (this.msgType)
      {
      case 3: 
      default: 
        Log.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
      case 2: 
      case 6: 
      case 10: 
      case 12: 
      case 13: 
      case 14: 
      case 16: 
        i = 1;
        if (i == 0) {
          break label2860;
        }
        bool3 = true;
        if ((this.msgType != 11) && (this.msgType != 1)) {
          break label1088;
        }
        localObject1 = this.XWk;
        Log.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
        if ((11 == this.msgType) && (y.Yl(this.fileName)))
        {
          com.tencent.mm.ui.widget.snackbar.b.a(this, getResources().getString(R.l.sendrequest_send_fail), "", null);
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(274931);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(274931);
            }
          }, 1800L);
        }
        break;
      }
      do
      {
        for (;;)
        {
          if (this.XWy) {
            l.Gh(true);
          }
          AppMethodBeat.o(39292);
          return;
          if (hYQ()) {
            break;
          }
          finish();
          i = 0;
          break label181;
          if ((this.fQs != null) && (!this.fQs.equals(""))) {
            break;
          }
          Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          finish();
          i = 0;
          break label181;
          if (!hYQ())
          {
            finish();
            i = 0;
            break label181;
          }
          if (this.fileName != null) {
            break;
          }
          Log.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
          finish();
          i = 0;
          break label181;
          if ((this.fQs != null) && (!this.fQs.equals(""))) {
            break;
          }
          Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          localObject3 = new b((byte)0);
          ((b)localObject3).XXj = new LinkedList();
          ((b)localObject3).XXj.addAll((Collection)localObject1);
          localObject4 = y.Yk(this.fileName);
          if (localObject4 != null) {
            break label516;
          }
          bh.beI();
          if (!com.tencent.mm.model.c.bbO().Oq(this.msgId).dlS()) {
            break label516;
          }
          kT((List)localObject1);
        }
        localObject5 = ((List)localObject1).iterator();
      } while (!((Iterator)localObject5).hasNext());
      localObject6 = (String)((Iterator)localObject5).next();
      if (localObject4 != null)
      {
        localObject1 = ((com.tencent.mm.modelvideo.w)localObject4).getFileName();
        if (localObject4 == null) {
          break label632;
        }
      }
      for (Object localObject2 = Integer.valueOf(((com.tencent.mm.modelvideo.w)localObject4).status);; localObject2 = "")
      {
        Log.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { localObject1, localObject2 });
        if ((localObject4 == null) || (((com.tencent.mm.modelvideo.w)localObject4).status != 199)) {
          break label640;
        }
        a((b)localObject3, (String)localObject6);
        break;
        localObject1 = "";
        break label559;
      }
      if (localObject4 == null)
      {
        Log.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
        i = 0;
      }
      final int j;
      while (i == 0)
      {
        hYR();
        break;
        Object localObject7 = XmlParser.parseXml(((com.tencent.mm.modelvideo.w)localObject4).bqO(), "msg", null);
        if (localObject7 == null)
        {
          Log.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
          i = 0;
        }
        else
        {
          localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
          if (Util.isNullOrNil((String)localObject1))
          {
            i = 0;
          }
          else
          {
            localObject2 = (String)((Map)localObject7).get(".msg.videomsg.$aeskey");
            final String str1 = (String)((Map)localObject7).get(".msg.videomsg.$md5");
            final String str2 = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
            i = Util.getInt((String)((Map)localObject7).get(".msg.videomsg.$length"), 0);
            j = Util.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
            final int k = Util.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
            if (Util.isNullOrNil(str1))
            {
              com.tencent.mm.modelvideo.s.bqB();
              if (!u.agG(x.XT(((com.tencent.mm.modelvideo.w)localObject4).getFileName())))
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1328L, 1L, 1L, true);
                i = 0;
                continue;
              }
            }
            localObject7 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject7).taskName = "task_MsgRetransmitUI_3";
            ((com.tencent.mm.i.g)localObject7).iUG = new g.a()
            {
              public final int a(final String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(275887);
                if (paramAnonymousd != null)
                {
                  if (!paramAnonymousd.field_exist_whencheck) {
                    break label375;
                  }
                  paramAnonymousd.field_fileId = this.val$url;
                  paramAnonymousd.field_aesKey = this.Qlb;
                  paramAnonymousd.field_thumbimgLength = k;
                  paramAnonymousd.field_fileLength = i;
                  paramAnonymousd.field_toUser = this.ffX;
                  paramAnonymousd.field_filemd5 = str1;
                  paramAnonymousd.field_mp4identifymd5 = str2;
                  Log.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
                  paramAnonymousString = x.XS(this.ffX);
                  com.tencent.mm.modelvideo.s.bqB();
                  paramAnonymousc = x.XU(paramAnonymousString);
                  com.tencent.mm.modelvideo.s.bqB();
                  u.on(x.XU(MsgRetransmitUI.this.fileName), paramAnonymousc);
                  paramAnonymousc = "<msg><videomsg aeskey=\"" + this.Qlb + "\" cdnthumbaeskey=\"" + this.Qlb + "\" cdnvideourl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
                  Log.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
                  y.b(paramAnonymousString, j, this.ffX, paramAnonymousc, this.mgz.mhR);
                  paramAnonymousc = com.tencent.mm.ay.s.bmp();
                  paramAnonymousc.fileName = paramAnonymousString;
                  paramAnonymousc.lQY = 0;
                  paramAnonymousc.lQZ = paramAnonymousd;
                  paramAnonymousc.lRa = new com.tencent.mm.ay.f()
                  {
                    public final void dN(int paramAnonymous2Int1, int paramAnonymous2Int2)
                    {
                      AppMethodBeat.i(288155);
                      com.tencent.mm.modelvideo.w localw = y.Yk(paramAnonymousString);
                      localw.status = 111;
                      localw.cUP = 256;
                      com.tencent.mm.modelvideo.s.bqB().c(localw);
                      Log.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                      AppMethodBeat.o(288155);
                    }
                  };
                  paramAnonymousc.lUq = 4;
                  paramAnonymousc.bnl().aEv();
                  MsgRetransmitUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(275887);
                  return 0;
                  label375:
                  Log.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                  MsgRetransmitUI.m(MsgRetransmitUI.this);
                }
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            ((com.tencent.mm.i.g)localObject7).field_mediaId = com.tencent.mm.aq.c.a("checkExist", Util.nowMilliSecond(), (String)localObject6, this.msgId);
            ((com.tencent.mm.i.g)localObject7).field_fileId = ((String)localObject1);
            ((com.tencent.mm.i.g)localObject7).field_aesKey = ((String)localObject2);
            ((com.tencent.mm.i.g)localObject7).field_filemd5 = str1;
            ((com.tencent.mm.i.g)localObject7).field_fileType = 4;
            ((com.tencent.mm.i.g)localObject7).field_talker = ((String)localObject6);
            ((com.tencent.mm.i.g)localObject7).field_priority = com.tencent.mm.i.a.iTU;
            ((com.tencent.mm.i.g)localObject7).field_svr_signature = "";
            ((com.tencent.mm.i.g)localObject7).field_onlycheckexist = true;
            ((com.tencent.mm.i.g)localObject7).field_trysafecdn = true;
            Log.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { localObject1, str1, localObject2, ((com.tencent.mm.modelvideo.w)localObject4).bqO() });
            if (!com.tencent.mm.aq.f.bkg().f((com.tencent.mm.i.g)localObject7))
            {
              Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
              finish();
              i = 0;
            }
            else
            {
              this.XWo = false;
              finish();
              i = 1;
            }
          }
        }
      }
      if (this.msgType == 0) {
        this.XWD = this.XWk.size();
      }
      final int i = this.XWk.size();
      c.hW(this.mSessionId, i);
      localObject1 = this.XWk.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        j = i - 1;
        boolean bool2;
        boolean bool1;
        if (j == 0)
        {
          bool2 = true;
          bool1 = bool3;
        }
        switch (this.msgType)
        {
        default: 
        case 1: 
        case 3: 
        case 11: 
        case 15: 
        case 17: 
        case 0: 
          for (bool1 = bool3;; bool1 = bool3)
          {
            if (this.XWy) {
              l.Gh(bool2);
            }
            i = j;
            bool3 = bool1;
            break;
            bool2 = false;
            break label1170;
            bh.aHJ().setHighPriority();
            com.tencent.e.h.ZvG.d(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(39258);
                Log.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                MsgRetransmitUI.a(MsgRetransmitUI.this, this.iXG);
                AppMethodBeat.o(39258);
              }
            }, "MicroMsg.MsgRetransmitUI");
          }
        case 2: 
        case 16: 
        case 19: 
          bool1 = bAL((String)localObject2);
        }
        for (;;)
        {
          break;
          com.tencent.mm.model.z.bcZ();
          localObject3 = com.tencent.mm.modelmulti.o.WI((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.fQs;
          localObject2 = ((o.e)localObject3).wD(ab.QZ((String)localObject2));
          ((o.e)localObject2).cUP = 0;
          ((o.e)localObject2).lUq = 4;
          ((o.e)localObject2).bnl().aEv();
          bool1 = true;
          continue;
          bool1 = dG((String)localObject2, false);
          continue;
          localObject3 = k.b.OQ(Util.processXml(this.fQs));
          if (localObject3 == null) {
            Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
          }
          for (bool1 = false;; bool1 = true)
          {
            break;
            a((String)localObject2, (k.b)localObject3, null, null);
          }
          localObject2 = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.s.p((String)localObject2, this.fileName, this.length), 1);
          bh.aGY().a((com.tencent.mm.an.q)localObject2, 0);
          bool1 = true;
          continue;
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(this.msgId);
          if (((ca)localObject3).getType() == 42)
          {
            Log.d("MicroMsg.MsgRetransmitUI", "set forward flag");
            ((ca)localObject3).hzR();
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.msgId, (ca)localObject3);
          }
          localObject3 = ca.a.bwZ(this.fQs);
          localObject4 = com.tencent.mm.modelmulti.o.WI((String)localObject2);
          ((o.e)localObject4).toUser = ((String)localObject2);
          ((o.e)localObject4).content = this.fQs;
          if (as.bvK(((ca.a)localObject3).fcC)) {}
          for (i = 66;; i = 42)
          {
            localObject2 = ((o.e)localObject4).wD(i);
            ((o.e)localObject2).cUP = 1;
            ((o.e)localObject2).lUq = 4;
            ((o.e)localObject2).bnl().aEv();
            bool1 = bool3;
            break;
          }
          localObject3 = com.tencent.mm.modelmulti.o.WI((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.fQs;
          localObject2 = ((o.e)localObject3).wD(48);
          ((o.e)localObject2).cUP = 0;
          ((o.e)localObject2).lUq = 4;
          ((o.e)localObject2).bnl().aEv();
          bool1 = true;
          continue;
          localObject3 = new sc();
          ((sc)localObject3).fRw.type = 4;
          localObject4 = ((sc)localObject3).fRw;
          bh.beI();
          ((sc.a)localObject4).fNz = com.tencent.mm.model.c.bbO().Oq(this.msgId);
          ((sc)localObject3).fRw.toUser = ((String)localObject2);
          EventCenter.instance.publish((IEvent)localObject3);
          bool1 = bool3;
          break;
          l.n(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          l.m(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          localObject3 = new vs();
          ((vs)localObject3).fUP.fxU = this.msgId;
          ((vs)localObject3).fUP.fII = this.fQs;
          ((vs)localObject3).fUP.fIJ = ((String)localObject2);
          EventCenter.instance.publish((IEvent)localObject3);
          bool1 = bool3;
          break;
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null)
            {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              localObject2 = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject3).ar(com.tencent.mm.plugin.findersdk.a.f.class);
              if (localObject2 != null)
              {
                localObject3 = new LinkedList();
                ((List)localObject3).add(new Pair(((com.tencent.mm.plugin.findersdk.a.f)localObject2).mbi.objectId, ((com.tencent.mm.plugin.findersdk.a.f)localObject2).mbi.objectNonceId));
                ((ak)com.tencent.mm.kernel.h.ag(ak.class)).shareStatsReport((List)localObject3, false);
              }
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null) {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null) {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null) {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null) {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null)
            {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              localObject2 = (com.tencent.mm.plugin.findersdk.a.i)((k.b)localObject3).ar(com.tencent.mm.plugin.findersdk.a.i.class);
              if (localObject2 != null)
              {
                localObject3 = new LinkedList();
                ((List)localObject3).add(new Pair(((com.tencent.mm.plugin.findersdk.a.i)localObject2).mbk.objectId, ((com.tencent.mm.plugin.findersdk.a.i)localObject2).mbk.objectNonceId));
                ((ak)com.tencent.mm.kernel.h.ag(ak.class)).shareStatsReport((List)localObject3, true);
              }
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null) {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.fQs))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder poi to %s", new Object[] { localObject2 });
            localObject3 = k.b.OQ(this.fQs);
            if (localObject3 != null)
            {
              w.a.bbx().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              bool1 = true;
              continue;
            }
          }
          bool1 = false;
        }
      }
      localObject3 = (String)this.XWk.get(0);
      switch (this.msgType)
      {
      case 3: 
      case 15: 
      case 17: 
      default: 
        finish();
        AppMethodBeat.o(39292);
        return;
      case 1: 
      case 11: 
        AppMethodBeat.o(39292);
        return;
      }
      if ((this.msgType == 2) || (this.msgType == 16))
      {
        localObject4 = k.b.OQ(Util.processXml(this.fQs));
        if ((localObject4 != null) && (((k.b)localObject4).type == 5) && (!Util.isNullOrNil(((k.b)localObject4).url))) {
          localObject1 = "";
        }
      }
      else
      {
        try
        {
          localObject2 = URLEncoder.encode(((k.b)localObject4).url, "UTF-8");
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
        if (bool3)
        {
          i = 1;
          Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.XWE), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.XWE), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      while ((bool3) || (localObject4 == null) || (((k.b)localObject4).type != 33))
      {
        if (!bool3) {
          break;
        }
        bAM((String)localObject3);
        AppMethodBeat.o(39292);
        return;
      }
      localObject1 = new com.tencent.mm.f.a.q();
      ((com.tencent.mm.f.a.q)localObject1).fva.scene = this.XWG;
      ((com.tencent.mm.f.a.q)localObject1).fva.cwR = this.XWH;
      if (2 == this.XWG)
      {
        ((com.tencent.mm.f.a.q)localObject1).fva.fvd = (this.XWF + ":" + this.WXa);
        if (!((String)localObject3).endsWith("@chatroom")) {
          break label3374;
        }
      }
      for (((com.tencent.mm.f.a.q)localObject1).fva.action = 2;; ((com.tencent.mm.f.a.q)localObject1).fva.action = 1)
      {
        ((com.tencent.mm.f.a.q)localObject1).fva.fvc = (((k.b)localObject4).loT + 1);
        ((com.tencent.mm.f.a.q)localObject1).fva.fve = ((k.b)localObject4).loz;
        ((com.tencent.mm.f.a.q)localObject1).fva.fvb = ((k.b)localObject4).loA;
        ((com.tencent.mm.f.a.q)localObject1).fva.appId = ((k.b)localObject4).loB;
        ((com.tencent.mm.f.a.q)localObject1).fva.appVersion = ((k.b)localObject4).loU;
        ((com.tencent.mm.f.a.q)localObject1).fva.fvf = "";
        ((com.tencent.mm.f.a.q)localObject1).fva.fvg = Util.nowSecond();
        ((com.tencent.mm.f.a.q)localObject1).fva.fvh = 2;
        ((com.tencent.mm.f.a.q)localObject1).fva.fvj = ((k.b)localObject4).loF;
        EventCenter.instance.publish((IEvent)localObject1);
        break;
        ((com.tencent.mm.f.a.q)localObject1).fva.fvd = this.XWF;
        break label3216;
      }
      finish();
      AppMethodBeat.o(39292);
      return;
    case 1: 
      label516:
      label559:
      label632:
      localObject1 = (String)this.XWk.get(0);
      label640:
      label1088:
      if (!hYQ())
      {
        finish();
        AppMethodBeat.o(39292);
        return;
      }
      label1170:
      label2860:
      label3374:
      switch (this.msgType)
      {
      default: 
        Log.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        AppMethodBeat.o(39292);
        return;
      case 0: 
        if ((this.XWu != null) && (this.XWu.size() > 0)) {
          this.XWw = this.XWu.size();
        }
        this.lPi = new com.tencent.mm.an.j()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.an.q paramAnonymousq)
          {
            AppMethodBeat.i(271690);
            if ((MsgRetransmitUI.e(MsgRetransmitUI.this) == null) || (paramAnonymousInt2 == 0))
            {
              AppMethodBeat.o(271690);
              return;
            }
            paramAnonymousInt1 = (int)(paramAnonymousInt1 * 100L / paramAnonymousInt2);
            MsgRetransmitUI.e(MsgRetransmitUI.this).setMessage(MsgRetransmitUI.this.getString(R.l.eMg, new Object[] { Integer.valueOf(MsgRetransmitUI.f(MsgRetransmitUI.this)), Integer.valueOf(MsgRetransmitUI.g(MsgRetransmitUI.this)), Integer.valueOf(paramAnonymousInt1) }));
            Log.i("MicroMsg.MsgRetransmitUI", "onSceneProgress: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            AppMethodBeat.o(271690);
          }
        };
        this.XWp = com.tencent.mm.ui.base.h.d(this, getString(R.l.eMg, new Object[] { Integer.valueOf(1), Integer.valueOf(this.XWw), Integer.valueOf(0) }), getString(R.l.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(282004);
            if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null) {
              MsgRetransmitUI.e(MsgRetransmitUI.this).cancel();
            }
            AppMethodBeat.o(282004);
          }
        });
        Log.i("MicroMsg.MsgRetransmitUI", "show uploadImgDialog : %s", new Object[] { this.XWp });
        if (this.XWp != null)
        {
          this.XWp.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(278769);
              com.tencent.mm.ui.base.h.a(MsgRetransmitUI.this, R.l.eMd, R.l.app_tip, R.l.app_yes, R.l.app_no, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(273157);
                  com.tencent.mm.ay.i locali;
                  com.tencent.mm.ay.g localg;
                  if (MsgRetransmitUI.h(MsgRetransmitUI.this) != null)
                  {
                    bh.aGY().a(MsgRetransmitUI.h(MsgRetransmitUI.this));
                    paramAnonymous2Int = (int)MsgRetransmitUI.h(MsgRetransmitUI.this).lPj;
                    paramAnonymous2DialogInterface = com.tencent.mm.ay.q.bmh().wl(paramAnonymous2Int);
                    if (paramAnonymous2DialogInterface != null)
                    {
                      locali = com.tencent.mm.ay.q.bmh();
                      localg = locali.wl(paramAnonymous2Int);
                      if ((localg != null) && (localg.localId == paramAnonymous2Int)) {
                        break label138;
                      }
                    }
                  }
                  for (;;)
                  {
                    bh.beI();
                    com.tencent.mm.model.c.bbO().Or(paramAnonymous2DialogInterface.lNP);
                    Toast.makeText(MsgRetransmitUI.this, R.l.eMe, 1).show();
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(273157);
                    return;
                    label138:
                    u.deleteFile(locali.r(localg.lNH, "", ""));
                    u.deleteFile(locali.r(localg.lNM, "", ""));
                    u.deleteFile(locali.r(localg.lNJ, "", ""));
                    u.deleteFile(locali.r(localg.lNJ, "", "") + "hd");
                    locali.lvy.delete(i.d.GG(paramAnonymous2Int), "id=?", new String[] { String.valueOf(paramAnonymous2Int) });
                    if (localg.blK())
                    {
                      localg = locali.wl(localg.lNR);
                      if (localg != null)
                      {
                        u.deleteFile(locali.r(localg.lNH, "", ""));
                        u.deleteFile(locali.r(localg.lNM, "", ""));
                        u.deleteFile(locali.r(localg.lNJ, "", ""));
                        u.deleteFile(locali.r(localg.lNJ, "", "") + "hd");
                        locali.lvy.delete(i.d.GG(paramAnonymous2Int), "id=?", new String[] { localg.localId });
                      }
                    }
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(283572);
                  if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null) {
                    MsgRetransmitUI.e(MsgRetransmitUI.this).show();
                  }
                  AppMethodBeat.o(283572);
                }
              });
              AppMethodBeat.o(278769);
            }
          });
          this.XWp.setCanceledOnTouchOutside(false);
          this.XWp.ayb(-1).setText(R.l.app_cancel);
        }
        a((String)localObject1, 6, this.lPi);
        AppMethodBeat.o(39292);
        return;
      case 1: 
      case 11: 
        if (!ag.dj(this))
        {
          com.tencent.mm.ui.base.h.a(this, R.l.video_export_file_warning, R.l.app_tip, R.l.app_ok, R.l.app_cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39279);
              MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), this.iXG);
              AppMethodBeat.o(39279);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(287606);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(287606);
            }
          });
          AppMethodBeat.o(39292);
          return;
        }
        s(getIntent(), (String)localObject1);
        AppMethodBeat.o(39292);
        return;
      }
      label3216:
      dG((String)localObject1, true);
      AppMethodBeat.o(39292);
      return;
    }
    switch (this.msgType)
    {
    default: 
      AppMethodBeat.o(39292);
      return;
    }
    this.XWk.get(0);
    Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName = ((String)localObject1);
    ao.fmz().get((IAutoDBItem)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new e(new e.a()
    {
      public final void hYS()
      {
        AppMethodBeat.i(198902);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(198902);
      }
    });
    if (((WXMediaMessage)localObject5).thumbData == null) {}
    for (localObject1 = null;; localObject1 = BitmapUtil.decodeByteArray(((WXMediaMessage)localObject5).thumbData)) {
      switch (((WXMediaMessage)localObject5).mediaObject.type())
      {
      default: 
        Log.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + ((WXMediaMessage)localObject5).mediaObject.type());
        AppMethodBeat.o(39292);
        return;
      }
    }
    localObject1 = View.inflate(this, R.i.ebJ, null);
    ((TextView)((View)localObject1).findViewById(R.h.title_tv)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(R.h.source_tv)).setText(com.tencent.mm.pluginsdk.model.app.h.a(this, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      ((e)localObject4).mUO = com.tencent.mm.ui.base.h.a(this, null, (View)localObject1, getString(R.l.app_send), getString(R.l.app_cancel), new e.1((e)localObject4), new e.2((e)localObject4));
      break;
      View localView = View.inflate(this, R.i.ebI, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      ((TextView)localView.findViewById(R.h.title_tv)).setText(((WXMediaMessage)localObject5).title);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.ebH, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.ebH, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.ebH, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.ebH, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.ebH, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
    }
  }
  
  private boolean hYQ()
  {
    AppMethodBeat.i(39298);
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.w.g(this, null);
      AppMethodBeat.o(39298);
      return false;
    }
    AppMethodBeat.o(39298);
    return true;
  }
  
  private void hYR()
  {
    AppMethodBeat.i(39308);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(290103);
        com.tencent.mm.modelvideo.s.bqG().a(MsgRetransmitUI.this.fileName, new x.a()
        {
          public final void a(x.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(290347);
            paramAnonymous2a = y.Yk(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199))
            {
              paramAnonymous2a = new MsgRetransmitUI.b((byte)0);
              paramAnonymous2a.XXj = new LinkedList();
              paramAnonymous2a.XXj.addAll(MsgRetransmitUI.this.XWk);
              Iterator localIterator = MsgRetransmitUI.this.XWk.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                Log.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", new Object[] { str });
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymous2a, str);
              }
            }
            AppMethodBeat.o(290347);
          }
        });
        AppMethodBeat.o(290103);
      }
    }, "MicroMsg.MsgRetransmitUI");
    this.XWo = false;
    AppMethodBeat.o(39308);
  }
  
  private void kT(List<String> paramList)
  {
    AppMethodBeat.i(39307);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      bAL((String)paramList.next());
    }
    if (this.XWo) {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.l.has_send));
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39273);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39273);
      }
    }, 1800L);
    AppMethodBeat.o(39307);
  }
  
  private void s(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(39299);
    if (this.XWx)
    {
      this.XWw = this.XWu.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.XWM) {
            break;
          }
          bAN(paramString);
        }
        AppMethodBeat.o(39299);
        return;
      }
      finish();
      AppMethodBeat.o(39299);
      return;
    }
    this.XWw = 1;
    bAN(paramString);
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
        this.XWk = Util.stringsToList(((String)localObject3).split(","));
        localObject1 = localObject2;
      }
    }
    long l;
    if (this.XWJ)
    {
      localObject3 = com.tencent.mm.plugin.selectrecord.b.b.fFC();
      localObject2 = this.XWk;
      localObject3 = ((com.tencent.mm.plugin.selectrecord.b.b)localObject3).JcL;
      ((ia)localObject3).gHP = ((ia)localObject3).z("ToUsername", Util.listToString((List)localObject2, ";"), true);
      localObject2 = com.tencent.mm.plugin.selectrecord.b.b.fFC();
      if (Util.isNullOrNil((String)localObject1))
      {
        l = 2L;
        ((com.tencent.mm.plugin.selectrecord.b.b)localObject2).JcL.gHL = l;
      }
    }
    else
    {
      if (paramInt2 == -1) {
        break label597;
      }
      localObject1 = k.b.OQ(Util.processXml(this.fQs));
      if ((localObject1 == null) || (((k.b)localObject1).type != 5) || (((k.b)localObject1).url == null)) {
        break label372;
      }
      Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject1).url, Long.valueOf(this.startTime), Integer.valueOf(this.XWE), Integer.valueOf(1), Integer.valueOf(3) });
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
    com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.XWE), Integer.valueOf(1), Integer.valueOf(3) });
    label372:
    while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
    {
      if (this.XWJ) {
        com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
      }
      finish();
      AppMethodBeat.o(39293);
      return;
      l = 1L;
      break;
    }
    paramIntent = new com.tencent.mm.f.a.q();
    paramIntent.fva.cwR = this.XWH;
    paramIntent.fva.scene = this.XWG;
    if (2 == this.XWG) {}
    for (paramIntent.fva.fvd = (this.XWF + ":" + this.WXa);; paramIntent.fva.fvd = this.XWF)
    {
      paramIntent.fva.fvc = (localUnsupportedEncodingException.loT + 1);
      paramIntent.fva.fve = localUnsupportedEncodingException.loz;
      paramIntent.fva.fvb = localUnsupportedEncodingException.loA;
      paramIntent.fva.appId = localUnsupportedEncodingException.loB;
      paramIntent.fva.appVersion = localUnsupportedEncodingException.loU;
      paramIntent.fva.action = 1;
      paramIntent.fva.fvf = "";
      paramIntent.fva.fvg = Util.nowSecond();
      paramIntent.fva.fvh = 3;
      paramIntent.fva.fvj = localUnsupportedEncodingException.loF;
      EventCenter.instance.publish(paramIntent);
      break;
    }
    label597:
    if (paramInt1 != 0)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(39293);
      return;
    }
    this.wIf = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.wIf) {
      this.syu = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      Log.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    this.XWK = paramIntent.getBooleanExtra("KSendGroupToDo", false);
    this.XWL = paramIntent.getIntExtra("KShowTodoIntroduceView", 0);
    Log.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.XWr), Integer.valueOf(this.XWk.size()) });
    paramInt1 = this.msgType;
    paramIntent = this.fQs;
    Object localObject2 = ((r)com.tencent.mm.kernel.h.ae(r.class)).Wy(paramInt1);
    if (localObject2 != null)
    {
      localObject3 = com.tencent.mm.ui.base.s.a(this, getString(R.l.app_waiting), true, 3, null);
      ((com.tencent.mm.plugin.messenger.foundation.a.z)localObject2).a(this, (String)this.XWk.get(0), paramIntent, new z.a()
      {
        public final void ub(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(239159);
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276182);
              MsgRetransmitUI.12.this.ucj.dismiss();
              if (paramAnonymousBoolean)
              {
                MsgRetransmitUI.b(MsgRetransmitUI.this, (String)MsgRetransmitUI.this.XWk.get(0));
                AppMethodBeat.o(276182);
                return;
              }
              com.tencent.mm.ui.widget.snackbar.b.r(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.l.sendrequest_send_fail));
              Object localObject1 = new Intent();
              Object localObject2 = new ArrayList();
              ((ArrayList)localObject2).addAll(MsgRetransmitUI.this.XWk);
              ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
              ((Intent)localObject1).putExtra("sendResult", 0);
              MsgRetransmitUI.this.setResult(3, (Intent)localObject1);
              if (MsgRetransmitUI.a(MsgRetransmitUI.this))
              {
                localObject1 = MsgRetransmitUI.c(MsgRetransmitUI.this);
                localObject2 = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(219213);
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(219213);
                  }
                };
                if (!MsgRetransmitUI.b(MsgRetransmitUI.this)) {
                  break label207;
                }
              }
              label207:
              for (long l = 1800L;; l = 0L)
              {
                ((MMHandler)localObject1).postDelayed((Runnable)localObject2, l);
                AppMethodBeat.o(276182);
                return;
              }
            }
          });
          AppMethodBeat.o(239159);
        }
      });
    }
    if (localObject2 != null) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      AppMethodBeat.o(39293);
      return;
    }
    hYP();
    if (!TextUtils.isEmpty(localUnsupportedEncodingException))
    {
      paramIntent = this.XWk.iterator();
      while (paramIntent.hasNext())
      {
        localObject2 = (String)paramIntent.next();
        localObject3 = new uz();
        ((uz)localObject3).fUn.fcD = ((String)localObject2);
        ((uz)localObject3).fUn.content = localUnsupportedEncodingException;
        ((uz)localObject3).fUn.type = ab.QZ((String)localObject2);
        ((uz)localObject3).fUn.flags = 0;
        EventCenter.instance.publish((IEvent)localObject3);
      }
    }
    if (this.XWJ)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.b.fFC();
      paramIntent.aej(1);
      paramIntent.bpa();
    }
    AppMethodBeat.o(39293);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39289);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    ar.e(getWindow());
    this.startTime = Util.nowSecond();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    boolean bool;
    if (getIntent().hasExtra("Retr_Msg_content_bytes"))
    {
      this.fQs = new String(getIntent().getByteArrayExtra("Retr_Msg_content_bytes"));
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      this.XWl = ((ArrayList)getIntent().getSerializableExtra("Retr_Msg_Id_List"));
      this.fileName = getIntent().getStringExtra("Retr_File_Name");
      this.XWu = getIntent().getStringArrayListExtra("Retr_File_Path_List");
      if ((this.XWu == null) || (this.XWu.size() <= 0)) {
        break label895;
      }
      bool = true;
      label163:
      this.XWx = bool;
      this.lNK = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.XWr = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.XWq = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.XWm = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.XWn = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.XWB = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.XWr != 0) {
        break label900;
      }
      bool = true;
      label286:
      this.XWC = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.XWC) {
        this.XWB = true;
      }
      this.XWo = getIntent().getBooleanExtra("Retr_show_success_tips", this.XWB);
      this.XWy = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.isGroupChat = getIntent().getBooleanExtra("is_group_chat", false);
      this.mic = getIntent().getStringExtra("msg_uuid");
      this.Xim = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.XWz = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.longtitude = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.latitude = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.lPM = getIntent().getStringExtra("Retr_AttachedContent");
      this.XWA = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.mSessionId = getIntent().getStringExtra("reportSessionId");
      this.XWE = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.WXa = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.XWF = getIntent().getStringExtra("Retr_MsgTalker");
      this.XWG = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.XWH = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      this.XWJ = getIntent().getBooleanExtra("Retr_MsgFromMoreSelectRetransmit", false);
      this.fromScene = getIntent().getIntExtra("scene_from", 0);
      bh.aGY().a(110, this);
      if (!com.tencent.mm.compatible.util.d.qV(19)) {
        setContentView(R.i.ece);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.XWC) {
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
      default: 
        paramBundle.putExtra("Select_Conv_Type", 3);
      }
    }
    for (;;)
    {
      paramBundle.putExtra("Retr_Msg_Type", this.msgType);
      paramBundle.putExtra("Retr_Msg_Id", this.msgId);
      if (!Util.isNullOrNil(this.XWl)) {
        paramBundle.putExtra("Retr_Msg_Id_List", this.XWl);
      }
      if (this.fQs != null) {
        paramBundle.putExtra("Retr_Msg_content_bytes", this.fQs.getBytes());
      }
      paramBundle.putExtra("Retr_Msg_thumb_path", this.XWm);
      paramBundle.putExtra("image_path", this.fileName);
      paramBundle.putExtra("scene_from", this.fromScene);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(39289);
      return;
      this.fQs = getIntent().getStringExtra("Retr_Msg_content");
      break;
      label895:
      bool = false;
      break label163;
      label900:
      bool = false;
      break label286;
      paramBundle.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
      if (this.XWE == 3)
      {
        this.fromScene = 3;
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.Xim);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
      continue;
      bh.beI();
      ca.a locala = com.tencent.mm.model.c.bbO().aOU(this.fQs);
      if ((locala.fcC == null) || (locala.fcC.length() <= 0)) {
        Log.e("MicroMsg.MsgRetransmitUI", "getView : parse possible friend msg failed");
      }
      if (!ab.uL(locala.PKJ))
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
        if (l.hMG())
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
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39291);
    if (!this.XWt) {
      bh.aGY().b(110, this);
    }
    super.onDestroy();
    AppMethodBeat.o(39291);
  }
  
  @DoNotCheckLeakForActivities
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(39310);
    Log.i("MicroMsg.MsgRetransmitUI", "errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq.getType() != 110) || (!(paramq instanceof com.tencent.mm.ay.n)))
    {
      AppMethodBeat.o(39310);
      return;
    }
    paramString = (com.tencent.mm.ay.n)paramq;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramq = getIntent().getStringExtra("Retr_KSnsId");
      if (!ab.Lj(paramString.fcD)) {
        break label221;
      }
      localObject = new ws();
      ((ws)localObject).fVM.fLp = paramq;
      EventCenter.instance.publish((IEvent)localObject);
    }
    while ((this.XWu != null) && (this.XWu.size() > 1))
    {
      this.XWu.remove(0);
      paramq = paramString.fcD;
      paramString = paramq;
      if (Util.isNullOrNil(paramq))
      {
        paramString = paramq;
        if (this.XWk != null) {
          paramString = (String)this.XWk.get(0);
        }
      }
      a(paramString, 3, this.lPi);
      AppMethodBeat.o(39310);
      return;
      label221:
      localObject = new wt();
      ((wt)localObject).fVN.fLp = paramq;
      EventCenter.instance.publish((IEvent)localObject);
    }
    if (this.XWp != null)
    {
      this.XWp.dismiss();
      Log.i("MicroMsg.MsgRetransmitUI", "uploadImgDialog dismissed : %s", new Object[] { this.XWp.toString() });
      this.XWp = null;
    }
    this.XWD -= 1;
    if ((this.XWD <= 0) || (!this.XWC))
    {
      this.XWt = false;
      bh.aGY().b(110, this);
      if (this.XWr != 0)
      {
        finish();
        if ((this.XWn) && (!this.XWB))
        {
          paramq = new Intent(this, ChattingUI.class);
          paramq.addFlags(67108864);
          paramq.putExtra("Chat_User", paramString.fcD);
          paramq.putExtra("scene_from", this.fromScene);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
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
    public boolean XWZ;
    public boolean XWo;
    public int XWq;
    public String XXa;
    public boolean XXb;
    public boolean XXc;
    public boolean XXd;
    public eor XXe;
    public MsgRetransmitUI.b XXf;
    public int XXg;
    public d.a XXh;
    public Context context;
    public String fUk;
    public String fileName;
    public String hxy;
    public int lvw;
    private MMHandler mHandler;
    public int mfT;
    public String mic;
    public Dialog tipDialog;
    public String userName;
    
    public a()
    {
      AppMethodBeat.i(39285);
      this.XXb = true;
      this.XXc = false;
      this.XWo = false;
      this.XXd = true;
      this.XXe = null;
      this.XXf = null;
      this.mHandler = new MMHandler(Looper.getMainLooper());
      this.XXh = null;
      AppMethodBeat.o(39285);
    }
  }
  
  static final class b
  {
    public List<String> XXj = null;
    boolean fyl = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */