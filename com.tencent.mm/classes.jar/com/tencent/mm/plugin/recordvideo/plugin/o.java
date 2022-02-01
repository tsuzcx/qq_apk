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
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "fakeVideoPlayViewCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1;", "startTime", "getStartTime", "setStartTime", "getVideoPlayView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "onBackPress", "", "onPause", "", "onResume", "release", "reset", "setVisibility", "visibility", "start", "info", "Companion", "plugin-recordvideo_release"})
public final class o
  implements t
{
  public static final o.a xAW;
  public int ddx;
  public int htQ;
  public final b xAU;
  public StoryFakeVideoPlayView xAV;
  public b xAw;
  
  static
  {
    AppMethodBeat.i(75573);
    xAW = new o.a((byte)0);
    AppMethodBeat.o(75573);
  }
  
  public o(StoryFakeVideoPlayView paramStoryFakeVideoPlayView, final d paramd)
  {
    AppMethodBeat.i(75572);
    this.xAV = paramStoryFakeVideoPlayView;
    this.xAU = new b(this, paramd);
    AppMethodBeat.o(75572);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(75569);
    this.xAV.stop();
    AppMethodBeat.o(75569);
    return false;
  }
  
  public final void ayX() {}
  
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
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.xAV;
    ad.i(StoryFakeVideoPlayView.TAG, "pause");
    localStoryFakeVideoPlayView.xNm = StoryFakeVideoPlayView.c.xNv;
    AppMethodBeat.o(75568);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200319);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200319);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75567);
    ad.i("MicroMsg.EditPhotoToVideoPlugin", "onResume");
    Object localObject = this.xAw;
    if (localObject != null)
    {
      localObject = ((b)localObject).htW;
      if (localObject != null)
      {
        if (!((ArrayList)localObject).isEmpty()) {
          this.xAV.resume();
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
    this.xAV.stop();
    this.xAw = null;
    AppMethodBeat.o(75570);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75571);
    this.xAV.stop();
    this.xAw = null;
    AppMethodBeat.o(75571);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75566);
    this.xAV.setVisibility(paramInt);
    AppMethodBeat.o(75566);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    b(d paramd) {}
    
    public final void ta()
    {
      AppMethodBeat.i(75565);
      this.xAX.xAV.post((Runnable)new a(this));
      AppMethodBeat.o(75565);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(o.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75564);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_VIDEO_NEED_CROP", false);
        this.xAZ.xAX.xAV.setAlpha(0.99F);
        d.b.a(this.xAZ.xAY, d.c.xEu);
        this.xAZ.xAY.a(d.c.xEX, localBundle);
        ad.i("MicroMsg.EditPhotoToVideoPlugin", "setup fakeVideoPlayView onPrepared");
        AppMethodBeat.o(75564);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.o
 * JD-Core Version:    0.7.0.1
 */