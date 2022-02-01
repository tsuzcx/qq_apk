package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.epi;
import com.tencent.mm.protocal.protobuf.fab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.ui.base.u.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AllRemindMsgUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> lNS;
  private View aduj;
  private b aduk;
  private a adul;
  private RecyclerView mRecyclerView;
  private ProgressBar qgC;
  private LinkedList<d> wza;
  
  static
  {
    AppMethodBeat.i(32960);
    lNS = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(32960);
  }
  
  public AllRemindMsgUI()
  {
    AppMethodBeat.i(32953);
    this.adul = new a();
    AppMethodBeat.o(32953);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(32959);
    String str = "";
    Object localObject = k.b.Hf(paramString);
    switch (paramInt1)
    {
    default: 
      localObject = paramContext.getString(R.l.gOS);
    }
    for (;;)
    {
      AppMethodBeat.o(32959);
      return localObject;
      localObject = paramContext.getString(R.l.app_text);
      continue;
      paramString = new com.tencent.mm.modelvoice.p(paramString);
      localObject = paramContext.getString(R.l.gSW, new Object[] { Integer.valueOf((int)com.tencent.mm.modelvoice.s.jh(paramString.time)) });
      continue;
      localObject = paramContext.getString(R.l.app_pic);
      continue;
      if (62 == paramInt1) {}
      for (paramInt1 = R.l.app_shortvideo;; paramInt1 = R.l.app_video)
      {
        localObject = paramContext.getString(paramInt1);
        break;
      }
      bh.bCz();
      com.tencent.mm.model.c.bzD().aLV(paramString);
      localObject = paramContext.getString(R.l.gSN, new Object[] { "" });
      continue;
      localObject = paramContext.getString(R.l.app_friend_card);
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
        localObject = paramContext.getString(R.l.app_brand_default_name_with_brackets);
        break;
      case 6: 
      case 74: 
        localObject = paramContext.getString(R.l.gSM, new Object[] { ((k.b)localObject).title });
        break;
      case 5: 
      case 7: 
        localObject = paramContext.getString(R.l.gSU, new Object[] { "" });
        break;
      case 8: 
        localObject = paramContext.getString(R.l.app_emoji2);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(R.l.app_emoji);
        break;
      case 25: 
        localObject = paramContext.getString(R.l.app_designer_share);
        break;
      case 17: 
        localObject = paramContext.getString(R.l.gSN, new Object[] { "" });
        break;
      case 19: 
        localObject = paramContext.getString(R.l.gSQ, new Object[] { "" });
        break;
      case 24: 
        localObject = paramContext.getString(R.l.gSP, new Object[] { "" });
        break;
      case 3: 
        localObject = paramContext.getString(R.l.gSO, new Object[] { "" });
        break;
      case 4: 
        localObject = paramContext.getString(R.l.gSV, new Object[] { "" });
        break;
      case 2: 
        localObject = paramContext.getString(R.l.app_pic);
        break;
      case 44: 
        if (Util.isNullOrNil(((k.b)localObject).B(paramContext, true))) {
          break;
        }
        localObject = ((k.b)localObject).B(paramContext, true) + " " + ((k.b)localObject).title;
        continue;
        localObject = paramContext.getString(R.l.app_emoji);
        continue;
        localObject = paramContext.getString(R.l.gSR);
        continue;
        if (localObject == null)
        {
          Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
          AppMethodBeat.o(32959);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(R.l.gSK, new Object[] { ((k.b)localObject).nSI, "" });
        }
        else
        {
          localObject = paramContext.getString(R.l.gSK, new Object[] { ((k.b)localObject).nSI, "" });
          continue;
          if (localObject == null)
          {
            Log.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
            AppMethodBeat.o(32959);
            return "";
          }
          localObject = paramContext.getString(R.l.gSK, new Object[] { ((k.b)localObject).nSI, "" });
          continue;
          localObject = paramContext.getString(R.l.gSL, new Object[] { "" });
          continue;
          localObject = paramContext.getString(R.l.gSL, new Object[] { "" });
          continue;
          localObject = paramContext.getString(R.l.gSJ, new Object[] { "" });
          continue;
          localObject = paramContext.getString(R.l.gST, new Object[] { "" });
          continue;
          localObject = str;
          if (paramString != null)
          {
            localObject = str;
            if (paramString.length() > 0)
            {
              paramString = cc.f.byv(paramString);
              localObject = str;
              if (paramString != null)
              {
                localObject = str;
                if (paramString.hgk != null)
                {
                  localObject = str;
                  if (paramString.hgk.length() > 0) {
                    switch (paramString.scene)
                    {
                    case 19: 
                    case 20: 
                    case 21: 
                    default: 
                      localObject = paramContext.getString(R.l.gIN, new Object[] { paramString.getDisplayName() });
                      break;
                    case 18: 
                      localObject = paramContext.getString(R.l.gII, new Object[] { paramString.getDisplayName() });
                      break;
                    case 22: 
                    case 23: 
                    case 24: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 29: 
                      localObject = paramContext.getString(R.l.gIL, new Object[] { paramString.getDisplayName() });
                      break;
                    case 25: 
                      localObject = paramContext.getString(R.l.gIm, new Object[] { paramString.getDisplayName() });
                      continue;
                      localObject = paramContext.getString(R.l.app_text);
                    }
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
    return R.i.gec;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(32956);
    setMMTitle(R.l.gTj);
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.frd));
    this.qgC = ((ProgressBar)findViewById(R.h.progress_bar));
    this.aduj = findViewById(R.h.fJM);
    this.mRecyclerView.setVisibility(8);
    RecyclerView localRecyclerView = this.mRecyclerView;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.aduk = new b();
    this.mRecyclerView.setAdapter(this.aduk);
    this.aduk.a(new RecyclerView.c()
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
    bh.aZW().a(866, this.adul);
    bh.aZW().a(525, this);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(795L, 3L, 1L, false);
    initView();
    ThreadPool.post(new a(), "load remind data!");
    AppMethodBeat.o(32954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32955);
    super.onDestroy();
    bh.aZW().b(866, this.adul);
    bh.aZW().b(525, this);
    AppMethodBeat.o(32955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(32958);
    Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() != 525)
      {
        AppMethodBeat.o(32958);
        return;
      }
      paramString = (fab)c.b.b(((aa)paramp).oDw.otB);
      if (this.wza != null)
      {
        paramp = this.wza.listIterator();
        while (paramp.hasNext()) {
          if (((d)paramp.next()).aduu == paramString.abAD.abtx) {
            paramp.remove();
          }
        }
      }
      this.aduk.bZE.notifyChanged();
      AppMethodBeat.o(32958);
      return;
    }
    Toast.makeText(getContext(), Util.nullAs(paramString, getString(R.l.gQp)), 0).show();
    AppMethodBeat.o(32958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements com.tencent.mm.am.h, Runnable
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(32941);
      Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp.getType() != 866)
        {
          AppMethodBeat.o(32941);
          return;
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32939);
            Object localObject1 = ((crm)c.c.b(((r)paramp).oDw.otC)).aaxY;
            LinkedList localLinkedList = new LinkedList();
            if (localObject1 != null)
            {
              Iterator localIterator = ((List)localObject1).iterator();
              if (localIterator.hasNext())
              {
                localObject1 = (epi)localIterator.next();
                AllRemindMsgUI.d locald = new AllRemindMsgUI.d(AllRemindMsgUI.this);
                locald.adut = ((epi)localObject1);
                locald.timestamp = (((epi)localObject1).crm * 1000L);
                locald.subType = ((epi)localObject1).abmA;
                locald.aduu = ((epi)localObject1).abtx;
                Object localObject3;
                if (((epi)localObject1).abmA == 1) {
                  localObject3 = new drn();
                }
                for (;;)
                {
                  try
                  {
                    ((drn)localObject3).parseFrom(((epi)localObject1).ZqS.Op);
                    locald.title = ((drn)localObject3).hAP;
                    locald.username = ((drn)localObject3).UserName;
                    locald.msgId = ((drn)localObject3).Njv;
                    if (locald.username != null)
                    {
                      if (!au.bwE(locald.username)) {
                        continue;
                      }
                      localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(locald.username);
                      if (localObject1 != null)
                      {
                        if (Util.isNullOrNil(((az)localObject1).field_conRemark))
                        {
                          localObject1 = ((az)localObject1).field_nickname;
                          locald.nickname = ((String)localObject1);
                        }
                      }
                      else
                      {
                        if (!Util.isNullOrNil(locald.nickname)) {
                          continue;
                        }
                        localObject1 = AllRemindMsgUI.this.getString(R.l.gzv);
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
                    localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(locald.username);
                    if (((au)localObject2).aSV() != null) {}
                  }
                  for (Object localObject2 = ((au)localObject2).aSU();; localObject2 = ((au)localObject2).aSV())
                  {
                    locald.nickname = ((String)localObject2);
                    break;
                  }
                  if (((epi)localObject2).abmA == 2)
                  {
                    localObject3 = new arw();
                    try
                    {
                      ((arw)localObject3).parseFrom(((epi)localObject2).ZqS.Op);
                      locald.title = ((arw)localObject3).hAP;
                      locald.sourceType = ((arw)localObject3).YFx;
                      locald.sourceId = ((arw)localObject3).YFy;
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
                AllRemindMsgUI.a(AllRemindMsgUI.this).bZE.notifyChanged();
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
      r localr = new r();
      bh.aZW().a(localr, 0);
      AppMethodBeat.o(32940);
    }
  }
  
  final class b
    extends RecyclerView.a
  {
    b() {}
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(249433);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gnB, paramViewGroup, false);
      paramViewGroup = new AllRemindMsgUI.c(AllRemindMsgUI.this, paramViewGroup);
      AppMethodBeat.o(249433);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(249439);
      AllRemindMsgUI.d locald = (AllRemindMsgUI.d)AllRemindMsgUI.d(AllRemindMsgUI.this).get(paramInt);
      ((AllRemindMsgUI.c)paramv).caK.setTag(locald);
      ((AllRemindMsgUI.c)paramv).nicknameTv.setText(com.tencent.mm.pluginsdk.ui.span.p.b(AllRemindMsgUI.this.getContext(), locald.nickname, ((AllRemindMsgUI.c)paramv).nicknameTv.getTextSize()));
      ((AllRemindMsgUI.c)paramv).titleTv.setText(com.tencent.mm.pluginsdk.ui.span.p.b(AllRemindMsgUI.this.getContext(), locald.title, ((AllRemindMsgUI.c)paramv).titleTv.getTextSize()));
      long l = System.currentTimeMillis();
      if (locald.timestamp - l < 60000L) {
        ((AllRemindMsgUI.c)paramv).adup.setText(AllRemindMsgUI.this.getContext().getString(R.l.fmt_in_some_min, new Object[] { Integer.valueOf(1) }));
      }
      while (locald.subType == 2)
      {
        ((AllRemindMsgUI.c)paramv).avatar.setImageDrawable(AllRemindMsgUI.this.getContext().getResources().getDrawable(R.g.app_add_to_favorite));
        AppMethodBeat.o(249439);
        return;
        if (locald.timestamp - l < 3600000L) {
          ((AllRemindMsgUI.c)paramv).adup.setText(AllRemindMsgUI.this.getContext().getString(R.l.fmt_in_some_min, new Object[] { Long.valueOf((locald.timestamp - l) / 60000L) }));
        } else if (locald.timestamp - l < 10800000L) {
          ((AllRemindMsgUI.c)paramv).adup.setText(AllRemindMsgUI.this.getContext().getString(R.l.fmt_in_some_hour_min, new Object[] { Long.valueOf((locald.timestamp - l) / 3600000L), Long.valueOf((locald.timestamp - l - (locald.timestamp - l) / 3600000L * 3600000L) / 60000L) }));
        } else {
          ((AllRemindMsgUI.c)paramv).adup.setText(com.tencent.mm.pluginsdk.platformtools.f.d(AllRemindMsgUI.this.getContext(), locald.timestamp, true));
        }
      }
      a.b.g(((AllRemindMsgUI.c)paramv).avatar, locald.username);
      AppMethodBeat.o(249439);
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
    TextView adup;
    ImageView avatar;
    View caK;
    TextView nicknameTv;
    TextView titleTv;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(32950);
      this.caK = paramView;
      this.titleTv = ((TextView)paramView.findViewById(R.h.title));
      this.adup = ((TextView)paramView.findViewById(R.h.fZW));
      this.nicknameTv = ((TextView)paramView.findViewById(R.h.nickname));
      this.avatar = ((ImageView)paramView.findViewById(R.h.avatar));
      this.caK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(32945);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = (AllRemindMsgUI.d)paramAnonymousView.getTag();
          Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[] { paramAnonymousView });
          AllRemindMsgUI.c.g(AllRemindMsgUI.this, paramAnonymousView.username, paramAnonymousView.msgId);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(32945);
        }
      });
      this.caK.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(32946);
          int i = (int)paramAnonymousMotionEvent.getRawX();
          int j = (int)paramAnonymousMotionEvent.getRawY();
          paramAnonymousView.setTag(R.h.touch_loc, new int[] { i, j });
          AppMethodBeat.o(32946);
          return false;
        }
      });
      this.caK.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(32949);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/AllRemindMsgUI$RemindHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(AllRemindMsgUI.this.getContext());
          localObject = new int[2];
          if ((paramAnonymousView.getTag(R.h.touch_loc) instanceof int[])) {
            localObject = (int[])paramAnonymousView.getTag(R.h.touch_loc);
          }
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new u.i
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(32947);
              paramAnonymous2ContextMenu.add(0, 0, 0, AllRemindMsgUI.this.getContext().getString(R.l.gyo));
              AppMethodBeat.o(32947);
            }
          }, new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32948);
              paramAnonymous2MenuItem = (AllRemindMsgUI.d)paramAnonymousView.getTag();
              Log.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[] { paramAnonymous2MenuItem });
              paramAnonymous2MenuItem = new aa(2, paramAnonymous2MenuItem.adut);
              bh.aZW().a(paramAnonymous2MenuItem, 0);
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
    epi adut;
    String aduu;
    long msgId;
    String nickname;
    String sourceId;
    int sourceType;
    int subType;
    long timestamp;
    String title;
    String username;
    
    d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(32952);
      String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + Util.secPrint(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.subType + ", msgId=" + this.msgId + ", sourceType=" + this.sourceType + ", sourceId='" + this.sourceId + '\'' + '}';
      AppMethodBeat.o(32952);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI
 * JD-Core Version:    0.7.0.1
 */