package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bvl
  extends com.tencent.mm.bv.a
{
  public int eAJ;
  public int eAK;
  public int eAL;
  public int eAM;
  public int opType;
  public String tMh;
  public String tMi;
  public String tMj;
  public String tMk;
  public long timeStamp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tMh == null) {
        throw new b("Not all required fields were included: StatusDesc1");
      }
      if (this.tMi == null) {
        throw new b("Not all required fields were included: StatusDesc2");
      }
      if (this.tMj == null) {
        throw new b("Not all required fields were included: DataFlowSourceInfo");
      }
      if (this.tMk == null) {
        throw new b("Not all required fields were included: DataFlowResultInfo");
      }
      paramVarArgs.gB(1, this.opType);
      paramVarArgs.gB(2, this.eAM);
      paramVarArgs.gB(3, this.eAJ);
      paramVarArgs.Y(4, this.timeStamp);
      paramVarArgs.gB(5, this.eAK);
      paramVarArgs.gB(6, this.eAL);
      if (this.tMh != null) {
        paramVarArgs.d(7, this.tMh);
      }
      if (this.tMi != null) {
        paramVarArgs.d(8, this.tMi);
      }
      if (this.tMj != null) {
        paramVarArgs.d(9, this.tMj);
      }
      if (this.tMk != null) {
        paramVarArgs.d(10, this.tMk);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.opType) + 0 + d.a.a.a.gy(2, this.eAM) + d.a.a.a.gy(3, this.eAJ) + d.a.a.a.X(4, this.timeStamp) + d.a.a.a.gy(5, this.eAK) + d.a.a.a.gy(6, this.eAL);
      paramInt = i;
      if (this.tMh != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tMh);
      }
      i = paramInt;
      if (this.tMi != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tMi);
      }
      paramInt = i;
      if (this.tMj != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tMj);
      }
      i = paramInt;
    } while (this.tMk == null);
    return paramInt + d.a.a.b.b.a.e(10, this.tMk);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tMh == null) {
        throw new b("Not all required fields were included: StatusDesc1");
      }
      if (this.tMi == null) {
        throw new b("Not all required fields were included: StatusDesc2");
      }
      if (this.tMj == null) {
        throw new b("Not all required fields were included: DataFlowSourceInfo");
      }
      if (this.tMk == null) {
        throw new b("Not all required fields were included: DataFlowResultInfo");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      bvl localbvl = (bvl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbvl.opType = locala.xpH.oD();
        return 0;
      case 2: 
        localbvl.eAM = locala.xpH.oD();
        return 0;
      case 3: 
        localbvl.eAJ = locala.xpH.oD();
        return 0;
      case 4: 
        localbvl.timeStamp = locala.xpH.oE();
        return 0;
      case 5: 
        localbvl.eAK = locala.xpH.oD();
        return 0;
      case 6: 
        localbvl.eAL = locala.xpH.oD();
        return 0;
      case 7: 
        localbvl.tMh = locala.xpH.readString();
        return 0;
      case 8: 
        localbvl.tMi = locala.xpH.readString();
        return 0;
      case 9: 
        localbvl.tMj = locala.xpH.readString();
        return 0;
      }
      localbvl.tMk = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvl
 * JD-Core Version:    0.7.0.1
 */