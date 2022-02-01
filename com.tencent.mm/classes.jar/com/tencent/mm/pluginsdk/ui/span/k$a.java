package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class k$a
{
  public static final Pattern KqH;
  public static final Pattern KqI;
  public static final Pattern KqJ;
  public static final Pattern KqK;
  public static final Pattern KqL;
  public static final Pattern KqM;
  public static final Pattern KqN;
  public static final Pattern KqO;
  public static final Pattern KqP;
  public static final Pattern KqQ;
  public static final Pattern KqR;
  public static Pattern KqS;
  public static final Pattern KqT;
  public static final Pattern KqU;
  public static final Pattern KqV;
  public static final Pattern KqW;
  public static final Pattern KqX;
  public static final Pattern KqY;
  public static final Pattern KqZ;
  public static final Pattern Kra;
  public static final Pattern Krb;
  public static final Pattern Krc;
  
  static
  {
    AppMethodBeat.i(152274);
    KqH = Pattern.compile("<a.{1,500}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    KqI = Pattern.compile("<a.{1,100}?href\\s*=\\s*[\"|']\\s*(\\S+?)\\s*[\"|']\\s*>(.+?)</a>");
    KqJ = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,500}?)\\s*[\"|']\\s*>(.+?)</a>");
    KqK = Pattern.compile("<a.{1,1000}?href\\s*=\\s*[\"|']\\s*(.{1,300}?)\\s*[\"|']\\s*>(.+?)</a>");
    KqL = Pattern.compile("<_wc_custom_link_.+?color\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*href\\s*=\\s*[\"|']\\s*(.*?)\\s*[\"|']\\s*.*?>(.*?)</_wc_custom_link_>");
    KqM = Pattern.compile("<_wc_custom_link_.+?\\s*href\\s*=\\s*[\"|']\\s*(.+?)\\s*[\"|']\\s*>(.*?)</_wc_custom_link_>");
    KqN = Pattern.compile("<img.+?src=\"(.+?).png\"/>\\s*");
    KqO = Pattern.compile("weixin://\\S+");
    KqP = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([-_a-zA-Z0-9]([-_a-zA-Z0-9\\-]{0,61}[-_a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,6}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[-_a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?", 2);
    KqQ = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
    KqR = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9._-]+\\.[A-Z]+", 2);
    KqS = Pattern.compile("#冒泡#");
    KqT = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})([,;]+\\d{0,20}#?){0,5}");
    KqU = Pattern.compile("weixin://wxpay/\\S+");
    KqV = Pattern.compile("weixin://dl/\\w+");
    KqW = Pattern.compile("weixin://dl/business(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~%\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    KqX = Pattern.compile("\\d{1,5}\\s(\\w+[\\s,.]+){2,8}\\d{5}(-\\d{4})?([\\s,]*USA)?", 2);
    KqY = Pattern.compile("([A-Za-z0-9]{3,})");
    KqZ = Pattern.compile("^(62[0-9]{14,17})$");
    Kra = Pattern.compile("^(1[0-9]{10})$");
    Krb = Pattern.compile("([#＃][^#＃\\s,.，。@]{1,1000})");
    Krc = Pattern.compile("mp://\\w+");
    AppMethodBeat.o(152274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.k.a
 * JD-Core Version:    0.7.0.1
 */