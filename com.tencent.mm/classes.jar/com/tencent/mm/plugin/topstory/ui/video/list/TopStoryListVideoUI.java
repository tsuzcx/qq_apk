package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.topstory.ui.b.b;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n.1;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.List;
import java.util.UUID;

public class TopStoryListVideoUI
  extends TopStoryBaseVideoUI
  implements b
{
  private static long rpP = 0L;
  private View pHV;
  private TextView pHW;
  private e pHX;
  private com.tencent.mm.plugin.topstory.ui.video.fs.d pHY;
  private View pHZ;
  private ProgressDialog pHt;
  private View pHu;
  private View pHv;
  private View pHw;
  private Button pHx;
  private boolean pHy;
  private View pIa;
  private long pIc = 0L;
  
  private void bOA()
  {
    if (!this.pFu)
    {
      this.pHv.setVisibility(0);
      this.pHu.setVisibility(0);
    }
    for (;;)
    {
      this.pFq.zE(0);
      return;
      this.pIa.setVisibility(0);
      this.pHZ.setVisibility(0);
    }
  }
  
  public final void PL(String paramString)
  {
    ai.d(new TopStoryListVideoUI.5(this, paramString));
  }
  
  public final void a(bse parambse)
  {
    if (this.pFu) {
      bNI();
    }
    this.pFm.pFL = true;
    this.pFp.stopPlay();
    byg localbyg = this.pFq.Es(bNv().tOt);
    byf localbyf = com.tencent.mm.plugin.topstory.a.g.a(bNv());
    localbyf.tNY = UUID.randomUUID().toString();
    localbyf.tOk = localbyg.tOx;
    localbyf.tOo = parambse.tIP;
    localbyf.tOp = null;
    localbyf.tOq = parambse;
    localbyf.tOr = this.pFm.pFL;
    aa.a(this, localbyf);
    com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(28);
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(bNv(), localbyg, bNv().tOt, 4, parambse.bQZ + ":" + parambse.id);
  }
  
  public final void akJ()
  {
    long l = System.currentTimeMillis();
    if (l - this.pIc < 1000L) {}
    do
    {
      return;
      this.pIc = l;
      y.d("MicroMsg.TopStory.TopStoryVideoUI", "enterFullScreen");
      this.pDB.tOu = this.pFp.pGv.getControlBar().getmPosition();
    } while (this.pFp.pGv.getControlBar().getVideoTotalTime() - this.pDB.tOu < 2);
    jK(false);
    this.pFu = true;
    if (!bNE()) {
      setRequestedOrientation(0);
    }
    this.pHV.setVisibility(8);
    this.eXO.setVisibility(8);
    this.pEY.setVisibility(8);
    this.pFa.setVisibility(8);
    this.pFd.setVisibility(0);
    this.pHX.agL.notifyChanged();
    if (com.tencent.mm.kernel.g.DP().Dz().j(ac.a.uzO) == 0)
    {
      this.pFp.bFy();
      this.pHw.setVisibility(0);
      this.pHw.setOnTouchListener(new TopStoryListVideoUI.6(this));
      this.pHx.setOnClickListener(new TopStoryListVideoUI.7(this));
    }
    for (;;)
    {
      this.pHY.pGM = true;
      this.pFe.bE(bNv().tOt);
      getSwipeBackLayout().setEnableGesture(false);
      jK(true);
      return;
      this.pHw.setVisibility(8);
    }
  }
  
  public final void bNI()
  {
    long l = System.currentTimeMillis();
    if (l - this.pIc < 1000L) {}
    do
    {
      return;
      this.pIc = l;
      y.d("MicroMsg.TopStory.TopStoryVideoUI", "exitFullScreen");
      this.pDB.tOu = this.pFp.pGv.getControlBar().getmPosition();
    } while (this.pFp.pGv.getControlBar().getVideoTotalTime() - this.pDB.tOu < 2);
    jK(false);
    this.pFu = false;
    if (!bNE()) {
      setRequestedOrientation(1);
    }
    this.pHV.setVisibility(0);
    if (bNv().tOq == null) {
      this.eXO.setVisibility(0);
    }
    this.pFa.setVisibility(0);
    this.pFd.setVisibility(8);
    this.pHY.agL.notifyChanged();
    this.pHw.setVisibility(8);
    this.pHX.pHF = true;
    this.oFh.Z(bNv().tOt + this.pHX.pEn.size(), TopStoryBaseVideoUI.pEV);
    getSwipeBackLayout().setEnableGesture(true);
    jK(true);
  }
  
  public final void bNp()
  {
    if (!this.pFu) {
      this.pHV.animate().alpha(1.0F).setDuration(200L).setStartDelay(1800L);
    }
    this.nWb.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
    if ((bNv().tOq != null) && (this.pHW != null)) {
      this.pHW.animate().alpha(0.1F).setDuration(200L).setStartDelay(1800L);
    }
  }
  
  public final void bNq()
  {
    this.nWb.animate().cancel();
    this.nWb.setAlpha(1.0F);
    if ((bNv().tOq != null) && (this.pHW != null)) {
      this.pHW.setAlpha(1.0F);
    }
  }
  
  protected final void bOb()
  {
    if (this.pFu)
    {
      bNI();
      return;
    }
    if (this.pDB != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isMute", this.pDB.dnJ);
      setResult(-1, localIntent);
    }
    finish();
  }
  
  protected final void bOc()
  {
    super.bOc();
    this.pHw = findViewById(b.d.fs_scroll_tips_layout);
    this.pHx = ((Button)findViewById(b.d.scroll_tips_i_know_btn));
    this.pHV = findViewById(b.d.title_bg);
    this.pHV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((TopStoryListVideoUI.this.pFp.pGx) && (TopStoryListVideoUI.this.pFp.pGv.getItemUIComponent() != null))
        {
          TopStoryListVideoUI.this.pFp.pGv.getItemUIComponent().bNq();
          TopStoryListVideoUI.this.pFp.pGv.getItemUIComponent().bNp();
        }
      }
    });
    overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
    if (bNv().tOq != null) {
      this.eXO.setVisibility(8);
    }
    this.pFn.pGp = 2;
    if (bOh()) {
      if (this.pFm.isConnected())
      {
        bOA();
        this.pHy = false;
        if ((bNv().scene != 21) && (bNv().tOq == null)) {
          this.pHt = com.tencent.mm.ui.base.h.b(this, getString(b.g.loading_tips), true, new TopStoryListVideoUI.2(this));
        }
      }
    }
    for (;;)
    {
      this.pHX.pHA = true;
      if (bNv().tOr) {
        this.pFm.pFL = true;
      }
      this.pFa.post(new TopStoryListVideoUI.3(this));
      new c(this).f(this.pFa);
      new com.tencent.mm.plugin.topstory.ui.video.fs.b().f(this.pFd);
      if ((this.pFm.bOm()) && (com.tencent.mm.plugin.topstory.a.g.bNg()) && (System.currentTimeMillis() - rpP > 86400000L))
      {
        Toast.makeText(this, b.g.top_story_mobile_wangka_tips, 0).show();
        rpP = System.currentTimeMillis();
      }
      return;
      Toast.makeText(this, b.g.recommend_video_init_not_network_failed_hint, 1).show();
      this.pHy = true;
      continue;
      this.pHv.setVisibility(4);
      this.pHu.setVisibility(4);
    }
  }
  
  protected final com.tencent.mm.plugin.topstory.ui.video.d bOd()
  {
    return new d();
  }
  
  protected final com.tencent.mm.plugin.topstory.ui.video.d bOe()
  {
    return new com.tencent.mm.plugin.topstory.ui.video.fs.c();
  }
  
  protected final void bOf()
  {
    super.bOf();
    if ((!this.pFu) && (this.pHV.getAlpha() != 0.0F))
    {
      this.pHV.animate().cancel();
      this.pHV.setAlpha(0.0F);
    }
  }
  
  protected final void bOg()
  {
    if (!this.pFu)
    {
      this.pHv.setVisibility(0);
      this.pHu.setVisibility(0);
    }
    for (;;)
    {
      this.pFq.zE(this.pFq.cVn());
      return;
      this.pIa.setVisibility(0);
      this.pHZ.setVisibility(0);
    }
  }
  
  protected final com.tencent.mm.plugin.topstory.ui.video.e bOi()
  {
    this.pHX = new e(this);
    e locale = this.pHX;
    View localView1 = LayoutInflater.from(this).inflate(b.e.top_story_list_video_header, null);
    localView1.setClickable(false);
    localView1.setFocusableInTouchMode(false);
    localView1.setFocusable(false);
    Object localObject = localView1.findViewById(b.d.header_border_view);
    View localView2 = localView1.findViewById(b.d.header_layout);
    if (bNv().tOq != null)
    {
      ((View)localObject).setVisibility(8);
      localView2.setVisibility(0);
      this.pHW = ((TextView)localView1.findViewById(b.d.header_title_tv));
      this.pHW.setText(bNv().tOq.title);
      localObject = (TextView)localView1.findViewById(b.d.sub_header_title_tv);
      if (!bk.bl(bNv().tOq.imV)) {
        ((TextView)localObject).setText(bNv().tOq.imV);
      }
    }
    for (;;)
    {
      localView1.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      locale.pEn.put(locale.pEn.size() + 100000, localView1);
      locale = this.pHX;
      localView1 = LayoutInflater.from(this).inflate(b.e.top_story_list_video_loading_footer, null);
      localView1.setPadding(0, 0, 0, com.tencent.mm.cb.a.fk(this.mController.uMN) * 2 / 5 - getResources().getDimensionPixelSize(b.b.top_story_video_list_header_height));
      localView1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.pHv = localView1.findViewById(b.d.footer_loading_tv);
      this.pHu = localView1.findViewById(b.d.footer_progress_bar);
      locale.dl(localView1);
      return this.pHX;
      ((TextView)localObject).setVisibility(8);
      continue;
      ((View)localObject).setVisibility(0);
      localView2.setVisibility(8);
    }
  }
  
  protected final com.tencent.mm.plugin.topstory.ui.video.e bOj()
  {
    this.pHY = new com.tencent.mm.plugin.topstory.ui.video.fs.d(this);
    com.tencent.mm.plugin.topstory.ui.video.fs.d locald = this.pHY;
    View localView = LayoutInflater.from(this).inflate(b.e.top_story_list_video_loading_footer, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.pIa = localView.findViewById(b.d.footer_loading_tv);
    this.pHZ = localView.findViewById(b.d.footer_progress_bar);
    locald.dl(localView);
    return this.pHY;
  }
  
  public final void ei(int paramInt1, int paramInt2)
  {
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.pHy)) {
      bOA();
    }
    super.ei(paramInt1, paramInt2);
  }
  
  public final boolean ej(int paramInt1, int paramInt2)
  {
    if (bNv().tOq == null)
    {
      if ((paramInt1 > 30) && (paramInt1 / paramInt2 > 0.65F))
      {
        com.tencent.mm.plugin.topstory.ui.video.n localn = this.pFq;
        com.tencent.mm.plugin.topstory.a.c.c localc = new com.tencent.mm.plugin.topstory.a.c.c(this.pDB, localn.pEp.bNB());
        com.tencent.mm.kernel.g.Dk().a(localc, 0);
        com.tencent.mm.kernel.g.Dk().a(1943, new n.1(localn, localc));
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final void f(List<byg> paramList, boolean paramBoolean)
  {
    super.f(paramList, paramBoolean);
    ai.l(new TopStoryListVideoUI.4(this), 50L);
  }
  
  public final int getForceOrientation()
  {
    if ((this.pFu) && (!bNE())) {
      return 0;
    }
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return b.e.top_story_list_video_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.plugin.topstory.ui.video.p.pGr.a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001)
    {
      if ((this.pFm.aIq()) || (com.tencent.mm.plugin.topstory.a.g.bNg()))
      {
        RecyclerView.v localv = d.e(this);
        if ((localv != null) && ((localv instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {
          ((com.tencent.mm.plugin.topstory.ui.video.h)localv).jJ(false);
        }
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("isMute")) && (this.pDB != null)) {
        jL(paramIntent.getBooleanExtra("isMute", this.pDB.dnJ));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.boots.a.c.class)).cr(com.tencent.mm.plugin.boots.a.b.hXJ, 885);
    com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(13);
  }
  
  protected final void xK()
  {
    super.xK();
    if (bNv().tOp != null) {
      this.pFq.d(bNv().tOp);
    }
  }
  
  protected final void zD(int paramInt)
  {
    boolean bool;
    if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1)
    {
      bool = true;
      y.i("MicroMsg.TopStory.TopStoryVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (bool)
      {
        if ((paramInt != 90) && (paramInt != 270)) {
          break label79;
        }
        if (!this.pFu) {
          break label74;
        }
      }
    }
    label74:
    label79:
    while (((paramInt != 180) && (paramInt != 0)) || (!this.pFu))
    {
      return;
      bool = false;
      break;
      akJ();
      return;
    }
    bNI();
  }
  
  public final void zw(int paramInt)
  {
    y.i("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.pFu)
    {
      this.pFd.smoothScrollToPosition(paramInt);
      return;
    }
    this.pFc.a(this, this.pHX.pEn.size() + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI
 * JD-Core Version:    0.7.0.1
 */