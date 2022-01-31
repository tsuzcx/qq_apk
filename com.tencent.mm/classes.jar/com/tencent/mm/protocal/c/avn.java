package com.tencent.mm.protocal.c;

public final class avn
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public boolean tqZ;
  public boolean tra;
  public int trb;
  public int trc;
  public String trd;
  public boolean tre;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.tqZ);
      paramVarArgs.aA(2, this.tra);
      paramVarArgs.gB(3, this.trb);
      paramVarArgs.gB(4, this.trc);
      if (this.trd != null) {
        paramVarArgs.d(5, this.trd);
      }
      paramVarArgs.aA(6, this.tre);
      if (this.bOL != null) {
        paramVarArgs.d(7, this.bOL);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.b.b.a.dQ(1) + 1 + 0 + (d.a.a.b.b.a.dQ(2) + 1) + d.a.a.a.gy(3, this.trb) + d.a.a.a.gy(4, this.trc);
      paramInt = i;
      if (this.trd != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.trd);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(6) + 1);
      paramInt = i;
    } while (this.bOL == null);
    return i + d.a.a.b.b.a.e(7, this.bOL);
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
      avn localavn = (avn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localavn.tqZ = locala.cUr();
        return 0;
      case 2: 
        localavn.tra = locala.cUr();
        return 0;
      case 3: 
        localavn.trb = locala.xpH.oD();
        return 0;
      case 4: 
        localavn.trc = locala.xpH.oD();
        return 0;
      case 5: 
        localavn.trd = locala.xpH.readString();
        return 0;
      case 6: 
        localavn.tre = locala.cUr();
        return 0;
      }
      localavn.bOL = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avn
 * JD-Core Version:    0.7.0.1
 */