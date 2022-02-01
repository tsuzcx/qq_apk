package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class o$a
{
  public static final Pattern YoA;
  public static final Pattern YoB;
  public static final Pattern YoC;
  public static final Pattern Yof;
  public static final Pattern Yog;
  public static final Pattern Yoh;
  public static final Pattern Yoi;
  public static final Pattern Yoj;
  public static final Pattern Yok;
  public static final Pattern Yol;
  public static final Pattern Yom;
  public static final Pattern Yon;
  public static final Pattern Yoo;
  public static final Pattern Yop;
  public static final Pattern Yoq;
  public static final Pattern Yor;
  public static Pattern Yos;
  public static final Pattern Yot;
  public static final Pattern You;
  public static final Pattern Yov;
  public static final Pattern Yow;
  public static final Pattern Yox;
  public static final Pattern Yoy;
  public static final Pattern Yoz;
  
  static
  {
    AppMethodBeat.i(152274);
    Yof = Pattern.compile("<a[^>]*href\\s*=\\s*[\"|']\\s*([^>]{0,2048})\\s*[\"|'][^>]*>((\\s|\\S){0,1024}?)</a>");
    Yog = Pattern.compile("<a[^>]*href\\s*=\\s*[\"|']\\s*([^>]{0,2048})\\s*[\"|'][^>]*>((\\s|\\S){0,1024}?)</a>");
    Yoh = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,500}?)\\s*[\"|']\\s*>(.+?)</a>");
    Yoi = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,300}?)\\s*[\"|']\\s*>(.+?)</a>");
    Yoj = Pattern.compile("<a.{1,500}?href\\s*=\\s*[\"|']\\s*(.{1,500}?)\\s*[\"|']\\s*>(.+?)</a>");
    Yok = Pattern.compile("<a.{1,100}?href\\s*=\\s*[\"|']\\s*(.{1,300}?)\\s*[\"|']\\s*>(.+?)</a>");
    Yol = Pattern.compile("<_wc_custom_link_.+?color\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*href\\s*=\\s*[\"|']\\s*(.*?)\\s*[\"|']\\s*.*?>(.*?)</_wc_custom_link_>");
    Yom = Pattern.compile("<_wc_custom_link_.+?\\s*href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.*?)</_wc_custom_link_>");
    Yon = Pattern.compile("<img.+?src=\"(.+?).png\"/>\\s*");
    Yoo = Pattern.compile("weixin://\\S+");
    Yop = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([-_a-zA-Z0-9]([-_a-zA-Z0-9\\-]{0,61}[-_a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,6}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[-_a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?", 2);
    Yoq = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
    Yor = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9._-]+\\.[A-Z]+", 2);
    Yos = Pattern.compile("#冒泡#");
    Yot = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})([,;]+\\d{0,20}#?){0,5}");
    You = Pattern.compile("weixin://wxpay/\\S+");
    Yov = Pattern.compile("weixin://dl/\\w+");
    Yow = Pattern.compile("weixin://dl/business(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~%\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    Yox = Pattern.compile("\\d{1,5}\\s(\\w+[\\s,.]+){2,8}\\d{5}(-\\d{4})?([\\s,]*USA)?", 2);
    Yoy = Pattern.compile("([A-Za-z0-9]{3,})");
    Yoz = Pattern.compile("^(62[0-9]{14,17})$");
    YoA = Pattern.compile("^(1[0-9]{10})$");
    YoB = Pattern.compile("([#＃][^#＃\\s,.，。@]{1,1000})");
    YoC = Pattern.compile("mp://\\w+");
    AppMethodBeat.o(152274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.o.a
 * JD-Core Version:    0.7.0.1
 */