package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Html;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static String TAG;
  private static f<String, Spanned> omU;
  public static Spanned omV;
  
  static
  {
    AppMethodBeat.i(30381);
    TAG = "MicroMsg.ConvertHtmlToSpanned";
    omU = new com.tencent.mm.memory.a.c(30);
    omV = null;
    AppMethodBeat.o(30381);
  }
  
  public static Spanned Tc(String paramString)
  {
    AppMethodBeat.i(30379);
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    paramString = Pattern.compile("\n", 2).matcher((CharSequence)localObject).replaceAll("<br/>");
    localObject = fromHtml(paramString);
    omU.put(paramString, localObject);
    AppMethodBeat.o(30379);
    return localObject;
  }
  
  private static Spanned fromHtml(String paramString)
  {
    AppMethodBeat.i(30380);
    String str = paramString;
    if (!paramString.startsWith("<html>")) {
      str = "<html>".concat(String.valueOf(paramString));
    }
    paramString = str;
    if (!str.endsWith("</html>")) {
      paramString = str + "</html>";
    }
    try
    {
      omV = null;
      paramString = Html.fromHtml(paramString, null, new c());
      if (paramString == null)
      {
        AppMethodBeat.o(30380);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (omV != null)
        {
          paramString = omV;
          continue;
          int i = paramString.toString().length();
          if ((i > 1) && (paramString.toString().endsWith("\n")))
          {
            if (paramString.getSpans(i, i, ParagraphStyle.class).length > 0)
            {
              paramString = (Spanned)paramString.subSequence(0, i - 1);
              AppMethodBeat.o(30380);
              return paramString;
            }
            AppMethodBeat.o(30380);
            return paramString;
          }
          AppMethodBeat.o(30380);
          return paramString;
        }
        else
        {
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.a
 * JD-Core Version:    0.7.0.1
 */