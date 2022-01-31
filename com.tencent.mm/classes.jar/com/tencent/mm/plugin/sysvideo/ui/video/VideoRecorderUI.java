package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
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
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;

public class VideoRecorderUI
  extends MMActivity
{
  private static VideoRecorderUI tbl;
  private ProgressDialog eeN;
  private String iaf;
  private long mwM;
  private ap mwY;
  private ak oVd;
  private boolean qCR;
  private String taR;
  private SurfaceView taV;
  private SurfaceHolder taW;
  private b taX;
  private ImageButton taY;
  private boolean taZ;
  private String talker;
  private boolean tba;
  private TextView tbb;
  private LinearLayout tbc;
  private ImageView tbd;
  private ImageButton tbe;
  private ImageView tbf;
  private TextView tbg;
  private TextView tbh;
  private TextView tbi;
  private int tbj;
  private ImageButton tbk;
  private boolean tbm;
  private boolean tbn;
  private String tbo;
  private View tbp;
  private View tbq;
  SurfaceHolder.Callback tbr;
  private String videoPath;
  
  public VideoRecorderUI()
  {
    AppMethodBeat.i(25657);
    this.taV = null;
    this.taW = null;
    this.talker = null;
    this.eeN = null;
    this.taZ = false;
    this.tba = false;
    this.mwM = -1L;
    this.tbe = null;
    this.tbj = 0;
    this.tbm = false;
    this.tbn = true;
    this.videoPath = null;
    this.taR = null;
    this.iaf = null;
    this.tbo = null;
    this.mwY = new ap(new VideoRecorderUI.1(this), true);
    this.oVd = new VideoRecorderUI.9(this);
    this.tbr = new VideoRecorderUI.3(this);
    AppMethodBeat.o(25657);
  }
  
  private void aEa()
  {
    AppMethodBeat.i(25665);
    getSupportActionBar().hide();
    this.tbg.setText(f.mH(0));
    this.tbp.setVisibility(8);
    this.tbq.setVisibility(8);
    this.tbf.setVisibility(0);
    this.taZ = false;
    this.tbc.setVisibility(0);
    this.taV.setVisibility(0);
    this.tbb.setVisibility(8);
    this.tbe.setVisibility(8);
    this.tbg.setText(f.mH(0));
    this.tbd.setVisibility(8);
    this.taY.setEnabled(true);
    this.tbk.setVisibility(0);
    AppMethodBeat.o(25665);
  }
  
  private void cHl()
  {
    AppMethodBeat.i(25664);
    if (this.taZ)
    {
      h.a(this, getString(2131304532), getString(2131297087), new VideoRecorderUI.11(this), new VideoRecorderUI.12(this));
      AppMethodBeat.o(25664);
      return;
    }
    finish();
    AppMethodBeat.o(25664);
  }
  
  private void cHm()
  {
    AppMethodBeat.i(25669);
    h.a(this, 2131304509, 2131297087, new VideoRecorderUI.4(this));
    AppMethodBeat.o(25669);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(25670);
    this.taV.setKeepScreenOn(false);
    AppMethodBeat.o(25670);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(25662);
    af.h(af.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(25662);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(25671);
    if (d.Ll()) {}
    for (boolean bool = true;; bool = false)
    {
      this.qCR = bool;
      if (this.qCR) {
        break;
      }
      AppMethodBeat.o(25671);
      return 2130971071;
    }
    getWindow().setFlags(1024, 1024);
    setRequestedOrientation(0);
    AppMethodBeat.o(25671);
    return 2130971072;
  }
  
  public void initView()
  {
    int j = 1;
    AppMethodBeat.i(25661);
    this.taV = ((SurfaceView)findViewById(2131827769));
    this.tbc = ((LinearLayout)findViewById(2131821743));
    this.taW = this.taV.getHolder();
    this.taW.addCallback(this.tbr);
    this.taW.setType(3);
    this.tbf = ((ImageView)findViewById(2131828726));
    this.tbk = ((ImageButton)findViewById(2131828728));
    this.tbg = ((TextView)findViewById(2131828727));
    this.tbp = findViewById(2131828725);
    this.tbq = findViewById(2131828730);
    this.tbg.setText(f.mH(0));
    this.taX = new b();
    this.tbb = ((TextView)findViewById(2131828729));
    this.tbh = ((TextView)findViewById(2131828732));
    this.tbi = ((TextView)findViewById(2131828731));
    this.taY = ((ImageButton)findViewById(2131822783));
    this.taY.setOnClickListener(new VideoRecorderUI.7(this));
    b localb;
    label314:
    Object localObject;
    if (d.getNumberOfCameras() > 1)
    {
      this.tbk.setVisibility(0);
      this.tbk.setOnClickListener(new VideoRecorderUI.8(this));
      this.tbe = ((ImageButton)findViewById(2131828733));
      this.tbd = ((ImageView)findViewById(2131828724));
      this.tbe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25655);
          paramAnonymousView = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
          paramAnonymousView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(VideoRecorderUI.this).filename);
          paramAnonymousView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(VideoRecorderUI.this).qWJ.fXx);
          paramAnonymousView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(VideoRecorderUI.this).fileSize);
          paramAnonymousView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(VideoRecorderUI.this));
          paramAnonymousView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(VideoRecorderUI.this));
          VideoRecorderUI.this.startActivityForResult(paramAnonymousView, 0);
          VideoRecorderUI.this.overridePendingTransition(0, 0);
          AppMethodBeat.o(25655);
        }
      });
      localb = this.taX;
      if (this.qCR) {
        break label579;
      }
      i = 1;
      localObject = this.videoPath;
      String str1 = this.taR;
      String str2 = this.iaf;
      String str3 = this.tbo;
      localb.fVF = 0;
      if (1 != localb.fVF) {
        break label584;
      }
      localb.qWJ = a.dmG();
      label358:
      if (ac.erw.erh)
      {
        localb.qWJ.oHZ = ac.erw.mVideoHeight;
        localb.qWJ.oIa = ac.erw.mVideoWidth;
        localb.qWJ.oHY = ac.erw.erj;
      }
      localb.filename = str3;
      localb.qWJ.oIh = str1;
      localb.qWJ.oIf = str2;
      localb.qWJ.oIe = ((String)localObject + "temp.pcm");
      localb.qWJ.oId = ((String)localObject + "temp.yuv");
      localb.qWJ.oIg = ((String)localObject + "temp.vid");
      localb.qWJ.oIj = d.getNumberOfCameras();
      localObject = localb.qWJ;
      if (i == 0) {
        break label594;
      }
    }
    label579:
    label584:
    label594:
    for (int i = j;; i = 0)
    {
      ((a)localObject).rotate = i;
      localb.qWJ.fXx = 0;
      localb.vPa = new g();
      AppMethodBeat.o(25661);
      return;
      this.tbk.setVisibility(4);
      break;
      i = 0;
      break label314;
      localb.qWJ = a.dmF();
      break label358;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25668);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(25668);
      return;
    }
    if (paramInt1 == 0)
    {
      setResult(-1, paramIntent);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(25668);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25658);
    super.onCreate(paramBundle);
    MMActivity.initLanguage(this);
    tbl = this;
    getWindow().setFlags(1024, 1024);
    getSupportActionBar().hide();
    setMMTitle(2131304534);
    addTextOptionMenu(0, getString(2131297067), new VideoRecorderUI.5(this), null, q.b.zby);
    setBackBtn(new VideoRecorderUI.6(this));
    this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
    this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
    this.taR = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    this.iaf = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
    this.tbo = getIntent().getStringExtra("VideoRecorder_FileName");
    ab.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
    ab.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.taR + " videoThumbPath " + this.iaf + " KFileName " + this.tbo);
    initView();
    aEa();
    aw.BY().Ic();
    AppMethodBeat.o(25658);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25660);
    tbl = null;
    ab.v("MicroMsg.VideoRecorderUI", "on destroy");
    aw.BY().Ib();
    super.onDestroy();
    AppMethodBeat.o(25660);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25663);
    if (paramInt == 4)
    {
      ab.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
      if (this.tba)
      {
        AppMethodBeat.o(25663);
        return true;
      }
      cHl();
      AppMethodBeat.o(25663);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25663);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25667);
    if (this.tba)
    {
      b localb = this.taX;
      if (localb.oJm != null)
      {
        localb.oJm.stop();
        localb.oJm.release();
        localb.oJm = null;
      }
      aEa();
      this.tba = false;
      releaseWakeLock();
      this.taY.setImageResource(2130840666);
      this.mwY.stopTimer();
      this.tbb.setVisibility(8);
      this.tbc.setVisibility(0);
      this.taV.setVisibility(0);
    }
    this.taX.dmH();
    ab.v("MicroMsg.VideoRecorderUI", "onPause");
    super.onPause();
    AppMethodBeat.o(25667);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25666);
    if ((!this.tbn) && ((this.taX.b(this, false) != 0) || (this.taX.b(this.taW) != 0))) {
      cHm();
    }
    this.tbn = false;
    ab.v("MicroMsg.VideoRecorderUI", "onResume");
    super.onResume();
    AppMethodBeat.o(25666);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25659);
    super.onStart();
    if (this.qCR)
    {
      setRequestedOrientation(0);
      AppMethodBeat.o(25659);
      return;
    }
    setRequestedOrientation(1);
    AppMethodBeat.o(25659);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI
 * JD-Core Version:    0.7.0.1
 */