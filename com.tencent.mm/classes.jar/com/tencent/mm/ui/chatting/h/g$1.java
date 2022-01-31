package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.tt;
import com.tencent.mm.h.a.tt.b;
import com.tencent.mm.h.a.tu;
import com.tencent.mm.h.a.tu.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.a.c.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

final class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public final void run()
  {
    LinkedList localLinkedList = new LinkedList();
    au.Hx();
    Cursor localCursor = com.tencent.mm.model.c.Fy().bW(this.vzd.drJ, this.vzd.hkM);
    if (localCursor == null)
    {
      y.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
      return;
    }
    u localu;
    label87:
    bi localbi;
    Object localObject3;
    Object localObject4;
    label330:
    int i;
    int j;
    label556:
    label617:
    g.a locala;
    if (s.fn(this.vzd.drJ))
    {
      au.Hx();
      localu = com.tencent.mm.model.c.FF().in(this.vzd.drJ);
      long l1 = 0L;
      for (;;)
      {
        try
        {
          if (!localCursor.moveToNext()) {
            break label1126;
          }
          localbi = new bi();
          localbi.d(localCursor);
          Object localObject1 = localbi.field_content;
          if (localObject1 == null) {
            break label1177;
          }
          localObject3 = com.tencent.mm.ae.g.a.M((String)localObject1, localbi.field_reserved);
          if ((!g.mv(bk.ZR(((com.tencent.mm.ae.g.a)localObject3).dSh))) && (!g.mv(localbi.getType()))) {
            break label1177;
          }
          String str = g.j(localbi, s.fn(this.vzd.drJ));
          localObject4 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(str);
          localObject1 = "";
          if (localu != null) {
            localObject1 = localu.gV(str);
          }
          if (!g.mv(localbi.getType())) {
            break label724;
          }
          localObject1 = new g.a(this.vzd, localbi.field_createTime, localbi.getType(), ((com.tencent.mm.ae.g.a)localObject3).dRF, localbi.field_msgId, ((ao)localObject4).field_username, ((ad)localObject4).Bp(), ((ao)localObject4).field_conRemark, (String)localObject1);
          localObject4 = new tu();
          ((tu)localObject4).cee.bQR = ((com.tencent.mm.ae.g.a)localObject3).dRH;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject4);
          if (localbi.field_isSend == 1)
          {
            bool = ((tu)localObject4).cef.ceg;
            if (((tu)localObject4).cef.status == -2) {
              bool = false;
            }
            if (bool) {
              break;
            }
            y.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((tu)localObject4).cef.ceg), Integer.valueOf(((tu)localObject4).cef.status), Long.valueOf(localbi.field_msgId), this.vzd.vyE.eL(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
            continue;
          }
          if (((tu)localObject4).cef.ceg) {
            break label1186;
          }
        }
        finally
        {
          localCursor.close();
        }
        bool = true;
      }
      i = ((tu)localObject4).cef.status;
      j = i;
      if (i <= 0) {
        j = ((com.tencent.mm.ae.g.a)localObject3).dRE;
      }
      localObject2.nickname = this.vzd.mContext.getResources().getString(R.l.startup_remittance, new Object[] { localObject2.nickname });
      switch (j)
      {
      case 2: 
        localObject2.vzg = i;
        localObject2.desc = g.a(this.vzd, this.vzd.mContext, localbi, (com.tencent.mm.ae.g.a)localObject3, bool, j);
        localObject4 = this.vzd.mContext;
        if ((localObject3 == null) || (localObject4 == null))
        {
          i = R.k.c2c_remittance_icon;
          for (;;)
          {
            localObject2.iconRes = i;
            localObject3 = new Date(localbi.field_createTime);
            long l2 = com.tencent.mm.ui.gridviewheaders.a.cIz().b((Date)localObject3);
            if (l1 != l2) {
              localLinkedList.add(new c.c(localbi.field_createTime));
            }
            localLinkedList.add(localObject2);
            l1 = l2;
            break;
            label682:
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
          label724:
          locala = new g.a(this.vzd, localbi.field_createTime, localbi.getType(), ((com.tencent.mm.ae.g.a)localObject3).dSc, localbi.field_msgId, ((ao)localObject4).field_username, ((ad)localObject4).Bp(), ((ao)localObject4).field_conRemark, localObject2);
          locala.vzf = bk.ZR(((com.tencent.mm.ae.g.a)localObject3).dSh);
          if (locala.vzf == bk.ZR("1001"))
          {
            locala.nickname = this.vzd.mContext.getResources().getString(R.l.startup_aa, new Object[] { locala.nickname });
            if (localbi.field_isSend != 1) {
              break label1283;
            }
            bool = true;
            label846:
            locala.desc = com.tencent.mm.ui.chatting.g.b((com.tencent.mm.ae.g.a)localObject3, bool);
            if (localbi.field_isSend != 1) {
              break label1289;
            }
            bool = true;
            label870:
            locala.vzg = com.tencent.mm.ui.chatting.g.d((com.tencent.mm.ae.g.a)localObject3, bool);
            if (localbi.field_isSend != 1) {
              break label1295;
            }
          }
        }
        break;
      }
    }
    label1283:
    label1289:
    label1295:
    for (boolean bool = true;; bool = false)
    {
      locala.iconRes = com.tencent.mm.ui.chatting.g.a((com.tencent.mm.ae.g.a)localObject3, bool);
      break label617;
      localObject4 = new tt();
      ((tt)localObject4).cdZ.ceb = ((com.tencent.mm.ae.g.a)localObject3).dSi;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject4);
      locala.nickname = this.vzd.mContext.getResources().getString(R.l.startup_c2c, new Object[] { locala.nickname });
      i = ((tt)localObject4).cea.cec;
      j = ((tt)localObject4).cea.ced;
      label1003:
      int k;
      if (localbi.field_isSend == 1)
      {
        bool = true;
        locala.desc = com.tencent.mm.ui.chatting.g.a(i, j, bool, (com.tencent.mm.ae.g.a)localObject3);
        localObject3 = (com.tencent.mm.ae.c)((com.tencent.mm.ae.g.a)localObject3).A(com.tencent.mm.ae.c.class);
        i = this.vzd.mContext.getResources().getIdentifier(((com.tencent.mm.ae.c)localObject3).dQn, "drawable", ae.getPackageName());
        j = ((tt)localObject4).cea.cec;
        k = ((tt)localObject4).cea.ced;
        if (localbi.field_isSend != 1) {
          break label1120;
        }
      }
      label1120:
      for (bool = true;; bool = false)
      {
        locala.iconRes = com.tencent.mm.ui.chatting.g.t(j, k, bool);
        if (locala.iconRes <= 0) {
          locala.iconRes = i;
        }
        break;
        bool = false;
        break label1003;
      }
      label1126:
      localCursor.close();
      this.vzd.hka.addAll(localLinkedList);
      this.vzd.vyF = this.vzd.hka;
      localLinkedList.clear();
      ai.d(new g.1.1(this));
      return;
      label1177:
      break label1199;
      localu = null;
      break;
      label1186:
      bool = false;
      break label330;
      i = -352966;
      break label556;
      label1199:
      break label87;
      i = -352966;
      break label556;
      i = -470621;
      break label556;
      i = -470621;
      break label556;
      i = -470621;
      break label556;
      i = -470621;
      break label556;
      switch (j)
      {
      }
      break label682;
      bool = false;
      break label846;
      bool = false;
      break label870;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.g.1
 * JD-Core Version:    0.7.0.1
 */