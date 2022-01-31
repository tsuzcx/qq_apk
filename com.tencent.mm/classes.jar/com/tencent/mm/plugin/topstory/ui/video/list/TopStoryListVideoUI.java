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
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.n.1;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.af;
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
  private ProgressDialog tkO;
  private View tkP;
  private View tkQ;
  private View tkR;
  private Button tkS;
  View tkT;
  com.tencent.mm.plugin.topstory.ui.widget.c tkU;
  View tkV;
  TopStoryCommentFloatDialog tkW;
  private boolean tkX;
  private View tlG;
  private TextView tlH;
  private e tlI;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d tlJ;
  private View tlK;
  private View tlL;
  View tlM;
  com.tencent.mm.plugin.topstory.ui.widget.c tlN;
  View tlO;
  private long tlP = 0L;
  
  private void cKq()
  {
    AppMethodBeat.i(2120);
    if (!this.tiR)
    {
      this.tkQ.setVisibility(0);
      this.tkP.setVisibility(0);
    }
    for (;;)
    {
      this.tiM.GJ(0);
      AppMethodBeat.o(2120);
      return;
      this.tlL.setVisibility(0);
      this.tlK.setVisibility(0);
    }
  }
  
  private void cKv()
  {
    AppMethodBeat.i(141955);
    if (af.hW(this))
    {
      int i = af.hV(this);
      Object localObject = (RelativeLayout.LayoutParams)this.qKl.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      this.qKl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.tlG.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      this.tlG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(141955);
  }
  
  public final void GG(int paramInt)
  {
    AppMethodBeat.i(2128);
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.TopStory.TopStoryVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (!bool) {
        break label123;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label94;
      }
      if (!this.tiR) {
        break;
      }
      AppMethodBeat.o(2128);
      return;
    }
    aFp();
    AppMethodBeat.o(2128);
    return;
    label94:
    if ((paramInt == 180) || (paramInt == 0))
    {
      if (!this.tiR)
      {
        AppMethodBeat.o(2128);
        return;
      }
      cJr();
    }
    label123:
    AppMethodBeat.o(2128);
  }
  
  public final boolean Gz(int paramInt)
  {
    AppMethodBeat.i(2125);
    this.tkT.setVisibility(8);
    this.tlM.setVisibility(8);
    ab.i("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        if (!this.tiR) {
          continue;
        }
        if (paramInt < this.tiB.getItemCount() - this.tiB.getFootersCount() - this.tiB.getHeadersCount())
        {
          this.tiz.smoothScrollToPosition(paramInt);
          AppMethodBeat.o(2125);
          return true;
        }
        ab.w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tiB.getItemCount()), Integer.valueOf(this.tiB.getFootersCount()), Integer.valueOf(this.tiB.getHeadersCount()) });
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
        continue;
      }
      AppMethodBeat.o(2125);
      return false;
      if (paramInt < this.tlI.getItemCount() - this.tlI.getFootersCount() - this.tlI.getHeadersCount())
      {
        this.tiy.a(this, this.tlI.getHeadersCount() + paramInt);
        AppMethodBeat.o(2125);
        return true;
      }
      ab.w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tlI.getItemCount()), Integer.valueOf(this.tlI.getFootersCount()), Integer.valueOf(this.tlI.getHeadersCount()) });
    }
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(2113);
    super.Kc();
    if (cJf().xUP != null) {
      this.tiM.e(cJf().xUP);
    }
    AppMethodBeat.o(2113);
  }
  
  public final void a(ccp paramccp)
  {
    AppMethodBeat.i(2133);
    if (this.tiR) {
      cJr();
    }
    this.tiI.tjk = true;
    this.tiL.stopPlay();
    ckx localckx = this.tiM.GI(cJk());
    ckw localckw = com.tencent.mm.plugin.topstory.a.g.a(cJf());
    localckw.xUt = UUID.randomUUID().toString();
    localckw.xUK = localckx.xVa;
    localckw.xUO = paramccp.xNd;
    localckw.xUP = null;
    localckw.xUQ = paramccp;
    localckw.xUR = this.tiI.tjk;
    Object localObject = localckw.uIO.iterator();
    while (((Iterator)localObject).hasNext())
    {
      up localup = (up)((Iterator)localObject).next();
      if ("show_tag_list".equals(localup.key)) {
        localup.wMN = paramccp.id;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new up();
        ((up)localObject).key = "show_tag_list";
        ((up)localObject).wMN = paramccp.id;
        localckw.uIO.add(localObject);
      }
      aa.a(this, localckw);
      com.tencent.mm.plugin.websearch.api.a.a.kS(28);
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(cJf(), localckx, cJk(), 4, paramccp.cyA + ":" + paramccp.id);
      AppMethodBeat.o(2133);
      return;
    }
  }
  
  public final void a(ckx paramckx, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(2136);
    ab.i("MicroMsg.TopStory.TopStoryVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramckx.xVa, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.tlM.getVisibility() == 0)
      {
        if ((this.tlN != null) && (this.tlN.fgl != null) && (this.tlN.fgl.equals(paramckx.xVa)))
        {
          this.tlM.setVisibility(8);
          AppMethodBeat.o(2136);
        }
      }
      else if ((this.tkT.getVisibility() == 0) && (this.tkU != null) && (this.tkU.fgl != null) && (this.tkU.fgl.equals(paramckx.xVa))) {
        this.tkT.setVisibility(8);
      }
      AppMethodBeat.o(2136);
      return;
    }
    Object localObject1 = System.currentTimeMillis();
    Object localObject2 = paramckx.uKI;
    Object localObject3 = paramckx.title;
    Object localObject4 = cJf().hng;
    int j = cJf().scene;
    if (cJn()) {}
    for (int i = 318;; i = 317)
    {
      localObject1 = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject1, (String)localObject2, "", "", "", "", (String)localObject3, (String)localObject4, j, i, paramckx.xVa, paramckx.xVq);
      if (!this.tiR) {
        break;
      }
      this.tlM.setVisibility(0);
      this.tkT.setVisibility(8);
      this.tlN = new com.tencent.mm.plugin.topstory.ui.widget.c(this.tlO, new TopStoryListVideoUI.2(this, paramckx), (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramckx.xVa);
      paramckx = this.tlN;
      localObject2 = paramView.getContext();
      localObject3 = paramckx.contentView;
      localObject1 = new int[2];
      localObject4 = new int[2];
      paramView.getLocationInWindow((int[])localObject4);
      paramView.getHeight();
      i = paramView.getWidth();
      j = af.hQ((Context)localObject2).x;
      ((View)localObject3).measure(0, 0);
      int k = ((View)localObject3).getMeasuredHeight();
      int m = ((View)localObject3).getMeasuredWidth();
      int n = localObject4[0];
      localObject1[0] = (i / 2 + n - m / 2);
      localObject4[1] -= k;
      Log.i("PopupUtil", "window pos x:" + localObject1[0] + ", windowWidth:" + m + ", screenWidth:" + j);
      if (localObject1[0] + m > j) {
        localObject1[0] = (j - m);
      }
      localObject1[0] += 0;
      localObject1[1] += 0;
      paramView = (LinearLayout.LayoutParams)paramckx.contentView.getLayoutParams();
      paramView.leftMargin = localObject1[0];
      paramView.topMargin = localObject1[1];
      paramckx.contentView.setLayoutParams(paramView);
      this.tlM.postDelayed(new TopStoryListVideoUI.3(this), 1800L);
      AppMethodBeat.o(2136);
      return;
    }
    this.tlM.setVisibility(8);
    this.tkT.setVisibility(0);
    this.tkU = new com.tencent.mm.plugin.topstory.ui.widget.c(this.tkV, new TopStoryListVideoUI.4(this, paramckx), (com.tencent.mm.plugin.topstory.a.c.f)localObject1, paramckx.xVa);
    this.tkU.a(paramView, false, 0 - com.tencent.mm.plugin.topstory.ui.widget.d.dip2px(this, 10.0F));
    AppMethodBeat.o(2136);
  }
  
  public final void aFp()
  {
    AppMethodBeat.i(2131);
    long l = System.currentTimeMillis();
    if (l - this.tlP < 1000L)
    {
      AppMethodBeat.o(2131);
      return;
    }
    this.tlP = l;
    ab.d("MicroMsg.TopStory.TopStoryVideoUI", "enterFullScreen");
    if (this.tiL.tjQ != null)
    {
      this.tfp.xUU = this.tiL.tjQ.getControlBar().getmPosition();
      if (this.tiL.tjQ.getControlBar().getVideoTotalTime() - this.tfp.xUU < 2)
      {
        AppMethodBeat.o(2131);
        return;
      }
    }
    mB(false);
    this.tiR = true;
    this.tlM.setVisibility(8);
    this.tkT.setVisibility(8);
    if (!cJn()) {
      setRequestedOrientation(0);
    }
    if ((this.tiO != null) && (this.tiO.isShowing()))
    {
      this.tiO.dismiss();
      this.tiO = null;
    }
    this.tlG.setVisibility(8);
    this.gpL.setVisibility(8);
    this.tiu.setVisibility(8);
    this.tiw.setVisibility(8);
    this.tiz.setVisibility(0);
    this.tlI.ajb.notifyChanged();
    if (com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yKG, 0) == 0)
    {
      this.tiL.crn();
      this.tkR.setVisibility(0);
      this.tkR.setOnTouchListener(new TopStoryListVideoUI.11(this));
      this.tkS.setOnClickListener(new TopStoryListVideoUI.12(this));
    }
    for (;;)
    {
      this.tlJ.tke = true;
      this.tiA.ad(cJf().xUT, 0);
      getSwipeBackLayout().setEnableGesture(false);
      mB(true);
      if (af.hW(this))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qKl.getLayoutParams();
        localLayoutParams.topMargin = 0;
        localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        this.qKl.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(2131);
      return;
      this.tkR.setVisibility(8);
    }
  }
  
  public final void aen(String paramString)
  {
    AppMethodBeat.i(2127);
    al.d(new TopStoryListVideoUI.10(this, paramString));
    AppMethodBeat.o(2127);
  }
  
  public final void cIZ()
  {
    AppMethodBeat.i(2122);
    if (!this.tiR) {
      this.tlG.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    for (;;)
    {
      this.qKl.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      if ((cJf().xUQ != null) && (this.tlH != null)) {
        this.tlH.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
      }
      AppMethodBeat.o(2122);
      return;
      this.tlM.setVisibility(8);
    }
  }
  
  public final void cJO()
  {
    AppMethodBeat.i(2116);
    if (this.tiR)
    {
      cJr();
      AppMethodBeat.o(2116);
      return;
    }
    if (this.tfp != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.tfp.efg);
      localIntent.putExtra("MOBILE_CHECK_FLAG", this.tfp.xUW);
      setResult(-1, localIntent);
    }
    finish();
    AppMethodBeat.o(2116);
  }
  
  public final void cJP()
  {
    AppMethodBeat.i(2117);
    super.cJP();
    this.tkR = findViewById(2131828560);
    this.tkS = ((Button)findViewById(2131828561));
    this.tlG = findViewById(2131828606);
    this.tlG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(2097);
        if ((TopStoryListVideoUI.this.tiL.tjS) && (TopStoryListVideoUI.this.tiL.tjQ.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.tiL.tjQ.getItemUIComponent().cJa();
          TopStoryListVideoUI.this.tiL.tjQ.getItemUIComponent().cIZ();
        }
        AppMethodBeat.o(2097);
      }
    });
    overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    if (cJf().xUQ != null) {
      this.gpL.setVisibility(8);
    }
    this.tiJ.tjK = 2;
    if (cJU()) {
      if (this.tiI.isConnected())
      {
        cKq();
        this.tkX = false;
        if ((cJf().scene != 21) && (cJf().xUQ == null)) {
          this.tkO = com.tencent.mm.ui.base.h.b(this, getString(2131301086), true, new TopStoryListVideoUI.5(this));
        }
      }
    }
    for (;;)
    {
      this.tlI.tlc = true;
      if (cJf().xUR) {
        this.tiI.tjk = true;
      }
      this.tiw.post(new TopStoryListVideoUI.6(this));
      new c(this).i(this.tiw);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().i(this.tiz);
      this.tkT = findViewById(2131828564);
      this.tkV = findViewById(2131828565);
      this.tkT.setVisibility(8);
      this.tlM = findViewById(2131828607);
      this.tlO = findViewById(2131828608);
      this.tlM.setVisibility(8);
      this.tkT.setOnTouchListener(new TopStoryListVideoUI.7(this));
      this.tlM.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(2108);
          if (TopStoryListVideoUI.this.tlM.getVisibility() == 0)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            float f2 = paramAnonymousMotionEvent.getY();
            if (TopStoryListVideoUI.g(TopStoryListVideoUI.this.tlO, f1, f2))
            {
              ab.i("MicroMsg.TopStory.TopStoryVideoUI", "touch in mContentViewFull");
              AppMethodBeat.o(2108);
              return false;
            }
            TopStoryListVideoUI.this.tlM.setVisibility(8);
          }
          AppMethodBeat.o(2108);
          return false;
        }
      });
      this.tkW = ((TopStoryCommentFloatDialog)findViewById(2131828566));
      this.tkW.setVisibility(8);
      this.tkW.k(this);
      cKv();
      AppMethodBeat.o(2117);
      return;
      Toast.makeText(this, 2131302345, 1).show();
      this.tkX = true;
      continue;
      this.tkQ.setVisibility(4);
      this.tkP.setVisibility(4);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d cJQ()
  {
    AppMethodBeat.i(2118);
    d locald = new d();
    AppMethodBeat.o(2118);
    return locald;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.d cJR()
  {
    AppMethodBeat.i(2135);
    com.tencent.mm.plugin.topstory.ui.video.fs.c localc = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
    AppMethodBeat.o(2135);
    return localc;
  }
  
  public final void cJS()
  {
    AppMethodBeat.i(2124);
    super.cJS();
    if ((!this.tiR) && (this.tlG.getAlpha() != 0.0F))
    {
      this.tlG.animate().cancel();
      this.tlG.setAlpha(0.0F);
    }
    AppMethodBeat.o(2124);
  }
  
  public final void cJT()
  {
    AppMethodBeat.i(2119);
    if (!this.tiR)
    {
      this.tkQ.setVisibility(0);
      this.tkP.setVisibility(0);
    }
    for (;;)
    {
      this.tiM.GJ(this.tiM.cKc());
      AppMethodBeat.o(2119);
      return;
      this.tlL.setVisibility(0);
      this.tlK.setVisibility(0);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e cJV()
  {
    AppMethodBeat.i(2129);
    this.tlI = new e(this);
    e locale = this.tlI;
    View localView1 = LayoutInflater.from(this).inflate(2130971028, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(2131828593);
    View localView2 = localView1.findViewById(2131828594);
    if (cJf().xUQ != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.tlH = ((TextView)localView1.findViewById(2131828595));
      this.tlH.setText(cJf().xUQ.title);
      localObject = (TextView)localView1.findViewById(2131828596);
      if (!bo.isNullOrNil(cJf().xUQ.jjP)) {
        ((TextView)localObject).setText(cJf().xUQ.jjP);
      }
    }
    for (;;)
    {
      localObject = new RecyclerView.LayoutParams(-1, -2);
      if (af.hW(this)) {
        ((RecyclerView.LayoutParams)localObject).topMargin = af.hV(this);
      }
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      locale.addHeaderView(localView1);
      locale = this.tlI;
      localView1 = LayoutInflater.from(this).inflate(2130971030, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cb.a.gx(getContext()) * 2 / 5 - getResources().getDimensionPixelSize(2131428765));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.tkQ = localView1.findViewById(2131828604);
      this.tkP = localView1.findViewById(2131824364);
      locale.eo(localView1);
      locale = this.tlI;
      AppMethodBeat.o(2129);
      return locale;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.e cJW()
  {
    AppMethodBeat.i(2130);
    this.tlJ = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.tlJ;
    View localView = LayoutInflater.from(this).inflate(2130971030, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.tlL = localView.findViewById(2131828604);
    this.tlK = localView.findViewById(2131824364);
    locald.eo(localView);
    locald = this.tlJ;
    AppMethodBeat.o(2130);
    return locald;
  }
  
  public final void cJa()
  {
    AppMethodBeat.i(2123);
    this.qKl.animate().cancel();
    this.qKl.setAlpha(1.0F);
    if ((cJf().xUQ != null) && (this.tlH != null)) {
      this.tlH.setAlpha(1.0F);
    }
    AppMethodBeat.o(2123);
  }
  
  public final int cJp()
  {
    AppMethodBeat.i(141956);
    if (af.hW(this))
    {
      i = super.cJp();
      int j = af.hV(this);
      AppMethodBeat.o(141956);
      return i + j;
    }
    int i = super.cJp();
    AppMethodBeat.o(141956);
    return i;
  }
  
  public final void cJr()
  {
    AppMethodBeat.i(2132);
    long l = System.currentTimeMillis();
    if (l - this.tlP < 1000L)
    {
      AppMethodBeat.o(2132);
      return;
    }
    this.tlP = l;
    ab.d("MicroMsg.TopStory.TopStoryVideoUI", "exitFullScreen");
    if (this.tiL.tjQ != null)
    {
      this.tfp.xUU = this.tiL.tjQ.getControlBar().getmPosition();
      if (this.tiL.tjQ.getControlBar().getVideoTotalTime() - this.tfp.xUU < 2)
      {
        AppMethodBeat.o(2132);
        return;
      }
    }
    mB(false);
    this.tiR = false;
    this.tlM.setVisibility(8);
    this.tkT.setVisibility(8);
    if (!cJn()) {
      setRequestedOrientation(1);
    }
    if ((this.tiO != null) && (this.tiO.isShowing()))
    {
      this.tiO.dismiss();
      this.tiO = null;
    }
    this.tlG.setVisibility(0);
    if (cJf().xUQ == null) {
      this.gpL.setVisibility(0);
    }
    this.tiw.setVisibility(0);
    this.tiz.setVisibility(8);
    this.tlJ.ajb.notifyChanged();
    this.tkR.setVisibility(8);
    this.tlI.tll = true;
    this.ruI.ad(cJf().xUT + this.tlI.getHeadersCount(), cJp());
    getSwipeBackLayout().setEnableGesture(true);
    mB(true);
    cKv();
    AppMethodBeat.o(2132);
  }
  
  public final int cJw()
  {
    return 0;
  }
  
  public final void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2121);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.tkX)) {
      cKq();
    }
    super.ge(paramInt1, paramInt2);
    AppMethodBeat.o(2121);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(2114);
    if ((this.tiR) && (!cJn()))
    {
      AppMethodBeat.o(2114);
      return 0;
    }
    AppMethodBeat.o(2114);
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971031;
  }
  
  public final boolean gh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2134);
    if (cJf().xUQ == null)
    {
      if ((paramInt1 > 30) && (paramInt1 / paramInt2 > 0.65F))
      {
        n localn = this.tiM;
        ckw localckw = this.tfp;
        Object localObject = this.tiM.GI(cJk()).xVa;
        paramInt1 = this.tiM.cKc();
        localckw = com.tencent.mm.plugin.topstory.a.g.a(localckw);
        localckw.offset = paramInt1;
        localObject = new j(localckw, localn.thM.cJk(), (String)localObject);
        com.tencent.mm.kernel.g.Rc().a((m)localObject, 0);
        com.tencent.mm.kernel.g.Rc().a(1943, new n.1(localn, (j)localObject));
        AppMethodBeat.o(2134);
        return true;
      }
      AppMethodBeat.o(2134);
      return false;
    }
    AppMethodBeat.o(2134);
    return true;
  }
  
  public final void k(List<ckx> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(2126);
    super.k(paramList, paramBoolean);
    al.p(new TopStoryListVideoUI.9(this), 50L);
    AppMethodBeat.o(2126);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(2115);
    com.tencent.mm.plugin.topstory.ui.video.p.tjM.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      RecyclerView.v localv = d.f(this);
      if ((localv != null) && ((localv instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
        ((com.tencent.mm.plugin.topstory.ui.video.h)localv).mA(false);
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.tfp != null)) {
        mC(paramIntent.getBooleanExtra("isMute", this.tfp.efg));
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("MOBILE_CHECK_FLAG")) && (this.tfp != null)) {
        GB(paramIntent.getIntExtra("MOBILE_CHECK_FLAG", this.tfp.xUW));
      }
    }
    AppMethodBeat.o(2115);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(2112);
    if (Build.VERSION.SDK_INT >= 28) {
      customfixStatusbar(true);
    }
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.boots.a.c.class)).dH(com.tencent.mm.plugin.boots.a.b.jRE, 885);
    com.tencent.mm.plugin.websearch.api.a.a.kS(13);
    AppMethodBeat.o(2112);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(2139);
    super.onDestroy();
    this.tkW.ehl.close();
    AppMethodBeat.o(2139);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(2140);
    if ((paramInt == 4) && (this.tkW.getVisibility() == 0))
    {
      this.tkW.hide();
      AppMethodBeat.o(2140);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(2140);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(2137);
    super.onPause();
    this.tkW.onPause();
    AppMethodBeat.o(2137);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(2138);
    super.onResume();
    this.tkW.onResume();
    AppMethodBeat.o(2138);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI
 * JD-Core Version:    0.7.0.1
 */