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
import androidx.lifecycle.q;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ig;
import com.tencent.mm.autogen.a.ig.a;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ox.a;
import com.tencent.mm.autogen.mmdata.rpt.my;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
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
  implements ViewPager.OnPageChangeListener, com.tencent.mm.am.h
{
  private int BuD;
  private com.tencent.mm.plugin.music.e.a.d.a LJz;
  private boolean LMW;
  private CheckBox LPH;
  private ImageButton LPI;
  private ImageButton LPJ;
  private MusicSeekBar LPK;
  private MusicViewPager LPL;
  private b LPM;
  private LinearLayout LPN;
  private TextView LPO;
  private ImageView LPP;
  private ImageView LPQ;
  private boolean LPR;
  private long LPS;
  private long LPT;
  private String LPU;
  private boolean LPV;
  private String LPW;
  private String LPX;
  private boolean LPY;
  private String LPZ;
  private int LQa;
  private Future<?> LQb;
  private MMHandler LQc;
  private long lastShakeTime;
  private MMHandler luI;
  private int mode;
  private IListener rDF;
  private int scene;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(63247);
    this.LPS = 0L;
    this.LPT = 0L;
    this.LPV = false;
    this.LPW = "";
    this.LPX = "";
    this.LPY = false;
    this.LQa = 0;
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    this.LQb = null;
    this.luI = new MMHandler(Looper.getMainLooper());
    this.BuD = -1;
    this.LJz = new com.tencent.mm.plugin.music.e.a.d.a()
    {
      public final void onProgress(int paramAnonymousInt1, int paramAnonymousInt2)
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
            MusicMainUI.j(MusicMainUI.this).aL(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), l + 200L);
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
            MusicMainUI.j(MusicMainUI.this).aL(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), paramAnonymousInt1);
          }
        }
      }
    };
    this.LQc = new MMHandler(Looper.getMainLooper())
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
  
  private void a(int paramInt, com.tencent.mm.aw.f paramf, boolean paramBoolean)
  {
    long l2 = 1L;
    AppMethodBeat.i(270964);
    my localmy = new my();
    localmy.ilm = paramInt;
    localmy.iOI = System.currentTimeMillis();
    localmy.vq(getIntent().getStringExtra("session_id"));
    if (m.G(paramf))
    {
      l1 = 1L;
      localmy.jcT = l1;
      paramf = localmy.vu(paramf.oOB).vr(paramf.oOx).vp(paramf.oOv).vs(paramf.oOy).vt(paramf.oOD);
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (long l1 = l2;; l1 = 2L)
    {
      paramf.jcR = l1;
      localmy.bMH();
      AppMethodBeat.o(270964);
      return;
      l1 = 3L;
      break;
    }
  }
  
  private void duV()
  {
    AppMethodBeat.i(63259);
    int i = j.gnw().gnj().gmA();
    int j = j.gnw().gnj().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.LPK.setProgress(i);
      this.LPK.setMaxProgress(j);
    }
    AppMethodBeat.o(63259);
  }
  
  private void goS()
  {
    AppMethodBeat.i(63251);
    this.LPM.count = 200000;
    this.LPM.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnt())
    {
      this.LPL.setCanSlide(true);
      AppMethodBeat.o(63251);
      return;
    }
    this.LPL.setCanSlide(false);
    AppMethodBeat.o(63251);
  }
  
  private void goT()
  {
    AppMethodBeat.i(63252);
    if (this.LQb != null) {
      this.LQb.cancel(false);
    }
    this.LQb = null;
    AppMethodBeat.o(63252);
  }
  
  private void io(View paramView)
  {
    AppMethodBeat.i(270953);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    int j = aw.getStatusBarHeight(getContext());
    localLayoutParams.setMargins(localLayoutParams.leftMargin, i + j, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(270953);
  }
  
  private void j(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63256);
    if ((m.a(parama)) && (!this.LMW))
    {
      this.LPH.setVisibility(0);
      this.LPJ.setVisibility(0);
      AppMethodBeat.o(63256);
      return;
    }
    this.LPH.setVisibility(4);
    this.LPJ.setVisibility(4);
    AppMethodBeat.o(63256);
  }
  
  public int getLayoutId()
  {
    return a.g.music_main_ui;
  }
  
  public final void k(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63260);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl();
    if (locala == null)
    {
      AppMethodBeat.o(63260);
      return;
    }
    if ((locala.i(parama)) && (this.LPJ != null) && (this.LPI != null) && (this.LPH != null) && (this.LPJ.getBackground() != null) && (this.LPI.getBackground() != null) && (this.LPH.getBackground() != null) && (this.LPK != null))
    {
      if (parama.goo())
      {
        int i = parama.field_songLyricColor;
        this.LPJ.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.LPI.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.LPH.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.LPK.setColor(i);
        this.LPO.setTextColor(i);
        this.LPQ.getDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(63260);
        return;
      }
      this.LPJ.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.LPI.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.LPH.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.LPK.setColor(-1);
      this.LPO.setTextColor(-1);
      this.LPQ.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }
    AppMethodBeat.o(63260);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63258);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      m.a(j.gnw().gng(), paramIntent, this);
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
    Object localObject2 = j.gnw().gng();
    Log.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.aw.f)localObject2).oOt), ((com.tencent.mm.aw.f)localObject2).oOD });
    final String str1;
    Object localObject1;
    final String str2;
    Object localObject3;
    if (((com.tencent.mm.aw.f)localObject2).oOt == 11)
    {
      paramView = new ig();
      paramView.publish();
      str1 = paramView.hJJ.appId;
      localObject1 = paramView.hJJ.hEy;
      str2 = paramView.hJJ.appUserName;
      final int i = paramView.hJJ.hJK;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      Log.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(a.h.go_to_app_brand, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.aw.f)localObject2).oOD))
      {
        ArrayList localArrayList = new ArrayList();
        localObject1 = getString(a.h.music_send_to_friend);
        localObject3 = getString(a.h.music_share_timeline);
        String str3 = getString(a.h.chatting_fav);
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(3));
        localArrayList.add(Integer.valueOf(4));
        localObject2 = new k.d()
        {
          public final void qz(int paramAnonymousInt)
          {
            AppMethodBeat.i(63241);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(63241);
              return;
              m.bc(MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.adF(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.adH(2);
              MusicMainUI.a(MusicMainUI.this, 254, this.oOj);
              AppMethodBeat.o(63241);
              return;
              m.c(this.oOj, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.adG(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.adH(1);
              MusicMainUI.a(MusicMainUI.this, 253, this.oOj);
              AppMethodBeat.o(63241);
              return;
              m.a(this.oOj, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.adH(3);
              MusicMainUI.a(MusicMainUI.this, 255, this.oOj);
              AppMethodBeat.o(63241);
              return;
              m.at(str1, str2, i);
            }
          }
        };
        k.a(this, "", new String[] { localObject1, localObject3, str3, paramView }, "", (k.d)localObject2);
        AppMethodBeat.o(63255);
        return;
      }
      new ArrayList().add(Integer.valueOf(1));
      localObject1 = new k.d()
      {
        public final void qz(int paramAnonymousInt)
        {
          AppMethodBeat.i(63242);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63242);
            return;
            m.at(str1, str2, i);
          }
        }
      };
      k.a(this, "", new String[] { paramView }, "", (k.d)localObject1);
      AppMethodBeat.o(63255);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.aw.f)localObject2).oOD))
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
      localObject2 = new k.d()
      {
        public final void qz(int paramAnonymousInt)
        {
          AppMethodBeat.i(63243);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63243);
            return;
            m.bc(MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.adF(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.adH(2);
            AppMethodBeat.o(63243);
            return;
            m.c(this.oOj, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.adG(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.adH(1);
            AppMethodBeat.o(63243);
            return;
            m.a(this.oOj, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.adH(3);
            AppMethodBeat.o(63243);
            return;
            m.b(this.oOj, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.adH(4);
          }
        }
      };
      k.a(this, "", new String[] { paramView, localObject1, str1, str2 }, "", (k.d)localObject2);
    }
    AppMethodBeat.o(63255);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63248);
    super.onCreate(paramBundle);
    this.LPZ = getIntent().getStringExtra("session_id");
    hideTitleView();
    if (!j.isInit())
    {
      finish();
      Log.e("MicroMsg.Music.MusicMainUI", "MusicPlayerManager is not init!");
      AppMethodBeat.o(63248);
      return;
    }
    this.mode = getIntent().getIntExtra("key_mode", 2);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.LMW = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.LPL = ((MusicViewPager)findViewById(a.e.view_pager));
    this.LPM = new b(this, this.scene, this.LMW);
    this.LPL.setAdapter(this.LPM);
    this.LPL.setOnPageChangeListener(this);
    this.LPL.setSystemUiVisibility(4096);
    this.LPI = ((ImageButton)findViewById(a.e.back_btn));
    this.LPJ = ((ImageButton)findViewById(a.e.send_btn));
    if ((!this.LPY) && (aw.bx(getContext())))
    {
      io(this.LPI);
      io(this.LPJ);
      this.LPY = true;
    }
    this.LPH = ((CheckBox)findViewById(a.e.music_play_btn));
    paramBundle = this.LPH;
    boolean bool;
    int i;
    if (!j.gnw().gnj().bLk())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
      this.LPH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          MusicMainUI.a(MusicMainUI.this);
          if (MusicMainUI.b(MusicMainUI.this).isChecked())
          {
            com.tencent.mm.aw.a.bLg();
            MusicMainUI.b(MusicMainUI.this).setChecked(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63228);
            return;
          }
          MusicMainUI.c(MusicMainUI.this);
          if (j.gnw().gnj().bLm()) {
            j.gnw().gnj().resume();
          }
          for (;;)
          {
            MusicMainUI.b(MusicMainUI.this).setChecked(false);
            break;
            j.gnw().w(null);
          }
        }
      });
      this.rDF.alive();
      this.LPK = ((MusicSeekBar)findViewById(a.e.music_seek_bar));
      this.LPK.setOnSeekBarChange(new MusicSeekBar.a()
      {
        public final void Ez(int paramAnonymousInt)
        {
          AppMethodBeat.i(63231);
          com.tencent.mm.aw.a.wH(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).setProgress(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).lI(true);
          AppMethodBeat.o(63231);
        }
      });
      this.LPN = ((LinearLayout)findViewById(a.e.music_source_layout));
      this.LPP = ((ImageView)findViewById(a.e.music_logo));
      this.LPO = ((TextView)findViewById(a.e.forward_to_tv));
      this.LPQ = ((ImageView)findViewById(a.e.forward_to_arrow));
      this.LPN.setOnClickListener(new MusicMainUI.6(this));
      this.LPN.setVisibility(8);
      if (!this.shakeSensor.hdE()) {
        Log.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      goS();
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl();
      if (paramBundle != null)
      {
        Log.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.h.OAn.b(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl();
      if (paramBundle != null) {
        break label843;
      }
      String str = getIntent().getStringExtra("db_music_id");
      if (TextUtils.isEmpty(str)) {
        break label843;
      }
      paramBundle = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).aOS(str);
    }
    label843:
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
      this.LPL.setCurrentItem(((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnr() + 100000);
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).getMode() == 2))
      {
        i = com.tencent.mm.kernel.h.baE().ban().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, a.h.fts_search_enter_wording, 0).show();
          com.tencent.mm.kernel.h.baE().ban().B(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
      }
      j(paramBundle);
      if (this.mode == 1) {
        this.LQb = com.tencent.threadpool.h.ahAA.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(63240);
            MusicMainUI.m(MusicMainUI.this).onProgress(0, 0);
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
      this.shakeSensor.cuD();
    }
    if (this.LPM != null)
    {
      Object localObject = this.LPM;
      ((b)localObject).LMx.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).LPr;
      ((com.tencent.mm.plugin.music.model.i)localObject).LMx.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.i)localObject).ltC.clear();
    }
    if (this.LPK != null) {
      this.LPK.lI(false);
    }
    goT();
    this.rDF.dead();
    j.gnw().gnj().b(this.LJz);
    if (!j.gnw().gnj().bLk()) {
      j.gnw().gnj().stopPlay();
    }
    ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gns();
    AppMethodBeat.o(63253);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63257);
    Log.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnt()) {
      this.LPL.setCanSlide(false);
    }
    this.luI.removeCallbacksAndMessages(null);
    this.luI.postDelayed(new a(paramInt), 500L);
    if (this.BuD == -1) {
      this.BuD = paramInt;
    }
    if (this.BuD != paramInt)
    {
      this.BuD = paramInt;
      com.tencent.mm.plugin.music.model.d.e.LNA = true;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.kc(1, this.scene);
    }
    AppMethodBeat.o(63257);
  }
  
  public void onPause()
  {
    int k = 1;
    AppMethodBeat.i(63250);
    super.onPause();
    this.LPT = System.currentTimeMillis();
    Object localObject2 = j.gnw().gng();
    Object localObject1 = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl();
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (this.shakeSensor != null) {
        this.shakeSensor.cuD();
      }
      j.gnw().gnj().b(this.LJz);
      AppMethodBeat.o(63250);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songLyric)) {}
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(((com.tencent.mm.aw.f)localObject2).oOW)) {
        this.LPW = ((com.tencent.mm.aw.f)localObject2).oOW;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      long l1 = this.LPS;
      long l2 = this.LPT;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songName;
      String str1 = this.LPU;
      int j;
      label161:
      int m;
      String str2;
      if (this.LPV)
      {
        j = 1;
        m = ((com.tencent.mm.aw.f)localObject2).oOt;
        localObject2 = this.LPW;
        str2 = this.LPX;
        if (this.scene != 9) {
          break label299;
        }
      }
      for (;;)
      {
        localh.b(17629, new Object[] { "", "", Long.valueOf(l1), Long.valueOf(l2), localObject1, Integer.valueOf(0), str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), localObject2, str2, Integer.valueOf(k) });
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
    this.LPS = System.currentTimeMillis();
    this.LPV = false;
    if (((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnm()) {
      if (!this.LMW)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.hdE()) && (!this.shakeSensor.hdD())) {
          this.shakeSensor.a(new b((byte)0));
        }
        this.lastShakeTime = Util.currentTicks();
      }
    }
    for (;;)
    {
      j.gnw().gnj().a(this.LJz);
      duV();
      AppMethodBeat.o(63249);
      return;
      Log.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gno();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(271085);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      setActionbarColor(getContext().getResources().getColor(a.b.transparent));
      hideActionbarLine();
      if (!this.LPY)
      {
        if (this.LPI != null) {
          io(this.LPI);
        }
        if (this.LPJ != null) {
          io(this.LPJ);
        }
        this.LPY = true;
      }
    }
    AppMethodBeat.o(271085);
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
      ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).adw(this.position);
      com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl();
      if (locala == null)
      {
        AppMethodBeat.o(63245);
        return;
      }
      if (locala.goo()) {
        MusicMainUI.this.k(locala);
      }
      if (((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnt()) {
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
        ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).Zp(MusicMainUI.i(MusicMainUI.this));
      }
      AppMethodBeat.o(63246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */