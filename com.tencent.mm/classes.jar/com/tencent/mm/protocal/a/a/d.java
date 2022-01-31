package com.tencent.mm.protocal.a.a;

public final class d
  extends com.tencent.mm.bv.a
{
  public int count;
  public int nZA;
  public com.tencent.mm.bv.b sqC;
  public int sqD;
  public int sqt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sqC == null) {
        throw new d.a.a.b("Not all required fields were included: value");
      }
      paramVarArgs.gB(1, this.sqt);
      if (this.sqC != null) {
        paramVarArgs.b(2, this.sqC);
      }
      paramVarArgs.gB(3, this.sqD);
      paramVarArgs.gB(4, this.nZA);
      paramVarArgs.gB(5, this.count);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.sqt) + 0;
      paramInt = i;
      if (this.sqC != null) {
        paramInt = i + d.a.a.a.a(2, this.sqC);
      }
      return paramInt + d.a.a.a.gy(3, this.sqD) + d.a.a.a.gy(4, this.nZA) + d.a.a.a.gy(5, this.count);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sqC == null) {
        throw new d.a.a.b("Not all required fields were included: value");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locald.sqt = locala.xpH.oD();
        return 0;
      case 2: 
        locald.sqC = locala.cUs();
        return 0;
      case 3: 
        locald.sqD = locala.xpH.oD();
        return 0;
      case 4: 
        locald.nZA = locala.xpH.oD();
        return 0;
      }
      locald.count = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */