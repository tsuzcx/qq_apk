package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public final class fd
{
  public static final eb<StringBuffer> A;
  public static final ec B;
  public static final eb<URL> C;
  public static final ec D;
  public static final eb<URI> E;
  public static final ec F;
  public static final eb<InetAddress> G;
  public static final ec H;
  public static final eb<UUID> I;
  public static final ec J;
  public static final ec K;
  public static final eb<Calendar> L;
  public static final ec M;
  public static final eb<Locale> N;
  public static final ec O;
  public static final eb<dq> P;
  public static final ec Q;
  public static final ec R;
  public static final eb<Class> a;
  public static final ec b;
  public static final eb<BitSet> c;
  public static final ec d;
  public static final eb<Boolean> e;
  public static final eb<Boolean> f;
  public static final ec g;
  public static final eb<Number> h;
  public static final ec i;
  public static final eb<Number> j;
  public static final ec k;
  public static final eb<Number> l;
  public static final ec m;
  public static final eb<Number> n;
  public static final eb<Number> o;
  public static final eb<Number> p;
  public static final eb<Number> q;
  public static final ec r;
  public static final eb<Character> s;
  public static final ec t;
  public static final eb<String> u;
  public static final eb<BigDecimal> v;
  public static final eb<BigInteger> w;
  public static final ec x;
  public static final eb<StringBuilder> y;
  public static final ec z;
  
  static
  {
    AppMethodBeat.i(147866);
    a = new fd.1();
    b = a(Class.class, a);
    c = new fd.12();
    d = a(BitSet.class, c);
    e = new eb()
    {
      public final Boolean a(ff paramAnonymousff)
      {
        AppMethodBeat.i(147794);
        if (paramAnonymousff.f() == fg.i)
        {
          paramAnonymousff.j();
          AppMethodBeat.o(147794);
          return null;
        }
        if (paramAnonymousff.f() == fg.f)
        {
          bool = Boolean.parseBoolean(paramAnonymousff.h());
          AppMethodBeat.o(147794);
          return Boolean.valueOf(bool);
        }
        boolean bool = paramAnonymousff.i();
        AppMethodBeat.o(147794);
        return Boolean.valueOf(bool);
      }
      
      public final void a(fh paramAnonymousfh, Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(147795);
        if (paramAnonymousBoolean == null)
        {
          paramAnonymousfh.f();
          AppMethodBeat.o(147795);
          return;
        }
        paramAnonymousfh.a(paramAnonymousBoolean.booleanValue());
        AppMethodBeat.o(147795);
      }
    };
    f = new fd.27();
    g = a(Boolean.TYPE, Boolean.class, e);
    h = new fd.28();
    i = a(Byte.TYPE, Byte.class, h);
    j = new fd.29();
    k = a(Short.TYPE, Short.class, j);
    l = new fd.30();
    m = a(Integer.TYPE, Integer.class, l);
    n = new fd.31();
    o = new fd.32();
    p = new fd.2();
    q = new fd.3();
    r = a(Number.class, q);
    s = new fd.4();
    t = a(Character.TYPE, Character.class, s);
    u = new fd.5();
    v = new fd.6();
    w = new fd.7();
    x = a(String.class, u);
    y = new fd.8();
    z = a(StringBuilder.class, y);
    A = new eb()
    {
      public final StringBuffer a(ff paramAnonymousff)
      {
        AppMethodBeat.i(147851);
        if (paramAnonymousff.f() == fg.i)
        {
          paramAnonymousff.j();
          AppMethodBeat.o(147851);
          return null;
        }
        paramAnonymousff = new StringBuffer(paramAnonymousff.h());
        AppMethodBeat.o(147851);
        return paramAnonymousff;
      }
      
      public final void a(fh paramAnonymousfh, StringBuffer paramAnonymousStringBuffer)
      {
        AppMethodBeat.i(147852);
        if (paramAnonymousStringBuffer == null) {}
        for (paramAnonymousStringBuffer = null;; paramAnonymousStringBuffer = paramAnonymousStringBuffer.toString())
        {
          paramAnonymousfh.b(paramAnonymousStringBuffer);
          AppMethodBeat.o(147852);
          return;
        }
      }
    };
    B = a(StringBuffer.class, A);
    C = new fd.10();
    D = a(URL.class, C);
    E = new eb()
    {
      public final URI a(ff paramAnonymousff)
      {
        AppMethodBeat.i(147751);
        if (paramAnonymousff.f() == fg.i)
        {
          paramAnonymousff.j();
          AppMethodBeat.o(147751);
          return null;
        }
        try
        {
          paramAnonymousff = paramAnonymousff.h();
          if ("null".equals(paramAnonymousff))
          {
            AppMethodBeat.o(147751);
            return null;
          }
        }
        catch (URISyntaxException paramAnonymousff)
        {
          paramAnonymousff = new dr(paramAnonymousff);
          AppMethodBeat.o(147751);
          throw paramAnonymousff;
        }
        paramAnonymousff = new URI(paramAnonymousff);
        AppMethodBeat.o(147751);
        return paramAnonymousff;
      }
      
      public final void a(fh paramAnonymousfh, URI paramAnonymousURI)
      {
        AppMethodBeat.i(147752);
        if (paramAnonymousURI == null) {}
        for (paramAnonymousURI = null;; paramAnonymousURI = paramAnonymousURI.toASCIIString())
        {
          paramAnonymousfh.b(paramAnonymousURI);
          AppMethodBeat.o(147752);
          return;
        }
      }
    };
    F = a(URI.class, E);
    G = new fd.13();
    H = b(InetAddress.class, G);
    I = new fd.14();
    J = a(UUID.class, I);
    K = new fd.15();
    L = new fd.16();
    M = b(Calendar.class, GregorianCalendar.class, L);
    N = new fd.17();
    O = a(Locale.class, N);
    P = new fd.18();
    Q = b(dq.class, P);
    R = a();
    AppMethodBeat.o(147866);
  }
  
  public static ec a()
  {
    AppMethodBeat.i(147860);
    fd.19 local19 = new fd.19();
    AppMethodBeat.o(147860);
    return local19;
  }
  
  public static <TT> ec a(fe<TT> paramfe, eb<TT> parameb)
  {
    AppMethodBeat.i(147861);
    paramfe = new fd.20(paramfe, parameb);
    AppMethodBeat.o(147861);
    return paramfe;
  }
  
  public static <TT> ec a(Class<TT> paramClass, eb<TT> parameb)
  {
    AppMethodBeat.i(147862);
    paramClass = new fd.21(paramClass, parameb);
    AppMethodBeat.o(147862);
    return paramClass;
  }
  
  public static <TT> ec a(Class<TT> paramClass1, Class<TT> paramClass2, eb<? super TT> parameb)
  {
    AppMethodBeat.i(147863);
    paramClass1 = new fd.22(paramClass1, paramClass2, parameb);
    AppMethodBeat.o(147863);
    return paramClass1;
  }
  
  public static <TT> ec b(Class<TT> paramClass, final eb<TT> parameb)
  {
    AppMethodBeat.i(147865);
    paramClass = new ec()
    {
      public final <T> eb<T> a(dk paramAnonymousdk, fe<T> paramAnonymousfe)
      {
        AppMethodBeat.i(147800);
        if (this.a.isAssignableFrom(paramAnonymousfe.a()))
        {
          paramAnonymousdk = parameb;
          AppMethodBeat.o(147800);
          return paramAnonymousdk;
        }
        AppMethodBeat.o(147800);
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(147801);
        String str = "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + parameb + "]";
        AppMethodBeat.o(147801);
        return str;
      }
    };
    AppMethodBeat.o(147865);
    return paramClass;
  }
  
  public static <TT> ec b(Class<TT> paramClass, final Class<? extends TT> paramClass1, final eb<? super TT> parameb)
  {
    AppMethodBeat.i(147864);
    paramClass = new ec()
    {
      public final <T> eb<T> a(dk paramAnonymousdk, fe<T> paramAnonymousfe)
      {
        AppMethodBeat.i(147798);
        paramAnonymousdk = paramAnonymousfe.a();
        if ((paramAnonymousdk == this.a) || (paramAnonymousdk == paramClass1))
        {
          paramAnonymousdk = parameb;
          AppMethodBeat.o(147798);
          return paramAnonymousdk;
        }
        AppMethodBeat.o(147798);
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(147799);
        String str = "Factory[type=" + this.a.getName() + "+" + paramClass1.getName() + ",adapter=" + parameb + "]";
        AppMethodBeat.o(147799);
        return str;
      }
    };
    AppMethodBeat.o(147864);
    return paramClass;
  }
  
  static final class a<T extends Enum<T>>
    extends eb<T>
  {
    private final Map<String, T> a;
    private final Map<T, String> b;
    
    public a(Class<T> paramClass)
    {
      AppMethodBeat.i(147855);
      this.a = new HashMap();
      this.b = new HashMap();
      for (;;)
      {
        try
        {
          Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
          int j = arrayOfEnum.length;
          int i = 0;
          if (i < j)
          {
            Enum localEnum = arrayOfEnum[i];
            String str = localEnum.name();
            ee localee = (ee)paramClass.getField(str).getAnnotation(ee.class);
            if (localee != null)
            {
              str = localee.a();
              this.a.put(str, localEnum);
              this.b.put(localEnum, str);
              i += 1;
            }
          }
          else
          {
            AppMethodBeat.o(147855);
            return;
          }
        }
        catch (NoSuchFieldException paramClass)
        {
          paramClass = new AssertionError();
          AppMethodBeat.o(147855);
          throw paramClass;
        }
      }
    }
    
    public final T a(ff paramff)
    {
      AppMethodBeat.i(147856);
      if (paramff.f() == fg.i)
      {
        paramff.j();
        AppMethodBeat.o(147856);
        return null;
      }
      paramff = (Enum)this.a.get(paramff.h());
      AppMethodBeat.o(147856);
      return paramff;
    }
    
    public final void a(fh paramfh, T paramT)
    {
      AppMethodBeat.i(147857);
      if (paramT == null) {}
      for (paramT = null;; paramT = (String)this.b.get(paramT))
      {
        paramfh.b(paramT);
        AppMethodBeat.o(147857);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd
 * JD-Core Version:    0.7.0.1
 */