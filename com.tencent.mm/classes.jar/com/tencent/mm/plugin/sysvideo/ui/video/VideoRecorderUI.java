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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI zUU;
  private ProgressDialog fts;
  private SurfaceHolder jSi;
  private String kMh;
  private SurfaceView mSurfaceView;
  private long oPI;
  private au oPT;
  private String talker;
  private ao uYY;
  private String videoPath;
  private String zUB;
  private b zUF;
  private ImageButton zUG;
  private boolean zUH;
  private boolean zUI;
  private TextView zUJ;
  private LinearLayout zUK;
  private ImageView zUL;
  private ImageButton zUM;
  private ImageView zUN;
  private TextView zUO;
  private TextView zUP;
  private TextView zUQ;
  private int zUR;
  private boolean zUS;
  private ImageButton zUT;
  private boolean zUV;
  private boolean zUW;
  private String zUX;
  private View zUY;
  private View zUZ;
  SurfaceHolder.Callback zVa;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(29345);
    this.mSurfaceView = null;
    this.jSi = null;
    this.talker = null;
    this.fts = null;
    this.zUH = false;
    this.zUI = false;
    this.oPI = -1L;
    this.zUM = null;
    this.zUR = 0;
    this.zUV = false;
    this.zUW = true;
    this.videoPath = null;
    this.zUB = null;
    this.kMh = null;
    this.zUX = null;
    this.oPT = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29331);
        if (VideoRecorderUI.a(VideoRecorderUI.this) == -1L) {
          VideoRecorderUI.a(VideoRecorderUI.this, SystemClock.elapsedRealtime());
        }
        long l1 = VideoRecorderUI.a(VideoRecorderUI.this);
        l1 = SystemClock.elapsedRealtime() - l1;
        VideoRecorderUI.b(VideoRecorderUI.this).setText(f.qy((int)(l1 / 1000L)));
        if ((l1 <= 30000L) && (l1 >= 20000L))
        {
          long l2 = (30000L - l1) / 1000L;
          VideoRecorderUI.c(VideoRecorderUI.this).setVisibility(0);
          VideoRecorderUI.c(VideoRecorderUI.this).setText(VideoRecorderUI.this.getResources().getQuantityString(2131623972, (int)l2, new Object[] { Long.valueOf(l2) }));
        }
        while (l1 >= 30000L)
        {
          ac.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
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
    this.uYY = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29342);
        super.handleMessage(paramAnonymousMessage);
        VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(true);
        AppMethodBeat.o(29342);
      }
    };
    this.zVa = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(29335);
        ac.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + paramAnonymousInt1 + " w:" + paramAnonymousInt2 + " h:" + paramAnonymousInt3);
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
        ac.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
        if (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) {
          VideoRecorderUI.s(VideoRecorderUI.this);
        }
        AppMethodBeat.o(29333);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(29334);
        ac.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(VideoRecorderUI.this, true);
        VideoRecorderUI.h(VideoRecorderUI.this).eMn();
        AppMethodBeat.o(29334);
      }
    };
    AppMethodBeat.o(29345);
  }
  
  private void ebf()
  {
    AppMethodBeat.i(29352);
    if (this.zUH)
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
  
  private void ebg()
  {
    AppMethodBeat.i(29357);
    h.a(this, 2131764670, 2131755906, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29336);
        VideoRecorderUI.h(VideoRecorderUI.this).eMn();
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
    this.zUO.setText(f.qy(0));
    this.zUY.setVisibility(8);
    this.zUZ.setVisibility(8);
    this.zUN.setVisibility(0);
    this.zUH = false;
    this.zUK.setVisibility(0);
    this.mSurfaceView.setVisibility(0);
    this.zUJ.setVisibility(8);
    this.zUM.setVisibility(8);
    this.zUO.setText(f.qy(0));
    this.zUL.setVisibility(8);
    this.zUG.setEnabled(true);
    this.zUT.setVisibility(0);
    AppMethodBeat.o(29353);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(29350);
    aj.m(aj.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29350);
  }
  
  public int getLayoutId()
  {
    boolean bool = true;
    AppMethodBeat.i(29359);
    int i;
    if (ae.fJd.fEU == 1)
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
    }
    for (;;)
    {
      this.zUS = bool;
      if (this.zUS) {
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
    this.zUK = ((LinearLayout)findViewById(2131306384));
    this.jSi = this.mSurfaceView.getHolder();
    this.jSi.addCallback(this.zVa);
    this.jSi.setType(3);
    this.zUN = ((ImageView)findViewById(2131306387));
    this.zUT = ((ImageButton)findViewById(2131306416));
    this.zUO = ((TextView)findViewById(2131306385));
    this.zUY = findViewById(2131306386);
    this.zUZ = findViewById(2131306380);
    this.zUO.setText(f.qy(0));
    this.zUF = new b();
    this.zUJ = ((TextView)findViewById(2131306421));
    this.zUP = ((TextView)findViewById(2131306388));
    this.zUQ = ((TextView)findViewById(2131306381));
    this.zUG = ((ImageButton)findViewById(2131306418));
    this.zUG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29340);
        az.ayM();
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
      this.zUT.setVisibility(0);
      this.zUT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29341);
          VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(false);
          VideoRecorderUI.p(VideoRecorderUI.this).sendEmptyMessageDelayed(0, 3000L);
          VideoRecorderUI.a(VideoRecorderUI.this, true);
          VideoRecorderUI.h(VideoRecorderUI.this).eMn();
          if ((VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) || (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.r(VideoRecorderUI.this)) != 0)) {
            VideoRecorderUI.s(VideoRecorderUI.this);
          }
          AppMethodBeat.o(29341);
        }
      });
      this.zUM = ((ImageButton)findViewById(2131306364));
      this.zUL = ((ImageView)findViewById(2131306383));
      this.zUM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29343);
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).xGx.hpy);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          VideoRecorderUI.this.overridePendingTransition(0, 0);
          AppMethodBeat.o(29343);
        }
      });
      localb = this.zUF;
      if (this.zUS) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.zUB;
      String str2 = this.kMh;
      String str3 = this.zUX;
      localb.hYQ = 0;
      if (1 != localb.hYQ) {
        break label584;
      }
      localb.xGx = a.eMm();
      label358:
      if (ae.fJf.fIQ)
      {
        localb.xGx.uLE = ae.fJf.mVideoHeight;
        localb.xGx.uLF = ae.fJf.mVideoWidth;
        localb.xGx.uLD = ae.fJf.fIS;
      }
      localb.filename = str3;
      localb.xGx.uLM = str1;
      localb.xGx.uLK = str2;
      localb.xGx.uLJ = ((String)localObject + "temp.pcm");
      localb.xGx.uLI = ((String)localObject + "temp.yuv");
      localb.xGx.uLL = ((String)localObject + "temp.vid");
      localb.xGx.uLO = d.getNumberOfCameras();
      localObject = localb.xGx;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((a)localObject).duc = i;
      localb.xGx.hpy = 0;
      localb.Dmq = new g();
      AppMethodBeat.o(29349);
      return;
      this.zUT.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.xGx = a.eMl();
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
    zUU = this;
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
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).xGx.hpy);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29337);
        return true;
      }
    }, null, s.b.Hom);
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
    this.zUB = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.kMh = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.zUX = getIntent().getStringExtra("VideoRecorder_FileName");
    ac.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    ac.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.zUB + " videoThumbPath " + this.kMh + " KFileName " + this.zUX);
    initView();
    resetStatus();
    az.Lt().Ue();
    AppMethodBeat.o(29346);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29348);
    zUU = null;
    ac.v("MicroMsg.VideoRecorderUI", "on destroy");
    az.Lt().Ud();
    super.onDestroy();
    AppMethodBeat.o(29348);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29351);
    if (paramInt == 4)
    {
      ac.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.zUI)
      {
        AppMethodBeat.o(29351);
        return true;
      }
      ebf();
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
    if (this.zUI)
    {
      b localb = this.zUF;
      if (localb.uMS != null)
      {
        localb.uMS.stop();
        localb.uMS.release();
        localb.uMS = null;
      }
      resetStatus();
      this.zUI = false;
      releaseWakeLock();
      this.zUG.setImageResource(2131234476);
      this.oPT.stopTimer();
      this.zUJ.setVisibility(8);
      this.zUK.setVisibility(0);
      this.mSurfaceView.setVisibility(0);
    }
    this.zUF.eMn();
    ac.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(29355);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29354);
    if ((!this.zUW) && ((this.zUF.b(this, false) != 0) || (this.zUF.b(this.jSi) != 0))) {
      ebg();
    }
    this.zUW = false;
    ac.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(29354);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29347);
    super.onStart();
    if (this.zUS)
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