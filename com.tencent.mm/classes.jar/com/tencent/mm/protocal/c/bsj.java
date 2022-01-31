package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bsj
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public String tIU;
  public String tIV;
  public String tIW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tIU == null) {
        throw new b("Not all required fields were included: PickedWord");
      }
      if (this.tIU != null) {
        paramVarArgs.d(1, this.tIU);
      }
      if (this.tIV != null) {
        paramVarArgs.d(2, this.tIV);
      }
      if (this.tIW != null) {
        paramVarArgs.d(3, this.tIW);
      }
      paramVarArgs.gB(4, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tIU == null) {
        break label360;
      }
    }
    label360:
    for (int i = d.a.a.b.b.a.e(1, this.tIU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tIV != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tIV);
      }
      i = paramInt;
      if (this.tIW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tIW);
      }
      return i + d.a.a.a.gy(4, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tIU != null) {
          break;
        }
        throw new b("Not all required fields were included: PickedWord");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bsj localbsj = (bsj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbsj.tIU = locala.xpH.readString();
          return 0;
        case 2: 
          localbsj.tIV = locala.xpH.readString();
          return 0;
        case 3: 
          localbsj.tIW = locala.xpH.readString();
          return 0;
        }
        localbsj.pyo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsj
 * JD-Core Version:    0.7.0.1
 */