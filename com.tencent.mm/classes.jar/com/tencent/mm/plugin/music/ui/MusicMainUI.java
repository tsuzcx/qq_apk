package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.ho.a;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.mx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(32)
public class MusicMainUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener, com.tencent.mm.ak.i
{
  private com.tencent.mm.plugin.music.f.a.d.a AhI;
  private boolean AkV;
  private CheckBox AnB;
  private ImageButton AnC;
  private ImageButton AnD;
  private MusicSeekBar AnE;
  private MusicViewPager AnF;
  private b AnG;
  private LinearLayout AnH;
  private TextView AnI;
  private ImageView AnJ;
  private ImageView AnK;
  private boolean AnL;
  private long AnM;
  private long AnN;
  private String AnO;
  private boolean AnP;
  private String AnQ;
  private String AnR;
  private boolean AnS;
  private int AnT;
  private Timer AnU;
  private MMHandler AnV;
  private MMHandler goC;
  private IListener lEl;
  private long lastShakeTime;
  private int mode;
  private int scene;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  private int wAr;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(63247);
    this.AnM = 0L;
    this.AnN = 0L;
    this.AnP = false;
    this.AnQ = "";
    this.AnR = "";
    this.AnS = false;
    this.AnT = 0;
    this.lEl = new IListener() {};
    this.goC = new MMHandler(Looper.getMainLooper());
    this.wAr = -1;
    this.AhI = new com.tencent.mm.plugin.music.f.a.d.a()
    {
      public final void fn(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63244);
        if (MusicMainUI.j(MusicMainUI.this) == null)
        {
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
            Assert.assertTrue("pager is null, err", false);
          }
          Log.w("MicroMsg.Music.MusicMainUI", "pager is null, return");
          AppMethodBeat.o(63244);
          return;
        }
        if ((MusicMainUI.n(MusicMainUI.this) == 1) && (!MusicMainUI.o(MusicMainUI.this)))
        {
          float f = MusicMainUI.this.getIntent().getFloatExtra("key_offset", 0.0F);
          long l = MusicMainUI.this.getIntent().getLongExtra("music_player_beg_time", 0L);
          l = (f * 1000.0F + (float)(System.currentTimeMillis() - l));
          if (l >= 0L) {
            MusicMainUI.j(MusicMainUI.this).av(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), l + 200L);
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
            MusicMainUI.j(MusicMainUI.this).av(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), paramAnonymousInt1);
          }
        }
      }
    };
    this.AnV = new MMHandler(Looper.getMainLooper())
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
  
  private void cBY()
  {
    AppMethodBeat.i(63259);
    int i = k.euj().etW().etn();
    int j = k.euj().etW().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.AnE.setProgress(i);
      this.AnE.setMaxProgress(j);
    }
    AppMethodBeat.o(63259);
  }
  
  private void eB(View paramView)
  {
    AppMethodBeat.i(219882);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    int j = com.tencent.mm.ui.ao.getStatusBarHeight(getContext());
    localLayoutParams.setMargins(localLayoutParams.leftMargin, i + j, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(219882);
  }
  
  private void evl()
  {
    AppMethodBeat.i(63251);
    this.AnG.count = 200000;
    this.AnG.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).eug())
    {
      this.AnF.setCanSlide(true);
      AppMethodBeat.o(63251);
      return;
    }
    this.AnF.setCanSlide(false);
    AppMethodBeat.o(63251);
  }
  
  private void evm()
  {
    AppMethodBeat.i(63252);
    if (this.AnU != null) {
      this.AnU.cancel();
    }
    this.AnU = null;
    AppMethodBeat.o(63252);
  }
  
  private void k(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63256);
    if ((m.a(parama)) && (!this.AkV))
    {
      this.AnB.setVisibility(0);
      this.AnD.setVisibility(0);
      AppMethodBeat.o(63256);
      return;
    }
    this.AnB.setVisibility(4);
    this.AnD.setVisibility(4);
    AppMethodBeat.o(63256);
  }
  
  public int getLayoutId()
  {
    return 2131495778;
  }
  
  public final void l(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63260);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
    if (locala == null)
    {
      AppMethodBeat.o(63260);
      return;
    }
    if ((locala.h(parama)) && (this.AnD != null) && (this.AnC != null) && (this.AnB != null) && (this.AnD.getBackground() != null) && (this.AnC.getBackground() != null) && (this.AnB.getBackground() != null) && (this.AnE != null))
    {
      if (parama.euM())
      {
        int i = parama.field_songLyricColor;
        this.AnD.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.AnC.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.AnB.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.AnE.setColor(i);
        this.AnI.setTextColor(i);
        this.AnK.getDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(63260);
        return;
      }
      this.AnD.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.AnC.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.AnB.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.AnE.setColor(-1);
      this.AnI.setTextColor(-1);
      this.AnK.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }
    AppMethodBeat.o(63260);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63258);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      m.a(k.euj().etU(), paramIntent, this);
      AppMethodBeat.o(63258);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(63258);
  }
  
  public void onClickBack(View paramView)
  {
    AppMethodBeat.i(63254);
    Log.i("MicroMsg.Music.MusicMainUI", "onClickBack finish");
    finish();
    AppMethodBeat.o(63254);
  }
  
  public void onClickSend(View paramView)
  {
    AppMethodBeat.i(63255);
    Object localObject2 = k.euj().etU();
    Log.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.ay.f)localObject2).jeT), ((com.tencent.mm.ay.f)localObject2).jfd });
    final String str1;
    Object localObject1;
    final String str2;
    Object localObject3;
    if (((com.tencent.mm.ay.f)localObject2).jeT == 11)
    {
      paramView = new ho();
      EventCenter.instance.publish(paramView);
      str1 = paramView.dMd.appId;
      localObject1 = paramView.dMd.brandName;
      str2 = paramView.dMd.appUserName;
      final int i = paramView.dMd.dMe;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      Log.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(2131761451, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).jfd))
      {
        ArrayList localArrayList = new ArrayList();
        localObject1 = getString(2131763407);
        localObject3 = getString(2131763408);
        String str3 = getString(2131757361);
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(3));
        localArrayList.add(Integer.valueOf(4));
        localObject2 = new h.d()
        {
          public final void oj(int paramAnonymousInt)
          {
            AppMethodBeat.i(63241);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(63241);
              return;
              m.av(MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.SX(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.SZ(2);
              AppMethodBeat.o(63241);
              return;
              m.c(this.jeI, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.SY(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.SZ(1);
              AppMethodBeat.o(63241);
              return;
              m.a(this.jeI, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.SZ(3);
              AppMethodBeat.o(63241);
              return;
              m.ag(str1, str2, i);
            }
          }
        };
        com.tencent.mm.ui.base.h.a(this, "", new String[] { localObject1, localObject3, str3, paramView }, "", (h.d)localObject2);
        AppMethodBeat.o(63255);
        return;
      }
      new ArrayList().add(Integer.valueOf(1));
      localObject1 = new h.d()
      {
        public final void oj(int paramAnonymousInt)
        {
          AppMethodBeat.i(63242);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63242);
            return;
            m.ag(str1, str2, i);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.d)localObject1);
      AppMethodBeat.o(63255);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).jfd))
    {
      localObject3 = new ArrayList();
      paramView = getString(2131763407);
      localObject1 = getString(2131763408);
      str1 = getString(2131757361);
      str2 = getString(2131759166);
      ((List)localObject3).add(Integer.valueOf(0));
      ((List)localObject3).add(Integer.valueOf(2));
      ((List)localObject3).add(Integer.valueOf(3));
      ((List)localObject3).add(Integer.valueOf(4));
      localObject2 = new h.d()
      {
        public final void oj(int paramAnonymousInt)
        {
          AppMethodBeat.i(63243);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63243);
            return;
            m.av(MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.SX(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.SZ(2);
            AppMethodBeat.o(63243);
            return;
            m.c(this.jeI, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.SY(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.SZ(1);
            AppMethodBeat.o(63243);
            return;
            m.a(this.jeI, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.SZ(3);
            AppMethodBeat.o(63243);
            return;
            m.b(this.jeI, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.SZ(4);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView, localObject1, str1, str2 }, "", (h.d)localObject2);
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
      Log.e("MicroMsg.Music.MusicMainUI", "MusicPlayerManager is not init!");
      AppMethodBeat.o(63248);
      return;
    }
    this.mode = getIntent().getIntExtra("key_mode", 2);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.AkV = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.AnF = ((MusicViewPager)findViewById(2131309864));
    this.AnG = new b(this, this.scene, this.AkV);
    this.AnF.setAdapter(this.AnG);
    this.AnF.setOnPageChangeListener(this);
    this.AnF.setSystemUiVisibility(4096);
    this.AnC = ((ImageButton)findViewById(2131297163));
    this.AnD = ((ImageButton)findViewById(2131307604));
    if ((!this.AnS) && (com.tencent.mm.ui.ao.aQ(getContext())))
    {
      eB(this.AnC);
      eB(this.AnD);
      this.AnS = true;
    }
    this.AnB = ((CheckBox)findViewById(2131305109));
    paramBundle = this.AnB;
    boolean bool;
    int i;
    if (!k.euj().etW().bec())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
      this.AnB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MusicMainUI.a(MusicMainUI.this);
          if (MusicMainUI.b(MusicMainUI.this).isChecked())
          {
            com.tencent.mm.ay.a.bdY();
            MusicMainUI.b(MusicMainUI.this).setChecked(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63228);
            return;
          }
          MusicMainUI.c(MusicMainUI.this);
          if (k.euj().etW().bee()) {
            k.euj().etW().resume();
          }
          for (;;)
          {
            MusicMainUI.b(MusicMainUI.this).setChecked(false);
            break;
            k.euj().s(null);
          }
        }
      });
      EventCenter.instance.addListener(this.lEl);
      this.AnE = ((MusicSeekBar)findViewById(2131305110));
      this.AnE.setOnSeekBarChange(new MusicSeekBar.a()
      {
        public final void As(int paramAnonymousInt)
        {
          AppMethodBeat.i(63231);
          com.tencent.mm.ay.a.tG(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).setProgress(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).jl(true);
          AppMethodBeat.o(63231);
        }
      });
      this.AnH = ((LinearLayout)findViewById(2131305113));
      this.AnJ = ((ImageView)findViewById(2131305097));
      this.AnI = ((TextView)findViewById(2131301705));
      this.AnK = ((ImageView)findViewById(2131301704));
      this.AnH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63232);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MusicMainUI.e(MusicMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63232);
        }
      });
      this.AnH.setVisibility(8);
      if (!this.shakeSensor.gom()) {
        Log.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      evl();
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
      if (paramBundle != null)
      {
        Log.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.h.CyF.a(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
      if (paramBundle != null) {
        break label845;
      }
      String str = getIntent().getStringExtra("db_music_id");
      if (TextUtils.isEmpty(str)) {
        break label845;
      }
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).aHL(str);
    }
    label845:
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
      this.AnF.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).eue() + 100000);
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
      {
        i = g.aAh().azQ().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, 2131761040, 0).show();
          g.aAh().azQ().set(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
      }
      k(paramBundle);
      if (this.mode == 1)
      {
        if (this.AnU == null) {
          this.AnU = new Timer();
        }
        this.AnU.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(63240);
            MusicMainUI.m(MusicMainUI.this).fn(0, 0);
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
      this.shakeSensor.cBo();
    }
    if (this.AnG != null)
    {
      Object localObject = this.AnG;
      ((b)localObject).Aky.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).Ank;
      ((com.tencent.mm.plugin.music.model.i)localObject).Aky.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.i)localObject).gnw.clear();
    }
    if (this.AnE != null) {
      this.AnE.jl(false);
    }
    evm();
    EventCenter.instance.removeListener(this.lEl);
    k.euj().etW().c(this.AhI);
    if (!k.euj().etW().bec()) {
      k.euj().etW().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).euf();
    AppMethodBeat.o(63253);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63257);
    Log.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).eug()) {
      this.AnF.setCanSlide(false);
    }
    this.goC.removeCallbacksAndMessages(null);
    this.goC.postDelayed(new a(paramInt), 500L);
    if (this.wAr == -1) {
      this.wAr = paramInt;
    }
    if (this.wAr != paramInt)
    {
      this.wAr = paramInt;
      com.tencent.mm.plugin.music.model.d.e.Alx = true;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.hu(1, this.scene);
    }
    AppMethodBeat.o(63257);
  }
  
  public void onPause()
  {
    int k = 1;
    AppMethodBeat.i(63250);
    super.onPause();
    this.AnN = System.currentTimeMillis();
    Object localObject2 = k.euj().etU();
    Object localObject1 = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (this.shakeSensor != null) {
        this.shakeSensor.cBo();
      }
      k.euj().etW().c(this.AhI);
      AppMethodBeat.o(63250);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songLyric)) {}
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).jfw)) {
        this.AnQ = ((com.tencent.mm.ay.f)localObject2).jfw;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      long l1 = this.AnM;
      long l2 = this.AnN;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songName;
      String str1 = this.AnO;
      int j;
      label161:
      int m;
      String str2;
      if (this.AnP)
      {
        j = 1;
        m = ((com.tencent.mm.ay.f)localObject2).jeT;
        localObject2 = this.AnQ;
        str2 = this.AnR;
        if (this.scene != 9) {
          break label299;
        }
      }
      for (;;)
      {
        localh.a(17629, new Object[] { "", "", Long.valueOf(l1), Long.valueOf(l2), localObject1, Integer.valueOf(0), str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), localObject2, str2, Integer.valueOf(k) });
        break;
        j = 0;
        break label161;
        label299:
        k = 0;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(63249);
    super.onResume();
    this.AnM = System.currentTimeMillis();
    this.AnP = false;
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etZ()) {
      if (!this.AkV)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.gom()) && (!this.shakeSensor.gok())) {
          this.shakeSensor.a(new b((byte)0));
        }
        this.lastShakeTime = Util.currentTicks();
      }
    }
    for (;;)
    {
      k.euj().etW().b(this.AhI);
      cBY();
      AppMethodBeat.o(63249);
      return;
      Log.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).eub();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(219881);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      setActionbarColor(getContext().getResources().getColor(2131101287));
      hideActionbarLine();
      if (!this.AnS)
      {
        if (this.AnC != null) {
          eB(this.AnC);
        }
        if (this.AnD != null) {
          eB(this.AnD);
        }
        this.AnS = true;
      }
    }
    AppMethodBeat.o(219881);
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
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).SO(this.position);
      com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
      if (locala == null)
      {
        AppMethodBeat.o(63245);
        return;
      }
      if (locala.euM()) {
        MusicMainUI.this.l(locala);
      }
      if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).eug()) {
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
      Log.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[] { Boolean.valueOf(paramBoolean) });
      long l = Util.ticksToNow(MusicMainUI.f(MusicMainUI.this));
      if (l < 1200L)
      {
        Log.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(63246);
        return;
      }
      Log.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(l)));
      MusicMainUI.a(MusicMainUI.this, Util.currentTicks());
      MusicMainUI.g(MusicMainUI.this);
      if (MusicMainUI.h(MusicMainUI.this) % 2 == 0) {
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).Pl(MusicMainUI.i(MusicMainUI.this));
      }
      AppMethodBeat.o(63246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */