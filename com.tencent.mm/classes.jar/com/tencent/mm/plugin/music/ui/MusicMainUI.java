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
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hg.a;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mg.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.o;
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
  implements ViewPager.OnPageChangeListener, com.tencent.mm.ak.f
{
  private aq fJn;
  private com.tencent.mm.sdk.b.c kzS;
  private long lastShakeTime;
  private int mode;
  private int scene;
  private com.tencent.mm.pluginsdk.l.d shakeSensor;
  private int tnI;
  private boolean wAO;
  private CheckBox wDc;
  private ImageButton wDd;
  private ImageButton wDe;
  private MusicSeekBar wDf;
  private MusicViewPager wDg;
  private b wDh;
  private LinearLayout wDi;
  private TextView wDj;
  private ImageView wDk;
  private ImageView wDl;
  private boolean wDm;
  private long wDn;
  private long wDo;
  private String wDp;
  private boolean wDq;
  private String wDr;
  private String wDs;
  private int wDt;
  private Timer wDu;
  private aq wDv;
  private com.tencent.mm.plugin.music.f.a.d.a wxZ;
  
  public MusicMainUI()
  {
    AppMethodBeat.i(63247);
    this.wDn = 0L;
    this.wDo = 0L;
    this.wDq = false;
    this.wDr = "";
    this.wDs = "";
    this.wDt = 0;
    this.kzS = new com.tencent.mm.sdk.b.c() {};
    this.fJn = new aq(Looper.getMainLooper());
    this.tnI = -1;
    this.wxZ = new com.tencent.mm.plugin.music.f.a.d.a()
    {
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63244);
        if (MusicMainUI.j(MusicMainUI.this) == null)
        {
          if ((j.IS_FLAVOR_RED) || (j.DEBUG)) {
            Assert.assertTrue("pager is null, err", false);
          }
          ae.w("MicroMsg.Music.MusicMainUI", "pager is null, return");
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
    this.wDv = new aq(Looper.getMainLooper())
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
  
  private void cei()
  {
    AppMethodBeat.i(63259);
    int i = k.dwp().dwc().dvr();
    int j = k.dwp().dwc().getDuration();
    if ((i > 0) && (j > 0))
    {
      this.wDf.setProgress(i);
      this.wDf.setMaxProgress(j);
    }
    AppMethodBeat.o(63259);
  }
  
  private void dxd()
  {
    AppMethodBeat.i(63251);
    this.wDh.count = 200000;
    this.wDh.notifyDataSetChanged();
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwm())
    {
      this.wDg.setCanSlide(true);
      AppMethodBeat.o(63251);
      return;
    }
    this.wDg.setCanSlide(false);
    AppMethodBeat.o(63251);
  }
  
  private void dxe()
  {
    AppMethodBeat.i(63252);
    if (this.wDu != null) {
      this.wDu.cancel();
    }
    this.wDu = null;
    AppMethodBeat.o(63252);
  }
  
  private void j(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63256);
    if ((com.tencent.mm.plugin.music.model.e.a(parama)) && (!this.wAO))
    {
      this.wDc.setVisibility(0);
      this.wDe.setVisibility(0);
      AppMethodBeat.o(63256);
      return;
    }
    this.wDc.setVisibility(8);
    this.wDe.setVisibility(8);
    AppMethodBeat.o(63256);
  }
  
  public int getLayoutId()
  {
    return 2131494985;
  }
  
  public final void k(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63260);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
    if (locala == null)
    {
      AppMethodBeat.o(63260);
      return;
    }
    if ((locala.g(parama)) && (this.wDe != null) && (this.wDd != null) && (this.wDc != null) && (this.wDe.getBackground() != null) && (this.wDd.getBackground() != null) && (this.wDc.getBackground() != null) && (this.wDf != null))
    {
      if (parama.dwE())
      {
        int i = parama.field_songLyricColor;
        this.wDe.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.wDd.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.wDc.getBackground().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        this.wDf.setColor(i);
        this.wDj.setTextColor(i);
        this.wDl.getDrawable().setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(63260);
        return;
      }
      this.wDe.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.wDd.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.wDc.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      this.wDf.setColor(-1);
      this.wDj.setTextColor(-1);
      this.wDl.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }
    AppMethodBeat.o(63260);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63258);
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      com.tencent.mm.ay.f localf = k.dwp().dwa();
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      paramIntent = new WXMusicObject();
      paramIntent.musicUrl = localf.ikh;
      paramIntent.musicDataUrl = localf.ikf;
      paramIntent.musicLowBandUrl = localf.ikg;
      paramIntent.musicLowBandDataUrl = localf.ikg;
      paramIntent.songAlbumUrl = localf.ikq;
      paramIntent.songLyric = localf.iki;
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = paramIntent;
      localWXMediaMessage.title = localf.ikb;
      localWXMediaMessage.description = localf.ikc;
      Object localObject = null;
      String str2 = com.tencent.mm.plugin.music.model.e.y(localf);
      paramIntent = localObject;
      if (str2 != null)
      {
        paramIntent = localObject;
        if (o.fB(str2))
        {
          paramInt1 = (int)getResources().getDimension(2131165508);
          paramIntent = com.tencent.mm.sdk.platformtools.h.aO(str2, paramInt1, paramInt1);
        }
      }
      if (paramIntent != null)
      {
        localWXMediaMessage.thumbData = bu.aG(paramIntent);
        if (!com.tencent.mm.pluginsdk.model.app.h.aNa(com.tencent.mm.plugin.music.model.e.z(localf))) {
          break label270;
        }
      }
      label270:
      for (paramIntent = com.tencent.mm.plugin.music.model.e.z(localf);; paramIntent = "")
      {
        com.tencent.mm.plugin.music.model.c.iUz.a(this, paramIntent, localWXMediaMessage, str1, com.tencent.mm.plugin.music.model.e.A(localf));
        ae.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
        AppMethodBeat.o(63258);
        return;
        localWXMediaMessage.thumbData = bu.aG(com.tencent.mm.sdk.platformtools.h.aaZ(2131231880));
        break;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(63258);
  }
  
  public void onClickBack(View paramView)
  {
    AppMethodBeat.i(63254);
    ae.i("MicroMsg.Music.MusicMainUI", "onClickBack finish");
    finish();
    AppMethodBeat.o(63254);
  }
  
  public void onClickSend(View paramView)
  {
    AppMethodBeat.i(63255);
    Object localObject2 = k.dwp().dwa();
    ae.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[] { Integer.valueOf(((com.tencent.mm.ay.f)localObject2).ijX), ((com.tencent.mm.ay.f)localObject2).ikh });
    final String str1;
    Object localObject1;
    final String str2;
    Object localObject3;
    if (((com.tencent.mm.ay.f)localObject2).ijX == 11)
    {
      paramView = new hg();
      com.tencent.mm.sdk.b.a.IvT.l(paramView);
      str1 = paramView.duI.appId;
      localObject1 = paramView.duI.dpI;
      str2 = paramView.duI.duJ;
      final int i = paramView.duI.duK;
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "";
      }
      ae.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { str1, paramView, Integer.valueOf(i), str2 });
      paramView = getString(2131760073, new Object[] { paramView });
      if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).ikh))
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
          public final void lh(int paramAnonymousInt)
          {
            AppMethodBeat.i(63241);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.av(MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Ma(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.Mc(2);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.c(this.ijM, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Mb(MusicMainUI.i(MusicMainUI.this));
              com.tencent.mm.plugin.music.model.d.e.Mc(1);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.a(this.ijM, MusicMainUI.this);
              com.tencent.mm.plugin.music.model.d.e.Mc(3);
              AppMethodBeat.o(63241);
              return;
              com.tencent.mm.plugin.music.model.e.ad(str1, str2, i);
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
        public final void lh(int paramAnonymousInt)
        {
          AppMethodBeat.i(63242);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63242);
            return;
            com.tencent.mm.plugin.music.model.e.ad(str1, str2, i);
          }
        }
      };
      com.tencent.mm.ui.base.h.a(this, "", new String[] { paramView }, "", (h.c)localObject1);
      AppMethodBeat.o(63255);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).ikh))
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
        public final void lh(int paramAnonymousInt)
        {
          AppMethodBeat.i(63243);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.av(MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Ma(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.Mc(2);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.c(this.ijM, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Mb(MusicMainUI.i(MusicMainUI.this));
            com.tencent.mm.plugin.music.model.d.e.Mc(1);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.a(this.ijM, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Mc(3);
            AppMethodBeat.o(63243);
            return;
            com.tencent.mm.plugin.music.model.e.b(this.ijM, MusicMainUI.this);
            com.tencent.mm.plugin.music.model.d.e.Mc(4);
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
      ae.e("MicroMsg.Music.MusicMainUI", "MusicPlayerManager is not init!");
      AppMethodBeat.o(63248);
      return;
    }
    getWindow().setFlags(67109888, 67109888);
    this.mode = getIntent().getIntExtra("key_mode", 2);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.wAO = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
    this.wDg = ((MusicViewPager)findViewById(2131306432));
    this.wDh = new b(this, this.scene, this.wAO);
    this.wDg.setAdapter(this.wDh);
    this.wDg.setOnPageChangeListener(this);
    this.wDg.setSystemUiVisibility(4096);
    this.wDd = ((ImageButton)findViewById(2131297026));
    this.wDe = ((ImageButton)findViewById(2131304562));
    paramBundle = (RelativeLayout.LayoutParams)this.wDd.getLayoutParams();
    int j = paramBundle.topMargin;
    int i = j;
    if (com.tencent.mm.ui.al.aH(getContext())) {
      i = j + com.tencent.mm.ui.al.jN(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.wDd.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.wDe.getLayoutParams();
    j = paramBundle.topMargin;
    i = j;
    if (com.tencent.mm.ui.al.aH(getContext())) {
      i = j + com.tencent.mm.ui.al.jN(getContext());
    }
    paramBundle.setMargins(paramBundle.leftMargin, i, paramBundle.rightMargin, paramBundle.bottomMargin);
    this.wDe.setLayoutParams(paramBundle);
    this.wDc = ((CheckBox)findViewById(2131302614));
    paramBundle = this.wDc;
    boolean bool;
    if (!k.dwp().dwc().aJZ())
    {
      bool = true;
      paramBundle.setChecked(bool);
      this.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
      this.wDc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63228);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          MusicMainUI.a(MusicMainUI.this);
          if (MusicMainUI.b(MusicMainUI.this).isChecked())
          {
            com.tencent.mm.ay.a.aJV();
            MusicMainUI.b(MusicMainUI.this).setChecked(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63228);
            return;
          }
          MusicMainUI.c(MusicMainUI.this);
          if (k.dwp().dwc().aKb()) {
            k.dwp().dwc().resume();
          }
          for (;;)
          {
            MusicMainUI.b(MusicMainUI.this).setChecked(false);
            break;
            k.dwp().s(null);
          }
        }
      });
      com.tencent.mm.sdk.b.a.IvT.c(this.kzS);
      this.wDf = ((MusicSeekBar)findViewById(2131302615));
      this.wDf.setOnSeekBarChange(new MusicSeekBar.a()
      {
        public final void wK(int paramAnonymousInt)
        {
          AppMethodBeat.i(63231);
          com.tencent.mm.ay.a.pR(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).setProgress(paramAnonymousInt);
          MusicMainUI.d(MusicMainUI.this).ik(true);
          AppMethodBeat.o(63231);
        }
      });
      this.wDi = ((LinearLayout)findViewById(2131302618));
      this.wDk = ((ImageView)findViewById(2131302605));
      this.wDj = ((TextView)findViewById(2131300231));
      this.wDl = ((ImageView)findViewById(2131300230));
      this.wDi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63232);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          MusicMainUI.e(MusicMainUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63232);
        }
      });
      this.wDi.setVisibility(8);
      if (!this.shakeSensor.ffc()) {
        ae.w("MicroMsg.Music.MusicMainUI", "not support shake");
      }
      dxd();
      i = this.scene;
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
      if (paramBundle != null)
      {
        ae.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(13041), Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
        com.tencent.mm.plugin.report.service.g.yxI.f(13041, new Object[] { Integer.valueOf(i), paramBundle.field_musicId, paramBundle.field_songName, paramBundle.field_songAlbum, Integer.valueOf(paramBundle.field_songId), paramBundle.field_songSinger, paramBundle.field_appId });
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(285L, 1L, 1L, false);
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
      if (paramBundle != null) {
        break label946;
      }
      String str = getIntent().getStringExtra("db_music_id");
      if (TextUtils.isEmpty(str)) {
        break label946;
      }
      paramBundle = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).atP(str);
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
      this.wDg.setCurrentItem(((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwk() + 100000);
      if ((this.scene == 4) && (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2))
      {
        i = com.tencent.mm.kernel.g.ajR().ajA().getInt(83, 0);
        if (i < 3)
        {
          Toast.makeText(this, 2131759719, 0).show();
          com.tencent.mm.kernel.g.ajR().ajA().set(83, Integer.valueOf(i + 1));
        }
      }
      if (this.scene == 5) {
        com.tencent.mm.plugin.music.model.d.e.a(0, paramBundle);
      }
      j(paramBundle);
      if (this.mode == 1)
      {
        if (this.wDu == null) {
          this.wDu = new Timer();
        }
        this.wDu.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(63240);
            MusicMainUI.m(MusicMainUI.this).fa(0, 0);
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
      this.shakeSensor.cdt();
    }
    if (this.wDh != null)
    {
      Object localObject = this.wDh;
      ((b)localObject).wAz.removeCallbacksAndMessages(null);
      localObject = ((b)localObject).wCM;
      ((com.tencent.mm.plugin.music.model.d)localObject).wAz.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.music.model.d)localObject).fIj.clear();
    }
    if (this.wDf != null) {
      this.wDf.ik(false);
    }
    dxe();
    com.tencent.mm.sdk.b.a.IvT.d(this.kzS);
    k.dwp().dwc().b(this.wxZ);
    if (!k.dwp().dwc().aJZ()) {
      k.dwp().dwc().stopPlay();
    }
    ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwl();
    AppMethodBeat.o(63253);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63257);
    ae.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwm()) {
      this.wDg.setCanSlide(false);
    }
    this.fJn.removeCallbacksAndMessages(null);
    this.fJn.postDelayed(new a(paramInt), 500L);
    if (this.tnI == -1) {
      this.tnI = paramInt;
    }
    if (this.tnI != paramInt)
    {
      this.tnI = paramInt;
      com.tencent.mm.plugin.music.model.d.e.wBp = true;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(285L, 3L, 1L, false);
      com.tencent.mm.plugin.music.model.d.e.gO(1, this.scene);
    }
    AppMethodBeat.o(63257);
  }
  
  public void onPause()
  {
    int k = 1;
    AppMethodBeat.i(63250);
    super.onPause();
    this.wDo = System.currentTimeMillis();
    Object localObject2 = k.dwp().dwa();
    Object localObject1 = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
    if ((localObject2 == null) || (localObject1 == null))
    {
      if (this.shakeSensor != null) {
        this.shakeSensor.cdt();
      }
      k.dwp().dwc().b(this.wxZ);
      AppMethodBeat.o(63250);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songLyric)) {}
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(((com.tencent.mm.ay.f)localObject2).ikA)) {
        this.wDr = ((com.tencent.mm.ay.f)localObject2).ikA;
      }
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
      long l1 = this.wDn;
      long l2 = this.wDo;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.a)localObject1).field_songName;
      String str1 = this.wDp;
      int j;
      label160:
      int m;
      String str2;
      if (this.wDq)
      {
        j = 1;
        m = ((com.tencent.mm.ay.f)localObject2).ijX;
        localObject2 = this.wDr;
        str2 = this.wDs;
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
    this.wDn = System.currentTimeMillis();
    this.wDq = false;
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwf()) {
      if (!this.wAO)
      {
        if ((this.shakeSensor != null) && (this.shakeSensor.ffc()) && (!this.shakeSensor.ffa())) {
          this.shakeSensor.a(new b((byte)0));
        }
        this.lastShakeTime = bu.HQ();
      }
    }
    for (;;)
    {
      k.dwp().dwc().a(this.wxZ);
      cei();
      AppMethodBeat.o(63249);
      return;
      ae.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwh();
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
      ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).LR(this.position);
      com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
      if (locala == null)
      {
        AppMethodBeat.o(63245);
        return;
      }
      if (locala.dwE()) {
        MusicMainUI.this.k(locala);
      }
      if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwm()) {
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
      ae.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[] { Boolean.valueOf(paramBoolean) });
      long l = bu.aO(MusicMainUI.f(MusicMainUI.this));
      if (l < 1200L)
      {
        ae.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
        AppMethodBeat.o(63246);
        return;
      }
      ae.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(l)));
      MusicMainUI.a(MusicMainUI.this, bu.HQ());
      MusicMainUI.g(MusicMainUI.this);
      if (MusicMainUI.h(MusicMainUI.this) % 2 == 0) {
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).Ji(MusicMainUI.i(MusicMainUI.this));
      }
      AppMethodBeat.o(63246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI
 * JD-Core Version:    0.7.0.1
 */