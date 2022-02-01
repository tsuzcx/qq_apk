package com.tencent.mm.plugin.topstory.ui.video.list;

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
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.topstory.ui.c.b;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.foa;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
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
  private View TOA;
  private Button TOB;
  View TOC;
  com.tencent.mm.plugin.topstory.ui.widget.c TOD;
  View TOE;
  TopStoryCommentFloatDialog TOF;
  private boolean TOG;
  private ProgressDialog TOx;
  private View TOy;
  private View TOz;
  private View TPA;
  private View TPB;
  View TPC;
  com.tencent.mm.plugin.topstory.ui.widget.c TPD;
  View TPE;
  private long TPF = 0L;
  private View TPw;
  private TextView TPx;
  private e TPy;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d TPz;
  
  private void hOQ()
  {
    AppMethodBeat.i(126522);
    if (!this.TMw)
    {
      this.TOz.setVisibility(0);
      this.TOy.setVisibility(0);
    }
    for (;;)
    {
      this.TMp.apd(0);
      AppMethodBeat.o(126522);
      return;
      this.TPB.setVisibility(0);
      this.TPA.setVisibility(0);
    }
  }
  
  private void hOU()
  {
    AppMethodBeat.i(126535);
    if (aw.bx(this))
    {
      int i = aw.bw(this);
      Object localObject = (RelativeLayout.LayoutParams)this.AtJ.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.AtJ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.TPw.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.TPw.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(126535);
  }
  
  public final void H(List<foh> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126528);
    super.H(paramList, paramBoolean);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126511);
        if (!TopStoryListVideoUI.this.TMw)
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
          TopStoryListVideoUI.e(TopStoryListVideoUI.this).br(0, 3);
        }
      }
    }, 50L);
    AppMethodBeat.o(126528);
  }
  
  public final void a(fcl paramfcl)
  {
    AppMethodBeat.i(126537);
    if (this.TMw) {
      anI();
    }
    hNw().TMQ = true;
    this.TMo.stopPlay();
    foh localfoh = this.TMp.apc(hND());
    foe localfoe = com.tencent.mm.plugin.topstory.a.g.a(hNz());
    localfoe.zIO = UUID.randomUUID().toString();
    localfoe.abOf = localfoh.Ido;
    localfoe.abOj = paramfcl.abCa;
    localfoe.abOk = null;
    localfoe.abOl = paramfcl;
    localfoe.abOm = hNw().TMQ;
    Object localObject = localfoe.Wol.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aem localaem = (aem)((Iterator)localObject).next();
      if ("show_tag_list".equals(localaem.key)) {
        localaem.Zmy = paramfcl.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new aem();
        ((aem)localObject).key = "show_tag_list";
        ((aem)localObject).Zmy = paramfcl.id;
        localfoe.Wol.add(localObject);
      }
      aj.a(this, localfoe, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.rG(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(hNz(), localfoh, hND(), 4, paramfcl.wording + ":" + paramfcl.id);
      AppMethodBeat.o(126537);
      return;
    }
  }
  
  public final void a(foh paramfoh, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126539);
    if (hNz().abOl != null)
    {
      AppMethodBeat.o(126539);
      return;
    }
    if ((paramfoh == null) || (paramfoh.abOG == null))
    {
      AppMethodBeat.o(126539);
      return;
    }
    Object localObject = hNx().TNp;
    int i;
    int j;
    if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIB != 0L))
    {
      long l = (System.currentTimeMillis() - ((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIB) / 1000L;
      i = paramfoh.abOG.abOb - 10;
      paramInt2 = paramfoh.abOG.abOc * paramInt2 / 100 - 10;
      if ((!paramfoh.abOG.abOe) && (l >= i) && (paramInt1 >= paramInt2))
      {
        localObject = this.TMp;
        foe localfoe = this.TIY;
        j = this.TMp.hOz();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", new Object[] { paramfoh.Ido, Integer.valueOf(j), Long.valueOf(l) });
        if (((n)localObject).TNe != null)
        {
          com.tencent.mm.kernel.h.aZW().a(((n)localObject).TNe);
          ((n)localObject).TNe = null;
        }
        localfoe = com.tencent.mm.plugin.topstory.a.g.a(localfoe);
        localfoe.offset = j;
        ((n)localObject).TNe = new com.tencent.mm.plugin.topstory.a.c.h(localfoe, ((n)localObject).TLn.hND(), paramfoh, l);
        com.tencent.mm.kernel.h.aZW().a(((n)localObject).TNe, 0);
        com.tencent.mm.kernel.h.aZW().a(1943, ((n)localObject).maV);
        paramfoh.abOG.abOe = true;
      }
      if ((!paramfoh.abOG.hBY) && (l >= i + 10) && (paramInt1 >= paramInt2 + 10))
      {
        paramfoh.abOG.hBY = true;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", new Object[] { Integer.valueOf(paramfoh.abOG.abOd.size()) });
        paramfoh = paramfoh.abOG.abOd.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramfoh.hasNext())
        {
          localObject = (foh)paramfoh.next();
          if (((foh)localObject).abOG == null)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", new Object[] { ((foh)localObject).Ido });
            continue;
            AppMethodBeat.o(126539);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", new Object[] { ((foh)localObject).Ido, Integer.valueOf(((foh)localObject).abOG.abNZ) });
            if (((foh)localObject).abOG.abNZ == 2)
            {
              paramInt2 = ((foh)localObject).abOG.Yjq;
              j = hND();
              if (paramInt2 > 0)
              {
                paramInt1 = paramInt2;
                label495:
                paramInt1 = j + paramInt1;
                i = this.TMp.hOz() - 1;
                if (paramInt1 <= i) {
                  break label618;
                }
                paramInt1 = i;
              }
            }
          }
        }
      }
    }
    label618:
    for (;;)
    {
      this.TMp.aiJ().add(paramInt1, localObject);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), ((foh)localObject).Ido, ((foh)localObject).title });
      getRecyclerView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126499);
          TopStoryListVideoUI.this.hNG().fW(paramInt1 + TopStoryListVideoUI.this.hNG().hNP());
          AppMethodBeat.o(126499);
        }
      });
      break;
      paramInt1 = 1;
      break label495;
      AppMethodBeat.o(126539);
      return;
    }
  }
  
  public final void a(final foh paramfoh, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126541);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramfoh.Ido, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.TPC.getVisibility() == 0)
      {
        if ((this.TPD != null) && (this.TPD.vid != null) && (this.TPD.vid.equals(paramfoh.Ido)))
        {
          this.TPC.setVisibility(8);
          AppMethodBeat.o(126541);
        }
      }
      else if ((this.TOC.getVisibility() == 0) && (this.TOD != null) && (this.TOD.vid != null) && (this.TOD.vid.equals(paramfoh.Ido))) {
        this.TOC.setVisibility(8);
      }
      AppMethodBeat.o(126541);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = paramfoh.HsD;
    Object localObject3 = paramfoh.title;
    Object localObject4 = hNz().mpa;
    int j = hNz().scene;
    if (hNH()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, paramfoh.Ido, paramfoh.ELy);
      if (!this.TMw) {
        break;
      }
      this.TPC.setVisibility(0);
      this.TOC.setVisibility(8);
      this.TPD = new com.tencent.mm.plugin.topstory.ui.widget.c(this.TPE, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126502);
          TopStoryListVideoUI.this.TOF.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void hOS()
            {
              AppMethodBeat.i(126501);
              TopStoryListVideoUI.this.TPC.setVisibility(8);
              TopStoryListVideoUI.this.TOC.setVisibility(8);
              AppMethodBeat.o(126501);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126500);
              TopStoryListVideoUI.this.TMo.bcl();
              AppMethodBeat.o(126500);
            }
          }, (int)TopStoryListVideoUI.j(TopStoryListVideoUI.this).abOj, paramfoh.abOz);
          if (TopStoryListVideoUI.this.TMo.fjy()) {
            TopStoryListVideoUI.this.TMo.bck();
          }
          AppMethodBeat.o(126502);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramfoh.Ido);
      paramfoh = this.TPD;
      i = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0F);
      localObject2 = paramView.getContext();
      localObject3 = paramfoh.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      j = paramView.getWidth();
      int k = aw.bf((Context)localObject2).x;
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
      paramView = (LinearLayout.LayoutParams)paramfoh.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      paramfoh.contentView.setLayoutParams(paramView);
      this.TPC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126503);
          if (TopStoryListVideoUI.this.TPC.getVisibility() == 0) {
            TopStoryListVideoUI.this.TPC.setVisibility(8);
          }
          AppMethodBeat.o(126503);
        }
      }, 1800L);
      AppMethodBeat.o(126541);
      return;
    }
    this.TPC.setVisibility(8);
    this.TOC.setVisibility(0);
    this.TOD = new com.tencent.mm.plugin.topstory.ui.widget.c(this.TOE, new c.a()
    {
      public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
      {
        AppMethodBeat.i(126506);
        TopStoryListVideoUI.this.TOF.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
        {
          public final void hOS()
          {
            AppMethodBeat.i(126505);
            TopStoryListVideoUI.this.TPC.setVisibility(8);
            TopStoryListVideoUI.this.TOC.setVisibility(8);
            AppMethodBeat.o(126505);
          }
          
          public final void onDismiss()
          {
            AppMethodBeat.i(126504);
            TopStoryListVideoUI.this.TMo.bcl();
            AppMethodBeat.o(126504);
          }
        }, (int)TopStoryListVideoUI.k(TopStoryListVideoUI.this).abOj, paramfoh.abOz);
        if (TopStoryListVideoUI.this.TMo.fjy()) {
          TopStoryListVideoUI.this.TMo.bck();
        }
        AppMethodBeat.o(126506);
      }
    }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramfoh.Ido);
    this.TOD.a(paramView, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0F));
    AppMethodBeat.o(126541);
  }
  
  public final void a(foh paramfoh, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt)
  {
    AppMethodBeat.i(126538);
    if ((paramfoh.abOO != null) && (paramfoh.abOO.abNW != null)) {
      if ((paramInt >= paramfoh.abOO.TpP) && (paramInt <= paramfoh.abOO.endTime))
      {
        if (!paramfoh.abOO.hBY)
        {
          paramfoh.abOO.hBY = true;
          paramf.hOd();
          AppMethodBeat.o(126538);
        }
      }
      else {
        paramf.hOe();
      }
    }
    AppMethodBeat.o(126538);
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(126515);
    super.aNi();
    if (hNz().abOk != null) {
      this.TMp.h(hNz().abOk);
    }
    AppMethodBeat.o(126515);
  }
  
  public final void anI()
  {
    AppMethodBeat.i(126534);
    long l = System.currentTimeMillis();
    if (l - this.TPF < 1000L)
    {
      AppMethodBeat.o(126534);
      return;
    }
    this.TPF = l;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (this.TMo.TNu != null)
    {
      this.TIY.abOp = this.TMo.TNu.getControlBar().getmPosition();
      if (this.TMo.TNu.getControlBar().getVideoTotalTime() - this.TIY.abOp < 2)
      {
        AppMethodBeat.o(126534);
        return;
      }
    }
    FE(false);
    this.TMw = false;
    this.TPC.setVisibility(8);
    this.TOC.setVisibility(8);
    if (!hNH()) {
      setRequestedOrientation(1);
    }
    if ((this.TMt != null) && (this.TMt.isShowing()))
    {
      this.TMt.dismiss();
      this.TMt = null;
    }
    this.TPw.setVisibility(0);
    if (hNz().abOl == null) {
      this.pJJ.setVisibility(0);
    }
    this.TLX.setVisibility(0);
    this.TMa.setVisibility(8);
    this.TPz.bZE.notifyChanged();
    this.TOA.setVisibility(8);
    this.TPy.TOX = true;
    this.vqi.bo(hNz().abOo + this.TPy.hNP(), hNJ());
    getSwipeBackLayout().setEnableGesture(true);
    FE(true);
    hOU();
    AppMethodBeat.o(126534);
  }
  
  public final void anJ()
  {
    AppMethodBeat.i(126533);
    long l = System.currentTimeMillis();
    if (l - this.TPF < 1000L)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.TPF = l;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    if (this.TMo.TNu != null)
    {
      this.TIY.abOp = this.TMo.TNu.getControlBar().getmPosition();
      if (this.TMo.TNu.getControlBar().getVideoTotalTime() - this.TIY.abOp < 2)
      {
        AppMethodBeat.o(126533);
        return;
      }
    }
    FE(false);
    this.TMw = true;
    this.TPC.setVisibility(8);
    this.TOC.setVisibility(8);
    if (!hNH()) {
      setRequestedOrientation(0);
    }
    if ((this.TMt != null) && (this.TMt.isShowing()))
    {
      this.TMt.dismiss();
      this.TMt = null;
    }
    this.TPw.setVisibility(8);
    this.pJJ.setVisibility(8);
    this.TLV.setVisibility(8);
    this.TLX.setVisibility(8);
    this.TMa.setVisibility(0);
    this.TPy.bZE.notifyChanged();
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acXm, 0) == 0)
    {
      this.TMo.bck();
      this.TOA.setVisibility(0);
      this.TOA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.TOB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126513);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acXm, Integer.valueOf(1));
          TopStoryListVideoUI.this.TMo.bcl();
          TopStoryListVideoUI.h(TopStoryListVideoUI.this).setVisibility(8);
          TopStoryListVideoUI.i(TopStoryListVideoUI.this).b(TopStoryListVideoUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126513);
        }
      });
    }
    for (;;)
    {
      this.TPz.TNH = true;
      this.TMb.bo(hNz().abOo, 0);
      getSwipeBackLayout().setEnableGesture(false);
      FE(true);
      if (aw.bx(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.AtJ.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        this.AtJ.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(126533);
      return;
      this.TOA.setVisibility(8);
    }
  }
  
  public final boolean aoT(int paramInt)
  {
    AppMethodBeat.i(126527);
    this.TOC.setVisibility(8);
    this.TPC.setVisibility(8);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.TMw) {
          continue;
        }
        if (paramInt < this.TMc.getItemCount() - this.TMc.hNQ() - this.TMc.hNP())
        {
          RecyclerView localRecyclerView = this.TMa;
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(126527);
          return true;
        }
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.TMc.getItemCount()), Integer.valueOf(this.TMc.hNQ()), Integer.valueOf(this.TMc.hNP()) });
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(126527);
      return false;
      if (paramInt < this.TPy.getItemCount() - this.TPy.hNQ() - this.TPy.hNP())
      {
        this.TLZ.a(this, this.TPy.hNP() + paramInt);
        AppMethodBeat.o(126527);
        return true;
      }
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.TPy.getItemCount()), Integer.valueOf(this.TPy.hNQ()), Integer.valueOf(this.TPy.hNP()) });
    }
  }
  
  public final void apa(int paramInt)
  {
    AppMethodBeat.i(126530);
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (!bool) {
        break label126;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label97;
      }
      if (!this.TMw) {
        break;
      }
      AppMethodBeat.o(126530);
      return;
    }
    anJ();
    AppMethodBeat.o(126530);
    return;
    label97:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.TMw)
      {
        AppMethodBeat.o(126530);
        return;
      }
      anI();
    }
    label126:
    AppMethodBeat.o(126530);
  }
  
  public final void bez(final String paramString)
  {
    AppMethodBeat.i(126529);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126512);
        if (!TopStoryListVideoUI.this.TMw)
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
    if ((this.TMw) && (!hNH()))
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
  
  public final int hNJ()
  {
    AppMethodBeat.i(126536);
    if (aw.bx(this))
    {
      i = super.hNJ();
      int j = aw.bw(this);
      AppMethodBeat.o(126536);
      return i + j;
    }
    int i = super.hNJ();
    AppMethodBeat.o(126536);
    return i;
  }
  
  public final int hNO()
  {
    return 0;
  }
  
  public final void hNt()
  {
    AppMethodBeat.i(126524);
    if (!this.TMw) {
      this.TPw.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.AtJ.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((hNz().abOl != null) && (this.TPx != null)) {
        this.TPx.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(126524);
      return;
      this.TPC.setVisibility(8);
    }
  }
  
  public final void hNu()
  {
    AppMethodBeat.i(126525);
    this.AtJ.animate().cancel();
    this.AtJ.setAlpha(1.0F);
    if ((hNz().abOl != null) && (this.TPx != null)) {
      this.TPx.setAlpha(1.0F);
    }
    AppMethodBeat.o(126525);
  }
  
  public final void hOk()
  {
    AppMethodBeat.i(126518);
    super.hOk();
    if (this.TMw)
    {
      anI();
      AppMethodBeat.o(126518);
      return;
    }
    if (this.TIY != null)
    {
      hNx().hOD();
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.TIY.lAj);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.TIY.abOr);
      localIntent.putExtra("key_video_play_info", Util.listToString(hNx().TNq, ";"));
      localIntent.putExtra("key_search_id", hNz().mpa);
      setResult(-1, localIntent);
    }
    if (!hOu().af(2, false)) {
      finish();
    }
    if (!hOv().zX(2)) {
      finish();
    }
    AppMethodBeat.o(126518);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d hOl()
  {
    AppMethodBeat.i(126520);
    d locald = new d();
    AppMethodBeat.o(126520);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d hOm()
  {
    AppMethodBeat.i(126540);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(126540);
    return localc;
  }
  
  public final void hOn()
  {
    AppMethodBeat.i(126526);
    super.hOn();
    if ((!this.TMw) && (this.TPw.getAlpha() != 0.0F))
    {
      this.TPw.animate().cancel();
      this.TPw.setAlpha(0.0F);
    }
    AppMethodBeat.o(126526);
  }
  
  public final void hOo()
  {
    AppMethodBeat.i(126521);
    if (!this.TMw)
    {
      this.TOz.setVisibility(0);
      this.TOy.setVisibility(0);
    }
    for (;;)
    {
      this.TMp.apd(this.TMp.hOz());
      AppMethodBeat.o(126521);
      return;
      this.TPB.setVisibility(0);
      this.TPA.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e hOq()
  {
    AppMethodBeat.i(126531);
    this.TPy = new e(this);
    e locale = this.TPy;
    View localView1 = LayoutInflater.from(this).inflate(c.e.top_story_list_video_header, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(c.d.header_border_view);
    View localView2 = localView1.findViewById(c.d.header_layout);
    if (hNz().abOl != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.TPx = ((TextView)localView1.findViewById(c.d.header_title_tv));
      this.TPx.setText(hNz().abOl.title);
      localObject = (TextView)localView1.findViewById(c.d.sub_header_title_tv);
      if (!Util.isNullOrNil(hNz().abOl.uCW)) {
        ((TextView)localObject).setText(hNz().abOl.uCW);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (aw.bx(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = aw.bw(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.ev(localView1);
      locale = this.TPy;
      localView1 = LayoutInflater.from(this).inflate(c.e.top_story_list_video_loading_footer, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cd.a.mt(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(c.b.top_story_video_list_header_height));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.TOz = localView1.findViewById(c.d.footer_loading_tv);
      this.TOy = localView1.findViewById(c.d.footer_progress_bar);
      locale.kn(localView1);
      locale = this.TPy;
      AppMethodBeat.o(126531);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e hOr()
  {
    AppMethodBeat.i(126532);
    this.TPz = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.TPz;
    View localView = LayoutInflater.from(this).inflate(c.e.top_story_list_video_loading_footer, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.TPB = localView.findViewById(c.d.footer_loading_tv);
    this.TPA = localView.findViewById(c.d.footer_progress_bar);
    locald.kn(localView);
    locald = this.TPz;
    AppMethodBeat.o(126532);
    return locald;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(126519);
    super.initContentView();
    this.TOA = findViewById(c.d.fs_scroll_tips_layout);
    this.TOB = ((Button)findViewById(c.d.scroll_tips_i_know_btn));
    this.TPw = findViewById(c.d.title_bg);
    this.TPw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126498);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TopStoryListVideoUI.this.TMo.TNv) && (TopStoryListVideoUI.this.TMo.TNu.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.TMo.TNu.getItemUIComponent().hNu();
          TopStoryListVideoUI.this.TMo.TNu.getItemUIComponent().hNt();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126498);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
    if (hNz().abOl != null) {
      this.pJJ.setVisibility(8);
    }
    hNx().TNo = 2;
    if (hOp()) {
      if (hNw().isConnected())
      {
        hOQ();
        this.TOG = false;
        if ((hNz().scene != 21) && (hNz().abOl == null)) {
          this.TOx = k.a(this, getString(c.g.loading_tips), true, new DialogInterface.OnCancelListener()
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
      this.TPy.TOL = true;
      if (hNz().abOm) {
        hNw().TMQ = true;
      }
      this.TLX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126508);
          TopStoryListVideoUI.this.TMm.hOC();
          AppMethodBeat.o(126508);
        }
      });
      new c(this).a(this.TLX);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().a(this.TMa);
      this.TOC = findViewById(c.d.dialog_notfull_frame);
      this.TOE = findViewById(c.d.dialog_notfull_root);
      this.TOC.setVisibility(8);
      this.TPC = findViewById(c.d.dialog_full_frame);
      this.TPE = findViewById(c.d.dialog_full_root);
      this.TPC.setVisibility(8);
      this.TOC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126509);
          if (TopStoryListVideoUI.this.TOC.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.j(TopStoryListVideoUI.this.TOE, f1, f2))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewNotFull");
              AppMethodBeat.o(126509);
              return false;
            }
            TopStoryListVideoUI.this.TOC.setVisibility(8);
          }
          AppMethodBeat.o(126509);
          return false;
        }
      });
      this.TPC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126510);
          if (TopStoryListVideoUI.this.TPC.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.j(TopStoryListVideoUI.this.TPE, f1, f2))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewFull");
              AppMethodBeat.o(126510);
              return false;
            }
            TopStoryListVideoUI.this.TPC.setVisibility(8);
          }
          AppMethodBeat.o(126510);
          return false;
        }
      });
      this.TOF = ((TopStoryCommentFloatDialog)findViewById(c.d.comment_float_dialog));
      this.TOF.setVisibility(8);
      this.TOF.u(this);
      hOU();
      AppMethodBeat.o(126519);
      return;
      Toast.makeText(this, c.g.recommend_video_init_not_network_failed_hint, 1).show();
      this.TOG = true;
      continue;
      this.TOz.setVisibility(4);
      this.TOy.setVisibility(4);
    }
  }
  
  public final void mm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126523);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.TOG)) {
      hOQ();
    }
    super.mm(paramInt1, paramInt2);
    AppMethodBeat.o(126523);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126517);
    p.TNr.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.v localv = d.f(this);
      if ((localv != null) && ((localv instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localv).FD(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.TIY != null)) {
        FF(paramIntent.getBooleanExtra("isMute", this.TIY.lAj));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.TIY != null)) {
        aoV(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.TIY.abOr));
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.boots.a.c.class)).gs(com.tencent.mm.plugin.boots.a.b.vyA, 885);
    com.tencent.mm.plugin.websearch.api.a.a.rG(13);
    AppMethodBeat.o(126514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126544);
    super.onDestroy();
    this.TOF.lKz.close();
    AppMethodBeat.o(126544);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126545);
    if ((paramInt == 4) && (this.TOF.getVisibility() == 0))
    {
      this.TOF.hide();
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
    this.TOF.onPause();
    AppMethodBeat.o(126542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126543);
    super.onResume();
    this.TOF.onResume();
    AppMethodBeat.o(126543);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI
 * JD-Core Version:    0.7.0.1
 */