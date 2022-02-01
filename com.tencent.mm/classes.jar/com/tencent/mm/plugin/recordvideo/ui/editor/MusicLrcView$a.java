package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$Companion;", "", "()V", "spanForQuery", "", "source", "", "hlString", "foregroundColor", "", "plugin-recordvideo_release"})
public final class MusicLrcView$a
{
  public static CharSequence a(String paramString, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(220825);
    p.k(paramString, "source");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (CharSequence)localSpannableString;
      AppMethodBeat.o(220825);
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
        AppMethodBeat.o(220825);
        return paramString;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView.a
 * JD-Core Version:    0.7.0.1
 */