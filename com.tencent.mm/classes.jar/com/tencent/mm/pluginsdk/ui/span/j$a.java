package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class j$a
{
  public static final Pattern DCa;
  public static final Pattern DCb;
  public static final Pattern DCc;
  public static final Pattern DCd;
  public static final Pattern DCe;
  public static final Pattern DCf;
  public static final Pattern DCg;
  public static final Pattern DCh;
  public static final Pattern DCi;
  public static final Pattern DCj;
  public static final Pattern DCk;
  public static Pattern DCl;
  public static final Pattern DCm;
  public static final Pattern DCn;
  public static final Pattern DCo;
  public static final Pattern DCp;
  public static final Pattern DCq;
  public static final Pattern DCr;
  public static final Pattern DCs;
  public static final Pattern DCt;
  
  static
  {
    AppMethodBeat.i(152274);
    DCa = Pattern.compile("<a.{1,500}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    DCb = Pattern.compile("<a.{1,100}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    DCc = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,500}?)\\s*[\"|']\\s*>(.+?)</a>");
    DCd = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,300}?)\\s*[\"|']\\s*>(.+?)</a>");
    DCe = Pattern.compile("<_wc_custom_link_.+?color\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*href\\s*=\\s*[\"|']\\s*(.*?)\\s*[\"|']\\s*.*?>(.+?)</_wc_custom_link_>");
    DCf = Pattern.compile("<_wc_custom_link_.+?\\s*href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.+?)</_wc_custom_link_>");
    DCg = Pattern.compile("<img.+?src=\"(.+?).png\"/>\\s*");
    DCh = Pattern.compile("weixin://\\S+");
    DCi = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([-_a-zA-Z0-9]([-_a-zA-Z0-9\\-]{0,61}[-_a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,6}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[-_a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?", 2);
    DCj = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
    DCk = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9._-]+\\.[A-Z]+", 2);
    DCl = Pattern.compile("#冒泡#");
    DCm = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})([,;]+\\d{0,20}#?){0,5}");
    DCn = Pattern.compile("weixin://wxpay/\\S+");
    DCo = Pattern.compile("weixin://dl/\\w+");
    DCp = Pattern.compile("weixin://dl/business(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~%\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    DCq = Pattern.compile("\\d{1,5}\\s(\\w+[\\s,.]+){2,8}\\d{5}(-\\d{4})?([\\s,]*USA)?", 2);
    DCr = Pattern.compile("([A-Za-z0-9]{3,})");
    DCs = Pattern.compile("^(62[0-9]{14,17})$");
    DCt = Pattern.compile("^(1[0-9]{10})$");
    AppMethodBeat.o(152274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.j.a
 * JD-Core Version:    0.7.0.1
 */