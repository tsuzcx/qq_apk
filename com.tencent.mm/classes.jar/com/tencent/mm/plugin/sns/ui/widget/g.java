package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  private static String TAG = "MicroMsg.SnsPostDescUtil";
  
  public static m a(Context paramContext, String paramString, float paramFloat, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(267838);
    paramContext = new m(l.b(paramContext, paramString, (int)paramFloat, paramBoolean, paramObject));
    AppMethodBeat.o(267838);
    return paramContext;
  }
  
  public static CharSequence d(Spannable paramSpannable)
  {
    AppMethodBeat.i(267839);
    localSpannableStringBuilder = new SpannableStringBuilder(paramSpannable);
    try
    {
      if (!Util.isNullOrNil(paramSpannable))
      {
        p[] arrayOfp = (p[])paramSpannable.getSpans(0, paramSpannable.length(), p.class);
        if ((arrayOfp != null) && (arrayOfp.length > 0))
        {
          int j = arrayOfp.length;
          int i = 0;
          while (i < j)
          {
            p localp = arrayOfp[i];
            if (localp.getType() == 1)
            {
              String str1 = localp.getHrefInfo().url;
              if ((str1 != null) && (str1.length() > ah.JXe) && (localSpannableStringBuilder.toString().contains(str1)))
              {
                String str2 = str1.substring(0, ah.JXe) + "...";
                SpannableString localSpannableString = new SpannableString(str2);
                localSpannableString.setSpan(new p(2, localp.getHrefInfo()), 0, str2.length(), 33);
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
      AppMethodBeat.o(267839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */