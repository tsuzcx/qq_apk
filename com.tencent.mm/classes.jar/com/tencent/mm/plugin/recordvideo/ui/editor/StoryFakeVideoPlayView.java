package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.background.b.c;
import com.tencent.mm.plugin.recordvideo.background.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;)V", "canResume", "", "curImageList", "", "", "curPos", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "playStatus", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$STATUS;", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "surfaceAvailable", "task", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "getCurPos", "init", "", "isPlaying", "pause", "play", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resume", "stop", "Callback", "Companion", "STATUS", "VideoLoopTask", "plugin-recordvideo_release"})
public final class StoryFakeVideoPlayView
  extends TextureView
{
  public static final b IaM;
  public static final String TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
  private com.tencent.mm.plugin.recordvideo.background.b.h HHD;
  private c HHE;
  public c IaG;
  private boolean IaH;
  private a IaI;
  private d IaJ;
  boolean IaK;
  private List<String> IaL;
  private int yeA;
  
  static
  {
    AppMethodBeat.i(76066);
    IaM = new b((byte)0);
    TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
    AppMethodBeat.o(76066);
  }
  
  public StoryFakeVideoPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76063);
    this.IaG = c.IaN;
    init();
    AppMethodBeat.o(76063);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(76064);
    this.IaG = c.IaN;
    init();
    AppMethodBeat.o(76064);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76065);
    this.IaG = c.IaN;
    init();
    AppMethodBeat.o(76065);
  }
  
  private void init()
  {
    AppMethodBeat.i(76059);
    this.HHD = new com.tencent.mm.plugin.recordvideo.background.b.h();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)new e(this));
    AppMethodBeat.o(76059);
  }
  
  public final void aR(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(76060);
    p.k(paramArrayList, "imageList");
    Log.i(TAG, "play");
    d locald = this.IaJ;
    if (locald != null)
    {
      List localList = this.IaL;
      int k;
      int i;
      if (localList != null) {
        if (localList.size() == paramArrayList.size())
        {
          k = paramArrayList.size() - 1;
          if (k >= 0)
          {
            i = 0;
            if (!Util.isEqual((String)paramArrayList.get(i), (String)localList.get(i))) {
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
        Log.i(TAG, "play same imagelist, do nothing");
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
    this.IaL = ((List)paramArrayList);
    this.IaJ = new d(paramArrayList);
    paramArrayList = com.tencent.e.h.ZvG;
    locald = this.IaJ;
    if (locald == null) {
      p.iCn();
    }
    paramArrayList.bh((Runnable)locald);
    AppMethodBeat.o(76060);
  }
  
  public final a getCallback()
  {
    return this.IaI;
  }
  
  public final int getCurPos()
  {
    return this.yeA;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76061);
    Log.i(TAG, "resume");
    this.IaG = c.IaO;
    AppMethodBeat.o(76061);
  }
  
  public final void setCallback(a parama)
  {
    this.IaI = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76062);
    Log.i(TAG, "stop");
    this.IaG = c.IaN;
    d locald = this.IaJ;
    if (locald != null)
    {
      locald.stop = true;
      AppMethodBeat.o(76062);
      return;
    }
    AppMethodBeat.o(76062);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "", "onPrepared", "", "plugin-recordvideo_release"})
  public static abstract interface a
  {
    public abstract void qX();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$STATUS;", "", "(Ljava/lang/String;I)V", "STOP", "PLAYING", "PAUSE", "plugin-recordvideo_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(76048);
      c localc1 = new c("STOP", 0);
      IaN = localc1;
      c localc2 = new c("PLAYING", 1);
      IaO = localc2;
      c localc3 = new c("PAUSE", 2);
      IaP = localc3;
      IaQ = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(76048);
    }
    
    private c() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Ljava/util/ArrayList;)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "getKey", "run", "", "plugin-recordvideo_release"})
  public final class d
    implements com.tencent.e.i.h
  {
    private ArrayList<String> HHJ;
    boolean stop;
    
    public d()
    {
      AppMethodBeat.i(76054);
      this.HHJ = localObject;
      AppMethodBeat.o(76054);
    }
    
    public final String getKey()
    {
      return "Story_VideoLoopTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(76053);
      StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this, StoryFakeVideoPlayView.c.IaO);
      while (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this)) {
        Thread.sleep(100L);
      }
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).HIu.fvp();
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).gI((List)this.HHJ);
      if (this.stop)
      {
        AppMethodBeat.o(76053);
        return;
        if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.IaP) {
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
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.IaO) || (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break;
        }
        localObject = f.HJU;
        int i = f.fvB();
        localObject = f.HJU;
        int k = i / f.getFrameRate();
        StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).aD((Runnable)new b(this));
        int j;
        for (i = 0;; i = j)
        {
          j = i + 1;
          if ((i >= k) || (this.stop)) {
            break;
          }
          localObject = StoryFakeVideoPlayView.this;
          long l = j;
          f localf = f.HJU;
          StoryFakeVideoPlayView.a((StoryFakeVideoPlayView)localObject, (int)(l * (1000L / f.getFrameRate())));
          if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.IaO) {
            break;
          }
          StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).requestRender();
          if (StoryFakeVideoPlayView.this.getCallback() != null) {
            StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).aD((Runnable)new a(this));
          }
          localObject = f.HJU;
          Thread.sleep(1000L / f.getFrameRate());
        }
        label299:
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.IaO) || (StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break label331;
        }
        Thread.sleep(500L);
      }
      label331:
      Object localObject = StoryFakeVideoPlayView.IaM;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "video play end");
      AppMethodBeat.o(76053);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask$run$2$1"})
    static final class a
      implements Runnable
    {
      a(StoryFakeVideoPlayView.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(76051);
        StoryFakeVideoPlayView.a locala = this.IaS.IaR.getCallback();
        if (locala != null) {
          locala.qX();
        }
        this.IaS.IaR.setCallback(null);
        AppMethodBeat.o(76051);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(StoryFakeVideoPlayView.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(76052);
        StoryFakeVideoPlayView.c(this.IaS.IaR).startTime = 0L;
        AppMethodBeat.o(76052);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-recordvideo_release"})
  public static final class e
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(76058);
      StoryFakeVideoPlayView.a(this.IaR, new c(paramSurfaceTexture, StoryFakeVideoPlayView.c(this.IaR)));
      StoryFakeVideoPlayView.d(this.IaR).start();
      StoryFakeVideoPlayView.d(this.IaR).ej(paramInt1, paramInt2);
      paramSurfaceTexture = StoryFakeVideoPlayView.d(this.IaR);
      f localf = f.HJU;
      paramSurfaceTexture.setFrameRate(f.getFrameRate());
      StoryFakeVideoPlayView.a(this.IaR, true);
      paramSurfaceTexture = StoryFakeVideoPlayView.IaM;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureAvailable");
      AppMethodBeat.o(76058);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76057);
      paramSurfaceTexture = StoryFakeVideoPlayView.IaM;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureDestroyed");
      StoryFakeVideoPlayView.a(this.IaR, false);
      StoryFakeVideoPlayView.d(this.IaR).stop();
      AppMethodBeat.o(76057);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(76055);
      paramSurfaceTexture = StoryFakeVideoPlayView.IaM;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureSizeChanged");
      AppMethodBeat.o(76055);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76056);
      paramSurfaceTexture = StoryFakeVideoPlayView.IaM;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureUpdated");
      AppMethodBeat.o(76056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView
 * JD-Core Version:    0.7.0.1
 */