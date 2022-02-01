package com.tencent.mm.plugin.sns.ui.widget;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.a.b.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
{
  public static CharSequence d(Spannable paramSpannable)
  {
    AppMethodBeat.i(200671);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannable);
    if (!bs.aj(paramSpannable))
    {
      paramSpannable = (o[])paramSpannable.getSpans(0, paramSpannable.length(), o.class);
      if ((paramSpannable != null) && (paramSpannable.length > 0))
      {
        int j = paramSpannable.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramSpannable[i];
          if (localObject.getType() == 1)
          {
            String str1 = localObject.getHrefInfo().url;
            if ((str1 != null) && (str1.length() > a.yZS))
            {
              String str2 = str1.substring(0, a.yZS) + "...";
              SpannableString localSpannableString = new SpannableString(str2);
              localSpannableString.setSpan(new o(2, localObject.getHrefInfo()), 0, str2.length(), 33);
              int k = localSpannableStringBuilder.toString().indexOf(str1);
              localSpannableStringBuilder.replace(k, str1.length() + k, localSpannableString);
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(200671);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */