package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.aj;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.ui.b.a;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.b.f;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;
import java.io.IOException;
import java.util.List;

public class TopStoryFSVideoUI
  extends MMActivity
  implements c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long rpP = 0L;
  protected RecyclerView.m doG = new RecyclerView.m()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt2 == 0) {
        return;
      }
      TopStoryFSVideoUI.this.bOf();
    }
    
    public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      }
      TopStoryFSVideoUI.this.pHs.b(TopStoryFSVideoUI.this);
    }
  };
  protected ImageButton mBP;
  protected View nWb;
  protected LinearLayoutManager oFh;
  private Point osl;
  protected byf pDB;
  protected View pEW;
  protected ImageView pEX;
  protected RecyclerView pFa;
  protected int pFi = 0;
  protected long pFj = -1L;
  protected long pFk = -1L;
  private l pFm;
  private o pFn;
  private m pFo;
  private r pFp;
  private n pFq;
  private aj pFs;
  protected i pHr;
  protected h pHs;
  private ProgressDialog pHt;
  private View pHu;
  private View pHv;
  private View pHw;
  private Button pHx;
  private boolean pHy;
  private int videoHeight;
  
  private void bOA()
  {
    this.pHv.setVisibility(0);
    this.pHu.setVisibility(0);
    this.pFq.zE(0);
  }
  
  private void bOa()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.gG(19))
    {
      localView.setSystemUiVisibility(2);
      return;
    }
    localView.setSystemUiVisibility(4098);
  }
  
  private boolean bOh()
  {
    return this.pDB.scene != 36;
  }
  
  private void bOk()
  {
    if (this.pDB.dnJ) {
      this.pEX.setBackgroundResource(b.f.top_story_volume_off);
    }
    for (;;)
    {
      if (this.pFp.pGx) {
        this.pFp.setMute(this.pDB.dnJ);
      }
      return;
      this.pEX.setBackgroundResource(b.f.top_story_volume_on);
    }
  }
  
  private int getSystemVolume()
  {
    return ((AudioManager)this.mController.uMN.getSystemService("audio")).getStreamVolume(3);
  }
  
  public final boolean Bj()
  {
    return this.pDB.dnJ;
  }
  
  public final void PL(String paramString)
  {
    ai.d(new TopStoryFSVideoUI.7(this, paramString));
  }
  
  public final void a(bse parambse) {}
  
  public final aj bNA()
  {
    return this.pFs;
  }
  
  public final int bNB()
  {
    return this.pDB.tOt;
  }
  
  public final boolean bNC()
  {
    return bOh();
  }
  
  public final e bND()
  {
    return this.pHr;
  }
  
  public final boolean bNE()
  {
    return this.pDB.tOo == 100203L;
  }
  
  public final void bNF()
  {
    bOa();
  }
  
  public final int bNG()
  {
    return 0;
  }
  
  public final void bNH() {}
  
  public final void bNI() {}
  
  public final n bNJ()
  {
    return this.pFq;
  }
  
  public final void bNp()
  {
    this.nWb.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
  }
  
  public final void bNq()
  {
    this.nWb.animate().cancel();
    this.nWb.setAlpha(1.0F);
  }
  
  public final l bNs()
  {
    return this.pFm;
  }
  
  public final o bNt()
  {
    return this.pFn;
  }
  
  public final String bNu()
  {
    return com.tencent.mm.plugin.topstory.a.g.PJ(this.pDB.tNY);
  }
  
  public final byf bNv()
  {
    return this.pDB;
  }
  
  public final m bNw()
  {
    return this.pFo;
  }
  
  public final r bNx()
  {
    return this.pFp;
  }
  
  public final Point bNz()
  {
    if (this.osl == null) {
      this.osl = ak.gx(this);
    }
    return this.osl;
  }
  
  public final void bOB()
  {
    if (this.pDB.dnJ)
    {
      this.pDB.dnJ = false;
      if (getSystemVolume() == 0) {
        ((AudioManager)this.mController.uMN.getSystemService("audio")).setStreamVolume(3, 1, 0);
      }
    }
    for (;;)
    {
      bOk();
      bNq();
      bNp();
      return;
      this.pDB.dnJ = true;
    }
  }
  
  protected final void bOf()
  {
    int i = 1;
    this.pHs.a(this);
    this.pFi = this.oFh.ha();
    int j = this.oFh.getItemCount();
    if ((this.pFj <= 0L) || (bk.cp(this.pFj) >= 50L))
    {
      this.pFj = bk.UZ();
      if (this.pFq.pFY == 1) {
        break label149;
      }
      if ((this.pFi < j - 1) || (this.pFq.pFX) || (bk.cp(this.pFk) < 50L)) {
        break label183;
      }
    }
    for (;;)
    {
      if (!bOh()) {
        i = 0;
      }
      if (i != 0)
      {
        this.pHv.setVisibility(0);
        this.pHu.setVisibility(0);
        this.pFq.zE(this.pFq.cVn());
      }
      return;
      label149:
      if ((j - this.pFi > 2) || (this.pFq.pFX) || (bk.cp(this.pFk) < 50L)) {
        label183:
        i = 0;
      }
    }
  }
  
  public final MMActivity bfn()
  {
    return this;
  }
  
  public final void ei(int paramInt1, int paramInt2)
  {
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.pHy)) {
      bOA();
    }
    this.pFp.ek(paramInt1, paramInt2);
  }
  
  public final boolean ej(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public final void f(List<byg> paramList, boolean paramBoolean)
  {
    this.pHr.g(paramList, paramBoolean);
    ai.l(new TopStoryFSVideoUI.6(this), 50L);
  }
  
  public final int getForceOrientation()
  {
    if (bNE()) {
      return 1;
    }
    return 0;
  }
  
  protected final int getLayoutId()
  {
    return b.e.top_story_fs_video_ui;
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    return this.oFh;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.pFa;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (bNE()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = bNz().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      y.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(bNz().x, bNz().y);
  }
  
  public final boolean isFullscreenMode()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    p.pGr.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.pFm.aIq()) || (com.tencent.mm.plugin.topstory.a.g.bNg())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.jJ(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_context");
    this.pDB = new byf();
    try
    {
      this.pDB.aH(paramBundle);
      this.pFq = new n();
      this.pFq.pEp = this;
      this.pFo = new m();
      this.pFo.d(this);
      this.pFn = new o();
      this.pFn.d(this);
      this.pFp = new r();
      this.pFp.d(this);
      this.pFm = new l();
      this.pHs = new h();
      if (this.pDB.tOp != null) {
        this.pFq.d(this.pDB.tOp);
      }
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().setStatusBarColor(getResources().getColor(b.a.fts_recommend_video_list_bg_color));
      }
      if (this.pDB.tOr) {
        this.pFm.pFL = true;
      }
      bOa();
      this.nWb = findViewById(b.d.title_container);
      this.pEW = findViewById(b.d.mute_click_area);
      this.pEX = ((ImageView)findViewById(b.d.mute_iv));
      this.mBP = ((ImageButton)findViewById(b.d.back_btn));
      this.mBP.getDrawable().setColorFilter(getResources().getColor(b.a.white), PorterDuff.Mode.SRC_ATOP);
      this.mBP.setOnClickListener(new TopStoryFSVideoUI.1(this));
      this.pEW.setOnClickListener(new TopStoryFSVideoUI.2(this));
      this.pHw = findViewById(b.d.fs_scroll_tips_layout);
      this.pHx = ((Button)findViewById(b.d.scroll_tips_i_know_btn));
      this.pFa = ((RecyclerView)findViewById(b.d.video_recycle_view));
      this.pFa.a(this.doG);
      this.oFh = new LinearLayoutManager();
      this.pFa.setLayoutManager(this.oFh);
      this.pFs = aj.b(this.oFh);
      this.pHr = new i(this);
      paramBundle = this.pHr;
      View localView = LayoutInflater.from(this).inflate(b.e.top_story_list_video_loading_footer, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.pHv = localView.findViewById(b.d.footer_loading_tv);
      this.pHu = localView.findViewById(b.d.footer_progress_bar);
      paramBundle.dl(localView);
      this.pFa.setAdapter(this.pHr);
      this.mBP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          TopStoryFSVideoUI.this.finish();
        }
      });
      new b().f(this.pFa);
      if (bOh()) {
        if (this.pFm.isConnected())
        {
          bOA();
          this.pHy = false;
          if ((this.pDB.scene != 21) && (this.pDB.tOq == null)) {
            this.pHt = com.tencent.mm.ui.base.h.b(this, getString(b.g.loading_tips), true, new TopStoryFSVideoUI.4(this));
          }
          this.pHr.pHA = true;
          this.pHw.setVisibility(8);
          if ((this.pFm.bOm()) && (com.tencent.mm.plugin.topstory.a.g.bNg()) && (System.currentTimeMillis() - rpP > 86400000L))
          {
            Toast.makeText(this, b.g.top_story_mobile_wangka_tips, 0).show();
            rpP = System.currentTimeMillis();
          }
          return;
        }
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        finish();
        continue;
        Toast.makeText(this, b.g.recommend_video_init_not_network_failed_hint, 1).show();
        this.pHy = true;
        continue;
        this.pHv.setVisibility(4);
        this.pHu.setVisibility(4);
      }
    }
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.plugin.topstory.a.h.a(this.pDB, czu());
    this.pFq.akT();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.pDB);
    this.pFp.akT();
    this.pFm.akT();
    this.pFn.akT();
    this.pFo.akT();
    a.jdMethod_if(16);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      y.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      byf localbyf = this.pDB;
      if (getSystemVolume() <= 1)
      {
        localbyf.dnJ = bool;
        bOk();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        y.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.pDB.dnJ = false;
        bOk();
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.pFp.Se();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    a.jdMethod_if(15);
  }
  
  protected void onResume()
  {
    super.onResume();
    bOa();
    bOk();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.pFp.Sf();
    this.pFm.pFN = l.bOn();
    a.jdMethod_if(14);
  }
  
  public final void zw(int paramInt)
  {
    y.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    this.pFa.smoothScrollToPosition(paramInt);
  }
  
  public final void zx(int paramInt)
  {
    this.pDB.tOt = paramInt;
  }
  
  public final void zy(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI
 * JD-Core Version:    0.7.0.1
 */