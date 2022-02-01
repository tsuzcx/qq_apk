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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.ui.base.n.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AllRemindMsgUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> fVO;
  private View Jnd;
  private b Jne;
  private a Jnf;
  private RecyclerView anl;
  private ProgressBar jtq;
  private LinkedList<d> oKT;
  
  static
  {
    AppMethodBeat.i(32960);
    fVO = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(32960);
  }
  
  public AllRemindMsgUI()
  {
    AppMethodBeat.i(32953);
    this.Jnf = new a();
    AppMethodBeat.o(32953);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(32959);
    String str = "";
    Object localObject = k.b.zb(paramString);
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
      localObject = paramContext.getString(2131762255, new Object[] { Integer.valueOf((int)s.sI(new p(paramString).time)) });
      continue;
      localObject = paramContext.getString(2131755853);
      continue;
      if (62 == paramInt1) {}
      for (paramInt1 = 2131755895;; paramInt1 = 2131755926)
      {
        localObject = paramContext.getString(paramInt1);
        break;
      }
      bc.aCg();
      com.tencent.mm.model.c.azI().arq(paramString);
      localObject = paramContext.getString(2131762242, new Object[] { "" });
      continue;
      localObject = paramContext.getString(2131755782);
      continue;
      if (localObject == null)
      {
        ae.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
        AppMethodBeat.o(32959);
        return "";
      }
      switch (((k.b)localObject).type)
      {
      default: 
        ae.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[] { Integer.valueOf(((k.b)localObject).type) });
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
        if (bu.isNullOrNil(((k.b)localObject).t(paramContext, true))) {
          break;
        }
        localObject = ((k.b)localObject).t(paramContext, true) + " " + ((k.b)localObject).title;
        continue;
        localObject = paramContext.getString(2131755722);
        continue;
        localObject = paramContext.getString(2131762246);
        continue;
        if (localObject == null)
        {
          ae.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
          AppMethodBeat.o(32959);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).hEi, "" });
        }
        else
        {
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).hEi, "" });
          continue;
          if (localObject == null)
          {
            ae.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
            AppMethodBeat.o(32959);
            return "";
          }
          localObject = paramContext.getString(2131762234, new Object[] { ((k.b)localObject).hEi, "" });
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
              paramString = bv.d.aVF(paramString);
              localObject = str;
              if (paramString.cUA != null)
              {
                localObject = str;
                if (paramString.cUA.length() > 0) {
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
    this.anl = ((RecyclerView)findViewById(2131296644));
    this.jtq = ((ProgressBar)findViewById(2131303518));
    this.Jnd = findViewById(2131300746);
    this.anl.setVisibility(8);
    RecyclerView localRecyclerView = this.anl;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.Jne = new b();
    this.anl.setAdapter(this.Jne);
    this.Jne.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(32936);
        super.onChanged();
        ae.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[] { Integer.valueOf(AllRemindMsgUI.a(AllRemindMsgUI.this).getItemCount()) });
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
    bc.ajj().a(866, this.Jnf);
    bc.ajj().a(525, this);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(795L, 3L, 1L, false);
    initView();
    com.tencent.mm.sdk.g.b.c(new a(), "load remind data!");
    AppMethodBeat.o(32954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32955);
    super.onDestroy();
    bc.ajj().b(866, this.Jnf);
    bc.ajj().b(525, this);
    AppMethodBeat.o(32955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(32958);
    ae.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() != 525)
      {
        AppMethodBeat.o(32958);
        return;
      }
      paramString = (ddc)((z)paramn).hZD.hQD.hQJ;
      paramn = this.oKT.listIterator();
      while (paramn.hasNext()) {
        if (((d)paramn.next()).Jno == paramString.HLa.HET) {
          paramn.remove();
        }
      }
      this.Jne.asY.notifyChanged();
      AppMethodBeat.o(32958);
      return;
    }
    Toast.makeText(getContext(), bu.bI(paramString, getString(2131761751)), 0).show();
    AppMethodBeat.o(32958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.ak.f, Runnable
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(32941);
      ae.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
            Object localObject1 = ((bik)((com.tencent.mm.modelsimple.q)paramn).hZD.hQE.hQJ).GWw;
            LinkedList localLinkedList = new LinkedList();
            if (localObject1 != null)
            {
              Iterator localIterator = ((List)localObject1).iterator();
              if (localIterator.hasNext())
              {
                localObject1 = (ctx)localIterator.next();
                AllRemindMsgUI.d locald = new AllRemindMsgUI.d(AllRemindMsgUI.this);
                locald.Jnn = ((ctx)localObject1);
                locald.timestamp = (((ctx)localObject1).qlc * 1000L);
                locald.subType = ((ctx)localObject1).Hzh;
                locald.Jno = ((ctx)localObject1).HET;
                Object localObject3;
                if (((ctx)localObject1).Hzh == 1) {
                  localObject3 = new cci();
                }
                for (;;)
                {
                  try
                  {
                    ((cci)localObject3).parseFrom(((ctx)localObject1).GuM.zr);
                    locald.title = ((cci)localObject3).Title;
                    locald.username = ((cci)localObject3).nIJ;
                    locald.msgId = ((cci)localObject3).xrk;
                    if (locald.username != null)
                    {
                      if (!x.wb(locald.username)) {
                        continue;
                      }
                      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(locald.username);
                      if (localObject1 != null)
                      {
                        if (((an)localObject1).adG() == null)
                        {
                          localObject1 = ((an)localObject1).adF();
                          locald.nickname = ((String)localObject1);
                        }
                      }
                      else
                      {
                        if (!bu.isNullOrNil(locald.nickname)) {
                          continue;
                        }
                        localObject1 = AllRemindMsgUI.this.getString(2131757293);
                        locald.nickname = ((String)localObject1);
                      }
                    }
                    else
                    {
                      ae.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", new Object[] { locald });
                      localLinkedList.add(locald);
                    }
                  }
                  catch (IOException localIOException1)
                  {
                    ae.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException1.toString() });
                    continue;
                    localObject2 = localIOException1.adG();
                    continue;
                    localObject2 = locald.nickname;
                    continue;
                    localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(locald.username);
                    if (((an)localObject2).adG() != null) {}
                  }
                  for (Object localObject2 = ((an)localObject2).adF();; localObject2 = ((an)localObject2).adG())
                  {
                    locald.nickname = ((String)localObject2);
                    break;
                  }
                  if (((ctx)localObject2).Hzh == 2)
                  {
                    localObject3 = new ako();
                    try
                    {
                      ((ako)localObject3).parseFrom(((ctx)localObject2).GuM.zr);
                      locald.title = ((ako)localObject3).Title;
                      locald.sourceType = ((ako)localObject3).FNy;
                      locald.GBC = ((ako)localObject3).FNz;
                    }
                    catch (IOException localIOException2)
                    {
                      for (;;)
                      {
                        ae.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException2.toString() });
                      }
                    }
                  }
                }
              }
              AllRemindMsgUI.a(AllRemindMsgUI.this, localLinkedList);
            }
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(32938);
                AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
                AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
                AllRemindMsgUI.a(AllRemindMsgUI.this).asY.notifyChanged();
                AppMethodBeat.o(32938);
              }
            });
            AppMethodBeat.o(32939);
          }
        }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
        AppMethodBeat.o(32941);
        return;
      }
      ae.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
      AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
      AppMethodBeat.o(32941);
    }
    
    public final void run()
    {
      AppMethodBeat.i(32940);
      com.tencent.mm.modelsimple.q localq = new com.tencent.mm.modelsimple.q();
      bc.ajj().a(localq, 0);
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
      ((AllRemindMsgUI.c)paramw).auu.setTag(locald);
      ((AllRemindMsgUI.c)paramw).ovs.setText(k.b(AllRemindMsgUI.this.getContext(), locald.nickname, ((AllRemindMsgUI.c)paramw).ovs.getTextSize()));
      ((AllRemindMsgUI.c)paramw).titleTv.setText(k.b(AllRemindMsgUI.this.getContext(), locald.title, ((AllRemindMsgUI.c)paramw).titleTv.getTextSize()));
      long l = System.currentTimeMillis();
      if (locald.timestamp - l < 60000L) {
        ((AllRemindMsgUI.c)paramw).Jnj.setText(AllRemindMsgUI.this.getContext().getString(2131759514, new Object[] { Integer.valueOf(1) }));
      }
      while (locald.subType == 2)
      {
        ((AllRemindMsgUI.c)paramw).jgy.setImageDrawable(AllRemindMsgUI.this.getContext().getResources().getDrawable(2131230943));
        AppMethodBeat.o(32943);
        return;
        if (locald.timestamp - l < 3600000L) {
          ((AllRemindMsgUI.c)paramw).Jnj.setText(AllRemindMsgUI.this.getContext().getString(2131759514, new Object[] { Long.valueOf((locald.timestamp - l) / 60000L) }));
        } else if (locald.timestamp - l < 10800000L) {
          ((AllRemindMsgUI.c)paramw).Jnj.setText(AllRemindMsgUI.this.getContext().getString(2131759513, new Object[] { Long.valueOf((locald.timestamp - l) / 3600000L), Long.valueOf((locald.timestamp - l - (locald.timestamp - l) / 3600000L * 3600000L) / 60000L) }));
        } else {
          ((AllRemindMsgUI.c)paramw).Jnj.setText(com.tencent.mm.pluginsdk.i.i.c(AllRemindMsgUI.this.getContext(), locald.timestamp, true));
        }
      }
      a.b.c(((AllRemindMsgUI.c)paramw).jgy, locald.username);
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
    TextView Jnj;
    View auu;
    ImageView jgy;
    TextView ovs;
    TextView titleTv;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(32950);
      this.auu = paramView;
      this.titleTv = ((TextView)paramView.findViewById(2131305902));
      this.Jnj = ((TextView)paramView.findViewById(2131305846));
      this.ovs = ((TextView)paramView.findViewById(2131302863));
      this.jgy = ((ImageView)paramView.findViewById(2131296996));
      this.auu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(32945);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = (AllRemindMsgUI.d)paramAnonymousView.getTag();
          ae.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[] { paramAnonymousView });
          AllRemindMsgUI.c.c(AllRemindMsgUI.this, paramAnonymousView.username, paramAnonymousView.msgId);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(32945);
        }
      });
      this.auu.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(32946);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          paramAnonymousView.setTag(2131306044, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(32946);
          return false;
        }
      });
      this.auu.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(32949);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(AllRemindMsgUI.this.getContext());
          localObject = new int[2];
          if ((paramAnonymousView.getTag(2131306044) instanceof int[])) {
            localObject = (int[])paramAnonymousView.getTag(2131306044);
          }
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(32947);
              paramAnonymous2ContextMenu.add(0, 0, 0, AllRemindMsgUI.this.getContext().getString(2131757221));
              AppMethodBeat.o(32947);
            }
          }, new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32948);
              paramAnonymous2MenuItem = (AllRemindMsgUI.d)paramAnonymousView.getTag();
              ae.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[] { paramAnonymous2MenuItem });
              paramAnonymous2MenuItem = new z(2, paramAnonymous2MenuItem.Jnn);
              bc.ajj().a(paramAnonymous2MenuItem, 0);
              AppMethodBeat.o(32948);
            }
          }, localObject[0], localObject[1]);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(32949);
          return true;
        }
      });
      AppMethodBeat.o(32950);
    }
  }
  
  final class d
  {
    String GBC;
    ctx Jnn;
    String Jno;
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
      String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + bu.aSM(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.subType + ", msgId=" + this.msgId + ", sourceType=" + this.sourceType + ", sourceId='" + this.GBC + '\'' + '}';
      AppMethodBeat.o(32952);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI
 * JD-Core Version:    0.7.0.1
 */