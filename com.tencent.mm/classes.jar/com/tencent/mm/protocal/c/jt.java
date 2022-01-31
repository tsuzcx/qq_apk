package com.tencent.mm.protocal.c;

import com.tencent.mm.ai.d;
import com.tencent.mm.storage.ad;
import d.a.a.b;

public final class jt
  extends com.tencent.mm.bv.a
{
  public ad dnp;
  public d mVy;
  public String userName;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.userName == null) {
        throw new b("Not all required fields were included: userName");
      }
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label210;
      }
    }
    label210:
    for (paramInt = d.a.a.b.b.a.e(1, this.userName) + 0;; paramInt = 0)
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
        if (this.userName != null) {
          break;
        }
        throw new b("Not all required fields were included: userName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        jt localjt = (jt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        }
        localjt.userName = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jt
 * JD-Core Version:    0.7.0.1
 */