package com.tencent.mm.protocal.c;

public final class blf
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public long sFC;
  public int sOl;
  public long tAB;
  public String tEJ;
  public String tEK;
  public int tEL;
  public int tEM;
  public int tEN;
  public String tEO;
  public String tEP;
  public String tEQ;
  public int tmc;
  public String tqX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.pyo);
      if (this.tqX != null) {
        paramVarArgs.d(2, this.tqX);
      }
      if (this.tEJ != null) {
        paramVarArgs.d(3, this.tEJ);
      }
      paramVarArgs.Y(4, this.sFC);
      if (this.tEK != null) {
        paramVarArgs.d(5, this.tEK);
      }
      paramVarArgs.gB(6, this.tEL);
      paramVarArgs.gB(7, this.tEM);
      paramVarArgs.gB(8, this.tEN);
      paramVarArgs.Y(9, this.tAB);
      paramVarArgs.gB(10, this.tmc);
      if (this.tEO != null) {
        paramVarArgs.d(11, this.tEO);
      }
      paramVarArgs.gB(12, this.sOl);
      if (this.tEP != null) {
        paramVarArgs.d(13, this.tEP);
      }
      if (this.tEQ != null) {
        paramVarArgs.d(14, this.tEQ);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.pyo) + 0;
      paramInt = i;
      if (this.tqX != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tqX);
      }
      i = paramInt;
      if (this.tEJ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tEJ);
      }
      i += d.a.a.a.X(4, this.sFC);
      paramInt = i;
      if (this.tEK != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tEK);
      }
      i = paramInt + d.a.a.a.gy(6, this.tEL) + d.a.a.a.gy(7, this.tEM) + d.a.a.a.gy(8, this.tEN) + d.a.a.a.X(9, this.tAB) + d.a.a.a.gy(10, this.tmc);
      paramInt = i;
      if (this.tEO != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tEO);
      }
      i = paramInt + d.a.a.a.gy(12, this.sOl);
      paramInt = i;
      if (this.tEP != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.tEP);
      }
      i = paramInt;
    } while (this.tEQ == null);
    return paramInt + d.a.a.b.b.a.e(14, this.tEQ);
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
      blf localblf = (blf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localblf.pyo = locala.xpH.oD();
        return 0;
      case 2: 
        localblf.tqX = locala.xpH.readString();
        return 0;
      case 3: 
        localblf.tEJ = locala.xpH.readString();
        return 0;
      case 4: 
        localblf.sFC = locala.xpH.oE();
        return 0;
      case 5: 
        localblf.tEK = locala.xpH.readString();
        return 0;
      case 6: 
        localblf.tEL = locala.xpH.oD();
        return 0;
      case 7: 
        localblf.tEM = locala.xpH.oD();
        return 0;
      case 8: 
        localblf.tEN = locala.xpH.oD();
        return 0;
      case 9: 
        localblf.tAB = locala.xpH.oE();
        return 0;
      case 10: 
        localblf.tmc = locala.xpH.oD();
        return 0;
      case 11: 
        localblf.tEO = locala.xpH.readString();
        return 0;
      case 12: 
        localblf.sOl = locala.xpH.oD();
        return 0;
      case 13: 
        localblf.tEP = locala.xpH.readString();
        return 0;
      }
      localblf.tEQ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blf
 * JD-Core Version:    0.7.0.1
 */