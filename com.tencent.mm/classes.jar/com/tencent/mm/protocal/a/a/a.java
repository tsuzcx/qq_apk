package com.tencent.mm.protocal.a.a;

public final class a
  extends com.tencent.mm.bv.a
{
  public int count;
  public int sqt;
  public int value;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sqt);
      paramVarArgs.gB(2, this.value);
      paramVarArgs.gB(3, this.count);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sqt) + 0 + d.a.a.a.gy(2, this.value) + d.a.a.a.gy(3, this.count);
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
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locala1.sqt = locala.xpH.oD();
        return 0;
      case 2: 
        locala1.value = locala.xpH.oD();
        return 0;
      }
      locala1.count = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.a
 * JD-Core Version:    0.7.0.1
 */