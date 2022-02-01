package com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"MAX_VIDEO_DURATION_MS", "", "TAG", "", "getFinderContextId", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getMaxDurationMs", "getMediaType", "", "type", "getPostId", "getSessionId", "initMultiMediaModel", "", "mediaModel", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFollowMusic", "", "isMediaMute", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-vlog_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final String v(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282074);
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.oSS.getString("FINDER_CONTEXT_ID", "");
      Log.i("MicroMsg.TimelineEditorModelParser", s.X("getFinderContextId by parse:", paramRecordConfigProvider));
      s.s(paramRecordConfigProvider, "ret");
      AppMethodBeat.o(282074);
      return paramRecordConfigProvider;
    }
    Log.i("MicroMsg.TimelineEditorModelParser", "getFinderContextId by default:");
    AppMethodBeat.o(282074);
    return "";
  }
  
  public static final String w(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282080);
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.oSS.getString("FINDER_SESSION_ID", "");
      Log.i("MicroMsg.TimelineEditorModelParser", s.X("getSessionId by parse:", paramRecordConfigProvider));
      s.s(paramRecordConfigProvider, "ret");
      AppMethodBeat.o(282080);
      return paramRecordConfigProvider;
    }
    Log.i("MicroMsg.TimelineEditorModelParser", "getSessionId by default:");
    AppMethodBeat.o(282080);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.b
 * JD-Core Version:    0.7.0.1
 */