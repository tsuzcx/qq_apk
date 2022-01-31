package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class cml
  extends com.tencent.mm.bv.a
{
  public b sCF;
  public String tMY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tMY != null) {
        paramVarArgs.d(1, this.tMY);
      }
      if (this.sCF != null) {
        paramVarArgs.b(2, this.sCF);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tMY == null) {
        break label231;
      }
    }
    label231:
    for (paramInt = d.a.a.b.b.a.e(1, this.tMY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sCF != null) {
        i = paramInt + d.a.a.a.a(2, this.sCF);
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
        cml localcml = (cml)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcml.tMY = locala.xpH.readString();
          return 0;
        }
        localcml.sCF = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cml
 * JD-Core Version:    0.7.0.1
 */