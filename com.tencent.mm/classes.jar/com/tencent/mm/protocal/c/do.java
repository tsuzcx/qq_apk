package com.tencent.mm.protocal.c;

public final class do
  extends com.tencent.mm.bv.a
{
  public String kSC;
  public String kVs;
  public int swX = 600;
  public String swY;
  public int swZ;
  public boolean sxa;
  public int sxb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSC != null) {
        paramVarArgs.d(1, this.kSC);
      }
      if (this.kVs != null) {
        paramVarArgs.d(2, this.kVs);
      }
      paramVarArgs.gB(3, this.swX);
      if (this.swY != null) {
        paramVarArgs.d(4, this.swY);
      }
      paramVarArgs.gB(5, this.swZ);
      paramVarArgs.aA(6, this.sxa);
      paramVarArgs.gB(7, this.sxb);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSC == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = d.a.a.b.b.a.e(1, this.kSC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kVs != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kVs);
      }
      i += d.a.a.a.gy(3, this.swX);
      paramInt = i;
      if (this.swY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.swY);
      }
      return paramInt + d.a.a.a.gy(5, this.swZ) + (d.a.a.b.b.a.dQ(6) + 1) + d.a.a.a.gy(7, this.sxb);
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
        do localdo = (do)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdo.kSC = locala.xpH.readString();
          return 0;
        case 2: 
          localdo.kVs = locala.xpH.readString();
          return 0;
        case 3: 
          localdo.swX = locala.xpH.oD();
          return 0;
        case 4: 
          localdo.swY = locala.xpH.readString();
          return 0;
        case 5: 
          localdo.swZ = locala.xpH.oD();
          return 0;
        case 6: 
          localdo.sxa = locala.cUr();
          return 0;
        }
        localdo.sxb = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.do
 * JD-Core Version:    0.7.0.1
 */