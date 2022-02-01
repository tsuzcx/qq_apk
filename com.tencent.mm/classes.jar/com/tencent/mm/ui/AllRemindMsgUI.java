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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AllRemindMsgUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private static final f<Integer, com.tencent.mm.protocal.b.a.c> fwL;
  private View FFW;
  private b FFX;
  private a FFY;
  private RecyclerView akA;
  private ProgressBar ixl;
  private LinkedList<d> nxX;
  
  static
  {
    AppMethodBeat.i(32960);
    fwL = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(32960);
  }
  
  public AllRemindMsgUI()
  {
    AppMethodBeat.i(32953);
    this.FFY = new a();
    AppMethodBeat.o(32953);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(32959);
    String str = "";
    Object localObject = k.b.rx(paramString);
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
      localObject = paramContext.getString(2131762255, new Object[] { Integer.valueOf((int)s.mI(new com.tencent.mm.modelvoice.p(paramString).time)) });
      continue;
      localObject = paramContext.getString(2131755853);
      continue;
      if (62 == paramInt1) {}
      for (paramInt1 = 2131755895;; paramInt1 = 2131755926)
      {
        localObject = paramContext.getString(paramInt1);
        break;
      }
      az.arV();
      com.tencent.mm.model.c.apO().agD(paramString);
      localObject = paramContext.getString(2131762242, new Object[] { "" });
      continue;
      localObject = paramContext.getString(2131755782);
      continue;
      if (localObject == null)
      {
        ad.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
        AppMethodBeat.o(32959);
        return "";
      }
      switch (((k.b)localObject).type)
      {
      default: 
        ad.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[] { Integer.valueOf(((k.b)localObject).type) });
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
        if (bt.isNullOrNil(((k.b)localObject).r(paramContext, true))) {
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
          ad.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
          AppMethodBeat.o(32959);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).gIL, "" });
        }
        else
        {
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).gIL, "" });
          continue;
          if (localObject == null)
          {
            ad.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
            AppMethodBeat.o(32959);
            return "";
          }
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).gIL, "" });
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
              paramString = bl.d.aIR(paramString);
              localObject = str;
              if (paramString.yGA != null)
              {
                localObject = str;
                if (paramString.yGA.length() > 0) {
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
    this.akA = ((RecyclerView)findViewById(2131296644));
    this.ixl = ((ProgressBar)findViewById(2131303518));
    this.FFW = findViewById(2131300746);
    this.akA.setVisibility(8);
    RecyclerView localRecyclerView = this.akA;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.FFX = new b();
    this.akA.setAdapter(this.FFX);
    this.FFX.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(32936);
        super.onChanged();
        ad.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[] { Integer.valueOf(AllRemindMsgUI.a(AllRemindMsgUI.this).getItemCount()) });
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
    az.aeS().a(866, this.FFY);
    az.aeS().a(525, this);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(795L, 3L, 1L, false);
    initView();
    com.tencent.mm.sdk.g.b.c(new a(), "load remind data!");
    AppMethodBeat.o(32954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32955);
    super.onDestroy();
    az.aeS().b(866, this.FFY);
    az.aeS().b(525, this);
    AppMethodBeat.o(32955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(32958);
    ad.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() != 525)
      {
        AppMethodBeat.o(32958);
        return;
      }
      paramString = (crm)((y)paramn).hdD.gUS.gUX;
      paramn = this.nxX.listIterator();
      while (paramn.hasNext()) {
        if (((d)paramn.next()).FGh == paramString.EjS.Eeg) {
          paramn.remove();
        }
      }
      this.FFX.aql.notifyChanged();
      AppMethodBeat.o(32958);
      return;
    }
    Toast.makeText(getContext(), bt.by(paramString, getString(2131761751)), 0).show();
    AppMethodBeat.o(32958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.al.g, Runnable
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(32941);
      ad.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
            Object localObject1 = ((azw)((com.tencent.mm.modelsimple.p)paramn).hdD.gUT.gUX).Dyg;
            LinkedList localLinkedList = new LinkedList();
            if (localObject1 != null)
            {
              Iterator localIterator = ((List)localObject1).iterator();
              if (localIterator.hasNext())
              {
                localObject1 = (cit)localIterator.next();
                AllRemindMsgUI.d locald = new AllRemindMsgUI.d(AllRemindMsgUI.this);
                locald.FGg = ((cit)localObject1);
                locald.timestamp = (((cit)localObject1).oXH * 1000L);
                locald.subType = ((cit)localObject1).DYI;
                locald.FGh = ((cit)localObject1).Eeg;
                Object localObject3;
                if (((cit)localObject1).DYI == 1) {
                  localObject3 = new bsh();
                }
                for (;;)
                {
                  try
                  {
                    ((bsh)localObject3).parseFrom(((cit)localObject1).DbF.wA);
                    locald.title = ((bsh)localObject3).Title;
                    locald.username = ((bsh)localObject3).mAQ;
                    locald.msgId = ((bsh)localObject3).uKZ;
                    if (locald.username != null)
                    {
                      if (!w.pF(locald.username)) {
                        continue;
                      }
                      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(locald.username);
                      if (localObject1 != null)
                      {
                        if (((af)localObject1).ZX() == null)
                        {
                          localObject1 = ((af)localObject1).ZW();
                          locald.nickname = ((String)localObject1);
                        }
                      }
                      else
                      {
                        if (!bt.isNullOrNil(locald.nickname)) {
                          continue;
                        }
                        localObject1 = AllRemindMsgUI.this.getString(2131757293);
                        locald.nickname = ((String)localObject1);
                      }
                    }
                    else
                    {
                      ad.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", new Object[] { locald });
                      localLinkedList.add(locald);
                    }
                  }
                  catch (IOException localIOException1)
                  {
                    ad.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException1.toString() });
                    continue;
                    localObject2 = localIOException1.ZX();
                    continue;
                    localObject2 = locald.nickname;
                    continue;
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(locald.username);
                    if (((af)localObject2).ZX() != null) {}
                  }
                  for (Object localObject2 = ((af)localObject2).ZW();; localObject2 = ((af)localObject2).ZX())
                  {
                    locald.nickname = ((String)localObject2);
                    break;
                  }
                  if (((cit)localObject2).DYI == 2)
                  {
                    localObject3 = new agp();
                    try
                    {
                      ((agp)localObject3).parseFrom(((cit)localObject2).DbF.wA);
                      locald.title = ((agp)localObject3).Title;
                      locald.sourceType = ((agp)localObject3).Cxp;
                      locald.Dib = ((agp)localObject3).Cxq;
                    }
                    catch (IOException localIOException2)
                    {
                      for (;;)
                      {
                        ad.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException2.toString() });
                      }
                    }
                  }
                }
              }
              AllRemindMsgUI.a(AllRemindMsgUI.this, localLinkedList);
            }
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(32938);
                AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
                AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
                AllRemindMsgUI.a(AllRemindMsgUI.this).aql.notifyChanged();
                AppMethodBeat.o(32938);
              }
            });
            AppMethodBeat.o(32939);
          }
        }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
        AppMethodBeat.o(32941);
        return;
      }
      ad.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
      AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
      AppMethodBeat.o(32941);
    }
    
    public final void run()
    {
      AppMethodBeat.i(32940);
      com.tencent.mm.modelsimple.p localp = new com.tencent.mm.modelsimple.p();
      az.aeS().a(localp, 0);
      AppMethodBeat.o(32940);
    }
  }
  
  final class b
    extends RecyclerView.a
  {
    b() {}
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(32942);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495248, paramViewGroup, false);
      paramViewGroup = new AllRemindMsgUI.c(AllRemindMsgUI.this, paramViewGroup);
      AppMethodBeat.o(32942);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(32943);
      AllRemindMsgUI.d locald = (AllRemindMsgUI.d)AllRemindMsgUI.d(AllRemindMsgUI.this).get(paramInt);
      ((AllRemindMsgUI.c)paramv).arI.setTag(locald);
      ((AllRemindMsgUI.c)paramv).nkb.setText(com.tencent.mm.pluginsdk.ui.span.k.b(AllRemindMsgUI.this.getContext(), locald.nickname, ((AllRemindMsgUI.c)paramv).nkb.getTextSize()));
      ((AllRemindMsgUI.c)paramv).titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(AllRemindMsgUI.this.getContext(), locald.title, ((AllRemindMsgUI.c)paramv).titleTv.getTextSize()));
      long l = System.currentTimeMillis();
      if (locald.timestamp - l < 60000L) {
        ((AllRemindMsgUI.c)paramv).FGc.setText(AllRemindMsgUI.this.getContext().getString(2131759514, new Object[] { Integer.valueOf(1) }));
      }
      while (locald.subType == 2)
      {
        ((AllRemindMsgUI.c)paramv).ikp.setImageDrawable(AllRemindMsgUI.this.getContext().getResources().getDrawable(2131230943));
        AppMethodBeat.o(32943);
        return;
        if (locald.timestamp - l < 3600000L) {
          ((AllRemindMsgUI.c)paramv).FGc.setText(AllRemindMsgUI.this.getContext().getString(2131759514, new Object[] { Long.valueOf((locald.timestamp - l) / 60000L) }));
        } else if (locald.timestamp - l < 10800000L) {
          ((AllRemindMsgUI.c)paramv).FGc.setText(AllRemindMsgUI.this.getContext().getString(2131759513, new Object[] { Long.valueOf((locald.timestamp - l) / 3600000L), Long.valueOf((locald.timestamp - l - (locald.timestamp - l) / 3600000L * 3600000L) / 60000L) }));
        } else {
          ((AllRemindMsgUI.c)paramv).FGc.setText(com.tencent.mm.pluginsdk.g.h.c(AllRemindMsgUI.this.getContext(), locald.timestamp, true));
        }
      }
      a.b.c(((AllRemindMsgUI.c)paramv).ikp, locald.username);
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
    extends RecyclerView.v
  {
    TextView FGc;
    View arI;
    ImageView ikp;
    TextView nkb;
    TextView titleTv;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(32950);
      this.arI = paramView;
      this.titleTv = ((TextView)paramView.findViewById(2131305902));
      this.FGc = ((TextView)paramView.findViewById(2131305846));
      this.nkb = ((TextView)paramView.findViewById(2131302863));
      this.ikp = ((ImageView)paramView.findViewById(2131296996));
      this.arI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(32945);
          paramAnonymousView = (AllRemindMsgUI.d)paramAnonymousView.getTag();
          ad.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[] { paramAnonymousView });
          AllRemindMsgUI.c.b(AllRemindMsgUI.this, paramAnonymousView.username, paramAnonymousView.msgId);
          AppMethodBeat.o(32945);
        }
      });
      this.arI.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(32946);
          paramAnonymousView.setTag(2131306044, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          AppMethodBeat.o(32946);
          return false;
        }
      });
      this.arI.setOnLongClickListener(new View.OnLongClickListener()
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
              ad.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[] { paramAnonymous2MenuItem });
              paramAnonymous2MenuItem = new y(2, paramAnonymous2MenuItem.FGg);
              az.aeS().a(paramAnonymous2MenuItem, 0);
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
    String Dib;
    cit FGg;
    String FGh;
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
      String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + bt.aGs(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.subType + ", msgId=" + this.msgId + ", sourceType=" + this.sourceType + ", sourceId='" + this.Dib + '\'' + '}';
      AppMethodBeat.o(32952);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI
 * JD-Core Version:    0.7.0.1
 */