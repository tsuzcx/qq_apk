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
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.d.a;
import com.tencent.mm.av.m.a;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.a;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.by;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelvideo.h.a;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.network.ae;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.ac.a;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aj;
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
  implements com.tencent.mm.ak.g
{
  private boolean HIm;
  public List<String> IVD;
  private String IVE;
  private boolean IVF;
  private boolean IVG;
  private com.tencent.mm.ui.widget.a.d IVH;
  private int IVI;
  private int IVJ;
  private com.tencent.mm.av.l IVK;
  private boolean IVL;
  private List<String> IVM;
  private int IVN;
  private int IVO;
  private boolean IVP;
  private boolean IVQ;
  private int IVR;
  private boolean IVS;
  private boolean IVT;
  private boolean IVU;
  private int IVV;
  private int IVW;
  private String IVX;
  private String IVY;
  private int IVZ;
  private int IWa;
  private boolean IWb;
  private boolean IWc;
  private int IWd;
  boolean IWe;
  private int ImY;
  private float dmL;
  public String drV;
  public String fileName;
  private ProgressDialog fts;
  private int hGP;
  private float hIO;
  private String hIP;
  private com.tencent.mm.ak.h hIl;
  private String iaU;
  private int length;
  private ao mHandler;
  private String mSessionId;
  public long msgId;
  public int msgType;
  long nxq;
  boolean qKh;
  private long startTime;
  private String thumbPath;
  
  public MsgRetransmitUI()
  {
    AppMethodBeat.i(39288);
    this.IVE = null;
    this.IVF = true;
    this.IVG = false;
    this.fts = null;
    this.hGP = 0;
    this.IVI = 0;
    this.IVJ = 0;
    this.IVK = null;
    this.IVL = false;
    this.IVM = null;
    this.hIl = null;
    this.IVN = 0;
    this.IVO = 0;
    this.IVP = false;
    this.IVQ = false;
    this.HIm = false;
    this.ImY = -1;
    this.IVT = true;
    this.IVU = true;
    this.IVV = 0;
    this.startTime = 0L;
    this.IWb = true;
    this.IWc = false;
    this.IWd = 0;
    this.mHandler = new ao(Looper.getMainLooper());
    this.IWe = false;
    AppMethodBeat.o(39288);
  }
  
  private void a(final k.b paramb, final com.tencent.mm.pluginsdk.model.app.c paramc, final bo parambo, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39296);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39282);
        paramc.field_fileFullPath = paramString2;
        if ((paramAnonymousInt == 0) && (paramAnonymousc != null))
        {
          paramc.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.pluginsdk.model.app.ap.bEO().a(paramc, new String[0]);
        }
        if ((paramAnonymousInt == 0) && (paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          paramc.field_status = 199L;
          paramc.field_offset = paramc.field_totalLen;
          com.tencent.mm.pluginsdk.model.app.ap.bEO().a(paramc, new String[0]);
          parambo.setStatus(3);
          az.ayM();
          com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
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
    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), parambo.field_talker, parambo.field_msgId);
    localg.field_aesKey = paramb.fQi;
    localg.field_fileType = 19;
    localg.field_authKey = paramb.hhR;
    localg.fre = paramb.hhL;
    localg.field_fullpath = paramString2;
    if (!com.tencent.mm.an.f.aDD().b(localg, -1)) {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
    }
    AppMethodBeat.o(39296);
  }
  
  private void a(b paramb, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(39309);
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
    Object localObject = new a();
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131755886), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39274);
        this.HQA.IWo = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39274);
      }
    });
    ((a)localObject).context = this;
    ((a)localObject).fileName = this.fileName;
    ((a)localObject).tipDialog = this.fts;
    ((a)localObject).IVI = this.IVI;
    ((a)localObject).hpy = this.length;
    ((a)localObject).hYQ = this.msgType;
    ((a)localObject).IWq = false;
    ((a)localObject).userName = paramString;
    ((a)localObject).IWr = true;
    ((a)localObject).IVG = this.IVG;
    ((a)localObject).IWu = paramb;
    paramb = com.tencent.mm.modelvideo.u.Ej(this.fileName);
    if ((paramb != null) && (paramb.iaR != null))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((a)localObject).IWt = paramb.iaR;
      ((a)localObject).eul = paramb.getUser();
      ((a)localObject).IWv = paramb.iaJ;
    }
    ((a)localObject).execute(new Object[0]);
    by.azu().d(by.hpL, null);
    if (this.msgId == -1L)
    {
      AppMethodBeat.o(39309);
      return;
    }
    az.ayM();
    bo localbo = com.tencent.mm.model.c.awD().vP(this.msgId);
    boolean bool = com.tencent.mm.model.w.sQ(paramString);
    if (bool)
    {
      paramb = a.c.HJn;
      if (!this.IVS) {
        break label319;
      }
    }
    label319:
    for (localObject = a.d.HJr;; localObject = a.d.HJq)
    {
      if (bool) {
        i = com.tencent.mm.model.q.wb(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localbo, i);
      AppMethodBeat.o(39309);
      return;
      paramb = a.c.HJm;
      break;
    }
  }
  
  private void a(String paramString, int paramInt, com.tencent.mm.ak.h paramh)
  {
    AppMethodBeat.i(39301);
    String str2 = com.tencent.mm.model.u.axw();
    az.ayM();
    bo localbo = com.tencent.mm.model.c.awD().vP(this.msgId);
    if (localbo.field_msgId == this.msgId)
    {
      String str1 = localbo.field_content;
      Object localObject1 = null;
      if (localbo.field_msgId > 0L) {
        localObject1 = com.tencent.mm.av.o.aFx().qg(localbo.field_msgId);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.av.e)localObject1).dcd > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localbo.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.av.o.aFx().qf(localbo.field_msgSvrId);
        }
      }
      localObject1 = str1;
      if (bs.isNullOrNil(str1))
      {
        localObject1 = str1;
        if (localbo.field_msgSvrId > 0L) {
          localObject1 = ((com.tencent.mm.av.e)localObject2).hGY;
        }
      }
      if ((localObject2 != null) && ((((com.tencent.mm.av.e)localObject2).offset < ((com.tencent.mm.av.e)localObject2).hux) || (((com.tencent.mm.av.e)localObject2).hux == 0)) && (!this.IVP))
      {
        paramh = com.tencent.mm.av.o.aFx().qf(localbo.field_msgSvrId);
        if (!a(paramh, localbo, (String)localObject1, paramInt, paramString, str2)) {
          b(paramh, localbo, (String)localObject1, paramInt, paramString, str2);
        }
        AppMethodBeat.o(39301);
        return;
      }
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.av.e)localObject2).dcd;; l = -1L)
      {
        a(paramString, paramInt, str2, (String)localObject1, paramh, l);
        AppMethodBeat.o(39301);
        return;
      }
    }
    a(paramString, paramInt, str2, "", paramh, -1L);
    AppMethodBeat.o(39301);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.ak.h paramh, long paramLong)
  {
    AppMethodBeat.i(39304);
    if (!bs.isNullOrNil(this.fileName))
    {
      this.IVN = 1;
      this.IVO = 1;
      if (!aRq(this.fileName))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.hGP == 1) && (!com.tencent.mm.model.u.f(this.fileName, paramString1, false))) {
        this.hGP = 0;
      }
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 96L, 1L, false);
      this.IVK = new com.tencent.mm.av.l(paramInt, paramString2, paramString1, this.fileName, this.hGP, paramh, 0, paramString3, "", true, 2131231564, this.IVR, this.hIO, this.dmL, paramLong, this.msgId, this.iaU);
      if (this.IVJ == 1) {
        this.IVK.aFk();
      }
      az.agi().a(this.IVK, 0);
      this.IVL = true;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.hGP) });
      by.azu().d(by.hpK, null);
      AppMethodBeat.o(39304);
      return;
    }
    if (this.IVP)
    {
      this.IVN += 1;
      if (!aRq((String)this.IVM.get(0)))
      {
        AppMethodBeat.o(39304);
        return;
      }
      if ((this.hGP == 1) && (!com.tencent.mm.model.u.f((String)this.IVM.get(0), paramString1, false))) {
        this.hGP = 0;
      }
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.hGP) });
      this.IVK = new com.tencent.mm.av.l(paramInt, paramString2, paramString1, (String)this.IVM.get(0), this.hGP, paramh, 0, paramString3, "", true, 2131231564);
      if (this.IVJ == 1) {
        this.IVK.aFk();
      }
      this.IVL = true;
      az.agi().a(this.IVK, 0);
      by.azu().d(by.hpK, null);
    }
    AppMethodBeat.o(39304);
  }
  
  private void a(final String paramString, final k.b paramb, final byte[] paramArrayOfByte, bo parambo)
  {
    AppMethodBeat.i(39295);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, paramb.cZa });
    Object localObject1 = m.aGn(paramb.cZa);
    if (!bs.isNullOrNil(paramb.hhL)) {
      localObject1 = m.c(parambo, paramb.cZa);
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
          az.ayM();
          localObject2 = m.aj(com.tencent.mm.model.c.awT(), paramb.title, paramb.hhG);
          com.tencent.mm.vfs.i.lZ(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, (String)localObject2);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, paramb.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).cOg()) });
        }
      }
    }
    localObject3 = k.b.a(paramb);
    ((k.b)localObject3).hhI = 3;
    if ((parambo != null) && (paramb.type == 6) && (!bs.isNullOrNil(paramb.hhL)) && (localObject1 != null) && ((!com.tencent.mm.vfs.i.eA(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.i.aSp(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)))
    {
      a((k.b)localObject3, (com.tencent.mm.pluginsdk.model.app.c)localObject1, parambo, paramString, (String)localObject2, paramArrayOfByte);
      AppMethodBeat.o(39295);
      return;
    }
    if ((bs.isNullOrNil((String)localObject2)) && ((paramb.hhJ != 0) || (paramb.hhF > 26214400)))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(paramb.hhJ), Integer.valueOf(paramb.hhF) });
      az.agi().a(new com.tencent.mm.pluginsdk.model.app.ac(paramb, null, paramString, new ac.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, long paramAnonymousLong)
        {
          AppMethodBeat.i(39281);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramAnonymousString1, bs.aLJ(paramAnonymousString2), bs.aLJ(paramAnonymousString3), bs.aLJ(paramb.fQi), bs.aLJ(paramAnonymousString4), bs.aLJ(paramAnonymousString5) });
          if (!bs.isNullOrNil(paramAnonymousString3))
          {
            m.a(this.IWl, paramb.appId, paramb.appName, paramString, "", paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this), paramAnonymousString3);
            AppMethodBeat.o(39281);
            return;
          }
          com.tencent.mm.ui.base.h.c(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(2131757939), "", true);
          MsgRetransmitUI.this.finish();
          AppMethodBeat.o(39281);
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
      paramb = URLEncoder.encode(bs.nullAsNil(((k.b)localObject3).url));
      paramArrayOfByte = URLEncoder.encode(bs.nullAsNil(((k.b)localObject3).title));
      parambo = URLEncoder.encode(bs.nullAsNil(((k.b)localObject3).description));
      localObject1 = URLEncoder.encode(bs.nullAsNil(((k.b)localObject3).hkd));
      com.tencent.mm.plugin.report.service.h.wUl.f(14127, new Object[] { ((k.b)localObject3).appId, ((k.b)localObject3).hke, localObject1, paramArrayOfByte, parambo, "", paramb, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString });
      AppMethodBeat.o(39295);
      return;
    }
  }
  
  private boolean a(final com.tencent.mm.av.e parame, final bo parambo, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39302);
    Object localObject = bv.L(parame.hGY, "msg");
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { parame.hGY });
      AppMethodBeat.o(39302);
      return false;
    }
    final int j = parame.hGP;
    String str1;
    if (j != 1) {
      str1 = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
    }
    for (final int i = 2;; i = 1)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), str1 });
      if (!bs.isNullOrNil(str1)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(39302);
      return false;
      str1 = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    }
    String str2 = (String)((Map)localObject).get(".msg.img.$aeskey");
    if (bs.isNullOrNil(str2))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
      AppMethodBeat.o(39302);
      return false;
    }
    if (bs.isNullOrNil(com.tencent.mm.an.c.a("downimg", parame.hGU, parambo.field_talker, parambo.field_msgId)))
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambo.field_msgSvrId) });
      AppMethodBeat.o(39302);
      return false;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$md5");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(39267);
        if (paramAnonymousd != null)
        {
          if (!paramAnonymousd.field_exist_whencheck) {
            break label78;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymousd, parambo, paramInt, paramString2, paramString3, paramString1, this.laP, j);
        }
        for (;;)
        {
          AppMethodBeat.o(39267);
          return 0;
          label78:
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
          MsgRetransmitUI.a(MsgRetransmitUI.this, parame, parambo, paramString1, paramInt, paramString2, paramString3);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), paramString2, parambo.field_msgId);
    localg.field_fileId = str1;
    localg.field_aesKey = str2;
    localg.field_filemd5 = ((String)localObject);
    localg.field_fileType = i;
    localg.field_talker = paramString2;
    localg.field_priority = com.tencent.mm.i.a.fqp;
    localg.field_svr_signature = "";
    localg.field_onlycheckexist = true;
    localg.field_trysafecdn = true;
    if (!com.tencent.mm.an.f.aDD().f(localg))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
      AppMethodBeat.o(39302);
      return false;
    }
    AppMethodBeat.o(39302);
    return true;
  }
  
  /* Error */
  private static boolean aRq(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc_w 1056
    //   7: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 293
    //   13: ldc_w 1058
    //   16: iconst_1
    //   17: anewarray 307	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 641	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: invokestatic 1062	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: new 1064	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 1065	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: iconst_1
    //   51: putfield 1068	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: aconst_null
    //   60: aload 5
    //   62: invokestatic 1074	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: getfield 1077	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: iflt +29 -> 103
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 1080	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: istore_1
    //   86: iload_1
    //   87: iflt +16 -> 103
    //   90: aload 4
    //   92: invokestatic 1083	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   95: ldc_w 1056
    //   98: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload_2
    //   102: ireturn
    //   103: iconst_0
    //   104: istore_2
    //   105: goto -15 -> 90
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_3
    //   111: ldc_w 293
    //   114: ldc_w 1085
    //   117: iconst_1
    //   118: anewarray 307	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: invokestatic 1021	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: invokestatic 1083	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   132: ldc_w 1056
    //   135: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_3
    //   142: invokestatic 1083	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   145: ldc_w 1056
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
  
  private boolean aRs(final String paramString)
  {
    AppMethodBeat.i(39294);
    final k.b localb = k.b.vA(bs.aLx(this.drV));
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.drV, localb });
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(39294);
      return false;
    }
    if ((localb.type == 53) || (localb.type == 57))
    {
      localObject1 = localb.title;
      com.tencent.mm.model.u.axw();
      paramString = new com.tencent.mm.modelmulti.i(paramString, (String)localObject1, com.tencent.mm.model.w.xt(paramString), 0);
      az.agi().a(paramString, 0);
      AppMethodBeat.o(39294);
      return true;
    }
    az.ayM();
    final bo localbo = com.tencent.mm.model.c.awD().vP(this.msgId);
    if (localbo.eZj())
    {
      if (localb.type == 33) {
        com.tencent.mm.ui.chatting.l.b(paramString, localb, ch.c(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        AppMethodBeat.o(39294);
        return true;
        com.tencent.mm.ui.chatting.j.a(this, paramString, this.drV, localbo.field_isSend, this.HIm);
      }
    }
    Object localObject3 = null;
    Object localObject1 = null;
    byte[] arrayOfByte = null;
    boolean bool;
    if (this.IVE == null)
    {
      localObject1 = localObject3;
      if (this.ImY < 0)
      {
        localObject1 = localObject3;
        if (localbo.field_imgPath != null)
        {
          localObject1 = localObject3;
          if (!localbo.field_imgPath.equals(""))
          {
            localObject3 = com.tencent.mm.av.o.aFx().R(localbo.field_imgPath, true);
            localObject1 = arrayOfByte;
            try
            {
              arrayOfByte = com.tencent.mm.vfs.i.aU((String)localObject3, 0, -1);
              localObject1 = arrayOfByte;
              bool = cz(arrayOfByte);
              localObject1 = arrayOfByte;
              if (!bool)
              {
                AppMethodBeat.o(39294);
                return false;
              }
            }
            catch (Exception localException1)
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException1.getLocalizedMessage() });
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new com.tencent.mm.ah.a();
      }
      ((com.tencent.mm.ah.a)localObject2).hgn = this.IWc;
      localb.a((com.tencent.mm.ah.f)localObject2);
      com.tencent.e.h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39277);
          MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, localb, this.IWk, localbo);
          AppMethodBeat.o(39277);
        }
      }, "MicroMsg.MsgRetransmitUI");
      break;
      try
      {
        localObject2 = com.tencent.mm.vfs.i.aU(this.IVE, 0, -1);
        localObject1 = localObject2;
        bool = cz((byte[])localObject2);
        localObject1 = localObject2;
        if (!bool)
        {
          AppMethodBeat.o(39294);
          return false;
        }
      }
      catch (Exception localException2)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.MsgRetransmitUI", localException2, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException2.getLocalizedMessage() });
      }
    }
  }
  
  private void aRt(final String paramString)
  {
    AppMethodBeat.i(39300);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new com.tencent.mm.pluginsdk.model.l(this, null, getIntent(), paramString, 1, new l.a()
    {
      public final void eKI()
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
    com.tencent.e.h.JZN.aS(paramString);
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39266);
        paramString.eKC();
        MsgRetransmitUI.this.IWe = true;
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39266);
      }
    });
    AppMethodBeat.o(39300);
  }
  
  private void b(com.tencent.mm.av.e parame, bo parambo, final String paramString1, final int paramInt, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(39303);
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = parame.hGP;
    long l1 = com.tencent.mm.av.o.aFx().a(this.fileName, i, paramInt, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.av.e locale = com.tencent.mm.av.o.aFx().c(Long.valueOf(l1));
    locale.oP(1);
    bo localbo = new bo();
    localbo.setType(com.tencent.mm.model.w.xu(paramString2));
    localbo.re(paramString2);
    localbo.jT(1);
    localbo.setStatus(1);
    localbo.rf(((PString)localObject).value);
    localbo.ke(localPInt1.value);
    localbo.kf(localPInt2.value);
    localbo.oA(bi.yp(localbo.field_talker));
    if (com.tencent.mm.al.f.so(localbo.field_talker)) {
      parambo.qf(com.tencent.mm.al.a.e.TG());
    }
    az.ayM();
    long l2 = com.tencent.mm.model.c.awD().ap(localbo);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      locale.qe((int)l2);
      com.tencent.mm.av.o.aFx().a(Long.valueOf(l1), locale);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), parame);
      com.tencent.mm.av.o.aFy().a(parame.dcd, parambo.field_msgId, i, localObject, 2131231564, new d.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
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
              paramAnonymousn = (com.tencent.mm.av.e)paramAnonymousn.getValue();
              MsgRetransmitUI.this.fileName = com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c(paramAnonymousn), "", "");
              if (paramAnonymousInt1 != 0)
              {
                az.ayM();
                com.tencent.mm.model.c.awD().vQ(paramAnonymousString.longValue());
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
  
  private boolean cQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39297);
    if (this.fileName == null)
    {
      AppMethodBeat.o(39297);
      return false;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(this.fileName);
    long l;
    Object localObject1;
    label71:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = com.tencent.mm.vfs.i.aSp(this.fileName);
      if (localEmojiInfo != null) {
        break label280;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.m.b.ZF()) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.m.b.ZF())) {
        break label627;
      }
    }
    label280:
    label620:
    label627:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.m.b.ZG()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.JC())
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.IWb = false;
          this.IVG = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131758246), "", getString(2131760315), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39283);
              MsgRetransmitUI.this.finish();
              AppMethodBeat.o(39283);
            }
          });
          if (this.IVR == 1) {
            com.tencent.mm.plugin.report.service.h.wUl.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.JC(), Integer.valueOf(1) });
          }
          AppMethodBeat.o(39297);
          return true;
          l = com.tencent.mm.vfs.i.aSp(localEmojiInfo.ghd());
          break;
          localObject1 = localEmojiInfo.ghd();
          break label71;
        }
      }
      if (this.IVR == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
        if (localEmojiInfo == null)
        {
          localObject1 = "";
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), localObject1, Integer.valueOf(1) });
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
      for (localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL((String)localObject1);; localObject1 = localEmojiInfo)
      {
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).JC(), Integer.valueOf(2) });
          com.tencent.mm.ui.chatting.j.c((EmojiInfo)localObject1, paramString);
        }
        finish();
        AppMethodBeat.o(39297);
        return true;
        localObject1 = localEmojiInfo.JC();
        break;
        if ((localEmojiInfo != null) && (l > ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(localEmojiInfo, false)))
        {
          com.tencent.mm.ui.chatting.j.c(localEmojiInfo, paramString);
          AppMethodBeat.o(39297);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(this, paramString, this.fileName))
        {
          AppMethodBeat.o(39297);
          return true;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
        AppMethodBeat.o(39297);
        return false;
      }
    }
  }
  
  private static boolean cz(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39306);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", new Object[] { Byte.valueOf(paramArrayOfByte[0]), Byte.valueOf(paramArrayOfByte[1]), Byte.valueOf(paramArrayOfByte[2]), Byte.valueOf(paramArrayOfByte[3]), Byte.valueOf(paramArrayOfByte[4]) });
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
  
  private void fuf()
  {
    AppMethodBeat.i(39292);
    label181:
    Object localObject6;
    switch (this.IVJ)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.IVJ) });
      finish();
      AppMethodBeat.o(39292);
      return;
    case 0: 
      boolean bool3;
      switch (this.msgType)
      {
      case 3: 
      default: 
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
      case 2: 
      case 6: 
      case 10: 
      case 12: 
      case 13: 
      case 14: 
      case 16: 
        i = 1;
        if (i == 0) {
          break label2232;
        }
        bool3 = true;
        if ((this.msgType != 11) && (this.msgType != 1)) {
          break label1079;
        }
        localObject1 = this.IVD;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
        if ((11 == this.msgType) && (com.tencent.mm.modelvideo.u.El(this.fileName)))
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
          if (this.IVQ) {
            com.tencent.mm.ui.chatting.k.xf(true);
          }
          AppMethodBeat.o(39292);
          return;
          if (fug()) {
            break;
          }
          finish();
          i = 0;
          break label181;
          if ((this.drV != null) && (!this.drV.equals(""))) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          finish();
          i = 0;
          break label181;
          if (!fug())
          {
            finish();
            i = 0;
            break label181;
          }
          if (this.fileName != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
          finish();
          i = 0;
          break label181;
          if ((this.drV != null) && (!this.drV.equals(""))) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          break label181;
          localObject3 = new b((byte)0);
          ((b)localObject3).IWx = new LinkedList();
          ((b)localObject3).IWx.addAll((Collection)localObject1);
          localObject4 = com.tencent.mm.modelvideo.u.Ej(this.fileName);
          if (localObject4 != null) {
            break label516;
          }
          az.ayM();
          if (!com.tencent.mm.model.c.awD().vP(this.msgId).cru()) {
            break label516;
          }
          iy((List)localObject1);
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { localObject1, localObject2 });
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
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
        i = 0;
      }
      final int j;
      while (i == 0)
      {
        fuh();
        break;
        Object localObject7 = bv.L(((com.tencent.mm.modelvideo.s)localObject4).aJK(), "msg");
        if (localObject7 == null)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
          i = 0;
        }
        else
        {
          localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
          if (bs.isNullOrNil((String)localObject1))
          {
            i = 0;
          }
          else
          {
            localObject2 = (String)((Map)localObject7).get(".msg.videomsg.$aeskey");
            final String str1 = (String)((Map)localObject7).get(".msg.videomsg.$md5");
            final String str2 = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
            i = bs.getInt((String)((Map)localObject7).get(".msg.videomsg.$length"), 0);
            j = bs.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
            final int k = bs.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
            if (bs.isNullOrNil(str1))
            {
              com.tencent.mm.modelvideo.o.aJy();
              if (!com.tencent.mm.vfs.i.eA(com.tencent.mm.modelvideo.t.DV(((com.tencent.mm.modelvideo.s)localObject4).getFileName())))
              {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1328L, 1L, 1L, true);
                i = 0;
                continue;
              }
            }
            localObject7 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject7).frb = new g.a()
            {
              public final int a(final String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(39276);
                if (paramAnonymousd != null)
                {
                  if (!paramAnonymousd.field_exist_whencheck) {
                    break label356;
                  }
                  paramAnonymousd.field_fileId = this.val$url;
                  paramAnonymousd.field_aesKey = this.CCX;
                  paramAnonymousd.field_thumbimgLength = k;
                  paramAnonymousd.field_fileLength = i;
                  paramAnonymousd.field_toUser = this.cKY;
                  paramAnonymousd.field_filemd5 = str1;
                  paramAnonymousd.field_mp4identifymd5 = str2;
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
                  paramAnonymousString = com.tencent.mm.modelvideo.t.DU(com.tencent.mm.model.u.axw());
                  com.tencent.mm.modelvideo.o.aJy();
                  paramAnonymousc = com.tencent.mm.modelvideo.t.DW(paramAnonymousString);
                  com.tencent.mm.modelvideo.o.aJy();
                  com.tencent.mm.vfs.i.lZ(com.tencent.mm.modelvideo.t.DW(MsgRetransmitUI.this.fileName), paramAnonymousc);
                  paramAnonymousc = "<msg><videomsg aeskey=\"" + this.CCX + "\" cdnthumbaeskey=\"" + this.CCX + "\" cdnvideourl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
                  com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, this.cKY, paramAnonymousc, this.Ids.iaJ);
                  com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.modelvideo.h(paramAnonymousString, 0, paramAnonymousd, new h.a()
                  {
                    public final void dm(int paramAnonymous2Int1, int paramAnonymous2Int2)
                    {
                      AppMethodBeat.i(39275);
                      com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Ej(paramAnonymousString);
                      locals.status = 111;
                      locals.drx = 256;
                      com.tencent.mm.modelvideo.o.aJy().c(locals);
                      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                      AppMethodBeat.o(39275);
                    }
                  }), 0);
                  MsgRetransmitUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(39276);
                  return 0;
                  label356:
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                  MsgRetransmitUI.i(MsgRetransmitUI.this);
                }
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            ((com.tencent.mm.i.g)localObject7).field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), (String)localObject6, this.msgId);
            ((com.tencent.mm.i.g)localObject7).field_fileId = ((String)localObject1);
            ((com.tencent.mm.i.g)localObject7).field_aesKey = ((String)localObject2);
            ((com.tencent.mm.i.g)localObject7).field_filemd5 = str1;
            ((com.tencent.mm.i.g)localObject7).field_fileType = 4;
            ((com.tencent.mm.i.g)localObject7).field_talker = ((String)localObject6);
            ((com.tencent.mm.i.g)localObject7).field_priority = com.tencent.mm.i.a.fqp;
            ((com.tencent.mm.i.g)localObject7).field_svr_signature = "";
            ((com.tencent.mm.i.g)localObject7).field_onlycheckexist = true;
            ((com.tencent.mm.i.g)localObject7).field_trysafecdn = true;
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { localObject1, str1, localObject2, ((com.tencent.mm.modelvideo.s)localObject4).aJK() });
            if (!com.tencent.mm.an.f.aDD().f((com.tencent.mm.i.g)localObject7))
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
              finish();
              i = 0;
            }
            else
            {
              this.IVG = false;
              finish();
              i = 1;
            }
          }
        }
      }
      if (this.msgType == 0) {
        this.IVV = this.IVD.size();
      }
      final int i = this.IVD.size();
      localObject1 = this.IVD.iterator();
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
            if (this.IVQ) {
              com.tencent.mm.ui.chatting.k.xf(bool2);
            }
            i = j;
            bool3 = bool1;
            break;
            bool2 = false;
            break label1153;
            az.agU().Kw();
            com.tencent.e.h.JZN.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(39258);
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                MsgRetransmitUI.a(MsgRetransmitUI.this, this.fur);
                AppMethodBeat.o(39258);
              }
            }, "MicroMsg.MsgRetransmitUI");
          }
        case 2: 
        case 16: 
        case 19: 
          bool1 = aRs((String)localObject2);
        }
        for (;;)
        {
          break;
          com.tencent.mm.model.u.axw();
          localObject2 = new com.tencent.mm.modelmulti.i((String)localObject2, this.drV, com.tencent.mm.model.w.xt((String)localObject2), 0);
          az.agi().a((n)localObject2, 0);
          bool1 = true;
          continue;
          bool1 = cQ((String)localObject2, false);
          continue;
          localObject3 = k.b.vA(bs.aLx(this.drV));
          if (localObject3 == null) {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
          }
          for (bool1 = false;; bool1 = true)
          {
            break;
            a((String)localObject2, (k.b)localObject3, null, null);
          }
          localObject2 = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.s.n((String)localObject2, this.fileName, this.length), 1);
          az.agi().a((n)localObject2, 0);
          bool1 = true;
          continue;
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.msgId);
          if (((bo)localObject3).getType() == 42)
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "set forward flag");
            ((bo)localObject3).fbT();
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.msgId, (bo)localObject3);
          }
          localObject3 = bo.a.aOk(this.drV);
          localObject4 = this.drV;
          if (ai.aNc(((bo.a)localObject3).zTO)) {}
          for (i = 66;; i = 42)
          {
            localObject2 = new com.tencent.mm.modelmulti.i((String)localObject2, (String)localObject4, i, 1);
            az.agi().a((n)localObject2, 0);
            bool1 = bool3;
            break;
          }
          localObject2 = new com.tencent.mm.modelmulti.i((String)localObject2, this.drV, 48, 0);
          az.agi().a((n)localObject2, 0);
          bool1 = true;
          continue;
          localObject3 = new pw();
          ((pw)localObject3).dsN.type = 4;
          localObject4 = ((pw)localObject3).dsN;
          az.ayM();
          ((pw.a)localObject4).dpq = com.tencent.mm.model.c.awD().vP(this.msgId);
          ((pw)localObject3).dsN.toUser = ((String)localObject2);
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.k.m(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          com.tencent.mm.ui.chatting.k.l(this, (String)localObject2, bool2);
          bool1 = bool3;
          break;
          localObject3 = new sz();
          ((sz)localObject3).dvS.dbz = this.msgId;
          ((sz)localObject3).dvS.dkV = this.drV;
          ((sz)localObject3).dvS.dkW = ((String)localObject2);
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
          bool1 = bool3;
          break;
          if (!bs.isNullOrNil(this.drV))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", new Object[] { localObject2 });
            localObject3 = k.b.vA(this.drV);
            if (localObject3 != null)
            {
              w.a.awq().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              localObject2 = (com.tencent.mm.plugin.i.a.b)((k.b)localObject3).ao(com.tencent.mm.plugin.i.a.b.class);
              if (localObject2 != null)
              {
                localObject3 = new LinkedList();
                ((List)localObject3).add(((com.tencent.mm.plugin.i.a.b)localObject2).hTI.objectId);
                ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).shareStatsReport((List)localObject3);
              }
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!bs.isNullOrNil(this.drV))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", new Object[] { localObject2 });
            localObject3 = k.b.vA(this.drV);
            if (localObject3 != null) {
              w.a.awq().a((k.b)localObject3, "", "", (String)localObject2, "", null);
            }
          }
          for (bool1 = true;; bool1 = false) {
            break;
          }
          if (!bs.isNullOrNil(this.drV))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", new Object[] { localObject2 });
            localObject3 = k.b.vA(this.drV);
            if (localObject3 != null)
            {
              w.a.awq().a((k.b)localObject3, "", "", (String)localObject2, "", null);
              bool1 = true;
              continue;
            }
          }
          bool1 = false;
        }
      }
      localObject3 = (String)this.IVD.get(0);
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
        localObject4 = k.b.vA(bs.aLx(this.drV));
        if ((localObject4 != null) && (((k.b)localObject4).type == 5) && (!bs.isNullOrNil(((k.b)localObject4).url))) {
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
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            i = 2;
          }
        }
        if (bool3)
        {
          i = 1;
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.IVW), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.IVW), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      while (bool3)
      {
        if (this.IVG) {
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        }
        localObject1 = new Intent();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(this.IVD);
        ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
        setResult(-1, (Intent)localObject1);
        if (this.IWb) {
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
        if ((this.IVF) && (!this.IVT))
        {
          localObject1 = new Intent(this, ChattingUI.class);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("Chat_User", (String)localObject3);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(39292);
        return;
        if ((!bool3) && (localObject4 != null) && (((k.b)localObject4).type == 33))
        {
          localObject1 = new com.tencent.mm.g.a.o();
          ((com.tencent.mm.g.a.o)localObject1).cYN.scene = this.IVZ;
          ((com.tencent.mm.g.a.o)localObject1).cYN.cca = this.IWa;
          if (2 == this.IVZ)
          {
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYP = (this.IVY + ":" + this.IVX);
            if (!((String)localObject3).endsWith("@chatroom")) {
              break label2927;
            }
          }
          for (((com.tencent.mm.g.a.o)localObject1).cYN.action = 2;; ((com.tencent.mm.g.a.o)localObject1).cYN.action = 1)
          {
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYO = (((k.b)localObject4).hkq + 1);
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYQ = ((k.b)localObject4).hkd;
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYF = ((k.b)localObject4).hke;
            ((com.tencent.mm.g.a.o)localObject1).cYN.appId = ((k.b)localObject4).hkf;
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYR = "";
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYS = bs.aNx();
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYT = 2;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
            break;
            ((com.tencent.mm.g.a.o)localObject1).cYN.cYP = this.IVY;
            break label2795;
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
      localObject1 = (String)this.IVD.get(0);
      label640:
      label1079:
      label2232:
      label2795:
      label2927:
      if (!fug())
      {
        finish();
        AppMethodBeat.o(39292);
        return;
      }
      label1153:
      switch (this.msgType)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        AppMethodBeat.o(39292);
        return;
      case 0: 
        if ((this.IVM != null) && (this.IVM.size() > 0)) {
          this.IVO = this.IVM.size();
        }
        this.hIl = new com.tencent.mm.ak.h()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
          {
            AppMethodBeat.i(39259);
            if ((MsgRetransmitUI.b(MsgRetransmitUI.this) == null) || (paramAnonymousInt2 == 0))
            {
              AppMethodBeat.o(39259);
              return;
            }
            paramAnonymousInt1 = (int)(paramAnonymousInt1 * 100L / paramAnonymousInt2);
            MsgRetransmitUI.b(MsgRetransmitUI.this).setMessage(MsgRetransmitUI.this.getString(2131761378, new Object[] { Integer.valueOf(MsgRetransmitUI.c(MsgRetransmitUI.this)), Integer.valueOf(MsgRetransmitUI.d(MsgRetransmitUI.this)), Integer.valueOf(paramAnonymousInt1) }));
            AppMethodBeat.o(39259);
          }
        };
        this.IVH = com.tencent.mm.ui.base.h.d(this, getString(2131761378, new Object[] { Integer.valueOf(1), Integer.valueOf(this.IVO), Integer.valueOf(0) }), getString(2131755906), new DialogInterface.OnClickListener()
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
        if (this.IVH != null)
        {
          this.IVH.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(39263);
              com.tencent.mm.ui.base.h.b(MsgRetransmitUI.this, 2131761372, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(39261);
                  com.tencent.mm.av.g localg;
                  com.tencent.mm.av.e locale;
                  if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null)
                  {
                    az.agi().a(MsgRetransmitUI.e(MsgRetransmitUI.this));
                    paramAnonymous2Int = (int)MsgRetransmitUI.e(MsgRetransmitUI.this).hIm;
                    paramAnonymous2DialogInterface = com.tencent.mm.av.o.aFx().oR(paramAnonymous2Int);
                    if (paramAnonymous2DialogInterface != null)
                    {
                      localg = com.tencent.mm.av.o.aFx();
                      locale = localg.oR(paramAnonymous2Int);
                      if ((locale != null) && (locale.dcd == paramAnonymous2Int)) {
                        break label137;
                      }
                    }
                  }
                  for (;;)
                  {
                    az.ayM();
                    com.tencent.mm.model.c.awD().vQ(paramAnonymous2DialogInterface.hGV);
                    Toast.makeText(MsgRetransmitUI.this, 2131761373, 1).show();
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(39261);
                    return;
                    label137:
                    com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGM, "", ""));
                    com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGR, "", ""));
                    com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGO, "", ""));
                    com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGO, "", "") + "hd");
                    localg.hpA.delete("ImgInfo2", "id=?", new String[] { String.valueOf(paramAnonymous2Int) });
                    if (locale.aFa())
                    {
                      locale = localg.oR(locale.hGX);
                      if (locale != null)
                      {
                        com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGM, "", ""));
                        com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGR, "", ""));
                        com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGO, "", ""));
                        com.tencent.mm.vfs.i.deleteFile(localg.p(locale.hGO, "", "") + "hd");
                        localg.hpA.delete("ImgInfo2", "id=?", new String[] { locale.dcd });
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
          this.IVH.setCanceledOnTouchOutside(false);
          this.IVH.getButton(-1).setText(2131755691);
        }
        a((String)localObject1, 6, this.hIl);
        AppMethodBeat.o(39292);
        return;
      case 1: 
      case 11: 
        if (!ae.cS(this))
        {
          com.tencent.mm.ui.base.h.b(this, 2131764676, 2131755906, 2131755835, 2131755691, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(39278);
              MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), this.fur);
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
      cQ((String)localObject1, true);
      AppMethodBeat.o(39292);
      return;
    }
    switch (this.msgType)
    {
    default: 
      AppMethodBeat.o(39292);
      return;
    }
    this.IVD.get(0);
    Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName = ((String)localObject1);
    com.tencent.mm.pluginsdk.model.app.ap.dny().get((com.tencent.mm.sdk.e.c)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new c(new c.a()
    {
      public final void fui()
      {
        AppMethodBeat.i(39271);
        MsgRetransmitUI.this.finish();
        AppMethodBeat.o(39271);
      }
    });
    if (((WXMediaMessage)localObject5).thumbData == null) {}
    for (localObject1 = null;; localObject1 = com.tencent.mm.sdk.platformtools.f.ck(((WXMediaMessage)localObject5).thumbData)) {
      switch (((WXMediaMessage)localObject5).mediaObject.type())
      {
      default: 
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + ((WXMediaMessage)localObject5).mediaObject.type());
        AppMethodBeat.o(39292);
        return;
      }
    }
    localObject1 = View.inflate(this, 2131493113, null);
    ((TextView)((View)localObject1).findViewById(2131305948)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(2131305134)).setText(com.tencent.mm.pluginsdk.model.app.h.a(this, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      ((c)localObject4).iJj = com.tencent.mm.ui.base.h.a(this, null, (View)localObject1, getString(2131755884), getString(2131755691), new c.1((c)localObject4), new c.2((c)localObject4));
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
  
  private boolean fug()
  {
    AppMethodBeat.i(39298);
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.t.g(this, null);
      AppMethodBeat.o(39298);
      return false;
    }
    AppMethodBeat.o(39298);
    return true;
  }
  
  private void fuh()
  {
    AppMethodBeat.i(39308);
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39273);
        com.tencent.mm.modelvideo.o.aJD().a(MsgRetransmitUI.this.fileName, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(39272);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.Ej(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199))
            {
              paramAnonymous2a = new MsgRetransmitUI.b((byte)0);
              paramAnonymous2a.IWx = new LinkedList();
              paramAnonymous2a.IWx.addAll(MsgRetransmitUI.this.IVD);
              Iterator localIterator = MsgRetransmitUI.this.IVD.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", new Object[] { str });
                MsgRetransmitUI.a(MsgRetransmitUI.this, paramAnonymous2a, str);
              }
            }
            AppMethodBeat.o(39272);
          }
        });
        AppMethodBeat.o(39273);
      }
    }, "MicroMsg.MsgRetransmitUI");
    this.IVG = false;
    AppMethodBeat.o(39308);
  }
  
  private void iy(List<String> paramList)
  {
    AppMethodBeat.i(39307);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      aRs((String)paramList.next());
    }
    if (this.IVG) {
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
    if (this.IVP)
    {
      this.IVO = this.IVM.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.IWe) {
            break;
          }
          aRt(paramString);
        }
        AppMethodBeat.o(39299);
        return;
      }
      finish();
      AppMethodBeat.o(39299);
      return;
    }
    this.IVO = 1;
    aRt(paramString);
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
      Object localObject = k.b.vA(bs.aLx(this.drV));
      if ((localObject != null) && (((k.b)localObject).type == 5) && (((k.b)localObject).url != null))
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject).url, Long.valueOf(this.startTime), Integer.valueOf(this.IVW), Integer.valueOf(1), Integer.valueOf(3) });
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
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.IVW), Integer.valueOf(1), Integer.valueOf(3) });
      }
      while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
      {
        finish();
        AppMethodBeat.o(39293);
        return;
      }
      paramIntent = new com.tencent.mm.g.a.o();
      paramIntent.cYN.cca = this.IWa;
      paramIntent.cYN.scene = this.IVZ;
      if (2 == this.IVZ) {}
      for (paramIntent.cYN.cYP = (this.IVY + ":" + this.IVX);; paramIntent.cYN.cYP = this.IVY)
      {
        paramIntent.cYN.cYO = (localUnsupportedEncodingException.hkq + 1);
        paramIntent.cYN.cYQ = localUnsupportedEncodingException.hkd;
        paramIntent.cYN.cYF = localUnsupportedEncodingException.hke;
        paramIntent.cYN.appId = localUnsupportedEncodingException.hkf;
        paramIntent.cYN.action = 1;
        paramIntent.cYN.cYR = "";
        paramIntent.cYN.cYS = bs.aNx();
        paramIntent.cYN.cYT = 3;
        com.tencent.mm.sdk.b.a.GpY.l(paramIntent);
        break;
      }
    }
    if (paramInt1 != 0)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(39293);
      return;
    }
    this.IVD = bs.S(paramIntent.getStringExtra("Select_Conv_User").split(","));
    String str1 = paramIntent.getStringExtra("custom_send_text");
    this.qKh = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.qKh) {
      this.nxq = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    this.IWc = paramIntent.getBooleanExtra("KSendGroupToDo", false);
    this.IWd = paramIntent.getIntExtra("KShowTodoIntroduceView", 0);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.IVJ), Integer.valueOf(this.IVD.size()) });
    fuf();
    if (!TextUtils.isEmpty(str1))
    {
      paramIntent = this.IVD.iterator();
      while (paramIntent.hasNext())
      {
        String str2 = (String)paramIntent.next();
        sk localsk = new sk();
        localsk.dvv.dvw = str2;
        localsk.dvv.content = str1;
        localsk.dvv.type = com.tencent.mm.model.w.xt(str2);
        localsk.dvv.flags = 0;
        com.tencent.mm.sdk.b.a.GpY.l(localsk);
      }
    }
    AppMethodBeat.o(39293);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39289);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    aj.b(getWindow());
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MsgRetransmitUI", "on activity create");
    this.startTime = bs.aNx();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    this.drV = getIntent().getStringExtra("Retr_Msg_content");
    this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
    this.fileName = getIntent().getStringExtra("Retr_File_Name");
    this.IVM = getIntent().getStringArrayListExtra("Retr_File_Path_List");
    boolean bool;
    if ((this.IVM != null) && (this.IVM.size() > 0))
    {
      bool = true;
      this.IVP = bool;
      this.hGP = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.IVJ = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.IVI = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.IVE = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.IVF = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.IVT = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.IVJ != 0) {
        break label767;
      }
      bool = true;
      label258:
      this.IVU = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.IVU) {
        this.IVT = true;
      }
      this.IVG = getIntent().getBooleanExtra("Retr_show_success_tips", this.IVT);
      this.IVQ = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.HIm = getIntent().getBooleanExtra("is_group_chat", false);
      this.iaU = getIntent().getStringExtra("msg_uuid");
      this.ImY = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.IVR = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.hIO = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.dmL = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.hIP = getIntent().getStringExtra("Retr_AttachedContent");
      this.IVS = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.mSessionId = getIntent().getStringExtra("reportSessionId");
      this.IVW = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.IVX = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.IVY = getIntent().getStringExtra("Retr_MsgTalker");
      this.IVZ = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.IWa = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      az.agi().a(110, this);
      if (!com.tencent.mm.compatible.util.d.kZ(19)) {
        setContentView(2131493233);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.IVU) {
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
      paramBundle.putExtra("Retr_Msg_content", this.drV);
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
      if (this.IVW == 3) {
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.ImY);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
      continue;
      az.ayM();
      bo.a locala = com.tencent.mm.model.c.awD().alw(this.drV);
      if ((locala.zTO == null) || (locala.zTO.length() <= 0)) {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MsgRetransmitUI", "getView : parse possible friend msg failed");
      }
      if (!com.tencent.mm.model.w.nN(locala.Chb))
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
        if (com.tencent.mm.ui.chatting.k.fkX())
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MsgRetransmitUI", "has can forward card");
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
    if (!this.IVL) {
      az.agi().b(110, this);
    }
    super.onDestroy();
    AppMethodBeat.o(39291);
  }
  
  @com.tencent.mm.sdk.platformtools.j
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(39310);
    if ((paramn.getType() != 110) || (!(paramn instanceof com.tencent.mm.av.l)))
    {
      AppMethodBeat.o(39310);
      return;
    }
    paramString = (com.tencent.mm.av.l)paramn;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramn = getIntent().getStringExtra("Retr_KSnsId");
      if (!com.tencent.mm.model.w.sQ(paramString.dvw)) {
        break label190;
      }
      localObject = new ts();
      ((ts)localObject).dwx.dnn = paramn;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    while ((this.IVM != null) && (this.IVM.size() > 1))
    {
      this.IVM.remove(0);
      paramn = paramString.dvw;
      paramString = paramn;
      if (bs.isNullOrNil(paramn))
      {
        paramString = paramn;
        if (this.IVD != null) {
          paramString = (String)this.IVD.get(0);
        }
      }
      a(paramString, 3, this.hIl);
      AppMethodBeat.o(39310);
      return;
      label190:
      localObject = new tt();
      ((tt)localObject).dwy.dnn = paramn;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if (this.IVH != null)
    {
      this.IVH.dismiss();
      this.IVH = null;
    }
    this.IVV -= 1;
    if ((this.IVV <= 0) || (!this.IVU))
    {
      this.IVL = false;
      az.agi().b(110, this);
      if (this.IVJ != 0)
      {
        finish();
        if ((this.IVF) && (!this.IVT))
        {
          paramn = new Intent(this, ChattingUI.class);
          paramn.addFlags(67108864);
          paramn.putExtra("Chat_User", paramString.dvw);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lR(0));
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
    public boolean IVG;
    public int IVI;
    public boolean IWo;
    public String IWp;
    public boolean IWq;
    public boolean IWr;
    public boolean IWs;
    public dev IWt;
    public MsgRetransmitUI.b IWu;
    public int IWv;
    public Context context;
    public String dvs;
    public String eul;
    public String fileName;
    public int hYQ;
    public int hpy;
    public String iaU;
    private ao mHandler;
    public Dialog tipDialog;
    public String userName;
    
    public a()
    {
      AppMethodBeat.i(39285);
      this.IWq = true;
      this.IWr = false;
      this.IVG = false;
      this.IWs = true;
      this.IWt = null;
      this.IWu = null;
      this.mHandler = new ao(Looper.getMainLooper());
      AppMethodBeat.o(39285);
    }
  }
  
  static final class b
  {
    public List<String> IWx = null;
    boolean dbS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */