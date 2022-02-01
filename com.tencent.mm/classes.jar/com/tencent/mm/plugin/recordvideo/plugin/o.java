package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "fakeVideoPlayViewCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1;", "startTime", "getStartTime", "setStartTime", "getVideoPlayView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "onBackPress", "", "onPause", "", "onResume", "release", "reset", "setVisibility", "visibility", "start", "info", "Companion", "plugin-recordvideo_release"})
public final class o
  implements t
{
  public static final a vku;
  public int cUL;
  public int gBm;
  public b vjS;
  public final b vks;
  public StoryFakeVideoPlayView vkt;
  
  static
  {
    AppMethodBeat.i(75573);
    vku = new a((byte)0);
    AppMethodBeat.o(75573);
  }
  
  public o(StoryFakeVideoPlayView paramStoryFakeVideoPlayView, final d paramd)
  {
    AppMethodBeat.i(75572);
    this.vkt = paramStoryFakeVideoPlayView;
    this.vks = new b(this, paramd);
    AppMethodBeat.o(75572);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    AppMethodBeat.i(75569);
    this.vkt.stop();
    AppMethodBeat.o(75569);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(75568);
    ad.i("MicroMsg.EditPhotoToVideoPlugin", "onPause");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.vkt;
    ad.i(StoryFakeVideoPlayView.TAG, "pause");
    localStoryFakeVideoPlayView.vsn = StoryFakeVideoPlayView.c.vsw;
    AppMethodBeat.o(75568);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75567);
    ad.i("MicroMsg.EditPhotoToVideoPlugin", "onResume");
    Object localObject = this.vjS;
    if (localObject != null)
    {
      localObject = ((b)localObject).gBs;
      if (localObject != null)
      {
        if (!((ArrayList)localObject).isEmpty()) {
          this.vkt.resume();
        }
        AppMethodBeat.o(75567);
        return;
      }
    }
    AppMethodBeat.o(75567);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75570);
    ad.i("MicroMsg.EditPhotoToVideoPlugin", "release");
    this.vkt.stop();
    this.vjS = null;
    AppMethodBeat.o(75570);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75571);
    this.vkt.stop();
    this.vjS = null;
    AppMethodBeat.o(75571);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75566);
    this.vkt.setVisibility(paramInt);
    AppMethodBeat.o(75566);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    b(d paramd) {}
    
    public final void rq()
    {
      AppMethodBeat.i(75565);
      this.vkv.vkt.post((Runnable)new a(this));
      AppMethodBeat.o(75565);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(o.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75564);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_VIDEO_NEED_CROP", false);
        this.vkx.vkv.vkt.setAlpha(0.99F);
        d.b.a(this.vkx.vkw, d.c.vnG);
        this.vkx.vkw.a(d.c.voh, localBundle);
        ad.i("MicroMsg.EditPhotoToVideoPlugin", "setup fakeVideoPlayView onPrepared");
        AppMethodBeat.o(75564);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.o
 * JD-Core Version:    0.7.0.1
 */