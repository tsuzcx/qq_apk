package com.tencent.mm.plugin.music.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.h.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@com.tencent.mm.ui.base.a(19)
public class MusicMainUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener, com.tencent.mm.ai.f
{
  private ak ebv;
  private com.tencent.mm.sdk.b.c hCe;
  private long lastShakeTime;
  private int mode;
  private d.a oXk;
  private boolean oZO;
  private CheckBox pbS;
  private ImageButton pbT;
  private ImageButton pbU;
  private MusicSeekBar pbV;
  private MusicViewPager pbW;
  private b pbX;
  private boolean pbY;
  private int pbZ;
  private Timer pca;
  private int pcb;
  private ak pcc;
  private int scene;
  private com.tencent.mm.pluginsdk.i.d shakeSensor;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(105107);
    this.pbZ = 0;
    this.hCe = new MusicMainUI.3(this);
    this.ebv = new ak(Looper.getMainLooper());
    this.pcb = -1;
    this.oXk = new MusicMainUI.8(this);
    this.pcc = new MusicMainUI.9(this, Looper.getMainLooper());
    AppMethodBeat.o(105107);
  }
  
  private void bWs()
  {
    AppMethodBeat.i(105111);
    com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class);
    this.pbX.count = 200000;
    this.pbX.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVE())
    {
      this.pbW.setCanSlide(true);
      AppMethodBeat.o(105111);
      return;
    }
    this.pbW.setCanSlide(false);
    AppMethodBeat.o(105111);
  }
  
  private void bWt()
  {
    AppMethodBeat.i(105112);
    if (this.pca != null) {
      this.pca.cancel();
    }
    this.pca = null;
    AppMethodBeat.o(105112);
  }
  
  private void bWu()
  {
    AppMethodBeat.i(105119);
    int i = k.bVH().bVu().bUH();
    int j = k.bVH().bVu().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.pbV.setProgress(i);
      this.pbV.setMaxProgress(j);
    }
    AppMethodBeat.o(105119);
  }
  
  private void h(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(105116);
    if ((com.tencent.mm.plugin.music.model.d.a(parama)) && (!this.oZO))
    {
      this.pbS.setVisibility(0);
      this.pbU.setVisibility(0);
      AppMethodBeat.o(105116);
      return;
    }
    this.pbS.setVisibility(8);
    this.pbU.setVisibility(8);
    AppMethodBeat.o(105116);
  }
  
  public int getLayoutId()
  {
    return 2130970329;
  }
  
  public final void i(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(105120);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVw();
    if (locala == null)
    {
      AppMethodBeat.o(105120);
      return;
    }
    if ((locala.g(parama)) && (this.pbU != null) && (this.pbT != null) && (this.pbS != null) && (this.pbU.getBackground() != null) && (this.pbT.getBackground() != null) && (this.pbS.getBackground() != null) && (this.pbV != null))
    {
      if (parama.bVW())
      {
        int i = parama.field_songLyricColor;
        this.pbU.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.pbT.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.pbS.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.pbV.setColor(i);
        AppMethodBeat.o(105120);
        return;
      }
      this.pbU.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.pbT.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.pbS.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.pbV.setColor(-1);
    }
    AppMethodBeat.o(105120);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(105118);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      com.tencent.mm.aw.e locale = k.bVH().bVs();
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      paramIntent = new WXMusicObject();
      paramIntent.musicUrl = locale.fKr;
      paramIntent.musicDataUrl = locale.fKp;
      paramIntent.musicLowBandUrl = locale.fKq;
      paramIntent.musicLowBandDataUrl = locale.fKq;
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = paramIntent;
      localWXMediaMessage.title = locale.fKl;
      localWXMediaMessage.description = locale.fKm;
      Object localObject = null;
      String str2 = com.tencent.mm.plugin.music.model.d.u(locale);
      paramIntent = localObject;
      if (str2 != null)
      {
        paramIntent = localObject;
        if (com.tencent.mm.vfs.e.cN(str2))
        {
          paramInt1 = (int)getResources().getDimension(2131427800);
          paramIntent = com.tencent.mm.sdk.platformtools.d.aA(str2, paramInt1, paramInt1);
        }
      }
      if (paramIntent != null) {}
      for (localWXMediaMessage.thumbData = bo.an(paramIntent);; localWXMediaMessage.thumbData = bo.an(com.tencent.mm.sdk.platformtools.d.Na(2130838497)))
      {
        com.tencent.mm.plugin.music.model.b.gmO.a(this, com.tencent.mm.plugin.music.model.d.v(locale), localWXMediaMessage, str1, com.tencent.mm.plugin.music.model.d.w(locale));
        ab.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
        AppMethodBeat.o(105118);
        return;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(105118);
  }
  
  public void onClickBack(View paramView)
  {
    AppMethodBeat.i(105114);
    finish();
    AppMethodBeat.o(105114);
  }
  
  public void onClickSend(View paramView)
  {
    AppMethodBeat.i(105115);
    Object localObject2 = k.bVH().bVs();
    ab.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.aw.e)localObject2).fKh), ((com.tencent.mm.aw.e)localObject2).fKr });
    String str1;
    Object localObject1;
    String str2;
    Object localObject3;
    if (((com.tencent.mm.aw.e)localObject2).fKh == 11)
    {
      paramView = new gl();
      com.tencent.mm.sdk.b.a.ymk.l(paramView);
      str1 = paramView.cvq.appId;
      localObject1 = paramView.cvq.cqQ;
      str2 = paramView.cvq.cvr;
      int i = paramView.cvq.cvs;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      ab.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(2131300534, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.aw.e)localObject2).fKr))
      {
        ArrayList localArrayList = new ArrayList();
        localObject1 = getString(2131301732);
        localObject3 = getString(2131301733);
        String str3 = getString(2131298168);
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(Integer.valueOf(1));
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(3));
        localObject2 = new MusicMainUI.5(this, (com.tencent.mm.aw.e)localObject2, str1, str2, i);
        com.tencent.mm.ui.base.h.a(this, "", new String[] { localObject1, localObject3, str3, paramView }, "", (h.c)localObject2);
        AppMethodBeat.o(105115);
        return;
      }
      new ArrayList().add(Integer.valueOf(0));
      localObject1 = new MusicMainUI.6(this, str1, str2, i);
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.c)localObject1);
      AppMethodBeat.o(105115);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.aw.e)localObject2).fKr))
    {
      localObject3 = new ArrayList();
      paramView = getString(2131301732);
      localObject1 = getString(2131301733);
      str1 = getString(2131298168);
      str2 = getString(2131299678);
      ((List)localObject3).add(Integer.valueOf(0));
      ((List)localObject3).add(Integer.valueOf(1));
      ((List)localObject3).add(Integer.valueOf(2));
      ((List)localObject3).add(Integer.valueOf(3));
      localObject2 = new MusicMainUI.7(this, (com.tencent.mm.aw.e)localObject2);
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView, localObject1, str1, str2 }, "", (h.c)localObject2);
    }
    AppMethodBeat.o(105115);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(105108);
    super.onCreate(paramBundle);
    hideTitleView();
    if (!k.isInit())
    {
      finish();
      ab.e("MicroMsg.Music.MusicMainUI", "MusicPlayerManager is not init!");
      AppMethodBeat.o(105108);
      return;
    }
    getWindow().setFlags(67109888, 67109888);
    this.mode = getIntent().getIntExtra("key_mode", 2);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.oZO = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.pbW = ((MusicViewPager)findViewById(2131826457));
    this.pbX = new b(this, this.scene, this.oZO);
    this.pbW.setAdapter(this.pbX);
    this.pbW.setOnPageChangeListener(this);
    this.pbW.setSystemUiVisibility(4096);
    this.pbT = ((ImageButton)findViewById(2131826460));
    this.pbU = ((ImageButton)findViewById(2131826461));
    paramBundle = (RelativeLayout.LayoutParams)this.pbT.getLayoutParams();
    int j = paramBundle.topMargin;
    int i = j;
    if (af.hW(getContext())) {
      i = j + af.getStatusBarHeight(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.pbT.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.pbU.getLayoutParams();
    j = paramBundle.topMargin;
    i = j;
    if (af.hW(getContext())) {
      i = j + af.getStatusBarHeight(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.pbU.setLayoutParams(paramBundle);
    this.pbS = ((CheckBox)findViewById(2131826458));
    paramBundle = this.pbS;
    if (!k.bVH().bVu().aiw()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.i.d();
      this.pbS.setOnClickListener(new MusicMainUI.1(this));
      com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
      this.pbV = ((MusicSeekBar)findViewById(2131826459));
      this.pbV.setOnSeekBarChange(new MusicMainUI.2(this));
      if (!this.shakeSensor.dmL()) {
        ab.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      bWs();
      this.pbW.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVC() + 100000);
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVw();
      if (paramBundle != null)
      {
        ab.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.h.qsU.e(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVw();
      if (paramBundle != null) {
        break;
      }
      finish();
      AppMethodBeat.o(105108);
      return;
    }
    if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
    {
      i = g.RL().Ru().getInt(83, 0);
      if (i < 3)
      {
        Toast.makeText(this, 2131300239, 0).show();
        g.RL().Ru().set(83, Integer.valueOf(i + 1));
      }
    }
    if (this.scene == 5) {
      com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
    }
    h(paramBundle);
    if (this.mode == 1)
    {
      if (this.pca == null) {
        this.pca = new Timer();
      }
      this.pca.schedule(new MusicMainUI.4(this), 0L, 500L);
    }
    AppMethodBeat.o(105108);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(105113);
    super.onDestroy();
    if (this.shakeSensor != null) {
      this.shakeSensor.bjf();
    }
    if (this.pbX != null)
    {
      Object localObject = this.pbX;
      ((b)localObject).oZz.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).pbB;
      ((com.tencent.mm.plugin.music.model.c)localObject).oZz.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.c)localObject).eap.clear();
    }
    if (this.pbV != null) {
      this.pbV.fs(false);
    }
    bWt();
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    k.bVH().bVu().a(null);
    if (!k.bVH().bVu().aiw()) {
      k.bVH().bVu().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVD();
    AppMethodBeat.o(105113);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(105117);
    ab.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVE()) {
      this.pbW.setCanSlide(false);
    }
    this.ebv.removeCallbacksAndMessages(null);
    this.ebv.postDelayed(new MusicMainUI.a(this, paramInt), 500L);
    if (this.pcb == -1) {
      this.pcb = paramInt;
    }
    if (this.pcb != paramInt)
    {
      this.pcb = paramInt;
      com.tencent.mm.plugin.music.model.d.e.pap = true;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.eS(1, this.scene);
    }
    AppMethodBeat.o(105117);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(105110);
    super.onPause();
    if (this.shakeSensor != null) {
      this.shakeSensor.bjf();
    }
    k.bVH().bVu().a(null);
    AppMethodBeat.o(105110);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(105109);
    super.onResume();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVx()) {
      if (!this.oZO)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.dmL()) && (!this.shakeSensor.dmJ())) {
          this.shakeSensor.a(new MusicMainUI.b(this, (byte)0));
        }
        this.lastShakeTime = bo.yB();
      }
    }
    for (;;)
    {
      k.bVH().bVu().a(this.oXk);
      bWu();
      AppMethodBeat.o(105109);
      return;
      ab.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVz();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */