package com.tencent.mm.plugin.story.image2video;

import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$Callback;)V", "canResume", "", "curImageList", "", "", "curPos", "glThread", "Lcom/tencent/mm/plugin/story/image2video/GLThread;", "playStatus", "Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$STATUS;", "render", "Lcom/tencent/mm/plugin/story/image2video/StoryImageVideoRender;", "surfaceAvailable", "task", "Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$VideoLoopTask;", "getCurPos", "init", "", "isPlaying", "pause", "play", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resume", "stop", "Callback", "Companion", "STATUS", "VideoLoopTask", "plugin-story_release"})
public final class StoryFakeVideoPlayView
  extends TextureView
{
  public static final String TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
  public static final b stA;
  private j ssZ;
  private c sta;
  public c stt;
  private boolean stu;
  private StoryFakeVideoPlayView.a stv;
  private int stw;
  private d stx;
  public boolean sty;
  private List<String> stz;
  
  static
  {
    AppMethodBeat.i(151038);
    stA = new b((byte)0);
    TAG = "MicroMsg.Story.StoryFakeVideoPlayView";
    AppMethodBeat.o(151038);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(151036);
    this.stt = c.stB;
    init();
    AppMethodBeat.o(151036);
  }
  
  public StoryFakeVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(151037);
    this.stt = c.stB;
    init();
    AppMethodBeat.o(151037);
  }
  
  private void init()
  {
    AppMethodBeat.i(151032);
    this.ssZ = new j();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)new StoryFakeVideoPlayView.e(this));
    AppMethodBeat.o(151032);
  }
  
  public final void T(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(151033);
    a.f.b.j.q(paramArrayList, "imageList");
    ab.i(TAG, "play");
    d locald = this.stx;
    if (locald != null)
    {
      List localList = this.stz;
      int k;
      int i;
      if (localList != null) {
        if (localList.size() == paramArrayList.size())
        {
          k = paramArrayList.size() - 1;
          if (k >= 0)
          {
            i = 0;
            if (!bo.isEqual((String)paramArrayList.get(i), (String)localList.get(i))) {
              i = j;
            }
          }
        }
      }
      for (;;)
      {
        if ((i == 0) || (locald.oIr)) {
          break label148;
        }
        ab.i(TAG, "play same imagelist, do nothing");
        AppMethodBeat.o(151033);
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
      locald.oIr = true;
    }
    this.stz = ((List)paramArrayList);
    this.stx = new d(paramArrayList);
    com.tencent.mm.sdk.g.d.h((Runnable)this.stx, "Story_VideoLoopTask").start();
    AppMethodBeat.o(151033);
  }
  
  public final StoryFakeVideoPlayView.a getCallback()
  {
    return this.stv;
  }
  
  public final int getCurPos()
  {
    return this.stw;
  }
  
  public final boolean isPlaying()
  {
    return this.stt == c.stC;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(151034);
    ab.i(TAG, "resume");
    this.stt = c.stC;
    AppMethodBeat.o(151034);
  }
  
  public final void setCallback(StoryFakeVideoPlayView.a parama)
  {
    this.stv = parama;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(151035);
    ab.i(TAG, "stop");
    this.stt = c.stB;
    d locald = this.stx;
    if (locald != null)
    {
      locald.oIr = true;
      AppMethodBeat.o(151035);
      return;
    }
    AppMethodBeat.o(151035);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class b {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$STATUS;", "", "(Ljava/lang/String;I)V", "STOP", "PLAYING", "PAUSE", "plugin-story_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(151023);
      c localc1 = new c("STOP", 0);
      stB = localc1;
      c localc2 = new c("PLAYING", 1);
      stC = localc2;
      c localc3 = new c("PAUSE", 2);
      stD = localc3;
      stE = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(151023);
    }
    
    private c() {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$VideoLoopTask;", "Ljava/lang/Runnable;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView;Ljava/util/ArrayList;)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "run", "", "plugin-story_release"})
  public final class d
    implements Runnable
  {
    boolean oIr;
    private ArrayList<String> ste;
    
    public d()
    {
      AppMethodBeat.i(151029);
      this.ste = localObject;
      AppMethodBeat.o(151029);
    }
    
    public final void run()
    {
      AppMethodBeat.i(151028);
      StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this, StoryFakeVideoPlayView.c.stC);
      while (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this)) {
        Thread.sleep(100L);
      }
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).sud.czV();
      StoryFakeVideoPlayView.c(StoryFakeVideoPlayView.this).dD((List)this.ste);
      if (this.oIr)
      {
        AppMethodBeat.o(151028);
        return;
        if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.stD) {
          break label269;
        }
        StoryFakeVideoPlayView.e(StoryFakeVideoPlayView.this);
        Thread.sleep(500L);
      }
      for (;;)
      {
        if (this.oIr) {
          break label301;
        }
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.stC) || (!StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break;
        }
        int k = 15000 / d.ssU;
        StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).postJob((Runnable)new StoryFakeVideoPlayView.d.b(this));
        int j;
        for (int i = 0;; i = j)
        {
          j = i + 1;
          if ((i >= k) || (this.oIr)) {
            break;
          }
          StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this, (int)(j * (1000L / d.ssU)));
          if (StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.stC) {
            break;
          }
          StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).requestRender();
          if (StoryFakeVideoPlayView.this.getCallback() != null) {
            StoryFakeVideoPlayView.d(StoryFakeVideoPlayView.this).postJob((Runnable)new StoryFakeVideoPlayView.d.a(this));
          }
          Thread.sleep(1000L / d.ssU);
        }
        label269:
        if ((StoryFakeVideoPlayView.a(StoryFakeVideoPlayView.this) != StoryFakeVideoPlayView.c.stC) || (StoryFakeVideoPlayView.b(StoryFakeVideoPlayView.this))) {
          break label301;
        }
        Thread.sleep(500L);
      }
      label301:
      StoryFakeVideoPlayView.b localb = StoryFakeVideoPlayView.stA;
      ab.i(StoryFakeVideoPlayView.access$getTAG$cp(), "video play end");
      AppMethodBeat.o(151028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView
 * JD-Core Version:    0.7.0.1
 */