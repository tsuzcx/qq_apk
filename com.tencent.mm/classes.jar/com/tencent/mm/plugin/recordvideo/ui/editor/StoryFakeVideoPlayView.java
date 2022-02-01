package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.background.b.c;
import com.tencent.mm.plugin.recordvideo.background.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;)V", "canResume", "", "curImageList", "", "", "curPos", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "playStatus", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$STATUS;", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "surfaceAvailable", "task", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "getCurPos", "init", "", "isPlaying", "pause", "play", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resume", "stop", "Callback", "Companion", "STATUS", "VideoLoopTask", "plugin-recordvideo_release"})
public final class StoryFakeVideoPlayView
  extends TextureView
{
  public static final StoryFakeVideoPlayView.b Cen;
  public static final String TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
  private com.tencent.mm.plugin.recordvideo.background.b.h BLs;
  private c BLt;
  public StoryFakeVideoPlayView.c Ceh;
  private boolean Cei;
  private a Cej;
  private d Cek;
  boolean Cel;
  private List<String> Cem;
  private int uis;
  
  static
  {
    AppMethodBeat.i(76066);
    Cen = new StoryFakeVideoPlayView.b((byte)0);
    TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
    AppMethodBeat.o(76066);
  }
  
  public StoryFakeVideoPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76063);
    this.Ceh = StoryFakeVideoPlayView.c.Ceo;
    init();
    AppMethodBeat.o(76063);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(76064);
    this.Ceh = StoryFakeVideoPlayView.c.Ceo;
    init();
    AppMethodBeat.o(76064);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76065);
    this.Ceh = StoryFakeVideoPlayView.c.Ceo;
    init();
    AppMethodBeat.o(76065);
  }
  
  private void init()
  {
    AppMethodBeat.i(76059);
    this.BLs = new com.tencent.mm.plugin.recordvideo.background.b.h();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)new e(this));
    AppMethodBeat.o(76059);
  }
  
  public final void aK(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(76060);
    p.h(paramArrayList, "imageList");
    Log.i(TAG, "play");
    d locald = this.Cek;
    if (locald != null)
    {
      List localList = this.Cem;
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
    this.Cem = ((List)paramArrayList);
    this.Cek = new d(paramArrayList);
    paramArrayList = com.tencent.f.h.RTc;
    locald = this.Cek;
    if (locald == null) {
      p.hyc();
    }
    paramArrayList.ba((Runnable)locald);
    AppMethodBeat.o(76060);
  }
  
  public final a getCallback()
  {
    return this.Cej;
  }
  
  public final int getCurPos()
  {
    return this.uis;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76061);
    Log.i(TAG, "resume");
    this.Ceh = StoryFakeVideoPlayView.c.Cep;
    AppMethodBeat.o(76061);
  }
  
  public final void setCallback(a parama)
  {
    this.Cej = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76062);
    Log.i(TAG, "stop");
    this.Ceh = StoryFakeVideoPlayView.c.Ceo;
    d locald = this.Cek;
    if (locald != null)
    {
      locald.stop = true;
      AppMethodBeat.o(76062);
      return;
    }
    AppMethodBeat.o(76062);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "", "onPrepared", "", "plugin-recordvideo_release"})
  public static abstract interface a
  {
    public abstract void tf();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Ljava/util/ArrayList;)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "getKey", "run", "", "plugin-recordvideo_release"})
  public final class d
    implements com.tencent.f.i.h
  {
    private ArrayList<String> BLy;
    boolean stop;
    
    public d()
    {
      AppMethodBeat.i(76054);
      this.BLy = localObject;
      AppMethodBeat.o(76054);
    }
    
    public final String getKey()
    {
      return "Story_VideoLoopTask";
    }
    
    public final void run()
    {
      AppMethodBeat.i(76053);
      StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this, StoryFakeVideoPlayView.c.Cep);
      while (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this)) {
        Thread.sleep(100L);
      }
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).BMi.eJm();
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).ge((List)this.BLy);
      if (this.stop)
      {
        AppMethodBeat.o(76053);
        return;
        if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.Ceq) {
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
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.Cep) || (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break;
        }
        localObject = e.BNm;
        int i = e.eJs();
        localObject = e.BNm;
        int k = i / e.getFrameRate();
        StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).ax((Runnable)new b(this));
        int j;
        for (i = 0;; i = j)
        {
          j = i + 1;
          if ((i >= k) || (this.stop)) {
            break;
          }
          localObject = StoryFakeVideoPlayView.this;
          long l = j;
          e locale = e.BNm;
          StoryFakeVideoPlayView.a((StoryFakeVideoPlayView)localObject, (int)(l * (1000L / e.getFrameRate())));
          if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.Cep) {
            break;
          }
          StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).requestRender();
          if (StoryFakeVideoPlayView.this.getCallback() != null) {
            StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).ax((Runnable)new a(this));
          }
          localObject = e.BNm;
          Thread.sleep(1000L / e.getFrameRate());
        }
        label299:
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.Cep) || (StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break label331;
        }
        Thread.sleep(500L);
      }
      label331:
      Object localObject = StoryFakeVideoPlayView.Cen;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "video play end");
      AppMethodBeat.o(76053);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask$run$2$1"})
    static final class a
      implements Runnable
    {
      a(StoryFakeVideoPlayView.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(76051);
        StoryFakeVideoPlayView.a locala = this.Cet.Ces.getCallback();
        if (locala != null) {
          locala.tf();
        }
        this.Cet.Ces.setCallback(null);
        AppMethodBeat.o(76051);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(StoryFakeVideoPlayView.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(76052);
        StoryFakeVideoPlayView.c(this.Cet.Ces).startTime = 0L;
        AppMethodBeat.o(76052);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-recordvideo_release"})
  public static final class e
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(76058);
      StoryFakeVideoPlayView.a(this.Ces, new c(paramSurfaceTexture, StoryFakeVideoPlayView.c(this.Ces)));
      StoryFakeVideoPlayView.d(this.Ces).start();
      StoryFakeVideoPlayView.d(this.Ces).dL(paramInt1, paramInt2);
      paramSurfaceTexture = StoryFakeVideoPlayView.d(this.Ces);
      e locale = e.BNm;
      paramSurfaceTexture.setFrameRate(e.getFrameRate());
      StoryFakeVideoPlayView.a(this.Ces, true);
      paramSurfaceTexture = StoryFakeVideoPlayView.Cen;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureAvailable");
      AppMethodBeat.o(76058);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76057);
      paramSurfaceTexture = StoryFakeVideoPlayView.Cen;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureDestroyed");
      StoryFakeVideoPlayView.a(this.Ces, false);
      StoryFakeVideoPlayView.d(this.Ces).stop();
      AppMethodBeat.o(76057);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(76055);
      paramSurfaceTexture = StoryFakeVideoPlayView.Cen;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureSizeChanged");
      AppMethodBeat.o(76055);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(76056);
      paramSurfaceTexture = StoryFakeVideoPlayView.Cen;
      Log.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureUpdated");
      AppMethodBeat.o(76056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView
 * JD-Core Version:    0.7.0.1
 */