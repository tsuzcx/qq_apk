package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

final class c
{
  private static final String[][] CPg;
  private static final String[][] CPh;
  static final String[][] CPi;
  static final String[][] CPj;
  public static final c CPk;
  public static final c CPl;
  public static final c CPm;
  private final c.a CPn;
  
  static
  {
    AppMethodBeat.i(116935);
    CPg = new String[][] { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
    CPh = new String[][] { { "apos", "39" } };
    Object localObject = { "nbsp", "160" };
    String[] arrayOfString1 = { "curren", "164" };
    String[] arrayOfString2 = { "sect", "167" };
    String[] arrayOfString3 = { "uml", "168" };
    String[] arrayOfString4 = { "copy", "169" };
    String[] arrayOfString5 = { "ordf", "170" };
    String[] arrayOfString6 = { "deg", "176" };
    String[] arrayOfString7 = { "sup3", "179" };
    String[] arrayOfString8 = { "para", "182" };
    String[] arrayOfString9 = { "iquest", "191" };
    String[] arrayOfString10 = { "Agrave", "192" };
    String[] arrayOfString11 = { "Aring", "197" };
    String[] arrayOfString12 = { "Eacute", "201" };
    String[] arrayOfString13 = { "Ecirc", "202" };
    String[] arrayOfString14 = { "Euml", "203" };
    String[] arrayOfString15 = { "Icirc", "206" };
    String[] arrayOfString16 = { "Ntilde", "209" };
    String[] arrayOfString17 = { "Ograve", "210" };
    String[] arrayOfString18 = { "Oacute", "211" };
    String[] arrayOfString19 = { "Ocirc", "212" };
    String[] arrayOfString20 = { "Otilde", "213" };
    String[] arrayOfString21 = { "Uacute", "218" };
    String[] arrayOfString22 = { "Ucirc", "219" };
    String[] arrayOfString23 = { "ccedil", "231" };
    String[] arrayOfString24 = { "iuml", "239" };
    String[] arrayOfString25 = { "eth", "240" };
    String[] arrayOfString26 = { "ntilde", "241" };
    String[] arrayOfString27 = { "ograve", "242" };
    String[] arrayOfString28 = { "oacute", "243" };
    String[] arrayOfString29 = { "divide", "247" };
    String[] arrayOfString30 = { "oslash", "248" };
    String[] arrayOfString31 = { "uuml", "252" };
    String[] arrayOfString32 = { "yuml", "255" };
    CPi = new String[][] { localObject, { "iexcl", "161" }, { "cent", "162" }, { "pound", "163" }, arrayOfString1, { "yen", "165" }, { "brvbar", "166" }, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, { "laquo", "171" }, { "not", "172" }, { "shy", "173" }, { "reg", "174" }, { "macr", "175" }, arrayOfString6, { "plusmn", "177" }, { "sup2", "178" }, arrayOfString7, { "acute", "180" }, { "micro", "181" }, arrayOfString8, { "middot", "183" }, { "cedil", "184" }, { "sup1", "185" }, { "ordm", "186" }, { "raquo", "187" }, { "frac14", "188" }, { "frac12", "189" }, { "frac34", "190" }, arrayOfString9, arrayOfString10, { "Aacute", "193" }, { "Acirc", "194" }, { "Atilde", "195" }, { "Auml", "196" }, arrayOfString11, { "AElig", "198" }, { "Ccedil", "199" }, { "Egrave", "200" }, arrayOfString12, arrayOfString13, arrayOfString14, { "Igrave", "204" }, { "Iacute", "205" }, arrayOfString15, { "Iuml", "207" }, { "ETH", "208" }, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, { "Ouml", "214" }, { "times", "215" }, { "Oslash", "216" }, { "Ugrave", "217" }, arrayOfString21, arrayOfString22, { "Uuml", "220" }, { "Yacute", "221" }, { "THORN", "222" }, { "szlig", "223" }, { "agrave", "224" }, { "aacute", "225" }, { "acirc", "226" }, { "atilde", "227" }, { "auml", "228" }, { "aring", "229" }, { "aelig", "230" }, arrayOfString23, { "egrave", "232" }, { "eacute", "233" }, { "ecirc", "234" }, { "euml", "235" }, { "igrave", "236" }, { "iacute", "237" }, { "icirc", "238" }, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, { "ocirc", "244" }, { "otilde", "245" }, { "ouml", "246" }, arrayOfString29, arrayOfString30, { "ugrave", "249" }, { "uacute", "250" }, { "ucirc", "251" }, arrayOfString31, { "yacute", "253" }, { "thorn", "254" }, arrayOfString32 };
    localObject = new String[] { "Beta", "914" };
    arrayOfString1 = new String[] { "Delta", "916" };
    arrayOfString2 = new String[] { "Iota", "921" };
    arrayOfString3 = new String[] { "Xi", "926" };
    arrayOfString4 = new String[] { "Pi", "928" };
    arrayOfString5 = new String[] { "Chi", "935" };
    arrayOfString6 = new String[] { "alpha", "945" };
    arrayOfString7 = new String[] { "sigma", "963" };
    arrayOfString8 = new String[] { "tau", "964" };
    arrayOfString9 = new String[] { "phi", "966" };
    arrayOfString10 = new String[] { "psi", "968" };
    arrayOfString11 = new String[] { "thetasym", "977" };
    arrayOfString12 = new String[] { "piv", "982" };
    arrayOfString13 = new String[] { "image", "8465" };
    arrayOfString14 = new String[] { "real", "8476" };
    arrayOfString15 = new String[] { "larr", "8592" };
    arrayOfString16 = new String[] { "rarr", "8594" };
    arrayOfString17 = new String[] { "harr", "8596" };
    arrayOfString18 = new String[] { "lArr", "8656" };
    arrayOfString19 = new String[] { "ni", "8715" };
    arrayOfString20 = new String[] { "prod", "8719" };
    arrayOfString21 = new String[] { "prop", "8733" };
    arrayOfString22 = new String[] { "sub", "8834" };
    arrayOfString23 = new String[] { "perp", "8869" };
    arrayOfString24 = new String[] { "rceil", "8969" };
    arrayOfString25 = new String[] { "hearts", "9829" };
    arrayOfString26 = new String[] { "diams", "9830" };
    arrayOfString27 = new String[] { "ndash", "8211" };
    arrayOfString28 = new String[] { "lsquo", "8216" };
    arrayOfString29 = new String[] { "dagger", "8224" };
    arrayOfString30 = new String[] { "rsaquo", "8250" };
    arrayOfString31 = new String[] { "euro", "8364" };
    CPj = new String[][] { { "fnof", "402" }, { "Alpha", "913" }, localObject, { "Gamma", "915" }, arrayOfString1, { "Epsilon", "917" }, { "Zeta", "918" }, { "Eta", "919" }, { "Theta", "920" }, arrayOfString2, { "Kappa", "922" }, { "Lambda", "923" }, { "Mu", "924" }, { "Nu", "925" }, arrayOfString3, { "Omicron", "927" }, arrayOfString4, { "Rho", "929" }, { "Sigma", "931" }, { "Tau", "932" }, { "Upsilon", "933" }, { "Phi", "934" }, arrayOfString5, { "Psi", "936" }, { "Omega", "937" }, arrayOfString6, { "beta", "946" }, { "gamma", "947" }, { "delta", "948" }, { "epsilon", "949" }, { "zeta", "950" }, { "eta", "951" }, { "theta", "952" }, { "iota", "953" }, { "kappa", "954" }, { "lambda", "955" }, { "mu", "956" }, { "nu", "957" }, { "xi", "958" }, { "omicron", "959" }, { "pi", "960" }, { "rho", "961" }, { "sigmaf", "962" }, arrayOfString7, arrayOfString8, { "upsilon", "965" }, arrayOfString9, { "chi", "967" }, arrayOfString10, { "omega", "969" }, arrayOfString11, { "upsih", "978" }, arrayOfString12, { "bull", "8226" }, { "hellip", "8230" }, { "prime", "8242" }, { "Prime", "8243" }, { "oline", "8254" }, { "frasl", "8260" }, { "weierp", "8472" }, arrayOfString13, arrayOfString14, { "trade", "8482" }, { "alefsym", "8501" }, arrayOfString15, { "uarr", "8593" }, arrayOfString16, { "darr", "8595" }, arrayOfString17, { "crarr", "8629" }, arrayOfString18, { "uArr", "8657" }, { "rArr", "8658" }, { "dArr", "8659" }, { "hArr", "8660" }, { "forall", "8704" }, { "part", "8706" }, { "exist", "8707" }, { "empty", "8709" }, { "nabla", "8711" }, { "isin", "8712" }, { "notin", "8713" }, arrayOfString19, arrayOfString20, { "sum", "8721" }, { "minus", "8722" }, { "lowast", "8727" }, { "radic", "8730" }, arrayOfString21, { "infin", "8734" }, { "ang", "8736" }, { "and", "8743" }, { "or", "8744" }, { "cap", "8745" }, { "cup", "8746" }, { "int", "8747" }, { "there4", "8756" }, { "sim", "8764" }, { "cong", "8773" }, { "asymp", "8776" }, { "ne", "8800" }, { "equiv", "8801" }, { "le", "8804" }, { "ge", "8805" }, arrayOfString22, { "sup", "8835" }, { "sube", "8838" }, { "supe", "8839" }, { "oplus", "8853" }, { "otimes", "8855" }, arrayOfString23, { "sdot", "8901" }, { "lceil", "8968" }, arrayOfString24, { "lfloor", "8970" }, { "rfloor", "8971" }, { "lang", "9001" }, { "rang", "9002" }, { "loz", "9674" }, { "spades", "9824" }, { "clubs", "9827" }, arrayOfString25, arrayOfString26, { "OElig", "338" }, { "oelig", "339" }, { "Scaron", "352" }, { "scaron", "353" }, { "Yuml", "376" }, { "circ", "710" }, { "tilde", "732" }, { "ensp", "8194" }, { "emsp", "8195" }, { "thinsp", "8201" }, { "zwnj", "8204" }, { "zwj", "8205" }, { "lrm", "8206" }, { "rlm", "8207" }, arrayOfString27, { "mdash", "8212" }, arrayOfString28, { "rsquo", "8217" }, { "sbquo", "8218" }, { "ldquo", "8220" }, { "rdquo", "8221" }, { "bdquo", "8222" }, arrayOfString29, { "Dagger", "8225" }, { "permil", "8240" }, { "lsaquo", "8249" }, arrayOfString30, arrayOfString31 };
    localObject = new c();
    ((c)localObject).a(CPg);
    ((c)localObject).a(CPh);
    CPk = (c)localObject;
    localObject = new c();
    ((c)localObject).a(CPg);
    ((c)localObject).a(CPi);
    CPl = (c)localObject;
    localObject = new c();
    ((c)localObject).a(CPg);
    ((c)localObject).a(CPi);
    ((c)localObject).a(CPj);
    CPm = (c)localObject;
    AppMethodBeat.o(116935);
  }
  
  public c()
  {
    AppMethodBeat.i(116931);
    this.CPn = new c.b();
    AppMethodBeat.o(116931);
  }
  
  private void a(Writer paramWriter, String paramString, int paramInt)
  {
    AppMethodBeat.i(116934);
    paramWriter.write(paramString, 0, paramInt);
    int k = paramString.length();
    int i;
    int j;
    label106:
    String str;
    if (paramInt < k)
    {
      i = paramString.charAt(paramInt);
      if (i == 38)
      {
        int m = paramInt + 1;
        j = paramString.indexOf(';', m);
        if (j == -1) {
          paramWriter.write(i);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          int n = paramString.indexOf('&', paramInt + 1);
          if ((n == -1) || (n >= j)) {
            break label106;
          }
          paramWriter.write(i);
        }
        str = paramString.substring(m, j);
        paramInt = str.length();
        if (paramInt <= 0) {
          break label293;
        }
        if (str.charAt(0) == '#')
        {
          if (paramInt <= 1) {
            break label293;
          }
          switch (str.charAt(1))
          {
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(str.substring(1), 10);
        paramInt = i;
        if (i > 65535) {
          paramInt = -1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramInt = -1;
        continue;
      }
      if (paramInt == -1)
      {
        paramWriter.write(38);
        paramWriter.write(str);
        paramWriter.write(59);
        paramInt = j;
        break;
        i = Integer.parseInt(str.substring(2), 16);
        continue;
        paramInt = this.CPn.azI(str);
        continue;
      }
      paramWriter.write(paramInt);
      continue;
      paramWriter.write(i);
      break;
      AppMethodBeat.o(116934);
      return;
      label293:
      paramInt = -1;
    }
  }
  
  private void a(String[][] paramArrayOfString)
  {
    AppMethodBeat.i(116932);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i][0];
      int j = Integer.parseInt(paramArrayOfString[i][1]);
      this.CPn.g(str, j);
      i += 1;
    }
    AppMethodBeat.o(116932);
  }
  
  public final String unescape(String paramString)
  {
    AppMethodBeat.i(116933);
    int i = paramString.indexOf('&');
    if (i < 0)
    {
      AppMethodBeat.o(116933);
      return paramString;
    }
    StringWriter localStringWriter = new StringWriter((int)(paramString.length() + paramString.length() * 0.1D));
    try
    {
      a(localStringWriter, paramString, i);
      paramString = localStringWriter.toString();
      AppMethodBeat.o(116933);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(116933);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.apache.commons.b.c
 * JD-Core Version:    0.7.0.1
 */