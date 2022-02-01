package d.j;

import d.l;
import java.util.Random;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"})
public abstract class a
  extends c
{
  public final int agJ(int paramInt)
  {
    return d.kY(fOD().nextInt(), paramInt);
  }
  
  public abstract Random fOD();
  
  public final double nextDouble()
  {
    return fOD().nextDouble();
  }
  
  public final int nextInt()
  {
    return fOD().nextInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.j.a
 * JD-Core Version:    0.7.0.1
 */