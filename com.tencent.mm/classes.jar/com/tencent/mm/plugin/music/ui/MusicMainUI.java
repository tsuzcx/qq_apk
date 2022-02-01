package com.tencent.mm.plugin.music.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(16)
public class MusicMainUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener, com.tencent.mm.al.f
{
  private ap fHj;
  private com.tencent.mm.sdk.b.c kwD;
  private long lastShakeTime;
  private int mode;
  private int scene;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  private int tcO;
  private com.tencent.mm.plugin.music.f.a.d.a wiu;
  private boolean wlf;
  private TextView wnA;
  private ImageView wnB;
  private ImageView wnC;
  private boolean wnD;
  private long wnE;
  private long wnF;
  private String wnG;
  private boolean wnH;
  private String wnI;
  private String wnJ;
  private int wnK;
  private Timer wnL;
  private ap wnM;
  private CheckBox wnt;
  private ImageButton wnu;
  private ImageButton wnv;
  private MusicSeekBar wnw;
  private MusicViewPager wnx;
  private b wny;
  private LinearLayout wnz;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(63247);
    this.wnE = 0L;
    this.wnF = 0L;
    this.wnH = false;
    this.wnI = "";
    this.wnJ = "";
    this.wnK = 0;
    this.kwD = new com.tencent.mm.sdk.b.c() {};
    this.fHj = new ap(Looper.getMainLooper());
    this.tcO = -1;
    this.wiu = new com.tencent.mm.plugin.music.f.a.d.a()
    {
      public final void eZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63244);
        if (MusicMainUI.j(MusicMainUI.this) == null)
        {
          if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG)) {
            Assert.assertTrue("pager is null, err", false);
          }
          ad.w("MicroMsg.Music.MusicMainUI", "pager is null, return");
          AppMethodBeat.o(63244);
          return;
        }
        if ((MusicMainUI.n(MusicMainUI.this) == 1) && (!MusicMainUI.o(MusicMainUI.this)))
        {
          float f = MusicMainUI.this.getIntent().getFloatExtra("key_offset", 0.0F);
          long l = MusicMainUI.this.getIntent().getLongExtra("music_player_beg_time", 0L);
          l = (f * 1000.0F + (float)(System.currentTimeMillis() - l));
          if (l >= 0L) {
            MusicMainUI.j(MusicMainUI.this).ap(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), l + 200L);
          }
        }
        for (;;)
        {
          Message localMessage = new Message();
          localMessage.what = 1;
          MusicMainUI.p(MusicMainUI.this).sendMessage(localMessage);
          AppMethodBeat.o(63244);
          return;
          if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 > 0)) {
            MusicMainUI.j(MusicMainUI.this).ap(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), paramAnonymousInt1);
          }
        }
      }
    };
    this.wnM = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(63229);
        if (paramAnonymousMessage.what == 1) {
          MusicMainUI.q(MusicMainUI.this);
        }
        AppMethodBeat.o(63229);
      }
    };
    AppMethodBeat.o(63247);
  }
  
  private void ccT()
  {
    AppMethodBeat.i(63259);
    int i = k.dta().dsN().dsc();
    int j = k.dta().dsN().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.wnw.setProgress(i);
      this.wnw.setMaxProgress(j);
    }
    AppMethodBeat.o(63259);
  }
  
  private void dtO()
  {
    AppMethodBeat.i(63251);
    this.wny.count = 200000;
    this.wny.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsX())
    {
      this.wnx.setCanSlide(true);
      AppMethodBeat.o(63251);
      return;
    }
    this.wnx.setCanSlide(false);
    AppMethodBeat.o(63251);
  }
  
  private void dtP()
  {
    AppMethodBeat.i(63252);
    if (this.wnL != null) {
      this.wnL.cancel();
    }
    this.wnL = null;
    AppMethodBeat.o(63252);
  }
  
  private void j(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63256);
    if ((com.tencent.mm.plugin.music.model.e.a(parama)) && (!this.wlf))
    {
      this.wnt.setVisibility(0);
      this.wnv.setVisibility(0);
      AppMethodBeat.o(63256);
      return;
    }
    this.wnt.setVisibility(8);
    this.wnv.setVisibility(8);
    AppMethodBeat.o(63256);
  }
  
  public int getLayoutId()
  {
    return 2131494985;
  }
  
  public final void k(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63260);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsP();
    if (locala == null)
    {
      AppMethodBeat.o(63260);
      return;
    }
    if ((locala.g(parama)) && (this.wnv != null) && (this.wnu != null) && (this.wnt != null) && (this.wnv.getBackground() != null) && (this.wnu.getBackground() != null) && (this.wnt.getBackground() != null) && (this.wnw != null))
    {
      if (parama.dtp())
      {
        int i = parama.field_songLyricColor;
        this.wnv.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.wnu.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.wnt.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.wnw.setColor(i);
        this.wnA.setTextColor(i);
        this.wnC.getDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(63260);
        return;
      }
      this.wnv.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.wnu.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.wnt.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.wnw.setColor(-1);
      this.wnA.setTextColor(-1);
      this.wnC.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }
    AppMethodBeat.o(63260);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63258);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      com.tencent.mm.az.f localf = k.dta().dsL();
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      paramIntent = new WXMusicObject();
      paramIntent.musicUrl = localf.iho;
      paramIntent.musicDataUrl = localf.ihm;
      paramIntent.musicLowBandUrl = localf.ihn;
      paramIntent.musicLowBandDataUrl = localf.ihn;
      paramIntent.songAlbumUrl = localf.ihx;
      paramIntent.songLyric = localf.ihp;
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = paramIntent;
      localWXMediaMessage.title = localf.ihi;
      localWXMediaMessage.description = localf.ihj;
      Object localObject = null;
      String str2 = com.tencent.mm.plugin.music.model.e.y(localf);
      paramIntent = localObject;
      if (str2 != null)
      {
        paramIntent = localObject;
        if (com.tencent.mm.vfs.i.fv(str2))
        {
          paramInt1 = (int)getResources().getDimension(2131165508);
          paramIntent = com.tencent.mm.sdk.platformtools.g.aM(str2, paramInt1, paramInt1);
        }
      }
      if (paramIntent != null)
      {
        localWXMediaMessage.thumbData = bt.aF(paramIntent);
        if (!com.tencent.mm.pluginsdk.model.app.h.aLE(com.tencent.mm.plugin.music.model.e.z(localf))) {
          break label270;
        }
      }
      label270:
      for (paramIntent = com.tencent.mm.plugin.music.model.e.z(localf);; paramIntent = "")
      {
        com.tencent.mm.plugin.music.model.c.iRG.a(this, paramIntent, localWXMediaMessage, str1, com.tencent.mm.plugin.music.model.e.A(localf));
        ad.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
        AppMethodBeat.o(63258);
        return;
        localWXMediaMessage.thumbData = bt.aF(com.tencent.mm.sdk.platformtools.g.aat(2131231880));
        break;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(63258);
  }
  
  public void onClickBack(View paramView)
  {
    AppMethodBeat.i(63254);
    ad.i("MicroMsg.Music.MusicMainUI", "onClickBack finish");
    finish();
    AppMethodBeat.o(63254);
  }
  
  public void onClickSend(View paramView)
  {
    AppMethodBeat.i(63255);
    Object localObject2 = k.dta().dsL();
    ad.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.az.f)localObject2).ihe), ((com.tencent.mm.az.f)localObject2).iho });
    final String str1;
    Object localObject1;
    final String str2;
    Object localObject3;
    if (((com.tencent.mm.az.f)localObject2).ihe == 11)
    {
      paramView = new hf();
      com.tencent.mm.sdk.b.a.IbL.l(paramView);
      str1 = paramView.dtD.appId;
      localObject1 = paramView.dtD.doD;
      str2 = paramView.dtD.dtE;
      final int i = paramView.dtD.dtF;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      ad.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(2131760073, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.az.f)localObject2).iho))
      {
        ArrayList localArrayList = new ArrayList();
        localObject1 = getString(2131761477);
        localObject3 = getString(2131761478);
        String str3 = getString(2131757157);
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(3));
        localArrayList.add(Integer.valueOf(4));
        localObject2 = new h.c()
        {
          public final void lf(int paramAnonymousInt)
          {
            AppMethodBeat.i(63241);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.au(MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Lv(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.Lx(2);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.c(this.igT, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Lw(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.Lx(1);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.a(this.igT, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Lx(3);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.ac(str1, str2, i);
            }
          }
        };
        com.tencent.mm.ui.base.h.a(this, "", new String[] { localObject1, localObject3, str3, paramView }, "", (h.c)localObject2);
        AppMethodBeat.o(63255);
        return;
      }
      new ArrayList().add(Integer.valueOf(1));
      localObject1 = new h.c()
      {
        public final void lf(int paramAnonymousInt)
        {
          AppMethodBeat.i(63242);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63242);
            return;
            com.tencent.mm.plugin.music.model.e.ac(str1, str2, i);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.c)localObject1);
      AppMethodBeat.o(63255);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.az.f)localObject2).iho))
    {
      localObject3 = new ArrayList();
      paramView = getString(2131761477);
      localObject1 = getString(2131761478);
      str1 = getString(2131757157);
      str2 = getString(2131758843);
      ((List)localObject3).add(Integer.valueOf(0));
      ((List)localObject3).add(Integer.valueOf(2));
      ((List)localObject3).add(Integer.valueOf(3));
      ((List)localObject3).add(Integer.valueOf(4));
      localObject2 = new h.c()
      {
        public final void lf(int paramAnonymousInt)
        {
          AppMethodBeat.i(63243);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.au(MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Lv(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.Lx(2);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.c(this.igT, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Lw(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.Lx(1);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.a(this.igT, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Lx(3);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.b(this.igT, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Lx(4);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView, localObject1, str1, str2 }, "", (h.c)localObject2);
    }
    AppMethodBeat.o(63255);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63248);
    super.onCreate(paramBundle);
    hideTitleView();
    if (!k.isInit())
    {
      finish();
      ad.e("MicroMsg.Music.MusicMainUI", "MusicPlayerManager is not init!");
      AppMethodBeat.o(63248);
      return;
    }
    getWindow().setFlags(67109888, 67109888);
    this.mode = getIntent().getIntExtra("key_mode", 2);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.wlf = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.wnx = ((MusicViewPager)findViewById(2131306432));
    this.wny = new b(this, this.scene, this.wlf);
    this.wnx.setAdapter(this.wny);
    this.wnx.setOnPageChangeListener(this);
    this.wnx.setSystemUiVisibility(4096);
    this.wnu = ((ImageButton)findViewById(2131297026));
    this.wnv = ((ImageButton)findViewById(2131304562));
    paramBundle = (RelativeLayout.LayoutParams)this.wnu.getLayoutParams();
    int j = paramBundle.topMargin;
    int i = j;
    if (com.tencent.mm.ui.al.aG(getContext())) {
      i = j + com.tencent.mm.ui.al.jG(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.wnu.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.wnv.getLayoutParams();
    j = paramBundle.topMargin;
    i = j;
    if (com.tencent.mm.ui.al.aG(getContext())) {
      i = j + com.tencent.mm.ui.al.jG(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.wnv.setLayoutParams(paramBundle);
    this.wnt = ((CheckBox)findViewById(2131302614));
    paramBundle = this.wnt;
    boolean bool;
    if (!k.dta().dsN().aJG())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
      this.wnt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          MusicMainUI.a(MusicMainUI.this);
          if (MusicMainUI.b(MusicMainUI.this).isChecked())
          {
            com.tencent.mm.az.a.aJC();
            MusicMainUI.b(MusicMainUI.this).setChecked(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63228);
            return;
          }
          MusicMainUI.c(MusicMainUI.this);
          if (k.dta().dsN().aJI()) {
            k.dta().dsN().resume();
          }
          for (;;)
          {
            MusicMainUI.b(MusicMainUI.this).setChecked(false);
            break;
            k.dta().s(null);
          }
        }
      });
      com.tencent.mm.sdk.b.a.IbL.c(this.kwD);
      this.wnw = ((MusicSeekBar)findViewById(2131302615));
      this.wnw.setOnSeekBarChange(new MusicSeekBar.a()
      {
        public final void wF(int paramAnonymousInt)
        {
          AppMethodBeat.i(63231);
          com.tencent.mm.az.a.pO(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).setProgress(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).im(true);
          AppMethodBeat.o(63231);
        }
      });
      this.wnz = ((LinearLayout)findViewById(2131302618));
      this.wnB = ((ImageView)findViewById(2131302605));
      this.wnA = ((TextView)findViewById(2131300231));
      this.wnC = ((ImageView)findViewById(2131300230));
      this.wnz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63232);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          MusicMainUI.e(MusicMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63232);
        }
      });
      this.wnz.setVisibility(8);
      if (!this.shakeSensor.fbo()) {
        ad.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      dtO();
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsP();
      if (paramBundle != null)
      {
        ad.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.g.yhR.f(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsP();
      if (paramBundle != null) {
        break label946;
      }
      String str = getIntent().getStringExtra("db_music_id");
      if (TextUtils.isEmpty(str)) {
        break label946;
      }
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).asC(str);
    }
    label946:
    for (;;)
    {
      if (paramBundle == null)
      {
        finish();
        AppMethodBeat.o(63248);
        return;
        bool = false;
        break;
      }
      this.wnx.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsV() + 100000);
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
      {
        i = com.tencent.mm.kernel.g.ajC().ajl().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, 2131759719, 0).show();
          com.tencent.mm.kernel.g.ajC().ajl().set(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
      }
      j(paramBundle);
      if (this.mode == 1)
      {
        if (this.wnL == null) {
          this.wnL = new Timer();
        }
        this.wnL.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(63240);
            MusicMainUI.m(MusicMainUI.this).eZ(0, 0);
            AppMethodBeat.o(63240);
          }
        }, 0L, 500L);
      }
      AppMethodBeat.o(63248);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63253);
    super.onDestroy();
    if (this.shakeSensor != null) {
      this.shakeSensor.cce();
    }
    if (this.wny != null)
    {
      Object localObject = this.wny;
      ((b)localObject).wkQ.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).wnd;
      ((com.tencent.mm.plugin.music.model.d)localObject).wkQ.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.d)localObject).fGf.clear();
    }
    if (this.wnw != null) {
      this.wnw.im(false);
    }
    dtP();
    com.tencent.mm.sdk.b.a.IbL.d(this.kwD);
    k.dta().dsN().b(this.wiu);
    if (!k.dta().dsN().aJG()) {
      k.dta().dsN().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsW();
    AppMethodBeat.o(63253);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63257);
    ad.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsX()) {
      this.wnx.setCanSlide(false);
    }
    this.fHj.removeCallbacksAndMessages(null);
    this.fHj.postDelayed(new a(paramInt), 500L);
    if (this.tcO == -1) {
      this.tcO = paramInt;
    }
    if (this.tcO != paramInt)
    {
      this.tcO = paramInt;
      com.tencent.mm.plugin.music.model.d.e.wlG = true;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.gN(1, this.scene);
    }
    AppMethodBeat.o(63257);
  }
  
  public void onPause()
  {
    int k = 1;
    AppMethodBeat.i(63250);
    super.onPause();
    this.wnF = System.currentTimeMillis();
    Object localObject2 = k.dta().dsL();
    Object localObject1 = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsP();
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (this.shakeSensor != null) {
        this.shakeSensor.cce();
      }
      k.dta().dsN().b(this.wiu);
      AppMethodBeat.o(63250);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songLyric)) {}
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(((com.tencent.mm.az.f)localObject2).ihH)) {
        this.wnI = ((com.tencent.mm.az.f)localObject2).ihH;
      }
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
      long l1 = this.wnE;
      long l2 = this.wnF;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songName;
      String str1 = this.wnG;
      int j;
      label160:
      int m;
      String str2;
      if (this.wnH)
      {
        j = 1;
        m = ((com.tencent.mm.az.f)localObject2).ihe;
        localObject2 = this.wnI;
        str2 = this.wnJ;
        if (this.scene != 9) {
          break label298;
        }
      }
      for (;;)
      {
        localg.f(17629, new Object[] { "", "", Long.valueOf(l1), Long.valueOf(l2), localObject1, Integer.valueOf(0), str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), localObject2, str2, Integer.valueOf(k) });
        break;
        j = 0;
        break label160;
        label298:
        k = 0;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(63249);
    super.onResume();
    this.wnE = System.currentTimeMillis();
    this.wnH = false;
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsQ()) {
      if (!this.wlf)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.fbo()) && (!this.shakeSensor.fbm())) {
          this.shakeSensor.a(new b((byte)0));
        }
        this.lastShakeTime = bt.HI();
      }
    }
    for (;;)
    {
      k.dta().dsN().a(this.wiu);
      ccT();
      AppMethodBeat.o(63249);
      return;
      ad.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsS();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements Runnable
  {
    int position;
    
    public a(int paramInt)
    {
      this.position = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63245);
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).Lm(this.position);
      com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsP();
      if (locala == null)
      {
        AppMethodBeat.o(63245);
        return;
      }
      if (locala.dtp()) {
        MusicMainUI.this.k(locala);
      }
      if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsX()) {
        MusicMainUI.k(MusicMainUI.this).setCanSlide(true);
      }
      MusicMainUI.a(MusicMainUI.this, locala);
      AppMethodBeat.o(63245);
    }
  }
  
  final class b
    extends com.tencent.mm.pluginsdk.l.d.a
  {
    private b() {}
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(63246);
      ad.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[] { Boolean.valueOf(paramBoolean) });
      long l = bt.aO(MusicMainUI.f(MusicMainUI.this));
      if (l < 1200L)
      {
        ad.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(63246);
        return;
      }
      ad.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(l)));
      MusicMainUI.a(MusicMainUI.this, bt.HI());
      MusicMainUI.g(MusicMainUI.this);
      if (MusicMainUI.h(MusicMainUI.this) % 2 == 0) {
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).IK(MusicMainUI.i(MusicMainUI.this));
      }
      AppMethodBeat.o(63246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */