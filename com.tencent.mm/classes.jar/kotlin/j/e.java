package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class e
  extends c
  implements Serializable
{
  private static final a aixn;
  private int aixm;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    AppMethodBeat.i(190901);
    aixn = new a((byte)0);
    AppMethodBeat.o(190901);
  }
  
  public e(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, paramInt1 ^ 0xFFFFFFFF, paramInt1 << 10 ^ paramInt2 >>> 4);
    AppMethodBeat.i(129557);
    AppMethodBeat.o(129557);
  }
  
  private e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129556);
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = 0;
    this.w = 0;
    this.v = paramInt3;
    this.aixm = paramInt4;
    if ((this.x | this.y | this.z | this.w | this.v) != 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramInt2 = i;
      if (paramInt1 != 0) {
        break;
      }
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
      AppMethodBeat.o(129556);
      throw localThrowable;
    }
    while (paramInt2 < 64)
    {
      Zo();
      paramInt2 += 1;
    }
    AppMethodBeat.o(129556);
  }
  
  public final int Zo()
  {
    int i = this.x;
    i ^= i >>> 2;
    this.x = this.y;
    this.y = this.z;
    this.z = this.w;
    int j = this.v;
    this.w = j;
    i = i ^ i << 1 ^ j ^ j << 4;
    this.v = i;
    this.aixm += 362437;
    return i + this.aixm;
  }
  
  public final int aKr(int paramInt)
  {
    AppMethodBeat.i(129555);
    paramInt = d.qr(Zo(), paramInt);
    AppMethodBeat.o(129555);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/random/XorWowRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.j.e
 * JD-Core Version:    0.7.0.1
 */