package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Html;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import com.tencent.mm.a.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static String TAG = "MicroMsg.ConvertHtmlToSpanned";
  private static f<String, Spanned> rHc = new f(30);
  public static Spanned rHd = null;
  
  public static Spanned Uw(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    paramString = Pattern.compile("\n", 2).matcher((CharSequence)localObject).replaceAll("<br/>");
    localObject = fromHtml(paramString);
    rHc.put(paramString, localObject);
    return localObject;
  }
  
  private static Spanned fromHtml(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("<html>")) {
      str = "<html>" + paramString;
    }
    paramString = str;
    if (!str.endsWith("</html>")) {
      paramString = str + "</html>";
    }
    try
    {
      rHd = null;
      paramString = Html.fromHtml(paramString, null, new c());
      if (paramString == null) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (rHd != null)
        {
          paramString = rHd;
          continue;
          int i = paramString.toString().length();
          if ((i > 1) && (paramString.toString().endsWith("\n")))
          {
            if (paramString.getSpans(i, i, ParagraphStyle.class).length > 0) {
              return (Spanned)paramString.subSequence(0, i - 1);
            }
            return paramString;
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.a
 * JD-Core Version:    0.7.0.1
 */