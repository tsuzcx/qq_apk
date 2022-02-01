package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.f;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.c;

public final class r
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final List<String> ajMU;
  public final List<String> ajMV;
  private final String ajMW;
  private final String hPy;
  public final String host;
  public final int port;
  public final String scheme;
  private final String url;
  private final String username;
  
  r(a parama)
  {
    AppMethodBeat.i(186647);
    this.scheme = parama.scheme;
    this.username = eY(parama.ajMX, false);
    this.hPy = eY(parama.ajMY, false);
    this.host = parama.host;
    this.port = parama.kGT();
    this.ajMU = S(parama.ajMZ, false);
    if (parama.ajNa != null) {}
    for (Object localObject1 = S(parama.ajNa, true);; localObject1 = null)
    {
      this.ajMV = ((List)localObject1);
      localObject1 = localObject2;
      if (parama.ajNb != null) {
        localObject1 = eY(parama.ajNb, false);
      }
      this.ajMW = ((String)localObject1);
      this.url = parama.toString();
      AppMethodBeat.o(186647);
      return;
    }
  }
  
  private static List<String> S(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(186696);
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    if (i < j)
    {
      String str = (String)paramList.get(i);
      if (str != null) {}
      for (str = eY(str, paramBoolean);; str = null)
      {
        localArrayList.add(str);
        i += 1;
        break;
      }
    }
    paramList = Collections.unmodifiableList(localArrayList);
    AppMethodBeat.o(186696);
    return paramList;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(186753);
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString1.codePointAt(i);
      if ((j < 32) || (j == 127) || ((j >= 128) && (paramBoolean4)) || (paramString2.indexOf(j) != -1) || ((j == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!bq(paramString1, i, paramInt2))))) || ((j == 43) && (paramBoolean3)))
      {
        f localf = new f();
        localf.bB(paramString1, paramInt1, i);
        Object localObject1 = null;
        paramInt1 = i;
        if (paramInt1 < paramInt2)
        {
          i = paramString1.codePointAt(paramInt1);
          Object localObject3;
          Object localObject2;
          if (paramBoolean1)
          {
            localObject3 = localObject1;
            if (i != 9)
            {
              localObject3 = localObject1;
              if (i != 10)
              {
                localObject3 = localObject1;
                if (i != 12)
                {
                  localObject3 = localObject1;
                  if (i == 13) {}
                }
              }
            }
          }
          else
          {
            if ((i != 43) || (!paramBoolean3)) {
              break label239;
            }
            if (!paramBoolean1) {
              break label232;
            }
            localObject2 = "+";
            label205:
            localf.bKQ((String)localObject2);
            localObject3 = localObject1;
          }
          for (;;)
          {
            paramInt1 = Character.charCount(i) + paramInt1;
            localObject1 = localObject3;
            break;
            label232:
            localObject2 = "%2B";
            break label205;
            label239:
            if ((i < 32) || (i == 127) || ((i >= 128) && (paramBoolean4)) || (paramString2.indexOf(i) != -1) || ((i == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!bq(paramString1, paramInt1, paramInt2))))))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new f();
              }
              ((f)localObject2).aNf(i);
              for (;;)
              {
                localObject3 = localObject2;
                if (((f)localObject2).kIy()) {
                  break;
                }
                j = ((f)localObject2).readByte() & 0xFF;
                localf.aNg(37);
                localf.aNg(HEX_DIGITS[(j >> 4 & 0xF)]);
                localf.aNg(HEX_DIGITS[(j & 0xF)]);
              }
            }
            localf.aNf(i);
            localObject3 = localObject1;
          }
        }
        paramString1 = localf.kIG();
        AppMethodBeat.o(186753);
        return paramString1;
      }
      i += Character.charCount(j);
    }
    paramString1 = paramString1.substring(paramInt1, paramInt2);
    AppMethodBeat.o(186753);
    return paramString1;
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(186761);
    paramString1 = a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    AppMethodBeat.o(186761);
    return paramString1;
  }
  
  private static void a(f paramf, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(186721);
    if (paramInt1 < paramInt2)
    {
      int i = paramString.codePointAt(paramInt1);
      if ((i == 37) && (paramInt1 + 2 < paramInt2))
      {
        int j = c.N(paramString.charAt(paramInt1 + 1));
        int k = c.N(paramString.charAt(paramInt1 + 2));
        if ((j == -1) || (k == -1)) {
          break label116;
        }
        paramf.aNg((j << 4) + k);
        paramInt1 += 2;
      }
      for (;;)
      {
        paramInt1 += Character.charCount(i);
        break;
        if ((i == 43) && (paramBoolean)) {
          paramf.aNg(32);
        } else {
          label116:
          paramf.aNf(i);
        }
      }
    }
    AppMethodBeat.o(186721);
  }
  
  public static int bKo(String paramString)
  {
    AppMethodBeat.i(186650);
    if (paramString.equals("http"))
    {
      AppMethodBeat.o(186650);
      return 80;
    }
    if (paramString.equals("https"))
    {
      AppMethodBeat.o(186650);
      return 443;
    }
    AppMethodBeat.o(186650);
    return -1;
  }
  
  static List<String> bKp(String paramString)
  {
    AppMethodBeat.i(186671);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i <= paramString.length())
    {
      int k = paramString.indexOf('&', i);
      int j = k;
      if (k == -1) {
        j = paramString.length();
      }
      k = paramString.indexOf('=', i);
      if ((k == -1) || (k > j))
      {
        localArrayList.add(paramString.substring(i, j));
        localArrayList.add(null);
      }
      for (;;)
      {
        i = j + 1;
        break;
        localArrayList.add(paramString.substring(i, k));
        localArrayList.add(paramString.substring(k + 1, j));
      }
    }
    AppMethodBeat.o(186671);
    return localArrayList;
  }
  
  public static r bKr(String paramString)
  {
    AppMethodBeat.i(186677);
    paramString = new a().a(null, paramString).kGU();
    AppMethodBeat.o(186677);
    return paramString;
  }
  
  private static boolean bq(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186731);
    if ((paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (c.N(paramString.charAt(paramInt1 + 1)) != -1) && (c.N(paramString.charAt(paramInt1 + 2)) != -1))
    {
      AppMethodBeat.o(186731);
      return true;
    }
    AppMethodBeat.o(186731);
    return false;
  }
  
  static void d(StringBuilder paramStringBuilder, List<String> paramList)
  {
    AppMethodBeat.i(186655);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(186655);
  }
  
  public static void e(StringBuilder paramStringBuilder, List<String> paramList)
  {
    AppMethodBeat.i(186660);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str1 = (String)paramList.get(i);
      String str2 = (String)paramList.get(i + 1);
      if (i > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      i += 2;
    }
    AppMethodBeat.o(186660);
  }
  
  private static String eY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(186685);
    paramString = g(paramString, 0, paramString.length(), paramBoolean);
    AppMethodBeat.o(186685);
    return paramString;
  }
  
  static String g(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(186707);
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString.charAt(i);
      if ((j == 37) || ((j == 43) && (paramBoolean)))
      {
        f localf = new f();
        localf.bB(paramString, paramInt1, i);
        a(localf, paramString, i, paramInt2, paramBoolean);
        paramString = localf.kIG();
        AppMethodBeat.o(186707);
        return paramString;
      }
      i += 1;
    }
    paramString = paramString.substring(paramInt1, paramInt2);
    AppMethodBeat.o(186707);
    return paramString;
  }
  
  public final a bKq(String paramString)
  {
    AppMethodBeat.i(186840);
    try
    {
      paramString = new a().a(this, paramString);
      AppMethodBeat.o(186840);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(186840);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186851);
    if (((paramObject instanceof r)) && (((r)paramObject).url.equals(this.url)))
    {
      AppMethodBeat.o(186851);
      return true;
    }
    AppMethodBeat.o(186851);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186855);
    int i = this.url.hashCode();
    AppMethodBeat.o(186855);
    return i;
  }
  
  public final boolean isHttps()
  {
    AppMethodBeat.i(186795);
    boolean bool = this.scheme.equals("https");
    AppMethodBeat.o(186795);
    return bool;
  }
  
  public final URI kGN()
  {
    AppMethodBeat.i(186789);
    Object localObject2 = new a();
    ((a)localObject2).scheme = this.scheme;
    ((a)localObject2).ajMX = kGO();
    ((a)localObject2).ajMY = kGP();
    ((a)localObject2).host = this.host;
    int i;
    if (this.port != bKo(this.scheme))
    {
      i = this.port;
      ((a)localObject2).port = i;
      ((a)localObject2).ajMZ.clear();
      ((a)localObject2).ajMZ.addAll(kGR());
      ((a)localObject2).bKs(kGS());
      if (this.ajMW != null) {
        break label194;
      }
    }
    int j;
    for (Object localObject1 = null;; localObject1 = this.url.substring(i + 1))
    {
      ((a)localObject2).ajNb = ((String)localObject1);
      j = ((a)localObject2).ajMZ.size();
      i = 0;
      while (i < j)
      {
        localObject1 = (String)((a)localObject2).ajMZ.get(i);
        ((a)localObject2).ajMZ.set(i, a((String)localObject1, "[]", true, true, false, true));
        i += 1;
      }
      i = -1;
      break;
      label194:
      i = this.url.indexOf('#');
    }
    if (((a)localObject2).ajNa != null)
    {
      j = ((a)localObject2).ajNa.size();
      i = 0;
      while (i < j)
      {
        localObject1 = (String)((a)localObject2).ajNa.get(i);
        if (localObject1 != null) {
          ((a)localObject2).ajNa.set(i, a((String)localObject1, "\\^`{|}", true, true, true, true));
        }
        i += 1;
      }
    }
    if (((a)localObject2).ajNb != null) {
      ((a)localObject2).ajNb = a(((a)localObject2).ajNb, " \"#<>\\^`{|}", true, true, false, false);
    }
    localObject2 = ((a)localObject2).toString();
    try
    {
      localObject1 = new URI((String)localObject2);
      AppMethodBeat.o(186789);
      return localObject1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        localObject2 = URI.create(((String)localObject2).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        AppMethodBeat.o(186789);
        return localObject2;
      }
      catch (Exception localException)
      {
        RuntimeException localRuntimeException = new RuntimeException(localURISyntaxException);
        AppMethodBeat.o(186789);
        throw localRuntimeException;
      }
    }
  }
  
  public final String kGO()
  {
    AppMethodBeat.i(186808);
    if (this.username.isEmpty())
    {
      AppMethodBeat.o(186808);
      return "";
    }
    int i = this.scheme.length() + 3;
    String str = this.url;
    int j = c.u(str, i, str.length(), ":@");
    str = this.url.substring(i, j);
    AppMethodBeat.o(186808);
    return str;
  }
  
  public final String kGP()
  {
    AppMethodBeat.i(186816);
    if (this.hPy.isEmpty())
    {
      AppMethodBeat.o(186816);
      return "";
    }
    int i = this.url.indexOf(':', this.scheme.length() + 3);
    int j = this.url.indexOf('@');
    String str = this.url.substring(i + 1, j);
    AppMethodBeat.o(186816);
    return str;
  }
  
  public final String kGQ()
  {
    AppMethodBeat.i(186823);
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    String str = this.url;
    int j = c.u(str, i, str.length(), "?#");
    str = this.url.substring(i, j);
    AppMethodBeat.o(186823);
    return str;
  }
  
  public final List<String> kGR()
  {
    AppMethodBeat.i(186833);
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    Object localObject = this.url;
    int j = c.u((String)localObject, i, ((String)localObject).length(), "?#");
    localObject = new ArrayList();
    while (i < j)
    {
      int k = i + 1;
      i = c.a(this.url, k, j, '/');
      ((List)localObject).add(this.url.substring(k, i));
    }
    AppMethodBeat.o(186833);
    return localObject;
  }
  
  public final String kGS()
  {
    AppMethodBeat.i(186838);
    if (this.ajMV == null)
    {
      AppMethodBeat.o(186838);
      return null;
    }
    int i = this.url.indexOf('?') + 1;
    String str = this.url;
    int j = c.a(str, i, str.length(), '#');
    str = this.url.substring(i, j);
    AppMethodBeat.o(186838);
    return str;
  }
  
  public final String toString()
  {
    return this.url;
  }
  
  public static final class a
  {
    String ajMX;
    String ajMY;
    final List<String> ajMZ;
    List<String> ajNa;
    String ajNb;
    String host;
    int port;
    String scheme;
    
    public a()
    {
      AppMethodBeat.i(186557);
      this.ajMX = "";
      this.ajMY = "";
      this.port = -1;
      this.ajMZ = new ArrayList();
      this.ajMZ.add("");
      AppMethodBeat.o(186557);
    }
    
    private void br(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186565);
      if (paramInt1 == paramInt2)
      {
        AppMethodBeat.o(186565);
        return;
      }
      int i = paramString.charAt(paramInt1);
      int j;
      label86:
      String str;
      label169:
      if ((i == 47) || (i == 92))
      {
        this.ajMZ.clear();
        this.ajMZ.add("");
        paramInt1 += 1;
        if (paramInt1 >= paramInt2) {
          break label397;
        }
        j = c.u(paramString, paramInt1, paramInt2, "/\\");
        if (j >= paramInt2) {
          break label279;
        }
        i = 1;
        str = r.a(paramString, paramInt1, j, " \"<>^`{}|/\\?#", true, false, false, true);
        if ((!str.equals(".")) && (!str.equalsIgnoreCase("%2e"))) {
          break label285;
        }
        paramInt1 = 1;
        label123:
        if (paramInt1 == 0)
        {
          if ((!str.equals("..")) && (!str.equalsIgnoreCase("%2e.")) && (!str.equalsIgnoreCase(".%2e")) && (!str.equalsIgnoreCase("%2e%2e"))) {
            break label290;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label310;
          }
          if ((!((String)this.ajMZ.remove(this.ajMZ.size() - 1)).isEmpty()) || (this.ajMZ.isEmpty())) {
            break label295;
          }
          this.ajMZ.set(this.ajMZ.size() - 1, "");
        }
      }
      label395:
      for (;;)
      {
        paramInt1 = j;
        if (i != 0) {
          paramInt1 = j + 1;
        }
        break;
        this.ajMZ.set(this.ajMZ.size() - 1, "");
        break;
        label279:
        i = 0;
        break label86;
        label285:
        paramInt1 = 0;
        break label123;
        label290:
        paramInt1 = 0;
        break label169;
        label295:
        this.ajMZ.add("");
        continue;
        label310:
        if (((String)this.ajMZ.get(this.ajMZ.size() - 1)).isEmpty()) {
          this.ajMZ.set(this.ajMZ.size() - 1, str);
        }
        for (;;)
        {
          if (i == 0) {
            break label395;
          }
          this.ajMZ.add("");
          break;
          this.ajMZ.add(str);
        }
      }
      label397:
      AppMethodBeat.o(186565);
    }
    
    private static int bs(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186573);
      if (paramInt2 - paramInt1 < 2)
      {
        AppMethodBeat.o(186573);
        return -1;
      }
      int i = paramString.charAt(paramInt1);
      if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)))
      {
        AppMethodBeat.o(186573);
        return -1;
      }
      paramInt1 += 1;
      while (paramInt1 < paramInt2)
      {
        i = paramString.charAt(paramInt1);
        if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && ((i < 48) || (i > 57)) && (i != 43) && (i != 45) && (i != 46))
        {
          if (i == 58)
          {
            AppMethodBeat.o(186573);
            return paramInt1;
          }
          AppMethodBeat.o(186573);
          return -1;
        }
        paramInt1 += 1;
      }
      AppMethodBeat.o(186573);
      return -1;
    }
    
    private static int bt(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186580);
      int i = 0;
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if ((j != 92) && (j != 47)) {
          break;
        }
        i += 1;
        paramInt1 += 1;
      }
      AppMethodBeat.o(186580);
      return i;
    }
    
    private static int bu(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186589);
      if (paramInt1 < paramInt2)
      {
        int i = paramInt1;
        switch (paramString.charAt(paramInt1))
        {
        default: 
          i = paramInt1;
        case '[': 
          for (;;)
          {
            paramInt1 = i + 1;
            break;
            do
            {
              paramInt1 = i + 1;
              i = paramInt1;
              if (paramInt1 >= paramInt2) {
                break;
              }
              i = paramInt1;
            } while (paramString.charAt(paramInt1) != ']');
            i = paramInt1;
          }
        }
        AppMethodBeat.o(186589);
        return paramInt1;
      }
      AppMethodBeat.o(186589);
      return paramInt2;
    }
    
    static String bv(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186599);
      paramString = c.bKy(r.g(paramString, paramInt1, paramInt2, false));
      AppMethodBeat.o(186599);
      return paramString;
    }
    
    private static int bw(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186606);
      try
      {
        paramInt1 = Integer.parseInt(r.a(paramString, paramInt1, paramInt2, "", false, false, false, true));
        if ((paramInt1 > 0) && (paramInt1 <= 65535))
        {
          AppMethodBeat.o(186606);
          return paramInt1;
        }
        AppMethodBeat.o(186606);
        return -1;
      }
      catch (NumberFormatException paramString)
      {
        AppMethodBeat.o(186606);
      }
      return -1;
    }
    
    final a a(r paramr, String paramString)
    {
      AppMethodBeat.i(186692);
      int i = c.bx(paramString, 0, paramString.length());
      int i1 = c.by(paramString, i, paramString.length());
      int j = bs(paramString, i, i1);
      label66:
      int k;
      int n;
      if (j != -1) {
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.scheme = "https";
          i += 6;
          j = 0;
          k = 0;
          m = bt(paramString, i, i1);
          if ((m < 2) && (paramr != null) && (paramr.scheme.equals(this.scheme))) {
            break label776;
          }
          m = i + m;
          i = k;
          k = m;
          n = c.u(paramString, k, i1, "@/\\?#");
          if (n == i1) {
            break label400;
          }
        }
      }
      label400:
      for (int m = paramString.charAt(n);; m = -1) {
        switch (m)
        {
        default: 
          break;
        case -1: 
        case 35: 
        case 47: 
        case 63: 
        case 92: 
          i = bu(paramString, k, n);
          if (i + 1 >= n) {
            break label588;
          }
          this.host = bv(paramString, k, i);
          this.port = bw(paramString, i + 1, n);
          if (this.port != -1) {
            break label610;
          }
          paramr = new IllegalArgumentException("Invalid URL port: \"" + paramString.substring(i + 1, n) + '"');
          AppMethodBeat.o(186692);
          throw paramr;
          if (paramString.regionMatches(true, i, "http:", 0, 5))
          {
            this.scheme = "http";
            i += 5;
            break label66;
          }
          paramr = new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + paramString.substring(0, j) + "'");
          AppMethodBeat.o(186692);
          throw paramr;
          if (paramr != null)
          {
            this.scheme = paramr.scheme;
            break label66;
          }
          paramr = new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
          AppMethodBeat.o(186692);
          throw paramr;
        }
      }
      if (i == 0)
      {
        m = c.a(paramString, k, n, ':');
        String str = r.a(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
        paramr = str;
        if (j != 0) {
          paramr = this.ajMX + "%40" + str;
        }
        this.ajMX = paramr;
        if (m != n)
        {
          i = 1;
          this.ajMY = r.a(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
        }
        j = i;
      }
      for (i = 1;; i = k)
      {
        k = n + 1;
        m = i;
        i = j;
        j = m;
        break;
        this.ajMY = (this.ajMY + "%40" + r.a(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
        k = j;
        j = i;
      }
      label588:
      this.host = bv(paramString, k, i);
      this.port = r.bKo(this.scheme);
      label610:
      if (this.host == null)
      {
        paramr = new IllegalArgumentException("Invalid URL host: \"" + paramString.substring(k, i) + '"');
        AppMethodBeat.o(186692);
        throw paramr;
      }
      j = n;
      i = c.u(paramString, j, i1, "?#");
      br(paramString, j, i);
      if ((i < i1) && (paramString.charAt(i) == '?'))
      {
        j = c.a(paramString, i, i1, '#');
        this.ajNa = r.bKp(r.a(paramString, i + 1, j, " \"'<>#", true, false, true, true));
        i = j;
      }
      for (;;)
      {
        if ((i < i1) && (paramString.charAt(i) == '#')) {
          this.ajNb = r.a(paramString, i + 1, i1, "", true, false, false, false);
        }
        AppMethodBeat.o(186692);
        return this;
        label776:
        this.ajMX = paramr.kGO();
        this.ajMY = paramr.kGP();
        this.host = paramr.host;
        this.port = paramr.port;
        this.ajMZ.clear();
        this.ajMZ.addAll(paramr.kGR());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {
            break;
          }
        }
        bKs(paramr.kGS());
        j = i;
        break;
      }
    }
    
    public final a bKs(String paramString)
    {
      AppMethodBeat.i(186616);
      if (paramString != null) {}
      for (paramString = r.bKp(r.a(paramString, " \"'<>#", true, false, true, true));; paramString = null)
      {
        this.ajNa = paramString;
        AppMethodBeat.o(186616);
        return this;
      }
    }
    
    final int kGT()
    {
      AppMethodBeat.i(186611);
      if (this.port != -1)
      {
        i = this.port;
        AppMethodBeat.o(186611);
        return i;
      }
      int i = r.bKo(this.scheme);
      AppMethodBeat.o(186611);
      return i;
    }
    
    public final r kGU()
    {
      AppMethodBeat.i(186622);
      if (this.scheme == null)
      {
        localObject = new IllegalStateException("scheme == null");
        AppMethodBeat.o(186622);
        throw ((Throwable)localObject);
      }
      if (this.host == null)
      {
        localObject = new IllegalStateException("host == null");
        AppMethodBeat.o(186622);
        throw ((Throwable)localObject);
      }
      Object localObject = new r(this);
      AppMethodBeat.o(186622);
      return localObject;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(186645);
      Object localObject = new StringBuilder();
      if (this.scheme != null)
      {
        ((StringBuilder)localObject).append(this.scheme);
        ((StringBuilder)localObject).append("://");
        if ((!this.ajMX.isEmpty()) || (!this.ajMY.isEmpty()))
        {
          ((StringBuilder)localObject).append(this.ajMX);
          if (!this.ajMY.isEmpty())
          {
            ((StringBuilder)localObject).append(':');
            ((StringBuilder)localObject).append(this.ajMY);
          }
          ((StringBuilder)localObject).append('@');
        }
        if (this.host != null)
        {
          if (this.host.indexOf(':') == -1) {
            break label271;
          }
          ((StringBuilder)localObject).append('[');
          ((StringBuilder)localObject).append(this.host);
          ((StringBuilder)localObject).append(']');
        }
      }
      for (;;)
      {
        if ((this.port != -1) || (this.scheme != null))
        {
          int i = kGT();
          if ((this.scheme == null) || (i != r.bKo(this.scheme)))
          {
            ((StringBuilder)localObject).append(':');
            ((StringBuilder)localObject).append(i);
          }
        }
        r.d((StringBuilder)localObject, this.ajMZ);
        if (this.ajNa != null)
        {
          ((StringBuilder)localObject).append('?');
          r.e((StringBuilder)localObject, this.ajNa);
        }
        if (this.ajNb != null)
        {
          ((StringBuilder)localObject).append('#');
          ((StringBuilder)localObject).append(this.ajNb);
        }
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(186645);
        return localObject;
        ((StringBuilder)localObject).append("//");
        break;
        label271:
        ((StringBuilder)localObject).append(this.host);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.r
 * JD-Core Version:    0.7.0.1
 */