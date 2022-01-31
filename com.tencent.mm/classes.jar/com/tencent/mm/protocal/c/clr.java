package com.tencent.mm.protocal.c;

public final class clr
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public int sCy;
  public int tmZ;
  public int tqL;
  public int tqM;
  public String tqN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tmZ);
      paramVarArgs.gB(2, this.sCy);
      paramVarArgs.gB(3, this.pyo);
      if (this.tqN != null) {
        paramVarArgs.d(4, this.tqN);
      }
      paramVarArgs.gB(5, this.tqM);
      paramVarArgs.gB(6, this.tqL);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tmZ) + 0 + d.a.a.a.gy(2, this.sCy) + d.a.a.a.gy(3, this.pyo);
      paramInt = i;
      if (this.tqN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tqN);
      }
      return paramInt + d.a.a.a.gy(5, this.tqM) + d.a.a.a.gy(6, this.tqL);
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
      clr localclr = (clr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localclr.tmZ = locala.xpH.oD();
        return 0;
      case 2: 
        localclr.sCy = locala.xpH.oD();
        return 0;
      case 3: 
        localclr.pyo = locala.xpH.oD();
        return 0;
      case 4: 
        localclr.tqN = locala.xpH.readString();
        return 0;
      case 5: 
        localclr.tqM = locala.xpH.oD();
        return 0;
      }
      localclr.tqL = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clr
 * JD-Core Version:    0.7.0.1
 */