package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class q$b
  implements com.tencent.mm.ai.f, t.a, Runnable
{
  private boolean bVC;
  private int i;
  HashMap<Long, Boolean> pYM;
  HashMap<Long, String> pYS;
  private com.tencent.mm.plugin.record.a.j pYr;
  
  public q$b(q paramq, com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(135727);
    this.i = 0;
    this.pYM = new HashMap();
    this.pYS = new HashMap();
    this.bVC = false;
    this.pYr = paramj;
    com.tencent.mm.modelvideo.o.alE().a(this, Looper.getMainLooper());
    com.tencent.mm.kernel.g.RK().eHt.a(221, this);
    AppMethodBeat.o(135727);
  }
  
  private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(135732);
    if ((n(paramHashMap)) && (paramBoolean))
    {
      com.tencent.mm.modelvideo.o.alE().a(this);
      paramj.field_type = 2;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().update(paramj, new String[] { "localId" });
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramj);
    }
    AppMethodBeat.o(135732);
  }
  
  private void af(bi parambi)
  {
    AppMethodBeat.i(135731);
    Object localObject = j.b.mY(parambi.field_content);
    if (localObject == null)
    {
      ab.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { parambi.field_content });
      AppMethodBeat.o(135731);
      return;
    }
    if ((bo.isNullOrNil(((j.b)localObject).cmN)) && (!bo.isNullOrNil(((j.b)localObject).fgL)))
    {
      ab.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { parambi.field_content });
      ((j.b)localObject).cmN = ((j.b)localObject).fgL.hashCode();
    }
    localObject = ((j.b)localObject).cmN;
    if (!a.a(parambi, a.q((String)localObject, parambi.field_msgId)))
    {
      this.pYM.put(Long.valueOf(parambi.field_msgId), Boolean.FALSE);
      this.pYS.put(Long.valueOf(parambi.field_msgId), localObject);
      a.af(parambi);
    }
    AppMethodBeat.o(135731);
  }
  
  private static boolean n(HashMap<Long, Boolean> paramHashMap)
  {
    AppMethodBeat.i(135733);
    if (paramHashMap == null)
    {
      AppMethodBeat.o(135733);
      return true;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext()) {
      if (!((Boolean)((Map.Entry)paramHashMap.next()).getValue()).booleanValue())
      {
        AppMethodBeat.o(135733);
        return false;
      }
    }
    AppMethodBeat.o(135733);
    return true;
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(135729);
    parama = u.vr(parama.fileName);
    if (parama != null)
    {
      bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(parama.fXy);
      if (parama.alS())
      {
        this.pYM.put(Long.valueOf(localbi.field_msgId), Boolean.TRUE);
        a(this.pYM, this.bVC, this.pYr);
      }
      AppMethodBeat.o(135729);
      return;
    }
    a(null, this.bVC, this.pYr);
    AppMethodBeat.o(135729);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(135730);
    if ((paramm instanceof e))
    {
      com.tencent.mm.kernel.g.RK().eHt.b(221, this);
      if (this.pYS != null) {
        paramm = this.pYS.entrySet().iterator();
      }
    }
    label291:
    label294:
    for (;;)
    {
      long l;
      com.tencent.mm.pluginsdk.model.app.b localb;
      if (paramm.hasNext())
      {
        paramString = (Map.Entry)paramm.next();
        l = ((Long)paramString.getKey()).longValue();
        paramString = (String)paramString.getValue();
        if ((l <= 0L) || (((Boolean)this.pYM.get(Long.valueOf(l))).booleanValue())) {
          continue;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(l);
        localb = a.q(paramString, l);
        if (localb == null) {
          break label291;
        }
      }
      for (paramString = localb.field_fileFullPath;; paramString = null)
      {
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label294;
        }
        this.pYM.put(Long.valueOf(l), Boolean.TRUE);
        paramString = this.pYr.field_dataProto.wVc.iterator();
        while (paramString.hasNext())
        {
          aca localaca = (aca)paramString.next();
          if (localaca.wTI == l) {
            localaca.anE(localb.field_fileFullPath);
          }
        }
        break;
        a(this.pYM, this.bVC, this.pYr);
        AppMethodBeat.o(135730);
        return;
        a(null, this.bVC, this.pYr);
        AppMethodBeat.o(135730);
        return;
      }
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(135728);
    this.i = 0;
    this.bVC = false;
    ab.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", new Object[] { Long.valueOf(this.pYr.field_msgId) });
    Iterator localIterator = this.pYr.field_dataProto.wVc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (aca)localIterator.next();
      long l = ((aca)localObject1).wTI;
      label387:
      if (l > 0L)
      {
        bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(l);
        Object localObject2 = ((aca)localObject1).wTa;
        if ((System.currentTimeMillis() - localbi.field_createTime > 259200000L) && ((bo.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.e.cN((String)localObject2)))) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label188;
          }
          ab.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localbi.getType()) });
          break;
        }
        label188:
        if (((aca)localObject1).dataType == 2)
        {
          if (localbi.dvX())
          {
            localObject2 = com.tencent.mm.at.o.ahC().gS(localbi.field_msgSvrId);
            if (localbi.field_isSend == 1) {
              if (((com.tencent.mm.at.e)localObject2).ahh()) {
                j = 1;
              }
            }
            for (;;)
            {
              if ((((com.tencent.mm.at.e)localObject2).offset >= ((com.tencent.mm.at.e)localObject2).fsd) && (((com.tencent.mm.at.e)localObject2).fsd != 0)) {
                break label387;
              }
              this.pYM.put(Long.valueOf(l), Boolean.FALSE);
              this.i = this.pYr.field_dataProto.wVc.indexOf(localObject1);
              com.tencent.mm.at.o.ahD().a(((com.tencent.mm.at.e)localObject2).fDL, localbi.field_msgId, j, localObject1, 2130838228, new q.b.1(this, (com.tencent.mm.at.e)localObject2, localbi, l));
              break;
              j = 0;
              continue;
              if (!((com.tencent.mm.at.e)localObject2).ahh())
              {
                j = 0;
              }
              else
              {
                com.tencent.mm.at.e locale = com.tencent.mm.at.f.a((com.tencent.mm.at.e)localObject2);
                if (!com.tencent.mm.vfs.e.cN(com.tencent.mm.at.o.ahC().q(locale.fDM, "", ""))) {
                  j = 0;
                } else {
                  j = 1;
                }
              }
            }
          }
          else if (localbi.dxV())
          {
            af(localbi);
          }
        }
        else if ((((aca)localObject1).dataType == 4) || (((aca)localObject1).dataType == 15))
        {
          localObject1 = u.vr(localbi.field_imgPath);
          if ((localObject1 != null) && (((s)localObject1).status != 199))
          {
            this.pYM.put(Long.valueOf(l), Boolean.FALSE);
            if (((s)localObject1).alR())
            {
              ab.i("MicroMsg.RecordMsgSendService", "start complete online video");
              u.vy(localbi.field_imgPath);
            }
            else
            {
              ab.i("MicroMsg.RecordMsgSendService", "start complete offline video");
              u.vn(localbi.field_imgPath);
            }
          }
        }
        else if ((((aca)localObject1).dataType == 8) && (!bo.isNullOrNil(((aca)localObject1).wTU)))
        {
          af(localbi);
        }
      }
    }
    this.bVC = true;
    this.pYR.pYu = false;
    a(this.pYM, this.bVC, this.pYr);
    AppMethodBeat.o(135728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q.b
 * JD-Core Version:    0.7.0.1
 */