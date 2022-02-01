package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bc;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class f
  implements a.a
{
  private static f wlQ;
  public int dAB;
  private c wlR;
  long wlS;
  boolean wlT = false;
  boolean wlU = false;
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(26532);
    ae.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 0L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
    this.wlR.wlz = this;
    LinkedList localLinkedList = this.wlR.drA();
    ae.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ae.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
      cancel();
      l = bu.DD(this.wlS);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 5L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 7L, l, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 11L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 12L, 0L, false);
      b.m(l, paramInt, 1);
      AppMethodBeat.o(26532);
      return;
    }
    if (b.wlu < 0) {}
    for (long l = b.wlu;; l = bu.DD(b.wlu * 24 * 60 * 60 * 1000))
    {
      this.wlR.a(paramd, localLinkedList, l, System.currentTimeMillis(), b.wls);
      AppMethodBeat.o(26532);
      return;
    }
  }
  
  private void a(d paramd, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(26533);
    ae.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 15L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
    this.wlR.wlz = this;
    LinkedList localLinkedList = this.wlR.drA();
    ae.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ae.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bu.DD(this.wlS);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 16L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 20L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 22L, paramLong1, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 26L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 27L, 0L, false);
      b.m(paramLong1, paramInt, 2);
      AppMethodBeat.o(26533);
      return;
    }
    long l;
    if (b.wlu < 0)
    {
      l = b.wlu;
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
          ae.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1) });
          a(paramd, true);
          AppMethodBeat.o(26533);
          return;
          l = bu.DD(b.wlu * 24 * 60 * 60 * 1000);
          break;
        }
        this.wlR.a(paramd, localLinkedList, l, paramLong1, b.wls);
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
    ae.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 31L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
    this.wlR.wlz = this;
    paramString = c.asa(paramString);
    ae.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString.size()) });
    if (paramString.size() == 0)
    {
      ae.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bu.DD(this.wlS);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 32L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 36L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 38L, paramLong1, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 42L, 0L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 43L, 0L, false);
      b.m(paramLong1, paramInt2, 3);
      AppMethodBeat.o(26534);
      return;
    }
    this.wlR.a(paramd, paramString, paramLong1, paramLong2, paramInt1);
    AppMethodBeat.o(26534);
  }
  
  static void asc(String paramString)
  {
    AppMethodBeat.i(26536);
    if (paramString.equals(b.wll))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 2L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.wlm))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 17L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.wln)) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 33L, 1L, false);
    }
    AppMethodBeat.o(26536);
  }
  
  public static f oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(26530);
    if (wlQ == null) {
      wlQ = new f();
    }
    for (;;)
    {
      f localf = wlQ;
      AppMethodBeat.o(26530);
      return localf;
      if (paramBoolean)
      {
        wlQ.cancel();
        wlQ = new f();
      }
    }
  }
  
  public final void a(final d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(26535);
    ae.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramd.wlF), Long.valueOf(paramd.wlG), Long.valueOf(paramd.wlH) });
    if ((paramd.wlF <= 0L) && (paramd.wlG <= 0L) && (paramd.wlH <= 0L))
    {
      ae.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
      a(paramd, true);
      AppMethodBeat.o(26535);
      return;
    }
    g.a local2 = new g.a()
    {
      public final void aBX()
      {
        AppMethodBeat.i(26527);
        ae.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[] { Boolean.valueOf(f.this.wlT), Boolean.valueOf(com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe)) });
        if ((f.this.wlT) && (com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe)))
        {
          ae.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
          bc.aCg();
          com.tencent.mm.model.c.b(this);
          f.this.wlT = false;
          f.this.a(paramd, false);
        }
        AppMethodBeat.o(26527);
      }
    }
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26528);
        ae.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ae.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ae.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          f.this.cancel();
          f.asc(paramd.action);
          b.a(0L, 0L, 0L, 0L, 1, f.this.dAB, paramd.action);
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label250;
          }
          ae.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, paramAnonymousString, paramAnonymousd.field_filemd5 });
          f.asc(paramd.action);
          f.this.cancel();
          b.a(0L, 0L, 0L, 0L, 1, f.this.dAB, paramd.action);
        }
        for (;;)
        {
          AppMethodBeat.o(26528);
          return 0;
          label250:
          ae.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[] { paramAnonymousString, paramAnonymousd.field_filemd5, Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = new PByteArray();
          if (!MMProtocalJni.rsaPublicEncryptPemkey(paramAnonymousd.field_aesKey.getBytes(), paramAnonymousString, paramd.wlE))
          {
            ae.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
            AppMethodBeat.o(26528);
            return -1;
          }
          paramAnonymousString = bu.cH(paramAnonymousString.value);
          paramAnonymousc = paramd;
          String str = paramAnonymousd.field_fileId;
          paramAnonymousInt = (int)paramAnonymousd.field_fileLength;
          paramAnonymousc.wlK = new String(str);
          paramAnonymousc.wlL = new String(paramAnonymousString);
          paramAnonymousc.wlM = paramAnonymousInt;
          if (com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe))
          {
            ae.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
            f.this.a(paramd, false);
          }
          else
          {
            ae.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
            bc.aCg();
            com.tencent.mm.model.c.a(this.wlW);
            f.this.wlT = true;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    String str = "MSG_SYNCHRONIZE_" + paramInt + "_" + bu.fpO();
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_MsgSynchronizeServer";
    localg.fLm = local2;
    localg.field_mediaId = str;
    localg.field_fullpath = paramString;
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = ((String)com.tencent.mm.plugin.backup.h.d.bJW().bJX().ajA().get(2, null));
    localg.field_priority = com.tencent.mm.i.a.fKA;
    if (!com.tencent.mm.an.f.aGZ().f(localg))
    {
      ae.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[] { str });
      asc(paramd.action);
      b.a(0L, 0L, 0L, 0L, 1, this.dAB, paramd.action);
    }
    AppMethodBeat.o(26535);
  }
  
  final void a(final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(26537);
    ae.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(26529);
        bc.ajj().b(222, this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          f.this.cancel();
          if (paramd.action.equals(b.wll)) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 3L, 1L, false);
          }
          for (;;)
          {
            b.a(0L, 0L, 0L, 0L, 2, f.this.dAB, paramd.action);
            AppMethodBeat.o(26529);
            return;
            if (paramd.action.equals(b.wlm)) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 18L, 1L, false);
            } else if (paramd.action.equals(b.wln)) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 34L, 1L, false);
            }
          }
        }
        ae.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
        com.tencent.mm.plugin.backup.b.g.WA(g.drC());
        com.tencent.mm.plugin.backup.b.g.WA(g.drD());
        f.this.wlU = false;
        long l = bu.DD(f.this.wlS);
        if (paramd.action.equals(b.wll))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 1L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 5L, paramd.wlH, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 7L, l, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 11L, paramd.wlG, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 12L, paramd.wlF, false);
        }
        for (;;)
        {
          b.a(paramd.wlH, l, paramd.wlG, paramd.wlF, 0, f.this.dAB, paramd.action);
          AppMethodBeat.o(26529);
          return;
          if (paramd.action.equals(b.wlm))
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 16L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 20L, paramd.wlH, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 22L, l, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 26L, paramd.wlG, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 27L, paramd.wlF, false);
          }
          else if (paramd.action.equals(b.wln))
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 36L, paramd.wlH, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 38L, l, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 42L, paramd.wlG, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(466L, 43L, paramd.wlF, false);
          }
        }
      }
    };
    bc.ajj().a(222, (com.tencent.mm.ak.f)localObject);
    localObject = "";
    if (paramd.action.equals(b.wln)) {
      localObject = paramd.wlI + "," + paramd.wlJ;
    }
    if (paramBoolean) {}
    for (paramd = new e("", "NULL", 0, paramd.fHO, paramd.action, (String)localObject);; paramd = new e(paramd.wlK, paramd.wlL, paramd.wlM, paramd.fHO, paramd.action, (String)localObject))
    {
      bc.ajj().a(paramd, 0);
      AppMethodBeat.o(26537);
      return;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(26538);
    ae.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[] { au.foQ() });
    this.wlR.wly = true;
    this.wlU = false;
    AppMethodBeat.o(26538);
  }
  
  public final void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26531);
    ae.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(this.dAB) });
    if (this.wlU)
    {
      ae.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", new Object[] { paramString1 });
      AppMethodBeat.o(26531);
      return;
    }
    this.wlU = true;
    this.wlS = bu.fpO();
    if (this.wlR != null) {
      this.wlR.wly = true;
    }
    this.wlR = new c();
    d locald = new d(paramString1);
    locald.wlE = paramArrayOfByte;
    if (paramString1.equals(b.wll))
    {
      a(locald, this.dAB);
      AppMethodBeat.o(26531);
      return;
    }
    bc.aCg();
    if (!((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IRy, Boolean.FALSE)).booleanValue())
    {
      ae.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
      cancel();
      AppMethodBeat.o(26531);
      return;
    }
    paramString2 = paramString2.split(",");
    if (paramString1.equals(b.wlm))
    {
      if (b.wlv <= 0)
      {
        ae.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 2)
      {
        ae.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      a(locald, com.tencent.mm.plugin.backup.b.g.WG(paramString2[0]) * 1000L, com.tencent.mm.plugin.backup.b.g.WG(paramString2[1]) * 1000L, this.dAB);
      AppMethodBeat.o(26531);
      return;
    }
    if (paramString1.equals(b.wln))
    {
      if (b.wlw <= 0)
      {
        ae.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 5)
      {
        ae.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      paramString1 = paramString2[0];
      long l1 = com.tencent.mm.plugin.backup.b.g.WG(paramString2[1]);
      long l2 = com.tencent.mm.plugin.backup.b.g.WG(paramString2[2]);
      locald.asb(paramString2[3]);
      a(locald, paramString1, l1 * 1000L, l2 * 1000L, com.tencent.mm.plugin.backup.b.g.cn(paramString2[4], 0), this.dAB);
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