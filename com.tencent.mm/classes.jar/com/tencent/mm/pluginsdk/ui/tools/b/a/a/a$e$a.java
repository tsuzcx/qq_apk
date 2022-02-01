package com.tencent.mm.pluginsdk.ui.tools.b.a.a;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Companion;", "", "()V", "taskContainer", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "clearFetchDurationTask", "", "fetchDurationMs", "tv", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "setResult", "durationMs", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$e$a
{
  static void l(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(245843);
    if (paramTextView == null)
    {
      AppMethodBeat.o(245843);
      return;
    }
    if (paramInt < 0)
    {
      paramTextView.setText((CharSequence)"--:--");
      AppMethodBeat.o(245843);
      return;
    }
    paramInt = Math.round(paramInt / 1000.0F);
    String str2 = String.valueOf(paramInt % 60);
    String str1 = str2;
    if (str2.length() < 2) {
      str1 = s.X("0", str2);
    }
    paramTextView.setText((CharSequence)(paramInt / 60 + ':' + str1));
    AppMethodBeat.o(245843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.e.a
 * JD-Core Version:    0.7.0.1
 */