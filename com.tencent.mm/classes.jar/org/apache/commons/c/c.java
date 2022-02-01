package org.apache.commons.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

final class c
{
  private static final String[][] ajVs;
  private static final String[][] ajVt;
  static final String[][] ajVu;
  static final String[][] ajVv;
  public static final c ajVw;
  public static final c ajVx;
  public static final c ajVy;
  private final c.a ajVz;
  
  static
  {
    AppMethodBeat.i(40711);
    ajVs = new String[][] { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
    ajVt = new String[][] { { "apos", "39" } };
    Object localObject = { "nbsp", "160" };
    String[] arrayOfString1 = { "cent", "162" };
    String[] arrayOfString2 = { "curren", "164" };
    String[] arrayOfString3 = { "yen", "165" };
    String[] arrayOfString4 = { "sect", "167" };
    String[] arrayOfString5 = { "copy", "169" };
    String[] arrayOfString6 = { "ordf", "170" };
    String[] arrayOfString7 = { "laquo", "171" };
    String[] arrayOfString8 = { "shy", "173" };
    String[] arrayOfString9 = { "deg", "176" };
    String[] arrayOfString10 = { "plusmn", "177" };
    String[] arrayOfString11 = { "sup2", "178" };
    String[] arrayOfString12 = { "micro", "181" };
    String[] arrayOfString13 = { "para", "182" };
    String[] arrayOfString14 = { "middot", "183" };
    String[] arrayOfString15 = { "cedil", "184" };
    String[] arrayOfString16 = { "sup1", "185" };
    String[] arrayOfString17 = { "ordm", "186" };
    String[] arrayOfString18 = { "raquo", "187" };
    String[] arrayOfString19 = { "iquest", "191" };
    String[] arrayOfString20 = { "Agrave", "192" };
    String[] arrayOfString21 = { "Aacute", "193" };
    String[] arrayOfString22 = { "Acirc", "194" };
    String[] arrayOfString23 = { "Atilde", "195" };
    String[] arrayOfString24 = { "Auml", "196" };
    String[] arrayOfString25 = { "Aring", "197" };
    String[] arrayOfString26 = { "AElig", "198" };
    String[] arrayOfString27 = { "Egrave", "200" };
    String[] arrayOfString28 = { "Ecirc", "202" };
    String[] arrayOfString29 = { "Euml", "203" };
    String[] arrayOfString30 = { "Igrave", "204" };
    String[] arrayOfString31 = { "Iacute", "205" };
    String[] arrayOfString32 = { "Icirc", "206" };
    String[] arrayOfString33 = { "Iuml", "207" };
    String[] arrayOfString34 = { "Ntilde", "209" };
    String[] arrayOfString35 = { "Ograve", "210" };
    String[] arrayOfString36 = { "Oacute", "211" };
    String[] arrayOfString37 = { "Ocirc", "212" };
    String[] arrayOfString38 = { "Otilde", "213" };
    String[] arrayOfString39 = { "Ouml", "214" };
    String[] arrayOfString40 = { "times", "215" };
    String[] arrayOfString41 = { "Ugrave", "217" };
    String[] arrayOfString42 = { "Uacute", "218" };
    String[] arrayOfString43 = { "Ucirc", "219" };
    String[] arrayOfString44 = { "Uuml", "220" };
    String[] arrayOfString45 = { "Yacute", "221" };
    String[] arrayOfString46 = { "szlig", "223" };
    String[] arrayOfString47 = { "aacute", "225" };
    String[] arrayOfString48 = { "acirc", "226" };
    String[] arrayOfString49 = { "atilde", "227" };
    String[] arrayOfString50 = { "aring", "229" };
    String[] arrayOfString51 = { "aelig", "230" };
    String[] arrayOfString52 = { "ccedil", "231" };
    String[] arrayOfString53 = { "egrave", "232" };
    String[] arrayOfString54 = { "eacute", "233" };
    String[] arrayOfString55 = { "ecirc", "234" };
    String[] arrayOfString56 = { "igrave", "236" };
    String[] arrayOfString57 = { "icirc", "238" };
    String[] arrayOfString58 = { "iuml", "239" };
    String[] arrayOfString59 = { "eth", "240" };
    String[] arrayOfString60 = { "ntilde", "241" };
    String[] arrayOfString61 = { "ograve", "242" };
    String[] arrayOfString62 = { "oacute", "243" };
    String[] arrayOfString63 = { "otilde", "245" };
    String[] arrayOfString64 = { "ouml", "246" };
    String[] arrayOfString65 = { "divide", "247" };
    String[] arrayOfString66 = { "oslash", "248" };
    String[] arrayOfString67 = { "uacute", "250" };
    String[] arrayOfString68 = { "ucirc", "251" };
    String[] arrayOfString69 = { "uuml", "252" };
    String[] arrayOfString70 = { "yacute", "253" };
    String[] arrayOfString71 = { "thorn", "254" };
    String[] arrayOfString72 = { "yuml", "255" };
    ajVu = new String[][] { localObject, { "iexcl", "161" }, arrayOfString1, { "pound", "163" }, arrayOfString2, arrayOfString3, { "brvbar", "166" }, arrayOfString4, { "uml", "168" }, arrayOfString5, arrayOfString6, arrayOfString7, { "not", "172" }, arrayOfString8, { "reg", "174" }, { "macr", "175" }, arrayOfString9, arrayOfString10, arrayOfString11, { "sup3", "179" }, { "acute", "180" }, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, { "frac14", "188" }, { "frac12", "189" }, { "frac34", "190" }, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, { "Ccedil", "199" }, arrayOfString27, { "Eacute", "201" }, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, { "ETH", "208" }, arrayOfString34, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, { "Oslash", "216" }, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, { "THORN", "222" }, arrayOfString46, { "agrave", "224" }, arrayOfString47, arrayOfString48, arrayOfString49, { "auml", "228" }, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, { "euml", "235" }, arrayOfString56, { "iacute", "237" }, arrayOfString57, arrayOfString58, arrayOfString59, arrayOfString60, arrayOfString61, arrayOfString62, { "ocirc", "244" }, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, { "ugrave", "249" }, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72 };
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
    arrayOfString12 = new String[] { "Xi", "926" };
    arrayOfString13 = new String[] { "Pi", "928" };
    arrayOfString14 = new String[] { "Rho", "929" };
    arrayOfString15 = new String[] { "Sigma", "931" };
    arrayOfString16 = new String[] { "Tau", "932" };
    arrayOfString17 = new String[] { "Upsilon", "933" };
    arrayOfString18 = new String[] { "Phi", "934" };
    arrayOfString19 = new String[] { "Chi", "935" };
    arrayOfString20 = new String[] { "Omega", "937" };
    arrayOfString21 = new String[] { "beta", "946" };
    arrayOfString22 = new String[] { "gamma", "947" };
    arrayOfString23 = new String[] { "delta", "948" };
    arrayOfString24 = new String[] { "epsilon", "949" };
    arrayOfString25 = new String[] { "zeta", "950" };
    arrayOfString26 = new String[] { "theta", "952" };
    arrayOfString27 = new String[] { "kappa", "954" };
    arrayOfString28 = new String[] { "mu", "956" };
    arrayOfString29 = new String[] { "nu", "957" };
    arrayOfString30 = new String[] { "pi", "960" };
    arrayOfString31 = new String[] { "rho", "961" };
    arrayOfString32 = new String[] { "sigmaf", "962" };
    arrayOfString33 = new String[] { "sigma", "963" };
    arrayOfString34 = new String[] { "tau", "964" };
    arrayOfString35 = new String[] { "upsilon", "965" };
    arrayOfString36 = new String[] { "phi", "966" };
    arrayOfString37 = new String[] { "psi", "968" };
    arrayOfString38 = new String[] { "omega", "969" };
    arrayOfString39 = new String[] { "thetasym", "977" };
    arrayOfString40 = new String[] { "upsih", "978" };
    arrayOfString41 = new String[] { "bull", "8226" };
    arrayOfString42 = new String[] { "prime", "8242" };
    arrayOfString43 = new String[] { "oline", "8254" };
    arrayOfString44 = new String[] { "image", "8465" };
    arrayOfString45 = new String[] { "real", "8476" };
    arrayOfString46 = new String[] { "trade", "8482" };
    arrayOfString47 = new String[] { "larr", "8592" };
    arrayOfString48 = new String[] { "darr", "8595" };
    arrayOfString49 = new String[] { "harr", "8596" };
    arrayOfString50 = new String[] { "crarr", "8629" };
    arrayOfString51 = new String[] { "lArr", "8656" };
    arrayOfString52 = new String[] { "uArr", "8657" };
    arrayOfString53 = new String[] { "rArr", "8658" };
    arrayOfString54 = new String[] { "dArr", "8659" };
    arrayOfString55 = new String[] { "part", "8706" };
    arrayOfString56 = new String[] { "exist", "8707" };
    arrayOfString57 = new String[] { "empty", "8709" };
    arrayOfString58 = new String[] { "nabla", "8711" };
    arrayOfString59 = new String[] { "notin", "8713" };
    arrayOfString60 = new String[] { "ni", "8715" };
    arrayOfString61 = new String[] { "minus", "8722" };
    arrayOfString62 = new String[] { "lowast", "8727" };
    arrayOfString63 = new String[] { "radic", "8730" };
    arrayOfString64 = new String[] { "infin", "8734" };
    arrayOfString65 = new String[] { "and", "8743" };
    arrayOfString66 = new String[] { "or", "8744" };
    arrayOfString67 = new String[] { "cap", "8745" };
    arrayOfString68 = new String[] { "cup", "8746" };
    arrayOfString69 = new String[] { "int", "8747" };
    arrayOfString70 = new String[] { "there4", "8756" };
    arrayOfString71 = new String[] { "sim", "8764" };
    arrayOfString72 = new String[] { "cong", "8773" };
    String[] arrayOfString73 = { "asymp", "8776" };
    String[] arrayOfString74 = { "ne", "8800" };
    String[] arrayOfString75 = { "ge", "8805" };
    String[] arrayOfString76 = { "sub", "8834" };
    String[] arrayOfString77 = { "sup", "8835" };
    String[] arrayOfString78 = { "sube", "8838" };
    String[] arrayOfString79 = { "oplus", "8853" };
    String[] arrayOfString80 = { "perp", "8869" };
    String[] arrayOfString81 = { "sdot", "8901" };
    String[] arrayOfString82 = { "lceil", "8968" };
    String[] arrayOfString83 = { "rceil", "8969" };
    String[] arrayOfString84 = { "lfloor", "8970" };
    String[] arrayOfString85 = { "rfloor", "8971" };
    String[] arrayOfString86 = { "lang", "9001" };
    String[] arrayOfString87 = { "rang", "9002" };
    String[] arrayOfString88 = { "loz", "9674" };
    String[] arrayOfString89 = { "spades", "9824" };
    String[] arrayOfString90 = { "clubs", "9827" };
    String[] arrayOfString91 = { "diams", "9830" };
    String[] arrayOfString92 = { "OElig", "338" };
    String[] arrayOfString93 = { "oelig", "339" };
    String[] arrayOfString94 = { "Scaron", "352" };
    String[] arrayOfString95 = { "scaron", "353" };
    String[] arrayOfString96 = { "circ", "710" };
    String[] arrayOfString97 = { "tilde", "732" };
    String[] arrayOfString98 = { "emsp", "8195" };
    String[] arrayOfString99 = { "thinsp", "8201" };
    String[] arrayOfString100 = { "zwnj", "8204" };
    String[] arrayOfString101 = { "zwj", "8205" };
    String[] arrayOfString102 = { "lrm", "8206" };
    String[] arrayOfString103 = { "mdash", "8212" };
    String[] arrayOfString104 = { "lsquo", "8216" };
    String[] arrayOfString105 = { "rsquo", "8217" };
    String[] arrayOfString106 = { "sbquo", "8218" };
    String[] arrayOfString107 = { "rdquo", "8221" };
    String[] arrayOfString108 = { "Dagger", "8225" };
    String[] arrayOfString109 = { "permil", "8240" };
    String[] arrayOfString110 = { "lsaquo", "8249" };
    String[] arrayOfString111 = { "rsaquo", "8250" };
    String[] arrayOfString112 = { "euro", "8364" };
    ajVv = new String[][] { localObject, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, { "Mu", "924" }, { "Nu", "925" }, arrayOfString12, { "Omicron", "927" }, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, { "Psi", "936" }, arrayOfString20, { "alpha", "945" }, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, { "eta", "951" }, arrayOfString26, { "iota", "953" }, arrayOfString27, { "lambda", "955" }, arrayOfString28, arrayOfString29, { "xi", "958" }, { "omicron", "959" }, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, arrayOfString36, { "chi", "967" }, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, { "piv", "982" }, arrayOfString41, { "hellip", "8230" }, arrayOfString42, { "Prime", "8243" }, arrayOfString43, { "frasl", "8260" }, { "weierp", "8472" }, arrayOfString44, arrayOfString45, arrayOfString46, { "alefsym", "8501" }, arrayOfString47, { "uarr", "8593" }, { "rarr", "8594" }, arrayOfString48, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, { "hArr", "8660" }, { "forall", "8704" }, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, { "isin", "8712" }, arrayOfString59, arrayOfString60, { "prod", "8719" }, { "sum", "8721" }, arrayOfString61, arrayOfString62, arrayOfString63, { "prop", "8733" }, arrayOfString64, { "ang", "8736" }, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72, arrayOfString73, arrayOfString74, { "equiv", "8801" }, { "le", "8804" }, arrayOfString75, arrayOfString76, arrayOfString77, arrayOfString78, { "supe", "8839" }, arrayOfString79, { "otimes", "8855" }, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83, arrayOfString84, arrayOfString85, arrayOfString86, arrayOfString87, arrayOfString88, arrayOfString89, arrayOfString90, { "hearts", "9829" }, arrayOfString91, arrayOfString92, arrayOfString93, arrayOfString94, arrayOfString95, { "Yuml", "376" }, arrayOfString96, arrayOfString97, { "ensp", "8194" }, arrayOfString98, arrayOfString99, arrayOfString100, arrayOfString101, arrayOfString102, { "rlm", "8207" }, { "ndash", "8211" }, arrayOfString103, arrayOfString104, arrayOfString105, arrayOfString106, { "ldquo", "8220" }, arrayOfString107, { "bdquo", "8222" }, { "dagger", "8224" }, arrayOfString108, arrayOfString109, arrayOfString110, arrayOfString111, arrayOfString112 };
    localObject = new c();
    ((c)localObject).a(ajVs);
    ((c)localObject).a(ajVt);
    ajVw = (c)localObject;
    localObject = new c();
    ((c)localObject).a(ajVs);
    ((c)localObject).a(ajVu);
    ajVx = (c)localObject;
    localObject = new c();
    ((c)localObject).a(ajVs);
    ((c)localObject).a(ajVu);
    ((c)localObject).a(ajVv);
    ajVy = (c)localObject;
    AppMethodBeat.o(40711);
  }
  
  public c()
  {
    AppMethodBeat.i(40707);
    this.ajVz = new c.b();
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
        paramInt = this.ajVz.bLb(str);
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
      this.ajVz.u(str, j);
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
      paramString = new k(paramString);
      AppMethodBeat.o(40709);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.apache.commons.c.c
 * JD-Core Version:    0.7.0.1
 */