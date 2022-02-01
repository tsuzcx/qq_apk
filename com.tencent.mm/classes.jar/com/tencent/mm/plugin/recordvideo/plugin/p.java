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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "fakeVideoPlayViewCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1;", "startTime", "getStartTime", "setStartTime", "getVideoPlayView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "onBackPress", "", "onPause", "", "onResume", "release", "reset", "setVisibility", "visibility", "start", "info", "Companion", "plugin-recordvideo_release"})
public final class p
  implements u
{
  public static final a HNE;
  public final b HNC;
  public StoryFakeVideoPlayView HND;
  public b HNh;
  public int endTime;
  public int fod;
  
  static
  {
    AppMethodBeat.i(75573);
    HNE = new a((byte)0);
    AppMethodBeat.o(75573);
  }
  
  public p(StoryFakeVideoPlayView paramStoryFakeVideoPlayView, final d paramd)
  {
    AppMethodBeat.i(75572);
    this.HND = paramStoryFakeVideoPlayView;
    this.HNC = new b(this, paramd);
    AppMethodBeat.o(75572);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(222798);
    String str = getClass().getName();
    AppMethodBeat.o(222798);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75569);
    this.HND.stop();
    AppMethodBeat.o(75569);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(75568);
    Log.i("MicroMsg.EditPhotoToVideoPlugin", "onPause");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.HND;
    Log.i(StoryFakeVideoPlayView.TAG, "pause");
    localStoryFakeVideoPlayView.IaG = StoryFakeVideoPlayView.c.IaP;
    AppMethodBeat.o(75568);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(222803);
    kotlin.g.b.p.k(paramArrayOfString, "permissions");
    kotlin.g.b.p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(222803);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75567);
    Log.i("MicroMsg.EditPhotoToVideoPlugin", "onResume");
    Object localObject = this.HNh;
    if (localObject != null)
    {
      localObject = ((b)localObject).lfr;
      if (localObject != null)
      {
        if (!((ArrayList)localObject).isEmpty()) {
          this.HND.resume();
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
    Log.i("MicroMsg.EditPhotoToVideoPlugin", "release");
    this.HND.stop();
    this.HNh = null;
    AppMethodBeat.o(75570);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75571);
    this.HND.stop();
    this.HNh = null;
    AppMethodBeat.o(75571);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75566);
    this.HND.setVisibility(paramInt);
    AppMethodBeat.o(75566);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    b(d paramd) {}
    
    public final void qX()
    {
      AppMethodBeat.i(75565);
      this.HNF.HND.post((Runnable)new a(this));
      AppMethodBeat.o(75565);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(p.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75564);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("PARAM_VIDEO_NEED_CROP", false);
        this.HNH.HNF.HND.setAlpha(0.99F);
        d.b.a(this.HNH.HNG, d.c.HRE);
        this.HNH.HNG.a(d.c.HSl, localBundle);
        Log.i("MicroMsg.EditPhotoToVideoPlugin", "setup fakeVideoPlayView onPrepared");
        AppMethodBeat.o(75564);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p
 * JD-Core Version:    0.7.0.1
 */