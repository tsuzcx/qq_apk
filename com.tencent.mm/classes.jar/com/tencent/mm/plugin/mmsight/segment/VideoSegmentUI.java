package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.plugin.mmsight.segment.a.c.a;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.concurrent.CountDownLatch;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI
  extends MMActivity
{
  private CountDownLatch bpQ = new CountDownLatch(2);
  private ProgressDialog dnm = null;
  private int eAx;
  private d eMh = new d(this);
  private String jkO = "";
  private RelativeLayout kgv;
  private Surface mSurface;
  private VideoTransPara mgW;
  private String mnk = null;
  private f mnl;
  private com.tencent.mm.plugin.mmsight.segment.a.c mnm;
  private boolean mnn = false;
  private c mno;
  private int mnp = 10000;
  private boolean mnq = false;
  private boolean mnr = false;
  private boolean mns = false;
  private c.b mnt = new VideoSegmentUI.2(this);
  private c.a mnu = new VideoSegmentUI.3(this);
  private a.d mnv = new VideoSegmentUI.4(this);
  private String thumbPath;
  
  private void a(boolean paramBoolean, Surface paramSurface)
  {
    if (this.mnm != null)
    {
      y.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
      return;
    }
    this.mnm = new com.tencent.mm.plugin.mmsight.segment.a.c();
    this.mnn = false;
    this.mnm.setDataSource(this.mnk);
    this.mnm.a(new VideoSegmentUI.9(this));
    if (paramBoolean) {
      this.mnm.a(this.mnv);
    }
    this.mnm.setAudioStreamType(3);
    this.mnm.setLooping(true);
    if (paramSurface != null) {
      this.mnm.setSurface(paramSurface);
    }
    this.mnm.mnu = this.mnu;
    this.mnm.a(new VideoSegmentUI.10(this));
    this.mnm.prepareAsync();
    this.mnm.a(new VideoSegmentUI.11(this));
  }
  
  protected final int getLayoutId()
  {
    return a.f.video_segment_ui;
  }
  
  protected final void initView()
  {
    this.mno = ((c)findViewById(a.e.segment_thumb_seek_bar));
    this.kgv = ((RelativeLayout)findViewById(a.e.root));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.eMh));
    this.eMh.connect(new VideoSegmentUI.1(this));
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.VideoSegmentUI", "onDestroy");
    super.onDestroy();
    getWindow().clearFlags(128);
    this.eMh.release();
    if (this.mno != null) {
      this.mno.release();
    }
    if (this.mnm != null) {
      this.mnm.release();
    }
    if (this.mSurface != null) {
      this.mSurface.release();
    }
    if (this.mnl != null) {
      this.mnl.release();
    }
    j.mji.ET();
  }
  
  protected void onPause()
  {
    if (this.mnm != null)
    {
      y.i("MicroMsg.VideoSegmentUI", "onPause pause player");
      this.mnm.pause();
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    if ((this.mnm != null) && (this.mnn))
    {
      y.i("MicroMsg.VideoSegmentUI", "onResume start player");
      this.mnm.start();
    }
    super.onResume();
  }
  
  private final class a
    implements Runnable
  {
    private Context context;
    private ViewGroup jRV;
    private int mnD;
    private int mnE;
    private int mnF;
    private VideoSegmentUI.b mnG;
    
    private a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, VideoSegmentUI.b paramb)
    {
      this.mnD = paramInt1;
      this.mnE = paramInt2;
      this.mnF = paramInt3;
      this.context = paramViewGroup.getContext();
      this.jRV = paramViewGroup;
      this.mnG = paramb;
    }
    
    public final void run()
    {
      if (VideoSegmentUI.this.isFinishing()) {
        return;
      }
      Object localObject = new VideoSegmentUI.a.1(this, this.context);
      int i = this.jRV.getWidth();
      int j = com.tencent.mm.cb.a.aa(this.context, a.c.video_segment_surface_padding_vertical);
      int k = ((View)VideoSegmentUI.j(VideoSegmentUI.this)).getTop() - j * 2;
      int m = this.mnE;
      int n = this.mnD;
      Point localPoint = new Point();
      if (n / m > k / i) {}
      for (float f = k / n;; f = i / m)
      {
        localPoint.x = ((int)(m * f));
        localPoint.y = ((int)(f * n));
        y.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.mnE), Integer.valueOf(this.mnD), Integer.valueOf(this.mnF), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
        if ((localPoint.x > 0) && (localPoint.y > 0)) {
          break label338;
        }
        y.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.mnE), Integer.valueOf(this.mnD), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
        if (this.mnG == null) {
          break;
        }
        localObject = this.mnG;
        y.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
        VideoSegmentUI.m(((VideoSegmentUI.b)localObject).mnw);
        ((VideoSegmentUI.b)localObject).mnw.finish();
        VideoSegmentUI.b(((VideoSegmentUI.b)localObject).mnw);
        return;
      }
      label338:
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(localPoint.x, localPoint.y);
      j += (int)((k - localPoint.y) / 2.0F);
      localLayoutParams.topMargin = j;
      localLayoutParams.bottomMargin = j;
      i = (int)((i - localPoint.x) / 2.0F);
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      ((MMTextureView)localObject).setSurfaceTextureListener(this.mnG);
      this.jRV.addView((View)localObject, 0, localLayoutParams);
    }
  }
  
  private final class b
    implements TextureView.SurfaceTextureListener
  {
    private b() {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      boolean bool2 = VideoSegmentUI.w(VideoSegmentUI.this);
      boolean bool1;
      if (VideoSegmentUI.d(VideoSegmentUI.this) == null) {
        bool1 = true;
      }
      for (;;)
      {
        y.i("MicroMsg.VideoSegmentUI", "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        VideoSegmentUI.b(VideoSegmentUI.this, new Surface(paramSurfaceTexture));
        if ((VideoSegmentUI.d(VideoSegmentUI.this) == null) && (VideoSegmentUI.w(VideoSegmentUI.this))) {
          y.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
        }
        try
        {
          VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.u(VideoSegmentUI.this));
          if ((VideoSegmentUI.j(VideoSegmentUI.this) != null) && (VideoSegmentUI.d(VideoSegmentUI.this) != null)) {
            VideoSegmentUI.d(VideoSegmentUI.this).setLoop((int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).bjK()), (int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).bjL()));
          }
          VideoSegmentUI.a(VideoSegmentUI.this, false);
          VideoSegmentUI.o(VideoSegmentUI.this).countDown();
          return;
          bool1 = false;
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.VideoSegmentUI", paramSurfaceTexture, "ResumeMediaPlayer error %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
        }
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      y.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", new Object[] { bk.csb() });
      try
      {
        if (VideoSegmentUI.d(VideoSegmentUI.this) != null)
        {
          y.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
          VideoSegmentUI.d(VideoSegmentUI.this).release();
          VideoSegmentUI.v(VideoSegmentUI.this);
          VideoSegmentUI.a(VideoSegmentUI.this, true);
        }
        VideoSegmentUI.b(VideoSegmentUI.this, null);
        return false;
      }
      catch (Exception paramSurfaceTexture) {}
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI
 * JD-Core Version:    0.7.0.1
 */