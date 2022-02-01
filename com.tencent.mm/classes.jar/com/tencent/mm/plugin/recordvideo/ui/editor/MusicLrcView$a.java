package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$Companion;", "", "()V", "spanForQuery", "", "source", "", "hlString", "foregroundColor", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicLrcView$a
{
  public static CharSequence a(String paramString, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(279909);
    s.u(paramString, "source");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (CharSequence)localSpannableString;
      AppMethodBeat.o(279909);
      return paramString;
    }
    int j = paramCharSequence.length();
    i = 0;
    int k = n.a((CharSequence)paramString, paramCharSequence.toString(), i, false);
    if (k != -1)
    {
      i = k + j + i;
      localSpannableString.setSpan(new ForegroundColorSpan(paramInt), k, k + j, 33);
    }
    for (;;)
    {
      if (k == -1)
      {
        paramString = (CharSequence)localSpannableString;
        AppMethodBeat.o(279909);
        return paramString;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView.a
 * JD-Core Version:    0.7.0.1
 */