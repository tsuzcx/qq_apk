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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
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
  implements ViewPager.OnPageChangeListener, com.tencent.mm.ak.g
{
  private ao fpb;
  private com.tencent.mm.sdk.b.c kce;
  private long lastShakeTime;
  private int mode;
  private int scene;
  private int seS;
  private com.tencent.mm.pluginsdk.j.d shakeSensor;
  private com.tencent.mm.plugin.music.f.a.d.a vcY;
  private boolean vfK;
  private CheckBox vhY;
  private ImageButton vhZ;
  private ImageButton vib;
  private MusicSeekBar vic;
  private MusicViewPager vid;
  private b vie;
  private LinearLayout vif;
  private TextView vig;
  private ImageView vih;
  private ImageView vii;
  private boolean vij;
  private long vik;
  private long vil;
  private String vim;
  private boolean vin;
  private String vio;
  private String vip;
  private int viq;
  private Timer vir;
  private ao vis;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(63247);
    this.vik = 0L;
    this.vil = 0L;
    this.vin = false;
    this.vio = "";
    this.vip = "";
    this.viq = 0;
    this.kce = new com.tencent.mm.sdk.b.c() {};
    this.fpb = new ao(Looper.getMainLooper());
    this.seS = -1;
    this.vcY = new com.tencent.mm.plugin.music.f.a.d.a()
    {
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63244);
        if (MusicMainUI.j(MusicMainUI.this) == null)
        {
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {
            Assert.assertTrue("pager is null, err", false);
          }
          ac.w("MicroMsg.Music.MusicMainUI", "pager is null, return");
          AppMethodBeat.o(63244);
          return;
        }
        if ((MusicMainUI.n(MusicMainUI.this) == 1) && (!MusicMainUI.o(MusicMainUI.this)))
        {
          float f = MusicMainUI.this.getIntent().getFloatExtra("key_offset", 0.0F);
          long l = MusicMainUI.this.getIntent().getLongExtra("music_player_beg_time", 0L);
          l = (f * 1000.0F + (float)(System.currentTimeMillis() - l));
          if (l >= 0L) {
            MusicMainUI.j(MusicMainUI.this).ak(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), l + 200L);
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
            MusicMainUI.j(MusicMainUI.this).ak(MusicMainUI.k(MusicMainUI.this).getCurrentItem(), paramAnonymousInt1);
          }
        }
      }
    };
    this.vis = new ao(Looper.getMainLooper())
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
  
  private void bYp()
  {
    AppMethodBeat.i(63259);
    int i = k.diO().diB().dhO();
    int j = k.diO().diB().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.vic.setProgress(i);
      this.vic.setMaxProgress(j);
    }
    AppMethodBeat.o(63259);
  }
  
  private void djC()
  {
    AppMethodBeat.i(63251);
    this.vie.count = 200000;
    this.vie.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diL())
    {
      this.vid.setCanSlide(true);
      AppMethodBeat.o(63251);
      return;
    }
    this.vid.setCanSlide(false);
    AppMethodBeat.o(63251);
  }
  
  private void djD()
  {
    AppMethodBeat.i(63252);
    if (this.vir != null) {
      this.vir.cancel();
    }
    this.vir = null;
    AppMethodBeat.o(63252);
  }
  
  private void j(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63256);
    if ((com.tencent.mm.plugin.music.model.e.a(parama)) && (!this.vfK))
    {
      this.vhY.setVisibility(0);
      this.vib.setVisibility(0);
      AppMethodBeat.o(63256);
      return;
    }
    this.vhY.setVisibility(8);
    this.vib.setVisibility(8);
    AppMethodBeat.o(63256);
  }
  
  public int getLayoutId()
  {
    return 2131494985;
  }
  
  public final void k(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63260);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diD();
    if (locala == null)
    {
      AppMethodBeat.o(63260);
      return;
    }
    if ((locala.g(parama)) && (this.vib != null) && (this.vhZ != null) && (this.vhY != null) && (this.vib.getBackground() != null) && (this.vhZ.getBackground() != null) && (this.vhY.getBackground() != null) && (this.vic != null))
    {
      if (parama.djd())
      {
        int i = parama.field_songLyricColor;
        this.vib.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.vhZ.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.vhY.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.vic.setColor(i);
        this.vig.setTextColor(i);
        this.vii.getDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(63260);
        return;
      }
      this.vib.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.vhZ.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.vhY.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.vic.setColor(-1);
      this.vig.setTextColor(-1);
      this.vii.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }
    AppMethodBeat.o(63260);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63258);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      com.tencent.mm.ay.f localf = k.diO().diz();
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      paramIntent = new WXMusicObject();
      paramIntent.musicUrl = localf.hOa;
      paramIntent.musicDataUrl = localf.hNY;
      paramIntent.musicLowBandUrl = localf.hNZ;
      paramIntent.musicLowBandDataUrl = localf.hNZ;
      paramIntent.songAlbumUrl = localf.hOj;
      paramIntent.songLyric = localf.hOb;
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = paramIntent;
      localWXMediaMessage.title = localf.hNU;
      localWXMediaMessage.description = localf.hNV;
      Object localObject = null;
      String str2 = com.tencent.mm.plugin.music.model.e.y(localf);
      paramIntent = localObject;
      if (str2 != null)
      {
        paramIntent = localObject;
        if (i.eA(str2))
        {
          paramInt1 = (int)getResources().getDimension(2131165508);
          paramIntent = com.tencent.mm.sdk.platformtools.f.aI(str2, paramInt1, paramInt1);
        }
      }
      if (paramIntent != null)
      {
        localWXMediaMessage.thumbData = bs.aD(paramIntent);
        if (!com.tencent.mm.pluginsdk.model.app.h.aGe(com.tencent.mm.plugin.music.model.e.z(localf))) {
          break label270;
        }
      }
      label270:
      for (paramIntent = com.tencent.mm.plugin.music.model.e.z(localf);; paramIntent = "")
      {
        com.tencent.mm.plugin.music.model.c.iyx.a(this, paramIntent, localWXMediaMessage, str1, com.tencent.mm.plugin.music.model.e.A(localf));
        ac.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
        AppMethodBeat.o(63258);
        return;
        localWXMediaMessage.thumbData = bs.aD(com.tencent.mm.sdk.platformtools.f.Yo(2131231880));
        break;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(63258);
  }
  
  public void onClickBack(View paramView)
  {
    AppMethodBeat.i(63254);
    ac.i("MicroMsg.Music.MusicMainUI", "onClickBack finish");
    finish();
    AppMethodBeat.o(63254);
  }
  
  public void onClickSend(View paramView)
  {
    AppMethodBeat.i(63255);
    Object localObject2 = k.diO().diz();
    ac.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.ay.f)localObject2).hNQ), ((com.tencent.mm.ay.f)localObject2).hOa });
    final String str1;
    Object localObject1;
    final String str2;
    Object localObject3;
    if (((com.tencent.mm.ay.f)localObject2).hNQ == 11)
    {
      paramView = new hb();
      com.tencent.mm.sdk.b.a.GpY.l(paramView);
      str1 = paramView.dhZ.appId;
      localObject1 = paramView.dhZ.ddh;
      str2 = paramView.dhZ.dia;
      final int i = paramView.dhZ.dib;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      ac.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(2131760073, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).hOa))
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
          public final void kG(int paramAnonymousInt)
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
              com.tencent.mm.plugin.music.model.d.e.JT(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.JV(2);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.c(this.hNF, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.JU(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.JV(1);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.a(this.hNF, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.JV(3);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.Z(str1, str2, i);
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
        public final void kG(int paramAnonymousInt)
        {
          AppMethodBeat.i(63242);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63242);
            return;
            com.tencent.mm.plugin.music.model.e.Z(str1, str2, i);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.c)localObject1);
      AppMethodBeat.o(63255);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).hOa))
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
        public final void kG(int paramAnonymousInt)
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
            com.tencent.mm.plugin.music.model.d.e.JT(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.JV(2);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.c(this.hNF, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.JU(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.JV(1);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.a(this.hNF, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.JV(3);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.b(this.hNF, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.JV(4);
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
      ac.e("MicroMsg.Music.MusicMainUI", "MusicPlayerManager is not init!");
      AppMethodBeat.o(63248);
      return;
    }
    getWindow().setFlags(67109888, 67109888);
    this.mode = getIntent().getIntExtra("key_mode", 2);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.vfK = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.vid = ((MusicViewPager)findViewById(2131306432));
    this.vie = new b(this, this.scene, this.vfK);
    this.vid.setAdapter(this.vie);
    this.vid.setOnPageChangeListener(this);
    this.vid.setSystemUiVisibility(4096);
    this.vhZ = ((ImageButton)findViewById(2131297026));
    this.vib = ((ImageButton)findViewById(2131304562));
    paramBundle = (RelativeLayout.LayoutParams)this.vhZ.getLayoutParams();
    int j = paramBundle.topMargin;
    int i = j;
    if (aj.aG(getContext())) {
      i = j + aj.ji(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.vhZ.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.vib.getLayoutParams();
    j = paramBundle.topMargin;
    i = j;
    if (aj.aG(getContext())) {
      i = j + aj.ji(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.vib.setLayoutParams(paramBundle);
    this.vhY = ((CheckBox)findViewById(2131302614));
    paramBundle = this.vhY;
    boolean bool;
    if (!k.diO().diB().aGv())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.j.d();
      this.vhY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63228);
          MusicMainUI.a(MusicMainUI.this);
          if (MusicMainUI.b(MusicMainUI.this).isChecked())
          {
            com.tencent.mm.ay.a.aGr();
            MusicMainUI.b(MusicMainUI.this).setChecked(true);
            AppMethodBeat.o(63228);
            return;
          }
          MusicMainUI.c(MusicMainUI.this);
          if (k.diO().diB().aGx()) {
            k.diO().diB().resume();
          }
          for (;;)
          {
            MusicMainUI.b(MusicMainUI.this).setChecked(false);
            AppMethodBeat.o(63228);
            return;
            k.diO().s(null);
          }
        }
      });
      com.tencent.mm.sdk.b.a.GpY.c(this.kce);
      this.vic = ((MusicSeekBar)findViewById(2131302615));
      this.vic.setOnSeekBarChange(new MusicSeekBar.a()
      {
        public final void wa(int paramAnonymousInt)
        {
          AppMethodBeat.i(63231);
          com.tencent.mm.ay.a.pl(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).setProgress(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).id(true);
          AppMethodBeat.o(63231);
        }
      });
      this.vif = ((LinearLayout)findViewById(2131302618));
      this.vih = ((ImageView)findViewById(2131302605));
      this.vig = ((TextView)findViewById(2131300231));
      this.vii = ((ImageView)findViewById(2131300230));
      this.vif.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63232);
          MusicMainUI.e(MusicMainUI.this);
          AppMethodBeat.o(63232);
        }
      });
      this.vif.setVisibility(8);
      if (!this.shakeSensor.eMr()) {
        ac.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      djC();
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diD();
      if (paramBundle != null)
      {
        ac.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.h.wUl.f(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diD();
      if (paramBundle != null) {
        break label946;
      }
      String str = getIntent().getStringExtra("db_music_id");
      if (TextUtils.isEmpty(str)) {
        break label946;
      }
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).anD(str);
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
      this.vid.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diJ() + 100000);
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
      {
        i = com.tencent.mm.kernel.g.agR().agA().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, 2131759719, 0).show();
          com.tencent.mm.kernel.g.agR().agA().set(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
      }
      j(paramBundle);
      if (this.mode == 1)
      {
        if (this.vir == null) {
          this.vir = new Timer();
        }
        this.vir.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(63240);
            MusicMainUI.m(MusicMainUI.this).eV(0, 0);
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
      this.shakeSensor.bXB();
    }
    if (this.vie != null)
    {
      Object localObject = this.vie;
      ((b)localObject).vfv.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).vhI;
      ((com.tencent.mm.plugin.music.model.d)localObject).vfv.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.d)localObject).fnX.clear();
    }
    if (this.vic != null) {
      this.vic.id(false);
    }
    djD();
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    k.diO().diB().b(this.vcY);
    if (!k.diO().diB().aGv()) {
      k.diO().diB().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diK();
    AppMethodBeat.o(63253);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63257);
    ac.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diL()) {
      this.vid.setCanSlide(false);
    }
    this.fpb.removeCallbacksAndMessages(null);
    this.fpb.postDelayed(new a(paramInt), 500L);
    if (this.seS == -1) {
      this.seS = paramInt;
    }
    if (this.seS != paramInt)
    {
      this.seS = paramInt;
      com.tencent.mm.plugin.music.model.d.e.vgl = true;
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.gv(1, this.scene);
    }
    AppMethodBeat.o(63257);
  }
  
  public void onPause()
  {
    int k = 1;
    AppMethodBeat.i(63250);
    super.onPause();
    this.vil = System.currentTimeMillis();
    Object localObject2 = k.diO().diz();
    Object localObject1 = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diD();
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (this.shakeSensor != null) {
        this.shakeSensor.bXB();
      }
      k.diO().diB().b(this.vcY);
      AppMethodBeat.o(63250);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songLyric)) {}
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).hOt)) {
        this.vio = ((com.tencent.mm.ay.f)localObject2).hOt;
      }
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      long l1 = this.vik;
      long l2 = this.vil;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songName;
      String str1 = this.vim;
      int j;
      label160:
      int m;
      String str2;
      if (this.vin)
      {
        j = 1;
        m = ((com.tencent.mm.ay.f)localObject2).hNQ;
        localObject2 = this.vio;
        str2 = this.vip;
        if (this.scene != 9) {
          break label298;
        }
      }
      for (;;)
      {
        localh.f(17629, new Object[] { "", "", Long.valueOf(l1), Long.valueOf(l2), localObject1, Integer.valueOf(0), str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), localObject2, str2, Integer.valueOf(k) });
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
    this.vik = System.currentTimeMillis();
    this.vin = false;
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diE()) {
      if (!this.vfK)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.eMr()) && (!this.shakeSensor.eMp())) {
          this.shakeSensor.a(new b((byte)0));
        }
        this.lastShakeTime = bs.Gn();
      }
    }
    for (;;)
    {
      k.diO().diB().a(this.vcY);
      bYp();
      AppMethodBeat.o(63249);
      return;
      ac.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diG();
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
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).JK(this.position);
      com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diD();
      if (locala == null)
      {
        AppMethodBeat.o(63245);
        return;
      }
      if (locala.djd()) {
        MusicMainUI.this.k(locala);
      }
      if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diL()) {
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
      ac.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[] { Boolean.valueOf(paramBoolean) });
      long l = bs.aO(MusicMainUI.f(MusicMainUI.this));
      if (l < 1200L)
      {
        ac.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(63246);
        return;
      }
      ac.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(l)));
      MusicMainUI.a(MusicMainUI.this, bs.Gn());
      MusicMainUI.g(MusicMainUI.this);
      if (MusicMainUI.h(MusicMainUI.this) % 2 == 0) {
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).Ho(MusicMainUI.i(MusicMainUI.this));
      }
      AppMethodBeat.o(63246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */