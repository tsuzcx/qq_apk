package com.tencent.mm.plugin.mv.ui.shake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.l;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.model.a.n;
import com.tencent.mm.plugin.mv.ui.WeCheckBox;
import com.tencent.mm.plugin.mv.ui.WeCheckBox.a;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(32)
public class MusicMainUINew
  extends MMActivity
{
  public static int LIC = 0;
  private static int Mcz = 1;
  private static String TAG = "MusicMainUINew";
  FrameLayout HOp;
  com.tencent.mm.aw.f LLa;
  com.tencent.mm.plugin.music.model.e.a LMB;
  private com.tencent.mm.plugin.music.model.i McA;
  com.tencent.threadpool.i.d<?> McB;
  private boolean McC;
  boolean McD;
  a McE;
  private WeCheckBox McF;
  MultiMediaEffectVideoLayout Mci;
  CdnImageView Mco;
  c Mcp;
  String Mcq;
  List<com.tencent.mm.plugin.mv.ui.a.b> Mcr;
  List<com.tencent.mm.aw.f> Mcs;
  boolean Mct;
  boolean Mcu;
  boolean Mcv;
  boolean Mcw;
  boolean Mcx;
  boolean Mcy;
  Float cvr;
  int duration;
  private IListener rDF;
  
  public MusicMainUINew()
  {
    AppMethodBeat.i(287374);
    this.Mcr = new ArrayList();
    this.Mct = false;
    this.Mcu = false;
    this.Mcv = false;
    this.Mcy = false;
    this.McA = new com.tencent.mm.plugin.music.model.i();
    this.McC = false;
    this.McD = false;
    this.McE = new a();
    this.McF = null;
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(287374);
  }
  
  private void a(String paramString, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(287397);
    this.Mcp = new c(getContext(), paramViewGroup, (int)(com.tencent.mm.cd.a.mt(getContext()) * 0.7D * 0.4D), paramInt);
    this.Mcp.onCreate();
    this.Mcp.aPE(paramString);
    AppMethodBeat.o(287397);
  }
  
  private com.tencent.mm.aw.f bLn()
  {
    AppMethodBeat.i(287389);
    if (this.LLa == null) {
      this.LLa = com.tencent.mm.aw.a.bLn();
    }
    com.tencent.mm.aw.f localf = this.LLa;
    AppMethodBeat.o(287389);
    return localf;
  }
  
  private com.tencent.mm.plugin.music.model.e.a gnl()
  {
    AppMethodBeat.i(287382);
    if (this.LMB == null)
    {
      localObject = l.LMH;
      this.LMB = l.bb(getContext());
    }
    Object localObject = this.LMB;
    AppMethodBeat.o(287382);
    return localObject;
  }
  
  public void finish()
  {
    AppMethodBeat.i(287574);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.mv.b.a.activity_fade_in, com.tencent.mm.plugin.mv.b.a.activity_fade_out);
    AppMethodBeat.o(287574);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.LVk;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(287544);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(287544);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(287539);
    if ((!this.McD) && (!this.Mcu)) {
      setResult(Mcz);
    }
    this.rDF.dead();
    super.onBackPressed();
    AppMethodBeat.o(287539);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287531);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    Log.i(TAG, "onCreate");
    if (!j.isInit())
    {
      finish();
      Log.e(TAG, "MusicPlayerManager is not init!");
      AppMethodBeat.o(287531);
      return;
    }
    overridePendingTransition(com.tencent.mm.plugin.mv.b.a.activity_fade_in, com.tencent.mm.plugin.mv.b.a.activity_fade_out);
    getWindow().setFlags(67109888, 67109888);
    hideTitleView();
    gnl();
    bLn();
    if (bLn() != null) {
      this.Mcq = bLn().oOE;
    }
    this.cvr = Float.valueOf(getIntent().getFloatExtra("key_offset", -1.0F));
    if (getIntent().getIntExtra("key_pure", 0) == 1)
    {
      bool = true;
      this.Mcw = bool;
      this.Mct = getIntent().getBooleanExtra("key_copyright", false);
      if (getIntent().getIntExtra("key_byuser", 0) != 1) {
        break label1267;
      }
    }
    final int i;
    Object localObject3;
    label1267:
    for (boolean bool = true;; bool = false)
    {
      this.Mcx = bool;
      this.Mcv = getIntent().getBooleanExtra("key_history", false);
      this.Mcs = ((List)getIntent().getSerializableExtra("key_recommend_list"));
      this.duration = getIntent().getIntExtra("key_duration", 0);
      this.Mcy = getIntent().getBooleanExtra("key_hasPre", false);
      paramBundle = getIntent().getStringExtra("report_sessionid");
      localObject1 = getIntent().getStringExtra("shake_sessionid");
      i = getIntent().getIntExtra("copyright_report", 0);
      localObject2 = f.McU;
      f.a(paramBundle, (String)localObject1, bLn(), Integer.valueOf(i), Boolean.valueOf(this.Mcv));
      paramBundle = f.McU;
      f.BI(250);
      this.HOp = ((FrameLayout)findViewById(b.e.BXT));
      paramBundle = (LinearLayout.LayoutParams)this.HOp.getLayoutParams();
      paramBundle.height = ((int)(com.tencent.mm.cd.a.mt(getContext()) * 0.7D));
      paramBundle.width = ((int)(com.tencent.mm.cd.a.mt(getContext()) * 0.42D));
      this.HOp.setLayoutParams(paramBundle);
      this.HOp.setClipToOutline(true);
      this.HOp.setOutlineProvider(new e(com.tencent.mm.cd.a.fromDPToPix(getContext(), 25)));
      paramBundle = (LinearLayout)findViewById(b.e.LUl);
      localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).width = ((int)(com.tencent.mm.cd.a.mt(getContext()) * 0.42D));
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      findViewById(b.e.close).setOnClickListener(new MusicMainUINew.1(this));
      paramBundle = (CdnImageView)findViewById(b.e.Bzw);
      paramBundle.setVisibility(0);
      paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.McA.a(bLn(), paramBundle, getContext(), true);
      if (!this.Mct) {
        break label1273;
      }
      paramBundle = LayoutInflater.from(getContext()).inflate(b.f.LVM, null);
      localObject1 = (RelativeLayout)paramBundle.findViewById(b.e.LVd);
      this.Mci = ((MultiMediaEffectVideoLayout)paramBundle.findViewById(b.e.video_layout));
      this.Mci.setMute(true);
      localObject2 = (CdnImageView)paramBundle.findViewById(b.e.LSJ);
      ((CdnImageView)localObject2).setVisibility(0);
      ((CdnImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.McA.a(bLn(), (CdnImageView)localObject2, getContext(), false);
      ((CdnImageView)localObject2).setClipToOutline(true);
      ((CdnImageView)localObject2).setOutlineProvider(new e(com.tencent.mm.cd.a.fromDPToPix(getContext(), 5)));
      ((TextView)paramBundle.findViewById(b.e.LSM)).setText(gnl().field_songName);
      ((TextView)paramBundle.findViewById(b.e.LSN)).setText(gnl().field_songSinger);
      this.Mco = ((CdnImageView)paramBundle.findViewById(b.e.LSl));
      this.Mco.setScaleType(ImageView.ScaleType.CENTER_CROP);
      i = (int)(com.tencent.mm.cd.a.mt(getContext()) * 0.7D);
      int j = (int)(com.tencent.mm.cd.a.mt(getContext()) * 0.42D);
      localObject2 = new com.tencent.mm.plugin.music.model.i();
      ((com.tencent.mm.plugin.music.model.i)localObject2).LMv = new MusicMainUINew.12(this, j, i);
      ((com.tencent.mm.plugin.music.model.i)localObject2).a(bLn(), this.Mco, getContext(), false);
      this.Mco.setVisibility(0);
      a(this.Mcq, (ViewGroup)localObject1, 0);
      if (this.Mcp != null) {
        this.Mcp.aeb(this.cvr.intValue());
      }
      paramBundle.findViewById(b.e.LSQ).setOnClickListener(new MusicMainUINew.13(this));
      paramBundle.findViewById(b.e.LSO).setOnClickListener(new MusicMainUINew.14(this));
      paramBundle.findViewById(b.e.LSE).setOnClickListener(new MusicMainUINew.15(this));
      this.HOp.addView(paramBundle);
      paramBundle = (LinearLayout)findViewById(b.e.LSI);
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(287337);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/shake/MusicMainUINew$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = com.tencent.mm.plugin.music.model.c.LLZ;
          com.tencent.mm.plugin.music.model.c.zK(true);
          paramAnonymousView = MusicMainUINew.f(MusicMainUINew.this);
          paramAnonymousView.oOI = "wx5aa333606550dfd5";
          localObject = l.LMH;
          l.a(MusicMainUINew.this.getContext(), paramAnonymousView, MusicMainUINew.this.McE.be(MusicMainUINew.this.getContext()), new ap()
          {
            public final void onLaunchApp(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(287421);
              f localf;
              if (paramAnonymous2Boolean1) {
                localf = f.McU;
              }
              for (f.gqu().jcR = 1L;; f.gqu().jcR = 2L)
              {
                if (paramAnonymous2Boolean2)
                {
                  localf = f.McU;
                  f.gqu().jcR = 3L;
                }
                localf = f.McU;
                f.BI(256);
                AppMethodBeat.o(287421);
                return;
                localf = f.McU;
              }
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/shake/MusicMainUINew$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(287337);
        }
      });
      this.HOp.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(287403);
          MusicMainUINew.this.HOp.startAnimation(AnimationUtils.loadAnimation(MusicMainUINew.this.getContext(), com.tencent.mm.plugin.mv.b.a.LRA));
          AppMethodBeat.o(287403);
        }
      });
      if ((!this.Mcv) && (!this.Mcx) && (this.Mct))
      {
        if (!com.tencent.mm.aw.a.bLk())
        {
          this.LLa = j.gnw().gng();
          j.gnw().w(null);
        }
        if ((!this.Mcx) && (!this.Mcv))
        {
          localObject1 = this.McE;
          localObject2 = getContext();
          localObject3 = new com.tencent.mm.plugin.mv.model.a.b.a()
          {
            boolean McI = false;
            
            public final void a(com.tencent.mm.plugin.mv.ui.a.b paramAnonymousb)
            {
              AppMethodBeat.i(287378);
              Log.i(MusicMainUINew.gqt(), "Finder Get! Here!");
              if ((!this.McI) && (MusicMainUINew.this.Mci != null) && (MusicMainUINew.this.Mco != null))
              {
                MusicMainUINew.this.Mci.setMediaList(paramAnonymousb.MaX.gpD());
                MusicMainUINew.this.Mci.start();
                MusicMainUINew.this.Mci.seekTo(com.tencent.mm.aw.a.bLo().mPosition);
                MusicMainUINew.this.Mci.setVisibility(0);
                this.McI = true;
                MusicMainUINew.l(MusicMainUINew.this);
                dtj localdtj = new dtj();
                localdtj.YqO = paramAnonymousb.MaX.LXk;
                localdtj.YqN = paramAnonymousb.MaX.LXj.toString();
                localdtj.YqP = paramAnonymousb.MaX.coverUrl;
                localdtj.YqQ = paramAnonymousb.MaX.LXl;
              }
              MusicMainUINew.this.Mcr.add(paramAnonymousb);
              AppMethodBeat.o(287378);
            }
          };
          paramBundle = l.LMH;
          paramBundle = l.bb((Activity)localObject2);
          ((a)localObject1).Gbe = new boo();
          if (paramBundle != null)
          {
            a.a(paramBundle, ((a)localObject1).Gbe);
            paramBundle = ((a)localObject1).Gbe;
            i = localObject2.hashCode();
            ((a)localObject1).McM = new com.tencent.mm.plugin.mv.model.a.b(paramBundle, i);
            ((a)localObject1).McM.LYG = ((com.tencent.mm.plugin.mv.model.a.b.a)localObject3);
            ((a)localObject1).McM.LYF = new ArrayList();
            ((a)localObject1).McM.gpP();
            localObject1 = ((a)localObject1).McM;
            localObject2 = com.tencent.mm.plugin.mv.ui.a.Maz;
            localObject2 = com.tencent.mm.plugin.mv.ui.a.a(((com.tencent.mm.plugin.mv.model.a.b)localObject1).Gbe);
            com.tencent.mm.kernel.h.aZW().a(new n(null, ((com.tencent.mm.plugin.mv.model.a.b)localObject1).Gbe, (String)localObject2, i), 0);
            com.tencent.mm.plugin.mv.model.a.b.kC("wx5aa333606550dfd5", paramBundle.oOZ);
          }
        }
      }
      if (this.Mcv)
      {
        paramBundle = this.McE;
        localObject1 = getContext();
        localObject2 = l.LMH;
        localObject2 = l.bb((Activity)localObject1);
        paramBundle.Gbe = new boo();
        if (localObject2 != null)
        {
          a.a((com.tencent.mm.plugin.music.model.e.a)localObject2, paramBundle.Gbe);
          paramBundle.McM = new com.tencent.mm.plugin.mv.model.a.b(paramBundle.Gbe, localObject1.hashCode());
          paramBundle.McM.gpP();
          com.tencent.mm.plugin.mv.model.a.b.kC("wx5aa333606550dfd5", paramBundle.Gbe.oOZ);
        }
      }
      AppMethodBeat.o(287531);
      return;
      bool = false;
      break;
    }
    label1273:
    paramBundle = LayoutInflater.from(getContext()).inflate(b.f.LVg, null);
    Object localObject1 = (LinearLayout)paramBundle.findViewById(b.e.LVd);
    Object localObject2 = (CdnImageView)paramBundle.findViewById(b.e.LSl);
    ((CdnImageView)localObject2).setVisibility(0);
    ((CdnImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.McA.a(bLn(), (CdnImageView)localObject2, getContext(), false);
    if (this.Mcq == null)
    {
      localObject1 = (TextView)paramBundle.findViewById(b.e.LUR);
      ((TextView)localObject1).setVisibility(0);
      if (this.Mcw) {
        ((TextView)localObject1).setText("纯音乐无歌词");
      }
    }
    for (;;)
    {
      if ((!this.Mcv) && (this.Mcp != null)) {
        this.Mcp.aeb(this.cvr.intValue());
      }
      if ((!this.Mcx) && (!this.Mcv)) {
        this.McB = com.tencent.threadpool.h.ahAA.b(new Runnable()
        {
          int bVs;
          
          public final void run()
          {
            AppMethodBeat.i(287398);
            this.bVs += 100;
            if (this.bVs >= MusicMainUINew.this.duration)
            {
              MusicMainUINew.g(MusicMainUINew.this);
              AppMethodBeat.o(287398);
              return;
            }
            if (MusicMainUINew.this.Mcp != null) {
              MusicMainUINew.this.Mcp.aeb(this.bVs);
            }
            AppMethodBeat.o(287398);
          }
        }, 0L, 100L);
      }
      this.HOp.addView(paramBundle);
      localObject1 = (TextView)paramBundle.findViewById(b.e.LUP);
      aw.d(((TextView)localObject1).getPaint());
      aw.d(((TextView)paramBundle.findViewById(b.e.LSe)).getPaint());
      paramBundle = (TextView)paramBundle.findViewById(b.e.LUD);
      ((TextView)localObject1).setText(this.LMB.field_songName);
      paramBundle.setText(this.LMB.field_songSinger);
      if ((this.Mcs == null) || (this.Mcs.size() <= 0)) {
        break;
      }
      paramBundle = (LinearLayout)findViewById(b.e.LUv);
      localObject1 = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).width = ((int)(com.tencent.mm.cd.a.mt(getContext()) * 0.42D));
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramBundle.setVisibility(0);
      localObject1 = this.Mcs.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.aw.f)((Iterator)localObject1).next();
        i += 1;
        localObject3 = LayoutInflater.from(getContext()).inflate(b.f.LVL, null);
        CdnImageView localCdnImageView = (CdnImageView)((View)localObject3).findViewById(b.e.HTJ);
        TextView localTextView1 = (TextView)((View)localObject3).findViewById(b.e.LUP);
        TextView localTextView2 = (TextView)((View)localObject3).findViewById(b.e.LUD);
        final WeCheckBox localWeCheckBox = (WeCheckBox)((View)localObject3).findViewById(b.e.play_btn);
        this.McA.a((com.tencent.mm.aw.f)localObject2, localCdnImageView, getContext(), false);
        localCdnImageView.setClipToOutline(true);
        localCdnImageView.setOutlineProvider(new e(com.tencent.mm.cd.a.fromDPToPix(getContext(), 5)));
        localTextView1.setText(((com.tencent.mm.aw.f)localObject2).oOx);
        localTextView2.setText(((com.tencent.mm.aw.f)localObject2).oOy);
        ((View)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(287414);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/shake/MusicMainUINew$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            MusicMainUINew.this.McD = true;
            MusicMainUINew.b(MusicMainUINew.this).dead();
            MusicMainUINew.a(MusicMainUINew.this, this.oOn);
            paramAnonymousView = com.tencent.mm.plugin.music.model.c.LLZ;
            com.tencent.mm.plugin.music.model.c.zK(true);
            localWeCheckBox.setChecked(true);
            MusicMainUINew.this.Mcu = true;
            paramAnonymousView = f.McU;
            f.gqu().jcS = i;
            paramAnonymousView = f.McU;
            f.BI(252);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/shake/MusicMainUINew$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(287414);
          }
        });
        localWeCheckBox.setOnCheckedChangeListener(new WeCheckBox.a()
        {
          public final void zX(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(287383);
            if (paramAnonymousBoolean)
            {
              MusicMainUINew.this.Mcp.onPause();
              MusicMainUINew.af(this.oOn);
              if ((j.gnw().gnj() instanceof com.tencent.mm.plugin.music.e.e)) {
                ((com.tencent.mm.plugin.music.e.e)j.gnw().gnj()).setVolume(1.0F);
              }
              Object localObject = com.tencent.mm.plugin.music.model.c.LLZ;
              com.tencent.mm.plugin.music.model.c.gnP();
              MusicMainUINew.this.Mcu = true;
              MusicMainUINew.h(MusicMainUINew.this);
              com.tencent.mm.aw.a.c(this.oOn);
              if (MusicMainUINew.i(MusicMainUINew.this) != null) {
                MusicMainUINew.i(MusicMainUINew.this).setChecked(false);
              }
              MusicMainUINew.a(MusicMainUINew.this, localWeCheckBox);
              localObject = f.McU;
              f.gqu().jcS = i;
              localObject = f.McU;
              f.BI(257);
              AppMethodBeat.o(287383);
              return;
            }
            if (com.tencent.mm.aw.a.bLn().oOv == this.oOn.oOv) {
              com.tencent.mm.aw.a.bLi();
            }
            MusicMainUINew.a(MusicMainUINew.this, null);
            AppMethodBeat.o(287383);
          }
        });
        paramBundle.addView((View)localObject3);
      }
      break;
      ((TextView)localObject1).setText("暂无歌词");
      continue;
      a(this.Mcq, (ViewGroup)localObject1, 1);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(287510);
    super.onCreateBeforeSetContentView();
    setBounceEnabled(false);
    AppMethodBeat.o(287510);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(287552);
    super.onDestroy();
    Log.i(TAG, "onDestroy");
    Object localObject = this.McE;
    if (((a)localObject).McM != null)
    {
      localObject = ((a)localObject).McM;
      com.tencent.mm.kernel.h.aZW().b(6860, ((com.tencent.mm.plugin.mv.model.a.b)localObject).LYH);
      com.tencent.mm.kernel.h.aZW().b(3763, ((com.tencent.mm.plugin.mv.model.a.b)localObject).LYH);
      com.tencent.mm.kernel.h.aZW().b(6473, ((com.tencent.mm.plugin.mv.model.a.b)localObject).LYH);
    }
    if (this.Mci != null) {
      this.Mci.TGY.release();
    }
    if ((!this.McD) && (!this.Mcu) && (!this.Mcy)) {
      com.tencent.mm.aw.a.bLi();
    }
    if (this.Mcp != null)
    {
      localObject = this.Mcp;
      Log.i("MicroMsg.Mv.MusicMvLyric", "onDestroy");
      ((c)localObject).Mcc.clear();
      ((c)localObject).LOA = null;
      j.gnw().gnj().b(((c)localObject).LJz);
    }
    this.rDF.dead();
    AppMethodBeat.o(287552);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(287566);
    super.onPause();
    if (this.Mcu)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.gnP();
    }
    this.rDF.dead();
    if (this.Mcp != null) {
      this.Mcp.onPause();
    }
    Log.i(TAG, "onPause");
    AppMethodBeat.o(287566);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(287560);
    super.onResume();
    if (!this.McC)
    {
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.onResume();
    }
    this.rDF.alive();
    if ((!this.Mct) && (this.Mcp != null)) {
      this.Mcp.onPause();
    }
    Log.i(TAG, "onResume");
    AppMethodBeat.o(287560);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.MusicMainUINew
 * JD-Core Version:    0.7.0.1
 */