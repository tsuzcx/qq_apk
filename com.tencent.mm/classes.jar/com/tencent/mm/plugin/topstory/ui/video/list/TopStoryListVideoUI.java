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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.topstory.ui.c.b;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.est;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TopStoryListVideoUI
  extends TopStoryBaseVideoUI
  implements b
{
  private ProgressDialog NbO;
  private View NbP;
  private View NbQ;
  private View NbR;
  private Button NbS;
  View NbT;
  com.tencent.mm.plugin.topstory.ui.widget.c NbU;
  View NbV;
  TopStoryCommentFloatDialog NbW;
  private boolean NbX;
  private View NcM;
  private TextView NcN;
  private e NcO;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d NcP;
  private View NcQ;
  private View NcR;
  View NcS;
  com.tencent.mm.plugin.topstory.ui.widget.c NcT;
  View NcU;
  private long NcV = 0L;
  
  private void grP()
  {
    AppMethodBeat.i(126522);
    if (!this.MZN)
    {
      this.NbQ.setVisibility(0);
      this.NbP.setVisibility(0);
    }
    for (;;)
    {
      this.MZG.ajK(0);
      AppMethodBeat.o(126522);
      return;
      this.NcR.setVisibility(0);
      this.NcQ.setVisibility(0);
    }
  }
  
  private void grT()
  {
    AppMethodBeat.i(126535);
    if (ar.aN(this))
    {
      int i = ar.aM(this);
      Object localObject = (RelativeLayout.LayoutParams)this.wWQ.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.wWQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.NcM.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.NcM.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(126535);
  }
  
  public final void Np()
  {
    AppMethodBeat.i(126534);
    long l = System.currentTimeMillis();
    if (l - this.NcV < 1000L)
    {
      AppMethodBeat.o(126534);
      return;
    }
    this.NcV = l;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.MZF.NaL != null)
    {
      this.MWu.UuN = this.MZF.NaL.getControlBar().getmPosition();
      if (this.MZF.NaL.getControlBar().getVideoTotalTime() - this.MWu.UuN < 2)
      {
        AppMethodBeat.o(126534);
        return;
      }
    }
    Ai(false);
    this.MZN = false;
    this.NcS.setVisibility(8);
    this.NbT.setVisibility(8);
    if (!gqI()) {
      setRequestedOrientation(1);
    }
    if ((this.MZK != null) && (this.MZK.isShowing()))
    {
      this.MZK.dismiss();
      this.MZK = null;
    }
    this.NcM.setVisibility(0);
    if (gqA().UuJ == null) {
      this.mNb.setVisibility(0);
    }
    this.MZo.setVisibility(0);
    this.MZr.setVisibility(8);
    this.NcP.alc.notifyChanged();
    this.NbR.setVisibility(8);
    this.NcO.Ncn = true;
    this.set.au(gqA().UuM + this.NcO.gqR(), gqK());
    getSwipeBackLayout().setEnableGesture(true);
    Ai(true);
    grT();
    AppMethodBeat.o(126534);
  }
  
  public final void Nq()
  {
    AppMethodBeat.i(126533);
    long l = System.currentTimeMillis();
    if (l - this.NcV < 1000L)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.NcV = l;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    if (this.MZF.NaL != null)
    {
      this.MWu.UuN = this.MZF.NaL.getControlBar().getmPosition();
      if (this.MZF.NaL.getControlBar().getVideoTotalTime() - this.MWu.UuN < 2)
      {
        AppMethodBeat.o(126533);
        return;
      }
    }
    Ai(false);
    this.MZN = true;
    this.NcS.setVisibility(8);
    this.NbT.setVisibility(8);
    if (!gqI()) {
      setRequestedOrientation(0);
    }
    if ((this.MZK != null) && (this.MZK.isShowing()))
    {
      this.MZK.dismiss();
      this.MZK = null;
    }
    this.NcM.setVisibility(8);
    this.mNb.setVisibility(8);
    this.MZm.setVisibility(8);
    this.MZo.setVisibility(8);
    this.MZr.setVisibility(0);
    this.NcO.alc.notifyChanged();
    if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VvD, 0) == 0)
    {
      this.MZF.dmi();
      this.NbR.setVisibility(0);
      this.NbR.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.NbS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126513);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvD, Integer.valueOf(1));
          TopStoryListVideoUI.this.MZF.fLJ();
          TopStoryListVideoUI.h(TopStoryListVideoUI.this).setVisibility(8);
          TopStoryListVideoUI.i(TopStoryListVideoUI.this).b(TopStoryListVideoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126513);
        }
      });
    }
    for (;;)
    {
      this.NcP.NaY = true;
      this.MZs.au(gqA().UuM, 0);
      getSwipeBackLayout().setEnableGesture(false);
      Ai(true);
      if (ar.aN(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.wWQ.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 24);
        this.wWQ.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(126533);
      return;
      this.NbR.setVisibility(8);
    }
  }
  
  public final void a(eij parameij)
  {
    AppMethodBeat.i(126537);
    if (this.MZN) {
      Np();
    }
    gqx().Nah = true;
    this.MZF.stopPlay();
    esy localesy = this.MZG.ajJ(gqE());
    esv localesv = com.tencent.mm.plugin.topstory.a.h.a(gqA());
    localesv.wmL = UUID.randomUUID().toString();
    localesv.UuD = localesy.Crh;
    localesv.UuH = parameij.Ukr;
    localesv.UuI = null;
    localesv.UuJ = parameij;
    localesv.UuK = gqx().Nah;
    Object localObject = localesv.Pye.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aci localaci = (aci)((Iterator)localObject).next();
      if ("show_tag_list".equals(localaci.key)) {
        localaci.SnW = parameij.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new aci();
        ((aci)localObject).key = "show_tag_list";
        ((aci)localObject).SnW = parameij.id;
        localesv.Pye.add(localObject);
      }
      ai.a(this, localesv, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.rE(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(gqA(), localesy, gqE(), 4, parameij.wording + ":" + parameij.id);
      AppMethodBeat.o(126537);
      return;
    }
  }
  
  public final void a(esy paramesy, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126539);
    if (gqA().UuJ != null)
    {
      AppMethodBeat.o(126539);
      return;
    }
    if ((paramesy == null) || (paramesy.Uvf == null))
    {
      AppMethodBeat.o(126539);
      return;
    }
    Object localObject = gqy().NaG;
    int i;
    int j;
    if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).MVX != 0L))
    {
      long l = (System.currentTimeMillis() - ((com.tencent.mm.plugin.topstory.a.b.b)localObject).MVX) / 1000L;
      i = paramesy.Uvf.Uuz - 10;
      paramInt2 = paramesy.Uvf.UuA * paramInt2 / 100 - 10;
      if ((!paramesy.Uvf.UuC) && (l >= i) && (paramInt1 >= paramInt2))
      {
        localObject = this.MZG;
        esv localesv = this.MWu;
        j = this.MZG.grz();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", new Object[] { paramesy.Crh, Integer.valueOf(j), Long.valueOf(l) });
        if (((n)localObject).Nav != null)
        {
          com.tencent.mm.kernel.h.aGY().a(((n)localObject).Nav);
          ((n)localObject).Nav = null;
        }
        localesv = com.tencent.mm.plugin.topstory.a.h.a(localesv);
        localesv.offset = j;
        ((n)localObject).Nav = new com.tencent.mm.plugin.topstory.a.c.h(localesv, ((n)localObject).MYE.gqE(), paramesy, l);
        com.tencent.mm.kernel.h.aGY().a(((n)localObject).Nav, 0);
        com.tencent.mm.kernel.h.aGY().a(1943, ((n)localObject).jxB);
        paramesy.Uvf.UuC = true;
      }
      if ((!paramesy.Uvf.fxt) && (l >= i + 10) && (paramInt1 >= paramInt2 + 10))
      {
        paramesy.Uvf.fxt = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", new Object[] { Integer.valueOf(paramesy.Uvf.UuB.size()) });
        paramesy = paramesy.Uvf.UuB.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramesy.hasNext())
        {
          localObject = (esy)paramesy.next();
          if (((esy)localObject).Uvf == null)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", new Object[] { ((esy)localObject).Crh });
            continue;
            AppMethodBeat.o(126539);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", new Object[] { ((esy)localObject).Crh, Integer.valueOf(((esy)localObject).Uvf.Uux) });
            if (((esy)localObject).Uvf.Uux == 2)
            {
              paramInt2 = ((esy)localObject).Uvf.Rna;
              j = gqE();
              if (paramInt2 > 0)
              {
                paramInt1 = paramInt2;
                label492:
                paramInt1 = j + paramInt1;
                i = this.MZG.grz() - 1;
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
      this.MZG.eiH().add(paramInt1, localObject);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), ((esy)localObject).Crh, ((esy)localObject).title });
      getRecyclerView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126499);
          TopStoryListVideoUI.this.gqH().cM(paramInt1 + TopStoryListVideoUI.this.gqH().gqR());
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
  
  public final void a(final esy paramesy, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126541);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramesy.Crh, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.NcS.getVisibility() == 0)
      {
        if ((this.NcT != null) && (this.NcT.vid != null) && (this.NcT.vid.equals(paramesy.Crh)))
        {
          this.NcS.setVisibility(8);
          AppMethodBeat.o(126541);
        }
      }
      else if ((this.NbT.getVisibility() == 0) && (this.NbU != null) && (this.NbU.vid != null) && (this.NbU.vid.equals(paramesy.Crh))) {
        this.NbT.setVisibility(8);
      }
      AppMethodBeat.o(126541);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = paramesy.BHW;
    Object localObject3 = paramesy.title;
    Object localObject4 = gqA().jQi;
    int j = gqA().scene;
    if (gqI()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, paramesy.Crh, paramesy.zGJ);
      if (!this.MZN) {
        break;
      }
      this.NcS.setVisibility(0);
      this.NbT.setVisibility(8);
      this.NcT = new com.tencent.mm.plugin.topstory.ui.widget.c(this.NcU, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126502);
          TopStoryListVideoUI.this.NbW.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void grR()
            {
              AppMethodBeat.i(126501);
              TopStoryListVideoUI.this.NcS.setVisibility(8);
              TopStoryListVideoUI.this.NbT.setVisibility(8);
              AppMethodBeat.o(126501);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126500);
              TopStoryListVideoUI.this.MZF.fLJ();
              AppMethodBeat.o(126500);
            }
          }, (int)TopStoryListVideoUI.j(TopStoryListVideoUI.this).UuH, paramesy.UuY);
          if (TopStoryListVideoUI.this.MZF.ehu()) {
            TopStoryListVideoUI.this.MZF.dmi();
          }
          AppMethodBeat.o(126502);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramesy.Crh);
      paramesy = this.NcT;
      i = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0F);
      localObject2 = paramView.getContext();
      localObject3 = paramesy.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      j = paramView.getWidth();
      int k = ar.au((Context)localObject2).x;
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
      paramView = (LinearLayout.LayoutParams)paramesy.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      paramesy.contentView.setLayoutParams(paramView);
      this.NcS.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126503);
          if (TopStoryListVideoUI.this.NcS.getVisibility() == 0) {
            TopStoryListVideoUI.this.NcS.setVisibility(8);
          }
          AppMethodBeat.o(126503);
        }
      }, 1800L);
      AppMethodBeat.o(126541);
      return;
    }
    this.NcS.setVisibility(8);
    this.NbT.setVisibility(0);
    this.NbU = new com.tencent.mm.plugin.topstory.ui.widget.c(this.NbV, new c.a()
    {
      public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
      {
        AppMethodBeat.i(126506);
        TopStoryListVideoUI.this.NbW.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
        {
          public final void grR()
          {
            AppMethodBeat.i(126505);
            TopStoryListVideoUI.this.NcS.setVisibility(8);
            TopStoryListVideoUI.this.NbT.setVisibility(8);
            AppMethodBeat.o(126505);
          }
          
          public final void onDismiss()
          {
            AppMethodBeat.i(126504);
            TopStoryListVideoUI.this.MZF.fLJ();
            AppMethodBeat.o(126504);
          }
        }, (int)TopStoryListVideoUI.k(TopStoryListVideoUI.this).UuH, paramesy.UuY);
        if (TopStoryListVideoUI.this.MZF.ehu()) {
          TopStoryListVideoUI.this.MZF.dmi();
        }
        AppMethodBeat.o(126506);
      }
    }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramesy.Crh);
    this.NbU.a(paramView, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0F));
    AppMethodBeat.o(126541);
  }
  
  public final void a(esy paramesy, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt)
  {
    AppMethodBeat.i(126538);
    if ((paramesy.Uvn != null) && (paramesy.Uvn.Uut != null)) {
      if ((paramInt >= paramesy.Uvn.MFF) && (paramInt <= paramesy.Uvn.endTime))
      {
        if (!paramesy.Uvn.fxt)
        {
          paramesy.Uvn.fxt = true;
          paramf.gre();
          AppMethodBeat.o(126538);
        }
      }
      else {
        paramf.grf();
      }
    }
    AppMethodBeat.o(126538);
  }
  
  public final boolean ajA(int paramInt)
  {
    AppMethodBeat.i(126527);
    this.NbT.setVisibility(8);
    this.NcS.setVisibility(8);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.MZN) {
          continue;
        }
        if (paramInt < this.MZt.getItemCount() - this.MZt.gqS() - this.MZt.gqR())
        {
          RecyclerView localRecyclerView = this.MZr;
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(126527);
          return true;
        }
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.MZt.getItemCount()), Integer.valueOf(this.MZt.gqS()), Integer.valueOf(this.MZt.gqR()) });
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(126527);
      return false;
      if (paramInt < this.NcO.getItemCount() - this.NcO.gqS() - this.NcO.gqR())
      {
        this.MZq.a(this, this.NcO.gqR() + paramInt);
        AppMethodBeat.o(126527);
        return true;
      }
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.NcO.getItemCount()), Integer.valueOf(this.NcO.gqS()), Integer.valueOf(this.NcO.gqR()) });
    }
  }
  
  public final void ajH(int paramInt)
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
      if (!this.MZN) {
        break;
      }
      AppMethodBeat.o(126530);
      return;
    }
    Nq();
    AppMethodBeat.o(126530);
    return;
    label96:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.MZN)
      {
        AppMethodBeat.o(126530);
        return;
      }
      Np();
    }
    label125:
    AppMethodBeat.o(126530);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(126515);
    super.ata();
    if (gqA().UuI != null) {
      this.MZG.h(gqA().UuI);
    }
    AppMethodBeat.o(126515);
  }
  
  public final void bfc(final String paramString)
  {
    AppMethodBeat.i(126529);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126512);
        if (!TopStoryListVideoUI.this.MZN)
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
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126516);
    if ((this.MZN) && (!gqI()))
    {
      AppMethodBeat.o(126516);
      return 0;
    }
    AppMethodBeat.o(126516);
    return 1;
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_list_video_ui;
  }
  
  public final int gqK()
  {
    AppMethodBeat.i(126536);
    if (ar.aN(this))
    {
      i = super.gqK();
      int j = ar.aM(this);
      AppMethodBeat.o(126536);
      return i + j;
    }
    int i = super.gqK();
    AppMethodBeat.o(126536);
    return i;
  }
  
  public final int gqP()
  {
    return 0;
  }
  
  public final void gqu()
  {
    AppMethodBeat.i(126524);
    if (!this.MZN) {
      this.NcM.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.wWQ.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((gqA().UuJ != null) && (this.NcN != null)) {
        this.NcN.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(126524);
      return;
      this.NcS.setVisibility(8);
    }
  }
  
  public final void gqv()
  {
    AppMethodBeat.i(126525);
    this.wWQ.animate().cancel();
    this.wWQ.setAlpha(1.0F);
    if ((gqA().UuJ != null) && (this.NcN != null)) {
      this.NcN.setAlpha(1.0F);
    }
    AppMethodBeat.o(126525);
  }
  
  public final void grl()
  {
    AppMethodBeat.i(126518);
    super.grl();
    if (this.MZN)
    {
      Np();
      AppMethodBeat.o(126518);
      return;
    }
    if (this.MWu != null)
    {
      gqy().grD();
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.MWu.iYs);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.MWu.UuP);
      localIntent.putExtra("key_video_play_info", Util.listToString(gqy().NaH, ";"));
      localIntent.putExtra("key_search_id", gqA().jQi);
      setResult(-1, localIntent);
    }
    if (!grv().Q(2, false)) {
      finish();
    }
    if (!grw().zH(2)) {
      finish();
    }
    AppMethodBeat.o(126518);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d grm()
  {
    AppMethodBeat.i(126520);
    d locald = new d();
    AppMethodBeat.o(126520);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d grn()
  {
    AppMethodBeat.i(126540);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(126540);
    return localc;
  }
  
  public final void gro()
  {
    AppMethodBeat.i(126526);
    super.gro();
    if ((!this.MZN) && (this.NcM.getAlpha() != 0.0F))
    {
      this.NcM.animate().cancel();
      this.NcM.setAlpha(0.0F);
    }
    AppMethodBeat.o(126526);
  }
  
  public final void grp()
  {
    AppMethodBeat.i(126521);
    if (!this.MZN)
    {
      this.NbQ.setVisibility(0);
      this.NbP.setVisibility(0);
    }
    for (;;)
    {
      this.MZG.ajK(this.MZG.grz());
      AppMethodBeat.o(126521);
      return;
      this.NcR.setVisibility(0);
      this.NcQ.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e grr()
  {
    AppMethodBeat.i(126531);
    this.NcO = new e(this);
    e locale = this.NcO;
    View localView1 = LayoutInflater.from(this).inflate(c.e.top_story_list_video_header, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(c.d.header_border_view);
    View localView2 = localView1.findViewById(c.d.header_layout);
    if (gqA().UuJ != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.NcN = ((TextView)localView1.findViewById(c.d.header_title_tv));
      this.NcN.setText(gqA().UuJ.title);
      localObject = (TextView)localView1.findViewById(c.d.sub_header_title_tv);
      if (!Util.isNullOrNil(gqA().UuJ.rsw)) {
        ((TextView)localObject).setText(gqA().UuJ.rsw);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (ar.aN(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = ar.aM(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.dI(localView1);
      locale = this.NcO;
      localView1 = LayoutInflater.from(this).inflate(c.e.top_story_list_video_loading_footer, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.ci.a.ks(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(c.b.top_story_video_list_header_height));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.NbQ = localView1.findViewById(c.d.footer_loading_tv);
      this.NbP = localView1.findViewById(c.d.footer_progress_bar);
      locale.hc(localView1);
      locale = this.NcO;
      AppMethodBeat.o(126531);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e grs()
  {
    AppMethodBeat.i(126532);
    this.NcP = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.NcP;
    View localView = LayoutInflater.from(this).inflate(c.e.top_story_list_video_loading_footer, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.NcR = localView.findViewById(c.d.footer_loading_tv);
    this.NcQ = localView.findViewById(c.d.footer_progress_bar);
    locald.hc(localView);
    locald = this.NcP;
    AppMethodBeat.o(126532);
    return locald;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(126519);
    super.initContentView();
    this.NbR = findViewById(c.d.fs_scroll_tips_layout);
    this.NbS = ((Button)findViewById(c.d.scroll_tips_i_know_btn));
    this.NcM = findViewById(c.d.title_bg);
    this.NcM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126498);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((TopStoryListVideoUI.this.MZF.NaM) && (TopStoryListVideoUI.this.MZF.NaL.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.MZF.NaL.getItemUIComponent().gqv();
          TopStoryListVideoUI.this.MZF.NaL.getItemUIComponent().gqu();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126498);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
    if (gqA().UuJ != null) {
      this.mNb.setVisibility(8);
    }
    gqy().NaF = 2;
    if (grq()) {
      if (gqx().isConnected())
      {
        grP();
        this.NbX = false;
        if ((gqA().scene != 21) && (gqA().UuJ == null)) {
          this.NbO = com.tencent.mm.ui.base.h.a(this, getString(c.g.loading_tips), true, new DialogInterface.OnCancelListener()
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
      this.NcO.Ncc = true;
      if (gqA().UuK) {
        gqx().Nah = true;
      }
      this.MZo.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126508);
          TopStoryListVideoUI.this.MZD.grC();
          AppMethodBeat.o(126508);
        }
      });
      new c(this).a(this.MZo);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().a(this.MZr);
      this.NbT = findViewById(c.d.dialog_notfull_frame);
      this.NbV = findViewById(c.d.dialog_notfull_root);
      this.NbT.setVisibility(8);
      this.NcS = findViewById(c.d.dialog_full_frame);
      this.NcU = findViewById(c.d.dialog_full_root);
      this.NcS.setVisibility(8);
      this.NbT.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126509);
          if (TopStoryListVideoUI.this.NbT.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.k(TopStoryListVideoUI.this.NbV, f1, f2))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewNotFull");
              AppMethodBeat.o(126509);
              return false;
            }
            TopStoryListVideoUI.this.NbT.setVisibility(8);
          }
          AppMethodBeat.o(126509);
          return false;
        }
      });
      this.NcS.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126510);
          if (TopStoryListVideoUI.this.NcS.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.k(TopStoryListVideoUI.this.NcU, f1, f2))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewFull");
              AppMethodBeat.o(126510);
              return false;
            }
            TopStoryListVideoUI.this.NcS.setVisibility(8);
          }
          AppMethodBeat.o(126510);
          return false;
        }
      });
      this.NbW = ((TopStoryCommentFloatDialog)findViewById(c.d.comment_float_dialog));
      this.NbW.setVisibility(8);
      this.NbW.p(this);
      grT();
      AppMethodBeat.o(126519);
      return;
      Toast.makeText(this, c.g.recommend_video_init_not_network_failed_hint, 1).show();
      this.NbX = true;
      continue;
      this.NbQ.setVisibility(4);
      this.NbP.setVisibility(4);
    }
  }
  
  public final void ky(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126523);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.NbX)) {
      grP();
    }
    super.ky(paramInt1, paramInt2);
    AppMethodBeat.o(126523);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126517);
    p.NaI.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.v localv = d.f(this);
      if ((localv != null) && ((localv instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localv).Ah(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.MWu != null)) {
        Aj(paramIntent.getBooleanExtra("isMute", this.MWu.iYs));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.MWu != null)) {
        ajC(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.MWu.UuP));
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).fA(com.tencent.mm.plugin.boots.a.b.smB, 885);
    com.tencent.mm.plugin.websearch.api.a.a.rE(13);
    AppMethodBeat.o(126514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126544);
    super.onDestroy();
    this.NbW.jij.close();
    AppMethodBeat.o(126544);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126545);
    if ((paramInt == 4) && (this.NbW.getVisibility() == 0))
    {
      this.NbW.hide();
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
    this.NbW.onPause();
    AppMethodBeat.o(126542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126543);
    super.onResume();
    this.NbW.onResume();
    AppMethodBeat.o(126543);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(List<esy> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126528);
    super.t(paramList, paramBoolean);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126511);
        if (!TopStoryListVideoUI.this.MZN)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI
 * JD-Core Version:    0.7.0.1
 */