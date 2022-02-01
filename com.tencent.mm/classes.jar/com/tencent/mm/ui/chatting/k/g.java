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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.g.a.yu.b;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
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
  int fVc = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean vG(int paramInt)
  {
    AppMethodBeat.i(36572);
    if ((bt.aRe("1001") == paramInt) || (bt.aRe("1002") == paramInt) || (419430449 == paramInt))
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
    a locala = (a)adg(paramInt);
    if (bt.isNullOrNil(locala.desc)) {
      parama.iCV.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 6);
      parama.lZa.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.lZa.setImageResource(locala.iconRes);
      parama.lZa.setBackgroundColor(locala.JWj);
      AppMethodBeat.o(36578);
      return;
      parama.iCV.setVisibility(0);
      parama.iCV.setText(bt.bI(locala.desc, ""));
    }
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(36574);
    String str = this.mContext.getString(2131762912);
    AppMethodBeat.o(36574);
    return str;
  }
  
  public final void fFE()
  {
    AppMethodBeat.i(36573);
    this.JVH.fFI();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36567);
        LinkedList localLinkedList = new LinkedList();
        ba.aBQ();
        Cursor localCursor = com.tencent.mm.model.c.azs().en(g.this.fTa, g.this.fVc);
        if (localCursor == null)
        {
          ad.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36567);
          return;
        }
        ab localab;
        label97:
        bu localbu;
        Object localObject3;
        Object localObject4;
        label340:
        int i;
        int j;
        label572:
        label626:
        label632:
        g.a locala;
        if (w.vF(g.this.fTa))
        {
          ba.aBQ();
          localab = com.tencent.mm.model.c.azz().AN(g.this.fTa);
          long l1 = 0L;
          for (;;)
          {
            try
            {
              if (!localCursor.moveToNext()) {
                break label1117;
              }
              localbu = new bu();
              localbu.convertFrom(localCursor);
              Object localObject1 = localbu.field_content;
              if (localObject1 == null) {
                break label1173;
              }
              localObject3 = k.b.aA((String)localObject1, localbu.field_reserved);
              if ((!g.vG(bt.aRe(((k.b)localObject3).hBw))) && (!g.vG(localbu.getType()))) {
                break label1173;
              }
              String str = g.b(localbu, w.vF(g.this.fTa));
              localObject4 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(str);
              localObject1 = "";
              if (localab != null) {
                localObject1 = localab.zf(str);
              }
              if (!g.vG(localbu.getType())) {
                break label697;
              }
              localObject1 = new g.a(g.this, localbu.field_createTime, localbu.getType(), ((k.b)localObject3).hAV, localbu.field_msgId, ((aw)localObject4).field_username, ((am)localObject4).adu(), ((aw)localObject4).field_conRemark, (String)localObject1);
              localObject4 = new yv();
              ((yv)localObject4).dNP.dxv = ((k.b)localObject3).hAX;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject4);
              if (localbu.field_isSend == 1)
              {
                bool = ((yv)localObject4).dNQ.dNR;
                if (((yv)localObject4).dNQ.status == -2) {
                  bool = false;
                }
                if (bool) {
                  break;
                }
                ad.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((yv)localObject4).dNQ.dNR), Integer.valueOf(((yv)localObject4).dNQ.status), Long.valueOf(localbu.field_msgId), g.this.JVI.tG(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
                continue;
              }
              if (((yv)localObject4).dNQ.dNR) {
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
          i = ((yv)localObject4).dNQ.status;
          j = i;
          if (i <= 0) {
            j = ((k.b)localObject3).hAU;
          }
          localObject2.nickname = g.this.mContext.getResources().getString(2131764135, new Object[] { localObject2.nickname });
          switch (j)
          {
          case 2: 
            localObject2.JWj = i;
            localObject2.desc = g.a(g.this, g.this.mContext, localbu, (k.b)localObject3, bool, j);
            localObject4 = g.this.mContext;
            if (localObject3 != null)
            {
              if (localObject4 != null) {
                break label1240;
              }
              break label1195;
              localObject2.iconRes = i;
              localObject3 = new Date(localbu.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.fJG().b((Date)localObject3);
              if (l1 != l2) {
                localLinkedList.add(new c.c(localbu.field_createTime));
              }
              localLinkedList.add(localObject2);
              l1 = l2;
              break label1202;
              label697:
              locala = new g.a(g.this, localbu.field_createTime, localbu.getType(), ((k.b)localObject3).hBr, localbu.field_msgId, ((aw)localObject4).field_username, ((am)localObject4).adu(), ((aw)localObject4).field_conRemark, localObject2);
              locala.JWi = bt.aRe(((k.b)localObject3).hBw);
              if (locala.JWi == bt.aRe("1001"))
              {
                locala.nickname = g.this.mContext.getResources().getString(2131764125, new Object[] { locala.nickname });
                if (localbu.field_isSend != 1) {
                  break label1326;
                }
                bool = true;
                label819:
                locala.desc = f.b((k.b)localObject3, bool);
                if (localbu.field_isSend != 1) {
                  break label1332;
                }
                bool = true;
                label843:
                locala.JWj = f.d((k.b)localObject3, bool);
                if (localbu.field_isSend != 1) {
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
          localObject4 = new yu();
          ((yu)localObject4).dNJ.dNL = ((k.b)localObject3).hBx;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject4);
          locala.nickname = g.this.mContext.getResources().getString(2131764128, new Object[] { locala.nickname });
          i = ((yu)localObject4).dNK.dNM;
          j = ((yu)localObject4).dNK.dNN;
          int k = ((yu)localObject4).dNK.dNO;
          if (localbu.field_isSend == 1)
          {
            bool = true;
            label985:
            locala.desc = f.b(i, j, k, bool, w.vF(g.this.fTa));
            localObject3 = (com.tencent.mm.ai.c)((k.b)localObject3).ao(com.tencent.mm.ai.c.class);
            i = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.ai.c)localObject3).hyU, "drawable", aj.getPackageName());
            j = ((yu)localObject4).dNK.dNN;
            k = ((yu)localObject4).dNK.dNO;
            if (localbu.field_isSend != 1) {
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
          g.this.JVJ = g.this.mDataList;
          localLinkedList.clear();
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36566);
              if (g.this.JVH != null) {
                g.this.JVH.B(g.1.this.oSY, g.this.mDataList.size());
              }
              AppMethodBeat.o(36566);
            }
          });
          AppMethodBeat.o(36567);
          return;
          break label1202;
          localab = null;
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
  
  public final c.e fFF()
  {
    AppMethodBeat.i(36576);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36568);
        paramAnonymousView = g.this.mContext;
        String str = g.this.fTa;
        long l = paramAnonymousb.msgId;
        if (str == null)
        {
          ad.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
          AppMethodBeat.o(36568);
          return;
        }
        ba.aBQ();
        l = com.tencent.mm.model.c.azs().xY(l).field_msgId;
        ad.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
        if (w.vF(str))
        {
          ba.aBQ();
          if (com.tencent.mm.model.c.azz().AN(str) == null)
          {
            ad.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
            h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
            AppMethodBeat.o(36568);
          }
        }
        else
        {
          ba.aBQ();
          paramAnonymousb = com.tencent.mm.model.c.azp().Bf(str);
          if ((paramAnonymousb == null) || (!com.tencent.mm.o.b.lM(paramAnonymousb.field_type)))
          {
            if (paramAnonymousb == null) {
              ad.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
            }
            for (;;)
            {
              h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
              AppMethodBeat.o(36568);
              return;
              ad.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
            }
          }
        }
        paramAnonymousb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
        paramAnonymousb.setClass(paramAnonymousView, ChattingUI.class);
        paramAnonymousb = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousb);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousb.ahp(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousb.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36568);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb) {}
    };
    AppMethodBeat.o(36576);
    return local2;
  }
  
  public final String fFH()
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
    public int JWi;
    public int JWj = 0;
    public String appId;
    public String desc;
    public int iconRes;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean aVX(String paramString)
    {
      AppMethodBeat.i(36569);
      if (paramString != null)
      {
        boolean bool2 = super.aVX(paramString);
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
      String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bVG + '\'' + ", nameInRoom='" + this.mOm + '\'' + '}';
      AppMethodBeat.o(36570);
      return str;
    }
  }
  
  final class b
    extends c.a
  {
    TextView iCV;
    ImageView lZa;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36571);
      this.lZa = ((ImageView)paramView.findViewById(2131299794));
      this.iVq.setSingleLine(false);
      this.iVq.setMaxLines(2);
      this.iCV = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.g
 * JD-Core Version:    0.7.0.1
 */