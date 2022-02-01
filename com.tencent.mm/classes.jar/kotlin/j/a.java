package kotlin.j;

import java.util.Random;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"})
public abstract class a
  extends c
{
  public final int atK(int paramInt)
  {
    return d.mX(hyh().nextInt(), paramInt);
  }
  
  public abstract Random hyh();
  
  public final double nextDouble()
  {
    return hyh().nextDouble();
  }
  
  public final int nextInt()
  {
    return hyh().nextInt();
  }
  
  public final int nextInt(int paramInt)
  {
    return hyh().nextInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.j.a
 * JD-Core Version:    0.7.0.1
 */