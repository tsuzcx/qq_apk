package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.v;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI pzx;
  private ProgressDialog dnm = null;
  private SurfaceView gab = null;
  private am ibI = new am(new VideoRecorderUI.1(this), true);
  private long ibp = -1L;
  private boolean nOX;
  private String pzA = null;
  private String pzB = null;
  private View pzC;
  private View pzD;
  private ah pzE = new VideoRecorderUI.9(this);
  SurfaceHolder.Callback pzF = new VideoRecorderUI.3(this);
  private String pze = null;
  private SurfaceHolder pzi = null;
  private b pzj;
  private ImageButton pzk;
  private boolean pzl = false;
  private boolean pzm = false;
  private TextView pzn;
  private LinearLayout pzo;
  private ImageView pzp;
  private ImageButton pzq = null;
  private ImageView pzr;
  private TextView pzs;
  private TextView pzt;
  private TextView pzu;
  private int pzv = 0;
  private ImageButton pzw;
  private boolean pzy = false;
  private boolean pzz = true;
  private String talker = null;
  private String videoPath = null;
  
  private void bMm()
  {
    if (this.pzl)
    {
      h.a(this, getString(R.l.video_recorder_cancel), getString(R.l.app_tip), new VideoRecorderUI.11(this), new VideoRecorderUI.12(this));
      return;
    }
    finish();
  }
  
  private void bMn()
  {
    h.a(this, R.l.video_dev_create_failed, R.l.app_tip, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VideoRecorderUI.h(VideoRecorderUI.this).clT();
        VideoRecorderUI.this.finish();
      }
    });
  }
  
  private void bcB()
  {
    getSupportActionBar().hide();
    this.pzs.setText(e.jL(0));
    this.pzC.setVisibility(8);
    this.pzD.setVisibility(8);
    this.pzr.setVisibility(0);
    this.pzl = false;
    this.pzo.setVisibility(0);
    this.gab.setVisibility(0);
    this.pzn.setVisibility(8);
    this.pzq.setVisibility(8);
    this.pzs.setText(e.jL(0));
    this.pzp.setVisibility(8);
    this.pzk.setEnabled(true);
    this.pzw.setVisibility(0);
  }
  
  private void releaseWakeLock()
  {
    this.gab.setKeepScreenOn(false);
  }
  
  protected final void dealContentView(View paramView)
  {
    ak.g(ak.a(getWindow(), null), this.mController.uMz);
    ((ViewGroup)this.mController.uMz.getParent()).removeView(this.mController.uMz);
    ((ViewGroup)getWindow().getDecorView()).addView(this.mController.uMz, 0);
  }
  
  protected final int getLayoutId()
  {
    if (d.yN()) {}
    for (boolean bool = true;; bool = false)
    {
      this.nOX = bool;
      if (this.nOX) {
        break;
      }
      return R.i.video_recorder;
    }
    getWindow().setFlags(1024, 1024);
    setRequestedOrientation(0);
    return R.i.video_recorder_land;
  }
  
  protected final void initView()
  {
    int j = 1;
    this.gab = ((SurfaceView)findViewById(R.h.surface_camera));
    this.pzo = ((LinearLayout)findViewById(R.h.video_recorder_preview_area));
    this.pzi = this.gab.getHolder();
    this.pzi.addCallback(this.pzF);
    this.pzi.setType(3);
    this.pzr = ((ImageView)findViewById(R.h.video_recorder_recording_icon));
    this.pzw = ((ImageButton)findViewById(R.h.videorecord_camera_switch));
    this.pzs = ((TextView)findViewById(R.h.video_recorder_recorded_time));
    this.pzC = findViewById(R.h.video_recorder_recorded_time_area);
    this.pzD = findViewById(R.h.video_recorder_data_area);
    this.pzs.setText(e.jL(0));
    this.pzj = new b();
    this.pzn = ((TextView)findViewById(R.h.videorecord_time_limit_tv));
    this.pzt = ((TextView)findViewById(R.h.video_recorder_size));
    this.pzu = ((TextView)findViewById(R.h.video_recorder_length));
    this.pzk = ((ImageButton)findViewById(R.h.videorecord_control_btn));
    this.pzk.setOnClickListener(new VideoRecorderUI.7(this));
    b localb;
    label308:
    Object localObject;
    if (d.getNumberOfCameras() > 1)
    {
      this.pzw.setVisibility(0);
      this.pzw.setOnClickListener(new VideoRecorderUI.8(this));
      this.pzq = ((ImageButton)findViewById(R.h.video_play_btn));
      this.pzp = ((ImageView)findViewById(R.h.video_recorder_play_view));
      this.pzq.setOnClickListener(new VideoRecorderUI.10(this));
      localb = this.pzj;
      if (this.nOX) {
        break label567;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.pze;
      String str2 = this.pzA;
      String str3 = this.pzB;
      localb.eFO = 0;
      if (1 != localb.eFO) {
        break label572;
      }
      localb.oiw = a.clS();
      label352:
      if (q.dyf.dyH)
      {
        localb.oiw.mhT = q.dyf.mVideoHeight;
        localb.oiw.mhU = q.dyf.mVideoWidth;
        localb.oiw.mhS = q.dyf.dyJ;
      }
      localb.filename = str3;
      localb.oiw.mib = str1;
      localb.oiw.mhZ = str2;
      localb.oiw.mhY = ((String)localObject + "temp.pcm");
      localb.oiw.mhX = ((String)localObject + "temp.yuv");
      localb.oiw.mia = ((String)localObject + "temp.vid");
      localb.oiw.jlS = d.getNumberOfCameras();
      localObject = localb.oiw;
      if (i == 0) {
        break label582;
      }
    }
    label567:
    label572:
    label582:
    for (int i = j;; i = 0)
    {
      ((a)localObject).rotate = i;
      localb.oiw.eHH = 0;
      localb.rYj = new f();
      return;
      this.pzw.setVisibility(4);
      break;
      i = 0;
      break label308;
      localb.oiw = a.clR();
      break label352;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 == 0)
    {
      setResult(-1, paramIntent);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    s.initLanguage(this);
    pzx = this;
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    setMMTitle(R.l.video_recorder_title);
    a(0, getString(R.l.app_send), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
        paramAnonymousMenuItem.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).oiw.eHH);
        paramAnonymousMenuItem.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
        VideoRecorderUI.this.setResult(-1, paramAnonymousMenuItem);
        VideoRecorderUI.this.finish();
        return true;
      }
    }, s.b.uNx);
    setBackBtn(new VideoRecorderUI.6(this));
    this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
    this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
    this.pze = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.pzA = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.pzB = getIntent().getStringExtra("VideoRecorder_FileName");
    y.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    y.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.pze + " videoThumbPath " + this.pzA + " KFileName " + this.pzB);
    initView();
    bcB();
    au.tu().vT();
  }
  
  protected void onDestroy()
  {
    pzx = null;
    y.v("MicroMsg.VideoRecorderUI", "on destroy");
    au.tu().vS();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.pzm) {
        return true;
      }
      bMm();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.pzm)
    {
      b localb = this.pzj;
      if (localb.mjf != null)
      {
        localb.mjf.stop();
        localb.mjf.release();
        localb.mjf = null;
      }
      bcB();
      this.pzm = false;
      releaseWakeLock();
      this.pzk.setImageResource(R.g.video_recorder_start_btn);
      this.ibI.stopTimer();
      this.pzn.setVisibility(8);
      this.pzo.setVisibility(0);
      this.gab.setVisibility(0);
    }
    this.pzj.clT();
    y.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
  }
  
  protected void onResume()
  {
    if ((!this.pzz) && ((this.pzj.a(this, false) != 0) || (this.pzj.b(this.pzi) != 0))) {
      bMn();
    }
    this.pzz = false;
    y.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.nOX)
    {
      setRequestedOrientation(0);
      return;
    }
    setRequestedOrientation(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI
 * JD-Core Version:    0.7.0.1
 */