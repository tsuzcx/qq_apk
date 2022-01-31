package com.tencent.mm.protocal.c;

public final class bvh
  extends com.tencent.mm.bv.a
{
  public String appName;
  public int bba;
  public String tLZ;
  public boolean tMa;
  public boolean tMb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tLZ != null) {
        paramVarArgs.d(1, this.tLZ);
      }
      if (this.appName != null) {
        paramVarArgs.d(2, this.appName);
      }
      paramVarArgs.gB(3, this.bba);
      paramVarArgs.aA(4, this.tMa);
      paramVarArgs.aA(5, this.tMb);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tLZ == null) {
        break label333;
      }
    }
    label333:
    for (paramInt = d.a.a.b.b.a.e(1, this.tLZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.appName);
      }
      return i + d.a.a.a.gy(3, this.bba) + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1);
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
        bvh localbvh = (bvh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbvh.tLZ = locala.xpH.readString();
          return 0;
        case 2: 
          localbvh.appName = locala.xpH.readString();
          return 0;
        case 3: 
          localbvh.bba = locala.xpH.oD();
          return 0;
        case 4: 
          localbvh.tMa = locala.cUr();
          return 0;
        }
        localbvh.tMb = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvh
 * JD-Core Version:    0.7.0.1
 */