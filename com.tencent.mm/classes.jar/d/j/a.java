package d.j;

import d.l;
import java.util.Random;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"})
public abstract class a
  extends c
{
  public final int ajk(int paramInt)
  {
    return d.ln(ggd().nextInt(), paramInt);
  }
  
  public abstract Random ggd();
  
  public final double nextDouble()
  {
    return ggd().nextDouble();
  }
  
  public final int nextInt()
  {
    return ggd().nextInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.j.a
 * JD-Core Version:    0.7.0.1
 */