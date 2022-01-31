package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class vl
  extends com.tencent.mm.bv.a
{
  public String kVZ;
  public String sSA;
  public String sSB;
  public String sSz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kVZ == null) {
        throw new b("Not all required fields were included: Label");
      }
      if (this.sSz == null) {
        throw new b("Not all required fields were included: Number");
      }
      if (this.sSA == null) {
        throw new b("Not all required fields were included: Type");
      }
      if (this.kVZ != null) {
        paramVarArgs.d(1, this.kVZ);
      }
      if (this.sSz != null) {
        paramVarArgs.d(2, this.sSz);
      }
      if (this.sSA != null) {
        paramVarArgs.d(3, this.sSA);
      }
      if (this.sSB != null) {
        paramVarArgs.d(4, this.sSB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVZ == null) {
        break label444;
      }
    }
    label444:
    for (int i = d.a.a.b.b.a.e(1, this.kVZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sSz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sSz);
      }
      i = paramInt;
      if (this.sSA != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sSA);
      }
      paramInt = i;
      if (this.sSB != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sSB);
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
        if (this.kVZ == null) {
          throw new b("Not all required fields were included: Label");
        }
        if (this.sSz == null) {
          throw new b("Not all required fields were included: Number");
        }
        if (this.sSA != null) {
          break;
        }
        throw new b("Not all required fields were included: Type");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        vl localvl = (vl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localvl.kVZ = locala.xpH.readString();
          return 0;
        case 2: 
          localvl.sSz = locala.xpH.readString();
          return 0;
        case 3: 
          localvl.sSA = locala.xpH.readString();
          return 0;
        }
        localvl.sSB = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vl
 * JD-Core Version:    0.7.0.1
 */