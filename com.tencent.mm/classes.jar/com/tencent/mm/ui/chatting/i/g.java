package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.a.vp.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class g
  extends b
{
  int elr = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean pL(int paramInt)
  {
    AppMethodBeat.i(32632);
    if ((bo.apV("1001") == paramInt) || (bo.apV("1002") == paramInt) || (419430449 == paramInt))
    {
      AppMethodBeat.o(32632);
      return true;
    }
    AppMethodBeat.o(32632);
    return false;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(32638);
    parama = (g.b)parama;
    g.a locala = (g.a)PD(paramInt);
    if (bo.isNullOrNil(locala.desc)) {
      parama.gpM.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6);
      parama.ivs.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.ivs.setImageResource(locala.iconRes);
      parama.ivs.setBackgroundColor(locala.zPD);
      AppMethodBeat.o(32638);
      return;
      parama.gpM.setVisibility(0);
      parama.gpM.setText(bo.bf(locala.desc, ""));
    }
  }
  
  public final String apc()
  {
    AppMethodBeat.i(32634);
    String str = this.mContext.getString(2131302974);
    AppMethodBeat.o(32634);
    return str;
  }
  
  public final void dJQ()
  {
    AppMethodBeat.i(32633);
    this.zPc.dJU();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32627);
        LinkedList localLinkedList = new LinkedList();
        aw.aaz();
        Cursor localCursor = com.tencent.mm.model.c.YC().cN(g.this.ejr, g.this.elr);
        if (localCursor == null)
        {
          ab.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(32627);
          return;
        }
        u localu;
        label99:
        bi localbi;
        Object localObject3;
        Object localObject4;
        label342:
        int i;
        int j;
        label576:
        label630:
        label636:
        g.a locala;
        if (t.lA(g.this.ejr))
        {
          aw.aaz();
          localu = com.tencent.mm.model.c.YJ().oU(g.this.ejr);
          long l1 = 0L;
          for (;;)
          {
            try
            {
              if (!localCursor.moveToNext()) {
                break label1121;
              }
              localbi = new bi();
              localbi.convertFrom(localCursor);
              Object localObject1 = localbi.field_content;
              if (localObject1 == null) {
                break label1178;
              }
              localObject3 = j.b.ab((String)localObject1, localbi.field_reserved);
              if ((!g.pL(bo.apV(((j.b)localObject3).fig))) && (!g.pL(localbi.getType()))) {
                break label1178;
              }
              String str = g.b(localbi, t.lA(g.this.ejr));
              localObject4 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(str);
              localObject1 = "";
              if (localu != null) {
                localObject1 = localu.nE(str);
              }
              if (!g.pL(localbi.getType())) {
                break label701;
              }
              localObject1 = new g.a(g.this, localbi.field_createTime, localbi.getType(), ((j.b)localObject3).fhE, localbi.field_msgId, ((aq)localObject4).field_username, ((ad)localObject4).Oe(), ((aq)localObject4).field_conRemark, (String)localObject1);
              localObject4 = new vq();
              ((vq)localObject4).cMS.cyr = ((j.b)localObject3).fhG;
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
              if (localbi.field_isSend == 1)
              {
                bool = ((vq)localObject4).cMT.cMU;
                if (((vq)localObject4).cMT.status == -2) {
                  bool = false;
                }
                if (bool) {
                  break;
                }
                ab.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((vq)localObject4).cMT.cMU), Integer.valueOf(((vq)localObject4).cMT.status), Long.valueOf(localbi.field_msgId), g.this.zPd.in(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
                continue;
              }
              if (((vq)localObject4).cMT.cMU) {
                break label1187;
              }
            }
            finally
            {
              localCursor.close();
              AppMethodBeat.o(32627);
            }
            bool = true;
          }
          i = ((vq)localObject4).cMT.status;
          j = i;
          if (i <= 0) {
            j = ((j.b)localObject3).fhD;
          }
          localObject2.nickname = g.this.mContext.getResources().getString(2131304095, new Object[] { localObject2.nickname });
          switch (j)
          {
          case 2: 
            localObject2.zPD = i;
            localObject2.desc = g.a(g.this, g.this.mContext, localbi, (j.b)localObject3, bool, j);
            localObject4 = g.this.mContext;
            if (localObject3 != null)
            {
              if (localObject4 != null) {
                break label1245;
              }
              break label1200;
              localObject2.iconRes = i;
              localObject3 = new Date(localbi.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.dNj().b((Date)localObject3);
              if (l1 != l2) {
                localLinkedList.add(new c.c(localbi.field_createTime));
              }
              localLinkedList.add(localObject2);
              l1 = l2;
              break label1207;
              label701:
              locala = new g.a(g.this, localbi.field_createTime, localbi.getType(), ((j.b)localObject3).fib, localbi.field_msgId, ((aq)localObject4).field_username, ((ad)localObject4).Oe(), ((aq)localObject4).field_conRemark, localObject2);
              locala.zPC = bo.apV(((j.b)localObject3).fig);
              if (locala.zPC == bo.apV("1001"))
              {
                locala.nickname = g.this.mContext.getResources().getString(2131304093, new Object[] { locala.nickname });
                if (localbi.field_isSend != 1) {
                  break label1330;
                }
                bool = true;
                label823:
                locala.desc = f.b((j.b)localObject3, bool);
                if (localbi.field_isSend != 1) {
                  break label1336;
                }
                bool = true;
                label847:
                locala.zPD = f.d((j.b)localObject3, bool);
                if (localbi.field_isSend != 1) {
                  break label1342;
                }
              }
            }
            break;
          }
        }
        label1178:
        label1187:
        label1200:
        label1207:
        label1336:
        label1342:
        for (boolean bool = true;; bool = false)
        {
          locala.iconRes = f.a((j.b)localObject3, bool);
          break label636;
          localObject4 = new vp();
          ((vp)localObject4).cMM.cMO = ((j.b)localObject3).fih;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
          locala.nickname = g.this.mContext.getResources().getString(2131304094, new Object[] { locala.nickname });
          i = ((vp)localObject4).cMN.cMP;
          j = ((vp)localObject4).cMN.cMQ;
          int k = ((vp)localObject4).cMN.cMR;
          if (localbi.field_isSend == 1)
          {
            bool = true;
            label989:
            locala.desc = f.a(i, j, k, bool, t.lA(g.this.ejr));
            localObject3 = (com.tencent.mm.af.c)((j.b)localObject3).R(com.tencent.mm.af.c.class);
            i = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.af.c)localObject3).ffV, "drawable", ah.getPackageName());
            j = ((vp)localObject4).cMN.cMQ;
            k = ((vp)localObject4).cMN.cMR;
            if (localbi.field_isSend != 1) {
              break label1115;
            }
          }
          label1115:
          for (bool = true;; bool = false)
          {
            locala.iconRes = f.v(j, k, bool);
            if (locala.iconRes <= 0) {
              locala.iconRes = i;
            }
            break;
            bool = false;
            break label989;
          }
          label1121:
          localCursor.close();
          g.this.iVH.addAll(localLinkedList);
          g.this.zPe = g.this.iVH;
          localLinkedList.clear();
          al.d(new g.1.1(this));
          AppMethodBeat.o(32627);
          return;
          break label1207;
          localu = null;
          break;
          bool = false;
          break label342;
          i = -352966;
          break label576;
          i = 2131231059;
          break label630;
          break label99;
          i = -352966;
          break label576;
          i = -470621;
          break label576;
          i = -470621;
          break label576;
          i = -470621;
          break label576;
          i = -470621;
          break label576;
          switch (j)
          {
          case 2: 
          default: 
            i = 2131231059;
            break;
          case 1: 
          case 7: 
            i = 2131231059;
            break;
          case 3: 
            i = 2131231060;
            break;
          case 4: 
            i = 2131231061;
            break;
          case 5: 
            i = 2131231060;
            break;
          case 6: 
            label1245:
            i = 2131231058;
            break;
            bool = false;
            break label823;
            bool = false;
            break label847;
          }
        }
      }
    });
    AppMethodBeat.o(32633);
  }
  
  public final c.e dJR()
  {
    AppMethodBeat.i(32636);
    g.2 local2 = new g.2(this);
    AppMethodBeat.o(32636);
    return local2;
  }
  
  public final String dJT()
  {
    AppMethodBeat.i(32635);
    String str = this.mContext.getString(2131302974);
    AppMethodBeat.o(32635);
    return str;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final RecyclerView.v v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(32637);
    paramViewGroup = new g.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969580, paramViewGroup, false));
    AppMethodBeat.o(32637);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.g
 * JD-Core Version:    0.7.0.1
 */