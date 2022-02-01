package com.tencent.mm.plugin.taskbar.ui.c;

import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/utils/TextUtils;", "", "()V", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "checkTitle", "", "title", "MAX_SHOW_TITLE_COUNT", "getNickName", "", "tv", "Landroid/widget/TextView;", "spanText", "maxWidth", "", "plugin-taskbar_release"})
public final class c
{
  public static final c FWh;
  
  static
  {
    AppMethodBeat.i(238572);
    FWh = new c();
    AppMethodBeat.o(238572);
  }
  
  public static CharSequence a(TextView paramTextView, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(238571);
    p.h(paramTextView, "tv");
    p.h(paramCharSequence, "spanText");
    paramTextView = TextUtils.ellipsize(paramCharSequence, paramTextView.getPaint(), paramFloat, TextUtils.TruncateAt.END);
    p.g(paramTextView, "TextUtils.ellipsize(span… tv.paint, maxWidth, END)");
    AppMethodBeat.o(238571);
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.c.c
 * JD-Core Version:    0.7.0.1
 */