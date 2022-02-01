package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.a.b.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
{
  private static String TAG = "MicroMsg.SnsPostDescUtil";
  
  public static l a(Context paramContext, String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(100558);
    paramContext = new l(k.a(paramContext, paramString, (int)paramFloat, 2, paramBoolean));
    AppMethodBeat.o(100558);
    return paramContext;
  }
  
  public static CharSequence d(Spannable paramSpannable)
  {
    AppMethodBeat.i(220161);
    localSpannableStringBuilder = new SpannableStringBuilder(paramSpannable);
    try
    {
      if (!bu.ah(paramSpannable))
      {
        o[] arrayOfo = (o[])paramSpannable.getSpans(0, paramSpannable.length(), o.class);
        if ((arrayOfo != null) && (arrayOfo.length > 0))
        {
          int j = arrayOfo.length;
          int i = 0;
          while (i < j)
          {
            o localo = arrayOfo[i];
            if (localo.getType() == 1)
            {
              String str1 = localo.getHrefInfo().url;
              if ((str1 != null) && (str1.length() > a.AIW))
              {
                String str2 = str1.substring(0, a.AIW) + "...";
                SpannableString localSpannableString = new SpannableString(str2);
                localSpannableString.setSpan(new o(2, localo.getHrefInfo()), 0, str2.length(), 33);
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
      ae.w(TAG, "compressedPostDesc fail:%s", new Object[] { paramSpannable });
      AppMethodBeat.o(220161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */