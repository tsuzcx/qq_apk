package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AllRemindMsgUI$a$1
  implements Runnable
{
  AllRemindMsgUI$a$1(AllRemindMsgUI.a parama, m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(29115);
    Object localObject1 = ((aph)((p)this.ckS).fBd.fsW.fta).xfm;
    LinkedList localLinkedList = new LinkedList();
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (btj)localIterator.next();
        AllRemindMsgUI.d locald = new AllRemindMsgUI.d(this.yTE.yTD);
        locald.yTK = ((btj)localObject1);
        locald.timestamp = (((btj)localObject1).lGW * 1000L);
        locald.subType = ((btj)localObject1).xCa;
        locald.yTL = ((btj)localObject1).xGT;
        Object localObject3;
        if (((btj)localObject1).xCa == 1) {
          localObject3 = new bfk();
        }
        for (;;)
        {
          try
          {
            ((bfk)localObject3).parseFrom(((btj)localObject1).wPb.pW);
            locald.title = ((bfk)localObject3).Title;
            locald.username = ((bfk)localObject3).jJA;
            locald.cpO = ((bfk)localObject3).pIG;
            if (locald.username != null)
            {
              if (!t.lA(locald.username)) {
                continue;
              }
              localObject1 = ((j)g.E(j.class)).YA().arw(locald.username);
              if (localObject1 != null)
              {
                if (((ad)localObject1).Of() == null)
                {
                  localObject1 = ((ad)localObject1).Oe();
                  locald.nickname = ((String)localObject1);
                }
              }
              else
              {
                if (!bo.isNullOrNil(locald.nickname)) {
                  continue;
                }
                localObject1 = this.yTE.yTD.getString(2131298302);
                locald.nickname = ((String)localObject1);
              }
            }
            else
            {
              ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", new Object[] { locald });
              localLinkedList.add(locald);
            }
          }
          catch (IOException localIOException1)
          {
            ab.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException1.toString() });
            continue;
            localObject2 = localIOException1.Of();
            continue;
            localObject2 = locald.nickname;
            continue;
            localObject2 = ((j)g.E(j.class)).YA().arw(locald.username);
            if (((ad)localObject2).Of() != null) {}
          }
          for (Object localObject2 = ((ad)localObject2).Oe();; localObject2 = ((ad)localObject2).Of())
          {
            locald.nickname = ((String)localObject2);
            break;
          }
          if (((btj)localObject2).xCa == 2)
          {
            localObject3 = new acr();
            try
            {
              ((acr)localObject3).parseFrom(((btj)localObject2).wPb.pW);
              locald.title = ((acr)localObject3).Title;
              locald.cpG = ((acr)localObject3).woH;
              locald.wUy = ((acr)localObject3).woI;
            }
            catch (IOException localIOException2)
            {
              for (;;)
              {
                ab.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException2.toString() });
              }
            }
          }
        }
      }
      AllRemindMsgUI.a(this.yTE.yTD, localLinkedList);
    }
    al.d(new AllRemindMsgUI.a.1.1(this));
    AppMethodBeat.o(29115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */