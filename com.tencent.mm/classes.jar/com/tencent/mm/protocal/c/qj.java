package com.tencent.mm.protocal.c;

public final class qj
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public int nSM;
  public String path;
  public long sxj;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.sxj);
      paramVarArgs.gB(2, this.nSM);
      if (this.bOL != null) {
        paramVarArgs.d(3, this.bOL);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.X(1, this.sxj) + 0 + d.a.a.a.gy(2, this.nSM);
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bOL);
      }
      i = paramInt;
    } while (this.path == null);
    return paramInt + d.a.a.b.b.a.e(4, this.path);
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
      qj localqj = (qj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localqj.sxj = locala.xpH.oE();
        return 0;
      case 2: 
        localqj.nSM = locala.xpH.oD();
        return 0;
      case 3: 
        localqj.bOL = locala.xpH.readString();
        return 0;
      }
      localqj.path = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qj
 * JD-Core Version:    0.7.0.1
 */