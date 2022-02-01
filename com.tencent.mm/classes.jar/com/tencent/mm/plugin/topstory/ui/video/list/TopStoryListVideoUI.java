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
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private ProgressDialog BwX;
  private View BwY;
  private View BwZ;
  private View BxV;
  private TextView BxW;
  private e BxX;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d BxY;
  private View BxZ;
  private View Bxa;
  private Button Bxb;
  View Bxc;
  com.tencent.mm.plugin.topstory.ui.widget.c Bxd;
  View Bxe;
  TopStoryCommentFloatDialog Bxf;
  private boolean Bxg;
  private View Bya;
  View Byb;
  com.tencent.mm.plugin.topstory.ui.widget.c Byc;
  View Byd;
  private long Bye = 0L;
  
  private void eqM()
  {
    AppMethodBeat.i(126522);
    if (!this.BuW)
    {
      this.BwZ.setVisibility(0);
      this.BwY.setVisibility(0);
    }
    for (;;)
    {
      this.BuP.Th(0);
      AppMethodBeat.o(126522);
      return;
      this.Bya.setVisibility(0);
      this.BxZ.setVisibility(0);
    }
  }
  
  private void eqR()
  {
    AppMethodBeat.i(126535);
    if (al.aG(this))
    {
      int i = al.aF(this);
      Object localObject = (RelativeLayout.LayoutParams)this.yJh.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.yJh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.BxV.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.BxV.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(126535);
  }
  
  public final boolean SX(int paramInt)
  {
    AppMethodBeat.i(126527);
    this.Bxc.setVisibility(8);
    this.Byb.setVisibility(8);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.BuW) {
          continue;
        }
        if (paramInt < this.BuD.getItemCount() - this.BuD.getFootersCount() - this.BuD.getHeadersCount())
        {
          RecyclerView localRecyclerView = this.BuB;
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(126527);
          return true;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BuD.getItemCount()), Integer.valueOf(this.BuD.getFootersCount()), Integer.valueOf(this.BuD.getHeadersCount()) });
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(126527);
      return false;
      if (paramInt < this.BxX.getItemCount() - this.BxX.getFootersCount() - this.BxX.getHeadersCount())
      {
        this.BuA.a(this, this.BxX.getHeadersCount() + paramInt);
        AppMethodBeat.o(126527);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BxX.getItemCount()), Integer.valueOf(this.BxX.getFootersCount()), Integer.valueOf(this.BxX.getHeadersCount()) });
    }
  }
  
  public final void Te(int paramInt)
  {
    AppMethodBeat.i(126530);
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (!bool) {
        break label125;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label96;
      }
      if (!this.BuW) {
        break;
      }
      AppMethodBeat.o(126530);
      return;
    }
    bnj();
    AppMethodBeat.o(126530);
    return;
    label96:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.BuW)
      {
        AppMethodBeat.o(126530);
        return;
      }
      dfI();
    }
    label125:
    AppMethodBeat.o(126530);
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(126515);
    super.Zd();
    if (epz().HCg != null) {
      this.BuP.h(epz().HCg);
    }
    AppMethodBeat.o(126515);
  }
  
  public final void a(dei paramdei)
  {
    AppMethodBeat.i(126537);
    if (this.BuW) {
      dfI();
    }
    this.BuL.Bvq = true;
    this.BuO.stopPlay();
    dod localdod = this.BuP.Tg(epE());
    doa localdoa = com.tencent.mm.plugin.topstory.a.h.a(epz());
    localdoa.qXu = UUID.randomUUID().toString();
    localdoa.HCb = localdod.tSk;
    localdoa.HCf = paramdei.HsJ;
    localdoa.HCg = null;
    localdoa.HCh = paramdei;
    localdoa.HCi = this.BuL.Bvq;
    Object localObject = localdoa.DBj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aag localaag = (aag)((Iterator)localObject).next();
      if ("show_tag_list".equals(localaag.key)) {
        localaag.FZf = paramdei.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new aag();
        ((aag)localObject).key = "show_tag_list";
        ((aag)localObject).FZf = paramdei.id;
        localdoa.DBj.add(localObject);
      }
      com.tencent.mm.plugin.websearch.api.ad.a(this, localdoa, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.ma(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(epz(), localdod, epE(), 4, paramdei.dxD + ":" + paramdei.id);
      AppMethodBeat.o(126537);
      return;
    }
  }
  
  public final void a(dod paramdod, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126539);
    if (epz().HCh != null)
    {
      AppMethodBeat.o(126539);
      return;
    }
    if ((paramdod == null) || (paramdod.HCF == null))
    {
      AppMethodBeat.o(126539);
      return;
    }
    Object localObject = this.BuM.BvO;
    int i;
    int j;
    if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).Bre != 0L))
    {
      long l = (System.currentTimeMillis() - ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Bre) / 1000L;
      i = paramdod.HCF.HBX - 10;
      paramInt2 = paramdod.HCF.HBY * paramInt2 / 100 - 10;
      if ((!paramdod.HCF.HCa) && (l >= i) && (paramInt1 >= paramInt2))
      {
        localObject = this.BuP;
        doa localdoa = this.BrB;
        j = this.BuP.eqv();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", new Object[] { paramdod.tSk, Integer.valueOf(j), Long.valueOf(l) });
        if (((n)localObject).BvF != null)
        {
          com.tencent.mm.kernel.g.aiU().a(((n)localObject).BvF);
          ((n)localObject).BvF = null;
        }
        localdoa = com.tencent.mm.plugin.topstory.a.h.a(localdoa);
        localdoa.offset = j;
        ((n)localObject).BvF = new com.tencent.mm.plugin.topstory.a.c.h(localdoa, ((n)localObject).BtO.epE(), paramdod, l);
        com.tencent.mm.kernel.g.aiU().a(((n)localObject).BvF, 0);
        com.tencent.mm.kernel.g.aiU().a(1943, ((n)localObject).hPn);
        paramdod.HCF.HCa = true;
      }
      if ((!paramdod.HCF.dmo) && (l >= i + 10) && (paramInt1 >= paramInt2 + 10))
      {
        paramdod.HCF.dmo = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", new Object[] { Integer.valueOf(paramdod.HCF.HBZ.size()) });
        paramdod = paramdod.HCF.HBZ.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramdod.hasNext())
        {
          localObject = (dod)paramdod.next();
          if (((dod)localObject).HCF == null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", new Object[] { ((dod)localObject).tSk });
            continue;
            AppMethodBeat.o(126539);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", new Object[] { ((dod)localObject).tSk, Integer.valueOf(((dod)localObject).HCF.HBV) });
            if (((dod)localObject).HCF.HBV == 2)
            {
              paramInt2 = ((dod)localObject).HCF.FcU;
              j = epE();
              if (paramInt2 > 0)
              {
                paramInt1 = paramInt2;
                label492:
                paramInt1 = j + paramInt1;
                i = this.BuP.eqv() - 1;
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
      this.BuP.cNm().add(paramInt1, localObject);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), ((dod)localObject).tSk, ((dod)localObject).title });
      getRecyclerView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126499);
          TopStoryListVideoUI.this.epH().ck(paramInt1 + TopStoryListVideoUI.this.epH().getHeadersCount());
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
  
  public final void a(final dod paramdod, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126541);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramdod.tSk, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.Byb.getVisibility() == 0)
      {
        if ((this.Byc != null) && (this.Byc.hzm != null) && (this.Byc.hzm.equals(paramdod.tSk)))
        {
          this.Byb.setVisibility(8);
          AppMethodBeat.o(126541);
        }
      }
      else if ((this.Bxc.getVisibility() == 0) && (this.Bxd != null) && (this.Bxd.hzm != null) && (this.Bxd.hzm.equals(paramdod.tSk))) {
        this.Bxc.setVisibility(8);
      }
      AppMethodBeat.o(126541);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = paramdod.tul;
    Object localObject3 = paramdod.title;
    Object localObject4 = epz().keN;
    int j = epz().scene;
    if (epI()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, paramdod.tSk, paramdod.HCJ);
      if (!this.BuW) {
        break;
      }
      this.Byb.setVisibility(0);
      this.Bxc.setVisibility(8);
      this.Byc = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Byd, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126502);
          TopStoryListVideoUI.this.Bxf.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void eqO()
            {
              AppMethodBeat.i(126501);
              TopStoryListVideoUI.this.Byb.setVisibility(8);
              TopStoryListVideoUI.this.Bxc.setVisibility(8);
              AppMethodBeat.o(126501);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126500);
              TopStoryListVideoUI.this.BuO.eaq();
              AppMethodBeat.o(126500);
            }
          }, (int)TopStoryListVideoUI.j(TopStoryListVideoUI.this).HCf, paramdod.HCx);
          if (TopStoryListVideoUI.this.BuO.eqE()) {
            TopStoryListVideoUI.this.BuO.cxw();
          }
          AppMethodBeat.o(126502);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramdod.tSk);
      paramdod = this.Byc;
      i = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0F);
      localObject2 = paramView.getContext();
      localObject3 = paramdod.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      j = paramView.getWidth();
      int k = al.ci((Context)localObject2).x;
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
      paramView = (LinearLayout.LayoutParams)paramdod.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      paramdod.contentView.setLayoutParams(paramView);
      this.Byb.postDelayed(new TopStoryListVideoUI.4(this), 1800L);
      AppMethodBeat.o(126541);
      return;
    }
    this.Byb.setVisibility(8);
    this.Bxc.setVisibility(0);
    this.Bxd = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Bxe, new c.a()
    {
      public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
      {
        AppMethodBeat.i(126506);
        TopStoryListVideoUI.this.Bxf.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
        {
          public final void eqO()
          {
            AppMethodBeat.i(126505);
            TopStoryListVideoUI.this.Byb.setVisibility(8);
            TopStoryListVideoUI.this.Bxc.setVisibility(8);
            AppMethodBeat.o(126505);
          }
          
          public final void onDismiss()
          {
            AppMethodBeat.i(126504);
            TopStoryListVideoUI.this.BuO.eaq();
            AppMethodBeat.o(126504);
          }
        }, (int)TopStoryListVideoUI.k(TopStoryListVideoUI.this).HCf, paramdod.HCx);
        if (TopStoryListVideoUI.this.BuO.eqE()) {
          TopStoryListVideoUI.this.BuO.cxw();
        }
        AppMethodBeat.o(126506);
      }
    }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramdod.tSk);
    this.Bxd.a(paramView, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0F));
    AppMethodBeat.o(126541);
  }
  
  public final void a(dod paramdod, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt)
  {
    AppMethodBeat.i(126538);
    if ((paramdod.HCO != null) && (paramdod.HCO.HBR != null)) {
      if ((paramInt >= paramdod.HCO.HBO) && (paramInt <= paramdod.HCO.htQ))
      {
        if (!paramdod.HCO.dmo)
        {
          paramdod.HCO.dmo = true;
          paramf.eqc();
          AppMethodBeat.o(126538);
        }
      }
      else {
        paramf.eqd();
      }
    }
    AppMethodBeat.o(126538);
  }
  
  public final void aCV(final String paramString)
  {
    AppMethodBeat.i(126529);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126512);
        if (!TopStoryListVideoUI.this.BuW)
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
  
  public final void bnj()
  {
    AppMethodBeat.i(126533);
    long l = System.currentTimeMillis();
    if (l - this.Bye < 1000L)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.Bye = l;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    if (this.BuO.BvT != null)
    {
      this.BrB.HCl = this.BuO.BvT.getControlBar().getmPosition();
      if (this.BuO.BvT.getControlBar().getVideoTotalTime() - this.BrB.HCl < 2)
      {
        AppMethodBeat.o(126533);
        return;
      }
    }
    sK(false);
    this.BuW = true;
    this.Byb.setVisibility(8);
    this.Bxc.setVisibility(8);
    if (!epI()) {
      setRequestedOrientation(0);
    }
    if ((this.BuT != null) && (this.BuT.isShowing()))
    {
      this.BuT.dismiss();
      this.BuT = null;
    }
    this.BxV.setVisibility(8);
    this.iVq.setVisibility(8);
    this.Buw.setVisibility(8);
    this.Buy.setVisibility(8);
    this.BuB.setVisibility(0);
    this.BxX.asY.notifyChanged();
    if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IEq, 0) == 0)
    {
      this.BuO.cxw();
      this.Bxa.setVisibility(0);
      this.Bxa.setOnTouchListener(new TopStoryListVideoUI.12(this));
      this.Bxb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126513);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEq, Integer.valueOf(1));
          TopStoryListVideoUI.this.BuO.eaq();
          TopStoryListVideoUI.h(TopStoryListVideoUI.this).setVisibility(8);
          TopStoryListVideoUI.i(TopStoryListVideoUI.this).b(TopStoryListVideoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126513);
        }
      });
    }
    for (;;)
    {
      this.BxY.Bwg = true;
      this.BuC.ag(epz().HCk, 0);
      getSwipeBackLayout().setEnableGesture(false);
      sK(true);
      if (al.aG(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yJh.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
        this.yJh.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(126533);
      return;
      this.Bxa.setVisibility(8);
    }
  }
  
  public final void dfI()
  {
    AppMethodBeat.i(126534);
    long l = System.currentTimeMillis();
    if (l - this.Bye < 1000L)
    {
      AppMethodBeat.o(126534);
      return;
    }
    this.Bye = l;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.BuO.BvT != null)
    {
      this.BrB.HCl = this.BuO.BvT.getControlBar().getmPosition();
      if (this.BuO.BvT.getControlBar().getVideoTotalTime() - this.BrB.HCl < 2)
      {
        AppMethodBeat.o(126534);
        return;
      }
    }
    sK(false);
    this.BuW = false;
    this.Byb.setVisibility(8);
    this.Bxc.setVisibility(8);
    if (!epI()) {
      setRequestedOrientation(1);
    }
    if ((this.BuT != null) && (this.BuT.isShowing()))
    {
      this.BuT.dismiss();
      this.BuT = null;
    }
    this.BxV.setVisibility(0);
    if (epz().HCh == null) {
      this.iVq.setVisibility(0);
    }
    this.Buy.setVisibility(0);
    this.BuB.setVisibility(8);
    this.BxY.asY.notifyChanged();
    this.Bxa.setVisibility(8);
    this.BxX.Bxw = true;
    this.nLX.ag(epz().HCk + this.BxX.getHeadersCount(), epK());
    getSwipeBackLayout().setEnableGesture(true);
    sK(true);
    eqR();
    AppMethodBeat.o(126534);
  }
  
  public final int epK()
  {
    AppMethodBeat.i(126536);
    if (al.aG(this))
    {
      i = super.epK();
      int j = al.aF(this);
      AppMethodBeat.o(126536);
      return i + j;
    }
    int i = super.epK();
    AppMethodBeat.o(126536);
    return i;
  }
  
  public final int epP()
  {
    return 0;
  }
  
  public final void ept()
  {
    AppMethodBeat.i(126524);
    if (!this.BuW) {
      this.BxV.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.yJh.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((epz().HCh != null) && (this.BxW != null)) {
        this.BxW.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(126524);
      return;
      this.Byb.setVisibility(8);
    }
  }
  
  public final void epu()
  {
    AppMethodBeat.i(126525);
    this.yJh.animate().cancel();
    this.yJh.setAlpha(1.0F);
    if ((epz().HCh != null) && (this.BxW != null)) {
      this.BxW.setAlpha(1.0F);
    }
    AppMethodBeat.o(126525);
  }
  
  public final void eqj()
  {
    AppMethodBeat.i(126518);
    super.eqj();
    if (this.BuW)
    {
      dfI();
      AppMethodBeat.o(126518);
      return;
    }
    if (this.BrB != null)
    {
      this.BuM.eqz();
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.BrB.fMP);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.BrB.HCn);
      localIntent.putExtra("key_video_play_info", bt.m(this.BuM.BvP, ";"));
      localIntent.putExtra("key_search_id", epz().keN);
      setResult(-1, localIntent);
    }
    if (!this.BuF.sv(2)) {
      finish();
    }
    AppMethodBeat.o(126518);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d eqk()
  {
    AppMethodBeat.i(126520);
    d locald = new d();
    AppMethodBeat.o(126520);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d eql()
  {
    AppMethodBeat.i(126540);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(126540);
    return localc;
  }
  
  public final void eqm()
  {
    AppMethodBeat.i(126526);
    super.eqm();
    if ((!this.BuW) && (this.BxV.getAlpha() != 0.0F))
    {
      this.BxV.animate().cancel();
      this.BxV.setAlpha(0.0F);
    }
    AppMethodBeat.o(126526);
  }
  
  public final void eqn()
  {
    AppMethodBeat.i(126521);
    if (!this.BuW)
    {
      this.BwZ.setVisibility(0);
      this.BwY.setVisibility(0);
    }
    for (;;)
    {
      this.BuP.Th(this.BuP.eqv());
      AppMethodBeat.o(126521);
      return;
      this.Bya.setVisibility(0);
      this.BxZ.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e eqp()
  {
    AppMethodBeat.i(126531);
    this.BxX = new e(this);
    e locale = this.BxX;
    View localView1 = LayoutInflater.from(this).inflate(2131495792, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(2131300708);
    View localView2 = localView1.findViewById(2131300719);
    if (epz().HCh != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.BxW = ((TextView)localView1.findViewById(2131300732));
      this.BxW.setText(epz().HCh.title);
      localObject = (TextView)localView1.findViewById(2131305507);
      if (!bt.isNullOrNil(epz().HCh.nch)) {
        ((TextView)localObject).setText(epz().HCh.nch);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (al.aG(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = al.aF(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.addHeaderView(localView1);
      locale = this.BxX;
      localView1 = LayoutInflater.from(this).inflate(2131495794, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cc.a.iq(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(2131166931));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.BwZ = localView1.findViewById(2131300203);
      this.BwY = localView1.findViewById(2131300207);
      locale.fC(localView1);
      locale = this.BxX;
      AppMethodBeat.o(126531);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e eqq()
  {
    AppMethodBeat.i(126532);
    this.BxY = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.BxY;
    View localView = LayoutInflater.from(this).inflate(2131495794, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.Bya = localView.findViewById(2131300203);
    this.BxZ = localView.findViewById(2131300207);
    locald.fC(localView);
    locald = this.BxY;
    AppMethodBeat.o(126532);
    return locald;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126516);
    if ((this.BuW) && (!epI()))
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
  
  public final void ij(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126523);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.Bxg)) {
      eqM();
    }
    super.ij(paramInt1, paramInt2);
    AppMethodBeat.o(126523);
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(126519);
    super.initContentView();
    this.Bxa = findViewById(2131300313);
    this.Bxb = ((Button)findViewById(2131304375));
    this.BxV = findViewById(2131305911);
    this.BxV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126498);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((TopStoryListVideoUI.this.BuO.BvU) && (TopStoryListVideoUI.this.BuO.BvT.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.BuO.BvT.getItemUIComponent().epu();
          TopStoryListVideoUI.this.BuO.BvT.getItemUIComponent().ept();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126498);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
    if (epz().HCh != null) {
      this.iVq.setVisibility(8);
    }
    this.BuM.BvN = 2;
    if (eqo()) {
      if (this.BuL.isConnected())
      {
        eqM();
        this.Bxg = false;
        if ((epz().scene != 21) && (epz().HCh == null)) {
          this.BwX = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new TopStoryListVideoUI.6(this));
        }
      }
    }
    for (;;)
    {
      this.BxX.Bxl = true;
      if (epz().HCi) {
        this.BuL.Bvq = true;
      }
      this.Buy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126508);
          TopStoryListVideoUI.this.BuM.eqy();
          AppMethodBeat.o(126508);
        }
      });
      new c(this).j(this.Buy);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().j(this.BuB);
      this.Bxc = findViewById(2131299128);
      this.Bxe = findViewById(2131299129);
      this.Bxc.setVisibility(8);
      this.Byb = findViewById(2131299123);
      this.Byd = findViewById(2131299124);
      this.Byb.setVisibility(8);
      this.Bxc.setOnTouchListener(new TopStoryListVideoUI.8(this));
      this.Byb.setOnTouchListener(new TopStoryListVideoUI.9(this));
      this.Bxf = ((TopStoryCommentFloatDialog)findViewById(2131298520));
      this.Bxf.setVisibility(8);
      this.Bxf.o(this);
      eqR();
      AppMethodBeat.o(126519);
      return;
      Toast.makeText(this, 2131762228, 1).show();
      this.Bxg = true;
      continue;
      this.BwZ.setVisibility(4);
      this.BwY.setVisibility(4);
    }
  }
  
  public final void n(List<dod> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126528);
    super.n(paramList, paramBoolean);
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126511);
        if (!TopStoryListVideoUI.this.BuW)
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
    p.BvQ.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.w localw = d.f(this);
      if ((localw != null) && ((localw instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localw).sJ(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.BrB != null)) {
        sL(paramIntent.getBooleanExtra("isMute", this.BrB.fMP));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.BrB != null)) {
        SZ(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.BrB.HCn));
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eN(com.tencent.mm.plugin.boots.a.b.nTO, 885);
    com.tencent.mm.plugin.websearch.api.a.a.ma(13);
    AppMethodBeat.o(126514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126544);
    super.onDestroy();
    this.Bxf.fQT.close();
    AppMethodBeat.o(126544);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126545);
    if ((paramInt == 4) && (this.Bxf.getVisibility() == 0))
    {
      this.Bxf.hide();
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
    this.Bxf.onPause();
    AppMethodBeat.o(126542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126543);
    super.onResume();
    this.Bxf.onResume();
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