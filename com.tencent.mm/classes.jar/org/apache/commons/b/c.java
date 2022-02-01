package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

final class c
{
  static final String[][] abIA;
  public static final c abIB;
  public static final c abIC;
  public static final c abID;
  private static final String[][] abIx;
  private static final String[][] abIy;
  static final String[][] abIz;
  private final c.a abIE;
  
  static
  {
    AppMethodBeat.i(40711);
    Object localObject = { "quot", "34" };
    String[] arrayOfString1 = { "gt", "62" };
    abIx = new String[][] { localObject, { "amp", "38" }, { "lt", "60" }, arrayOfString1 };
    abIy = new String[][] { { "apos", "39" } };
    localObject = new String[] { "nbsp", "160" };
    arrayOfString1 = new String[] { "iexcl", "161" };
    String[] arrayOfString2 = { "curren", "164" };
    String[] arrayOfString3 = { "yen", "165" };
    String[] arrayOfString4 = { "brvbar", "166" };
    String[] arrayOfString5 = { "copy", "169" };
    String[] arrayOfString6 = { "ordf", "170" };
    String[] arrayOfString7 = { "laquo", "171" };
    String[] arrayOfString8 = { "shy", "173" };
    String[] arrayOfString9 = { "macr", "175" };
    String[] arrayOfString10 = { "deg", "176" };
    String[] arrayOfString11 = { "sup3", "179" };
    String[] arrayOfString12 = { "acute", "180" };
    String[] arrayOfString13 = { "para", "182" };
    String[] arrayOfString14 = { "cedil", "184" };
    String[] arrayOfString15 = { "sup1", "185" };
    String[] arrayOfString16 = { "frac34", "190" };
    String[] arrayOfString17 = { "Agrave", "192" };
    String[] arrayOfString18 = { "Aacute", "193" };
    String[] arrayOfString19 = { "Atilde", "195" };
    String[] arrayOfString20 = { "Euml", "203" };
    String[] arrayOfString21 = { "Icirc", "206" };
    String[] arrayOfString22 = { "ETH", "208" };
    String[] arrayOfString23 = { "Oacute", "211" };
    String[] arrayOfString24 = { "Ouml", "214" };
    String[] arrayOfString25 = { "Oslash", "216" };
    String[] arrayOfString26 = { "Ugrave", "217" };
    String[] arrayOfString27 = { "Ucirc", "219" };
    String[] arrayOfString28 = { "Uuml", "220" };
    String[] arrayOfString29 = { "szlig", "223" };
    String[] arrayOfString30 = { "agrave", "224" };
    String[] arrayOfString31 = { "auml", "228" };
    String[] arrayOfString32 = { "eacute", "233" };
    String[] arrayOfString33 = { "ecirc", "234" };
    String[] arrayOfString34 = { "euml", "235" };
    String[] arrayOfString35 = { "igrave", "236" };
    String[] arrayOfString36 = { "iuml", "239" };
    String[] arrayOfString37 = { "ntilde", "241" };
    String[] arrayOfString38 = { "ograve", "242" };
    String[] arrayOfString39 = { "oacute", "243" };
    String[] arrayOfString40 = { "otilde", "245" };
    String[] arrayOfString41 = { "ugrave", "249" };
    abIz = new String[][] { localObject, arrayOfString1, { "cent", "162" }, { "pound", "163" }, arrayOfString2, arrayOfString3, arrayOfString4, { "sect", "167" }, { "uml", "168" }, arrayOfString5, arrayOfString6, arrayOfString7, { "not", "172" }, arrayOfString8, { "reg", "174" }, arrayOfString9, arrayOfString10, { "plusmn", "177" }, { "sup2", "178" }, arrayOfString11, arrayOfString12, { "micro", "181" }, arrayOfString13, { "middot", "183" }, arrayOfString14, arrayOfString15, { "ordm", "186" }, { "raquo", "187" }, { "frac14", "188" }, { "frac12", "189" }, arrayOfString16, { "iquest", "191" }, arrayOfString17, arrayOfString18, { "Acirc", "194" }, arrayOfString19, { "Auml", "196" }, { "Aring", "197" }, { "AElig", "198" }, { "Ccedil", "199" }, { "Egrave", "200" }, { "Eacute", "201" }, { "Ecirc", "202" }, arrayOfString20, { "Igrave", "204" }, { "Iacute", "205" }, arrayOfString21, { "Iuml", "207" }, arrayOfString22, { "Ntilde", "209" }, { "Ograve", "210" }, arrayOfString23, { "Ocirc", "212" }, { "Otilde", "213" }, arrayOfString24, { "times", "215" }, arrayOfString25, arrayOfString26, { "Uacute", "218" }, arrayOfString27, arrayOfString28, { "Yacute", "221" }, { "THORN", "222" }, arrayOfString29, arrayOfString30, { "aacute", "225" }, { "acirc", "226" }, { "atilde", "227" }, arrayOfString31, { "aring", "229" }, { "aelig", "230" }, { "ccedil", "231" }, { "egrave", "232" }, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, { "iacute", "237" }, { "icirc", "238" }, arrayOfString36, { "eth", "240" }, arrayOfString37, arrayOfString38, arrayOfString39, { "ocirc", "244" }, arrayOfString40, { "ouml", "246" }, { "divide", "247" }, { "oslash", "248" }, arrayOfString41, { "uacute", "250" }, { "ucirc", "251" }, { "uuml", "252" }, { "yacute", "253" }, { "thorn", "254" }, { "yuml", "255" } };
    localObject = new String[] { "Mu", "924" };
    arrayOfString1 = new String[] { "Nu", "925" };
    arrayOfString2 = new String[] { "Tau", "932" };
    arrayOfString3 = new String[] { "Phi", "934" };
    arrayOfString4 = new String[] { "delta", "948" };
    arrayOfString5 = new String[] { "zeta", "950" };
    arrayOfString6 = new String[] { "lambda", "955" };
    arrayOfString7 = new String[] { "rho", "961" };
    arrayOfString8 = new String[] { "sigma", "963" };
    arrayOfString9 = new String[] { "phi", "966" };
    arrayOfString10 = new String[] { "upsih", "978" };
    arrayOfString11 = new String[] { "prime", "8242" };
    arrayOfString12 = new String[] { "isin", "8712" };
    arrayOfString13 = new String[] { "sim", "8764" };
    arrayOfString14 = new String[] { "asymp", "8776" };
    arrayOfString15 = new String[] { "ne", "8800" };
    arrayOfString16 = new String[] { "sdot", "8901" };
    arrayOfString17 = new String[] { "lceil", "8968" };
    arrayOfString18 = new String[] { "rceil", "8969" };
    arrayOfString19 = new String[] { "rfloor", "8971" };
    arrayOfString20 = new String[] { "Scaron", "352" };
    arrayOfString21 = new String[] { "tilde", "732" };
    arrayOfString22 = new String[] { "zwnj", "8204" };
    arrayOfString23 = new String[] { "rlm", "8207" };
    arrayOfString24 = new String[] { "ndash", "8211" };
    arrayOfString25 = new String[] { "ldquo", "8220" };
    arrayOfString26 = new String[] { "bdquo", "8222" };
    arrayOfString27 = new String[] { "Dagger", "8225" };
    abIA = new String[][] { { "fnof", "402" }, { "Alpha", "913" }, { "Beta", "914" }, { "Gamma", "915" }, { "Delta", "916" }, { "Epsilon", "917" }, { "Zeta", "918" }, { "Eta", "919" }, { "Theta", "920" }, { "Iota", "921" }, { "Kappa", "922" }, { "Lambda", "923" }, localObject, arrayOfString1, { "Xi", "926" }, { "Omicron", "927" }, { "Pi", "928" }, { "Rho", "929" }, { "Sigma", "931" }, arrayOfString2, { "Upsilon", "933" }, arrayOfString3, { "Chi", "935" }, { "Psi", "936" }, { "Omega", "937" }, { "alpha", "945" }, { "beta", "946" }, { "gamma", "947" }, arrayOfString4, { "epsilon", "949" }, arrayOfString5, { "eta", "951" }, { "theta", "952" }, { "iota", "953" }, { "kappa", "954" }, arrayOfString6, { "mu", "956" }, { "nu", "957" }, { "xi", "958" }, { "omicron", "959" }, { "pi", "960" }, arrayOfString7, { "sigmaf", "962" }, arrayOfString8, { "tau", "964" }, { "upsilon", "965" }, arrayOfString9, { "chi", "967" }, { "psi", "968" }, { "omega", "969" }, { "thetasym", "977" }, arrayOfString10, { "piv", "982" }, { "bull", "8226" }, { "hellip", "8230" }, arrayOfString11, { "Prime", "8243" }, { "oline", "8254" }, { "frasl", "8260" }, { "weierp", "8472" }, { "image", "8465" }, { "real", "8476" }, { "trade", "8482" }, { "alefsym", "8501" }, { "larr", "8592" }, { "uarr", "8593" }, { "rarr", "8594" }, { "darr", "8595" }, { "harr", "8596" }, { "crarr", "8629" }, { "lArr", "8656" }, { "uArr", "8657" }, { "rArr", "8658" }, { "dArr", "8659" }, { "hArr", "8660" }, { "forall", "8704" }, { "part", "8706" }, { "exist", "8707" }, { "empty", "8709" }, { "nabla", "8711" }, arrayOfString12, { "notin", "8713" }, { "ni", "8715" }, { "prod", "8719" }, { "sum", "8721" }, { "minus", "8722" }, { "lowast", "8727" }, { "radic", "8730" }, { "prop", "8733" }, { "infin", "8734" }, { "ang", "8736" }, { "and", "8743" }, { "or", "8744" }, { "cap", "8745" }, { "cup", "8746" }, { "int", "8747" }, { "there4", "8756" }, arrayOfString13, { "cong", "8773" }, arrayOfString14, arrayOfString15, { "equiv", "8801" }, { "le", "8804" }, { "ge", "8805" }, { "sub", "8834" }, { "sup", "8835" }, { "sube", "8838" }, { "supe", "8839" }, { "oplus", "8853" }, { "otimes", "8855" }, { "perp", "8869" }, arrayOfString16, arrayOfString17, arrayOfString18, { "lfloor", "8970" }, arrayOfString19, { "lang", "9001" }, { "rang", "9002" }, { "loz", "9674" }, { "spades", "9824" }, { "clubs", "9827" }, { "hearts", "9829" }, { "diams", "9830" }, { "OElig", "338" }, { "oelig", "339" }, arrayOfString20, { "scaron", "353" }, { "Yuml", "376" }, { "circ", "710" }, arrayOfString21, { "ensp", "8194" }, { "emsp", "8195" }, { "thinsp", "8201" }, arrayOfString22, { "zwj", "8205" }, { "lrm", "8206" }, arrayOfString23, arrayOfString24, { "mdash", "8212" }, { "lsquo", "8216" }, { "rsquo", "8217" }, { "sbquo", "8218" }, arrayOfString25, { "rdquo", "8221" }, arrayOfString26, { "dagger", "8224" }, arrayOfString27, { "permil", "8240" }, { "lsaquo", "8249" }, { "rsaquo", "8250" }, { "euro", "8364" } };
    localObject = new c();
    ((c)localObject).a(abIx);
    ((c)localObject).a(abIy);
    abIB = (c)localObject;
    localObject = new c();
    ((c)localObject).a(abIx);
    ((c)localObject).a(abIz);
    abIC = (c)localObject;
    localObject = new c();
    ((c)localObject).a(abIx);
    ((c)localObject).a(abIz);
    ((c)localObject).a(abIA);
    abID = (c)localObject;
    AppMethodBeat.o(40711);
  }
  
  public c()
  {
    AppMethodBeat.i(40707);
    this.abIE = new c.b();
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
        paramInt = this.abIE.bIh(str);
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
      this.abIE.n(str, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.apache.commons.b.c
 * JD-Core Version:    0.7.0.1
 */