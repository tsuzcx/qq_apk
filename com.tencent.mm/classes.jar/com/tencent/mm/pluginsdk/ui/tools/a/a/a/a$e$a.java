package com.tencent.mm.pluginsdk.ui.tools.a.a.a;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Companion;", "", "()V", "taskContainer", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "clearFetchDurationTask", "", "fetchDurationMs", "tv", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "setResult", "durationMs", "", "app_release"})
public final class a$e$a
{
  static void j(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(286884);
    if (paramTextView == null)
    {
      AppMethodBeat.o(286884);
      return;
    }
    if (paramInt < 0)
    {
      paramTextView.setText((CharSequence)"--:--");
      AppMethodBeat.o(286884);
      return;
    }
    paramInt = Math.round(paramInt / 1000.0F);
    String str2 = String.valueOf(paramInt % 60);
    String str1 = str2;
    if (str2.length() < 2) {
      str1 = "0".concat(String.valueOf(str2));
    }
    paramTextView.setText((CharSequence)(String.valueOf(paramInt / 60) + ":" + str1));
    AppMethodBeat.o(286884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.e.a
 * JD-Core Version:    0.7.0.1
 */