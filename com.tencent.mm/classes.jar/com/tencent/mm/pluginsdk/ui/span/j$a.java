package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class j$a
{
  public static final Pattern FhA;
  public static final Pattern Fhh;
  public static final Pattern Fhi;
  public static final Pattern Fhj;
  public static final Pattern Fhk;
  public static final Pattern Fhl;
  public static final Pattern Fhm;
  public static final Pattern Fhn;
  public static final Pattern Fho;
  public static final Pattern Fhp;
  public static final Pattern Fhq;
  public static final Pattern Fhr;
  public static Pattern Fhs;
  public static final Pattern Fht;
  public static final Pattern Fhu;
  public static final Pattern Fhv;
  public static final Pattern Fhw;
  public static final Pattern Fhx;
  public static final Pattern Fhy;
  public static final Pattern Fhz;
  
  static
  {
    AppMethodBeat.i(152274);
    Fhh = Pattern.compile("<a.{1,500}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    Fhi = Pattern.compile("<a.{1,100}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    Fhj = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,500}?)\\s*[\"|']\\s*>(.+?)</a>");
    Fhk = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,300}?)\\s*[\"|']\\s*>(.+?)</a>");
    Fhl = Pattern.compile("<_wc_custom_link_.+?color\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*href\\s*=\\s*[\"|']\\s*(.*?)\\s*[\"|']\\s*.*?>(.+?)</_wc_custom_link_>");
    Fhm = Pattern.compile("<_wc_custom_link_.+?\\s*href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.+?)</_wc_custom_link_>");
    Fhn = Pattern.compile("<img.+?src=\"(.+?).png\"/>\\s*");
    Fho = Pattern.compile("weixin://\\S+");
    Fhp = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([-_a-zA-Z0-9]([-_a-zA-Z0-9\\-]{0,61}[-_a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,6}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[-_a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?", 2);
    Fhq = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
    Fhr = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9._-]+\\.[A-Z]+", 2);
    Fhs = Pattern.compile("#冒泡#");
    Fht = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})([,;]+\\d{0,20}#?){0,5}");
    Fhu = Pattern.compile("weixin://wxpay/\\S+");
    Fhv = Pattern.compile("weixin://dl/\\w+");
    Fhw = Pattern.compile("weixin://dl/business(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~%\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    Fhx = Pattern.compile("\\d{1,5}\\s(\\w+[\\s,.]+){2,8}\\d{5}(-\\d{4})?([\\s,]*USA)?", 2);
    Fhy = Pattern.compile("([A-Za-z0-9]{3,})");
    Fhz = Pattern.compile("^(62[0-9]{14,17})$");
    FhA = Pattern.compile("^(1[0-9]{10})$");
    AppMethodBeat.o(152274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.j.a
 * JD-Core Version:    0.7.0.1
 */