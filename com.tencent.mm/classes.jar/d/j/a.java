package d.j;

import d.l;
import java.util.Random;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"})
public abstract class a
  extends c
{
  public final int adN(int paramInt)
  {
    return d.kI(fvZ().nextInt(), paramInt);
  }
  
  public abstract Random fvZ();
  
  public final double nextDouble()
  {
    return fvZ().nextDouble();
  }
  
  public final int nextInt()
  {
    return fvZ().nextInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.j.a
 * JD-Core Version:    0.7.0.1
 */