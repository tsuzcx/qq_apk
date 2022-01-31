package com.tencent.mm.g;

public final class b
  extends com.tencent.mm.d.a
{
  public int Ys;
  public int Yt;
  public int Yu;
  public int Yv = -1;
  public int Yw;
  public int Yx;
  public int size;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aq(1, this.Ys);
      paramVarArgs.aq(2, this.Yt);
      paramVarArgs.aq(3, this.Yu);
      paramVarArgs.aq(41, this.Yv);
      paramVarArgs.aq(5, this.Yw);
      paramVarArgs.aq(6, this.Yx);
      paramVarArgs.aq(7, this.size);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.ak(1, this.Ys) + 0 + a.a.a.a.ak(2, this.Yt) + a.a.a.a.ak(3, this.Yu) + a.a.a.a.ak(41, this.Yv) + a.a.a.a.ak(5, this.Yw) + a.a.a.a.ak(6, this.Yx) + a.a.a.a.ak(7, this.size);
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
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localb.Ys = locala.ot();
        return 0;
      case 2: 
        localb.Yt = locala.ot();
        return 0;
      case 3: 
        localb.Yu = locala.ot();
        return 0;
      case 41: 
        localb.Yv = locala.ot();
        return 0;
      case 5: 
        localb.Yw = locala.ot();
        return 0;
      case 6: 
        localb.Yx = locala.ot();
        return 0;
      }
      localb.size = locala.ot();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.g.b
 * JD-Core Version:    0.7.0.1
 */