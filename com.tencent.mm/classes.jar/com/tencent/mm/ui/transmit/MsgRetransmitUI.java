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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.i.d;
import com.tencent.mm.av.o.a;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.al;
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
  implements com.tencent.mm.ak.f
{
  private boolean JQT;
  private String KpV;
  private int KzP;
  private int LjA;
  private int LjB;
  private boolean LjC;
  private boolean LjD;
  private boolean LjE;
  private int LjF;
  boolean LjG;
  public List<String> Ljf;
  private String Ljg;
  private boolean Ljh;
  private boolean Lji;
  private com.tencent.mm.ui.widget.a.d Ljj;
  private int Ljk;
  private int Ljl;
  private com.tencent.mm.av.n Ljm;
  private boolean Ljn;
  private List<String> Ljo;
  private int Ljp;
  private int Ljq;
  private boolean Ljr;
  private boolean Ljs;
  private int Ljt;
  private boolean Lju;
  private boolean Ljv;
  private boolean Ljw;
  private int Ljx;
  private int Ljy;
  private String Ljz;
  public String dEU;
  private float dzE;
  private ProgressDialog fOC;
  public String fileName;
  private int icr;
  private com.tencent.mm.ak.g idS;
  private float iev;
  private String iew;
  private String ixk;
  private int length;
  private aq mHandler;
  private String mSessionId;
  public long msgId;
  public int msgType;
  long oex;
  boolean rCv;
  private long startTime;
  private String thumbPath;
  
  public MsgRetransmitUI()
  {
    AppMethodBeat.i(39288);
    this.Ljg = null;
    this.Ljh = true;
    this.Lji = false;
    this.fOC = null;
    this.icr = 0;
    this.Ljk = 0;
    this.Ljl = 0;
    this.Ljm = null;
    this.Ljn = false;
    this.Ljo = null;
    this.idS = null;
    this.Ljp = 0;
    this.Ljq = 0;
    this.Ljr = false;
    this.Ljs = false;
    this.JQT = false;
    this.KzP = -1;
    this.Ljv = true;
    this.Ljw = true;
    this.Ljx = 0;
    this.startTime = 0L;
    this.LjC = true;
    this.LjD = false;
    this.LjE = false;
    this.LjF = 0;
    this.mHandler = new aq(Looper.getMainLooper());
    this.LjG = false;
    AppMethodBeat.o(39288);
  }
  
  private void a(final k.b paramb, final com.tencent.mm.pluginsdk.model.app.c paramc, final bv parambv, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39296);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_MsgRetransmitUI_1";
    localg.fLm = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39282);
        paramc.field_fileFullPath = paramString2;
        if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
        {
          paramc.field_offset = paramAnonymousc.field_finishedLength;
          ao.bJV().a(paramc, new String[0]);
        }
        if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          paramc.field_status = 199L;
          paramc.field_offset = paramc.field_totalLen;
          ao.bJV().a(paramc, new String[0]);
          parambv.setStatus(3);
          bc.aCg();
          com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
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
    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), parambv.field_talker, parambv.field_msgId);
    localg.field_aesKey = paramb.gmb;
    localg.field_fileType = 19;
    localg.field_authKey = paramb.hCO;
    localg.fLp = paramb.hCI;
    localg.field_fullpath = paramString2;
    if (!com.tencent.mm.an.f.aGZ().b(localg, -1)) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
    }
    AppMethodBeat.o(39296);
  }
  
  private void a(b paramb, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(39309);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
    Object localObject = new a();
    getString(2131755906);
    this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39274);
        this.JZg.LjQ = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39274);
      }
    });
    ((a)localObject).context = this;
    ((a)localObject).fileName = this.fileName;
    ((a)localObject).tipDialog = this.fOC;
    ((a)localObject).Ljk = this.Ljk;
    ((a)localObject).hKI = this.length;
    ((a)localObject).ivg = this.msgType;
    ((a)localObject).LjS = false;
    ((a)localObject).userName = paramString;
    ((a)localObject).LjT = true;
    ((a)localObject).Lji = this.Lji;
    ((a)localObject).LjW = paramb;
    paramb = u.Ia(this.fileName);
    if ((paramb != null) && (paramb.ixh != null))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((a)localObject).LjV = paramb.ixh;
      ((a)localObject).eNd = paramb.getUser();
      ((a)localObject).LjX = paramb.iwZ;
    }
    ((a)localObject).execute(new Object[0]);
    cb.aCN().d(cb.hKV, null);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(39309);
      return;
    }
    bc.aCg();
    bv localbv = com.tencent.mm.model.c.azI().ys(this.msgId);
    boolean bool = x.wb(paramString);
    if (bool)
    {
      paramb = a.c.JRU;
      if (!this.Lju) {
        break label319;
      }
    }
    label319:
    for (localObject = a.d.JRY;; localObject = a.d.JRX)
    {
      if (bool) {
        i = r.zC(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localbv, i);
      AppMethodBeat.o(39309);
      return;
      paramb = a.c.JRT;
      break;
    }
  }
  
  private void a(String paramString, int paramInt, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(39301);
    String str2 = v.aAC();
    bc.aCg();
    bv localbv = com.tencent.mm.model.c.azI().ys(this.msgId);
    if (localbv.field_msgId == this.msgId)
    {
      String str1 = localbv.field_content;
      Object localObject1 = null;
      if (localbv.field_msgId > 0L) {
        localObject1 = com.tencent.mm.av.q.aIX().G(localbv.field_talker, localbv.field_msgId);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.av.g)localObject1).doE > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localbv.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.av.q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
        }
      }
      localObject1 = str1;
      if (bu.isNullOrNil(str1))
      {
        localObject1 = str1;
        if (localbv.field_msgSvrId > 0L) {
          localObject1 = ((com.tencent.mm.av.g)localObject2).icA;
        }
      }
      if ((localObject2 != null) && ((((com.tencent.mm.av.g)localObject2).offset < ((com.tencent.mm.av.g)localObject2).hPI) || (((com.tencent.mm.av.g)localObject2).hPI == 0)) && (!this.Ljr))
      {
        paramg = com.tencent.mm.av.q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
        if (!a(paramg, localbv, (String)localObject1, paramInt, paramString, str2)) {
          b(paramg, localbv, (String)localObject1, paramInt, paramString, str2);
        }
        AppMethodBeat.o(39301);
        return;
      }
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.av.g)localObject2).doE;; l = -1L)
      {
        a(paramString, paramInt, str2, (String)localObject1, paramg, l);
        AppMethodBeat.o(39301);
        return;
      }
    }
    a(paramString, paramInt, str2, "", paramg, -1L);
    AppMethodBeat.o(39301);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.ak.g paramg, long paramLong)
  {
    AppMethodBeat.i(39304);
    o.e locale;
    if (!bu.isNullOrNil(this.fileName))
    {
      this.Ljp = 1;
      this.Ljq = 1;
      if (!aYP(this.fileName))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.icr == 1) && (!v.f(this.fileName, paramString1, false))) {
        this.icr = 0;
      }
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 96L, 1L, false);
      locale = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(paramInt);
      locale.dzZ = paramString2;
      locale.toUser = paramString1;
      locale.iey = this.fileName;
      locale.icr = this.icr;
      locale.iiW = paramg;
      locale.dyw = 0;
      locale.icA = paramString3;
      locale.thumbPath = "";
      locale.iiZ = true;
      locale.iiY = 2131231564;
      locale.ije = true;
      locale.ijf = this.Ljt;
      locale.dBu = this.iev;
      locale.dzE = this.dzE;
      locale.iew = this.iew;
      locale.ijb = paramLong;
      locale.ija = this.msgId;
      locale.ijc = this.ixk;
      if (this.Ljl == 1) {}
      for (bool = true;; bool = false)
      {
        locale.gzE = bool;
        locale.iiV = 19;
        paramString1 = locale.aJO();
        this.Ljm = ((com.tencent.mm.av.n)paramString1.iiO);
        paramString1.execute();
        this.Ljn = true;
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.icr) });
        cb.aCN().d(cb.hKU, null);
        AppMethodBeat.o(39304);
        return;
      }
    }
    if (this.Ljr)
    {
      this.Ljp += 1;
      if (!aYP((String)this.Ljo.get(0)))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.icr == 1) && (!v.f((String)this.Ljo.get(0), paramString1, false))) {
        this.icr = 0;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.icr) });
      locale = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(paramInt);
      locale.dzZ = paramString2;
      locale.toUser = paramString1;
      locale.iey = ((String)this.Ljo.get(0));
      locale.icr = this.icr;
      locale.iiW = paramg;
      locale.dyw = 0;
      locale.icA = paramString3;
      locale.thumbPath = "";
      locale.iiZ = true;
      locale.iiY = 2131231564;
      if (this.Ljl != 1) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      locale.gzE = bool;
      locale.iiV = 11;
      paramString1 = locale.aJO();
      this.Ljm = ((com.tencent.mm.av.n)paramString1.iiO);
      this.Ljn = true;
      paramString1.execute();
      cb.aCN().d(cb.hKU, null);
      AppMethodBeat.o(39304);
      return;
    }
  }
  
  private void a(final String paramString, final k.b paramb, final byte[] paramArrayOfByte, bv parambv)
  {
    AppMethodBeat.i(39295);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, paramb.dlu });
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.m.aNj(paramb.dlu);
    if (!bu.isNullOrNil(paramb.hCI)) {
      localObject1 = com.tencent.mm.pluginsdk.model.app.m.c(parambv, paramb.dlu);
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
          bc.aCg();
          localObject2 = com.tencent.mm.pluginsdk.model.app.m.aq(com.tencent.mm.model.c.azY(), paramb.title, paramb.hCD);
          com.tencent.mm.vfs.o.mF(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, (String)localObject2);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramb.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).cZe()) });
        }
      }
    }
    localObject3 = k.b.a(paramb);
    ((k.b)localObject3).hCF = 3;
    if ((parambv != null) && (paramb.type == 6) && (!bu.isNullOrNil(paramb.hCI)) && (localObject1 != null) && ((!com.tencent.mm.vfs.o.fB(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.o.aZR(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
    {
      a((k.b)localObject3, (com.tencent.mm.pluginsdk.model.app.c)localObject1, parambv, paramString, (String)localObject2, paramArrayOfByte);
      AppMethodBeat.o(39295);
      return;
    }
    if ((bu.isNullOrNil((String)localObject2)) && ((paramb.hCG != 0) || (paramb.hCC > 26214400)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(paramb.hCG), Integer.valueOf(paramb.hCC) });
      bc.ajj().a(new com.tencent.mm.pluginsdk.g.c(paramb, null, paramString, new com.tencent.mm.pluginsdk.g.c.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
        {
          AppMethodBeat.i(188206);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new, errMsg:[%s], md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2, bu.aSM(paramAnonymousString3), bu.aSM(paramAnonymousString4), bu.aSM(paramb.gmb), bu.aSM(paramAnonymousString5), bu.aSM(paramAnonymousString6) });
          if (!bu.isNullOrNil(paramAnonymousString4))
          {
            com.tencent.mm.pluginsdk.model.app.m.a(this.LjN, paramb.appId, paramb.appName, paramString, "", paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this), paramAnonymousString4);
            AppMethodBeat.o(188206);
            return;
          }
          com.tencent.mm.ui.base.h.c(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(2131757939), "", true);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(188206);
        }
      }), 0);
      AppMethodBeat.o(39295);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.m.a((k.b)localObject3, paramb.appId, paramb.appName, paramString, (String)localObject2, paramArrayOfByte, this.mSessionId);
    if (((k.b)localObject3).type == 36) {
      if (!paramString.endsWith("chatroom")) {
        break label560;
      }
    }
    label560:
    for (int i = 1;; i = 0)
    {
      paramb = URLEncoder.encode(bu.nullAsNil(((k.b)localObject3).url));
      paramArrayOfByte = URLEncoder.encode(bu.nullAsNil(((k.b)localObject3).title));
      parambv = URLEncoder.encode(bu.nullAsNil(((k.b)localObject3).description));
      localObject1 = URLEncoder.encode(bu.nullAsNil(((k.b)localObject3).hFb));
      com.tencent.mm.plugin.report.service.g.yxI.f(14127, new Object[] { ((k.b)localObject3).appId, ((k.b)localObject3).hFc, localObject1, paramArrayOfByte, parambv, "", paramb, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString });
      AppMethodBeat.o(39295);
      return;
    }
  }
  
  private boolean a(final com.tencent.mm.av.g paramg, final bv parambv, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39302);
    Object localObject = bx.M(paramg.icA, "msg");
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.icA });
      AppMethodBeat.o(39302);
      return false;
    }
    final int j = paramg.icr;
    String str1;
    if (j != 1) {
      str1 = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
    }
    for (final int i = 2;; i = 1)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), str1 });
      if (!bu.isNullOrNil(str1)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(39302);
      return false;
      str1 = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    }
    String str2 = (String)((Map)localObject).get(".msg.img.$aeskey");
    if (bu.isNullOrNil(str2))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
      AppMethodBeat.o(39302);
      return false;
    }
    if (bu.isNullOrNil(com.tencent.mm.an.c.a("downimg", paramg.icw, parambv.field_talker, parambv.field_msgId)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambv.field_msgSvrId) });
      AppMethodBeat.o(39302);
      return false;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$md5");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_MsgRetransmitUI_2";
    localg.fLm = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39267);
        if (paramAnonymousd != null)
        {
          if (!paramAnonymousd.field_exist_whencheck) {
            break label78;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymousd, parambv, paramInt, paramString2, paramString3, paramString1, this.lCn, j);
        }
        for (;;)
        {
          AppMethodBeat.o(39267);
          return 0;
          label78:
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramg, parambv, paramString1, paramInt, paramString2, paramString3);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), paramString2, parambv.field_msgId);
    localg.field_fileId = str1;
    localg.field_aesKey = str2;
    localg.field_filemd5 = ((String)localObject);
    localg.field_fileType = i;
    localg.field_talker = paramString2;
    localg.field_priority = com.tencent.mm.i.a.fKA;
    localg.field_svr_signature = "";
    localg.field_onlycheckexist = true;
    localg.field_trysafecdn = true;
    if (!com.tencent.mm.an.f.aGZ().f(localg))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
      AppMethodBeat.o(39302);
      return false;
    }
    AppMethodBeat.o(39302);
    return true;
  }
  
  /* Error */
  private static boolean aYP(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc_w 1157
    //   7: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 301
    //   13: ldc_w 1159
    //   16: iconst_1
    //   17: anewarray 315	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 649	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: invokestatic 1163	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: new 1165	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 1166	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: iconst_1
    //   51: putfield 1169	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: aconst_null
    //   60: aload 5
    //   62: invokestatic 1175	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: getfield 1178	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: iflt +29 -> 103
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 1181	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: istore_1
    //   86: iload_1
    //   87: iflt +16 -> 103
    //   90: aload 4
    //   92: invokestatic 1184	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   95: ldc_w 1157
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
    //   114: ldc_w 1186
    //   117: iconst_1
    //   118: anewarray 315	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: invokestatic 1120	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: invokestatic 1184	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   132: ldc_w 1157
    //   135: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_3
    //   142: invokestatic 1184	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   145: ldc_w 1157
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
  
  private boolean aYS(final String paramString)
  {
    AppMethodBeat.i(39294);
    final k.b localb = k.b.zb(bu.aSA(this.dEU));
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.dEU, localb });
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(39294);
      return false;
    }
    if ((localb.type == 53) || (localb.type == 57))
    {
      localObject1 = localb.title;
      v.aAC();
      localObject2 = com.tencent.mm.modelmulti.o.Gz(paramString);
      ((o.e)localObject2).toUser = paramString;
      ((o.e)localObject2).content = ((String)localObject1);
      ((o.e)localObject2).type = x.Bb(paramString);
      ((o.e)localObject2).dEu = 0;
      ((o.e)localObject2).iiV = 4;
      ((o.e)localObject2).aJO().execute();
      AppMethodBeat.o(39294);
      return true;
    }
    bc.aCg();
    final bv localbv = com.tencent.mm.model.c.azI().ys(this.msgId);
    if (localbv.fta())
    {
      if (localb.type == 33) {
        com.tencent.mm.ui.chatting.m.b(paramString, localb, ck.c(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        AppMethodBeat.o(39294);
        return true;
        com.tencent.mm.ui.chatting.k.a(this, paramString, this.dEU, localbv.field_isSend, this.JQT);
      }
    }
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool;
    if (this.Ljg == null)
    {
      localObject1 = localObject4;
      if (this.KzP < 0)
      {
        localObject1 = localObject4;
        if (localbv.field_imgPath != null)
        {
          localObject1 = localObject4;
          if (!localbv.field_imgPath.equals(""))
          {
            localObject4 = com.tencent.mm.av.q.aIX().R(localbv.field_imgPath, true);
            localObject1 = localObject2;
            try
            {
              localObject2 = com.tencent.mm.vfs.o.bb((String)localObject4, 0, -1);
              localObject1 = localObject2;
              bool = cJ((byte[])localObject2);
              localObject1 = localObject2;
              if (!bool)
              {
                AppMethodBeat.o(39294);
                return false;
              }
            }
            catch (Exception localException1)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException1.getLocalizedMessage() });
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject4 = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new com.tencent.mm.ah.a();
      }
      ((com.tencent.mm.ah.a)localObject3).hBk = this.LjE;
      localb.a((com.tencent.mm.ah.f)localObject3);
      com.tencent.e.h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39277);
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, localb, this.LjM, localbv);
          AppMethodBeat.o(39277);
        }
      }, "MicroMsg.MsgRetransmitUI");
      break;
      try
      {
        localObject3 = com.tencent.mm.vfs.o.bb(this.Ljg, 0, -1);
        localObject1 = localObject3;
        bool = cJ((byte[])localObject3);
        localObject1 = localObject3;
        if (!bool)
        {
          AppMethodBeat.o(39294);
          return false;
        }
      }
      catch (Exception localException2)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MsgRetransmitUI", localException2, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException2.getLocalizedMessage() });
      }
    }
  }
  
  private void aYT(final String paramString)
  {
    AppMethodBeat.i(39300);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new com.tencent.mm.pluginsdk.model.l(this, null, getIntent(), paramString, 1, new l.a()
    {
      public final void fdq()
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
    com.tencent.e.h.MqF.aO(paramString);
    getString(2131755906);
    this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39266);
        paramString.fdk();
        MsgRetransmitUI.this.LjG = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39266);
      }
    });
    AppMethodBeat.o(39300);
  }
  
  private void b(com.tencent.mm.av.g paramg, bv parambv, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39303);
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = paramg.icr;
    long l1 = com.tencent.mm.av.q.aIX().a(parambv.field_talker, this.fileName, i, paramInt, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.av.g localg = com.tencent.mm.av.q.aIX().c(Long.valueOf(l1));
    localg.pu(1);
    bv localbv = new bv();
    localbv.setType(x.Bc(paramString2));
    localbv.ui(paramString2);
    localbv.kt(1);
    localbv.setStatus(1);
    localbv.uj(((PString)localObject).value);
    localbv.kD(localPInt1.value);
    localbv.kE(localPInt2.value);
    localbv.qN(bl.BQ(localbv.field_talker));
    if (com.tencent.mm.al.g.vz(localbv.field_talker)) {
      parambv.tk(com.tencent.mm.al.a.e.We());
    }
    bc.aCg();
    long l2 = com.tencent.mm.model.c.azI().ar(localbv);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      localg.sq((int)l2);
      com.tencent.mm.av.q.aIX().a(Long.valueOf(l1), localg);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), paramg);
      com.tencent.mm.av.q.aIY().a(paramg.doE, parambv.field_msgId, i, localObject, 2131231564, new e.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.n paramAnonymousn) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
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
              paramAnonymousn = (Map.Entry)paramAnonymousObject.next();
              paramAnonymousString = (Long)paramAnonymousn.getKey();
              paramAnonymousn = (com.tencent.mm.av.g)paramAnonymousn.getValue();
              MsgRetransmitUI.this.fileName = com.tencent.mm.av.q.aIX().o(com.tencent.mm.av.h.c(paramAnonymousn), "", "");
              if (paramAnonymousInt1 != 0)
              {
                bc.aCg();
                com.tencent.mm.model.c.azI().yt(paramAnonymousString.longValue());
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
  
  private static boolean cJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39306);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", new Object[] { Byte.valueOf(paramArrayOfByte[0]), Byte.valueOf(paramArrayOfByte[1]), Byte.valueOf(paramArrayOfByte[2]), Byte.valueOf(paramArrayOfByte[3]), Byte.valueOf(paramArrayOfByte[4]) });
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
  
  private boolean cZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39297);
    if (this.fileName == null)
    {
      AppMethodBeat.o(39297);
      return false;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(this.fileName);
    long l;
    Object localObject1;
    label71:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = com.tencent.mm.vfs.o.aZR(this.fileName);
      if (localEmojiInfo != null) {
        break label280;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.n.b.acp()) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.n.b.acp())) {
        break label608;
      }
    }
    label280:
    label601:
    label608:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.n.b.acq()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.Lj())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.LjC = false;
          this.Lji = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131758246), "", getString(2131760315), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39283);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(39283);
            }
          });
          if (this.Ljt == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.Lj(), Integer.valueOf(1) });
          }
          AppMethodBeat.o(39297);
          return true;
          l = com.tencent.mm.vfs.o.aZR(localEmojiInfo.fSQ());
          break;
          localObject1 = localEmojiInfo.fSQ();
          break label71;
        }
      }
      if (this.Ljt == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
        if (localEmojiInfo == null)
        {
          localObject1 = "";
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), localObject1, Integer.valueOf(1) });
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
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject1, "");
      }
      for (localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci((String)localObject1);; localObject1 = localEmojiInfo)
      {
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).Lj(), Integer.valueOf(2) });
          com.tencent.mm.ui.chatting.k.c((EmojiInfo)localObject1, paramString);
        }
        finish();
        AppMethodBeat.o(39297);
        return true;
        localObject1 = localEmojiInfo.Lj();
        break;
        if ((localEmojiInfo != null) && (l > com.tencent.mm.n.b.acn()))
        {
          com.tencent.mm.ui.chatting.k.c(localEmojiInfo, paramString);
          AppMethodBeat.o(39297);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(this, paramString, this.fileName))
        {
          AppMethodBeat.o(39297);
          return true;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
        AppMethodBeat.o(39297);
        return false;
      }
    }
  }
  
  private void fPl()
  {
    AppMethodBeat.i(39292);
    label181:
    Object localObject6;
    switch (this.Ljl)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.Ljl) });
      finish();
      AppMethodBeat.o(39292);
      return;
    case 0: 
      boolean bool3;
      switch (this.msgType)
      {
      case 3: 
      default: 
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
      case 2: 
      case 6: 
      case 10: 
      case 12: 
      case 13: 
      case 14: 
      case 16: 
        i = 1;
        if (i == 0) {
          break label2308;
        }
        bool3 = true;
        if ((this.msgType != 11) && (this.msgType != 1)) {
          break label1087;
        }
        localObject1 = this.Ljf;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
        if ((11 == this.msgType) && (u.Ic(this.fileName)))
        {
          com.tencent.mm.ui.widget.snackbar.b.a(this, getResources().getString(2131763075), "", null);
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
          if (this.Ljs) {
            com.tencent.mm.ui.chatting.l.xX(true);
          }
          AppMethodBeat.o(39292);
          return;
          if (fPm()) {
            break;
          }
          finish();
          i = 0;
          break label181;
          if ((this.dEU != null) && (!this.dEU.equals(""))) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          finish();
          i = 0;
          break label181;
          if (!fPm())
          {
            finish();
            i = 0;
            break label181;
          }
          if (this.fileName != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
          finish();
          i = 0;
          break label181;
          if ((this.dEU != null) && (!this.dEU.equals(""))) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          localObject3 = new b((byte)0);
          ((b)localObject3).LjZ = new LinkedList();
          ((b)localObject3).LjZ.addAll((Collection)localObject1);
          localObject4 = u.Ia(this.fileName);
          if (localObject4 != null) {
            break label516;
          }
          bc.aCg();
          if (!com.tencent.mm.model.c.azI().ys(this.msgId).cyH()) {
            break label516;
          }
          iV((List)localObject1);
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { localObject1, localObject2 });
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
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
        i = 0;
      }
      final int j;
      while (i == 0)
      {
        fPn();
        break;
        Object localObject7 = bx.M(((com.tencent.mm.modelvideo.s)localObject4).aNt(), "msg");
        if (localObject7 == null)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
          i = 0;
        }
        else
        {
          localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
          if (bu.isNullOrNil((String)localObject1))
          {
            i = 0;
          }
          else
          {
            localObject2 = (String)((Map)localObject7).get(".msg.videomsg.$aeskey");
            final String str1 = (String)((Map)localObject7).get(".msg.videomsg.$md5");
            final String str2 = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
            i = bu.getInt((String)((Map)localObject7).get(".msg.videomsg.$length"), 0);
            j = bu.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
            final int k = bu.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
            if (bu.isNullOrNil(str1))
            {
              com.tencent.mm.modelvideo.o.aNh();
              if (!com.tencent.mm.vfs.o.fB(com.tencent.mm.modelvideo.t.HJ(((com.tencent.mm.modelvideo.s)localObject4).getFileName())))
              {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1328L, 1L, 1L, true);
                i = 0;
                continue;
              }
            }
            localObject7 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject7).fLl = "task_MsgRetransmitUI_3";
            ((com.tencent.mm.i.g)localObject7).fLm = new g.a()
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
                  paramAnonymousd.field_aesKey = this.EyJ;
                  paramAnonymousd.field_thumbimgLength = k;
                  paramAnonymousd.field_fileLength = i;
                  paramAnonymousd.field_toUser = this.cXi;
                  paramAnonymousd.field_filemd5 = str1;
                  paramAnonymousd.field_mp4identifymd5 = str2;
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
                  paramAnonymousString = com.tencent.mm.modelvideo.t.HI(this.cXi);
                  com.tencent.mm.modelvideo.o.aNh();
                  paramAnonymousc = com.tencent.mm.modelvideo.t.HK(paramAnonymousString);
                  com.tencent.mm.modelvideo.o.aNh();
                  com.tencent.mm.vfs.o.mF(com.tencent.mm.modelvideo.t.HK(MsgRetransmitUI.this.fileName), paramAnonymousc);
                  paramAnonymousc = "<msg><videomsg aeskey=\"" + this.EyJ + "\" cdnthumbaeskey=\"" + this.EyJ + "\" cdnvideourl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
                  u.b(paramAnonymousString, j, this.cXi, paramAnonymousc, this.ivJ.iwZ);
                  paramAnonymousc = com.tencent.mm.av.s.aJe();
                  paramAnonymousc.fileName = paramAnonymousString;
                  paramAnonymousc.ifG = 0;
                  paramAnonymousc.ifH = paramAnonymousd;
                  paramAnonymousc.ifI = new com.tencent.mm.av.f()
                  {
                    public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
                    {
                      AppMethodBeat.i(39275);
                      com.tencent.mm.modelvideo.s locals = u.Ia(paramAnonymousString);
                      locals.status = 111;
                      locals.dEu = 256;
                      com.tencent.mm.modelvideo.o.aNh().c(locals);
                      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                      AppMethodBeat.o(39275);
                    }
                  };
                  paramAnonymousc.iiV = 4;
                  paramAnonymousc.aJO().execute();
                  MsgRetransmitUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(39276);
                  return 0;
                  label375:
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                  MsgRetransmitUI.i(MsgRetransmitUI.this);
                }
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            ((com.tencent.mm.i.g)localObject7).field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), (String)localObject6, this.msgId);
            ((com.tencent.mm.i.g)localObject7).field_fileId = ((String)localObject1);
            ((com.tencent.mm.i.g)localObject7).field_aesKey = ((String)localObject2);
            ((com.tencent.mm.i.g)localObject7).field_filemd5 = str1;
            ((com.tencent.mm.i.g)localObject7).field_fileType = 4;
            ((com.tencent.mm.i.g)localObject7).field_talker = ((String)localObject6);
            ((com.tencent.mm.i.g)localObject7).field_priority = com.tencent.mm.i.a.fKA;
            ((com.tencent.mm.i.g)localObject7).field_svr_signature = "";
            ((com.tencent.mm.i.g)localObject7).field_onlycheckexist = true;
            ((com.tencent.mm.i.g)localObject7).field_trysafecdn = true;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { localObject1, str1, localObject2, ((com.tencent.mm.modelvideo.s)localObject4).aNt() });
            if (!com.tencent.mm.an.f.aGZ().f((com.tencent.mm.i.g)localObject7))
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
              finish();
              i = 0;
            }
            else
            {
              this.Lji = false;
              finish();
              i = 1;
            }
          }
        }
      }
      if (this.msgType == 0) {
        this.Ljx = this.Ljf.size();
      }
      final int i = this.Ljf.size();
      localObject1 = this.Ljf.iterator();
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
            if (this.Ljs) {
              com.tencent.mm.ui.chatting.l.xX(bool2);
            }
            i = j;
            bool3 = bool1;
            break;
            bool2 = false;
            break label1161;
            bc.ajU().Mh();
            com.tencent.e.h.MqF.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(39258);
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                MsgRetransmitUI.a(MsgRetransmitUI.this, this.fOj);
                AppMethodBeat.o(39258);
              }
            }, "MicroMsg.MsgRetransmitUI");
          }
        case 2: 
        case 16: 
        case 19: 
          bool1 = aYS((String)localObject2);
        }
        for (;;)
        {
          break;
          v.aAC();
          localObject3 = com.tencent.mm.modelmulti.o.Gz((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.dEU;
          ((o.e)localObject3).type = x.Bb((String)localObject2);
          ((o.e)localObject3).dEu = 0;
          ((o.e)localObject3).iiV = 4;
          ((o.e)localObject3).aJO().execute();
          bool1 = true;
          continue;
          bool1 = cZ((String)localObject2, false);
          continue;
          localObject3 = k.b.zb(bu.aSA(this.dEU));
          if (localObject3 == null) {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
          }
          for (bool1 = false;; bool1 = true)
          {
            break;
            a((String)localObject2, (k.b)localObject3, null, null);
          }
          localObject2 = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.s.o((String)localObject2, this.fileName, this.length), 1);
          bc.ajj().a((com.tencent.mm.ak.n)localObject2, 0);
          bool1 = true;
          continue;
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(this.msgId);
          if (((bv)localObject3).getType() == 42)
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "set forward flag");
            ((bv)localObject3).fvX();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(this.msgId, (bv)localObject3);
          }
          localObject3 = bv.a.aVC(this.dEU);
          localObject4 = com.tencent.mm.modelmulti.o.Gz((String)localObject2);
          ((o.e)localObject4).toUser = ((String)localObject2);
          ((o.e)localObject4).content = this.dEU;
          if (an.aUq(((bv.a)localObject3).cUA)) {}
          for (i = 66;; i = 42)
          {
            ((o.e)localObject4).type = i;
            ((o.e)localObject4).dEu = 1;
            ((o.e)localObject4).iiV = 4;
            ((o.e)localObject4).aJO().execute();
            bool1 = bool3;
            break;
          }
          localObject3 = com.tencent.mm.modelmulti.o.Gz((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.dEU;
          ((o.e)localObject3).type = 48;
          ((o.e)localObject3).dEu = 0;
          ((o.e)localObject3).iiV = 4;
          ((o.e)localObject3).aJO().execute();
          bool1 = true;
          continue;
          localObject3 = new qi();
          ((qi)localObject3).dFS.type = 4;
          localObject4 = ((qi)localObject3).dFS;
          bc.aCg();
          ((qi.a)localObject4).dCi = com.tencent.mm.model.c.azI().ys(this.msgId);
          ((qi)localObject3).dFS.toUser = ((String)localObject2);
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.l.n(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.l.m(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          localObject3 = new tr();
          ((tr)localObject3).dJf.dnX = this.msgId;
          ((tr)localObject3).dJf.dxN = this.dEU;
          ((tr)localObject3).dJf.dxO = ((String)localObject2);
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
          bool1 = bool3;
          break;
          if (!bu.isNullOrNil(this.dEU))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { localObject2 });
            localObject3 = k.b.zb(this.dEU);
            if (localObject3 != null)
            {
              w.a.azs().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              localObject2 = (com.tencent.mm.plugin.i.a.b)((k.b)localObject3).ao(com.tencent.mm.plugin.i.a.b.class);
              if (localObject2 != null)
              {
                localObject3 = new LinkedList();
                ((List)localObject3).add(((com.tencent.mm.plugin.i.a.b)localObject2).ipW.objectId);
                ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).shareStatsReport((List)localObject3);
              }
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!bu.isNullOrNil(this.dEU))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.zb(this.dEU);
            if (localObject3 != null) {
              w.a.azs().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!bu.isNullOrNil(this.dEU))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { localObject2 });
            localObject3 = k.b.zb(this.dEU);
            if (localObject3 != null)
            {
              w.a.azs().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              bool1 = true;
              continue;
            }
          }
          bool1 = false;
        }
      }
      localObject3 = (String)this.Ljf.get(0);
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
        localObject4 = k.b.zb(bu.aSA(this.dEU));
        if ((localObject4 != null) && (((k.b)localObject4).type == 5) && (!bu.isNullOrNil(((k.b)localObject4).url))) {
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
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            i = 2;
          }
        }
        if (bool3)
        {
          i = 1;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.Ljy), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.Ljy), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      while (bool3)
      {
        if (this.Lji) {
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        }
        localObject1 = new Intent();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(this.Ljf);
        ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
        setResult(-1, (Intent)localObject1);
        if (this.LjC) {
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(39264);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(39264);
            }
          }, 1800L);
        }
        if ((this.Ljh) && (!this.Ljv))
        {
          localObject1 = new Intent(this, ChattingUI.class);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("Chat_User", (String)localObject3);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(39292);
        return;
        if ((!bool3) && (localObject4 != null) && (((k.b)localObject4).type == 33))
        {
          localObject1 = new com.tencent.mm.g.a.o();
          ((com.tencent.mm.g.a.o)localObject1).dlh.scene = this.LjA;
          ((com.tencent.mm.g.a.o)localObject1).dlh.cmt = this.LjB;
          if (2 == this.LjA)
          {
            ((com.tencent.mm.g.a.o)localObject1).dlh.dlj = (this.Ljz + ":" + this.KpV);
            if (!((String)localObject3).endsWith("@chatroom")) {
              break label3003;
            }
          }
          for (((com.tencent.mm.g.a.o)localObject1).dlh.action = 2;; ((com.tencent.mm.g.a.o)localObject1).dlh.action = 1)
          {
            ((com.tencent.mm.g.a.o)localObject1).dlh.dli = (((k.b)localObject4).hFr + 1);
            ((com.tencent.mm.g.a.o)localObject1).dlh.dlk = ((k.b)localObject4).hFb;
            ((com.tencent.mm.g.a.o)localObject1).dlh.dkZ = ((k.b)localObject4).hFc;
            ((com.tencent.mm.g.a.o)localObject1).dlh.appId = ((k.b)localObject4).hFd;
            ((com.tencent.mm.g.a.o)localObject1).dlh.dll = "";
            ((com.tencent.mm.g.a.o)localObject1).dlh.dlm = bu.aRi();
            ((com.tencent.mm.g.a.o)localObject1).dlh.dln = 2;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
            break;
            ((com.tencent.mm.g.a.o)localObject1).dlh.dlj = this.Ljz;
            break label2871;
          }
        }
      }
      finish();
      AppMethodBeat.o(39292);
      return;
    case 1: 
      label516:
      label559:
      label632:
      localObject1 = (String)this.Ljf.get(0);
      label640:
      label1087:
      if (!fPm())
      {
        finish();
        AppMethodBeat.o(39292);
        return;
      }
      label1161:
      label2871:
      label3003:
      switch (this.msgType)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        AppMethodBeat.o(39292);
        return;
      case 0: 
        if ((this.Ljo != null) && (this.Ljo.size() > 0)) {
          this.Ljq = this.Ljo.size();
        }
        this.idS = new com.tencent.mm.ak.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(39259);
            if ((MsgRetransmitUI.b(MsgRetransmitUI.this) == null) || (paramAnonymousInt2 == 0))
            {
              AppMethodBeat.o(39259);
              return;
            }
            paramAnonymousInt1 = (int)(paramAnonymousInt1 * 100L / paramAnonymousInt2);
            MsgRetransmitUI.b(MsgRetransmitUI.this).setMessage(MsgRetransmitUI.this.getString(2131761378, new Object[] { Integer.valueOf(MsgRetransmitUI.c(MsgRetransmitUI.this)), Integer.valueOf(MsgRetransmitUI.d(MsgRetransmitUI.this)), Integer.valueOf(paramAnonymousInt1) }));
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "onSceneProgress: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            AppMethodBeat.o(39259);
          }
        };
        this.Ljj = com.tencent.mm.ui.base.h.d(this, getString(2131761378, new Object[] { Integer.valueOf(1), Integer.valueOf(this.Ljq), Integer.valueOf(0) }), getString(2131755906), new DialogInterface.OnClickListener()
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "show uploadImgDialog : %s", new Object[] { this.Ljj });
        if (this.Ljj != null)
        {
          this.Ljj.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(39263);
              com.tencent.mm.ui.base.h.a(MsgRetransmitUI.this, 2131761372, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(39261);
                  com.tencent.mm.av.i locali;
                  com.tencent.mm.av.g localg;
                  if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null)
                  {
                    bc.ajj().a(MsgRetransmitUI.e(MsgRetransmitUI.this));
                    paramAnonymous2Int = (int)MsgRetransmitUI.e(MsgRetransmitUI.this).idT;
                    paramAnonymous2DialogInterface = com.tencent.mm.av.q.aIX().pw(paramAnonymous2Int);
                    if (paramAnonymous2DialogInterface != null)
                    {
                      locali = com.tencent.mm.av.q.aIX();
                      localg = locali.pw(paramAnonymous2Int);
                      if ((localg != null) && (localg.doE == paramAnonymous2Int)) {
                        break label137;
                      }
                    }
                  }
                  for (;;)
                  {
                    bc.aCg();
                    com.tencent.mm.model.c.azI().yt(paramAnonymous2DialogInterface.icx);
                    Toast.makeText(MsgRetransmitUI.this, 2131761373, 1).show();
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(39261);
                    return;
                    label137:
                    com.tencent.mm.vfs.o.deleteFile(locali.o(localg.ico, "", ""));
                    com.tencent.mm.vfs.o.deleteFile(locali.o(localg.ict, "", ""));
                    com.tencent.mm.vfs.o.deleteFile(locali.o(localg.icq, "", ""));
                    com.tencent.mm.vfs.o.deleteFile(locali.o(localg.icq, "", "") + "hd");
                    locali.hKK.delete(i.d.ss(paramAnonymous2Int), "id=?", new String[] { String.valueOf(paramAnonymous2Int) });
                    if (localg.aIB())
                    {
                      localg = locali.pw(localg.icz);
                      if (localg != null)
                      {
                        com.tencent.mm.vfs.o.deleteFile(locali.o(localg.ico, "", ""));
                        com.tencent.mm.vfs.o.deleteFile(locali.o(localg.ict, "", ""));
                        com.tencent.mm.vfs.o.deleteFile(locali.o(localg.icq, "", ""));
                        com.tencent.mm.vfs.o.deleteFile(locali.o(localg.icq, "", "") + "hd");
                        locali.hKK.delete(i.d.ss(paramAnonymous2Int), "id=?", new String[] { localg.doE });
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
          this.Ljj.setCanceledOnTouchOutside(false);
          this.Ljj.getButton(-1).setText(2131755691);
        }
        a((String)localObject1, 6, this.idS);
        AppMethodBeat.o(39292);
        return;
      case 1: 
      case 11: 
        if (!com.tencent.mm.network.ae.cR(this))
        {
          com.tencent.mm.ui.base.h.a(this, 2131764676, 2131755906, 2131755835, 2131755691, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39278);
              MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), this.fOj);
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
        v(getIntent(), (String)localObject1);
        AppMethodBeat.o(39292);
        return;
      }
      label2308:
      cZ((String)localObject1, true);
      AppMethodBeat.o(39292);
      return;
    }
    switch (this.msgType)
    {
    default: 
      AppMethodBeat.o(39292);
      return;
    }
    this.Ljf.get(0);
    Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName = ((String)localObject1);
    ao.dBg().get((com.tencent.mm.sdk.e.c)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new c(new c.a()
    {
      public final void fPo()
      {
        AppMethodBeat.i(39271);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39271);
      }
    });
    if (((WXMediaMessage)localObject5).thumbData == null) {}
    for (localObject1 = null;; localObject1 = com.tencent.mm.sdk.platformtools.h.cu(((WXMediaMessage)localObject5).thumbData)) {
      switch (((WXMediaMessage)localObject5).mediaObject.type())
      {
      default: 
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + ((WXMediaMessage)localObject5).mediaObject.type());
        AppMethodBeat.o(39292);
        return;
      }
    }
    localObject1 = View.inflate(this, 2131493113, null);
    ((TextView)((View)localObject1).findViewById(2131305948)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(2131305134)).setText(com.tencent.mm.pluginsdk.model.app.h.a(this, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      ((c)localObject4).jfl = com.tencent.mm.ui.base.h.a(this, null, (View)localObject1, getString(2131755884), getString(2131755691), new c.1((c)localObject4), new c.2((c)localObject4));
      break;
      View localView = View.inflate(this, 2131493112, null);
      ((ImageView)localView.findViewById(2131305798)).setImageBitmap((Bitmap)localObject1);
      ((TextView)localView.findViewById(2131305948)).setText(((WXMediaMessage)localObject5).title);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493111, null);
      ((ImageView)localView.findViewById(2131305798)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131305948);
      localObject6 = (TextView)localView.findViewById(2131299008);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493111, null);
      ((ImageView)localView.findViewById(2131305798)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131305948);
      localObject6 = (TextView)localView.findViewById(2131299008);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493111, null);
      ((ImageView)localView.findViewById(2131305798)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131305948);
      localObject6 = (TextView)localView.findViewById(2131299008);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493111, null);
      ((ImageView)localView.findViewById(2131305798)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131305948);
      localObject6 = (TextView)localView.findViewById(2131299008);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2131493111, null);
      ((ImageView)localView.findViewById(2131305798)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131305948);
      localObject6 = (TextView)localView.findViewById(2131299008);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
    }
  }
  
  private boolean fPm()
  {
    AppMethodBeat.i(39298);
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.t.g(this, null);
      AppMethodBeat.o(39298);
      return false;
    }
    AppMethodBeat.o(39298);
    return true;
  }
  
  private void fPn()
  {
    AppMethodBeat.i(39308);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39273);
        com.tencent.mm.modelvideo.o.aNm().a(MsgRetransmitUI.this.fileName, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(39272);
            paramAnonymous2a = u.Ia(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199))
            {
              paramAnonymous2a = new MsgRetransmitUI.b((byte)0);
              paramAnonymous2a.LjZ = new LinkedList();
              paramAnonymous2a.LjZ.addAll(MsgRetransmitUI.this.Ljf);
              Iterator localIterator = MsgRetransmitUI.this.Ljf.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", new Object[] { str });
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymous2a, str);
              }
            }
            AppMethodBeat.o(39272);
          }
        });
        AppMethodBeat.o(39273);
      }
    }, "MicroMsg.MsgRetransmitUI");
    this.Lji = false;
    AppMethodBeat.o(39308);
  }
  
  private void iV(List<String> paramList)
  {
    AppMethodBeat.i(39307);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      aYS((String)paramList.next());
    }
    if (this.Lji) {
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
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
  
  private void v(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(39299);
    if (this.Ljr)
    {
      this.Ljq = this.Ljo.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.LjG) {
            break;
          }
          aYT(paramString);
        }
        AppMethodBeat.o(39299);
        return;
      }
      finish();
      AppMethodBeat.o(39299);
      return;
    }
    this.Ljq = 1;
    aYT(paramString);
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
      if (!bu.isNullOrNil((String)localObject3))
      {
        this.Ljf = bu.U(((String)localObject3).split(","));
        localObject1 = localObject2;
      }
    }
    long l;
    if (this.LjD)
    {
      localObject3 = com.tencent.mm.plugin.selectrecord.b.b.dQy();
      localObject2 = this.Ljf;
      localObject3 = ((com.tencent.mm.plugin.selectrecord.b.b)localObject3).ySp;
      ((dk)localObject3).eht = ((dk)localObject3).t("ToUsername", bu.m((List)localObject2, ";"), true);
      localObject2 = com.tencent.mm.plugin.selectrecord.b.b.dQy();
      if (bu.isNullOrNil((String)localObject1))
      {
        l = 2L;
        ((com.tencent.mm.plugin.selectrecord.b.b)localObject2).ySp.ehp = l;
      }
    }
    else
    {
      if (paramInt2 == -1) {
        break label573;
      }
      localObject1 = k.b.zb(bu.aSA(this.dEU));
      if ((localObject1 == null) || (((k.b)localObject1).type != 5) || (((k.b)localObject1).url == null)) {
        break label372;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject1).url, Long.valueOf(this.startTime), Integer.valueOf(this.Ljy), Integer.valueOf(1), Integer.valueOf(3) });
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
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.Ljy), Integer.valueOf(1), Integer.valueOf(3) });
    label372:
    while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
    {
      if (this.LjD) {
        com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
      }
      finish();
      AppMethodBeat.o(39293);
      return;
      l = 1L;
      break;
    }
    paramIntent = new com.tencent.mm.g.a.o();
    paramIntent.dlh.cmt = this.LjB;
    paramIntent.dlh.scene = this.LjA;
    if (2 == this.LjA) {}
    for (paramIntent.dlh.dlj = (this.Ljz + ":" + this.KpV);; paramIntent.dlh.dlj = this.Ljz)
    {
      paramIntent.dlh.dli = (localUnsupportedEncodingException.hFr + 1);
      paramIntent.dlh.dlk = localUnsupportedEncodingException.hFb;
      paramIntent.dlh.dkZ = localUnsupportedEncodingException.hFc;
      paramIntent.dlh.appId = localUnsupportedEncodingException.hFd;
      paramIntent.dlh.action = 1;
      paramIntent.dlh.dll = "";
      paramIntent.dlh.dlm = bu.aRi();
      paramIntent.dlh.dln = 3;
      com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
      break;
    }
    label573:
    if (paramInt1 != 0)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(39293);
      return;
    }
    this.rCv = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.rCv) {
      this.oex = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    this.LjE = paramIntent.getBooleanExtra("KSendGroupToDo", false);
    this.LjF = paramIntent.getIntExtra("KShowTodoIntroduceView", 0);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.Ljl), Integer.valueOf(this.Ljf.size()) });
    fPl();
    if (!TextUtils.isEmpty(localUnsupportedEncodingException))
    {
      paramIntent = this.Ljf.iterator();
      while (paramIntent.hasNext())
      {
        localObject2 = (String)paramIntent.next();
        localObject3 = new sy();
        ((sy)localObject3).dID.cUB = ((String)localObject2);
        ((sy)localObject3).dID.content = localUnsupportedEncodingException;
        ((sy)localObject3).dID.type = x.Bb((String)localObject2);
        ((sy)localObject3).dID.flags = 0;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    if (this.LjD)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.b.dQy();
      paramIntent.PG(1);
      paramIntent.aLH();
    }
    AppMethodBeat.o(39293);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39289);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    al.b(getWindow());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "on activity create");
    this.startTime = bu.aRi();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    this.dEU = getIntent().getStringExtra("Retr_Msg_content");
    this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
    this.fileName = getIntent().getStringExtra("Retr_File_Name");
    this.Ljo = getIntent().getStringArrayListExtra("Retr_File_Path_List");
    boolean bool;
    if ((this.Ljo != null) && (this.Ljo.size() > 0))
    {
      bool = true;
      this.Ljr = bool;
      this.icr = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.Ljl = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.Ljk = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.Ljg = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.Ljh = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.Ljv = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.Ljl != 0) {
        break label783;
      }
      bool = true;
      label258:
      this.Ljw = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.Ljw) {
        this.Ljv = true;
      }
      this.Lji = getIntent().getBooleanExtra("Retr_show_success_tips", this.Ljv);
      this.Ljs = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.JQT = getIntent().getBooleanExtra("is_group_chat", false);
      this.ixk = getIntent().getStringExtra("msg_uuid");
      this.KzP = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.Ljt = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.iev = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.dzE = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.iew = getIntent().getStringExtra("Retr_AttachedContent");
      this.Lju = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.mSessionId = getIntent().getStringExtra("reportSessionId");
      this.Ljy = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.KpV = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.Ljz = getIntent().getStringExtra("Retr_MsgTalker");
      this.LjA = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.LjB = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      this.LjD = getIntent().getBooleanExtra("Retr_MsgFromMoreSelectRetransmit", false);
      bc.ajj().a(110, this);
      if (!com.tencent.mm.compatible.util.d.lA(19)) {
        setContentView(2131493233);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.Ljw) {
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
      paramBundle.putExtra("Retr_Msg_content", this.dEU);
      paramBundle.putExtra("image_path", this.fileName);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(39289);
      return;
      bool = false;
      break;
      label783:
      bool = false;
      break label258;
      paramBundle.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
      if (this.Ljy == 3) {
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.KzP);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
      continue;
      bc.aCg();
      bv.a locala = com.tencent.mm.model.c.azI().arp(this.dEU);
      if ((locala.cUA == null) || (locala.cUA.length() <= 0)) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MsgRetransmitUI", "getView : parse possible friend msg failed");
      }
      if (!x.oq(locala.Ecg))
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
        if (com.tencent.mm.ui.chatting.l.fFp())
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MsgRetransmitUI", "has can forward card");
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
    if (!this.Ljn) {
      bc.ajj().b(110, this);
    }
    super.onDestroy();
    AppMethodBeat.o(39291);
  }
  
  @com.tencent.mm.sdk.platformtools.l
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(39310);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn.getType() != 110) || (!(paramn instanceof com.tencent.mm.av.n)))
    {
      AppMethodBeat.o(39310);
      return;
    }
    paramString = (com.tencent.mm.av.n)paramn;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramn = getIntent().getStringExtra("Retr_KSnsId");
      if (!x.wb(paramString.cUB)) {
        break label221;
      }
      localObject = new up();
      ((up)localObject).dJX.dAg = paramn;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    while ((this.Ljo != null) && (this.Ljo.size() > 1))
    {
      this.Ljo.remove(0);
      paramn = paramString.cUB;
      paramString = paramn;
      if (bu.isNullOrNil(paramn))
      {
        paramString = paramn;
        if (this.Ljf != null) {
          paramString = (String)this.Ljf.get(0);
        }
      }
      a(paramString, 3, this.idS);
      AppMethodBeat.o(39310);
      return;
      label221:
      localObject = new uq();
      ((uq)localObject).dJY.dAg = paramn;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if (this.Ljj != null)
    {
      this.Ljj.dismiss();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MsgRetransmitUI", "uploadImgDialog dismissed : %s", new Object[] { this.Ljj.toString() });
      this.Ljj = null;
    }
    this.Ljx -= 1;
    if ((this.Ljx <= 0) || (!this.Ljw))
    {
      this.Ljn = false;
      bc.ajj().b(110, this);
      if (this.Ljl != 0)
      {
        finish();
        if ((this.Ljh) && (!this.Ljv))
        {
          paramn = new Intent(this, ChattingUI.class);
          paramn.addFlags(67108864);
          paramn.putExtra("Chat_User", paramString.cUB);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
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
    public boolean LjQ;
    public String LjR;
    public boolean LjS;
    public boolean LjT;
    public boolean LjU;
    public dld LjV;
    public MsgRetransmitUI.b LjW;
    public int LjX;
    public boolean Lji;
    public int Ljk;
    public Context context;
    public String dIA;
    public String eNd;
    public String fileName;
    public int hKI;
    public int ivg;
    public String ixk;
    private aq mHandler;
    public Dialog tipDialog;
    public String userName;
    
    public a()
    {
      AppMethodBeat.i(39285);
      this.LjS = true;
      this.LjT = false;
      this.Lji = false;
      this.LjU = true;
      this.LjV = null;
      this.LjW = null;
      this.mHandler = new aq(Looper.getMainLooper());
      AppMethodBeat.o(39285);
    }
  }
  
  static final class b
  {
    public List<String> LjZ = null;
    boolean doq = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */