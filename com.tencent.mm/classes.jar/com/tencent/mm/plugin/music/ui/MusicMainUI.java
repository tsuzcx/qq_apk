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
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.gz.a;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ln.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.i;
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
  implements ViewPager.OnPageChangeListener, com.tencent.mm.al.g
{
  private ap flH;
  private com.tencent.mm.sdk.b.c jBI;
  private long lastShakeTime;
  private int mode;
  private int scene;
  private com.tencent.mm.pluginsdk.j.d shakeSensor;
  private com.tencent.mm.plugin.music.f.a.d.a tUq;
  private boolean tWZ;
  private ap tZA;
  private CheckBox tZg;
  private ImageButton tZh;
  private ImageButton tZi;
  private MusicSeekBar tZj;
  private MusicViewPager tZk;
  private b tZl;
  private LinearLayout tZm;
  private TextView tZn;
  private ImageView tZo;
  private ImageView tZp;
  private boolean tZq;
  private long tZr;
  private long tZs;
  private String tZt;
  private boolean tZu;
  private String tZv;
  private String tZw;
  private int tZx;
  private Timer tZy;
  private int tZz;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(63247);
    this.tZr = 0L;
    this.tZs = 0L;
    this.tZu = false;
    this.tZv = "";
    this.tZw = "";
    this.tZx = 0;
    this.jBI = new com.tencent.mm.sdk.b.c() {};
    this.flH = new ap(Looper.getMainLooper());
    this.tZz = -1;
    this.tUq = new com.tencent.mm.plugin.music.f.a.d.a()
    {
      public final void eS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63244);
        if (MusicMainUI.j(MusicMainUI.this) == null)
        {
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {
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
            MusicMainUI.j(MusicMainUI.this).am(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), l + 200L);
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
            MusicMainUI.j(MusicMainUI.this).am(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), paramAnonymousInt1);
          }
        }
      }
    };
    this.tZA = new ap(Looper.getMainLooper())
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
  
  private void bRa()
  {
    AppMethodBeat.i(63259);
    int i = k.cVi().cUV().cUi();
    int j = k.cVi().cUV().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.tZj.setProgress(i);
      this.tZj.setMaxProgress(j);
    }
    AppMethodBeat.o(63259);
  }
  
  private void cVU()
  {
    AppMethodBeat.i(63251);
    this.tZl.count = 200000;
    this.tZl.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cVf())
    {
      this.tZk.setCanSlide(true);
      AppMethodBeat.o(63251);
      return;
    }
    this.tZk.setCanSlide(false);
    AppMethodBeat.o(63251);
  }
  
  private void cVV()
  {
    AppMethodBeat.i(63252);
    if (this.tZy != null) {
      this.tZy.cancel();
    }
    this.tZy = null;
    AppMethodBeat.o(63252);
  }
  
  private void h(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63256);
    if ((com.tencent.mm.plugin.music.model.e.a(parama)) && (!this.tWZ))
    {
      this.tZg.setVisibility(0);
      this.tZi.setVisibility(0);
      AppMethodBeat.o(63256);
      return;
    }
    this.tZg.setVisibility(8);
    this.tZi.setVisibility(8);
    AppMethodBeat.o(63256);
  }
  
  public int getLayoutId()
  {
    return 2131494985;
  }
  
  public final void i(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63260);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUX();
    if (locala == null)
    {
      AppMethodBeat.o(63260);
      return;
    }
    if ((locala.g(parama)) && (this.tZi != null) && (this.tZh != null) && (this.tZg != null) && (this.tZi.getBackground() != null) && (this.tZh.getBackground() != null) && (this.tZg.getBackground() != null) && (this.tZj != null))
    {
      if (parama.cVx())
      {
        int i = parama.field_songLyricColor;
        this.tZi.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.tZh.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.tZg.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.tZj.setColor(i);
        this.tZn.setTextColor(i);
        this.tZp.getDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(63260);
        return;
      }
      this.tZi.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.tZh.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.tZg.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.tZj.setColor(-1);
      this.tZn.setTextColor(-1);
      this.tZp.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }
    AppMethodBeat.o(63260);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63258);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      com.tencent.mm.az.f localf = k.cVi().cUT();
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      paramIntent = new WXMusicObject();
      paramIntent.musicUrl = localf.hnx;
      paramIntent.musicDataUrl = localf.hnv;
      paramIntent.musicLowBandUrl = localf.hnw;
      paramIntent.musicLowBandDataUrl = localf.hnw;
      paramIntent.songAlbumUrl = localf.hnG;
      paramIntent.songLyric = localf.hny;
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = paramIntent;
      localWXMediaMessage.title = localf.hnr;
      localWXMediaMessage.description = localf.hns;
      Object localObject = null;
      String str2 = com.tencent.mm.plugin.music.model.e.x(localf);
      paramIntent = localObject;
      if (str2 != null)
      {
        paramIntent = localObject;
        if (i.eK(str2))
        {
          paramInt1 = (int)getResources().getDimension(2131165508);
          paramIntent = com.tencent.mm.sdk.platformtools.f.aF(str2, paramInt1, paramInt1);
        }
      }
      if (paramIntent != null)
      {
        localWXMediaMessage.thumbData = bt.aB(paramIntent);
        if (!com.tencent.mm.pluginsdk.model.app.h.aAM(com.tencent.mm.plugin.music.model.e.y(localf))) {
          break label270;
        }
      }
      label270:
      for (paramIntent = com.tencent.mm.plugin.music.model.e.y(localf);; paramIntent = "")
      {
        com.tencent.mm.plugin.music.model.c.hYt.a(this, paramIntent, localWXMediaMessage, str1, com.tencent.mm.plugin.music.model.e.z(localf));
        ad.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
        AppMethodBeat.o(63258);
        return;
        localWXMediaMessage.thumbData = bt.aB(com.tencent.mm.sdk.platformtools.f.Wf(2131231880));
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
    Object localObject2 = k.cVi().cUT();
    ad.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.az.f)localObject2).hnn), ((com.tencent.mm.az.f)localObject2).hnx });
    final String str1;
    Object localObject1;
    final String str2;
    Object localObject3;
    if (((com.tencent.mm.az.f)localObject2).hnn == 11)
    {
      paramView = new gz();
      com.tencent.mm.sdk.b.a.ESL.l(paramView);
      str1 = paramView.dkA.appId;
      localObject1 = paramView.dkA.dfM;
      str2 = paramView.dkA.dkB;
      final int i = paramView.dkA.dkC;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      ad.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(2131760073, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.az.f)localObject2).hnx))
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
          public final void kM(int paramAnonymousInt)
          {
            AppMethodBeat.i(63241);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.aq(MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.HU(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.HW(2);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.c(this.hnc, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.HV(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.HW(1);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.a(this.hnc, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.HW(3);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.Y(str1, str2, i);
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
        public final void kM(int paramAnonymousInt)
        {
          AppMethodBeat.i(63242);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63242);
            return;
            com.tencent.mm.plugin.music.model.e.Y(str1, str2, i);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.c)localObject1);
      AppMethodBeat.o(63255);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.az.f)localObject2).hnx))
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
        public final void kM(int paramAnonymousInt)
        {
          AppMethodBeat.i(63243);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.aq(MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.HU(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.HW(2);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.c(this.hnc, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.HV(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.HW(1);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.a(this.hnc, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.HW(3);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.b(this.hnc, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.HW(4);
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
    this.tWZ = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.tZk = ((MusicViewPager)findViewById(2131306432));
    this.tZl = new b(this, this.scene, this.tWZ);
    this.tZk.setAdapter(this.tZl);
    this.tZk.setOnPageChangeListener(this);
    this.tZk.setSystemUiVisibility(4096);
    this.tZh = ((ImageButton)findViewById(2131297026));
    this.tZi = ((ImageButton)findViewById(2131304562));
    paramBundle = (RelativeLayout.LayoutParams)this.tZh.getLayoutParams();
    int j = paramBundle.topMargin;
    int i = j;
    if (ai.aF(getContext())) {
      i = j + ai.iX(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.tZh.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.tZi.getLayoutParams();
    j = paramBundle.topMargin;
    i = j;
    if (ai.aF(getContext())) {
      i = j + ai.iX(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.tZi.setLayoutParams(paramBundle);
    this.tZg = ((CheckBox)findViewById(2131302614));
    paramBundle = this.tZg;
    boolean bool;
    if (!k.cVi().cUV().azF())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.j.d();
      this.tZg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63228);
          MusicMainUI.a(MusicMainUI.this);
          if (MusicMainUI.b(MusicMainUI.this).isChecked())
          {
            com.tencent.mm.az.a.azB();
            MusicMainUI.b(MusicMainUI.this).setChecked(true);
            AppMethodBeat.o(63228);
            return;
          }
          MusicMainUI.c(MusicMainUI.this);
          if (k.cVi().cUV().azH()) {
            k.cVi().cUV().resume();
          }
          for (;;)
          {
            MusicMainUI.b(MusicMainUI.this).setChecked(false);
            AppMethodBeat.o(63228);
            return;
            k.cVi().s(null);
          }
        }
      });
      com.tencent.mm.sdk.b.a.ESL.c(this.jBI);
      this.tZj = ((MusicSeekBar)findViewById(2131302615));
      this.tZj.setOnSeekBarChange(new MusicSeekBar.a()
      {
        public final void vj(int paramAnonymousInt)
        {
          AppMethodBeat.i(63231);
          com.tencent.mm.az.a.ox(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).setProgress(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).hE(true);
          AppMethodBeat.o(63231);
        }
      });
      this.tZm = ((LinearLayout)findViewById(2131302618));
      this.tZo = ((ImageView)findViewById(2131302605));
      this.tZn = ((TextView)findViewById(2131300231));
      this.tZp = ((ImageView)findViewById(2131300230));
      this.tZm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63232);
          MusicMainUI.e(MusicMainUI.this);
          AppMethodBeat.o(63232);
        }
      });
      this.tZm.setVisibility(8);
      if (!this.shakeSensor.ewX()) {
        ad.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      cVU();
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUX();
      if (paramBundle != null)
      {
        ad.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.h.vKh.f(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUX();
      if (paramBundle != null) {
        break label946;
      }
      String str = getIntent().getStringExtra("db_music_id");
      if (TextUtils.isEmpty(str)) {
        break label946;
      }
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).aiI(str);
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
      this.tZk.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cVd() + 100000);
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
      {
        i = com.tencent.mm.kernel.g.afB().afk().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, 2131759719, 0).show();
          com.tencent.mm.kernel.g.afB().afk().set(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
      }
      h(paramBundle);
      if (this.mode == 1)
      {
        if (this.tZy == null) {
          this.tZy = new Timer();
        }
        this.tZy.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(63240);
            MusicMainUI.m(MusicMainUI.this).eS(0, 0);
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
      this.shakeSensor.bQk();
    }
    if (this.tZl != null)
    {
      Object localObject = this.tZl;
      ((b)localObject).tWK.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).tYP;
      ((com.tencent.mm.plugin.music.model.d)localObject).tWK.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.d)localObject).fkD.clear();
    }
    if (this.tZj != null) {
      this.tZj.hE(false);
    }
    cVV();
    com.tencent.mm.sdk.b.a.ESL.d(this.jBI);
    k.cVi().cUV().a(null);
    if (!k.cVi().cUV().azF()) {
      k.cVi().cUV().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cVe();
    AppMethodBeat.o(63253);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63257);
    ad.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cVf()) {
      this.tZk.setCanSlide(false);
    }
    this.flH.removeCallbacksAndMessages(null);
    this.flH.postDelayed(new a(paramInt), 500L);
    if (this.tZz == -1) {
      this.tZz = paramInt;
    }
    if (this.tZz != paramInt)
    {
      this.tZz = paramInt;
      com.tencent.mm.plugin.music.model.d.e.tXz = true;
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.go(1, this.scene);
    }
    AppMethodBeat.o(63257);
  }
  
  public void onPause()
  {
    int k = 1;
    AppMethodBeat.i(63250);
    super.onPause();
    this.tZs = System.currentTimeMillis();
    Object localObject2 = k.cVi().cUT();
    Object localObject1 = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUX();
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (this.shakeSensor != null) {
        this.shakeSensor.bQk();
      }
      k.cVi().cUV().a(null);
      AppMethodBeat.o(63250);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songLyric)) {}
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(((com.tencent.mm.az.f)localObject2).hnQ)) {
        this.tZv = ((com.tencent.mm.az.f)localObject2).hnQ;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      long l1 = this.tZr;
      long l2 = this.tZs;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songName;
      String str1 = this.tZt;
      int j;
      label157:
      int m;
      String str2;
      if (this.tZu)
      {
        j = 1;
        m = ((com.tencent.mm.az.f)localObject2).hnn;
        localObject2 = this.tZv;
        str2 = this.tZw;
        if (this.scene != 9) {
          break label295;
        }
      }
      for (;;)
      {
        localh.f(17629, new Object[] { "", "", Long.valueOf(l1), Long.valueOf(l2), localObject1, Integer.valueOf(0), str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), localObject2, str2, Integer.valueOf(k) });
        break;
        j = 0;
        break label157;
        label295:
        k = 0;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(63249);
    super.onResume();
    this.tZr = System.currentTimeMillis();
    this.tZu = false;
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUY()) {
      if (!this.tWZ)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.ewX()) && (!this.shakeSensor.ewV())) {
          this.shakeSensor.a(new b((byte)0));
        }
        this.lastShakeTime = bt.GC();
      }
    }
    for (;;)
    {
      k.cVi().cUV().a(this.tUq);
      bRa();
      AppMethodBeat.o(63249);
      return;
      ad.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cVa();
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
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).HL(this.position);
      com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUX();
      if (locala == null)
      {
        AppMethodBeat.o(63245);
        return;
      }
      if (locala.cVx()) {
        MusicMainUI.this.i(locala);
      }
      if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cVf()) {
        MusicMainUI.k(MusicMainUI.this).setCanSlide(true);
      }
      MusicMainUI.a(MusicMainUI.this, locala);
      AppMethodBeat.o(63245);
    }
  }
  
  final class b
    extends com.tencent.mm.pluginsdk.j.d.a
  {
    private b() {}
    
    public final void onRelease() {}
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(63246);
      ad.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[] { Boolean.valueOf(paramBoolean) });
      long l = bt.aS(MusicMainUI.f(MusicMainUI.this));
      if (l < 1200L)
      {
        ad.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(63246);
        return;
      }
      ad.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(l)));
      MusicMainUI.a(MusicMainUI.this, bt.GC());
      MusicMainUI.g(MusicMainUI.this);
      if (MusicMainUI.h(MusicMainUI.this) % 2 == 0) {
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).Ft(MusicMainUI.i(MusicMainUI.this));
      }
      AppMethodBeat.o(63246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */