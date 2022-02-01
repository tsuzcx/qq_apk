package com.tencent.mm.g;

public final class b
  extends com.tencent.mm.d.a
{
  public int abS;
  public int abT;
  public int abU;
  public int abV = -1;
  public int abW;
  public int abX;
  public int size;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.at(1, this.abS);
      paramVarArgs.at(2, this.abT);
      paramVarArgs.at(3, this.abU);
      paramVarArgs.at(41, this.abV);
      paramVarArgs.at(5, this.abW);
      paramVarArgs.at(6, this.abX);
      paramVarArgs.at(7, this.size);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.an(1, this.abS) + 0 + a.a.a.a.an(2, this.abT) + a.a.a.a.an(3, this.abU) + a.a.a.a.an(41, this.abV) + a.a.a.a.an(5, this.abW) + a.a.a.a.an(6, this.abX) + a.a.a.a.an(7, this.size);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localb.abS = locala.pg();
        return 0;
      case 2: 
        localb.abT = locala.pg();
        return 0;
      case 3: 
        localb.abU = locala.pg();
        return 0;
      case 41: 
        localb.abV = locala.pg();
        return 0;
      case 5: 
        localb.abW = locala.pg();
        return 0;
      case 6: 
        localb.abX = locala.pg();
        return 0;
      }
      localb.size = locala.pg();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.g.b
 * JD-Core Version:    0.7.0.1
 */