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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "fakeVideoPlayViewCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1;", "startTime", "getStartTime", "setStartTime", "getVideoPlayView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "onBackPress", "", "onPause", "", "onResume", "release", "reset", "setVisibility", "visibility", "start", "info", "Companion", "plugin-recordvideo_release"})
public final class o
  implements t
{
  public static final o.a xQR;
  public int dez;
  public int hwE;
  public final b xQP;
  public StoryFakeVideoPlayView xQQ;
  public b xQs;
  
  static
  {
    AppMethodBeat.i(75573);
    xQR = new o.a((byte)0);
    AppMethodBeat.o(75573);
  }
  
  public o(StoryFakeVideoPlayView paramStoryFakeVideoPlayView, final d paramd)
  {
    AppMethodBeat.i(75572);
    this.xQQ = paramStoryFakeVideoPlayView;
    this.xQP = new b(this, paramd);
    AppMethodBeat.o(75572);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75569);
    this.xQQ.stop();
    AppMethodBeat.o(75569);
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(75568);
    ae.i("MicroMsg.EditPhotoToVideoPlugin", "onPause");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.xQQ;
    ae.i(StoryFakeVideoPlayView.TAG, "pause");
    localStoryFakeVideoPlayView.ydf = StoryFakeVideoPlayView.c.ydo;
    AppMethodBeat.o(75568);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206580);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206580);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75567);
    ae.i("MicroMsg.EditPhotoToVideoPlugin", "onResume");
    Object localObject = this.xQs;
    if (localObject != null)
    {
      localObject = ((b)localObject).hwK;
      if (localObject != null)
      {
        if (!((ArrayList)localObject).isEmpty()) {
          this.xQQ.resume();
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
    ae.i("MicroMsg.EditPhotoToVideoPlugin", "release");
    this.xQQ.stop();
    this.xQs = null;
    AppMethodBeat.o(75570);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75571);
    this.xQQ.stop();
    this.xQs = null;
    AppMethodBeat.o(75571);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75566);
    this.xQQ.setVisibility(paramInt);
    AppMethodBeat.o(75566);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    b(d paramd) {}
    
    public final void ta()
    {
      AppMethodBeat.i(75565);
      this.xQS.xQQ.post((Runnable)new a(this));
      AppMethodBeat.o(75565);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(o.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75564);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_VIDEO_NEED_CROP", false);
        this.xQU.xQS.xQQ.setAlpha(0.99F);
        d.b.a(this.xQU.xQT, d.c.xUp);
        this.xQU.xQT.a(d.c.xUS, localBundle);
        ae.i("MicroMsg.EditPhotoToVideoPlugin", "setup fakeVideoPlayView onPrepared");
        AppMethodBeat.o(75564);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.o
 * JD-Core Version:    0.7.0.1
 */