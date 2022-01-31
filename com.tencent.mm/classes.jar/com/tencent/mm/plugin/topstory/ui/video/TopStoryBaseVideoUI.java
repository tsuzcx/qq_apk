package com.tencent.mm.plugin.topstory.ui.video;

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
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.aj;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.b.a;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.f;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.c;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class TopStoryBaseVideoUI
  extends MMActivity
  implements c, b
{
  public static final int pEV = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 56);
  protected RecyclerView.m doG = new TopStoryBaseVideoUI.3(this);
  public TextView eXO;
  private boolean gAR = false;
  protected ImageButton mBP;
  public View nWb;
  public LinearLayoutManager oFh;
  private Point osl;
  public byf pDB;
  protected View pEW;
  protected ImageView pEX;
  public ImageView pEY;
  protected i pEZ;
  public RecyclerView pFa;
  protected e pFb;
  public d pFc;
  public RecyclerView pFd;
  public LinearLayoutManager pFe;
  protected e pFf;
  public d pFg;
  public boolean pFh = true;
  protected int pFi = 0;
  protected long pFj = -1L;
  protected long pFk = -1L;
  private i.a pFl = new TopStoryBaseVideoUI.4(this);
  public l pFm;
  public o pFn;
  private m pFo;
  public r pFp;
  public n pFq;
  private boolean pFr;
  private aj pFs;
  private aj pFt;
  public boolean pFu;
  private int videoHeight;
  
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
  
  public void PL(String paramString) {}
  
  public final aj bNA()
  {
    if (this.pFu) {
      return this.pFt;
    }
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
    if (this.pFu) {
      return this.pFf;
    }
    return this.pFb;
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
    return pEV;
  }
  
  public final void bNH()
  {
    if (!this.pFu)
    {
      this.eXO.setText(b.g.recommend_video_title);
      this.pEY.setVisibility(8);
    }
  }
  
  public final n bNJ()
  {
    return this.pFq;
  }
  
  public void bNp() {}
  
  public void bNq() {}
  
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
    y.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.osl.x), Integer.valueOf(this.osl.y) });
    return this.osl;
  }
  
  final void bOa()
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
  
  public void bOb() {}
  
  public void bOc()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(b.a.fts_recommend_video_list_bg_color));
    }
    bOa();
    this.nWb = findViewById(b.d.title_container);
    this.eXO = ((TextView)findViewById(b.d.title_tv));
    this.pEY = ((ImageView)findViewById(b.d.source_iv));
    this.pEW = findViewById(b.d.mute_click_area);
    this.pEX = ((ImageView)findViewById(b.d.mute_iv));
    this.mBP = ((ImageButton)findViewById(b.d.back_btn));
    this.mBP.getDrawable().setColorFilter(getResources().getColor(b.a.white), PorterDuff.Mode.SRC_ATOP);
    this.mBP.setOnClickListener(new TopStoryBaseVideoUI.1(this));
    this.pEW.setOnClickListener(new TopStoryBaseVideoUI.2(this));
    this.pFa = ((RecyclerView)findViewById(b.d.video_recycle_view));
    this.pFa.a(this.doG);
    this.pFa.setItemAnimator(new TopStoryBaseVideoUI.a(this, (byte)0));
    this.oFh = new LinearLayoutManager();
    this.pFa.setLayoutManager(this.oFh);
    this.pFs = aj.b(this.oFh);
    this.pFb = bOi();
    this.pFa.setAdapter(this.pFb);
    this.pFd = ((RecyclerView)findViewById(b.d.fs_video_recycle_view));
    this.pFd.a(this.doG);
    this.pFd.setItemAnimator(new TopStoryBaseVideoUI.a(this, (byte)0));
    this.pFe = new LinearLayoutManager();
    this.pFd.setLayoutManager(this.pFe);
    this.pFt = aj.b(this.pFe);
    this.pFf = bOj();
    this.pFd.setAdapter(this.pFf);
    this.pFd.setVisibility(8);
    if ((!this.gAR) && (!bNE()))
    {
      this.pEZ = new i(this);
      this.pEZ.enable();
      this.pEZ.pFA = this.pFl;
      this.gAR = true;
    }
    if (this.pDB.dnJ) {
      jL(this.pDB.dnJ);
    }
    this.pFm.pFM = this;
  }
  
  public abstract d bOd();
  
  public abstract d bOe();
  
  public void bOf()
  {
    int j = 0;
    int i;
    if (this.pFu)
    {
      this.pFg.a(this);
      this.pFi = ((LinearLayoutManager)getLayoutManager()).ha();
      i = getLayoutManager().getItemCount();
      if ((this.pFj <= 0L) || (bk.cp(this.pFj) >= 50L))
      {
        this.pFj = bk.UZ();
        if (this.pFq.pFY == 1) {
          break label145;
        }
        if ((this.pFi < i - 1) || (this.pFq.pFX) || (bk.cp(this.pFk) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!bOh()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          bOg();
        }
        return;
        this.pFc.a(this);
        break;
        label145:
        if ((i - this.pFi > 2) || (this.pFq.pFX) || (bk.cp(this.pFk) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  public void bOg()
  {
    this.pFk = bk.UZ();
  }
  
  public final boolean bOh()
  {
    return this.pDB.scene != 36;
  }
  
  public abstract e bOi();
  
  public abstract e bOj();
  
  public final MMActivity bfn()
  {
    return this;
  }
  
  public void ei(int paramInt1, int paramInt2)
  {
    this.pFp.ek(paramInt1, paramInt2);
  }
  
  public void f(final List<byg> paramList, final boolean paramBoolean)
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        if (TopStoryBaseVideoUI.this.pFu)
        {
          TopStoryBaseVideoUI.this.pFf.g(paramList, paramBoolean);
          TopStoryBaseVideoUI.this.pFb.agL.notifyChanged();
          return;
        }
        TopStoryBaseVideoUI.this.pFb.g(paramList, paramBoolean);
        TopStoryBaseVideoUI.this.pFf.agL.notifyChanged();
      }
    });
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    if (this.pFu) {
      return this.pFe;
    }
    return this.oFh;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.pFu) {
      return this.pFd;
    }
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
      y.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(bNz().x, bNz().y);
  }
  
  public final boolean isFullscreenMode()
  {
    return this.pFu;
  }
  
  public final void jK(boolean paramBoolean)
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pFh = paramBoolean;
  }
  
  public final void jL(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.pDB.dnJ = true;
    }
    for (;;)
    {
      bOk();
      return;
      this.pDB.dnJ = false;
      if (getSystemVolume() == 0) {
        ((AudioManager)this.mController.uMN.getSystemService("audio")).setStreamVolume(3, 1, 0);
      }
    }
  }
  
  public void onBackPressed()
  {
    bOb();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    xK();
    bOc();
  }
  
  protected void onDestroy()
  {
    h.a(this.pDB, czu());
    if (this.gAR)
    {
      this.pEZ.disable();
      this.pEZ.pFA = null;
      this.pEZ = null;
    }
    this.pFq.akT();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.pDB);
    this.pFp.akT();
    this.pFm.akT();
    this.pFn.akT();
    this.pFo.akT();
    com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(16);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      y.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
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
        y.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
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
    com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(15);
  }
  
  protected void onResume()
  {
    super.onResume();
    bOa();
    bOk();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.pFp.Sf();
    this.pFm.pFN = l.bOn();
    com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(14);
  }
  
  public void xK()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.pDB = new byf();
    try
    {
      this.pDB.aH(arrayOfByte);
      this.pFq = new n();
      this.pFq.pEp = this;
      this.pFo = new m();
      this.pFo.d(this);
      this.pFn = new o();
      this.pFn.d(this);
      this.pFp = new r();
      this.pFp.d(this);
      this.pFm = new l();
      this.pFc = bOd();
      this.pFg = bOe();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        finish();
      }
    }
  }
  
  public void zD(int paramInt) {}
  
  public final void zx(int paramInt)
  {
    this.pDB.tOt = paramInt;
  }
  
  public final void zy(int paramInt)
  {
    if (this.pFp.bOu())
    {
      this.pFp.bFy();
      this.pFr = true;
    }
    Object localObject = this.pFq.Es(paramInt);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 1;
    while (i < ((byg)localObject).tOH.size())
    {
      localLinkedHashMap.put(((zc)((byg)localObject).tOH.get(i)).bQZ, Integer.valueOf(0));
      i += 1;
    }
    e.a locala1 = new e.a(this.mController.uMN);
    localObject = new TopStoryBaseVideoUI.5(this, (byg)localObject, paramInt);
    e.a locala2 = locala1.aeF(getString(b.g.top_story_feedback_unlike_reason_title));
    String str = getString(b.g.top_story_feedback_unlike_reason_desc);
    paramInt = ap.fromDPToPix(locala2.mContext, (int)(14.0F * ap.cJ(locala2.mContext)));
    if ((str != null) && (str.length() > 0))
    {
      SpannableString localSpannableString = (SpannableString)com.tencent.mm.ui.e.c.b.c(str.toString(), paramInt);
      locala2.scn.T(localSpannableString);
    }
    locala2.scn.T(str);
    locala2.b(localLinkedHashMap);
    locala1.Iu(b.g.top_story_feedback_unlike);
    locala1.nY(true);
    locala1.wnB = new TopStoryBaseVideoUI.6(this, locala1, (e.c)localObject);
    locala1.a((e.c)localObject);
    locala1.b(new TopStoryBaseVideoUI.7(this));
    locala1.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */