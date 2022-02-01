package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

final class c
{
  private static final String[][] Oql;
  private static final String[][] Oqm;
  static final String[][] Oqn;
  static final String[][] Oqo;
  public static final c Oqp;
  public static final c Oqq;
  public static final c Oqr;
  private final a Oqs;
  
  static
  {
    AppMethodBeat.i(40711);
    Oql = new String[][] { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
    Oqm = new String[][] { { "apos", "39" } };
    Object localObject = { "nbsp", "160" };
    String[] arrayOfString1 = { "iexcl", "161" };
    String[] arrayOfString2 = { "curren", "164" };
    String[] arrayOfString3 = { "yen", "165" };
    String[] arrayOfString4 = { "brvbar", "166" };
    String[] arrayOfString5 = { "sect", "167" };
    String[] arrayOfString6 = { "uml", "168" };
    String[] arrayOfString7 = { "copy", "169" };
    String[] arrayOfString8 = { "laquo", "171" };
    String[] arrayOfString9 = { "not", "172" };
    String[] arrayOfString10 = { "shy", "173" };
    String[] arrayOfString11 = { "macr", "175" };
    String[] arrayOfString12 = { "deg", "176" };
    String[] arrayOfString13 = { "plusmn", "177" };
    String[] arrayOfString14 = { "sup2", "178" };
    String[] arrayOfString15 = { "middot", "183" };
    String[] arrayOfString16 = { "cedil", "184" };
    String[] arrayOfString17 = { "sup1", "185" };
    String[] arrayOfString18 = { "raquo", "187" };
    String[] arrayOfString19 = { "frac12", "189" };
    String[] arrayOfString20 = { "frac34", "190" };
    String[] arrayOfString21 = { "iquest", "191" };
    String[] arrayOfString22 = { "Agrave", "192" };
    String[] arrayOfString23 = { "Aacute", "193" };
    String[] arrayOfString24 = { "Acirc", "194" };
    String[] arrayOfString25 = { "Atilde", "195" };
    String[] arrayOfString26 = { "Auml", "196" };
    String[] arrayOfString27 = { "Aring", "197" };
    String[] arrayOfString28 = { "Egrave", "200" };
    String[] arrayOfString29 = { "Eacute", "201" };
    String[] arrayOfString30 = { "Ecirc", "202" };
    String[] arrayOfString31 = { "Euml", "203" };
    String[] arrayOfString32 = { "Iacute", "205" };
    String[] arrayOfString33 = { "Icirc", "206" };
    String[] arrayOfString34 = { "Iuml", "207" };
    String[] arrayOfString35 = { "Ntilde", "209" };
    String[] arrayOfString36 = { "Ograve", "210" };
    String[] arrayOfString37 = { "Ocirc", "212" };
    String[] arrayOfString38 = { "Otilde", "213" };
    String[] arrayOfString39 = { "Ouml", "214" };
    String[] arrayOfString40 = { "times", "215" };
    String[] arrayOfString41 = { "Ugrave", "217" };
    String[] arrayOfString42 = { "Uacute", "218" };
    String[] arrayOfString43 = { "Uuml", "220" };
    String[] arrayOfString44 = { "Yacute", "221" };
    String[] arrayOfString45 = { "szlig", "223" };
    String[] arrayOfString46 = { "aacute", "225" };
    String[] arrayOfString47 = { "atilde", "227" };
    String[] arrayOfString48 = { "auml", "228" };
    String[] arrayOfString49 = { "aring", "229" };
    String[] arrayOfString50 = { "aelig", "230" };
    String[] arrayOfString51 = { "ccedil", "231" };
    String[] arrayOfString52 = { "egrave", "232" };
    String[] arrayOfString53 = { "eacute", "233" };
    String[] arrayOfString54 = { "ecirc", "234" };
    String[] arrayOfString55 = { "euml", "235" };
    String[] arrayOfString56 = { "igrave", "236" };
    String[] arrayOfString57 = { "iacute", "237" };
    String[] arrayOfString58 = { "icirc", "238" };
    String[] arrayOfString59 = { "eth", "240" };
    String[] arrayOfString60 = { "ograve", "242" };
    String[] arrayOfString61 = { "oacute", "243" };
    String[] arrayOfString62 = { "divide", "247" };
    String[] arrayOfString63 = { "oslash", "248" };
    String[] arrayOfString64 = { "ugrave", "249" };
    String[] arrayOfString65 = { "uacute", "250" };
    String[] arrayOfString66 = { "ucirc", "251" };
    String[] arrayOfString67 = { "uuml", "252" };
    String[] arrayOfString68 = { "yacute", "253" };
    String[] arrayOfString69 = { "thorn", "254" };
    String[] arrayOfString70 = { "yuml", "255" };
    Oqn = new String[][] { localObject, arrayOfString1, { "cent", "162" }, { "pound", "163" }, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, { "ordf", "170" }, arrayOfString8, arrayOfString9, arrayOfString10, { "reg", "174" }, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, { "sup3", "179" }, { "acute", "180" }, { "micro", "181" }, { "para", "182" }, arrayOfString15, arrayOfString16, arrayOfString17, { "ordm", "186" }, arrayOfString18, { "frac14", "188" }, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, { "AElig", "198" }, { "Ccedil", "199" }, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, { "Igrave", "204" }, arrayOfString32, arrayOfString33, arrayOfString34, { "ETH", "208" }, arrayOfString35, arrayOfString36, { "Oacute", "211" }, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, { "Oslash", "216" }, arrayOfString41, arrayOfString42, { "Ucirc", "219" }, arrayOfString43, arrayOfString44, { "THORN", "222" }, arrayOfString45, { "agrave", "224" }, arrayOfString46, { "acirc", "226" }, arrayOfString47, arrayOfString48, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, { "iuml", "239" }, arrayOfString59, { "ntilde", "241" }, arrayOfString60, arrayOfString61, { "ocirc", "244" }, { "otilde", "245" }, { "ouml", "246" }, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70 };
    localObject = new String[] { "fnof", "402" };
    arrayOfString1 = new String[] { "Alpha", "913" };
    arrayOfString2 = new String[] { "Gamma", "915" };
    arrayOfString3 = new String[] { "Zeta", "918" };
    arrayOfString4 = new String[] { "Eta", "919" };
    arrayOfString5 = new String[] { "Theta", "920" };
    arrayOfString6 = new String[] { "Iota", "921" };
    arrayOfString7 = new String[] { "Nu", "925" };
    arrayOfString8 = new String[] { "Omicron", "927" };
    arrayOfString9 = new String[] { "Rho", "929" };
    arrayOfString10 = new String[] { "Sigma", "931" };
    arrayOfString11 = new String[] { "Tau", "932" };
    arrayOfString12 = new String[] { "Phi", "934" };
    arrayOfString13 = new String[] { "Chi", "935" };
    arrayOfString14 = new String[] { "Omega", "937" };
    arrayOfString15 = new String[] { "alpha", "945" };
    arrayOfString16 = new String[] { "beta", "946" };
    arrayOfString17 = new String[] { "gamma", "947" };
    arrayOfString18 = new String[] { "delta", "948" };
    arrayOfString19 = new String[] { "epsilon", "949" };
    arrayOfString20 = new String[] { "zeta", "950" };
    arrayOfString21 = new String[] { "eta", "951" };
    arrayOfString22 = new String[] { "theta", "952" };
    arrayOfString23 = new String[] { "iota", "953" };
    arrayOfString24 = new String[] { "kappa", "954" };
    arrayOfString25 = new String[] { "lambda", "955" };
    arrayOfString26 = new String[] { "mu", "956" };
    arrayOfString27 = new String[] { "nu", "957" };
    arrayOfString28 = new String[] { "xi", "958" };
    arrayOfString29 = new String[] { "pi", "960" };
    arrayOfString30 = new String[] { "rho", "961" };
    arrayOfString31 = new String[] { "sigmaf", "962" };
    arrayOfString32 = new String[] { "sigma", "963" };
    arrayOfString33 = new String[] { "tau", "964" };
    arrayOfString34 = new String[] { "upsilon", "965" };
    arrayOfString35 = new String[] { "phi", "966" };
    arrayOfString36 = new String[] { "psi", "968" };
    arrayOfString37 = new String[] { "omega", "969" };
    arrayOfString38 = new String[] { "upsih", "978" };
    arrayOfString39 = new String[] { "piv", "982" };
    arrayOfString40 = new String[] { "bull", "8226" };
    arrayOfString41 = new String[] { "hellip", "8230" };
    arrayOfString42 = new String[] { "prime", "8242" };
    arrayOfString43 = new String[] { "Prime", "8243" };
    arrayOfString44 = new String[] { "oline", "8254" };
    arrayOfString45 = new String[] { "frasl", "8260" };
    arrayOfString46 = new String[] { "weierp", "8472" };
    arrayOfString47 = new String[] { "image", "8465" };
    arrayOfString48 = new String[] { "trade", "8482" };
    arrayOfString49 = new String[] { "larr", "8592" };
    arrayOfString50 = new String[] { "uarr", "8593" };
    arrayOfString51 = new String[] { "darr", "8595" };
    arrayOfString52 = new String[] { "harr", "8596" };
    arrayOfString53 = new String[] { "lArr", "8656" };
    arrayOfString54 = new String[] { "uArr", "8657" };
    arrayOfString55 = new String[] { "rArr", "8658" };
    arrayOfString56 = new String[] { "dArr", "8659" };
    arrayOfString57 = new String[] { "hArr", "8660" };
    arrayOfString58 = new String[] { "part", "8706" };
    arrayOfString59 = new String[] { "exist", "8707" };
    arrayOfString60 = new String[] { "empty", "8709" };
    arrayOfString61 = new String[] { "nabla", "8711" };
    arrayOfString62 = new String[] { "isin", "8712" };
    arrayOfString63 = new String[] { "notin", "8713" };
    arrayOfString64 = new String[] { "prod", "8719" };
    arrayOfString65 = new String[] { "minus", "8722" };
    arrayOfString66 = new String[] { "lowast", "8727" };
    arrayOfString67 = new String[] { "radic", "8730" };
    arrayOfString68 = new String[] { "prop", "8733" };
    arrayOfString69 = new String[] { "ang", "8736" };
    arrayOfString70 = new String[] { "and", "8743" };
    String[] arrayOfString71 = { "or", "8744" };
    String[] arrayOfString72 = { "cup", "8746" };
    String[] arrayOfString73 = { "int", "8747" };
    String[] arrayOfString74 = { "there4", "8756" };
    String[] arrayOfString75 = { "sim", "8764" };
    String[] arrayOfString76 = { "cong", "8773" };
    String[] arrayOfString77 = { "asymp", "8776" };
    String[] arrayOfString78 = { "ge", "8805" };
    String[] arrayOfString79 = { "sub", "8834" };
    String[] arrayOfString80 = { "sup", "8835" };
    String[] arrayOfString81 = { "sube", "8838" };
    String[] arrayOfString82 = { "supe", "8839" };
    String[] arrayOfString83 = { "oplus", "8853" };
    String[] arrayOfString84 = { "otimes", "8855" };
    String[] arrayOfString85 = { "perp", "8869" };
    String[] arrayOfString86 = { "sdot", "8901" };
    String[] arrayOfString87 = { "lceil", "8968" };
    String[] arrayOfString88 = { "rfloor", "8971" };
    String[] arrayOfString89 = { "lang", "9001" };
    String[] arrayOfString90 = { "rang", "9002" };
    String[] arrayOfString91 = { "loz", "9674" };
    String[] arrayOfString92 = { "spades", "9824" };
    String[] arrayOfString93 = { "clubs", "9827" };
    String[] arrayOfString94 = { "hearts", "9829" };
    String[] arrayOfString95 = { "diams", "9830" };
    String[] arrayOfString96 = { "scaron", "353" };
    String[] arrayOfString97 = { "thinsp", "8201" };
    String[] arrayOfString98 = { "zwnj", "8204" };
    String[] arrayOfString99 = { "zwj", "8205" };
    String[] arrayOfString100 = { "rlm", "8207" };
    String[] arrayOfString101 = { "ndash", "8211" };
    String[] arrayOfString102 = { "lsquo", "8216" };
    String[] arrayOfString103 = { "rsquo", "8217" };
    String[] arrayOfString104 = { "sbquo", "8218" };
    String[] arrayOfString105 = { "ldquo", "8220" };
    String[] arrayOfString106 = { "bdquo", "8222" };
    String[] arrayOfString107 = { "permil", "8240" };
    String[] arrayOfString108 = { "lsaquo", "8249" };
    String[] arrayOfString109 = { "rsaquo", "8250" };
    String[] arrayOfString110 = { "euro", "8364" };
    Oqo = new String[][] { localObject, arrayOfString1, { "Beta", "914" }, arrayOfString2, { "Delta", "916" }, { "Epsilon", "917" }, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, { "Kappa", "922" }, { "Lambda", "923" }, { "Mu", "924" }, arrayOfString7, { "Xi", "926" }, arrayOfString8, { "Pi", "928" }, arrayOfString9, arrayOfString10, arrayOfString11, { "Upsilon", "933" }, arrayOfString12, arrayOfString13, { "Psi", "936" }, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, { "omicron", "959" }, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, { "chi", "967" }, arrayOfString36, arrayOfString37, { "thetasym", "977" }, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, arrayOfString47, { "real", "8476" }, arrayOfString48, { "alefsym", "8501" }, arrayOfString49, arrayOfString50, { "rarr", "8594" }, arrayOfString51, arrayOfString52, { "crarr", "8629" }, arrayOfString53, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, { "forall", "8704" }, arrayOfString58, arrayOfString59, arrayOfString60, arrayOfString61, arrayOfString62, arrayOfString63, { "ni", "8715" }, arrayOfString64, { "sum", "8721" }, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, { "infin", "8734" }, arrayOfString69, arrayOfString70, arrayOfString71, { "cap", "8745" }, arrayOfString72, arrayOfString73, arrayOfString74, arrayOfString75, arrayOfString76, arrayOfString77, { "ne", "8800" }, { "equiv", "8801" }, { "le", "8804" }, arrayOfString78, arrayOfString79, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83, arrayOfString84, arrayOfString85, arrayOfString86, arrayOfString87, { "rceil", "8969" }, { "lfloor", "8970" }, arrayOfString88, arrayOfString89, arrayOfString90, arrayOfString91, arrayOfString92, arrayOfString93, arrayOfString94, arrayOfString95, { "OElig", "338" }, { "oelig", "339" }, { "Scaron", "352" }, arrayOfString96, { "Yuml", "376" }, { "circ", "710" }, { "tilde", "732" }, { "ensp", "8194" }, { "emsp", "8195" }, arrayOfString97, arrayOfString98, arrayOfString99, { "lrm", "8206" }, arrayOfString100, arrayOfString101, { "mdash", "8212" }, arrayOfString102, arrayOfString103, arrayOfString104, arrayOfString105, { "rdquo", "8221" }, arrayOfString106, { "dagger", "8224" }, { "Dagger", "8225" }, arrayOfString107, arrayOfString108, arrayOfString109, arrayOfString110 };
    localObject = new c();
    ((c)localObject).a(Oql);
    ((c)localObject).a(Oqm);
    Oqp = (c)localObject;
    localObject = new c();
    ((c)localObject).a(Oql);
    ((c)localObject).a(Oqn);
    Oqq = (c)localObject;
    localObject = new c();
    ((c)localObject).a(Oql);
    ((c)localObject).a(Oqn);
    ((c)localObject).a(Oqo);
    Oqr = (c)localObject;
    AppMethodBeat.o(40711);
  }
  
  public c()
  {
    AppMethodBeat.i(40707);
    this.Oqs = new b();
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
        paramInt = this.Oqs.bfn(str);
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
      this.Oqs.i(str, j);
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
    public abstract int bfn(String paramString);
    
    public abstract void i(String paramString, int paramInt);
  }
  
  static final class b
    extends c.c
  {}
  
  static class c
    implements c.a
  {
    private final Map Oqt;
    private final d Oqu;
    
    c()
    {
      AppMethodBeat.i(40704);
      this.Oqt = new HashMap();
      this.Oqu = new d();
      AppMethodBeat.o(40704);
    }
    
    public final int bfn(String paramString)
    {
      AppMethodBeat.i(40706);
      paramString = this.Oqt.get(paramString);
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
      this.Oqt.put(paramString, Integer.valueOf(paramInt));
      this.Oqu.d(paramInt, paramString);
      AppMethodBeat.o(40705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.c
 * JD-Core Version:    0.7.0.1
 */