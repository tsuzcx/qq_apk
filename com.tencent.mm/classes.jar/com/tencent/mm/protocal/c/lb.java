package com.tencent.mm.protocal.c;

public final class lb
  extends com.tencent.mm.bv.a
{
  public String bWt;
  public String qVr;
  public String sGi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sGi != null) {
        paramVarArgs.d(1, this.sGi);
      }
      if (this.qVr != null) {
        paramVarArgs.d(2, this.qVr);
      }
      if (this.bWt != null) {
        paramVarArgs.d(3, this.bWt);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGi == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.sGi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qVr != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.qVr);
      }
      i = paramInt;
      if (this.bWt != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bWt);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        lb locallb = (lb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locallb.sGi = locala.xpH.readString();
          return 0;
        case 2: 
          locallb.qVr = locala.xpH.readString();
          return 0;
        }
        locallb.bWt = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lb
 * JD-Core Version:    0.7.0.1
 */