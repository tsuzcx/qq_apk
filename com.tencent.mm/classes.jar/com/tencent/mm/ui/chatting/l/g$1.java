package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.abm;
import com.tencent.mm.f.a.abm.b;
import com.tencent.mm.f.a.abn;
import com.tencent.mm.f.a.abn.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

final class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(36567);
    LinkedList localLinkedList = new LinkedList();
    bh.beI();
    Cursor localCursor = com.tencent.mm.model.c.bbO().fj(this.WZz.jkq, this.WZz.jmu);
    if (localCursor == null)
    {
      Log.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
      AppMethodBeat.o(36567);
      return;
    }
    ah localah;
    label97:
    ca localca;
    Object localObject3;
    Object localObject4;
    label340:
    int i;
    int j;
    label572:
    label633:
    g.a locala;
    if (ab.Lj(this.WZz.jkq))
    {
      bh.beI();
      localah = com.tencent.mm.model.c.bbV().Rw(this.WZz.jkq);
      long l1 = 0L;
      for (;;)
      {
        try
        {
          if (!localCursor.moveToNext()) {
            break label1170;
          }
          localca = new ca();
          localca.convertFrom(localCursor);
          Object localObject1 = localca.field_content;
          if (localObject1 == null) {
            break label1226;
          }
          localObject3 = k.b.aG((String)localObject1, localca.field_reserved);
          if ((!g.Df(Util.safeParseInt(((k.b)localObject3).lnG))) && (!g.Df(localca.getType()))) {
            break label1226;
          }
          String str = g.b(localca, ab.Lj(this.WZz.jkq));
          localObject4 = ((n)h.ae(n.class)).bbL().RG(str);
          localObject1 = "";
          if (localah != null) {
            localObject1 = localah.PJ(str);
          }
          if (!g.Df(localca.getType())) {
            break label740;
          }
          localObject1 = new g.a(this.WZz, localca.field_createTime, localca.getType(), ((k.b)localObject3).lnd, localca.field_msgId, ((ax)localObject4).field_username, ((as)localObject4).ayr(), ((ax)localObject4).field_conRemark, (String)localObject1);
          localObject4 = new abn();
          ((abn)localObject4).gbr.fJG = ((k.b)localObject3).lnf;
          EventCenter.instance.publish((IEvent)localObject4);
          if (localca.field_isSend == 1)
          {
            bool = ((abn)localObject4).gbs.gbt;
            if (((abn)localObject4).gbs.status == -2) {
              bool = false;
            }
            if (bool) {
              break;
            }
            Log.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((abn)localObject4).gbs.gbt), Integer.valueOf(((abn)localObject4).gbs.status), Long.valueOf(localca.field_msgId), this.WZz.WZa.Il(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
            continue;
          }
          if (((abn)localObject4).gbs.gbt) {
            break label1235;
          }
        }
        finally
        {
          localCursor.close();
          AppMethodBeat.o(36567);
        }
        bool = true;
      }
      i = ((abn)localObject4).gbs.status;
      j = i;
      if (i <= 0) {
        j = ((k.b)localObject3).lnc;
      }
      localObject2.nickname = this.WZz.mContext.getResources().getString(R.l.eTG, new Object[] { localObject2.nickname });
      switch (j)
      {
      case 2: 
        localObject2.rqS = i;
        localObject2.desc = g.a(this.WZz, this.WZz.mContext, localca, (k.b)localObject3, bool, j);
        localObject4 = this.WZz.mContext;
        if ((localObject3 == null) || (localObject4 == null))
        {
          i = R.k.c2c_remittance_icon;
          for (;;)
          {
            localObject2.iconRes = i;
            localObject3 = new Date(localca.field_createTime);
            long l2 = a.hWZ().b((Date)localObject3);
            if (l1 != l2) {
              localLinkedList.add(new c.c(localca.field_createTime));
            }
            localLinkedList.add(localObject2);
            l1 = l2;
            break;
            label698:
            i = R.k.c2c_remittance_icon;
            continue;
            i = R.k.c2c_remittance_icon;
            continue;
            i = R.k.c2c_remittance_received_icon;
            continue;
            i = R.k.c2c_remittance_rejected_icon;
            continue;
            i = R.k.c2c_remittance_received_icon;
            continue;
            i = R.k.c2c_remittance_cancle_icon;
          }
          label740:
          locala = new g.a(this.WZz, localca.field_createTime, localca.getType(), ((k.b)localObject3).lnB, localca.field_msgId, ((ax)localObject4).field_username, ((as)localObject4).ayr(), ((ax)localObject4).field_conRemark, localObject2);
          locala.fcB = Util.safeParseInt(((k.b)localObject3).lnG);
          if (locala.fcB == Util.safeParseInt("1001"))
          {
            locala.nickname = this.WZz.mContext.getResources().getString(R.l.eTE, new Object[] { locala.nickname });
            if (localca.field_isSend != 1) {
              break label1331;
            }
            bool = true;
            label862:
            locala.desc = f.a((k.b)localObject3, bool);
            if (localca.field_isSend != 1) {
              break label1337;
            }
            bool = true;
            label886:
            locala.rqS = f.d((k.b)localObject3, bool);
            if (localca.field_isSend != 1) {
              break label1343;
            }
          }
        }
        break;
      }
    }
    label1028:
    label1164:
    label1170:
    label1331:
    label1337:
    label1343:
    for (boolean bool = true;; bool = false)
    {
      locala.iconRes = f.b((k.b)localObject3, bool);
      break label633;
      localObject4 = new abm();
      ((abm)localObject4).gbl.gbn = ((k.b)localObject3).lnH;
      EventCenter.instance.publish((IEvent)localObject4);
      locala.nickname = this.WZz.mContext.getResources().getString(R.l.eTF, new Object[] { locala.nickname });
      i = ((abm)localObject4).gbm.gbo;
      j = ((abm)localObject4).gbm.gbp;
      int k = ((abm)localObject4).gbm.gbq;
      if (localca.field_isSend == 1)
      {
        bool = true;
        locala.desc = f.a(i, j, k, bool, ab.Lj(this.WZz.jkq), this.WZz.jkq, (k.b)localObject3, null);
        localObject3 = (com.tencent.mm.aj.c)((k.b)localObject3).ar(com.tencent.mm.aj.c.class);
        i = this.WZz.mContext.getResources().getIdentifier(((com.tencent.mm.aj.c)localObject3).llb, "drawable", MMApplicationContext.getPackageName());
        j = ((abm)localObject4).gbm.gbp;
        k = ((abm)localObject4).gbm.gbq;
        if (localca.field_isSend != 1) {
          break label1164;
        }
      }
      for (bool = true;; bool = false)
      {
        locala.iconRes = f.Q(j, k, bool);
        if (locala.iconRes <= 0) {
          locala.iconRes = i;
        }
        break;
        bool = false;
        break label1028;
      }
      localCursor.close();
      this.WZz.mDataList.addAll(localLinkedList);
      this.WZz.WZb = this.WZz.mDataList;
      localLinkedList.clear();
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36566);
          if (g.1.this.WZz.WYZ != null) {
            g.1.this.WZz.WYZ.H(g.1.this.tNh, g.1.this.WZz.mDataList.size());
          }
          AppMethodBeat.o(36566);
        }
      });
      AppMethodBeat.o(36567);
      return;
      label1226:
      break label1248;
      localah = null;
      break;
      label1235:
      bool = false;
      break label340;
      i = -352966;
      break label572;
      label1248:
      break label97;
      i = -352966;
      break label572;
      i = -470621;
      break label572;
      i = -470621;
      break label572;
      i = -470621;
      break label572;
      i = -470621;
      break label572;
      switch (j)
      {
      }
      break label698;
      bool = false;
      break label862;
      bool = false;
      break label886;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.g.1
 * JD-Core Version:    0.7.0.1
 */