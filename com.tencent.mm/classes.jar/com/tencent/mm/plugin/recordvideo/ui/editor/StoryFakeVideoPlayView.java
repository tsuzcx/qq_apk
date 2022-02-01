package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.background.a.c;
import com.tencent.mm.plugin.recordvideo.background.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;)V", "canResume", "", "curImageList", "", "", "curPos", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "playStatus", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$STATUS;", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "surfaceAvailable", "task", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "getCurPos", "init", "", "isPlaying", "pause", "play", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resume", "stop", "Callback", "Companion", "STATUS", "VideoLoopTask", "plugin-recordvideo_release"})
public final class StoryFakeVideoPlayView
  extends TextureView
{
  public static final String TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
  public static final StoryFakeVideoPlayView.b vst;
  private int qNE;
  private com.tencent.mm.plugin.recordvideo.background.a.h veO;
  private c veP;
  public StoryFakeVideoPlayView.c vsn;
  private boolean vso;
  private StoryFakeVideoPlayView.a vsp;
  private d vsq;
  boolean vsr;
  private List<String> vss;
  
  static
  {
    AppMethodBeat.i(76066);
    vst = new StoryFakeVideoPlayView.b((byte)0);
    TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
    AppMethodBeat.o(76066);
  }
  
  public StoryFakeVideoPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76063);
    this.vsn = StoryFakeVideoPlayView.c.vsu;
    init();
    AppMethodBeat.o(76063);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(76064);
    this.vsn = StoryFakeVideoPlayView.c.vsu;
    init();
    AppMethodBeat.o(76064);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76065);
    this.vsn = StoryFakeVideoPlayView.c.vsu;
    init();
    AppMethodBeat.o(76065);
  }
  
  private void init()
  {
    AppMethodBeat.i(76059);
    this.veO = new com.tencent.mm.plugin.recordvideo.background.a.h();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)new e(this));
    AppMethodBeat.o(76059);
  }
  
  public final void ai(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(76060);
    k.h(paramArrayList, "imageList");
    ad.i(TAG, "play");
    d locald = this.vsq;
    if (locald != null)
    {
      List localList = this.vss;
      int k;
      int i;
      if (localList != null) {
        if (localList.size() == paramArrayList.size())
        {
          k = paramArrayList.size() - 1;
          if (k >= 0)
          {
            i = 0;
            if (!bt.kU((String)paramArrayList.get(i), (String)localList.get(i))) {
              i = j;
            }
          }
        }
      }
      for (;;)
      {
        if ((i == 0) || (locald.stop)) {
          break label148;
        }
        ad.i(TAG, "play same imagelist, do nothing");
        AppMethodBeat.o(76060);
        return;
        if (i != k)
        {
          i += 1;
          break;
        }
        i = 1;
        continue;
        i = 1;
      }
      label148:
      locald.stop = true;
    }
    this.vss = ((List)paramArrayList);
    this.vsq = new d(paramArrayList);
    paramArrayList = com.tencent.e.h.Iye;
    locald = this.vsq;
    if (locald == null) {
      k.fvU();
    }
    paramArrayList.aS((Runnable)locald);
    AppMethodBeat.o(76060);
  }
  
  public final StoryFakeVideoPlayView.a getCallback()
  {
    return this.vsp;
  }
  
  public final int getCurPos()
  {
    return this.qNE;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76061);
    ad.i(TAG, "resume");
    this.vsn = StoryFakeVideoPlayView.c.vsv;
    AppMethodBeat.o(76061);
  }
  
  public final void setCallback(StoryFakeVideoPlayView.a parama)
  {
    this.vsp = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76062);
    ad.i(TAG, "stop");
    this.vsn = StoryFakeVideoPlayView.c.vsu;
    d locald = this.vsq;
    if (locald != null)
    {
      locald.stop = true;
      AppMethodBeat.o(76062);
      return;
    }
    AppMethodBeat.o(76062);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Ljava/util/ArrayList;)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "getKey", "run", "", "plugin-recordvideo_release"})
  public final class d
    implements com.tencent.e.i.h
  {
    boolean stop;
    private ArrayList<String> veU;
    
    public d()
    {
      AppMethodBeat.i(76054);
      this.veU = localObject;
      AppMethodBeat.o(76054);
    }
    
    public final String getKey()
    {
      return "Story_VideoLoopTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(76053);
      StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this, StoryFakeVideoPlayView.c.vsv);
      while (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this)) {
        Thread.sleep(100L);
      }
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).vfD.dhe();
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).eH((List)this.veU);
      if (this.stop)
      {
        AppMethodBeat.o(76053);
        return;
        if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.vsw) {
          break label299;
        }
        StoryFakeVideoPlayView.e(StoryFakeVideoPlayView.this);
        Thread.sleep(500L);
      }
      for (;;)
      {
        if (this.stop) {
          break label331;
        }
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.vsv) || (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break;
        }
        localObject = e.vgG;
        int i = e.dhm();
        localObject = e.vgG;
        int k = i / e.getFrameRate();
        StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).ao((Runnable)new b(this));
        int j;
        for (i = 0;; i = j)
        {
          j = i + 1;
          if ((i >= k) || (this.stop)) {
            break;
          }
          localObject = StoryFakeVideoPlayView.this;
          long l = j;
          e locale = e.vgG;
          StoryFakeVideoPlayView.a((StoryFakeVideoPlayView)localObject, (int)(l * (1000L / e.getFrameRate())));
          if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.vsv) {
            break;
          }
          StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).requestRender();
          if (StoryFakeVideoPlayView.this.getCallback() != null) {
            StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).ao((Runnable)new a(this));
          }
          localObject = e.vgG;
          Thread.sleep(1000L / e.getFrameRate());
        }
        label299:
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.vsv) || (StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break label331;
        }
        Thread.sleep(500L);
      }
      label331:
      Object localObject = StoryFakeVideoPlayView.vst;
      ad.i(StoryFakeVideoPlayView.access$getTAG$cp(), "video play end");
      AppMethodBeat.o(76053);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask$run$2$1"})
    static final class a
      implements Runnable
    {
      a(StoryFakeVideoPlayView.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(76051);
        StoryFakeVideoPlayView.a locala = this.vsz.vsy.getCallback();
        if (locala != null) {
          locala.rq();
        }
        this.vsz.vsy.setCallback(null);
        AppMethodBeat.o(76051);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(StoryFakeVideoPlayView.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(76052);
        StoryFakeVideoPlayView.c(this.vsz.vsy).startTime = 0L;
        AppMethodBeat.o(76052);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-recordvideo_release"})
  public static final class e
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(76058);
      StoryFakeVideoPlayView.a(this.vsy, new c(paramSurfaceTexture, StoryFakeVideoPlayView.c(this.vsy)));
      StoryFakeVideoPlayView.d(this.vsy).start();
      StoryFakeVideoPlayView.d(this.vsy).dz(paramInt1, paramInt2);
      paramSurfaceTexture = StoryFakeVideoPlayView.d(this.vsy);
      e locale = e.vgG;
      paramSurfaceTexture.setFrameRate(e.getFrameRate());
      StoryFakeVideoPlayView.a(this.vsy, true);
      paramSurfaceTexture = StoryFakeVideoPlayView.vst;
      ad.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureAvailable");
      AppMethodBeat.o(76058);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76057);
      paramSurfaceTexture = StoryFakeVideoPlayView.vst;
      ad.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureDestroyed");
      StoryFakeVideoPlayView.a(this.vsy, false);
      StoryFakeVideoPlayView.d(this.vsy).stop();
      AppMethodBeat.o(76057);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(76055);
      paramSurfaceTexture = StoryFakeVideoPlayView.vst;
      ad.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureSizeChanged");
      AppMethodBeat.o(76055);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76056);
      paramSurfaceTexture = StoryFakeVideoPlayView.vst;
      ad.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureUpdated");
      AppMethodBeat.o(76056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView
 * JD-Core Version:    0.7.0.1
 */