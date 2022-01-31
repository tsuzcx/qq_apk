package com.tencent.mm.protocal.c;

public final class rc
  extends com.tencent.mm.bv.a
{
  public long sOK;
  public int sOL;
  public int sOM;
  public int sON;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.sOK);
      paramVarArgs.gB(2, this.sOL);
      paramVarArgs.gB(3, this.sOM);
      paramVarArgs.gB(4, this.sON);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.sOK) + 0 + d.a.a.a.gy(2, this.sOL) + d.a.a.a.gy(3, this.sOM) + d.a.a.a.gy(4, this.sON);
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
      rc localrc = (rc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localrc.sOK = locala.xpH.oE();
        return 0;
      case 2: 
        localrc.sOL = locala.xpH.oD();
        return 0;
      case 3: 
        localrc.sOM = locala.xpH.oD();
        return 0;
      }
      localrc.sON = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rc
 * JD-Core Version:    0.7.0.1
 */