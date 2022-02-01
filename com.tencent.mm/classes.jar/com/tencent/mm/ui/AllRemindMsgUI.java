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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.ui.base.o.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AllRemindMsgUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> gAU;
  private View OwX;
  private b OwY;
  private a OwZ;
  private ProgressBar krF;
  private RecyclerView mRecyclerView;
  private LinkedList<d> pYH;
  
  static
  {
    AppMethodBeat.i(32960);
    gAU = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(32960);
  }
  
  public AllRemindMsgUI()
  {
    AppMethodBeat.i(32953);
    this.OwZ = new a();
    AppMethodBeat.o(32953);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(32959);
    String str = "";
    Object localObject = k.b.HD(paramString);
    switch (paramInt1)
    {
    default: 
      localObject = paramContext.getString(2131763598);
    }
    for (;;)
    {
      AppMethodBeat.o(32959);
      return localObject;
      localObject = paramContext.getString(2131755996);
      continue;
      localObject = paramContext.getString(2131764321, new Object[] { Integer.valueOf((int)s.AO(new p(paramString).time)) });
      continue;
      localObject = paramContext.getString(2131755939);
      continue;
      if (62 == paramInt1) {}
      for (paramInt1 = 2131755987;; paramInt1 = 2131756018)
      {
        localObject = paramContext.getString(paramInt1);
        break;
      }
      bg.aVF();
      com.tencent.mm.model.c.aSQ().aEL(paramString);
      localObject = paramContext.getString(2131764288, new Object[] { "" });
      continue;
      localObject = paramContext.getString(2131755862);
      continue;
      if (localObject == null)
      {
        Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
        AppMethodBeat.o(32959);
        return "";
      }
      switch (((k.b)localObject).type)
      {
      default: 
        Log.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[] { Integer.valueOf(((k.b)localObject).type) });
        break;
      case 33: 
        localObject = paramContext.getString(2131755413);
        break;
      case 6: 
        localObject = paramContext.getString(2131764270, new Object[] { ((k.b)localObject).title });
        break;
      case 5: 
      case 7: 
        localObject = paramContext.getString(2131764316, new Object[] { "" });
        break;
      case 8: 
        localObject = paramContext.getString(2131755794);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(2131755793);
        break;
      case 25: 
        localObject = paramContext.getString(2131755781);
        break;
      case 17: 
        localObject = paramContext.getString(2131764288, new Object[] { "" });
        break;
      case 19: 
        localObject = paramContext.getString(2131764296, new Object[] { "" });
        break;
      case 24: 
        localObject = paramContext.getString(2131764295, new Object[] { "" });
        break;
      case 3: 
        localObject = paramContext.getString(2131764294, new Object[] { "" });
        break;
      case 4: 
        localObject = paramContext.getString(2131764317, new Object[] { "" });
        break;
      case 2: 
        localObject = paramContext.getString(2131755939);
        break;
      case 44: 
        if (Util.isNullOrNil(((k.b)localObject).w(paramContext, true))) {
          break;
        }
        localObject = ((k.b)localObject).w(paramContext, true) + " " + ((k.b)localObject).title;
        continue;
        localObject = paramContext.getString(2131755793);
        continue;
        localObject = paramContext.getString(2131764297);
        continue;
        if (localObject == null)
        {
          Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
          AppMethodBeat.o(32959);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131764264, new Object[] { ((k.b)localObject).iyo, "" });
        }
        else
        {
          localObject = paramContext.getString(2131764264, new Object[] { ((k.b)localObject).iyo, "" });
          continue;
          if (localObject == null)
          {
            Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
            AppMethodBeat.o(32959);
            return "";
          }
          localObject = paramContext.getString(2131764264, new Object[] { ((k.b)localObject).iyo, "" });
          continue;
          localObject = paramContext.getString(2131764265, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131764265, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131764257, new Object[] { "" });
          continue;
          localObject = paramContext.getString(2131764302, new Object[] { "" });
          continue;
          localObject = str;
          if (paramString != null)
          {
            localObject = str;
            if (paramString.length() > 0)
            {
              paramString = ca.d.bkD(paramString);
              localObject = str;
              if (paramString.dkU != null)
              {
                localObject = str;
                if (paramString.dkU.length() > 0) {
                  switch (paramString.scene)
                  {
                  case 19: 
                  case 20: 
                  case 21: 
                  default: 
                    localObject = paramContext.getString(2131760895, new Object[] { paramString.getDisplayName() });
                    break;
                  case 18: 
                    localObject = paramContext.getString(2131760876, new Object[] { paramString.getDisplayName() });
                    break;
                  case 22: 
                  case 23: 
                  case 24: 
                  case 26: 
                  case 27: 
                  case 28: 
                  case 29: 
                    localObject = paramContext.getString(2131760886, new Object[] { paramString.getDisplayName() });
                    break;
                  case 25: 
                    localObject = paramContext.getString(2131760806, new Object[] { paramString.getDisplayName() });
                    continue;
                    localObject = paramContext.getString(2131755996);
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
    return 2131492990;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(32956);
    setMMTitle(2131764481);
    this.mRecyclerView = ((RecyclerView)findViewById(2131296721));
    this.krF = ((ProgressBar)findViewById(2131306284));
    this.OwX = findViewById(2131302334);
    this.mRecyclerView.setVisibility(8);
    RecyclerView localRecyclerView = this.mRecyclerView;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.OwY = new b();
    this.mRecyclerView.setAdapter(this.OwY);
    this.OwY.a(new RecyclerView.c()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(32936);
        super.onChanged();
        Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[] { Integer.valueOf(AllRemindMsgUI.a(AllRemindMsgUI.this).getItemCount()) });
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
    bg.azz().a(866, this.OwZ);
    bg.azz().a(525, this);
    h.CyF.idkeyStat(795L, 3L, 1L, false);
    initView();
    ThreadPool.post(new a(), "load remind data!");
    AppMethodBeat.o(32954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32955);
    super.onDestroy();
    bg.azz().b(866, this.OwZ);
    bg.azz().b(525, this);
    AppMethodBeat.o(32955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(32958);
    Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() != 525)
      {
        AppMethodBeat.o(32958);
        return;
      }
      paramString = (dwg)((z)paramq).iUB.iLK.iLR;
      paramq = this.pYH.listIterator();
      while (paramq.hasNext()) {
        if (((d)paramq.next()).Oxi == paramString.MWJ.MQb) {
          paramq.remove();
        }
      }
      this.OwY.atj.notifyChanged();
      AppMethodBeat.o(32958);
      return;
    }
    Toast.makeText(getContext(), Util.nullAs(paramString, getString(2131763720)), 0).show();
    AppMethodBeat.o(32958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.ak.i, Runnable
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(32941);
      Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq.getType() != 866)
        {
          AppMethodBeat.o(32941);
          return;
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32939);
            Object localObject1 = ((bul)((com.tencent.mm.modelsimple.q)paramq).iUB.iLL.iLR).MaU;
            LinkedList localLinkedList = new LinkedList();
            if (localObject1 != null)
            {
              Iterator localIterator = ((List)localObject1).iterator();
              if (localIterator.hasNext())
              {
                localObject1 = (dmn)localIterator.next();
                AllRemindMsgUI.d locald = new AllRemindMsgUI.d(AllRemindMsgUI.this);
                locald.Oxh = ((dmn)localObject1);
                locald.timestamp = (((dmn)localObject1).rBX * 1000L);
                locald.subType = ((dmn)localObject1).MJT;
                locald.Oxi = ((dmn)localObject1).MQb;
                Object localObject3;
                if (((dmn)localObject1).MJT == 1) {
                  localObject3 = new crk();
                }
                for (;;)
                {
                  try
                  {
                    ((crk)localObject3).parseFrom(((dmn)localObject1).Lqr.zy);
                    locald.title = ((crk)localObject3).Title;
                    locald.username = ((crk)localObject3).UserName;
                    locald.msgId = ((crk)localObject3).Brn;
                    if (locald.username != null)
                    {
                      if (!ab.Eq(locald.username)) {
                        continue;
                      }
                      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(locald.username);
                      if (localObject1 != null)
                      {
                        if (Util.isNullOrNil(((ax)localObject1).field_conRemark))
                        {
                          localObject1 = ((ax)localObject1).field_nickname;
                          locald.nickname = ((String)localObject1);
                        }
                      }
                      else
                      {
                        if (!Util.isNullOrNil(locald.nickname)) {
                          continue;
                        }
                        localObject1 = AllRemindMsgUI.this.getString(2131757507);
                        locald.nickname = ((String)localObject1);
                      }
                    }
                    else
                    {
                      Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", new Object[] { locald });
                      localLinkedList.add(locald);
                    }
                  }
                  catch (IOException localIOException1)
                  {
                    Log.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException1.toString() });
                    continue;
                    localObject2 = localIOException1.field_conRemark;
                    continue;
                    localObject2 = locald.nickname;
                    continue;
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(locald.username);
                    if (((as)localObject2).arJ() != null) {}
                  }
                  for (Object localObject2 = ((as)localObject2).arI();; localObject2 = ((as)localObject2).arJ())
                  {
                    locald.nickname = ((String)localObject2);
                    break;
                  }
                  if (((dmn)localObject2).MJT == 2)
                  {
                    localObject3 = new anc();
                    try
                    {
                      ((anc)localObject3).parseFrom(((dmn)localObject2).Lqr.zy);
                      locald.title = ((anc)localObject3).Title;
                      locald.sourceType = ((anc)localObject3).KHd;
                      locald.Gah = ((anc)localObject3).KHe;
                    }
                    catch (IOException localIOException2)
                    {
                      for (;;)
                      {
                        Log.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", new Object[] { localIOException2.toString() });
                      }
                    }
                  }
                }
              }
              AllRemindMsgUI.a(AllRemindMsgUI.this, localLinkedList);
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(32938);
                AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
                AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
                AllRemindMsgUI.a(AllRemindMsgUI.this).atj.notifyChanged();
                AppMethodBeat.o(32938);
              }
            });
            AppMethodBeat.o(32939);
          }
        }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
        AppMethodBeat.o(32941);
        return;
      }
      Log.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AllRemindMsgUI.c(AllRemindMsgUI.this).setVisibility(0);
      AllRemindMsgUI.e(AllRemindMsgUI.this).setVisibility(8);
      AppMethodBeat.o(32941);
    }
    
    public final void run()
    {
      AppMethodBeat.i(32940);
      com.tencent.mm.modelsimple.q localq = new com.tencent.mm.modelsimple.q();
      bg.azz().a(localq, 0);
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
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496094, paramViewGroup, false);
      paramViewGroup = new AllRemindMsgUI.c(AllRemindMsgUI.this, paramViewGroup);
      AppMethodBeat.o(32942);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(32943);
      AllRemindMsgUI.d locald = (AllRemindMsgUI.d)AllRemindMsgUI.d(AllRemindMsgUI.this).get(paramInt);
      ((AllRemindMsgUI.c)paramv).aus.setTag(locald);
      ((AllRemindMsgUI.c)paramv).pIN.setText(com.tencent.mm.pluginsdk.ui.span.l.b(AllRemindMsgUI.this.getContext(), locald.nickname, ((AllRemindMsgUI.c)paramv).pIN.getTextSize()));
      ((AllRemindMsgUI.c)paramv).titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.b(AllRemindMsgUI.this.getContext(), locald.title, ((AllRemindMsgUI.c)paramv).titleTv.getTextSize()));
      long l = System.currentTimeMillis();
      if (locald.timestamp - l < 60000L) {
        ((AllRemindMsgUI.c)paramv).Oxd.setText(AllRemindMsgUI.this.getContext().getString(2131760829, new Object[] { Integer.valueOf(1) }));
      }
      while (locald.subType == 2)
      {
        ((AllRemindMsgUI.c)paramv).keC.setImageDrawable(AllRemindMsgUI.this.getContext().getResources().getDrawable(2131230966));
        AppMethodBeat.o(32943);
        return;
        if (locald.timestamp - l < 3600000L) {
          ((AllRemindMsgUI.c)paramv).Oxd.setText(AllRemindMsgUI.this.getContext().getString(2131760829, new Object[] { Long.valueOf((locald.timestamp - l) / 60000L) }));
        } else if (locald.timestamp - l < 10800000L) {
          ((AllRemindMsgUI.c)paramv).Oxd.setText(AllRemindMsgUI.this.getContext().getString(2131760828, new Object[] { Long.valueOf((locald.timestamp - l) / 3600000L), Long.valueOf((locald.timestamp - l - (locald.timestamp - l) / 3600000L * 3600000L) / 60000L) }));
        } else {
          ((AllRemindMsgUI.c)paramv).Oxd.setText(com.tencent.mm.pluginsdk.i.f.c(AllRemindMsgUI.this.getContext(), locald.timestamp, true));
        }
      }
      a.b.c(((AllRemindMsgUI.c)paramv).keC, locald.username);
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
    TextView Oxd;
    View aus;
    ImageView keC;
    TextView pIN;
    TextView titleTv;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(32950);
      this.aus = paramView;
      this.titleTv = ((TextView)paramView.findViewById(2131309195));
      this.Oxd = ((TextView)paramView.findViewById(2131309126));
      this.pIN = ((TextView)paramView.findViewById(2131305436));
      this.keC = ((ImageView)paramView.findViewById(2131297119));
      this.aus.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(32945);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = (AllRemindMsgUI.d)paramAnonymousView.getTag();
          Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[] { paramAnonymousView });
          AllRemindMsgUI.c.f(AllRemindMsgUI.this, paramAnonymousView.username, paramAnonymousView.msgId);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(32945);
        }
      });
      this.aus.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(32946);
          paramAnonymousView.setTag(2131309367, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          AppMethodBeat.o(32946);
          return false;
        }
      });
      this.aus.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(32949);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(AllRemindMsgUI.this.getContext());
          localObject = new int[2];
          if ((paramAnonymousView.getTag(2131309367) instanceof int[])) {
            localObject = (int[])paramAnonymousView.getTag(2131309367);
          }
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new o.g
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(32947);
              paramAnonymous2ContextMenu.add(0, 0, 0, AllRemindMsgUI.this.getContext().getString(2131757433));
              AppMethodBeat.o(32947);
            }
          }, new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32948);
              paramAnonymous2MenuItem = (AllRemindMsgUI.d)paramAnonymousView.getTag();
              Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[] { paramAnonymous2MenuItem });
              paramAnonymous2MenuItem = new z(2, paramAnonymous2MenuItem.Oxh);
              bg.azz().a(paramAnonymous2MenuItem, 0);
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
    String Gah;
    dmn Oxh;
    String Oxi;
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
      String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + Util.secPrint(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.subType + ", msgId=" + this.msgId + ", sourceType=" + this.sourceType + ", sourceId='" + this.Gah + '\'' + '}';
      AppMethodBeat.o(32952);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI
 * JD-Core Version:    0.7.0.1
 */