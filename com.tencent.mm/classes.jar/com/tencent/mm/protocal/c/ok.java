package com.tencent.mm.protocal.c;

public final class ok
  extends com.tencent.mm.bv.a
{
  public String sLS;
  public String sLT;
  public String sLU;
  public int sLV;
  public int sLW;
  public String sLX;
  public int sLY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sLS != null) {
        paramVarArgs.d(1, this.sLS);
      }
      if (this.sLT != null) {
        paramVarArgs.d(2, this.sLT);
      }
      if (this.sLU != null) {
        paramVarArgs.d(3, this.sLU);
      }
      paramVarArgs.gB(4, this.sLV);
      paramVarArgs.gB(5, this.sLW);
      if (this.sLX != null) {
        paramVarArgs.d(6, this.sLX);
      }
      paramVarArgs.gB(7, this.sLY);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sLS == null) {
        break label461;
      }
    }
    label461:
    for (int i = d.a.a.b.b.a.e(1, this.sLS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sLT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sLT);
      }
      i = paramInt;
      if (this.sLU != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sLU);
      }
      i = i + d.a.a.a.gy(4, this.sLV) + d.a.a.a.gy(5, this.sLW);
      paramInt = i;
      if (this.sLX != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sLX);
      }
      return paramInt + d.a.a.a.gy(7, this.sLY);
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
        ok localok = (ok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localok.sLS = locala.xpH.readString();
          return 0;
        case 2: 
          localok.sLT = locala.xpH.readString();
          return 0;
        case 3: 
          localok.sLU = locala.xpH.readString();
          return 0;
        case 4: 
          localok.sLV = locala.xpH.oD();
          return 0;
        case 5: 
          localok.sLW = locala.xpH.oD();
          return 0;
        case 6: 
          localok.sLX = locala.xpH.readString();
          return 0;
        }
        localok.sLY = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ok
 * JD-Core Version:    0.7.0.1
 */