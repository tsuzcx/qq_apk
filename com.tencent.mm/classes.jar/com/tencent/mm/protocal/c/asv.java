package com.tencent.mm.protocal.c;

public final class asv
  extends com.tencent.mm.bv.a
{
  public String sEc;
  public String sEd;
  public String sEe;
  public String sEf;
  public String sEg;
  public int toB;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sEc != null) {
        paramVarArgs.d(1, this.sEc);
      }
      if (this.sEd != null) {
        paramVarArgs.d(2, this.sEd);
      }
      if (this.sEe != null) {
        paramVarArgs.d(3, this.sEe);
      }
      if (this.sEf != null) {
        paramVarArgs.d(4, this.sEf);
      }
      if (this.sEg != null) {
        paramVarArgs.d(5, this.sEg);
      }
      paramVarArgs.gB(6, this.toB);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sEc == null) {
        break label438;
      }
    }
    label438:
    for (int i = d.a.a.b.b.a.e(1, this.sEc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sEd != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sEd);
      }
      i = paramInt;
      if (this.sEe != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sEe);
      }
      paramInt = i;
      if (this.sEf != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sEf);
      }
      i = paramInt;
      if (this.sEg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sEg);
      }
      return i + d.a.a.a.gy(6, this.toB);
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
        asv localasv = (asv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localasv.sEc = locala.xpH.readString();
          return 0;
        case 2: 
          localasv.sEd = locala.xpH.readString();
          return 0;
        case 3: 
          localasv.sEe = locala.xpH.readString();
          return 0;
        case 4: 
          localasv.sEf = locala.xpH.readString();
          return 0;
        case 5: 
          localasv.sEg = locala.xpH.readString();
          return 0;
        }
        localasv.toB = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.asv
 * JD-Core Version:    0.7.0.1
 */