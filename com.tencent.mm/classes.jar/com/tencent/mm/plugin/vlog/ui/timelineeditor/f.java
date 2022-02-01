package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.vlog.model.report.b;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getPlayView", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "setPlayView", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;)V", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoSeekable", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin$videoSeekable$1;", "fastMuteOrigin", "", "mute", "", "flushSurface", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "pause", "registerCallback", "callback", "release", "resume", "seek", "seekMs", "setPlayRange", "startMs", "endMs", "start", "updateComposition", "playAfterUpdate", "seekToOriginPosition", "seekTo", "Companion", "plugin-vlog_release"})
public final class f
  extends a
  implements a.a.a
{
  public static final a NEg;
  public VideoCompositionPlayView AJS;
  d APl;
  private final b NEf;
  public j NmT;
  public d.e NuH;
  private final LinkedList<com.tencent.mm.plugin.vlog.ui.plugin.d.b> Nuy;
  
  static
  {
    AppMethodBeat.i(251752);
    NEg = new a((byte)0);
    AppMethodBeat.o(251752);
  }
  
  public f(VideoCompositionPlayView paramVideoCompositionPlayView, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(251749);
    this.AJS = paramVideoCompositionPlayView;
    this.APl = paramd;
    this.Nuy = new LinkedList();
    this.NEf = new b(this);
    this.AJS.setPlayerCallback((a.a.a)this);
    AppMethodBeat.o(251749);
  }
  
  public final void Np(long paramLong)
  {
    AppMethodBeat.i(251739);
    Iterator localIterator = ((Iterable)this.Nuy).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.vlog.ui.plugin.d.b localb = (com.tencent.mm.plugin.vlog.ui.plugin.d.b)localIterator.next();
      if ((localb instanceof com.tencent.mm.plugin.vlog.ui.plugin.d.c)) {
        ((com.tencent.mm.plugin.vlog.ui.plugin.d.c)localb).LX(paramLong);
      }
    }
    AppMethodBeat.o(251739);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.ui.plugin.d.b paramb)
  {
    AppMethodBeat.i(251732);
    p.k(paramb, "callback");
    if (!this.Nuy.contains(paramb)) {
      this.Nuy.add(paramb);
    }
    AppMethodBeat.o(251732);
  }
  
  public final void a(j paramj, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(251728);
    if (paramj != null)
    {
      this.NmT = paramj;
      this.AJS.a(paramj, paramBoolean1, paramBoolean2, paramLong);
      AppMethodBeat.o(251728);
      return;
    }
    AppMethodBeat.o(251728);
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(251720);
    this.AJS.aG(paramLong1, paramLong2);
    AppMethodBeat.o(251720);
  }
  
  public final void egA()
  {
    AppMethodBeat.i(251742);
    Object localObject = ((Iterable)this.Nuy).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.vlog.ui.plugin.d.b localb = (com.tencent.mm.plugin.vlog.ui.plugin.d.b)((Iterator)localObject).next();
      if ((localb instanceof com.tencent.mm.plugin.vlog.ui.plugin.d.c)) {
        ((com.tencent.mm.plugin.vlog.ui.plugin.d.c)localb).a((d.e)this.NEf);
      }
    }
    long l2 = this.AJS.getPosition();
    localObject = this.NmT;
    if (localObject != null) {}
    for (long l1 = ((j)localObject).getPlayStart();; l1 = 0L)
    {
      l1 /= 1000L;
      localObject = this.NuH;
      if (localObject == null) {
        break;
      }
      ((d.e)localObject).Sw(l2 - l1);
      AppMethodBeat.o(251742);
      return;
    }
    AppMethodBeat.o(251742);
  }
  
  public final void egB() {}
  
  public final void egC()
  {
    AppMethodBeat.i(251734);
    Iterator localIterator = ((Iterable)this.Nuy).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(251734);
  }
  
  public final void egD()
  {
    AppMethodBeat.i(251737);
    com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTJ);
    AppMethodBeat.o(251737);
  }
  
  public final void egE() {}
  
  public final void pause()
  {
    AppMethodBeat.i(251725);
    this.AJS.pause();
    AppMethodBeat.o(251725);
  }
  
  public final void release()
  {
    AppMethodBeat.i(251746);
    super.release();
    this.Nuy.clear();
    AppMethodBeat.o(251746);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(251723);
    "seek to ".concat(String.valueOf(paramLong));
    h.ioq();
    this.AJS.seekTo(paramLong);
    AppMethodBeat.o(251723);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
  public static final class b
    implements d.e
  {
    public final void Sw(long paramLong)
    {
      AppMethodBeat.i(225860);
      b localb = b.NoK;
      b.report(0L);
      this.NEh.AJS.seekTo(paramLong);
      AppMethodBeat.o(225860);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(225863);
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.NEh.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSf);
      AppMethodBeat.o(225863);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(225865);
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.NEh.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSg);
      AppMethodBeat.o(225865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.f
 * JD-Core Version:    0.7.0.1
 */