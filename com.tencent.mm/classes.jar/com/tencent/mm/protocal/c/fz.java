package com.tencent.mm.protocal.c;

public final class fz
  extends com.tencent.mm.bv.a
{
  public String sAa;
  public String sAb;
  public String szZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szZ != null) {
        paramVarArgs.d(1, this.szZ);
      }
      if (this.sAa != null) {
        paramVarArgs.d(2, this.sAa);
      }
      if (this.sAb != null) {
        paramVarArgs.d(3, this.sAb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.szZ == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.szZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sAa != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sAa);
      }
      i = paramInt;
      if (this.sAb != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sAb);
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
        fz localfz = (fz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localfz.szZ = locala.xpH.readString();
          return 0;
        case 2: 
          localfz.sAa = locala.xpH.readString();
          return 0;
        }
        localfz.sAb = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fz
 * JD-Core Version:    0.7.0.1
 */