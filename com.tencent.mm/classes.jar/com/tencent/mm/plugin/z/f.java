package com.tencent.mm.plugin.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.g.a;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class f
  implements a.a
{
  private static f LhE;
  private c LhF;
  long LhG;
  boolean LhH = false;
  boolean LhI = false;
  public int hRt;
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(26532);
    Log.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 0L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.cWK().cWN();
    this.LhF.Lhn = this;
    LinkedList localLinkedList = this.LhF.gdQ();
    if (localLinkedList == null) {}
    for (int i = -1;; i = localLinkedList.size())
    {
      Log.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(i) });
      if ((localLinkedList != null) && (localLinkedList.size() != 0)) {
        break;
      }
      Log.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
      cancel();
      l = Util.milliSecondsToNow(this.LhG);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 5L, 0L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 7L, l, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 11L, 0L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 12L, 0L, false);
      b.u(l, paramInt, 1);
      AppMethodBeat.o(26532);
      return;
    }
    if (b.Lhi < 0) {}
    for (long l = b.Lhi;; l = Util.milliSecondsToNow(b.Lhi * 24 * 60 * 60 * 1000))
    {
      this.LhF.a(paramd, localLinkedList, l, System.currentTimeMillis(), b.Lhg);
      AppMethodBeat.o(26532);
      return;
    }
  }
  
  private void a(d paramd, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(26533);
    Log.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 15L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.cWK().cWN();
    this.LhF.Lhn = this;
    LinkedList localLinkedList = this.LhF.gdQ();
    if (localLinkedList == null) {}
    for (int i = -1;; i = localLinkedList.size())
    {
      Log.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(i) });
      if ((localLinkedList != null) && (localLinkedList.size() != 0)) {
        break;
      }
      Log.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = Util.milliSecondsToNow(this.LhG);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 16L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 20L, 0L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 22L, paramLong1, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 26L, 0L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 27L, 0L, false);
      b.u(paramLong1, paramInt, 2);
      AppMethodBeat.o(26533);
      return;
    }
    long l;
    if (b.Lhi < 0)
    {
      l = b.Lhi;
      if (paramLong1 >= l) {
        break label345;
      }
    }
    for (;;)
    {
      if (paramLong2 == 0L) {}
      for (paramLong1 = System.currentTimeMillis();; paramLong1 = paramLong2)
      {
        if (l > paramLong1)
        {
          Log.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1) });
          a(paramd, true);
          AppMethodBeat.o(26533);
          return;
          l = Util.milliSecondsToNow(b.Lhi * 24 * 60 * 60 * 1000);
          break;
        }
        this.LhF.a(paramd, localLinkedList, l, paramLong1, b.Lhg);
        AppMethodBeat.o(26533);
        return;
      }
      label345:
      l = paramLong1;
    }
  }
  
  private void a(d paramd, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26534);
    Log.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 31L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.cWK().cWN();
    this.LhF.Lhn = this;
    paramString = c.aMC(paramString);
    if (paramString == null) {}
    for (int i = -1;; i = paramString.size())
    {
      Log.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(i) });
      if ((paramString != null) && (paramString.size() != 0)) {
        break;
      }
      Log.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = Util.milliSecondsToNow(this.LhG);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 32L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 36L, 0L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 38L, paramLong1, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 42L, 0L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 43L, 0L, false);
      b.u(paramLong1, paramInt2, 3);
      AppMethodBeat.o(26534);
      return;
    }
    this.LhF.a(paramd, paramString, paramLong1, paramLong2, paramInt1);
    AppMethodBeat.o(26534);
  }
  
  static void aME(String paramString)
  {
    AppMethodBeat.i(26536);
    if (paramString.equals(b.LgZ))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 2L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.Lha))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 17L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.Lhb)) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 33L, 1L, false);
    }
    AppMethodBeat.o(26536);
  }
  
  public static f yH(boolean paramBoolean)
  {
    AppMethodBeat.i(26530);
    if (LhE == null) {
      LhE = new f();
    }
    for (;;)
    {
      f localf = LhE;
      AppMethodBeat.o(26530);
      return localf;
      if (paramBoolean)
      {
        LhE.cancel();
        LhE = new f();
      }
    }
  }
  
  public final void a(final d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(26535);
    Log.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramd.Lht), Long.valueOf(paramd.Lhu), Long.valueOf(paramd.Lhv) });
    if ((paramd.Lht <= 0L) && (paramd.Lhu <= 0L) && (paramd.Lhv <= 0L))
    {
      Log.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
      a(paramd, true);
      AppMethodBeat.o(26535);
      return;
    }
    g.a local2 = new g.a()
    {
      public final void onNotifyUserStatusChange()
      {
        AppMethodBeat.i(26527);
        Log.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[] { Boolean.valueOf(f.this.LhH), Boolean.valueOf(com.tencent.mm.kernel.b.sy(com.tencent.mm.kernel.h.baC().mBT)) });
        if ((f.this.LhH) && (com.tencent.mm.kernel.b.sy(com.tencent.mm.kernel.h.baC().mBT)))
        {
          Log.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
          bh.bCz();
          com.tencent.mm.model.c.b(this);
          f.this.LhH = false;
          f.this.a(paramd, false);
        }
        AppMethodBeat.o(26527);
      }
    }
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26528);
        Log.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          f.this.cancel();
          f.aME(paramd.action);
          b.a(0L, 0L, 0L, 0L, 1, f.this.hRt, paramd.action);
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label250;
          }
          Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, paramAnonymousString, paramAnonymousd.field_filemd5 });
          f.aME(paramd.action);
          f.this.cancel();
          b.a(0L, 0L, 0L, 0L, 1, f.this.hRt, paramd.action);
        }
        for (;;)
        {
          AppMethodBeat.o(26528);
          return 0;
          label250:
          Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[] { paramAnonymousString, paramAnonymousd.field_filemd5, Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = new PByteArray();
          if (!MMProtocalJni.rsaPublicEncryptPemkey(paramAnonymousd.field_aesKey.getBytes(), paramAnonymousString, paramd.Lhs))
          {
            Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
            AppMethodBeat.o(26528);
            return -1;
          }
          paramAnonymousString = Util.encodeHexString(paramAnonymousString.value);
          paramAnonymousc = paramd;
          String str = paramAnonymousd.field_fileId;
          paramAnonymousInt = (int)paramAnonymousd.field_fileLength;
          paramAnonymousc.Lhy = new String(str);
          paramAnonymousc.Lhz = new String(paramAnonymousString);
          paramAnonymousc.LhA = paramAnonymousInt;
          if (com.tencent.mm.kernel.b.sy(com.tencent.mm.kernel.h.baC().mBT))
          {
            Log.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
            f.this.a(paramd, false);
          }
          else
          {
            Log.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
            bh.bCz();
            com.tencent.mm.model.c.a(this.LhK);
            f.this.LhH = true;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    String str = "MSG_SYNCHRONIZE_" + paramInt + "_" + Util.nowMilliSecond();
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_MsgSynchronizeServer";
    localg.lwL = local2;
    localg.field_mediaId = str;
    localg.field_fullpath = paramString;
    localg.field_fileType = a.MediaType_FILE;
    localg.field_talker = ((String)com.tencent.mm.plugin.backup.h.d.cWK().cWL().ban().d(2, null));
    localg.field_priority = a.lvZ;
    if (!k.bHW().g(localg))
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[] { str });
      aME(paramd.action);
      b.a(0L, 0L, 0L, 0L, 1, this.hRt, paramd.action);
    }
    AppMethodBeat.o(26535);
  }
  
  final void a(final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(26537);
    Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(26529);
        bh.aZW().b(222, this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          f.this.cancel();
          if (paramd.action.equals(b.LgZ)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 3L, 1L, false);
          }
          for (;;)
          {
            b.a(0L, 0L, 0L, 0L, 2, f.this.hRt, paramd.action);
            AppMethodBeat.o(26529);
            return;
            if (paramd.action.equals(b.Lha)) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 18L, 1L, false);
            } else if (paramd.action.equals(b.Lhb)) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 34L, 1L, false);
            }
          }
        }
        Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
        com.tencent.mm.plugin.backup.b.g.ahx(g.gdS());
        com.tencent.mm.plugin.backup.b.g.ahx(g.gdT());
        f.this.LhI = false;
        long l = Util.milliSecondsToNow(f.this.LhG);
        if (paramd.action.equals(b.LgZ))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 1L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 5L, paramd.Lhv, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 7L, l, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 11L, paramd.Lhu, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 12L, paramd.Lht, false);
        }
        for (;;)
        {
          b.a(paramd.Lhv, l, paramd.Lhu, paramd.Lht, 0, f.this.hRt, paramd.action);
          AppMethodBeat.o(26529);
          return;
          if (paramd.action.equals(b.Lha))
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 16L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 20L, paramd.Lhv, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 22L, l, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 26L, paramd.Lhu, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 27L, paramd.Lht, false);
          }
          else if (paramd.action.equals(b.Lhb))
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 36L, paramd.Lhv, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 38L, l, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 42L, paramd.Lhu, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(466L, 43L, paramd.Lht, false);
          }
        }
      }
    };
    bh.aZW().a(222, (com.tencent.mm.am.h)localObject);
    localObject = "";
    if (paramd.action.equals(b.Lhb)) {
      localObject = paramd.Lhw + "," + paramd.Lhx;
    }
    if (paramBoolean) {}
    for (paramd = new e("", "NULL", 0, paramd.ltf, paramd.action, (String)localObject, paramd.hRv);; paramd = new e(paramd.Lhy, paramd.Lhz, paramd.LhA, paramd.ltf, paramd.action, (String)localObject, paramd.hRv))
    {
      bh.aZW().a(paramd, 0);
      AppMethodBeat.o(26537);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(261810);
    Log.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(this.hRt) });
    if (this.LhI)
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", new Object[] { paramString1 });
      AppMethodBeat.o(261810);
      return;
    }
    this.LhI = true;
    this.LhG = Util.nowMilliSecond();
    if (this.LhF != null) {
      this.LhF.Lhm = true;
    }
    this.LhF = new c();
    d locald = new d(paramString1);
    locald.Lhs = paramArrayOfByte;
    locald.hRv = paramString3;
    if (paramString1.equals(b.LgZ))
    {
      a(locald, this.hRt);
      AppMethodBeat.o(261810);
      return;
    }
    bh.bCz();
    if (!((Boolean)com.tencent.mm.model.c.ban().get(at.a.acOV, Boolean.FALSE)).booleanValue())
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
      cancel();
      AppMethodBeat.o(261810);
      return;
    }
    paramString2 = paramString2.split(",");
    if (paramString1.equals(b.Lha))
    {
      if (b.Lhj <= 0)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(261810);
        return;
      }
      if (paramString2.length < 2)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(261810);
        return;
      }
      a(locald, com.tencent.mm.plugin.backup.b.g.ahD(paramString2[0]) * 1000L, com.tencent.mm.plugin.backup.b.g.ahD(paramString2[1]) * 1000L, this.hRt);
      AppMethodBeat.o(261810);
      return;
    }
    if (paramString1.equals(b.Lhb))
    {
      if (b.Lhk <= 0)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(261810);
        return;
      }
      if (paramString2.length < 5)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(261810);
        return;
      }
      paramString1 = paramString2[0];
      long l1 = com.tencent.mm.plugin.backup.b.g.ahD(paramString2[1]);
      long l2 = com.tencent.mm.plugin.backup.b.g.ahD(paramString2[2]);
      locald.aMD(paramString2[3]);
      a(locald, paramString1, l1 * 1000L, l2 * 1000L, com.tencent.mm.plugin.backup.b.g.dr(paramString2[4], 0), this.hRt);
    }
    AppMethodBeat.o(261810);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(26538);
    Log.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[] { MMStack.getCaller() });
    this.LhF.Lhm = true;
    this.LhI = false;
    AppMethodBeat.o(26538);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(26539);
    cancel();
    AppMethodBeat.o(26539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.z.f
 * JD-Core Version:    0.7.0.1
 */