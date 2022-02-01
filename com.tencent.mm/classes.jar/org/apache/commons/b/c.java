package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

final class c
{
  private static final String[][] KkX;
  private static final String[][] KkY;
  static final String[][] KkZ;
  static final String[][] Kla;
  public static final c Klb;
  public static final c Klc;
  public static final c Kld;
  private final c.a Kle;
  
  static
  {
    AppMethodBeat.i(40711);
    Object localObject = { "quot", "34" };
    String[] arrayOfString1 = { "amp", "38" };
    String[] arrayOfString2 = { "gt", "62" };
    KkX = new String[][] { localObject, arrayOfString1, { "lt", "60" }, arrayOfString2 };
    KkY = new String[][] { { "apos", "39" } };
    localObject = new String[] { "curren", "164" };
    arrayOfString1 = new String[] { "yen", "165" };
    arrayOfString2 = new String[] { "laquo", "171" };
    String[] arrayOfString3 = { "not", "172" };
    String[] arrayOfString4 = { "shy", "173" };
    String[] arrayOfString5 = { "reg", "174" };
    String[] arrayOfString6 = { "acute", "180" };
    String[] arrayOfString7 = { "micro", "181" };
    String[] arrayOfString8 = { "cedil", "184" };
    String[] arrayOfString9 = { "sup1", "185" };
    String[] arrayOfString10 = { "frac12", "189" };
    String[] arrayOfString11 = { "AElig", "198" };
    String[] arrayOfString12 = { "Egrave", "200" };
    String[] arrayOfString13 = { "Eacute", "201" };
    String[] arrayOfString14 = { "Euml", "203" };
    String[] arrayOfString15 = { "Ocirc", "212" };
    String[] arrayOfString16 = { "Otilde", "213" };
    String[] arrayOfString17 = { "Ouml", "214" };
    String[] arrayOfString18 = { "times", "215" };
    String[] arrayOfString19 = { "Oslash", "216" };
    String[] arrayOfString20 = { "Ugrave", "217" };
    String[] arrayOfString21 = { "Uacute", "218" };
    String[] arrayOfString22 = { "agrave", "224" };
    String[] arrayOfString23 = { "aacute", "225" };
    String[] arrayOfString24 = { "aring", "229" };
    String[] arrayOfString25 = { "aelig", "230" };
    String[] arrayOfString26 = { "ccedil", "231" };
    String[] arrayOfString27 = { "igrave", "236" };
    String[] arrayOfString28 = { "icirc", "238" };
    String[] arrayOfString29 = { "eth", "240" };
    String[] arrayOfString30 = { "ograve", "242" };
    String[] arrayOfString31 = { "divide", "247" };
    String[] arrayOfString32 = { "oslash", "248" };
    String[] arrayOfString33 = { "yuml", "255" };
    KkZ = new String[][] { { "nbsp", "160" }, { "iexcl", "161" }, { "cent", "162" }, { "pound", "163" }, localObject, arrayOfString1, { "brvbar", "166" }, { "sect", "167" }, { "uml", "168" }, { "copy", "169" }, { "ordf", "170" }, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, { "macr", "175" }, { "deg", "176" }, { "plusmn", "177" }, { "sup2", "178" }, { "sup3", "179" }, arrayOfString6, arrayOfString7, { "para", "182" }, { "middot", "183" }, arrayOfString8, arrayOfString9, { "ordm", "186" }, { "raquo", "187" }, { "frac14", "188" }, arrayOfString10, { "frac34", "190" }, { "iquest", "191" }, { "Agrave", "192" }, { "Aacute", "193" }, { "Acirc", "194" }, { "Atilde", "195" }, { "Auml", "196" }, { "Aring", "197" }, arrayOfString11, { "Ccedil", "199" }, arrayOfString12, arrayOfString13, { "Ecirc", "202" }, arrayOfString14, { "Igrave", "204" }, { "Iacute", "205" }, { "Icirc", "206" }, { "Iuml", "207" }, { "ETH", "208" }, { "Ntilde", "209" }, { "Ograve", "210" }, { "Oacute", "211" }, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, { "Ucirc", "219" }, { "Uuml", "220" }, { "Yacute", "221" }, { "THORN", "222" }, { "szlig", "223" }, arrayOfString22, arrayOfString23, { "acirc", "226" }, { "atilde", "227" }, { "auml", "228" }, arrayOfString24, arrayOfString25, arrayOfString26, { "egrave", "232" }, { "eacute", "233" }, { "ecirc", "234" }, { "euml", "235" }, arrayOfString27, { "iacute", "237" }, arrayOfString28, { "iuml", "239" }, arrayOfString29, { "ntilde", "241" }, arrayOfString30, { "oacute", "243" }, { "ocirc", "244" }, { "otilde", "245" }, { "ouml", "246" }, arrayOfString31, arrayOfString32, { "ugrave", "249" }, { "uacute", "250" }, { "ucirc", "251" }, { "uuml", "252" }, { "yacute", "253" }, { "thorn", "254" }, arrayOfString33 };
    localObject = new String[] { "fnof", "402" };
    arrayOfString1 = new String[] { "Alpha", "913" };
    arrayOfString2 = new String[] { "Beta", "914" };
    arrayOfString3 = new String[] { "Gamma", "915" };
    arrayOfString4 = new String[] { "Delta", "916" };
    arrayOfString5 = new String[] { "Epsilon", "917" };
    arrayOfString6 = new String[] { "Zeta", "918" };
    arrayOfString7 = new String[] { "Eta", "919" };
    arrayOfString8 = new String[] { "Theta", "920" };
    arrayOfString9 = new String[] { "Iota", "921" };
    arrayOfString10 = new String[] { "Kappa", "922" };
    arrayOfString11 = new String[] { "Lambda", "923" };
    arrayOfString12 = new String[] { "Mu", "924" };
    arrayOfString13 = new String[] { "Nu", "925" };
    arrayOfString14 = new String[] { "Xi", "926" };
    arrayOfString15 = new String[] { "Omicron", "927" };
    arrayOfString16 = new String[] { "Pi", "928" };
    arrayOfString17 = new String[] { "Rho", "929" };
    arrayOfString18 = new String[] { "Sigma", "931" };
    arrayOfString19 = new String[] { "Tau", "932" };
    arrayOfString20 = new String[] { "Upsilon", "933" };
    arrayOfString21 = new String[] { "Phi", "934" };
    arrayOfString22 = new String[] { "Psi", "936" };
    arrayOfString23 = new String[] { "Omega", "937" };
    arrayOfString24 = new String[] { "alpha", "945" };
    arrayOfString25 = new String[] { "beta", "946" };
    arrayOfString26 = new String[] { "gamma", "947" };
    arrayOfString27 = new String[] { "delta", "948" };
    arrayOfString28 = new String[] { "epsilon", "949" };
    arrayOfString29 = new String[] { "zeta", "950" };
    arrayOfString30 = new String[] { "eta", "951" };
    arrayOfString31 = new String[] { "theta", "952" };
    arrayOfString32 = new String[] { "iota", "953" };
    arrayOfString33 = new String[] { "kappa", "954" };
    String[] arrayOfString34 = { "lambda", "955" };
    String[] arrayOfString35 = { "mu", "956" };
    String[] arrayOfString36 = { "nu", "957" };
    String[] arrayOfString37 = { "xi", "958" };
    String[] arrayOfString38 = { "omicron", "959" };
    String[] arrayOfString39 = { "pi", "960" };
    String[] arrayOfString40 = { "rho", "961" };
    String[] arrayOfString41 = { "sigmaf", "962" };
    String[] arrayOfString42 = { "sigma", "963" };
    String[] arrayOfString43 = { "tau", "964" };
    String[] arrayOfString44 = { "upsilon", "965" };
    String[] arrayOfString45 = { "phi", "966" };
    String[] arrayOfString46 = { "chi", "967" };
    String[] arrayOfString47 = { "psi", "968" };
    String[] arrayOfString48 = { "omega", "969" };
    String[] arrayOfString49 = { "thetasym", "977" };
    String[] arrayOfString50 = { "upsih", "978" };
    String[] arrayOfString51 = { "piv", "982" };
    String[] arrayOfString52 = { "bull", "8226" };
    String[] arrayOfString53 = { "hellip", "8230" };
    String[] arrayOfString54 = { "prime", "8242" };
    String[] arrayOfString55 = { "Prime", "8243" };
    String[] arrayOfString56 = { "oline", "8254" };
    String[] arrayOfString57 = { "frasl", "8260" };
    String[] arrayOfString58 = { "weierp", "8472" };
    String[] arrayOfString59 = { "image", "8465" };
    String[] arrayOfString60 = { "real", "8476" };
    String[] arrayOfString61 = { "trade", "8482" };
    String[] arrayOfString62 = { "alefsym", "8501" };
    String[] arrayOfString63 = { "larr", "8592" };
    String[] arrayOfString64 = { "uarr", "8593" };
    String[] arrayOfString65 = { "rarr", "8594" };
    String[] arrayOfString66 = { "darr", "8595" };
    String[] arrayOfString67 = { "harr", "8596" };
    String[] arrayOfString68 = { "crarr", "8629" };
    String[] arrayOfString69 = { "lArr", "8656" };
    String[] arrayOfString70 = { "uArr", "8657" };
    String[] arrayOfString71 = { "rArr", "8658" };
    String[] arrayOfString72 = { "dArr", "8659" };
    String[] arrayOfString73 = { "hArr", "8660" };
    String[] arrayOfString74 = { "forall", "8704" };
    String[] arrayOfString75 = { "part", "8706" };
    String[] arrayOfString76 = { "exist", "8707" };
    String[] arrayOfString77 = { "empty", "8709" };
    String[] arrayOfString78 = { "nabla", "8711" };
    String[] arrayOfString79 = { "isin", "8712" };
    String[] arrayOfString80 = { "notin", "8713" };
    String[] arrayOfString81 = { "ni", "8715" };
    String[] arrayOfString82 = { "prod", "8719" };
    String[] arrayOfString83 = { "sum", "8721" };
    String[] arrayOfString84 = { "minus", "8722" };
    String[] arrayOfString85 = { "lowast", "8727" };
    String[] arrayOfString86 = { "radic", "8730" };
    String[] arrayOfString87 = { "prop", "8733" };
    String[] arrayOfString88 = { "infin", "8734" };
    String[] arrayOfString89 = { "ang", "8736" };
    String[] arrayOfString90 = { "and", "8743" };
    String[] arrayOfString91 = { "or", "8744" };
    String[] arrayOfString92 = { "cap", "8745" };
    String[] arrayOfString93 = { "cup", "8746" };
    String[] arrayOfString94 = { "int", "8747" };
    String[] arrayOfString95 = { "there4", "8756" };
    String[] arrayOfString96 = { "sim", "8764" };
    String[] arrayOfString97 = { "cong", "8773" };
    String[] arrayOfString98 = { "asymp", "8776" };
    String[] arrayOfString99 = { "ne", "8800" };
    String[] arrayOfString100 = { "equiv", "8801" };
    String[] arrayOfString101 = { "le", "8804" };
    String[] arrayOfString102 = { "ge", "8805" };
    String[] arrayOfString103 = { "sub", "8834" };
    String[] arrayOfString104 = { "sup", "8835" };
    String[] arrayOfString105 = { "sube", "8838" };
    String[] arrayOfString106 = { "supe", "8839" };
    String[] arrayOfString107 = { "oplus", "8853" };
    String[] arrayOfString108 = { "otimes", "8855" };
    String[] arrayOfString109 = { "perp", "8869" };
    String[] arrayOfString110 = { "sdot", "8901" };
    String[] arrayOfString111 = { "lceil", "8968" };
    String[] arrayOfString112 = { "rceil", "8969" };
    String[] arrayOfString113 = { "lfloor", "8970" };
    String[] arrayOfString114 = { "rfloor", "8971" };
    String[] arrayOfString115 = { "lang", "9001" };
    String[] arrayOfString116 = { "rang", "9002" };
    String[] arrayOfString117 = { "loz", "9674" };
    String[] arrayOfString118 = { "spades", "9824" };
    String[] arrayOfString119 = { "clubs", "9827" };
    String[] arrayOfString120 = { "hearts", "9829" };
    String[] arrayOfString121 = { "diams", "9830" };
    String[] arrayOfString122 = { "OElig", "338" };
    String[] arrayOfString123 = { "oelig", "339" };
    String[] arrayOfString124 = { "Scaron", "352" };
    String[] arrayOfString125 = { "scaron", "353" };
    String[] arrayOfString126 = { "Yuml", "376" };
    String[] arrayOfString127 = { "circ", "710" };
    String[] arrayOfString128 = { "tilde", "732" };
    String[] arrayOfString129 = { "ensp", "8194" };
    String[] arrayOfString130 = { "emsp", "8195" };
    String[] arrayOfString131 = { "thinsp", "8201" };
    String[] arrayOfString132 = { "zwnj", "8204" };
    String[] arrayOfString133 = { "zwj", "8205" };
    String[] arrayOfString134 = { "lrm", "8206" };
    String[] arrayOfString135 = { "rlm", "8207" };
    String[] arrayOfString136 = { "mdash", "8212" };
    String[] arrayOfString137 = { "lsquo", "8216" };
    String[] arrayOfString138 = { "rsquo", "8217" };
    String[] arrayOfString139 = { "sbquo", "8218" };
    String[] arrayOfString140 = { "ldquo", "8220" };
    String[] arrayOfString141 = { "rdquo", "8221" };
    String[] arrayOfString142 = { "bdquo", "8222" };
    String[] arrayOfString143 = { "dagger", "8224" };
    String[] arrayOfString144 = { "Dagger", "8225" };
    String[] arrayOfString145 = { "permil", "8240" };
    String[] arrayOfString146 = { "lsaquo", "8249" };
    String[] arrayOfString147 = { "rsaquo", "8250" };
    String[] arrayOfString148 = { "euro", "8364" };
    Kla = new String[][] { localObject, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, { "Chi", "935" }, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, arrayOfString47, arrayOfString48, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, arrayOfString59, arrayOfString60, arrayOfString61, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72, arrayOfString73, arrayOfString74, arrayOfString75, arrayOfString76, arrayOfString77, arrayOfString78, arrayOfString79, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83, arrayOfString84, arrayOfString85, arrayOfString86, arrayOfString87, arrayOfString88, arrayOfString89, arrayOfString90, arrayOfString91, arrayOfString92, arrayOfString93, arrayOfString94, arrayOfString95, arrayOfString96, arrayOfString97, arrayOfString98, arrayOfString99, arrayOfString100, arrayOfString101, arrayOfString102, arrayOfString103, arrayOfString104, arrayOfString105, arrayOfString106, arrayOfString107, arrayOfString108, arrayOfString109, arrayOfString110, arrayOfString111, arrayOfString112, arrayOfString113, arrayOfString114, arrayOfString115, arrayOfString116, arrayOfString117, arrayOfString118, arrayOfString119, arrayOfString120, arrayOfString121, arrayOfString122, arrayOfString123, arrayOfString124, arrayOfString125, arrayOfString126, arrayOfString127, arrayOfString128, arrayOfString129, arrayOfString130, arrayOfString131, arrayOfString132, arrayOfString133, arrayOfString134, arrayOfString135, { "ndash", "8211" }, arrayOfString136, arrayOfString137, arrayOfString138, arrayOfString139, arrayOfString140, arrayOfString141, arrayOfString142, arrayOfString143, arrayOfString144, arrayOfString145, arrayOfString146, arrayOfString147, arrayOfString148 };
    localObject = new c();
    ((c)localObject).a(KkX);
    ((c)localObject).a(KkY);
    Klb = (c)localObject;
    localObject = new c();
    ((c)localObject).a(KkX);
    ((c)localObject).a(KkZ);
    Klc = (c)localObject;
    localObject = new c();
    ((c)localObject).a(KkX);
    ((c)localObject).a(KkZ);
    ((c)localObject).a(Kla);
    Kld = (c)localObject;
    AppMethodBeat.o(40711);
  }
  
  public c()
  {
    AppMethodBeat.i(40707);
    this.Kle = new c.b();
    AppMethodBeat.o(40707);
  }
  
  private void a(Writer paramWriter, String paramString, int paramInt)
  {
    AppMethodBeat.i(40710);
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
        paramInt = this.Kle.aRp(str);
        continue;
      }
      paramWriter.write(paramInt);
      continue;
      paramWriter.write(i);
      break;
      AppMethodBeat.o(40710);
      return;
      label293:
      paramInt = -1;
    }
  }
  
  private void a(String[][] paramArrayOfString)
  {
    AppMethodBeat.i(40708);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i][0];
      int j = Integer.parseInt(paramArrayOfString[i][1]);
      this.Kle.g(str, j);
      i += 1;
    }
    AppMethodBeat.o(40708);
  }
  
  public final String unescape(String paramString)
  {
    AppMethodBeat.i(40709);
    int i = paramString.indexOf('&');
    if (i < 0)
    {
      AppMethodBeat.o(40709);
      return paramString;
    }
    StringWriter localStringWriter = new StringWriter((int)(paramString.length() + paramString.length() * 0.1D));
    try
    {
      a(localStringWriter, paramString, i);
      paramString = localStringWriter.toString();
      AppMethodBeat.o(40709);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(40709);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.c
 * JD-Core Version:    0.7.0.1
 */