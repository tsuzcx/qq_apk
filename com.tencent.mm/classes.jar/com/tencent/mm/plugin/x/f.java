package com.tencent.mm.plugin.x;

import com.tencent.mm.ah.p;
import com.tencent.mm.j.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class f
  implements a.a
{
  private static f mtg;
  public int bSn;
  private c mth;
  long mti;
  boolean mtj = false;
  boolean mtk = false;
  
  static void Ir(String paramString)
  {
    if (paramString.equals(b.msB)) {
      h.nFQ.a(466L, 2L, 1L, false);
    }
    do
    {
      return;
      if (paramString.equals(b.msC))
      {
        h.nFQ.a(466L, 17L, 1L, false);
        return;
      }
    } while (!paramString.equals(b.msD));
    h.nFQ.a(466L, 33L, 1L, false);
  }
  
  public static f hD(boolean paramBoolean)
  {
    if (mtg == null) {
      mtg = new f();
    }
    for (;;)
    {
      return mtg;
      if (paramBoolean)
      {
        mtg.cancel();
        mtg = new f();
      }
    }
  }
  
  public final void a(d paramd, String paramString, int paramInt)
  {
    y.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramd.msV), Long.valueOf(paramd.msW), Long.valueOf(paramd.msX) });
    if ((paramd.msV <= 0L) && (paramd.msW <= 0L) && (paramd.msX <= 0L))
    {
      y.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
      a(paramd, true);
    }
    String str;
    com.tencent.mm.j.f localf;
    do
    {
      return;
      f.2 local2 = new f.2(this, paramd, new f.1(this, paramd));
      str = "MSG_SYNCHRONIZE_" + paramInt + "_" + bk.UY();
      localf = new com.tencent.mm.j.f();
      localf.dlP = local2;
      localf.field_mediaId = str;
      localf.field_fullpath = paramString;
      localf.field_fileType = a.MediaType_FILE;
      localf.field_talker = ((String)com.tencent.mm.plugin.backup.h.d.avi().avj().Dz().get(2, null));
      localf.field_priority = a.dlk;
    } while (com.tencent.mm.ak.f.Nd().c(localf));
    y.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[] { str });
    Ir(paramd.action);
    b.a(0L, 0L, 0L, 0L, 1, this.bSn, paramd.action);
  }
  
  final void a(d paramd, boolean paramBoolean)
  {
    y.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = new f.3(this, paramd);
    au.Dk().a(222, (com.tencent.mm.ah.f)localObject);
    localObject = "";
    if (paramd.action.equals(b.msD)) {
      localObject = paramd.msY + "," + paramd.msZ;
    }
    if (paramBoolean) {}
    for (paramd = new e("", "NULL", 0, paramd.diG, paramd.action, (String)localObject);; paramd = new e(paramd.mta, paramd.mtb, paramd.mtc, paramd.diG, paramd.action, (String)localObject))
    {
      au.Dk().a(paramd, 0);
      return;
    }
  }
  
  public final void cancel()
  {
    y.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[] { ak.cri() });
    this.mth.msO = true;
    this.mtk = false;
  }
  
  public final void e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(this.bSn) });
    if (this.mtk)
    {
      y.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", new Object[] { paramString1 });
      return;
    }
    this.mtk = true;
    this.mti = bk.UY();
    if (this.mth != null) {
      this.mth.msO = true;
    }
    this.mth = new c();
    d locald = new d(paramString1);
    locald.msU = paramArrayOfByte;
    int i;
    long l1;
    if (paramString1.equals(b.msB))
    {
      i = this.bSn;
      y.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(i) });
      h.nFQ.a(466L, 0L, 1L, false);
      com.tencent.mm.plugin.backup.h.d.avi().avl();
      this.mth.msP = this;
      paramString1 = this.mth.bkw();
      y.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString1.size()) });
      if (paramString1.size() == 0)
      {
        y.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
        cancel();
        l1 = bk.co(this.mti);
        h.nFQ.a(466L, 1L, 1L, false);
        h.nFQ.a(466L, 5L, 0L, false);
        h.nFQ.a(466L, 7L, l1, false);
        h.nFQ.a(466L, 11L, 0L, false);
        h.nFQ.a(466L, 12L, 0L, false);
        b.h(l1, i, 1);
        return;
      }
      if (b.msK < 0) {}
      for (l1 = b.msK;; l1 = bk.co(b.msK * 24 * 60 * 60 * 1000))
      {
        this.mth.a(locald, paramString1, l1, System.currentTimeMillis(), b.msI);
        return;
      }
    }
    au.Hx();
    if (!((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uuk, Boolean.valueOf(false))).booleanValue())
    {
      y.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
      cancel();
      return;
    }
    paramString2 = paramString2.split(",");
    long l3;
    long l2;
    if (paramString1.equals(b.msC))
    {
      if (b.msL <= 0)
      {
        y.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
        cancel();
        return;
      }
      if (paramString2.length < 2)
      {
        y.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
        cancel();
        return;
      }
      l3 = com.tencent.mm.plugin.backup.b.g.xs(paramString2[0]) * 1000L;
      l2 = com.tencent.mm.plugin.backup.b.g.xs(paramString2[1]) * 1000L;
      i = this.bSn;
      y.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(i) });
      h.nFQ.a(466L, 15L, 1L, false);
      com.tencent.mm.plugin.backup.h.d.avi().avl();
      this.mth.msP = this;
      paramString1 = this.mth.bkw();
      y.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString1.size()) });
      if (paramString1.size() == 0)
      {
        y.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
        cancel();
        l1 = bk.co(this.mti);
        h.nFQ.a(466L, 16L, 1L, false);
        h.nFQ.a(466L, 20L, 0L, false);
        h.nFQ.a(466L, 22L, l1, false);
        h.nFQ.a(466L, 26L, 0L, false);
        h.nFQ.a(466L, 27L, 0L, false);
        b.h(l1, i, 2);
        return;
      }
      if (b.msK < 0)
      {
        l1 = b.msK;
        label697:
        if (l3 >= l1) {
          break label1198;
        }
      }
    }
    for (;;)
    {
      if (l2 == 0L) {
        l2 = System.currentTimeMillis();
      }
      for (;;)
      {
        if (l1 > l2)
        {
          y.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          a(locald, true);
          return;
          l1 = bk.co(b.msK * 24 * 60 * 60 * 1000);
          break label697;
        }
        this.mth.a(locald, paramString1, l1, l2, b.msI);
        return;
        if (!paramString1.equals(b.msD)) {
          break;
        }
        if (b.msM <= 0)
        {
          y.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
          cancel();
          return;
        }
        if (paramString2.length < 5)
        {
          y.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", new Object[] { paramString1, paramString2 });
          cancel();
          return;
        }
        paramString1 = paramString2[0];
        l1 = com.tencent.mm.plugin.backup.b.g.xs(paramString2[1]);
        l2 = com.tencent.mm.plugin.backup.b.g.xs(paramString2[2]);
        locald.msY = new String(paramString2[3]);
        i = com.tencent.mm.plugin.backup.b.g.be(paramString2[4], 0);
        int j = this.bSn;
        y.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", new Object[] { Integer.valueOf(j) });
        h.nFQ.a(466L, 31L, 1L, false);
        com.tencent.mm.plugin.backup.h.d.avi().avl();
        this.mth.msP = this;
        paramString2 = new LinkedList();
        if (bk.bl(paramString1)) {}
        for (;;)
        {
          y.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", new Object[] { Integer.valueOf(paramString2.size()) });
          if (paramString2.size() != 0) {
            break;
          }
          y.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
          cancel();
          l1 = bk.co(this.mti);
          h.nFQ.a(466L, 32L, 1L, false);
          h.nFQ.a(466L, 36L, 0L, false);
          h.nFQ.a(466L, 38L, l1, false);
          h.nFQ.a(466L, 42L, 0L, false);
          h.nFQ.a(466L, 43L, 0L, false);
          b.h(l1, j, 3);
          return;
          int k = com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().HP(paramString1);
          y.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", new Object[] { paramString1, Integer.valueOf(k) });
          if (k > 0) {
            paramString2.add(new c.a(paramString1));
          }
        }
        this.mth.a(locald, paramString2, l1 * 1000L, l2 * 1000L, i);
        return;
      }
      label1198:
      l1 = l3;
    }
  }
  
  public final void onCancel()
  {
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.x.f
 * JD-Core Version:    0.7.0.1
 */