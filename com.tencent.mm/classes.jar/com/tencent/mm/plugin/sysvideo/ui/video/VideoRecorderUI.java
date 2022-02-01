package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
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
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.l.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI SMg;
  private MMHandler LrM;
  private String SLN;
  private com.tencent.mm.pluginsdk.l.b SLR;
  private ImageButton SLS;
  private boolean SLT;
  private boolean SLU;
  private TextView SLV;
  private LinearLayout SLW;
  private ImageView SLX;
  private ImageButton SLY;
  private ImageView SLZ;
  private TextView SMa;
  private TextView SMb;
  private TextView SMc;
  private int SMd;
  private boolean SMe;
  private ImageButton SMf;
  private boolean SMh;
  private boolean SMi;
  private String SMj;
  private View SMk;
  private View SMl;
  SurfaceHolder.Callback SMm;
  private ProgressDialog lzP;
  private SurfaceView mSurfaceView;
  private SurfaceHolder rsd;
  private String svn;
  private String talker;
  private String videoPath;
  private long xxO;
  private MTimerHandler xxZ;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(29345);
    this.mSurfaceView = null;
    this.rsd = null;
    this.talker = null;
    this.lzP = null;
    this.SLT = false;
    this.SLU = false;
    this.xxO = -1L;
    this.SLY = null;
    this.SMd = 0;
    this.SMh = false;
    this.SMi = true;
    this.videoPath = null;
    this.SLN = null;
    this.svn = null;
    this.SMj = null;
    this.xxZ = new MTimerHandler(new MTimerHandler.CallBack()
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
          VideoRecorderUI.c(VideoRecorderUI.this).setText(VideoRecorderUI.this.getResources().getQuantityString(R.j.video_recorder_time_limit, (int)l2, new Object[] { Long.valueOf(l2) }));
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
    this.LrM = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29342);
        super.handleMessage(paramAnonymousMessage);
        VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(true);
        AppMethodBeat.o(29342);
      }
    };
    this.SMm = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(29335);
        Log.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + paramAnonymousInt1 + " w:" + paramAnonymousInt2 + " h:" + paramAnonymousInt3);
        if (VideoRecorderUI.h(VideoRecorderUI.this).e(paramAnonymousSurfaceHolder) != 0) {
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
        if (VideoRecorderUI.h(VideoRecorderUI.this).f(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) {
          VideoRecorderUI.s(VideoRecorderUI.this);
        }
        AppMethodBeat.o(29333);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(29334);
        Log.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(VideoRecorderUI.this, true);
        VideoRecorderUI.h(VideoRecorderUI.this).iJS();
        AppMethodBeat.o(29334);
      }
    };
    AppMethodBeat.o(29345);
  }
  
  private void hCc()
  {
    AppMethodBeat.i(29352);
    if (this.SLT)
    {
      k.a(this, getString(R.l.video_recorder_cancel), getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void hCd()
  {
    AppMethodBeat.i(29357);
    k.a(this, R.l.video_dev_create_failed, R.l.app_tip, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29336);
        VideoRecorderUI.h(VideoRecorderUI.this).iJS();
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
    this.SMa.setText(f.formatSecToMin(0));
    this.SMk.setVisibility(8);
    this.SMl.setVisibility(8);
    this.SLZ.setVisibility(0);
    this.SLT = false;
    this.SLW.setVisibility(0);
    this.mSurfaceView.setVisibility(0);
    this.SLV.setVisibility(8);
    this.SLY.setVisibility(8);
    this.SMa.setText(f.formatSecToMin(0));
    this.SLX.setVisibility(8);
    this.SLS.setEnabled(true);
    this.SMf.setVisibility(0);
    AppMethodBeat.o(29353);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(29350);
    aw.y(aw.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29350);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(29359);
    if (d.aOH()) {}
    for (boolean bool = true;; bool = false)
    {
      this.SMe = bool;
      if (this.SMe) {
        break;
      }
      i = R.i.goM;
      AppMethodBeat.o(29359);
      return i;
    }
    getWindow().setFlags(1024, 1024);
    setRequestedOrientation(0);
    int i = R.i.goN;
    AppMethodBeat.o(29359);
    return i;
  }
  
  public void initView()
  {
    int j = 1;
    AppMethodBeat.i(29349);
    this.mSurfaceView = ((SurfaceView)findViewById(R.h.fYv));
    this.SLW = ((LinearLayout)findViewById(R.h.video_recorder_preview_area));
    this.rsd = this.mSurfaceView.getHolder();
    this.rsd.addCallback(this.SMm);
    this.rsd.setType(3);
    this.SLZ = ((ImageView)findViewById(R.h.gbM));
    this.SMf = ((ImageButton)findViewById(R.h.gbQ));
    this.SMa = ((TextView)findViewById(R.h.gbK));
    this.SMk = findViewById(R.h.gbL);
    this.SMl = findViewById(R.h.gbG);
    this.SMa.setText(f.formatSecToMin(0));
    this.SLR = new com.tencent.mm.pluginsdk.l.b();
    this.SLV = ((TextView)findViewById(R.h.gbS));
    this.SMb = ((TextView)findViewById(R.h.gbN));
    this.SMc = ((TextView)findViewById(R.h.gbH));
    this.SLS = ((ImageButton)findViewById(R.h.gbR));
    this.SLS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29340);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        bh.bCz();
        if (!c.isSDCardAvailable())
        {
          aa.j(VideoRecorderUI.this, null);
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
            k.a(VideoRecorderUI.this, VideoRecorderUI.this.getString(R.l.video_recorder_restart), VideoRecorderUI.this.getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29339);
                VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(R.g.fpH);
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
            VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(R.g.fpH);
            VideoRecorderUI.n(VideoRecorderUI.this);
          }
        }
      }
    });
    com.tencent.mm.pluginsdk.l.b localb;
    label314:
    Object localObject;
    if (d.aOG() > 1)
    {
      this.SMf.setVisibility(0);
      this.SMf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(false);
          VideoRecorderUI.p(VideoRecorderUI.this).sendEmptyMessageDelayed(0, 3000L);
          VideoRecorderUI.a(VideoRecorderUI.this, true);
          VideoRecorderUI.h(VideoRecorderUI.this).iJS();
          if ((VideoRecorderUI.h(VideoRecorderUI.this).f(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) || (VideoRecorderUI.h(VideoRecorderUI.this).e(VideoRecorderUI.r(VideoRecorderUI.this)) != 0)) {
            VideoRecorderUI.s(VideoRecorderUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29341);
        }
      });
      this.SLY = ((ImageButton)findViewById(R.h.gbF));
      this.SLX = ((ImageView)findViewById(R.h.gbJ));
      this.SLY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).PJl.omT);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderUI.this, 0, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29343);
        }
      });
      localb = this.SLR;
      if (this.SMe) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.SLN;
      String str2 = this.svn;
      String str3 = this.SMj;
      localb.oYP = 0;
      if (1 != localb.oYP) {
        break label584;
      }
      localb.PJl = com.tencent.mm.pluginsdk.l.a.iJR();
      label358:
      if (af.lYa.lXF)
      {
        localb.PJl.nAh = af.lYa.mVideoHeight;
        localb.PJl.nAg = af.lYa.mVideoWidth;
        localb.PJl.KWa = af.lYa.lXH;
      }
      localb.filename = str3;
      localb.PJl.KWh = str1;
      localb.PJl.KWf = str2;
      localb.PJl.KWe = ((String)localObject + "temp.pcm");
      localb.PJl.KWd = ((String)localObject + "temp.yuv");
      localb.PJl.KWg = ((String)localObject + "temp.vid");
      localb.PJl.nvv = d.aOG();
      localObject = localb.PJl;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((com.tencent.mm.pluginsdk.l.a)localObject).hYK = i;
      localb.PJl.omT = 0;
      localb.XXo = new g();
      AppMethodBeat.o(29349);
      return;
      this.SMf.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.PJl = com.tencent.mm.pluginsdk.l.a.iJQ();
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
    SMg = this;
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    setMMTitle(R.l.video_recorder_title);
    addTextOptionMenu(0, getString(R.l.app_send), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29337);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).PJl.omT);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29337);
        return true;
      }
    }, null, y.b.adEJ);
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
    this.SLN = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.svn = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.SMj = getIntent().getStringExtra("VideoRecorder_FileName");
    Log.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    Log.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.SLN + " videoThumbPath " + this.svn + " KFileName " + this.SMj);
    initView();
    resetStatus();
    bh.aDI().aKl();
    AppMethodBeat.o(29346);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29348);
    SMg = null;
    Log.v("MicroMsg.VideoRecorderUI", "on destroy");
    bh.aDI().aKk();
    super.onDestroy();
    AppMethodBeat.o(29348);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29351);
    if (paramInt == 4)
    {
      Log.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.SLU)
      {
        AppMethodBeat.o(29351);
        return true;
      }
      hCc();
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
    if (this.SLU)
    {
      com.tencent.mm.pluginsdk.l.b localb = this.SLR;
      if (localb.KXn != null)
      {
        localb.KXn.stop();
        localb.KXn.release();
        localb.KXn = null;
      }
      resetStatus();
      this.SLU = false;
      releaseWakeLock();
      this.SLS.setImageResource(R.g.fpG);
      this.xxZ.stopTimer();
      this.SLV.setVisibility(8);
      this.SLW.setVisibility(0);
      this.mSurfaceView.setVisibility(0);
    }
    this.SLR.iJS();
    Log.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(29355);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29354);
    if ((!this.SMi) && ((this.SLR.f(this, false) != 0) || (this.SLR.e(this.rsd) != 0))) {
      hCd();
    }
    this.SMi = false;
    Log.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(29354);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29347);
    super.onStart();
    if (this.SMe)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI
 * JD-Core Version:    0.7.0.1
 */