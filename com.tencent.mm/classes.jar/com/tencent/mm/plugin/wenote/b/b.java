package com.tencent.mm.plugin.wenote.b;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  public static ArrayList<String> UA(String paramString)
  {
    if ((bk.bl(paramString)) || (paramString.length() == 0)) {
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
    return localArrayList;
  }
  
  public static String UB(String paramString)
  {
    if ((bk.bl(paramString)) || (paramString.length() == 0)) {
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
    return Pattern.compile("&nbsp;", 2).matcher(paramString).replaceAll(" ");
  }
  
  public static boolean UC(String paramString)
  {
    int k = "<br/>".length();
    if ((bk.bl(paramString)) || (paramString.length() < k)) {
      return false;
    }
    int j;
    for (int i = 0;; i = j)
    {
      if (i >= paramString.length()) {
        break label64;
      }
      j = i + k;
      if ((j > paramString.length()) || (!"<br/>".equalsIgnoreCase(paramString.substring(i, j)))) {
        break;
      }
    }
    label64:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.b
 * JD-Core Version:    0.7.0.1
 */