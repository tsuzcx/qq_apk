package com.tencent.mm.ui.chatting.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.adj;
import com.tencent.mm.autogen.a.adj.b;
import com.tencent.mm.autogen.a.adk;
import com.tencent.mm.autogen.a.adk.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class g
  extends b
{
  int lPs = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean Dz(int paramInt)
  {
    AppMethodBeat.i(36572);
    if ((Util.safeParseInt("1001") == paramInt) || (Util.safeParseInt("1002") == paramInt) || (419430449 == paramInt))
    {
      AppMethodBeat.o(36572);
      return true;
    }
    AppMethodBeat.o(36572);
    return false;
  }
  
  private boolean juG()
  {
    AppMethodBeat.i(254323);
    if ((au.bwE(this.lMU)) || (au.bwF(this.lMU)))
    {
      AppMethodBeat.o(254323);
      return true;
    }
    AppMethodBeat.o(254323);
    return false;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36578);
    parama = (b)parama;
    a locala = (a)aCa(paramInt);
    if (Util.isNullOrNil(locala.desc)) {
      parama.plr.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 6);
      parama.ttT.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.ttT.setImageResource(locala.iconRes);
      parama.ttT.setBackgroundColor(locala.uBc);
      AppMethodBeat.o(36578);
      return;
      parama.plr.setVisibility(0);
      parama.plr.setText(Util.nullAs(locala.desc, ""));
    }
  }
  
  public final RecyclerView.v af(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254335);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gjT, paramViewGroup, false));
    AppMethodBeat.o(254335);
    return paramViewGroup;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(36574);
    String str = this.mContext.getString(R.l.search_chatroom_pay);
    AppMethodBeat.o(36574);
    return str;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void juR()
  {
    AppMethodBeat.i(36573);
    this.aeIz.juV();
    h.baF();
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36567);
        LinkedList localLinkedList = new LinkedList();
        bh.bCz();
        Cursor localCursor = com.tencent.mm.model.c.bzD().gc(g.this.lMU, g.this.lPs);
        if (localCursor == null)
        {
          Log.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36567);
          return;
        }
        aj localaj;
        label97:
        cc localcc;
        Object localObject3;
        Object localObject4;
        label337:
        int i;
        int j;
        label568:
        label629:
        g.a locala;
        if (au.bwE(g.this.lMU))
        {
          bh.bCz();
          localaj = com.tencent.mm.model.c.bzK().Ju(g.this.lMU);
          long l1 = 0L;
          for (;;)
          {
            try
            {
              if (!localCursor.moveToNext()) {
                break label1163;
              }
              localcc = new cc();
              localcc.convertFrom(localCursor);
              Object localObject1 = localcc.field_content;
              if (localObject1 == null) {
                break label1219;
              }
              localObject3 = k.b.aP((String)localObject1, localcc.field_reserved);
              if ((!g.Dz(Util.safeParseInt(((k.b)localObject3).nSK))) && (!g.Dz(localcc.getType()))) {
                break label1219;
              }
              String str = g.b(localcc, au.bwE(g.this.lMU));
              localObject4 = ((n)h.ax(n.class)).bzA().JE(str);
              localObject1 = "";
              if (localaj != null) {
                localObject1 = localaj.getDisplayName(str);
              }
              if (!g.Dz(localcc.getType())) {
                break label736;
              }
              localObject1 = new g.a(g.this, localcc.getCreateTime(), localcc.getType(), ((k.b)localObject3).nSi, localcc.field_msgId, ((az)localObject4).field_username, ((au)localObject4).aSU(), ((az)localObject4).field_conRemark, (String)localObject1);
              localObject4 = new adk();
              ((adk)localObject4).ihB.hPj = ((k.b)localObject3).nSk;
              ((adk)localObject4).publish();
              if (localcc.field_isSend == 1)
              {
                bool = ((adk)localObject4).ihC.ihD;
                if (((adk)localObject4).ihC.status == -2) {
                  bool = false;
                }
                if (bool) {
                  break;
                }
                Log.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((adk)localObject4).ihC.ihD), Integer.valueOf(((adk)localObject4).ihC.status), Long.valueOf(localcc.field_msgId), g.this.aeIA.kD(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
                continue;
              }
              if (((adk)localObject4).ihC.ihD) {
                break label1228;
              }
            }
            finally
            {
              localCursor.close();
              AppMethodBeat.o(36567);
            }
            bool = true;
          }
          i = ((adk)localObject4).ihC.status;
          j = i;
          if (i <= 0) {
            j = ((k.b)localObject3).nSh;
          }
          localObject2.nickname = g.this.mContext.getResources().getString(R.l.gWy, new Object[] { localObject2.nickname });
          switch (j)
          {
          case 2: 
            localObject2.uBc = i;
            localObject2.desc = g.a(g.this, g.this.mContext, localcc, (k.b)localObject3, bool, j);
            localObject4 = g.this.mContext;
            if ((localObject3 == null) || (localObject4 == null))
            {
              i = R.k.c2c_remittance_icon;
              for (;;)
              {
                localObject2.iconRes = i;
                localObject3 = new Date(localcc.getCreateTime());
                long l2 = com.tencent.mm.ui.gridviewheaders.a.jBw().b((Date)localObject3);
                if (l1 != l2) {
                  localLinkedList.add(new c.c(localcc.getCreateTime()));
                }
                localLinkedList.add(localObject2);
                l1 = l2;
                break;
                label694:
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
              label736:
              locala = new g.a(g.this, localcc.getCreateTime(), localcc.getType(), ((k.b)localObject3).nSF, localcc.field_msgId, ((az)localObject4).field_username, ((au)localObject4).aSU(), ((az)localObject4).field_conRemark, localObject2);
              locala.hgj = Util.safeParseInt(((k.b)localObject3).nSK);
              if (locala.hgj == Util.safeParseInt("1001"))
              {
                locala.nickname = g.this.mContext.getResources().getString(R.l.gWw, new Object[] { locala.nickname });
                if (localcc.field_isSend != 1) {
                  break label1327;
                }
                bool = true;
                label858:
                locala.desc = com.tencent.mm.ui.chatting.g.a((k.b)localObject3, bool);
                if (localcc.field_isSend != 1) {
                  break label1333;
                }
                bool = true;
                label882:
                locala.uBc = com.tencent.mm.ui.chatting.g.d((k.b)localObject3, bool);
                if (localcc.field_isSend != 1) {
                  break label1339;
                }
              }
            }
            break;
          }
        }
        label1157:
        label1163:
        label1327:
        label1333:
        label1339:
        for (boolean bool = true;; bool = false)
        {
          locala.iconRes = com.tencent.mm.ui.chatting.g.b((k.b)localObject3, bool);
          break label629;
          localObject4 = new adj();
          ((adj)localObject4).ihv.ihx = ((k.b)localObject3).nSL;
          ((adj)localObject4).publish();
          locala.nickname = g.this.mContext.getResources().getString(R.l.gWx, new Object[] { locala.nickname });
          i = ((adj)localObject4).ihw.ihy;
          j = ((adj)localObject4).ihw.ihz;
          int k = ((adj)localObject4).ihw.ihA;
          if (localcc.field_isSend == 1)
          {
            bool = true;
            label1021:
            locala.desc = com.tencent.mm.ui.chatting.g.a(i, j, k, bool, au.bwE(g.this.lMU), g.this.lMU, (k.b)localObject3, null);
            localObject3 = (com.tencent.mm.message.c)((k.b)localObject3).aK(com.tencent.mm.message.c.class);
            i = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.message.c)localObject3).nPQ, "drawable", MMApplicationContext.getPackageName());
            j = ((adj)localObject4).ihw.ihz;
            k = ((adj)localObject4).ihw.ihA;
            if (localcc.field_isSend != 1) {
              break label1157;
            }
          }
          for (bool = true;; bool = false)
          {
            locala.iconRes = com.tencent.mm.ui.chatting.g.U(j, k, bool);
            if (locala.iconRes <= 0) {
              locala.iconRes = i;
            }
            break;
            bool = false;
            break label1021;
          }
          localCursor.close();
          g.this.mDataList.addAll(localLinkedList);
          g.this.aeIB = g.this.mDataList;
          localLinkedList.clear();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36566);
              if (g.this.aeIz != null) {
                g.this.aeIz.F(g.1.this.wQx, g.this.mDataList.size());
              }
              AppMethodBeat.o(36566);
            }
          });
          AppMethodBeat.o(36567);
          return;
          label1219:
          break label1241;
          localaj = null;
          break;
          label1228:
          bool = false;
          break label337;
          i = -352966;
          break label568;
          label1241:
          break label97;
          i = -352966;
          break label568;
          i = -470621;
          break label568;
          i = -470621;
          break label568;
          i = -470621;
          break label568;
          i = -470621;
          break label568;
          switch (j)
          {
          }
          break label694;
          bool = false;
          break label858;
          bool = false;
          break label882;
        }
      }
    });
    AppMethodBeat.o(36573);
  }
  
  public final c.e juS()
  {
    AppMethodBeat.i(36576);
    g.2 local2 = new g.2(this);
    AppMethodBeat.o(36576);
    return local2;
  }
  
  public final String juU()
  {
    AppMethodBeat.i(36575);
    String str = this.mContext.getString(R.l.search_chatroom_pay);
    AppMethodBeat.o(36575);
    return str;
  }
  
  final class a
    extends c.b
  {
    public String appId;
    public String desc;
    public int hgj;
    public int iconRes;
    public int uBc = 0;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean bAH(String paramString)
    {
      AppMethodBeat.i(36569);
      if (paramString != null)
      {
        boolean bool2 = super.bAH(paramString);
        boolean bool1 = bool2;
        if (!bool2) {
          bool1 = this.title.contains(paramString);
        }
        AppMethodBeat.o(36569);
        return bool1;
      }
      AppMethodBeat.o(36569);
      return false;
    }
    
    public final int getType()
    {
      return this.type;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36570);
      String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.dYO + '\'' + ", nameInRoom='" + this.uqb + '\'' + '}';
      AppMethodBeat.o(36570);
      return str;
    }
  }
  
  final class b
    extends c.a
  {
    TextView plr;
    ImageView ttT;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36571);
      this.ttT = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.pJJ.setSingleLine(false);
      this.pJJ.setMaxLines(2);
      this.plr = ((TextView)paramView.findViewById(R.h.fav_detail));
      AppMethodBeat.o(36571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.g
 * JD-Core Version:    0.7.0.1
 */