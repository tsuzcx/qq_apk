package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class j$a
{
  public static final Pattern FzF;
  public static final Pattern FzG;
  public static final Pattern FzH;
  public static final Pattern FzI;
  public static final Pattern FzJ;
  public static final Pattern FzK;
  public static final Pattern FzL;
  public static final Pattern FzM;
  public static final Pattern FzN;
  public static final Pattern FzO;
  public static final Pattern FzP;
  public static Pattern FzQ;
  public static final Pattern FzR;
  public static final Pattern FzS;
  public static final Pattern FzT;
  public static final Pattern FzU;
  public static final Pattern FzV;
  public static final Pattern FzW;
  public static final Pattern FzX;
  public static final Pattern FzY;
  
  static
  {
    AppMethodBeat.i(152274);
    FzF = Pattern.compile("<a.{1,500}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    FzG = Pattern.compile("<a.{1,100}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    FzH = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,500}?)\\s*[\"|']\\s*>(.+?)</a>");
    FzI = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,300}?)\\s*[\"|']\\s*>(.+?)</a>");
    FzJ = Pattern.compile("<_wc_custom_link_.+?color\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*href\\s*=\\s*[\"|']\\s*(.*?)\\s*[\"|']\\s*.*?>(.+?)</_wc_custom_link_>");
    FzK = Pattern.compile("<_wc_custom_link_.+?\\s*href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.+?)</_wc_custom_link_>");
    FzL = Pattern.compile("<img.+?src=\"(.+?).png\"/>\\s*");
    FzM = Pattern.compile("weixin://\\S+");
    FzN = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([-_a-zA-Z0-9]([-_a-zA-Z0-9\\-]{0,61}[-_a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,6}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[-_a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?", 2);
    FzO = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
    FzP = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9._-]+\\.[A-Z]+", 2);
    FzQ = Pattern.compile("#冒泡#");
    FzR = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})([,;]+\\d{0,20}#?){0,5}");
    FzS = Pattern.compile("weixin://wxpay/\\S+");
    FzT = Pattern.compile("weixin://dl/\\w+");
    FzU = Pattern.compile("weixin://dl/business(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~%\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    FzV = Pattern.compile("\\d{1,5}\\s(\\w+[\\s,.]+){2,8}\\d{5}(-\\d{4})?([\\s,]*USA)?", 2);
    FzW = Pattern.compile("([A-Za-z0-9]{3,})");
    FzX = Pattern.compile("^(62[0-9]{14,17})$");
    FzY = Pattern.compile("^(1[0-9]{10})$");
    AppMethodBeat.o(152274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.j.a
 * JD-Core Version:    0.7.0.1
 */