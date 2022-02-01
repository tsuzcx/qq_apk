package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

final class c
{
  private static final String[][] Ufj;
  private static final String[][] Ufk;
  static final String[][] Ufl;
  static final String[][] Ufm;
  public static final c Ufn;
  public static final c Ufo;
  public static final c Ufp;
  private final a Ufq;
  
  static
  {
    AppMethodBeat.i(40711);
    Ufj = new String[][] { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
    Ufk = new String[][] { { "apos", "39" } };
    Object localObject = { "pound", "163" };
    String[] arrayOfString1 = { "laquo", "171" };
    String[] arrayOfString2 = { "cedil", "184" };
    String[] arrayOfString3 = { "Auml", "196" };
    String[] arrayOfString4 = { "Aring", "197" };
    String[] arrayOfString5 = { "AElig", "198" };
    String[] arrayOfString6 = { "Ugrave", "217" };
    String[] arrayOfString7 = { "aring", "229" };
    String[] arrayOfString8 = { "igrave", "236" };
    String[] arrayOfString9 = { "ntilde", "241" };
    String[] arrayOfString10 = { "otilde", "245" };
    String[] arrayOfString11 = { "ouml", "246" };
    String[] arrayOfString12 = { "oslash", "248" };
    Ufl = new String[][] { { "nbsp", "160" }, { "iexcl", "161" }, { "cent", "162" }, localObject, { "curren", "164" }, { "yen", "165" }, { "brvbar", "166" }, { "sect", "167" }, { "uml", "168" }, { "copy", "169" }, { "ordf", "170" }, arrayOfString1, { "not", "172" }, { "shy", "173" }, { "reg", "174" }, { "macr", "175" }, { "deg", "176" }, { "plusmn", "177" }, { "sup2", "178" }, { "sup3", "179" }, { "acute", "180" }, { "micro", "181" }, { "para", "182" }, { "middot", "183" }, arrayOfString2, { "sup1", "185" }, { "ordm", "186" }, { "raquo", "187" }, { "frac14", "188" }, { "frac12", "189" }, { "frac34", "190" }, { "iquest", "191" }, { "Agrave", "192" }, { "Aacute", "193" }, { "Acirc", "194" }, { "Atilde", "195" }, arrayOfString3, arrayOfString4, arrayOfString5, { "Ccedil", "199" }, { "Egrave", "200" }, { "Eacute", "201" }, { "Ecirc", "202" }, { "Euml", "203" }, { "Igrave", "204" }, { "Iacute", "205" }, { "Icirc", "206" }, { "Iuml", "207" }, { "ETH", "208" }, { "Ntilde", "209" }, { "Ograve", "210" }, { "Oacute", "211" }, { "Ocirc", "212" }, { "Otilde", "213" }, { "Ouml", "214" }, { "times", "215" }, { "Oslash", "216" }, arrayOfString6, { "Uacute", "218" }, { "Ucirc", "219" }, { "Uuml", "220" }, { "Yacute", "221" }, { "THORN", "222" }, { "szlig", "223" }, { "agrave", "224" }, { "aacute", "225" }, { "acirc", "226" }, { "atilde", "227" }, { "auml", "228" }, arrayOfString7, { "aelig", "230" }, { "ccedil", "231" }, { "egrave", "232" }, { "eacute", "233" }, { "ecirc", "234" }, { "euml", "235" }, arrayOfString8, { "iacute", "237" }, { "icirc", "238" }, { "iuml", "239" }, { "eth", "240" }, arrayOfString9, { "ograve", "242" }, { "oacute", "243" }, { "ocirc", "244" }, arrayOfString10, arrayOfString11, { "divide", "247" }, arrayOfString12, { "ugrave", "249" }, { "uacute", "250" }, { "ucirc", "251" }, { "uuml", "252" }, { "yacute", "253" }, { "thorn", "254" }, { "yuml", "255" } };
    localObject = new String[] { "fnof", "402" };
    arrayOfString1 = new String[] { "Beta", "914" };
    arrayOfString2 = new String[] { "Zeta", "918" };
    arrayOfString3 = new String[] { "Theta", "920" };
    arrayOfString4 = new String[] { "Iota", "921" };
    arrayOfString5 = new String[] { "Lambda", "923" };
    arrayOfString6 = new String[] { "Mu", "924" };
    arrayOfString7 = new String[] { "Nu", "925" };
    arrayOfString8 = new String[] { "Xi", "926" };
    arrayOfString9 = new String[] { "Omicron", "927" };
    arrayOfString10 = new String[] { "Pi", "928" };
    arrayOfString11 = new String[] { "Tau", "932" };
    arrayOfString12 = new String[] { "Upsilon", "933" };
    String[] arrayOfString13 = { "Phi", "934" };
    String[] arrayOfString14 = { "Chi", "935" };
    String[] arrayOfString15 = { "Psi", "936" };
    String[] arrayOfString16 = { "beta", "946" };
    String[] arrayOfString17 = { "delta", "948" };
    String[] arrayOfString18 = { "epsilon", "949" };
    String[] arrayOfString19 = { "zeta", "950" };
    String[] arrayOfString20 = { "theta", "952" };
    String[] arrayOfString21 = { "kappa", "954" };
    String[] arrayOfString22 = { "mu", "956" };
    String[] arrayOfString23 = { "nu", "957" };
    String[] arrayOfString24 = { "xi", "958" };
    String[] arrayOfString25 = { "omicron", "959" };
    String[] arrayOfString26 = { "rho", "961" };
    String[] arrayOfString27 = { "sigmaf", "962" };
    String[] arrayOfString28 = { "chi", "967" };
    String[] arrayOfString29 = { "omega", "969" };
    String[] arrayOfString30 = { "thetasym", "977" };
    String[] arrayOfString31 = { "piv", "982" };
    String[] arrayOfString32 = { "bull", "8226" };
    String[] arrayOfString33 = { "hellip", "8230" };
    String[] arrayOfString34 = { "prime", "8242" };
    String[] arrayOfString35 = { "oline", "8254" };
    String[] arrayOfString36 = { "frasl", "8260" };
    String[] arrayOfString37 = { "weierp", "8472" };
    String[] arrayOfString38 = { "image", "8465" };
    String[] arrayOfString39 = { "larr", "8592" };
    String[] arrayOfString40 = { "uarr", "8593" };
    String[] arrayOfString41 = { "rarr", "8594" };
    String[] arrayOfString42 = { "crarr", "8629" };
    String[] arrayOfString43 = { "lArr", "8656" };
    String[] arrayOfString44 = { "uArr", "8657" };
    String[] arrayOfString45 = { "rArr", "8658" };
    String[] arrayOfString46 = { "dArr", "8659" };
    String[] arrayOfString47 = { "forall", "8704" };
    String[] arrayOfString48 = { "part", "8706" };
    String[] arrayOfString49 = { "nabla", "8711" };
    String[] arrayOfString50 = { "isin", "8712" };
    String[] arrayOfString51 = { "notin", "8713" };
    String[] arrayOfString52 = { "ni", "8715" };
    String[] arrayOfString53 = { "prod", "8719" };
    String[] arrayOfString54 = { "lowast", "8727" };
    String[] arrayOfString55 = { "radic", "8730" };
    String[] arrayOfString56 = { "infin", "8734" };
    String[] arrayOfString57 = { "ang", "8736" };
    String[] arrayOfString58 = { "and", "8743" };
    String[] arrayOfString59 = { "or", "8744" };
    String[] arrayOfString60 = { "cap", "8745" };
    String[] arrayOfString61 = { "int", "8747" };
    String[] arrayOfString62 = { "there4", "8756" };
    String[] arrayOfString63 = { "sim", "8764" };
    String[] arrayOfString64 = { "asymp", "8776" };
    String[] arrayOfString65 = { "ne", "8800" };
    String[] arrayOfString66 = { "equiv", "8801" };
    String[] arrayOfString67 = { "le", "8804" };
    String[] arrayOfString68 = { "sub", "8834" };
    String[] arrayOfString69 = { "sube", "8838" };
    String[] arrayOfString70 = { "supe", "8839" };
    String[] arrayOfString71 = { "sdot", "8901" };
    String[] arrayOfString72 = { "lceil", "8968" };
    String[] arrayOfString73 = { "rceil", "8969" };
    String[] arrayOfString74 = { "rfloor", "8971" };
    String[] arrayOfString75 = { "lang", "9001" };
    String[] arrayOfString76 = { "loz", "9674" };
    String[] arrayOfString77 = { "spades", "9824" };
    String[] arrayOfString78 = { "clubs", "9827" };
    String[] arrayOfString79 = { "hearts", "9829" };
    String[] arrayOfString80 = { "diams", "9830" };
    String[] arrayOfString81 = { "OElig", "338" };
    String[] arrayOfString82 = { "Scaron", "352" };
    String[] arrayOfString83 = { "circ", "710" };
    String[] arrayOfString84 = { "tilde", "732" };
    String[] arrayOfString85 = { "ensp", "8194" };
    String[] arrayOfString86 = { "thinsp", "8201" };
    String[] arrayOfString87 = { "zwj", "8205" };
    String[] arrayOfString88 = { "mdash", "8212" };
    String[] arrayOfString89 = { "lsquo", "8216" };
    String[] arrayOfString90 = { "rsquo", "8217" };
    String[] arrayOfString91 = { "sbquo", "8218" };
    String[] arrayOfString92 = { "ldquo", "8220" };
    String[] arrayOfString93 = { "rdquo", "8221" };
    String[] arrayOfString94 = { "bdquo", "8222" };
    String[] arrayOfString95 = { "dagger", "8224" };
    String[] arrayOfString96 = { "lsaquo", "8249" };
    Ufm = new String[][] { localObject, { "Alpha", "913" }, arrayOfString1, { "Gamma", "915" }, { "Delta", "916" }, { "Epsilon", "917" }, arrayOfString2, { "Eta", "919" }, arrayOfString3, arrayOfString4, { "Kappa", "922" }, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, { "Rho", "929" }, { "Sigma", "931" }, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, { "Omega", "937" }, { "alpha", "945" }, arrayOfString16, { "gamma", "947" }, arrayOfString17, arrayOfString18, arrayOfString19, { "eta", "951" }, arrayOfString20, { "iota", "953" }, arrayOfString21, { "lambda", "955" }, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, { "pi", "960" }, arrayOfString26, arrayOfString27, { "sigma", "963" }, { "tau", "964" }, { "upsilon", "965" }, { "phi", "966" }, arrayOfString28, { "psi", "968" }, arrayOfString29, arrayOfString30, { "upsih", "978" }, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, { "Prime", "8243" }, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, { "real", "8476" }, { "trade", "8482" }, { "alefsym", "8501" }, arrayOfString39, arrayOfString40, arrayOfString41, { "darr", "8595" }, { "harr", "8596" }, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, { "hArr", "8660" }, arrayOfString47, arrayOfString48, { "exist", "8707" }, { "empty", "8709" }, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, { "sum", "8721" }, { "minus", "8722" }, arrayOfString54, arrayOfString55, { "prop", "8733" }, arrayOfString56, arrayOfString57, arrayOfString58, arrayOfString59, arrayOfString60, { "cup", "8746" }, arrayOfString61, arrayOfString62, arrayOfString63, { "cong", "8773" }, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, { "ge", "8805" }, arrayOfString68, { "sup", "8835" }, arrayOfString69, arrayOfString70, { "oplus", "8853" }, { "otimes", "8855" }, { "perp", "8869" }, arrayOfString71, arrayOfString72, arrayOfString73, { "lfloor", "8970" }, arrayOfString74, arrayOfString75, { "rang", "9002" }, arrayOfString76, arrayOfString77, arrayOfString78, arrayOfString79, arrayOfString80, arrayOfString81, { "oelig", "339" }, arrayOfString82, { "scaron", "353" }, { "Yuml", "376" }, arrayOfString83, arrayOfString84, arrayOfString85, { "emsp", "8195" }, arrayOfString86, { "zwnj", "8204" }, arrayOfString87, { "lrm", "8206" }, { "rlm", "8207" }, { "ndash", "8211" }, arrayOfString88, arrayOfString89, arrayOfString90, arrayOfString91, arrayOfString92, arrayOfString93, arrayOfString94, arrayOfString95, { "Dagger", "8225" }, { "permil", "8240" }, arrayOfString96, { "rsaquo", "8250" }, { "euro", "8364" } };
    localObject = new c();
    ((c)localObject).a(Ufj);
    ((c)localObject).a(Ufk);
    Ufn = (c)localObject;
    localObject = new c();
    ((c)localObject).a(Ufj);
    ((c)localObject).a(Ufl);
    Ufo = (c)localObject;
    localObject = new c();
    ((c)localObject).a(Ufj);
    ((c)localObject).a(Ufl);
    ((c)localObject).a(Ufm);
    Ufp = (c)localObject;
    AppMethodBeat.o(40711);
  }
  
  public c()
  {
    AppMethodBeat.i(40707);
    this.Ufq = new b();
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
        paramInt = this.Ufq.bvd(str);
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
      this.Ufq.i(str, j);
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
    public abstract int bvd(String paramString);
    
    public abstract void i(String paramString, int paramInt);
  }
  
  static final class b
    extends c.c
  {}
  
  static class c
    implements c.a
  {
    private final Map Ufr;
    private final d Ufs;
    
    c()
    {
      AppMethodBeat.i(40704);
      this.Ufr = new HashMap();
      this.Ufs = new d();
      AppMethodBeat.o(40704);
    }
    
    public final int bvd(String paramString)
    {
      AppMethodBeat.i(40706);
      paramString = this.Ufr.get(paramString);
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
      this.Ufr.put(paramString, Integer.valueOf(paramInt));
      this.Ufs.e(paramInt, paramString);
      AppMethodBeat.o(40705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.b.c
 * JD-Core Version:    0.7.0.1
 */