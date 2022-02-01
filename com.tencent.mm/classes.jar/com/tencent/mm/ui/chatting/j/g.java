package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.g.a.xp.b;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
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
  int fyi = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean uj(int paramInt)
  {
    AppMethodBeat.i(36572);
    if ((bt.aGh("1001") == paramInt) || (bt.aGh("1002") == paramInt) || (419430449 == paramInt))
    {
      AppMethodBeat.o(36572);
      return true;
    }
    AppMethodBeat.o(36572);
    return false;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36578);
    parama = (b)parama;
    a locala = (a)YJ(paramInt);
    if (bt.isNullOrNil(locala.desc)) {
      parama.hJe.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 6);
      parama.kXS.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.kXS.setImageResource(locala.iconRes);
      parama.kXS.setBackgroundColor(locala.GGa);
      AppMethodBeat.o(36578);
      return;
      parama.hJe.setVisibility(0);
      parama.hJe.setText(bt.by(locala.desc, ""));
    }
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(36574);
    String str = this.mContext.getString(2131762912);
    AppMethodBeat.o(36574);
    return str;
  }
  
  public final void eZk()
  {
    AppMethodBeat.i(36573);
    this.GFy.eZo();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36567);
        LinkedList localLinkedList = new LinkedList();
        az.arV();
        Cursor localCursor = com.tencent.mm.model.c.apO().dP(g.this.fwd, g.this.fyi);
        if (localCursor == null)
        {
          ad.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36567);
          return;
        }
        com.tencent.mm.storage.w localw;
        label97:
        bl localbl;
        Object localObject3;
        Object localObject4;
        label340:
        int i;
        int j;
        label572:
        label626:
        label632:
        g.a locala;
        if (com.tencent.mm.model.w.pF(g.this.fwd))
        {
          az.arV();
          localw = com.tencent.mm.model.c.apV().tH(g.this.fwd);
          long l1 = 0L;
          for (;;)
          {
            try
            {
              if (!localCursor.moveToNext()) {
                break label1117;
              }
              localbl = new bl();
              localbl.convertFrom(localCursor);
              Object localObject1 = localbl.field_content;
              if (localObject1 == null) {
                break label1173;
              }
              localObject3 = k.b.ar((String)localObject1, localbl.field_reserved);
              if ((!g.uj(bt.aGh(((k.b)localObject3).gIN))) && (!g.uj(localbl.getType()))) {
                break label1173;
              }
              String str = g.b(localbl, com.tencent.mm.model.w.pF(g.this.fwd));
              localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(str);
              localObject1 = "";
              if (localw != null) {
                localObject1 = localw.sh(str);
              }
              if (!g.uj(localbl.getType())) {
                break label697;
              }
              localObject1 = new g.a(g.this, localbl.field_createTime, localbl.getType(), ((k.b)localObject3).gIl, localbl.field_msgId, ((au)localObject4).field_username, ((af)localObject4).ZW(), ((au)localObject4).field_conRemark, (String)localObject1);
              localObject4 = new xq();
              ((xq)localObject4).dDQ.dnZ = ((k.b)localObject3).gIn;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject4);
              if (localbl.field_isSend == 1)
              {
                bool = ((xq)localObject4).dDR.dDS;
                if (((xq)localObject4).dDR.status == -2) {
                  bool = false;
                }
                if (bool) {
                  break;
                }
                ad.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((xq)localObject4).dDR.dDS), Integer.valueOf(((xq)localObject4).dDR.status), Long.valueOf(localbl.field_msgId), g.this.GFz.nV(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
                continue;
              }
              if (((xq)localObject4).dDR.dDS) {
                break label1182;
              }
            }
            finally
            {
              localCursor.close();
              AppMethodBeat.o(36567);
            }
            bool = true;
          }
          i = ((xq)localObject4).dDR.status;
          j = i;
          if (i <= 0) {
            j = ((k.b)localObject3).gIk;
          }
          localObject2.nickname = g.this.mContext.getResources().getString(2131764135, new Object[] { localObject2.nickname });
          switch (j)
          {
          case 2: 
            localObject2.GGa = i;
            localObject2.desc = g.a(g.this, g.this.mContext, localbl, (k.b)localObject3, bool, j);
            localObject4 = g.this.mContext;
            if (localObject3 != null)
            {
              if (localObject4 != null) {
                break label1240;
              }
              break label1195;
              localObject2.iconRes = i;
              localObject3 = new Date(localbl.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.fcX().b((Date)localObject3);
              if (l1 != l2) {
                localLinkedList.add(new c.c(localbl.field_createTime));
              }
              localLinkedList.add(localObject2);
              l1 = l2;
              break label1202;
              label697:
              locala = new g.a(g.this, localbl.field_createTime, localbl.getType(), ((k.b)localObject3).gII, localbl.field_msgId, ((au)localObject4).field_username, ((af)localObject4).ZW(), ((au)localObject4).field_conRemark, localObject2);
              locala.GFZ = bt.aGh(((k.b)localObject3).gIN);
              if (locala.GFZ == bt.aGh("1001"))
              {
                locala.nickname = g.this.mContext.getResources().getString(2131764125, new Object[] { locala.nickname });
                if (localbl.field_isSend != 1) {
                  break label1326;
                }
                bool = true;
                label819:
                locala.desc = f.b((k.b)localObject3, bool);
                if (localbl.field_isSend != 1) {
                  break label1332;
                }
                bool = true;
                label843:
                locala.GGa = f.d((k.b)localObject3, bool);
                if (localbl.field_isSend != 1) {
                  break label1338;
                }
              }
            }
            break;
          }
        }
        label1173:
        label1182:
        label1195:
        label1202:
        label1332:
        label1338:
        for (boolean bool = true;; bool = false)
        {
          locala.iconRes = f.a((k.b)localObject3, bool);
          break label632;
          localObject4 = new xp();
          ((xp)localObject4).dDK.dDM = ((k.b)localObject3).gIO;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject4);
          locala.nickname = g.this.mContext.getResources().getString(2131764128, new Object[] { locala.nickname });
          i = ((xp)localObject4).dDL.dDN;
          j = ((xp)localObject4).dDL.dDO;
          int k = ((xp)localObject4).dDL.dDP;
          if (localbl.field_isSend == 1)
          {
            bool = true;
            label985:
            locala.desc = f.b(i, j, k, bool, com.tencent.mm.model.w.pF(g.this.fwd));
            localObject3 = (com.tencent.mm.ai.c)((k.b)localObject3).ao(com.tencent.mm.ai.c.class);
            i = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.ai.c)localObject3).gGk, "drawable", com.tencent.mm.sdk.platformtools.aj.getPackageName());
            j = ((xp)localObject4).dDL.dDO;
            k = ((xp)localObject4).dDL.dDP;
            if (localbl.field_isSend != 1) {
              break label1111;
            }
          }
          label1111:
          for (bool = true;; bool = false)
          {
            locala.iconRes = f.F(j, k, bool);
            if (locala.iconRes <= 0) {
              locala.iconRes = i;
            }
            break;
            bool = false;
            break label985;
          }
          label1117:
          localCursor.close();
          g.this.hIH.addAll(localLinkedList);
          g.this.GFA = g.this.hIH;
          localLinkedList.clear();
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36566);
              if (g.this.GFy != null) {
                g.this.GFy.A(g.1.this.nMD, g.this.hIH.size());
              }
              AppMethodBeat.o(36566);
            }
          });
          AppMethodBeat.o(36567);
          return;
          break label1202;
          localw = null;
          break;
          bool = false;
          break label340;
          i = -352966;
          break label572;
          i = 2131689850;
          break label626;
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
          case 2: 
          default: 
            i = 2131689850;
            break;
          case 1: 
          case 7: 
            i = 2131689850;
            break;
          case 3: 
            i = 2131689851;
            break;
          case 4: 
            i = 2131689852;
            break;
          case 5: 
            i = 2131689851;
            break;
          case 6: 
            label1240:
            i = 2131689849;
            break;
            bool = false;
            break label819;
            bool = false;
            break label843;
          }
        }
      }
    });
    AppMethodBeat.o(36573);
  }
  
  public final c.e eZl()
  {
    AppMethodBeat.i(36576);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36568);
        paramAnonymousView = g.this.mContext;
        String str = g.this.fwd;
        long l = paramAnonymousb.msgId;
        if (str == null)
        {
          ad.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
          AppMethodBeat.o(36568);
          return;
        }
        az.arV();
        l = com.tencent.mm.model.c.apO().rm(l).field_msgId;
        ad.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
        if (com.tencent.mm.model.w.pF(str))
        {
          az.arV();
          if (com.tencent.mm.model.c.apV().tH(str) == null)
          {
            ad.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
            com.tencent.mm.ui.base.h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
            AppMethodBeat.o(36568);
          }
        }
        else
        {
          az.arV();
          paramAnonymousb = com.tencent.mm.model.c.apM().aHY(str);
          if ((paramAnonymousb == null) || (!com.tencent.mm.n.b.ls(paramAnonymousb.field_type)))
          {
            if (paramAnonymousb == null) {
              ad.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
            }
            for (;;)
            {
              com.tencent.mm.ui.base.h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
              AppMethodBeat.o(36568);
              return;
              ad.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
            }
          }
        }
        paramAnonymousb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
        paramAnonymousb.setClass(paramAnonymousView, ChattingUI.class);
        paramAnonymousb = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousb);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousb.adn(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousb.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36568);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb) {}
    };
    AppMethodBeat.o(36576);
    return local2;
  }
  
  public final String eZn()
  {
    AppMethodBeat.i(36575);
    String str = this.mContext.getString(2131762912);
    AppMethodBeat.o(36575);
    return str;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final RecyclerView.v y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36577);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494003, paramViewGroup, false));
    AppMethodBeat.o(36577);
    return paramViewGroup;
  }
  
  final class a
    extends c.b
  {
    public int GFZ;
    public int GGa = 0;
    public String appId;
    public String desc;
    public int iconRes;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean aKD(String paramString)
    {
      AppMethodBeat.i(36569);
      if (paramString != null)
      {
        boolean bool2 = super.aKD(paramString);
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
      String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bNL + '\'' + ", nameInRoom='" + this.lLN + '\'' + '}';
      AppMethodBeat.o(36570);
      return str;
    }
  }
  
  final class b
    extends c.a
  {
    TextView hJe;
    ImageView kXS;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36571);
      this.kXS = ((ImageView)paramView.findViewById(2131299794));
      this.ica.setSingleLine(false);
      this.ica.setMaxLines(2);
      this.hJe = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.g
 * JD-Core Version:    0.7.0.1
 */