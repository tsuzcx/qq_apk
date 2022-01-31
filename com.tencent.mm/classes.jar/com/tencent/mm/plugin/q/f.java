package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.i.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class f
  implements a.a
{
  private static f oSR;
  public int czO;
  private c oSS;
  long oST;
  boolean oSU = false;
  boolean oSV = false;
  
  static void Ug(String paramString)
  {
    AppMethodBeat.i(22912);
    if (paramString.equals(b.oSm))
    {
      h.qsU.idkeyStat(466L, 2L, 1L, false);
      AppMethodBeat.o(22912);
      return;
    }
    if (paramString.equals(b.oSn))
    {
      h.qsU.idkeyStat(466L, 17L, 1L, false);
      AppMethodBeat.o(22912);
      return;
    }
    if (paramString.equals(b.oSo)) {
      h.qsU.idkeyStat(466L, 33L, 1L, false);
    }
    AppMethodBeat.o(22912);
  }
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(22908);
    ab.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    h.qsU.idkeyStat(466L, 0L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.aUK().aUN();
    this.oSS.oSA = this;
    LinkedList localLinkedList = this.oSS.bSw();
    ab.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
      cancel();
      l = bo.hl(this.oST);
      h.qsU.idkeyStat(466L, 1L, 1L, false);
      h.qsU.idkeyStat(466L, 5L, 0L, false);
      h.qsU.idkeyStat(466L, 7L, l, false);
      h.qsU.idkeyStat(466L, 11L, 0L, false);
      h.qsU.idkeyStat(466L, 12L, 0L, false);
      b.k(l, paramInt, 1);
      AppMethodBeat.o(22908);
      return;
    }
    if (b.oSv < 0) {}
    for (long l = b.oSv;; l = bo.hl(b.oSv * 24 * 60 * 60 * 1000))
    {
      this.oSS.a(paramd, localLinkedList, l, System.currentTimeMillis(), b.oSt);
      AppMethodBeat.o(22908);
      return;
    }
  }
  
  private void a(d paramd, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(22909);
    ab.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt) });
    h.qsU.idkeyStat(466L, 15L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.aUK().aUN();
    this.oSS.oSA = this;
    LinkedList localLinkedList = this.oSS.bSw();
    ab.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() == 0)
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bo.hl(this.oST);
      h.qsU.idkeyStat(466L, 16L, 1L, false);
      h.qsU.idkeyStat(466L, 20L, 0L, false);
      h.qsU.idkeyStat(466L, 22L, paramLong1, false);
      h.qsU.idkeyStat(466L, 26L, 0L, false);
      h.qsU.idkeyStat(466L, 27L, 0L, false);
      b.k(paramLong1, paramInt, 2);
      AppMethodBeat.o(22909);
      return;
    }
    long l;
    if (b.oSv < 0)
    {
      l = b.oSv;
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
          ab.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1) });
          a(paramd, true);
          AppMethodBeat.o(22909);
          return;
          l = bo.hl(b.oSv * 24 * 60 * 60 * 1000);
          break;
        }
        this.oSS.a(paramd, localLinkedList, l, paramLong1, b.oSt);
        AppMethodBeat.o(22909);
        return;
      }
      label325:
      l = paramLong1;
    }
  }
  
  private void a(d paramd, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22910);
    ab.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(paramInt2) });
    h.qsU.idkeyStat(466L, 31L, 1L, false);
    com.tencent.mm.plugin.backup.h.d.aUK().aUN();
    this.oSS.oSA = this;
    paramString = c.Ue(paramString);
    ab.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString.size()) });
    if (paramString.size() == 0)
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
      cancel();
      paramLong1 = bo.hl(this.oST);
      h.qsU.idkeyStat(466L, 32L, 1L, false);
      h.qsU.idkeyStat(466L, 36L, 0L, false);
      h.qsU.idkeyStat(466L, 38L, paramLong1, false);
      h.qsU.idkeyStat(466L, 42L, 0L, false);
      h.qsU.idkeyStat(466L, 43L, 0L, false);
      b.k(paramLong1, paramInt2, 3);
      AppMethodBeat.o(22910);
      return;
    }
    this.oSS.a(paramd, paramString, paramLong1, paramLong2, paramInt1);
    AppMethodBeat.o(22910);
  }
  
  public static f jw(boolean paramBoolean)
  {
    AppMethodBeat.i(22906);
    if (oSR == null) {
      oSR = new f();
    }
    for (;;)
    {
      f localf = oSR;
      AppMethodBeat.o(22906);
      return localf;
      if (paramBoolean)
      {
        oSR.cancel();
        oSR = new f();
      }
    }
  }
  
  public final void a(d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(22911);
    ab.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramd.oSG), Long.valueOf(paramd.oSH), Long.valueOf(paramd.oSI) });
    if ((paramd.oSG <= 0L) && (paramd.oSH <= 0L) && (paramd.oSI <= 0L))
    {
      ab.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
      a(paramd, true);
      AppMethodBeat.o(22911);
      return;
    }
    f.2 local2 = new f.2(this, paramd, new f.1(this, paramd));
    String str = "MSG_SYNCHRONIZE_" + paramInt + "_" + bo.aoy();
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = local2;
    localg.field_mediaId = str;
    localg.field_fullpath = paramString;
    localg.field_fileType = a.MediaType_FILE;
    localg.field_talker = ((String)com.tencent.mm.plugin.backup.h.d.aUK().aUL().Ru().get(2, null));
    localg.field_priority = a.ecF;
    if (!com.tencent.mm.al.f.afO().e(localg))
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[] { str });
      Ug(paramd.action);
      b.a(0L, 0L, 0L, 0L, 1, this.czO, paramd.action);
    }
    AppMethodBeat.o(22911);
  }
  
  final void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(22913);
    ab.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = new f.3(this, paramd);
    aw.Rc().a(222, (com.tencent.mm.ai.f)localObject);
    localObject = "";
    if (paramd.action.equals(b.oSo)) {
      localObject = paramd.oSJ + "," + paramd.oSK;
    }
    if (paramBoolean) {}
    for (paramd = new e("", "NULL", 0, paramd.dZZ, paramd.action, (String)localObject);; paramd = new e(paramd.oSL, paramd.oSM, paramd.oSN, paramd.dZZ, paramd.action, (String)localObject))
    {
      aw.Rc().a(paramd, 0);
      AppMethodBeat.o(22913);
      return;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(22914);
    ab.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[] { an.dtg() });
    this.oSS.oSz = true;
    this.oSV = false;
    AppMethodBeat.o(22914);
  }
  
  public final void e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22907);
    ab.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(this.czO) });
    if (this.oSV)
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", new Object[] { paramString1 });
      AppMethodBeat.o(22907);
      return;
    }
    this.oSV = true;
    this.oST = bo.aoy();
    if (this.oSS != null) {
      this.oSS.oSz = true;
    }
    this.oSS = new c();
    d locald = new d(paramString1);
    locald.oSF = paramArrayOfByte;
    if (paramString1.equals(b.oSm))
    {
      a(locald, this.czO);
      AppMethodBeat.o(22907);
      return;
    }
    aw.aaz();
    if (!((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yEn, Boolean.FALSE)).booleanValue())
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
      cancel();
      AppMethodBeat.o(22907);
      return;
    }
    paramString2 = paramString2.split(",");
    if (paramString1.equals(b.oSn))
    {
      if (b.oSw <= 0)
      {
        ab.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(22907);
        return;
      }
      if (paramString2.length < 2)
      {
        ab.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(22907);
        return;
      }
      a(locald, com.tencent.mm.plugin.backup.b.g.Gl(paramString2[0]) * 1000L, com.tencent.mm.plugin.backup.b.g.Gl(paramString2[1]) * 1000L, this.czO);
      AppMethodBeat.o(22907);
      return;
    }
    if (paramString1.equals(b.oSo))
    {
      if (b.oSx <= 0)
      {
        ab.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        AppMethodBeat.o(22907);
        return;
      }
      if (paramString2.length < 5)
      {
        ab.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        AppMethodBeat.o(22907);
        return;
      }
      paramString1 = paramString2[0];
      long l1 = com.tencent.mm.plugin.backup.b.g.Gl(paramString2[1]);
      long l2 = com.tencent.mm.plugin.backup.b.g.Gl(paramString2[2]);
      locald.Uf(paramString2[3]);
      a(locald, paramString1, l1 * 1000L, l2 * 1000L, com.tencent.mm.plugin.backup.b.g.bE(paramString2[4], 0), this.czO);
    }
    AppMethodBeat.o(22907);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(22915);
    cancel();
    AppMethodBeat.o(22915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.q.f
 * JD-Core Version:    0.7.0.1
 */