package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class h
  implements Comparable<h>
{
  public static final h aiuC;
  public static final a aiuD;
  private final int aaGW;
  private final int rid;
  private final int rie;
  private final int version;
  
  static
  {
    AppMethodBeat.i(190842);
    aiuD = new a((byte)0);
    aiuC = i.kkP();
    AppMethodBeat.o(190842);
  }
  
  public h(int paramInt)
  {
    this(paramInt, 0);
  }
  
  public h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190831);
    this.rid = 1;
    this.rie = paramInt1;
    this.aaGW = paramInt2;
    paramInt2 = this.rid;
    int j = this.rie;
    int k = this.aaGW;
    if (paramInt2 < 0) {}
    for (paramInt1 = 0;; paramInt1 = i)
    {
      if (paramInt1 != 0) {
        break label150;
      }
      Throwable localThrowable = (Throwable)new IllegalArgumentException(("Version components are out of range: " + paramInt2 + '.' + j + '.' + k).toString());
      AppMethodBeat.o(190831);
      throw localThrowable;
      if ((255 < paramInt2) || (j < 0) || (255 < j) || (k < 0) || (255 < k)) {
        break;
      }
    }
    label150:
    this.version = ((paramInt2 << 16) + (j << 8) + k);
    AppMethodBeat.o(190831);
  }
  
  public final int a(h paramh)
  {
    AppMethodBeat.i(190858);
    s.u(paramh, "other");
    int i = this.version;
    int j = paramh.version;
    AppMethodBeat.o(190858);
    return i - j;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((h)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (h)paramObject;
      if (paramObject == null) {
        return false;
      }
      return this.version == paramObject.version;
    }
  }
  
  public final int hashCode()
  {
    return this.version;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190845);
    String str = this.rid + '.' + this.rie + '.' + this.aaGW;
    AppMethodBeat.o(190845);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.h
 * JD-Core Version:    0.7.0.1
 */