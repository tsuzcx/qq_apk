package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class aia
  extends com.tencent.mm.bv.a
{
  public String bJY;
  public String ePP;
  public String ePQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePQ == null) {
        throw new b("Not all required fields were included: tp_username");
      }
      if (this.ePQ != null) {
        paramVarArgs.d(1, this.ePQ);
      }
      if (this.ePP != null) {
        paramVarArgs.d(2, this.ePP);
      }
      if (this.bJY != null) {
        paramVarArgs.d(3, this.bJY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePQ == null) {
        break label321;
      }
    }
    label321:
    for (int i = d.a.a.b.b.a.e(1, this.ePQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ePP != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ePP);
      }
      i = paramInt;
      if (this.bJY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bJY);
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
        if (this.ePQ != null) {
          break;
        }
        throw new b("Not all required fields were included: tp_username");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        aia localaia = (aia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaia.ePQ = locala.xpH.readString();
          return 0;
        case 2: 
          localaia.ePP = locala.xpH.readString();
          return 0;
        }
        localaia.bJY = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aia
 * JD-Core Version:    0.7.0.1
 */