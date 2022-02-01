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
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.l.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI Bmy;
  private boolean BmA;
  private String BmB;
  private View BmC;
  private View BmD;
  SurfaceHolder.Callback BmE;
  private String Bmf;
  private com.tencent.mm.pluginsdk.l.b Bmj;
  private ImageButton Bmk;
  private boolean Bml;
  private boolean Bmm;
  private TextView Bmn;
  private LinearLayout Bmo;
  private ImageView Bmp;
  private ImageButton Bmq;
  private ImageView Bmr;
  private TextView Bms;
  private TextView Bmt;
  private TextView Bmu;
  private int Bmv;
  private boolean Bmw;
  private ImageButton Bmx;
  private boolean Bmz;
  private ProgressDialog fMu;
  private SurfaceHolder kmw;
  private String liK;
  private SurfaceView mSurfaceView;
  private av ptD;
  private long ptq;
  private String talker;
  private String videoPath;
  private ap wdW;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(29345);
    this.mSurfaceView = null;
    this.kmw = null;
    this.talker = null;
    this.fMu = null;
    this.Bml = false;
    this.Bmm = false;
    this.ptq = -1L;
    this.Bmq = null;
    this.Bmv = 0;
    this.Bmz = false;
    this.BmA = true;
    this.videoPath = null;
    this.Bmf = null;
    this.liK = null;
    this.BmB = null;
    this.ptD = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29331);
        if (VideoRecorderUI.a(VideoRecorderUI.this) == -1L) {
          VideoRecorderUI.a(VideoRecorderUI.this, SystemClock.elapsedRealtime());
        }
        long l1 = VideoRecorderUI.a(VideoRecorderUI.this);
        l1 = SystemClock.elapsedRealtime() - l1;
        VideoRecorderUI.b(VideoRecorderUI.this).setText(f.qY((int)(l1 / 1000L)));
        if ((l1 <= 30000L) && (l1 >= 20000L))
        {
          long l2 = (30000L - l1) / 1000L;
          VideoRecorderUI.c(VideoRecorderUI.this).setVisibility(0);
          VideoRecorderUI.c(VideoRecorderUI.this).setText(VideoRecorderUI.this.getResources().getQuantityString(2131623972, (int)l2, new Object[] { Long.valueOf(l2) }));
        }
        while (l1 >= 30000L)
        {
          ad.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
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
    this.wdW = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29342);
        super.handleMessage(paramAnonymousMessage);
        VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(true);
        AppMethodBeat.o(29342);
      }
    };
    this.BmE = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(29335);
        ad.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + paramAnonymousInt1 + " w:" + paramAnonymousInt2 + " h:" + paramAnonymousInt3);
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
        ad.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
        if (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) {
          VideoRecorderUI.s(VideoRecorderUI.this);
        }
        AppMethodBeat.o(29333);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(29334);
        ad.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(VideoRecorderUI.this, true);
        VideoRecorderUI.h(VideoRecorderUI.this).fbk();
        AppMethodBeat.o(29334);
      }
    };
    AppMethodBeat.o(29345);
  }
  
  private void enw()
  {
    AppMethodBeat.i(29352);
    if (this.Bml)
    {
      h.a(this, getString(2131764695), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void enx()
  {
    AppMethodBeat.i(29357);
    h.a(this, 2131764670, 2131755906, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29336);
        VideoRecorderUI.h(VideoRecorderUI.this).fbk();
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
    this.Bms.setText(f.qY(0));
    this.BmC.setVisibility(8);
    this.BmD.setVisibility(8);
    this.Bmr.setVisibility(0);
    this.Bml = false;
    this.Bmo.setVisibility(0);
    this.mSurfaceView.setVisibility(0);
    this.Bmn.setVisibility(8);
    this.Bmq.setVisibility(8);
    this.Bms.setText(f.qY(0));
    this.Bmp.setVisibility(8);
    this.Bmk.setEnabled(true);
    this.Bmx.setVisibility(0);
    AppMethodBeat.o(29353);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(29350);
    al.n(al.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29350);
  }
  
  public int getLayoutId()
  {
    boolean bool = true;
    AppMethodBeat.i(29359);
    int i;
    if (ae.gcE.fYt == 1)
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
    }
    for (;;)
    {
      this.Bmw = bool;
      if (this.Bmw) {
        break label81;
      }
      AppMethodBeat.o(29359);
      return 2131495837;
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
    return 2131495838;
  }
  
  public void initView()
  {
    int j = 1;
    AppMethodBeat.i(29349);
    this.mSurfaceView = ((SurfaceView)findViewById(2131305558));
    this.Bmo = ((LinearLayout)findViewById(2131306384));
    this.kmw = this.mSurfaceView.getHolder();
    this.kmw.addCallback(this.BmE);
    this.kmw.setType(3);
    this.Bmr = ((ImageView)findViewById(2131306387));
    this.Bmx = ((ImageButton)findViewById(2131306416));
    this.Bms = ((TextView)findViewById(2131306385));
    this.BmC = findViewById(2131306386);
    this.BmD = findViewById(2131306380);
    this.Bms.setText(f.qY(0));
    this.Bmj = new com.tencent.mm.pluginsdk.l.b();
    this.Bmn = ((TextView)findViewById(2131306421));
    this.Bmt = ((TextView)findViewById(2131306388));
    this.Bmu = ((TextView)findViewById(2131306381));
    this.Bmk = ((ImageButton)findViewById(2131306418));
    this.Bmk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29340);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ba.aBQ();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(VideoRecorderUI.this, null);
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
            h.a(VideoRecorderUI.this, VideoRecorderUI.this.getString(2131764696), VideoRecorderUI.this.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29339);
                VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(2131234477);
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
            VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(2131234477);
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
      this.Bmx.setVisibility(0);
      this.Bmx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(false);
          VideoRecorderUI.p(VideoRecorderUI.this).sendEmptyMessageDelayed(0, 3000L);
          VideoRecorderUI.a(VideoRecorderUI.this, true);
          VideoRecorderUI.h(VideoRecorderUI.this).fbk();
          if ((VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) || (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.r(VideoRecorderUI.this)) != 0)) {
            VideoRecorderUI.s(VideoRecorderUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29341);
        }
      });
      this.Bmq = ((ImageButton)findViewById(2131306364));
      this.Bmp = ((ImageView)findViewById(2131306383));
      this.Bmq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).yVh.hHQ);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          VideoRecorderUI.this.overridePendingTransition(0, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29343);
        }
      });
      localb = this.Bmj;
      if (this.Bmw) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.Bmf;
      String str2 = this.liK;
      String str3 = this.BmB;
      localb.ism = 0;
      if (1 != localb.ism) {
        break label584;
      }
      localb.yVh = com.tencent.mm.pluginsdk.l.a.fbj();
      label358:
      if (ae.gcG.gcr)
      {
        localb.yVh.vOK = ae.gcG.mVideoHeight;
        localb.yVh.vOL = ae.gcG.mVideoWidth;
        localb.yVh.vOJ = ae.gcG.gct;
      }
      localb.filename = str3;
      localb.yVh.vOS = str1;
      localb.yVh.vOQ = str2;
      localb.yVh.vOP = ((String)localObject + "temp.pcm");
      localb.yVh.vOO = ((String)localObject + "temp.yuv");
      localb.yVh.vOR = ((String)localObject + "temp.vid");
      localb.yVh.vOU = d.getNumberOfCameras();
      localObject = localb.yVh;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((com.tencent.mm.pluginsdk.l.a)localObject).dGc = i;
      localb.yVh.hHQ = 0;
      localb.ERs = new g();
      AppMethodBeat.o(29349);
      return;
      this.Bmx.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.yVh = com.tencent.mm.pluginsdk.l.a.fbi();
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
    Bmy = this;
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    setMMTitle(2131764697);
    addTextOptionMenu(0, getString(2131755884), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29337);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).yVh.hHQ);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29337);
        return true;
      }
    }, null, s.b.JbS);
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
    this.Bmf = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.liK = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.BmB = getIntent().getStringExtra("VideoRecorder_FileName");
    ad.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    ad.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.Bmf + " videoThumbPath " + this.liK + " KFileName " + this.BmB);
    initView();
    resetStatus();
    ba.Nb().Wv();
    AppMethodBeat.o(29346);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29348);
    Bmy = null;
    ad.v("MicroMsg.VideoRecorderUI", "on destroy");
    ba.Nb().Wu();
    super.onDestroy();
    AppMethodBeat.o(29348);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29351);
    if (paramInt == 4)
    {
      ad.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.Bmm)
      {
        AppMethodBeat.o(29351);
        return true;
      }
      enw();
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
    if (this.Bmm)
    {
      com.tencent.mm.pluginsdk.l.b localb = this.Bmj;
      if (localb.vPZ != null)
      {
        localb.vPZ.stop();
        localb.vPZ.release();
        localb.vPZ = null;
      }
      resetStatus();
      this.Bmm = false;
      releaseWakeLock();
      this.Bmk.setImageResource(2131234476);
      this.ptD.stopTimer();
      this.Bmn.setVisibility(8);
      this.Bmo.setVisibility(0);
      this.mSurfaceView.setVisibility(0);
    }
    this.Bmj.fbk();
    ad.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(29355);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29354);
    if ((!this.BmA) && ((this.Bmj.b(this, false) != 0) || (this.Bmj.b(this.kmw) != 0))) {
      enx();
    }
    this.BmA = false;
    ad.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(29354);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29347);
    super.onStart();
    if (this.Bmw)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI
 * JD-Core Version:    0.7.0.1
 */