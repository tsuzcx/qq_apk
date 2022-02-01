package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.w;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AllRemindMsgUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private static final f<Integer, com.tencent.mm.protocal.b.a.c> fAs;
  private View Hfe;
  private b Hff;
  private a Hfg;
  private RecyclerView alu;
  private ProgressBar iXo;
  private LinkedList<d> oaX;
  
  static
  {
    AppMethodBeat.i(32960);
    fAs = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(32960);
  }
  
  public AllRemindMsgUI()
  {
    AppMethodBeat.i(32953);
    this.Hfg = new a();
    AppMethodBeat.o(32953);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(32959);
    String str = "";
    Object localObject = k.b.vA(paramString);
    switch (paramInt1)
    {
    default: 
      localObject = paramContext.getString(2131761630);
    }
    for (;;)
    {
      AppMethodBeat.o(32959);
      return localObject;
      localObject = paramContext.getString(2131755904);
      continue;
      localObject = paramContext.getString(2131762255, new Object[] { Integer.valueOf((int)s.qw(new com.tencent.mm.modelvoice.p(paramString).time)) });
      continue;
      localObject = paramContext.getString(2131755853);
      continue;
      if (62 == paramInt1) {}
      for (paramInt1 = 2131755895;; paramInt1 = 2131755926)
      {
        localObject = paramContext.getString(paramInt1);
        break;
      }
      az.ayM();
      com.tencent.mm.model.c.awD().alx(paramString);
      localObject = paramContext.getString(2131762242, new Object[] { "" });
      continue;
      localObject = paramContext.getString(2131755782);
      continue;
      if (localObject == null)
      {
        ac.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
        AppMethodBeat.o(32959);
        return "";
      }
      switch (((k.b)localObject).type)
      {
      default: 
        ac.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[] { Integer.valueOf(((k.b)localObject).type) });
        break;
      case 33: 
        localObject = paramContext.getString(2131755375);
        break;
      case 6: 
        localObject = paramContext.getString(2131762239, new Object[] { ((k.b)localObject).title });
        break;
      case 5: 
      case 7: 
        localObject = paramContext.getString(2131762253, new Object[] { "" });
        break;
      case 8: 
        localObject = paramContext.getString(2131755723);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(2131755722);
        break;
      case 25: 
        localObject = paramContext.getString(2131755710);
        break;
      case 17: 
        localObject = paramContext.getString(2131762242, new Object[] { "" });
        break;
      case 19: 
        localObject = paramContext.getString(2131762245, new Object[] { "" });
        break;
      case 24: 
        localObject = paramContext.getString(2131762244, new Object[] { "" });
        break;
      case 3: 
        localObject = paramContext.getString(2131762243, new Object[] { "" });
        break;
      case 4: 
        localObject = paramContext.getString(2131762254, new Object[] { "" });
        break;
      case 2: 
        localObject = paramContext.getString(2131755853);
        break;
      case 44: 
        if (bs.isNullOrNil(((k.b)localObject).r(paramContext, true))) {
          break;
        }
        localObject = ((k.b)localObject).r(paramContext, true) + " " + ((k.b)localObject).title;
        continue;
        localObject = paramContext.getString(2131755722);
        continue;
        localObject = paramContext.getString(2131762246);
        continue;
        if (localObject == null)
        {
          ac.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
          AppMethodBeat.o(32959);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).hjl, "" });
        }
        else
        {
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).hjl, "" });
          continue;
          if (localObject == null)
          {
            ac.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
            AppMethodBeat.o(32959);
            return "";
          }
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).hjl, "" });
          continue;
          localObject = paramContext.getString(2131762235, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131762235, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131762233, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131762248, new Object[] { "" });
          continue;
          localObject = str;
          if (paramString != null)
          {
            localObject = str;
            if (paramString.length() > 0)
            {
              paramString = bo.d.aOn(paramString);
              localObject = str;
              if (paramString.zTO != null)
              {
                localObject = str;
                if (paramString.zTO.length() > 0) {
                  switch (paramString.scene)
                  {
                  case 19: 
                  case 20: 
                  case 21: 
                  default: 
                    localObject = paramContext.getString(2131759578, new Object[] { paramString.getDisplayName() });
                    break;
                  case 18: 
                    localObject = paramContext.getString(2131759559, new Object[] { paramString.getDisplayName() });
                    break;
                  case 22: 
                  case 23: 
                  case 24: 
                  case 26: 
                  case 27: 
                  case 28: 
                  case 29: 
                    localObject = paramContext.getString(2131759569, new Object[] { paramString.getDisplayName() });
                    break;
                  case 25: 
                    localObject = paramContext.getString(2131759491, new Object[] { paramString.getDisplayName() });
                    continue;
                    localObject = paramContext.getString(2131755904);
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
  }
  
  protected int getLayoutId()
  {
    return 2131492957;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(32956);
    setMMTitle(2131762415);
    this.alu = ((RecyclerView)findViewById(2131296644));
    this.iXo = ((ProgressBar)findViewById(2131303518));
    this.Hfe = findViewById(2131300746);
    this.alu.setVisibility(8);
    RecyclerView localRecyclerView = this.alu;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.Hff = new b();
    this.alu.setAdapter(this.Hff);
    this.Hff.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(32936);
        super.onChanged();
        ac.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[] { Integer.valueOf(AllRemindMsgUI.a(AllRemindMsgUI.this).getItemCount()) });
        if (AllRemindMsgUI.a(AllRemindMsgUI.this).getItemCount() == 0)
        {
          AllRemindMsgUI.b(AllRemindMsgUI.this).setVisibility(0);
          AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(8);
          AppMethodBeat.o(32936);
          return;
        }
        AllRemindMsgUI.b(AllRemindMsgUI.this).setVisibility(8);
        AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
        AppMethodBeat.o(32936);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(32937);
        AllRemindMsgUI.this.onBackPressed();
        AppMethodBeat.o(32937);
        return true;
      }
    });
    AppMethodBeat.o(32956);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(32957);
    finish();
    AppMethodBeat.o(32957);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32954);
    super.onCreate(paramBundle);
    az.agi().a(866, this.Hfg);
    az.agi().a(525, this);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(795L, 3L, 1L, false);
    initView();
    com.tencent.mm.sdk.g.b.c(new a(), "load remind data!");
    AppMethodBeat.o(32954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32955);
    super.onDestroy();
    az.agi().b(866, this.Hfg);
    az.agi().b(525, this);
    AppMethodBeat.o(32955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(32958);
    ac.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() != 525)
      {
        AppMethodBeat.o(32958);
        return;
      }
      paramString = (cwv)((y)paramn).hEg.hvr.hvw;
      paramn = this.oaX.listIterator();
      while (paramn.hasNext()) {
        if (((d)paramn.next()).Hfp == paramString.FGQ.FBg) {
          paramn.remove();
        }
      }
      this.Hff.arg.notifyChanged();
      AppMethodBeat.o(32958);
      return;
    }
    Toast.makeText(getContext(), bs.bG(paramString, getString(2131761751)), 0).show();
    AppMethodBeat.o(32958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.ak.g, Runnable
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(32941);
      ac.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.getType() != 866)
        {
          AppMethodBeat.o(32941);
          return;
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32939);
            Object localObject1 = ((bdo)((com.tencent.mm.modelsimple.p)paramn).hEg.hvs.hvw).ETC;
            LinkedList localLinkedList = new LinkedList();
            if (localObject1 != null)
            {
              Iterator localIterator = ((List)localObject1).iterator();
              if (localIterator.hasNext())
              {
                localObject1 = (coa)localIterator.next();
                AllRemindMsgUI.d locald = new AllRemindMsgUI.d(AllRemindMsgUI.this);
                locald.Hfo = ((coa)localObject1);
                locald.timestamp = (((coa)localObject1).pAS * 1000L);
                locald.subType = ((coa)localObject1).FvC;
                locald.Hfp = ((coa)localObject1).FBg;
                Object localObject3;
                if (((coa)localObject1).FvC == 1) {
                  localObject3 = new bwy();
                }
                for (;;)
                {
                  try
                  {
                    ((bwy)localObject3).parseFrom(((coa)localObject1).EuL.xy);
                    locald.title = ((bwy)localObject3).Title;
                    locald.username = ((bwy)localObject3).ncR;
                    locald.msgId = ((bwy)localObject3).vTQ;
                    if (locald.username != null)
                    {
                      if (!w.sQ(locald.username)) {
                        continue;
                      }
                      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(locald.username);
                      if (localObject1 != null)
                      {
                        if (((ai)localObject1).aaS() == null)
                        {
                          localObject1 = ((ai)localObject1).aaR();
                          locald.nickname = ((String)localObject1);
                        }
                      }
                      else
                      {
                        if (!bs.isNullOrNil(locald.nickname)) {
                          continue;
                        }
                        localObject1 = AllRemindMsgUI.this.getString(2131757293);
                        locald.nickname = ((String)localObject1);
                      }
                    }
                    else
                    {
                      ac.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", new Object[] { locald });
                      localLinkedList.add(locald);
                    }
                  }
                  catch (IOException localIOException1)
                  {
                    ac.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException1.toString() });
                    continue;
                    localObject2 = localIOException1.aaS();
                    continue;
                    localObject2 = locald.nickname;
                    continue;
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(locald.username);
                    if (((ai)localObject2).aaS() != null) {}
                  }
                  for (Object localObject2 = ((ai)localObject2).aaR();; localObject2 = ((ai)localObject2).aaS())
                  {
                    locald.nickname = ((String)localObject2);
                    break;
                  }
                  if (((coa)localObject2).FvC == 2)
                  {
                    localObject3 = new aho();
                    try
                    {
                      ((aho)localObject3).parseFrom(((coa)localObject2).EuL.xy);
                      locald.title = ((aho)localObject3).Title;
                      locald.sourceType = ((aho)localObject3).DPL;
                      locald.EBh = ((aho)localObject3).DPM;
                    }
                    catch (IOException localIOException2)
                    {
                      for (;;)
                      {
                        ac.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException2.toString() });
                      }
                    }
                  }
                }
              }
              AllRemindMsgUI.a(AllRemindMsgUI.this, localLinkedList);
            }
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(32938);
                AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
                AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
                AllRemindMsgUI.a(AllRemindMsgUI.this).arg.notifyChanged();
                AppMethodBeat.o(32938);
              }
            });
            AppMethodBeat.o(32939);
          }
        }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
        AppMethodBeat.o(32941);
        return;
      }
      ac.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
      AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
      AppMethodBeat.o(32941);
    }
    
    public final void run()
    {
      AppMethodBeat.i(32940);
      com.tencent.mm.modelsimple.p localp = new com.tencent.mm.modelsimple.p();
      az.agi().a(localp, 0);
      AppMethodBeat.o(32940);
    }
  }
  
  final class b
    extends RecyclerView.a
  {
    b() {}
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(32942);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495248, paramViewGroup, false);
      paramViewGroup = new AllRemindMsgUI.c(AllRemindMsgUI.this, paramViewGroup);
      AppMethodBeat.o(32942);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(32943);
      AllRemindMsgUI.d locald = (AllRemindMsgUI.d)AllRemindMsgUI.d(AllRemindMsgUI.this).get(paramInt);
      ((AllRemindMsgUI.c)paramw).asD.setTag(locald);
      ((AllRemindMsgUI.c)paramw).nMU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(AllRemindMsgUI.this.getContext(), locald.nickname, ((AllRemindMsgUI.c)paramw).nMU.getTextSize()));
      ((AllRemindMsgUI.c)paramw).titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(AllRemindMsgUI.this.getContext(), locald.title, ((AllRemindMsgUI.c)paramw).titleTv.getTextSize()));
      long l = System.currentTimeMillis();
      if (locald.timestamp - l < 60000L) {
        ((AllRemindMsgUI.c)paramw).Hfk.setText(AllRemindMsgUI.this.getContext().getString(2131759514, new Object[] { Integer.valueOf(1) }));
      }
      while (locald.subType == 2)
      {
        ((AllRemindMsgUI.c)paramw).iKw.setImageDrawable(AllRemindMsgUI.this.getContext().getResources().getDrawable(2131230943));
        AppMethodBeat.o(32943);
        return;
        if (locald.timestamp - l < 3600000L) {
          ((AllRemindMsgUI.c)paramw).Hfk.setText(AllRemindMsgUI.this.getContext().getString(2131759514, new Object[] { Long.valueOf((locald.timestamp - l) / 60000L) }));
        } else if (locald.timestamp - l < 10800000L) {
          ((AllRemindMsgUI.c)paramw).Hfk.setText(AllRemindMsgUI.this.getContext().getString(2131759513, new Object[] { Long.valueOf((locald.timestamp - l) / 3600000L), Long.valueOf((locald.timestamp - l - (locald.timestamp - l) / 3600000L * 3600000L) / 60000L) }));
        } else {
          ((AllRemindMsgUI.c)paramw).Hfk.setText(com.tencent.mm.pluginsdk.g.h.c(AllRemindMsgUI.this.getContext(), locald.timestamp, true));
        }
      }
      a.b.c(((AllRemindMsgUI.c)paramw).iKw, locald.username);
      AppMethodBeat.o(32943);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(32944);
      if (AllRemindMsgUI.d(AllRemindMsgUI.this) == null)
      {
        AppMethodBeat.o(32944);
        return 0;
      }
      int i = AllRemindMsgUI.d(AllRemindMsgUI.this).size();
      AppMethodBeat.o(32944);
      return i;
    }
  }
  
  final class c
    extends RecyclerView.w
  {
    TextView Hfk;
    View asD;
    ImageView iKw;
    TextView nMU;
    TextView titleTv;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(32950);
      this.asD = paramView;
      this.titleTv = ((TextView)paramView.findViewById(2131305902));
      this.Hfk = ((TextView)paramView.findViewById(2131305846));
      this.nMU = ((TextView)paramView.findViewById(2131302863));
      this.iKw = ((ImageView)paramView.findViewById(2131296996));
      this.asD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(32945);
          paramAnonymousView = (AllRemindMsgUI.d)paramAnonymousView.getTag();
          ac.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[] { paramAnonymousView });
          AllRemindMsgUI.c.b(AllRemindMsgUI.this, paramAnonymousView.username, paramAnonymousView.msgId);
          AppMethodBeat.o(32945);
        }
      });
      this.asD.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(32946);
          paramAnonymousView.setTag(2131306044, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          AppMethodBeat.o(32946);
          return false;
        }
      });
      this.asD.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(32949);
          a locala = new a(AllRemindMsgUI.this.getContext());
          int[] arrayOfInt = new int[2];
          if ((paramAnonymousView.getTag(2131306044) instanceof int[])) {
            arrayOfInt = (int[])paramAnonymousView.getTag(2131306044);
          }
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(32947);
              paramAnonymous2ContextMenu.add(0, 0, 0, AllRemindMsgUI.this.getContext().getString(2131757221));
              AppMethodBeat.o(32947);
            }
          }, new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32948);
              paramAnonymous2MenuItem = (AllRemindMsgUI.d)paramAnonymousView.getTag();
              ac.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[] { paramAnonymous2MenuItem });
              paramAnonymous2MenuItem = new y(2, paramAnonymous2MenuItem.Hfo);
              az.agi().a(paramAnonymous2MenuItem, 0);
              AppMethodBeat.o(32948);
            }
          }, arrayOfInt[0], arrayOfInt[1]);
          AppMethodBeat.o(32949);
          return true;
        }
      });
      AppMethodBeat.o(32950);
    }
  }
  
  final class d
  {
    String EBh;
    coa Hfo;
    String Hfp;
    long msgId;
    String nickname;
    int sourceType;
    int subType;
    long timestamp;
    String title;
    String username;
    
    d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(32952);
      String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + bs.aLJ(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.subType + ", msgId=" + this.msgId + ", sourceType=" + this.sourceType + ", sourceId='" + this.EBh + '\'' + '}';
      AppMethodBeat.o(32952);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI
 * JD-Core Version:    0.7.0.1
 */