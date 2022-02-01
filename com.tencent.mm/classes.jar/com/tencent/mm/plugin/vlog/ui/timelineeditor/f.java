package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.model.report.b;
import com.tencent.mm.plugin.vlog.ui.plugin.d.b;
import com.tencent.mm.plugin.vlog.ui.plugin.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getPlayView", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "setPlayView", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;)V", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "videoSeekable", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin$videoSeekable$1;", "flushSurface", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "pause", "registerCallback", "callback", "release", "resume", "seek", "seekMs", "setPlayRange", "startMs", "endMs", "start", "updateComposition", "playAfterUpdate", "", "seekToOriginPosition", "seekTo", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements a.a.a
{
  public static final f.a UqA;
  public VideoCompositionPlayView GmD;
  public j Uaw;
  private final LinkedList<d.b> UhS;
  public d.e Uib;
  private final b UqB;
  
  static
  {
    AppMethodBeat.i(282284);
    UqA = new f.a((byte)0);
    AppMethodBeat.o(282284);
  }
  
  public f(VideoCompositionPlayView paramVideoCompositionPlayView, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282264);
    this.GmD = paramVideoCompositionPlayView;
    this.UhS = new LinkedList();
    this.UqB = new b(this, parama);
    this.GmD.setPlayerCallback((a.a.a)this);
    AppMethodBeat.o(282264);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(282327);
    s.u(paramb, "callback");
    if (!this.UhS.contains(paramb)) {
      this.UhS.add(paramb);
    }
    AppMethodBeat.o(282327);
  }
  
  public final void a(j paramj, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(282316);
    if (paramj != null)
    {
      this.Uaw = paramj;
      this.GmD.a(paramj, paramBoolean1, paramBoolean2, paramLong);
    }
    AppMethodBeat.o(282316);
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(282292);
    this.GmD.bs(paramLong1, paramLong2);
    AppMethodBeat.o(282292);
  }
  
  public final void fiA()
  {
    AppMethodBeat.i(282347);
    a.b.a(this.GrC, a.c.NQt);
    AppMethodBeat.o(282347);
  }
  
  public final void fiB() {}
  
  public final void fix()
  {
    AppMethodBeat.i(282356);
    Object localObject = ((Iterable)this.UhS).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.b localb = (d.b)((Iterator)localObject).next();
      if ((localb instanceof d.c)) {
        ((d.c)localb).a((d.e)this.UqB);
      }
    }
    long l2 = this.GmD.getPosition();
    localObject = this.Uaw;
    if (localObject == null) {}
    for (long l1 = 0L;; l1 = ((j)localObject).getPlayStart())
    {
      l1 /= 1000L;
      localObject = this.Uib;
      if (localObject != null) {
        ((d.e)localObject).wK(l2 - l1);
      }
      AppMethodBeat.o(282356);
      return;
    }
  }
  
  public final void fiy() {}
  
  public final void fiz()
  {
    AppMethodBeat.i(282334);
    Iterator localIterator = ((Iterable)this.UhS).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(282334);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(282310);
    this.GmD.pause();
    AppMethodBeat.o(282310);
  }
  
  public final void qT(long paramLong)
  {
    AppMethodBeat.i(282349);
    Iterator localIterator = ((Iterable)this.UhS).iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if ((localb instanceof d.c)) {
        ((d.c)localb).qU(paramLong);
      }
    }
    AppMethodBeat.o(282349);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282372);
    super.release();
    this.UhS.clear();
    AppMethodBeat.o(282372);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(282299);
    s.X("seek to ", Long.valueOf(paramLong));
    h.jXD();
    this.GmD.seekTo(paramLong);
    AppMethodBeat.o(282299);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d.e
  {
    b(f paramf, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama) {}
    
    public final void pause()
    {
      AppMethodBeat.i(282238);
      a.b.a(parama, a.c.NOL);
      AppMethodBeat.o(282238);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(282243);
      a.b.a(parama, a.c.NOM);
      AppMethodBeat.o(282243);
    }
    
    public final void wK(long paramLong)
    {
      AppMethodBeat.i(282230);
      b localb = b.Ucm;
      b.report(0L);
      this.UqC.GmD.seekTo(paramLong);
      AppMethodBeat.o(282230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.f
 * JD-Core Version:    0.7.0.1
 */