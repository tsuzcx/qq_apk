package kotlin.j;

import java.util.Random;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class a
  extends c
{
  public final float OB()
  {
    return klH().nextFloat();
  }
  
  public final int Pa(int paramInt)
  {
    return klH().nextInt(paramInt);
  }
  
  public final double Zm()
  {
    return klH().nextDouble();
  }
  
  public final long Zn()
  {
    return klH().nextLong();
  }
  
  public final int Zo()
  {
    return klH().nextInt();
  }
  
  public final int aKr(int paramInt)
  {
    return d.qr(klH().nextInt(), paramInt);
  }
  
  public final byte[] dG(byte[] paramArrayOfByte)
  {
    s.u(paramArrayOfByte, "array");
    klH().nextBytes(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public abstract Random klH();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.j.a
 * JD-Core Version:    0.7.0.1
 */