package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ad;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a.d;
import kotlin.l.b.a.b.e.c.a.d.b;
import kotlin.l.b.a.b.e.c.a.d.b.b;
import kotlin.l.b.a.b.h.d;
import kotlin.n.n;

public final class f
  implements c
{
  private static final String ajdY;
  public static final f.a ajeh;
  private static final List<String> ajek;
  private static final Map<String, Integer> ajel;
  private final String[] aiXE;
  private final a.d ajei;
  private final Set<Integer> ajej;
  private final List<a.d.b> wZc;
  
  static
  {
    AppMethodBeat.i(59250);
    ajeh = new f.a((byte)0);
    ajdY = p.a((Iterable)p.listOf(new Character[] { Character.valueOf('k'), Character.valueOf('o'), Character.valueOf('t'), Character.valueOf('l'), Character.valueOf('i'), Character.valueOf('n') }), (CharSequence)"", null, null, 0, null, null, 62);
    Object localObject1 = p.listOf(new String[] { s.X(ajdY, "/Any"), s.X(ajdY, "/Nothing"), s.X(ajdY, "/Unit"), s.X(ajdY, "/Throwable"), s.X(ajdY, "/Number"), s.X(ajdY, "/Byte"), s.X(ajdY, "/Double"), s.X(ajdY, "/Float"), s.X(ajdY, "/Int"), s.X(ajdY, "/Long"), s.X(ajdY, "/Short"), s.X(ajdY, "/Boolean"), s.X(ajdY, "/Char"), s.X(ajdY, "/CharSequence"), s.X(ajdY, "/String"), s.X(ajdY, "/Comparable"), s.X(ajdY, "/Enum"), s.X(ajdY, "/Array"), s.X(ajdY, "/ByteArray"), s.X(ajdY, "/DoubleArray"), s.X(ajdY, "/FloatArray"), s.X(ajdY, "/IntArray"), s.X(ajdY, "/LongArray"), s.X(ajdY, "/ShortArray"), s.X(ajdY, "/BooleanArray"), s.X(ajdY, "/CharArray"), s.X(ajdY, "/Cloneable"), s.X(ajdY, "/Annotation"), s.X(ajdY, "/collections/Iterable"), s.X(ajdY, "/collections/MutableIterable"), s.X(ajdY, "/collections/Collection"), s.X(ajdY, "/collections/MutableCollection"), s.X(ajdY, "/collections/List"), s.X(ajdY, "/collections/MutableList"), s.X(ajdY, "/collections/Set"), s.X(ajdY, "/collections/MutableSet"), s.X(ajdY, "/collections/Map"), s.X(ajdY, "/collections/MutableMap"), s.X(ajdY, "/collections/Map.Entry"), s.X(ajdY, "/collections/MutableMap.MutableEntry"), s.X(ajdY, "/collections/Iterator"), s.X(ajdY, "/collections/MutableIterator"), s.X(ajdY, "/collections/ListIterator"), s.X(ajdY, "/collections/MutableListIterator") });
    ajek = (List)localObject1;
    Object localObject2 = p.s((Iterable)localObject1);
    localObject1 = (Map)new LinkedHashMap(k.qu(ak.aKi(p.a((Iterable)localObject2, 10)), 16));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put((String)((ae)localObject3).value, Integer.valueOf(((ae)localObject3).index));
    }
    ajel = (Map)localObject1;
    AppMethodBeat.o(59250);
  }
  
  public f(a.d paramd, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59249);
    this.ajei = paramd;
    this.aiXE = paramArrayOfString;
    paramd = this.ajei.ajdH;
    if (paramd.isEmpty()) {}
    for (paramd = (Set)ad.aivA;; paramd = p.r((Iterable)paramd))
    {
      this.ajej = paramd;
      paramd = new ArrayList();
      paramArrayOfString = this.ajei.ajdG;
      paramd.ensureCapacity(paramArrayOfString.size());
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        a.d.b localb = (a.d.b)paramArrayOfString.next();
        int j = localb.ajdK;
        int i = 0;
        while (i < j)
        {
          paramd.add(localb);
          i += 1;
        }
      }
      s.s(paramd, "");
    }
    paramd.trimToSize();
    paramArrayOfString = ah.aiuX;
    this.wZc = ((List)paramd);
    AppMethodBeat.o(59249);
  }
  
  public final String aLW(int paramInt)
  {
    AppMethodBeat.i(59247);
    String str = getString(paramInt);
    AppMethodBeat.o(59247);
    return str;
  }
  
  public final boolean aLX(int paramInt)
  {
    AppMethodBeat.i(59248);
    boolean bool = this.ajej.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(59248);
    return bool;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59246);
    Object localObject3 = (a.d.b)this.wZc.get(paramInt);
    Object localObject1;
    Object localObject2;
    if (((a.d.b)localObject3).kxB())
    {
      localObject1 = ((a.d.b)localObject3).ajdM;
      if ((localObject1 instanceof String))
      {
        localObject1 = (String)localObject1;
        localObject2 = localObject1;
        Object localObject4;
        if (((a.d.b)localObject3).ajdO.size() >= 2)
        {
          localObject2 = ((a.d.b)localObject3).ajdO;
          s.s(localObject2, "substringIndexList");
          localObject4 = (Integer)((List)localObject2).get(0);
          Integer localInteger = (Integer)((List)localObject2).get(1);
          s.s(localObject4, "begin");
          localObject2 = localObject1;
          if (((Integer)localObject4).intValue() >= 0)
          {
            paramInt = ((Integer)localObject4).intValue();
            s.s(localInteger, "end");
            localObject2 = localObject1;
            if (paramInt <= localInteger.intValue())
            {
              localObject2 = localObject1;
              if (localInteger.intValue() <= ((String)localObject1).length())
              {
                s.s(localObject1, "string");
                localObject2 = ((String)localObject1).substring(((Integer)localObject4).intValue(), localInteger.intValue());
                s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              }
            }
          }
        }
        localObject1 = localObject2;
        if (((a.d.b)localObject3).ajdQ.size() >= 2)
        {
          localObject4 = ((a.d.b)localObject3).ajdQ;
          s.s(localObject4, "replaceCharList");
          localObject1 = (Integer)((List)localObject4).get(0);
          localObject4 = (Integer)((List)localObject4).get(1);
          s.s(localObject2, "string");
          localObject1 = n.a((String)localObject2, (char)((Integer)localObject1).intValue(), (char)((Integer)localObject4).intValue());
        }
        localObject2 = ((a.d.b)localObject3).ajdN;
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = a.d.b.b.ajdS;
        }
        localObject2 = localObject1;
        switch (b.$EnumSwitchMapping$0[localObject3.ordinal()])
        {
        default: 
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      s.s(localObject2, "string");
      AppMethodBeat.o(59246);
      return localObject2;
      localObject2 = (d)localObject1;
      localObject1 = ((d)localObject2).ZV();
      if (((d)localObject2).ZW()) {
        ((a.d.b)localObject3).ajdM = localObject1;
      }
      break;
      if (((a.d.b)localObject3).kxA())
      {
        int i = ajek.size();
        int j = ((a.d.b)localObject3).ajdL;
        if (j >= 0) {
          if (j <= i - 1) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label476;
          }
          localObject1 = (String)ajek.get(((a.d.b)localObject3).ajdL);
          break;
          i = 0;
          continue;
          i = 0;
        }
      }
      label476:
      localObject1 = this.aiXE[paramInt];
      break;
      s.s(localObject1, "string");
      localObject2 = n.a((String)localObject1, '$', '.');
      continue;
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 2)
      {
        s.s(localObject1, "string");
        localObject2 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      s.s(localObject2, "string");
      localObject2 = n.a((String)localObject2, '$', '.');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.f
 * JD-Core Version:    0.7.0.1
 */