package com.tencent.mm.protocal.c;

public final class bsb
  extends com.tencent.mm.bv.a
{
  public String iHx;
  public String lRE;
  public String lRF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lRE != null) {
        paramVarArgs.d(1, this.lRE);
      }
      if (this.lRF != null) {
        paramVarArgs.d(2, this.lRF);
      }
      if (this.iHx != null) {
        paramVarArgs.d(3, this.iHx);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.lRE == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.lRE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lRF != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.lRF);
      }
      i = paramInt;
      if (this.iHx != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iHx);
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
        bsb localbsb = (bsb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbsb.lRE = locala.xpH.readString();
          return 0;
        case 2: 
          localbsb.lRF = locala.xpH.readString();
          return 0;
        }
        localbsb.iHx = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsb
 * JD-Core Version:    0.7.0.1
 */