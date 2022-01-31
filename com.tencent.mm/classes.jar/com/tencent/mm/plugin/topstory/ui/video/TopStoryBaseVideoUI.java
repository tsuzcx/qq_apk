package com.tencent.mm.plugin.topstory.ui.video;

import android.app.Activity;
import android.content.Context;
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
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.io.IOException;
import java.util.List;

public abstract class TopStoryBaseVideoUI
  extends MMActivity
  implements c, b
{
  protected RecyclerView.m egc = new TopStoryBaseVideoUI.3(this);
  protected TextView gpL;
  private boolean hYK = false;
  protected ImageButton pbT;
  protected View qKl;
  private Point rhc;
  protected LinearLayoutManager ruI;
  public ckw tfp;
  protected LinearLayoutManager tiA;
  protected e tiB;
  public d tiC;
  public boolean tiD = true;
  protected int tiE = 0;
  protected long tiF = -1L;
  protected long tiG = -1L;
  private i.a tiH = new TopStoryBaseVideoUI.4(this);
  protected l tiI;
  public o tiJ;
  private m tiK;
  public r tiL;
  protected n tiM;
  private boolean tiN;
  protected com.tencent.mm.plugin.topstory.ui.widget.b tiO;
  private aj tiP;
  private aj tiQ;
  public boolean tiR;
  private com.tencent.mm.ai.f tiS = new TopStoryBaseVideoUI.7(this);
  protected View tis;
  protected ImageView tit;
  protected ImageView tiu;
  protected i tiv;
  protected RecyclerView tiw;
  protected e tix;
  protected d tiy;
  public RecyclerView tiz;
  private int videoHeight;
  
  private void cJN()
  {
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.fw(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      return;
      localView.setSystemUiVisibility(4098);
    }
  }
  
  private void cJX()
  {
    if (this.tfp.efg) {
      this.tit.setBackgroundResource(2131232123);
    }
    for (;;)
    {
      if (this.tiL.tjS) {
        this.tiL.setMute(this.tfp.efg);
      }
      return;
      this.tit.setBackgroundResource(2131232124);
    }
  }
  
  private void cJY()
  {
    com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
  }
  
  private int getSystemVolume()
  {
    return ((AudioManager)getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  public final boolean DP()
  {
    return this.tfp.efg;
  }
  
  public final void GA(int paramInt)
  {
    this.tfp.xUT = paramInt;
  }
  
  public final void GB(int paramInt)
  {
    this.tfp.xUW = paramInt;
  }
  
  protected void GG(int paramInt) {}
  
  protected void Kc()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_context");
    this.tfp = new ckw();
    try
    {
      this.tfp.parseFrom(arrayOfByte);
      this.tiM = new n();
      this.tiM.thM = this;
      this.tiK = new m();
      this.tiK.d(this);
      this.tiJ = new o();
      this.tiJ.d(this);
      this.tiL = new r();
      this.tiL.d(this);
      this.tiI = new l();
      this.tiy = cJQ();
      this.tiC = cJR();
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
  
  public final void a(ckx paramckx)
  {
    if (paramckx != null)
    {
      if (!at.isConnected(this)) {
        Toast.makeText(getContext(), getString(2131304339), 0).show();
      }
    }
    else {
      return;
    }
    Object localObject = paramckx.uKI;
    int i;
    int j;
    if (paramckx.xVp)
    {
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.tfp.scene;
      String str2 = this.tfp.hng;
      if (!cJn()) {
        break label178;
      }
      j = 318;
      label92:
      localObject = new com.tencent.mm.plugin.topstory.a.c.i(paramckx, (String)localObject, i, str1, k, str2, j, paramckx.xVa, paramckx.xVq);
      com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      if (paramckx.xVp) {
        break label185;
      }
    }
    label178:
    label185:
    for (boolean bool = true;; bool = false)
    {
      paramckx.xVp = bool;
      ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + paramckx.xVp);
      return;
      i = 4;
      break;
      j = 317;
      break label92;
    }
  }
  
  public abstract void a(ckx paramckx, View paramView, boolean paramBoolean);
  
  public void aen(String paramString) {}
  
  public final void aeo(String paramString)
  {
    this.tfp.xUV = paramString;
  }
  
  public final void ah(View paramView, int paramInt)
  {
    if (this.tiL.cKj())
    {
      this.tiL.crn();
      this.tiN = true;
    }
    ckx localckx = this.tiM.GI(paramInt);
    this.tiO = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localckx.xVk, new TopStoryBaseVideoUI.5(this, localckx, paramInt));
    if (this.tiR) {
      this.tiO.a(paramView, true, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
    }
    try
    {
      ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.tiL.tjQ.getControlBar()).baj();
      return;
    }
    catch (Exception paramView) {}
    this.tiO.a(paramView, false, 0, 0 - com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    return;
  }
  
  public final MMActivity bMN()
  {
    return this;
  }
  
  public void cIZ() {}
  
  protected void cJO() {}
  
  protected void cJP()
  {
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
      getSupportActionBar().hide();
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131690076));
    }
    cJN();
    this.qKl = findViewById(2131828204);
    this.gpL = ((TextView)findViewById(2131821212));
    this.tiu = ((ImageView)findViewById(2131828540));
    this.tis = findViewById(2131828562);
    this.tit = ((ImageView)findViewById(2131828563));
    this.pbT = ((ImageButton)findViewById(2131826460));
    this.pbT.getDrawable().setColorFilter(getResources().getColor(2131690709), PorterDuff.Mode.SRC_ATOP);
    this.pbT.setOnClickListener(new TopStoryBaseVideoUI.1(this));
    this.tis.setOnClickListener(new TopStoryBaseVideoUI.2(this));
    this.tis.setVisibility(8);
    this.tiw = ((RecyclerView)findViewById(2131828559));
    this.tiw.a(this.egc);
    this.tiw.setItemAnimator(new TopStoryBaseVideoUI.a(this, (byte)0));
    this.ruI = new LinearLayoutManager();
    this.tiw.setLayoutManager(this.ruI);
    this.tiP = aj.e(this.ruI);
    this.tix = cJV();
    this.tiw.setAdapter(this.tix);
    this.tiz = ((RecyclerView)findViewById(2131828605));
    this.tiz.a(this.egc);
    this.tiz.setItemAnimator(new TopStoryBaseVideoUI.a(this, (byte)0));
    this.tiA = new LinearLayoutManager();
    this.tiz.setLayoutManager(this.tiA);
    this.tiQ = aj.e(this.tiA);
    this.tiB = cJW();
    this.tiz.setAdapter(this.tiB);
    this.tiz.setVisibility(8);
    if ((!this.hYK) && (!cJn()))
    {
      this.tiv = new i(getApplicationContext());
      this.tiv.enable();
      this.tiv.tiZ = this.tiH;
      this.hYK = true;
    }
    if (this.tfp.efg) {
      mC(this.tfp.efg);
    }
    this.tiI.tjl = this;
  }
  
  protected abstract d cJQ();
  
  protected abstract d cJR();
  
  protected void cJS()
  {
    int j = 0;
    int i;
    if (this.tiR)
    {
      this.tiC.a(this);
      this.tiE = ((LinearLayoutManager)getLayoutManager()).iv();
      i = getLayoutManager().getItemCount();
      if ((this.tiF <= 0L) || (bo.av(this.tiF) >= 50L))
      {
        this.tiF = bo.yB();
        if (this.tiM.tjv == 1) {
          break label145;
        }
        if ((this.tiE < i - 1) || (this.tiM.tju) || (bo.av(this.tiG) < 50L)) {
          break label187;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label116:
      if (!cJU()) {
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          cJT();
        }
        return;
        this.tiy.a(this);
        break;
        label145:
        if ((i - this.tiE > 3) || (this.tiM.tju) || (bo.av(this.tiG) < 50L)) {
          break label187;
        }
        i = 1;
        break label116;
      }
      label187:
      i = 0;
    }
  }
  
  protected void cJT()
  {
    this.tiG = bo.yB();
  }
  
  protected final boolean cJU()
  {
    return (this.tfp.scene != 36) && (!this.tfp.xUX);
  }
  
  protected abstract e cJV();
  
  protected abstract e cJW();
  
  public void cJa() {}
  
  public final l cJc()
  {
    return this.tiI;
  }
  
  public final o cJd()
  {
    return this.tiJ;
  }
  
  public final String cJe()
  {
    return com.tencent.mm.plugin.topstory.a.g.aef(this.tfp.xUt);
  }
  
  public final ckw cJf()
  {
    return this.tfp;
  }
  
  public final m cJg()
  {
    return this.tiK;
  }
  
  public final r cJh()
  {
    return this.tiL;
  }
  
  public final Point cJi()
  {
    if (this.rhc == null) {
      this.rhc = af.hQ(this);
    }
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", new Object[] { Integer.valueOf(this.rhc.x), Integer.valueOf(this.rhc.y) });
    return this.rhc;
  }
  
  public final aj cJj()
  {
    if (this.tiR) {
      return this.tiQ;
    }
    return this.tiP;
  }
  
  public final int cJk()
  {
    return this.tfp.xUT;
  }
  
  public final boolean cJl()
  {
    return this.tfp.scene != 36;
  }
  
  public final e cJm()
  {
    if (this.tiR) {
      return this.tiB;
    }
    return this.tix;
  }
  
  public final boolean cJn()
  {
    return this.tfp.xUO == 100203L;
  }
  
  public final void cJo()
  {
    cJN();
  }
  
  public int cJp()
  {
    return com.tencent.mm.plugin.topstory.ui.a.tfs;
  }
  
  public final void cJq()
  {
    if (!this.tiR)
    {
      this.gpL.setText(2131302349);
      this.tiu.setVisibility(8);
    }
  }
  
  public final n cJs()
  {
    return this.tiM;
  }
  
  public final String cJt()
  {
    if (this.tfp.xUV == null) {
      return "";
    }
    return this.tfp.xUV;
  }
  
  public final int cJu()
  {
    return this.tfp.xUW;
  }
  
  public final void cJv()
  {
    runOnUiThread(new TopStoryBaseVideoUI.8(this));
  }
  
  public void ge(int paramInt1, int paramInt2)
  {
    this.tiL.gi(paramInt1, paramInt2);
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    if (this.tiR) {
      return this.tiA;
    }
    return this.ruI;
  }
  
  public final RecyclerView getRecyclerView()
  {
    if (this.tiR) {
      return this.tiz;
    }
    return this.tiw;
  }
  
  public final int getVideoHeight()
  {
    if (this.videoHeight == 0)
    {
      if (cJn()) {
        break label35;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      return this.videoHeight;
      label35:
      this.videoHeight = 1280;
      int i = cJi().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    return Math.min(cJi().x, cJi().y);
  }
  
  public final boolean isFullscreenMode()
  {
    return this.tiR;
  }
  
  public void k(List<ckx> paramList, boolean paramBoolean)
  {
    al.d(new TopStoryBaseVideoUI.6(this, paramList, paramBoolean));
  }
  
  public final void mB(boolean paramBoolean)
  {
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tiD = paramBoolean;
  }
  
  public final void mC(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.tfp.efg = true;
    }
    for (;;)
    {
      cJX();
      return;
      this.tfp.efg = false;
      if (getSystemVolume() == 0) {
        cJY();
      }
    }
  }
  
  public void onBackPressed()
  {
    cJO();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Kc();
    cJP();
    com.tencent.mm.kernel.g.Rc().a(2802, this.tiS);
  }
  
  public void onDestroy()
  {
    h.a(this.tfp, getActivityBrowseTimeMs(), this.tiM.GI(this.tfp.xUT));
    if (this.hYK)
    {
      this.tiv.disable();
      this.tiv.tiZ = null;
      this.tiv = null;
    }
    com.tencent.mm.kernel.g.Rc().b(2802, this.tiS);
    this.tiM.aEM();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.tfp);
    this.tiL.aEM();
    this.tiI.aEM();
    this.tiJ.aEM();
    this.tiK.aEM();
    com.tencent.mm.plugin.websearch.api.a.a.kS(16);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      ckw localckw = this.tfp;
      if (getSystemVolume() <= 1)
      {
        localckw.efg = bool;
        cJX();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.tfp.efg = false;
        cJX();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.tiL.alo();
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
      label25:
      com.tencent.mm.plugin.websearch.api.a.a.kS(15);
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    cJN();
    cJX();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.tiL.alp();
    this.tiI.qCf = l.cvE();
    com.tencent.mm.plugin.websearch.api.a.a.kS(14);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
 * JD-Core Version:    0.7.0.1
 */