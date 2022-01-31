package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class aow
  extends com.tencent.mm.bv.a
{
  public int kTS;
  public b sAk;
  public b sAm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sAm != null) {
        paramVarArgs.b(1, this.sAm);
      }
      if (this.sAk != null) {
        paramVarArgs.b(2, this.sAk);
      }
      paramVarArgs.gB(3, this.kTS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sAm == null) {
        break label263;
      }
    }
    label263:
    for (paramInt = d.a.a.a.a(1, this.sAm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sAk != null) {
        i = paramInt + d.a.a.a.a(2, this.sAk);
      }
      return i + d.a.a.a.gy(3, this.kTS);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        aow localaow = (aow)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaow.sAm = locala.cUs();
          return 0;
        case 2: 
          localaow.sAk = locala.cUs();
          return 0;
        }
        localaow.kTS = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aow
 * JD-Core Version:    0.7.0.1
 */