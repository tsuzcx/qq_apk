package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.l.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI FOJ;
  private ImageView FOA;
  private ImageButton FOB;
  private ImageView FOC;
  private TextView FOD;
  private TextView FOE;
  private TextView FOF;
  private int FOG;
  private boolean FOH;
  private ImageButton FOI;
  private boolean FOK;
  private boolean FOL;
  private String FOM;
  private View FON;
  private View FOO;
  SurfaceHolder.Callback FOP;
  private String FOq;
  private com.tencent.mm.pluginsdk.l.b FOu;
  private ImageButton FOv;
  private boolean FOw;
  private boolean FOx;
  private TextView FOy;
  private LinearLayout FOz;
  private SurfaceHolder gQc;
  private ProgressDialog gtM;
  private SurfaceView mSurfaceView;
  private String mss;
  private long qPn;
  private MTimerHandler qPy;
  private String talker;
  private String videoPath;
  private MMHandler zPV;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(29345);
    this.mSurfaceView = null;
    this.gQc = null;
    this.talker = null;
    this.gtM = null;
    this.FOw = false;
    this.FOx = false;
    this.qPn = -1L;
    this.FOB = null;
    this.FOG = 0;
    this.FOK = false;
    this.FOL = true;
    this.videoPath = null;
    this.FOq = null;
    this.mss = null;
    this.FOM = null;
    this.qPy = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29331);
        if (VideoRecorderUI.a(VideoRecorderUI.this) == -1L) {
          VideoRecorderUI.a(VideoRecorderUI.this, SystemClock.elapsedRealtime());
        }
        long l1 = VideoRecorderUI.a(VideoRecorderUI.this);
        l1 = SystemClock.elapsedRealtime() - l1;
        VideoRecorderUI.b(VideoRecorderUI.this).setText(f.formatSecToMin((int)(l1 / 1000L)));
        if ((l1 <= 30000L) && (l1 >= 20000L))
        {
          long l2 = (30000L - l1) / 1000L;
          VideoRecorderUI.c(VideoRecorderUI.this).setVisibility(0);
          VideoRecorderUI.c(VideoRecorderUI.this).setText(VideoRecorderUI.this.getResources().getQuantityString(2131623972, (int)l2, new Object[] { Long.valueOf(l2) }));
        }
        while (l1 >= 30000L)
        {
          Log.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
          VideoRecorderUI.d(VideoRecorderUI.this);
          VideoRecorderUI.a(VideoRecorderUI.this, -1L);
          AppMethodBeat.o(29331);
          return false;
          VideoRecorderUI.c(VideoRecorderUI.this).setVisibility(8);
        }
        VideoRecorderUI.a(VideoRecorderUI.this, VideoRecorderUI.e(VideoRecorderUI.this) % 2);
        if (VideoRecorderUI.e(VideoRecorderUI.this) == 0) {
          VideoRecorderUI.f(VideoRecorderUI.this).setVisibility(4);
        }
        for (;;)
        {
          VideoRecorderUI.g(VideoRecorderUI.this);
          AppMethodBeat.o(29331);
          return true;
          VideoRecorderUI.f(VideoRecorderUI.this).setVisibility(0);
        }
      }
    }, true);
    this.zPV = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29342);
        super.handleMessage(paramAnonymousMessage);
        VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(true);
        AppMethodBeat.o(29342);
      }
    };
    this.FOP = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(29335);
        Log.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + paramAnonymousInt1 + " w:" + paramAnonymousInt2 + " h:" + paramAnonymousInt3);
        if (VideoRecorderUI.h(VideoRecorderUI.this).b(paramAnonymousSurfaceHolder) != 0) {
          VideoRecorderUI.s(VideoRecorderUI.this);
        }
        VideoRecorderUI.a(VideoRecorderUI.this, false);
        VideoRecorderUI.b(VideoRecorderUI.this, false);
        VideoRecorderUI.x(VideoRecorderUI.this);
        AppMethodBeat.o(29335);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(29333);
        Log.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
        if (VideoRecorderUI.h(VideoRecorderUI.this).d(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) {
          VideoRecorderUI.s(VideoRecorderUI.this);
        }
        AppMethodBeat.o(29333);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(29334);
        Log.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(VideoRecorderUI.this, true);
        VideoRecorderUI.h(VideoRecorderUI.this).goi();
        AppMethodBeat.o(29334);
      }
    };
    AppMethodBeat.o(29345);
  }
  
  private void ftB()
  {
    AppMethodBeat.i(29352);
    if (this.FOw)
    {
      h.a(this, getString(2131767104), getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29344);
          VideoRecorderUI.this.finish();
          AppMethodBeat.o(29344);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(29352);
      return;
    }
    finish();
    AppMethodBeat.o(29352);
  }
  
  private void ftC()
  {
    AppMethodBeat.i(29357);
    h.a(this, 2131767052, 2131755998, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29336);
        VideoRecorderUI.h(VideoRecorderUI.this).goi();
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29336);
      }
    });
    AppMethodBeat.o(29357);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(29358);
    this.mSurfaceView.setKeepScreenOn(false);
    AppMethodBeat.o(29358);
  }
  
  private void resetStatus()
  {
    AppMethodBeat.i(29353);
    getSupportActionBar().hide();
    this.FOD.setText(f.formatSecToMin(0));
    this.FON.setVisibility(8);
    this.FOO.setVisibility(8);
    this.FOC.setVisibility(0);
    this.FOw = false;
    this.FOz.setVisibility(0);
    this.mSurfaceView.setVisibility(0);
    this.FOy.setVisibility(8);
    this.FOB.setVisibility(8);
    this.FOD.setText(f.formatSecToMin(0));
    this.FOA.setVisibility(8);
    this.FOv.setEnabled(true);
    this.FOI.setVisibility(0);
    AppMethodBeat.o(29353);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(29350);
    ao.p(ao.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29350);
  }
  
  public int getLayoutId()
  {
    boolean bool = true;
    AppMethodBeat.i(29359);
    int i;
    if (ae.gKt.gFQ == 1)
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
    }
    for (;;)
    {
      this.FOH = bool;
      if (this.FOH) {
        break label81;
      }
      AppMethodBeat.o(29359);
      return 2131496806;
      if ((Build.VERSION.SDK_INT == 10) && (Build.MODEL.equals("GT-S5360")))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label76:
      bool = false;
    }
    label81:
    getWindow().setFlags(1024, 1024);
    setRequestedOrientation(0);
    AppMethodBeat.o(29359);
    return 2131496807;
  }
  
  public void initView()
  {
    int j = 1;
    AppMethodBeat.i(29349);
    this.mSurfaceView = ((SurfaceView)findViewById(2131308779));
    this.FOz = ((LinearLayout)findViewById(2131309813));
    this.gQc = this.mSurfaceView.getHolder();
    this.gQc.addCallback(this.FOP);
    this.gQc.setType(3);
    this.FOC = ((ImageView)findViewById(2131309816));
    this.FOI = ((ImageButton)findViewById(2131309847));
    this.FOD = ((TextView)findViewById(2131309814));
    this.FON = findViewById(2131309815);
    this.FOO = findViewById(2131309809);
    this.FOD.setText(f.formatSecToMin(0));
    this.FOu = new com.tencent.mm.pluginsdk.l.b();
    this.FOy = ((TextView)findViewById(2131309852));
    this.FOE = ((TextView)findViewById(2131309817));
    this.FOF = ((TextView)findViewById(2131309810));
    this.FOv = ((ImageButton)findViewById(2131309849));
    this.FOv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29340);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          u.g(VideoRecorderUI.this, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29340);
          return;
        }
        if (VideoRecorderUI.k(VideoRecorderUI.this)) {
          VideoRecorderUI.d(VideoRecorderUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29340);
          return;
          if (VideoRecorderUI.l(VideoRecorderUI.this))
          {
            h.a(VideoRecorderUI.this, VideoRecorderUI.this.getString(2131767105), VideoRecorderUI.this.getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29339);
                VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(2131235420);
                VideoRecorderUI.n(VideoRecorderUI.this);
                AppMethodBeat.o(29339);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
          }
          else
          {
            VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(2131235420);
            VideoRecorderUI.n(VideoRecorderUI.this);
          }
        }
      }
    });
    com.tencent.mm.pluginsdk.l.b localb;
    label314:
    Object localObject;
    if (d.getNumberOfCameras() > 1)
    {
      this.FOI.setVisibility(0);
      this.FOI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(false);
          VideoRecorderUI.p(VideoRecorderUI.this).sendEmptyMessageDelayed(0, 3000L);
          VideoRecorderUI.a(VideoRecorderUI.this, true);
          VideoRecorderUI.h(VideoRecorderUI.this).goi();
          if ((VideoRecorderUI.h(VideoRecorderUI.this).d(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) || (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.r(VideoRecorderUI.this)) != 0)) {
            VideoRecorderUI.s(VideoRecorderUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29341);
        }
      });
      this.FOB = ((ImageButton)findViewById(2131309793));
      this.FOA = ((ImageView)findViewById(2131309812));
      this.FOB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).Dqi.iFw);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderUI.this, 0, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29343);
        }
      });
      localb = this.FOu;
      if (this.FOH) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.FOq;
      String str2 = this.mss;
      String str3 = this.FOM;
      localb.jqs = 0;
      if (1 != localb.jqs) {
        break label584;
      }
      localb.Dqi = com.tencent.mm.pluginsdk.l.a.goh();
      label358:
      if (ae.gKv.gKa)
      {
        localb.Dqi.ifO = ae.gKv.mVideoHeight;
        localb.Dqi.ifN = ae.gKv.mVideoWidth;
        localb.Dqi.zuR = ae.gKv.gKc;
      }
      localb.filename = str3;
      localb.Dqi.zuY = str1;
      localb.Dqi.zuW = str2;
      localb.Dqi.zuV = ((String)localObject + "temp.pcm");
      localb.Dqi.zuU = ((String)localObject + "temp.yuv");
      localb.Dqi.zuX = ((String)localObject + "temp.vid");
      localb.Dqi.zva = d.getNumberOfCameras();
      localObject = localb.Dqi;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((com.tencent.mm.pluginsdk.l.a)localObject).dYT = i;
      localb.Dqi.iFw = 0;
      localb.KaF = new g();
      AppMethodBeat.o(29349);
      return;
      this.FOI.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.Dqi = com.tencent.mm.pluginsdk.l.a.gog();
      break label358;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(29356);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(29356);
      return;
    }
    if (paramInt1 == 0)
    {
      setResult(-1, paramIntent);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(29356);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29346);
    super.onCreate(paramBundle);
    MMActivity.initLanguage(this);
    FOJ = this;
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    setMMTitle(2131767106);
    addTextOptionMenu(0, getString(2131755976), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29337);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).Dqi.iFw);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29337);
        return true;
      }
    }, null, t.b.OGU);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29338);
        VideoRecorderUI.j(VideoRecorderUI.this);
        AppMethodBeat.o(29338);
        return true;
      }
    });
    this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
    this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
    this.FOq = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.mss = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.FOM = getIntent().getStringExtra("VideoRecorder_FileName");
    Log.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    Log.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.FOq + " videoThumbPath " + this.mss + " KFileName " + this.FOM);
    initView();
    resetStatus();
    bg.Xi().akr();
    AppMethodBeat.o(29346);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29348);
    FOJ = null;
    Log.v("MicroMsg.VideoRecorderUI", "on destroy");
    bg.Xi().akq();
    super.onDestroy();
    AppMethodBeat.o(29348);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29351);
    if (paramInt == 4)
    {
      Log.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.FOx)
      {
        AppMethodBeat.o(29351);
        return true;
      }
      ftB();
      AppMethodBeat.o(29351);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(29351);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29355);
    if (this.FOx)
    {
      com.tencent.mm.pluginsdk.l.b localb = this.FOu;
      if (localb.zwf != null)
      {
        localb.zwf.stop();
        localb.zwf.release();
        localb.zwf = null;
      }
      resetStatus();
      this.FOx = false;
      releaseWakeLock();
      this.FOv.setImageResource(2131235419);
      this.qPy.stopTimer();
      this.FOy.setVisibility(8);
      this.FOz.setVisibility(0);
      this.mSurfaceView.setVisibility(0);
    }
    this.FOu.goi();
    Log.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(29355);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29354);
    if ((!this.FOL) && ((this.FOu.d(this, false) != 0) || (this.FOu.b(this.gQc) != 0))) {
      ftC();
    }
    this.FOL = false;
    Log.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(29354);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29347);
    super.onStart();
    if (this.FOH)
    {
      setRequestedOrientation(0);
      AppMethodBeat.o(29347);
      return;
    }
    setRequestedOrientation(1);
    AppMethodBeat.o(29347);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI
 * JD-Core Version:    0.7.0.1
 */