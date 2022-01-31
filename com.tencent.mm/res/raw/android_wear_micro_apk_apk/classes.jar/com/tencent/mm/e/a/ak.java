package com.tencent.mm.e.a;

public final class ak
  extends com.tencent.mm.d.a
{
  public int Wy;
  public long Wz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aq(1, this.Wy);
      paramVarArgs.g(2, this.Wz);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.ak(1, this.Wy) + 0 + a.a.a.a.e(2, this.Wz);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      ak localak = (ak)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localak.Wy = locala.ot();
        return 0;
      }
      localak.Wz = locala.ow();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.ak
 * JD-Core Version:    0.7.0.1
 */