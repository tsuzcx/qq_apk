package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "fakeVideoPlayViewCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1;", "startTime", "getStartTime", "setStartTime", "getVideoPlayView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "onBackPress", "", "onPause", "", "onResume", "release", "reset", "setVisibility", "visibility", "start", "info", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements v
{
  public static final q.a NKy;
  public final b NKA;
  public b NKf;
  public StoryFakeVideoPlayView NKz;
  public int endTime;
  public int startTime;
  
  static
  {
    AppMethodBeat.i(75573);
    NKy = new q.a((byte)0);
    AppMethodBeat.o(75573);
  }
  
  public q(StoryFakeVideoPlayView paramStoryFakeVideoPlayView, final a parama)
  {
    AppMethodBeat.i(75572);
    this.NKz = paramStoryFakeVideoPlayView;
    this.NKA = new b(this, parama);
    AppMethodBeat.o(75572);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280644);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280644);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280672);
    s.u(this, "this");
    AppMethodBeat.o(280672);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280653);
    String str = v.a.b(this);
    AppMethodBeat.o(280653);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280663);
    s.u(this, "this");
    AppMethodBeat.o(280663);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75569);
    this.NKz.stop();
    s.u((v)this, "this");
    AppMethodBeat.o(75569);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280681);
    s.u(this, "this");
    AppMethodBeat.o(280681);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(75568);
    Log.i("MicroMsg.EditPhotoToVideoPlugin", "onPause");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.NKz;
    Log.i(StoryFakeVideoPlayView.TAG, "pause");
    localStoryFakeVideoPlayView.NXi = StoryFakeVideoPlayView.c.NXq;
    AppMethodBeat.o(75568);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280689);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280689);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75567);
    Log.i("MicroMsg.EditPhotoToVideoPlugin", "onResume");
    Object localObject = this.NKf;
    if (localObject != null)
    {
      localObject = ((b)localObject).nKc;
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.NKz.resume();
      }
      AppMethodBeat.o(75567);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75570);
    Log.i("MicroMsg.EditPhotoToVideoPlugin", "release");
    this.NKz.stop();
    this.NKf = null;
    AppMethodBeat.o(75570);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75571);
    this.NKz.stop();
    this.NKf = null;
    AppMethodBeat.o(75571);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75566);
    this.NKz.setVisibility(paramInt);
    AppMethodBeat.o(75566);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    b(q paramq, a parama) {}
    
    private static final void a(q paramq, a parama)
    {
      AppMethodBeat.i(280452);
      s.u(paramq, "this$0");
      s.u(parama, "$status");
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_VIDEO_NEED_CROP", false);
      paramq.NKz.setAlpha(0.99F);
      a.b.a(parama, a.c.NOk);
      parama.a(a.c.NOR, localBundle);
      Log.i("MicroMsg.EditPhotoToVideoPlugin", "setup fakeVideoPlayView onPrepared");
      AppMethodBeat.o(280452);
    }
    
    public final void Qz()
    {
      AppMethodBeat.i(75565);
      this.NKB.NKz.post(new q.b..ExternalSyntheticLambda0(this.NKB, parama));
      AppMethodBeat.o(75565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.q
 * JD-Core Version:    0.7.0.1
 */