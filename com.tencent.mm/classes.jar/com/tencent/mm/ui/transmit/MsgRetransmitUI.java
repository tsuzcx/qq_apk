package com.tencent.mm.ui.transmit;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.a;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ac;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
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
  implements com.tencent.mm.ai.f
{
  public List<String> AyX;
  private String AyY;
  private boolean AyZ;
  private boolean Aza;
  private com.tencent.mm.ui.widget.b.c Azb;
  private int Azc;
  private int Azd;
  private com.tencent.mm.at.l Aze;
  private boolean Azf;
  private List<String> Azg;
  private int Azh;
  private int Azi;
  private boolean Azj;
  private boolean Azk;
  private int Azl;
  private boolean Azm;
  private boolean Azn;
  private boolean Azo;
  private int Azp;
  private int Azq;
  private String Azr;
  private String Azs;
  private int Azt;
  private int Azu;
  private boolean Azv;
  boolean Azw;
  public String cDI;
  public long cpO;
  private float cyV;
  private ProgressDialog eeN;
  private int fDP;
  private float fFN;
  private String fFO;
  private com.tencent.mm.ai.g fFj;
  public String fileName;
  long jUy;
  private int length;
  private ak mHandler;
  private String mSessionId;
  public int msgType;
  boolean muT;
  private long startTime;
  private String thumbPath;
  private int zUQ;
  private boolean zur;
  
  public MsgRetransmitUI()
  {
    AppMethodBeat.i(35090);
    this.AyY = null;
    this.AyZ = true;
    this.Aza = false;
    this.eeN = null;
    this.fDP = 0;
    this.Azc = 0;
    this.Azd = 0;
    this.Aze = null;
    this.Azf = false;
    this.Azg = null;
    this.fFj = null;
    this.Azh = 0;
    this.Azi = 0;
    this.Azj = false;
    this.Azk = false;
    this.zur = false;
    this.zUQ = -1;
    this.Azn = true;
    this.Azo = true;
    this.Azp = 0;
    this.startTime = 0L;
    this.Azv = true;
    this.mHandler = new ak();
    this.Azw = false;
    AppMethodBeat.o(35090);
  }
  
  private void a(j.b paramb, com.tencent.mm.pluginsdk.model.app.b paramb1, bi parambi, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(35098);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = new MsgRetransmitUI.20(this, paramb1, paramString2, parambi, paramb, paramString1, paramArrayOfByte);
    localg.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.aoy(), parambi.field_talker, parambi.field_msgId);
    localg.field_aesKey = paramb.ewj;
    localg.field_fileType = 19;
    localg.field_authKey = paramb.fgI;
    localg.eds = paramb.fgC;
    localg.field_fullpath = paramString2;
    if (!com.tencent.mm.al.f.afO().b(localg, -1)) {
      ab.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
    }
    AppMethodBeat.o(35098);
  }
  
  private void a(MsgRetransmitUI.b paramb, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(35110);
    ab.b("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
    Object localObject = new MsgRetransmitUI.a();
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131297069), true, new MsgRetransmitUI.13(this, (MsgRetransmitUI.a)localObject));
    ((MsgRetransmitUI.a)localObject).context = this;
    ((MsgRetransmitUI.a)localObject).fileName = this.fileName;
    ((MsgRetransmitUI.a)localObject).gKM = this.eeN;
    ((MsgRetransmitUI.a)localObject).Azc = this.Azc;
    ((MsgRetransmitUI.a)localObject).fXx = this.length;
    ((MsgRetransmitUI.a)localObject).fVF = this.msgType;
    ((MsgRetransmitUI.a)localObject).AzI = false;
    ((MsgRetransmitUI.a)localObject).userName = paramString;
    ((MsgRetransmitUI.a)localObject).AzJ = true;
    ((MsgRetransmitUI.a)localObject).Aza = this.Aza;
    ((MsgRetransmitUI.a)localObject).AzM = paramb;
    paramb = u.vr(this.fileName);
    if ((paramb != null) && (paramb.fXG != null))
    {
      ab.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
      ((MsgRetransmitUI.a)localObject).AzL = paramb.fXG;
      ((MsgRetransmitUI.a)localObject).dns = paramb.getUser();
    }
    ((MsgRetransmitUI.a)localObject).execute(new Object[0]);
    bv.abc().c(bv.fnJ, null);
    if (this.cpO == -1L)
    {
      AppMethodBeat.o(35110);
      return;
    }
    aw.aaz();
    bi localbi = com.tencent.mm.model.c.YC().kB(this.cpO);
    boolean bool = com.tencent.mm.model.t.lA(paramString);
    if (bool)
    {
      paramb = a.c.zvn;
      if (!this.Azm) {
        break label302;
      }
    }
    label302:
    for (localObject = a.d.zvr;; localObject = a.d.zvq)
    {
      if (bool) {
        i = com.tencent.mm.model.n.nv(paramString);
      }
      com.tencent.mm.ui.chatting.a.a(paramb, (a.d)localObject, localbi, i);
      AppMethodBeat.o(35110);
      return;
      paramb = a.c.zvm;
      break;
    }
  }
  
  private void a(String paramString, int paramInt, com.tencent.mm.ai.g paramg)
  {
    AppMethodBeat.i(35103);
    String str2 = r.Zn();
    aw.aaz();
    bi localbi = com.tencent.mm.model.c.YC().kB(this.cpO);
    if (localbi.field_msgId == this.cpO)
    {
      String str1 = localbi.field_content;
      Object localObject1 = null;
      if (localbi.field_msgId > 0L) {
        localObject1 = o.ahC().gT(localbi.field_msgId);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.at.e)localObject1).fDL > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localbi.field_msgSvrId > 0L) {
          localObject2 = o.ahC().gS(localbi.field_msgSvrId);
        }
      }
      localObject1 = str1;
      if (bo.isNullOrNil(str1))
      {
        localObject1 = str1;
        if (localbi.field_msgSvrId > 0L) {
          localObject1 = ((com.tencent.mm.at.e)localObject2).fDX;
        }
      }
      if ((localObject2 != null) && ((((com.tencent.mm.at.e)localObject2).offset < ((com.tencent.mm.at.e)localObject2).fsd) || (((com.tencent.mm.at.e)localObject2).fsd == 0)) && (!this.Azj))
      {
        paramg = o.ahC().gS(localbi.field_msgSvrId);
        if (!a(paramg, localbi, (String)localObject1, paramInt, paramString, str2)) {
          b(paramg, localbi, (String)localObject1, paramInt, paramString, str2);
        }
        AppMethodBeat.o(35103);
        return;
      }
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.at.e)localObject2).fDL;; l = -1L)
      {
        a(paramString, paramInt, str2, (String)localObject1, paramg, l);
        AppMethodBeat.o(35103);
        return;
      }
    }
    a(paramString, paramInt, str2, "", paramg, -1L);
    AppMethodBeat.o(35103);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.ai.g paramg, long paramLong)
  {
    AppMethodBeat.i(35106);
    if (!bo.isNullOrNil(this.fileName))
    {
      this.Azh = 1;
      this.Azi = 1;
      if (!auV(this.fileName))
      {
        AppMethodBeat.o(35106);
        return;
      }
      if ((this.fDP == 1) && (!r.g(this.fileName, paramString1, false))) {
        this.fDP = 0;
      }
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 96L, 1L, false);
      this.Aze = new com.tencent.mm.at.l(paramInt, paramString2, paramString1, this.fileName, this.fDP, paramg, 0, paramString3, "", true, 2130838228, this.Azl, this.fFN, this.cyV, paramLong);
      if (this.Azd == 1) {
        this.Aze.ahr();
      }
      aw.Rc().a(this.Aze, 0);
      this.Azf = true;
      ab.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.fDP) });
      bv.abc().c(bv.fnI, null);
      AppMethodBeat.o(35106);
      return;
    }
    if (this.Azj)
    {
      this.Azh += 1;
      if (!auV((String)this.Azg.get(0)))
      {
        AppMethodBeat.o(35106);
        return;
      }
      if ((this.fDP == 1) && (!r.g((String)this.Azg.get(0), paramString1, false))) {
        this.fDP = 0;
      }
      ab.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.fDP) });
      this.Aze = new com.tencent.mm.at.l(paramInt, paramString2, paramString1, (String)this.Azg.get(0), this.fDP, paramg, 0, paramString3, "", true, 2130838228);
      if (this.Azd == 1) {
        this.Aze.ahr();
      }
      this.Azf = true;
      aw.Rc().a(this.Aze, 0);
      bv.abc().c(bv.fnI, null);
    }
    AppMethodBeat.o(35106);
  }
  
  private void a(String paramString, j.b paramb, byte[] paramArrayOfByte, bi parambi)
  {
    AppMethodBeat.i(35097);
    ab.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, paramb.cmN });
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.l.alv(paramb.cmN);
    if (!bo.isNullOrNil(paramb.fgC)) {
      localObject1 = com.tencent.mm.pluginsdk.model.app.l.d(parambi, paramb.cmN);
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
          aw.aaz();
          localObject2 = com.tencent.mm.pluginsdk.model.app.l.Z(com.tencent.mm.model.c.YS(), paramb.title, paramb.fgx);
          com.tencent.mm.vfs.e.C(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath, (String)localObject2);
          ab.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath, paramb.title, localObject2, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.b)localObject1).bEL()) });
        }
      }
    }
    localObject3 = j.b.a(paramb);
    ((j.b)localObject3).fgz = 3;
    if ((parambi != null) && (paramb.type == 6) && (!bo.isNullOrNil(paramb.fgC)) && (localObject1 != null) && ((!com.tencent.mm.vfs.e.cN(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)) || (com.tencent.mm.vfs.e.avI(((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_totalLen)))
    {
      a((j.b)localObject3, (com.tencent.mm.pluginsdk.model.app.b)localObject1, parambi, paramString, (String)localObject2, paramArrayOfByte);
      AppMethodBeat.o(35097);
      return;
    }
    if ((bo.isNullOrNil((String)localObject2)) && ((paramb.fgA != 0) || (paramb.fgw > 26214400)))
    {
      ab.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(paramb.fgA), Integer.valueOf(paramb.fgw) });
      aw.Rc().a(new z(paramb, null, paramString, new MsgRetransmitUI.19(this, paramb, (j.b)localObject3, paramString, paramArrayOfByte)), 0);
      AppMethodBeat.o(35097);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.l.a((j.b)localObject3, paramb.appId, paramb.appName, paramString, (String)localObject2, paramArrayOfByte, this.mSessionId);
    if (((j.b)localObject3).type == 36) {
      if (!paramString.endsWith("chatroom")) {
        break label557;
      }
    }
    label557:
    for (int i = 1;; i = 0)
    {
      paramb = URLEncoder.encode(bo.nullAsNil(((j.b)localObject3).url));
      paramArrayOfByte = URLEncoder.encode(bo.nullAsNil(((j.b)localObject3).title));
      parambi = URLEncoder.encode(bo.nullAsNil(((j.b)localObject3).description));
      localObject1 = URLEncoder.encode(bo.nullAsNil(((j.b)localObject3).fiW));
      com.tencent.mm.plugin.report.service.h.qsU.e(14127, new Object[] { ((j.b)localObject3).appId, ((j.b)localObject3).fiX, localObject1, paramArrayOfByte, parambi, "", paramb, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString });
      AppMethodBeat.o(35097);
      return;
    }
  }
  
  private boolean a(com.tencent.mm.at.e parame, bi parambi, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35104);
    Object localObject = br.F(parame.fDX, "msg");
    if (localObject == null)
    {
      ab.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", new Object[] { parame.fDX });
      AppMethodBeat.o(35104);
      return false;
    }
    int j = parame.fDP;
    String str1;
    if (j != 1) {
      str1 = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
    }
    for (int i = 2;; i = 1)
    {
      ab.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), str1 });
      if (!bo.isNullOrNil(str1)) {
        break;
      }
      ab.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(35104);
      return false;
      str1 = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    }
    String str2 = (String)((Map)localObject).get(".msg.img.$aeskey");
    if (bo.isNullOrNil(str2))
    {
      ab.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
      AppMethodBeat.o(35104);
      return false;
    }
    if (bo.isNullOrNil(com.tencent.mm.al.c.a("downimg", parame.fDT, parambi.field_talker, parambi.field_msgId)))
    {
      ab.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
      AppMethodBeat.o(35104);
      return false;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$md5");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = new MsgRetransmitUI.8(this, parambi, paramInt, i, paramString2, paramString3, paramString1, (String)localObject, j, parame);
    localg.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.aoy(), paramString2, parambi.field_msgId);
    localg.field_fileId = str1;
    localg.field_aesKey = str2;
    localg.field_filemd5 = ((String)localObject);
    localg.field_fileType = i;
    localg.field_talker = paramString2;
    localg.field_priority = com.tencent.mm.i.a.ecF;
    localg.field_svr_signature = "";
    localg.field_onlycheckexist = true;
    localg.field_trysafecdn = true;
    if (!com.tencent.mm.al.f.afO().e(localg))
    {
      ab.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
      AppMethodBeat.o(35104);
      return false;
    }
    AppMethodBeat.o(35104);
    return true;
  }
  
  /* Error */
  private static boolean auV(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc_w 985
    //   7: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 228
    //   12: ldc_w 987
    //   15: iconst_1
    //   16: anewarray 242	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_0
    //   22: aastore
    //   23: invokestatic 568	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: invokestatic 991	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: new 993	android/graphics/BitmapFactory$Options
    //   38: dup
    //   39: invokespecial 994	android/graphics/BitmapFactory$Options:<init>	()V
    //   42: astore 5
    //   44: aload 4
    //   46: astore_3
    //   47: aload 5
    //   49: iconst_1
    //   50: putfield 997	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   53: aload 4
    //   55: astore_3
    //   56: aload 4
    //   58: aconst_null
    //   59: aload 5
    //   61: invokestatic 1003	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   64: pop
    //   65: aload 4
    //   67: astore_3
    //   68: aload 5
    //   70: getfield 1006	android/graphics/BitmapFactory$Options:outWidth	I
    //   73: iflt +29 -> 102
    //   76: aload 4
    //   78: astore_3
    //   79: aload 5
    //   81: getfield 1009	android/graphics/BitmapFactory$Options:outHeight	I
    //   84: istore_1
    //   85: iload_1
    //   86: iflt +16 -> 102
    //   89: aload 4
    //   91: invokestatic 1012	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   94: ldc_w 985
    //   97: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iload_2
    //   101: ireturn
    //   102: iconst_0
    //   103: istore_2
    //   104: goto -15 -> 89
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_3
    //   110: ldc 228
    //   112: ldc_w 1014
    //   115: iconst_1
    //   116: anewarray 242	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: aastore
    //   123: invokestatic 948	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_3
    //   127: invokestatic 1012	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   130: ldc_w 985
    //   133: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: aload_3
    //   140: invokestatic 1012	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   143: ldc_w 985
    //   146: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_0
    //   150: athrow
    //   151: astore_0
    //   152: goto -13 -> 139
    //   155: astore_3
    //   156: aload 4
    //   158: astore_3
    //   159: goto -49 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   84	2	1	i	int
    //   3	101	2	bool	boolean
    //   1	78	3	localObject1	Object
    //   107	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   109	31	3	localCloseable	java.io.Closeable
    //   155	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   158	1	3	localObject2	Object
    //   30	127	4	localInputStream	java.io.InputStream
    //   42	38	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   26	32	107	java/io/FileNotFoundException
    //   26	32	138	finally
    //   35	44	138	finally
    //   47	53	138	finally
    //   56	65	138	finally
    //   68	76	138	finally
    //   79	85	138	finally
    //   110	126	151	finally
    //   35	44	155	java/io/FileNotFoundException
    //   47	53	155	java/io/FileNotFoundException
    //   56	65	155	java/io/FileNotFoundException
    //   68	76	155	java/io/FileNotFoundException
    //   79	85	155	java/io/FileNotFoundException
  }
  
  private boolean auX(String paramString)
  {
    AppMethodBeat.i(35096);
    j.b localb = j.b.mY(bo.apU(this.cDI));
    ab.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.cDI, localb });
    if (localb == null)
    {
      ab.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      AppMethodBeat.o(35096);
      return false;
    }
    aw.aaz();
    bi localbi = com.tencent.mm.model.c.YC().kB(this.cpO);
    if (localbi.dvV())
    {
      if (localb.type == 33) {
        com.tencent.mm.ui.chatting.l.b(paramString, localb, ce.f(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
      }
      for (;;)
      {
        AppMethodBeat.o(35096);
        return true;
        com.tencent.mm.ui.chatting.j.a(this, paramString, this.cDI, localbi.field_isSend, this.zur);
      }
    }
    String str = null;
    Object localObject = null;
    byte[] arrayOfByte1 = null;
    boolean bool;
    if (this.AyY == null)
    {
      localObject = str;
      if (this.zUQ < 0)
      {
        localObject = str;
        if (localbi.field_imgPath != null)
        {
          localObject = str;
          if (!localbi.field_imgPath.equals(""))
          {
            str = o.ahC().J(localbi.field_imgPath, true);
            localObject = arrayOfByte1;
            try
            {
              arrayOfByte1 = com.tencent.mm.vfs.e.i(str, 0, -1);
              localObject = arrayOfByte1;
              bool = ci(arrayOfByte1);
              localObject = arrayOfByte1;
              if (!bool)
              {
                AppMethodBeat.o(35096);
                return false;
              }
            }
            catch (Exception localException1)
            {
              ab.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException1.getLocalizedMessage() });
            }
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.g.d.ysn.a(new MsgRetransmitUI.15(this, paramString, localb, (byte[])localObject, localbi), "MicroMsg.MsgRetransmitUI");
      break;
      try
      {
        byte[] arrayOfByte2 = com.tencent.mm.vfs.e.i(this.AyY, 0, -1);
        localObject = arrayOfByte2;
        bool = ci(arrayOfByte2);
        localObject = arrayOfByte2;
        if (!bool)
        {
          AppMethodBeat.o(35096);
          return false;
        }
      }
      catch (Exception localException2)
      {
        ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", localException2, "", new Object[0]);
        ab.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException2.getLocalizedMessage() });
      }
    }
  }
  
  private void auY(String paramString)
  {
    AppMethodBeat.i(35102);
    ab.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new com.tencent.mm.pluginsdk.model.j(this, null, getIntent(), paramString, 1, new MsgRetransmitUI.6(this));
    com.tencent.mm.sdk.g.d.post(paramString, "ChattingUI_importMultiVideo");
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new MsgRetransmitUI.7(this, paramString));
    AppMethodBeat.o(35102);
  }
  
  private void b(com.tencent.mm.at.e parame, bi parambi, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35105);
    Object localObject = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject).value = this.fileName;
    int i = parame.fDP;
    long l1 = o.ahC().a(this.fileName, i, paramInt, (PString)localObject, localPInt1, localPInt2);
    com.tencent.mm.at.e locale = o.ahC().b(Long.valueOf(l1));
    locale.lt(1);
    bi localbi = new bi();
    localbi.setType(com.tencent.mm.model.t.oG(paramString2));
    localbi.kj(paramString2);
    localbi.hL(1);
    localbi.setStatus(1);
    localbi.kk(((PString)localObject).value);
    localbi.hW(localPInt1.value);
    localbi.hX(localPInt2.value);
    localbi.fQ(bf.py(localbi.field_talker));
    if (com.tencent.mm.aj.f.lg(localbi.field_talker)) {
      parambi.jl(com.tencent.mm.aj.a.e.aaQ());
    }
    aw.aaz();
    long l2 = com.tencent.mm.model.c.YC().Z(localbi);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      locale.gQ((int)l2);
      o.ahC().a(Long.valueOf(l1), locale);
      localObject = new HashMap();
      ((HashMap)localObject).put(Long.valueOf(l2), parame);
      o.ahD().a(parame.fDL, parambi.field_msgId, i, localObject, 2130838228, new MsgRetransmitUI.10(this, paramString2, paramInt, paramString3, paramString1));
      AppMethodBeat.o(35105);
      return;
    }
  }
  
  private static boolean ci(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(35108);
    ab.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", new Object[] { Byte.valueOf(paramArrayOfByte[0]), Byte.valueOf(paramArrayOfByte[1]), Byte.valueOf(paramArrayOfByte[2]), Byte.valueOf(paramArrayOfByte[3]), Byte.valueOf(paramArrayOfByte[4]) });
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    if ((localOptions.outWidth >= 0) && (localOptions.outHeight >= 0))
    {
      AppMethodBeat.o(35108);
      return true;
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  private boolean cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35099);
    if (this.fileName == null)
    {
      AppMethodBeat.o(35099);
      return false;
    }
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(this.fileName);
    long l;
    Object localObject1;
    label71:
    Object localObject2;
    if (localEmojiInfo == null)
    {
      l = com.tencent.mm.vfs.e.avI(this.fileName);
      if (localEmojiInfo != null) {
        break label281;
      }
      localObject1 = this.fileName;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      if (((com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.m.b.MV())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.m.b.MV())) {
        break label627;
      }
    }
    label281:
    label620:
    label627:
    for (int i = 1;; i = 0)
    {
      if ((l > com.tencent.mm.m.b.MW()) || (i != 0))
      {
        if (localEmojiInfo == null) {}
        for (paramString = "fileName";; paramString = localEmojiInfo.Al())
        {
          ab.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.Azv = false;
          this.Aza = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131299130), "", getString(2131300718), new MsgRetransmitUI.21(this));
          if (this.Azl == 1) {
            com.tencent.mm.plugin.report.service.h.qsU.e(13459, new Object[] { Long.valueOf(l), Integer.valueOf(1), localEmojiInfo.Al(), Integer.valueOf(1) });
          }
          AppMethodBeat.o(35099);
          return true;
          l = com.tencent.mm.vfs.e.avI(localEmojiInfo.dQB());
          break;
          localObject1 = localEmojiInfo.dQB();
          break label71;
        }
      }
      if (this.Azl == 1)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
        if (localEmojiInfo == null)
        {
          localObject1 = "";
          ((com.tencent.mm.plugin.report.service.h)localObject2).e(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), localObject1, Integer.valueOf(1) });
        }
      }
      else
      {
        if (!paramBoolean) {
          break label520;
        }
        if (localEmojiInfo != null) {
          break label620;
        }
        localObject1 = new WXMediaMessage(new WXEmojiObject(this.fileName));
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject1, "");
      }
      for (localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt((String)localObject1);; localObject1 = localEmojiInfo)
      {
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(13459, new Object[] { Long.valueOf(l), Integer.valueOf(0), ((EmojiInfo)localObject1).Al(), Integer.valueOf(2) });
          com.tencent.mm.ui.chatting.j.b((EmojiInfo)localObject1, paramString);
        }
        finish();
        AppMethodBeat.o(35099);
        return true;
        localObject1 = localEmojiInfo.Al();
        break;
        if ((localEmojiInfo != null) && (l > ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().e(localEmojiInfo, false)))
        {
          com.tencent.mm.ui.chatting.j.b(localEmojiInfo, paramString);
          AppMethodBeat.o(35099);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(this, paramString, this.fileName))
        {
          AppMethodBeat.o(35099);
          return true;
        }
        ab.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
        AppMethodBeat.o(35099);
        return false;
      }
    }
  }
  
  private void dOi()
  {
    AppMethodBeat.i(35094);
    Object localObject6;
    switch (this.Azd)
    {
    default: 
      ab.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.Azd) });
      finish();
      AppMethodBeat.o(35094);
      return;
    case 0: 
      int i;
      switch (this.msgType)
      {
      case 3: 
      default: 
        ab.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
      case 2: 
      case 6: 
      case 10: 
      case 12: 
      case 13: 
      case 14: 
      case 16: 
        i = 1;
      }
      boolean bool1;
      Object localObject2;
      for (;;)
      {
        if (i != 0)
        {
          bool1 = true;
          int j;
          if ((this.msgType == 11) || (this.msgType == 1))
          {
            localObject1 = this.AyX;
            ab.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
            if ((11 == this.msgType) && (u.vt(this.fileName)))
            {
              com.tencent.mm.ui.widget.snackbar.b.a(this, getResources().getString(2131303126), "", null);
              this.mHandler.postDelayed(new MsgRetransmitUI.18(this), 1800L);
              AppMethodBeat.o(35094);
              return;
              if (dOj()) {
                break;
              }
              finish();
              i = 0;
              continue;
              if ((this.cDI != null) && (!this.cDI.equals(""))) {
                break;
              }
              ab.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
              finish();
              i = 0;
              continue;
              finish();
              i = 0;
              continue;
              if (!dOj())
              {
                finish();
                i = 0;
                continue;
              }
              if (this.fileName != null) {
                break;
              }
              ab.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
              finish();
              i = 0;
              continue;
              if ((this.cDI != null) && (!this.cDI.equals(""))) {
                break;
              }
              ab.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
              finish();
              i = 0;
              continue;
            }
            localObject3 = new MsgRetransmitUI.b((byte)0);
            ((MsgRetransmitUI.b)localObject3).AzO = new LinkedList();
            ((MsgRetransmitUI.b)localObject3).AzO.addAll((Collection)localObject1);
            localObject4 = u.vr(this.fileName);
            localObject5 = ((List)localObject1).iterator();
            if (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              if (localObject4 != null)
              {
                localObject1 = ((com.tencent.mm.modelvideo.s)localObject4).getFileName();
                if (localObject4 == null) {
                  break label579;
                }
              }
              for (localObject2 = Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject4).status);; localObject2 = "")
              {
                ab.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", new Object[] { localObject1, localObject2 });
                if ((localObject4 == null) || (((com.tencent.mm.modelvideo.s)localObject4).status != 199)) {
                  break label587;
                }
                a((MsgRetransmitUI.b)localObject3, (String)localObject6);
                break;
                localObject1 = "";
                break label507;
              }
              if (localObject4 == null)
              {
                ab.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
                i = 0;
              }
              while (i == 0)
              {
                dOk();
                break;
                Object localObject7 = br.F(((com.tencent.mm.modelvideo.s)localObject4).alP(), "msg");
                if (localObject7 == null)
                {
                  ab.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
                  i = 0;
                }
                else
                {
                  localObject1 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
                  if (bo.isNullOrNil((String)localObject1))
                  {
                    i = 0;
                  }
                  else
                  {
                    localObject2 = (String)((Map)localObject7).get(".msg.videomsg.$aeskey");
                    String str1 = (String)((Map)localObject7).get(".msg.videomsg.$md5");
                    String str2 = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
                    i = Integer.valueOf((String)((Map)localObject7).get(".msg.videomsg.$length")).intValue();
                    j = bo.getInt((String)((Map)localObject7).get(".msg.videomsg.$playlength"), 0);
                    int k = bo.getInt((String)((Map)localObject7).get(".msg.videomsg.$cdnthumblength"), 0);
                    localObject7 = new com.tencent.mm.i.g();
                    ((com.tencent.mm.i.g)localObject7).edp = new MsgRetransmitUI.14(this, (String)localObject1, (String)localObject2, k, i, (String)localObject6, str1, str2, j);
                    ((com.tencent.mm.i.g)localObject7).field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.aoy(), (String)localObject6, this.cpO);
                    ((com.tencent.mm.i.g)localObject7).field_fileId = ((String)localObject1);
                    ((com.tencent.mm.i.g)localObject7).field_aesKey = ((String)localObject2);
                    ((com.tencent.mm.i.g)localObject7).field_filemd5 = str1;
                    ((com.tencent.mm.i.g)localObject7).field_fileType = 4;
                    ((com.tencent.mm.i.g)localObject7).field_talker = ((String)localObject6);
                    ((com.tencent.mm.i.g)localObject7).field_priority = com.tencent.mm.i.a.ecF;
                    ((com.tencent.mm.i.g)localObject7).field_svr_signature = "";
                    ((com.tencent.mm.i.g)localObject7).field_onlycheckexist = true;
                    ((com.tencent.mm.i.g)localObject7).field_trysafecdn = true;
                    ab.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", new Object[] { localObject1, str1, localObject2, ((com.tencent.mm.modelvideo.s)localObject4).alP() });
                    if (!com.tencent.mm.al.f.afO().e((com.tencent.mm.i.g)localObject7))
                    {
                      ab.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
                      finish();
                      i = 0;
                    }
                    else
                    {
                      this.Aza = false;
                      finish();
                      i = 1;
                    }
                  }
                }
              }
            }
            AppMethodBeat.o(35094);
            return;
          }
          if (this.msgType == 0) {
            this.Azp = this.AyX.size();
          }
          i = this.AyX.size();
          localObject1 = this.AyX.iterator();
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
              if (this.Azk) {
                k.qS(bool2);
              }
              i = j;
              break;
              bool2 = false;
              break label1060;
              aw.RO().Bk();
              com.tencent.mm.sdk.g.d.ysn.a(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(35061);
                  ab.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                  MsgRetransmitUI.a(MsgRetransmitUI.this, this.efI);
                  AppMethodBeat.o(35061);
                }
              }, "MicroMsg.MsgRetransmitUI");
              continue;
              bool1 = auX((String)localObject2);
              continue;
              r.Zn();
              localObject2 = new com.tencent.mm.modelmulti.h((String)localObject2, this.cDI, com.tencent.mm.model.t.oF((String)localObject2));
              aw.Rc().a((m)localObject2, 0);
              bool1 = true;
              continue;
              bool1 = cq((String)localObject2, false);
              continue;
              localObject3 = j.b.mY(bo.apU(this.cDI));
              if (localObject3 == null)
              {
                ab.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
                bool1 = false;
              }
              else
              {
                a((String)localObject2, (j.b)localObject3, null, null);
                bool1 = true;
                continue;
                localObject2 = new com.tencent.mm.modelvoice.f(com.tencent.mm.modelvoice.s.i((String)localObject2, this.fileName, this.length), 1);
                aw.Rc().a((m)localObject2, 0);
                bool1 = true;
                continue;
                localObject3 = bi.a.asj(this.cDI);
                localObject4 = this.cDI;
                if (ad.arf(((bi.a)localObject3).tac)) {}
                for (i = 66;; i = 42)
                {
                  localObject2 = new com.tencent.mm.modelmulti.h((String)localObject2, (String)localObject4, i);
                  aw.Rc().a((m)localObject2, 0);
                  break;
                }
                localObject2 = new com.tencent.mm.modelmulti.h((String)localObject2, this.cDI, 48);
                aw.Rc().a((m)localObject2, 0);
                bool1 = true;
                continue;
                localObject3 = new oa();
                ((oa)localObject3).cEz.type = 4;
                localObject4 = ((oa)localObject3).cEz;
                aw.aaz();
                ((oa.a)localObject4).cEE = com.tencent.mm.model.c.YC().kB(this.cpO);
                ((oa)localObject3).cEz.toUser = ((String)localObject2);
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
                continue;
                k.l(this, (String)localObject2, bool2);
                continue;
                k.k(this, (String)localObject2, bool2);
                continue;
                localObject3 = new qx();
                ((qx)localObject3).cHr.cpg = this.cpO;
                ((qx)localObject3).cHr.cxK = this.cDI;
                ((qx)localObject3).cHr.cxL = ((String)localObject2);
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
              }
            }
          }
          localObject3 = (String)this.AyX.get(0);
          switch (this.msgType)
          {
          case 3: 
          case 15: 
          default: 
            finish();
          }
        }
      }
      AppMethodBeat.o(35094);
      return;
      AppMethodBeat.o(35094);
      return;
      if ((this.msgType == 2) || (this.msgType == 16))
      {
        localObject4 = j.b.mY(bo.apU(this.cDI));
        if ((localObject4 != null) && (((j.b)localObject4).type == 5) && (!bo.isNullOrNil(((j.b)localObject4).url))) {
          localObject1 = "";
        }
      }
      else
      {
        try
        {
          localObject2 = URLEncoder.encode(((j.b)localObject4).url, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            i = 2;
          }
        }
        if (bool1)
        {
          i = 1;
          ab.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((j.b)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.Azq), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.Azq), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      while ((bool1) || (localObject4 == null) || (((j.b)localObject4).type != 33))
      {
        if (!bool1) {
          break;
        }
        if (this.Aza) {
          com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
        }
        localObject1 = new Intent();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(this.AyX);
        ((Intent)localObject1).putStringArrayListExtra("SendMsgUsernames", (ArrayList)localObject2);
        setResult(-1, (Intent)localObject1);
        if (this.Azv) {
          this.mHandler.postDelayed(new MsgRetransmitUI.5(this), 1800L);
        }
        if ((this.AyZ) && (!this.Azn))
        {
          localObject1 = new Intent(this, ChattingUI.class);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("Chat_User", (String)localObject3);
          startActivity((Intent)localObject1);
        }
        AppMethodBeat.o(35094);
        return;
      }
      localObject1 = new com.tencent.mm.g.a.n();
      ((com.tencent.mm.g.a.n)localObject1).cmD.scene = this.Azt;
      ((com.tencent.mm.g.a.n)localObject1).cmD.bCV = this.Azu;
      if (2 == this.Azt)
      {
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmF = (this.Azs + ":" + this.Azr);
        if (!((String)localObject3).endsWith("@chatroom")) {
          break label2319;
        }
      }
      for (((com.tencent.mm.g.a.n)localObject1).cmD.action = 2;; ((com.tencent.mm.g.a.n)localObject1).cmD.action = 1)
      {
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmE = (((j.b)localObject4).fjh + 1);
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmG = ((j.b)localObject4).fiW;
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmx = ((j.b)localObject4).fiX;
        ((com.tencent.mm.g.a.n)localObject1).cmD.appId = ((j.b)localObject4).fiY;
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmH = "";
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmI = bo.aox();
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmJ = 2;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        break;
        ((com.tencent.mm.g.a.n)localObject1).cmD.cmF = this.Azs;
        break label2187;
      }
      finish();
      AppMethodBeat.o(35094);
      return;
    case 1: 
      label507:
      localObject1 = (String)this.AyX.get(0);
      label579:
      label587:
      if (!dOj())
      {
        finish();
        AppMethodBeat.o(35094);
        return;
      }
      label1060:
      switch (this.msgType)
      {
      default: 
        ab.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        AppMethodBeat.o(35094);
        return;
      case 0: 
        if ((this.Azg != null) && (this.Azg.size() > 0)) {
          this.Azi = this.Azg.size();
        }
        this.fFj = new MsgRetransmitUI.2(this);
        this.Azb = com.tencent.mm.ui.base.h.a(this, getString(2131301646, new Object[] { Integer.valueOf(1), Integer.valueOf(this.Azi), Integer.valueOf(0) }), getString(2131297087), new MsgRetransmitUI.3(this));
        this.Azb.setOnCancelListener(new MsgRetransmitUI.4(this));
        this.Azb.setCanceledOnTouchOutside(false);
        this.Azb.getButton(-1).setText(2131296888);
        a((String)localObject1, 6, this.fFj);
        AppMethodBeat.o(35094);
        return;
      case 1: 
      case 11: 
        if (!ac.cm(this))
        {
          com.tencent.mm.ui.base.h.a(this, 2131304515, 2131297087, 2131297018, 2131296888, new MsgRetransmitUI.16(this, (String)localObject1), new MsgRetransmitUI.17(this));
          AppMethodBeat.o(35094);
          return;
        }
        s(getIntent(), (String)localObject1);
        AppMethodBeat.o(35094);
        return;
      }
      label2187:
      label2319:
      cq((String)localObject1, true);
      AppMethodBeat.o(35094);
      return;
    }
    switch (this.msgType)
    {
    default: 
      AppMethodBeat.o(35094);
      return;
    }
    this.AyX.get(0);
    Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.f();
    ((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_packageName = ((String)localObject1);
    com.tencent.mm.pluginsdk.model.app.al.cac().get((com.tencent.mm.sdk.e.c)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new c(new MsgRetransmitUI.12(this));
    if (((WXMediaMessage)localObject5).thumbData == null) {}
    for (localObject1 = null;; localObject1 = com.tencent.mm.sdk.platformtools.d.bT(((WXMediaMessage)localObject5).thumbData)) {
      switch (((WXMediaMessage)localObject5).mediaObject.type())
      {
      default: 
        ab.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + ((WXMediaMessage)localObject5).mediaObject.type());
        AppMethodBeat.o(35094);
        return;
      }
    }
    localObject1 = View.inflate(this, 2130968784, null);
    ((TextView)((View)localObject1).findViewById(2131821212)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(2131821550)).setText(com.tencent.mm.pluginsdk.model.app.g.b(this, (com.tencent.mm.pluginsdk.model.app.f)localObject3, null));
      ((c)localObject4).gwf = com.tencent.mm.ui.base.h.a(this, null, (View)localObject1, getString(2131297067), getString(2131296888), new c.1((c)localObject4), new c.2((c)localObject4));
      break;
      View localView = View.inflate(this, 2130968783, null);
      ((ImageView)localView.findViewById(2131821549)).setImageBitmap((Bitmap)localObject1);
      ((TextView)localView.findViewById(2131821212)).setText(((WXMediaMessage)localObject5).title);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2130968782, null);
      ((ImageView)localView.findViewById(2131821549)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131821212);
      localObject6 = (TextView)localView.findViewById(2131821007);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2130968782, null);
      ((ImageView)localView.findViewById(2131821549)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131821212);
      localObject6 = (TextView)localView.findViewById(2131821007);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2130968782, null);
      ((ImageView)localView.findViewById(2131821549)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131821212);
      localObject6 = (TextView)localView.findViewById(2131821007);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2130968782, null);
      ((ImageView)localView.findViewById(2131821549)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131821212);
      localObject6 = (TextView)localView.findViewById(2131821007);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, 2130968782, null);
      ((ImageView)localView.findViewById(2131821549)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(2131821212);
      localObject6 = (TextView)localView.findViewById(2131821007);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
    }
  }
  
  private boolean dOj()
  {
    AppMethodBeat.i(35100);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ab.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      com.tencent.mm.ui.base.t.ii(this);
      AppMethodBeat.o(35100);
      return false;
    }
    AppMethodBeat.o(35100);
    return true;
  }
  
  private void dOk()
  {
    AppMethodBeat.i(35109);
    com.tencent.mm.sdk.g.d.ysn.a(new MsgRetransmitUI.11(this), "MicroMsg.MsgRetransmitUI");
    this.Aza = false;
    AppMethodBeat.o(35109);
  }
  
  private void s(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(35101);
    if (this.Azj)
    {
      this.Azi = this.Azg.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.Azw) {
            break;
          }
          auY(paramString);
        }
        AppMethodBeat.o(35101);
        return;
      }
      finish();
      AppMethodBeat.o(35101);
      return;
    }
    this.Azi = 1;
    auY(paramString);
    AppMethodBeat.o(35101);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35092);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(35092);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35095);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      Object localObject = j.b.mY(bo.apU(this.cDI));
      if ((localObject != null) && (((j.b)localObject).type == 5) && (((j.b)localObject).url != null))
      {
        ab.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((j.b)localObject).url, Long.valueOf(this.startTime), Integer.valueOf(this.Azq), Integer.valueOf(1), Integer.valueOf(3) });
        paramIntent = "";
        try
        {
          localObject = URLEncoder.encode(((j.b)localObject).url, "UTF-8");
          paramIntent = (Intent)localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.Azq), Integer.valueOf(1), Integer.valueOf(3) });
      }
      while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
      {
        finish();
        AppMethodBeat.o(35095);
        return;
      }
      paramIntent = new com.tencent.mm.g.a.n();
      paramIntent.cmD.bCV = this.Azu;
      paramIntent.cmD.scene = this.Azt;
      if (2 == this.Azt) {}
      for (paramIntent.cmD.cmF = (this.Azs + ":" + this.Azr);; paramIntent.cmD.cmF = this.Azs)
      {
        paramIntent.cmD.cmE = (localUnsupportedEncodingException.fjh + 1);
        paramIntent.cmD.cmG = localUnsupportedEncodingException.fiW;
        paramIntent.cmD.cmx = localUnsupportedEncodingException.fiX;
        paramIntent.cmD.appId = localUnsupportedEncodingException.fiY;
        paramIntent.cmD.action = 1;
        paramIntent.cmD.cmH = "";
        paramIntent.cmD.cmI = bo.aox();
        paramIntent.cmD.cmJ = 3;
        com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
        break;
      }
    }
    if (paramInt1 != 0)
    {
      ab.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(35095);
      return;
    }
    this.AyX = bo.P(paramIntent.getStringExtra("Select_Conv_User").split(","));
    String str1 = paramIntent.getStringExtra("custom_send_text");
    this.muT = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.muT) {
      this.jUy = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      ab.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    ab.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.Azd), Integer.valueOf(this.AyX.size()) });
    dOi();
    if (!TextUtils.isEmpty(str1))
    {
      paramIntent = this.AyX.iterator();
      while (paramIntent.hasNext())
      {
        String str2 = (String)paramIntent.next();
        qj localqj = new qj();
        localqj.cGX.cGY = str2;
        localqj.cGX.content = str1;
        localqj.cGX.type = com.tencent.mm.model.t.oF(str2);
        localqj.cGX.flags = 0;
        com.tencent.mm.sdk.b.a.ymk.l(localqj);
      }
    }
    AppMethodBeat.o(35095);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35091);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    af.a(getWindow());
    ab.i("MicroMsg.MsgRetransmitUI", "on activity create");
    this.startTime = bo.aox();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    this.cDI = getIntent().getStringExtra("Retr_Msg_content");
    this.cpO = getIntent().getLongExtra("Retr_Msg_Id", -1L);
    this.fileName = getIntent().getStringExtra("Retr_File_Name");
    this.Azg = getIntent().getStringArrayListExtra("Retr_File_Path_List");
    boolean bool;
    if ((this.Azg != null) && (this.Azg.size() > 0))
    {
      bool = true;
      this.Azj = bool;
      this.fDP = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.Azd = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.Azc = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.AyY = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.AyZ = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.Azn = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.Azd != 0) {
        break label751;
      }
      bool = true;
      label257:
      this.Azo = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.Azo) {
        this.Azn = true;
      }
      this.Aza = getIntent().getBooleanExtra("Retr_show_success_tips", this.Azn);
      this.Azk = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.zur = getIntent().getBooleanExtra("is_group_chat", false);
      this.zUQ = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.Azl = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.fFN = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.cyV = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.fFO = getIntent().getStringExtra("Retr_AttachedContent");
      this.Azm = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.mSessionId = getIntent().getStringExtra("reportSessionId");
      this.Azq = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.Azr = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.Azs = getIntent().getStringExtra("Retr_MsgTalker");
      this.Azt = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      this.Azu = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
      aw.Rc().a(110, this);
      if (!com.tencent.mm.compatible.util.d.fv(19)) {
        setContentView(2130968895);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.Azo) {
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
      paramBundle.putExtra("Retr_Msg_Id", this.cpO);
      paramBundle.putExtra("Retr_Msg_content", this.cDI);
      paramBundle.putExtra("image_path", this.fileName);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(35091);
      return;
      bool = false;
      break;
      label751:
      bool = false;
      break label257;
      paramBundle.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
      if (this.Azq == 3) {
        paramBundle.putExtra("scene_from", 3);
      }
      paramBundle.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.zUQ);
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35093);
    if (!this.Azf) {
      aw.Rc().b(110, this);
    }
    super.onDestroy();
    AppMethodBeat.o(35093);
  }
  
  @com.tencent.mm.sdk.platformtools.h
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(35111);
    if ((paramm.getType() != 110) || (!(paramm instanceof com.tencent.mm.at.l)))
    {
      AppMethodBeat.o(35111);
      return;
    }
    paramString = (com.tencent.mm.at.l)paramm;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramm = getIntent().getStringExtra("Retr_KSnsId");
      if (!com.tencent.mm.model.t.lA(paramString.cGY)) {
        break label190;
      }
      localObject = new rp();
      ((rp)localObject).cHV.czw = paramm;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    while ((this.Azg != null) && (this.Azg.size() > 1))
    {
      this.Azg.remove(0);
      paramm = paramString.cGY;
      paramString = paramm;
      if (bo.isNullOrNil(paramm))
      {
        paramString = paramm;
        if (this.AyX != null) {
          paramString = (String)this.AyX.get(0);
        }
      }
      a(paramString, 3, this.fFj);
      AppMethodBeat.o(35111);
      return;
      label190:
      localObject = new rq();
      ((rq)localObject).cHW.czw = paramm;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if (this.Azb != null)
    {
      this.Azb.dismiss();
      this.Azb = null;
    }
    this.Azp -= 1;
    if ((this.Azp <= 0) || (!this.Azo))
    {
      this.Azf = false;
      aw.Rc().b(110, this);
      if (this.Azd != 0)
      {
        finish();
        if ((this.AyZ) && (!this.Azn))
        {
          paramm = new Intent(this, ChattingUI.class);
          paramm.addFlags(67108864);
          paramm.putExtra("Chat_User", paramString.cGY);
          startActivity(paramm);
        }
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI
 * JD-Core Version:    0.7.0.1
 */