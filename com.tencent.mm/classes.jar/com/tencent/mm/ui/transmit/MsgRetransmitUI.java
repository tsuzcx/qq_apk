package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.n;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.a;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.h.a.pq;
import com.tencent.mm.h.a.qf;
import com.tencent.mm.h.a.qg;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class MsgRetransmitUI
  extends MMBaseActivity
  implements com.tencent.mm.ah.f
{
  public long bIt;
  private float bRt;
  public String bVV;
  private ProgressDialog dnm = null;
  private int ent = 0;
  private com.tencent.mm.ah.g eoM = null;
  private float epo;
  private String epp;
  private String fKV;
  public String fileName;
  long idK;
  boolean kax;
  private int length;
  private ah mHandler = new ah();
  public int msgType;
  private long startTime = 0L;
  private String thumbPath;
  private int vDF = -1;
  private boolean vfS = false;
  private String wgA;
  private String wgB;
  private int wgC;
  private int wgD;
  private boolean wgE = true;
  boolean wgF = false;
  public List<String> wgg;
  private String wgh = null;
  private boolean wgi = true;
  private boolean wgj = false;
  private com.tencent.mm.ui.widget.a.c wgk;
  private int wgl = 0;
  private int wgm = 0;
  private com.tencent.mm.as.l wgn = null;
  private boolean wgo = false;
  private List<String> wgp = null;
  private int wgq = 0;
  private int wgr = 0;
  private boolean wgs = false;
  private boolean wgt = false;
  private int wgu;
  private boolean wgv;
  private boolean wgw = true;
  private boolean wgx = true;
  private int wgy = 0;
  private int wgz;
  
  private void a(com.tencent.mm.as.e parame, bi parambi, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = parame.ent;
    long l1 = o.OJ().a(this.fileName, i, paramInt, 0, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.as.e locale = o.OJ().b(Long.valueOf(l1));
    locale.iF(1);
    bi localbi = new bi();
    localbi.setType(com.tencent.mm.model.s.hX(paramString2));
    localbi.ec(paramString2);
    localbi.fA(1);
    localbi.setStatus(1);
    localbi.ed(((PString)localObject).value);
    localbi.fK(localPInt1.value);
    localbi.fL(localPInt2.value);
    localbi.bg(bd.iK(localbi.field_talker));
    if (com.tencent.mm.ai.f.eW(localbi.field_talker)) {
      parambi.cY(com.tencent.mm.ai.a.e.HR());
    }
    au.Hx();
    long l2 = com.tencent.mm.model.c.Fy().T(localbi);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      y.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = " + l2);
      locale.bV((int)l2);
      o.OJ().a(Long.valueOf(l1), locale);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), parame);
      o.OK().a(parame.enp, parambi.field_msgId, i, localObject, R.g.chat_img_template, new MsgRetransmitUI.10(this, paramString2, paramInt, paramString3, paramString1));
      return;
    }
  }
  
  private void a(MsgRetransmitUI.b paramb, String paramString)
  {
    int i = 0;
    y.l("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
    Object localObject = new MsgRetransmitUI.a();
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_sending), true, new MsgRetransmitUI.13(this, (MsgRetransmitUI.a)localObject));
    ((MsgRetransmitUI.a)localObject).context = this;
    ((MsgRetransmitUI.a)localObject).fileName = this.fileName;
    ((MsgRetransmitUI.a)localObject).ftk = this.dnm;
    ((MsgRetransmitUI.a)localObject).wgl = this.wgl;
    ((MsgRetransmitUI.a)localObject).eHH = this.length;
    ((MsgRetransmitUI.a)localObject).eFO = this.msgType;
    ((MsgRetransmitUI.a)localObject).wgR = false;
    ((MsgRetransmitUI.a)localObject).userName = paramString;
    ((MsgRetransmitUI.a)localObject).wgS = true;
    ((MsgRetransmitUI.a)localObject).wgj = this.wgj;
    ((MsgRetransmitUI.a)localObject).wgV = paramb;
    paramb = u.oe(this.fileName);
    if ((paramb != null) && (paramb.eHQ != null))
    {
      y.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((MsgRetransmitUI.a)localObject).wgU = paramb.eHQ;
      ((MsgRetransmitUI.a)localObject).czr = paramb.SA();
    }
    ((MsgRetransmitUI.a)localObject).execute(new Object[0]);
    bt.If().d(bt.dXE, null);
    if (this.bIt == -1L) {
      return;
    }
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(this.bIt);
    boolean bool = com.tencent.mm.model.s.fn(paramString);
    if (bool)
    {
      paramb = a.c.vgq;
      if (!this.wgv) {
        break label292;
      }
    }
    label292:
    for (localObject = a.d.vgu;; localObject = a.d.vgt)
    {
      if (bool) {
        i = com.tencent.mm.model.m.gM(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localbi, i);
      return;
      paramb = a.c.vgp;
      break;
    }
  }
  
  private void a(String paramString, int paramInt, com.tencent.mm.ah.g paramg)
  {
    String str2 = com.tencent.mm.model.q.Gj();
    String str1 = "";
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(this.bIt);
    if (localbi.field_msgId == this.bIt) {
      str1 = localbi.field_content;
    }
    com.tencent.mm.as.e locale = null;
    if (localbi.field_msgId > 0L) {
      locale = o.OJ().bY(localbi.field_msgId);
    }
    Object localObject;
    if (locale != null)
    {
      localObject = locale;
      if (locale.enp > 0L) {}
    }
    else
    {
      localObject = locale;
      if (localbi.field_msgSvrId > 0L) {
        localObject = o.OJ().bX(localbi.field_msgSvrId);
      }
    }
    if ((str1 == null) && (localbi.field_msgSvrId > 0L)) {
      str1 = ((com.tencent.mm.as.e)localObject).enA;
    }
    for (;;)
    {
      if ((localObject != null) && ((((com.tencent.mm.as.e)localObject).offset < ((com.tencent.mm.as.e)localObject).ebK) || (((com.tencent.mm.as.e)localObject).ebK == 0)) && (!this.wgs))
      {
        locale = o.OJ().bX(localbi.field_msgSvrId);
        localObject = bn.s(locale.enA, "msg");
        int i;
        if (localObject == null)
        {
          y.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { locale.enA });
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            a(locale, localbi, str1, paramInt, paramString, str2);
          }
          return;
          int j = locale.ent;
          if (j != 1) {
            paramg = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
          }
          for (i = 2;; i = 1)
          {
            y.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), paramg });
            if (!bk.bl(paramg)) {
              break label347;
            }
            y.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
            i = 0;
            break;
            paramg = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
          }
          label347:
          String str3 = (String)((Map)localObject).get(".msg.img.$aeskey");
          if (bk.bl(str3))
          {
            y.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
            i = 0;
          }
          else if (bk.bl(com.tencent.mm.ak.c.a("downimg", locale.enw, localbi.field_talker, localbi.field_msgId)))
          {
            y.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(localbi.field_msgSvrId) });
            i = 0;
          }
          else
          {
            localObject = (String)((Map)localObject).get(".msg.img.$md5");
            com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
            localf.dlP = new MsgRetransmitUI.8(this, localbi, paramInt, i, paramString, str2, str1, (String)localObject, j, locale);
            localf.field_mediaId = com.tencent.mm.ak.c.a("checkExist", bk.UY(), paramString, localbi.field_msgId);
            localf.field_fileId = paramg;
            localf.field_aesKey = str3;
            localf.field_filemd5 = ((String)localObject);
            localf.field_fileType = i;
            localf.field_talker = paramString;
            localf.field_priority = com.tencent.mm.j.a.dlk;
            localf.field_svr_signature = "";
            localf.field_onlycheckexist = true;
            localf.field_trysafecdn = true;
            if (!com.tencent.mm.ak.f.Nd().c(localf))
            {
              y.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
        }
      }
      a(paramString, paramInt, str2, str1, paramg);
      return;
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.ah.g paramg)
  {
    if (!bk.bl(this.fileName))
    {
      this.wgq = 1;
      this.wgr = 1;
      if (aeq(this.fileName)) {}
    }
    boolean bool;
    label212:
    do
    {
      do
      {
        return;
        str = this.fileName;
        if (this.ent == 0)
        {
          bool = true;
          if (!com.tencent.mm.model.q.g(str, paramString1, bool)) {
            break label212;
          }
        }
        for (this.ent = 1;; this.ent = 0)
        {
          long l = System.currentTimeMillis();
          com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 96L, 1L, false);
          this.wgn = new com.tencent.mm.as.l(paramInt, paramString2, paramString1, this.fileName, this.ent, paramg, 0, paramString3, "", true, R.g.chat_img_template, this.wgu, this.epo, this.bRt);
          if (this.wgm == 1) {
            this.wgn.Oz();
          }
          au.Dk().a(this.wgn, 0);
          this.wgo = true;
          y.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.ent) });
          bt.If().d(bt.dXD, null);
          return;
          bool = false;
          break;
        }
      } while (!this.wgs);
      this.wgq += 1;
    } while (!aeq((String)this.wgp.get(0)));
    String str = (String)this.wgp.get(0);
    if (this.ent == 0)
    {
      bool = true;
      if (!com.tencent.mm.model.q.g(str, paramString1, bool)) {
        break label412;
      }
    }
    label412:
    for (this.ent = 1;; this.ent = 0)
    {
      y.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.ent) });
      this.wgn = new com.tencent.mm.as.l(paramInt, paramString2, paramString1, (String)this.wgp.get(0), this.ent, paramg, 0, paramString3, "", true, R.g.chat_img_template);
      if (this.wgm == 1) {
        this.wgn.Oz();
      }
      this.wgo = true;
      au.Dk().a(this.wgn, 0);
      bt.If().d(bt.dXD, null);
      return;
      bool = false;
      break;
    }
  }
  
  private void a(String paramString, g.a parama, byte[] paramArrayOfByte, bi parambi)
  {
    y.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, parama.bFE });
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.l.VX(parama.bFE);
    if (!bk.bl(parama.dQB)) {
      localObject1 = com.tencent.mm.pluginsdk.model.app.l.d(parambi, parama.bFE);
    }
    Object localObject3 = "";
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if (((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath != null)
      {
        localObject2 = localObject3;
        if (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath.equals(""))
        {
          au.Hx();
          localObject2 = com.tencent.mm.pluginsdk.model.app.l.aj(com.tencent.mm.model.c.FO(), parama.title, parama.dQw);
          com.tencent.mm.vfs.e.r(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath, (String)localObject2);
          y.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath, parama.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.b)localObject1).aXY()) });
        }
      }
    }
    localObject3 = g.a.a(parama);
    ((g.a)localObject3).dQy = 3;
    if ((parambi != null) && (parama.type == 6) && (!bk.bl(parama.dQB)) && (localObject1 != null) && ((!com.tencent.mm.vfs.e.bK(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.e.aeQ(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_totalLen)))
    {
      parama = new com.tencent.mm.j.f();
      parama.dlP = new MsgRetransmitUI.20(this, (com.tencent.mm.pluginsdk.model.app.b)localObject1, (String)localObject2, parambi, (g.a)localObject3, paramString, paramArrayOfByte);
      parama.field_mediaId = com.tencent.mm.ak.c.a("checkExist", bk.UY(), parambi.field_talker, parambi.field_msgId);
      parama.field_aesKey = ((g.a)localObject3).dQR;
      parama.field_fileType = 19;
      parama.field_authKey = ((g.a)localObject3).dQH;
      parama.dlQ = ((g.a)localObject3).dQB;
      parama.field_fullpath = ((String)localObject2);
      if (!com.tencent.mm.ak.f.Nd().b(parama, -1)) {
        y.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
      }
    }
    do
    {
      return;
      if ((bk.bl((String)localObject2)) && ((parama.dQz != 0) || (parama.dQv > 26214400)))
      {
        y.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(parama.dQz), Integer.valueOf(parama.dQv) });
        au.Dk().a(new aa(parama, null, paramString, new MsgRetransmitUI.19(this, parama, (g.a)localObject3, paramString, paramArrayOfByte)), 0);
        return;
      }
      com.tencent.mm.pluginsdk.model.app.l.a((g.a)localObject3, parama.appId, parama.appName, paramString, (String)localObject2, paramArrayOfByte, this.fKV);
    } while (((g.a)localObject3).type != 36);
    if (paramString.endsWith("chatroom")) {}
    for (int i = 1;; i = 0)
    {
      parama = URLEncoder.encode(bk.pm(((g.a)localObject3).url));
      paramArrayOfByte = URLEncoder.encode(bk.pm(((g.a)localObject3).title));
      parambi = URLEncoder.encode(bk.pm(((g.a)localObject3).description));
      localObject1 = URLEncoder.encode(bk.pm(((g.a)localObject3).dSX));
      com.tencent.mm.plugin.report.service.h.nFQ.f(14127, new Object[] { ((g.a)localObject3).appId, ((g.a)localObject3).dSY, localObject1, paramArrayOfByte, parambi, "", parama, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString });
      return;
    }
  }
  
  private boolean aeo(String paramString)
  {
    byte[] arrayOfByte1 = null;
    Object localObject = null;
    String str = null;
    g.a locala = g.a.gp(bk.ZQ(this.bVV));
    y.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.bVV, locala });
    if (locala == null)
    {
      y.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      return false;
    }
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(this.bIt);
    if (localbi.ctz())
    {
      if (locala.type == 33) {
        com.tencent.mm.ui.chatting.m.b(paramString, locala, cc.e(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        label126:
        return true;
        k.a(this, paramString, this.bVV, localbi.field_isSend, this.vfS);
      }
    }
    if (this.wgh == null)
    {
      localObject = str;
      if (this.vDF < 0)
      {
        localObject = str;
        if (localbi.field_imgPath != null)
        {
          localObject = str;
          if (!localbi.field_imgPath.equals(""))
          {
            str = o.OJ().F(localbi.field_imgPath, true);
            localObject = arrayOfByte1;
          }
        }
      }
    }
    for (;;)
    {
      boolean bool;
      try
      {
        arrayOfByte1 = com.tencent.mm.vfs.e.c(str, 0, -1);
        localObject = arrayOfByte1;
        bool = bI(arrayOfByte1);
        if (!bool) {
          break;
        }
        localObject = arrayOfByte1;
      }
      catch (Exception localException1)
      {
        y.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException1.getLocalizedMessage() });
        continue;
      }
      au.DS().O(new MsgRetransmitUI.15(this, paramString, locala, (byte[])localObject, localbi));
      break label126;
      try
      {
        byte[] arrayOfByte2 = com.tencent.mm.vfs.e.c(this.wgh, 0, -1);
        localObject = arrayOfByte2;
        bool = bI(arrayOfByte2);
        localObject = arrayOfByte2;
        if (!bool) {
          return false;
        }
      }
      catch (Exception localException2)
      {
        y.printErrStackTrace("MicroMsg.MsgRetransmitUI", localException2, "", new Object[0]);
        y.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException2.getLocalizedMessage() });
      }
    }
  }
  
  private void aep(String paramString)
  {
    y.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new j(this, null, getIntent(), paramString, 1, new MsgRetransmitUI.6(this));
    com.tencent.mm.sdk.f.e.post(paramString, "ChattingUI_importMultiVideo");
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new MsgRetransmitUI.7(this, paramString));
  }
  
  /* Error */
  private static boolean aeq(String paramString)
  {
    // Byte code:
    //   0: ldc_w 258
    //   3: ldc_w 1121
    //   6: iconst_2
    //   7: anewarray 320	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: bipush 7
    //   18: invokestatic 713	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic 551	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_0
    //   28: invokestatic 1125	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: new 1127	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   37: dup
    //   38: invokespecial 1128	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: aload_3
    //   46: invokestatic 1134	com/tencent/mm/sdk/platformtools/MMBitmapFactory:checkIsImageLegal	(Ljava/io/InputStream;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Z
    //   49: ifne +58 -> 107
    //   52: aload_2
    //   53: astore_1
    //   54: aload_3
    //   55: invokevirtual 1137	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   58: sipush 2000
    //   61: if_icmplt +46 -> 107
    //   64: aload_2
    //   65: astore_1
    //   66: ldc_w 258
    //   69: ldc_w 1139
    //   72: invokestatic 1141	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: bipush 7
    //   80: aload_3
    //   81: invokestatic 1147	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   84: astore_3
    //   85: aload_2
    //   86: astore_1
    //   87: getstatic 820	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   90: sipush 12712
    //   93: aload_3
    //   94: invokevirtual 1151	com/tencent/mm/plugin/report/service/h:aC	(ILjava/lang/String;)V
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 1156	java/io/InputStream:close	()V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 1156	java/io/InputStream:close	()V
    //   115: iconst_1
    //   116: ireturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_1
    //   120: ldc_w 258
    //   123: ldc_w 1158
    //   126: iconst_1
    //   127: anewarray 320	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: invokestatic 738	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_1
    //   138: ifnull -33 -> 105
    //   141: aload_1
    //   142: invokevirtual 1156	java/io/InputStream:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload_1
    //   152: ifnull +7 -> 159
    //   155: aload_1
    //   156: invokevirtual 1156	java/io/InputStream:close	()V
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_0
    //   165: goto -50 -> 115
    //   168: astore_1
    //   169: goto -10 -> 159
    //   172: astore_0
    //   173: goto -22 -> 151
    //   176: astore_1
    //   177: aload_2
    //   178: astore_1
    //   179: goto -59 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   26	61	1	localObject1	Object
    //   117	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   119	37	1	localObject2	Object
    //   168	1	1	localException	Exception
    //   176	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   178	1	1	localObject3	Object
    //   31	147	2	localInputStream	java.io.InputStream
    //   41	53	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	117	java/io/FileNotFoundException
    //   141	145	147	java/lang/Exception
    //   27	32	150	finally
    //   34	42	150	finally
    //   44	52	150	finally
    //   54	64	150	finally
    //   66	75	150	finally
    //   77	85	150	finally
    //   87	97	150	finally
    //   101	105	161	java/lang/Exception
    //   111	115	164	java/lang/Exception
    //   155	159	168	java/lang/Exception
    //   120	137	172	finally
    //   34	42	176	java/io/FileNotFoundException
    //   44	52	176	java/io/FileNotFoundException
    //   54	64	176	java/io/FileNotFoundException
    //   66	75	176	java/io/FileNotFoundException
    //   77	85	176	java/io/FileNotFoundException
    //   87	97	176	java/io/FileNotFoundException
  }
  
  private static boolean bI(byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d], scene:%d", new Object[] { Byte.valueOf(paramArrayOfByte[0]), Byte.valueOf(paramArrayOfByte[1]), Byte.valueOf(paramArrayOfByte[2]), Byte.valueOf(paramArrayOfByte[3]), Byte.valueOf(paramArrayOfByte[4]), Integer.valueOf(6) });
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
    if ((!MMBitmapFactory.checkIsImageLegal(paramArrayOfByte, localDecodeResultLogger)) && (localDecodeResultLogger.getDecodeResult() >= 2000))
    {
      y.w("MicroMsg.MsgRetransmitUI", "try to send illegal image.");
      paramArrayOfByte = MMBitmapFactory.KVStatHelper.getKVStatString(paramArrayOfByte, 6, localDecodeResultLogger);
      com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramArrayOfByte);
      return false;
    }
    return true;
  }
  
  private boolean bO(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.fileName == null)
    {
      paramBoolean = false;
      return paramBoolean;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(this.fileName);
    long l;
    label53:
    Object localObject1;
    label64:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = com.tencent.mm.vfs.e.aeQ(this.fileName);
      if (localEmojiInfo != null) {
        break label272;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      if (((com.tencent.mm.sdk.platformtools.c.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.m.b.Ag())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.m.b.Ag())) {
        break label591;
      }
    }
    label272:
    label314:
    label584:
    label591:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.m.b.Ah()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.Wv())
        {
          y.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.wgE = false;
          this.wgj = false;
          com.tencent.mm.ui.base.h.a(this, getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", getString(R.l.i_know_it), new MsgRetransmitUI.21(this));
          paramBoolean = bool;
          if (this.wgu != 1) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.Wv(), Integer.valueOf(1) });
          return true;
          l = com.tencent.mm.vfs.e.aeQ(localEmojiInfo.cwL());
          break label53;
          localObject1 = localEmojiInfo.cwL();
          break label64;
        }
      }
      if (this.wgu == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
        if (localEmojiInfo == null)
        {
          localObject1 = "";
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), localObject1, Integer.valueOf(1) });
        }
      }
      else
      {
        if (!paramBoolean) {
          break label500;
        }
        if (localEmojiInfo != null) {
          break label584;
        }
        localObject1 = new WXMediaMessage(new WXEmojiObject(this.fileName));
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject1, "");
      }
      for (localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As((String)localObject1);; localObject1 = localEmojiInfo)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).Wv(), Integer.valueOf(2) });
        k.b((EmojiInfo)localObject1, paramString);
        finish();
        return true;
        localObject1 = localEmojiInfo.Wv();
        break label314;
        label500:
        if ((localEmojiInfo != null) && (l > ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(localEmojiInfo, false)))
        {
          k.b(localEmojiInfo, paramString);
          return true;
        }
        paramBoolean = bool;
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().m(this, paramString, this.fileName)) {
          break;
        }
        y.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
        return false;
      }
    }
  }
  
  private void cJs()
  {
    label171:
    Object localObject6;
    switch (this.wgm)
    {
    default: 
      y.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.wgm) });
      finish();
    case 0: 
      boolean bool1;
      do
      {
        return;
        switch (this.msgType)
        {
        case 3: 
        default: 
          y.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
        case 2: 
        case 6: 
        case 10: 
        case 12: 
        case 13: 
        case 14: 
        case 16: 
          i = 1;
        }
        while (i != 0)
        {
          bool1 = true;
          if ((this.msgType != 11) && (this.msgType != 1)) {
            break label957;
          }
          localObject1 = this.wgg;
          y.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
          if ((11 != this.msgType) || (!u.og(this.fileName))) {
            break label411;
          }
          com.tencent.mm.ui.widget.snackbar.b.a(this, getResources().getString(R.l.sendrequest_send_fail), "", null);
          this.mHandler.postDelayed(new MsgRetransmitUI.18(this), 1800L);
          return;
          if (cJt()) {
            break label171;
          }
          finish();
          i = 0;
          continue;
          if ((this.bVV != null) && (!this.bVV.equals(""))) {
            break label171;
          }
          y.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
          finish();
          i = 0;
          continue;
          finish();
          i = 0;
          continue;
          if (!cJt())
          {
            finish();
            i = 0;
          }
          else
          {
            if (this.fileName != null) {
              break label171;
            }
            y.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
            finish();
            i = 0;
            continue;
            if ((this.bVV != null) && (!this.bVV.equals(""))) {
              break label171;
            }
            y.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
            finish();
            i = 0;
          }
        }
        localObject3 = new MsgRetransmitUI.b((byte)0);
        ((MsgRetransmitUI.b)localObject3).wgX = new LinkedList();
        ((MsgRetransmitUI.b)localObject3).wgX.addAll((Collection)localObject1);
        localObject4 = u.oe(this.fileName);
        localObject5 = ((List)localObject1).iterator();
      } while (!((Iterator)localObject5).hasNext());
      localObject6 = (String)((Iterator)localObject5).next();
      if (localObject4 != null)
      {
        localObject1 = ((com.tencent.mm.modelvideo.s)localObject4).getFileName();
        if (localObject4 == null) {
          break label571;
        }
      }
      for (Object localObject2 = Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject4).status);; localObject2 = "")
      {
        y.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { localObject1, localObject2 });
        if ((localObject4 == null) || (((com.tencent.mm.modelvideo.s)localObject4).status != 199)) {
          break label579;
        }
        a((MsgRetransmitUI.b)localObject3, (String)localObject6);
        break;
        localObject1 = "";
        break label498;
      }
      Object localObject7 = bn.s(((com.tencent.mm.modelvideo.s)localObject4).SD(), "msg");
      if (localObject7 == null)
      {
        y.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
        i = 0;
      }
      int j;
      while (i == 0)
      {
        cJu();
        break;
        localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
        if (bk.bl((String)localObject1))
        {
          i = 0;
        }
        else
        {
          localObject2 = (String)((Map)localObject7).get(".msg.videomsg.$aeskey");
          String str1 = (String)((Map)localObject7).get(".msg.videomsg.$md5");
          String str2 = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
          i = Integer.valueOf((String)((Map)localObject7).get(".msg.videomsg.$length")).intValue();
          j = bk.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
          int k = bk.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
          localObject7 = new com.tencent.mm.j.f();
          ((com.tencent.mm.j.f)localObject7).dlP = new MsgRetransmitUI.14(this, (String)localObject1, (String)localObject2, k, i, (String)localObject6, str1, str2, j);
          ((com.tencent.mm.j.f)localObject7).field_mediaId = com.tencent.mm.ak.c.a("checkExist", bk.UY(), (String)localObject6, this.bIt);
          ((com.tencent.mm.j.f)localObject7).field_fileId = ((String)localObject1);
          ((com.tencent.mm.j.f)localObject7).field_aesKey = ((String)localObject2);
          ((com.tencent.mm.j.f)localObject7).field_filemd5 = str1;
          ((com.tencent.mm.j.f)localObject7).field_fileType = 4;
          ((com.tencent.mm.j.f)localObject7).field_talker = ((String)localObject6);
          ((com.tencent.mm.j.f)localObject7).field_priority = com.tencent.mm.j.a.dlk;
          ((com.tencent.mm.j.f)localObject7).field_svr_signature = "";
          ((com.tencent.mm.j.f)localObject7).field_onlycheckexist = true;
          ((com.tencent.mm.j.f)localObject7).field_trysafecdn = true;
          y.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { localObject1, str1, localObject2, ((com.tencent.mm.modelvideo.s)localObject4).SD() });
          if (!com.tencent.mm.ak.f.Nd().c((com.tencent.mm.j.f)localObject7))
          {
            y.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
            finish();
            i = 0;
          }
          else
          {
            this.wgj = false;
            finish();
            i = 1;
          }
        }
      }
      if (this.msgType == 0) {
        this.wgy = this.wgg.size();
      }
      int i = this.wgg.size();
      localObject1 = this.wgg.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        j = i - 1;
        boolean bool2;
        if (j == 0)
        {
          bool2 = true;
          switch (this.msgType)
          {
          }
        }
        for (;;)
        {
          if (this.wgt) {
            com.tencent.mm.ui.chatting.l.nj(bool2);
          }
          i = j;
          break;
          bool2 = false;
          break label1031;
          au.DS().sQ();
          au.DS().O(new Runnable()
          {
            public final void run()
            {
              y.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
              MsgRetransmitUI.a(MsgRetransmitUI.this, this.dol);
            }
          });
          continue;
          bool1 = aeo((String)localObject2);
          continue;
          com.tencent.mm.model.q.Gj();
          localObject2 = new com.tencent.mm.modelmulti.h((String)localObject2, this.bVV, com.tencent.mm.model.s.hW((String)localObject2));
          au.Dk().a((com.tencent.mm.ah.m)localObject2, 0);
          bool1 = true;
          continue;
          bool1 = bO((String)localObject2, false);
          continue;
          localObject3 = g.a.gp(bk.ZQ(this.bVV));
          if (localObject3 == null)
          {
            y.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            bool1 = false;
          }
          else
          {
            a((String)localObject2, (g.a)localObject3, null, null);
            bool1 = true;
            continue;
            localObject2 = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.q.g((String)localObject2, this.fileName, this.length), 1);
            au.Dk().a((com.tencent.mm.ah.m)localObject2, 0);
            bool1 = true;
            continue;
            localObject3 = bi.a.abZ(this.bVV);
            localObject4 = this.bVV;
            if (ad.aaU(((bi.a)localObject3).pyp)) {}
            for (i = 66;; i = 42)
            {
              localObject2 = new com.tencent.mm.modelmulti.h((String)localObject2, (String)localObject4, i);
              au.Dk().a((com.tencent.mm.ah.m)localObject2, 0);
              break;
            }
            localObject2 = new com.tencent.mm.modelmulti.h((String)localObject2, this.bVV, 48);
            au.Dk().a((com.tencent.mm.ah.m)localObject2, 0);
            bool1 = true;
            continue;
            localObject3 = new nd();
            ((nd)localObject3).bWJ.type = 4;
            localObject4 = ((nd)localObject3).bWJ;
            au.Hx();
            ((nd.a)localObject4).bWO = com.tencent.mm.model.c.Fy().fd(this.bIt);
            ((nd)localObject3).bWJ.toUser = ((String)localObject2);
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
            continue;
            com.tencent.mm.ui.chatting.l.k(this, (String)localObject2, bool2);
            continue;
            com.tencent.mm.ui.chatting.l.j(this, (String)localObject2, bool2);
            continue;
            localObject3 = new pq();
            ((pq)localObject3).bZg.bHR = this.bIt;
            ((pq)localObject3).bZg.bQr = this.bVV;
            ((pq)localObject3).bZg.bQs = ((String)localObject2);
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
          }
        }
      }
      localObject3 = (String)this.wgg.get(0);
      switch (this.msgType)
      {
      case 1: 
      case 11: 
      case 3: 
      case 15: 
      default: 
        finish();
        return;
      }
      if ((this.msgType == 2) || (this.msgType == 16))
      {
        localObject4 = g.a.gp(bk.ZQ(this.bVV));
        if ((localObject4 != null) && (((g.a)localObject4).type == 5) && (!bk.bl(((g.a)localObject4).url))) {
          localObject1 = "";
        }
      }
      else
      {
        try
        {
          localObject2 = URLEncoder.encode(((g.a)localObject4).url, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            i = 2;
          }
        }
        if (bool1)
        {
          i = 1;
          y.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((g.a)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.wgz), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.wgz), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        if (bool1)
        {
          if (this.wgj) {
            com.tencent.mm.ui.widget.snackbar.b.h(this, getString(R.l.has_send));
          }
          localObject1 = new Intent();
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).addAll(this.wgg);
          ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
          setResult(-1, (Intent)localObject1);
          if (this.wgE) {
            this.mHandler.postDelayed(new MsgRetransmitUI.5(this), 1800L);
          }
          if ((!this.wgi) || (this.wgw)) {
            break;
          }
          localObject1 = new Intent(this, ChattingUI.class);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("Chat_User", (String)localObject3);
          startActivity((Intent)localObject1);
          return;
          if ((!bool1) && (localObject4 != null) && (((g.a)localObject4).type == 33))
          {
            localObject1 = new n();
            ((n)localObject1).bFt.scene = this.wgC;
            ((n)localObject1).bFt.bFB = this.wgD;
            if (2 == this.wgC)
            {
              ((n)localObject1).bFt.bFv = (this.wgB + ":" + this.wgA);
              if (!((String)localObject3).endsWith("@chatroom")) {
                break label2266;
              }
            }
            for (((n)localObject1).bFt.action = 2;; ((n)localObject1).bFt.action = 1)
            {
              ((n)localObject1).bFt.bFu = (((g.a)localObject4).dTf + 1);
              ((n)localObject1).bFt.bFw = ((g.a)localObject4).dSX;
              ((n)localObject1).bFt.bFn = ((g.a)localObject4).dSY;
              ((n)localObject1).bFt.appId = ((g.a)localObject4).dSZ;
              ((n)localObject1).bFt.bFx = "";
              ((n)localObject1).bFt.bFy = bk.UX();
              ((n)localObject1).bFt.bFz = 2;
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
              break;
              ((n)localObject1).bFt.bFv = this.wgB;
              break label2134;
            }
          }
        }
      }
      finish();
      return;
    case 1: 
      label411:
      label498:
      localObject1 = (String)this.wgg.get(0);
      label571:
      label579:
      label2134:
      label2266:
      if (!cJt())
      {
        finish();
        return;
      }
      label957:
      switch (this.msgType)
      {
      default: 
        y.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        return;
      case 0: 
        if ((this.wgp != null) && (this.wgp.size() > 0)) {
          this.wgr = this.wgp.size();
        }
        this.eoM = new MsgRetransmitUI.2(this);
        this.wgk = com.tencent.mm.ui.base.h.a(this, getString(R.l.msgretr_uploading_img, new Object[] { Integer.valueOf(1), Integer.valueOf(this.wgr), Integer.valueOf(0) }), getString(R.l.app_tip), new MsgRetransmitUI.3(this));
        this.wgk.setOnCancelListener(new MsgRetransmitUI.4(this));
        this.wgk.setCanceledOnTouchOutside(false);
        this.wgk.getButton(-1).setText(R.l.app_cancel);
        a((String)localObject1, 6, this.eoM);
        return;
      case 1: 
      case 11: 
        if (!ab.bG(this))
        {
          com.tencent.mm.ui.base.h.a(this, R.l.video_export_file_warning, R.l.app_tip, R.l.app_ok, R.l.app_cancel, new MsgRetransmitUI.16(this, (String)localObject1), new MsgRetransmitUI.17(this));
          return;
        }
        n(getIntent(), (String)localObject1);
        return;
      }
      label1031:
      bO((String)localObject1, true);
      return;
    }
    switch (this.msgType)
    {
    default: 
      return;
    }
    this.wgg.get(0);
    Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.f();
    ((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_packageName = ((String)localObject1);
    ap.brn().b((com.tencent.mm.sdk.e.c)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new c(new MsgRetransmitUI.12(this));
    if (((WXMediaMessage)localObject5).thumbData == null) {}
    for (localObject1 = null;; localObject1 = com.tencent.mm.sdk.platformtools.c.bu(((WXMediaMessage)localObject5).thumbData)) {
      switch (((WXMediaMessage)localObject5).mediaObject.type())
      {
      default: 
        y.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + ((WXMediaMessage)localObject5).mediaObject.type());
        return;
      }
    }
    localObject1 = View.inflate(this, R.i.appmsg_transmit_confirm_text, null);
    ((TextView)((View)localObject1).findViewById(R.h.title_tv)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(R.h.source_tv)).setText(com.tencent.mm.pluginsdk.model.app.g.b(this, (com.tencent.mm.pluginsdk.model.app.f)localObject3, null));
      ((c)localObject4).few = com.tencent.mm.ui.base.h.a(this, null, (View)localObject1, getString(R.l.app_send), getString(R.l.app_cancel), new c.1((c)localObject4), new c.2((c)localObject4));
      return;
      View localView = View.inflate(this, R.i.appmsg_transmit_confirm_image, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      ((TextView)localView.findViewById(R.h.title_tv)).setText(((WXMediaMessage)localObject5).title);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.appmsg_transmit_confirm_file, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.appmsg_transmit_confirm_file, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.appmsg_transmit_confirm_file, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.appmsg_transmit_confirm_file, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.appmsg_transmit_confirm_file, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.title_tv);
      localObject6 = (TextView)localView.findViewById(R.h.desc_tv);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
    }
  }
  
  private boolean cJt()
  {
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      y.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.s.gM(this);
      return false;
    }
    return true;
  }
  
  private void cJu()
  {
    au.DS().O(new MsgRetransmitUI.11(this));
    this.wgj = false;
    finish();
  }
  
  private void n(Intent paramIntent, String paramString)
  {
    if (this.wgs)
    {
      this.wgr = this.wgp.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0)) {
        paramIntent = paramIntent.iterator();
      }
      while (paramIntent.hasNext())
      {
        paramIntent.next();
        if (!this.wgF)
        {
          aep(paramString);
          continue;
          finish();
        }
      }
      return;
    }
    this.wgr = 1;
    aep(paramString);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      Object localObject = g.a.gp(bk.ZQ(this.bVV));
      if ((localObject != null) && (((g.a)localObject).type == 5) && (((g.a)localObject).url != null))
      {
        y.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((g.a)localObject).url, Long.valueOf(this.startTime), Integer.valueOf(this.wgz), Integer.valueOf(1), Integer.valueOf(3) });
        paramIntent = "";
        try
        {
          localObject = URLEncoder.encode(((g.a)localObject).url, "UTF-8");
          paramIntent = (Intent)localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            label182:
            y.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.wgz), Integer.valueOf(1), Integer.valueOf(3) });
        break label186;
        finish();
      }
    }
    for (;;)
    {
      label186:
      return;
      if ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33)) {
        break label182;
      }
      paramIntent = new n();
      paramIntent.bFt.bFB = this.wgD;
      paramIntent.bFt.scene = this.wgC;
      if (2 == this.wgC) {}
      for (paramIntent.bFt.bFv = (this.wgB + ":" + this.wgA);; paramIntent.bFt.bFv = this.wgB)
      {
        paramIntent.bFt.bFu = (localUnsupportedEncodingException.dTf + 1);
        paramIntent.bFt.bFw = localUnsupportedEncodingException.dSX;
        paramIntent.bFt.bFn = localUnsupportedEncodingException.dSY;
        paramIntent.bFt.appId = localUnsupportedEncodingException.dSZ;
        paramIntent.bFt.action = 1;
        paramIntent.bFt.bFx = "";
        paramIntent.bFt.bFy = bk.UX();
        paramIntent.bFt.bFz = 3;
        com.tencent.mm.sdk.b.a.udP.m(paramIntent);
        break;
      }
      if (paramInt1 != 0)
      {
        y.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = " + paramInt1);
        return;
      }
      this.wgg = bk.G(paramIntent.getStringExtra("Select_Conv_User").split(","));
      String str1 = paramIntent.getStringExtra("custom_send_text");
      this.kax = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      if (this.kax) {
        this.idK = paramIntent.getLongExtra("key_biz_chat_id", -1L);
      }
      paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
      if (paramInt1 != -1)
      {
        y.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
        this.msgType = paramInt1;
      }
      y.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.wgm), Integer.valueOf(this.wgg.size()) });
      cJs();
      if (TextUtils.isEmpty(str1)) {
        break;
      }
      paramIntent = this.wgg.iterator();
      while (paramIntent.hasNext())
      {
        String str2 = (String)paramIntent.next();
        pe localpe = new pe();
        localpe.bYQ.bYR = str2;
        localpe.bYQ.content = str1;
        localpe.bYQ.type = com.tencent.mm.model.s.hW(str2);
        localpe.bYQ.flags = 0;
        com.tencent.mm.sdk.b.a.udP.m(localpe);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    ak.a(getWindow());
    y.i("MicroMsg.MsgRetransmitUI", "on activity create");
    this.startTime = bk.UX();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    this.bVV = getIntent().getStringExtra("Retr_Msg_content");
    this.bIt = getIntent().getLongExtra("Retr_Msg_Id", -1L);
    this.fileName = getIntent().getStringExtra("Retr_File_Name");
    this.wgp = getIntent().getStringArrayListExtra("Retr_File_Path_List");
    boolean bool;
    if ((this.wgp != null) && (this.wgp.size() > 0))
    {
      bool = true;
      this.wgs = bool;
      this.ent = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.wgm = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.wgl = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.wgh = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.wgi = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.wgw = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.wgm != 0) {
        break label741;
      }
      bool = true;
      label252:
      this.wgx = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.wgx) {
        this.wgw = true;
      }
      this.wgj = getIntent().getBooleanExtra("Retr_show_success_tips", this.wgw);
      this.wgt = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.vfS = getIntent().getBooleanExtra("is_group_chat", false);
      this.vDF = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.wgu = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.epo = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.bRt = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.epp = getIntent().getStringExtra("Retr_AttachedContent");
      this.wgv = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.fKV = getIntent().getStringExtra("reportSessionId");
      this.wgz = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.wgA = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.wgB = getIntent().getStringExtra("Retr_MsgTalker");
      this.wgC = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.wgD = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      au.Dk().a(110, this);
      if (!com.tencent.mm.compatible.util.d.gF(19)) {
        setContentView(R.i.black_empty_layout);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.wgx) {
        paramBundle.putExtra("mutil_select_is_ret", true);
      }
      switch (this.msgType)
      {
      case 3: 
      case 4: 
      case 5: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        paramBundle.putExtra("Select_Conv_Type", 3);
      }
    }
    for (;;)
    {
      paramBundle.putExtra("Retr_Msg_Type", this.msgType);
      paramBundle.putExtra("Retr_Msg_Id", this.bIt);
      paramBundle.putExtra("Retr_Msg_content", this.bVV);
      paramBundle.putExtra("image_path", this.fileName);
      startActivityForResult(paramBundle, 0);
      return;
      bool = false;
      break;
      label741:
      bool = false;
      break label252;
      paramBundle.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
      if (this.wgz == 3) {
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vDF);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
    }
  }
  
  protected void onDestroy()
  {
    if (!this.wgo) {
      au.Dk().b(110, this);
    }
    super.onDestroy();
  }
  
  @com.tencent.mm.sdk.platformtools.f
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm.getType() != 110) || (!(paramm instanceof com.tencent.mm.as.l))) {}
    label172:
    do
    {
      do
      {
        return;
        paramString = (com.tencent.mm.as.l)paramm;
        Object localObject;
        if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
        {
          paramm = getIntent().getStringExtra("Retr_KSnsId");
          if (!com.tencent.mm.model.s.fn(paramString.bYR)) {
            break label172;
          }
          localObject = new qf();
          ((qf)localObject).bZD.bRV = paramm;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        }
        while ((this.wgp != null) && (this.wgp.size() > 1))
        {
          this.wgp.remove(0);
          paramm = paramString.bYR;
          paramString = paramm;
          if (bk.bl(paramm))
          {
            paramString = paramm;
            if (this.wgg != null) {
              paramString = (String)this.wgg.get(0);
            }
          }
          a(paramString, 3, this.eoM);
          return;
          localObject = new qg();
          ((qg)localObject).bZE.bRV = paramm;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        }
        if (this.wgk != null)
        {
          this.wgk.dismiss();
          this.wgk = null;
        }
        this.wgy -= 1;
      } while ((this.wgy > 0) && (this.wgx));
      this.wgo = false;
      au.Dk().b(110, this);
    } while (this.wgm == 0);
    if ((this.wgi) && (!this.wgw))
    {
      paramm = new Intent(this, ChattingUI.class);
      paramm.addFlags(67108864);
      paramm.putExtra("Chat_User", paramString.bYR);
      startActivity(paramm);
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */