package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class js
  extends com.tencent.mm.bv.a
{
  public String sCO;
  public LinkedList<String> sEz = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sCO == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.sCO != null) {
        paramVarArgs.d(2, this.sCO);
      }
      paramVarArgs.d(3, 1, this.sEz);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sCO == null) {
        break label260;
      }
    }
    label260:
    for (paramInt = d.a.a.b.b.a.e(2, this.sCO) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(3, 1, this.sEz);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sEz.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sCO != null) {
          break;
        }
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        js localjs = (js)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 2: 
          localjs.sCO = locala.xpH.readString();
          return 0;
        }
        localjs.sEz.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.js
 * JD-Core Version:    0.7.0.1
 */