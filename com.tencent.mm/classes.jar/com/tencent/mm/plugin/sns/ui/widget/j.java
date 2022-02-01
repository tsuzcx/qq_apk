package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.h.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
{
  private static String TAG = "MicroMsg.SnsPostDescUtil";
  
  public static q a(Context paramContext, String paramString, float paramFloat, boolean paramBoolean, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(309198);
    paramContext = new q(a.a(paramLong, p.b(paramContext, paramString, (int)paramFloat, paramBoolean, paramObject), 0));
    AppMethodBeat.o(309198);
    return paramContext;
  }
  
  public static CharSequence d(Spannable paramSpannable)
  {
    AppMethodBeat.i(309202);
    localSpannableStringBuilder = new SpannableStringBuilder(paramSpannable);
    try
    {
      if (!Util.isNullOrNil(paramSpannable))
      {
        t[] arrayOft = (t[])paramSpannable.getSpans(0, paramSpannable.length(), t.class);
        if ((arrayOft != null) && (arrayOft.length > 0))
        {
          int j = arrayOft.length;
          int i = 0;
          while (i < j)
          {
            t localt = arrayOft[i];
            if (localt.getType() == 1)
            {
              String str1 = localt.getHrefInfo().url;
              if ((str1 != null) && (str1.length() > aj.Qum) && (localSpannableStringBuilder.toString().contains(str1)))
              {
                String str2 = str1.substring(0, aj.Qum) + "...";
                SpannableString localSpannableString = new SpannableString(str2);
                localSpannableString.setSpan(new t(2, localt.getHrefInfo()), 0, str2.length(), 33);
                int k = localSpannableStringBuilder.toString().indexOf(str1);
                localSpannableStringBuilder.replace(k, str1.length() + k, localSpannableString);
              }
            }
            i += 1;
          }
        }
      }
      return localSpannableStringBuilder;
    }
    catch (Exception localException)
    {
      Log.w(TAG, "compressedPostDesc fail:%s", new Object[] { paramSpannable });
      AppMethodBeat.o(309202);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */