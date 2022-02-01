package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
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
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.m.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.w.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI MiK;
  private MMHandler Fvy;
  private LinearLayout MiA;
  private ImageView MiB;
  private ImageButton MiC;
  private ImageView MiD;
  private TextView MiE;
  private TextView MiF;
  private TextView MiG;
  private int MiH;
  private boolean MiI;
  private ImageButton MiJ;
  private boolean MiL;
  private boolean MiM;
  private String MiN;
  private View MiO;
  private View MiP;
  SurfaceHolder.Callback MiQ;
  private String Mir;
  private com.tencent.mm.pluginsdk.m.b Miv;
  private ImageButton Miw;
  private boolean Mix;
  private boolean Miy;
  private TextView Miz;
  private ProgressDialog iXX;
  private SurfaceHolder jAv;
  private SurfaceView mSurfaceView;
  private String pqA;
  private String talker;
  private MTimerHandler urE;
  private long urt;
  private String videoPath;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(29345);
    this.mSurfaceView = null;
    this.jAv = null;
    this.talker = null;
    this.iXX = null;
    this.Mix = false;
    this.Miy = false;
    this.urt = -1L;
    this.MiC = null;
    this.MiH = 0;
    this.MiL = false;
    this.MiM = true;
    this.videoPath = null;
    this.Mir = null;
    this.pqA = null;
    this.MiN = null;
    this.urE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29331);
        if (VideoRecorderUI.a(VideoRecorderUI.this) == -1L) {
          VideoRecorderUI.a(VideoRecorderUI.this, SystemClock.elapsedRealtime());
        }
        long l1 = VideoRecorderUI.a(VideoRecorderUI.this);
        l1 = SystemClock.elapsedRealtime() - l1;
        VideoRecorderUI.b(VideoRecorderUI.this).setText(g.formatSecToMin((int)(l1 / 1000L)));
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
    this.Fvy = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29342);
        super.handleMessage(paramAnonymousMessage);
        VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(true);
        AppMethodBeat.o(29342);
      }
    };
    this.MiQ = new SurfaceHolder.Callback()
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
        if (VideoRecorderUI.h(VideoRecorderUI.this).e(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) {
          VideoRecorderUI.s(VideoRecorderUI.this);
        }
        AppMethodBeat.o(29333);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(29334);
        Log.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(VideoRecorderUI.this, true);
        VideoRecorderUI.h(VideoRecorderUI.this).hiS();
        AppMethodBeat.o(29334);
      }
    };
    AppMethodBeat.o(29345);
  }
  
  private void gib()
  {
    AppMethodBeat.i(29352);
    if (this.Mix)
    {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.video_recorder_cancel), getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void gic()
  {
    AppMethodBeat.i(29357);
    com.tencent.mm.ui.base.h.a(this, R.l.video_dev_create_failed, R.l.app_tip, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29336);
        VideoRecorderUI.h(VideoRecorderUI.this).hiS();
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
    this.MiE.setText(g.formatSecToMin(0));
    this.MiO.setVisibility(8);
    this.MiP.setVisibility(8);
    this.MiD.setVisibility(0);
    this.Mix = false;
    this.MiA.setVisibility(0);
    this.mSurfaceView.setVisibility(0);
    this.Miz.setVisibility(8);
    this.MiC.setVisibility(8);
    this.MiE.setText(g.formatSecToMin(0));
    this.MiB.setVisibility(8);
    this.Miw.setEnabled(true);
    this.MiJ.setVisibility(0);
    AppMethodBeat.o(29353);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(29350);
    ar.p(ar.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29350);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(29359);
    if (d.aum()) {}
    for (boolean bool = true;; bool = false)
    {
      this.MiI = bool;
      if (this.MiI) {
        break;
      }
      i = R.i.elI;
      AppMethodBeat.o(29359);
      return i;
    }
    getWindow().setFlags(1024, 1024);
    setRequestedOrientation(0);
    int i = R.i.elJ;
    AppMethodBeat.o(29359);
    return i;
  }
  
  public void initView()
  {
    int j = 1;
    AppMethodBeat.i(29349);
    this.mSurfaceView = ((SurfaceView)findViewById(R.h.dVU));
    this.MiA = ((LinearLayout)findViewById(R.h.video_recorder_preview_area));
    this.jAv = this.mSurfaceView.getHolder();
    this.jAv.addCallback(this.MiQ);
    this.jAv.setType(3);
    this.MiD = ((ImageView)findViewById(R.h.dYY));
    this.MiJ = ((ImageButton)findViewById(R.h.dZb));
    this.MiE = ((TextView)findViewById(R.h.dYW));
    this.MiO = findViewById(R.h.dYX);
    this.MiP = findViewById(R.h.dYS);
    this.MiE.setText(g.formatSecToMin(0));
    this.Miv = new com.tencent.mm.pluginsdk.m.b();
    this.Miz = ((TextView)findViewById(R.h.dZd));
    this.MiF = ((TextView)findViewById(R.h.dYZ));
    this.MiG = ((TextView)findViewById(R.h.dYT));
    this.Miw = ((ImageButton)findViewById(R.h.dZc));
    this.Miw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29340);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        bh.beI();
        if (!c.isSDCardAvailable())
        {
          w.g(VideoRecorderUI.this, null);
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
            com.tencent.mm.ui.base.h.a(VideoRecorderUI.this, VideoRecorderUI.this.getString(R.l.video_recorder_restart), VideoRecorderUI.this.getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29339);
                VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(R.g.dps);
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
            VideoRecorderUI.m(VideoRecorderUI.this).setImageResource(R.g.dps);
            VideoRecorderUI.n(VideoRecorderUI.this);
          }
        }
      }
    });
    com.tencent.mm.pluginsdk.m.b localb;
    label314:
    Object localObject;
    if (d.auj() > 1)
    {
      this.MiJ.setVisibility(0);
      this.MiJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(false);
          VideoRecorderUI.p(VideoRecorderUI.this).sendEmptyMessageDelayed(0, 3000L);
          VideoRecorderUI.a(VideoRecorderUI.this, true);
          VideoRecorderUI.h(VideoRecorderUI.this).hiS();
          if ((VideoRecorderUI.h(VideoRecorderUI.this).e(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) || (VideoRecorderUI.h(VideoRecorderUI.this).e(VideoRecorderUI.r(VideoRecorderUI.this)) != 0)) {
            VideoRecorderUI.s(VideoRecorderUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29341);
        }
      });
      this.MiC = ((ImageButton)findViewById(R.h.dYR));
      this.MiB = ((ImageView)findViewById(R.h.dYV));
      this.MiC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).JvN.lvw);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderUI.this, 0, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29343);
        }
      });
      localb = this.Miv;
      if (this.MiI) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.Mir;
      String str2 = this.pqA;
      String str3 = this.MiN;
      localb.mfT = 0;
      if (1 != localb.mfT) {
        break label584;
      }
      localb.JvN = com.tencent.mm.pluginsdk.m.a.hiR();
      label358:
      if (af.juJ.juo)
      {
        localb.JvN.kUC = af.juJ.mVideoHeight;
        localb.JvN.kUB = af.juJ.mVideoWidth;
        localb.JvN.Faq = af.juJ.juq;
      }
      localb.filename = str3;
      localb.JvN.Fax = str1;
      localb.JvN.Fav = str2;
      localb.JvN.Fau = ((String)localObject + "temp.pcm");
      localb.JvN.Fat = ((String)localObject + "temp.yuv");
      localb.JvN.Faw = ((String)localObject + "temp.vid");
      localb.JvN.Faz = d.auj();
      localObject = localb.JvN;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((com.tencent.mm.pluginsdk.m.a)localObject).fSM = i;
      localb.JvN.lvw = 0;
      localb.Rbi = new com.tencent.mm.pluginsdk.m.h();
      AppMethodBeat.o(29349);
      return;
      this.MiJ.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.JvN = com.tencent.mm.pluginsdk.m.a.hiQ();
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
    MiK = this;
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
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).JvN.lvw);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29337);
        return true;
      }
    }, null, w.b.Wao);
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
    this.Mir = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.pqA = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.MiN = getIntent().getStringExtra("VideoRecorder_FileName");
    Log.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    Log.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.Mir + " videoThumbPath " + this.pqA + " KFileName " + this.MiN);
    initView();
    resetStatus();
    bh.abL().aqn();
    AppMethodBeat.o(29346);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29348);
    MiK = null;
    Log.v("MicroMsg.VideoRecorderUI", "on destroy");
    bh.abL().aqm();
    super.onDestroy();
    AppMethodBeat.o(29348);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29351);
    if (paramInt == 4)
    {
      Log.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.Miy)
      {
        AppMethodBeat.o(29351);
        return true;
      }
      gib();
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
    if (this.Miy)
    {
      com.tencent.mm.pluginsdk.m.b localb = this.Miv;
      if (localb.FbE != null)
      {
        localb.FbE.stop();
        localb.FbE.release();
        localb.FbE = null;
      }
      resetStatus();
      this.Miy = false;
      releaseWakeLock();
      this.Miw.setImageResource(R.g.dpr);
      this.urE.stopTimer();
      this.Miz.setVisibility(8);
      this.MiA.setVisibility(0);
      this.mSurfaceView.setVisibility(0);
    }
    this.Miv.hiS();
    Log.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(29355);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29354);
    if ((!this.MiM) && ((this.Miv.e(this, false) != 0) || (this.Miv.e(this.jAv) != 0))) {
      gic();
    }
    this.MiM = false;
    Log.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(29354);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29347);
    super.onStart();
    if (this.MiI)
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