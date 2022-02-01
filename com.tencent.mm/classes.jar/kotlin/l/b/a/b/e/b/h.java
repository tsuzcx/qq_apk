package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.c;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.q;
import kotlin.l.b.a.b.e.a.u;
import kotlin.l.b.a.b.e.a.u.c;
import kotlin.l.b.a.b.h.r;

public final class h
{
  public static final a ajdc;
  public final h.b ajdd;
  public final a.u.c ajde;
  private final a ajdf;
  private final Integer ajdg;
  private final String message;
  
  static
  {
    AppMethodBeat.i(191558);
    ajdc = new a((byte)0);
    AppMethodBeat.o(191558);
  }
  
  public h(h.b paramb, a.u.c paramc, a parama, Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(191556);
    this.ajdd = paramb;
    this.ajde = paramc;
    this.ajdf = parama;
    this.ajdg = paramInteger;
    this.message = paramString;
    AppMethodBeat.o(191556);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191559);
    StringBuilder localStringBuilder = new StringBuilder("since ").append(this.ajdd).append(' ').append(this.ajdf);
    if (this.ajdg != null)
    {
      str = s.X(" error ", this.ajdg);
      localStringBuilder = localStringBuilder.append(str);
      if (this.message == null) {
        break label96;
      }
    }
    label96:
    for (String str = s.X(": ", this.message);; str = "")
    {
      str = str;
      AppMethodBeat.o(191559);
      return str;
      str = "";
      break;
    }
  }
  
  public static final class a
  {
    public static List<h> a(r paramr, c paramc, i parami)
    {
      AppMethodBeat.i(191553);
      s.u(paramr, "proto");
      s.u(paramc, "nameResolver");
      s.u(parami, "table");
      if ((paramr instanceof a.b)) {
        paramr = ((a.b)paramr).aiZa;
      }
      Collection localCollection;
      Object localObject2;
      for (;;)
      {
        s.s(paramr, "ids");
        paramr = (Iterable)paramr;
        localCollection = (Collection)new ArrayList();
        Iterator localIterator = paramr.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label564;
          }
          paramr = (Integer)localIterator.next();
          localObject1 = h.ajdc;
          s.s(paramr, "id");
          int i = paramr.intValue();
          s.u(paramc, "nameResolver");
          s.u(parami, "table");
          localObject2 = (a.u)kotlin.a.p.ae(parami.ooG, i);
          if (localObject2 != null) {
            break;
          }
          paramr = null;
          if (paramr != null) {
            localCollection.add(paramr);
          }
        }
        if ((paramr instanceof a.c))
        {
          paramr = ((a.c)paramr).aiZa;
        }
        else if ((paramr instanceof a.h))
        {
          paramr = ((a.h)paramr).aiZa;
        }
        else if ((paramr instanceof a.m))
        {
          paramr = ((a.m)paramr).aiZa;
        }
        else
        {
          if (!(paramr instanceof a.q)) {
            break;
          }
          paramr = ((a.q)paramr).aiZa;
        }
      }
      paramr = new IllegalStateException(s.X("Unexpected declaration: ", paramr.getClass()));
      AppMethodBeat.o(191553);
      throw paramr;
      paramr = h.b.ajdh;
      if (((a.u)localObject2).kwJ())
      {
        paramr = Integer.valueOf(((a.u)localObject2).ajbu);
        label271:
        if (!((a.u)localObject2).kwK()) {
          break label404;
        }
        localObject1 = Integer.valueOf(((a.u)localObject2).ajbv);
        label289:
        if (localObject1 == null) {
          break label410;
        }
        paramr = new h.b(((Integer)localObject1).intValue() & 0xFF, ((Integer)localObject1).intValue() >> 8 & 0xFF, ((Integer)localObject1).intValue() >> 16 & 0xFF);
      }
      for (;;)
      {
        localObject1 = ((a.u)localObject2).ajbw;
        s.checkNotNull(localObject1);
        switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        default: 
          paramr = new kotlin.p();
          AppMethodBeat.o(191553);
          throw paramr;
          paramr = null;
          break label271;
          label404:
          localObject1 = null;
          break label289;
          label410:
          if (paramr != null) {
            paramr = new h.b(paramr.intValue() & 0x7, paramr.intValue() >> 3 & 0xF, paramr.intValue() >> 7 & 0x7F);
          } else {
            paramr = h.b.ajdi;
          }
          break;
        }
      }
      Object localObject1 = a.aiuy;
      label463:
      Integer localInteger;
      if (((a.u)localObject2).hasErrorCode())
      {
        localInteger = Integer.valueOf(((a.u)localObject2).ajbx);
        label481:
        if (!((a.u)localObject2).kwM()) {
          break label558;
        }
      }
      label558:
      for (String str = paramc.getString(((a.u)localObject2).ajby);; str = null)
      {
        localObject2 = ((a.u)localObject2).ajbz;
        s.s(localObject2, "info.versionKind");
        paramr = new h(paramr, (a.u.c)localObject2, (a)localObject1, localInteger, str);
        break;
        localObject1 = a.aiuz;
        break label463;
        localObject1 = a.aiuA;
        break label463;
        localInteger = null;
        break label481;
      }
      label564:
      paramr = (List)localCollection;
      AppMethodBeat.o(191553);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.h
 * JD-Core Version:    0.7.0.1
 */