package kotlin.j;

import java.util.Random;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"})
public abstract class a
  extends c
{
  public final int Nz(int paramInt)
  {
    return iCs().nextInt(paramInt);
  }
  
  public final int aDE(int paramInt)
  {
    return d.ot(iCs().nextInt(), paramInt);
  }
  
  public abstract Random iCs();
  
  public final double zB()
  {
    return iCs().nextDouble();
  }
  
  public final long zC()
  {
    return iCs().nextLong();
  }
  
  public final int zD()
  {
    return iCs().nextInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.j.a
 * JD-Core Version:    0.7.0.1
 */