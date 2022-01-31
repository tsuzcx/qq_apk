package com.tencent.mm.protocal.c;

public final class hn
  extends com.tencent.mm.bv.a
{
  public int sAQ;
  public int sAR;
  public int sAS;
  public int sAl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sAl);
      paramVarArgs.gB(2, this.sAQ);
      paramVarArgs.gB(3, this.sAR);
      paramVarArgs.gB(4, this.sAS);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sAl) + 0 + d.a.a.a.gy(2, this.sAQ) + d.a.a.a.gy(3, this.sAR) + d.a.a.a.gy(4, this.sAS);
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
      hn localhn = (hn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localhn.sAl = locala.xpH.oD();
        return 0;
      case 2: 
        localhn.sAQ = locala.xpH.oD();
        return 0;
      case 3: 
        localhn.sAR = locala.xpH.oD();
        return 0;
      }
      localhn.sAS = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.hn
 * JD-Core Version:    0.7.0.1
 */