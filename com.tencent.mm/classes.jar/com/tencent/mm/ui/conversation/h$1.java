package com.tencent.mm.ui.conversation;

import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;

final class h$1
  implements NoMeasuredTextView.c
{
  h$1(h paramh) {}
  
  public final CharSequence a(NoMeasuredTextView paramNoMeasuredTextView, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34353);
    float f1 = paramNoMeasuredTextView.getPaint().getTextSize();
    paramInt2 = a.fromDPToPix(h.a(this.Akm), paramInt2);
    paramNoMeasuredTextView.getPaint().setTextSize(paramInt2);
    float f2 = paramNoMeasuredTextView.getPaint().measureText(" ".concat(String.valueOf(paramString)));
    paramNoMeasuredTextView.getPaint().setTextSize(f1);
    int i = paramNoMeasuredTextView.getMeasuredWidth() - paramNoMeasuredTextView.getCompoundPaddingRight() - paramNoMeasuredTextView.getCompoundPaddingLeft();
    if (f2 >= i * 0.6D)
    {
      paramCharSequence = TextUtils.ellipsize(paramCharSequence, paramNoMeasuredTextView.getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
      f2 = paramNoMeasuredTextView.getPaint().measureText(paramCharSequence.toString());
      paramNoMeasuredTextView.getPaint().setTextSize(paramInt2);
      paramString = TextUtils.ellipsize(paramString, paramNoMeasuredTextView.getPaint(), i - f2 - 20.0F, TextUtils.TruncateAt.END);
      paramNoMeasuredTextView.getPaint().setTextSize(f1);
    }
    for (paramNoMeasuredTextView = paramCharSequence;; paramNoMeasuredTextView = TextUtils.ellipsize(paramCharSequence, paramNoMeasuredTextView.getPaint(), i - f2, TextUtils.TruncateAt.END))
    {
      paramCharSequence = j.b(h.b(this.Akm), paramNoMeasuredTextView + " " + paramString);
      ColorStateList localColorStateList = a.l(h.c(this.Akm), paramInt1);
      paramCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramInt2, localColorStateList, localColorStateList), paramNoMeasuredTextView.length() + 1, paramNoMeasuredTextView.length() + 1 + paramString.length(), 33);
      AppMethodBeat.o(34353);
      return paramCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.1
 * JD-Core Version:    0.7.0.1
 */