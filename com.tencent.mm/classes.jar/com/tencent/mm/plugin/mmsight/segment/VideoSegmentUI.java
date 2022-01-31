package com.tencent.mm.plugin.mmsight.segment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.plugin.mmsight.segment.a.c.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.concurrent.CountDownLatch;

@a(3)
public class VideoSegmentUI
  extends MMActivity
{
  private CountDownLatch bPR;
  private ProgressDialog eeN;
  private d evl;
  private int fQq;
  private String lup;
  private RelativeLayout mBh;
  private Surface mSurface;
  private VideoTransPara oHk;
  private boolean oMA;
  private c.b oMB;
  private c.a oMC;
  private a.d oMD;
  private String oMs;
  private f oMt;
  private com.tencent.mm.plugin.mmsight.segment.a.c oMu;
  private boolean oMv;
  private c oMw;
  private int oMx;
  private boolean oMy;
  private boolean oMz;
  private String thumbPath;
  
  public VideoSegmentUI()
  {
    AppMethodBeat.i(55053);
    this.oMs = null;
    this.oMv = false;
    this.bPR = new CountDownLatch(2);
    this.oMx = 10000;
    this.eeN = null;
    this.evl = new d(this);
    this.lup = "";
    this.oMy = false;
    this.oMz = false;
    this.oMA = false;
    this.oMB = new VideoSegmentUI.2(this);
    this.oMC = new VideoSegmentUI.3(this);
    this.oMD = new VideoSegmentUI.4(this);
    AppMethodBeat.o(55053);
  }
  
  private void a(boolean paramBoolean, Surface paramSurface)
  {
    AppMethodBeat.i(55056);
    if (this.oMu != null)
    {
      ab.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
      AppMethodBeat.o(55056);
      return;
    }
    this.oMu = new com.tencent.mm.plugin.mmsight.segment.a.c();
    this.oMv = false;
    this.oMu.setDataSource(this.oMs);
    this.oMu.a(new VideoSegmentUI.9(this));
    if (paramBoolean) {
      this.oMu.a(this.oMD);
    }
    this.oMu.setAudioStreamType(3);
    this.oMu.setLooping(true);
    if (paramSurface != null) {
      this.oMu.setSurface(paramSurface);
    }
    this.oMu.oMC = this.oMC;
    this.oMu.a(new VideoSegmentUI.10(this));
    this.oMu.prepareAsync();
    this.oMu.a(new VideoSegmentUI.11(this));
    AppMethodBeat.o(55056);
  }
  
  public int getLayoutId()
  {
    return 2130971076;
  }
  
  public void initView()
  {
    AppMethodBeat.i(55055);
    this.oMw = ((c)findViewById(2131828736));
    this.mBh = ((RelativeLayout)findViewById(2131821003));
    AppMethodBeat.o(55055);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55054);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
    this.evl.connect(new VideoSegmentUI.1(this));
    AppMethodBeat.o(55054);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55059);
    ab.i("MicroMsg.VideoSegmentUI", "onDestroy");
    super.onDestroy();
    getWindow().clearFlags(128);
    this.evl.release();
    if (this.oMw != null) {
      this.oMw.release();
    }
    if (this.oMu != null) {
      this.oMu.release();
    }
    if (this.mSurface != null) {
      this.mSurface.release();
    }
    if (this.oMt != null) {
      this.oMt.release();
    }
    j.oJp.XJ();
    AppMethodBeat.o(55059);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(55058);
    if (this.oMu != null)
    {
      ab.i("MicroMsg.VideoSegmentUI", "onPause pause player");
      this.oMu.pause();
    }
    super.onPause();
    AppMethodBeat.o(55058);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(55057);
    if ((this.oMu != null) && (this.oMv))
    {
      ab.i("MicroMsg.VideoSegmentUI", "onResume start player");
      this.oMu.start();
    }
    super.onResume();
    AppMethodBeat.o(55057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
    implements TextureView.SurfaceTextureListener
  {
    private b() {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(55047);
      boolean bool2 = VideoSegmentUI.w(VideoSegmentUI.this);
      boolean bool1;
      if (VideoSegmentUI.d(VideoSegmentUI.this) == null) {
        bool1 = true;
      }
      for (;;)
      {
        ab.i("MicroMsg.VideoSegmentUI", "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        VideoSegmentUI.b(VideoSegmentUI.this, new Surface(paramSurfaceTexture));
        if ((VideoSegmentUI.d(VideoSegmentUI.this) == null) && (VideoSegmentUI.w(VideoSegmentUI.this))) {
          ab.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
        }
        try
        {
          VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.u(VideoSegmentUI.this));
          if ((VideoSegmentUI.j(VideoSegmentUI.this) != null) && (VideoSegmentUI.d(VideoSegmentUI.this) != null)) {
            VideoSegmentUI.d(VideoSegmentUI.this).setLoop((int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).bRy()), (int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).bRz()));
          }
          VideoSegmentUI.a(VideoSegmentUI.this, false);
          VideoSegmentUI.o(VideoSegmentUI.this).countDown();
          AppMethodBeat.o(55047);
          return;
          bool1 = false;
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.VideoSegmentUI", paramSurfaceTexture, "ResumeMediaPlayer error %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
        }
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(55048);
      ab.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", new Object[] { bo.dtY() });
      try
      {
        if (VideoSegmentUI.d(VideoSegmentUI.this) != null)
        {
          ab.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
          VideoSegmentUI.d(VideoSegmentUI.this).release();
          VideoSegmentUI.v(VideoSegmentUI.this);
          VideoSegmentUI.a(VideoSegmentUI.this, true);
        }
        VideoSegmentUI.b(VideoSegmentUI.this, null);
      }
      catch (Exception paramSurfaceTexture)
      {
        label75:
        break label75;
      }
      AppMethodBeat.o(55048);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI
 * JD-Core Version:    0.7.0.1
 */