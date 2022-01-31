package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class wm
  extends com.tencent.mm.bv.a
{
  public String sTn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sTn == null) {
        throw new b("Not all required fields were included: LoginUrl");
      }
      if (this.sTn != null) {
        paramVarArgs.d(1, this.sTn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sTn == null) {
        break label210;
      }
    }
    label210:
    for (paramInt = d.a.a.b.b.a.e(1, this.sTn) + 0;; paramInt = 0)
    {
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sTn != null) {
          break;
        }
        throw new b("Not all required fields were included: LoginUrl");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        wm localwm = (wm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        }
        localwm.sTn = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.wm
 * JD-Core Version:    0.7.0.1
 */