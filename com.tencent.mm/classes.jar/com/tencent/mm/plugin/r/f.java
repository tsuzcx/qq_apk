package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.av;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class f
  implements a.a
{
  private static f uWE;
  public int dnI;
  private c uWF;
  long uWG;
  boolean uWH = false;
  boolean uWI = false;
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(26532);
    ac.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    h.wUl.idkeyStat(466L, 0L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bEP().bES();
    this.uWF.uWn = this;
    LinkedList localLinkedList = this.uWF.dfe();
    ac.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ac.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
      cancel();
      l = bs.Ap(this.uWG);
      h.wUl.idkeyStat(466L, 1L, 1L, false);
      h.wUl.idkeyStat(466L, 5L, 0L, false);
      h.wUl.idkeyStat(466L, 7L, l, false);
      h.wUl.idkeyStat(466L, 11L, 0L, false);
      h.wUl.idkeyStat(466L, 12L, 0L, false);
      b.l(l, paramInt, 1);
      AppMethodBeat.o(26532);
      return;
    }
    if (b.uWi < 0) {}
    for (long l = b.uWi;; l = bs.Ap(b.uWi * 24 * 60 * 60 * 1000))
    {
      this.uWF.a(paramd, localLinkedList, l, System.currentTimeMillis(), b.uWg);
      AppMethodBeat.o(26532);
      return;
    }
  }
  
  private void a(d paramd, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(26533);
    ac.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    h.wUl.idkeyStat(466L, 15L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bEP().bES();
    this.uWF.uWn = this;
    LinkedList localLinkedList = this.uWF.dfe();
    ac.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ac.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bs.Ap(this.uWG);
      h.wUl.idkeyStat(466L, 16L, 1L, false);
      h.wUl.idkeyStat(466L, 20L, 0L, false);
      h.wUl.idkeyStat(466L, 22L, paramLong1, false);
      h.wUl.idkeyStat(466L, 26L, 0L, false);
      h.wUl.idkeyStat(466L, 27L, 0L, false);
      b.l(paramLong1, paramInt, 2);
      AppMethodBeat.o(26533);
      return;
    }
    long l;
    if (b.uWi < 0)
    {
      l = b.uWi;
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
          ac.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1) });
          a(paramd, true);
          AppMethodBeat.o(26533);
          return;
          l = bs.Ap(b.uWi * 24 * 60 * 60 * 1000);
          break;
        }
        this.uWF.a(paramd, localLinkedList, l, paramLong1, b.uWg);
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
    ac.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt2) });
    h.wUl.idkeyStat(466L, 31L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.bEP().bES();
    this.uWF.uWn = this;
    paramString = c.amg(paramString);
    ac.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString.size()) });
    if (paramString.size() == 0)
    {
      ac.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bs.Ap(this.uWG);
      h.wUl.idkeyStat(466L, 32L, 1L, false);
      h.wUl.idkeyStat(466L, 36L, 0L, false);
      h.wUl.idkeyStat(466L, 38L, paramLong1, false);
      h.wUl.idkeyStat(466L, 42L, 0L, false);
      h.wUl.idkeyStat(466L, 43L, 0L, false);
      b.l(paramLong1, paramInt2, 3);
      AppMethodBeat.o(26534);
      return;
    }
    this.uWF.a(paramd, paramString, paramLong1, paramLong2, paramInt1);
    AppMethodBeat.o(26534);
  }
  
  static void ami(String paramString)
  {
    AppMethodBeat.i(26536);
    if (paramString.equals(b.uVZ))
    {
      h.wUl.idkeyStat(466L, 2L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.uWa))
    {
      h.wUl.idkeyStat(466L, 17L, 1L, false);
      AppMethodBeat.o(26536);
      return;
    }
    if (paramString.equals(b.uWb)) {
      h.wUl.idkeyStat(466L, 33L, 1L, false);
    }
    AppMethodBeat.o(26536);
  }
  
  public static f ok(boolean paramBoolean)
  {
    AppMethodBeat.i(26530);
    if (uWE == null) {
      uWE = new f();
    }
    for (;;)
    {
      f localf = uWE;
      AppMethodBeat.o(26530);
      return localf;
      if (paramBoolean)
      {
        uWE.cancel();
        uWE = new f();
      }
    }
  }
  
  public final void a(final d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(26535);
    ac.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramd.uWt), Long.valueOf(paramd.uWu), Long.valueOf(paramd.uWv) });
    if ((paramd.uWt <= 0L) && (paramd.uWu <= 0L) && (paramd.uWv <= 0L))
    {
      ac.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
      a(paramd, true);
      AppMethodBeat.o(26535);
      return;
    }
    g.a local2 = new g.a()
    {
      public final void ayD()
      {
        AppMethodBeat.i(26527);
        ac.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[] { Boolean.valueOf(f.this.uWH), Boolean.valueOf(com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.g.agP().ggN)) });
        if ((f.this.uWH) && (com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.g.agP().ggN)))
        {
          ac.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
          az.ayM();
          com.tencent.mm.model.c.b(this);
          f.this.uWH = false;
          f.this.a(paramd, false);
        }
        AppMethodBeat.o(26527);
      }
    }
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26528);
        ac.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ac.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ac.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          f.this.cancel();
          f.ami(paramd.action);
          b.a(0L, 0L, 0L, 0L, 1, f.this.dnI, paramd.action);
          AppMethodBeat.o(26528);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label250;
          }
          ac.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, paramAnonymousString, paramAnonymousd.field_filemd5 });
          f.ami(paramd.action);
          f.this.cancel();
          b.a(0L, 0L, 0L, 0L, 1, f.this.dnI, paramd.action);
        }
        for (;;)
        {
          AppMethodBeat.o(26528);
          return 0;
          label250:
          ac.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[] { paramAnonymousString, paramAnonymousd.field_filemd5, Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = new PByteArray();
          if (!MMProtocalJni.rsaPublicEncryptPemkey(paramAnonymousd.field_aesKey.getBytes(), paramAnonymousString, paramd.uWs))
          {
            ac.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
            AppMethodBeat.o(26528);
            return -1;
          }
          paramAnonymousString = bs.cx(paramAnonymousString.value);
          paramAnonymousc = paramd;
          String str = paramAnonymousd.field_fileId;
          paramAnonymousInt = (int)paramAnonymousd.field_fileLength;
          paramAnonymousc.uWy = new String(str);
          paramAnonymousc.uWz = new String(paramAnonymousString);
          paramAnonymousc.uWA = paramAnonymousInt;
          if (com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.g.agP().ggN))
          {
            ac.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
            f.this.a(paramd, false);
          }
          else
          {
            ac.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
            az.ayM();
            com.tencent.mm.model.c.a(this.uWK);
            f.this.uWH = true;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    String str = "MSG_SYNCHRONIZE_" + paramInt + "_" + bs.eWj();
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = local2;
    localg.field_mediaId = str;
    localg.field_fullpath = paramString;
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = ((String)com.tencent.mm.plugin.backup.h.d.bEP().bEQ().agA().get(2, null));
    localg.field_priority = com.tencent.mm.i.a.fqp;
    if (!com.tencent.mm.an.f.aDD().f(localg))
    {
      ac.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[] { str });
      ami(paramd.action);
      b.a(0L, 0L, 0L, 0L, 1, this.dnI, paramd.action);
    }
    AppMethodBeat.o(26535);
  }
  
  final void a(final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(26537);
    ac.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(26529);
        az.agi().b(222, this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          f.this.cancel();
          if (paramd.action.equals(b.uVZ)) {
            h.wUl.idkeyStat(466L, 3L, 1L, false);
          }
          for (;;)
          {
            b.a(0L, 0L, 0L, 0L, 2, f.this.dnI, paramd.action);
            AppMethodBeat.o(26529);
            return;
            if (paramd.action.equals(b.uWa)) {
              h.wUl.idkeyStat(466L, 18L, 1L, false);
            } else if (paramd.action.equals(b.uWb)) {
              h.wUl.idkeyStat(466L, 34L, 1L, false);
            }
          }
        }
        ac.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
        com.tencent.mm.plugin.backup.b.g.Sq(g.dfg());
        com.tencent.mm.plugin.backup.b.g.Sq(g.dfh());
        f.this.uWI = false;
        long l = bs.Ap(f.this.uWG);
        if (paramd.action.equals(b.uVZ))
        {
          h.wUl.idkeyStat(466L, 1L, 1L, false);
          h.wUl.idkeyStat(466L, 5L, paramd.uWv, false);
          h.wUl.idkeyStat(466L, 7L, l, false);
          h.wUl.idkeyStat(466L, 11L, paramd.uWu, false);
          h.wUl.idkeyStat(466L, 12L, paramd.uWt, false);
        }
        for (;;)
        {
          b.a(paramd.uWv, l, paramd.uWu, paramd.uWt, 0, f.this.dnI, paramd.action);
          AppMethodBeat.o(26529);
          return;
          if (paramd.action.equals(b.uWa))
          {
            h.wUl.idkeyStat(466L, 16L, 1L, false);
            h.wUl.idkeyStat(466L, 20L, paramd.uWv, false);
            h.wUl.idkeyStat(466L, 22L, l, false);
            h.wUl.idkeyStat(466L, 26L, paramd.uWu, false);
            h.wUl.idkeyStat(466L, 27L, paramd.uWt, false);
          }
          else if (paramd.action.equals(b.uWb))
          {
            h.wUl.idkeyStat(466L, 32L, 1L, false);
            h.wUl.idkeyStat(466L, 36L, paramd.uWv, false);
            h.wUl.idkeyStat(466L, 38L, l, false);
            h.wUl.idkeyStat(466L, 42L, paramd.uWu, false);
            h.wUl.idkeyStat(466L, 43L, paramd.uWt, false);
          }
        }
      }
    };
    az.agi().a(222, (com.tencent.mm.ak.g)localObject);
    localObject = "";
    if (paramd.action.equals(b.uWb)) {
      localObject = paramd.uWw + "," + paramd.uWx;
    }
    if (paramBoolean) {}
    for (paramd = new e("", "NULL", 0, paramd.fnC, paramd.action, (String)localObject);; paramd = new e(paramd.uWy, paramd.uWz, paramd.uWA, paramd.fnC, paramd.action, (String)localObject))
    {
      az.agi().a(paramd, 0);
      AppMethodBeat.o(26537);
      return;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(26538);
    ac.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[] { as.eVo() });
    this.uWF.uWm = true;
    this.uWI = false;
    AppMethodBeat.o(26538);
  }
  
  public final void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26531);
    ac.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(this.dnI) });
    if (this.uWI)
    {
      ac.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", new Object[] { paramString1 });
      AppMethodBeat.o(26531);
      return;
    }
    this.uWI = true;
    this.uWG = bs.eWj();
    if (this.uWF != null) {
      this.uWF.uWm = true;
    }
    this.uWF = new c();
    d locald = new d(paramString1);
    locald.uWs = paramArrayOfByte;
    if (paramString1.equals(b.uVZ))
    {
      a(locald, this.dnI);
      AppMethodBeat.o(26531);
      return;
    }
    az.ayM();
    if (!((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKI, Boolean.FALSE)).booleanValue())
    {
      ac.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
      cancel();
      AppMethodBeat.o(26531);
      return;
    }
    paramString2 = paramString2.split(",");
    if (paramString1.equals(b.uWa))
    {
      if (b.uWj <= 0)
      {
        ac.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 2)
      {
        ac.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      a(locald, com.tencent.mm.plugin.backup.b.g.Sw(paramString2[0]) * 1000L, com.tencent.mm.plugin.backup.b.g.Sw(paramString2[1]) * 1000L, this.dnI);
      AppMethodBeat.o(26531);
      return;
    }
    if (paramString1.equals(b.uWb))
    {
      if (b.uWk <= 0)
      {
        ac.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      if (paramString2.length < 5)
      {
        ac.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(26531);
        return;
      }
      paramString1 = paramString2[0];
      long l1 = com.tencent.mm.plugin.backup.b.g.Sw(paramString2[1]);
      long l2 = com.tencent.mm.plugin.backup.b.g.Sw(paramString2[2]);
      locald.amh(paramString2[3]);
      a(locald, paramString1, l1 * 1000L, l2 * 1000L, com.tencent.mm.plugin.backup.b.g.cg(paramString2[4], 0), this.dnI);
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