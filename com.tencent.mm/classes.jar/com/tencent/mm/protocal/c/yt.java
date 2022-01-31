package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class yt
  extends com.tencent.mm.bv.a
{
  public int aZs;
  public String rtH;
  public String sXl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.rtH == null) {
        throw new b("Not all required fields were included: tagName");
      }
      if (this.sXl == null) {
        throw new b("Not all required fields were included: tagPinYin");
      }
      if (this.rtH != null) {
        paramVarArgs.d(1, this.rtH);
      }
      if (this.sXl != null) {
        paramVarArgs.d(2, this.sXl);
      }
      paramVarArgs.gB(3, this.aZs);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rtH == null) {
        break label337;
      }
    }
    label337:
    for (paramInt = d.a.a.b.b.a.e(1, this.rtH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sXl != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sXl);
      }
      return i + d.a.a.a.gy(3, this.aZs);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.rtH == null) {
          throw new b("Not all required fields were included: tagName");
        }
        if (this.sXl != null) {
          break;
        }
        throw new b("Not all required fields were included: tagPinYin");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        yt localyt = (yt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localyt.rtH = locala.xpH.readString();
          return 0;
        case 2: 
          localyt.sXl = locala.xpH.readString();
          return 0;
        }
        localyt.aZs = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yt
 * JD-Core Version:    0.7.0.1
 */