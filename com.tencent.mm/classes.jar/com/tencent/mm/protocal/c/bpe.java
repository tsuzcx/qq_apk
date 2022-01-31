package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bpe
  extends com.tencent.mm.bv.a
{
  public String ePQ;
  public String svT;
  public String tHi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePQ == null) {
        throw new b("Not all required fields were included: tp_username");
      }
      if (this.tHi == null) {
        throw new b("Not all required fields were included: verify_content");
      }
      if (this.svT == null) {
        throw new b("Not all required fields were included: antispam_ticket");
      }
      if (this.ePQ != null) {
        paramVarArgs.d(1, this.ePQ);
      }
      if (this.tHi != null) {
        paramVarArgs.d(2, this.tHi);
      }
      if (this.svT != null) {
        paramVarArgs.d(3, this.svT);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePQ == null) {
        break label389;
      }
    }
    label389:
    for (int i = d.a.a.b.b.a.e(1, this.ePQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tHi != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tHi);
      }
      i = paramInt;
      if (this.svT != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.svT);
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
        if (this.tHi == null) {
          throw new b("Not all required fields were included: verify_content");
        }
        if (this.svT != null) {
          break;
        }
        throw new b("Not all required fields were included: antispam_ticket");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bpe localbpe = (bpe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbpe.ePQ = locala.xpH.readString();
          return 0;
        case 2: 
          localbpe.tHi = locala.xpH.readString();
          return 0;
        }
        localbpe.svT = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bpe
 * JD-Core Version:    0.7.0.1
 */