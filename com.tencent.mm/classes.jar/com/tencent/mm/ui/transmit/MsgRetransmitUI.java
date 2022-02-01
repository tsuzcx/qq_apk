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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.i.d;
import com.tencent.mm.aw.o.a;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.um;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.ci;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.network.ae;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
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
  implements com.tencent.mm.al.f
{
  private boolean Jwd;
  public List<String> KMH;
  private String KMI;
  private boolean KMJ;
  private boolean KMK;
  private com.tencent.mm.ui.widget.a.d KML;
  private int KMM;
  private int KMN;
  private com.tencent.mm.aw.n KMO;
  private boolean KMP;
  private List<String> KMQ;
  private int KMR;
  private int KMS;
  private boolean KMT;
  private boolean KMU;
  private int KMV;
  private boolean KMW;
  private boolean KMX;
  private boolean KMY;
  private int KMZ;
  private int KNa;
  private String KNb;
  private String KNc;
  private int KNd;
  private int KNe;
  private boolean KNf;
  private boolean KNg;
  private int KNh;
  boolean KNi;
  private int Kdw;
  public String dDP;
  private float dyz;
  private ProgressDialog fMu;
  public String fileName;
  private int hZz;
  private com.tencent.mm.al.g iaZ;
  private float ibC;
  private String ibD;
  private String iuq;
  private int length;
  private ap mHandler;
  private String mSessionId;
  public long msgId;
  public int msgType;
  long nYO;
  boolean ruj;
  private long startTime;
  private String thumbPath;
  
  public MsgRetransmitUI()
  {
    AppMethodBeat.i(39288);
    this.KMI = null;
    this.KMJ = true;
    this.KMK = false;
    this.fMu = null;
    this.hZz = 0;
    this.KMM = 0;
    this.KMN = 0;
    this.KMO = null;
    this.KMP = false;
    this.KMQ = null;
    this.iaZ = null;
    this.KMR = 0;
    this.KMS = 0;
    this.KMT = false;
    this.KMU = false;
    this.Jwd = false;
    this.Kdw = -1;
    this.KMX = true;
    this.KMY = true;
    this.KMZ = 0;
    this.startTime = 0L;
    this.KNf = true;
    this.KNg = false;
    this.KNh = 0;
    this.mHandler = new ap(Looper.getMainLooper());
    this.KNi = false;
    AppMethodBeat.o(39288);
  }
  
  private void a(final k.b paramb, final com.tencent.mm.pluginsdk.model.app.c paramc, final bu parambu, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39296);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_MsgRetransmitUI_1";
    localg.fJj = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39282);
        paramc.field_fileFullPath = paramString2;
        if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
        {
          paramc.field_offset = paramAnonymousc.field_finishedLength;
          ao.bIX().a(paramc, new String[0]);
        }
        if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          paramc.field_status = 199L;
          paramc.field_offset = paramc.field_totalLen;
          ao.bIX().a(paramc, new String[0]);
          parambu.setStatus(3);
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
          m.a(paramb, paramb.appId, paramb.appName, paramString1, paramString2, paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this));
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
    localg.field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), parambu.field_talker, parambu.field_msgId);
    localg.field_aesKey = paramb.gjI;
    localg.field_fileType = 19;
    localg.field_authKey = paramb.hAa;
    localg.fJm = paramb.hzU;
    localg.field_fullpath = paramString2;
    if (!com.tencent.mm.ao.f.aGI().b(localg, -1)) {
      ad.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
    }
    AppMethodBeat.o(39296);
  }
  
  private void a(b paramb, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(39309);
    ad.m("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
    Object localObject = new a();
    getString(2131755906);
    this.fMu = com.tencent.mm.ui.base.h.b(this, getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39274);
        this.JEp.KNs = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39274);
      }
    });
    ((a)localObject).context = this;
    ((a)localObject).fileName = this.fileName;
    ((a)localObject).tipDialog = this.fMu;
    ((a)localObject).KMM = this.KMM;
    ((a)localObject).hHQ = this.length;
    ((a)localObject).ism = this.msgType;
    ((a)localObject).KNu = false;
    ((a)localObject).userName = paramString;
    ((a)localObject).KNv = true;
    ((a)localObject).KMK = this.KMK;
    ((a)localObject).KNy = paramb;
    paramb = com.tencent.mm.modelvideo.u.Hy(this.fileName);
    if ((paramb != null) && (paramb.iun != null))
    {
      ad.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((a)localObject).KNx = paramb.iun;
      ((a)localObject).eLs = paramb.getUser();
      ((a)localObject).KNz = paramb.iuf;
    }
    ((a)localObject).execute(new Object[0]);
    bz.aCx().d(bz.hId, null);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(39309);
      return;
    }
    ba.aBQ();
    bu localbu = com.tencent.mm.model.c.azs().xY(this.msgId);
    boolean bool = com.tencent.mm.model.w.vF(paramString);
    if (bool)
    {
      paramb = a.c.Jxe;
      if (!this.KMW) {
        break label319;
      }
    }
    label319:
    for (localObject = a.d.Jxi;; localObject = a.d.Jxh)
    {
      if (bool) {
        i = com.tencent.mm.model.q.yS(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localbu, i);
      AppMethodBeat.o(39309);
      return;
      paramb = a.c.Jxd;
      break;
    }
  }
  
  private void a(String paramString, int paramInt, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(39301);
    String str2 = com.tencent.mm.model.u.aAm();
    ba.aBQ();
    bu localbu = com.tencent.mm.model.c.azs().xY(this.msgId);
    if (localbu.field_msgId == this.msgId)
    {
      String str1 = localbu.field_content;
      Object localObject1 = null;
      if (localbu.field_msgId > 0L) {
        localObject1 = com.tencent.mm.aw.q.aIF().G(localbu.field_talker, localbu.field_msgId);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.aw.g)localObject1).dnz > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localbu.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.aw.q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
        }
      }
      localObject1 = str1;
      if (bt.isNullOrNil(str1))
      {
        localObject1 = str1;
        if (localbu.field_msgSvrId > 0L) {
          localObject1 = ((com.tencent.mm.aw.g)localObject2).hZI;
        }
      }
      if ((localObject2 != null) && ((((com.tencent.mm.aw.g)localObject2).offset < ((com.tencent.mm.aw.g)localObject2).hMP) || (((com.tencent.mm.aw.g)localObject2).hMP == 0)) && (!this.KMT))
      {
        paramg = com.tencent.mm.aw.q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
        if (!a(paramg, localbu, (String)localObject1, paramInt, paramString, str2)) {
          b(paramg, localbu, (String)localObject1, paramInt, paramString, str2);
        }
        AppMethodBeat.o(39301);
        return;
      }
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.aw.g)localObject2).dnz;; l = -1L)
      {
        a(paramString, paramInt, str2, (String)localObject1, paramg, l);
        AppMethodBeat.o(39301);
        return;
      }
    }
    a(paramString, paramInt, str2, "", paramg, -1L);
    AppMethodBeat.o(39301);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.al.g paramg, long paramLong)
  {
    AppMethodBeat.i(39304);
    o.e locale;
    if (!bt.isNullOrNil(this.fileName))
    {
      this.KMR = 1;
      this.KMS = 1;
      if (!aXo(this.fileName))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.hZz == 1) && (!com.tencent.mm.model.u.f(this.fileName, paramString1, false))) {
        this.hZz = 0;
      }
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, 96L, 1L, false);
      locale = com.tencent.mm.modelmulti.o.a(o.d.ifX).pk(paramInt);
      locale.dyU = paramString2;
      locale.toUser = paramString1;
      locale.ibF = this.fileName;
      locale.hZz = this.hZz;
      locale.igd = paramg;
      locale.dxr = 0;
      locale.hZI = paramString3;
      locale.thumbPath = "";
      locale.igg = true;
      locale.igf = 2131231564;
      locale.igl = true;
      locale.igm = this.KMV;
      locale.dAp = this.ibC;
      locale.dyz = this.dyz;
      locale.ibD = this.ibD;
      locale.igi = paramLong;
      locale.igh = this.msgId;
      locale.igj = this.iuq;
      if (this.KMN == 1) {}
      for (bool = true;; bool = false)
      {
        locale.gwX = bool;
        locale.igc = 19;
        paramString1 = locale.aJv();
        this.KMO = ((com.tencent.mm.aw.n)paramString1.ifV);
        paramString1.execute();
        this.KMP = true;
        ad.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.hZz) });
        bz.aCx().d(bz.hIc, null);
        AppMethodBeat.o(39304);
        return;
      }
    }
    if (this.KMT)
    {
      this.KMR += 1;
      if (!aXo((String)this.KMQ.get(0)))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.hZz == 1) && (!com.tencent.mm.model.u.f((String)this.KMQ.get(0), paramString1, false))) {
        this.hZz = 0;
      }
      ad.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.hZz) });
      locale = com.tencent.mm.modelmulti.o.a(o.d.ifX).pk(paramInt);
      locale.dyU = paramString2;
      locale.toUser = paramString1;
      locale.ibF = ((String)this.KMQ.get(0));
      locale.hZz = this.hZz;
      locale.igd = paramg;
      locale.dxr = 0;
      locale.hZI = paramString3;
      locale.thumbPath = "";
      locale.igg = true;
      locale.igf = 2131231564;
      if (this.KMN != 1) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      locale.gwX = bool;
      locale.igc = 11;
      paramString1 = locale.aJv();
      this.KMO = ((com.tencent.mm.aw.n)paramString1.ifV);
      this.KMP = true;
      paramString1.execute();
      bz.aCx().d(bz.hIc, null);
      AppMethodBeat.o(39304);
      return;
    }
  }
  
  private void a(final String paramString, final k.b paramb, final byte[] paramArrayOfByte, bu parambu)
  {
    AppMethodBeat.i(39295);
    ad.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, paramb.dks });
    Object localObject1 = m.aLN(paramb.dks);
    if (!bt.isNullOrNil(paramb.hzU)) {
      localObject1 = m.c(parambu, paramb.dks);
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
          ba.aBQ();
          localObject2 = m.aq(com.tencent.mm.model.c.azI(), paramb.title, paramb.hzP);
          com.tencent.mm.vfs.i.mz(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, (String)localObject2);
          ad.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramb.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).cWz()) });
        }
      }
    }
    localObject3 = k.b.a(paramb);
    ((k.b)localObject3).hzR = 3;
    if ((parambu != null) && (paramb.type == 6) && (!bt.isNullOrNil(paramb.hzU)) && (localObject1 != null) && ((!com.tencent.mm.vfs.i.fv(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.i.aYo(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
    {
      a((k.b)localObject3, (com.tencent.mm.pluginsdk.model.app.c)localObject1, parambu, paramString, (String)localObject2, paramArrayOfByte);
      AppMethodBeat.o(39295);
      return;
    }
    if ((bt.isNullOrNil((String)localObject2)) && ((paramb.hzS != 0) || (paramb.hzO > 26214400)))
    {
      ad.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(paramb.hzS), Integer.valueOf(paramb.hzO) });
      ba.aiU().a(new com.tencent.mm.pluginsdk.g.c(paramb, null, paramString, new com.tencent.mm.pluginsdk.g.c.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
        {
          AppMethodBeat.i(194804);
          ad.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new, errMsg:[%s], md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2, bt.aRp(paramAnonymousString3), bt.aRp(paramAnonymousString4), bt.aRp(paramb.gjI), bt.aRp(paramAnonymousString5), bt.aRp(paramAnonymousString6) });
          if (!bt.isNullOrNil(paramAnonymousString4))
          {
            m.a(this.KNp, paramb.appId, paramb.appName, paramString, "", paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this), paramAnonymousString4);
            AppMethodBeat.o(194804);
            return;
          }
          com.tencent.mm.ui.base.h.c(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(2131757939), "", true);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(194804);
        }
      }), 0);
      AppMethodBeat.o(39295);
      return;
    }
    m.a((k.b)localObject3, paramb.appId, paramb.appName, paramString, (String)localObject2, paramArrayOfByte, this.mSessionId);
    if (((k.b)localObject3).type == 36) {
      if (!paramString.endsWith("chatroom")) {
        break label560;
      }
    }
    label560:
    for (int i = 1;; i = 0)
    {
      paramb = URLEncoder.encode(bt.nullAsNil(((k.b)localObject3).url));
      paramArrayOfByte = URLEncoder.encode(bt.nullAsNil(((k.b)localObject3).title));
      parambu = URLEncoder.encode(bt.nullAsNil(((k.b)localObject3).description));
      localObject1 = URLEncoder.encode(bt.nullAsNil(((k.b)localObject3).hCm));
      com.tencent.mm.plugin.report.service.g.yhR.f(14127, new Object[] { ((k.b)localObject3).appId, ((k.b)localObject3).hCn, localObject1, paramArrayOfByte, parambu, "", paramb, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString });
      AppMethodBeat.o(39295);
      return;
    }
  }
  
  private boolean a(final com.tencent.mm.aw.g paramg, final bu parambu, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39302);
    Object localObject = bw.M(paramg.hZI, "msg");
    if (localObject == null)
    {
      ad.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { paramg.hZI });
      AppMethodBeat.o(39302);
      return false;
    }
    final int j = paramg.hZz;
    String str1;
    if (j != 1) {
      str1 = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
    }
    for (final int i = 2;; i = 1)
    {
      ad.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), str1 });
      if (!bt.isNullOrNil(str1)) {
        break;
      }
      ad.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(39302);
      return false;
      str1 = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    }
    String str2 = (String)((Map)localObject).get(".msg.img.$aeskey");
    if (bt.isNullOrNil(str2))
    {
      ad.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
      AppMethodBeat.o(39302);
      return false;
    }
    if (bt.isNullOrNil(com.tencent.mm.ao.c.a("downimg", paramg.hZE, parambu.field_talker, parambu.field_msgId)))
    {
      ad.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambu.field_msgSvrId) });
      AppMethodBeat.o(39302);
      return false;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$md5");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_MsgRetransmitUI_2";
    localg.fJj = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39267);
        if (paramAnonymousd != null)
        {
          if (!paramAnonymousd.field_exist_whencheck) {
            break label78;
          }
          ad.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymousd, parambu, paramInt, paramString2, paramString3, paramString1, this.lxP, j);
        }
        for (;;)
        {
          AppMethodBeat.o(39267);
          return 0;
          label78:
          ad.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramg, parambu, paramString1, paramInt, paramString2, paramString3);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    localg.field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), paramString2, parambu.field_msgId);
    localg.field_fileId = str1;
    localg.field_aesKey = str2;
    localg.field_filemd5 = ((String)localObject);
    localg.field_fileType = i;
    localg.field_talker = paramString2;
    localg.field_priority = com.tencent.mm.i.a.fIw;
    localg.field_svr_signature = "";
    localg.field_onlycheckexist = true;
    localg.field_trysafecdn = true;
    if (!com.tencent.mm.ao.f.aGI().f(localg))
    {
      ad.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
      AppMethodBeat.o(39302);
      return false;
    }
    AppMethodBeat.o(39302);
    return true;
  }
  
  /* Error */
  private static boolean aXo(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc_w 1154
    //   7: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 298
    //   13: ldc_w 1156
    //   16: iconst_1
    //   17: anewarray 312	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 646	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: invokestatic 1160	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: new 1162	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 1163	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: iconst_1
    //   51: putfield 1166	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: aconst_null
    //   60: aload 5
    //   62: invokestatic 1172	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: getfield 1175	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: iflt +29 -> 103
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 1178	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: istore_1
    //   86: iload_1
    //   87: iflt +16 -> 103
    //   90: aload 4
    //   92: invokestatic 1181	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   95: ldc_w 1154
    //   98: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload_2
    //   102: ireturn
    //   103: iconst_0
    //   104: istore_2
    //   105: goto -15 -> 90
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_3
    //   111: ldc_w 298
    //   114: ldc_w 1183
    //   117: iconst_1
    //   118: anewarray 312	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: invokestatic 1117	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: invokestatic 1181	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   132: ldc_w 1154
    //   135: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_3
    //   142: invokestatic 1181	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   145: ldc_w 1154
    //   148: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private boolean aXq(final String paramString)
  {
    AppMethodBeat.i(39294);
    final k.b localb = k.b.yr(bt.aRd(this.dDP));
    ad.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.dDP, localb });
    if (localb == null)
    {
      ad.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(39294);
      return false;
    }
    if ((localb.type == 53) || (localb.type == 57))
    {
      localObject1 = localb.title;
      com.tencent.mm.model.u.aAm();
      localObject2 = com.tencent.mm.modelmulti.o.FX(paramString);
      ((o.e)localObject2).toUser = paramString;
      ((o.e)localObject2).content = ((String)localObject1);
      ((o.e)localObject2).type = com.tencent.mm.model.w.Ar(paramString);
      ((o.e)localObject2).dDp = 0;
      ((o.e)localObject2).igc = 4;
      ((o.e)localObject2).aJv().execute();
      AppMethodBeat.o(39294);
      return true;
    }
    ba.aBQ();
    final bu localbu = com.tencent.mm.model.c.azs().xY(this.msgId);
    if (localbu.fpd())
    {
      if (localb.type == 33) {
        com.tencent.mm.ui.chatting.l.b(paramString, localb, ci.c(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        AppMethodBeat.o(39294);
        return true;
        com.tencent.mm.ui.chatting.j.a(this, paramString, this.dDP, localbu.field_isSend, this.Jwd);
      }
    }
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool;
    if (this.KMI == null)
    {
      localObject1 = localObject4;
      if (this.Kdw < 0)
      {
        localObject1 = localObject4;
        if (localbu.field_imgPath != null)
        {
          localObject1 = localObject4;
          if (!localbu.field_imgPath.equals(""))
          {
            localObject4 = com.tencent.mm.aw.q.aIF().R(localbu.field_imgPath, true);
            localObject1 = localObject2;
            try
            {
              localObject2 = com.tencent.mm.vfs.i.aY((String)localObject4, 0, -1);
              localObject1 = localObject2;
              bool = cG((byte[])localObject2);
              localObject1 = localObject2;
              if (!bool)
              {
                AppMethodBeat.o(39294);
                return false;
              }
            }
            catch (Exception localException1)
            {
              ad.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException1.getLocalizedMessage() });
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject4 = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new com.tencent.mm.ai.a();
      }
      ((com.tencent.mm.ai.a)localObject3).hyw = this.KNg;
      localb.a((com.tencent.mm.ai.f)localObject3);
      com.tencent.e.h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39277);
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, localb, this.KNo, localbu);
          AppMethodBeat.o(39277);
        }
      }, "MicroMsg.MsgRetransmitUI");
      break;
      try
      {
        localObject3 = com.tencent.mm.vfs.i.aY(this.KMI, 0, -1);
        localObject1 = localObject3;
        bool = cG((byte[])localObject3);
        localObject1 = localObject3;
        if (!bool)
        {
          AppMethodBeat.o(39294);
          return false;
        }
      }
      catch (Exception localException2)
      {
        ad.printErrStackTrace("MicroMsg.MsgRetransmitUI", localException2, "", new Object[0]);
        ad.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException2.getLocalizedMessage() });
      }
    }
  }
  
  private void aXr(final String paramString)
  {
    AppMethodBeat.i(39300);
    ad.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new com.tencent.mm.pluginsdk.model.l(this, null, getIntent(), paramString, 1, new l.a()
    {
      public final void eZC()
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
    com.tencent.e.h.LTJ.aR(paramString);
    getString(2131755906);
    this.fMu = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39266);
        paramString.eZw();
        MsgRetransmitUI.this.KNi = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39266);
      }
    });
    AppMethodBeat.o(39300);
  }
  
  private void b(com.tencent.mm.aw.g paramg, bu parambu, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39303);
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = paramg.hZz;
    long l1 = com.tencent.mm.aw.q.aIF().a(parambu.field_talker, this.fileName, i, paramInt, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.aw.g localg = com.tencent.mm.aw.q.aIF().c(Long.valueOf(l1));
    localg.pr(1);
    bu localbu = new bu();
    localbu.setType(com.tencent.mm.model.w.As(paramString2));
    localbu.tN(paramString2);
    localbu.kr(1);
    localbu.setStatus(1);
    localbu.tO(((PString)localObject).value);
    localbu.kB(localPInt1.value);
    localbu.kC(localPInt2.value);
    localbu.qA(bj.Bo(localbu.field_talker));
    if (com.tencent.mm.am.g.vd(localbu.field_talker)) {
      parambu.sP(com.tencent.mm.am.a.e.VW());
    }
    ba.aBQ();
    long l2 = com.tencent.mm.model.c.azs().as(localbu);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      localg.sd((int)l2);
      com.tencent.mm.aw.q.aIF().a(Long.valueOf(l1), localg);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), paramg);
      com.tencent.mm.aw.q.aIG().a(paramg.dnz, parambu.field_msgId, i, localObject, 2131231564, new e.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.al.n paramAnonymousn) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
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
              paramAnonymousn = (com.tencent.mm.aw.g)paramAnonymousn.getValue();
              MsgRetransmitUI.this.fileName = com.tencent.mm.aw.q.aIF().o(com.tencent.mm.aw.h.c(paramAnonymousn), "", "");
              if (paramAnonymousInt1 != 0)
              {
                ba.aBQ();
                com.tencent.mm.model.c.azs().xZ(paramAnonymousString.longValue());
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
  
  private static boolean cG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39306);
    ad.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", new Object[] { Byte.valueOf(paramArrayOfByte[0]), Byte.valueOf(paramArrayOfByte[1]), Byte.valueOf(paramArrayOfByte[2]), Byte.valueOf(paramArrayOfByte[3]), Byte.valueOf(paramArrayOfByte[4]) });
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
  
  private boolean cV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39297);
    if (this.fileName == null)
    {
      AppMethodBeat.o(39297);
      return false;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(this.fileName);
    long l;
    Object localObject1;
    label71:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = com.tencent.mm.vfs.i.aYo(this.fileName);
      if (localEmojiInfo != null) {
        break label280;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.n.b.acf()) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.n.b.acf())) {
        break label627;
      }
    }
    label280:
    label620:
    label627:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.n.b.acg()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.Lb())
        {
          ad.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.KNf = false;
          this.KMK = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131758246), "", getString(2131760315), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39283);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(39283);
            }
          });
          if (this.KMV == 1) {
            com.tencent.mm.plugin.report.service.g.yhR.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.Lb(), Integer.valueOf(1) });
          }
          AppMethodBeat.o(39297);
          return true;
          l = com.tencent.mm.vfs.i.aYo(localEmojiInfo.gzQ());
          break;
          localObject1 = localEmojiInfo.gzQ();
          break label71;
        }
      }
      if (this.KMV == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
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
          break label620;
        }
        localObject1 = new WXMediaMessage(new WXEmojiObject(this.fileName));
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject1, "");
      }
      for (localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr((String)localObject1);; localObject1 = localEmojiInfo)
      {
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).Lb(), Integer.valueOf(2) });
          com.tencent.mm.ui.chatting.j.c((EmojiInfo)localObject1, paramString);
        }
        finish();
        AppMethodBeat.o(39297);
        return true;
        localObject1 = localEmojiInfo.Lb();
        break;
        if ((localEmojiInfo != null) && (l > ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(localEmojiInfo, false)))
        {
          com.tencent.mm.ui.chatting.j.c(localEmojiInfo, paramString);
          AppMethodBeat.o(39297);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(this, paramString, this.fileName))
        {
          AppMethodBeat.o(39297);
          return true;
        }
        ad.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
        AppMethodBeat.o(39297);
        return false;
      }
    }
  }
  
  private void fKS()
  {
    AppMethodBeat.i(39292);
    label181:
    Object localObject6;
    switch (this.KMN)
    {
    default: 
      ad.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.KMN) });
      finish();
      AppMethodBeat.o(39292);
      return;
    case 0: 
      boolean bool3;
      switch (this.msgType)
      {
      case 3: 
      default: 
        ad.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
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
        localObject1 = this.KMH;
        ad.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
        if ((11 == this.msgType) && (com.tencent.mm.modelvideo.u.HA(this.fileName)))
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
          if (this.KMU) {
            com.tencent.mm.ui.chatting.k.xQ(true);
          }
          AppMethodBeat.o(39292);
          return;
          if (fKT()) {
            break;
          }
          finish();
          i = 0;
          break label181;
          if ((this.dDP != null) && (!this.dDP.equals(""))) {
            break;
          }
          ad.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          finish();
          i = 0;
          break label181;
          if (!fKT())
          {
            finish();
            i = 0;
            break label181;
          }
          if (this.fileName != null) {
            break;
          }
          ad.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
          finish();
          i = 0;
          break label181;
          if ((this.dDP != null) && (!this.dDP.equals(""))) {
            break;
          }
          ad.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          localObject3 = new b((byte)0);
          ((b)localObject3).KNB = new LinkedList();
          ((b)localObject3).KNB.addAll((Collection)localObject1);
          localObject4 = com.tencent.mm.modelvideo.u.Hy(this.fileName);
          if (localObject4 != null) {
            break label516;
          }
          ba.aBQ();
          if (!com.tencent.mm.model.c.azs().xY(this.msgId).cxg()) {
            break label516;
          }
          iL((List)localObject1);
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
        ad.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { localObject1, localObject2 });
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
        ad.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
        i = 0;
      }
      final int j;
      while (i == 0)
      {
        fKU();
        break;
        Object localObject7 = bw.M(((com.tencent.mm.modelvideo.s)localObject4).aMV(), "msg");
        if (localObject7 == null)
        {
          ad.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
          i = 0;
        }
        else
        {
          localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
          if (bt.isNullOrNil((String)localObject1))
          {
            i = 0;
          }
          else
          {
            localObject2 = (String)((Map)localObject7).get(".msg.videomsg.$aeskey");
            final String str1 = (String)((Map)localObject7).get(".msg.videomsg.$md5");
            final String str2 = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
            i = bt.getInt((String)((Map)localObject7).get(".msg.videomsg.$length"), 0);
            j = bt.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
            final int k = bt.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
            if (bt.isNullOrNil(str1))
            {
              com.tencent.mm.modelvideo.o.aMJ();
              if (!com.tencent.mm.vfs.i.fv(com.tencent.mm.modelvideo.t.Hh(((com.tencent.mm.modelvideo.s)localObject4).getFileName())))
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1328L, 1L, 1L, true);
                i = 0;
                continue;
              }
            }
            localObject7 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject7).fJi = "task_MsgRetransmitUI_3";
            ((com.tencent.mm.i.g)localObject7).fJj = new g.a()
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
                  paramAnonymousd.field_aesKey = this.EgG;
                  paramAnonymousd.field_thumbimgLength = k;
                  paramAnonymousd.field_fileLength = i;
                  paramAnonymousd.field_toUser = this.cWl;
                  paramAnonymousd.field_filemd5 = str1;
                  paramAnonymousd.field_mp4identifymd5 = str2;
                  ad.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
                  paramAnonymousString = com.tencent.mm.modelvideo.t.Hg(this.cWl);
                  com.tencent.mm.modelvideo.o.aMJ();
                  paramAnonymousc = com.tencent.mm.modelvideo.t.Hi(paramAnonymousString);
                  com.tencent.mm.modelvideo.o.aMJ();
                  com.tencent.mm.vfs.i.mz(com.tencent.mm.modelvideo.t.Hi(MsgRetransmitUI.this.fileName), paramAnonymousc);
                  paramAnonymousc = "<msg><videomsg aeskey=\"" + this.EgG + "\" cdnthumbaeskey=\"" + this.EgG + "\" cdnvideourl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
                  ad.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
                  com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, this.cWl, paramAnonymousc, this.isP.iuf);
                  paramAnonymousc = com.tencent.mm.aw.s.aIM();
                  paramAnonymousc.fileName = paramAnonymousString;
                  paramAnonymousc.icN = 0;
                  paramAnonymousc.icO = paramAnonymousd;
                  paramAnonymousc.icP = new com.tencent.mm.aw.f()
                  {
                    public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
                    {
                      AppMethodBeat.i(39275);
                      com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Hy(paramAnonymousString);
                      locals.status = 111;
                      locals.dDp = 256;
                      com.tencent.mm.modelvideo.o.aMJ().c(locals);
                      ad.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                      AppMethodBeat.o(39275);
                    }
                  };
                  paramAnonymousc.igc = 4;
                  paramAnonymousc.aJv().execute();
                  MsgRetransmitUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(39276);
                  return 0;
                  label375:
                  ad.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                  MsgRetransmitUI.i(MsgRetransmitUI.this);
                }
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            ((com.tencent.mm.i.g)localObject7).field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), (String)localObject6, this.msgId);
            ((com.tencent.mm.i.g)localObject7).field_fileId = ((String)localObject1);
            ((com.tencent.mm.i.g)localObject7).field_aesKey = ((String)localObject2);
            ((com.tencent.mm.i.g)localObject7).field_filemd5 = str1;
            ((com.tencent.mm.i.g)localObject7).field_fileType = 4;
            ((com.tencent.mm.i.g)localObject7).field_talker = ((String)localObject6);
            ((com.tencent.mm.i.g)localObject7).field_priority = com.tencent.mm.i.a.fIw;
            ((com.tencent.mm.i.g)localObject7).field_svr_signature = "";
            ((com.tencent.mm.i.g)localObject7).field_onlycheckexist = true;
            ((com.tencent.mm.i.g)localObject7).field_trysafecdn = true;
            ad.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { localObject1, str1, localObject2, ((com.tencent.mm.modelvideo.s)localObject4).aMV() });
            if (!com.tencent.mm.ao.f.aGI().f((com.tencent.mm.i.g)localObject7))
            {
              ad.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
              finish();
              i = 0;
            }
            else
            {
              this.KMK = false;
              finish();
              i = 1;
            }
          }
        }
      }
      if (this.msgType == 0) {
        this.KMZ = this.KMH.size();
      }
      final int i = this.KMH.size();
      localObject1 = this.KMH.iterator();
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
            if (this.KMU) {
              com.tencent.mm.ui.chatting.k.xQ(bool2);
            }
            i = j;
            bool3 = bool1;
            break;
            bool2 = false;
            break label1161;
            ba.ajF().LZ();
            com.tencent.e.h.LTJ.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(39258);
                ad.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                MsgRetransmitUI.a(MsgRetransmitUI.this, this.fNr);
                AppMethodBeat.o(39258);
              }
            }, "MicroMsg.MsgRetransmitUI");
          }
        case 2: 
        case 16: 
        case 19: 
          bool1 = aXq((String)localObject2);
        }
        for (;;)
        {
          break;
          com.tencent.mm.model.u.aAm();
          localObject3 = com.tencent.mm.modelmulti.o.FX((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.dDP;
          ((o.e)localObject3).type = com.tencent.mm.model.w.Ar((String)localObject2);
          ((o.e)localObject3).dDp = 0;
          ((o.e)localObject3).igc = 4;
          ((o.e)localObject3).aJv().execute();
          bool1 = true;
          continue;
          bool1 = cV((String)localObject2, false);
          continue;
          localObject3 = k.b.yr(bt.aRd(this.dDP));
          if (localObject3 == null) {
            ad.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
          }
          for (bool1 = false;; bool1 = true)
          {
            break;
            a((String)localObject2, (k.b)localObject3, null, null);
          }
          localObject2 = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.s.o((String)localObject2, this.fileName, this.length), 1);
          ba.aiU().a((com.tencent.mm.al.n)localObject2, 0);
          bool1 = true;
          continue;
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(this.msgId);
          if (((bu)localObject3).getType() == 42)
          {
            ad.d("MicroMsg.MsgRetransmitUI", "set forward flag");
            ((bu)localObject3).frW();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(this.msgId, (bu)localObject3);
          }
          localObject3 = bu.a.aUb(this.dDP);
          localObject4 = com.tencent.mm.modelmulti.o.FX((String)localObject2);
          ((o.e)localObject4).toUser = ((String)localObject2);
          ((o.e)localObject4).content = this.dDP;
          if (am.aSQ(((bu.a)localObject3).dHm)) {}
          for (i = 66;; i = 42)
          {
            ((o.e)localObject4).type = i;
            ((o.e)localObject4).dDp = 1;
            ((o.e)localObject4).igc = 4;
            ((o.e)localObject4).aJv().execute();
            bool1 = bool3;
            break;
          }
          localObject3 = com.tencent.mm.modelmulti.o.FX((String)localObject2);
          ((o.e)localObject3).toUser = ((String)localObject2);
          ((o.e)localObject3).content = this.dDP;
          ((o.e)localObject3).type = 48;
          ((o.e)localObject3).dDp = 0;
          ((o.e)localObject3).igc = 4;
          ((o.e)localObject3).aJv().execute();
          bool1 = true;
          continue;
          localObject3 = new qh();
          ((qh)localObject3).dEN.type = 4;
          localObject4 = ((qh)localObject3).dEN;
          ba.aBQ();
          ((qh.a)localObject4).dBd = com.tencent.mm.model.c.azs().xY(this.msgId);
          ((qh)localObject3).dEN.toUser = ((String)localObject2);
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.k.m(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.k.l(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          localObject3 = new tq();
          ((tq)localObject3).dIb.dmV = this.msgId;
          ((tq)localObject3).dIb.dwI = this.dDP;
          ((tq)localObject3).dIb.dwJ = ((String)localObject2);
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
          bool1 = bool3;
          break;
          if (!bt.isNullOrNil(this.dDP))
          {
            ad.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { localObject2 });
            localObject3 = k.b.yr(this.dDP);
            if (localObject3 != null)
            {
              w.a.azd().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              localObject2 = (com.tencent.mm.plugin.i.a.b)((k.b)localObject3).ao(com.tencent.mm.plugin.i.a.b.class);
              if (localObject2 != null)
              {
                localObject3 = new LinkedList();
                ((List)localObject3).add(((com.tencent.mm.plugin.i.a.b)localObject2).inc.objectId);
                ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).shareStatsReport((List)localObject3);
              }
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!bt.isNullOrNil(this.dDP))
          {
            ad.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.yr(this.dDP);
            if (localObject3 != null) {
              w.a.azd().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!bt.isNullOrNil(this.dDP))
          {
            ad.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { localObject2 });
            localObject3 = k.b.yr(this.dDP);
            if (localObject3 != null)
            {
              w.a.azd().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              bool1 = true;
              continue;
            }
          }
          bool1 = false;
        }
      }
      localObject3 = (String)this.KMH.get(0);
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
        localObject4 = k.b.yr(bt.aRd(this.dDP));
        if ((localObject4 != null) && (((k.b)localObject4).type == 5) && (!bt.isNullOrNil(((k.b)localObject4).url))) {
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
            ad.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            i = 2;
          }
        }
        if (bool3)
        {
          i = 1;
          ad.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.KNa), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.KNa), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      while (bool3)
      {
        if (this.KMK) {
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        }
        localObject1 = new Intent();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(this.KMH);
        ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
        setResult(-1, (Intent)localObject1);
        if (this.KNf) {
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
        if ((this.KMJ) && (!this.KMX))
        {
          localObject1 = new Intent(this, ChattingUI.class);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("Chat_User", (String)localObject3);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(39292);
        return;
        if ((!bool3) && (localObject4 != null) && (((k.b)localObject4).type == 33))
        {
          localObject1 = new com.tencent.mm.g.a.o();
          ((com.tencent.mm.g.a.o)localObject1).dkf.scene = this.KNd;
          ((com.tencent.mm.g.a.o)localObject1).dkf.cmr = this.KNe;
          if (2 == this.KNd)
          {
            ((com.tencent.mm.g.a.o)localObject1).dkf.dkh = (this.KNc + ":" + this.KNb);
            if (!((String)localObject3).endsWith("@chatroom")) {
              break label3003;
            }
          }
          for (((com.tencent.mm.g.a.o)localObject1).dkf.action = 2;; ((com.tencent.mm.g.a.o)localObject1).dkf.action = 1)
          {
            ((com.tencent.mm.g.a.o)localObject1).dkf.dkg = (((k.b)localObject4).hCz + 1);
            ((com.tencent.mm.g.a.o)localObject1).dkf.dki = ((k.b)localObject4).hCm;
            ((com.tencent.mm.g.a.o)localObject1).dkf.djX = ((k.b)localObject4).hCn;
            ((com.tencent.mm.g.a.o)localObject1).dkf.appId = ((k.b)localObject4).hCo;
            ((com.tencent.mm.g.a.o)localObject1).dkf.dkj = "";
            ((com.tencent.mm.g.a.o)localObject1).dkf.dkk = bt.aQJ();
            ((com.tencent.mm.g.a.o)localObject1).dkf.dkl = 2;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
            break;
            ((com.tencent.mm.g.a.o)localObject1).dkf.dkh = this.KNc;
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
      localObject1 = (String)this.KMH.get(0);
      label640:
      label1087:
      if (!fKT())
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
        ad.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        AppMethodBeat.o(39292);
        return;
      case 0: 
        if ((this.KMQ != null) && (this.KMQ.size() > 0)) {
          this.KMS = this.KMQ.size();
        }
        this.iaZ = new com.tencent.mm.al.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(39259);
            if ((MsgRetransmitUI.b(MsgRetransmitUI.this) == null) || (paramAnonymousInt2 == 0))
            {
              AppMethodBeat.o(39259);
              return;
            }
            paramAnonymousInt1 = (int)(paramAnonymousInt1 * 100L / paramAnonymousInt2);
            MsgRetransmitUI.b(MsgRetransmitUI.this).setMessage(MsgRetransmitUI.this.getString(2131761378, new Object[] { Integer.valueOf(MsgRetransmitUI.c(MsgRetransmitUI.this)), Integer.valueOf(MsgRetransmitUI.d(MsgRetransmitUI.this)), Integer.valueOf(paramAnonymousInt1) }));
            ad.i("MicroMsg.MsgRetransmitUI", "onSceneProgress: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            AppMethodBeat.o(39259);
          }
        };
        this.KML = com.tencent.mm.ui.base.h.d(this, getString(2131761378, new Object[] { Integer.valueOf(1), Integer.valueOf(this.KMS), Integer.valueOf(0) }), getString(2131755906), new DialogInterface.OnClickListener()
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
        ad.i("MicroMsg.MsgRetransmitUI", "show uploadImgDialog : %s", new Object[] { this.KML });
        if (this.KML != null)
        {
          this.KML.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(39263);
              com.tencent.mm.ui.base.h.a(MsgRetransmitUI.this, 2131761372, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(39261);
                  com.tencent.mm.aw.i locali;
                  com.tencent.mm.aw.g localg;
                  if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null)
                  {
                    ba.aiU().a(MsgRetransmitUI.e(MsgRetransmitUI.this));
                    paramAnonymous2Int = (int)MsgRetransmitUI.e(MsgRetransmitUI.this).iba;
                    paramAnonymous2DialogInterface = com.tencent.mm.aw.q.aIF().pt(paramAnonymous2Int);
                    if (paramAnonymous2DialogInterface != null)
                    {
                      locali = com.tencent.mm.aw.q.aIF();
                      localg = locali.pt(paramAnonymous2Int);
                      if ((localg != null) && (localg.dnz == paramAnonymous2Int)) {
                        break label137;
                      }
                    }
                  }
                  for (;;)
                  {
                    ba.aBQ();
                    com.tencent.mm.model.c.azs().xZ(paramAnonymous2DialogInterface.hZF);
                    Toast.makeText(MsgRetransmitUI.this, 2131761373, 1).show();
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(39261);
                    return;
                    label137:
                    com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZw, "", ""));
                    com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZB, "", ""));
                    com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZy, "", ""));
                    com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZy, "", "") + "hd");
                    locali.hHS.delete(i.d.sf(paramAnonymous2Int), "id=?", new String[] { String.valueOf(paramAnonymous2Int) });
                    if (localg.aIj())
                    {
                      localg = locali.pt(localg.hZH);
                      if (localg != null)
                      {
                        com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZw, "", ""));
                        com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZB, "", ""));
                        com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZy, "", ""));
                        com.tencent.mm.vfs.i.deleteFile(locali.o(localg.hZy, "", "") + "hd");
                        locali.hHS.delete(i.d.sf(paramAnonymous2Int), "id=?", new String[] { localg.dnz });
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
          this.KML.setCanceledOnTouchOutside(false);
          this.KML.getButton(-1).setText(2131755691);
        }
        a((String)localObject1, 6, this.iaZ);
        AppMethodBeat.o(39292);
        return;
      case 1: 
      case 11: 
        if (!ae.cP(this))
        {
          com.tencent.mm.ui.base.h.a(this, 2131764676, 2131755906, 2131755835, 2131755691, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39278);
              MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), this.fNr);
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
      cV((String)localObject1, true);
      AppMethodBeat.o(39292);
      return;
    }
    switch (this.msgType)
    {
    default: 
      AppMethodBeat.o(39292);
      return;
    }
    this.KMH.get(0);
    Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName = ((String)localObject1);
    ao.dxQ().get((com.tencent.mm.sdk.e.c)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new c(new c.a()
    {
      public final void fKV()
      {
        AppMethodBeat.i(39271);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39271);
      }
    });
    if (((WXMediaMessage)localObject5).thumbData == null) {}
    for (localObject1 = null;; localObject1 = com.tencent.mm.sdk.platformtools.g.cr(((WXMediaMessage)localObject5).thumbData)) {
      switch (((WXMediaMessage)localObject5).mediaObject.type())
      {
      default: 
        ad.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + ((WXMediaMessage)localObject5).mediaObject.type());
        AppMethodBeat.o(39292);
        return;
      }
    }
    localObject1 = View.inflate(this, 2131493113, null);
    ((TextView)((View)localObject1).findViewById(2131305948)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(2131305134)).setText(com.tencent.mm.pluginsdk.model.app.h.a(this, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      ((c)localObject4).jcs = com.tencent.mm.ui.base.h.a(this, null, (View)localObject1, getString(2131755884), getString(2131755691), new c.1((c)localObject4), new c.2((c)localObject4));
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
  
  private boolean fKT()
  {
    AppMethodBeat.i(39298);
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ad.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.t.g(this, null);
      AppMethodBeat.o(39298);
      return false;
    }
    AppMethodBeat.o(39298);
    return true;
  }
  
  private void fKU()
  {
    AppMethodBeat.i(39308);
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39273);
        com.tencent.mm.modelvideo.o.aMO().a(MsgRetransmitUI.this.fileName, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(39272);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.Hy(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199))
            {
              paramAnonymous2a = new MsgRetransmitUI.b((byte)0);
              paramAnonymous2a.KNB = new LinkedList();
              paramAnonymous2a.KNB.addAll(MsgRetransmitUI.this.KMH);
              Iterator localIterator = MsgRetransmitUI.this.KMH.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                ad.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", new Object[] { str });
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymous2a, str);
              }
            }
            AppMethodBeat.o(39272);
          }
        });
        AppMethodBeat.o(39273);
      }
    }, "MicroMsg.MsgRetransmitUI");
    this.KMK = false;
    AppMethodBeat.o(39308);
  }
  
  private void iL(List<String> paramList)
  {
    AppMethodBeat.i(39307);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      aXq((String)paramList.next());
    }
    if (this.KMK) {
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
    if (this.KMT)
    {
      this.KMS = this.KMQ.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.KNi) {
            break;
          }
          aXr(paramString);
        }
        AppMethodBeat.o(39299);
        return;
      }
      finish();
      AppMethodBeat.o(39299);
      return;
    }
    this.KMS = 1;
    aXr(paramString);
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
    if (paramInt2 != -1)
    {
      Object localObject = k.b.yr(bt.aRd(this.dDP));
      if ((localObject != null) && (((k.b)localObject).type == 5) && (((k.b)localObject).url != null))
      {
        ad.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject).url, Long.valueOf(this.startTime), Integer.valueOf(this.KNa), Integer.valueOf(1), Integer.valueOf(3) });
        paramIntent = "";
        try
        {
          localObject = URLEncoder.encode(((k.b)localObject).url, "UTF-8");
          paramIntent = (Intent)localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.KNa), Integer.valueOf(1), Integer.valueOf(3) });
      }
      while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
      {
        finish();
        AppMethodBeat.o(39293);
        return;
      }
      paramIntent = new com.tencent.mm.g.a.o();
      paramIntent.dkf.cmr = this.KNe;
      paramIntent.dkf.scene = this.KNd;
      if (2 == this.KNd) {}
      for (paramIntent.dkf.dkh = (this.KNc + ":" + this.KNb);; paramIntent.dkf.dkh = this.KNc)
      {
        paramIntent.dkf.dkg = (localUnsupportedEncodingException.hCz + 1);
        paramIntent.dkf.dki = localUnsupportedEncodingException.hCm;
        paramIntent.dkf.djX = localUnsupportedEncodingException.hCn;
        paramIntent.dkf.appId = localUnsupportedEncodingException.hCo;
        paramIntent.dkf.action = 1;
        paramIntent.dkf.dkj = "";
        paramIntent.dkf.dkk = bt.aQJ();
        paramIntent.dkf.dkl = 3;
        com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
        break;
      }
    }
    if (paramInt1 != 0)
    {
      ad.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(39293);
      return;
    }
    this.KMH = bt.U(paramIntent.getStringExtra("Select_Conv_User").split(","));
    String str1 = paramIntent.getStringExtra("custom_send_text");
    this.ruj = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.ruj) {
      this.nYO = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      ad.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    this.KNg = paramIntent.getBooleanExtra("KSendGroupToDo", false);
    this.KNh = paramIntent.getIntExtra("KShowTodoIntroduceView", 0);
    ad.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.KMN), Integer.valueOf(this.KMH.size()) });
    fKS();
    if (!TextUtils.isEmpty(str1))
    {
      paramIntent = this.KMH.iterator();
      while (paramIntent.hasNext())
      {
        String str2 = (String)paramIntent.next();
        sx localsx = new sx();
        localsx.dHy.dHz = str2;
        localsx.dHy.content = str1;
        localsx.dHy.type = com.tencent.mm.model.w.Ar(str2);
        localsx.dHy.flags = 0;
        com.tencent.mm.sdk.b.a.IbL.l(localsx);
      }
    }
    AppMethodBeat.o(39293);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39289);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    al.b(getWindow());
    ad.i("MicroMsg.MsgRetransmitUI", "on activity create");
    this.startTime = bt.aQJ();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    this.dDP = getIntent().getStringExtra("Retr_Msg_content");
    this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
    this.fileName = getIntent().getStringExtra("Retr_File_Name");
    this.KMQ = getIntent().getStringArrayListExtra("Retr_File_Path_List");
    boolean bool;
    if ((this.KMQ != null) && (this.KMQ.size() > 0))
    {
      bool = true;
      this.KMT = bool;
      this.hZz = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.KMN = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.KMM = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.KMI = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.KMJ = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.KMX = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.KMN != 0) {
        break label767;
      }
      bool = true;
      label258:
      this.KMY = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.KMY) {
        this.KMX = true;
      }
      this.KMK = getIntent().getBooleanExtra("Retr_show_success_tips", this.KMX);
      this.KMU = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.Jwd = getIntent().getBooleanExtra("is_group_chat", false);
      this.iuq = getIntent().getStringExtra("msg_uuid");
      this.Kdw = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.KMV = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.ibC = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.dyz = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.ibD = getIntent().getStringExtra("Retr_AttachedContent");
      this.KMW = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.mSessionId = getIntent().getStringExtra("reportSessionId");
      this.KNa = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.KNb = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.KNc = getIntent().getStringExtra("Retr_MsgTalker");
      this.KNd = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.KNe = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      ba.aiU().a(110, this);
      if (!com.tencent.mm.compatible.util.d.ly(19)) {
        setContentView(2131493233);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.KMY) {
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
      paramBundle.putExtra("Retr_Msg_content", this.dDP);
      paramBundle.putExtra("image_path", this.fileName);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(39289);
      return;
      bool = false;
      break;
      label767:
      bool = false;
      break label258;
      paramBundle.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
      if (this.KNa == 3) {
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.Kdw);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
      continue;
      ba.aBQ();
      bu.a locala = com.tencent.mm.model.c.azs().aqk(this.dDP);
      if ((locala.dHm == null) || (locala.dHm.length() <= 0)) {
        ad.e("MicroMsg.MsgRetransmitUI", "getView : parse possible friend msg failed");
      }
      if (!com.tencent.mm.model.w.on(locala.DKi))
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
        if (com.tencent.mm.ui.chatting.k.fBn())
        {
          ad.d("MicroMsg.MsgRetransmitUI", "has can forward card");
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
    if (!this.KMP) {
      ba.aiU().b(110, this);
    }
    super.onDestroy();
    AppMethodBeat.o(39291);
  }
  
  @com.tencent.mm.sdk.platformtools.k
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(39310);
    ad.i("MicroMsg.MsgRetransmitUI", "errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn.getType() != 110) || (!(paramn instanceof com.tencent.mm.aw.n)))
    {
      AppMethodBeat.o(39310);
      return;
    }
    paramString = (com.tencent.mm.aw.n)paramn;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramn = getIntent().getStringExtra("Retr_KSnsId");
      if (!com.tencent.mm.model.w.vF(paramString.dHz)) {
        break label221;
      }
      localObject = new ul();
      ((ul)localObject).dIJ.dzb = paramn;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    while ((this.KMQ != null) && (this.KMQ.size() > 1))
    {
      this.KMQ.remove(0);
      paramn = paramString.dHz;
      paramString = paramn;
      if (bt.isNullOrNil(paramn))
      {
        paramString = paramn;
        if (this.KMH != null) {
          paramString = (String)this.KMH.get(0);
        }
      }
      a(paramString, 3, this.iaZ);
      AppMethodBeat.o(39310);
      return;
      label221:
      localObject = new um();
      ((um)localObject).dIK.dzb = paramn;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if (this.KML != null)
    {
      this.KML.dismiss();
      ad.i("MicroMsg.MsgRetransmitUI", "uploadImgDialog dismissed : %s", new Object[] { this.KML.toString() });
      this.KML = null;
    }
    this.KMZ -= 1;
    if ((this.KMZ <= 0) || (!this.KMY))
    {
      this.KMP = false;
      ba.aiU().b(110, this);
      if (this.KMN != 0)
      {
        finish();
        if ((this.KMJ) && (!this.KMX))
        {
          paramn = new Intent(this, ChattingUI.class);
          paramn.addFlags(67108864);
          paramn.putExtra("Chat_User", paramString.dHz);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
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
    public boolean KMK;
    public int KMM;
    public boolean KNs;
    public String KNt;
    public boolean KNu;
    public boolean KNv;
    public boolean KNw;
    public dki KNx;
    public MsgRetransmitUI.b KNy;
    public int KNz;
    public Context context;
    public String dHv;
    public String eLs;
    public String fileName;
    public int hHQ;
    public int ism;
    public String iuq;
    private ap mHandler;
    public Dialog tipDialog;
    public String userName;
    
    public a()
    {
      AppMethodBeat.i(39285);
      this.KNu = true;
      this.KNv = false;
      this.KMK = false;
      this.KNw = true;
      this.KNx = null;
      this.KNy = null;
      this.mHandler = new ap(Looper.getMainLooper());
      AppMethodBeat.o(39285);
    }
  }
  
  static final class b
  {
    public List<String> KNB = null;
    boolean dno = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */