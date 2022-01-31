package com.tencent.mm.protocal.c;

public final class fi
  extends com.tencent.mm.bv.a
{
  public long endTime;
  public long startTime;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.startTime);
      paramVarArgs.Y(2, this.endTime);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.startTime) + 0 + d.a.a.a.X(2, this.endTime);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      fi localfi = (fi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localfi.startTime = locala.xpH.oE();
        return 0;
      }
      localfi.endTime = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fi
 * JD-Core Version:    0.7.0.1
 */