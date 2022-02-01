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
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.l.g;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI BDX;
  private String BDE;
  private com.tencent.mm.pluginsdk.l.b BDI;
  private ImageButton BDJ;
  private boolean BDK;
  private boolean BDL;
  private TextView BDM;
  private LinearLayout BDN;
  private ImageView BDO;
  private ImageButton BDP;
  private ImageView BDQ;
  private TextView BDR;
  private TextView BDS;
  private TextView BDT;
  private int BDU;
  private boolean BDV;
  private ImageButton BDW;
  private boolean BDY;
  private boolean BDZ;
  private String BEa;
  private View BEb;
  private View BEc;
  SurfaceHolder.Callback BEd;
  private ProgressDialog fOC;
  private SurfaceHolder kpM;
  private String lmw;
  private SurfaceView mSurfaceView;
  private aw pAh;
  private long pzW;
  private String talker;
  private String videoPath;
  private aq wtz;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(29345);
    this.mSurfaceView = null;
    this.kpM = null;
    this.talker = null;
    this.fOC = null;
    this.BDK = false;
    this.BDL = false;
    this.pzW = -1L;
    this.BDP = null;
    this.BDU = 0;
    this.BDY = false;
    this.BDZ = true;
    this.videoPath = null;
    this.BDE = null;
    this.lmw = null;
    this.BEa = null;
    this.pAh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29331);
        if (VideoRecorderUI.a(VideoRecorderUI.this) == -1L) {
          VideoRecorderUI.a(VideoRecorderUI.this, SystemClock.elapsedRealtime());
        }
        long l1 = VideoRecorderUI.a(VideoRecorderUI.this);
        l1 = SystemClock.elapsedRealtime() - l1;
        VideoRecorderUI.b(VideoRecorderUI.this).setText(f.rb((int)(l1 / 1000L)));
        if ((l1 <= 30000L) && (l1 >= 20000L))
        {
          long l2 = (30000L - l1) / 1000L;
          VideoRecorderUI.c(VideoRecorderUI.this).setVisibility(0);
          VideoRecorderUI.c(VideoRecorderUI.this).setText(VideoRecorderUI.this.getResources().getQuantityString(2131623972, (int)l2, new Object[] { Long.valueOf(l2) }));
        }
        while (l1 >= 30000L)
        {
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
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
    this.wtz = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29342);
        super.handleMessage(paramAnonymousMessage);
        VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(true);
        AppMethodBeat.o(29342);
      }
    };
    this.BEd = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(29335);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + paramAnonymousInt1 + " w:" + paramAnonymousInt2 + " h:" + paramAnonymousInt3);
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
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
        if (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) {
          VideoRecorderUI.s(VideoRecorderUI.this);
        }
        AppMethodBeat.o(29333);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(29334);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(VideoRecorderUI.this, true);
        VideoRecorderUI.h(VideoRecorderUI.this).feY();
        AppMethodBeat.o(29334);
      }
    };
    AppMethodBeat.o(29345);
  }
  
  private void erd()
  {
    AppMethodBeat.i(29352);
    if (this.BDK)
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
  
  private void ere()
  {
    AppMethodBeat.i(29357);
    h.a(this, 2131764670, 2131755906, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29336);
        VideoRecorderUI.h(VideoRecorderUI.this).feY();
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
    this.BDR.setText(f.rb(0));
    this.BEb.setVisibility(8);
    this.BEc.setVisibility(8);
    this.BDQ.setVisibility(0);
    this.BDK = false;
    this.BDN.setVisibility(0);
    this.mSurfaceView.setVisibility(0);
    this.BDM.setVisibility(8);
    this.BDP.setVisibility(8);
    this.BDR.setText(f.rb(0));
    this.BDO.setVisibility(8);
    this.BDJ.setEnabled(true);
    this.BDW.setVisibility(0);
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
    if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaA == 1)
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
    }
    for (;;)
    {
      this.BDV = bool;
      if (this.BDV) {
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
    this.BDN = ((LinearLayout)findViewById(2131306384));
    this.kpM = this.mSurfaceView.getHolder();
    this.kpM.addCallback(this.BEd);
    this.kpM.setType(3);
    this.BDQ = ((ImageView)findViewById(2131306387));
    this.BDW = ((ImageButton)findViewById(2131306416));
    this.BDR = ((TextView)findViewById(2131306385));
    this.BEb = findViewById(2131306386);
    this.BEc = findViewById(2131306380);
    this.BDR.setText(f.rb(0));
    this.BDI = new com.tencent.mm.pluginsdk.l.b();
    this.BDM = ((TextView)findViewById(2131306421));
    this.BDS = ((TextView)findViewById(2131306388));
    this.BDT = ((TextView)findViewById(2131306381));
    this.BDJ = ((ImageButton)findViewById(2131306418));
    this.BDJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29340);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        bc.aCg();
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
      this.BDW.setVisibility(0);
      this.BDW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          VideoRecorderUI.o(VideoRecorderUI.this).setEnabled(false);
          VideoRecorderUI.p(VideoRecorderUI.this).sendEmptyMessageDelayed(0, 3000L);
          VideoRecorderUI.a(VideoRecorderUI.this, true);
          VideoRecorderUI.h(VideoRecorderUI.this).feY();
          if ((VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.this, VideoRecorderUI.q(VideoRecorderUI.this)) != 0) || (VideoRecorderUI.h(VideoRecorderUI.this).b(VideoRecorderUI.r(VideoRecorderUI.this)) != 0)) {
            VideoRecorderUI.s(VideoRecorderUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29341);
        }
      });
      this.BDP = ((ImageButton)findViewById(2131306364));
      this.BDO = ((ImageView)findViewById(2131306383));
      this.BDP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).zlr.hKI);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          VideoRecorderUI.this.overridePendingTransition(0, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29343);
        }
      });
      localb = this.BDI;
      if (this.BDV) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.BDE;
      String str2 = this.lmw;
      String str3 = this.BEa;
      localb.ivg = 0;
      if (1 != localb.ivg) {
        break label584;
      }
      localb.zlr = com.tencent.mm.pluginsdk.l.a.feX();
      label358:
      if (com.tencent.mm.compatible.deviceinfo.ae.geO.gez)
      {
        localb.zlr.waN = com.tencent.mm.compatible.deviceinfo.ae.geO.mVideoHeight;
        localb.zlr.waO = com.tencent.mm.compatible.deviceinfo.ae.geO.mVideoWidth;
        localb.zlr.waM = com.tencent.mm.compatible.deviceinfo.ae.geO.geB;
      }
      localb.filename = str3;
      localb.zlr.waV = str1;
      localb.zlr.waT = str2;
      localb.zlr.waS = ((String)localObject + "temp.pcm");
      localb.zlr.waR = ((String)localObject + "temp.yuv");
      localb.zlr.waU = ((String)localObject + "temp.vid");
      localb.zlr.waX = d.getNumberOfCameras();
      localObject = localb.zlr;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((com.tencent.mm.pluginsdk.l.a)localObject).dHi = i;
      localb.zlr.hKI = 0;
      localb.FjN = new g();
      AppMethodBeat.o(29349);
      return;
      this.BDW.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.zlr = com.tencent.mm.pluginsdk.l.a.feW();
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
    BDX = this;
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
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).zlr.hKI);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        AppMethodBeat.o(29337);
        return true;
      }
    }, null, s.b.JwA);
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
    this.BDE = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.lmw = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.BEa = getIntent().getStringExtra("VideoRecorder_FileName");
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.BDE + " videoThumbPath " + this.lmw + " KFileName " + this.BEa);
    initView();
    resetStatus();
    bc.MW().WD();
    AppMethodBeat.o(29346);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29348);
    BDX = null;
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoRecorderUI", "on destroy");
    bc.MW().WC();
    super.onDestroy();
    AppMethodBeat.o(29348);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29351);
    if (paramInt == 4)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.BDL)
      {
        AppMethodBeat.o(29351);
        return true;
      }
      erd();
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
    if (this.BDL)
    {
      com.tencent.mm.pluginsdk.l.b localb = this.BDI;
      if (localb.wcd != null)
      {
        localb.wcd.stop();
        localb.wcd.release();
        localb.wcd = null;
      }
      resetStatus();
      this.BDL = false;
      releaseWakeLock();
      this.BDJ.setImageResource(2131234476);
      this.pAh.stopTimer();
      this.BDM.setVisibility(8);
      this.BDN.setVisibility(0);
      this.mSurfaceView.setVisibility(0);
    }
    this.BDI.feY();
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(29355);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29354);
    if ((!this.BDZ) && ((this.BDI.b(this, false) != 0) || (this.BDI.b(this.kpM) != 0))) {
      ere();
    }
    this.BDZ = false;
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(29354);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29347);
    super.onStart();
    if (this.BDV)
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