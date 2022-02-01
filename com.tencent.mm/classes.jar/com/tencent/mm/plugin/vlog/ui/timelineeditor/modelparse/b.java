package com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse;

import android.os.Bundle;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"MAX_VIDEO_DURATION_MS", "", "TAG", "", "getFinderContextId", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getMaxDurationMs", "getMediaType", "", "type", "getPostId", "getSessionId", "initMultiMediaModel", "", "mediaModel", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFollowMusic", "", "isMediaMute", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-vlog_release"})
public final class b
{
  public static final String p(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(225088);
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.mab.getString("FINDER_CONTEXT_ID", "");
      "getFinderContextId by parse:".concat(String.valueOf(paramRecordConfigProvider));
      h.ioq();
      p.j(paramRecordConfigProvider, "ret");
      AppMethodBeat.o(225088);
      return paramRecordConfigProvider;
    }
    h.ioq();
    AppMethodBeat.o(225088);
    return "";
  }
  
  public static final String q(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(225090);
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.mab.getString("FINDER_SESSION_ID", "");
      "getSessionId by parse:".concat(String.valueOf(paramRecordConfigProvider));
      h.ioq();
      p.j(paramRecordConfigProvider, "ret");
      AppMethodBeat.o(225090);
      return paramRecordConfigProvider;
    }
    h.ioq();
    AppMethodBeat.o(225090);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.b
 * JD-Core Version:    0.7.0.1
 */