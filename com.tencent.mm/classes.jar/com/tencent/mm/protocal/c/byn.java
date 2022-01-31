package com.tencent.mm.protocal.c;

public final class byn
  extends com.tencent.mm.bv.a
{
  public String kRZ;
  public double sDm;
  public double sDn;
  public String txR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, this.sDn);
      paramVarArgs.b(2, this.sDm);
      if (this.kRZ != null) {
        paramVarArgs.d(3, this.kRZ);
      }
      if (this.txR != null) {
        paramVarArgs.d(4, this.txR);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.b.b.a.dQ(1) + 8 + 0 + (d.a.a.b.b.a.dQ(2) + 8);
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kRZ);
      }
      i = paramInt;
    } while (this.txR == null);
    return paramInt + d.a.a.b.b.a.e(4, this.txR);
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
      byn localbyn = (byn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbyn.sDn = locala.xpH.readDouble();
        return 0;
      case 2: 
        localbyn.sDm = locala.xpH.readDouble();
        return 0;
      case 3: 
        localbyn.kRZ = locala.xpH.readString();
        return 0;
      }
      localbyn.txR = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byn
 * JD-Core Version:    0.7.0.1
 */