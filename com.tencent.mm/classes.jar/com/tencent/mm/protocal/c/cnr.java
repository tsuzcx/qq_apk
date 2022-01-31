package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cnr
  extends com.tencent.mm.bv.a
{
  public int score;
  public int uao;
  public int uap;
  public int uaq;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username == null) {
        throw new b("Not all required fields were included: username");
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.gB(2, this.score);
      paramVarArgs.gB(3, this.uao);
      paramVarArgs.gB(4, this.uap);
      paramVarArgs.gB(5, this.uaq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.score) + d.a.a.a.gy(3, this.uao) + d.a.a.a.gy(4, this.uap) + d.a.a.a.gy(5, this.uaq);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.username != null) {
          break;
        }
        throw new b("Not all required fields were included: username");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cnr localcnr = (cnr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcnr.username = locala.xpH.readString();
          return 0;
        case 2: 
          localcnr.score = locala.xpH.oD();
          return 0;
        case 3: 
          localcnr.uao = locala.xpH.oD();
          return 0;
        case 4: 
          localcnr.uap = locala.xpH.oD();
          return 0;
        }
        localcnr.uaq = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnr
 * JD-Core Version:    0.7.0.1
 */