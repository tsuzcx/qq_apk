package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cnv
  extends com.tencent.mm.bv.a
{
  public String dRj;
  public String title;
  public int uao;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.dRj == null) {
        throw new b("Not all required fields were included: rankid");
      }
      if (this.title == null) {
        throw new b("Not all required fields were included: title");
      }
      if (this.dRj != null) {
        paramVarArgs.d(1, this.dRj);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.gB(3, this.uao);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dRj == null) {
        break label337;
      }
    }
    label337:
    for (paramInt = d.a.a.b.b.a.e(1, this.dRj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.title);
      }
      return i + d.a.a.a.gy(3, this.uao);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.dRj == null) {
          throw new b("Not all required fields were included: rankid");
        }
        if (this.title != null) {
          break;
        }
        throw new b("Not all required fields were included: title");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cnv localcnv = (cnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcnv.dRj = locala.xpH.readString();
          return 0;
        case 2: 
          localcnv.title = locala.xpH.readString();
          return 0;
        }
        localcnv.uao = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnv
 * JD-Core Version:    0.7.0.1
 */