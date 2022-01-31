package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class vm
  extends com.tencent.mm.bv.a
{
  public String sSC;
  public String sSD;
  public String sSE;
  public String sSF;
  public String sSG;
  public int sSH;
  public int sSI;
  public String sSJ;
  public int svx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sSC == null) {
        throw new b("Not all required fields were included: BegWord");
      }
      if (this.sSD == null) {
        throw new b("Not all required fields were included: BegPicUrl");
      }
      if (this.sSE == null) {
        throw new b("Not all required fields were included: ThanksPicUrl");
      }
      if (this.sSC != null) {
        paramVarArgs.d(1, this.sSC);
      }
      if (this.sSD != null) {
        paramVarArgs.d(2, this.sSD);
      }
      if (this.sSE != null) {
        paramVarArgs.d(3, this.sSE);
      }
      if (this.sSF != null) {
        paramVarArgs.d(4, this.sSF);
      }
      if (this.sSG != null) {
        paramVarArgs.d(5, this.sSG);
      }
      paramVarArgs.gB(6, this.sSH);
      paramVarArgs.gB(7, this.sSI);
      if (this.sSJ != null) {
        paramVarArgs.d(8, this.sSJ);
      }
      paramVarArgs.gB(9, this.svx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sSC == null) {
        break label675;
      }
    }
    label675:
    for (int i = d.a.a.b.b.a.e(1, this.sSC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sSD != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sSD);
      }
      i = paramInt;
      if (this.sSE != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sSE);
      }
      paramInt = i;
      if (this.sSF != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sSF);
      }
      i = paramInt;
      if (this.sSG != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sSG);
      }
      i = i + d.a.a.a.gy(6, this.sSH) + d.a.a.a.gy(7, this.sSI);
      paramInt = i;
      if (this.sSJ != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sSJ);
      }
      return paramInt + d.a.a.a.gy(9, this.svx);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sSC == null) {
          throw new b("Not all required fields were included: BegWord");
        }
        if (this.sSD == null) {
          throw new b("Not all required fields were included: BegPicUrl");
        }
        if (this.sSE != null) {
          break;
        }
        throw new b("Not all required fields were included: ThanksPicUrl");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        vm localvm = (vm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localvm.sSC = locala.xpH.readString();
          return 0;
        case 2: 
          localvm.sSD = locala.xpH.readString();
          return 0;
        case 3: 
          localvm.sSE = locala.xpH.readString();
          return 0;
        case 4: 
          localvm.sSF = locala.xpH.readString();
          return 0;
        case 5: 
          localvm.sSG = locala.xpH.readString();
          return 0;
        case 6: 
          localvm.sSH = locala.xpH.oD();
          return 0;
        case 7: 
          localvm.sSI = locala.xpH.oD();
          return 0;
        case 8: 
          localvm.sSJ = locala.xpH.readString();
          return 0;
        }
        localvm.svx = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vm
 * JD-Core Version:    0.7.0.1
 */