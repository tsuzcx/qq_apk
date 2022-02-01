package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.b.c;
import com.tencent.mm.plugin.recordvideo.background.b.c.2;
import com.tencent.mm.plugin.recordvideo.background.b.g;
import com.tencent.mm.plugin.recordvideo.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;)V", "canResume", "", "curImageList", "", "", "curPos", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "playStatus", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$STATUS;", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "surfaceAvailable", "task", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "getCurPos", "init", "", "isPlaying", "pause", "play", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resume", "stop", "Callback", "Companion", "STATUS", "VideoLoopTask", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryFakeVideoPlayView
  extends TextureView
{
  public static final StoryFakeVideoPlayView.b NXh;
  public static final String TAG;
  private int CEY;
  private com.tencent.mm.plugin.recordvideo.background.b.h NFa;
  private c NFb;
  public StoryFakeVideoPlayView.c NXi;
  private boolean NXj;
  private a NXk;
  private d NXl;
  boolean NXm;
  private List<String> NXn;
  
  static
  {
    AppMethodBeat.i(76066);
    NXh = new StoryFakeVideoPlayView.b((byte)0);
    TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
    AppMethodBeat.o(76066);
  }
  
  public StoryFakeVideoPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76063);
    this.NXi = StoryFakeVideoPlayView.c.NXo;
    init();
    AppMethodBeat.o(76063);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(76064);
    this.NXi = StoryFakeVideoPlayView.c.NXo;
    init();
    AppMethodBeat.o(76064);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76065);
    this.NXi = StoryFakeVideoPlayView.c.NXo;
    init();
    AppMethodBeat.o(76065);
  }
  
  private void init()
  {
    AppMethodBeat.i(76059);
    this.NFa = new com.tencent.mm.plugin.recordvideo.background.b.h();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)new e(this));
    AppMethodBeat.o(76059);
  }
  
  public final void bm(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(76060);
    s.u(paramArrayList, "imageList");
    Log.i(TAG, "play");
    d locald = this.NXl;
    List localList;
    int k;
    int i;
    if (locald != null)
    {
      localList = this.NXn;
      if ((localList != null) && (localList.size() == paramArrayList.size()))
      {
        k = paramArrayList.size() - 1;
        if (k >= 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (!Util.isEqual((String)paramArrayList.get(i), (String)localList.get(i))) {}
      for (i = j; (i != 0) && (!locald.stop); i = 1)
      {
        Log.i(TAG, "play same imagelist, do nothing");
        AppMethodBeat.o(76060);
        return;
        if (i != k) {
          break label196;
        }
      }
      locald.stop = true;
      this.NXn = ((List)paramArrayList);
      this.NXl = new d(paramArrayList);
      paramArrayList = com.tencent.threadpool.h.ahAA;
      locald = this.NXl;
      s.checkNotNull(locald);
      paramArrayList.bp((Runnable)locald);
      AppMethodBeat.o(76060);
      return;
      label196:
      i += 1;
    }
  }
  
  public final a getCallback()
  {
    return this.NXk;
  }
  
  public final int getCurPos()
  {
    return this.CEY;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76061);
    Log.i(TAG, "resume");
    this.NXi = StoryFakeVideoPlayView.c.NXp;
    AppMethodBeat.o(76061);
  }
  
  public final void setCallback(a parama)
  {
    this.NXk = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76062);
    Log.i(TAG, "stop");
    this.NXi = StoryFakeVideoPlayView.c.NXo;
    d locald = this.NXl;
    if (locald != null) {
      locald.stop = true;
    }
    AppMethodBeat.o(76062);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "", "onPrepared", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Qz();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Ljava/util/ArrayList;)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "getKey", "run", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    implements com.tencent.threadpool.i.h
  {
    private ArrayList<String> NEX;
    boolean stop;
    
    public d()
    {
      AppMethodBeat.i(76054);
      this.NEX = localObject;
      AppMethodBeat.o(76054);
    }
    
    private static final void f(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
    {
      AppMethodBeat.i(279952);
      s.u(paramStoryFakeVideoPlayView, "this$0");
      com.tencent.mm.plugin.recordvideo.background.b.h localh = StoryFakeVideoPlayView.b(paramStoryFakeVideoPlayView);
      paramStoryFakeVideoPlayView = localh;
      if (localh == null)
      {
        s.bIx("render");
        paramStoryFakeVideoPlayView = null;
      }
      paramStoryFakeVideoPlayView.startTime = 0L;
      AppMethodBeat.o(279952);
    }
    
    private static final void g(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
    {
      AppMethodBeat.i(279956);
      s.u(paramStoryFakeVideoPlayView, "this$0");
      StoryFakeVideoPlayView.a locala = paramStoryFakeVideoPlayView.getCallback();
      if (locala != null) {
        locala.Qz();
      }
      paramStoryFakeVideoPlayView.setCallback(null);
      AppMethodBeat.o(279956);
    }
    
    public final String getKey()
    {
      return "Story_VideoLoopTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(76053);
      StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this, StoryFakeVideoPlayView.c.NXp);
      while (!StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this)) {
        Thread.sleep(100L);
      }
      Object localObject2 = StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("render");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.recordvideo.background.b.h)localObject1).NFN.gHf();
      localObject1 = StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this);
      if (localObject1 == null)
      {
        s.bIx("render");
        localObject1 = null;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.recordvideo.background.b.h)localObject1).jI((List)this.NEX);
        if (!this.stop) {
          break;
        }
        AppMethodBeat.o(76053);
        return;
      }
      if (StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this) == StoryFakeVideoPlayView.c.NXq)
      {
        StoryFakeVideoPlayView.e(StoryFakeVideoPlayView.this);
        Thread.sleep(500L);
      }
      for (;;)
      {
        if (this.stop) {
          break label475;
        }
        if ((StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.NXp) || (!StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this))) {
          break;
        }
        localObject1 = f.NGM;
        int i = f.gHp();
        localObject1 = f.NGM;
        int k = i / f.getFrameRate();
        localObject2 = StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("glThread");
          localObject1 = null;
        }
        ((c)localObject1).aM(new StoryFakeVideoPlayView.d..ExternalSyntheticLambda1(StoryFakeVideoPlayView.this));
        i = 0;
        int j = i + 1;
        if ((i < k) && (!this.stop))
        {
          localObject1 = StoryFakeVideoPlayView.this;
          long l = j;
          localObject2 = f.NGM;
          StoryFakeVideoPlayView.a((StoryFakeVideoPlayView)localObject1, (int)(l * (1000L / f.getFrameRate())));
          if (StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this) == StoryFakeVideoPlayView.c.NXp)
          {
            localObject2 = StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("glThread");
              localObject1 = null;
            }
            Log.i("MicroMsg.Story.GLThread", "requestRender");
            if (((c)localObject1).handler == null) {
              Log.i("MicroMsg.Story.GLThread", "requestRender but handler is null");
            }
            for (;;)
            {
              if (StoryFakeVideoPlayView.this.getCallback() != null)
              {
                StoryFakeVideoPlayView localStoryFakeVideoPlayView = StoryFakeVideoPlayView.this;
                localObject2 = StoryFakeVideoPlayView.a(localStoryFakeVideoPlayView);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("glThread");
                  localObject1 = null;
                }
                ((c)localObject1).aM(new StoryFakeVideoPlayView.d..ExternalSyntheticLambda0(localStoryFakeVideoPlayView));
              }
              localObject1 = f.NGM;
              Thread.sleep(1000L / f.getFrameRate());
              i = j;
              break;
              ((c)localObject1).handler.post(new c.2((c)localObject1));
            }
            if ((StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.NXp) || (StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this))) {
              break label475;
            }
            Thread.sleep(500L);
          }
        }
      }
      label475:
      localObject1 = StoryFakeVideoPlayView.NXh;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "video play end");
      AppMethodBeat.o(76053);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements TextureView.SurfaceTextureListener
  {
    e(StoryFakeVideoPlayView paramStoryFakeVideoPlayView) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(76058);
      s.u(paramSurfaceTexture, "surface");
      StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.NXs;
      com.tencent.mm.plugin.recordvideo.background.b.h localh = StoryFakeVideoPlayView.b(this.NXs);
      Object localObject1 = localh;
      if (localh == null)
      {
        s.bIx("render");
        localObject1 = null;
      }
      StoryFakeVideoPlayView.a(localStoryFakeVideoPlayView, new c(paramSurfaceTexture, (com.tencent.mm.plugin.recordvideo.background.b.h)localObject1));
      localObject1 = StoryFakeVideoPlayView.a(this.NXs);
      paramSurfaceTexture = (SurfaceTexture)localObject1;
      if (localObject1 == null)
      {
        s.bIx("glThread");
        paramSurfaceTexture = null;
      }
      paramSurfaceTexture.start();
      localObject1 = StoryFakeVideoPlayView.a(this.NXs);
      paramSurfaceTexture = (SurfaceTexture)localObject1;
      if (localObject1 == null)
      {
        s.bIx("glThread");
        paramSurfaceTexture = null;
      }
      paramSurfaceTexture.fd(paramInt1, paramInt2);
      paramSurfaceTexture = StoryFakeVideoPlayView.a(this.NXs);
      if (paramSurfaceTexture == null)
      {
        s.bIx("glThread");
        paramSurfaceTexture = localObject2;
      }
      for (;;)
      {
        localObject1 = f.NGM;
        long l = 1000 / f.getFrameRate();
        paramSurfaceTexture.NET.NFM = l;
        StoryFakeVideoPlayView.a(this.NXs, true);
        paramSurfaceTexture = StoryFakeVideoPlayView.NXh;
        Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureAvailable");
        AppMethodBeat.o(76058);
        return;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76057);
      s.u(paramSurfaceTexture, "surface");
      paramSurfaceTexture = StoryFakeVideoPlayView.NXh;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureDestroyed");
      StoryFakeVideoPlayView.a(this.NXs, false);
      c localc = StoryFakeVideoPlayView.a(this.NXs);
      paramSurfaceTexture = localc;
      if (localc == null)
      {
        s.bIx("glThread");
        paramSurfaceTexture = null;
      }
      paramSurfaceTexture.stop();
      AppMethodBeat.o(76057);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(76055);
      s.u(paramSurfaceTexture, "surface");
      paramSurfaceTexture = StoryFakeVideoPlayView.NXh;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureSizeChanged");
      AppMethodBeat.o(76055);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76056);
      s.u(paramSurfaceTexture, "surface");
      paramSurfaceTexture = StoryFakeVideoPlayView.NXh;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureUpdated");
      AppMethodBeat.o(76056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView
 * JD-Core Version:    0.7.0.1
 */