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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.av.i.d;
import com.tencent.mm.av.n;
import com.tencent.mm.av.o.a;
import com.tencent.mm.g.a.p;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.a;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.co;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.eeq;
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
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
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
  implements com.tencent.mm.ak.i
{
  private String PCe;
  private int PMs;
  private boolean PbY;
  private int QyA;
  private int QyB;
  private boolean QyC;
  private boolean QyD;
  private boolean QyE;
  private int QyF;
  boolean QyG;
  public List<String> Qyf;
  private String Qyg;
  private boolean Qyh;
  private boolean Qyi;
  private com.tencent.mm.ui.widget.a.d Qyj;
  private int Qyk;
  private int Qyl;
  private n Qym;
  private boolean Qyn;
  private List<String> Qyo;
  private int Qyp;
  private int Qyq;
  private boolean Qyr;
  private boolean Qys;
  private int Qyt;
  private boolean Qyu;
  private boolean Qyv;
  private boolean Qyw;
  private int Qyx;
  private int Qyy;
  private String Qyz;
  public String dWG;
  public String fileName;
  private ProgressDialog gtM;
  private int iXp;
  private com.tencent.mm.ak.j iYO;
  private String iZr;
  private String jsz;
  private float latitude;
  private int length;
  private float longtitude;
  private MMHandler mHandler;
  private String mSessionId;
  public long msgId;
  public int msgType;
  long ppv;
  private long startTime;
  boolean tca;
  private String thumbPath;
  
  public MsgRetransmitUI()
  {
    AppMethodBeat.i(39288);
    this.Qyg = null;
    this.Qyh = true;
    this.Qyi = false;
    this.gtM = null;
    this.iXp = 0;
    this.Qyk = 0;
    this.Qyl = 0;
    this.Qym = null;
    this.Qyn = false;
    this.Qyo = null;
    this.iYO = null;
    this.Qyp = 0;
    this.Qyq = 0;
    this.Qyr = false;
    this.Qys = false;
    this.PbY = false;
    this.PMs = -1;
    this.Qyv = true;
    this.Qyw = true;
    this.Qyx = 0;
    this.startTime = 0L;
    this.QyC = true;
    this.QyD = false;
    this.QyE = false;
    this.QyF = 0;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.QyG = false;
    AppMethodBeat.o(39288);
  }
  
  private void a(final k.b paramb, final com.tencent.mm.pluginsdk.model.app.c paramc, final ca paramca, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39296);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_MsgRetransmitUI_1";
    localg.gqy = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39282);
        paramc.field_fileFullPath = paramString2;
        if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
        {
          paramc.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.pluginsdk.model.app.ao.cgO().a(paramc, new String[0]);
        }
        if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          paramc.field_status = 199L;
          paramc.field_offset = paramc.field_totalLen;
          com.tencent.mm.pluginsdk.model.app.ao.cgO().a(paramc, new String[0]);
          paramca.setStatus(3);
          bg.aVF();
          com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
          com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.appId, paramb.appName, paramString1, paramString2, paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this));
        }
        AppMethodBeat.o(39282);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), paramca.field_talker, paramca.field_msgId);
    localg.field_aesKey = paramb.aesKey;
    localg.field_fileType = 19;
    localg.field_authKey = paramb.iwT;
    localg.gqB = paramb.iwN;
    localg.field_fullpath = paramString2;
    if (!com.tencent.mm.an.f.baQ().b(localg, -1)) {
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
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131755978), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39274);
        this.Pkz.QyQ = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39274);
      }
    });
    ((a)localObject).context = this;
    ((a)localObject).fileName = this.fileName;
    ((a)localObject).tipDialog = this.gtM;
    ((a)localObject).Qyk = this.Qyk;
    ((a)localObject).iFw = this.length;
    ((a)localObject).jqs = this.msgType;
    ((a)localObject).QyS = false;
    ((a)localObject).userName = paramString;
    ((a)localObject).QyT = true;
    ((a)localObject).Qyi = this.Qyi;
    ((a)localObject).QyW = paramb;
    paramb = com.tencent.mm.modelvideo.u.QN(this.fileName);
    if ((paramb != null) && (paramb.jsw != null))
    {
      Log.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((a)localObject).QyV = paramb.jsw;
      ((a)localObject).fqK = paramb.getUser();
      ((a)localObject).QyX = paramb.jso;
    }
    ((a)localObject).execute(new Object[0]);
    cf.aWl().f(cf.iFJ, null);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(39309);
      return;
    }
    bg.aVF();
    ca localca = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
    boolean bool = ab.Eq(paramString);
    if (bool)
    {
      paramb = a.c.PcY;
      if (!this.Qyu) {
        break label319;
      }
    }
    label319:
    for (localObject = a.d.Pdc;; localObject = a.d.Pdb)
    {
      if (bool) {
        i = v.Ie(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localca, i);
      AppMethodBeat.o(39309);
      return;
      paramb = a.c.PcX;
      break;
    }
  }
  
  private void a(String paramString, int paramInt, com.tencent.mm.ak.j paramj)
  {
    AppMethodBeat.i(39301);
    String str2 = z.aTY();
    bg.aVF();
    ca localca = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
    if (localca.field_msgId == this.msgId)
    {
      String str1 = localca.field_content;
      Object localObject1 = null;
      if (localca.field_msgId > 0L) {
        localObject1 = com.tencent.mm.av.q.bcR().H(localca.field_talker, localca.field_msgId);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.av.g)localObject1).localId > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localca.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.av.q.bcR().G(localca.field_talker, localca.field_msgSvrId);
        }
      }
      localObject1 = str1;
      if (Util.isNullOrNil(str1))
      {
        localObject1 = str1;
        if (localca.field_msgSvrId > 0L) {
          localObject1 = ((com.tencent.mm.av.g)localObject2).iXy;
        }
      }
      if ((localObject2 != null) && ((((com.tencent.mm.av.g)localObject2).offset < ((com.tencent.mm.av.g)localObject2).iKP) || (((com.tencent.mm.av.g)localObject2).iKP == 0)) && (!this.Qyr))
      {
        paramj = com.tencent.mm.av.q.bcR().G(localca.field_talker, localca.field_msgSvrId);
        if (!a(paramj, localca, (String)localObject1, paramInt, paramString, str2)) {
          b(paramj, localca, (String)localObject1, paramInt, paramString, str2);
        }
        AppMethodBeat.o(39301);
        return;
      }
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.av.g)localObject2).localId;; l = -1L)
      {
        a(paramString, paramInt, str2, (String)localObject1, paramj, l);
        AppMethodBeat.o(39301);
        return;
      }
    }
    a(paramString, paramInt, str2, "", paramj, -1L);
    AppMethodBeat.o(39301);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.ak.j paramj, long paramLong)
  {
    AppMethodBeat.i(39304);
    o.e locale;
    if (!Util.isNullOrNil(this.fileName))
    {
      this.Qyp = 1;
      this.Qyq = 1;
      if (!bnU(this.fileName))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.iXp == 1) && (!z.f(this.fileName, paramString1, false))) {
        this.iXp = 0;
      }
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 96L, 1L, false);
      locale = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(paramInt);
      locale.dRL = paramString2;
      locale.toUser = paramString1;
      locale.iZt = this.fileName;
      locale.iXp = this.iXp;
      locale.jdS = paramj;
      locale.dQd = 0;
      locale.iXy = paramString3;
      locale.thumbPath = "";
      locale.jdV = true;
      locale.jdU = 2131231628;
      locale.jea = true;
      locale.jeb = this.Qyt;
      locale.dTj = this.longtitude;
      locale.latitude = this.latitude;
      locale.iZr = this.iZr;
      locale.jdX = paramLong;
      locale.jdW = this.msgId;
      locale.jdY = this.jsz;
      if (this.Qyl == 1) {}
      for (bool = true;; bool = false)
      {
        locale.hmr = bool;
        locale.jdR = 19;
        paramString1 = locale.bdQ();
        this.Qym = ((n)paramString1.jdJ);
        paramString1.execute();
        this.Qyn = true;
        Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.iXp) });
        cf.aWl().f(cf.iFI, null);
        AppMethodBeat.o(39304);
        return;
      }
    }
    if (this.Qyr)
    {
      this.Qyp += 1;
      if (!bnU((String)this.Qyo.get(0)))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.iXp == 1) && (!z.f((String)this.Qyo.get(0), paramString1, false))) {
        this.iXp = 0;
      }
      Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.iXp) });
      locale = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(paramInt);
      locale.dRL = paramString2;
      locale.toUser = paramString1;
      locale.iZt = ((String)this.Qyo.get(0));
      locale.iXp = this.iXp;
      locale.jdS = paramj;
      locale.dQd = 0;
      locale.iXy = paramString3;
      locale.thumbPath = "";
      locale.jdV = true;
      locale.jdU = 2131231628;
      if (this.Qyl != 1) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      locale.hmr = bool;
      locale.jdR = 11;
      paramString1 = locale.bdQ();
      this.Qym = ((n)paramString1.jdJ);
      this.Qyn = true;
      paramString1.execute();
      cf.aWl().f(cf.iFI, null);
      AppMethodBeat.o(39304);
      return;
    }
  }
  
  private void a(final String paramString, final k.b paramb, final byte[] paramArrayOfByte, ca paramca)
  {
    AppMethodBeat.i(39295);
    Log.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, paramb.dCK });
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.m.bdJ(paramb.dCK);
    if (!Util.isNullOrNil(paramb.iwN)) {
      localObject1 = com.tencent.mm.pluginsdk.model.app.m.c(paramca, paramb.dCK);
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
          bg.aVF();
          localObject2 = com.tencent.mm.pluginsdk.model.app.m.aB(com.tencent.mm.model.c.aTg(), paramb.title, paramb.iwJ);
          com.tencent.mm.vfs.s.nw(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, (String)localObject2);
          Log.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramb.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).deQ()) });
        }
      }
    }
    localObject3 = k.b.a(paramb);
    ((k.b)localObject3).iwL = 3;
    if ((paramca != null) && (paramb.type == 6) && (!Util.isNullOrNil(paramb.iwN)) && (localObject1 != null) && ((!com.tencent.mm.vfs.s.YS(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.s.boW(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
    {
      a((k.b)localObject3, (com.tencent.mm.pluginsdk.model.app.c)localObject1, paramca, paramString, (String)localObject2, paramArrayOfByte);
      AppMethodBeat.o(39295);
      return;
    }
    if ((Util.isNullOrNil((String)localObject2)) && ((paramb.iwM != 0) || (paramb.iwI > 26214400)))
    {
      Log.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(paramb.iwM), Integer.valueOf(paramb.iwI) });
      bg.azz().a(new com.tencent.mm.pluginsdk.g.c(paramb, null, paramString, new c.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
        {
          AppMethodBeat.i(234474);
          Log.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new, errMsg:[%s], md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2, Util.secPrint(paramAnonymousString3), Util.secPrint(paramAnonymousString4), Util.secPrint(paramb.aesKey), Util.secPrint(paramAnonymousString5), Util.secPrint(paramAnonymousString6) });
          if (!Util.isNullOrNil(paramAnonymousString4))
          {
            com.tencent.mm.pluginsdk.model.app.m.a(this.QyN, paramb.appId, paramb.appName, paramString, "", paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this), paramAnonymousString4);
            AppMethodBeat.o(234474);
            return;
          }
          com.tencent.mm.ui.base.h.c(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(2131758179), "", true);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(234474);
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
      localObject2 = URLEncoder.encode(Util.nullAsNil(((k.b)localObject3).izh));
      paramb = paramb.izn;
      com.tencent.mm.plugin.report.service.h.CyF.a(14127, new Object[] { ((k.b)localObject3).appId, ((k.b)localObject3).izi, localObject2, paramca, localObject1, "", paramArrayOfByte, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString, Integer.valueOf(1), paramb, "" });
      AppMethodBeat.o(39295);
      return;
    }
  }
  
  private boolean a(final com.tencent.mm.av.g paramg, final ca paramca, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39302);
    Object localObject = XmlParser.parseXml(paramg.iXy, "msg", null);
    if (localObject == null)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.iXy });
      AppMethodBeat.o(39302);
      return false;
    }
    final int j = paramg.iXp;
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
    if (Util.isNullOrNil(com.tencent.mm.an.c.a("downimg", paramg.iXu, paramca.field_talker, paramca.field_msgId)))
    {
      Log.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(paramca.field_msgSvrId) });
      AppMethodBeat.o(39302);
      return false;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$md5");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_MsgRetransmitUI_2";
    localg.gqy = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39267);
        if (paramAnonymousd != null)
        {
          if (!paramAnonymousd.field_exist_whencheck) {
            break label78;
          }
          Log.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymousd, paramca, paramInt, paramString2, paramString3, paramString1, this.lhI, j);
        }
        for (;;)
        {
          AppMethodBeat.o(39267);
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
    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), paramString2, paramca.field_msgId);
    localg.field_fileId = str1;
    localg.field_aesKey = str2;
    localg.field_filemd5 = ((String)localObject);
    localg.field_fileType = i;
    localg.field_talker = paramString2;
    localg.field_priority = com.tencent.mm.i.a.gpM;
    localg.field_svr_signature = "";
    localg.field_onlycheckexist = true;
    localg.field_trysafecdn = true;
    if (!com.tencent.mm.an.f.baQ().f(localg))
    {
      Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
      AppMethodBeat.o(39302);
      return false;
    }
    AppMethodBeat.o(39302);
    return true;
  }
  
  private void b(com.tencent.mm.av.g paramg, ca paramca, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39303);
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = paramg.iXp;
    long l1 = com.tencent.mm.av.q.bcR().a(paramca.field_talker, this.fileName, i, paramInt, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.av.g localg = com.tencent.mm.av.q.bcR().c(Long.valueOf(l1));
    localg.tj(1);
    ca localca = new ca();
    localca.setType(ab.JH(paramString2));
    localca.Cy(paramString2);
    localca.nv(1);
    localca.setStatus(1);
    localca.Cz(((PString)localObject).value);
    localca.nG(localPInt1.value);
    localca.nH(localPInt2.value);
    localca.setCreateTime(bp.Kw(localca.field_talker));
    if (com.tencent.mm.al.g.DQ(localca.field_talker)) {
      paramca.BB(com.tencent.mm.al.a.e.ajw());
    }
    bg.aVF();
    long l2 = com.tencent.mm.model.c.aSQ().aC(localca);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      localg.Aw((int)l2);
      com.tencent.mm.av.q.bcR().a(Long.valueOf(l1), localg);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), paramg);
      com.tencent.mm.av.q.bcS().a(paramg.localId, paramca.field_msgId, i, localObject, 2131231628, new com.tencent.mm.av.e.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.q paramAnonymousq) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(39269);
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
              paramAnonymousq = (com.tencent.mm.av.g)paramAnonymousq.getValue();
              MsgRetransmitUI.this.fileName = com.tencent.mm.av.q.bcR().o(com.tencent.mm.av.h.c(paramAnonymousq), "", "");
              if (paramAnonymousInt1 != 0)
              {
                bg.aVF();
                com.tencent.mm.model.c.aSQ().Hc(paramAnonymousString.longValue());
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramString2, paramInt, paramString3, paramString1, MsgRetransmitUI.h(MsgRetransmitUI.this), paramAnonymousLong1);
              }
            }
          }
          AppMethodBeat.o(39269);
        }
      });
      AppMethodBeat.o(39303);
      return;
    }
  }
  
  /* Error */
  private static boolean bnU(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc_w 1205
    //   7: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 301
    //   13: ldc_w 1207
    //   16: iconst_1
    //   17: anewarray 315	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 650	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: invokestatic 1211	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: new 1213	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 1214	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: iconst_1
    //   51: putfield 1217	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: aconst_null
    //   60: aload 5
    //   62: invokestatic 1223	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: getfield 1226	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: iflt +29 -> 103
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 1229	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: istore_1
    //   86: iload_1
    //   87: iflt +16 -> 103
    //   90: aload 4
    //   92: invokestatic 1233	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   95: ldc_w 1205
    //   98: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload_2
    //   102: ireturn
    //   103: iconst_0
    //   104: istore_2
    //   105: goto -15 -> 90
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_3
    //   111: ldc_w 301
    //   114: ldc_w 1235
    //   117: iconst_1
    //   118: anewarray 315	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: invokestatic 1124	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: invokestatic 1233	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   132: ldc_w 1205
    //   135: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_3
    //   142: invokestatic 1233	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   145: ldc_w 1205
    //   148: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private boolean bnY(final String paramString)
  {
    AppMethodBeat.i(39294);
    final k.b localb = k.b.HD(Util.processXml(this.dWG));
    Log.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.dWG, localb });
    if (localb == null)
    {
      Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(39294);
      return false;
    }
    if ((localb.type == 53) || (localb.type == 57))
    {
      localObject1 = localb.title;
      z.aTY();
      localObject2 = com.tencent.mm.modelmulti.o.Pl(paramString);
      ((o.e)localObject2).toUser = paramString;
      ((o.e)localObject2).content = ((String)localObject1);
      paramString = ((o.e)localObject2).tD(ab.JG(paramString));
      paramString.cSx = 0;
      paramString.jdR = 4;
      paramString.bdQ().execute();
      AppMethodBeat.o(39294);
      return true;
    }
    bg.aVF();
    final ca localca = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
    if (localca.gAt())
    {
      if (localb.type == 33) {
        com.tencent.mm.ui.chatting.m.b(paramString, localb, co.c(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        AppMethodBeat.o(39294);
        return true;
        com.tencent.mm.ui.chatting.k.a(this, paramString, this.dWG, localca.field_isSend, this.PbY);
      }
    }
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool;
    if (this.Qyg == null)
    {
      localObject1 = localObject4;
      if (this.PMs < 0)
      {
        localObject1 = localObject4;
        if (localca.field_imgPath != null)
        {
          localObject1 = localObject4;
          if (!localca.field_imgPath.equals(""))
          {
            localObject4 = com.tencent.mm.av.q.bcR().R(localca.field_imgPath, true);
            localObject1 = localObject2;
            try
            {
              localObject2 = com.tencent.mm.vfs.s.aW((String)localObject4, 0, -1);
              localObject1 = localObject2;
              bool = cM((byte[])localObject2);
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
      localObject4 = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new com.tencent.mm.ag.a();
      }
      ((com.tencent.mm.ag.a)localObject3).ivq = this.QyE;
      localb.a((com.tencent.mm.ag.f)localObject3);
      com.tencent.f.h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39277);
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, localb, this.QyM, localca);
          AppMethodBeat.o(39277);
        }
      }, "MicroMsg.MsgRetransmitUI");
      break;
      try
      {
        localObject3 = com.tencent.mm.vfs.s.aW(this.Qyg, 0, -1);
        localObject1 = localObject3;
        bool = cM((byte[])localObject3);
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
  
  private void bnZ(final String paramString)
  {
    AppMethodBeat.i(39300);
    Log.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new com.tencent.mm.pluginsdk.model.m(this, null, getIntent(), paramString, 1, new m.a()
    {
      public final void gmA()
      {
        AppMethodBeat.i(39265);
        if (MsgRetransmitUI.f(MsgRetransmitUI.this) != null)
        {
          MsgRetransmitUI.f(MsgRetransmitUI.this).dismiss();
          MsgRetransmitUI.g(MsgRetransmitUI.this);
        }
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39265);
      }
    });
    com.tencent.f.h.RTc.aX(paramString);
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39266);
        paramString.gmu();
        MsgRetransmitUI.this.QyG = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39266);
      }
    });
    AppMethodBeat.o(39300);
  }
  
  private static boolean cM(byte[] paramArrayOfByte)
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
  
  private boolean du(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39297);
    if (this.fileName == null)
    {
      AppMethodBeat.o(39297);
      return false;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(this.fileName);
    long l;
    Object localObject1;
    label71:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = com.tencent.mm.vfs.s.boW(this.fileName);
      if (localEmojiInfo != null) {
        break label280;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapUtil.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.n.c.aqo()) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.n.c.aqo())) {
        break label608;
      }
    }
    label280:
    label601:
    label608:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.n.c.aqp()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.getMd5())
        {
          Log.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.QyC = false;
          this.Qyi = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131758534), "", getString(2131761757), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39283);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(39283);
            }
          });
          if (this.Qyt == 1) {
            com.tencent.mm.plugin.report.service.h.CyF.a(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.getMd5(), Integer.valueOf(1) });
          }
          AppMethodBeat.o(39297);
          return true;
          l = com.tencent.mm.vfs.s.boW(localEmojiInfo.hRM());
          break;
          localObject1 = localEmojiInfo.hRM();
          break label71;
        }
      }
      if (this.Qyt == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
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
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject1, "");
      }
      for (localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml((String)localObject1);; localObject1 = localEmojiInfo)
      {
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(2) });
          com.tencent.mm.ui.chatting.k.d((EmojiInfo)localObject1, paramString);
        }
        finish();
        AppMethodBeat.o(39297);
        return true;
        localObject1 = localEmojiInfo.getMd5();
        break;
        if ((localEmojiInfo != null) && (l > com.tencent.mm.n.c.aqm()))
        {
          com.tencent.mm.ui.chatting.k.d(localEmojiInfo, paramString);
          AppMethodBeat.o(39297);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(this, paramString, this.fileName))
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
  
  private void gYe()
  {
    AppMethodBeat.i(39292);
    label181:
    Object localObject6;
    switch (this.Qyl)
    {
    default: 
      Log.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.Qyl) });
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
          break label2852;
        }
        bool3 = true;
        if ((this.msgType != 11) && (this.msgType != 1)) {
          break label1088;
        }
        localObject1 = this.Qyf;
        Log.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
        if ((11 == this.msgType) && (com.tencent.mm.modelvideo.u.QO(this.fileName)))
        {
          com.tencent.mm.ui.widget.snackbar.b.a(this, getResources().getString(2131765235), "", null);
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(39280);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(39280);
            }
          }, 1800L);
        }
        break;
      }
      do
      {
        for (;;)
        {
          if (this.Qys) {
            com.tencent.mm.ui.chatting.l.BM(true);
          }
          AppMethodBeat.o(39292);
          return;
          if (gYf()) {
            break;
          }
          finish();
          i = 0;
          break label181;
          if ((this.dWG != null) && (!this.dWG.equals(""))) {
            break;
          }
          Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          finish();
          i = 0;
          break label181;
          if (!gYf())
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
          if ((this.dWG != null) && (!this.dWG.equals(""))) {
            break;
          }
          Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          localObject3 = new b((byte)0);
          ((b)localObject3).Qza = new LinkedList();
          ((b)localObject3).Qza.addAll((Collection)localObject1);
          localObject4 = com.tencent.mm.modelvideo.u.QN(this.fileName);
          if (localObject4 != null) {
            break label516;
          }
          bg.aVF();
          if (!com.tencent.mm.model.c.aSQ().Hb(this.msgId).cWK()) {
            break label516;
          }
          jY((List)localObject1);
        }
        localObject5 = ((List)localObject1).iterator();
      } while (!((Iterator)localObject5).hasNext());
      localObject6 = (String)((Iterator)localObject5).next();
      if (localObject4 != null)
      {
        localObject1 = ((com.tencent.mm.modelvideo.s)localObject4).getFileName();
        if (localObject4 == null) {
          break label632;
        }
      }
      for (Object localObject2 = Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject4).status);; localObject2 = "")
      {
        Log.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { localObject1, localObject2 });
        if ((localObject4 == null) || (((com.tencent.mm.modelvideo.s)localObject4).status != 199)) {
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
        gYg();
        break;
        Object localObject7 = XmlParser.parseXml(((com.tencent.mm.modelvideo.s)localObject4).bhv(), "msg", null);
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
              com.tencent.mm.modelvideo.o.bhj();
              if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.modelvideo.t.Qw(((com.tencent.mm.modelvideo.s)localObject4).getFileName())))
              {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1328L, 1L, 1L, true);
                i = 0;
                continue;
              }
            }
            localObject7 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject7).taskName = "task_MsgRetransmitUI_3";
            ((com.tencent.mm.i.g)localObject7).gqy = new g.a()
            {
              public final int a(final String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(39276);
                if (paramAnonymousd != null)
                {
                  if (!paramAnonymousd.field_exist_whencheck) {
                    break label375;
                  }
                  paramAnonymousd.field_fileId = this.val$url;
                  paramAnonymousd.field_aesKey = this.JnJ;
                  paramAnonymousd.field_thumbimgLength = k;
                  paramAnonymousd.field_fileLength = i;
                  paramAnonymousd.field_toUser = this.dnJ;
                  paramAnonymousd.field_filemd5 = str1;
                  paramAnonymousd.field_mp4identifymd5 = str2;
                  Log.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
                  paramAnonymousString = com.tencent.mm.modelvideo.t.Qv(this.dnJ);
                  com.tencent.mm.modelvideo.o.bhj();
                  paramAnonymousc = com.tencent.mm.modelvideo.t.Qx(paramAnonymousString);
                  com.tencent.mm.modelvideo.o.bhj();
                  com.tencent.mm.vfs.s.nw(com.tencent.mm.modelvideo.t.Qx(MsgRetransmitUI.this.fileName), paramAnonymousc);
                  paramAnonymousc = "<msg><videomsg aeskey=\"" + this.JnJ + "\" cdnthumbaeskey=\"" + this.JnJ + "\" cdnvideourl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
                  Log.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
                  com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, this.dnJ, paramAnonymousc, this.jqW.jso);
                  paramAnonymousc = com.tencent.mm.av.s.bcY();
                  paramAnonymousc.fileName = paramAnonymousString;
                  paramAnonymousc.jaB = 0;
                  paramAnonymousc.jaC = paramAnonymousd;
                  paramAnonymousc.jaD = new com.tencent.mm.av.f()
                  {
                    public final void dq(int paramAnonymous2Int1, int paramAnonymous2Int2)
                    {
                      AppMethodBeat.i(39275);
                      com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(paramAnonymousString);
                      locals.status = 111;
                      locals.cSx = 256;
                      com.tencent.mm.modelvideo.o.bhj().c(locals);
                      Log.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                      AppMethodBeat.o(39275);
                    }
                  };
                  paramAnonymousc.jdR = 4;
                  paramAnonymousc.bdQ().execute();
                  MsgRetransmitUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(39276);
                  return 0;
                  label375:
                  Log.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                  MsgRetransmitUI.i(MsgRetransmitUI.this);
                }
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            ((com.tencent.mm.i.g)localObject7).field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), (String)localObject6, this.msgId);
            ((com.tencent.mm.i.g)localObject7).field_fileId = ((String)localObject1);
            ((com.tencent.mm.i.g)localObject7).field_aesKey = ((String)localObject2);
            ((com.tencent.mm.i.g)localObject7).field_filemd5 = str1;
            ((com.tencent.mm.i.g)localObject7).field_fileType = 4;
            ((com.tencent.mm.i.g)localObject7).field_talker = ((String)localObject6);
            ((com.tencent.mm.i.g)localObject7).field_priority = com.tencent.mm.i.a.gpM;
            ((com.tencent.mm.i.g)localObject7).field_svr_signature = "";
            ((com.tencent.mm.i.g)localObject7).field_onlycheckexist = true;
            ((com.tencent.mm.i.g)localObject7).field_trysafecdn = true;
            Log.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { localObject1, str1, localObject2, ((com.tencent.mm.modelvideo.s)localObject4).bhv() });
            if (!com.tencent.mm.an.f.baQ().f((com.tencent.mm.i.g)localObject7))
            {
              Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
              finish();
              i = 0;
            }
            else
            {
              this.Qyi = false;
              finish();
              i = 1;
            }
          }
        }
      }
      if (this.msgType == 0) {
        this.Qyx = this.Qyf.size();
      }
      final int i = this.Qyf.size();
      c.hn(this.mSessionId, i);
      localObject1 = this.Qyf.iterator();
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
            if (this.Qys) {
              com.tencent.mm.ui.chatting.l.BM(bool2);
            }
            i = j;
            bool3 = bool1;
            break;
            bool2 = false;
            break label1170;
            bg.aAk().setHighPriority();
            com.tencent.f.h.RTc.b(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(39258);
                Log.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                MsgRetransmitUI.a(MsgRetransmitUI.this, this.gtu);
                AppMethodBeat.o(39258);
              }
            }, "MicroMsg.MsgRetransmitUI");
          }
        case 2: 
        case 16: 
        case 19: 
          bool1 = bnY((String)localObject2);
        }
        for (;;)
        {
          break;
          z.aTY();
          localObject3 = com.tencent.mm.modelmulti.o.Pl((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.dWG;
          localObject2 = ((o.e)localObject3).tD(ab.JG((String)localObject2));
          ((o.e)localObject2).cSx = 0;
          ((o.e)localObject2).jdR = 4;
          ((o.e)localObject2).bdQ().execute();
          bool1 = true;
          continue;
          bool1 = du((String)localObject2, false);
          continue;
          localObject3 = k.b.HD(Util.processXml(this.dWG));
          if (localObject3 == null) {
            Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
          }
          for (bool1 = false;; bool1 = true)
          {
            break;
            a((String)localObject2, (k.b)localObject3, null, null);
          }
          localObject2 = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.s.n((String)localObject2, this.fileName, this.length), 1);
          bg.azz().a((com.tencent.mm.ak.q)localObject2, 0);
          bool1 = true;
          continue;
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.msgId);
          if (((ca)localObject3).getType() == 42)
          {
            Log.d("MicroMsg.MsgRetransmitUI", "set forward flag");
            ((ca)localObject3).gDE();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.msgId, (ca)localObject3);
          }
          localObject3 = ca.a.bkA(this.dWG);
          localObject4 = com.tencent.mm.modelmulti.o.Pl((String)localObject2);
          ((o.e)localObject4).toUser = ((String)localObject2);
          ((o.e)localObject4).content = this.dWG;
          if (as.bjp(((ca.a)localObject3).dkU)) {}
          for (i = 66;; i = 42)
          {
            localObject2 = ((o.e)localObject4).tD(i);
            ((o.e)localObject2).cSx = 1;
            ((o.e)localObject2).jdR = 4;
            ((o.e)localObject2).bdQ().execute();
            bool1 = bool3;
            break;
          }
          localObject3 = com.tencent.mm.modelmulti.o.Pl((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.dWG;
          localObject2 = ((o.e)localObject3).tD(48);
          ((o.e)localObject2).cSx = 0;
          ((o.e)localObject2).jdR = 4;
          ((o.e)localObject2).bdQ().execute();
          bool1 = true;
          continue;
          localObject3 = new rc();
          ((rc)localObject3).dXF.type = 4;
          localObject4 = ((rc)localObject3).dXF;
          bg.aVF();
          ((rc.a)localObject4).dTX = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
          ((rc)localObject3).dXF.toUser = ((String)localObject2);
          EventCenter.instance.publish((IEvent)localObject3);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.l.n(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.l.m(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          localObject3 = new up();
          ((up)localObject3).eaS.dFm = this.msgId;
          ((up)localObject3).eaS.dPu = this.dWG;
          ((up)localObject3).eaS.dPv = ((String)localObject2);
          EventCenter.instance.publish((IEvent)localObject3);
          bool1 = bool3;
          break;
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null)
            {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              localObject2 = (com.tencent.mm.plugin.i.a.f)((k.b)localObject3).as(com.tencent.mm.plugin.i.a.f.class);
              if (localObject2 != null)
              {
                localObject3 = new LinkedList();
                ((List)localObject3).add(new Pair(((com.tencent.mm.plugin.i.a.f)localObject2).jlg.objectId, ((com.tencent.mm.plugin.i.a.f)localObject2).jlg.objectNonceId));
                ((aj)com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport((List)localObject3, false);
              }
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null) {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null) {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null) {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null) {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null)
            {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              localObject2 = (com.tencent.mm.plugin.i.a.i)((k.b)localObject3).as(com.tencent.mm.plugin.i.a.i.class);
              if (localObject2 != null)
              {
                localObject3 = new LinkedList();
                ((List)localObject3).add(new Pair(((com.tencent.mm.plugin.i.a.i)localObject2).jlh.objectId, ((com.tencent.mm.plugin.i.a.i)localObject2).jlh.objectNonceId));
                ((aj)com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport((List)localObject3, true);
              }
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null) {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!Util.isNullOrNil(this.dWG))
          {
            Log.i("MicroMsg.MsgRetransmitUI", "transfer finder poi to %s", new Object[] { localObject2 });
            localObject3 = k.b.HD(this.dWG);
            if (localObject3 != null)
            {
              w.a.aSz().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              bool1 = true;
              continue;
            }
          }
          bool1 = false;
        }
      }
      localObject3 = (String)this.Qyf.get(0);
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
        localObject4 = k.b.HD(Util.processXml(this.dWG));
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
          Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), Integer.valueOf(1), Integer.valueOf(i) });
          if (!bool3) {
            break label3620;
          }
          if (this.Qyi) {
            com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
          }
          localObject1 = new Intent();
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).addAll(this.Qyf);
          ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
          ((Intent)localObject1).putExtra("sendResult", 0);
          setResult(-1, (Intent)localObject1);
          if (this.QyC)
          {
            localObject1 = this.mHandler;
            localObject2 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(39264);
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(39264);
              }
            };
            if (!this.Qyi) {
              break label3614;
            }
          }
        }
      }
      for (long l = 1800L;; l = 0L)
      {
        ((MMHandler)localObject1).postDelayed((Runnable)localObject2, l);
        if ((this.Qyh) && (!this.Qyv))
        {
          localObject1 = new Intent(this, ChattingUI.class);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("Chat_User", (String)localObject3);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(39292);
        return;
        if ((bool3) || (localObject4 == null) || (((k.b)localObject4).type != 33)) {
          break;
        }
        localObject1 = new p();
        ((p)localObject1).dCt.scene = this.QyA;
        ((p)localObject1).dCt.cyo = this.QyB;
        if (2 == this.QyA)
        {
          ((p)localObject1).dCt.dCw = (this.Qyz + ":" + this.PCe);
          if (!((String)localObject3).endsWith("@chatroom")) {
            break label3602;
          }
        }
        for (((p)localObject1).dCt.action = 2;; ((p)localObject1).dCt.action = 1)
        {
          ((p)localObject1).dCt.dCv = (((k.b)localObject4).izz + 1);
          ((p)localObject1).dCt.dCx = ((k.b)localObject4).izh;
          ((p)localObject1).dCt.dCu = ((k.b)localObject4).izi;
          ((p)localObject1).dCt.appId = ((k.b)localObject4).izj;
          ((p)localObject1).dCt.appVersion = ((k.b)localObject4).izA;
          ((p)localObject1).dCt.dCy = "";
          ((p)localObject1).dCt.dCz = Util.nowSecond();
          ((p)localObject1).dCt.dCA = 2;
          ((p)localObject1).dCt.dCC = ((k.b)localObject4).izn;
          EventCenter.instance.publish((IEvent)localObject1);
          break;
          ((p)localObject1).dCt.dCw = this.Qyz;
          break label3444;
        }
      }
      finish();
      AppMethodBeat.o(39292);
      return;
    case 1: 
      label516:
      label559:
      label632:
      localObject1 = (String)this.Qyf.get(0);
      label640:
      label1088:
      label3444:
      if (!gYf())
      {
        finish();
        AppMethodBeat.o(39292);
        return;
      }
      label1170:
      label2852:
      switch (this.msgType)
      {
      default: 
        Log.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        AppMethodBeat.o(39292);
        return;
      case 0: 
        if ((this.Qyo != null) && (this.Qyo.size() > 0)) {
          this.Qyq = this.Qyo.size();
        }
        this.iYO = new com.tencent.mm.ak.j()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(39259);
            if ((MsgRetransmitUI.b(MsgRetransmitUI.this) == null) || (paramAnonymousInt2 == 0))
            {
              AppMethodBeat.o(39259);
              return;
            }
            paramAnonymousInt1 = (int)(paramAnonymousInt1 * 100L / paramAnonymousInt2);
            MsgRetransmitUI.b(MsgRetransmitUI.this).setMessage(MsgRetransmitUI.this.getString(2131763213, new Object[] { Integer.valueOf(MsgRetransmitUI.c(MsgRetransmitUI.this)), Integer.valueOf(MsgRetransmitUI.d(MsgRetransmitUI.this)), Integer.valueOf(paramAnonymousInt1) }));
            Log.i("MicroMsg.MsgRetransmitUI", "onSceneProgress: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            AppMethodBeat.o(39259);
          }
        };
        this.Qyj = com.tencent.mm.ui.base.h.d(this, getString(2131763213, new Object[] { Integer.valueOf(1), Integer.valueOf(this.Qyq), Integer.valueOf(0) }), getString(2131755998), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(39260);
            if (MsgRetransmitUI.b(MsgRetransmitUI.this) != null) {
              MsgRetransmitUI.b(MsgRetransmitUI.this).cancel();
            }
            AppMethodBeat.o(39260);
          }
        });
        Log.i("MicroMsg.MsgRetransmitUI", "show uploadImgDialog : %s", new Object[] { this.Qyj });
        if (this.Qyj != null)
        {
          this.Qyj.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(39263);
              com.tencent.mm.ui.base.h.a(MsgRetransmitUI.this, 2131763207, 2131755998, 2131756033, 2131755917, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(39261);
                  com.tencent.mm.av.i locali;
                  com.tencent.mm.av.g localg;
                  if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null)
                  {
                    bg.azz().a(MsgRetransmitUI.e(MsgRetransmitUI.this));
                    paramAnonymous2Int = (int)MsgRetransmitUI.e(MsgRetransmitUI.this).iYP;
                    paramAnonymous2DialogInterface = com.tencent.mm.av.q.bcR().tl(paramAnonymous2Int);
                    if (paramAnonymous2DialogInterface != null)
                    {
                      locali = com.tencent.mm.av.q.bcR();
                      localg = locali.tl(paramAnonymous2Int);
                      if ((localg != null) && (localg.localId == paramAnonymous2Int)) {
                        break label137;
                      }
                    }
                  }
                  for (;;)
                  {
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().Hc(paramAnonymous2DialogInterface.iXv);
                    Toast.makeText(MsgRetransmitUI.this, 2131763208, 1).show();
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(39261);
                    return;
                    label137:
                    com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXm, "", ""));
                    com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXr, "", ""));
                    com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXo, "", ""));
                    com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXo, "", "") + "hd");
                    locali.iFy.delete(i.d.Ay(paramAnonymous2Int), "id=?", new String[] { String.valueOf(paramAnonymous2Int) });
                    if (localg.bcv())
                    {
                      localg = locali.tl(localg.iXx);
                      if (localg != null)
                      {
                        com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXm, "", ""));
                        com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXr, "", ""));
                        com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXo, "", ""));
                        com.tencent.mm.vfs.s.deleteFile(locali.o(localg.iXo, "", "") + "hd");
                        locali.iFy.delete(i.d.Ay(paramAnonymous2Int), "id=?", new String[] { localg.localId });
                      }
                    }
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(39262);
                  if (MsgRetransmitUI.b(MsgRetransmitUI.this) != null) {
                    MsgRetransmitUI.b(MsgRetransmitUI.this).show();
                  }
                  AppMethodBeat.o(39262);
                }
              });
              AppMethodBeat.o(39263);
            }
          });
          this.Qyj.setCanceledOnTouchOutside(false);
          this.Qyj.getButton(-1).setText(2131755761);
        }
        a((String)localObject1, 6, this.iYO);
        AppMethodBeat.o(39292);
        return;
      case 1: 
      case 11: 
        if (!ag.dm(this))
        {
          com.tencent.mm.ui.base.h.a(this, 2131767069, 2131755998, 2131755921, 2131755761, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39278);
              MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), this.gtu);
              AppMethodBeat.o(39278);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39279);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(39279);
            }
          });
          AppMethodBeat.o(39292);
          return;
        }
        t(getIntent(), (String)localObject1);
        AppMethodBeat.o(39292);
        return;
      }
      label3602:
      label3614:
      label3620:
      du((String)localObject1, true);
      AppMethodBeat.o(39292);
      return;
    }
    switch (this.msgType)
    {
    default: 
      AppMethodBeat.o(39292);
      return;
    }
    this.Qyf.get(0);
    Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName = ((String)localObject1);
    com.tencent.mm.pluginsdk.model.app.ao.eAS().get((IAutoDBItem)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new e(new e.a()
    {
      public final void gYh()
      {
        AppMethodBeat.i(39271);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39271);
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
    localObject1 = View.inflate(this, 2131493155, null);
    ((TextView)((View)localObject1).findViewById(2131309249)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(2131308313)).setText(com.tencent.mm.pluginsdk.model.app.h.a(this, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      ((e)localObject4).kdo = com.tencent.mm.ui.base.h.a(this, null, (View)localObject1, getString(2131755976), getString(2131755761), new e.1((e)localObject4), new e.2((e)localObject4));
      break;
      View localView = View.inflate(this, 2131493154, null);
      ((ImageView)localView.findViewById(2131309073)).setImageBitmap((Bitmap)localObject1);
      ((TextView)localView.findViewById(2131309249)).setText(((WXMediaMessage)localObject5).title);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493153, null);
      ((ImageView)localView.findViewById(2131309073)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131309249);
      localObject6 = (TextView)localView.findViewById(2131299510);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493153, null);
      ((ImageView)localView.findViewById(2131309073)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131309249);
      localObject6 = (TextView)localView.findViewById(2131299510);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493153, null);
      ((ImageView)localView.findViewById(2131309073)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131309249);
      localObject6 = (TextView)localView.findViewById(2131299510);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493153, null);
      ((ImageView)localView.findViewById(2131309073)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131309249);
      localObject6 = (TextView)localView.findViewById(2131299510);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493153, null);
      ((ImageView)localView.findViewById(2131309073)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131309249);
      localObject6 = (TextView)localView.findViewById(2131299510);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
    }
  }
  
  private boolean gYf()
  {
    AppMethodBeat.i(39298);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.u.g(this, null);
      AppMethodBeat.o(39298);
      return false;
    }
    AppMethodBeat.o(39298);
    return true;
  }
  
  private void gYg()
  {
    AppMethodBeat.i(39308);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39273);
        com.tencent.mm.modelvideo.o.bho().a(MsgRetransmitUI.this.fileName, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(39272);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.QN(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199))
            {
              paramAnonymous2a = new MsgRetransmitUI.b((byte)0);
              paramAnonymous2a.Qza = new LinkedList();
              paramAnonymous2a.Qza.addAll(MsgRetransmitUI.this.Qyf);
              Iterator localIterator = MsgRetransmitUI.this.Qyf.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                Log.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", new Object[] { str });
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymous2a, str);
              }
            }
            AppMethodBeat.o(39272);
          }
        });
        AppMethodBeat.o(39273);
      }
    }, "MicroMsg.MsgRetransmitUI");
    this.Qyi = false;
    AppMethodBeat.o(39308);
  }
  
  private void jY(List<String> paramList)
  {
    AppMethodBeat.i(39307);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      bnY((String)paramList.next());
    }
    if (this.Qyi) {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39270);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39270);
      }
    }, 1800L);
    AppMethodBeat.o(39307);
  }
  
  private void t(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(39299);
    if (this.Qyr)
    {
      this.Qyq = this.Qyo.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.QyG) {
            break;
          }
          bnZ(paramString);
        }
        AppMethodBeat.o(39299);
        return;
      }
      finish();
      AppMethodBeat.o(39299);
      return;
    }
    this.Qyq = 1;
    bnZ(paramString);
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
    Object localObject2;
    Object localObject3;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("custom_send_text");
      localObject3 = paramIntent.getStringExtra("Select_Conv_User");
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject3))
      {
        this.Qyf = Util.stringsToList(((String)localObject3).split(","));
        localObject1 = localObject2;
      }
    }
    long l;
    if (this.QyD)
    {
      localObject3 = com.tencent.mm.plugin.selectrecord.b.b.eSz();
      localObject2 = this.Qyf;
      localObject3 = ((com.tencent.mm.plugin.selectrecord.b.b)localObject3).CXf;
      ((gf)localObject3).eJm = ((gf)localObject3).x("ToUsername", Util.listToString((List)localObject2, ";"), true);
      localObject2 = com.tencent.mm.plugin.selectrecord.b.b.eSz();
      if (Util.isNullOrNil((String)localObject1))
      {
        l = 2L;
        ((com.tencent.mm.plugin.selectrecord.b.b)localObject2).CXf.eJi = l;
      }
    }
    else
    {
      if (paramInt2 == -1) {
        break label597;
      }
      localObject1 = k.b.HD(Util.processXml(this.dWG));
      if ((localObject1 == null) || (((k.b)localObject1).type != 5) || (((k.b)localObject1).url == null)) {
        break label372;
      }
      Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject1).url, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), Integer.valueOf(1), Integer.valueOf(3) });
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
    com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), Integer.valueOf(1), Integer.valueOf(3) });
    label372:
    while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
    {
      if (this.QyD) {
        com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
      }
      finish();
      AppMethodBeat.o(39293);
      return;
      l = 1L;
      break;
    }
    paramIntent = new p();
    paramIntent.dCt.cyo = this.QyB;
    paramIntent.dCt.scene = this.QyA;
    if (2 == this.QyA) {}
    for (paramIntent.dCt.dCw = (this.Qyz + ":" + this.PCe);; paramIntent.dCt.dCw = this.Qyz)
    {
      paramIntent.dCt.dCv = (localUnsupportedEncodingException.izz + 1);
      paramIntent.dCt.dCx = localUnsupportedEncodingException.izh;
      paramIntent.dCt.dCu = localUnsupportedEncodingException.izi;
      paramIntent.dCt.appId = localUnsupportedEncodingException.izj;
      paramIntent.dCt.appVersion = localUnsupportedEncodingException.izA;
      paramIntent.dCt.action = 1;
      paramIntent.dCt.dCy = "";
      paramIntent.dCt.dCz = Util.nowSecond();
      paramIntent.dCt.dCA = 3;
      paramIntent.dCt.dCC = localUnsupportedEncodingException.izn;
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
    this.tca = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.tca) {
      this.ppv = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      Log.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    this.QyE = paramIntent.getBooleanExtra("KSendGroupToDo", false);
    this.QyF = paramIntent.getIntExtra("KShowTodoIntroduceView", 0);
    Log.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.Qyl), Integer.valueOf(this.Qyf.size()) });
    gYe();
    if (!TextUtils.isEmpty(localUnsupportedEncodingException))
    {
      paramIntent = this.Qyf.iterator();
      while (paramIntent.hasNext())
      {
        localObject2 = (String)paramIntent.next();
        localObject3 = new tw();
        ((tw)localObject3).eaq.dkV = ((String)localObject2);
        ((tw)localObject3).eaq.content = localUnsupportedEncodingException;
        ((tw)localObject3).eaq.type = ab.JG((String)localObject2);
        ((tw)localObject3).eaq.flags = 0;
        EventCenter.instance.publish((IEvent)localObject3);
      }
    }
    if (this.QyD)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.b.eSz();
      paramIntent.Xk(1);
      paramIntent.bfK();
    }
    AppMethodBeat.o(39293);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39289);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    com.tencent.mm.ui.ao.e(getWindow());
    Log.i("MicroMsg.MsgRetransmitUI", "on activity create");
    this.startTime = Util.nowSecond();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    this.dWG = getIntent().getStringExtra("Retr_Msg_content");
    this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
    this.fileName = getIntent().getStringExtra("Retr_File_Name");
    this.Qyo = getIntent().getStringArrayListExtra("Retr_File_Path_List");
    boolean bool;
    if ((this.Qyo != null) && (this.Qyo.size() > 0))
    {
      bool = true;
      this.Qyr = bool;
      this.iXp = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.Qyl = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.Qyk = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.Qyg = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.Qyh = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.Qyv = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.Qyl != 0) {
        break label795;
      }
      bool = true;
      label258:
      this.Qyw = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.Qyw) {
        this.Qyv = true;
      }
      this.Qyi = getIntent().getBooleanExtra("Retr_show_success_tips", this.Qyv);
      this.Qys = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.PbY = getIntent().getBooleanExtra("is_group_chat", false);
      this.jsz = getIntent().getStringExtra("msg_uuid");
      this.PMs = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.Qyt = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.longtitude = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.latitude = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.iZr = getIntent().getStringExtra("Retr_AttachedContent");
      this.Qyu = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.mSessionId = getIntent().getStringExtra("reportSessionId");
      this.Qyy = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.PCe = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.Qyz = getIntent().getStringExtra("Retr_MsgTalker");
      this.QyA = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.QyB = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      this.QyD = getIntent().getBooleanExtra("Retr_MsgFromMoreSelectRetransmit", false);
      bg.azz().a(110, this);
      if (!com.tencent.mm.compatible.util.d.oD(19)) {
        setContentView(2131493309);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.Qyw) {
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
      paramBundle.putExtra("Retr_Msg_content", this.dWG);
      paramBundle.putExtra("Retr_Msg_thumb_path", this.Qyg);
      paramBundle.putExtra("image_path", this.fileName);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(39289);
      return;
      bool = false;
      break;
      label795:
      bool = false;
      break label258;
      paramBundle.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
      if (this.Qyy == 3) {
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.PMs);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
      continue;
      bg.aVF();
      ca.a locala = com.tencent.mm.model.c.aSQ().aEK(this.dWG);
      if ((locala.dkU == null) || (locala.dkU.length() <= 0)) {
        Log.e("MicroMsg.MsgRetransmitUI", "getView : parse possible friend msg failed");
      }
      if (!ab.rR(locala.IOs))
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
        if (com.tencent.mm.ui.chatting.l.gNx())
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
    if (!this.Qyn) {
      bg.azz().b(110, this);
    }
    super.onDestroy();
    AppMethodBeat.o(39291);
  }
  
  @DoNotCheckLeakForActivities
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(39310);
    Log.i("MicroMsg.MsgRetransmitUI", "errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq.getType() != 110) || (!(paramq instanceof n)))
    {
      AppMethodBeat.o(39310);
      return;
    }
    paramString = (n)paramq;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramq = getIntent().getStringExtra("Retr_KSnsId");
      if (!ab.Eq(paramString.dkV)) {
        break label221;
      }
      localObject = new vn();
      ((vn)localObject).ebK.dRS = paramq;
      EventCenter.instance.publish((IEvent)localObject);
    }
    while ((this.Qyo != null) && (this.Qyo.size() > 1))
    {
      this.Qyo.remove(0);
      paramq = paramString.dkV;
      paramString = paramq;
      if (Util.isNullOrNil(paramq))
      {
        paramString = paramq;
        if (this.Qyf != null) {
          paramString = (String)this.Qyf.get(0);
        }
      }
      a(paramString, 3, this.iYO);
      AppMethodBeat.o(39310);
      return;
      label221:
      localObject = new vo();
      ((vo)localObject).ebL.dRS = paramq;
      EventCenter.instance.publish((IEvent)localObject);
    }
    if (this.Qyj != null)
    {
      this.Qyj.dismiss();
      Log.i("MicroMsg.MsgRetransmitUI", "uploadImgDialog dismissed : %s", new Object[] { this.Qyj.toString() });
      this.Qyj = null;
    }
    this.Qyx -= 1;
    if ((this.Qyx <= 0) || (!this.Qyw))
    {
      this.Qyn = false;
      bg.azz().b(110, this);
      if (this.Qyl != 0)
      {
        finish();
        if ((this.Qyh) && (!this.Qyv))
        {
          paramq = new Intent(this, ChattingUI.class);
          paramq.addFlags(67108864);
          paramq.putExtra("Chat_User", paramString.dkV);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    public boolean QyQ;
    public String QyR;
    public boolean QyS;
    public boolean QyT;
    public boolean QyU;
    public eeq QyV;
    public MsgRetransmitUI.b QyW;
    public int QyX;
    public d.a QyY;
    public boolean Qyi;
    public int Qyk;
    public Context context;
    public String ean;
    public String fileName;
    public String fqK;
    public int iFw;
    public int jqs;
    public String jsz;
    private MMHandler mHandler;
    public Dialog tipDialog;
    public String userName;
    
    public a()
    {
      AppMethodBeat.i(39285);
      this.QyS = true;
      this.QyT = false;
      this.Qyi = false;
      this.QyU = true;
      this.QyV = null;
      this.QyW = null;
      this.mHandler = new MMHandler(Looper.getMainLooper());
      this.QyY = null;
      AppMethodBeat.o(39285);
    }
  }
  
  static final class b
  {
    public List<String> Qza = null;
    boolean dFE = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */