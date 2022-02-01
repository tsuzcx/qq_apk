package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TopStoryListVideoUI
  extends TopStoryBaseVideoUI
  implements b
{
  private ProgressDialog Gpc;
  private View Gpd;
  private View Gpe;
  private View Gpf;
  private Button Gpg;
  View Gph;
  com.tencent.mm.plugin.topstory.ui.widget.c Gpi;
  View Gpj;
  TopStoryCommentFloatDialog Gpk;
  private boolean Gpl;
  private View Gqa;
  private TextView Gqb;
  private e Gqc;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d Gqd;
  private View Gqe;
  private View Gqf;
  View Gqg;
  com.tencent.mm.plugin.topstory.ui.widget.c Gqh;
  View Gqi;
  private long Gqj = 0L;
  
  private void fzO()
  {
    AppMethodBeat.i(126522);
    if (!this.Gna)
    {
      this.Gpe.setVisibility(0);
      this.Gpd.setVisibility(0);
    }
    for (;;)
    {
      this.GmT.ace(0);
      AppMethodBeat.o(126522);
      return;
      this.Gqf.setVisibility(0);
      this.Gqe.setVisibility(0);
    }
  }
  
  private void fzS()
  {
    AppMethodBeat.i(126535);
    if (com.tencent.mm.ui.ao.aQ(this))
    {
      int i = com.tencent.mm.ui.ao.aP(this);
      Object localObject = (RelativeLayout.LayoutParams)this.tql.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.tql.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.Gqa.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.Gqa.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(126535);
  }
  
  public final void KC()
  {
    AppMethodBeat.i(126534);
    long l = System.currentTimeMillis();
    if (l - this.Gqj < 1000L)
    {
      AppMethodBeat.o(126534);
      return;
    }
    this.Gqj = l;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.GmS.GnY != null)
    {
      this.GjJ.Nih = this.GmS.GnY.getControlBar().getmPosition();
      if (this.GmS.GnY.getControlBar().getVideoTotalTime() - this.GjJ.Nih < 2)
      {
        AppMethodBeat.o(126534);
        return;
      }
    }
    wv(false);
    this.Gna = false;
    this.Gqg.setVisibility(8);
    this.Gph.setVisibility(8);
    if (!fyL()) {
      setRequestedOrientation(1);
    }
    if ((this.GmX != null) && (this.GmX.isShowing()))
    {
      this.GmX.dismiss();
      this.GmX = null;
    }
    this.Gqa.setVisibility(0);
    if (fyD().Nid == null) {
      this.jVO.setVisibility(0);
    }
    this.GmC.setVisibility(0);
    this.GmF.setVisibility(8);
    this.Gqd.atj.notifyChanged();
    this.Gpf.setVisibility(8);
    this.Gqc.GpB = true;
    this.pcs.ah(fyD().Nig + this.Gqc.getHeadersCount(), fyN());
    getSwipeBackLayout().setEnableGesture(true);
    wv(true);
    fzS();
    AppMethodBeat.o(126534);
  }
  
  public final void KD()
  {
    AppMethodBeat.i(126533);
    long l = System.currentTimeMillis();
    if (l - this.Gqj < 1000L)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.Gqj = l;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    if (this.GmS.GnY != null)
    {
      this.GjJ.Nih = this.GmS.GnY.getControlBar().getmPosition();
      if (this.GmS.GnY.getControlBar().getVideoTotalTime() - this.GjJ.Nih < 2)
      {
        AppMethodBeat.o(126533);
        return;
      }
    }
    wv(false);
    this.Gna = true;
    this.Gqg.setVisibility(8);
    this.Gph.setVisibility(8);
    if (!fyL()) {
      setRequestedOrientation(0);
    }
    if ((this.GmX != null) && (this.GmX.isShowing()))
    {
      this.GmX.dismiss();
      this.GmX = null;
    }
    this.Gqa.setVisibility(8);
    this.jVO.setVisibility(8);
    this.GmA.setVisibility(8);
    this.GmC.setVisibility(8);
    this.GmF.setVisibility(0);
    this.Gqc.atj.notifyChanged();
    if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ohn, 0) == 0)
    {
      this.GmS.cXa();
      this.Gpf.setVisibility(0);
      this.Gpf.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.Gpg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126513);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohn, Integer.valueOf(1));
          TopStoryListVideoUI.this.GmS.eYd();
          TopStoryListVideoUI.h(TopStoryListVideoUI.this).setVisibility(8);
          TopStoryListVideoUI.i(TopStoryListVideoUI.this).b(TopStoryListVideoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126513);
        }
      });
    }
    for (;;)
    {
      this.Gqd.Gol = true;
      this.GmG.ah(fyD().Nig, 0);
      getSwipeBackLayout().setEnableGesture(false);
      wv(true);
      if (com.tencent.mm.ui.ao.aQ(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tql.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        this.tql.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(126533);
      return;
      this.Gpf.setVisibility(8);
    }
  }
  
  public final void a(dyi paramdyi)
  {
    AppMethodBeat.i(126537);
    if (this.Gna) {
      KC();
    }
    this.GmP.Gnu = true;
    this.GmS.stopPlay();
    eiw localeiw = this.GmT.acd(fyH());
    eit localeit = com.tencent.mm.plugin.topstory.a.h.a(fyD());
    localeit.sGQ = UUID.randomUUID().toString();
    localeit.NhX = localeiw.psI;
    localeit.Nib = paramdyi.MXW;
    localeit.Nic = null;
    localeit.Nid = paramdyi;
    localeit.Nie = this.GmP.Gnu;
    Object localObject = localeit.IDO.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject).next();
      if ("show_tag_list".equals(localaca.key)) {
        localaca.LmD = paramdyi.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new aca();
        ((aca)localObject).key = "show_tag_list";
        ((aca)localObject).LmD = paramdyi.id;
        localeit.IDO.add(localObject);
      }
      ai.a(this, localeit, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.pl(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(fyD(), localeiw, fyH(), 4, paramdyi.dQx + ":" + paramdyi.id);
      AppMethodBeat.o(126537);
      return;
    }
  }
  
  public final void a(eiw parameiw, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126539);
    if (fyD().Nid != null)
    {
      AppMethodBeat.o(126539);
      return;
    }
    if ((parameiw == null) || (parameiw.Niz == null))
    {
      AppMethodBeat.o(126539);
      return;
    }
    Object localObject = this.GmQ.GnT;
    int i;
    int j;
    if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).Gjm != 0L))
    {
      long l = (System.currentTimeMillis() - ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Gjm) / 1000L;
      i = parameiw.Niz.NhT - 10;
      paramInt2 = parameiw.Niz.NhU * paramInt2 / 100 - 10;
      if ((!parameiw.Niz.NhW) && (l >= i) && (paramInt1 >= paramInt2))
      {
        localObject = this.GmT;
        eit localeit = this.GjJ;
        j = this.GmT.fzy();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", new Object[] { parameiw.psI, Integer.valueOf(j), Long.valueOf(l) });
        if (((n)localObject).GnI != null)
        {
          com.tencent.mm.kernel.g.azz().a(((n)localObject).GnI);
          ((n)localObject).GnI = null;
        }
        localeit = com.tencent.mm.plugin.topstory.a.h.a(localeit);
        localeit.offset = j;
        ((n)localObject).GnI = new com.tencent.mm.plugin.topstory.a.c.h(localeit, ((n)localObject).GlS.fyH(), parameiw, l);
        com.tencent.mm.kernel.g.azz().a(((n)localObject).GnI, 0);
        com.tencent.mm.kernel.g.azz().a(1943, ((n)localObject).gNh);
        parameiw.Niz.NhW = true;
      }
      if ((!parameiw.Niz.dEF) && (l >= i + 10) && (paramInt1 >= paramInt2 + 10))
      {
        parameiw.Niz.dEF = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", new Object[] { Integer.valueOf(parameiw.Niz.NhV.size()) });
        parameiw = parameiw.Niz.NhV.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (parameiw.hasNext())
        {
          localObject = (eiw)parameiw.next();
          if (((eiw)localObject).Niz == null)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", new Object[] { ((eiw)localObject).psI });
            continue;
            AppMethodBeat.o(126539);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", new Object[] { ((eiw)localObject).psI, Integer.valueOf(((eiw)localObject).Niz.NhR) });
            if (((eiw)localObject).Niz.NhR == 2)
            {
              paramInt2 = ((eiw)localObject).Niz.Kmn;
              j = fyH();
              if (paramInt2 > 0)
              {
                paramInt1 = paramInt2;
                label492:
                paramInt1 = j + paramInt1;
                i = this.GmT.fzy() - 1;
                if (paramInt1 <= i) {
                  break label614;
                }
                paramInt1 = i;
              }
            }
          }
        }
      }
    }
    label614:
    for (;;)
    {
      this.GmT.GW().add(paramInt1, localObject);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), ((eiw)localObject).psI, ((eiw)localObject).title });
      getRecyclerView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126499);
          TopStoryListVideoUI.this.fyK().cj(paramInt1 + TopStoryListVideoUI.this.fyK().getHeadersCount());
          AppMethodBeat.o(126499);
        }
      });
      break;
      paramInt1 = 1;
      break label492;
      AppMethodBeat.o(126539);
      return;
    }
  }
  
  public final void a(final eiw parameiw, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126541);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { parameiw.psI, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.Gqg.getVisibility() == 0)
      {
        if ((this.Gqh != null) && (this.Gqh.vid != null) && (this.Gqh.vid.equals(parameiw.psI)))
        {
          this.Gqg.setVisibility(8);
          AppMethodBeat.o(126541);
        }
      }
      else if ((this.Gph.getVisibility() == 0) && (this.Gpi != null) && (this.Gpi.vid != null) && (this.Gpi.vid.equals(parameiw.psI))) {
        this.Gph.setVisibility(8);
      }
      AppMethodBeat.o(126541);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = parameiw.wWb;
    Object localObject3 = parameiw.title;
    Object localObject4 = fyD().hes;
    int j = fyD().scene;
    if (fyL()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, parameiw.psI, parameiw.NiD);
      if (!this.Gna) {
        break;
      }
      this.Gqg.setVisibility(0);
      this.Gph.setVisibility(8);
      this.Gqh = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Gqi, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126502);
          TopStoryListVideoUI.this.Gpk.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void fzQ()
            {
              AppMethodBeat.i(126501);
              TopStoryListVideoUI.this.Gqg.setVisibility(8);
              TopStoryListVideoUI.this.Gph.setVisibility(8);
              AppMethodBeat.o(126501);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126500);
              TopStoryListVideoUI.this.GmS.eYd();
              AppMethodBeat.o(126500);
            }
          }, (int)TopStoryListVideoUI.j(TopStoryListVideoUI.this).Nib, parameiw.Nis);
          if (TopStoryListVideoUI.this.GmS.dFG()) {
            TopStoryListVideoUI.this.GmS.cXa();
          }
          AppMethodBeat.o(126502);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, parameiw.psI);
      parameiw = this.Gqh;
      i = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0F);
      localObject2 = paramView.getContext();
      localObject3 = parameiw.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      j = paramView.getWidth();
      int k = com.tencent.mm.ui.ao.az((Context)localObject2).x;
      ((View)localObject3).measure(0, 0);
      int m = ((View)localObject3).getMeasuredHeight();
      int n = ((View)localObject3).getMeasuredWidth();
      int i1 = localObject4[0];
      localObject1[0] = (j / 2 + i1 - n / 2);
      localObject4[1] -= m;
      org.xwalk.core.Log.i("PopupUtil", "window pos x:" + localObject1[0] + ", windowWidth:" + n + ", screenWidth:" + k);
      if (localObject1[0] + n > k) {
        localObject1[0] = (k - n);
      }
      localObject1[0] += 0;
      localObject1[1] = (i + localObject1[1]);
      paramView = (LinearLayout.LayoutParams)parameiw.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      parameiw.contentView.setLayoutParams(paramView);
      this.Gqg.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126503);
          if (TopStoryListVideoUI.this.Gqg.getVisibility() == 0) {
            TopStoryListVideoUI.this.Gqg.setVisibility(8);
          }
          AppMethodBeat.o(126503);
        }
      }, 1800L);
      AppMethodBeat.o(126541);
      return;
    }
    this.Gqg.setVisibility(8);
    this.Gph.setVisibility(0);
    this.Gpi = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Gpj, new c.a()
    {
      public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
      {
        AppMethodBeat.i(126506);
        TopStoryListVideoUI.this.Gpk.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
        {
          public final void fzQ()
          {
            AppMethodBeat.i(126505);
            TopStoryListVideoUI.this.Gqg.setVisibility(8);
            TopStoryListVideoUI.this.Gph.setVisibility(8);
            AppMethodBeat.o(126505);
          }
          
          public final void onDismiss()
          {
            AppMethodBeat.i(126504);
            TopStoryListVideoUI.this.GmS.eYd();
            AppMethodBeat.o(126504);
          }
        }, (int)TopStoryListVideoUI.k(TopStoryListVideoUI.this).Nib, parameiw.Nis);
        if (TopStoryListVideoUI.this.GmS.dFG()) {
          TopStoryListVideoUI.this.GmS.cXa();
        }
        AppMethodBeat.o(126506);
      }
    }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, parameiw.psI);
    this.Gpi.a(paramView, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0F));
    AppMethodBeat.o(126541);
  }
  
  public final void a(eiw parameiw, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt)
  {
    AppMethodBeat.i(126538);
    if ((parameiw.NiI != null) && (parameiw.NiI.NhN != null)) {
      if ((paramInt >= parameiw.NiI.LHa) && (paramInt <= parameiw.NiI.iqg))
      {
        if (!parameiw.NiI.dEF)
        {
          parameiw.NiI.dEF = true;
          paramf.fzf();
          AppMethodBeat.o(126538);
        }
      }
      else {
        paramf.fzg();
      }
    }
    AppMethodBeat.o(126538);
  }
  
  public final void aTE(final String paramString)
  {
    AppMethodBeat.i(126529);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126512);
        if (!TopStoryListVideoUI.this.Gna)
        {
          TopStoryListVideoUI.a(TopStoryListVideoUI.this).setVisibility(4);
          TopStoryListVideoUI.b(TopStoryListVideoUI.this).setVisibility(4);
        }
        for (;;)
        {
          if (TopStoryListVideoUI.f(TopStoryListVideoUI.this) != null)
          {
            TopStoryListVideoUI.f(TopStoryListVideoUI.this).dismiss();
            TopStoryListVideoUI.g(TopStoryListVideoUI.this);
          }
          TopStoryListVideoUI.a(TopStoryListVideoUI.this, paramString);
          AppMethodBeat.o(126512);
          return;
          TopStoryListVideoUI.c(TopStoryListVideoUI.this).setVisibility(4);
          TopStoryListVideoUI.d(TopStoryListVideoUI.this).setVisibility(4);
        }
      }
    });
    AppMethodBeat.o(126529);
  }
  
  public final boolean abU(int paramInt)
  {
    AppMethodBeat.i(126527);
    this.Gph.setVisibility(8);
    this.Gqg.setVisibility(8);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.Gna) {
          continue;
        }
        if (paramInt < this.GmH.getItemCount() - this.GmH.getFootersCount() - this.GmH.getHeadersCount())
        {
          RecyclerView localRecyclerView = this.GmF;
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(126527);
          return true;
        }
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.GmH.getItemCount()), Integer.valueOf(this.GmH.getFootersCount()), Integer.valueOf(this.GmH.getHeadersCount()) });
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(126527);
      return false;
      if (paramInt < this.Gqc.getItemCount() - this.Gqc.getFootersCount() - this.Gqc.getHeadersCount())
      {
        this.GmE.a(this, this.Gqc.getHeadersCount() + paramInt);
        AppMethodBeat.o(126527);
        return true;
      }
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Gqc.getItemCount()), Integer.valueOf(this.Gqc.getFootersCount()), Integer.valueOf(this.Gqc.getHeadersCount()) });
    }
  }
  
  public final void acb(int paramInt)
  {
    AppMethodBeat.i(126530);
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (!bool) {
        break label125;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label96;
      }
      if (!this.Gna) {
        break;
      }
      AppMethodBeat.o(126530);
      return;
    }
    KD();
    AppMethodBeat.o(126530);
    return;
    label96:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.Gna)
      {
        AppMethodBeat.o(126530);
        return;
      }
      KC();
    }
    label125:
    AppMethodBeat.o(126530);
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(126515);
    super.amZ();
    if (fyD().Nic != null) {
      this.GmT.h(fyD().Nic);
    }
    AppMethodBeat.o(126515);
  }
  
  public final int fyN()
  {
    AppMethodBeat.i(126536);
    if (com.tencent.mm.ui.ao.aQ(this))
    {
      i = super.fyN();
      int j = com.tencent.mm.ui.ao.aP(this);
      AppMethodBeat.o(126536);
      return i + j;
    }
    int i = super.fyN();
    AppMethodBeat.o(126536);
    return i;
  }
  
  public final int fyS()
  {
    return 0;
  }
  
  public final void fyx()
  {
    AppMethodBeat.i(126524);
    if (!this.Gna) {
      this.Gqa.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.tql.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((fyD().Nid != null) && (this.Gqb != null)) {
        this.Gqb.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(126524);
      return;
      this.Gqg.setVisibility(8);
    }
  }
  
  public final void fyy()
  {
    AppMethodBeat.i(126525);
    this.tql.animate().cancel();
    this.tql.setAlpha(1.0F);
    if ((fyD().Nid != null) && (this.Gqb != null)) {
      this.Gqb.setAlpha(1.0F);
    }
    AppMethodBeat.o(126525);
  }
  
  public final void fzm()
  {
    AppMethodBeat.i(126518);
    super.fzm();
    if (this.Gna)
    {
      KC();
      AppMethodBeat.o(126518);
      return;
    }
    if (this.GjJ != null)
    {
      this.GmQ.fzC();
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.GjJ.guh);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.GjJ.Nij);
      localIntent.putExtra("key_video_play_info", Util.listToString(this.GmQ.GnU, ";"));
      localIntent.putExtra("key_search_id", fyD().hes);
      setResult(-1, localIntent);
    }
    if (!this.GmJ.O(2, false)) {
      finish();
    }
    if (!this.Utu.wu(2)) {
      finish();
    }
    AppMethodBeat.o(126518);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d fzn()
  {
    AppMethodBeat.i(126520);
    d locald = new d();
    AppMethodBeat.o(126520);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d fzo()
  {
    AppMethodBeat.i(126540);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(126540);
    return localc;
  }
  
  public final void fzp()
  {
    AppMethodBeat.i(126526);
    super.fzp();
    if ((!this.Gna) && (this.Gqa.getAlpha() != 0.0F))
    {
      this.Gqa.animate().cancel();
      this.Gqa.setAlpha(0.0F);
    }
    AppMethodBeat.o(126526);
  }
  
  public final void fzq()
  {
    AppMethodBeat.i(126521);
    if (!this.Gna)
    {
      this.Gpe.setVisibility(0);
      this.Gpd.setVisibility(0);
    }
    for (;;)
    {
      this.GmT.ace(this.GmT.fzy());
      AppMethodBeat.o(126521);
      return;
      this.Gqf.setVisibility(0);
      this.Gqe.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e fzs()
  {
    AppMethodBeat.i(126531);
    this.Gqc = new e(this);
    e locale = this.Gqc;
    View localView1 = LayoutInflater.from(this).inflate(2131496750, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(2131302280);
    View localView2 = localView1.findViewById(2131302294);
    if (fyD().Nid != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.Gqb = ((TextView)localView1.findViewById(2131302313));
      this.Gqb.setText(fyD().Nid.title);
      localObject = (TextView)localView1.findViewById(2131308716);
      if (!Util.isNullOrNil(fyD().Nid.oqZ)) {
        ((TextView)localObject).setText(fyD().Nid.oqZ);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (com.tencent.mm.ui.ao.aQ(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = com.tencent.mm.ui.ao.aP(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.addHeaderView(localView1);
      locale = this.Gqc;
      localView1 = LayoutInflater.from(this).inflate(2131496752, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cb.a.jo(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(2131167066));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.Gpe = localView1.findViewById(2131301672);
      this.Gpd = localView1.findViewById(2131301676);
      locale.fT(localView1);
      locale = this.Gqc;
      AppMethodBeat.o(126531);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e fzt()
  {
    AppMethodBeat.i(126532);
    this.Gqd = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.Gqd;
    View localView = LayoutInflater.from(this).inflate(2131496752, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.Gqf = localView.findViewById(2131301672);
    this.Gqe = localView.findViewById(2131301676);
    locald.fT(localView);
    locald = this.Gqd;
    AppMethodBeat.o(126532);
    return locald;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126516);
    if ((this.Gna) && (!fyL()))
    {
      AppMethodBeat.o(126516);
      return 0;
    }
    AppMethodBeat.o(126516);
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496753;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(126519);
    super.initContentView();
    this.Gpf = findViewById(2131301805);
    this.Gpg = ((Button)findViewById(2131307338));
    this.Gqa = findViewById(2131309207);
    this.Gqa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126498);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((TopStoryListVideoUI.this.GmS.GnZ) && (TopStoryListVideoUI.this.GmS.GnY.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.GmS.GnY.getItemUIComponent().fyy();
          TopStoryListVideoUI.this.GmS.GnY.getItemUIComponent().fyx();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126498);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
    if (fyD().Nid != null) {
      this.jVO.setVisibility(8);
    }
    this.GmQ.GnS = 2;
    if (fzr()) {
      if (this.GmP.isConnected())
      {
        fzO();
        this.Gpl = false;
        if ((fyD().scene != 21) && (fyD().Nid == null)) {
          this.Gpc = com.tencent.mm.ui.base.h.a(this, getString(2131762446), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(126507);
              TopStoryListVideoUI.this.finish();
              AppMethodBeat.o(126507);
            }
          });
        }
      }
    }
    for (;;)
    {
      this.Gqc.Gpq = true;
      if (fyD().Nie) {
        this.GmP.Gnu = true;
      }
      this.GmC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126508);
          TopStoryListVideoUI.this.GmQ.fzB();
          AppMethodBeat.o(126508);
        }
      });
      new c(this).f(this.GmC);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().f(this.GmF);
      this.Gph = findViewById(2131299653);
      this.Gpj = findViewById(2131299654);
      this.Gph.setVisibility(8);
      this.Gqg = findViewById(2131299648);
      this.Gqi = findViewById(2131299649);
      this.Gqg.setVisibility(8);
      this.Gph.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126509);
          if (TopStoryListVideoUI.this.Gph.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.i(TopStoryListVideoUI.this.Gpj, f1, f2))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewNotFull");
              AppMethodBeat.o(126509);
              return false;
            }
            TopStoryListVideoUI.this.Gph.setVisibility(8);
          }
          AppMethodBeat.o(126509);
          return false;
        }
      });
      this.Gqg.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126510);
          if (TopStoryListVideoUI.this.Gqg.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.i(TopStoryListVideoUI.this.Gqi, f1, f2))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewFull");
              AppMethodBeat.o(126510);
              return false;
            }
            TopStoryListVideoUI.this.Gqg.setVisibility(8);
          }
          AppMethodBeat.o(126510);
          return false;
        }
      });
      this.Gpk = ((TopStoryCommentFloatDialog)findViewById(2131298946));
      this.Gpk.setVisibility(8);
      this.Gpk.o(this);
      fzS();
      AppMethodBeat.o(126519);
      return;
      Toast.makeText(this, 2131764252, 1).show();
      this.Gpl = true;
      continue;
      this.Gpe.setVisibility(4);
      this.Gpd.setVisibility(4);
    }
  }
  
  public final void jm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126523);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.Gpl)) {
      fzO();
    }
    super.jm(paramInt1, paramInt2);
    AppMethodBeat.o(126523);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126517);
    p.GnV.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.v localv = d.f(this);
      if ((localv != null) && ((localv instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localv).wu(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.GjJ != null)) {
        ww(paramIntent.getBooleanExtra("isMute", this.GjJ.guh));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.GjJ != null)) {
        abW(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.GjJ.Nij));
      }
    }
    AppMethodBeat.o(126517);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126514);
    if (Build.VERSION.SDK_INT >= 28) {
      customfixStatusbar(true);
    }
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(com.tencent.mm.plugin.boots.a.b.pks, 885);
    com.tencent.mm.plugin.websearch.api.a.a.pl(13);
    AppMethodBeat.o(126514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126544);
    super.onDestroy();
    this.Gpk.gyh.close();
    AppMethodBeat.o(126544);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126545);
    if ((paramInt == 4) && (this.Gpk.getVisibility() == 0))
    {
      this.Gpk.hide();
      AppMethodBeat.o(126545);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(126545);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126542);
    super.onPause();
    this.Gpk.onPause();
    AppMethodBeat.o(126542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126543);
    super.onResume();
    this.Gpk.onResume();
    AppMethodBeat.o(126543);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(List<eiw> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126528);
    super.s(paramList, paramBoolean);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126511);
        if (!TopStoryListVideoUI.this.Gna)
        {
          TopStoryListVideoUI.a(TopStoryListVideoUI.this).setVisibility(4);
          TopStoryListVideoUI.b(TopStoryListVideoUI.this).setVisibility(4);
        }
        for (;;)
        {
          if (TopStoryListVideoUI.f(TopStoryListVideoUI.this) != null)
          {
            TopStoryListVideoUI.f(TopStoryListVideoUI.this).dismiss();
            TopStoryListVideoUI.g(TopStoryListVideoUI.this);
          }
          AppMethodBeat.o(126511);
          return;
          TopStoryListVideoUI.c(TopStoryListVideoUI.this).setVisibility(4);
          TopStoryListVideoUI.d(TopStoryListVideoUI.this).setVisibility(4);
          TopStoryListVideoUI.e(TopStoryListVideoUI.this).a(0, 3, null);
        }
      }
    }, 50L);
    AppMethodBeat.o(126528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI
 * JD-Core Version:    0.7.0.1
 */