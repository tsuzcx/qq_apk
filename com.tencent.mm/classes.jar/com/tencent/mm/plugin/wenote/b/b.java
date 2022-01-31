package com.tencent.mm.plugin.wenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  public static ArrayList<String> ajP(String paramString)
  {
    AppMethodBeat.i(26977);
    if ((bo.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(26977);
      return null;
    }
    paramString = Pattern.compile("<div><object[^>]*></object></div>", 2).matcher(paramString).replaceAll("<object>");
    paramString = Pattern.compile("<object[^>]*>", 2).matcher(paramString).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#");
    paramString = Pattern.compile("<hr[^>]*>", 2).matcher(paramString).replaceAll("#WNNoteNode#<ThisisNoteNodeHrObj>#WNNoteNode#");
    paramString = Pattern.compile("</object>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("<div></div>", 2).matcher(paramString).replaceAll("");
    String[] arrayOfString = Pattern.compile("\n", 2).matcher(paramString).replaceAll("").replaceAll("<br>", "<br/>").trim().split("#WNNoteNode#");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = arrayOfString[i];
      if (paramString.length() > 0)
      {
        String str = paramString.replace("</div>", "<div>");
        int j = -1;
        if (str.endsWith("<div>")) {
          j = str.lastIndexOf("<div>");
        }
        paramString = str;
        if (j > 0) {
          paramString = str.substring(0, j);
        }
        localArrayList.add(paramString.replace("<div><br/>", "<div>"));
      }
      i += 1;
    }
    AppMethodBeat.o(26977);
    return localArrayList;
  }
  
  public static String ajQ(String paramString)
  {
    AppMethodBeat.i(26978);
    if ((bo.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(26978);
      return paramString;
    }
    paramString = Pattern.compile("<br[^>]*>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("<div>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("</wx-li>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("</wx-todo>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("<hr[^>]*>", 2).matcher(paramString).replaceAll("\n");
    paramString = Pattern.compile("<p [^>]*>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("</p>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("<[^>]*>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("&nbsp;", 2).matcher(paramString).replaceAll(" ");
    AppMethodBeat.o(26978);
    return paramString;
  }
  
  public static boolean ajR(String paramString)
  {
    AppMethodBeat.i(26979);
    int k = "<br/>".length();
    if ((bo.isNullOrNil(paramString)) || (paramString.length() < k))
    {
      AppMethodBeat.o(26979);
      return false;
    }
    int j;
    for (int i = 0; i < paramString.length(); i = j)
    {
      j = i + k;
      if (j > paramString.length())
      {
        AppMethodBeat.o(26979);
        return false;
      }
      if (!"<br/>".equalsIgnoreCase(paramString.substring(i, j)))
      {
        AppMethodBeat.o(26979);
        return false;
      }
    }
    AppMethodBeat.o(26979);
    return true;
  }
  
  public static String ajS(String paramString)
  {
    AppMethodBeat.i(26980);
    paramString = ajQ(Pattern.compile("<object[^>]*>", 2).matcher(paramString).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
    if ((bo.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(26980);
      return paramString;
    }
    paramString = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    AppMethodBeat.o(26980);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.b
 * JD-Core Version:    0.7.0.1
 */