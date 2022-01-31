package com.tencent.mm.protocal.a.a;

public final class n
  extends com.tencent.mm.bv.a
{
  public int sqt;
  public int srd;
  public int sre;
  public int srf;
  public int srg;
  public int srh;
  public int sri;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sqt);
      paramVarArgs.gB(2, this.srd);
      paramVarArgs.gB(3, this.sre);
      paramVarArgs.gB(4, this.srf);
      paramVarArgs.gB(5, this.srg);
      paramVarArgs.gB(6, this.srh);
      paramVarArgs.gB(7, this.sri);
      paramVarArgs.gB(8, this.type);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sqt) + 0 + d.a.a.a.gy(2, this.srd) + d.a.a.a.gy(3, this.sre) + d.a.a.a.gy(4, this.srf) + d.a.a.a.gy(5, this.srg) + d.a.a.a.gy(6, this.srh) + d.a.a.a.gy(7, this.sri) + d.a.a.a.gy(8, this.type);
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
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localn.sqt = locala.xpH.oD();
        return 0;
      case 2: 
        localn.srd = locala.xpH.oD();
        return 0;
      case 3: 
        localn.sre = locala.xpH.oD();
        return 0;
      case 4: 
        localn.srf = locala.xpH.oD();
        return 0;
      case 5: 
        localn.srg = locala.xpH.oD();
        return 0;
      case 6: 
        localn.srh = locala.xpH.oD();
        return 0;
      case 7: 
        localn.sri = locala.xpH.oD();
        return 0;
      }
      localn.type = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */