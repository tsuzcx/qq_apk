package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ws
  extends com.tencent.mm.bv.a
{
  public boolean sTA;
  public String sTn;
  public String sTy;
  public LinkedList<String> sTz = new LinkedList();
  
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
      if (this.sTy != null) {
        paramVarArgs.d(2, this.sTy);
      }
      paramVarArgs.d(3, 1, this.sTz);
      paramVarArgs.aA(4, this.sTA);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sTn == null) {
        break label349;
      }
    }
    label349:
    for (paramInt = d.a.a.b.b.a.e(1, this.sTn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sTy != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sTy);
      }
      return i + d.a.a.a.c(3, 1, this.sTz) + (d.a.a.b.b.a.dQ(4) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sTz.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        ws localws = (ws)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localws.sTn = locala.xpH.readString();
          return 0;
        case 2: 
          localws.sTy = locala.xpH.readString();
          return 0;
        case 3: 
          localws.sTz.add(locala.xpH.readString());
          return 0;
        }
        localws.sTA = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ws
 * JD-Core Version:    0.7.0.1
 */