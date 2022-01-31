package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class bze
  extends com.tencent.mm.bv.a
{
  public b tPl;
  public String tPm;
  public b tPn;
  public int uin;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tPl != null) {
        paramVarArgs.b(1, this.tPl);
      }
      if (this.tPm != null) {
        paramVarArgs.d(2, this.tPm);
      }
      if (this.tPn != null) {
        paramVarArgs.b(3, this.tPn);
      }
      paramVarArgs.gB(4, this.uin);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tPl == null) {
        break label318;
      }
    }
    label318:
    for (int i = d.a.a.a.a(1, this.tPl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tPm != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tPm);
      }
      i = paramInt;
      if (this.tPn != null) {
        i = paramInt + d.a.a.a.a(3, this.tPn);
      }
      return i + d.a.a.a.gy(4, this.uin);
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
        bze localbze = (bze)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbze.tPl = locala.cUs();
          return 0;
        case 2: 
          localbze.tPm = locala.xpH.readString();
          return 0;
        case 3: 
          localbze.tPn = locala.cUs();
          return 0;
        }
        localbze.uin = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bze
 * JD-Core Version:    0.7.0.1
 */