package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import android.support.v7.widget.RecyclerView.w;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xwalk.core.Log;

public class TopStoryListVideoUI
  extends TopStoryBaseVideoUI
  implements b
{
  View BOA;
  com.tencent.mm.plugin.topstory.ui.widget.c BOB;
  View BOC;
  TopStoryCommentFloatDialog BOD;
  private boolean BOE;
  private ProgressDialog BOv;
  private View BOw;
  private View BOx;
  private View BOy;
  private Button BOz;
  com.tencent.mm.plugin.topstory.ui.widget.c BPA;
  View BPB;
  private long BPC = 0L;
  private View BPt;
  private TextView BPu;
  private e BPv;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d BPw;
  private View BPx;
  private View BPy;
  View BPz;
  
  private void eut()
  {
    AppMethodBeat.i(126522);
    if (!this.BMu)
    {
      this.BOx.setVisibility(0);
      this.BOw.setVisibility(0);
    }
    for (;;)
    {
      this.BMn.TO(0);
      AppMethodBeat.o(126522);
      return;
      this.BPy.setVisibility(0);
      this.BPx.setVisibility(0);
    }
  }
  
  private void euy()
  {
    AppMethodBeat.i(126535);
    if (al.aH(this))
    {
      int i = al.aG(this);
      Object localObject = (RelativeLayout.LayoutParams)this.yZr.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.yZr.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.BPt.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.BPt.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(126535);
  }
  
  public final boolean TE(int paramInt)
  {
    AppMethodBeat.i(126527);
    this.BOA.setVisibility(8);
    this.BPz.setVisibility(8);
    ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.BMu) {
          continue;
        }
        if (paramInt < this.BMb.getItemCount() - this.BMb.getFootersCount() - this.BMb.getHeadersCount())
        {
          RecyclerView localRecyclerView = this.BLZ;
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(126527);
          return true;
        }
        ae.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BMb.getItemCount()), Integer.valueOf(this.BMb.getFootersCount()), Integer.valueOf(this.BMb.getHeadersCount()) });
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(126527);
      return false;
      if (paramInt < this.BPv.getItemCount() - this.BPv.getFootersCount() - this.BPv.getHeadersCount())
      {
        this.BLY.a(this, this.BPv.getHeadersCount() + paramInt);
        AppMethodBeat.o(126527);
        return true;
      }
      ae.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BPv.getItemCount()), Integer.valueOf(this.BPv.getFootersCount()), Integer.valueOf(this.BPv.getHeadersCount()) });
    }
  }
  
  public final void TL(int paramInt)
  {
    AppMethodBeat.i(126530);
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (!bool) {
        break label125;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label96;
      }
      if (!this.BMu) {
        break;
      }
      AppMethodBeat.o(126530);
      return;
    }
    bnT();
    AppMethodBeat.o(126530);
    return;
    label96:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.BMu)
      {
        AppMethodBeat.o(126530);
        return;
      }
      diF();
    }
    label125:
    AppMethodBeat.o(126530);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(126515);
    super.Zm();
    if (etg().HVT != null) {
      this.BMn.h(etg().HVT);
    }
    AppMethodBeat.o(126515);
  }
  
  public final void a(dfc paramdfc)
  {
    AppMethodBeat.i(126537);
    if (this.BMu) {
      diF();
    }
    this.BMj.BMO = true;
    this.BMm.stopPlay();
    dpa localdpa = this.BMn.TN(etl());
    dox localdox = com.tencent.mm.plugin.topstory.a.h.a(etg());
    localdox.rfA = UUID.randomUUID().toString();
    localdox.HVO = localdpa.udb;
    localdox.HVS = paramdfc.HMm;
    localdox.HVT = null;
    localdox.HVU = paramdfc;
    localdox.HVV = this.BMj.BMO;
    Object localObject = localdox.DTg.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aaj localaaj = (aaj)((Iterator)localObject).next();
      if ("show_tag_list".equals(localaaj.key)) {
        localaaj.GrF = paramdfc.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new aaj();
        ((aaj)localObject).key = "show_tag_list";
        ((aaj)localObject).GrF = paramdfc.id;
        localdox.DTg.add(localObject);
      }
      ad.a(this, localdox, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.md(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(etg(), localdpa, etl(), 4, paramdfc.dyI + ":" + paramdfc.id);
      AppMethodBeat.o(126537);
      return;
    }
  }
  
  public final void a(dpa paramdpa, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126539);
    if (etg().HVU != null)
    {
      AppMethodBeat.o(126539);
      return;
    }
    if ((paramdpa == null) || (paramdpa.HWs == null))
    {
      AppMethodBeat.o(126539);
      return;
    }
    Object localObject = this.BMk.BNm;
    int i;
    int j;
    if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).BID != 0L))
    {
      long l = (System.currentTimeMillis() - ((com.tencent.mm.plugin.topstory.a.b.b)localObject).BID) / 1000L;
      i = paramdpa.HWs.HVK - 10;
      paramInt2 = paramdpa.HWs.HVL * paramInt2 / 100 - 10;
      if ((!paramdpa.HWs.HVN) && (l >= i) && (paramInt1 >= paramInt2))
      {
        localObject = this.BMn;
        dox localdox = this.BJa;
        j = this.BMn.euc();
        ae.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", new Object[] { paramdpa.udb, Integer.valueOf(j), Long.valueOf(l) });
        if (((n)localObject).BNd != null)
        {
          com.tencent.mm.kernel.g.ajj().a(((n)localObject).BNd);
          ((n)localObject).BNd = null;
        }
        localdox = com.tencent.mm.plugin.topstory.a.h.a(localdox);
        localdox.offset = j;
        ((n)localObject).BNd = new com.tencent.mm.plugin.topstory.a.c.h(localdox, ((n)localObject).BLm.etl(), paramdpa, l);
        com.tencent.mm.kernel.g.ajj().a(((n)localObject).BNd, 0);
        com.tencent.mm.kernel.g.ajj().a(1943, ((n)localObject).ghB);
        paramdpa.HWs.HVN = true;
      }
      if ((!paramdpa.HWs.dnq) && (l >= i + 10) && (paramInt1 >= paramInt2 + 10))
      {
        paramdpa.HWs.dnq = true;
        ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", new Object[] { Integer.valueOf(paramdpa.HWs.HVM.size()) });
        paramdpa = paramdpa.HWs.HVM.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramdpa.hasNext())
        {
          localObject = (dpa)paramdpa.next();
          if (((dpa)localObject).HWs == null)
          {
            ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", new Object[] { ((dpa)localObject).udb });
            continue;
            AppMethodBeat.o(126539);
          }
          else
          {
            ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", new Object[] { ((dpa)localObject).udb, Integer.valueOf(((dpa)localObject).HWs.HVI) });
            if (((dpa)localObject).HWs.HVI == 2)
            {
              paramInt2 = ((dpa)localObject).HWs.Fvs;
              j = etl();
              if (paramInt2 > 0)
              {
                paramInt1 = paramInt2;
                label492:
                paramInt1 = j + paramInt1;
                i = this.BMn.euc() - 1;
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
      this.BMn.cPU().add(paramInt1, localObject);
      ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), ((dpa)localObject).udb, ((dpa)localObject).title });
      getRecyclerView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126499);
          TopStoryListVideoUI.this.eto().ck(paramInt1 + TopStoryListVideoUI.this.eto().getHeadersCount());
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
  
  public final void a(final dpa paramdpa, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126541);
    ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramdpa.udb, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.BPz.getVisibility() == 0)
      {
        if ((this.BPA != null) && (this.BPA.hCa != null) && (this.BPA.hCa.equals(paramdpa.udb)))
        {
          this.BPz.setVisibility(8);
          AppMethodBeat.o(126541);
        }
      }
      else if ((this.BOA.getVisibility() == 0) && (this.BOB != null) && (this.BOB.hCa != null) && (this.BOB.hCa.equals(paramdpa.udb))) {
        this.BOA.setVisibility(8);
      }
      AppMethodBeat.o(126541);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = paramdpa.tFc;
    Object localObject3 = paramdpa.title;
    Object localObject4 = etg().kid;
    int j = etg().scene;
    if (etp()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, paramdpa.udb, paramdpa.HWw);
      if (!this.BMu) {
        break;
      }
      this.BPz.setVisibility(0);
      this.BOA.setVisibility(8);
      this.BPA = new com.tencent.mm.plugin.topstory.ui.widget.c(this.BPB, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126502);
          TopStoryListVideoUI.this.BOD.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void euv()
            {
              AppMethodBeat.i(126501);
              TopStoryListVideoUI.this.BPz.setVisibility(8);
              TopStoryListVideoUI.this.BOA.setVisibility(8);
              AppMethodBeat.o(126501);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126500);
              TopStoryListVideoUI.this.BMm.edW();
              AppMethodBeat.o(126500);
            }
          }, (int)TopStoryListVideoUI.j(TopStoryListVideoUI.this).HVS, paramdpa.HWk);
          if (TopStoryListVideoUI.this.BMm.eul()) {
            TopStoryListVideoUI.this.BMm.cyX();
          }
          AppMethodBeat.o(126502);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramdpa.udb);
      paramdpa = this.BPA;
      i = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0F);
      localObject2 = paramView.getContext();
      localObject3 = paramdpa.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      j = paramView.getWidth();
      int k = al.ck((Context)localObject2).x;
      ((View)localObject3).measure(0, 0);
      int m = ((View)localObject3).getMeasuredHeight();
      int n = ((View)localObject3).getMeasuredWidth();
      int i1 = localObject4[0];
      localObject1[0] = (j / 2 + i1 - n / 2);
      localObject4[1] -= m;
      Log.i("PopupUtil", "window pos x:" + localObject1[0] + ", windowWidth:" + n + ", screenWidth:" + k);
      if (localObject1[0] + n > k) {
        localObject1[0] = (k - n);
      }
      localObject1[0] += 0;
      localObject1[1] = (i + localObject1[1]);
      paramView = (LinearLayout.LayoutParams)paramdpa.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      paramdpa.contentView.setLayoutParams(paramView);
      this.BPz.postDelayed(new TopStoryListVideoUI.4(this), 1800L);
      AppMethodBeat.o(126541);
      return;
    }
    this.BPz.setVisibility(8);
    this.BOA.setVisibility(0);
    this.BOB = new com.tencent.mm.plugin.topstory.ui.widget.c(this.BOC, new c.a()
    {
      public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
      {
        AppMethodBeat.i(126506);
        TopStoryListVideoUI.this.BOD.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
        {
          public final void euv()
          {
            AppMethodBeat.i(126505);
            TopStoryListVideoUI.this.BPz.setVisibility(8);
            TopStoryListVideoUI.this.BOA.setVisibility(8);
            AppMethodBeat.o(126505);
          }
          
          public final void onDismiss()
          {
            AppMethodBeat.i(126504);
            TopStoryListVideoUI.this.BMm.edW();
            AppMethodBeat.o(126504);
          }
        }, (int)TopStoryListVideoUI.k(TopStoryListVideoUI.this).HVS, paramdpa.HWk);
        if (TopStoryListVideoUI.this.BMm.eul()) {
          TopStoryListVideoUI.this.BMm.cyX();
        }
        AppMethodBeat.o(126506);
      }
    }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramdpa.udb);
    this.BOB.a(paramView, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0F));
    AppMethodBeat.o(126541);
  }
  
  public final void a(dpa paramdpa, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt)
  {
    AppMethodBeat.i(126538);
    if ((paramdpa.HWB != null) && (paramdpa.HWB.HVE != null)) {
      if ((paramInt >= paramdpa.HWB.HVB) && (paramInt <= paramdpa.HWB.hwE))
      {
        if (!paramdpa.HWB.dnq)
        {
          paramdpa.HWB.dnq = true;
          paramf.etJ();
          AppMethodBeat.o(126538);
        }
      }
      else {
        paramf.etK();
      }
    }
    AppMethodBeat.o(126538);
  }
  
  public final void aEo(final String paramString)
  {
    AppMethodBeat.i(126529);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126512);
        if (!TopStoryListVideoUI.this.BMu)
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
  
  public final void bnT()
  {
    AppMethodBeat.i(126533);
    long l = System.currentTimeMillis();
    if (l - this.BPC < 1000L)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.BPC = l;
    ae.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    if (this.BMm.BNr != null)
    {
      this.BJa.HVY = this.BMm.BNr.getControlBar().getmPosition();
      if (this.BMm.BNr.getControlBar().getVideoTotalTime() - this.BJa.HVY < 2)
      {
        AppMethodBeat.o(126533);
        return;
      }
    }
    sR(false);
    this.BMu = true;
    this.BPz.setVisibility(8);
    this.BOA.setVisibility(8);
    if (!etp()) {
      setRequestedOrientation(0);
    }
    if ((this.BMr != null) && (this.BMr.isShowing()))
    {
      this.BMr.dismiss();
      this.BMr = null;
    }
    this.BPt.setVisibility(8);
    this.iYj.setVisibility(8);
    this.BLU.setVisibility(8);
    this.BLW.setVisibility(8);
    this.BLZ.setVisibility(0);
    this.BPv.asY.notifyChanged();
    if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IYQ, 0) == 0)
    {
      this.BMm.cyX();
      this.BOy.setVisibility(0);
      this.BOy.setOnTouchListener(new TopStoryListVideoUI.12(this));
      this.BOz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126513);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYQ, Integer.valueOf(1));
          TopStoryListVideoUI.this.BMm.edW();
          TopStoryListVideoUI.h(TopStoryListVideoUI.this).setVisibility(8);
          TopStoryListVideoUI.i(TopStoryListVideoUI.this).b(TopStoryListVideoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126513);
        }
      });
    }
    for (;;)
    {
      this.BPw.BNE = true;
      this.BMa.ag(etg().HVX, 0);
      getSwipeBackLayout().setEnableGesture(false);
      sR(true);
      if (al.aH(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yZr.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        this.yZr.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(126533);
      return;
      this.BOy.setVisibility(8);
    }
  }
  
  public final void diF()
  {
    AppMethodBeat.i(126534);
    long l = System.currentTimeMillis();
    if (l - this.BPC < 1000L)
    {
      AppMethodBeat.o(126534);
      return;
    }
    this.BPC = l;
    ae.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.BMm.BNr != null)
    {
      this.BJa.HVY = this.BMm.BNr.getControlBar().getmPosition();
      if (this.BMm.BNr.getControlBar().getVideoTotalTime() - this.BJa.HVY < 2)
      {
        AppMethodBeat.o(126534);
        return;
      }
    }
    sR(false);
    this.BMu = false;
    this.BPz.setVisibility(8);
    this.BOA.setVisibility(8);
    if (!etp()) {
      setRequestedOrientation(1);
    }
    if ((this.BMr != null) && (this.BMr.isShowing()))
    {
      this.BMr.dismiss();
      this.BMr = null;
    }
    this.BPt.setVisibility(0);
    if (etg().HVU == null) {
      this.iYj.setVisibility(0);
    }
    this.BLW.setVisibility(0);
    this.BLZ.setVisibility(8);
    this.BPw.asY.notifyChanged();
    this.BOy.setVisibility(8);
    this.BPv.BOU = true;
    this.nRC.ag(etg().HVX + this.BPv.getHeadersCount(), etr());
    getSwipeBackLayout().setEnableGesture(true);
    sR(true);
    euy();
    AppMethodBeat.o(126534);
  }
  
  public final void etQ()
  {
    AppMethodBeat.i(126518);
    super.etQ();
    if (this.BMu)
    {
      diF();
      AppMethodBeat.o(126518);
      return;
    }
    if (this.BJa != null)
    {
      this.BMk.eug();
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.BJa.fOX);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.BJa.HWa);
      localIntent.putExtra("key_video_play_info", bu.m(this.BMk.BNn, ";"));
      localIntent.putExtra("key_search_id", etg().kid);
      setResult(-1, localIntent);
    }
    if (!this.BMd.sy(2)) {
      finish();
    }
    AppMethodBeat.o(126518);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d etR()
  {
    AppMethodBeat.i(126520);
    d locald = new d();
    AppMethodBeat.o(126520);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d etS()
  {
    AppMethodBeat.i(126540);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(126540);
    return localc;
  }
  
  public final void etT()
  {
    AppMethodBeat.i(126526);
    super.etT();
    if ((!this.BMu) && (this.BPt.getAlpha() != 0.0F))
    {
      this.BPt.animate().cancel();
      this.BPt.setAlpha(0.0F);
    }
    AppMethodBeat.o(126526);
  }
  
  public final void etU()
  {
    AppMethodBeat.i(126521);
    if (!this.BMu)
    {
      this.BOx.setVisibility(0);
      this.BOw.setVisibility(0);
    }
    for (;;)
    {
      this.BMn.TO(this.BMn.euc());
      AppMethodBeat.o(126521);
      return;
      this.BPy.setVisibility(0);
      this.BPx.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e etW()
  {
    AppMethodBeat.i(126531);
    this.BPv = new e(this);
    e locale = this.BPv;
    View localView1 = LayoutInflater.from(this).inflate(2131495792, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(2131300708);
    View localView2 = localView1.findViewById(2131300719);
    if (etg().HVU != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.BPu = ((TextView)localView1.findViewById(2131300732));
      this.BPu.setText(etg().HVU.title);
      localObject = (TextView)localView1.findViewById(2131305507);
      if (!bu.isNullOrNil(etg().HVU.nhq)) {
        ((TextView)localObject).setText(etg().HVU.nhq);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (al.aH(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = al.aG(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.addHeaderView(localView1);
      locale = this.BPv;
      localView1 = LayoutInflater.from(this).inflate(2131495794, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cb.a.iv(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(2131166931));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.BOx = localView1.findViewById(2131300203);
      this.BOw = localView1.findViewById(2131300207);
      locale.fB(localView1);
      locale = this.BPv;
      AppMethodBeat.o(126531);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e etX()
  {
    AppMethodBeat.i(126532);
    this.BPw = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.BPw;
    View localView = LayoutInflater.from(this).inflate(2131495794, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.BPy = localView.findViewById(2131300203);
    this.BPx = localView.findViewById(2131300207);
    locald.fB(localView);
    locald = this.BPw;
    AppMethodBeat.o(126532);
    return locald;
  }
  
  public final void eta()
  {
    AppMethodBeat.i(126524);
    if (!this.BMu) {
      this.BPt.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.yZr.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((etg().HVU != null) && (this.BPu != null)) {
        this.BPu.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(126524);
      return;
      this.BPz.setVisibility(8);
    }
  }
  
  public final void etb()
  {
    AppMethodBeat.i(126525);
    this.yZr.animate().cancel();
    this.yZr.setAlpha(1.0F);
    if ((etg().HVU != null) && (this.BPu != null)) {
      this.BPu.setAlpha(1.0F);
    }
    AppMethodBeat.o(126525);
  }
  
  public final int etr()
  {
    AppMethodBeat.i(126536);
    if (al.aH(this))
    {
      i = super.etr();
      int j = al.aG(this);
      AppMethodBeat.o(126536);
      return i + j;
    }
    int i = super.etr();
    AppMethodBeat.o(126536);
    return i;
  }
  
  public final int etw()
  {
    return 0;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126516);
    if ((this.BMu) && (!etp()))
    {
      AppMethodBeat.o(126516);
      return 0;
    }
    AppMethodBeat.o(126516);
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495795;
  }
  
  public final void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126523);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.BOE)) {
      eut();
    }
    super.im(paramInt1, paramInt2);
    AppMethodBeat.o(126523);
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(126519);
    super.initContentView();
    this.BOy = findViewById(2131300313);
    this.BOz = ((Button)findViewById(2131304375));
    this.BPt = findViewById(2131305911);
    this.BPt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126498);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((TopStoryListVideoUI.this.BMm.BNs) && (TopStoryListVideoUI.this.BMm.BNr.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.BMm.BNr.getItemUIComponent().etb();
          TopStoryListVideoUI.this.BMm.BNr.getItemUIComponent().eta();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126498);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
    if (etg().HVU != null) {
      this.iYj.setVisibility(8);
    }
    this.BMk.BNl = 2;
    if (etV()) {
      if (this.BMj.isConnected())
      {
        eut();
        this.BOE = false;
        if ((etg().scene != 21) && (etg().HVU == null)) {
          this.BOv = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new TopStoryListVideoUI.6(this));
        }
      }
    }
    for (;;)
    {
      this.BPv.BOJ = true;
      if (etg().HVV) {
        this.BMj.BMO = true;
      }
      this.BLW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126508);
          TopStoryListVideoUI.this.BMk.euf();
          AppMethodBeat.o(126508);
        }
      });
      new c(this).j(this.BLW);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().j(this.BLZ);
      this.BOA = findViewById(2131299128);
      this.BOC = findViewById(2131299129);
      this.BOA.setVisibility(8);
      this.BPz = findViewById(2131299123);
      this.BPB = findViewById(2131299124);
      this.BPz.setVisibility(8);
      this.BOA.setOnTouchListener(new TopStoryListVideoUI.8(this));
      this.BPz.setOnTouchListener(new TopStoryListVideoUI.9(this));
      this.BOD = ((TopStoryCommentFloatDialog)findViewById(2131298520));
      this.BOD.setVisibility(8);
      this.BOD.o(this);
      euy();
      AppMethodBeat.o(126519);
      return;
      Toast.makeText(this, 2131762228, 1).show();
      this.BOE = true;
      continue;
      this.BOx.setVisibility(4);
      this.BOw.setVisibility(4);
    }
  }
  
  public final void n(List<dpa> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126528);
    super.n(paramList, paramBoolean);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126511);
        if (!TopStoryListVideoUI.this.BMu)
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126517);
    p.BNo.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.w localw = d.f(this);
      if ((localw != null) && ((localw instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localw).sQ(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.BJa != null)) {
        sS(paramIntent.getBooleanExtra("isMute", this.BJa.fOX));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.BJa != null)) {
        TG(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.BJa.HWa));
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eO(com.tencent.mm.plugin.boots.a.b.nZu, 885);
    com.tencent.mm.plugin.websearch.api.a.a.md(13);
    AppMethodBeat.o(126514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126544);
    super.onDestroy();
    this.BOD.fSZ.close();
    AppMethodBeat.o(126544);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126545);
    if ((paramInt == 4) && (this.BOD.getVisibility() == 0))
    {
      this.BOD.hide();
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
    this.BOD.onPause();
    AppMethodBeat.o(126542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126543);
    super.onResume();
    this.BOD.onResume();
    AppMethodBeat.o(126543);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI
 * JD-Core Version:    0.7.0.1
 */