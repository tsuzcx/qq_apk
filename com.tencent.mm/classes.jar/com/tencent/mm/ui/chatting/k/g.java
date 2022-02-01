package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.a.za.b;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.a.zb.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.ui.chatting.f.b.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public final class g
  extends b
{
  int fXi = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean vL(int paramInt)
  {
    AppMethodBeat.i(36572);
    if ((bu.aSB("1001") == paramInt) || (bu.aSB("1002") == paramInt) || (419430449 == paramInt))
    {
      AppMethodBeat.o(36572);
      return true;
    }
    AppMethodBeat.o(36572);
    return false;
  }
  
  public final RecyclerView.w D(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36577);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494003, paramViewGroup, false));
    AppMethodBeat.o(36577);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36578);
    parama = (b)parama;
    a locala = (a)adN(paramInt);
    if (bu.isNullOrNil(locala.desc)) {
      parama.iFO.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6);
      parama.mdt.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.mdt.setImageResource(locala.iconRes);
      parama.mdt.setBackgroundColor(locala.KsA);
      AppMethodBeat.o(36578);
      return;
      parama.iFO.setVisibility(0);
      parama.iFO.setText(bu.bI(locala.desc, ""));
    }
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(36574);
    String str = this.mContext.getString(2131762912);
    AppMethodBeat.o(36574);
    return str;
  }
  
  public final void fJL()
  {
    AppMethodBeat.i(36573);
    this.KrZ.fJP();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36567);
        LinkedList localLinkedList = new LinkedList();
        bc.aCg();
        Cursor localCursor = com.tencent.mm.model.c.azI().eu(g.this.fVg, g.this.fXi);
        if (localCursor == null)
        {
          ae.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36567);
          return;
        }
        ac localac;
        label97:
        bv localbv;
        Object localObject3;
        Object localObject4;
        label340:
        int i;
        int j;
        label572:
        label626:
        label632:
        g.a locala;
        if (x.wb(g.this.fVg))
        {
          bc.aCg();
          localac = com.tencent.mm.model.c.azP().Bx(g.this.fVg);
          long l1 = 0L;
          for (;;)
          {
            try
            {
              if (!localCursor.moveToNext()) {
                break label1117;
              }
              localbv = new bv();
              localbv.convertFrom(localCursor);
              Object localObject1 = localbv.field_content;
              if (localObject1 == null) {
                break label1173;
              }
              localObject3 = k.b.aB((String)localObject1, localbv.field_reserved);
              if ((!g.vL(bu.aSB(((k.b)localObject3).hEk))) && (!g.vL(localbv.getType()))) {
                break label1173;
              }
              String str = g.b(localbv, x.wb(g.this.fVg));
              localObject4 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(str);
              localObject1 = "";
              if (localac != null) {
                localObject1 = localac.zP(str);
              }
              if (!g.vL(localbv.getType())) {
                break label697;
              }
              localObject1 = new g.a(g.this, localbv.field_createTime, localbv.getType(), ((k.b)localObject3).hDJ, localbv.field_msgId, ((aw)localObject4).field_username, ((an)localObject4).adF(), ((aw)localObject4).field_conRemark, (String)localObject1);
              localObject4 = new zb();
              ((zb)localObject4).dPf.dyA = ((k.b)localObject3).hDL;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
              if (localbv.field_isSend == 1)
              {
                bool = ((zb)localObject4).dPg.dPh;
                if (((zb)localObject4).dPg.status == -2) {
                  bool = false;
                }
                if (bool) {
                  break;
                }
                ae.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((zb)localObject4).dPg.dPh), Integer.valueOf(((zb)localObject4).dPg.status), Long.valueOf(localbv.field_msgId), g.this.Ksa.tX(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
                continue;
              }
              if (((zb)localObject4).dPg.dPh) {
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
          i = ((zb)localObject4).dPg.status;
          j = i;
          if (i <= 0) {
            j = ((k.b)localObject3).hDI;
          }
          localObject2.nickname = g.this.mContext.getResources().getString(2131764135, new Object[] { localObject2.nickname });
          switch (j)
          {
          case 2: 
            localObject2.KsA = i;
            localObject2.desc = g.a(g.this, g.this.mContext, localbv, (k.b)localObject3, bool, j);
            localObject4 = g.this.mContext;
            if (localObject3 != null)
            {
              if (localObject4 != null) {
                break label1240;
              }
              break label1195;
              localObject2.iconRes = i;
              localObject3 = new Date(localbv.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.fNX().b((Date)localObject3);
              if (l1 != l2) {
                localLinkedList.add(new c.c(localbv.field_createTime));
              }
              localLinkedList.add(localObject2);
              l1 = l2;
              break label1202;
              label697:
              locala = new g.a(g.this, localbv.field_createTime, localbv.getType(), ((k.b)localObject3).hEf, localbv.field_msgId, ((aw)localObject4).field_username, ((an)localObject4).adF(), ((aw)localObject4).field_conRemark, localObject2);
              locala.cUz = bu.aSB(((k.b)localObject3).hEk);
              if (locala.cUz == bu.aSB("1001"))
              {
                locala.nickname = g.this.mContext.getResources().getString(2131764125, new Object[] { locala.nickname });
                if (localbv.field_isSend != 1) {
                  break label1326;
                }
                bool = true;
                label819:
                locala.desc = f.b((k.b)localObject3, bool);
                if (localbv.field_isSend != 1) {
                  break label1332;
                }
                bool = true;
                label843:
                locala.KsA = f.d((k.b)localObject3, bool);
                if (localbv.field_isSend != 1) {
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
          localObject4 = new za();
          ((za)localObject4).dOZ.dPb = ((k.b)localObject3).hEl;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
          locala.nickname = g.this.mContext.getResources().getString(2131764128, new Object[] { locala.nickname });
          i = ((za)localObject4).dPa.dPc;
          j = ((za)localObject4).dPa.dPd;
          int k = ((za)localObject4).dPa.dPe;
          if (localbv.field_isSend == 1)
          {
            bool = true;
            label985:
            locala.desc = f.b(i, j, k, bool, x.wb(g.this.fVg));
            localObject3 = (com.tencent.mm.ah.c)((k.b)localObject3).ao(com.tencent.mm.ah.c.class);
            i = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.ah.c)localObject3).hBI, "drawable", ak.getPackageName());
            j = ((za)localObject4).dPa.dPd;
            k = ((za)localObject4).dPa.dPe;
            if (localbv.field_isSend != 1) {
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
          g.this.mDataList.addAll(localLinkedList);
          g.this.Ksb = g.this.mDataList;
          localLinkedList.clear();
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36566);
              if (g.this.KrZ != null) {
                g.this.KrZ.C(g.1.this.oZA, g.this.mDataList.size());
              }
              AppMethodBeat.o(36566);
            }
          });
          AppMethodBeat.o(36567);
          return;
          break label1202;
          localac = null;
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
  
  public final c.e fJM()
  {
    AppMethodBeat.i(36576);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36568);
        paramAnonymousView = g.this.mContext;
        String str = g.this.fVg;
        long l = paramAnonymousb.msgId;
        if (str == null)
        {
          ae.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
          AppMethodBeat.o(36568);
          return;
        }
        bc.aCg();
        l = com.tencent.mm.model.c.azI().ys(l).field_msgId;
        ae.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
        if (x.wb(str))
        {
          bc.aCg();
          if (com.tencent.mm.model.c.azP().Bx(str) == null)
          {
            ae.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
            h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
            AppMethodBeat.o(36568);
          }
        }
        else
        {
          bc.aCg();
          paramAnonymousb = com.tencent.mm.model.c.azF().BH(str);
          if ((paramAnonymousb == null) || (!com.tencent.mm.contact.c.lO(paramAnonymousb.field_type)))
          {
            if (paramAnonymousb == null) {
              ae.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
            }
            for (;;)
            {
              h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
              AppMethodBeat.o(36568);
              return;
              ae.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
            }
          }
        }
        paramAnonymousb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
        paramAnonymousb.setClass(paramAnonymousView, ChattingUI.class);
        paramAnonymousb = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousb);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousb.ahE(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousb.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36568);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb) {}
    };
    AppMethodBeat.o(36576);
    return local2;
  }
  
  public final String fJO()
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
  
  final class a
    extends c.b
  {
    public int KsA = 0;
    public String appId;
    public int cUz;
    public String desc;
    public int iconRes;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean aXy(String paramString)
    {
      AppMethodBeat.i(36569);
      if (paramString != null)
      {
        boolean bool2 = super.aXy(paramString);
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
      String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bVG + '\'' + ", nameInRoom='" + this.mTq + '\'' + '}';
      AppMethodBeat.o(36570);
      return str;
    }
  }
  
  final class b
    extends c.a
  {
    TextView iFO;
    ImageView mdt;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36571);
      this.mdt = ((ImageView)paramView.findViewById(2131299794));
      this.iYj.setSingleLine(false);
      this.iYj.setMaxLines(2);
      this.iFO = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.g
 * JD-Core Version:    0.7.0.1
 */