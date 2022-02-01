package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

final class c
{
  private static final String[][] LYG;
  private static final String[][] LYH;
  static final String[][] LYI;
  static final String[][] LYJ;
  public static final c LYK;
  public static final c LYL;
  public static final c LYM;
  private final a LYN;
  
  static
  {
    AppMethodBeat.i(40711);
    Object localObject = { "lt", "60" };
    LYG = new String[][] { { "quot", "34" }, { "amp", "38" }, localObject, { "gt", "62" } };
    LYH = new String[][] { { "apos", "39" } };
    localObject = new String[] { "nbsp", "160" };
    String[] arrayOfString1 = { "iexcl", "161" };
    String[] arrayOfString2 = { "cent", "162" };
    String[] arrayOfString3 = { "pound", "163" };
    String[] arrayOfString4 = { "curren", "164" };
    String[] arrayOfString5 = { "yen", "165" };
    String[] arrayOfString6 = { "brvbar", "166" };
    String[] arrayOfString7 = { "sect", "167" };
    String[] arrayOfString8 = { "uml", "168" };
    String[] arrayOfString9 = { "copy", "169" };
    String[] arrayOfString10 = { "ordf", "170" };
    String[] arrayOfString11 = { "laquo", "171" };
    String[] arrayOfString12 = { "not", "172" };
    String[] arrayOfString13 = { "shy", "173" };
    String[] arrayOfString14 = { "reg", "174" };
    String[] arrayOfString15 = { "macr", "175" };
    String[] arrayOfString16 = { "deg", "176" };
    String[] arrayOfString17 = { "plusmn", "177" };
    String[] arrayOfString18 = { "sup2", "178" };
    String[] arrayOfString19 = { "sup3", "179" };
    String[] arrayOfString20 = { "acute", "180" };
    String[] arrayOfString21 = { "para", "182" };
    String[] arrayOfString22 = { "middot", "183" };
    String[] arrayOfString23 = { "cedil", "184" };
    String[] arrayOfString24 = { "sup1", "185" };
    String[] arrayOfString25 = { "ordm", "186" };
    String[] arrayOfString26 = { "raquo", "187" };
    String[] arrayOfString27 = { "frac34", "190" };
    String[] arrayOfString28 = { "iquest", "191" };
    String[] arrayOfString29 = { "Aacute", "193" };
    String[] arrayOfString30 = { "Acirc", "194" };
    String[] arrayOfString31 = { "Atilde", "195" };
    String[] arrayOfString32 = { "Auml", "196" };
    String[] arrayOfString33 = { "Aring", "197" };
    String[] arrayOfString34 = { "Ccedil", "199" };
    String[] arrayOfString35 = { "Egrave", "200" };
    String[] arrayOfString36 = { "Eacute", "201" };
    String[] arrayOfString37 = { "Ecirc", "202" };
    String[] arrayOfString38 = { "Igrave", "204" };
    String[] arrayOfString39 = { "Iacute", "205" };
    String[] arrayOfString40 = { "Icirc", "206" };
    String[] arrayOfString41 = { "Iuml", "207" };
    String[] arrayOfString42 = { "ETH", "208" };
    String[] arrayOfString43 = { "Ntilde", "209" };
    String[] arrayOfString44 = { "Ograve", "210" };
    String[] arrayOfString45 = { "Oacute", "211" };
    String[] arrayOfString46 = { "Ocirc", "212" };
    String[] arrayOfString47 = { "Otilde", "213" };
    String[] arrayOfString48 = { "Ouml", "214" };
    String[] arrayOfString49 = { "times", "215" };
    String[] arrayOfString50 = { "Oslash", "216" };
    String[] arrayOfString51 = { "Ugrave", "217" };
    String[] arrayOfString52 = { "Uacute", "218" };
    String[] arrayOfString53 = { "Ucirc", "219" };
    String[] arrayOfString54 = { "Uuml", "220" };
    String[] arrayOfString55 = { "Yacute", "221" };
    String[] arrayOfString56 = { "THORN", "222" };
    String[] arrayOfString57 = { "szlig", "223" };
    String[] arrayOfString58 = { "agrave", "224" };
    String[] arrayOfString59 = { "aacute", "225" };
    String[] arrayOfString60 = { "acirc", "226" };
    String[] arrayOfString61 = { "atilde", "227" };
    String[] arrayOfString62 = { "auml", "228" };
    String[] arrayOfString63 = { "aring", "229" };
    String[] arrayOfString64 = { "aelig", "230" };
    String[] arrayOfString65 = { "ccedil", "231" };
    String[] arrayOfString66 = { "egrave", "232" };
    String[] arrayOfString67 = { "eacute", "233" };
    String[] arrayOfString68 = { "ecirc", "234" };
    String[] arrayOfString69 = { "igrave", "236" };
    String[] arrayOfString70 = { "iacute", "237" };
    String[] arrayOfString71 = { "icirc", "238" };
    String[] arrayOfString72 = { "iuml", "239" };
    String[] arrayOfString73 = { "ntilde", "241" };
    String[] arrayOfString74 = { "ograve", "242" };
    String[] arrayOfString75 = { "oacute", "243" };
    String[] arrayOfString76 = { "ocirc", "244" };
    String[] arrayOfString77 = { "divide", "247" };
    String[] arrayOfString78 = { "oslash", "248" };
    String[] arrayOfString79 = { "ucirc", "251" };
    String[] arrayOfString80 = { "uuml", "252" };
    String[] arrayOfString81 = { "yacute", "253" };
    String[] arrayOfString82 = { "thorn", "254" };
    String[] arrayOfString83 = { "yuml", "255" };
    LYI = new String[][] { localObject, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, { "micro", "181" }, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, { "frac14", "188" }, { "frac12", "189" }, arrayOfString27, arrayOfString28, { "Agrave", "192" }, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, { "AElig", "198" }, arrayOfString34, arrayOfString35, arrayOfString36, arrayOfString37, { "Euml", "203" }, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, arrayOfString47, arrayOfString48, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, arrayOfString59, arrayOfString60, arrayOfString61, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, { "euml", "235" }, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72, { "eth", "240" }, arrayOfString73, arrayOfString74, arrayOfString75, arrayOfString76, { "otilde", "245" }, { "ouml", "246" }, arrayOfString77, arrayOfString78, { "ugrave", "249" }, { "uacute", "250" }, arrayOfString79, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83 };
    localObject = new String[] { "fnof", "402" };
    arrayOfString1 = new String[] { "Delta", "916" };
    arrayOfString2 = new String[] { "Zeta", "918" };
    arrayOfString3 = new String[] { "Theta", "920" };
    arrayOfString4 = new String[] { "Lambda", "923" };
    arrayOfString5 = new String[] { "Mu", "924" };
    arrayOfString6 = new String[] { "Xi", "926" };
    arrayOfString7 = new String[] { "Omicron", "927" };
    arrayOfString8 = new String[] { "Psi", "936" };
    arrayOfString9 = new String[] { "alpha", "945" };
    arrayOfString10 = new String[] { "gamma", "947" };
    arrayOfString11 = new String[] { "delta", "948" };
    arrayOfString12 = new String[] { "eta", "951" };
    arrayOfString13 = new String[] { "theta", "952" };
    arrayOfString14 = new String[] { "kappa", "954" };
    arrayOfString15 = new String[] { "omicron", "959" };
    arrayOfString16 = new String[] { "rho", "961" };
    arrayOfString17 = new String[] { "sigmaf", "962" };
    arrayOfString18 = new String[] { "sigma", "963" };
    arrayOfString19 = new String[] { "tau", "964" };
    arrayOfString20 = new String[] { "upsilon", "965" };
    arrayOfString21 = new String[] { "phi", "966" };
    arrayOfString22 = new String[] { "psi", "968" };
    arrayOfString23 = new String[] { "omega", "969" };
    arrayOfString24 = new String[] { "thetasym", "977" };
    arrayOfString25 = new String[] { "piv", "982" };
    arrayOfString26 = new String[] { "Prime", "8243" };
    arrayOfString27 = new String[] { "oline", "8254" };
    arrayOfString28 = new String[] { "frasl", "8260" };
    arrayOfString29 = new String[] { "image", "8465" };
    arrayOfString30 = new String[] { "real", "8476" };
    arrayOfString31 = new String[] { "trade", "8482" };
    arrayOfString32 = new String[] { "alefsym", "8501" };
    arrayOfString33 = new String[] { "uarr", "8593" };
    arrayOfString34 = new String[] { "rarr", "8594" };
    arrayOfString35 = new String[] { "dArr", "8659" };
    arrayOfString36 = new String[] { "forall", "8704" };
    arrayOfString37 = new String[] { "exist", "8707" };
    arrayOfString38 = new String[] { "empty", "8709" };
    arrayOfString39 = new String[] { "isin", "8712" };
    arrayOfString40 = new String[] { "notin", "8713" };
    arrayOfString41 = new String[] { "prod", "8719" };
    arrayOfString42 = new String[] { "sum", "8721" };
    arrayOfString43 = new String[] { "minus", "8722" };
    arrayOfString44 = new String[] { "lowast", "8727" };
    arrayOfString45 = new String[] { "and", "8743" };
    arrayOfString46 = new String[] { "or", "8744" };
    arrayOfString47 = new String[] { "cap", "8745" };
    arrayOfString48 = new String[] { "there4", "8756" };
    arrayOfString49 = new String[] { "sim", "8764" };
    arrayOfString50 = new String[] { "ge", "8805" };
    arrayOfString51 = new String[] { "supe", "8839" };
    arrayOfString52 = new String[] { "sdot", "8901" };
    arrayOfString53 = new String[] { "rfloor", "8971" };
    arrayOfString54 = new String[] { "lang", "9001" };
    arrayOfString55 = new String[] { "loz", "9674" };
    arrayOfString56 = new String[] { "spades", "9824" };
    arrayOfString57 = new String[] { "clubs", "9827" };
    arrayOfString58 = new String[] { "diams", "9830" };
    arrayOfString59 = new String[] { "scaron", "353" };
    arrayOfString60 = new String[] { "Yuml", "376" };
    arrayOfString61 = new String[] { "circ", "710" };
    arrayOfString62 = new String[] { "ensp", "8194" };
    arrayOfString63 = new String[] { "thinsp", "8201" };
    arrayOfString64 = new String[] { "zwnj", "8204" };
    arrayOfString65 = new String[] { "zwj", "8205" };
    arrayOfString66 = new String[] { "rlm", "8207" };
    arrayOfString67 = new String[] { "mdash", "8212" };
    arrayOfString68 = new String[] { "rsquo", "8217" };
    arrayOfString69 = new String[] { "rsaquo", "8250" };
    LYJ = new String[][] { localObject, { "Alpha", "913" }, { "Beta", "914" }, { "Gamma", "915" }, arrayOfString1, { "Epsilon", "917" }, arrayOfString2, { "Eta", "919" }, arrayOfString3, { "Iota", "921" }, { "Kappa", "922" }, arrayOfString4, arrayOfString5, { "Nu", "925" }, arrayOfString6, arrayOfString7, { "Pi", "928" }, { "Rho", "929" }, { "Sigma", "931" }, { "Tau", "932" }, { "Upsilon", "933" }, { "Phi", "934" }, { "Chi", "935" }, arrayOfString8, { "Omega", "937" }, arrayOfString9, { "beta", "946" }, arrayOfString10, arrayOfString11, { "epsilon", "949" }, { "zeta", "950" }, arrayOfString12, arrayOfString13, { "iota", "953" }, arrayOfString14, { "lambda", "955" }, { "mu", "956" }, { "nu", "957" }, { "xi", "958" }, arrayOfString15, { "pi", "960" }, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, { "chi", "967" }, arrayOfString22, arrayOfString23, arrayOfString24, { "upsih", "978" }, arrayOfString25, { "bull", "8226" }, { "hellip", "8230" }, { "prime", "8242" }, arrayOfString26, arrayOfString27, arrayOfString28, { "weierp", "8472" }, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, { "larr", "8592" }, arrayOfString33, arrayOfString34, { "darr", "8595" }, { "harr", "8596" }, { "crarr", "8629" }, { "lArr", "8656" }, { "uArr", "8657" }, { "rArr", "8658" }, arrayOfString35, { "hArr", "8660" }, arrayOfString36, { "part", "8706" }, arrayOfString37, arrayOfString38, { "nabla", "8711" }, arrayOfString39, arrayOfString40, { "ni", "8715" }, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, { "radic", "8730" }, { "prop", "8733" }, { "infin", "8734" }, { "ang", "8736" }, arrayOfString45, arrayOfString46, arrayOfString47, { "cup", "8746" }, { "int", "8747" }, arrayOfString48, arrayOfString49, { "cong", "8773" }, { "asymp", "8776" }, { "ne", "8800" }, { "equiv", "8801" }, { "le", "8804" }, arrayOfString50, { "sub", "8834" }, { "sup", "8835" }, { "sube", "8838" }, arrayOfString51, { "oplus", "8853" }, { "otimes", "8855" }, { "perp", "8869" }, arrayOfString52, { "lceil", "8968" }, { "rceil", "8969" }, { "lfloor", "8970" }, arrayOfString53, arrayOfString54, { "rang", "9002" }, arrayOfString55, arrayOfString56, arrayOfString57, { "hearts", "9829" }, arrayOfString58, { "OElig", "338" }, { "oelig", "339" }, { "Scaron", "352" }, arrayOfString59, arrayOfString60, arrayOfString61, { "tilde", "732" }, arrayOfString62, { "emsp", "8195" }, arrayOfString63, arrayOfString64, arrayOfString65, { "lrm", "8206" }, arrayOfString66, { "ndash", "8211" }, arrayOfString67, { "lsquo", "8216" }, arrayOfString68, { "sbquo", "8218" }, { "ldquo", "8220" }, { "rdquo", "8221" }, { "bdquo", "8222" }, { "dagger", "8224" }, { "Dagger", "8225" }, { "permil", "8240" }, { "lsaquo", "8249" }, arrayOfString69, { "euro", "8364" } };
    localObject = new c();
    ((c)localObject).a(LYG);
    ((c)localObject).a(LYH);
    LYK = (c)localObject;
    localObject = new c();
    ((c)localObject).a(LYG);
    ((c)localObject).a(LYI);
    LYL = (c)localObject;
    localObject = new c();
    ((c)localObject).a(LYG);
    ((c)localObject).a(LYI);
    ((c)localObject).a(LYJ);
    LYM = (c)localObject;
    AppMethodBeat.o(40711);
  }
  
  public c()
  {
    AppMethodBeat.i(40707);
    this.LYN = new b();
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
        paramInt = this.LYN.aXp(str);
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
      this.LYN.g(str, j);
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
    public abstract int aXp(String paramString);
    
    public abstract void g(String paramString, int paramInt);
  }
  
  static final class b
    extends c.c
  {}
  
  static class c
    implements c.a
  {
    private final Map LYO;
    private final d LYP;
    
    c()
    {
      AppMethodBeat.i(40704);
      this.LYO = new HashMap();
      this.LYP = new d();
      AppMethodBeat.o(40704);
    }
    
    public final int aXp(String paramString)
    {
      AppMethodBeat.i(40706);
      paramString = this.LYO.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(40706);
        return -1;
      }
      int i = ((Integer)paramString).intValue();
      AppMethodBeat.o(40706);
      return i;
    }
    
    public final void g(String paramString, int paramInt)
    {
      AppMethodBeat.i(40705);
      this.LYO.put(paramString, Integer.valueOf(paramInt));
      this.LYP.d(paramInt, paramString);
      AppMethodBeat.o(40705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.c
 * JD-Core Version:    0.7.0.1
 */