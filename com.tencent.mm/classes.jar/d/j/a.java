package d.j;

import d.l;
import java.util.Random;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"})
public abstract class a
  extends c
{
  public final int ajU(int paramInt)
  {
    return d.lu(gkF().nextInt(), paramInt);
  }
  
  public abstract Random gkF();
  
  public final double nextDouble()
  {
    return gkF().nextDouble();
  }
  
  public final int nextInt()
  {
    return gkF().nextInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.j.a
 * JD-Core Version:    0.7.0.1
 */