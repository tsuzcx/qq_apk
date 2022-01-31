package com.tencent.mm.protocal.c;

public final class vb
  extends com.tencent.mm.bv.a
{
  public String kRZ;
  public String kSy;
  public String sRO;
  public int sRP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRZ != null) {
        paramVarArgs.d(1, this.kRZ);
      }
      if (this.kSy != null) {
        paramVarArgs.d(2, this.kSy);
      }
      if (this.sRO != null) {
        paramVarArgs.d(3, this.sRO);
      }
      paramVarArgs.gB(4, this.sRP);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRZ == null) {
        break label324;
      }
    }
    label324:
    for (int i = d.a.a.b.b.a.e(1, this.kRZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSy);
      }
      i = paramInt;
      if (this.sRO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sRO);
      }
      return i + d.a.a.a.gy(4, this.sRP);
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
        vb localvb = (vb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localvb.kRZ = locala.xpH.readString();
          return 0;
        case 2: 
          localvb.kSy = locala.xpH.readString();
          return 0;
        case 3: 
          localvb.sRO = locala.xpH.readString();
          return 0;
        }
        localvb.sRP = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vb
 * JD-Core Version:    0.7.0.1
 */