package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.hv;
import com.tencent.mm.f.a.hv.a;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.np.a;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.h;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(32)
public class MusicMainUI
  extends MMActivity
  implements ViewPager.OnPageChangeListener, com.tencent.mm.an.i
{
  private int BoC;
  private com.tencent.mm.plugin.music.f.a.d.a FOE;
  private boolean FSb;
  private CheckBox FUH;
  private ImageButton FUI;
  private ImageButton FUJ;
  private MusicSeekBar FUK;
  private MusicViewPager FUL;
  private b FUM;
  private LinearLayout FUN;
  private TextView FUO;
  private ImageView FUP;
  private ImageView FUQ;
  private boolean FUR;
  private long FUS;
  private long FUT;
  private String FUU;
  private boolean FUV;
  private String FUW;
  private String FUX;
  private boolean FUY;
  private int FUZ;
  private Future<?> FVa;
  private MMHandler FVb;
  private MMHandler iSL;
  private long lastShakeTime;
  private int mode;
  private IListener ozM;
  private int scene;
  private com.tencent.mm.pluginsdk.m.d shakeSensor;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(63247);
    this.FUS = 0L;
    this.FUT = 0L;
    this.FUV = false;
    this.FUW = "";
    this.FUX = "";
    this.FUY = false;
    this.FUZ = 0;
    this.ozM = new IListener() {};
    this.FVa = null;
    this.iSL = new MMHandler(Looper.getMainLooper());
    this.BoC = -1;
    this.FOE = new com.tencent.mm.plugin.music.f.a.d.a()
    {
      public final void fK(int paramAnonymousInt1, int paramAnonymousInt2)
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
            MusicMainUI.j(MusicMainUI.this).aE(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), l + 200L);
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
            MusicMainUI.j(MusicMainUI.this).aE(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), paramAnonymousInt1);
          }
        }
      }
    };
    this.FVb = new MMHandler(Looper.getMainLooper())
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
  
  private void cQC()
  {
    AppMethodBeat.i(63259);
    int i = k.fet().feg().fdx();
    int j = k.fet().feg().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.FUK.setProgress(i);
      this.FUK.setMaxProgress(j);
    }
    AppMethodBeat.o(63259);
  }
  
  private void fB(View paramView)
  {
    AppMethodBeat.i(259990);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    int j = ar.getStatusBarHeight(getContext());
    localLayoutParams.setMargins(localLayoutParams.leftMargin, i + j, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(259990);
  }
  
  private void ffE()
  {
    AppMethodBeat.i(63251);
    this.FUM.count = 200000;
    this.FUM.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).feq())
    {
      this.FUL.setCanSlide(true);
      AppMethodBeat.o(63251);
      return;
    }
    this.FUL.setCanSlide(false);
    AppMethodBeat.o(63251);
  }
  
  private void ffF()
  {
    AppMethodBeat.i(63252);
    if (this.FVa != null) {
      this.FVa.cancel(false);
    }
    this.FVa = null;
    AppMethodBeat.o(63252);
  }
  
  private void k(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63256);
    if ((m.a(parama)) && (!this.FSb))
    {
      this.FUH.setVisibility(0);
      this.FUJ.setVisibility(0);
      AppMethodBeat.o(63256);
      return;
    }
    this.FUH.setVisibility(4);
    this.FUJ.setVisibility(4);
    AppMethodBeat.o(63256);
  }
  
  public int getLayoutId()
  {
    return a.g.music_main_ui;
  }
  
  public final void l(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63260);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fei();
    if (locala == null)
    {
      AppMethodBeat.o(63260);
      return;
    }
    if ((locala.h(parama)) && (this.FUJ != null) && (this.FUI != null) && (this.FUH != null) && (this.FUJ.getBackground() != null) && (this.FUI.getBackground() != null) && (this.FUH.getBackground() != null) && (this.FUK != null))
    {
      if (parama.fff())
      {
        int i = parama.field_songLyricColor;
        this.FUJ.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.FUI.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.FUH.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.FUK.setColor(i);
        this.FUO.setTextColor(i);
        this.FUQ.getDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(63260);
        return;
      }
      this.FUJ.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.FUI.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.FUH.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.FUK.setColor(-1);
      this.FUO.setTextColor(-1);
      this.FUQ.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }
    AppMethodBeat.o(63260);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63258);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      m.a(k.fet().fed(), paramIntent, this);
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
    Object localObject2 = k.fet().fed();
    Log.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.bb.f)localObject2).lVr), ((com.tencent.mm.bb.f)localObject2).lVB });
    final String str1;
    Object localObject1;
    final String str2;
    Object localObject3;
    if (((com.tencent.mm.bb.f)localObject2).lVr == 11)
    {
      paramView = new hv();
      EventCenter.instance.publish(paramView);
      str1 = paramView.fER.appId;
      localObject1 = paramView.fER.fzM;
      str2 = paramView.fER.appUserName;
      final int i = paramView.fER.fES;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      Log.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(a.h.go_to_app_brand, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.bb.f)localObject2).lVB))
      {
        ArrayList localArrayList = new ArrayList();
        localObject1 = getString(a.h.music_send_to_friend);
        localObject3 = getString(a.h.music_share_timeline);
        String str3 = getString(a.h.chatting_fav);
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(3));
        localArrayList.add(Integer.valueOf(4));
        localObject2 = new h.d()
        {
          public final void qy(int paramAnonymousInt)
          {
            AppMethodBeat.i(63241);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(63241);
              return;
              m.aB(MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Zs(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.Zu(2);
              AppMethodBeat.o(63241);
              return;
              m.c(this.lVh, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Zt(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.Zu(1);
              AppMethodBeat.o(63241);
              return;
              m.a(this.lVh, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Zu(3);
              AppMethodBeat.o(63241);
              return;
              m.al(str1, str2, i);
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
        public final void qy(int paramAnonymousInt)
        {
          AppMethodBeat.i(63242);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63242);
            return;
            m.al(str1, str2, i);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.d)localObject1);
      AppMethodBeat.o(63255);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.bb.f)localObject2).lVB))
    {
      localObject3 = new ArrayList();
      paramView = getString(a.h.music_send_to_friend);
      localObject1 = getString(a.h.music_share_timeline);
      str1 = getString(a.h.chatting_fav);
      str2 = getString(a.h.fav_to_qq_music);
      ((List)localObject3).add(Integer.valueOf(0));
      ((List)localObject3).add(Integer.valueOf(2));
      ((List)localObject3).add(Integer.valueOf(3));
      ((List)localObject3).add(Integer.valueOf(4));
      localObject2 = new h.d()
      {
        public final void qy(int paramAnonymousInt)
        {
          AppMethodBeat.i(63243);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63243);
            return;
            m.aB(MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Zs(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.Zu(2);
            AppMethodBeat.o(63243);
            return;
            m.c(this.lVh, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Zt(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.Zu(1);
            AppMethodBeat.o(63243);
            return;
            m.a(this.lVh, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Zu(3);
            AppMethodBeat.o(63243);
            return;
            m.b(this.lVh, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Zu(4);
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
    this.FSb = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.FUL = ((MusicViewPager)findViewById(a.e.view_pager));
    this.FUM = new b(this, this.scene, this.FSb);
    this.FUL.setAdapter(this.FUM);
    this.FUL.setOnPageChangeListener(this);
    this.FUL.setSystemUiVisibility(4096);
    this.FUI = ((ImageButton)findViewById(a.e.back_btn));
    this.FUJ = ((ImageButton)findViewById(a.e.send_btn));
    if ((!this.FUY) && (ar.aN(getContext())))
    {
      fB(this.FUI);
      fB(this.FUJ);
      this.FUY = true;
    }
    this.FUH = ((CheckBox)findViewById(a.e.music_play_btn));
    paramBundle = this.FUH;
    boolean bool;
    int i;
    if (!k.fet().feg().bnx())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.m.d();
      this.FUH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          MusicMainUI.a(MusicMainUI.this);
          if (MusicMainUI.b(MusicMainUI.this).isChecked())
          {
            com.tencent.mm.bb.a.bnt();
            MusicMainUI.b(MusicMainUI.this).setChecked(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63228);
            return;
          }
          MusicMainUI.c(MusicMainUI.this);
          if (k.fet().feg().bnz()) {
            k.fet().feg().resume();
          }
          for (;;)
          {
            MusicMainUI.b(MusicMainUI.this).setChecked(false);
            break;
            k.fet().s(null);
          }
        }
      });
      EventCenter.instance.addListener(this.ozM);
      this.FUK = ((MusicSeekBar)findViewById(a.e.music_seek_bar));
      this.FUK.setOnSeekBarChange(new MusicSeekBar.a()
      {
        public final void DZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(63231);
          com.tencent.mm.bb.a.wG(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).setProgress(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).kw(true);
          AppMethodBeat.o(63231);
        }
      });
      this.FUN = ((LinearLayout)findViewById(a.e.music_source_layout));
      this.FUP = ((ImageView)findViewById(a.e.music_logo));
      this.FUO = ((TextView)findViewById(a.e.forward_to_tv));
      this.FUQ = ((ImageView)findViewById(a.e.forward_to_arrow));
      this.FUN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63232);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          MusicMainUI.e(MusicMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63232);
        }
      });
      this.FUN.setVisibility(8);
      if (!this.shakeSensor.hiW()) {
        Log.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      ffE();
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fei();
      if (paramBundle != null)
      {
        Log.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.h.IzE.a(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fei();
      if (paramBundle != null) {
        break label832;
      }
      String str = getIntent().getStringExtra("db_music_id");
      if (TextUtils.isEmpty(str)) {
        break label832;
      }
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).aSa(str);
    }
    label832:
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
      this.FUL.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).feo() + 100000);
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
      {
        i = com.tencent.mm.kernel.h.aHG().aHp().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, a.h.fts_search_enter_wording, 0).show();
          com.tencent.mm.kernel.h.aHG().aHp().i(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
      }
      k(paramBundle);
      if (this.mode == 1) {
        this.FVa = com.tencent.e.h.ZvG.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(63240);
            MusicMainUI.m(MusicMainUI.this).fK(0, 0);
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
      this.shakeSensor.cPS();
    }
    if (this.FUM != null)
    {
      Object localObject = this.FUM;
      ((b)localObject).FRC.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).FUr;
      ((com.tencent.mm.plugin.music.model.i)localObject).FRC.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.i)localObject).iRF.clear();
    }
    if (this.FUK != null) {
      this.FUK.kw(false);
    }
    ffF();
    EventCenter.instance.removeListener(this.ozM);
    k.fet().feg().b(this.FOE);
    if (!k.fet().feg().bnx()) {
      k.fet().feg().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fep();
    AppMethodBeat.o(63253);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63257);
    Log.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).feq()) {
      this.FUL.setCanSlide(false);
    }
    this.iSL.removeCallbacksAndMessages(null);
    this.iSL.postDelayed(new a(paramInt), 500L);
    if (this.BoC == -1) {
      this.BoC = paramInt;
    }
    if (this.BoC != paramInt)
    {
      this.BoC = paramInt;
      com.tencent.mm.plugin.music.model.d.e.FSE = true;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.iy(1, this.scene);
    }
    AppMethodBeat.o(63257);
  }
  
  public void onPause()
  {
    int k = 1;
    AppMethodBeat.i(63250);
    super.onPause();
    this.FUT = System.currentTimeMillis();
    Object localObject2 = k.fet().fed();
    Object localObject1 = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fei();
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (this.shakeSensor != null) {
        this.shakeSensor.cPS();
      }
      k.fet().feg().b(this.FOE);
      AppMethodBeat.o(63250);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songLyric)) {}
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(((com.tencent.mm.bb.f)localObject2).lVU)) {
        this.FUW = ((com.tencent.mm.bb.f)localObject2).lVU;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      long l1 = this.FUS;
      long l2 = this.FUT;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songName;
      String str1 = this.FUU;
      int j;
      label161:
      int m;
      String str2;
      if (this.FUV)
      {
        j = 1;
        m = ((com.tencent.mm.bb.f)localObject2).lVr;
        localObject2 = this.FUW;
        str2 = this.FUX;
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
    this.FUS = System.currentTimeMillis();
    this.FUV = false;
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fej()) {
      if (!this.FSb)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.hiW()) && (!this.shakeSensor.hiU())) {
          this.shakeSensor.a(new b((byte)0));
        }
        this.lastShakeTime = Util.currentTicks();
      }
    }
    for (;;)
    {
      k.fet().feg().a(this.FOE);
      cQC();
      AppMethodBeat.o(63249);
      return;
      Log.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fel();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(259989);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      setActionbarColor(getContext().getResources().getColor(a.b.transparent));
      hideActionbarLine();
      if (!this.FUY)
      {
        if (this.FUI != null) {
          fB(this.FUI);
        }
        if (this.FUJ != null) {
          fB(this.FUJ);
        }
        this.FUY = true;
      }
    }
    AppMethodBeat.o(259989);
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
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).Zk(this.position);
      com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fei();
      if (locala == null)
      {
        AppMethodBeat.o(63245);
        return;
      }
      if (locala.fff()) {
        MusicMainUI.this.l(locala);
      }
      if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).feq()) {
        MusicMainUI.k(MusicMainUI.this).setCanSlide(true);
      }
      MusicMainUI.a(MusicMainUI.this, locala);
      AppMethodBeat.o(63245);
    }
  }
  
  final class b
    extends com.tencent.mm.pluginsdk.m.d.a
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
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).Vu(MusicMainUI.i(MusicMainUI.this));
      }
      AppMethodBeat.o(63246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */