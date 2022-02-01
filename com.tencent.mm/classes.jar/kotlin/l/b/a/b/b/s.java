package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.a.ar;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.j.g.a.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.n.g.a;
import kotlin.l.b.a.b.o.a;

public final class s
{
  public static final t aiGC;
  public static final t aiGD;
  public static final t aiGE;
  public static final t aiGF;
  public static final t aiGG;
  public static final t aiGH;
  public static final t aiGI;
  public static final t aiGJ;
  public static final t aiGK;
  public static final Set<t> aiGL;
  private static final Map<t, Integer> aiGM;
  public static final t aiGN;
  private static final kotlin.l.b.a.b.j.g.a.e aiGO;
  public static final kotlin.l.b.a.b.j.g.a.e aiGP;
  @Deprecated
  public static final kotlin.l.b.a.b.j.g.a.e aiGQ;
  private static final kotlin.l.b.a.b.n.g aiGR;
  private static final Map<bi, t> aiGS;
  
  static
  {
    AppMethodBeat.i(191814);
    aiGC = new q(bh.e.aiHG)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191785);
        if (paramAnonymousp == null) {
          aKu(1);
        }
        if (paramAnonymousl == null) {
          aKu(2);
        }
        if (d.r(paramAnonymousp))
        {
          if (paramAnonymousl == null) {
            aKu(0);
          }
          if (d.C(paramAnonymousl) != aw.aiHv) {}
          for (int i = 1; i != 0; i = 0)
          {
            boolean bool = s.a(paramAnonymousp, paramAnonymousl);
            AppMethodBeat.o(191785);
            return bool;
          }
        }
        if ((paramAnonymousp instanceof k))
        {
          paramAnonymouse = ((k)paramAnonymousp).koy();
          if ((d.v(paramAnonymouse)) && (d.r(paramAnonymouse)) && ((paramAnonymousl instanceof k)) && (d.r(paramAnonymousl.knp())) && (s.a(paramAnonymousp, paramAnonymousl)))
          {
            AppMethodBeat.o(191785);
            return true;
          }
        }
        paramAnonymouse = paramAnonymousp;
        l locall;
        do
        {
          paramAnonymousp = paramAnonymouse;
          if (paramAnonymouse == null) {
            break;
          }
          locall = paramAnonymouse.knp();
          if ((locall instanceof e))
          {
            paramAnonymousp = locall;
            if (!d.u(locall)) {
              break;
            }
          }
          paramAnonymouse = locall;
        } while (!(locall instanceof ah));
        paramAnonymousp = locall;
        if (paramAnonymousp == null)
        {
          AppMethodBeat.o(191785);
          return false;
        }
        while (paramAnonymousl != null)
        {
          if (paramAnonymousp == paramAnonymousl)
          {
            AppMethodBeat.o(191785);
            return true;
          }
          if ((paramAnonymousl instanceof ah))
          {
            if (((paramAnonymousp instanceof ah)) && (((ah)paramAnonymousp).koY().equals(((ah)paramAnonymousl).koY())) && (d.d(paramAnonymousl, paramAnonymousp)))
            {
              AppMethodBeat.o(191785);
              return true;
            }
            AppMethodBeat.o(191785);
            return false;
          }
          paramAnonymousl = paramAnonymousl.knp();
        }
        AppMethodBeat.o(191785);
        return false;
      }
    };
    aiGD = new q(bh.f.aiHH)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191773);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        if (s.aiGC.b(paramAnonymouse, paramAnonymousp, paramAnonymousl))
        {
          if (paramAnonymouse == s.aiGP)
          {
            AppMethodBeat.o(191773);
            return true;
          }
          if (paramAnonymouse == s.koE())
          {
            AppMethodBeat.o(191773);
            return false;
          }
          paramAnonymousp = d.a(paramAnonymousp, e.class);
          if ((paramAnonymousp != null) && ((paramAnonymouse instanceof kotlin.l.b.a.b.j.g.a.g)))
          {
            boolean bool = ((kotlin.l.b.a.b.j.g.a.g)paramAnonymouse).kpn().kow().equals(paramAnonymousp.kor());
            AppMethodBeat.o(191773);
            return bool;
          }
        }
        AppMethodBeat.o(191773);
        return false;
      }
    };
    aiGE = new q(bh.g.aiHI)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191797);
        for (;;)
        {
          if (paramAnonymousp == null) {
            aKu(0);
          }
          if (paramAnonymousl == null) {
            aKu(1);
          }
          e locale2 = (e)d.a(paramAnonymousp, e.class);
          e locale1 = (e)d.a(paramAnonymousl, e.class, false);
          if (locale1 == null)
          {
            AppMethodBeat.o(191797);
            return false;
          }
          if ((locale2 != null) && (d.u(locale2)))
          {
            paramAnonymousl = (e)d.a(locale2, e.class);
            if ((paramAnonymousl != null) && (d.c(locale1, paramAnonymousl)))
            {
              AppMethodBeat.o(191797);
              return true;
            }
          }
          paramAnonymousl = d.a(paramAnonymousp);
          locale2 = (e)d.a(paramAnonymousl, e.class);
          if (locale2 == null)
          {
            AppMethodBeat.o(191797);
            return false;
          }
          if (d.c(locale1, locale2))
          {
            if (paramAnonymousl == null) {
              aKu(2);
            }
            if (locale1 == null) {
              aKu(3);
            }
            int i;
            if (paramAnonymouse != s.aiGQ) {
              if (!(paramAnonymousl instanceof b)) {
                i = 1;
              }
            }
            while (i != 0)
            {
              AppMethodBeat.o(191797);
              return true;
              if ((paramAnonymousl instanceof k))
              {
                i = 1;
              }
              else if (paramAnonymouse == s.aiGP)
              {
                i = 1;
              }
              else if ((paramAnonymouse == s.koE()) || (paramAnonymouse == null))
              {
                i = 0;
              }
              else
              {
                if ((paramAnonymouse instanceof f)) {}
                for (paramAnonymousl = ((f)paramAnonymouse).kzM();; paramAnonymousl = paramAnonymouse.koG())
                {
                  if ((!d.b(paramAnonymousl, locale1)) && (!kotlin.l.b.a.b.m.t.aa(paramAnonymousl))) {
                    break label276;
                  }
                  i = 1;
                  break;
                }
                label276:
                i = 0;
              }
            }
          }
          paramAnonymousl = locale1.knp();
        }
      }
    };
    aiGF = new q(bh.b.aiHD)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191796);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        paramAnonymouse = d.s(paramAnonymousp);
        if (!d.s(paramAnonymousl).a(paramAnonymouse))
        {
          AppMethodBeat.o(191796);
          return false;
        }
        boolean bool = s.koF().g(paramAnonymousp, paramAnonymousl);
        AppMethodBeat.o(191796);
        return bool;
      }
    };
    aiGG = new q(bh.h.aiHJ)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191787);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        AppMethodBeat.o(191787);
        return true;
      }
    };
    aiGH = new q(bh.d.aiHF)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191786);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        paramAnonymouse = new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        AppMethodBeat.o(191786);
        throw paramAnonymouse;
      }
    };
    aiGI = new q(bh.a.aiHC)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191819);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        paramAnonymouse = new IllegalStateException("Visibility is unknown yet");
        AppMethodBeat.o(191819);
        throw paramAnonymouse;
      }
    };
    aiGJ = new q(bh.c.aiHE)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191816);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        AppMethodBeat.o(191816);
        return false;
      }
    };
    aiGK = new q(bh.i.aiHK)
    {
      public final boolean b(kotlin.l.b.a.b.j.g.a.e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191820);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        AppMethodBeat.o(191820);
        return false;
      }
    };
    aiGL = Collections.unmodifiableSet(ar.setOf(new t[] { aiGC, aiGD, aiGF, aiGH }));
    Object localObject = a.aMs(4);
    ((Map)localObject).put(aiGD, Integer.valueOf(0));
    ((Map)localObject).put(aiGC, Integer.valueOf(0));
    ((Map)localObject).put(aiGF, Integer.valueOf(1));
    ((Map)localObject).put(aiGE, Integer.valueOf(1));
    ((Map)localObject).put(aiGG, Integer.valueOf(2));
    aiGM = Collections.unmodifiableMap((Map)localObject);
    aiGN = aiGG;
    aiGO = new kotlin.l.b.a.b.j.g.a.e()
    {
      public final ad koG()
      {
        AppMethodBeat.i(191771);
        IllegalStateException localIllegalStateException = new IllegalStateException("This method should not be called");
        AppMethodBeat.o(191771);
        throw localIllegalStateException;
      }
    };
    aiGP = new kotlin.l.b.a.b.j.g.a.e()
    {
      public final ad koG()
      {
        AppMethodBeat.i(191772);
        IllegalStateException localIllegalStateException = new IllegalStateException("This method should not be called");
        AppMethodBeat.o(191772);
        throw localIllegalStateException;
      }
    };
    aiGQ = new kotlin.l.b.a.b.j.g.a.e()
    {
      public final ad koG()
      {
        AppMethodBeat.i(191767);
        IllegalStateException localIllegalStateException = new IllegalStateException("This method should not be called");
        AppMethodBeat.o(191767);
        throw localIllegalStateException;
      }
    };
    localObject = ServiceLoader.load(kotlin.l.b.a.b.n.g.class, kotlin.l.b.a.b.n.g.class.getClassLoader()).iterator();
    if (((Iterator)localObject).hasNext()) {}
    for (localObject = (kotlin.l.b.a.b.n.g)((Iterator)localObject).next();; localObject = g.a.ajsg)
    {
      aiGR = (kotlin.l.b.a.b.n.g)localObject;
      aiGS = new HashMap();
      b(aiGC);
      b(aiGD);
      b(aiGE);
      b(aiGF);
      b(aiGG);
      b(aiGH);
      b(aiGI);
      b(aiGJ);
      b(aiGK);
      AppMethodBeat.o(191814);
      return;
    }
  }
  
  public static Integer a(t paramt1, t paramt2)
  {
    AppMethodBeat.i(191789);
    if (paramt1 == null) {
      aKu(12);
    }
    if (paramt2 == null) {
      aKu(13);
    }
    Integer localInteger = paramt1.c(paramt2);
    if (localInteger != null)
    {
      AppMethodBeat.o(191789);
      return localInteger;
    }
    paramt1 = paramt2.c(paramt1);
    if (paramt1 != null)
    {
      int i = -paramt1.intValue();
      AppMethodBeat.o(191789);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(191789);
    return null;
  }
  
  private static p a(kotlin.l.b.a.b.j.g.a.e parame, p paramp, l paraml)
  {
    AppMethodBeat.i(191784);
    if (paramp == null) {
      aKu(8);
    }
    if (paraml == null) {
      aKu(9);
    }
    for (p localp = (p)paramp.kor(); (localp != null) && (localp.knc() != aiGH); localp = (p)d.a(localp, p.class)) {
      if (!localp.knc().b(parame, localp, paraml))
      {
        AppMethodBeat.o(191784);
        return localp;
      }
    }
    if ((paramp instanceof kotlin.l.b.a.b.b.c.ah))
    {
      parame = a(parame, ((kotlin.l.b.a.b.b.c.ah)paramp).kqj(), paraml);
      if (parame != null)
      {
        AppMethodBeat.o(191784);
        return parame;
      }
    }
    AppMethodBeat.o(191784);
    return null;
  }
  
  public static t a(bi parambi)
  {
    AppMethodBeat.i(191801);
    if (parambi == null) {
      aKu(15);
    }
    t localt = (t)aiGS.get(parambi);
    if (localt == null)
    {
      parambi = new IllegalArgumentException("Inapplicable visibility: ".concat(String.valueOf(parambi)));
      AppMethodBeat.o(191801);
      throw parambi;
    }
    if (localt == null) {
      aKu(16);
    }
    AppMethodBeat.o(191801);
    return localt;
  }
  
  public static boolean a(l paraml1, l paraml2)
  {
    AppMethodBeat.i(191780);
    if (paraml1 == null) {
      aKu(6);
    }
    if (paraml2 == null) {
      aKu(7);
    }
    paraml2 = d.C(paraml2);
    if (paraml2 != aw.aiHv)
    {
      boolean bool = paraml2.equals(d.C(paraml1));
      AppMethodBeat.o(191780);
      return bool;
    }
    AppMethodBeat.o(191780);
    return false;
  }
  
  public static boolean a(p paramp, l paraml)
  {
    AppMethodBeat.i(191777);
    if (paramp == null) {
      aKu(2);
    }
    if (paraml == null) {
      aKu(3);
    }
    if (a(aiGP, paramp, paraml) == null)
    {
      AppMethodBeat.o(191777);
      return true;
    }
    AppMethodBeat.o(191777);
    return false;
  }
  
  public static boolean a(t paramt)
  {
    AppMethodBeat.i(191793);
    if (paramt == null) {
      aKu(14);
    }
    if ((paramt == aiGC) || (paramt == aiGD))
    {
      AppMethodBeat.o(191793);
      return true;
    }
    AppMethodBeat.o(191793);
    return false;
  }
  
  private static void b(t paramt)
  {
    AppMethodBeat.i(191798);
    aiGS.put(paramt.koB(), paramt);
    AppMethodBeat.o(191798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.s
 * JD-Core Version:    0.7.0.1
 */