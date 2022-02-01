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
import com.tencent.mm.model.ah;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.j.b;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.j.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.r.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI yHG;
  private ProgressDialog fpP;
  private SurfaceHolder jrQ;
  private String kkP;
  private SurfaceView mSurfaceView;
  private long omi;
  private av omt;
  private ap tQy;
  private String talker;
  private String videoPath;
  private TextView yHA;
  private TextView yHB;
  private TextView yHC;
  private int yHD;
  private boolean yHE;
  private ImageButton yHF;
  private boolean yHH;
  private boolean yHI;
  private String yHJ;
  private View yHK;
  private View yHL;
  SurfaceHolder.Callback yHM;
  private String yHn;
  private b yHr;
  private ImageButton yHs;
  private boolean yHt;
  private boolean yHu;
  private TextView yHv;
  private LinearLayout yHw;
  private ImageView yHx;
  private ImageButton yHy;
  private ImageView yHz;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(29345);
    this.mSurfaceView = null;
    this.jrQ = null;
    this.talker = null;
    this.fpP = null;
    this.yHt = false;
    this.yHu = false;
    this.omi = -1L;
    this.yHy = null;
    this.yHD = 0;
    this.yHH = false;
    this.yHI = true;
    this.videoPath = null;
    this.yHn = null;
    this.kkP = null;
    this.yHJ = null;
    this.omt = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29331);
        if (VideoRecorderUI.a(VideoRecorderUI.this) == -1L) {
          VideoRecorderUI.a(VideoRecorderUI.this, SystemClock.elapsedRealtime());
        }
        long l1 = VideoRecorderUI.a(VideoRecorderUI.this);
        l1 = SystemClock.elapsedRealtime() - l1;
        VideoRecorderUI.b(VideoRecorderUI.this).setText(f.pL((int)(l1 / 1000L)));
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
    this.tQy = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29342);
        super.handleMessage(paramAnonymousMessage);
        VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(true);
        AppMethodBeat.o(29342);
      }
    };
    this.yHM = new SurfaceHolder.Callback()
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
        VideoRecorderUI.h(VideoRecorderUI.this).ewT();
        AppMethodBeat.o(29334);
      }
    };
    AppMethodBeat.o(29345);
  }
  
  private void dMF()
  {
    AppMethodBeat.i(29352);
    if (this.yHt)
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
  
  private void dMG()
  {
    AppMethodBeat.i(29357);
    h.a(this, 2131764670, 2131755906, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29336);
        VideoRecorderUI.h(VideoRecorderUI.this).ewT();
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
    this.yHA.setText(f.pL(0));
    this.yHK.setVisibility(8);
    this.yHL.setVisibility(8);
    this.yHz.setVisibility(0);
    this.yHt = false;
    this.yHw.setVisibility(0);
    this.mSurfaceView.setVisibility(0);
    this.yHv.setVisibility(8);
    this.yHy.setVisibility(8);
    this.yHA.setText(f.pL(0));
    this.yHx.setVisibility(8);
    this.yHs.setEnabled(true);
    this.yHF.setVisibility(0);
    AppMethodBeat.o(29353);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(29350);
    ai.l(ai.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29350);
  }
  
  public int getLayoutId()
  {
    boolean bool = true;
    AppMethodBeat.i(29359);
    int i;
    if (ae.fFw.fBn == 1)
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
    }
    for (;;)
    {
      this.yHE = bool;
      if (this.yHE) {
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
    this.yHw = ((LinearLayout)findViewById(2131306384));
    this.jrQ = this.mSurfaceView.getHolder();
    this.jrQ.addCallback(this.yHM);
    this.jrQ.setType(3);
    this.yHz = ((ImageView)findViewById(2131306387));
    this.yHF = ((ImageButton)findViewById(2131306416));
    this.yHA = ((TextView)findViewById(2131306385));
    this.yHK = findViewById(2131306386);
    this.yHL = findViewById(2131306380);
    this.yHA.setText(f.pL(0));
    this.yHr = new b();
    this.yHv = ((TextView)findViewById(2131306421));
    this.yHB = ((TextView)findViewById(2131306388));
    this.yHC = ((TextView)findViewById(2131306381));
    this.yHs = ((ImageButton)findViewById(2131306418));
    this.yHs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29340);
        az.arV();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(VideoRecorderUI.this, null);
          AppMethodBeat.o(29340);
          return;
        }
        if (VideoRecorderUI.k(VideoRecorderUI.this))
        {
          VideoRecorderUI.d(VideoRecorderUI.this);
          AppMethodBeat.o(29340);
          return;
        }
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
          AppMethodBeat.o(29340);
          return;
        }
        VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(2131234477);
        VideoRecorderUI.n(VideoRecorderUI.this);
        AppMethodBeat.o(29340);
      }
    });
    b localb;
    label314:
    Object localObject;
    if (d.getNumberOfCameras() > 1)
    {
      this.yHF.setVisibility(0);
      this.yHF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29341);
          VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(false);
          VideoRecorderUI.p(VideoRecorderUI.this).sendEmptyMessageDelayed(0, 3000L);
          VideoRecorderUI.a(VideoRecorderUI.this, true);
          VideoRecorderUI.h(VideoRecorderUI.this).ewT();
          if ((VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) || (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.r(VideoRecorderUI.this)) != 0)) {
            VideoRecorderUI.s(VideoRecorderUI.this);
          }
          AppMethodBeat.o(29341);
        }
      });
      this.yHy = ((ImageButton)findViewById(2131306364));
      this.yHx = ((ImageView)findViewById(2131306383));
      this.yHy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29343);
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).wvh.gOY);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          VideoRecorderUI.this.overridePendingTransition(0, 0);
          AppMethodBeat.o(29343);
        }
      });
      localb = this.yHr;
      if (this.yHE) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.yHn;
      String str2 = this.kkP;
      String str3 = this.yHJ;
      localb.hyp = 0;
      if (1 != localb.hyp) {
        break label584;
      }
      localb.wvh = a.ewS();
      label358:
      if (ae.fFy.fFj)
      {
        localb.wvh.tDh = ae.fFy.mVideoHeight;
        localb.wvh.tDi = ae.fFy.mVideoWidth;
        localb.wvh.tDg = ae.fFy.fFl;
      }
      localb.filename = str3;
      localb.wvh.tDp = str1;
      localb.wvh.tDn = str2;
      localb.wvh.tDm = ((String)localObject + "temp.pcm");
      localb.wvh.tDl = ((String)localObject + "temp.yuv");
      localb.wvh.tDo = ((String)localObject + "temp.vid");
      localb.wvh.tDr = d.getNumberOfCameras();
      localObject = localb.wvh;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((a)localObject).dwp = i;
      localb.wvh.gOY = 0;
      localb.BUa = new g();
      AppMethodBeat.o(29349);
      return;
      this.yHF.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.wvh = a.ewR();
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
    yHG = this;
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
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).wvh.gOY);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29337);
        return true;
      }
    }, null, r.b.FOB);
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
    this.yHn = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.kkP = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.yHJ = getIntent().getStringExtra("VideoRecorder_FileName");
    ad.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    ad.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.yHn + " videoThumbPath " + this.kkP + " KFileName " + this.yHJ);
    initView();
    resetStatus();
    az.Lv().Tk();
    AppMethodBeat.o(29346);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29348);
    yHG = null;
    ad.v("MicroMsg.VideoRecorderUI", "on destroy");
    az.Lv().Tj();
    super.onDestroy();
    AppMethodBeat.o(29348);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29351);
    if (paramInt == 4)
    {
      ad.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.yHu)
      {
        AppMethodBeat.o(29351);
        return true;
      }
      dMF();
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
    if (this.yHu)
    {
      b localb = this.yHr;
      if (localb.tEx != null)
      {
        localb.tEx.stop();
        localb.tEx.release();
        localb.tEx = null;
      }
      resetStatus();
      this.yHu = false;
      releaseWakeLock();
      this.yHs.setImageResource(2131234476);
      this.omt.stopTimer();
      this.yHv.setVisibility(8);
      this.yHw.setVisibility(0);
      this.mSurfaceView.setVisibility(0);
    }
    this.yHr.ewT();
    ad.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(29355);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29354);
    if ((!this.yHI) && ((this.yHr.b(this, false) != 0) || (this.yHr.b(this.jrQ) != 0))) {
      dMG();
    }
    this.yHI = false;
    ad.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(29354);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29347);
    super.onStart();
    if (this.yHE)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI
 * JD-Core Version:    0.7.0.1
 */