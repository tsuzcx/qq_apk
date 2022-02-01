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
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ai;
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
  private Button yRA;
  View yRB;
  com.tencent.mm.plugin.topstory.ui.widget.c yRC;
  View yRD;
  TopStoryCommentFloatDialog yRE;
  private boolean yRF;
  private ProgressDialog yRw;
  private View yRx;
  private View yRy;
  private View yRz;
  View ySA;
  com.tencent.mm.plugin.topstory.ui.widget.c ySB;
  View ySC;
  private long ySD = 0L;
  private View ySu;
  private TextView ySv;
  private e ySw;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d ySx;
  private View ySy;
  private View ySz;
  
  private void dPW()
  {
    AppMethodBeat.i(126522);
    if (!this.yPu)
    {
      this.yRy.setVisibility(0);
      this.yRx.setVisibility(0);
    }
    for (;;)
    {
      this.yPn.Pr(0);
      AppMethodBeat.o(126522);
      return;
      this.ySz.setVisibility(0);
      this.ySy.setVisibility(0);
    }
  }
  
  private void dQb()
  {
    AppMethodBeat.i(126535);
    if (ai.aF(this))
    {
      int i = ai.aE(this);
      Object localObject = (RelativeLayout.LayoutParams)this.wjg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.wjg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.ySu.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.ySu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(126535);
  }
  
  public final boolean Ph(int paramInt)
  {
    AppMethodBeat.i(126527);
    this.yRB.setVisibility(8);
    this.ySA.setVisibility(8);
    ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.yPu) {
          continue;
        }
        if (paramInt < this.yPb.getItemCount() - this.yPb.getFootersCount() - this.yPb.getHeadersCount())
        {
          RecyclerView localRecyclerView = this.yOZ;
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(126527);
          return true;
        }
        ad.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.yPb.getItemCount()), Integer.valueOf(this.yPb.getFootersCount()), Integer.valueOf(this.yPb.getHeadersCount()) });
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(126527);
      return false;
      if (paramInt < this.ySw.getItemCount() - this.ySw.getFootersCount() - this.ySw.getHeadersCount())
      {
        this.yOY.a(this, this.ySw.getHeadersCount() + paramInt);
        AppMethodBeat.o(126527);
        return true;
      }
      ad.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ySw.getItemCount()), Integer.valueOf(this.ySw.getFootersCount()), Integer.valueOf(this.ySw.getHeadersCount()) });
    }
  }
  
  public final void Po(int paramInt)
  {
    AppMethodBeat.i(126530);
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (!bool) {
        break label125;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label96;
      }
      if (!this.yPu) {
        break;
      }
      AppMethodBeat.o(126530);
      return;
    }
    bcC();
    AppMethodBeat.o(126530);
    return;
    label96:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.yPu)
      {
        AppMethodBeat.o(126530);
        return;
      }
      cMY();
    }
    label125:
    AppMethodBeat.o(126530);
  }
  
  public final void VL()
  {
    AppMethodBeat.i(126515);
    super.VL();
    if (dOH().Euz != null) {
      this.yPn.h(dOH().Euz);
    }
    AppMethodBeat.o(126515);
  }
  
  public final void a(ctk paramctk)
  {
    AppMethodBeat.i(126537);
    if (this.yPu) {
      cMY();
    }
    this.yPj.yPO = true;
    this.yPm.stopPlay();
    ddb localddb = this.yPn.Pq(dOM());
    dcy localdcy = com.tencent.mm.plugin.topstory.a.h.a(dOH());
    localdcy.qwV = UUID.randomUUID().toString();
    localdcy.Euu = localddb.rNP;
    localdcy.Euy = paramctk.Eld;
    localdcy.Euz = null;
    localdcy.EuA = paramctk;
    localdcy.EuB = this.yPj.yPO;
    Object localObject = localdcy.AFX.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xp localxp = (xp)((Iterator)localObject).next();
      if ("show_tag_list".equals(localxp.key)) {
        localxp.CZj = paramctk.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new xp();
        ((xp)localObject).key = "show_tag_list";
        ((xp)localObject).CZj = paramctk.id;
        localdcy.AFX.add(localObject);
      }
      aa.a(this, localdcy, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.lI(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(dOH(), localddb, dOM(), 4, paramctk.doh + ":" + paramctk.id);
      AppMethodBeat.o(126537);
      return;
    }
  }
  
  public final void a(ddb paramddb, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126539);
    if (dOH().EuA != null)
    {
      AppMethodBeat.o(126539);
      return;
    }
    if ((paramddb == null) || (paramddb.EuY == null))
    {
      AppMethodBeat.o(126539);
      return;
    }
    Object localObject = this.yPk.yQm;
    int i;
    int j;
    if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLz != 0L))
    {
      long l = (System.currentTimeMillis() - ((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLz) / 1000L;
      i = paramddb.EuY.Euq - 10;
      paramInt2 = paramddb.EuY.Eur * paramInt2 / 100 - 10;
      if ((!paramddb.EuY.Eut) && (l >= i) && (paramInt1 >= paramInt2))
      {
        localObject = this.yPn;
        dcy localdcy = this.yLX;
        j = this.yPn.dPF();
        ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", new Object[] { paramddb.rNP, Integer.valueOf(j), Long.valueOf(l) });
        if (((n)localObject).yQd != null)
        {
          com.tencent.mm.kernel.g.aeS().a(((n)localObject).yQd);
          ((n)localObject).yQd = null;
        }
        localdcy = com.tencent.mm.plugin.topstory.a.h.a(localdcy);
        localdcy.offset = j;
        ((n)localObject).yQd = new com.tencent.mm.plugin.topstory.a.c.h(localdcy, ((n)localObject).yOm.dOM(), paramddb, l);
        com.tencent.mm.kernel.g.aeS().a(((n)localObject).yQd, 0);
        com.tencent.mm.kernel.g.aeS().a(1943, ((n)localObject).gWw);
        paramddb.EuY.Eut = true;
      }
      if ((!paramddb.EuY.ddw) && (l >= i + 10) && (paramInt1 >= paramInt2 + 10))
      {
        paramddb.EuY.ddw = true;
        ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", new Object[] { Integer.valueOf(paramddb.EuY.Eus.size()) });
        paramddb = paramddb.EuY.Eus.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramddb.hasNext())
        {
          localObject = (ddb)paramddb.next();
          if (((ddb)localObject).EuY == null)
          {
            ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", new Object[] { ((ddb)localObject).rNP });
            continue;
            AppMethodBeat.o(126539);
          }
          else
          {
            ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", new Object[] { ((ddb)localObject).rNP, Integer.valueOf(((ddb)localObject).EuY.Euo) });
            if (((ddb)localObject).EuY.Euo == 2)
            {
              paramInt2 = ((ddb)localObject).EuY.Cfu;
              j = dOM();
              if (paramInt2 > 0)
              {
                paramInt1 = paramInt2;
                label492:
                paramInt1 = j + paramInt1;
                i = this.yPn.dPF() - 1;
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
      this.yPn.dPE().add(paramInt1, localObject);
      ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), ((ddb)localObject).rNP, ((ddb)localObject).title });
      getRecyclerView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126499);
          TopStoryListVideoUI.this.dOP().cl(paramInt1 + TopStoryListVideoUI.this.dOP().getHeadersCount());
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
  
  public final void a(final ddb paramddb, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126541);
    ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramddb.rNP, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.ySA.getVisibility() == 0)
      {
        if ((this.ySB != null) && (this.ySB.gGC != null) && (this.ySB.gGC.equals(paramddb.rNP)))
        {
          this.ySA.setVisibility(8);
          AppMethodBeat.o(126541);
        }
      }
      else if ((this.yRB.getVisibility() == 0) && (this.yRC != null) && (this.yRC.gGC != null) && (this.yRC.gGC.equals(paramddb.rNP))) {
        this.yRB.setVisibility(8);
      }
      AppMethodBeat.o(126541);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = paramddb.roQ;
    Object localObject3 = paramddb.title;
    Object localObject4 = dOH().jko;
    int j = dOH().scene;
    if (dOQ()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, paramddb.rNP, paramddb.Evc);
      if (!this.yPu) {
        break;
      }
      this.ySA.setVisibility(0);
      this.yRB.setVisibility(8);
      this.ySB = new com.tencent.mm.plugin.topstory.ui.widget.c(this.ySC, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126502);
          TopStoryListVideoUI.this.yRE.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void dPY()
            {
              AppMethodBeat.i(126501);
              TopStoryListVideoUI.this.ySA.setVisibility(8);
              TopStoryListVideoUI.this.yRB.setVisibility(8);
              AppMethodBeat.o(126501);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126500);
              TopStoryListVideoUI.this.yPm.dzF();
              AppMethodBeat.o(126500);
            }
          }, (int)TopStoryListVideoUI.j(TopStoryListVideoUI.this).Euy, paramddb.EuQ);
          if (TopStoryListVideoUI.this.yPm.dPO()) {
            TopStoryListVideoUI.this.yPm.ckd();
          }
          AppMethodBeat.o(126502);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramddb.rNP);
      paramddb = this.ySB;
      i = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0F);
      localObject2 = paramView.getContext();
      localObject3 = paramddb.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      j = paramView.getWidth();
      int k = ai.cf((Context)localObject2).x;
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
      paramView = (LinearLayout.LayoutParams)paramddb.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      paramddb.contentView.setLayoutParams(paramView);
      this.ySA.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126503);
          if (TopStoryListVideoUI.this.ySA.getVisibility() == 0) {
            TopStoryListVideoUI.this.ySA.setVisibility(8);
          }
          AppMethodBeat.o(126503);
        }
      }, 1800L);
      AppMethodBeat.o(126541);
      return;
    }
    this.ySA.setVisibility(8);
    this.yRB.setVisibility(0);
    this.yRC = new com.tencent.mm.plugin.topstory.ui.widget.c(this.yRD, new c.a()
    {
      public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
      {
        AppMethodBeat.i(126506);
        TopStoryListVideoUI.this.yRE.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
        {
          public final void dPY()
          {
            AppMethodBeat.i(126505);
            TopStoryListVideoUI.this.ySA.setVisibility(8);
            TopStoryListVideoUI.this.yRB.setVisibility(8);
            AppMethodBeat.o(126505);
          }
          
          public final void onDismiss()
          {
            AppMethodBeat.i(126504);
            TopStoryListVideoUI.this.yPm.dzF();
            AppMethodBeat.o(126504);
          }
        }, (int)TopStoryListVideoUI.k(TopStoryListVideoUI.this).Euy, paramddb.EuQ);
        if (TopStoryListVideoUI.this.yPm.dPO()) {
          TopStoryListVideoUI.this.yPm.ckd();
        }
        AppMethodBeat.o(126506);
      }
    }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramddb.rNP);
    this.yRC.a(paramView, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0F));
    AppMethodBeat.o(126541);
  }
  
  public final void a(ddb paramddb, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt)
  {
    AppMethodBeat.i(126538);
    if ((paramddb.Evh != null) && (paramddb.Evh.Euk != null)) {
      if ((paramInt >= paramddb.Evh.Euh) && (paramInt <= paramddb.Evh.gBm))
      {
        if (!paramddb.Evh.ddw)
        {
          paramddb.Evh.ddw = true;
          paramf.dPk();
          AppMethodBeat.o(126538);
        }
      }
      else {
        paramf.dPl();
      }
    }
    AppMethodBeat.o(126538);
  }
  
  public final void asH(final String paramString)
  {
    AppMethodBeat.i(126529);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126512);
        if (!TopStoryListVideoUI.this.yPu)
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
  
  public final void bcC()
  {
    AppMethodBeat.i(126533);
    long l = System.currentTimeMillis();
    if (l - this.ySD < 1000L)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.ySD = l;
    ad.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    if (this.yPm.yQr != null)
    {
      this.yLX.EuE = this.yPm.yQr.getControlBar().getmPosition();
      if (this.yPm.yQr.getControlBar().getVideoTotalTime() - this.yLX.EuE < 2)
      {
        AppMethodBeat.o(126533);
        return;
      }
    }
    rg(false);
    this.yPu = true;
    this.ySA.setVisibility(8);
    this.yRB.setVisibility(8);
    if (!dOQ()) {
      setRequestedOrientation(0);
    }
    if ((this.yPr != null) && (this.yPr.isShowing()))
    {
      this.yPr.dismiss();
      this.yPr = null;
    }
    this.ySu.setVisibility(8);
    this.ica.setVisibility(8);
    this.yOU.setVisibility(8);
    this.yOW.setVisibility(8);
    this.yOZ.setVisibility(0);
    this.ySw.aql.notifyChanged();
    if (com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.FtS, 0) == 0)
    {
      this.yPm.ckd();
      this.yRz.setVisibility(0);
      this.yRz.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.yRA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126513);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtS, Integer.valueOf(1));
          TopStoryListVideoUI.this.yPm.dzF();
          TopStoryListVideoUI.h(TopStoryListVideoUI.this).setVisibility(8);
          TopStoryListVideoUI.i(TopStoryListVideoUI.this).b(TopStoryListVideoUI.this);
          AppMethodBeat.o(126513);
        }
      });
    }
    for (;;)
    {
      this.ySx.yQE = true;
      this.yPa.af(dOH().EuD, 0);
      getSwipeBackLayout().setEnableGesture(false);
      rg(true);
      if (ai.aF(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.wjg.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        this.wjg.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(126533);
      return;
      this.yRz.setVisibility(8);
    }
  }
  
  public final void cMY()
  {
    AppMethodBeat.i(126534);
    long l = System.currentTimeMillis();
    if (l - this.ySD < 1000L)
    {
      AppMethodBeat.o(126534);
      return;
    }
    this.ySD = l;
    ad.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.yPm.yQr != null)
    {
      this.yLX.EuE = this.yPm.yQr.getControlBar().getmPosition();
      if (this.yPm.yQr.getControlBar().getVideoTotalTime() - this.yLX.EuE < 2)
      {
        AppMethodBeat.o(126534);
        return;
      }
    }
    rg(false);
    this.yPu = false;
    this.ySA.setVisibility(8);
    this.yRB.setVisibility(8);
    if (!dOQ()) {
      setRequestedOrientation(1);
    }
    if ((this.yPr != null) && (this.yPr.isShowing()))
    {
      this.yPr.dismiss();
      this.yPr = null;
    }
    this.ySu.setVisibility(0);
    if (dOH().EuA == null) {
      this.ica.setVisibility(0);
    }
    this.yOW.setVisibility(0);
    this.yOZ.setVisibility(8);
    this.ySx.aql.notifyChanged();
    this.yRz.setVisibility(8);
    this.ySw.yRV = true;
    this.mJn.af(dOH().EuD + this.ySw.getHeadersCount(), dOS());
    getSwipeBackLayout().setEnableGesture(true);
    rg(true);
    dQb();
    AppMethodBeat.o(126534);
  }
  
  public final void dOB()
  {
    AppMethodBeat.i(126524);
    if (!this.yPu) {
      this.ySu.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.wjg.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((dOH().EuA != null) && (this.ySv != null)) {
        this.ySv.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(126524);
      return;
      this.ySA.setVisibility(8);
    }
  }
  
  public final void dOC()
  {
    AppMethodBeat.i(126525);
    this.wjg.animate().cancel();
    this.wjg.setAlpha(1.0F);
    if ((dOH().EuA != null) && (this.ySv != null)) {
      this.ySv.setAlpha(1.0F);
    }
    AppMethodBeat.o(126525);
  }
  
  public final int dOS()
  {
    AppMethodBeat.i(126536);
    if (ai.aF(this))
    {
      i = super.dOS();
      int j = ai.aE(this);
      AppMethodBeat.o(126536);
      return i + j;
    }
    int i = super.dOS();
    AppMethodBeat.o(126536);
    return i;
  }
  
  public final int dOX()
  {
    return 0;
  }
  
  public final void dPr()
  {
    AppMethodBeat.i(126518);
    super.dPr();
    if (this.yPu)
    {
      cMY();
      AppMethodBeat.o(126518);
      return;
    }
    if (this.yLX != null)
    {
      this.yPk.dPJ();
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.yLX.fqj);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.yLX.EuG);
      localIntent.putExtra("key_video_play_info", bt.n(this.yPk.yQn, ";"));
      localIntent.putExtra("key_search_id", dOH().jko);
      setResult(-1, localIntent);
    }
    if (!this.yPd.rg(2)) {
      finish();
    }
    AppMethodBeat.o(126518);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d dPt()
  {
    AppMethodBeat.i(126520);
    d locald = new d();
    AppMethodBeat.o(126520);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d dPu()
  {
    AppMethodBeat.i(126540);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(126540);
    return localc;
  }
  
  public final void dPv()
  {
    AppMethodBeat.i(126526);
    super.dPv();
    if ((!this.yPu) && (this.ySu.getAlpha() != 0.0F))
    {
      this.ySu.animate().cancel();
      this.ySu.setAlpha(0.0F);
    }
    AppMethodBeat.o(126526);
  }
  
  public final void dPw()
  {
    AppMethodBeat.i(126521);
    if (!this.yPu)
    {
      this.yRy.setVisibility(0);
      this.yRx.setVisibility(0);
    }
    for (;;)
    {
      this.yPn.Pr(this.yPn.dPF());
      AppMethodBeat.o(126521);
      return;
      this.ySz.setVisibility(0);
      this.ySy.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e dPy()
  {
    AppMethodBeat.i(126531);
    this.ySw = new e(this);
    e locale = this.ySw;
    View localView1 = LayoutInflater.from(this).inflate(2131495792, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(2131300708);
    View localView2 = localView1.findViewById(2131300719);
    if (dOH().EuA != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.ySv = ((TextView)localView1.findViewById(2131300732));
      this.ySv.setText(dOH().EuA.title);
      localObject = (TextView)localView1.findViewById(2131305507);
      if (!bt.isNullOrNil(dOH().EuA.lZG)) {
        ((TextView)localObject).setText(dOH().EuA.lZG);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (ai.aF(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = ai.aE(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.addHeaderView(localView1);
      locale = this.ySw;
      localView1 = LayoutInflater.from(this).inflate(2131495794, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cd.a.hW(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(2131166931));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.yRy = localView1.findViewById(2131300203);
      this.yRx = localView1.findViewById(2131300207);
      locale.fc(localView1);
      locale = this.ySw;
      AppMethodBeat.o(126531);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e dPz()
  {
    AppMethodBeat.i(126532);
    this.ySx = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.ySx;
    View localView = LayoutInflater.from(this).inflate(2131495794, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.ySz = localView.findViewById(2131300203);
    this.ySy = localView.findViewById(2131300207);
    locald.fc(localView);
    locald = this.ySx;
    AppMethodBeat.o(126532);
    return locald;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126516);
    if ((this.yPu) && (!dOQ()))
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
  
  public final void hJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126523);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.yRF)) {
      dPW();
    }
    super.hJ(paramInt1, paramInt2);
    AppMethodBeat.o(126523);
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(126519);
    super.initContentView();
    this.yRz = findViewById(2131300313);
    this.yRA = ((Button)findViewById(2131304375));
    this.ySu = findViewById(2131305911);
    this.ySu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126498);
        if ((TopStoryListVideoUI.this.yPm.yQs) && (TopStoryListVideoUI.this.yPm.yQr.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.yPm.yQr.getItemUIComponent().dOC();
          TopStoryListVideoUI.this.yPm.yQr.getItemUIComponent().dOB();
        }
        AppMethodBeat.o(126498);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.lLF, MMFragmentActivity.a.lLG);
    if (dOH().EuA != null) {
      this.ica.setVisibility(8);
    }
    this.yPk.yQl = 2;
    if (dPx()) {
      if (this.yPj.isConnected())
      {
        dPW();
        this.yRF = false;
        if ((dOH().scene != 21) && (dOH().EuA == null)) {
          this.yRw = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
      this.ySw.yRK = true;
      if (dOH().EuB) {
        this.yPj.yPO = true;
      }
      this.yOW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126508);
          TopStoryListVideoUI.this.yPk.dPI();
          AppMethodBeat.o(126508);
        }
      });
      new c(this).j(this.yOW);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().j(this.yOZ);
      this.yRB = findViewById(2131299128);
      this.yRD = findViewById(2131299129);
      this.yRB.setVisibility(8);
      this.ySA = findViewById(2131299123);
      this.ySC = findViewById(2131299124);
      this.ySA.setVisibility(8);
      this.yRB.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126509);
          if (TopStoryListVideoUI.this.yRB.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.h(TopStoryListVideoUI.this.yRD, f1, f2))
            {
              ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewNotFull");
              AppMethodBeat.o(126509);
              return false;
            }
            TopStoryListVideoUI.this.yRB.setVisibility(8);
          }
          AppMethodBeat.o(126509);
          return false;
        }
      });
      this.ySA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126510);
          if (TopStoryListVideoUI.this.ySA.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.h(TopStoryListVideoUI.this.ySC, f1, f2))
            {
              ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewFull");
              AppMethodBeat.o(126510);
              return false;
            }
            TopStoryListVideoUI.this.ySA.setVisibility(8);
          }
          AppMethodBeat.o(126510);
          return false;
        }
      });
      this.yRE = ((TopStoryCommentFloatDialog)findViewById(2131298520));
      this.yRE.setVisibility(8);
      this.yRE.m(this);
      dQb();
      AppMethodBeat.o(126519);
      return;
      Toast.makeText(this, 2131762228, 1).show();
      this.yRF = true;
      continue;
      this.yRy.setVisibility(4);
      this.yRx.setVisibility(4);
    }
  }
  
  public final void l(List<ddb> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126528);
    super.l(paramList, paramBoolean);
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126511);
        if (!TopStoryListVideoUI.this.yPu)
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
    p.yQo.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.v localv = d.f(this);
      if ((localv != null) && ((localv instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localv).rf(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.yLX != null)) {
        rh(paramIntent.getBooleanExtra("isMute", this.yLX.fqj));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.yLX != null)) {
        Pj(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.yLX.EuG));
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eG(com.tencent.mm.plugin.boots.a.b.mQH, 885);
    com.tencent.mm.plugin.websearch.api.a.a.lI(13);
    AppMethodBeat.o(126514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126544);
    super.onDestroy();
    this.yRE.ftZ.close();
    AppMethodBeat.o(126544);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126545);
    if ((paramInt == 4) && (this.yRE.getVisibility() == 0))
    {
      this.yRE.hide();
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
    this.yRE.onPause();
    AppMethodBeat.o(126542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126543);
    super.onResume();
    this.yRE.onResume();
    AppMethodBeat.o(126543);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI
 * JD-Core Version:    0.7.0.1
 */