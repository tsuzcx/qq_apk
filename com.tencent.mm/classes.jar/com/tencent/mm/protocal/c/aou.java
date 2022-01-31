package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class aou
  extends com.tencent.mm.bv.a
{
  public b sAk;
  public b sAm;
  public b tkK;
  
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
      if (this.tkK != null) {
        paramVarArgs.b(3, this.tkK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sAm == null) {
        break label280;
      }
    }
    label280:
    for (int i = d.a.a.a.a(1, this.sAm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sAk != null) {
        paramInt = i + d.a.a.a.a(2, this.sAk);
      }
      i = paramInt;
      if (this.tkK != null) {
        i = paramInt + d.a.a.a.a(3, this.tkK);
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
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        aou localaou = (aou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaou.sAm = locala.cUs();
          return 0;
        case 2: 
          localaou.sAk = locala.cUs();
          return 0;
        }
        localaou.tkK = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aou
 * JD-Core Version:    0.7.0.1
 */