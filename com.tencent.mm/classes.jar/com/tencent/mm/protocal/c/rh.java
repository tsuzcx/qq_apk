package com.tencent.mm.protocal.c;

public final class rh
  extends com.tencent.mm.bv.a
{
  public String bHG;
  public String bHH;
  public int sPj;
  public int sPk;
  public String sPl;
  public int version;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.version);
      paramVarArgs.gB(2, this.sPj);
      paramVarArgs.gB(3, this.sPk);
      if (this.bHH != null) {
        paramVarArgs.d(4, this.bHH);
      }
      if (this.sPl != null) {
        paramVarArgs.d(5, this.sPl);
      }
      if (this.bHG != null) {
        paramVarArgs.d(6, this.bHG);
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
      i = d.a.a.a.gy(1, this.version) + 0 + d.a.a.a.gy(2, this.sPj) + d.a.a.a.gy(3, this.sPk);
      paramInt = i;
      if (this.bHH != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bHH);
      }
      i = paramInt;
      if (this.sPl != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sPl);
      }
      paramInt = i;
    } while (this.bHG == null);
    return i + d.a.a.b.b.a.e(6, this.bHG);
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
      rh localrh = (rh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localrh.version = locala.xpH.oD();
        return 0;
      case 2: 
        localrh.sPj = locala.xpH.oD();
        return 0;
      case 3: 
        localrh.sPk = locala.xpH.oD();
        return 0;
      case 4: 
        localrh.bHH = locala.xpH.readString();
        return 0;
      case 5: 
        localrh.sPl = locala.xpH.readString();
        return 0;
      }
      localrh.bHG = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rh
 * JD-Core Version:    0.7.0.1
 */