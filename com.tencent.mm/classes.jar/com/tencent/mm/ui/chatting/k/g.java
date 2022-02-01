package com.tencent.mm.ui.chatting.k;

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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.aaf;
import com.tencent.mm.g.a.aaf.b;
import com.tencent.mm.g.a.aag;
import com.tencent.mm.g.a.aag.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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
  int gCo = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean gRM()
  {
    AppMethodBeat.i(233505);
    if ((ab.Eq(this.gAn)) || (ab.Iy(this.gAn)))
    {
      AppMethodBeat.o(233505);
      return true;
    }
    AppMethodBeat.o(233505);
    return false;
  }
  
  public static boolean zA(int paramInt)
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
  
  public final RecyclerView.v N(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(36577);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494178, paramViewGroup, false));
    AppMethodBeat.o(36577);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36578);
    parama = (b)parama;
    a locala = (a)amy(paramInt);
    if (Util.isNullOrNil(locala.desc)) {
      parama.jBR.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6);
      parama.nnL.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.nnL.setImageResource(locala.iconRes);
      parama.nnL.setBackgroundColor(locala.PEO);
      AppMethodBeat.o(36578);
      return;
      parama.jBR.setVisibility(0);
      parama.jBR.setText(Util.nullAs(locala.desc, ""));
    }
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(36574);
    String str = this.mContext.getString(2131765048);
    AppMethodBeat.o(36574);
    return str;
  }
  
  public final void gRY()
  {
    AppMethodBeat.i(36573);
    this.PEm.gSc();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36567);
        LinkedList localLinkedList = new LinkedList();
        bg.aVF();
        Cursor localCursor = com.tencent.mm.model.c.aSQ().eI(g.this.gAn, g.this.gCo);
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
        label626:
        label632:
        g.a locala;
        if (ab.Eq(g.this.gAn))
        {
          bg.aVF();
          localah = com.tencent.mm.model.c.aSX().Kd(g.this.gAn);
          long l1 = 0L;
          for (;;)
          {
            try
            {
              if (!localCursor.moveToNext()) {
                break label1127;
              }
              localca = new ca();
              localca.convertFrom(localCursor);
              Object localObject1 = localca.field_content;
              if (localObject1 == null) {
                break label1183;
              }
              localObject3 = k.b.aD((String)localObject1, localca.field_reserved);
              if ((!g.zA(Util.safeParseInt(((k.b)localObject3).iyq))) && (!g.zA(localca.getType()))) {
                break label1183;
              }
              String str = g.b(localca, ab.Eq(g.this.gAn));
              localObject4 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
              localObject1 = "";
              if (localah != null) {
                localObject1 = localah.getDisplayName(str);
              }
              if (!g.zA(localca.getType())) {
                break label697;
              }
              localObject1 = new g.a(g.this, localca.field_createTime, localca.getType(), ((k.b)localObject3).ixO, localca.field_msgId, ((ax)localObject4).field_username, ((as)localObject4).arI(), ((ax)localObject4).field_conRemark, (String)localObject1);
              localObject4 = new aag();
              ((aag)localObject4).ehb.dQp = ((k.b)localObject3).ixQ;
              EventCenter.instance.publish((IEvent)localObject4);
              if (localca.field_isSend == 1)
              {
                bool = ((aag)localObject4).ehc.ehd;
                if (((aag)localObject4).ehc.status == -2) {
                  bool = false;
                }
                if (bool) {
                  break;
                }
                Log.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[] { Boolean.valueOf(((aag)localObject4).ehc.ehd), Integer.valueOf(((aag)localObject4).ehc.status), Long.valueOf(localca.field_msgId), g.this.PEn.Cc(((g.a)localObject1).timestamp), ((g.a)localObject1).toString() });
                continue;
              }
              if (((aag)localObject4).ehc.ehd) {
                break label1192;
              }
            }
            finally
            {
              localCursor.close();
              AppMethodBeat.o(36567);
            }
            bool = true;
          }
          i = ((aag)localObject4).ehc.status;
          j = i;
          if (i <= 0) {
            j = ((k.b)localObject3).ixN;
          }
          localObject2.nickname = g.this.mContext.getResources().getString(2131766391, new Object[] { localObject2.nickname });
          switch (j)
          {
          case 2: 
            localObject2.PEO = i;
            localObject2.desc = g.a(g.this, g.this.mContext, localca, (k.b)localObject3, bool, j);
            localObject4 = g.this.mContext;
            if (localObject3 != null)
            {
              if (localObject4 != null) {
                break label1250;
              }
              break label1205;
              localObject2.iconRes = i;
              localObject3 = new Date(localca.field_createTime);
              long l2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b((Date)localObject3);
              if (l1 != l2) {
                localLinkedList.add(new c.c(localca.field_createTime));
              }
              localLinkedList.add(localObject2);
              l1 = l2;
              break label1212;
              label697:
              locala = new g.a(g.this, localca.field_createTime, localca.getType(), ((k.b)localObject3).iyl, localca.field_msgId, ((ax)localObject4).field_username, ((as)localObject4).arI(), ((ax)localObject4).field_conRemark, localObject2);
              locala.dkT = Util.safeParseInt(((k.b)localObject3).iyq);
              if (locala.dkT == Util.safeParseInt("1001"))
              {
                locala.nickname = g.this.mContext.getResources().getString(2131766381, new Object[] { locala.nickname });
                if (localca.field_isSend != 1) {
                  break label1334;
                }
                bool = true;
                label819:
                locala.desc = f.a((k.b)localObject3, bool);
                if (localca.field_isSend != 1) {
                  break label1340;
                }
                bool = true;
                label843:
                locala.PEO = f.d((k.b)localObject3, bool);
                if (localca.field_isSend != 1) {
                  break label1346;
                }
              }
            }
            break;
          }
        }
        label1183:
        label1192:
        label1205:
        label1212:
        label1346:
        for (boolean bool = true;; bool = false)
        {
          locala.iconRes = f.b((k.b)localObject3, bool);
          break label632;
          localObject4 = new aaf();
          ((aaf)localObject4).egV.egX = ((k.b)localObject3).iyr;
          EventCenter.instance.publish((IEvent)localObject4);
          locala.nickname = g.this.mContext.getResources().getString(2131766384, new Object[] { locala.nickname });
          i = ((aaf)localObject4).egW.egY;
          j = ((aaf)localObject4).egW.egZ;
          int k = ((aaf)localObject4).egW.eha;
          if (localca.field_isSend == 1)
          {
            bool = true;
            label985:
            locala.desc = f.a(i, j, k, bool, ab.Eq(g.this.gAn), g.this.gAn, (k.b)localObject3, null);
            localObject3 = (com.tencent.mm.ag.c)((k.b)localObject3).as(com.tencent.mm.ag.c.class);
            i = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.ag.c)localObject3).ivO, "drawable", MMApplicationContext.getPackageName());
            j = ((aaf)localObject4).egW.egZ;
            k = ((aaf)localObject4).egW.eha;
            if (localca.field_isSend != 1) {
              break label1121;
            }
          }
          label1121:
          for (bool = true;; bool = false)
          {
            locala.iconRes = f.J(j, k, bool);
            if (locala.iconRes <= 0) {
              locala.iconRes = i;
            }
            break;
            bool = false;
            break label985;
          }
          label1127:
          localCursor.close();
          g.this.mDataList.addAll(localLinkedList);
          g.this.PEo = g.this.mDataList;
          localLinkedList.clear();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36566);
              if (g.this.PEm != null) {
                g.this.PEm.D(g.1.this.qoy, g.this.mDataList.size());
              }
              AppMethodBeat.o(36566);
            }
          });
          AppMethodBeat.o(36567);
          return;
          break label1212;
          localah = null;
          break;
          bool = false;
          break label340;
          i = -352966;
          break label572;
          i = 2131689865;
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
            i = 2131689865;
            break;
          case 1: 
          case 7: 
            i = 2131689865;
            break;
          case 3: 
            i = 2131689866;
            break;
          case 4: 
            i = 2131689867;
            break;
          case 5: 
            i = 2131689866;
            break;
          case 6: 
            label1250:
            i = 2131689864;
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
  
  public final c.e gRZ()
  {
    AppMethodBeat.i(36576);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36568);
        paramAnonymousView = g.this.mContext;
        String str = g.this.gAn;
        long l = paramAnonymousb.msgId;
        if (str == null)
        {
          Log.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
          AppMethodBeat.o(36568);
          return;
        }
        bg.aVF();
        l = com.tencent.mm.model.c.aSQ().Hb(l).field_msgId;
        Log.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
        if (ab.Eq(str))
        {
          bg.aVF();
          if (com.tencent.mm.model.c.aSX().Kd(str) == null)
          {
            Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
            h.d(paramAnonymousView, paramAnonymousView.getString(2131764477), paramAnonymousView.getString(2131766783), null);
            AppMethodBeat.o(36568);
          }
        }
        else
        {
          bg.aVF();
          paramAnonymousb = com.tencent.mm.model.c.aSN().Kn(str);
          if ((paramAnonymousb == null) || (!com.tencent.mm.contact.c.oR(paramAnonymousb.field_type)))
          {
            if (paramAnonymousb == null) {
              Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
            }
            for (;;)
            {
              h.d(paramAnonymousView, paramAnonymousView.getString(2131764477), paramAnonymousView.getString(2131766783), null);
              AppMethodBeat.o(36568);
              return;
              Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
            }
          }
        }
        paramAnonymousb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
        paramAnonymousb.setClass(paramAnonymousView, ChattingUI.class);
        paramAnonymousb = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousb);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousb.axQ(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousb.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36568);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb) {}
    };
    AppMethodBeat.o(36576);
    return local2;
  }
  
  public final String gSb()
  {
    AppMethodBeat.i(36575);
    String str = this.mContext.getString(2131765048);
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
    public int PEO = 0;
    public String appId;
    public String desc;
    public int dkT;
    public int iconRes;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean bmC(String paramString)
    {
      AppMethodBeat.i(36569);
      if (paramString != null)
      {
        boolean bool2 = super.bmC(paramString);
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
      String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.cgo + '\'' + ", nameInRoom='" + this.ogt + '\'' + '}';
      AppMethodBeat.o(36570);
      return str;
    }
  }
  
  final class b
    extends c.a
  {
    TextView jBR;
    ImageView nnL;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36571);
      this.nnL = ((ImageView)paramView.findViewById(2131300468));
      this.jVO.setSingleLine(false);
      this.jVO.setMaxLines(2);
      this.jBR = ((TextView)paramView.findViewById(2131300454));
      AppMethodBeat.o(36571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.g
 * JD-Core Version:    0.7.0.1
 */