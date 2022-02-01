package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

final class c
{
  private static final String[][] NTf;
  private static final String[][] NTg;
  static final String[][] NTh;
  static final String[][] NTi;
  public static final c NTj;
  public static final c NTk;
  public static final c NTl;
  private final a NTm;
  
  static
  {
    AppMethodBeat.i(40711);
    NTf = new String[][] { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
    NTg = new String[][] { { "apos", "39" } };
    Object localObject = { "nbsp", "160" };
    String[] arrayOfString1 = { "cent", "162" };
    String[] arrayOfString2 = { "pound", "163" };
    String[] arrayOfString3 = { "curren", "164" };
    String[] arrayOfString4 = { "yen", "165" };
    String[] arrayOfString5 = { "brvbar", "166" };
    String[] arrayOfString6 = { "sect", "167" };
    String[] arrayOfString7 = { "uml", "168" };
    String[] arrayOfString8 = { "copy", "169" };
    String[] arrayOfString9 = { "ordf", "170" };
    String[] arrayOfString10 = { "laquo", "171" };
    String[] arrayOfString11 = { "not", "172" };
    String[] arrayOfString12 = { "shy", "173" };
    String[] arrayOfString13 = { "reg", "174" };
    String[] arrayOfString14 = { "macr", "175" };
    String[] arrayOfString15 = { "deg", "176" };
    String[] arrayOfString16 = { "plusmn", "177" };
    String[] arrayOfString17 = { "sup2", "178" };
    String[] arrayOfString18 = { "sup3", "179" };
    String[] arrayOfString19 = { "acute", "180" };
    String[] arrayOfString20 = { "micro", "181" };
    String[] arrayOfString21 = { "para", "182" };
    String[] arrayOfString22 = { "middot", "183" };
    String[] arrayOfString23 = { "cedil", "184" };
    String[] arrayOfString24 = { "sup1", "185" };
    String[] arrayOfString25 = { "ordm", "186" };
    String[] arrayOfString26 = { "raquo", "187" };
    String[] arrayOfString27 = { "frac14", "188" };
    String[] arrayOfString28 = { "frac12", "189" };
    String[] arrayOfString29 = { "frac34", "190" };
    String[] arrayOfString30 = { "iquest", "191" };
    String[] arrayOfString31 = { "Agrave", "192" };
    String[] arrayOfString32 = { "Aacute", "193" };
    String[] arrayOfString33 = { "Acirc", "194" };
    String[] arrayOfString34 = { "Atilde", "195" };
    String[] arrayOfString35 = { "Auml", "196" };
    String[] arrayOfString36 = { "Aring", "197" };
    String[] arrayOfString37 = { "AElig", "198" };
    String[] arrayOfString38 = { "Ccedil", "199" };
    String[] arrayOfString39 = { "Egrave", "200" };
    String[] arrayOfString40 = { "Eacute", "201" };
    String[] arrayOfString41 = { "Ecirc", "202" };
    String[] arrayOfString42 = { "Euml", "203" };
    String[] arrayOfString43 = { "Igrave", "204" };
    String[] arrayOfString44 = { "Iacute", "205" };
    String[] arrayOfString45 = { "Icirc", "206" };
    String[] arrayOfString46 = { "Iuml", "207" };
    String[] arrayOfString47 = { "ETH", "208" };
    String[] arrayOfString48 = { "Ntilde", "209" };
    String[] arrayOfString49 = { "Ograve", "210" };
    String[] arrayOfString50 = { "Oacute", "211" };
    String[] arrayOfString51 = { "Ocirc", "212" };
    String[] arrayOfString52 = { "Otilde", "213" };
    String[] arrayOfString53 = { "Ouml", "214" };
    String[] arrayOfString54 = { "times", "215" };
    String[] arrayOfString55 = { "Oslash", "216" };
    String[] arrayOfString56 = { "Ugrave", "217" };
    String[] arrayOfString57 = { "Uacute", "218" };
    String[] arrayOfString58 = { "Ucirc", "219" };
    String[] arrayOfString59 = { "Uuml", "220" };
    String[] arrayOfString60 = { "Yacute", "221" };
    String[] arrayOfString61 = { "THORN", "222" };
    String[] arrayOfString62 = { "szlig", "223" };
    String[] arrayOfString63 = { "agrave", "224" };
    String[] arrayOfString64 = { "aacute", "225" };
    String[] arrayOfString65 = { "acirc", "226" };
    String[] arrayOfString66 = { "atilde", "227" };
    String[] arrayOfString67 = { "auml", "228" };
    String[] arrayOfString68 = { "aring", "229" };
    String[] arrayOfString69 = { "aelig", "230" };
    String[] arrayOfString70 = { "ccedil", "231" };
    String[] arrayOfString71 = { "egrave", "232" };
    String[] arrayOfString72 = { "eacute", "233" };
    String[] arrayOfString73 = { "ecirc", "234" };
    String[] arrayOfString74 = { "euml", "235" };
    String[] arrayOfString75 = { "igrave", "236" };
    String[] arrayOfString76 = { "iacute", "237" };
    String[] arrayOfString77 = { "iuml", "239" };
    String[] arrayOfString78 = { "eth", "240" };
    String[] arrayOfString79 = { "ntilde", "241" };
    String[] arrayOfString80 = { "ograve", "242" };
    String[] arrayOfString81 = { "oacute", "243" };
    String[] arrayOfString82 = { "ocirc", "244" };
    String[] arrayOfString83 = { "otilde", "245" };
    String[] arrayOfString84 = { "ouml", "246" };
    String[] arrayOfString85 = { "divide", "247" };
    String[] arrayOfString86 = { "oslash", "248" };
    String[] arrayOfString87 = { "ugrave", "249" };
    String[] arrayOfString88 = { "uacute", "250" };
    String[] arrayOfString89 = { "ucirc", "251" };
    String[] arrayOfString90 = { "uuml", "252" };
    String[] arrayOfString91 = { "yacute", "253" };
    String[] arrayOfString92 = { "thorn", "254" };
    String[] arrayOfString93 = { "yuml", "255" };
    NTh = new String[][] { localObject, { "iexcl", "161" }, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, arrayOfString47, arrayOfString48, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, arrayOfString59, arrayOfString60, arrayOfString61, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72, arrayOfString73, arrayOfString74, arrayOfString75, arrayOfString76, { "icirc", "238" }, arrayOfString77, arrayOfString78, arrayOfString79, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83, arrayOfString84, arrayOfString85, arrayOfString86, arrayOfString87, arrayOfString88, arrayOfString89, arrayOfString90, arrayOfString91, arrayOfString92, arrayOfString93 };
    localObject = new String[] { "Alpha", "913" };
    arrayOfString1 = new String[] { "Beta", "914" };
    arrayOfString2 = new String[] { "Gamma", "915" };
    arrayOfString3 = new String[] { "Delta", "916" };
    arrayOfString4 = new String[] { "Epsilon", "917" };
    arrayOfString5 = new String[] { "Zeta", "918" };
    arrayOfString6 = new String[] { "Eta", "919" };
    arrayOfString7 = new String[] { "Iota", "921" };
    arrayOfString8 = new String[] { "Lambda", "923" };
    arrayOfString9 = new String[] { "Mu", "924" };
    arrayOfString10 = new String[] { "Omicron", "927" };
    arrayOfString11 = new String[] { "Pi", "928" };
    arrayOfString12 = new String[] { "Rho", "929" };
    arrayOfString13 = new String[] { "Sigma", "931" };
    arrayOfString14 = new String[] { "Tau", "932" };
    arrayOfString15 = new String[] { "Upsilon", "933" };
    arrayOfString16 = new String[] { "Phi", "934" };
    arrayOfString17 = new String[] { "Chi", "935" };
    arrayOfString18 = new String[] { "beta", "946" };
    arrayOfString19 = new String[] { "gamma", "947" };
    arrayOfString20 = new String[] { "delta", "948" };
    arrayOfString21 = new String[] { "epsilon", "949" };
    arrayOfString22 = new String[] { "zeta", "950" };
    arrayOfString23 = new String[] { "theta", "952" };
    arrayOfString24 = new String[] { "kappa", "954" };
    arrayOfString25 = new String[] { "nu", "957" };
    arrayOfString26 = new String[] { "xi", "958" };
    arrayOfString27 = new String[] { "omicron", "959" };
    arrayOfString28 = new String[] { "pi", "960" };
    arrayOfString29 = new String[] { "rho", "961" };
    arrayOfString30 = new String[] { "sigmaf", "962" };
    arrayOfString31 = new String[] { "tau", "964" };
    arrayOfString32 = new String[] { "upsilon", "965" };
    arrayOfString33 = new String[] { "phi", "966" };
    arrayOfString34 = new String[] { "chi", "967" };
    arrayOfString35 = new String[] { "psi", "968" };
    arrayOfString36 = new String[] { "omega", "969" };
    arrayOfString37 = new String[] { "thetasym", "977" };
    arrayOfString38 = new String[] { "upsih", "978" };
    arrayOfString39 = new String[] { "bull", "8226" };
    arrayOfString40 = new String[] { "hellip", "8230" };
    arrayOfString41 = new String[] { "prime", "8242" };
    arrayOfString42 = new String[] { "Prime", "8243" };
    arrayOfString43 = new String[] { "oline", "8254" };
    arrayOfString44 = new String[] { "frasl", "8260" };
    arrayOfString45 = new String[] { "weierp", "8472" };
    arrayOfString46 = new String[] { "image", "8465" };
    arrayOfString47 = new String[] { "trade", "8482" };
    arrayOfString48 = new String[] { "alefsym", "8501" };
    arrayOfString49 = new String[] { "larr", "8592" };
    arrayOfString50 = new String[] { "darr", "8595" };
    arrayOfString51 = new String[] { "harr", "8596" };
    arrayOfString52 = new String[] { "uArr", "8657" };
    arrayOfString53 = new String[] { "dArr", "8659" };
    arrayOfString54 = new String[] { "hArr", "8660" };
    arrayOfString55 = new String[] { "forall", "8704" };
    arrayOfString56 = new String[] { "part", "8706" };
    arrayOfString57 = new String[] { "exist", "8707" };
    arrayOfString58 = new String[] { "empty", "8709" };
    arrayOfString59 = new String[] { "nabla", "8711" };
    arrayOfString60 = new String[] { "isin", "8712" };
    arrayOfString61 = new String[] { "notin", "8713" };
    arrayOfString62 = new String[] { "ni", "8715" };
    arrayOfString63 = new String[] { "prod", "8719" };
    arrayOfString64 = new String[] { "sum", "8721" };
    arrayOfString65 = new String[] { "minus", "8722" };
    arrayOfString66 = new String[] { "lowast", "8727" };
    arrayOfString67 = new String[] { "radic", "8730" };
    arrayOfString68 = new String[] { "prop", "8733" };
    arrayOfString69 = new String[] { "infin", "8734" };
    arrayOfString70 = new String[] { "ang", "8736" };
    arrayOfString71 = new String[] { "and", "8743" };
    arrayOfString72 = new String[] { "cap", "8745" };
    arrayOfString73 = new String[] { "cup", "8746" };
    arrayOfString74 = new String[] { "int", "8747" };
    arrayOfString75 = new String[] { "sim", "8764" };
    arrayOfString76 = new String[] { "cong", "8773" };
    arrayOfString77 = new String[] { "ne", "8800" };
    arrayOfString78 = new String[] { "le", "8804" };
    arrayOfString79 = new String[] { "ge", "8805" };
    arrayOfString80 = new String[] { "sub", "8834" };
    arrayOfString81 = new String[] { "sup", "8835" };
    arrayOfString82 = new String[] { "supe", "8839" };
    arrayOfString83 = new String[] { "oplus", "8853" };
    arrayOfString84 = new String[] { "otimes", "8855" };
    arrayOfString85 = new String[] { "perp", "8869" };
    arrayOfString86 = new String[] { "rceil", "8969" };
    arrayOfString87 = new String[] { "lfloor", "8970" };
    arrayOfString88 = new String[] { "rfloor", "8971" };
    arrayOfString89 = new String[] { "lang", "9001" };
    arrayOfString90 = new String[] { "rang", "9002" };
    arrayOfString91 = new String[] { "loz", "9674" };
    arrayOfString92 = new String[] { "clubs", "9827" };
    arrayOfString93 = new String[] { "hearts", "9829" };
    String[] arrayOfString94 = { "OElig", "338" };
    String[] arrayOfString95 = { "oelig", "339" };
    String[] arrayOfString96 = { "scaron", "353" };
    String[] arrayOfString97 = { "Yuml", "376" };
    String[] arrayOfString98 = { "tilde", "732" };
    String[] arrayOfString99 = { "ensp", "8194" };
    String[] arrayOfString100 = { "emsp", "8195" };
    String[] arrayOfString101 = { "rlm", "8207" };
    String[] arrayOfString102 = { "ndash", "8211" };
    String[] arrayOfString103 = { "mdash", "8212" };
    String[] arrayOfString104 = { "lsquo", "8216" };
    String[] arrayOfString105 = { "rsquo", "8217" };
    String[] arrayOfString106 = { "sbquo", "8218" };
    String[] arrayOfString107 = { "ldquo", "8220" };
    String[] arrayOfString108 = { "rdquo", "8221" };
    String[] arrayOfString109 = { "Dagger", "8225" };
    String[] arrayOfString110 = { "permil", "8240" };
    String[] arrayOfString111 = { "lsaquo", "8249" };
    String[] arrayOfString112 = { "rsaquo", "8250" };
    String[] arrayOfString113 = { "euro", "8364" };
    NTi = new String[][] { { "fnof", "402" }, localObject, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, { "Theta", "920" }, arrayOfString7, { "Kappa", "922" }, arrayOfString8, arrayOfString9, { "Nu", "925" }, { "Xi", "926" }, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, { "Psi", "936" }, { "Omega", "937" }, { "alpha", "945" }, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, { "eta", "951" }, arrayOfString23, { "iota", "953" }, arrayOfString24, { "lambda", "955" }, { "mu", "956" }, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, arrayOfString30, { "sigma", "963" }, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, { "piv", "982" }, arrayOfString39, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, { "real", "8476" }, arrayOfString47, arrayOfString48, arrayOfString49, { "uarr", "8593" }, { "rarr", "8594" }, arrayOfString50, arrayOfString51, { "crarr", "8629" }, { "lArr", "8656" }, arrayOfString52, { "rArr", "8658" }, arrayOfString53, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, arrayOfString59, arrayOfString60, arrayOfString61, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, { "or", "8744" }, arrayOfString72, arrayOfString73, arrayOfString74, { "there4", "8756" }, arrayOfString75, arrayOfString76, { "asymp", "8776" }, arrayOfString77, { "equiv", "8801" }, arrayOfString78, arrayOfString79, arrayOfString80, arrayOfString81, { "sube", "8838" }, arrayOfString82, arrayOfString83, arrayOfString84, arrayOfString85, { "sdot", "8901" }, { "lceil", "8968" }, arrayOfString86, arrayOfString87, arrayOfString88, arrayOfString89, arrayOfString90, arrayOfString91, { "spades", "9824" }, arrayOfString92, arrayOfString93, { "diams", "9830" }, arrayOfString94, arrayOfString95, { "Scaron", "352" }, arrayOfString96, arrayOfString97, { "circ", "710" }, arrayOfString98, arrayOfString99, arrayOfString100, { "thinsp", "8201" }, { "zwnj", "8204" }, { "zwj", "8205" }, { "lrm", "8206" }, arrayOfString101, arrayOfString102, arrayOfString103, arrayOfString104, arrayOfString105, arrayOfString106, arrayOfString107, arrayOfString108, { "bdquo", "8222" }, { "dagger", "8224" }, arrayOfString109, arrayOfString110, arrayOfString111, arrayOfString112, arrayOfString113 };
    localObject = new c();
    ((c)localObject).a(NTf);
    ((c)localObject).a(NTg);
    NTj = (c)localObject;
    localObject = new c();
    ((c)localObject).a(NTf);
    ((c)localObject).a(NTh);
    NTk = (c)localObject;
    localObject = new c();
    ((c)localObject).a(NTf);
    ((c)localObject).a(NTh);
    ((c)localObject).a(NTi);
    NTl = (c)localObject;
    AppMethodBeat.o(40711);
  }
  
  public c()
  {
    AppMethodBeat.i(40707);
    this.NTm = new b();
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
        paramInt = this.NTm.bdJ(str);
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
      this.NTm.i(str, j);
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
  
  static abstract interface a
  {
    public abstract int bdJ(String paramString);
    
    public abstract void i(String paramString, int paramInt);
  }
  
  static final class b
    extends c.c
  {}
  
  static class c
    implements c.a
  {
    private final Map NTn;
    private final d NTo;
    
    c()
    {
      AppMethodBeat.i(40704);
      this.NTn = new HashMap();
      this.NTo = new d();
      AppMethodBeat.o(40704);
    }
    
    public final int bdJ(String paramString)
    {
      AppMethodBeat.i(40706);
      paramString = this.NTn.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(40706);
        return -1;
      }
      int i = ((Integer)paramString).intValue();
      AppMethodBeat.o(40706);
      return i;
    }
    
    public final void i(String paramString, int paramInt)
    {
      AppMethodBeat.i(40705);
      this.NTn.put(paramString, Integer.valueOf(paramInt));
      this.NTo.d(paramInt, paramString);
      AppMethodBeat.o(40705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.c
 * JD-Core Version:    0.7.0.1
 */