package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class f
  implements a.a
{
  private static f vZM;
  public int dzw;
  private c vZN;
  long vZO;
  boolean vZP = false;
  boolean vZQ = false;
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(26532);
    ad.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 0L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bIY().bJb();
    this.vZN.vZv = this;
    LinkedList localLinkedList = this.vZN.doC();
    ad.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ad.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
      cancel();
      l = bt.Df(this.vZO);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 5L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 7L, l, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 11L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 12L, 0L, false);
      b.m(l, paramInt, 1);
      AppMethodBeat.o(26532);
      return;
    }
    if (b.vZq < 0) {}
    for (long l = b.vZq;; l = bt.Df(b.vZq * 24 * 60 * 60 * 1000))
    {
      this.vZN.a(paramd, localLinkedList, l, System.currentTimeMillis(), b.vZo);
      AppMethodBeat.o(26532);
      return;
    }
  }
  
  private void a(d paramd, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(26533);
    ad.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 15L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bIY().bJb();
    this.vZN.vZv = this;
    LinkedList localLinkedList = this.vZN.doC();
    ad.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ad.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bt.Df(this.vZO);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 16L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 20L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 22L, paramLong1, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 26L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 27L, 0L, false);
      b.m(paramLong1, paramInt, 2);
      AppMethodBeat.o(26533);
      return;
    }
    long l;
    if (b.vZq < 0)
    {
      l = b.vZq;
      if (paramLong1 >= l) {
        break label325;
      }
    }
    for (;;)
    {
      if (paramLong2 == 0L) {}
      for (paramLong1 = System.currentTimeMillis();; paramLong1 = paramLong2)
      {
        if (l > paramLong1)
        {
          ad.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1) });
          a(paramd, true);
          AppMethodBeat.o(26533);
          return;
          l = bt.Df(b.vZq * 24 * 60 * 60 * 1000);
          break;
        }
        this.vZN.a(paramd, localLinkedList, l, paramLong1, b.vZo);
        AppMethodBeat.o(26533);
        return;
      }
      label325:
      l = paramLong1;
    }
  }
  
  private void a(d paramd, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26534);
    ad.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 31L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bIY().bJb();
    this.vZN.vZv = this;
    paramString = c.aqV(paramString);
    ad.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString.size()) });
    if (paramString.size() == 0)
    {
      ad.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bt.Df(this.vZO);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 32L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 36L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 38L, paramLong1, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 42L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 43L, 0L, false);
      b.m(paramLong1, paramInt2, 3);
      AppMethodBeat.o(26534);
      return;
    }
    this.vZN.a(paramd, paramString, paramLong1, paramLong2, paramInt1);
    AppMethodBeat.o(26534);
  }
  
  static void aqX(String paramString)
  {
    AppMethodBeat.i(26536);
    if (paramString.equals(b.vZh))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 2L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.vZi))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 17L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.vZj)) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 33L, 1L, false);
    }
    AppMethodBeat.o(26536);
  }
  
  public static f oE(boolean paramBoolean)
  {
    AppMethodBeat.i(26530);
    if (vZM == null) {
      vZM = new f();
    }
    for (;;)
    {
      f localf = vZM;
      AppMethodBeat.o(26530);
      return localf;
      if (paramBoolean)
      {
        vZM.cancel();
        vZM = new f();
      }
    }
  }
  
  public final void a(final d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(26535);
    ad.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramd.vZB), Long.valueOf(paramd.vZC), Long.valueOf(paramd.vZD) });
    if ((paramd.vZB <= 0L) && (paramd.vZC <= 0L) && (paramd.vZD <= 0L))
    {
      ad.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
      a(paramd, true);
      AppMethodBeat.o(26535);
      return;
    }
    g.a local2 = new g.a()
    {
      public final void aBH()
      {
        AppMethodBeat.i(26527);
        ad.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[] { Boolean.valueOf(f.this.vZP), Boolean.valueOf(com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx)) });
        if ((f.this.vZP) && (com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx)))
        {
          ad.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
          ba.aBQ();
          com.tencent.mm.model.c.b(this);
          f.this.vZP = false;
          f.this.a(paramd, false);
        }
        AppMethodBeat.o(26527);
      }
    }
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26528);
        ad.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          f.this.cancel();
          f.aqX(paramd.action);
          b.a(0L, 0L, 0L, 0L, 1, f.this.dzw, paramd.action);
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label250;
          }
          ad.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, paramAnonymousString, paramAnonymousd.field_filemd5 });
          f.aqX(paramd.action);
          f.this.cancel();
          b.a(0L, 0L, 0L, 0L, 1, f.this.dzw, paramd.action);
        }
        for (;;)
        {
          AppMethodBeat.o(26528);
          return 0;
          label250:
          ad.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[] { paramAnonymousString, paramAnonymousd.field_filemd5, Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = new PByteArray();
          if (!MMProtocalJni.rsaPublicEncryptPemkey(paramAnonymousd.field_aesKey.getBytes(), paramAnonymousString, paramd.vZA))
          {
            ad.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
            AppMethodBeat.o(26528);
            return -1;
          }
          paramAnonymousString = bt.cE(paramAnonymousString.value);
          paramAnonymousc = paramd;
          String str = paramAnonymousd.field_fileId;
          paramAnonymousInt = (int)paramAnonymousd.field_fileLength;
          paramAnonymousc.vZG = new String(str);
          paramAnonymousc.vZH = new String(paramAnonymousString);
          paramAnonymousc.vZI = paramAnonymousInt;
          if (com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx))
          {
            ad.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
            f.this.a(paramd, false);
          }
          else
          {
            ad.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
            ba.aBQ();
            com.tencent.mm.model.c.a(this.vZS);
            f.this.vZP = true;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    String str = "MSG_SYNCHRONIZE_" + paramInt + "_" + bt.flT();
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_MsgSynchronizeServer";
    localg.fJj = local2;
    localg.field_mediaId = str;
    localg.field_fullpath = paramString;
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = ((String)com.tencent.mm.plugin.backup.h.d.bIY().bIZ().ajl().get(2, null));
    localg.field_priority = com.tencent.mm.i.a.fIw;
    if (!com.tencent.mm.ao.f.aGI().f(localg))
    {
      ad.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[] { str });
      aqX(paramd.action);
      b.a(0L, 0L, 0L, 0L, 1, this.dzw, paramd.action);
    }
    AppMethodBeat.o(26535);
  }
  
  final void a(final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(26537);
    ad.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(26529);
        ba.aiU().b(222, this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          f.this.cancel();
          if (paramd.action.equals(b.vZh)) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 3L, 1L, false);
          }
          for (;;)
          {
            b.a(0L, 0L, 0L, 0L, 2, f.this.dzw, paramd.action);
            AppMethodBeat.o(26529);
            return;
            if (paramd.action.equals(b.vZi)) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 18L, 1L, false);
            } else if (paramd.action.equals(b.vZj)) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 34L, 1L, false);
            }
          }
        }
        ad.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
        com.tencent.mm.plugin.backup.b.g.VO(g.doE());
        com.tencent.mm.plugin.backup.b.g.VO(g.doF());
        f.this.vZQ = false;
        long l = bt.Df(f.this.vZO);
        if (paramd.action.equals(b.vZh))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 1L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 5L, paramd.vZD, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 7L, l, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 11L, paramd.vZC, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 12L, paramd.vZB, false);
        }
        for (;;)
        {
          b.a(paramd.vZD, l, paramd.vZC, paramd.vZB, 0, f.this.dzw, paramd.action);
          AppMethodBeat.o(26529);
          return;
          if (paramd.action.equals(b.vZi))
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 16L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 20L, paramd.vZD, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 22L, l, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 26L, paramd.vZC, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 27L, paramd.vZB, false);
          }
          else if (paramd.action.equals(b.vZj))
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 36L, paramd.vZD, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 38L, l, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 42L, paramd.vZC, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(466L, 43L, paramd.vZB, false);
          }
        }
      }
    };
    ba.aiU().a(222, (com.tencent.mm.al.f)localObject);
    localObject = "";
    if (paramd.action.equals(b.vZj)) {
      localObject = paramd.vZE + "," + paramd.vZF;
    }
    if (paramBoolean) {}
    for (paramd = new e("", "NULL", 0, paramd.fFK, paramd.action, (String)localObject);; paramd = new e(paramd.vZG, paramd.vZH, paramd.vZI, paramd.fFK, paramd.action, (String)localObject))
    {
      ba.aiU().a(paramd, 0);
      AppMethodBeat.o(26537);
      return;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(26538);
    ad.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[] { at.fkV() });
    this.vZN.vZu = true;
    this.vZQ = false;
    AppMethodBeat.o(26538);
  }
  
  public final void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26531);
    ad.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(this.dzw) });
    if (this.vZQ)
    {
      ad.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", new Object[] { paramString1 });
      AppMethodBeat.o(26531);
      return;
    }
    this.vZQ = true;
    this.vZO = bt.flT();
    if (this.vZN != null) {
      this.vZN.vZu = true;
    }
    this.vZN = new c();
    d locald = new d(paramString1);
    locald.vZA = paramArrayOfByte;
    if (paramString1.equals(b.vZh))
    {
      a(locald, this.dzw);
      AppMethodBeat.o(26531);
      return;
    }
    ba.aBQ();
    if (!((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixa, Boolean.FALSE)).booleanValue())
    {
      ad.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
      cancel();
      AppMethodBeat.o(26531);
      return;
    }
    paramString2 = paramString2.split(",");
    if (paramString1.equals(b.vZi))
    {
      if (b.vZr <= 0)
      {
        ad.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 2)
      {
        ad.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      a(locald, com.tencent.mm.plugin.backup.b.g.VU(paramString2[0]) * 1000L, com.tencent.mm.plugin.backup.b.g.VU(paramString2[1]) * 1000L, this.dzw);
      AppMethodBeat.o(26531);
      return;
    }
    if (paramString1.equals(b.vZj))
    {
      if (b.vZs <= 0)
      {
        ad.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 5)
      {
        ad.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      paramString1 = paramString2[0];
      long l1 = com.tencent.mm.plugin.backup.b.g.VU(paramString2[1]);
      long l2 = com.tencent.mm.plugin.backup.b.g.VU(paramString2[2]);
      locald.aqW(paramString2[3]);
      a(locald, paramString1, l1 * 1000L, l2 * 1000L, com.tencent.mm.plugin.backup.b.g.cj(paramString2[4], 0), this.dzw);
    }
    AppMethodBeat.o(26531);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(26539);
    cancel();
    AppMethodBeat.o(26539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.f
 * JD-Core Version:    0.7.0.1
 */