package com.tencent.mm.plugin.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class f
  implements a.a
{
  private static f FlC;
  private c FlD;
  long FlE;
  boolean FlF = false;
  boolean FlG = false;
  public int fLL;
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(26532);
    Log.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 0L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.cua().cud();
    this.FlD.Fll = this;
    LinkedList localLinkedList = this.FlD.eVd();
    Log.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
      cancel();
      l = Util.milliSecondsToNow(this.FlE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 5L, 0L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 7L, l, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 11L, 0L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 12L, 0L, false);
      b.m(l, paramInt, 1);
      AppMethodBeat.o(26532);
      return;
    }
    if (b.Flg < 0) {}
    for (long l = b.Flg;; l = Util.milliSecondsToNow(b.Flg * 24 * 60 * 60 * 1000))
    {
      this.FlD.a(paramd, localLinkedList, l, System.currentTimeMillis(), b.Fle);
      AppMethodBeat.o(26532);
      return;
    }
  }
  
  private void a(d paramd, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(26533);
    Log.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 15L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.cua().cud();
    this.FlD.Fll = this;
    LinkedList localLinkedList = this.FlD.eVd();
    Log.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = Util.milliSecondsToNow(this.FlE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 16L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 20L, 0L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 22L, paramLong1, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 26L, 0L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 27L, 0L, false);
      b.m(paramLong1, paramInt, 2);
      AppMethodBeat.o(26533);
      return;
    }
    long l;
    if (b.Flg < 0)
    {
      l = b.Flg;
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
          Log.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1) });
          a(paramd, true);
          AppMethodBeat.o(26533);
          return;
          l = Util.milliSecondsToNow(b.Flg * 24 * 60 * 60 * 1000);
          break;
        }
        this.FlD.a(paramd, localLinkedList, l, paramLong1, b.Fle);
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
    Log.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 31L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.cua().cud();
    this.FlD.Fll = this;
    paramString = c.aPE(paramString);
    Log.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString.size()) });
    if (paramString.size() == 0)
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = Util.milliSecondsToNow(this.FlE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 32L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 36L, 0L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 38L, paramLong1, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 42L, 0L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 43L, 0L, false);
      b.m(paramLong1, paramInt2, 3);
      AppMethodBeat.o(26534);
      return;
    }
    this.FlD.a(paramd, paramString, paramLong1, paramLong2, paramInt1);
    AppMethodBeat.o(26534);
  }
  
  static void aPG(String paramString)
  {
    AppMethodBeat.i(26536);
    if (paramString.equals(b.FkX))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 2L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.FkY))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 17L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.FkZ)) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 33L, 1L, false);
    }
    AppMethodBeat.o(26536);
  }
  
  public static f uv(boolean paramBoolean)
  {
    AppMethodBeat.i(26530);
    if (FlC == null) {
      FlC = new f();
    }
    for (;;)
    {
      f localf = FlC;
      AppMethodBeat.o(26530);
      return localf;
      if (paramBoolean)
      {
        FlC.cancel();
        FlC = new f();
      }
    }
  }
  
  public final void a(final d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(26535);
    Log.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramd.Flr), Long.valueOf(paramd.Fls), Long.valueOf(paramd.Flt) });
    if ((paramd.Flr <= 0L) && (paramd.Fls <= 0L) && (paramd.Flt <= 0L))
    {
      Log.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
      a(paramd, true);
      AppMethodBeat.o(26535);
      return;
    }
    g.a local2 = new g.a()
    {
      public final void bez()
      {
        AppMethodBeat.i(26527);
        Log.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[] { Boolean.valueOf(f.this.FlF), Boolean.valueOf(com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN)) });
        if ((f.this.FlF) && (com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN)))
        {
          Log.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
          bh.beI();
          com.tencent.mm.model.c.b(this);
          f.this.FlF = false;
          f.this.a(paramd, false);
        }
        AppMethodBeat.o(26527);
      }
    }
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
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
          f.aPG(paramd.action);
          b.a(0L, 0L, 0L, 0L, 1, f.this.fLL, paramd.action);
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label250;
          }
          Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, paramAnonymousString, paramAnonymousd.field_filemd5 });
          f.aPG(paramd.action);
          f.this.cancel();
          b.a(0L, 0L, 0L, 0L, 1, f.this.fLL, paramd.action);
        }
        for (;;)
        {
          AppMethodBeat.o(26528);
          return 0;
          label250:
          Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[] { paramAnonymousString, paramAnonymousd.field_filemd5, Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = new PByteArray();
          if (!MMProtocalJni.rsaPublicEncryptPemkey(paramAnonymousd.field_aesKey.getBytes(), paramAnonymousString, paramd.Flq))
          {
            Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
            AppMethodBeat.o(26528);
            return -1;
          }
          paramAnonymousString = Util.encodeHexString(paramAnonymousString.value);
          paramAnonymousc = paramd;
          String str = paramAnonymousd.field_fileId;
          paramAnonymousInt = (int)paramAnonymousd.field_fileLength;
          paramAnonymousc.Flw = new String(str);
          paramAnonymousc.Flx = new String(paramAnonymousString);
          paramAnonymousc.Fly = paramAnonymousInt;
          if (com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN))
          {
            Log.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
            f.this.a(paramd, false);
          }
          else
          {
            Log.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
            bh.beI();
            com.tencent.mm.model.c.a(this.FlI);
            f.this.FlF = true;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    String str = "MSG_SYNCHRONIZE_" + paramInt + "_" + Util.nowMilliSecond();
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_MsgSynchronizeServer";
    localg.iUG = local2;
    localg.field_mediaId = str;
    localg.field_fullpath = paramString;
    localg.field_fileType = a.MediaType_FILE;
    localg.field_talker = ((String)com.tencent.mm.plugin.backup.h.d.cua().cub().aHp().b(2, null));
    localg.field_priority = a.iTU;
    if (!com.tencent.mm.aq.f.bkg().f(localg))
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[] { str });
      aPG(paramd.action);
      b.a(0L, 0L, 0L, 0L, 1, this.fLL, paramd.action);
    }
    AppMethodBeat.o(26535);
  }
  
  final void a(final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(26537);
    Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(26529);
        bh.aGY().b(222, this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          f.this.cancel();
          if (paramd.action.equals(b.FkX)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 3L, 1L, false);
          }
          for (;;)
          {
            b.a(0L, 0L, 0L, 0L, 2, f.this.fLL, paramd.action);
            AppMethodBeat.o(26529);
            return;
            if (paramd.action.equals(b.FkY)) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 18L, 1L, false);
            } else if (paramd.action.equals(b.FkZ)) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 34L, 1L, false);
            }
          }
        }
        Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
        com.tencent.mm.plugin.backup.b.g.aoa(g.eVf());
        com.tencent.mm.plugin.backup.b.g.aoa(g.eVg());
        f.this.FlG = false;
        long l = Util.milliSecondsToNow(f.this.FlE);
        if (paramd.action.equals(b.FkX))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 1L, 1L, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 5L, paramd.Flt, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 7L, l, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 11L, paramd.Fls, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 12L, paramd.Flr, false);
        }
        for (;;)
        {
          b.a(paramd.Flt, l, paramd.Fls, paramd.Flr, 0, f.this.fLL, paramd.action);
          AppMethodBeat.o(26529);
          return;
          if (paramd.action.equals(b.FkY))
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 16L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 20L, paramd.Flt, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 22L, l, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 26L, paramd.Fls, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 27L, paramd.Flr, false);
          }
          else if (paramd.action.equals(b.FkZ))
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 36L, paramd.Flt, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 38L, l, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 42L, paramd.Fls, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(466L, 43L, paramd.Flr, false);
          }
        }
      }
    };
    bh.aGY().a(222, (i)localObject);
    localObject = "";
    if (paramd.action.equals(b.FkZ)) {
      localObject = paramd.Flu + "," + paramd.Flv;
    }
    if (paramBoolean) {}
    for (paramd = new e("", "NULL", 0, paramd.iRj, paramd.action, (String)localObject);; paramd = new e(paramd.Flw, paramd.Flx, paramd.Fly, paramd.iRj, paramd.action, (String)localObject))
    {
      bh.aGY().a(paramd, 0);
      AppMethodBeat.o(26537);
      return;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(26538);
    Log.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[] { MMStack.getCaller() });
    this.FlD.Flk = true;
    this.FlG = false;
    AppMethodBeat.o(26538);
  }
  
  public final void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26531);
    Log.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(this.fLL) });
    if (this.FlG)
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", new Object[] { paramString1 });
      AppMethodBeat.o(26531);
      return;
    }
    this.FlG = true;
    this.FlE = Util.nowMilliSecond();
    if (this.FlD != null) {
      this.FlD.Flk = true;
    }
    this.FlD = new c();
    d locald = new d(paramString1);
    locald.Flq = paramArrayOfByte;
    if (paramString1.equals(b.FkX))
    {
      a(locald, this.fLL);
      AppMethodBeat.o(26531);
      return;
    }
    bh.beI();
    if (!((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnA, Boolean.FALSE)).booleanValue())
    {
      Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
      cancel();
      AppMethodBeat.o(26531);
      return;
    }
    paramString2 = paramString2.split(",");
    if (paramString1.equals(b.FkY))
    {
      if (b.Flh <= 0)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 2)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      a(locald, com.tencent.mm.plugin.backup.b.g.aog(paramString2[0]) * 1000L, com.tencent.mm.plugin.backup.b.g.aog(paramString2[1]) * 1000L, this.fLL);
      AppMethodBeat.o(26531);
      return;
    }
    if (paramString1.equals(b.FkZ))
    {
      if (b.Fli <= 0)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 5)
      {
        Log.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      paramString1 = paramString2[0];
      long l1 = com.tencent.mm.plugin.backup.b.g.aog(paramString2[1]);
      long l2 = com.tencent.mm.plugin.backup.b.g.aog(paramString2[2]);
      locald.aPF(paramString2[3]);
      a(locald, paramString1, l1 * 1000L, l2 * 1000L, com.tencent.mm.plugin.backup.b.g.cP(paramString2[4], 0), this.fLL);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.z.f
 * JD-Core Version:    0.7.0.1
 */