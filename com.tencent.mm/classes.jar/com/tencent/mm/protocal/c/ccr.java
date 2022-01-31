package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ccr
  extends com.tencent.mm.bv.a
{
  public String ePQ;
  public String ePZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePQ == null) {
        throw new b("Not all required fields were included: tp_username");
      }
      if (this.ePZ == null) {
        throw new b("Not all required fields were included: verify_ticket");
      }
      if (this.ePQ != null) {
        paramVarArgs.d(1, this.ePQ);
      }
      if (this.ePZ != null) {
        paramVarArgs.d(2, this.ePZ);
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
      if (this.ePZ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ePZ);
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
        if (this.ePZ != null) {
          break;
        }
        throw new b("Not all required fields were included: verify_ticket");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ccr localccr = (ccr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localccr.ePQ = locala.xpH.readString();
          return 0;
        }
        localccr.ePZ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccr
 * JD-Core Version:    0.7.0.1
 */