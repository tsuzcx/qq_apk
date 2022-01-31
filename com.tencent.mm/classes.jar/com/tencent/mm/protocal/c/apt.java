package com.tencent.mm.protocal.c;

public final class apt
  extends com.tencent.mm.bv.a
{
  public int hQL;
  public String jnU;
  public String kRZ;
  public String kSC;
  public String sSA;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sSA != null) {
        paramVarArgs.d(1, this.sSA);
      }
      paramVarArgs.gB(2, this.hQL);
      if (this.jnU != null) {
        paramVarArgs.d(3, this.jnU);
      }
      if (this.kSC != null) {
        paramVarArgs.d(4, this.kSC);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(5, this.kRZ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sSA == null) {
        break label383;
      }
    }
    label383:
    for (paramInt = d.a.a.b.b.a.e(1, this.sSA) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQL);
      paramInt = i;
      if (this.jnU != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.jnU);
      }
      i = paramInt;
      if (this.kSC != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kSC);
      }
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kRZ);
      }
      return paramInt;
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
        apt localapt = (apt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localapt.sSA = locala.xpH.readString();
          return 0;
        case 2: 
          localapt.hQL = locala.xpH.oD();
          return 0;
        case 3: 
          localapt.jnU = locala.xpH.readString();
          return 0;
        case 4: 
          localapt.kSC = locala.xpH.readString();
          return 0;
        }
        localapt.kRZ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apt
 * JD-Core Version:    0.7.0.1
 */