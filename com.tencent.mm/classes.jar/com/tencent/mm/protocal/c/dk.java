package com.tencent.mm.protocal.c;

public final class dk
  extends com.tencent.mm.bv.a
{
  public String hQE;
  public String kVn;
  public String lsK;
  public String swH;
  public String swI;
  public int swJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lsK != null) {
        paramVarArgs.d(1, this.lsK);
      }
      if (this.hQE != null) {
        paramVarArgs.d(2, this.hQE);
      }
      if (this.kVn != null) {
        paramVarArgs.d(3, this.kVn);
      }
      if (this.swH != null) {
        paramVarArgs.d(4, this.swH);
      }
      if (this.swI != null) {
        paramVarArgs.d(5, this.swI);
      }
      paramVarArgs.gB(6, this.swJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lsK == null) {
        break label438;
      }
    }
    label438:
    for (int i = d.a.a.b.b.a.e(1, this.lsK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hQE != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hQE);
      }
      i = paramInt;
      if (this.kVn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kVn);
      }
      paramInt = i;
      if (this.swH != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.swH);
      }
      i = paramInt;
      if (this.swI != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.swI);
      }
      return i + d.a.a.a.gy(6, this.swJ);
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
        dk localdk = (dk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdk.lsK = locala.xpH.readString();
          return 0;
        case 2: 
          localdk.hQE = locala.xpH.readString();
          return 0;
        case 3: 
          localdk.kVn = locala.xpH.readString();
          return 0;
        case 4: 
          localdk.swH = locala.xpH.readString();
          return 0;
        case 5: 
          localdk.swI = locala.xpH.readString();
          return 0;
        }
        localdk.swJ = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dk
 * JD-Core Version:    0.7.0.1
 */