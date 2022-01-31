package com.tencent.mm.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    Object localObject1 = ((ajw)((n)this.bEe).esv.ecF.ecN).tgE;
    LinkedList localLinkedList = new LinkedList();
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (bkj)localIterator.next();
        AllRemindMsgUI.d locald = new AllRemindMsgUI.d(this.uGC.uGB);
        locald.uGI = ((bkj)localObject1);
        locald.timestamp = (((bkj)localObject1).jxx * 1000L);
        locald.brC = ((bkj)localObject1).tAu;
        locald.uGJ = ((bkj)localObject1).tEd;
        Object localObject3;
        if (((bkj)localObject1).tAu == 1) {
          localObject3 = new ayn();
        }
        for (;;)
        {
          try
          {
            ((ayn)localObject3).aH(((bkj)localObject1).sQA.oY);
            locald.title = ((ayn)localObject3).bGw;
            locald.username = ((ayn)localObject3).hPY;
            locald.bIt = ((ayn)localObject3).ndp;
            if (locald.username != null)
            {
              if (!s.fn(locald.username)) {
                continue;
              }
              localObject1 = ((j)g.r(j.class)).Fw().abl(locald.username);
              if (localObject1 != null)
              {
                if (((ad)localObject1).Bq() == null)
                {
                  localObject1 = ((ad)localObject1).Bp();
                  locald.nickname = ((String)localObject1);
                }
              }
              else
              {
                if (!bk.bl(locald.nickname)) {
                  continue;
                }
                localObject1 = this.uGC.uGB.getString(R.l.chatting_roominfo_noname);
                locald.nickname = ((String)localObject1);
              }
            }
            else
            {
              y.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", new Object[] { locald });
              localLinkedList.add(locald);
            }
          }
          catch (IOException localIOException1)
          {
            y.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException1.toString() });
            continue;
            localObject2 = localIOException1.Bq();
            continue;
            localObject2 = locald.nickname;
            continue;
            localObject2 = ((j)g.r(j.class)).Fw().abl(locald.username);
            if (((ad)localObject2).Bq() != null) {}
          }
          for (Object localObject2 = ((ad)localObject2).Bp();; localObject2 = ((ad)localObject2).Bq())
          {
            locald.nickname = ((String)localObject2);
            break;
          }
          if (((bkj)localObject2).tAu == 2)
          {
            localObject3 = new yk();
            try
            {
              ((yk)localObject3).aH(((bkj)localObject2).sQA.oY);
              locald.title = ((yk)localObject3).bGw;
              locald.bIl = ((yk)localObject3).svA;
              locald.sWz = ((yk)localObject3).svB;
            }
            catch (IOException localIOException2)
            {
              for (;;)
              {
                y.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException2.toString() });
              }
            }
          }
        }
      }
      AllRemindMsgUI.a(this.uGC.uGB, localLinkedList);
    }
    ai.d(new AllRemindMsgUI.a.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */