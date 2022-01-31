package com.tencent.mm.protocal.c;

public final class aaf
  extends com.tencent.mm.bv.a
{
  public String dlQ;
  public int iQK;
  public String iQL;
  public String iQM;
  public String iQN;
  public String iQO;
  public int iQP;
  public String iQQ;
  public String iQR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.iQK);
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.iQL != null) {
        paramVarArgs.d(3, this.iQL);
      }
      if (this.iQM != null) {
        paramVarArgs.d(4, this.iQM);
      }
      if (this.iQN != null) {
        paramVarArgs.d(5, this.iQN);
      }
      if (this.iQO != null) {
        paramVarArgs.d(6, this.iQO);
      }
      paramVarArgs.gB(7, this.iQP);
      if (this.iQQ != null) {
        paramVarArgs.d(8, this.iQQ);
      }
      if (this.iQR != null) {
        paramVarArgs.d(9, this.iQR);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.iQK) + 0;
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.iQL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iQL);
      }
      paramInt = i;
      if (this.iQM != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iQM);
      }
      i = paramInt;
      if (this.iQN != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.iQN);
      }
      paramInt = i;
      if (this.iQO != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.iQO);
      }
      i = paramInt + d.a.a.a.gy(7, this.iQP);
      paramInt = i;
      if (this.iQQ != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.iQQ);
      }
      i = paramInt;
    } while (this.iQR == null);
    return paramInt + d.a.a.b.b.a.e(9, this.iQR);
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
      aaf localaaf = (aaf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaaf.iQK = locala.xpH.oD();
        return 0;
      case 2: 
        localaaf.dlQ = locala.xpH.readString();
        return 0;
      case 3: 
        localaaf.iQL = locala.xpH.readString();
        return 0;
      case 4: 
        localaaf.iQM = locala.xpH.readString();
        return 0;
      case 5: 
        localaaf.iQN = locala.xpH.readString();
        return 0;
      case 6: 
        localaaf.iQO = locala.xpH.readString();
        return 0;
      case 7: 
        localaaf.iQP = locala.xpH.oD();
        return 0;
      case 8: 
        localaaf.iQQ = locala.xpH.readString();
        return 0;
      }
      localaaf.iQR = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aaf
 * JD-Core Version:    0.7.0.1
 */