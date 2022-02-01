package com.tencent.mm.ui.chatting.j;

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
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.b;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
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
  int fBP = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean vb(int paramInt)
  {
    AppMethodBeat.i(36572);
    if ((bs.aLy("1001") == paramInt) || (bs.aLy("1002") == paramInt) || (419430449 == paramInt))
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
    a locala = (a)aaU(paramInt);
    if (bs.isNullOrNil(locala.desc)) {
      parama.ijE.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 6);
      parama.lzC.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.lzC.setImageResource(locala.iconRes);
      parama.lzC.setBackgroundColor(locala.IfW);
      AppMethodBeat.o(36578);
      return;
      parama.ijE.setVisibility(0);
      parama.ijE.setText(bs.bG(locala.desc, ""));
    }
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(36574);
    String str = this.mContext.getString(2131762912);
    AppMethodBeat.o(36574);
    return str;
  }
  
  public final void foZ()
  {
    AppMethodBeat.i(36573);
    this.Ifu.fpd();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36567);
        LinkedList localLinkedList = new LinkedList();
        az.ayM();
        Cursor localCursor = com.tencent.mm.model.c.awD().dW(g.this.fzK, g.this.fBP);
        if (localCursor == null)
        {
          ac.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36567);
          return;
        }
        x localx;
        label97:
        bo localbo;
        Object localObject3;
        Object localObject4;
        label340:
        int i;
        int j;
        label572:
        label626:
        label632:
        g.a locala;
        if (w.sQ(g.this.fzK))
        {
          az.ayM();
          localx = com.tencent.mm.model.c.awK().xN(g.this.fzK);
          long l1 = 0L;
          for (;;)
          {
            try
            {
              if (!localCursor.moveToNext()) {
                break label1117;
              }
              localbo = new bo();
              localbo.convertFrom(localCursor);
              Object localObject1 = localbo.field_content;
              if (localObject1 == null) {
                break label1173;
              }
              localObject3 = k.b.az((String)localObject1, localbo.field_reserved);
              if ((!g.vb(bs.aLy(((k.b)localObject3).hjn))) && (!g.vb(localbo.getType()))) {
                break label1173;
              }
              String str = g.b(localbo, w.sQ(g.this.fzK));
              localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(str);
              localObject1 = "";
              if (localx != null) {
                localObject1 = localx.wk(str);
              }
              if (!g.vb(localbo.getType())) {
                break label697;
              }
              localObject1 = new g.a(g.this, localbo.field_createTime, localbo.getType(), ((k.b)localObject3).hiM, localbo.field_msgId, ((av)localObject4).field_username, ((com.tencent.mm.storage.ai)localObject4).aaR(), ((av)localObject4).field_conRemark, (String)localObject1);
              localObject4 = new yb();
              ((yb)localObject4).dBC.dlI = ((k.b)localObject3).hiO;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject4);
              if (localbo.field_isSend == 1)
              {
                bool = ((yb)localObject4).dBD.dBE;
                if (((yb)localObject4).dBD.status == -2) {
                  bool = false;
                }
                if (bool) {
                  break;
                }
                ac.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((yb)localObject4).dBD.dBE), Integer.valueOf(((yb)localObject4).dBD.status), Long.valueOf(localbo.field_msgId), g.this.Ifv.rH(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
                continue;
              }
              if (((yb)localObject4).dBD.dBE) {
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
          i = ((yb)localObject4).dBD.status;
          j = i;
          if (i <= 0) {
            j = ((k.b)localObject3).hiL;
          }
          localObject2.nickname = g.this.mContext.getResources().getString(2131764135, new Object[] { localObject2.nickname });
          switch (j)
          {
          case 2: 
            localObject2.IfW = i;
            localObject2.desc = g.a(g.this, g.this.mContext, localbo, (k.b)localObject3, bool, j);
            localObject4 = g.this.mContext;
            if (localObject3 != null)
            {
              if (localObject4 != null) {
                break label1240;
              }
              break label1195;
              localObject2.iconRes = i;
              localObject3 = new Date(localbo.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.fsS().b((Date)localObject3);
              if (l1 != l2) {
                localLinkedList.add(new c.c(localbo.field_createTime));
              }
              localLinkedList.add(localObject2);
              l1 = l2;
              break label1202;
              label697:
              locala = new g.a(g.this, localbo.field_createTime, localbo.getType(), ((k.b)localObject3).hji, localbo.field_msgId, ((av)localObject4).field_username, ((com.tencent.mm.storage.ai)localObject4).aaR(), ((av)localObject4).field_conRemark, localObject2);
              locala.IfV = bs.aLy(((k.b)localObject3).hjn);
              if (locala.IfV == bs.aLy("1001"))
              {
                locala.nickname = g.this.mContext.getResources().getString(2131764125, new Object[] { locala.nickname });
                if (localbo.field_isSend != 1) {
                  break label1326;
                }
                bool = true;
                label819:
                locala.desc = f.b((k.b)localObject3, bool);
                if (localbo.field_isSend != 1) {
                  break label1332;
                }
                bool = true;
                label843:
                locala.IfW = f.d((k.b)localObject3, bool);
                if (localbo.field_isSend != 1) {
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
          localObject4 = new ya();
          ((ya)localObject4).dBw.dBy = ((k.b)localObject3).hjo;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject4);
          locala.nickname = g.this.mContext.getResources().getString(2131764128, new Object[] { locala.nickname });
          i = ((ya)localObject4).dBx.dBz;
          j = ((ya)localObject4).dBx.dBA;
          int k = ((ya)localObject4).dBx.dBB;
          if (localbo.field_isSend == 1)
          {
            bool = true;
            label985:
            locala.desc = f.b(i, j, k, bool, w.sQ(g.this.fzK));
            localObject3 = (com.tencent.mm.ah.c)((k.b)localObject3).ao(com.tencent.mm.ah.c.class);
            i = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.ah.c)localObject3).hgL, "drawable", com.tencent.mm.sdk.platformtools.ai.getPackageName());
            j = ((ya)localObject4).dBx.dBA;
            k = ((ya)localObject4).dBx.dBB;
            if (localbo.field_isSend != 1) {
              break label1111;
            }
          }
          label1111:
          for (bool = true;; bool = false)
          {
            locala.iconRes = f.E(j, k, bool);
            if (locala.iconRes <= 0) {
              locala.iconRes = i;
            }
            break;
            bool = false;
            break label985;
          }
          label1117:
          localCursor.close();
          g.this.ijj.addAll(localLinkedList);
          g.this.Ifw = g.this.ijj;
          localLinkedList.clear();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36566);
              if (g.this.Ifu != null) {
                g.this.Ifu.B(g.1.this.opD, g.this.ijj.size());
              }
              AppMethodBeat.o(36566);
            }
          });
          AppMethodBeat.o(36567);
          return;
          break label1202;
          localx = null;
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
  
  public final c.e fpa()
  {
    AppMethodBeat.i(36576);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36568);
        paramAnonymousView = g.this.mContext;
        String str = g.this.fzK;
        long l = paramAnonymousb.msgId;
        if (str == null)
        {
          ac.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
          AppMethodBeat.o(36568);
          return;
        }
        az.ayM();
        l = com.tencent.mm.model.c.awD().vP(l).field_msgId;
        ac.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
        if (w.sQ(str))
        {
          az.ayM();
          if (com.tencent.mm.model.c.awK().xN(str) == null)
          {
            ac.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
            com.tencent.mm.ui.base.h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
            AppMethodBeat.o(36568);
          }
        }
        else
        {
          az.ayM();
          paramAnonymousb = com.tencent.mm.model.c.awB().aNt(str);
          if ((paramAnonymousb == null) || (!com.tencent.mm.n.b.ln(paramAnonymousb.field_type)))
          {
            if (paramAnonymousb == null) {
              ac.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
            }
            for (;;)
            {
              com.tencent.mm.ui.base.h.d(paramAnonymousView, paramAnonymousView.getString(2131762411), paramAnonymousView.getString(2131764439), null);
              AppMethodBeat.o(36568);
              return;
              ac.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
            }
          }
        }
        paramAnonymousb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
        paramAnonymousb.setClass(paramAnonymousView, ChattingUI.class);
        paramAnonymousb = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousb);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousb.aeD(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousb.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36568);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb) {}
    };
    AppMethodBeat.o(36576);
    return local2;
  }
  
  public final String fpc()
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
  
  public final RecyclerView.w z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36577);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494003, paramViewGroup, false));
    AppMethodBeat.o(36577);
    return paramViewGroup;
  }
  
  final class a
    extends c.b
  {
    public int IfV;
    public int IfW = 0;
    public String appId;
    public String desc;
    public int iconRes;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean aQg(String paramString)
    {
      AppMethodBeat.i(36569);
      if (paramString != null)
      {
        boolean bool2 = super.aQg(paramString);
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
      String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bLt + '\'' + ", nameInRoom='" + this.mnK + '\'' + '}';
      AppMethodBeat.o(36570);
      return str;
    }
  }
  
  final class b
    extends c.a
  {
    TextView ijE;
    ImageView lzC;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36571);
      this.lzC = ((ImageView)paramView.findViewById(2131299794));
      this.iCg.setSingleLine(false);
      this.iCg.setMaxLines(2);
      this.ijE = ((TextView)paramView.findViewById(2131299781));
      AppMethodBeat.o(36571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.g
 * JD-Core Version:    0.7.0.1
 */