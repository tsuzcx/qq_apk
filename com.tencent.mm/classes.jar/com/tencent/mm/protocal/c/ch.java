package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ch
  extends com.tencent.mm.bv.a
{
  public String ePQ;
  public String svT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePQ == null) {
        throw new b("Not all required fields were included: tp_username");
      }
      if (this.svT == null) {
        throw new b("Not all required fields were included: antispam_ticket");
      }
      if (this.ePQ != null) {
        paramVarArgs.d(1, this.ePQ);
      }
      if (this.svT != null) {
        paramVarArgs.d(2, this.svT);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePQ == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = d.a.a.b.b.a.e(1, this.ePQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.svT != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.svT);
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
        if (this.ePQ == null) {
          throw new b("Not all required fields were included: tp_username");
        }
        if (this.svT != null) {
          break;
        }
        throw new b("Not all required fields were included: antispam_ticket");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ch localch = (ch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localch.ePQ = locala.xpH.readString();
          return 0;
        }
        localch.svT = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ch
 * JD-Core Version:    0.7.0.1
 */