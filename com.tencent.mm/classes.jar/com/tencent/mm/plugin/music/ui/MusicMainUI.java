package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.h.a.gg;
import com.tencent.mm.h.a.gg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@com.tencent.mm.ui.base.a(19)
public class MusicMainUI
  extends MMActivity
  implements ViewPager.e, com.tencent.mm.ah.f
{
  private ah dka = new ah(Looper.getMainLooper());
  private com.tencent.mm.sdk.b.c giK = new MusicMainUI.3(this);
  private long iam;
  private CheckBox mBO;
  private ImageButton mBP;
  private ImageButton mBQ;
  private MusicSeekBar mBR;
  private MusicViewPager mBS;
  private com.tencent.mm.pluginsdk.i.c mBT;
  private b mBU;
  private boolean mBV;
  private int mBW = 0;
  private Timer mBX;
  private int mBY = -1;
  private ah mBZ = new MusicMainUI.9(this, Looper.getMainLooper());
  private int mode;
  private d.a mxn = new MusicMainUI.8(this);
  private boolean mzI;
  private int scene;
  
  private void bnV()
  {
    com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class);
    this.mBU.count = 200000;
    this.mBU.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bni())
    {
      this.mBS.setCanSlide(true);
      return;
    }
    this.mBS.setCanSlide(false);
  }
  
  private void bnW()
  {
    if (this.mBX != null) {
      this.mBX.cancel();
    }
    this.mBX = null;
  }
  
  private void bnX()
  {
    int i = k.bnl().bmY().bmA();
    int j = k.bnl().bmY().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.mBR.setProgress(i);
      this.mBR.setMaxProgress(j);
    }
  }
  
  private void f(com.tencent.mm.plugin.music.model.e.a parama)
  {
    if ((com.tencent.mm.plugin.music.model.d.a(parama)) && (!this.mzI))
    {
      this.mBO.setVisibility(0);
      this.mBQ.setVisibility(0);
      return;
    }
    this.mBO.setVisibility(8);
    this.mBQ.setVisibility(8);
  }
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    y.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bni()) {
      this.mBS.setCanSlide(false);
    }
    this.dka.removeCallbacksAndMessages(null);
    this.dka.postDelayed(new MusicMainUI.a(this, paramInt), 500L);
    if (this.mBY == -1) {
      this.mBY = paramInt;
    }
    if (this.mBY != paramInt)
    {
      this.mBY = paramInt;
      com.tencent.mm.plugin.music.model.d.d.mAj = true;
      com.tencent.mm.plugin.report.service.h.nFQ.a(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.d.ds(1, this.scene);
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void g(com.tencent.mm.plugin.music.model.e.a parama)
  {
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bna();
    if (locala == null) {}
    for (;;)
    {
      return;
      if (parama == null) {}
      for (boolean bool = false; (bool) && (this.mBQ != null) && (this.mBP != null) && (this.mBO != null) && (this.mBQ.getBackground() != null) && (this.mBP.getBackground() != null) && (this.mBO.getBackground() != null); bool = locala.field_musicId.equals(parama.field_musicId))
      {
        if (!parama.bnz()) {
          break label161;
        }
        int i = parama.field_songLyricColor;
        this.mBQ.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.mBP.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.mBO.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.mBR.setColor(i);
        return;
      }
    }
    label161:
    this.mBQ.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    this.mBP.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    this.mBO.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    this.mBR.setColor(-1);
  }
  
  protected final int getLayoutId()
  {
    return a.e.music_main_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      com.tencent.mm.av.e locale = k.bnl().bmW();
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      paramIntent = new WXMusicObject();
      paramIntent.musicUrl = locale.euF;
      paramIntent.musicDataUrl = locale.euD;
      paramIntent.musicLowBandUrl = locale.euE;
      paramIntent.musicLowBandDataUrl = locale.euE;
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = paramIntent;
      localWXMediaMessage.title = locale.euz;
      localWXMediaMessage.description = locale.euA;
      Object localObject = null;
      String str2 = com.tencent.mm.plugin.music.model.d.u(locale);
      paramIntent = localObject;
      if (str2 != null)
      {
        paramIntent = localObject;
        if (com.tencent.mm.vfs.e.bK(str2))
        {
          paramInt1 = (int)getResources().getDimension(a.b.NormalAvatarSize);
          paramIntent = com.tencent.mm.sdk.platformtools.c.ak(str2, paramInt1, paramInt1);
        }
      }
      if (paramIntent != null) {}
      for (localWXMediaMessage.thumbData = bk.X(paramIntent);; localWXMediaMessage.thumbData = bk.X(com.tencent.mm.sdk.platformtools.c.EX(a.c.default_icon_music)))
      {
        com.tencent.mm.plugin.music.model.b.eUR.a(this, com.tencent.mm.plugin.music.model.d.v(locale), localWXMediaMessage, str1, com.tencent.mm.plugin.music.model.d.w(locale));
        y.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
        return;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClickBack(View paramView)
  {
    finish();
  }
  
  public void onClickSend(View paramView)
  {
    Object localObject2 = k.bnl().bmW();
    y.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.av.e)localObject2).euv), ((com.tencent.mm.av.e)localObject2).euF });
    if (((com.tencent.mm.av.e)localObject2).euv == 11)
    {
      paramView = new gg();
      com.tencent.mm.sdk.b.a.udP.m(paramView);
      str1 = paramView.bNY.appId;
      localObject1 = paramView.bNY.bJw;
      str2 = paramView.bNY.bNZ;
      i = paramView.bNY.bOa;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      y.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(a.f.go_to_app_brand, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.av.e)localObject2).euF))
      {
        localArrayList = new ArrayList();
        localObject1 = getString(a.f.music_send_to_friend);
        localObject3 = getString(a.f.music_share_timeline);
        str3 = getString(a.f.chatting_fav);
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(Integer.valueOf(1));
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(3));
        localObject2 = new h.c()
        {
          public final void gl(int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 0: 
              com.tencent.mm.plugin.music.model.d.D(MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.d.uR(MusicMainUI.h(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.d.uT(2);
              return;
            case 1: 
              com.tencent.mm.plugin.music.model.d.b(this.euo, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.d.uS(MusicMainUI.h(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.d.uT(1);
              return;
            case 2: 
              com.tencent.mm.plugin.music.model.d.a(this.euo, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.d.uT(3);
              return;
            }
            com.tencent.mm.plugin.music.model.d.F(str1, str2, i);
          }
        };
        com.tencent.mm.ui.base.h.a(this, "", new String[] { localObject1, localObject3, str3, paramView }, "", (h.c)localObject2);
      }
    }
    while (TextUtils.isEmpty(((com.tencent.mm.av.e)localObject2).euF))
    {
      final int i;
      ArrayList localArrayList;
      String str3;
      return;
      new ArrayList().add(Integer.valueOf(0));
      localObject1 = new MusicMainUI.6(this, str1, str2, i);
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.c)localObject1);
      return;
    }
    Object localObject3 = new ArrayList();
    paramView = getString(a.f.music_send_to_friend);
    Object localObject1 = getString(a.f.music_share_timeline);
    final String str1 = getString(a.f.chatting_fav);
    final String str2 = getString(a.f.fav_to_qq_music);
    ((List)localObject3).add(Integer.valueOf(0));
    ((List)localObject3).add(Integer.valueOf(1));
    ((List)localObject3).add(Integer.valueOf(2));
    ((List)localObject3).add(Integer.valueOf(3));
    localObject2 = new MusicMainUI.7(this, (com.tencent.mm.av.e)localObject2);
    com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView, localObject1, str1, str2 }, "", (h.c)localObject2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.mode = getIntent().getIntExtra("key_mode", 2);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.mzI = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.mBS = ((MusicViewPager)findViewById(a.d.view_pager));
    this.mBU = new b(this, this.scene, this.mzI);
    this.mBS.setAdapter(this.mBU);
    this.mBS.setOnPageChangeListener(this);
    this.mBS.setSystemUiVisibility(4096);
    this.mBP = ((ImageButton)findViewById(a.d.back_btn));
    this.mBQ = ((ImageButton)findViewById(a.d.send_btn));
    paramBundle = (RelativeLayout.LayoutParams)this.mBP.getLayoutParams();
    int j = paramBundle.topMargin;
    int i = j;
    if (ak.gC(this.mController.uMN)) {
      i = j + ak.gy(this.mController.uMN);
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.mBP.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.mBQ.getLayoutParams();
    j = paramBundle.topMargin;
    i = j;
    if (ak.gC(this.mController.uMN)) {
      i = j + ak.gy(this.mController.uMN);
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.mBQ.setLayoutParams(paramBundle);
    this.mBO = ((CheckBox)findViewById(a.d.music_play_btn));
    paramBundle = this.mBO;
    boolean bool;
    if (!k.bnl().bmY().Pu())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.mBT = new com.tencent.mm.pluginsdk.i.c(this);
      this.mBO.setOnClickListener(new MusicMainUI.1(this));
      com.tencent.mm.sdk.b.a.udP.c(this.giK);
      this.mBR = ((MusicSeekBar)findViewById(a.d.music_seek_bar));
      this.mBR.setOnSeekBarChange(new MusicMainUI.2(this));
      if (!this.mBT.clW()) {
        y.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      bnV();
      this.mBS.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bng() + 100000);
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bna();
      if (paramBundle != null)
      {
        y.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.h.nFQ.f(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bna();
      if (paramBundle != null) {
        break label649;
      }
      finish();
    }
    label649:
    do
    {
      return;
      bool = false;
      break;
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
      {
        i = g.DP().Dz().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, a.f.fts_search_enter_wording, 0).show();
          g.DP().Dz().o(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.d.a(0, paramBundle);
      }
      f(paramBundle);
    } while (this.mode != 1);
    if (this.mBX == null) {
      this.mBX = new Timer();
    }
    this.mBX.schedule(new TimerTask()
    {
      public final void run()
      {
        MusicMainUI.l(MusicMainUI.this).cy(0, 0);
      }
    }, 0L, 500L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mBT != null) {
      this.mBT.aFJ();
    }
    if (this.mBU != null)
    {
      Object localObject = this.mBU;
      ((b)localObject).mzt.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).mBw;
      ((com.tencent.mm.plugin.music.model.c)localObject).mzt.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.c)localObject).diW.clear();
    }
    if (this.mBR != null) {
      this.mBR.hU(false);
    }
    bnW();
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
    k.bnl().bmY().a(null);
    if (!k.bnl().bmY().Pu()) {
      k.bnl().bmY().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bnh();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mBT != null) {
      this.mBT.aFJ();
    }
    k.bnl().bmY().a(null);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bnb()) {
      if (!this.mzI)
      {
        if ((this.mBT != null) && (this.mBT.clW()) && (!this.mBT.clU())) {
          this.mBT.a(new MusicMainUI.b(this, (byte)0));
        }
        this.iam = bk.UZ();
      }
    }
    for (;;)
    {
      k.bnl().bmY().a(this.mxn);
      bnX();
      return;
      y.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bnd();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */