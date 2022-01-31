package com.tencent.mm.protocal.c;

public final class bsf
  extends com.tencent.mm.bv.a
{
  public String tIQ;
  public String tIR;
  public String tIS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tIQ != null) {
        paramVarArgs.d(1, this.tIQ);
      }
      if (this.tIR != null) {
        paramVarArgs.d(2, this.tIR);
      }
      if (this.tIS != null) {
        paramVarArgs.d(3, this.tIS);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tIQ == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.tIQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tIR != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tIR);
      }
      i = paramInt;
      if (this.tIS != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tIS);
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
        bsf localbsf = (bsf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbsf.tIQ = locala.xpH.readString();
          return 0;
        case 2: 
          localbsf.tIR = locala.xpH.readString();
          return 0;
        }
        localbsf.tIS = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsf
 * JD-Core Version:    0.7.0.1
 */