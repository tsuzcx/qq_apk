package com.tencent.mm.protocal.c;

public final class wu
  extends com.tencent.mm.bv.a
{
  public String sTC;
  public String sTD;
  public int sTE;
  public int sTF;
  public String sTG;
  public String sTH;
  public int sTo;
  public String sTp;
  public String sTq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sTo);
      if (this.sTp != null) {
        paramVarArgs.d(2, this.sTp);
      }
      if (this.sTC != null) {
        paramVarArgs.d(3, this.sTC);
      }
      if (this.sTD != null) {
        paramVarArgs.d(4, this.sTD);
      }
      paramVarArgs.gB(5, this.sTE);
      paramVarArgs.gB(6, this.sTF);
      if (this.sTG != null) {
        paramVarArgs.d(7, this.sTG);
      }
      if (this.sTq != null) {
        paramVarArgs.d(8, this.sTq);
      }
      if (this.sTH != null) {
        paramVarArgs.d(9, this.sTH);
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
      i = d.a.a.a.gy(1, this.sTo) + 0;
      paramInt = i;
      if (this.sTp != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sTp);
      }
      i = paramInt;
      if (this.sTC != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sTC);
      }
      paramInt = i;
      if (this.sTD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sTD);
      }
      i = paramInt + d.a.a.a.gy(5, this.sTE) + d.a.a.a.gy(6, this.sTF);
      paramInt = i;
      if (this.sTG != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sTG);
      }
      i = paramInt;
      if (this.sTq != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sTq);
      }
      paramInt = i;
    } while (this.sTH == null);
    return i + d.a.a.b.b.a.e(9, this.sTH);
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
      wu localwu = (wu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localwu.sTo = locala.xpH.oD();
        return 0;
      case 2: 
        localwu.sTp = locala.xpH.readString();
        return 0;
      case 3: 
        localwu.sTC = locala.xpH.readString();
        return 0;
      case 4: 
        localwu.sTD = locala.xpH.readString();
        return 0;
      case 5: 
        localwu.sTE = locala.xpH.oD();
        return 0;
      case 6: 
        localwu.sTF = locala.xpH.oD();
        return 0;
      case 7: 
        localwu.sTG = locala.xpH.readString();
        return 0;
      case 8: 
        localwu.sTq = locala.xpH.readString();
        return 0;
      }
      localwu.sTH = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.wu
 * JD-Core Version:    0.7.0.1
 */