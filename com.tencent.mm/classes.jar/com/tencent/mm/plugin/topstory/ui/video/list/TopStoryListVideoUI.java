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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aj;
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
  private ProgressDialog Afl;
  private View Afm;
  private View Afn;
  private View Afo;
  private Button Afp;
  View Afq;
  com.tencent.mm.plugin.topstory.ui.widget.c Afr;
  View Afs;
  TopStoryCommentFloatDialog Aft;
  private boolean Afu;
  private View Agj;
  private TextView Agk;
  private e Agl;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d Agm;
  private View Agn;
  private View Ago;
  View Agp;
  com.tencent.mm.plugin.topstory.ui.widget.c Agq;
  View Agr;
  private long Ags = 0L;
  
  private void eeA()
  {
    AppMethodBeat.i(126535);
    if (aj.aG(this))
    {
      int i = aj.aF(this);
      Object localObject = (RelativeLayout.LayoutParams)this.xuw.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.xuw.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.Agj.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.Agj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(126535);
  }
  
  private void eev()
  {
    AppMethodBeat.i(126522);
    if (!this.Adl)
    {
      this.Afn.setVisibility(0);
      this.Afm.setVisibility(0);
    }
    for (;;)
    {
      this.Ade.Rx(0);
      AppMethodBeat.o(126522);
      return;
      this.Ago.setVisibility(0);
      this.Agn.setVisibility(0);
    }
  }
  
  public final boolean Rn(int paramInt)
  {
    AppMethodBeat.i(126527);
    this.Afq.setVisibility(8);
    this.Agp.setVisibility(8);
    ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.Adl) {
          continue;
        }
        if (paramInt < this.AcS.getItemCount() - this.AcS.getFootersCount() - this.AcS.getHeadersCount())
        {
          RecyclerView localRecyclerView = this.AcQ;
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(126527);
          return true;
        }
        ac.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.AcS.getItemCount()), Integer.valueOf(this.AcS.getFootersCount()), Integer.valueOf(this.AcS.getHeadersCount()) });
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(126527);
      return false;
      if (paramInt < this.Agl.getItemCount() - this.Agl.getFootersCount() - this.Agl.getHeadersCount())
      {
        this.AcP.a(this, this.Agl.getHeadersCount() + paramInt);
        AppMethodBeat.o(126527);
        return true;
      }
      ac.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Agl.getItemCount()), Integer.valueOf(this.Agl.getFootersCount()), Integer.valueOf(this.Agl.getHeadersCount()) });
    }
  }
  
  public final void Ru(int paramInt)
  {
    AppMethodBeat.i(126530);
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (!bool) {
        break label125;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label96;
      }
      if (!this.Adl) {
        break;
      }
      AppMethodBeat.o(126530);
      return;
    }
    bjx();
    AppMethodBeat.o(126530);
    return;
    label96:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.Adl)
      {
        AppMethodBeat.o(126530);
        return;
      }
      cWw();
    }
    label125:
    AppMethodBeat.o(126530);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(126515);
    super.WJ();
    if (edh().FRA != null) {
      this.Ade.h(edh().FRA);
    }
    AppMethodBeat.o(126515);
  }
  
  public final void a(cyv paramcyv)
  {
    AppMethodBeat.i(126537);
    if (this.Adl) {
      cWw();
    }
    this.Ada.AdF = true;
    this.Add.stopPlay();
    dio localdio = this.Ade.Rw(edm());
    dil localdil = com.tencent.mm.plugin.topstory.a.h.a(edh());
    localdil.qox = UUID.randomUUID().toString();
    localdil.FRv = localdio.sVF;
    localdil.FRz = paramcyv.FIb;
    localdil.FRA = null;
    localdil.FRB = paramcyv;
    localdil.FRC = this.Ada.AdF;
    Object localObject = localdil.BYq.iterator();
    while (((Iterator)localObject).hasNext())
    {
      yh localyh = (yh)((Iterator)localObject).next();
      if ("show_tag_list".equals(localyh.key)) {
        localyh.ErW = paramcyv.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new yh();
        ((yh)localObject).key = "show_tag_list";
        ((yh)localObject).ErW = paramcyv.id;
        localdil.BYq.add(localObject);
      }
      z.a(this, localdil, 10001);
      com.tencent.mm.plugin.websearch.api.a.a.lA(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(edh(), localdio, edm(), 4, paramcyv.dlQ + ":" + paramcyv.id);
      AppMethodBeat.o(126537);
      return;
    }
  }
  
  public final void a(dio paramdio, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126539);
    if (edh().FRB != null)
    {
      AppMethodBeat.o(126539);
      return;
    }
    if ((paramdio == null) || (paramdio.FRZ == null))
    {
      AppMethodBeat.o(126539);
      return;
    }
    Object localObject = this.Adb.Aec;
    int i;
    int j;
    if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZs != 0L))
    {
      long l = (System.currentTimeMillis() - ((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZs) / 1000L;
      i = paramdio.FRZ.FRr - 10;
      paramInt2 = paramdio.FRZ.FRs * paramInt2 / 100 - 10;
      if ((!paramdio.FRZ.FRu) && (l >= i) && (paramInt1 >= paramInt2))
      {
        localObject = this.Ade;
        dil localdil = this.zZP;
        j = this.Ade.eee();
        ac.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", new Object[] { paramdio.sVF, Integer.valueOf(j), Long.valueOf(l) });
        if (((n)localObject).AdT != null)
        {
          com.tencent.mm.kernel.g.agi().a(((n)localObject).AdT);
          ((n)localObject).AdT = null;
        }
        localdil = com.tencent.mm.plugin.topstory.a.h.a(localdil);
        localdil.offset = j;
        ((n)localObject).AdT = new com.tencent.mm.plugin.topstory.a.c.h(localdil, ((n)localObject).Acd.edm(), paramdio, l);
        com.tencent.mm.kernel.g.agi().a(((n)localObject).AdT, 0);
        com.tencent.mm.kernel.g.agi().a(1943, ((n)localObject).hwV);
        paramdio.FRZ.FRu = true;
      }
      if ((!paramdio.FRZ.daU) && (l >= i + 10) && (paramInt1 >= paramInt2 + 10))
      {
        paramdio.FRZ.daU = true;
        ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", new Object[] { Integer.valueOf(paramdio.FRZ.FRt.size()) });
        paramdio = paramdio.FRZ.FRt.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramdio.hasNext())
        {
          localObject = (dio)paramdio.next();
          if (((dio)localObject).FRZ == null)
          {
            ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", new Object[] { ((dio)localObject).sVF });
            continue;
            AppMethodBeat.o(126539);
          }
          else
          {
            ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", new Object[] { ((dio)localObject).sVF, Integer.valueOf(((dio)localObject).FRZ.FRp) });
            if (((dio)localObject).FRZ.FRp == 2)
            {
              paramInt2 = ((dio)localObject).FRZ.DxL;
              j = edm();
              if (paramInt2 > 0)
              {
                paramInt1 = paramInt2;
                label492:
                paramInt1 = j + paramInt1;
                i = this.Ade.eee() - 1;
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
      this.Ade.eed().add(paramInt1, localObject);
      ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), ((dio)localObject).sVF, ((dio)localObject).title });
      getRecyclerView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126499);
          TopStoryListVideoUI.this.edp().ck(paramInt1 + TopStoryListVideoUI.this.edp().getHeadersCount());
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
  
  public final void a(final dio paramdio, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126541);
    ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramdio.sVF, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.Agp.getVisibility() == 0)
      {
        if ((this.Agq != null) && (this.Agq.hhd != null) && (this.Agq.hhd.equals(paramdio.sVF)))
        {
          this.Agp.setVisibility(8);
          AppMethodBeat.o(126541);
        }
      }
      else if ((this.Afq.getVisibility() == 0) && (this.Afr != null) && (this.Afr.hhd != null) && (this.Afr.hhd.equals(paramdio.sVF))) {
        this.Afq.setVisibility(8);
      }
      AppMethodBeat.o(126541);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = paramdio.sxK;
    Object localObject3 = paramdio.title;
    Object localObject4 = edh().jKB;
    int j = edh().scene;
    if (edq()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, paramdio.sVF, paramdio.FSd);
      if (!this.Adl) {
        break;
      }
      this.Agp.setVisibility(0);
      this.Afq.setVisibility(8);
      this.Agq = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Agr, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126502);
          TopStoryListVideoUI.this.Aft.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void eex()
            {
              AppMethodBeat.i(126501);
              TopStoryListVideoUI.this.Agp.setVisibility(8);
              TopStoryListVideoUI.this.Afq.setVisibility(8);
              AppMethodBeat.o(126501);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126500);
              TopStoryListVideoUI.this.Add.dOc();
              AppMethodBeat.o(126500);
            }
          }, (int)TopStoryListVideoUI.j(TopStoryListVideoUI.this).FRz, paramdio.FRR);
          if (TopStoryListVideoUI.this.Add.een()) {
            TopStoryListVideoUI.this.Add.crK();
          }
          AppMethodBeat.o(126502);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramdio.sVF);
      paramdio = this.Agq;
      i = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0F);
      localObject2 = paramView.getContext();
      localObject3 = paramdio.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      j = paramView.getWidth();
      int k = aj.cl((Context)localObject2).x;
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
      paramView = (LinearLayout.LayoutParams)paramdio.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      paramdio.contentView.setLayoutParams(paramView);
      this.Agp.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126503);
          if (TopStoryListVideoUI.this.Agp.getVisibility() == 0) {
            TopStoryListVideoUI.this.Agp.setVisibility(8);
          }
          AppMethodBeat.o(126503);
        }
      }, 1800L);
      AppMethodBeat.o(126541);
      return;
    }
    this.Agp.setVisibility(8);
    this.Afq.setVisibility(0);
    this.Afr = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Afs, new c.a()
    {
      public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
      {
        AppMethodBeat.i(126506);
        TopStoryListVideoUI.this.Aft.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
        {
          public final void eex()
          {
            AppMethodBeat.i(126505);
            TopStoryListVideoUI.this.Agp.setVisibility(8);
            TopStoryListVideoUI.this.Afq.setVisibility(8);
            AppMethodBeat.o(126505);
          }
          
          public final void onDismiss()
          {
            AppMethodBeat.i(126504);
            TopStoryListVideoUI.this.Add.dOc();
            AppMethodBeat.o(126504);
          }
        }, (int)TopStoryListVideoUI.k(TopStoryListVideoUI.this).FRz, paramdio.FRR);
        if (TopStoryListVideoUI.this.Add.een()) {
          TopStoryListVideoUI.this.Add.crK();
        }
        AppMethodBeat.o(126506);
      }
    }, (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramdio.sVF);
    this.Afr.a(paramView, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0F));
    AppMethodBeat.o(126541);
  }
  
  public final void a(dio paramdio, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt)
  {
    AppMethodBeat.i(126538);
    if ((paramdio.FSi != null) && (paramdio.FSi.FRl != null)) {
      if ((paramInt >= paramdio.FSi.FRi) && (paramInt <= paramdio.FSi.hbI))
      {
        if (!paramdio.FSi.daU)
        {
          paramdio.FSi.daU = true;
          paramf.edK();
          AppMethodBeat.o(126538);
        }
      }
      else {
        paramf.edL();
      }
    }
    AppMethodBeat.o(126538);
  }
  
  public final void axQ(final String paramString)
  {
    AppMethodBeat.i(126529);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126512);
        if (!TopStoryListVideoUI.this.Adl)
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
  
  public final void bjx()
  {
    AppMethodBeat.i(126533);
    long l = System.currentTimeMillis();
    if (l - this.Ags < 1000L)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.Ags = l;
    ac.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    if (this.Add.Aeh != null)
    {
      this.zZP.FRF = this.Add.Aeh.getControlBar().getmPosition();
      if (this.Add.Aeh.getControlBar().getVideoTotalTime() - this.zZP.FRF < 2)
      {
        AppMethodBeat.o(126533);
        return;
      }
    }
    se(false);
    this.Adl = true;
    this.Agp.setVisibility(8);
    this.Afq.setVisibility(8);
    if (!edq()) {
      setRequestedOrientation(0);
    }
    if ((this.Adi != null) && (this.Adi.isShowing()))
    {
      this.Adi.dismiss();
      this.Adi = null;
    }
    this.Agj.setVisibility(8);
    this.iCg.setVisibility(8);
    this.AcL.setVisibility(8);
    this.AcN.setVisibility(8);
    this.AcQ.setVisibility(0);
    this.Agl.arg.notifyChanged();
    if (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GRM, 0) == 0)
    {
      this.Add.crK();
      this.Afo.setVisibility(0);
      this.Afo.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.Afp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126513);
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRM, Integer.valueOf(1));
          TopStoryListVideoUI.this.Add.dOc();
          TopStoryListVideoUI.h(TopStoryListVideoUI.this).setVisibility(8);
          TopStoryListVideoUI.i(TopStoryListVideoUI.this).b(TopStoryListVideoUI.this);
          AppMethodBeat.o(126513);
        }
      });
    }
    for (;;)
    {
      this.Agm.Aeu = true;
      this.AcR.af(edh().FRE, 0);
      getSwipeBackLayout().setEnableGesture(false);
      se(true);
      if (aj.aG(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.xuw.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
        this.xuw.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(126533);
      return;
      this.Afo.setVisibility(8);
    }
  }
  
  public final void cWw()
  {
    AppMethodBeat.i(126534);
    long l = System.currentTimeMillis();
    if (l - this.Ags < 1000L)
    {
      AppMethodBeat.o(126534);
      return;
    }
    this.Ags = l;
    ac.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.Add.Aeh != null)
    {
      this.zZP.FRF = this.Add.Aeh.getControlBar().getmPosition();
      if (this.Add.Aeh.getControlBar().getVideoTotalTime() - this.zZP.FRF < 2)
      {
        AppMethodBeat.o(126534);
        return;
      }
    }
    se(false);
    this.Adl = false;
    this.Agp.setVisibility(8);
    this.Afq.setVisibility(8);
    if (!edq()) {
      setRequestedOrientation(1);
    }
    if ((this.Adi != null) && (this.Adi.isShowing()))
    {
      this.Adi.dismiss();
      this.Adi = null;
    }
    this.Agj.setVisibility(0);
    if (edh().FRB == null) {
      this.iCg.setVisibility(0);
    }
    this.AcN.setVisibility(0);
    this.AcQ.setVisibility(8);
    this.Agm.arg.notifyChanged();
    this.Afo.setVisibility(8);
    this.Agl.AfK = true;
    this.nlq.af(edh().FRE + this.Agl.getHeadersCount(), eds());
    getSwipeBackLayout().setEnableGesture(true);
    se(true);
    eeA();
    AppMethodBeat.o(126534);
  }
  
  public final void edR()
  {
    AppMethodBeat.i(126518);
    super.edR();
    if (this.Adl)
    {
      cWw();
      AppMethodBeat.o(126518);
      return;
    }
    if (this.zZP != null)
    {
      this.Adb.eei();
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.zZP.ftN);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.zZP.FRH);
      localIntent.putExtra("key_video_play_info", bs.n(this.Adb.Aed, ";"));
      localIntent.putExtra("key_search_id", edh().jKB);
      setResult(-1, localIntent);
    }
    if (!this.AcU.rT(2)) {
      finish();
    }
    AppMethodBeat.o(126518);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d edS()
  {
    AppMethodBeat.i(126520);
    d locald = new d();
    AppMethodBeat.o(126520);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d edT()
  {
    AppMethodBeat.i(126540);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(126540);
    return localc;
  }
  
  public final void edU()
  {
    AppMethodBeat.i(126526);
    super.edU();
    if ((!this.Adl) && (this.Agj.getAlpha() != 0.0F))
    {
      this.Agj.animate().cancel();
      this.Agj.setAlpha(0.0F);
    }
    AppMethodBeat.o(126526);
  }
  
  public final void edV()
  {
    AppMethodBeat.i(126521);
    if (!this.Adl)
    {
      this.Afn.setVisibility(0);
      this.Afm.setVisibility(0);
    }
    for (;;)
    {
      this.Ade.Rx(this.Ade.eee());
      AppMethodBeat.o(126521);
      return;
      this.Ago.setVisibility(0);
      this.Agn.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e edX()
  {
    AppMethodBeat.i(126531);
    this.Agl = new e(this);
    e locale = this.Agl;
    View localView1 = LayoutInflater.from(this).inflate(2131495792, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(2131300708);
    View localView2 = localView1.findViewById(2131300719);
    if (edh().FRB != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.Agk = ((TextView)localView1.findViewById(2131300732));
      this.Agk.setText(edh().FRB.title);
      localObject = (TextView)localView1.findViewById(2131305507);
      if (!bs.isNullOrNil(edh().FRB.mBH)) {
        ((TextView)localObject).setText(edh().FRB.mBH);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (aj.aG(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = aj.aF(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.addHeaderView(localView1);
      locale = this.Agl;
      localView1 = LayoutInflater.from(this).inflate(2131495794, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cc.a.ih(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(2131166931));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.Afn = localView1.findViewById(2131300203);
      this.Afm = localView1.findViewById(2131300207);
      locale.fp(localView1);
      locale = this.Agl;
      AppMethodBeat.o(126531);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e edY()
  {
    AppMethodBeat.i(126532);
    this.Agm = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.Agm;
    View localView = LayoutInflater.from(this).inflate(2131495794, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.Ago = localView.findViewById(2131300203);
    this.Agn = localView.findViewById(2131300207);
    locald.fp(localView);
    locald = this.Agm;
    AppMethodBeat.o(126532);
    return locald;
  }
  
  public final void edb()
  {
    AppMethodBeat.i(126524);
    if (!this.Adl) {
      this.Agj.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.xuw.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((edh().FRB != null) && (this.Agk != null)) {
        this.Agk.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(126524);
      return;
      this.Agp.setVisibility(8);
    }
  }
  
  public final void edc()
  {
    AppMethodBeat.i(126525);
    this.xuw.animate().cancel();
    this.xuw.setAlpha(1.0F);
    if ((edh().FRB != null) && (this.Agk != null)) {
      this.Agk.setAlpha(1.0F);
    }
    AppMethodBeat.o(126525);
  }
  
  public final int eds()
  {
    AppMethodBeat.i(126536);
    if (aj.aG(this))
    {
      i = super.eds();
      int j = aj.aF(this);
      AppMethodBeat.o(126536);
      return i + j;
    }
    int i = super.eds();
    AppMethodBeat.o(126536);
    return i;
  }
  
  public final int edx()
  {
    return 0;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126516);
    if ((this.Adl) && (!edq()))
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
  
  public final void hT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126523);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.Afu)) {
      eev();
    }
    super.hT(paramInt1, paramInt2);
    AppMethodBeat.o(126523);
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(126519);
    super.initContentView();
    this.Afo = findViewById(2131300313);
    this.Afp = ((Button)findViewById(2131304375));
    this.Agj = findViewById(2131305911);
    this.Agj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126498);
        if ((TopStoryListVideoUI.this.Add.Aei) && (TopStoryListVideoUI.this.Add.Aeh.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.Add.Aeh.getItemUIComponent().edc();
          TopStoryListVideoUI.this.Add.Aeh.getItemUIComponent().edb();
        }
        AppMethodBeat.o(126498);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.mnC, MMFragmentActivity.a.mnD);
    if (edh().FRB != null) {
      this.iCg.setVisibility(8);
    }
    this.Adb.Aeb = 2;
    if (edW()) {
      if (this.Ada.isConnected())
      {
        eev();
        this.Afu = false;
        if ((edh().scene != 21) && (edh().FRB == null)) {
          this.Afl = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
      this.Agl.Afz = true;
      if (edh().FRC) {
        this.Ada.AdF = true;
      }
      this.AcN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126508);
          TopStoryListVideoUI.this.Adb.eeh();
          AppMethodBeat.o(126508);
        }
      });
      new c(this).j(this.AcN);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().j(this.AcQ);
      this.Afq = findViewById(2131299128);
      this.Afs = findViewById(2131299129);
      this.Afq.setVisibility(8);
      this.Agp = findViewById(2131299123);
      this.Agr = findViewById(2131299124);
      this.Agp.setVisibility(8);
      this.Afq.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126509);
          if (TopStoryListVideoUI.this.Afq.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.h(TopStoryListVideoUI.this.Afs, f1, f2))
            {
              ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewNotFull");
              AppMethodBeat.o(126509);
              return false;
            }
            TopStoryListVideoUI.this.Afq.setVisibility(8);
          }
          AppMethodBeat.o(126509);
          return false;
        }
      });
      this.Agp.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(126510);
          if (TopStoryListVideoUI.this.Agp.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.h(TopStoryListVideoUI.this.Agr, f1, f2))
            {
              ac.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewFull");
              AppMethodBeat.o(126510);
              return false;
            }
            TopStoryListVideoUI.this.Agp.setVisibility(8);
          }
          AppMethodBeat.o(126510);
          return false;
        }
      });
      this.Aft = ((TopStoryCommentFloatDialog)findViewById(2131298520));
      this.Aft.setVisibility(8);
      this.Aft.m(this);
      eeA();
      AppMethodBeat.o(126519);
      return;
      Toast.makeText(this, 2131762228, 1).show();
      this.Afu = true;
      continue;
      this.Afn.setVisibility(4);
      this.Afm.setVisibility(4);
    }
  }
  
  public final void m(List<dio> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126528);
    super.m(paramList, paramBoolean);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126511);
        if (!TopStoryListVideoUI.this.Adl)
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
    p.Aee.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.w localw = d.f(this);
      if ((localw != null) && ((localw instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localw).sd(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.zZP != null)) {
        sf(paramIntent.getBooleanExtra("isMute", this.zZP.ftN));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.zZP != null)) {
        Rp(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.zZP.FRH));
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
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eJ(com.tencent.mm.plugin.boots.a.b.nsS, 885);
    com.tencent.mm.plugin.websearch.api.a.a.lA(13);
    AppMethodBeat.o(126514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126544);
    super.onDestroy();
    this.Aft.fxG.close();
    AppMethodBeat.o(126544);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126545);
    if ((paramInt == 4) && (this.Aft.getVisibility() == 0))
    {
      this.Aft.hide();
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
    this.Aft.onPause();
    AppMethodBeat.o(126542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126543);
    super.onResume();
    this.Aft.onResume();
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